/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

'use strict';

angular.module('myApp').factory('CredentialService',[ '$http', '$q',
        function (  $http, $q) {
            
        return {
            
            //TO DO - przechowywanie cred. w cookies
           // login: function (username, password) {
           //     var auth = { "username": username, "password": password };
            
            //        $cookies.username = username;
            //        authService.loginConfirmed();
                //});
           // },
            //logout: function (username, password) {
            //						document.execCommand("ClearAuthenticationCache");
            //    return $http.get("../Servlets/logout").success(function () {
            //        delete $cookies.username;
            //        authService.loginRequired();
            //        $(".main-menu").hide(); 
            //        $(".main-container").hide();
             //       $("#body").css("background-color","#FFFFCC");
           //     });
           // },
            getUsernameAndPassword: function(){
            	
    			var deferred = $q.defer();
    			$http.get('Servlets/autentificationServlet').success(function(result) {
    				
    				deferred.resolve(result);
    				
    				
    			}).error(function(result) {
    				console.log(result);
    			});
    			
    			return deferred.promise;
    		}
            
        };
    }]);
