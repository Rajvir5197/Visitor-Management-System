app.controller('settingController', function($scope, $http, $rootScope,$timeout) {
	
	$scope.UserID = window.localStorage.getItem("loginDetails");
	$scope.role = window.localStorage.getItem("loginRole");
	$scope.userName = window.localStorage.getItem("userName");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "/visitor-Management-System/index.html";
	}
	
	$scope.changePassword = function(){
		$http.post("/visitor-Management-System/Employee/changePassword", $rootScope.emp).then(function mySuccess(response){
			$('#notificationModal').modal('show');
			$scope.getUpdatedEmp();
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.getPlantCode = function(emp){
		$scope.plantCodeArray = [];
		angular.forEach(emp.empPlantCode,function(value){
			$scope.plantCodeArray.push(value.plantCode);
		});
		emp.plantCode = $scope.plantCodeArray.join();
	};
	
	$scope.getUpdatedEmp = function(){
		$http.post("/visitor-Management-System/Employee/GetLoggedInDetails",$scope.loginId).then(function mySuccess(response){
			$rootScope.emp = response.data;
			$scope.getPlantCode($rootScope.emp);
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.getUpdatedEmp();
	
	
});