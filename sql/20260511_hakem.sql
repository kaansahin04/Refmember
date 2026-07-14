CREATE TABLE `refmember`.`hakem` (
  `hakAd` VARCHAR(35) NOT NULL,
  `hakSoyad` VARCHAR(35) NOT NULL,
  `hakKulAd` VARCHAR(24) NOT NULL,
  `hakSifre` VARCHAR(255) NOT NULL,
  `hakKlasman` VARCHAR(10) NOT NULL,
  `hakLisans` INT NOT NULL,
  `hakDogru` INT NOT NULL,
  `hakYanlis` INT NOT NULL,
  `hakBos` INT NOT NULL,
  `hakPerformans` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`hakLisans`),
  UNIQUE INDEX `hakLisans_UNIQUE` (`hakLisans` ASC) VISIBLE,
  UNIQUE INDEX `hakKulAd_UNIQUE` (`hakKulAd` ASC) VISIBLE
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_turkish_ci;