app.controller('manageContactEditController', function($scope, $rootScope, $http) {
	
	$scope.UserID = window.localStorage.getItem("loginDetails");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "/visitor-Management-System/index.html";
	};
	
	if($rootScope.editedContact == undefined || $rootScope.editedContact == null){
		window.location = "#!ManageContact";
	}
	window.localStorage.setItem("pagePosition", "FromContactEditPage");
	$scope.invalidEditedMobile = false;
	$scope.editContact = function(){
		$scope.invalidEditedMobile = false;
		if($scope.editForm.$valid){
			if(!isNaN($rootScope.editedContact.mobileNumb) && angular.isNumber(+$rootScope.editedContact.mobileNumb)){
				$rootScope.editedContact.regBy = $scope.UserID;
				$http.post("/visitor-Management-System/Employee/addNewContact", $rootScope.editedContact).then(function mySuccess(response){
					$scope.msg = response.data.msg;
					if(response.data.msg == "SUCCESS"){
						$( "#notificationModal" ).modal("show");
					}else if(response.data.msg == "ALREADYTHERE"){
						$( "#notificationModal" ).modal("show");
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
	
	$scope.closeNoti = function(){
		window.location.href  = "#!ManageContact";
	};

});