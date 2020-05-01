app.controller('manageDeptController', function($scope, $rootScope, $http) {
	
	$scope.allDept = [];
	$scope.UserID = window.localStorage.getItem("loginDetails");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "login.html";
	}

	$scope.viewAllDept = function(){
		$http.post("/viewAllDept").then(function mySuccess(response){
			console.log(response.data);
			$scope.allDept = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	$scope.viewAllDept();
	
	$scope.viewSelectedDept = function(dept){
		$scope.viewDept = dept;
	};
	
	$scope.editSelectedDept = function(dept){
		$scope.editedDept = angular.copy(dept);
	};
	
	$scope.dtlSelectedDept = function(dept){
		$scope.deptToBeDeleted = dept;
	};
	
	$scope.addNewDept = function(){
		if($scope.addForm.$valid){
			$scope.newDept.regBy = $scope.UserID;
			$http.post("/addNewOrEditDept", $scope.newDept).then(function mySuccess(response){
				$('#addNewDeptModal').hide();
				$('.modal-backdrop').hide();
				$scope.viewAllDept();
			}, function myError(data){
				console.log("some internal error");
				console.log(data);
			});
		}
	};
	
	$scope.editDept = function(){
		if($scope.editForm.$valid){
			$scope.editedDept.regBy = $scope.UserID;
			$http.post("/addNewOrEditDept", $scope.editedDept).then(function mySuccess(response){
				$('#editDeptModal').hide();
				$('.modal-backdrop').hide();
				$scope.viewAllDept();
			}, function myError(data){
				console.log("some internal error");
				console.log(data);
			});
		}
	};
	
	$scope.deleteDept = function(){
		$scope.deptToBeDeleted.regBy = $scope.UserID;
		$http.post("/deleteDept", $scope.deptToBeDeleted).then(function mySuccess(response){
			$scope.viewAllDept();
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
});