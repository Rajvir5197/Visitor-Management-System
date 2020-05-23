app.controller('manageEmployeeController', function($scope, $rootScope, $http, $timeout) {

	$scope.UserID = window.localStorage.getItem("loginDetails");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "/visitor-Management-System/index.html";
	}
	
	$( "#Loader" ).modal("show");
	$scope.allEmp = [];
	$scope.invalidEditedMobile = false;
	$scope.invalidMobile = false;
	$scope.viewAllEmp = function(){
		$http.post("/visitor-Management-System/Employee/viewAllEmp").then(function mySuccess(response){
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
		$http.post("/visitor-Management-System/Department/viewAllDept").then(function mySuccess(response){
			console.log(response.data);
			$scope.allDept = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
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
	$scope.viewAllEmp();
	$scope.getAllDepartment();
	$scope.getAllPlants();
	$scope.getPlantCode = function(emp){
		$scope.plantCodeArray = [];
		angular.forEach(emp.empPlantCode,function(value){
			$scope.plantCodeArray.push(value.plantCode);
		});
		emp.plantCode = $scope.plantCodeArray.join();
		$timeout(function() {
			$('#dataTable').DataTable();
		   }, 200);
		$timeout(function() {
			$("#Loader").modal("hide");
		   }, 500);
		console.log("plantcode: ",emp.plantCode);
	};
	
	$scope.viewSelectedEmp = function(emp){
		$scope.viewEmp = emp;
	};
	
	$scope.editSelectedEmp = function(emp){
		$scope.editedEmp = angular.copy(emp);
		$scope.myFile = null;
		console.log("depart: ",$scope.editedEmp.empDept.deptName);
	};
	
	$scope.dtlSelectedEmp = function(emp){
		$scope.EmpToBeDeleted = emp;
	};
	
	$scope.addNewEmp1 = function(){
		$scope.invalidMobile = false;
		if($scope.addForm.$valid){
			if(!isNaN($scope.newEmp.empMobile) && angular.isNumber(+$scope.newEmp.empMobile)){
				$scope.newEmp.regBy = $scope.UserID;
				$http.post("/visitor-Management-System/Employee/addNewOrEditEmp", $scope.newEmp).then(function mySuccess(response){
					$('#addNewEmpModal').modal('hide');
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
	
	$scope.addNewEmp = function(){
		$scope.invalidMobile = false;
		if($scope.addForm.$valid){
			if(!isNaN($scope.newEmp.empMobile) && angular.isNumber(+$scope.newEmp.empMobile)){
				$scope.newEmp.regBy = $scope.UserID;
				if($scope.myFile != null && $scope.myFile != undefined){
					var file = $scope.myFile;
					var fd = new FormData();
					fd.append('file', file);
					fd.append('empDetails', JSON.stringify($scope.newEmp));
					
					$http.post("/visitor-Management-System/Employee/addNewOrEditEmp", fd, {
						transformRequest : angular.identity,
						headers : {'Content-Type' : undefined}
					}).then(function mySuccess(response){
						if(response.data.data == "Exist"){
							$scope.dataExist = true;
						}else{
							$scope.dataExist = false;
						}
						$('#addNewEmpModal').modal('hide');
						$('#notificationModal').modal('show');
					}, function myError(data){
						console.log("some internal error");
						console.log(data);
					});
				}else{
					$http.post("/visitor-Management-System/Employee/addNewEmp", $scope.newEmp).then(function mySuccess(response){
						if(response.data.data == "Exist"){
							$scope.dataExist = true;
						}else{
							$scope.dataExist = false;
						}
						$('#addNewEmpModal').modal('hide');
						$('#notificationModal').modal('show');
					}, function myError(data){
						console.log("some internal error");
						console.log(data);
					});
				}
			}else{
				$scope.invalidMobile = true;
			}
			
		}else{
			if(!isNaN($scope.newEmp.empMobile) && !angular.isNumber(+$scope.newEmp.empMobile)){
				$scope.invalidMobile = true;
			}
		}
	};
	
	$scope.notiClose = function(){
		$( "#Loader" ).modal("show");
		$('#dataTable').DataTable().clear().destroy();
		$scope.viewAllEmp();
	};
	
	$scope.editEmp1 = function(){
		$scope.invalidEditedMobile = false;
		if($scope.editForm.$valid){
			if(!isNaN($scope.editedEmp.empMobile) && angular.isNumber(+$scope.editedEmp.empMobile)){
				$scope.editedEmp.regBy = $scope.UserID;
				$http.post("/visitor-Management-System/Employee/editNewOrEditEmp", $scope.editedEmp).then(function mySuccess(response){
					$('#editEmpModal').modal('hide');
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
	
	$scope.editEmp = function(){
		$scope.invalidEditedMobile = false;
		if($scope.editForm.$valid){
			if(!isNaN($scope.editedEmp.empMobile) && angular.isNumber(+$scope.editedEmp.empMobile)){
				$scope.editedEmp.regBy = $scope.UserID;
				if($scope.myFile != null && $scope.myFile != undefined){
					var file = $scope.myFile;
					var fd = new FormData();
					fd.append('file', file);
					fd.append('empDetails', JSON.stringify($scope.editedEmp));
					
					$http.post("/visitor-Management-System/Employee/editNewOrEditEmp", fd, {
						transformRequest : angular.identity,
						headers : {'Content-Type' : undefined}
					}).then(function mySuccess(response){
						$('#editEmpModal').modal('hide');
						$( "#Loader" ).modal("show");
						$('#dataTable').DataTable().clear().destroy();
						$scope.viewAllEmp();
					}, function myError(data){
						console.log("some internal error");
						console.log(data);
					});
				}else{
					$http.post("/visitor-Management-System/Employee/editEmp", $scope.editedEmp).then(function mySuccess(response){
						$('#editEmpModal').modal('hide');
						$( "#Loader" ).modal("show");
						$('#dataTable').DataTable().clear().destroy();
						$scope.viewAllEmp();
					}, function myError(data){
						console.log("some internal error");
						console.log(data);
					});
				}
				
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
		$http.post("/visitor-Management-System/Employee/deleteEmp", $scope.EmpToBeDeleted).then(function mySuccess(response){
			$( "#Loader" ).modal("show");
			$('#dataTable').DataTable().clear().destroy();
			$scope.viewAllEmp();
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};

});