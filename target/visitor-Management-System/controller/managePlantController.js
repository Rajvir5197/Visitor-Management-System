app.controller('managePlantController', function($scope, $rootScope, $http, $timeout) {
		
	
	$scope.UserID = window.localStorage.getItem("loginDetails");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "/visitor-Management-System/index.html";
	}
	
	window.localStorage.setItem("pagePosition", "FromPlantPage");
	$( "#Loader" ).modal("show");
	
	$scope.allPlants = [];
	$scope.viewAllPlant = function(){
		$http.post("/visitor-Management-System/Plant/viewAllPlant").then(function mySuccess(response){
			console.log(response.data);
			$scope.allPlants = response.data;
			$timeout(function() {
				$('#dataTable').DataTable();
			   }, 200);
			$timeout(function() {
				$("#Loader").modal("hide");
			   }, 500);
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
		$('#dataTable').DataTable().clear().destroy();
		$scope.viewAllPlant();
	};
	
	$scope.editPlant = function(){
		if($scope.editForm.$valid){
			$scope.edited.regBy = $scope.UserID;
			$http.post("/visitor-Management-System/Plant/editPlant", $scope.edited).then(function mySuccess(response){
				$('#editPlantModal').modal('hide');
				$( "#Loader" ).modal("show");
				$('#dataTable').DataTable().clear().destroy();
				$scope.viewAllPlant();
			}, function myError(data){
				console.log("some internal error");
				console.log(data);
			});
		}
	}; 
	
	$scope.deletePlant = function(){
		$scope.plantToBeDeleted.regBy = $scope.UserID;
		$http.post("/visitor-Management-System/Plant/deletePlant", $scope.plantToBeDeleted).then(function mySuccess(response){
			$( "#Loader" ).modal("show");
			$('#dataTable').DataTable().clear().destroy();
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