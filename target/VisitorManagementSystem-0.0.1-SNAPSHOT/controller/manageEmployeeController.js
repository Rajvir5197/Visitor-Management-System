app.controller('manageEmployeeController', function($scope, $rootScope, $http) {

	$scope.UserID = window.localStorage.getItem("loginDetails");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "login.html";
	}
	$scope.allEmp = [];
	$scope.invalidEditedMobile = false;
	$scope.invalidMobile = false;
	$scope.viewAllEmp = function(){
		$http.post("/viewAllEmp").then(function mySuccess(response){
			console.log(response.data);
			$scope.allEmp = response.data;
			angular.forEach($scope.allEmp,function(value){
				$scope.getPlantCode(value);
			});
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.getAllDepartment = function(){
		$http.post("/viewAllDept").then(function mySuccess(response){
			console.log(response.data);
			$scope.allDept = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.getAllPlants = function(){
		$http.post("/viewAllPlant").then(function mySuccess(response){
			console.log(response.data);
			$scope.allPlants = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	$scope.viewAllEmp();
	$scope.getAllDepartment();
	$scope.getAllPlants();
	$scope.getPlantCode = function(emp){
		$scope.plantCodeArray = [];
		angular.forEach(emp.empPlantCode,function(value){
			$scope.plantCodeArray.push(value.plantCode);
		});
		emp.plantCode = $scope.plantCodeArray.join();
		console.log("plantcode: ",emp.plantCode);
	};
	
	$scope.viewSelectedEmp = function(emp){
		$scope.viewEmp = emp;
	};
	
	$scope.editSelectedEmp = function(emp){
		$scope.editedEmp = angular.copy(emp);
		console.log("depart: ",$scope.editedEmp.empDept.deptName);
	};
	
	$scope.dtlSelectedEmp = function(emp){
		$scope.EmpToBeDeleted = emp;
	};
	
	$scope.addNewEmp = function(){
		$scope.invalidMobile = false;
		if($scope.addForm.$valid){
			if(!isNaN($scope.newEmp.empMobile) && angular.isNumber(+$scope.newEmp.empMobile)){
				$scope.newEmp.regBy = $scope.UserID;
				$http.post("/addNewOrEditEmp", $scope.newEmp).then(function mySuccess(response){
					$('#addNewEmpModal').hide();
					$('.modal-backdrop').hide();
					$scope.viewAllEmp();
					console.log(response.data);
				}, function myError(data){
					console.log("some internal error");
					console.log(data);
				});
			}else{
				$scope.invalidMobile = true;
			}
			
		}else{
			if(!isNaN($scope.newEmp.empMobile) && !angular.isNumber(+$scope.newEmp.empMobile)){
				$scope.invalidMobile = true;
			}
		}
	};
	
	$scope.editEmp = function(){
		$scope.invalidEditedMobile = false;
		if($scope.editForm.$valid){
			if(!isNaN($scope.editedEmp.empMobile) && angular.isNumber(+$scope.editedEmp.empMobile)){
				$scope.editedEmp.regBy = $scope.UserID;
				$http.post("/addNewOrEditEmp", $scope.editedEmp).then(function mySuccess(response){
					$('#editEmpModal').hide();
					$('.modal-backdrop').hide();
					$scope.viewAllEmp();
					console.log(response.data);
				}, function myError(data){
					console.log("some internal error");
					console.log(data);
				});
			}else{
				$scope.invalidEditedMobile = true;
			}
			
		}else{
			if(!isNaN($scope.editedEmp.empMobile) && !angular.isNumber(+$scope.editedEmp.empMobile)){
				$scope.invalidEditedMobile = true;
			}
		}
	};
	
	$scope.deleteEmp = function(){
		$scope.EmpToBeDeleted.regBy = $scope.UserID;
		$http.post("/deleteEmp", $scope.EmpToBeDeleted).then(function mySuccess(response){
			$scope.viewAllEmp();
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
});