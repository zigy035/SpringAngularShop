var shopApp = angular.module('shopApp', []);
shopApp.controller('cartController', function($scope, $http) {
	
	function loadCartData(cartId) {	
		$http({method: 'GET', url: baseURL + "/cart/" + cartId}).
		then(function(response) {
			$scope.cartData = response.data;
		});
	};
	
	// This should be a part of Product Controller (after ng-view is implemented)
	function loadProductData() {	
		$http({method: 'GET', url: baseURL + "/cart/products"}).
		then(function(response) {
			$scope.products = response.data;
		});
	};
	
	$scope.addCartItem = function(cartId, productId) {
		$http({method: 'POST', url: baseURL + "/cart/add/" +  cartId + "/" + productId}).
		then(function(response) {
			loadCartData("CART1");
		});
    };
	
	$scope.updateCartItem = function(itemId, quantity) {
		$http({method: 'PUT', url: baseURL + "/cart/update/" +  itemId + "/" + quantity}).
		then(function(response) {
			loadCartData("CART1");
		},
		function(error) {
			console.log(error);
			loadCartData("CART1");
		});
    };
    
    $scope.deleteCartItem = function(itemId) {
		$http({method: 'DELETE', url: baseURL + "/cart/delete/" +  itemId}).
		then(function(response) {
			loadCartData("CART1");
		});
    };
	
	loadCartData("CART1");
	loadProductData();
});

/*
shopApp.controller('productController', function($scope, $http) {
	
	function loadProducts() {	
		$http({method: 'GET', url: baseURL + "/product"}).
		then(function(response) {
			console.log(response);
			$scope.products = response.data;
		});
	};
	
	loadProducts();
});
*/
