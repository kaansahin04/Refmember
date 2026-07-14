CREATE TABLE `refmember`.`performans` (
  `perfLisans` INT NOT NULL,
  `perfKural` INT NOT NULL,
  `perfDogru` INT NOT NULL,
  `perfYanlis` INT NOT NULL,
  `perfBos` INT NOT NULL,
  `perfYorum` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`perfLisans`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_turkish_ci;