CREATE TABLE `items`(
  id INT primary key NOT NULL AUTO_INCREMENT,
  `order` INT NOT NULL,
  `goods` INT NOT NULL,
  `created_at` DATETIME DEFAULT NOW(),
  `updated_at` DATETIME DEFAULT NOW()
);
