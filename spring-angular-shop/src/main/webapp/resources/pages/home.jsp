<h2>Products</h2>
<div ng-app="productApp" ng-controller="productController">
		
	<div class="productGrid">
		<div class="productItem" ng-repeat="product in products">
			<img src="resources/images/product_na.gif"/>
			<p>{{product.name}}</p>
			<p>{{product.price}}</p>
			<form ng-submit="addCartItem(product.id)" method="post">
				<input type="submit" class="btn" value="Add to Cart"/>
			</form>
		</div>
	</div>
	
	<script src="resources/js/controllers/ProductController.js"></script>
	
	<%-- <script src="<%=request.getContextPath()%>/resources/js/angular.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/angular-route.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/controllers/ProductController.js"></script> --%>
	
</div>