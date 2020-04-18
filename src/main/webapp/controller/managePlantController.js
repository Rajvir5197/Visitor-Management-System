app.controller('managePlantController', function($scope, $rootScope, $http, $window,$anchorScroll) {
		
	$scope.allPlants = [];
	$scope.whenError = false;
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
		
		console.log("newPlant",$scope.newPlant);
		if($scope.newPlant.plantCode != undefined && $scope.newPlant.plantCode != null){
			$http.post("/addNewPlant", $scope.newPlant).then(function mySuccess(response){
				$scope.viewAllPlant();
			}, function myError(data){
				console.log("some internal error");
				console.log(data);
			});
		}else{
			$scope.whenError = true;
		}
		
	};
	
	$scope.editPlant = function(){
		$http.post("/editPlant", $scope.edited).then(function mySuccess(response){
			$scope.viewAllPlant();
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	}; 
	
	$scope.deletePlant = function(){
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
		$scope.whenError = false;
	};
});