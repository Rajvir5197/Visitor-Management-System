app.controller('securityController', function($scope, $rootScope, $http) {
	
	$scope.UserID = window.localStorage.getItem("loginDetails");
	
	if($scope.UserID == undefined || $scope.UserID == null ){
		window.location = "/visitor-Management-System/index.html";
	};
	
	if($rootScope.visitCheckin == undefined || $rootScope.visitCheckin == null){
		window.location = "#!dashboard";
	};
	
	
	
	Webcam.attach( '#my_camera' );
	$scope.viewAllCoVisitor = function(){
		$http.post("/visitor-Management-System/Security/viewAllCoVisitor", $rootScope.visitCheckin).then(function mySuccess(response){
			console.log(response.data);
			$scope.allCoVisitor = response.data;
			if($scope.allCoVisitor.length > 0){
				angular.forEach($scope.allCoVisitor,function(coVisitor){
					coVisitor.allowCheckOut = true;
					$http.post("/visitor-Management-System/Security/getAllAsset", coVisitor).then(function mySuccess(response){
						angular.forEach(response.data,function(asset){
							if(!asset.deliveredFlag){
								coVisitor.allowCheckOut = false;
							};
						});
					}, function myError(data){
						console.log("some internal error");
						console.log(data);
					});
				});
			}
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	
	};
	$scope.viewAllCoVisitor();
	
	$scope.addCoVistor = function(){
		$scope.invalidMobile = false;
		if($scope.addForm.$valid){
			if(!isNaN($scope.newVisitor.coVisitorContact) && angular.isNumber(+$scope.newVisitor.coVisitorContact)){
				$scope.newVisitor.secCheckin = true;
				$scope.newVisitor.visitor = $rootScope.visitCheckin.meetingBooked.visitor;
				$scope.newVisitor.createdBy = $scope.UserID;
				$http.post("/visitor-Management-System/Security/addCoVisitor", $scope.newVisitor).then(function mySuccess(response){
					$('#addCoVisitorModal').modal('hide');
					$scope.viewAllCoVisitor();
					console.log(response.data);
				}, function myError(data){
					console.log("some internal error");
					console.log(data);
				});
			}else{
				$scope.invalidMobile = true;
			};
			
		}else{
			if(!isNaN($scope.newVisitor.coVisitorContact) && !angular.isNumber(+$scope.newVisitor.coVisitorContact)){
				$scope.invalidMobile = true;
			};
		};
	};
	
	$scope.getCovisitorAsset = function(selectedCoVisitor){
		$scope.selectedCoVisitor = selectedCoVisitor;
		$http.post("/visitor-Management-System/Security/getAllAsset", selectedCoVisitor).then(function mySuccess(response){
			$scope.allAsset = response.data;
			$scope.newAsset={};
			//$('#viewAssetModal').show();
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	}
	
	$scope.addAsset = function(){
		$scope.newAsset.assetStatus = "Not Delivered";
		$scope.newAsset.deliveredFlag = false;
		$scope.newAsset.visitor = $scope.selectedCoVisitor;
		$http.post("/visitor-Management-System/Security/addCoVisitorAsset", $scope.newAsset).then(function mySuccess(response){
			if(response.data.msg == "SUCCESS"){
				$scope.getCovisitorAsset($scope.selectedCoVisitor);
			}
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.deliverAsset = function(asset){
		asset.assetStatus = "Delivered";
		asset.deliveredFlag = true;
		$http.post("/visitor-Management-System/Security/addCoVisitorAsset", asset).then(function mySuccess(response){
			if(response.data.msg == "SUCCESS"){
				$scope.getCovisitorAsset($scope.selectedCoVisitor);
			}
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
	};
	
	$scope.selectedCoVisitorForCheckout = function(selectedCoVisitor){
		$scope.selectedCoVisitor = selectedCoVisitor;
		/*if($scope.selectedCoVisitor.seccheckout){
			alert('already checked out')
		}else{
			$('#checkoutModal').show();
		}*/
	}
	
	$scope.checkoutCoVisitor = function(){
		$scope.selectedCoVisitor.seccheckout = true;
		$http.post("/visitor-Management-System/Security/addCoVisitor", $scope.selectedCoVisitor).then(function mySuccess(response){
			$('#checkoutModal').modal('hide');
			$scope.viewAllCoVisitor();
			console.log(response.data);
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
		
	};
	
	$scope.take_snapshot = function() {
		 
		 // take snapshot and get image data
		 Webcam.snap( function(data_uri) {
		  // display results in page
			$scope.visitorImg = data_uri;
		  document.getElementById('results').innerHTML = 
		  '<img src="'+data_uri+'"/>';
		  } );
		};
	
	$scope.saveVisitorImage = function(){
		
		if($scope.visitorImg != null && $scope.visitorImg != undefined){
			$scope.image = [];
			$scope.image = $scope.visitorImg.split(",");
			$rootScope.visitCheckin.meetingBooked.visitor.visitorImage = $scope.image[1];
			$http.post("/visitor-Management-System/Security/addVisitorImage", $rootScope.visitCheckin).then(function mySuccess(response){
				$('#captureImageModal').modal('hide');
			}, function myError(data){
				console.log("some internal error");
				console.log(data);
			});
		}
	}
	
});