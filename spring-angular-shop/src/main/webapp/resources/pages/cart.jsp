<h2>Cart</h2>
<div ng-app="cartApp" ng-controller="cartController">
		
	<table class="striped cart_items" ng-show="cartData">
		<thead>
			<tr>
				<th>Item</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Total</th>
			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="cartItem in cartData">
				<td width="55%">
					<img src="resources/images/product_na.gif" alt=""/>
					<div>
						<p>{{cartItem.productName}}</p>
						<p>Some loooooooong description</p>
					</div>
				</td>
				<td width="15%"><div>{{cartItem.productPrice}}</div></td>
				<td width="15%">
					<div>
						<input type="text" class="qty" ng-model="cartItem.quantity" 
							ng-blur="updateCartItem(cartItem.id, cartItem.quantity)"/>
						<br/>
						<a class="removeItem" href="javascript:void(0)" ng-click="deleteCartItem(cartItem.id)">Remove</a>
					</div>
				</td>
				<td width="15%"><div>{{cartItem.productPrice * cartItem.quantity | number:2}}</div></td>
			</tr>
		</tbody>
	</table>
	
	<table class="striped order_total" ng-show="cartData">
		<thead>
			<tr><th>ORDER TOTALS</th><th></th></tr>
		</thead>
		<tbody>
			<tr><td>Subtotal</td><td>{{subtotal}}</td></tr>
			<tr><td>Delivery</td><td>{{deliveryCost}}</td></tr>
		</tbody>
		<tfoot>
			<tr><td>TOTAL</td><td>{{total}}</td></tr>
		</tfoot>
	</table>
	
	<p ng-show="!cartData">Your cart is empty</p>
	
	<script src="resources/js/controllers/CartController.js"></script>
	
</div>