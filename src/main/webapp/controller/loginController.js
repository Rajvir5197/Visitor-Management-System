app.controller('loginController', function($scope, $rootScope, $http, $rootScope) {
	
	console.log("in js");
	$scope.invalidUser = false;
	$scope.login = function(){
		$scope.param={
				empMobile: $scope.mobile,
				empPass: $scope.pass
		};
		$http.post("/doLogin",$scope.param).then(function mySuccess(response){
			console.log(response.data);
			if(response.data.data == 'SUCCESS'){
				console.log("authorized");
				$scope.invalidUser = false;
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