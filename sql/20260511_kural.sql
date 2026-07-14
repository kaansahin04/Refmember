CREATE TABLE `refmember`.`kural` (
  `kurFoto` VARCHAR(150) NOT NULL,
  `kurAciklama` VARCHAR(2994) NOT NULL,
  `kurNo` INT NOT NULL,
  `kurIlkSayfa` INT NOT NULL,
  `kurSonSayfa` INT NOT NULL,
  PRIMARY KEY (`kurNo`),
  UNIQUE INDEX `kurNo_UNIQUE` (`kurNo` ASC) VISIBLE
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_turkish_ci;