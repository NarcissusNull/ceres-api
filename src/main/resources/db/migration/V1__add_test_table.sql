CREATE TABLE goods(
  id INT primary key NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `price` DECIMAL(10,2) not null,
  `type` INT NULL,
  `describe` VARCHAR(2000) null,
  `created_at` DATETIME DEFAULT NOW(),
  `updated_at` DATETIME DEFAULT NOW()
);