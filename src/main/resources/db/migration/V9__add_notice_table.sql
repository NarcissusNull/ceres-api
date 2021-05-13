CREATE TABLE notice(
  id INT primary key NOT NULL AUTO_INCREMENT,
  `user` INT NOT NULL,
  `check` DATETIME NOT NULL,
  `created_at` DATETIME DEFAULT NOW(),
  `updated_at` DATETIME DEFAULT NOW()
);