app.controller('dashboardController', function($scope, $http, $rootScope) {
	
	$scope.UserID = window.localStorage.getItem("loginDetails");
	$scope.role = window.localStorage.getItem("loginRole");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "login.html";
	}
	
	$scope.allVisits = [];
	$scope.viewAllVisits = function(){
		$scope.param = {
				empCode: $scope.UserID,
				empRole: $scope.role
		};
		$http.post("/Employee/viewAllVisits",$scope.param).then(function mySuccess(response){
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
	
	$scope.securityCheckin = function(visit){
		$rootScope.visitCheckin = visit;
		if($rootScope.visitCheckin.secCheckin){
			window.location = "#!securityCheckOut";
		}else{
			$http.post("/Security/securityCheckin", $rootScope.visitCheckin).then(function mySuccess(response){
				if(response.data.msg == 'SUCCESS'){
					window.location = "#!securityCheckOut";
				}
			}, function myError(data){
				console.log("some internal error");
				console.log(data);
			});
		}
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