<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- 
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/css/jquery-ui.min.css"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/styles/js/jquery-1.12.1.min.js"></script>		
	<script type="text/javascript" src="<%=request.getContextPath()%>/styles/js/jquery-ui.min.js"></script>
	 -->

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/styles/css/style.css"/>
	<script type="text/javascript" src="<%=request.getContextPath()%>/styles/js/angular.min.js"></script>
	<script type="text/javascript">
		var baseURL = "${pageContext.request.contextPath}";
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/styles/js/app.js"></script>
</head>
<body ng-app="shopApp">
	<h2>Cart Page</h2>
	<div ng-controller="cartController">
		<table class="stripeMe sample">
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
		
		<div class="productGrid">
			<div class="productItem" ng-repeat="product in products">
				<img src="<%=request.getContextPath()%>/styles/images/product_na.gif"/>
				<p>{{product.name}}</p>
				<p>{{product.price}}</p>
				<form ng-submit="addCartItem('CART1', product.id)" method="post">
					<input type="submit" class="btn" value="Add to Cart"/>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>
