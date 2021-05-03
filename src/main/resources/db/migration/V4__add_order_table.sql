CREATE TABLE `orders`(
  id INT primary key NOT NULL AUTO_INCREMENT,
  `user` INT NOT NULL,
  `created_at` DATETIME DEFAULT NOW(),
  `updated_at` DATETIME DEFAULT NOW()
);
