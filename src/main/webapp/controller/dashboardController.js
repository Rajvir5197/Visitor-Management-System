app.controller('dashboardController', function($scope, $http, $rootScope) {
	
	$scope.UserID = window.localStorage.getItem("loginDetails");
	$scope.role = window.localStorage.getItem("loginRole");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "login.html";
	}
	
	$scope.allVisits = [];
	$scope.viewAllVisits = function(){
		$scope.param = {
				empCode: $scope.UserID,
				empRole: $scope.role
		};
		$http.post("/Employee/viewAllVisits",$scope.param).then(function mySuccess(response){
			console.log(response.data);
			$scope.allVisits = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.viewAllContacts = function(){
		$http.post("/Employee/viewAllContacts",$scope.UserID).then(function mySuccess(response){
			console.log(response.data);
			$scope.allContacts = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.getTasks = function(){
		$http.post("/Employee/viewTask",$scope.UserID).then(function mySuccess(response){
			console.log(response.data);
			$scope.allTask = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	}
	
	$scope.getAllPlants = function(){
		$http.post("/Plant/viewAllPlant").then(function mySuccess(response){
			console.log(response.data);
			$scope.allPlants = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	if($scope.role == "Security"){
		$scope.viewAllVisits();
	}else{
		$scope.viewAllContacts();
		$scope.getTasks();
		$scope.viewAllVisits();
		$scope.getAllPlants();
	}
	
	$scope.securityCheckin = function(visit){
		$rootScope.visitCheckin = visit;
		if($rootScope.visitCheckin.secCheckin){
			window.location = "#!securityCheckOut";
		}else{
			$http.post("/Security/securityCheckin", $rootScope.visitCheckin).then(function mySuccess(response){
				if(response.data.msg == 'SUCCESS'){
					window.location = "#!securityCheckOut";
				}
			}, function myError(data){
				console.log("some internal error");
				console.log(data);
			});
		}
	};
	
	$scope.securityCheckout = function(visit){
		$http.post("/Security/securityCheckout", visit).then(function mySuccess(response){
			if(response.data.msg == 'SUCCESS'){
				$scope.viewAllVisits();
			}
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	}
	
	$scope.addTask = function(){
		$scope.newTask.createdBy = $scope.UserID;
		$http.post("/Employee/addTask",$scope.newTask).then(function mySuccess(response){
			if(response.data.msg == "SUCCESS"){
				$scope.getTasks();
				$('#addNewTask').hide();
				$('.modal-backdrop').hide();
			}
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	}
	
	$scope.updateTask = function(task){
		$http.post("/Employee/completeTask",task).then(function mySuccess(response){
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
		if($scope.addVisitForm.$valid){
			if(!isNaN($scope.visit.meetingBooked.visitor.contactNumber) && angular.isNumber(+$scope.visit.meetingBooked.visitor.contactNumber)){
				var todayDate = new Date();
				todayDate.setHours(0,0,0,0)
				if($scope.visit.meetingBooked.visitDate < todayDate){
					$scope.invalidDate = true;
				}else{
					$scope.visit.createdBy = $scope.UserID;
					$scope.visit.lastUpdatedBy = $scope.UserID;
					$scope.visit.meetingBooked.empId = $scope.UserID;
					$http.post("/Employee/addNewVisit", $scope.visit).then(function mySuccess(response){
						if(response.data.msg == "SUCCESS"){
							$('#VisitScheduleModal').hide();
							$('.modal-backdrop').hide();
							window.location.href  = "#!employeeDashboard";
						}
					}, function myError(data){
						console.log("some internal error");
						console.log(data);
					});
				}
			}else{
				$scope.invalidMobile = true;
			}
		}
	};
	
});