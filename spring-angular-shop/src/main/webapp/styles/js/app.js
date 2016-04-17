var cartApp = angular.module('cartApp', []);
cartApp.controller('cartController', function($scope, $http) {
	
	function loadCartData(cartId) {	
		$http.get(baseURL + "/cart/" + cartId).then(function(response) {
			$scope.cartData = response.data;
		});
	};
	
	$scope.updateCartItem = function(itemId, quantity){
		$http.put(baseURL + "/cart/update/" +  itemId + "/" + quantity).
		then(function(response) {
			loadCartData("CART1");
		});
    };
    
    $scope.deleteCartItem = function(itemId){
		$http.delete(baseURL + "/cart/delete/" +  itemId).
		then(function(response) {
			loadCartData("CART1");
		});
    };
	
	loadCartData("CART1");

});