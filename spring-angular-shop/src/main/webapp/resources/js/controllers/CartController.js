'use strict';

var cartApp = angular.module('cartApp', []);
cartApp.controller('cartController', function($scope, $http) {
	
	$scope.loadCartData = function() {	
		$http({method: 'GET', url: "cart-rest"}).
		then(function(response) {
			console.log('Cart data!!!');
			$scope.cartData = response.data;
			
			// To be calculated...
			$scope.subtotal = 55;
			$scope.deliveryCost = 8;
			$scope.total = 63;
		});
	};

    $scope.updateCartItem = function(itemId, quantity) {
		$http({method: 'GET', url: "cart-rest/update/" +  itemId + "/" + quantity}).
		then(function(response) {
			$scope.loadCartData();
		},
		function(error) {
			console.log(error);
			$scope.loadCartData();
		});
    };

    $scope.deleteCartItem = function(itemId) {
		$http({method: 'GET', url: "cart-rest/delete/" +  itemId}).
		then(function(response) {
			$scope.loadCartData();
		});
    };

    $scope.loadCartData();
    
});