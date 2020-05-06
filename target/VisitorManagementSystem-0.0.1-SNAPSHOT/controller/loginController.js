app.controller('loginController', function($scope, $rootScope, $http) {
	
	console.log("in js");
	$scope.invalidUser = false;
	$scope.login = function(){
		$scope.param={
				empCode: $scope.empId,
				empPass: $scope.pass
		};
		$http.post("/VisitorManagementSystem/Login/doLogin",$scope.param).then(function mySuccess(response){
			console.log(response.data);
			if(response.data.data == 'SUCCESS'){
				console.log("authorized");
				$scope.invalidUser = false;
				window.localStorage.setItem("loginDetails", response.data.empDetails.empCode);
				window.localStorage.setItem("loginRole", response.data.empDetails.empRole);
				window.location.href  = "index.html"
			}else{
				$scope.invalidUser = true;
				console.log("not authorized");
			}
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};	
	
	
});