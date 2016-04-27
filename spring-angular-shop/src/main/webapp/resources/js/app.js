'use strict';

var shopApp = angular.module('shopApp', ['ngRoute']);

shopApp.config(['$routeProvider', function ($routeProvider) {

	$routeProvider.when('/', {
        templateUrl: 'resources/html/product.html',
        controller: ProductController
    });
	
    $routeProvider.when('/cart', {
        templateUrl: 'resources/html/cart.html',
        controller: CartController
    });

    $routeProvider.when('/product', {
        templateUrl: 'resources/html/product.html',
        controller: ProductController
    });

    $routeProvider.otherwise({redirectTo: '/cart'});
    
}]);