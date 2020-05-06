var app = angular.module('myApp', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/login',{
            templateUrl: '/VisitorManagementSystem-0.0.1-SNAPSHOT/login.html',
            controller: 'loginController'
        }).when('/secDashboard',{
            templateUrl: '/VisitorManagementSystem-0.0.1-SNAPSHOT/security-dashboard.html',
            controller: 'dashboardController'
        }).when('/employeeDashboard',{
            templateUrl: '/VisitorManagementSystem-0.0.1-SNAPSHOT/dashboard.html',
            controller: 'dashboardController'
        }).when('/ViewAllPlants',{
            templateUrl: '/VisitorManagementSystem-0.0.1-SNAPSHOT/manage-plant-view-all.html',
            controller: 'managePlantController'
        }).when('/ViewAllDepartment',{
            templateUrl: '/VisitorManagementSystem-0.0.1-SNAPSHOT/department-master-view-all.html',
            controller: 'manageDeptController'
        }).when('/ViewAllEmployee',{
            templateUrl: '/VisitorManagementSystem-0.0.1-SNAPSHOT/employee-master-view-all.html',
            controller: 'manageEmployeeController'
        }).when('/ManageContact',{
            templateUrl: '/VisitorManagementSystem-0.0.1-SNAPSHOT/manage-contact-view-all.html',
            controller: 'manageContactController'
        }).when('/addContact',{
            templateUrl: '/VisitorManagementSystem-0.0.1-SNAPSHOT/manage-contact-add-new.html',
            controller: 'manageContactController'
        }).when('/editContact',{
            templateUrl: '/VisitorManagementSystem-0.0.1-SNAPSHOT/manage-contact-edit.html',
            controller: 'manageContactEditController'
        }).when('/viewAllVisit',{
            templateUrl: '/VisitorManagementSystem-0.0.1-SNAPSHOT/todays-visits-listing.html',
            controller: 'manageVisitController'
        }).when('/addVisit',{
            templateUrl: '/VisitorManagementSystem-0.0.1-SNAPSHOT/manage-visits-add-new.html',
            controller: 'manageVisitController'
        }).when('/securityCheckOut',{
            templateUrl: '/VisitorManagementSystem-0.0.1-SNAPSHOT/personcheck-out.html',
            controller: 'securityController'
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
	
	$rootScope.UserName = window.localStorage.getItem("loginDetails");
	$scope.role = window.localStorage.getItem("loginRole");
	
	if($rootScope.UserName == undefined || $rootScope.UserName == null ){
		window.location = "/VisitorManagementSystem-0.0.1-SNAPSHOT/login.html";
	}else{
		if($scope.role == "Security"){
			window.location = "#!secDashboard";
		}else{
			window.location = "#!employeeDashboard";
		}
	}																											
	$scope.logoutUser = function(){
		window.localStorage.removeItem("loginDetails");
		window.localStorage.removeItem("loginRole");
		window.location.href  = "/VisitorManagementSystem-0.0.1-SNAPSHOT/login.html";
	};
	
	$scope.navToDashboard = function(){
		if($scope.role == "Security"){
			window.location = "#!secDashboard";
		}else{
			window.location = "#!employeeDashboard";
		}
	};
});