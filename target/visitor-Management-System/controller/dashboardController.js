app.controller('dashboardController', function($scope, $http, $rootScope,$timeout) {
	
	$scope.UserID = window.localStorage.getItem("loginDetails");
	$scope.role = window.localStorage.getItem("loginRole");
	$scope.userName = window.localStorage.getItem("userName");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "/visitor-Management-System/index.html";
	}
	
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
	
	if($scope.role == "Security"){
		$scope.viewAllVisits();
		$scope.invalidSecCode = false;
	}else{
		$scope.viewAllContacts();
		$scope.viewEmpPlant();
		$scope.getTasks();
		$scope.viewAllVisits();
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
		$scope.visit = {};
		$scope.visit.meetingBooked = {};
		$scope.visit.meetingBooked.visitor = {};
		$scope.visit.meetingBooked.visitor.visitorName = contact.firstName +" "+ contact.lastName;
		$scope.visit.meetingBooked.visitor.emailId = contact.emailId;
		$scope.visit.meetingBooked.visitor.contactNumber = contact.mobileNumb;
		$scope.visit.meetingBooked.visitor.organisation = contact.company;
	};
	
	$scope.addNewVisit = function(){
		$scope.invalidMobile = false;
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
		}
	};
	
});