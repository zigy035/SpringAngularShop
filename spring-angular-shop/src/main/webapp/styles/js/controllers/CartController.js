'use strict';

var CartController = function($scope, $http) {
	
	$scope.loadCartData = function() {	
		$http({method: 'GET', url: "cart"}).
		then(function(response) {
			console.log('Cart data!!!');
			$scope.cartData = response.data;
		});
	};

    $scope.updateCartItem = function(itemId, quantity) {
		$http({method: 'PUT', url: "cart/update/" +  itemId + "/" + quantity}).
		then(function(response) {
			$scope.loadCartData("CART1");
		},
		function(error) {
			console.log(error);
			$scope.loadCartData("CART1");
		});
    };

    $scope.deleteCartItem = function(itemId) {
		$http({method: 'DELETE', url: "cart/delete/" +  itemId}).
		then(function(response) {
			$scope.loadCartData("CART1");
		});
    };

    $scope.loadCartData();
    
};