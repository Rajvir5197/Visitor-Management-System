app.controller('dashboardController', function($scope, $http, $rootScope) {
	
	$scope.UserID = window.localStorage.getItem("loginDetails");
	$scope.role = window.localStorage.getItem("loginRole");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "login.html";
	}
	
	$scope.allVisits = [];
	$scope.viewAllVisits = function(){
		$http.post("/viewAllVisits").then(function mySuccess(response){
			console.log(response.data);
			$scope.allVisits = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	if($scope.role == "Security"){
		$scope.viewAllVisits();$scope.viewAllVisits();
	}
	
	$scope.securityCheckout = function(visit){
		$rootScope.visitCheckin = visit;
		window.location = "#!securityCheckOut";
	};
	
	
	
	
	
	
	/*$rootScope.noReturn = 0;
	console.log('inside dashboard controller');*/
	$scope.add = function(){
		$scope.param={
			visitorId: $scope.visitorId
		};
		
		$http.post("/addVisitor",$scope.param).then(function mySuccess(response){
			console.log(response.data);
			if(response.data.data == 'SUCCESS'){
				console.log('added');
			}
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.sendMssg = function(){
		$http.post("/sendMessage",$scope.param).then(function mySuccess(response){
			console.log(response.data);
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
});