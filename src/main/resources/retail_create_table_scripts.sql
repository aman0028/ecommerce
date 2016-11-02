CREATE TABLE `products` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(1) NOT NULL DEFAULT 'A',
  `category_id` int(11) NOT NULL,
  `date_created` timestamp NULL DEFAULT NULL,
  `date_updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=517 DEFAULT CHARSET=utf8

CREATE TABLE `product_languages` (
  `product_language_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `locale` varchar(5) NOT NULL,
  `product_name` varchar(64) NOT NULL,
  `product_currency` varchar(10) NOT NULL,
  `product_price` int(11) DEFAULT NULL,
  `product_short_description` text,
  `product_description` mediumtext,
  `date_created` timestamp NULL DEFAULT NULL,
  `date_updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_language_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5017 DEFAULT CHARSET=utf8

CREATE TABLE `categories` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(20) DEFAULT NULL,
  `category_type` varchar(20) NOT NULL,
  `tax_percentage` int(11) NOT NULL,
  `date_created` timestamp NULL DEFAULT NULL,
  `date_updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8