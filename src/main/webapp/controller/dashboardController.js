app.controller('dashboardController', function($scope, $http, $rootScope,$timeout) {
	
	$scope.UserID = window.localStorage.getItem("loginDetails");
	$scope.role = window.localStorage.getItem("loginRole");
	$scope.userName = window.localStorage.getItem("userName");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "/visitor-Management-System/index.html";
	}
	
	window.localStorage.setItem("pagePosition", "FromDashboardPage");
	$( "#Loader" ).modal("show");
	
	$( "#datepicker" ).datepicker({
		format: 'YYYY/MM/DD'
	});
	$("#datepicker").on("change", function() {

		if($scope.visit == undefined){
			$scope.visit = {
					meetingBooked:{
							visitDate:$("#datepicker").val()
					}
			};
		}else{
			if($scope.visit.meetingBooked == undefined){
                $scope.visit.meetingBooked = {
                	visitDate:$("#datepicker").val()
                }
			}else{
				$scope.visit.meetingBooked.visitDate = $("#datepicker").val();
			}
		}
		
    });
	
	
	$('.clockpicker').clockpicker()
	.find('input').change(function(){
		console.log(this.value);
		if($scope.visit == undefined){
			$scope.visit = {
					meetingBooked:{
						visitTime:this.value + ":00"
					}
			};
		}else{
			if($scope.visit.meetingBooked == undefined){
                $scope.visit.meetingBooked = {
                		visitTime:this.value + ":00"
                }
			}else{
				$scope.visit.meetingBooked.visitTime = this.value + ":00";
			}
		}
	});
	var input = $('#single-input').clockpicker({
		placement: 'bottom',
		align: 'left',
		autoclose: true,
		'default': 'now'
	});

	$('.clockpicker-with-callbacks').clockpicker({
		donetext: 'Done',
		init: function() { 
			console.log("colorpicker initiated");
		},
		beforeShow: function() {
			console.log("before show");
		},
		afterShow: function() {
			console.log("after show");
		},
		beforeHide: function() {
			console.log("before hide");
		},
		afterHide: function() {
			console.log("after hide");
		},
		beforeHourSelect: function() {
			console.log("before hour selected");
		},
		afterHourSelect: function() {
			console.log("after hour selected");
		},
		beforeDone: function() {
			console.log("before done");
		},
		afterDone: function() {
			console.log("after done");
		}
	})
	.find('input').change(function(){
		console.log(this.value);
	});

	// Manually toggle to the minutes view
	$('#check-minutes').click(function(e){
		// Have to stop propagation here
		e.stopPropagation();
		input.clockpicker('show')
				.clockpicker('toggleView', 'minutes');
	});
	if (/mobile/i.test(navigator.userAgent)) {
		$('input').prop('readOnly', true);
	}
	
	$rootScope.visitSelected = {};
	$scope.allVisits = [];
	$scope.getCounts = function(){
		$http.post("/visitor-Management-System/Employee/CancelVisitCount",$scope.UserID).then(function mySuccess(response){
			$scope.cancelVisitCount = response.data;
			$http.post("/visitor-Management-System/Employee/TotalVisitCount",$scope.UserID).then(function mySuccess(response){
				$scope.totalVisitCount = response.data;
				$http.post("/visitor-Management-System/Employee/TodaysVisitCount",$scope.UserID).then(function mySuccess(response){
					$scope.todaysVisitCount = response.data;
					$http.post("/visitor-Management-System/Employee/AttendedVisitCount",$scope.UserID).then(function mySuccess(response){
						$scope.attendedVisitCount = response.data;
						$timeout(function() {
							$("#Loader").modal("hide");
						   }, 500);
					}, function myError(data){
						$timeout(function() {
							$("#Loader").modal("hide");
						   }, 500);
						console.log("some internal error");
						console.log(data);
					});
				}, function myError(data){
					$timeout(function() {
						$("#Loader").modal("hide");
					   }, 500);
					console.log("some internal error");
					console.log(data);
				});
			}, function myError(data){
				$timeout(function() {
					$("#Loader").modal("hide");
				   }, 500);
				console.log("some internal error");
				console.log(data);
			});
		}, function myError(data){
			$timeout(function() {
				$("#Loader").modal("hide");
			   }, 500);
			console.log("some internal error");
			console.log(data);
		});
		
	};
	
	$scope.getAllCounts = function(){
		$http.post("/visitor-Management-System/Employee/getAllVisitCount",$scope.UserID).then(function mySuccess(response){
			$scope.totalVisitCount = response.data;
			$http.post("/visitor-Management-System/Employee/getAllEmployeeCount",$scope.UserID).then(function mySuccess(response){
				$scope.totalEmployeeCount = response.data;
				$http.post("/visitor-Management-System/Plant/getAllPlantCount",$scope.UserID).then(function mySuccess(response){
					$scope.totalPlantCount = response.data;
					$timeout(function() {
						$("#Loader").modal("hide");
					   }, 500);
				}, function myError(data){
					$timeout(function() {
						$("#Loader").modal("hide");
					   }, 500);
					console.log("some internal error");
					console.log(data);
				});
			}, function myError(data){
				$timeout(function() {
					$("#Loader").modal("hide");
				   }, 500);
				console.log("some internal error");
				console.log(data);
			});
		}, function myError(data){
			$timeout(function() {
				$("#Loader").modal("hide");
			   }, 500);
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.viewAllCoVisitor = function(visitor){
		visitor.enableVisitorCheckOut = true;
		$http.post("/visitor-Management-System/Security/viewAllCoVisitor", visitor).then(function mySuccess(response){
			$scope.allCoVisitor = response.data;
			$http.post("/visitor-Management-System/Security/getVisitAllAsset", visitor.meetingBooked.visitor).then(function mySuccess(response){
				$scope.allVisitorAsset = response.data;
				if($scope.allVisitorAsset.length > 0){
					angular.forEach($scope.allVisitorAsset,function(asset){
						if(!asset.deliveredFlag){
							visitor.enableVisitorCheckOut = false;
						}
					});
				}
				if($scope.allCoVisitor.length > 0){
					angular.forEach($scope.allCoVisitor,function(coVisitor){
						if(!coVisitor.seccheckout){
							visitor.enableVisitorCheckOut = false;
						}
					});
				}else{
					if(!visitor.empCheckout){
						visitor.enableVisitorCheckOut = false;
					}
				}
			}, function myError(data){
				console.log("some internal error");
				console.log(data);
			});
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	
	};
	
	$scope.viewAllUpcomingVisits = function(){
		$scope.param = {
				empCode: $scope.UserID,
				empRole: $scope.role
		};
		$http.post("/visitor-Management-System/Employee/viewAllUpcomingVisit",$scope.param).then(function mySuccess(response){
			console.log(response.data);
			$scope.allVisits = response.data;
			$scope.allVisits.sort(function (a, b) {
				  return new Date('1970/01/01 ' + a.meetingBooked.visitTime) - new Date('1970/01/01 ' + b.meetingBooked.visitTime);
				});
			if($scope.role != "Security"){
				$scope.getCounts();
			}else{
				$timeout(function() {
					$("#Loader").modal("hide");
				   }, 3000);
				/*angular.forEach($scope.allVisits,function(visit){
					$scope.viewAllCoVisitor(visit);
				});*/
			}
		}, function myError(data){
			$timeout(function() {
				$("#Loader").modal("hide");
			   }, 3000);
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.viewAllVisits = function(){
		$scope.param = {
				empCode: $scope.UserID,
				empRole: $scope.role
		};
		$http.post("/visitor-Management-System/Employee/viewAllVisits",$scope.param).then(function mySuccess(response){
			console.log(response.data);
			$scope.allVisits = response.data;
			if($scope.role != "Security"){
				$scope.getCounts();
			}else{
				$timeout(function() {
					$('#dataTable').DataTable();
				   }, 200);
				$timeout(function() {
					$("#Loader").modal("hide");
				   }, 500);
				/*angular.forEach($scope.allVisits,function(visit){
					$scope.viewAllCoVisitor(visit);
				});*/
			}
		}, function myError(data){
			$timeout(function() {
				$("#Loader").modal("hide");
			   }, 3000);
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.viewAllContacts = function(){
		$http.post("/visitor-Management-System/Employee/viewAllContacts",$scope.UserID).then(function mySuccess(response){
			console.log(response.data);
			$scope.allContacts = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.getTasks = function(){
		$http.post("/visitor-Management-System/Employee/viewTask",$scope.UserID).then(function mySuccess(response){
			console.log(response.data);
			$scope.allTask = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	}
	
	$scope.getAllPlants = function(){
		$http.post("/visitor-Management-System/Plant/viewAllPlant").then(function mySuccess(response){
			console.log(response.data);
			$scope.allPlants = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.getAllDepartment = function(){
		$http.post("/visitor-Management-System/Department/viewAllDept").then(function mySuccess(response){
			console.log(response.data);
			$scope.allDept = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.viewEmpPlant = function(){
		$scope.param = {
				empCode: $scope.UserID,
				empRole: $scope.role
		};
		$http.post("/visitor-Management-System/Employee/getEmpPlant",$scope.param).then(function mySuccess(response){
			$scope.EmpPlants = response.data.empPlantCode;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.viewAllMeetingType = function(){
		$http.post("/visitor-Management-System/Admin/viewAllMeeting").then(function mySuccess(response){
			console.log(response.data);
			$scope.allMeetingType = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	if($scope.role == "Security"){
		$scope.viewAllVisits();
		$scope.invalidSecCode = false;
	}else if($scope.role == "Super Admin"){
		$scope.viewAllContacts();
		$scope.getTasks();
		$scope.getAllCounts();
	}else{
		$scope.viewAllMeetingType();
		$scope.viewAllContacts();
		$scope.getAllPlants();
		$scope.getTasks();
		$scope.viewAllUpcomingVisits();
	}
	
	$scope.securityCheckin = function(visit){
		
		//$( "#Loader" ).modal('show');
		$rootScope.visitCheckin = visit;
		if($rootScope.visitCheckin.secCheckin){
			window.location = "#!securityCheckIn";
		}else{
			/*$scope.securityCode = 0;
			$scope.securityCode = $("#securityCode").val();*/
			if(visit.securityCode1 == $rootScope.visitCheckin.securityCode){
				visit.invalidSecCode = false;
				window.location = "#!securityCheckIn";
				/*$rootScope.visitCheckin.secCheckinBy = $scope.userName;
				$http.post("/visitor-Management-System/Security/securityCheckin", $rootScope.visitCheckin).then(function mySuccess(response){
					if(response.data.msg == 'SUCCESS'){
						window.location = "#!securityCheckOut";
					}
				}, function myError(data){
					console.log("some internal error");
					console.log(data);
				});*/
			}else{
				visit.invalidSecCode = true;
				$timeout(function() {
					$("#Loader").modal("hide");
				   }, 3000);
			}
		}
	};
	
	$scope.securityCheckout = function(visit){
		$rootScope.visitCheckin = visit;
		window.location = "#!securityCheckOut";
	};
	
	$scope.addTask = function(){
		$scope.newTask.createdBy = $scope.UserID;
		$http.post("/visitor-Management-System/Employee/addTask",$scope.newTask).then(function mySuccess(response){
			if(response.data.msg == "SUCCESS"){
				$scope.getTasks();
				$('#addNewTask').modal('hide');
			}
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	}
	
	$scope.updateTask = function(task){
		$http.post("/visitor-Management-System/Employee/completeTask",task).then(function mySuccess(response){
			if(response.data.msg == "SUCCESS"){
				$scope.getTasks();
			}
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.setVisit = function(contact){
		$rootScope.visitFromContact = {};
		$rootScope.visitFromContact.meetingBooked = {};
		$rootScope.visitFromContact.meetingBooked.visitor = {};
		$rootScope.visitFromContact.meetingBooked.visitor.salutation = contact.salutation;
		$rootScope.visitFromContact.meetingBooked.visitor.firstName = contact.firstName;
		$rootScope.visitFromContact.meetingBooked.visitor.lastName = contact.lastName;
		$rootScope.visitFromContact.meetingBooked.visitor.middleName = contact.middleName;
		$rootScope.visitFromContact.meetingBooked.visitor.gender = contact.gender;
		$rootScope.visitFromContact.meetingBooked.visitor.designation = contact.designation;
		$rootScope.visitFromContact.meetingBooked.visitor.emailId = contact.emailId;
		$rootScope.visitFromContact.meetingBooked.visitor.contactNumber = contact.mobileNumb;
		$rootScope.visitFromContact.meetingBooked.visitor.organisation = contact.company;
		window.location.href  = "#!addVisit";
	};
	
	$scope.addNewVisit = function(){
		window.location.href  = "#!addVisit";
		/*$scope.invalidMobile = false;
		$scope.invalidDate = false;
		$scope.invalidTime = false;
		if($scope.addVisitForm.$valid){
			if(!isNaN($scope.visit.meetingBooked.visitor.contactNumber) && angular.isNumber(+$scope.visit.meetingBooked.visitor.contactNumber)){
				var todayDate = new Date();
				todayDate.setHours(0,0,0,0)
				$scope.visit.meetingBooked.visitDate = new Date($scope.visit.meetingBooked.visitDate);
				if($scope.visit.meetingBooked.visitDate < todayDate){
					$scope.invalidDate = true;
				}else if($scope.visit.meetingBooked.visitDate > todayDate){
					
					$scope.visit.createdBy = $scope.UserID;
					$scope.visit.lastUpdatedBy = $scope.UserID;
					$scope.visit.meetingBooked.empId = $scope.UserID;
					$scope.visit.meetingBooked.empName = $scope.userName;
					$('#VisitScheduleModal').modal('hide');
					$( "#Loader" ).modal('show');
					$http.post("/visitor-Management-System/Employee/addNewVisit", $scope.visit).then(function mySuccess(response){
						if(response.data.msg == "SUCCESS"){
							$("#Loader").modal("hide");
							window.location.href  = "#!employeeDashboard";
						}else{
							$("#Loader").modal("hide");
							window.location.href  = "#!employeeDashboard";
						}
					}, function myError(data){
						$timeout(function() {
							$("#Loader").modal("hide");
						   }, 3000);
						console.log("some internal error");
						console.log(data);
					});
				}else{
					var visTime = new Date();
					visTime.setHours($scope.visit.meetingBooked.visitTime.substring(0, 2), $scope.visit.meetingBooked.visitTime.substring(3, 5), 0, 0);
					var todayTime = new Date();
					if(visTime < todayTime){
						$scope.invalidTime = true;
					}else{
						$scope.visit.createdBy = $scope.UserID;
						$scope.visit.lastUpdatedBy = $scope.UserID;
						$scope.visit.meetingBooked.empId = $scope.UserID;
						$scope.visit.meetingBooked.empName = $scope.userName;
						$('#VisitScheduleModal').modal('hide');
						$( "#Loader" ).modal('show');
						$http.post("/visitor-Management-System/Employee/addNewVisit", $scope.visit).then(function mySuccess(response){
							if(response.data.msg == "SUCCESS"){
								$("#Loader").modal("hide");
								window.location.href  = "#!employeeDashboard";
							}else{
								$("#Loader").modal("hide");
								window.location.href  = "#!employeeDashboard";
							}
						}, function myError(data){
							$timeout(function() {
								$("#Loader").modal("hide");
							   }, 3000);
							console.log("some internal error");
							console.log(data);
						});
					}
				}
			}else{
				$scope.invalidMobile = true;
			}
		}*/
	};
	
	$scope.openAddModal = function(type){
		$scope.modalType = type;
		if(type == 'emp'){
			$scope.getAllDepartment();
			$scope.newEmp = {};
			$( "#addPopUpModal" ).modal('hide');
			$( "#addNewEmpModal" ).modal('show');
		}else if(type == 'plant'){
			$scope.newPlant = {};
			$scope.newPlant.plantState = 'Maharashtra';
			$scope.newPlant.plantCountry = 'India';
			$scope.newPlant.plantCity = 'Aurangabad';
			$( "#addPopUpModal" ).modal('hide');
			$( "#addNewPlantModal" ).modal('show');
		}else{
			$scope.getAllPlants();
			$scope.newDept = {};
			$( "#addPopUpModal" ).modal('hide');
			$( "#addNewDeptModal" ).modal('show');
		}
	};
	
	$scope.addNewDept = function(){
		$scope.deleteData = false;
		$scope.updateData = false;
		if($scope.addDeptForm.$valid){
			$scope.newDept.regBy = $scope.UserID;
			$http.post("/visitor-Management-System/Department/addNewDept", $scope.newDept).then(function mySuccess(response){
				if(response.data.data == "Exist"){
					$scope.dataExist = true;
				}else{
					$scope.dataExist = false;
				}
				$('#addNewDeptModal').modal('hide');
				$('#notificationModal').modal('show');
			}, function myError(data){
				console.log("some internal error");
				console.log(data);
			});
		}
	};
	
	$scope.addNewEmp = function(){
		$scope.deleteData = false;
		$scope.updateData = false;
		$scope.invalidMobile = false;
		if($scope.addEmpForm.$valid){
			if(!isNaN($scope.newEmp.empMobile) && angular.isNumber(+$scope.newEmp.empMobile)){
				$scope.newEmp.regBy = $scope.UserID;
				if($scope.myFile != null && $scope.myFile != undefined){
					var file = $scope.myFile;
					if(file.size <= 900484){
						var fd = new FormData();
						fd.append('file', file);
						fd.append('empDetails', JSON.stringify($scope.newEmp));
						
						$http.post("/visitor-Management-System/Employee/addNewOrEditEmp", fd, {
							transformRequest : angular.identity,
							headers : {'Content-Type' : undefined}
						}).then(function mySuccess(response){
							if(response.data.data == "Exist"){
								$scope.dataExist = true;
							}else{
								$scope.dataExist = false;
							}
							$('#addNewEmpModal').modal('hide');
							$('#notificationModal').modal('show');
						}, function myError(data){
							console.log("some internal error");
							console.log(data);
						});
					}
				}else{
					$http.post("/visitor-Management-System/Employee/addNewEmp", $scope.newEmp).then(function mySuccess(response){
						if(response.data.data == "Exist"){
							$scope.dataExist = true;
						}else{
							$scope.dataExist = false;
						}
						$('#addNewEmpModal').modal('hide');
						$('#notificationModal').modal('show');
					}, function myError(data){
						console.log("some internal error");
						console.log(data);
					});
				}
			}else{
				$scope.invalidMobile = true;
			}
			
		}else{
			if(!isNaN($scope.newEmp.empMobile) && !angular.isNumber(+$scope.newEmp.empMobile)){
				$scope.invalidMobile = true;
			}
		}
	};
	
	$scope.addNewPlant = function(){
		$scope.deleteData = false;
		$scope.updateData = false;
		if($scope.addPlantForm.$valid){
			$scope.newPlant.regBy = $scope.UserID;
			$http.post("/visitor-Management-System/Plant/addNewPlant", $scope.newPlant).then(function mySuccess(response){
				if(response.data.data == "Exist"){
					$scope.dataExist = true;
				}else{
					$scope.dataExist = false;
				}
				$('#addNewPlantModal').modal('hide');
				$('#notificationModal').modal('show');
			}, function myError(data){
				console.log("some internal error");
				console.log(data);
			});
		}
	};
	
	$scope.notiClose = function(){
		$( "#Loader" ).modal("show");
		$scope.getAllCounts();
	};
	
	$scope.towardMeeting = function(visit){
		$rootScope.visitSelected = visit;
		window.location = "#!viewAllVisit";
	};
	
	$scope.navToReport = function(){
		$rootScope.reportFromDash = "emp";
		window.location = "#!empReportVisitedReport";
	};
	
	$scope.navToEmployee = function(){
		window.location = "#!ViewAllEmployee";
	};
	
	$scope.navToPlant = function(){
		window.location = "#!ViewAllPlants";
	};
	
	$scope.navToCancelReport = function(){
		$rootScope.reportFromDash = "cancelEmp";
		window.location = "#!empReportCancelReport";
	}
	
});