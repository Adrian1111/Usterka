'use strict';
var app = angular.module('myApp', []);
app.controller('mainMenuCtrl', ['$scope', 'CredentialService', 
    function($scope, CredentialService) {
    
        $scope.name;
        $scope.password;
    
    	CredentialService.getUsernameAndPassword().then(function (res) {
            $scope.list = res.ArrayList;
            alert(res);
        });

        $scope.login = function () {
           // if($scope.name)
            alert("zalogowan");
        };
    
}]);