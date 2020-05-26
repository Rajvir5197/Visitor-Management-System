app.controller('manageMeetingTypeController', function($scope, $rootScope, $http, $timeout) {
	
	$scope.allMeetingType = [];
	$scope.UserID = window.localStorage.getItem("loginDetails");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "/visitor-Management-System/index.html";
	}
	
	window.localStorage.setItem("pagePosition", "FromMeetingTypePage");
	$( "#Loader" ).modal("show");

	$scope.viewAllMeetingType = function(){
		$http.post("/visitor-Management-System/Admin/viewAllMeeting").then(function mySuccess(response){
			console.log(response.data);
			$scope.allMeetingType = response.data;
			$timeout(function() {
				$('#dataTable').DataTable();
			   }, 200);
			$timeout(function() {
				$("#Loader").modal("hide");
			   }, 500);
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.viewAllMeetingType();
	
	$scope.viewSelectedMeetingType = function(MeetingType){
		$scope.viewMeetingType = MeetingType;
	};
	
	$scope.editSelectedMeetingType = function(MeetingType){
		$scope.editedMeetingType = angular.copy(MeetingType);
	};
	
	$scope.dtlSelectedMeetingType = function(MeetingType){
		$scope.MeetingTypeToBeDeleted = MeetingType;
	};
	
	$scope.addNewMeetingType = function(){
		$scope.deleteData = false;
		$scope.updateData = false;
		if($scope.addForm.$valid){
			$scope.newMeetingType.regBy = $scope.UserID;
			$http.post("/visitor-Management-System/Admin/addMeeting", $scope.newMeetingType).then(function mySuccess(response){
				if(response.data.data == "Exist"){
					$scope.dataExist = true;
				}else{
					$scope.dataExist = false;
				}
				
				$('#addNewMeetingTypeModal').modal('hide');
				$('#notificationModal').modal('show');
			}, function myError(data){
				console.log("some internal error");
				console.log(data);
			});
		}
	};
	
	$scope.notiClose = function(){
		$( "#Loader" ).modal("show");
		$('#dataTable').DataTable().clear().destroy();
		$scope.viewAllMeetingType();
	};
	
	$scope.editMeetingType = function(){
		$scope.deleteData = false;
		$scope.updateData = false;
		if($scope.editForm.$valid){
			$http.post("/visitor-Management-System/Admin/updateMeeting", $scope.editedMeetingType).then(function mySuccess(response){
				$('#editMeetingTypeModal').modal('hide');
				$scope.updateData = true;
				$('#notificationModal').modal('show');
			}, function myError(data){
				console.log("some internal error");
				console.log(data);
			});
		}
	};
	
	$scope.deleteMeetingType = function(){
		$scope.deleteData = false;
		$scope.updateData = false;
		$scope.MeetingTypeToBeDeleted.regBy = $scope.UserID;
		$http.post("/visitor-Management-System/Admin/deleteMeeting", $scope.MeetingTypeToBeDeleted).then(function mySuccess(response){
			$scope.deleteData = true;
			$('#notificationModal').modal('show');
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
});