app.controller('manageVisitController', function($scope, $rootScope, $http) {
	
	$scope.UserID = window.localStorage.getItem("loginDetails");
	$scope.role = window.localStorage.getItem("loginRole");
	$scope.userName = window.localStorage.getItem("userName");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "/visitor-Management-System/index.html";
	}
	
	$( "#datepicker" ).datepicker({
		format: 'YYYY/MM/DD'
	});
	$("#datepicker").on("change", function() {

		if($scope.newVisit == undefined){
			$scope.newVisit = {
					meetingBooked:{
							visitDate:$("#datepicker").val()
					}
			};
		}else{
			$scope.newVisit.meetingBooked.visitDate = $("#datepicker").val();
		}
		

    });
	
	
	$('.clockpicker').clockpicker()
	.find('input').change(function(){
		console.log(this.value);
		if($scope.newVisit == undefined){
			$scope.newVisit = {
					meetingBooked:{
						visitTime:this.value + ":00"
					}
			};
		}else{
			$scope.newVisit.meetingBooked.visitTime = this.value + ":00";
		}
	});
	var input = $('#single-input').clockpicker({
		placement: 'bottom',
		align: 'left',
		autoclose: true,
		'default': 'now'
	});

	$('.clockpicker-with-callbacks').clockpicker({
		donetext: 'Done',
		init: function() { 
			console.log("colorpicker initiated");
		},
		beforeShow: function() {
			console.log("before show");
		},
		afterShow: function() {
			console.log("after show");
		},
		beforeHide: function() {
			console.log("before hide");
		},
		afterHide: function() {
			console.log("after hide");
		},
		beforeHourSelect: function() {
			console.log("before hour selected");
		},
		afterHourSelect: function() {
			console.log("after hour selected");
		},
		beforeDone: function() {
			console.log("before done");
		},
		afterDone: function() {
			console.log("after done");
		}
	})
	.find('input').change(function(){
		console.log(this.value);
	});

	// Manually toggle to the minutes view
	$('#check-minutes').click(function(e){
		// Have to stop propagation here
		e.stopPropagation();
		input.clockpicker('show')
				.clockpicker('toggleView', 'minutes');
	});
	if (/mobile/i.test(navigator.userAgent)) {
		$('input').prop('readOnly', true);
	}


	$scope.allVisits = [];
	$scope.invalidMobile = false;
	$scope.invalidDate = false;
	$scope.invalidTime = false;
	$scope.viewAllVisits = function(){
		$scope.param = {
				empCode: $scope.UserID,
				empRole: $scope.role
		};
		$http.post("/visitor-Management-System/Employee/viewAllVisits",$scope.param).then(function mySuccess(response){
			console.log(response.data);
			$scope.allVisits = response.data;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.viewEmpPlant = function(){
		$scope.param = {
				empCode: $scope.UserID,
				empRole: $scope.role
		};
		$http.post("/visitor-Management-System/Employee/getEmpPlant",$scope.param).then(function mySuccess(response){
			$scope.EmpPlants = response.data.empPlantCode;
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.viewAllVisits();
	$scope.viewEmpPlant();
	
	$scope.addNewVisit = function(){
		$scope.invalidMobile = false;
		$scope.invalidDate = false;
		$scope.invalidTime = false;
		if($scope.addForm.$valid){
			if(!isNaN($scope.newVisit.meetingBooked.visitor.contactNumber) && angular.isNumber(+$scope.newVisit.meetingBooked.visitor.contactNumber)){
				var todayDate = new Date();
				todayDate.setHours(0,0,0,0)
				$scope.newVisit.meetingBooked.visitDate = new Date($scope.newVisit.meetingBooked.visitDate);
				if($scope.newVisit.meetingBooked.visitDate < todayDate){
					$scope.invalidDate = true;
				}else{
					
					var visTime = new Date();
					visTime.setHours($scope.newVisit.meetingBooked.visitTime.substring(0, 2), $scope.newVisit.meetingBooked.visitTime.substring(3, 5), 0, 0);
					var todayTime = new Date();
					if(visTime < todayTime){
						$scope.invalidTime = true;
					}else{
						$scope.newVisit.createdBy = $scope.UserID;
						$scope.newVisit.lastUpdatedBy = $scope.UserID;
						$scope.newVisit.meetingBooked.empId = $scope.UserID;
						$scope.newVisit.meetingBooked.empName = $scope.userName;
						$http.post("/visitor-Management-System/Employee/addNewVisit", $scope.newVisit).then(function mySuccess(response){
							if(response.data.msg == "SUCCESS"){
								window.location.href  = "#!viewAllVisit";
							}
						}, function myError(data){
							console.log("some internal error");
							console.log(data);
						});
					}
				}
			}else{
				$scope.invalidMobile = true;
			}
		}
	};
	
	$scope.empCheckIn = function(visits){
		visits.lastUpdatedBy = $scope.UserID;
		$http.post("/visitor-Management-System/Employee/empCheckIn", visits).then(function mySuccess(response){
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
		$scope.selectedVisit.meetingBooked.remarks = '';
		
	};
	
	$scope.empCheckOut = function(){
		$scope.selectedVisit.lastUpdatedBy = $scope.UserID;
		$http.post("/visitor-Management-System/Employee/empCheckOut", $scope.selectedVisit).then(function mySuccess(response){
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
		$http.post("/visitor-Management-System/Employee/cancelVisit", $scope.selectedCancelVisit).then(function mySuccess(data){
			console.log("data deleted");
			$scope.viewAllVisits();
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
});