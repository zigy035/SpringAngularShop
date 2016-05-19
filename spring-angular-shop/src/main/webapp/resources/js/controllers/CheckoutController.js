'use strict';

var checkoutApp = angular.module('checkoutApp', ['ngCookies', 'ngDialog']);
checkoutApp.controller('checkoutController', function($scope, $http, $cookieStore, ngDialog) {

	$scope.loadPaymentAddress = function() {	
		$http({method: 'GET', url: "checkout/rest/billing-address"}).
		then(function(response) {
			console.log(response);
			$scope.billingAddress = response.data;
		});
	};

	$scope.loadDeliveryAddress = function() {	
		$http({method: 'GET', url: "checkout/rest/shipping-address"}).
		then(function(response) {
			console.log(response);
			$scope.shippingAddress = response.data;
		});
	};
	
	$scope.loadCheckoutCartData = function() {	
		$http({method: 'GET', url: "checkout/rest/cart"}).
		then(function(response) {
			console.log('Checkout Cart data!!!');
			console.log(response.data);
			
			$scope.cartItems = response.data.items;
			$scope.subtotal = response.data.subtotal;
			$scope.deliveryCost = response.data.deliveryCost;
			$scope.total = response.data.total;
		});
	};
	
	$scope.updateDeliveryCost = function(deliveryType) {
		$http({method: 'GET', url: "checkout/rest/update-delivery-cost/" + deliveryType}).
		then(function(response) {
			console.log('Cart data updated!!!');
			console.log(response.data);
			
			$scope.deliveryCost = response.data.deliveryCost;
			$scope.total = response.data.total;
		});
	};
	
	$scope.editAddress = function(addressId) {
		
		$http({method: 'GET', url: "checkout/rest/edit-address/" + addressId}).
		then(function(response) {
			
			$scope.countries = response.data.countries;
			$scope.regions = response.data.regions;
			
			$scope.address = {
				addressId : response.data.address.id,
				addressLine : response.data.address.addressLine,
				countryIso : response.data.address.countryIso,
				regionIso : response.data.address.regionIso,
				city : response.data.address.city,
				postcode : response.data.address.postcode,
				phone : response.data.address.phone
			};
			
	        ngDialog.open({
	        	template: 'checkoutEditAddress',
	        	className: 'ngdialog-theme-default',
	        	width: 360,
	        	scope: $scope
	        });
		});
		
    };
    
    $scope.updateAddress = function() {    	
		$http({
			method: 'POST', 
			url: "checkout/rest/update-address", 
			data: {
				id : $scope.address.addressId,
	    		addressLine : $scope.address.addressLine,
	    		countryIso : $scope.address.countryIso,
	    		regionIso : $scope.address.regionIso,
	    		city : $scope.address.city,
	    		postcode : $scope.address.postcode,
	    		phone : $scope.address.phone
	        }, 
		}).then(function(response) {
			
			console.log(response.data);
			
			ngDialog.close();

			if (response.data.shippingAddress) {
				console.log('Shipping!');
				$scope.shippingAddress = response.data;
			}
			
			if (response.data.billingAddress) {
				console.log('Billing!');
				$scope.billingAddress = response.data;
			}
		});
    };
    
	$scope.loadCountries = function() {	
		$http({method: 'GET', url: "address-rest/countries"}).
		then(function(response) {

			console.log("Countries:" + response.data);
			$scope.countries = response.data;
			
			var country = $cookieStore.get('country');
			
			if (country != null) {
				$scope.country = country;
				$scope.loadRegions(country);
			} else {
				$scope.country = '';
			}
			
		});
	};
	
	$scope.loadRegions = function(country) {	
		if (country != 'US' && country != 'CA') {
			$scope.country = '';
			$scope.regions = null;
			$scope.region = '';
			
			$cookieStore.remove('country');
			$cookieStore.remove('region');
			
		} else {
			$http({method: 'GET', url: "address-rest/regions/" + country}).
			then(function(response) {
				
				var region = $cookieStore.get('region');
				if (region != null) {
					$scope.address.region = region;
				} else {
					$scope.address.region = '';
				}
				
				$cookieStore.put('country', country);
				$scope.regions = response.data;
			});
		}
	};
    
	$scope.loadPaymentAddress();
	$scope.loadDeliveryAddress();
	$scope.loadCheckoutCartData();
	
});