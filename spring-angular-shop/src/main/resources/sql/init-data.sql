INSERT INTO `cart` (`id`, `customer_id`, `created`) VALUES
('CART1', 'CUSTOMER1', '2016-04-08 20:30:40');

INSERT INTO `cart_item` (`id`, `cart_id`, `product_id`, `quantity`) VALUES
('CARTITEM1', 'CART1', 'PRODUCT1', 4),
('CARTITEM2', 'CART1', 'PRODUCT2', 5),
('CARTITEM3', 'CART1', 'PRODUCT3', 6);

INSERT INTO `product` (`id`, `category_id`, `name`, `description`, `price`) VALUES
('PRODUCT1', 'CATEGORY1', 'Product Name 1', 'Product Desc 1', 23.65),
('PRODUCT2', 'CATEGORY1', 'Product Name 2', 'Product Desc 2', 15.96),
('PRODUCT3', 'CATEGORY1', 'Product Name 3', 'Product Desc 3', 7.24);