app.controller('manageVisitController', function($scope, $rootScope, $http) {
	
	$scope.UserID = window.localStorage.getItem("loginDetails");
	$scope.role = window.localStorage.getItem("loginRole");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "login.html";
	}
	
	$scope.allVisits = [];
	$scope.invalidMobile = false;
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
	
	$scope.viewEmpPlant = function(){
		$scope.param = {
				empCode: $scope.UserID,
				empRole: $scope.role
		};
		$http.post("/Employee/getEmpPlant",$scope.param).then(function mySuccess(response){
			$scope.EmpPlants = response.data.empPlantCode;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.viewAllVisits();
	$scope.viewEmpPlant();
	
	$scope.addNewVisit = function(){
		$scope.invalidMobile = false;
		if($scope.addForm.$valid){
			if(!isNaN($scope.newVisit.meetingBooked.visitor.contactNumber) && angular.isNumber(+$scope.newVisit.meetingBooked.visitor.contactNumber)){
				$scope.newVisit.createdBy = $scope.UserID;
				$scope.newVisit.lastUpdatedBy = $scope.UserID;
				$scope.newVisit.meetingBooked.empId = $scope.UserID;
				$http.post("/Employee/addNewVisit", $scope.newVisit).then(function mySuccess(response){
					if(response.data.msg == "SUCCESS"){
						window.location.href  = "#!viewAllVisit";
					}
				}, function myError(data){
					console.log("some internal error");
					console.log(data);
				});
			}else{
				$scope.invalidMobile = true;
			}
		}
	};
	
	$scope.empCheckIn = function(visits){
		visits.lastUpdatedBy = $scope.UserID;
		$http.post("/Employee/empCheckIn", visits).then(function mySuccess(response){
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
		$scope.selectedVisit.meetingBooked.Remarks = '';
		
	};
	
	$scope.empCheckOut = function(){
		$scope.selectedVisit.lastUpdatedBy = $scope.UserID;
		$http.post("/Employee/empCheckOut", $scope.selectedVisit).then(function mySuccess(response){
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
		$http.post("/Employee/cancelVisit", $scope.selectedCancelVisit).then(function mySuccess(data){
			console.log("data deleted");
			$scope.viewAllVisits();
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
});