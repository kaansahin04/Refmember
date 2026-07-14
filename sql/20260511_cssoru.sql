CREATE TABLE `refmember`.`cssoru` (
  `csFoto` VARCHAR(150) NOT NULL,
  `csKural` INT NOT NULL,
  `csSoru` VARCHAR(135) NOT NULL,
  `csSecenek1` VARCHAR(35) NOT NULL,
  `csSecenek2` VARCHAR(35) NOT NULL,
  `csSecenek3` VARCHAR(35) NOT NULL,
  `csCevap` VARCHAR(35) NOT NULL,
  `csAciklama` VARCHAR(135) NOT NULL,
  PRIMARY KEY (`csFoto`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_turkish_ci;