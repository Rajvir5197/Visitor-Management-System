app.controller('manageVisitController', function($scope, $rootScope, $http) {
	
	$scope.UserID = window.localStorage.getItem("loginDetails");
	
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
	$scope.viewAllVisits();
	
	$scope.addNewVisit = function(){
		//if($scope.addForm.$valid){
			$scope.newVisit.meetingBooked.createdBy = $scope.UserID;
			$scope.newVisit.lastUpdatedBy = $scope.UserID;
			$scope.newVisit.meetingBooked.empId = $scope.UserID;
			$http.post("/addNewVisit", $scope.newVisit).then(function mySuccess(response){
				if(response.data.msg == "SUCCESS"){
					window.location.href  = "#!viewAllVisit";
				}
				/*if(response.data.msg == "SUCCESS"){
					$scope.param = {
							APIKey: "R8ntvc8nnU26zeAGiN0U0A",
							senderid: "ERUCHA",
							channel: "2", 
							DCS: "0", 
							flashsms: "0", 
							numbers: $scope.newVisit.meetingBooked.visitor.contactNumber,
							text: "testMessage",
							route: "1"
					};
					$http.post("/sendMessage", response.data.meetingData).then(function mySuccess(data){
						if(data.data.status == "failure"){
							alert("couldn't send the msg");
							$http.post("/deleteVisit", response.data.meetingData).then(function mySuccess(data){
								console.log("data deleted");
							}, function myError(data){
								console.log("some internal error");
								console.log(data);
							});
						}else{
							window.location.href  = "#!viewAllVisit"
						}
					}, function myError(data){
						console.log("some internal error");
						console.log(data);
					});
				}*/
			}, function myError(data){
				console.log("some internal error");
				console.log(data);
			});
		//}
	};
	
	$scope.empCheckIn = function(visits){
		visits.lastUpdatedBy = $scope.UserID;
		$http.post("/empCheckIn", visits).then(function mySuccess(response){
			if(response.data.msg == "SUCCESS"){
				//console.log(data);
				$scope.viewAllVisits();
			}
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.checkoutSelectedEmp = function(visits){
		$scope.selectedVisit = visits;
		$scope.selectedVisit.meetingBooked.Remarks = '';
		
	};
	
	$scope.empCheckOut = function(){
		$scope.selectedVisit.lastUpdatedBy = $scope.UserID;
		$http.post("/empCheckOut", $scope.selectedVisit).then(function mySuccess(response){
			if(response.data.msg == "SUCCESS"){
				$scope.viewAllVisits();
			}
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.cancelSelectedEmp = function(visits){
		$scope.selectedCancelVisit = visits;
		
	};
	
	$scope.cancelVisit = function(){
		$http.post("/deleteVisit", $scope.selectedCancelVisit).then(function mySuccess(data){
			console.log("data deleted");
			$scope.viewAllVisits();
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
});