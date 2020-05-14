app.controller('reportController', function($scope, $rootScope, $http, $timeout) {
	
	$scope.UserID = window.localStorage.getItem("loginDetails");
	$scope.role = window.localStorage.getItem("loginRole");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "/visitor-Management-System/index.html";
	}
	
	$scope.allVisits=[];
	$scope.viewAllVisits = function(){
		$http.post("/visitor-Management-System/Admin/viewAllVisitsReport").then(function mySuccess(response){
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
		if(reportType == 'emp'){
			/*$("#visitData tr").filter(function(value){
				$(this).toggle($scope.allVisits[value].meetingBooked.visitDate > document.getElementById( "selectedFromDateEmp"))
			});*/
			/*$scope.allVisits = $scope.allVisits.filter(function(value){
				return value.meetingBooked.visitDate >= document.getElementById( "selectedFromDateEmp");
			});*/
			$('#dataTable thead tr').clone(true).appendTo( '#dataTable thead' );
			$('#dataTable thead tr:eq(1) th').each( function (i) {
				var title = $(this).text();
				if(i == 4){
					if ( table.column(i).search() !== document.getElementById( "selectedFromDateEmp").value ) {
		                table
		                    .column(i)
		                    .search( document.getElementById( "selectedFromDateEmp").value )
		                    .draw();
		            }
				}
		    } );
		};
	};
});