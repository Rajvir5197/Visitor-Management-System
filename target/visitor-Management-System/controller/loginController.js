app.controller('loginController', function($scope, $rootScope, $http) {
	
	console.log("in js");
	$scope.invalidUser = false;
	$scope.UserName = window.localStorage.getItem("userName");
	if($scope.UserName != undefined || $scope.UserName != null ){
		window.location.href  = "index1.html";
	}
	$scope.login = function(){
		$scope.param={
				empCode: $scope.empId,
				empPass: $scope.pass
		};
		$http.post("/visitor-Management-System/Login/doLogin",$scope.param).then(function mySuccess(response){
			console.log(response.data);
			if(response.data.data == 'SUCCESS'){
				console.log("authorized");
				$scope.invalidUser = false;
				window.localStorage.setItem("loginDetails", response.data.empDetails.empCode);
				window.localStorage.setItem("loginRole", response.data.empDetails.empRole);
				window.localStorage.setItem("userName", response.data.empDetails.empName);
				window.localStorage.setItem("pagePosition", "FromLoginPage");
				window.location.href  = "index1.html";
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