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
  })
  .when('/:id', {
    templateUrl: 'detailedview.html',
    controller: 'detailedViewController',
    title: 'Detailed View'
  });
});

trmsApp.controller('mainController', function($scope) {
  $scope.message = "Welcome to your dashboard, please select an option from the menu at the top of the page.";
});

trmsApp.controller('newReqController', function($scope) {
  $scope.message = "To create a new reimbursment request, please fill out the form completely.";
});

trmsApp.controller('viewReqController', function($scope) {
  displayReimb(reimbursements);
  $scope.message = "Your reimbursement requests: "
});

trmsApp.controller('detailedViewController', function($scope) {
  let pageId = window.location.hash.split('/')[1];

  let button = document.getElementById("backButton");
  button.addEventListener("click", function() {
	  window.location.hash = "viewrequests"
  });

  let accept = document.getElementById('approve');
  accept.addEventListener('click', function() {
    let xhr = new XMLHttpRequest();
    let reason = document.getElementById('approveRejectReason').value;
    let params = "reason="+reason+"&reimbId="+reimbId;

    xhr.open('POST', 'http://localhost:5252/TRMS/ApproveRequestServlet');

    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

    xhr.onreadystatechange = function() {
      if (xhr.readyState === 4 && xhr.status === 200) {
        alert('Request Approved');
      }
    }
    xhr.send(params);
  });

  let reject = document.getElementById('reject');
  reject.addEventListener('click', function() {
    let xhr = new XMLHttpRequest();
    let reason = document.getElementById('approveRejectReason').value;
    let params = "reason="+reason+"&reimbId="+reimbId;

    xhr.open('POST', 'http://localhost:5252/TRMS/RejectRequestServlet');

    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');

    xhr.onreadystatechange = function() {
      if (xhr.readyState === 4 && xhr.status === 200) {
        alert('Request Denied');
      }
    }
    xhr.send(params);
  });

  let reimbId = reimbursements[pageId].reimbursementId;
  $scope.employeeId = reimbursements[pageId].employeeId;
  $scope.eventType = reimbursements[pageId].eventTypeId;
  $scope.description = reimbursements[pageId].description;
  $scope.location = reimbursements[pageId].location;
  $scope.justification = reimbursements[pageId].justification;
  $scope.startDate = reimbursements[pageId].eventStartDate;
  $scope.gradingFormat = reimbursements[pageId].gradeFmtId;
  $scope.eventCost = reimbursements[pageId].eventCost;
  $scope.amountReimbursed = reimbursements[pageId].reimbursementAmount;
  $scope.submissionDate = reimbursements[pageId].requestSubmissionDate;
  $scope.timeMissed = reimbursements[pageId].workTimeMissed;
  $scope.approvalStatus = reimbursements[pageId].approvalStatus;
  $scope.additionalDetails = reimbursements[pageId].additionalComments;
});
