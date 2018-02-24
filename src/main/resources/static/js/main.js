var app = angular.module("registryOfProhibitedSites", []);

app.controller("AppCtrl", function ($scope, $http) {
    $scope.registry = [];

    $http.get('http://localhost:8080/start').success(function (data) {
        $scope.registry = data;
    });
});

app.controller("AddSiteController", function ($scope, $http) {
    $scope.addSite = function (link, ip, date) {
        $http.put('http://localhost:8080/add?link=' + link + '&ip=' + ip + '&date=' + date, $scope.registry);
        location.reload();
    }
});