'use strict';

var productApp = angular.module('productApp', []);
productApp.controller('productController', function($scope, $http) {

	$scope.loadProducts = function() {	
		$http({method: 'GET', url: "product-rest"}).
		then(function(response) {
			console.log(response);
			$scope.products = response.data;
		});
	};
	
	$scope.addCartItem = function(productId) {
		$http({method: 'POST', url: "cart-rest/add/" + productId}).
		then(function(response) {
			// Some indication needed here...
		});
    };
	
	$scope.loadProducts();
	
});