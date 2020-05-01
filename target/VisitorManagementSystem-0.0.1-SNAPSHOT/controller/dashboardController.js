app.controller('dashboardController', function($scope, $http, $rootScope) {
	
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