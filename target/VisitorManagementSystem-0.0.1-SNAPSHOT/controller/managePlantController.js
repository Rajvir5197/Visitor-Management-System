app.controller('managePlantController', function($scope, $rootScope, $http) {
		
	
	$scope.UserID = window.localStorage.getItem("loginDetails");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "login.html";
	}
	$scope.allPlants = [];
	$scope.viewAllPlant = function(){
		$http.post("/viewAllPlant").then(function mySuccess(response){
			console.log(response.data);
			$scope.allPlants = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	$scope.viewAllPlant();
	
	$scope.viewPlant = function(plant){
		$scope.plantView = plant;
	};
	
	$scope.viewEditPlant = function(plant){
		$scope.edited = angular.copy(plant);
	};
	
	$scope.deletePlantDetails = function(plant){
		$scope.plantToBeDeleted = plant;
	};
	
	$scope.addNewPlant = function(){
		if($scope.addForm.$valid){
			$scope.newPlant.regBy = $scope.UserID;
			$http.post("/addNewPlant", $scope.newPlant).then(function mySuccess(response){
				$('#addNewPlantModal').hide();
				$('.modal-backdrop').hide();
				$scope.viewAllPlant();
			}, function myError(data){
				console.log("some internal error");
				console.log(data);
			});
		}
	};
	
	$scope.editPlant = function(){
		if($scope.editForm.$valid){
			$scope.edited.regBy = $scope.UserID;
			$http.post("/editPlant", $scope.edited).then(function mySuccess(response){
				$('#editPlantModal').hide();
				$('.modal-backdrop').hide();
				$scope.viewAllPlant();
			}, function myError(data){
				console.log("some internal error");
				console.log(data);
			});
		}
	}; 
	
	$scope.deletePlant = function(){
		$scope.plantToBeDeleted.regBy = $scope.UserID;
		$http.post("/deletePlant", $scope.plantToBeDeleted).then(function mySuccess(response){
			$scope.viewAllPlant();
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.beforeAddModal = function(){
		$scope.newPlant = {};
		$scope.newPlant.plantState = 'Maharashtra';
		$scope.newPlant.plantCountry = 'India';
		$scope.newPlant.plantCity = 'Aurangabad';
	};
});