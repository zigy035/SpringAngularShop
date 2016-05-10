INSERT INTO `cart` (`id`, `customer_id`, `created`) VALUES
('CART1', 'CUSTOMER1', '2016-04-08 20:30:40');

INSERT INTO `cart_item` (`id`, `cart_id`, `product_id`, `quantity`) VALUES
('CARTITEM1', 'CART1', 'PRODUCT1', 4),
('CARTITEM2', 'CART1', 'PRODUCT2', 5),
('CARTITEM3', 'CART1', 'PRODUCT3', 6);

INSERT INTO `product` (`id`, `category_id`, `name`, `description`, `price`) VALUES
('PRODUCT1', 'CATEGORY1', 'Product Name 1', 'Product Desc 1', 23.65),
('PRODUCT2', 'CATEGORY1', 'Product Name 2', 'Product Desc 2', 15.96),
('PRODUCT3', 'CATEGORY1', 'Product Name 3', 'Product Desc 3', 42.71),
('PRODUCT4', 'CATEGORY1', 'Product Name 4', 'Product Desc 4', 30.27),
('PRODUCT5', 'CATEGORY1', 'Product Name 5', 'Product Desc 5', 12.29),
('PRODUCT6', 'CATEGORY1', 'Product Name 6', 'Product Desc 6', 7.24);

INSERT INTO `customer` (`id`, `title`, `first_name`, `last_name`, `email`, `password`, `access`) VALUES 
('CUSTOMER1', 'Mr.', 'Igor', 'Milosevic', 'imilosevic@westum.com', '78b6854e22ab09d4ae3dac29b92052963103b33e', 0);

INSERT INTO `title` (`code`, `name`, `order_number`) VALUES 
('MR',  'Mr.',   1),
('MRS', 'Mrs',   2),
('MS',  'Ms',    3),
('MISS', 'Miss', 4),
('DR', 'Dr.',    5);

INSERT INTO `country` (`code`, `name`) VALUES 
('CA', 'Canada'),
('US', 'United States');


INSERT INTO `tax` (`code`, `region_code`, `percent`) VALUES 
('TX-CA-AB', 'CA-AB', 12.0),
('TX-CA-ON', 'CA-ON', 11.0),
('TX-CA-QC', 'CA-QC', 10.0);

INSERT INTO `region` (`code`, `iso_code`, `name`) VALUES 
('CA-AB', 'CA', 'Alberta'),
('CA-BC', 'CA', 'British Columbia'),
('CA-MB', 'CA', 'Manitoba'),
('CA-NB', 'CA', 'New Brunswick'),
('CA-NL', 'CA', 'Newfoundland and Labrador'),
('CA-NS', 'CA', 'Nova Scotia'),
('CA-ON', 'CA', 'Ontario'),
('CA-PE', 'CA', 'Prince Edward Island'),
('CA-QC', 'CA', 'Quebec'),
('CA-SK', 'CA', 'Saskatchewan'),
('CA-NT', 'CA', 'Northwest Territories'),
('CA-NU', 'CA', 'Nunavut'),
('CA-YT', 'CA', 'Yukon Territory'),
('US-AL', 'US', 'Alabama'),
('US-AK', 'US', 'Alaska'),
('US-AZ', 'US', 'Arizona'),
('US-AR', 'US', 'Arkansas'),
('US-CA', 'US', 'California'),
('US-CO', 'US', 'Colorado'),
('US-CT', 'US', 'Connecticut'),
('US-DE', 'US', 'Delaware'),
('US-FL', 'US', 'Florida'),
('US-GA', 'US', 'Georgia'),
('US-HI', 'US', 'Hawaii'),
('US-ID', 'US', 'Idaho'),
('US-IL', 'US', 'Illinois'),
('US-IN', 'US', 'Indiana'),
('US-IA', 'US', 'Iowa'),
('US-KS', 'US', 'Kansas'),
('US-KY', 'US', 'Kentucky'),
('US-LA', 'US', 'Louisiana'),
('US-ME', 'US', 'Maine'),
('US-MD', 'US', 'Maryland'),
('US-MA', 'US', 'Massachusetts'),
('US-MI', 'US', 'Michigan'),
('US-MN', 'US', 'Minnesota'),
('US-MS', 'US', 'Mississippi'),
('US-MO', 'US', 'Missouri'),
('US-MT', 'US', 'Montana'),
('US-NE', 'US', 'Nebraska'),
('US-NV', 'US', 'Nevada'),
('US-NH', 'US', 'New Hampshire'),
('US-NJ', 'US', 'New Jersey'),
('US-NM', 'US', 'New Mexico'),
('US-NY', 'US', 'New York'),
('US-NC', 'US', 'North Carolina'),
('US-ND', 'US', 'North Dakota'),
('US-OH', 'US', 'Ohio'),
('US-OK', 'US', 'Oklahoma'),
('US-OR', 'US', 'Oregon'),
('US-PA', 'US', 'Pennsylvania'),
('US-RI', 'US', 'Rhode Island'),
('US-SC', 'US', 'South Carolina'),
('US-SD', 'US', 'South Dakota'),
('US-TN', 'US', 'Tennessee'),
('US-TX', 'US', 'Texas'),
('US-UT', 'US', 'Utah'),
('US-VT', 'US', 'Vermont'),
('US-VA', 'US', 'Virginia'),
('US-WA', 'US', 'Washington'),
('US-WV', 'US', 'West Virginia'),
('US-WI', 'US', 'Wisconsin'),
('US-WY', 'US', 'Wyoming'),
('US-DC', 'US', 'District of Columbia'),
('US-AS', 'US', 'American Samoa'),
('US-GU', 'US', 'Guam'),
('US-MP', 'US', 'Northern Mariana Islands'),
('US-PR', 'US', 'Puerto Rico'),
('US-UM', 'US', 'United States Minor Outlying Islands'),
('US-VI', 'US', 'United States Virgin Islands');