var app = angular.module('myApp', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/login',{
            templateUrl: '/visitor-Management-System/index.html',
            controller: 'loginController'
        }).when('/secDashboard',{
            templateUrl: '/visitor-Management-System/security-dashboard.html',
            controller: 'dashboardController'
        }).when('/employeeDashboard',{
            templateUrl: '/visitor-Management-System/dashboard.html',
            controller: 'dashboardController'
        }).when('/superAdminDashboard',{
            templateUrl: '/visitor-Management-System/superAdminDashboard.html',
            controller: 'dashboardController'
        }).when('/ViewAllPlants',{
            templateUrl: '/visitor-Management-System/manage-plant-view-all.html',
            controller: 'managePlantController'
        }).when('/ViewAllDepartment',{
            templateUrl: '/visitor-Management-System/department-master-view-all.html',
            controller: 'manageDeptController'
        }).when('/ViewAllEmployee',{
            templateUrl: '/visitor-Management-System/employee-master-view-all.html',
            controller: 'manageEmployeeController'
        }).when('/ViewAllMeetingType',{
            templateUrl: '/visitor-Management-System/meeting-type-master-view-all.html',
            controller: 'manageMeetingTypeController'
        }).when('/ManageContact',{
            templateUrl: '/visitor-Management-System/manage-contact-view-all.html',
            controller: 'manageContactController'
        }).when('/addContact',{
            templateUrl: '/visitor-Management-System/manage-contact-add-new.html',
            controller: 'manageContactController'
        }).when('/editContact',{
            templateUrl: '/visitor-Management-System/manage-contact-edit.html',
            controller: 'manageContactEditController'
        }).when('/viewAllVisit',{
            templateUrl: '/visitor-Management-System/todays-visits-listing.html',
            controller: 'manageVisitController'
        }).when('/addVisit',{
            templateUrl: '/visitor-Management-System/manage-visits-add-new.html',
            controller: 'manageVisitController'
        }).when('/securityCheckOut',{
            templateUrl: '/visitor-Management-System/personcheck-out.html',
            controller: 'securityController'
        }).when('/securityCheckIn',{
            templateUrl: '/visitor-Management-System/personcheck-in.html',
            controller: 'securityController'
        }).when('/empReportVisitedReport',{
            templateUrl: '/visitor-Management-System/employee-report-for-visited-visitor.html',
            controller: 'reportController'
        }).when('/empReportCancelReport',{
            templateUrl: '/visitor-Management-System/employee-report-for-cancelled-visitor.html',
            controller: 'reportController'
        }).when('/profile',{
            templateUrl: '/visitor-Management-System/manage_Profile.html'
        }).when('/settings',{
            templateUrl: '/visitor-Management-System/manage-Settings.html'
        });
});
app.directive('fileModel', ['$parse', function ($parse) {
    return {
       restrict: 'A',
       link: function(scope, element, attrs) {
          var model = $parse(attrs.fileModel);
          var modelSetter = model.assign;
          
          element.bind('change', function() {
             scope.$apply(function() {
                modelSetter(scope, element[0].files[0]);
             });
          });
       }
    };
 }]);

app.controller('indexController', function($scope, $rootScope, $http) {
	
	$rootScope.UserName = window.localStorage.getItem("userName");
	$scope.role = window.localStorage.getItem("loginRole");
	$scope.loginId = window.localStorage.getItem("loginDetails");
	$scope.page = window.localStorage.getItem("pagePosition");
	$scope.reportType = '';
	
	
	if($rootScope.UserName == undefined || $rootScope.UserName == null ){
		window.location = "/visitor-Management-System/index.html";
	}else{
		$http.post("/visitor-Management-System/Employee/GetLoggedInDetails",$scope.loginId).then(function mySuccess(response){
			$rootScope.emp = response.data;
			if("FromLoginPage" == $scope.page){
				if($scope.role == "Security"){
					window.location = "#!secDashboard";
				}else if($scope.role == "Super Admin"){
					window.location = "#!superAdminDashboard";
				}else{
					window.location = "#!employeeDashboard";
				}
			}
			console.log("in indexController");
		}, function myError(data){
			console.log("some internal error");
			console.log(data);
		});
		
	}																											
	$scope.logoutUser = function(){
		window.localStorage.removeItem("loginDetails");
		window.localStorage.removeItem("loginRole");
		window.localStorage.removeItem("userName");
		window.localStorage.removeItem("pagePosition");
		window.location.href  = "/visitor-Management-System/index.html";
	};
	
	$scope.navToDashboard = function(){
		if($scope.role == "Security"){
			window.location = "#!secDashboard";
		}else if($scope.role == "Super Admin"){
			window.location = "#!superAdminDashboard";
		}else{
			window.location = "#!employeeDashboard";
		}
	};
	
});