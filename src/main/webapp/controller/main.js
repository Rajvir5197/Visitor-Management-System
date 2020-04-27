var app = angular.module('myApp', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/login',{
            templateUrl: '/login.php',
            controller: 'loginController'
        })
        .when('/dashboard',{
            templateUrl: '/dashboard.html',
            controller: 'dashboardController'
        })
        .when('/ViewAllPlants',{
            templateUrl: '/manage-plant-view-all.html',
            controller: 'managePlantController'
        })
        .when('/ViewAllDepartment',{
            templateUrl: '/department-master-view-all.html',
            controller: 'manageDeptController'
        }).when('/ViewAllEmployee',{
            templateUrl: '/employee-master-view-all.html',
            controller: 'manageEmployeeController'
        }).when('/ManageContact',{
            templateUrl: '/manage-contact-view-all.html',
            controller: 'manageContactController'
        }).when('/addContact',{
            templateUrl: '/manage-contact-add-new.html',
            controller: 'manageContactController'
        }).when('/editContact',{
            templateUrl: '/manage-contact-edit.html',
            controller: 'manageContactEditController'
        }).when('/viewAllVisit',{
            templateUrl: '/todays-visits-listing.html',
            controller: 'manageVisitController'
        }).when('/addVisit',{
            templateUrl: '/manage-visits-add-new.html',
            controller: 'manageVisitController'
        });
});

app.controller('indexController', function($scope, $rootScope, $http) {
	
	$rootScope.UserName = window.localStorage.getItem("loginDetails");
	
	if($rootScope.UserName == undefined || $rootScope.UserName == null ){
		window.location = "login.html";
	}else{
		window.location = "#!dashboard";
	}																											
	$scope.logoutUser = function(){
		window.localStorage.removeItem("loginDetails");
		window.location.href  = "login.html";
	}
});