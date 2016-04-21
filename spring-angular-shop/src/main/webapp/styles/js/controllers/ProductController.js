'use strict';

var ProductController = function($scope, $http) {
	
	$scope.loadProducts = function() {	
		$http({method: 'GET', url: "product"}).
		then(function(response) {
			console.log('All products!!!');
			$scope.products = response.data;
		});
	};
	
	$scope.addCartItem = function(cartId, productId) {
		$http({method: 'POST', url: "cart/add/" +  cartId + "/" + productId}).
		then(function(response) {
			$scope.loadCartData("CART1");
		});
    };
	
	$scope.loadProducts();
	
};