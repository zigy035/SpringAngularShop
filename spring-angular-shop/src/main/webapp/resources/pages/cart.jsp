<h2>Cart</h2>
<div ng-app="cartApp" ng-controller="cartController">
		
	<table class="stripeMe sample" ng-show="cartData">
		<thead>
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Total</th>
			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="cartItem in cartData">
				<td>{{cartItem.productName}}</td>
				<td>{{cartItem.productPrice}}</td>
				<td>
					<input type="text" class="qty" ng-model="cartItem.quantity" 
						ng-blur="updateCartItem(cartItem.id, cartItem.quantity)"/>
					<br/>
					<a class="removeItem" href="javascript:void(0)" ng-click="deleteCartItem(cartItem.id)">Remove</a>
				</td>
				<td>{{cartItem.productPrice * cartItem.quantity | number:2}}</td>
			</tr>
		</tbody>
	</table>
	
	<p ng-show="!cartData">Your cart is empty</p>
	
	<script src="resources/js/controllers/CartController.js"></script>
	
</div>