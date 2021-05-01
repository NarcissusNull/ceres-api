CREATE TABLE `user`(
  id INT primary key NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `role` VARCHAR(10) NOT NULL,
  `created_at` DATETIME DEFAULT NOW(),
  `updated_at` DATETIME DEFAULT NOW()
);
