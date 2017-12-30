let trmsApp = angular.module("trmsApp", ['ngRoute']);

trmsApp.config(function($routeProvider) {
  $routeProvider
  .when('/', {
    templateUrl: 'home.html',
    controller: 'mainController',
    title: 'Dashboard'
  })

  .when('/newrequest', {
    templateUrl: 'newrequest.html',
    controller: 'newReqController',
    title: 'New Request'
  })

  .when('/viewrequests', {
    templateUrl: 'viewrequests.html',
    controller: 'viewReqController',
    title: 'Your Requests'
  });
});

trmsApp.controller('mainController', function($scope) {
  $scope.message = "Welcome to your dashboard, please select an option from the menu at the top of the page.";
});

trmsApp.controller('newReqController', function($scope) {
  $scope.message = "To create a new reimbursment request, please fill out the form completely.";
});

trmsApp.controller('viewReqController', function($scope) {
  $scope.message = "Your reimbursement requests: "
});
