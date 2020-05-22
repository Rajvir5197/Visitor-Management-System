app.controller('reportController', function($scope, $rootScope, $http, $timeout) {
	
	$scope.UserID = window.localStorage.getItem("loginDetails");
	$scope.role = window.localStorage.getItem("loginRole");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "/visitor-Management-System/index.html";
	}
	
	$scope.allVisits=[];
	$scope.errorInDate = false;
	$scope.viewAllVisits = function(){
		$http.post("/visitor-Management-System/Admin/viewAllVisitsReport").then(function mySuccess(response){
			console.log(response.data);
			$scope.allVisits = response.data;
			$scope.copyOfAllVisits = angular.copy($scope.allVisits);
			$timeout(function() {
				$('#dataTable').DataTable();
			   }, 200);
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.viewAllCancelVisits = function(){
		$http.post("/visitor-Management-System/Admin/viewAllCancelVisitsReport").then(function mySuccess(response){
			console.log(response.data);
			$scope.allVisits = response.data;
			$timeout(function() {
				$('#dataTable').DataTable();
			   }, 200);
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
	
	
	if($scope.reportType == 'plant' || $scope.reportType == 'plantHr' || $scope.reportType == 'emp'){
		$scope.viewAllVisits();
	}else{
		$scope.viewAllCancelVisits();
	}
	
	$scope.getAllDepartment();
	$scope.selectedDept = 'All Dept';
	$scope.getAllPlants();
	$scope.selectedPlant = 'All Plant';
	/*if($scope.reportType == 'plant' || $scope.reportType == 'plantHr' || $scope.reportType == 'cancelPlant' || $scope.reportType == 'cancelPlantHr'){
		$scope.getAllDepartment();
		if($scope.reportType == 'plant' || $scope.reportType == 'cancelPlant'){
			$scope.getAllPlants();
			$scope.selectedPlant = 'All Plant';
		}
	}*/
	
	
	$scope.getCoVisitor = function(visitor){
		$scope.selectedVisitor = visitor;
		$http.post("/visitor-Management-System/Security/viewAllCoVisitor", visitor).then(function mySuccess(response){
			console.log(response.data);
			$scope.coVisitorNameArray = [];
			angular.forEach(response.data,function(value){
				$scope.coVisitorNameArray.push(value.coVisitorName);
			});
			$scope.allCoVisitor = $scope.coVisitorNameArray.join(',');
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	
	};
	
	$scope.downloadExcel = function(){
		
		$http.get("/visitor-Management-System/Admin/downloadReport/reports.xlsx").then(function mySuccess(response){
			console.log("success in excel download");
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.getVisitsbetweenDates = function(){
		$http.post("/visitor-Management-System/Admin/getVisitsbetweenDates",document.getElementById("selectedFromDateEmp").value,document.getElementById("selectedToDate").value).then(function mySuccess(response){
			console.log(response.data);
			$scope.allVisits = response.data;
			$timeout(function() {
				$('#dataTable').DataTable();
			   }, 200);
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.filterData = function(reportType){
		console.log($scope.selectedFromDateEmp);
		$scope.errorInDate = false;
		if(reportType == 'emp' || reportType == 'cancelEmp'){
			if(document.getElementById("selectedFromDateEmp").value > document.getElementById("selectedToDate").value ){
				$scope.errorInDate = true;
			}else{
				$scope.allVisits = $scope.copyOfAllVisits;
				if(document.getElementById("selectedFromDateEmp").value != "" && document.getElementById("selectedToDate").value != ""){
					$('#dataTable').DataTable().clear().destroy();
					$scope.allVisits = $scope.allVisits.filter(function(value){
						return (value.meetingBooked.visitDate >= document.getElementById("selectedFromDateEmp").value && value.meetingBooked.visitDate <= document.getElementById("selectedToDate").value);
					});
				}else if(document.getElementById("selectedFromDateEmp").value != "" && document.getElementById("selectedToDate").value == ""){
					$('#dataTable').DataTable().clear().destroy();
					$scope.allVisits = $scope.allVisits.filter(function(value){
						return (value.meetingBooked.visitDate >= document.getElementById("selectedFromDateEmp").value);
					});
				}else if(document.getElementById("selectedFromDateEmp").value == "" && document.getElementById("selectedToDate").value != ""){
					$('#dataTable').DataTable().clear().destroy();
					$scope.allVisits = $scope.allVisits.filter(function(value){
						return (value.meetingBooked.visitDate <= document.getElementById("selectedToDate").value);
					});
				}else{
					$('#dataTable').DataTable().clear().destroy();
				}
				
				$timeout(function() {
					$('#dataTable').DataTable();
				   }, 200);
			};
		};
	};
});