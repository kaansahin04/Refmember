CREATE TABLE `refmember`.`sozluk` (
  `sozKavram` VARCHAR(24) NOT NULL,
  `sozTanim` VARCHAR(194) NOT NULL,
  PRIMARY KEY (`sozKavram`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_turkish_ci;