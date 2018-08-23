CREATE TABLE `rollingstone_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(255) NOT NULL,
  `user_profile_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgnxjxbwinq6xla6qo0wi5o833` (`user_profile_id`),
  CONSTRAINT `FKgnxjxbwinq6xla6qo0wi5o833` FOREIGN KEY (`user_profile_id`) REFERENCES `rollingstone_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `rollingstone_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `house_number` varchar(255) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street_address` varchar(255) NOT NULL,
  `zip_code` varchar(255) NOT NULL,
  `account_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjftwqebn4c1rknbhu0qjg5w21` (`account_id`),
  CONSTRAINT `FKjftwqebn4c1rknbhu0qjg5w21` FOREIGN KEY (`account_id`) REFERENCES `rollingstone_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `rollingstone_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cart_date` date NOT NULL,
  `cart_total` double NOT NULL,
  `user_profile_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9cs737yoaqx9jnr9ewvrsncnx` (`cart_date`),
  KEY `FKj8nf77twxlddndb0kmopxxlat` (`user_profile_id`),
  CONSTRAINT `FKj8nf77twxlddndb0kmopxxlat` FOREIGN KEY (`user_profile_id`) REFERENCES `rollingstone_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `rollingstone_cart_items` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ffm_type` varchar(255) NOT NULL,
  `item_total` double NOT NULL,
  `offerid` bigint(20) NOT NULL,
  `price` double NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `unit` varchar(255) NOT NULL,
  `cart_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkgs6jg1by5yh1nm84lv2lj846` (`cart_id`),
  CONSTRAINT `FKkgs6jg1by5yh1nm84lv2lj846` FOREIGN KEY (`cart_id`) REFERENCES `rollingstone_cart` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `rollingstone_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_description` varchar(255) NOT NULL,
  `category_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `rollingstone_delivery` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `arrivaldate` datetime NOT NULL,
  `daysintransit` int(11) NOT NULL,
  `deliverycharge` double NOT NULL,
  `hasspecialoffers` bit(1) NOT NULL,
  `haulawaymessage` varchar(255) NOT NULL,
  `isavailable` bit(1) NOT NULL,
  `isfreedeliveryformembers` bit(1) NOT NULL,
  `offerid` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `rollingstone_order_hdr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_date` date NOT NULL,
  `order_number` varchar(255) NOT NULL,
  `order_total` varchar(255) NOT NULL,
  `order_tracking_number` varchar(255) NOT NULL,
  `account_id` bigint(20) NOT NULL,
  `billing_address_id` bigint(20) DEFAULT NULL,
  `shipping_address_id` bigint(20) DEFAULT NULL,
  `user_profile_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1uybcbc46hw8sbay08xv77k26` (`order_date`),
  KEY `FKjch1lat5t1hqa6b8k6y7d8xu2` (`account_id`),
  KEY `FKojei9o0cwfill18v36pd859pd` (`billing_address_id`),
  KEY `FK4nsyswgtawoigov674h68s7xo` (`shipping_address_id`),
  KEY `FKs9coeeedtfkl9px6sa7rc7ybp` (`user_profile_id`),
  CONSTRAINT `FK4nsyswgtawoigov674h68s7xo` FOREIGN KEY (`shipping_address_id`) REFERENCES `rollingstone_address` (`id`),
  CONSTRAINT `FKjch1lat5t1hqa6b8k6y7d8xu2` FOREIGN KEY (`account_id`) REFERENCES `rollingstone_account` (`id`),
  CONSTRAINT `FKojei9o0cwfill18v36pd859pd` FOREIGN KEY (`billing_address_id`) REFERENCES `rollingstone_address` (`id`),
  CONSTRAINT `FKs9coeeedtfkl9px6sa7rc7ybp` FOREIGN KEY (`user_profile_id`) REFERENCES `rollingstone_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `rollingstone_order_items` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantity_ordered` varchar(255) NOT NULL,
  `uom` varchar(255) NOT NULL,
  `unit_price` double NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi2gr91a621099dgpkh5813dnr` (`order_id`),
  KEY `FK3x343xhgv4tkrbdy6oiga3vkf` (`product_id`),
  CONSTRAINT `FK3x343xhgv4tkrbdy6oiga3vkf` FOREIGN KEY (`product_id`) REFERENCES `rollingstone_product` (`id`),
  CONSTRAINT `FKi2gr91a621099dgpkh5813dnr` FOREIGN KEY (`order_id`) REFERENCES `rollingstone_order_hdr` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `rollingstone_pricing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `currencycode` varchar(255) NOT NULL,
  `disc_price` double NOT NULL,
  `label` double NOT NULL,
  `display` varchar(255) NOT NULL,
  `membertype` varchar(255) NOT NULL,
  `orig_price` double NOT NULL,
  `pricetype` varchar(255) NOT NULL,
  `price_id` varchar(255) NOT NULL,
  `pcode` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `rollingstone_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `candisplay` bit(1) NOT NULL,
  `isautomotive` bit(1) NOT NULL,
  `isdeleted` bit(1) NOT NULL,
  `isinternational` bit(1) NOT NULL,
  `long_description` varchar(255) NOT NULL,
  `pcode` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `short_description` varchar(255) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `parent_category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1273qdxsfg98re216bbtj99t7` (`category_id`),
  KEY `FKltvigl6yjjn6lpq6sywmk835c` (`parent_category_id`),
  CONSTRAINT `FK1273qdxsfg98re216bbtj99t7` FOREIGN KEY (`category_id`) REFERENCES `rollingstone_category` (`id`),
  CONSTRAINT `FKltvigl6yjjn6lpq6sywmk835c` FOREIGN KEY (`parent_category_id`) REFERENCES `rollingstone_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `rollingstone_promo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `disctype` varchar(255) NOT NULL,
  `discamt` double NOT NULL,
  `enddate` date NOT NULL,
  `minpurchaseval` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `pcode` varchar(255) NOT NULL,
  `promoid` varchar(255) NOT NULL,
  `promo_details` varchar(255) NOT NULL,
  `startdate` date NOT NULL,
  `status` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_i0fxiihpu4qmw85l8bpvux1nt` (`enddate`),
  UNIQUE KEY `UK_grgircu9fldjn4fc9kyhid3h0` (`startdate`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `rollingstone_shipping_hdr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `arrival_date` datetime NOT NULL,
  `days_in_transit` int(11) NOT NULL,
  `is_available` bit(1) NOT NULL,
  `is_free` bit(1) NOT NULL,
  `is_free_shipping_for_members` bit(1) NOT NULL,
  `offer_id` bigint(20) NOT NULL,
  `ship_carrier` varchar(255) NOT NULL,
  `shipping_charge` double NOT NULL,
  `shipping_mode` varchar(255) NOT NULL,
  `order_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK962s2yv66rkwcams3vow6ohkg` (`order_id`),
  CONSTRAINT `FK962s2yv66rkwcams3vow6ohkg` FOREIGN KEY (`order_id`) REFERENCES `rollingstone_order_hdr` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE rollingstone_shipping_hdr DROP COLUMN PRODUCT_ID;


CREATE TABLE `rollingstone_shipping_items` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantity_shipped` varchar(255) NOT NULL,
  `uom` varchar(255) NOT NULL,
  `unit_price` double NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `shipping_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp2g3bgxa5norkbt1e8bmy28bi` (`product_id`),
  KEY `FKq9q7j80yinenfyksrqo7cbne5` (`shipping_id`),
  CONSTRAINT `FKp2g3bgxa5norkbt1e8bmy28bi` FOREIGN KEY (`product_id`) REFERENCES `rollingstone_product` (`id`),
  CONSTRAINT `FKq9q7j80yinenfyksrqo7cbne5` FOREIGN KEY (`shipping_id`) REFERENCES `rollingstone_shipping_hdr` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `rollingstone_store_pickup` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `availablequantity` int(11) NOT NULL,
  `city` varchar(255) NOT NULL,
  `days` int(11) NOT NULL,
  `friwh` varchar(255) NOT NULL,
  `higheststoreindex` int(11) NOT NULL,
  `instockstatus` bit(1) NOT NULL,
  `isautostore` bit(1) NOT NULL,
  `nearest` bit(1) NOT NULL,
  `monwh` varchar(255) NOT NULL,
  `offerid` bigint(20) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `promisedate` datetime NOT NULL,
  `quantity` int(11) NOT NULL,
  `radius` varchar(255) NOT NULL,
  `satwh` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `storename` varchar(255) NOT NULL,
  `storenumber` varchar(255) NOT NULL,
  `streetaddress` varchar(255) NOT NULL,
  `sunwh` varchar(255) NOT NULL,
  `thurwh` varchar(255) NOT NULL,
  `tuewh` varchar(255) NOT NULL,
  `wedwh` varchar(255) NOT NULL,
  `zipcode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `rollingstone_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `mmeber_type` varchar(255) NOT NULL,
  `registration_date` date NOT NULL,
  `sex` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_lmuw5yn9r834i8u1ry9jvjft4` (`registration_date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


