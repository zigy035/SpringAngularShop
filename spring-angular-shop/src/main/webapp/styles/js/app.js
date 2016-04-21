'use strict';

var shopApp = angular.module('shopApp', ['ngRoute']);

shopApp.config(['$routeProvider', function ($routeProvider) {
	
    $routeProvider.when('/cart', {
        templateUrl: 'html/cart/layout.html',
        controller: CartController
    });

    $routeProvider.when('/product', {
        templateUrl: 'html/product/layout.html',
        controller: ProductController
    });

    $routeProvider.otherwise({redirectTo: '/cart'});
    
}]);