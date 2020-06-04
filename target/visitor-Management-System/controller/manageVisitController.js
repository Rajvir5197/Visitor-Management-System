app.controller('manageVisitController', function($scope, $rootScope, $http, $timeout) {
	
	$scope.UserID = window.localStorage.getItem("loginDetails");
	$scope.role = window.localStorage.getItem("loginRole");
	$scope.userName = window.localStorage.getItem("userName");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "/visitor-Management-System/index.html";
	}
	
	if($rootScope.visitFromContact != undefined){
		$scope.newVisit = $rootScope.visitFromContact;
	}
	
	$scope.enableAddVisitor = false;
	window.localStorage.setItem("pagePosition", "FromVisitPage");
	$( "#Loader" ).modal("show");
	
	$( "#datepicker" ).datepicker({
		format: 'YYYY/MM/DD'
	});
	$("#datepicker").on("change", function() {

		if($scope.newVisit == undefined){
			$scope.newVisit = {
					meetingBooked:{
							visitDate:$("#datepicker").val()
					}
			};
		}else{
			$scope.newVisit.meetingBooked.visitDate = $("#datepicker").val();
		}
		

    });
	
	
	$('.clockpicker').clockpicker()
	.find('input').change(function(){
		console.log(this.value);
		if($scope.newVisit == undefined){
			$scope.newVisit = {
					meetingBooked:{
						visitTime:this.value + ":00"
					}
			};
		}else{
			$scope.newVisit.meetingBooked.visitTime = this.value + ":00";
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
	$scope.invalidMobile = false;
	$scope.invalidDate = false;
	$scope.invalidTime = false;
	$scope.viewAllVisits = function(){
		$scope.param = {
				empCode: $scope.UserID,
				empRole: $scope.role
		};
		if($rootScope.visitSelected != undefined && ($rootScope.visitSelected.meetingId != undefined && $rootScope.visitSelected.meetingId != null)){
			$http.post("/visitor-Management-System/Employee/viewAllUpcomingVisit",$scope.param).then(function mySuccess(response){
				console.log(response.data);
				$scope.allVisits = response.data;
				if($rootScope.visitSelected != undefined && ($rootScope.visitSelected.meetingId != undefined && $rootScope.visitSelected.meetingId != null)){
					$scope.allVisits = $scope.allVisits.filter(function(value){
						return (value.meetingId == $rootScope.visitSelected.meetingId);
					});
				}
				$timeout(function() {
					$("#Loader").modal("hide");
				   }, 2000);
			}, function myError(data){
				console.log("some internal error");
				console.log(data);
			});
		}else{
			$http.post("/visitor-Management-System/Employee/viewAllVisits",$scope.param).then(function mySuccess(response){
				console.log(response.data);
				$scope.allVisits = response.data;
				/*if($rootScope.visitSelected != undefined && ($rootScope.visitSelected.meetingId != undefined && $rootScope.visitSelected.meetingId != null)){
					$scope.allVisits = $scope.allVisits.filter(function(value){
						return (value.meetingId == $rootScope.visitSelected.meetingId);
					});
				}*/
				$timeout(function() {
					$("#Loader").modal("hide");
				   }, 2000);
			}, function myError(data){
				console.log("some internal error");
				console.log(data);
			});
		}
	};
	
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
	
	$scope.viewAllMeetingType = function(){
		$http.post("/visitor-Management-System/Admin/viewAllMeeting").then(function mySuccess(response){
			console.log(response.data);
			$scope.allMeetingType = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.viewAllVisits();
	$scope.getAllPlants();
	$scope.viewAllMeetingType();
	
	$scope.addNewVisit = function(){
		$( "#Loader" ).modal("show");
		$scope.invalidMobile = false;
		$scope.invalidDate = false;
		$scope.invalidTime = false;
		if($scope.addForm.$valid){
			if(!isNaN($scope.newVisit.meetingBooked.visitor.contactNumber) && angular.isNumber(+$scope.newVisit.meetingBooked.visitor.contactNumber)){
				var todayDate = new Date();
				todayDate.setHours(0,0,0,0)
				$scope.newVisit.meetingBooked.visitDate = new Date($scope.newVisit.meetingBooked.visitDate);
				if($scope.newVisit.meetingBooked.visitDate < todayDate){
					$scope.invalidDate = true;
					$timeout(function() {
						$("#Loader").modal("hide");
					   }, 500);
				
				}else if($scope.newVisit.meetingBooked.visitDate > todayDate){
					$scope.newVisit.createdBy = $scope.UserID;
					$scope.newVisit.lastUpdatedBy = $scope.UserID;
					$scope.newVisit.meetingBooked.empId = $scope.UserID;
					$scope.newVisit.meetingBooked.empName = $scope.userName;
					$http.post("/visitor-Management-System/Employee/addNewVisit", $scope.newVisit).then(function mySuccess(response){
						if(response.data.msg == "SUCCESS"){
							$scope.addContactMsg = false;
							$scope.addedVisitor = response.data.meetingData;
							$("#Loader").modal("hide");
							$('#notificationModal').modal('show');
							//window.location.href  = "#!viewAllVisit";
						}else if(response.data.msg == "SUCCESSANDCONTACT"){
							$scope.addContactMsg = true;
							$scope.addedVisitor = response.data.meetingData;
							$("#Loader").modal("hide");
							$('#notificationModal').modal('show');
						}else{
							$timeout(function() {
								$("#Loader").modal("hide");
							   }, 500);
						}
					}, function myError(data){
						$timeout(function() {
							$("#Loader").modal("hide");
						   }, 500);
						console.log("some internal error");
						console.log(data);
					});
				}else{
					
					var visTime = new Date();
					visTime.setHours($scope.newVisit.meetingBooked.visitTime.substring(0, 2), $scope.newVisit.meetingBooked.visitTime.substring(3, 5), 0, 0);
					var todayTime = new Date();
					if(visTime < todayTime){
						$scope.invalidTime = true;
						$timeout(function() {
							$("#Loader").modal("hide");
						   }, 500);
					}else{
						$scope.newVisit.createdBy = $scope.UserID;
						$scope.newVisit.lastUpdatedBy = $scope.UserID;
						$scope.newVisit.meetingBooked.empId = $scope.UserID;
						$scope.newVisit.meetingBooked.empName = $scope.userName;
						$http.post("/visitor-Management-System/Employee/addNewVisit", $scope.newVisit).then(function mySuccess(response){
							if(response.data.msg == "SUCCESS"){
								$scope.addContactMsg = false;
								$scope.addedVisitor = response.data.meetingData;
								$("#Loader").modal("hide");
								$('#notificationModal').modal('show');
								//window.location.href  = "#!viewAllVisit";
							}else if(response.data.msg == "SUCCESSANDCONTACT"){
								$scope.addContactMsg = true;
								$scope.addedVisitor = response.data.meetingData;
								$("#Loader").modal("hide");
								$('#notificationModal').modal('show');
							}else{
								$timeout(function() {
									$("#Loader").modal("hide");
								   }, 500);
							}
						}, function myError(data){
							$timeout(function() {
								$("#Loader").modal("hide");
							   }, 500);
							console.log("some internal error");
							console.log(data);
						});
					}
				}
			}else{
				$scope.invalidMobile = true;
				$timeout(function() {
					$("#Loader").modal("hide");
				   }, 500);
			}
		}else{
			$timeout(function() {
				$("#Loader").modal("hide");
			   }, 500);
		}
	};
	
	$scope.notiClose = function(){
		//window.location.href  = "#!viewAllVisit";
		$scope.enableAddVisitor = true;
	};
	
	$scope.addNewContact = function(){
		$( "#notificationModal" ).modal("hide");
		$( "#Loader" ).modal("show");
		$scope.newContact = {};
		$scope.newContact.salutation = $scope.addedVisitor.meetingBooked.visitor.salutation;
		$scope.newContact.firstName = $scope.addedVisitor.meetingBooked.visitor.firstName;
		$scope.newContact.middleName = $scope.addedVisitor.meetingBooked.visitor.middleName;
		$scope.newContact.lastName = $scope.addedVisitor.meetingBooked.visitor.lastName;
		$scope.newContact.designation = $scope.addedVisitor.meetingBooked.visitor.designation;
		$scope.newContact.gender = $scope.addedVisitor.meetingBooked.visitor.gender;
		$scope.newContact.emailId = $scope.addedVisitor.meetingBooked.visitor.emailId;
		$scope.newContact.mobileNumb = $scope.addedVisitor.meetingBooked.visitor.contactNumber;
		$scope.newContact.company = $scope.addedVisitor.meetingBooked.visitor.organisation;
		$scope.newContact.regBy = $scope.UserID;
		$http.post("/visitor-Management-System/Employee/addNewOrEditContact", $scope.newContact).then(function mySuccess(response){
			if(response.data.msg == "SUCCESS"){
				$timeout(function() {
					$("#Loader").modal("hide");
					$( "#notificationModalForContact" ).modal("show");
				   }, 2000);
			}else{
				$timeout(function() {
					$("#Loader").modal("hide");
				   }, 2000);
			}
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
			
	};
	
	$scope.addCoVistor = function(){
		$scope.invalidMobile = false;
		if($scope.addCoVisitorForm.$valid){
			if(!isNaN($scope.newVisitor.coVisitorContact) && angular.isNumber(+$scope.newVisitor.coVisitorContact)){
				//$scope.newVisitor.secCheckin = true;
				$scope.newVisitor.visitor = $scope.addedVisitor.meetingBooked.visitor;
				$scope.newVisitor.createdBy = $scope.UserID;
				$http.post("/visitor-Management-System/Security/addCoVisitor", $scope.newVisitor).then(function mySuccess(response){
					$('#addCoVisitorModal').modal('hide');
					$scope.newVisitor = {};
					$scope.viewAllCoVisitor();
					console.log(response.data);
				}, function myError(data){
					console.log("some internal error");
					console.log(data);
				});
			}else{
				$scope.invalidMobile = true;
			};
			
		}else{
			if(!isNaN($scope.newVisitor.coVisitorContact) && !angular.isNumber(+$scope.newVisitor.coVisitorContact)){
				$scope.invalidMobile = true;
			};
		};
	};
	
	$scope.viewAllCoVisitor = function(){
		
		$http.post("/visitor-Management-System/Security/viewAllCoVisitor", $scope.addedVisitor).then(function mySuccess(response){
			console.log(response.data);
			$scope.allCoVisitor = response.data;
		}, function myError(data){
			$timeout(function() {
				$("#Loader").modal("hide");
			   }, 3000);
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.empCheckIn = function(visits){
		$( "#Loader" ).modal("show");
		visits.lastUpdatedBy = $scope.UserID;
		$http.post("/visitor-Management-System/Employee/empCheckIn", visits).then(function mySuccess(response){
			if(response.data.msg == "SUCCESS"){
				//console.log(data);
				$scope.viewAllVisits();
			}
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.checkoutSelectedEmp = function(visits){
		$scope.selectedVisit = visits;
		$scope.selectedVisit.meetingBooked.remarks = '';
		
	};
	
	$scope.empCheckOut = function(){
		$( "#Loader" ).modal("show");
		$scope.selectedVisit.lastUpdatedBy = $scope.UserID;
		$http.post("/visitor-Management-System/Employee/empCheckOut", $scope.selectedVisit).then(function mySuccess(response){
			if(response.data.msg == "SUCCESS"){
				$scope.viewAllVisits();
			}
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.cancelSelectedEmp = function(visits){
		$scope.selectedCancelVisit = visits;
		
	};
	
	$scope.cancelVisit = function(){
		$( "#Loader" ).modal("show");
		$http.post("/visitor-Management-System/Employee/cancelVisit", $scope.selectedCancelVisit).then(function mySuccess(data){
			console.log("data deleted");
			$scope.viewAllVisits();
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.backToVisit = function(){
		window.location.href  = "#!viewAllVisit";
	};
	
});