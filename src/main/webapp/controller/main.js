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
        .when('/manage-visits-add-new',{
            templateUrl: '/manage-visits-add-new.php'
        })
        .when('/manage-contact-add-new',{
            templateUrl: '/manage-contact-add-new.php'
        })
        .when('/manage-contact-edit',{
            templateUrl: '/manage-contact-edit.php'
        })
        .when('/manage-contact-view-all',{
            templateUrl: '/manage-contact-view-all.php'
        })
        .when('/manage-plant-add-new',{
            templateUrl: '/manage-plant-add-new.php'
        })
        .when('/manage-plant-edit',{
            templateUrl: '/manage-plant-edit.php'
        })
        .when('/ViewAllPlants',{
            templateUrl: '/manage-plant-view-all.html',
            controller: 'managePlantController'
        })
        .when('/manage-visits-view-all',{
            templateUrl: '/manage-visits-view-all.php'
        })
        .when('/personcheck-out',{
            templateUrl: '/personcheck-out.php'
        })
        .when('/security-dashboard',{
            templateUrl: '/security-dashboard.php'
        })
        .when('/todays-visits-listing',{
            templateUrl: '/todays-visits-listing.php'
        });
});

app.controller('indexController', function($scope, $rootScope, $http, $rootScope) {
	
	if($rootScope.formlogin == 0){

	}else{
		window.location = "#!dashboard";
	}
	
});