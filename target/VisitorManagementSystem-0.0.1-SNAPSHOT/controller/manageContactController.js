app.controller('manageContactController', function($scope, $rootScope, $http) {
	
	console.log("edited: ",$scope.editedContact);
	$scope.allContacts = [];
	$scope.UserID = window.localStorage.getItem("loginDetails");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "login.html";
	}

	$scope.invalidMobile = false;
	$scope.viewAllContacts = function(){
		$http.post("/viewAllContacts",$scope.UserID).then(function mySuccess(response){
			console.log(response.data);
			$scope.allContacts = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.viewAllContacts();
	
	$scope.viewSelectedContact = function(contact){
		$scope.viewContact = contact;
	};
	
	$scope.editSelectedContact = function(contact){
		$rootScope.editedContact = angular.copy(contact);
	};
	
	$scope.dtlSelectedContact = function(contact){
		$scope.contactToBeDeleted = contact;
	};
	
	$scope.addNewContact = function(){
		$scope.invalidMobile = false;
		if($scope.addForm.$valid){
			if(!isNaN($scope.newContact.mobileNumb) && angular.isNumber(+$scope.newContact.mobileNumb)){
				$scope.newContact.regBy = $scope.UserID;
				$http.post("/addNewOrEditContact", $scope.newContact).then(function mySuccess(response){
					if(response.data.msg == "SUCCESS"){
						window.location.href  = "#!ManageContact"
					}
				}, function myError(data){
					console.log("some internal error");
					console.log(data);
				});
			}else{
				$scope.invalidMobile = true;
			}
		}
	};
	
	$scope.deleteContact = function(){
		$scope.contactToBeDeleted.regBy = $scope.UserID;
		$http.post("/deleteContact", $scope.contactToBeDeleted).then(function mySuccess(response){
			$scope.viewAllContacts();
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
});