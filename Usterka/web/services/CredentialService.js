/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

'use strict';
var app = angular.module('myApp', []);
app.factory('CredentialService',['$rootScope', '$modal', 'authService', '$http', '$cookies','$q',
        function ($rootScope, $modal, authService, $http, $cookies, $q) {
        

        return {
            login: function (username, password) {
                var auth = { "username": username, "password": password };
                //return $http.post("../Servlets/login", auth, { ignoreAuthModule: true }).success(function (auth) {
                    $cookies.username = username;
                    authService.loginConfirmed();
                //});
            },
            logout: function (username, password) {
            						document.execCommand("ClearAuthenticationCache");
                return $http.get("../Servlets/logout").success(function () {
                    delete $cookies.username;
                    authService.loginRequired();
                    $(".main-menu").hide(); 
                    $(".main-container").hide();
                    $("#body").css("background-color","#FFFFCC");
                });
            },
            getUsername: function(){
            	
    			var deferred = $q.defer();
    			$http.get('../Servlets/getlogin').success(function(result) {
    				
    				deferred.resolve(result);
    				
    				
    			}).error(function(result) {
    				console.log(result);
    			});
    			 
    			return deferred.promise;
    		}
            
        };
    }]);
