app.controller('manageContactEditController', function($scope, $rootScope, $http) {
	
	$scope.UserID = window.localStorage.getItem("loginDetails");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "/VisitorManagementSystem-0.0.1-SNAPSHOT/login.html";
	};	
	$scope.invalidEditedMobile = false;
	$scope.editContact = function(){
		$scope.invalidEditedMobile = false;
		if($scope.editForm.$valid){
			if(!isNaN($rootScope.editedContact.mobileNumb) && angular.isNumber(+$rootScope.editedContact.mobileNumb)){
				$rootScope.editedContact.regBy = $scope.UserID;
				$http.post("/VisitorManagementSystem-0.0.1-SNAPSHOT/Employee/addNewOrEditContact", $rootScope.editedContact).then(function mySuccess(response){
					if(response.data.msg == "SUCCESS"){
						window.location.href  = "#!ManageContact"
					}
				}, function myError(data){
					console.log("some internal error");
					console.log(data);
				});
			}else{
				$scope.invalidEditedMobile = true;
			}
			
		}
	};

});