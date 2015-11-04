'use strict';
var app = angular.module('myApp', []);
app.controller('mainMenuCtrl', ['$scope', 'CredentialService', 
    function($scope, CredentialService) {
    
        $scope.name;
        $scope.password;
    
    	CredentialService.getUsernameAndPassword().then(function (res) {
            $scope.list = res;
            
        });

        $scope.login = function () {
           var i = 0;
           while($scope.list[i]){
            if( $scope.list[i][0] === $scope.name && $scope.list[i][1] === $scope.password){
                alert("zalogowan");
            }
            
            
            i++;
            }
        };
    
}]);