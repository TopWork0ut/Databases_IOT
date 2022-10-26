DROP SCHEMA IF EXISTS `sport_supplements` ;

--- - -----------------------------------------------------
-- -- Schema sport_supplements
-- -- -----------------------------------------------------
-- CREATE SCHEMA IF NOT EXISTS `sport_supplements` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
-- USE `sport_supplements` ;

-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`coach`
-- -- -----------------------------------------------------
-- DROP TABLE IF EXISTS `sport_supplements`.`coach` ;

-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`coach` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `name` VARCHAR(50) NOT NULL,
--   `surname` VARCHAR(50) NOT NULL,
--   `birthday` DATE NULL DEFAULT NULL,
--   `phone` VARCHAR(13) NOT NULL,
--   `adress` VARCHAR(50) NULL DEFAULT NULL,
--   PRIMARY KEY (`id`))
-- ENGINE = InnoDB
-- AUTO_INCREMENT = 11
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`place`
-- -- -----------------------------------------------------
-- DROP TABLE IF EXISTS `sport_supplements`.`place` ;

-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`place` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `street_adress` VARCHAR(50) NOT NULL,
--   PRIMARY KEY (`id`))
-- ENGINE = InnoDB
-- AUTO_INCREMENT = 11
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`competition`
-- -- -----------------------------------------------------
-- DROP TABLE IF EXISTS `sport_supplements`.`competition` ;

-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`competition` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `info` VARCHAR(200) NOT NULL,
--   `date_of_event` DATE NOT NULL,
--   `place_id` INT NOT NULL,
--   `name` VARCHAR(50) NOT NULL,
--   PRIMARY KEY (`id`),
--   CONSTRAINT `competitions_place`
--     FOREIGN KEY (`place_id`)
--     REFERENCES `sport_supplements`.`place` (`id`))
-- ENGINE = InnoDB
-- AUTO_INCREMENT = 11
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;

-- CREATE INDEX `competitions_place` ON `sport_supplements`.`competition` (`place_id` ASC) VISIBLE;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`dish`
-- -- -----------------------------------------------------
-- DROP TABLE IF EXISTS `sport_supplements`.`dish` ;

-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`dish` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `name` VARCHAR(50) NOT NULL,
--   `components` VARCHAR(300) NULL DEFAULT NULL,
--   `calories` INT NOT NULL,
--   `manufacturer` VARCHAR(50) NULL DEFAULT NULL,
--   `production_date` DATE NOT NULL,
--   `consumption_date` DATE NOT NULL,
--   PRIMARY KEY (`id`))
-- ENGINE = InnoDB
-- AUTO_INCREMENT = 11
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`doctor`
-- -- -----------------------------------------------------
-- DROP TABLE IF EXISTS `sport_supplements`.`doctor` ;

-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`doctor` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `name` VARCHAR(50) NOT NULL,
--   `surname` VARCHAR(50) NOT NULL,
--   `birthday` DATE NULL DEFAULT NULL,
--   `phone` VARCHAR(13) NOT NULL,
--   `adress` VARCHAR(50) NULL DEFAULT NULL,
--   PRIMARY KEY (`id`))
-- ENGINE = InnoDB
-- AUTO_INCREMENT = 11
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`schedule`
-- -- -----------------------------------------------------
-- DROP TABLE IF EXISTS `sport_supplements`.`schedule` ;

-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`schedule` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `start_dieting` DATE NULL DEFAULT NULL,
--   `end_dieting` DATE NULL DEFAULT NULL,
--   `description` VARCHAR(300) NULL DEFAULT NULL,
--   PRIMARY KEY (`id`))
-- ENGINE = InnoDB
-- AUTO_INCREMENT = 11
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`sportsman`
-- -- -----------------------------------------------------
-- DROP TABLE IF EXISTS `sport_supplements`.`sportsman` ;

-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`sportsman` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `kind_of_sport` VARCHAR(50) NOT NULL,
--   `height` INT NOT NULL,
--   `weight` INT NOT NULL,
--   `doctor_id` INT NOT NULL,
--   `coach_id` INT NOT NULL,
--   `schedule_id` INT NOT NULL,
--   PRIMARY KEY (`id`),
--   CONSTRAINT `sportsman_coach`
--     FOREIGN KEY (`coach_id`)
--     REFERENCES `sport_supplements`.`coach` (`id`),
--   CONSTRAINT `sportsman_doctor`
--     FOREIGN KEY (`doctor_id`)
--     REFERENCES `sport_supplements`.`doctor` (`id`),
--   CONSTRAINT `sportsman_schedule`
--     FOREIGN KEY (`schedule_id`)
--     REFERENCES `sport_supplements`.`schedule` (`id`))
-- ENGINE = InnoDB
-- AUTO_INCREMENT = 11
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;

-- CREATE INDEX `sportsman_coach` ON `sport_supplements`.`sportsman` (`coach_id` ASC) VISIBLE;

-- CREATE INDEX `sportsman_doctor` ON `sport_supplements`.`sportsman` (`doctor_id` ASC) VISIBLE;

-- CREATE INDEX `sportsman_schedule` ON `sport_supplements`.`sportsman` (`schedule_id` ASC) VISIBLE;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`future_competition`
-- -- -----------------------------------------------------
-- DROP TABLE IF EXISTS `sport_supplements`.`future_competition` ;

-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`future_competition` (
--   `sportsman_id` INT NOT NULL,
--   `competition_id` INT NOT NULL,
--   PRIMARY KEY (`sportsman_id`, `competition_id`),
--   CONSTRAINT `future_competitions_competitions`
--     FOREIGN KEY (`competition_id`)
--     REFERENCES `sport_supplements`.`competition` (`id`),
--   CONSTRAINT `future_competitions_sportsman`
--     FOREIGN KEY (`sportsman_id`)
--     REFERENCES `sport_supplements`.`sportsman` (`id`))
-- ENGINE = InnoDB
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;

-- CREATE INDEX `future_competitions_competitions` ON `sport_supplements`.`future_competition` (`competition_id` ASC) VISIBLE;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`past_competition`
-- -- -----------------------------------------------------
-- DROP TABLE IF EXISTS `sport_supplements`.`past_competition` ;

-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`past_competition` (
--   `sportsman_id` INT NOT NULL,
--   `competition_id` INT NOT NULL,
--   `place_in_tournament` INT NOT NULL,
--   PRIMARY KEY (`sportsman_id`, `competition_id`),
--   CONSTRAINT `competition_history_sportsman`
--     FOREIGN KEY (`sportsman_id`)
--     REFERENCES `sport_supplements`.`sportsman` (`id`),
--   CONSTRAINT `past_competitions_competitions`
--     FOREIGN KEY (`competition_id`)
--     REFERENCES `sport_supplements`.`competition` (`id`))
-- ENGINE = InnoDB
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;

-- CREATE INDEX `past_competitions_competitions` ON `sport_supplements`.`past_competition` (`competition_id` ASC) VISIBLE;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`schedule_dish`
-- -- -----------------------------------------------------
-- DROP TABLE IF EXISTS `sport_supplements`.`schedule_dish` ;

-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`schedule_dish` (
--   `dish_id` INT NOT NULL,
--   `schedule_id` INT NOT NULL,
--   PRIMARY KEY (`dish_id`, `schedule_id`),
--   CONSTRAINT `schedule_dishies_dishies`
--     FOREIGN KEY (`dish_id`)
--     REFERENCES `sport_supplements`.`dish` (`id`),
--   CONSTRAINT `schedule_dishies_schedule`
--     FOREIGN KEY (`schedule_id`)
--     REFERENCES `sport_supplements`.`schedule` (`id`))
-- ENGINE = InnoDB
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;

-- CREATE INDEX `schedule_dishies_schedule` ON `sport_supplements`.`schedule_dish` (`schedule_id` ASC) VISIBLE;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`supplement`
-- -- -----------------------------------------------------
-- DROP TABLE IF EXISTS `sport_supplements`.`supplement` ;

-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`supplement` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `name` VARCHAR(50) NOT NULL,
--   `components` VARCHAR(300) NOT NULL,
--   `calories` INT NOT NULL,
--   `manufacturer` VARCHAR(50) NOT NULL,
--   `production_date` DATE NOT NULL,
--   `consumption_date` DATE NOT NULL,
--   PRIMARY KEY (`id`))
-- ENGINE = InnoDB
-- AUTO_INCREMENT = 11
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`schedule_supplement`
-- -- -----------------------------------------------------
-- DROP TABLE IF EXISTS `sport_supplements`.`schedule_supplement` ;

-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`schedule_supplement` (
--   `schedule_id` INT NOT NULL,
--   `supplement_id` INT NOT NULL,
--   PRIMARY KEY (`schedule_id`, `supplement_id`),
--   CONSTRAINT `Table_11_schedule`
--     FOREIGN KEY (`schedule_id`)
--     REFERENCES `sport_supplements`.`schedule` (`id`),
--   CONSTRAINT `Table_11_supplements`
--     FOREIGN KEY (`supplement_id`)
--     REFERENCES `sport_supplements`.`supplement` (`id`))
-- ENGINE = InnoDB
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;



-- -----------------------------------------------------
-- Table `sport_supplements`.`coach`
-- -----------------------------------------------------
-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`coach` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `name` VARCHAR(50) NOT NULL,
--   `surname` VARCHAR(50) NOT NULL,
--   `birthday` DATE NULL DEFAULT NULL,
--   `phone` VARCHAR(13) NOT NULL,
--   `adress` VARCHAR(50) NULL DEFAULT NULL,
--   PRIMARY KEY (`id`))
-- ENGINE = InnoDB
-- AUTO_INCREMENT = 21
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`place`
-- -- -----------------------------------------------------
-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`place` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `street_adress` VARCHAR(50) NOT NULL,
--   PRIMARY KEY (`id`))
-- ENGINE = InnoDB
-- AUTO_INCREMENT = 21
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`competition`
-- -- -----------------------------------------------------
-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`competition` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `info` VARCHAR(200) NOT NULL,
--   `date_of_event` DATE NOT NULL,
--   `place_id` INT NOT NULL,
--   `name` VARCHAR(50) NOT NULL,
--   PRIMARY KEY (`id`),
--   INDEX `competitions_place` (`place_id` ASC) VISIBLE,
--   CONSTRAINT `competitions_place`
--     FOREIGN KEY (`place_id`)
--     REFERENCES `sport_supplements`.`place` (`id`))
-- ENGINE = InnoDB
-- AUTO_INCREMENT = 21
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`dish`
-- -- -----------------------------------------------------
-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`dish` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `name` VARCHAR(50) NOT NULL,
--   `components` VARCHAR(300) NULL DEFAULT NULL,
--   `calories` INT NOT NULL,
--   `manufacturer` VARCHAR(50) NULL DEFAULT NULL,
--   `production_date` DATE NOT NULL,
--   `consumption_date` DATE NOT NULL,
--   PRIMARY KEY (`id`))
-- ENGINE = InnoDB
-- AUTO_INCREMENT = 21
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`doctor`
-- -- -----------------------------------------------------
-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`doctor` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `name` VARCHAR(50) NOT NULL,
--   `surname` VARCHAR(50) NOT NULL,
--   `birthday` DATE NULL DEFAULT NULL,
--   `phone` VARCHAR(13) NOT NULL,
--   `adress` VARCHAR(50) NULL DEFAULT NULL,
--   PRIMARY KEY (`id`))
-- ENGINE = InnoDB
-- AUTO_INCREMENT = 21
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`schedule`
-- -- -----------------------------------------------------
-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`schedule` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `start_dieting` DATE NULL DEFAULT NULL,
--   `end_dieting` DATE NULL DEFAULT NULL,
--   `description` VARCHAR(300) NULL DEFAULT NULL,
--   PRIMARY KEY (`id`))
-- ENGINE = InnoDB
-- AUTO_INCREMENT = 21
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`sportsman`
-- -- -----------------------------------------------------
-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`sportsman` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `kind_of_sport` VARCHAR(50) NOT NULL,
--   `height` INT NOT NULL,
--   `weight` INT NOT NULL,
--   `doctor_id` INT NOT NULL,
--   `coach_id` INT NOT NULL,
--   `schedule_id` INT NOT NULL,
--   PRIMARY KEY (`id`),
--   INDEX `sportsman_coach` (`coach_id` ASC) VISIBLE,
--   INDEX `sportsman_doctor` (`doctor_id` ASC) VISIBLE,
--   INDEX `sportsman_schedule` (`schedule_id` ASC) VISIBLE,
--   CONSTRAINT `sportsman_coach`
--     FOREIGN KEY (`coach_id`)
--     REFERENCES `sport_supplements`.`coach` (`id`),
--   CONSTRAINT `sportsman_doctor`
--     FOREIGN KEY (`doctor_id`)
--     REFERENCES `sport_supplements`.`doctor` (`id`),
--   CONSTRAINT `sportsman_schedule`
--     FOREIGN KEY (`schedule_id`)
--     REFERENCES `sport_supplements`.`schedule` (`id`))
-- ENGINE = InnoDB
-- AUTO_INCREMENT = 21
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`schedule_dish`
-- -- -----------------------------------------------------
-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`schedule_dish` (
--   `dish_id` INT NOT NULL,
--   `schedule_id` INT NOT NULL,
--   PRIMARY KEY (`dish_id`, `schedule_id`),
--   INDEX `schedule_dishies_schedule` (`schedule_id` ASC) VISIBLE,
--   CONSTRAINT `schedule_dishies_dishies`
--     FOREIGN KEY (`dish_id`)
--     REFERENCES `sport_supplements`.`dish` (`id`),
--   CONSTRAINT `schedule_dishies_schedule`
--     FOREIGN KEY (`schedule_id`)
--     REFERENCES `sport_supplements`.`schedule` (`id`))
-- ENGINE = InnoDB
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`supplement`
-- -- -----------------------------------------------------
-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`supplement` (
--   `id` INT NOT NULL AUTO_INCREMENT,
--   `name` VARCHAR(50) NOT NULL,
--   `components` VARCHAR(300) NOT NULL,
--   `calories` INT NOT NULL,
--   `manufacturer` VARCHAR(50) NOT NULL,
--   `production_date` DATE NOT NULL,
--   `consumption_date` DATE NOT NULL,
--   PRIMARY KEY (`id`))
-- ENGINE = InnoDB
-- AUTO_INCREMENT = 21
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;


-- -- -----------------------------------------------------
-- -- Table `sport_supplements`.`schedule_supplement`
-- -- -----------------------------------------------------
-- CREATE TABLE IF NOT EXISTS `sport_supplements`.`schedule_supplement` (
--   `schedule_id` INT NOT NULL,
--   `supplement_id` INT NOT NULL,
--   PRIMARY KEY (`schedule_id`, `supplement_id`),
--   INDEX `Table_11_supplements` (`supplement_id` ASC) VISIBLE,
--   CONSTRAINT `Table_11_schedule`
--     FOREIGN KEY (`schedule_id`)
--     REFERENCES `sport_supplements`.`schedule` (`id`),
--   CONSTRAINT `Table_11_supplements`
--     FOREIGN KEY (`supplement_id`)
--     REFERENCES `sport_supplements`.`supplement` (`id`))
-- ENGINE = InnoDB
-- DEFAULT CHARACTER SET = utf8mb4
-- COLLATE = utf8mb4_0900_ai_ci;

-- SET SQL_MODE=@OLD_SQL_MODE;
-- SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
-- SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- SET SQL_MODE=@OLD_SQL_MODE;
-- SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
-- SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
-- CREATE INDEX `Table_11_supplements` ON `sport_supplements`.`schedule_supplement` (`supplement_id` ASC) VISIBLE;

CREATE SCHEMA IF NOT EXISTS `sport_supplements` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `sport_supplements` ;

CREATE TABLE IF NOT EXISTS `sport_supplements`.`dish` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `components` VARCHAR(300) NULL DEFAULT NULL,
  `calories` INT NOT NULL,
  `manufacturer` VARCHAR(50) NULL DEFAULT NULL,
  `production_date` DATE NOT NULL,
  `consumption_date` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sport_supplements`.`schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport_supplements`.`schedule` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_dieting` DATE NULL DEFAULT NULL,
  `end_dieting` DATE NULL DEFAULT NULL,
  `description` VARCHAR(300) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sport_supplements`.`schedule_dish`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport_supplements`.`schedule_dish` (
  `dish_id` INT NOT NULL,
  `schedule_id` INT NOT NULL,
  PRIMARY KEY (`dish_id`, `schedule_id`),
  INDEX `schedule_dishies_schedule` (`schedule_id` ASC) VISIBLE,
  CONSTRAINT `schedule_dishies_dishies`
    FOREIGN KEY (`dish_id`)
    REFERENCES `sport_supplements`.`dish` (`id`),
  CONSTRAINT `schedule_dishies_schedule`
    FOREIGN KEY (`schedule_id`)
    REFERENCES `sport_supplements`.`schedule` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sport_supplements`.`supplement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport_supplements`.`supplement` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `components` VARCHAR(300) NOT NULL,
  `calories` INT NOT NULL,
  `manufacturer` VARCHAR(50) NOT NULL,
  `production_date` DATE NOT NULL,
  `consumption_date` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sport_supplements`.`schedule_supplement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport_supplements`.`schedule_supplement` (
  `schedule_id` INT NOT NULL,
  `supplement_id` INT NOT NULL,
  PRIMARY KEY (`schedule_id`, `supplement_id`),
  INDEX `Table_11_supplements` (`supplement_id` ASC) VISIBLE,
  CONSTRAINT `Table_11_schedule`
    FOREIGN KEY (`schedule_id`)
    REFERENCES `sport_supplements`.`schedule` (`id`),
  CONSTRAINT `Table_11_supplements`
    FOREIGN KEY (`supplement_id`)
    REFERENCES `sport_supplements`.`supplement` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sport_supplements`.`sportsman`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport_supplements`.`sportsman` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `kind_of_sport` VARCHAR(50) NOT NULL,
  `height` INT NOT NULL,
  `weight` INT NOT NULL,
  `schedule_id` INT NOT NULL,
  PRIMARY KEY (`id`, `schedule_id`),
  INDEX `fk_sportsman_schedule1_idx` (`schedule_id` ASC) VISIBLE,
  CONSTRAINT `fk_sportsman_schedule1`
    FOREIGN KEY (`schedule_id`)
    REFERENCES `sport_supplements`.`schedule` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- insert into coach(name, surname, birthday, phone, adress) values('Max','Olaf','2002-01-04','0952341243','ShevchenkoStreet'); 
-- insert into coach(name, surname, birthday, phone, adress) values('Grim','Sh','2005-05-04','0994341243','Dragana'); 
-- insert into coach(name, surname, birthday, phone, adress) values('Dugan','Queen','2004-01-09','0955341243','ShevchenkoStreet'); 
-- insert into coach(name, surname, birthday, phone, adress) values('Shayry','Dark','2009-04-02','0972341243','Dragana'); 
-- insert into coach(name, surname, birthday, phone, adress) values('Oleg','Bee','2008-04-02','0941341243','Dragana'); 
-- insert into coach(name, surname, birthday, phone, adress) values('Man','Oks','1991-10-04','0999941243','ShevchenkoStreet'); 
-- insert into coach(name, surname, birthday, phone, adress) values('Bob','Grak','2001-8-10','0952341311','Dragana'); 
-- insert into coach(name, surname, birthday, phone, adress) values('Jerli','Witness','2003-01-04','0952341555','ShevchenkoStreet'); 
-- insert into coach(name, surname, birthday, phone, adress) values('ALex','Grew','2010-08-15','0952341444','Nahyrna'); 
-- insert into coach(name, surname, birthday, phone, adress) values('As','Shinee','2002-02-09','0952341222','Nahyrna'); 


-- insert into doctor(name, surname, birthday, phone, adress) values('Od','Olaf','2002-01-10','0952341255','Dragana'); 
-- insert into doctor(name, surname, birthday, phone, adress) values('Braa','Sjo','2008-05-08','0994341266','Dragana'); 
-- insert into doctor(name, surname, birthday, phone, adress) values('MAtviiv','Reeas','2002-01-09','0955341277','ShevchenkoStreet'); 
-- insert into doctor(name, surname, birthday, phone, adress) values('Sanya','Idtar','2010-04-02','0972341248','Nahyrna'); 
-- insert into doctor(name, surname, birthday, phone, adress) values('Groovy','Crew','1998-04-02','0941341299','Dragana'); 
-- insert into doctor(name, surname, birthday, phone, adress) values('Rust','Oks','1991-10-04','0999941211','ShevchenkoStreet'); 
-- insert into doctor(name, surname, birthday, phone, adress) values('Cabon','Seen','2004-8-10','0952341322','Nahyrna'); 
-- insert into doctor(name, surname, birthday, phone, adress) values('Mut','Bim','2003-03-04','0952341500','ShevchenkoStreet'); 
-- insert into doctor(name, surname, birthday, phone, adress) values('Bubble','Grew','2010-01-15','0952341488','Nahyrna'); 
-- insert into doctor(name, surname, birthday, phone, adress) values('Copy','Bom','2003-02-09','0952341111','Nahyrna'); 

insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Tomato','-',120,'-','2020-01-01','2020-02-02'); 
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Spagetti','Pasta, Ketchup',410,'Italiano','2021-02-01','2021-04-02'); 
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Pizza','milk,salt,meat',832,'Italiano','2020-01-01','2020-02-01'); 
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Coffee','nuts',100,'China','2020-01-01','2020-10-01'); 
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Boom','-',1000,'-','2021-01-01','2022-02-14'); 
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Tea','leafs',12,'Chine','2020-01-01','2022-01-01'); 
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Greeny','-',670,'-','2021-01-01','2021-05-08'); 
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Meat','-',311,'-','2020-01-01','2020-01-10'); 
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Fish','-',410,'-','2021-01-01','2021-02-02'); 
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Chunks','-',310,'-','2020-01-01','2020-09-02'); 

-- insert into place(street_adress) values('Dragana');
-- insert into place(street_adress) values('Trilovskogo');
-- insert into place(street_adress) values('Dragana');
-- insert into place(street_adress) values('Trilovskogo');
-- insert into place(street_adress) values('Trilovskogo');
-- insert into place(street_adress) values('Dragana');
-- insert into place(street_adress) values('ShevchenkoStreet');
-- insert into place(street_adress) values('ShevchenkoStreet');
-- insert into place(street_adress) values('Dragana');
-- insert into place(street_adress) values('Dragana');

-- insert into competition(info, date_of_event, place_id, name) values('powerlifting','2020-01-01',21,'Gym');
-- insert into competition(info, date_of_event, place_id, name) values('powerlifting','2022-01-10',22,'Trophy');
-- insert into competition(info, date_of_event, place_id, name) values('swimming','2020-04-01',22,'Gym');
-- insert into competition(info, date_of_event, place_id, name) values('powerlifting','2021-01-01',21,'Trophy');
-- insert into competition(info, date_of_event, place_id, name) values('swimming','2020-01-07',24,'Trophy');
-- insert into competition(info, date_of_event, place_id, name) values('swimming','2020-02-01',28,'Gym');
-- insert into competition(info, date_of_event, place_id, name) values('crossfit','2020-04-01',27,'Trophy');
-- insert into competition(info, date_of_event, place_id, name) values('crossfit','2020-01-11',27,'Gym');
-- insert into competition(info, date_of_event, place_id, name) values('powerlifting','2022-02-01',29,'Gym');
-- insert into competition(info, date_of_event, place_id, name) values('crossfit','2020-01-07',21,'Trophy');

insert into schedule(start_dieting, end_dieting, description) values('2020-01-07','2020-04-09','Two times a week');
insert into schedule(start_dieting, end_dieting, description) values('2020-02-07','2020-05-01','Each day, two times a day');
insert into schedule(start_dieting, end_dieting, description) values('2021-09-10','2021-10-09','Five rimes a week');
insert into schedule(start_dieting, end_dieting, description) values('2020-01-01','2020-04-01','Six times a week');
insert into schedule(start_dieting, end_dieting, description) values('2022-01-07','2022-04-09','One time a week');
insert into schedule(start_dieting, end_dieting, description) values('2022-01-01','2020-08-01','Three times a day');
insert into schedule(start_dieting, end_dieting, description) values('2020-04-03','2020-08-01','Two times a week');
insert into schedule(start_dieting, end_dieting, description) values('2020-09-23','2020-12-23','Two times a week');
insert into schedule(start_dieting, end_dieting, description) values('2020-01-07','2020-04-09','Four times a week');
insert into schedule(start_dieting, end_dieting, description) values('2021-01-07','2022-01-07','Two times a week');

insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Protein','-',240,'Ukraine','2020-03-01','2020-02-10'); 
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Gainer','-',510,'Ukraine','2021-02-01','2021-04-02'); 
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Creatine','-',782,'Italiano','2020-05-01','2020-02-08'); 
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Vitamins','A1,A2,C,E',120,'China','2020-02-01','2020-10-01'); 
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Izotonick','-',900,'Ukraine','2021-02-01','2022-02-14'); 
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Juice','Fruits,vegetables',421,'Ukraine','2020-01-10','2022-01-01'); 
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('GymMAss','-',110,'USA','2021-01-01','2021-05-09'); 
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Greely','-',831,'USA','2020-01-01','2020-01-10'); 
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Countins','-',933,'USA','2021-02-01','2021-02-02'); 
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Lities','-',123,'USA','2020-08-01','2020-09-02'); 


insert into schedule_supplement(schedule_id, supplement_id) values(31,31);
insert into schedule_supplement(schedule_id, supplement_id) values(31,33);
insert into schedule_supplement(schedule_id, supplement_id) values(31,39);
insert into schedule_supplement(schedule_id, supplement_id) values(32,33);
insert into schedule_supplement(schedule_id, supplement_id) values(32,35);
insert into schedule_supplement(schedule_id, supplement_id) values(35,34);
insert into schedule_supplement(schedule_id, supplement_id) values(36,33);
insert into schedule_supplement(schedule_id, supplement_id) values(38,37);
insert into schedule_supplement(schedule_id, supplement_id) values(38,39);
insert into schedule_supplement(schedule_id, supplement_id) values(39,39);

insert into schedule_dish(dish_id,schedule_id) values(31,31);
insert into schedule_dish(dish_id,schedule_id) values(32,33);
insert into schedule_dish(dish_id,schedule_id) values(32,37);
insert into schedule_dish(dish_id,schedule_id) values(33,35);
insert into schedule_dish(dish_id,schedule_id) values(34,31);
insert into schedule_dish(dish_id,schedule_id) values(36,32);
insert into schedule_dish(dish_id,schedule_id) values(37,36);
insert into schedule_dish(dish_id,schedule_id) values(37,31);
insert into schedule_dish(dish_id,schedule_id) values(39,37);
insert into schedule_dish(dish_id,schedule_id) values(39,38);

insert into sportsman(kind_of_sport,height,weight,schedule_id) values('powerlifting',172,81,31);
insert into sportsman(kind_of_sport,height,weight,schedule_id) values('powerlifting',179,89,33);
insert into sportsman(kind_of_sport,height,weight,schedule_id) values('crossfit',182,83,38);
insert into sportsman(kind_of_sport,height,weight,schedule_id) values('powerlifting',73,81,36);
insert into sportsman(kind_of_sport,height,weight,schedule_id) values('crossfit',173,91,34);
insert into sportsman(kind_of_sport,height,weight,schedule_id) values('swimming',162,61,38);
insert into sportsman(kind_of_sport,height,weight,schedule_id) values('powerlifting',186,101,32);
insert into sportsman(kind_of_sport,height,weight,schedule_id) values('powerlifting',189,91,31);
insert into sportsman(kind_of_sport,height,weight,schedule_id) values('crossfit',191,82,39);
insert into sportsman(kind_of_sport,height,weight,schedule_id) values('swimming',198,93,38);


-- insert into past_competition(sportsman_id, competition_id, place_in_tournament) values(11,11,1);
-- insert into past_competition(sportsman_id, competition_id, place_in_tournament) values(12,15,1);
-- insert into past_competition(sportsman_id, competition_id, place_in_tournament) values(11,18,3);
-- insert into past_competition(sportsman_id, competition_id, place_in_tournament) values(14,12,5);
-- insert into past_competition(sportsman_id, competition_id, place_in_tournament) values(12,12,1);
-- insert into past_competition(sportsman_id, competition_id, place_in_tournament) values(15,14,5);
-- insert into past_competition(sportsman_id, competition_id, place_in_tournament) values(15,12,1);
-- insert into past_competition(sportsman_id, competition_id, place_in_tournament) values(18,11,8);
-- insert into past_competition(sportsman_id, competition_id, place_in_tournament) values(19,12,9);
-- insert into past_competition(sportsman_id, competition_id, place_in_tournament) values(17,17,2);

-- insert into future_competition(sportsman_id, competition_id) values(11,12);
-- insert into future_competition(sportsman_id, competition_id) values(12,13);
-- insert into future_competition(sportsman_id, competition_id) values(12,14);
-- insert into future_competition(sportsman_id, competition_id) values(12,15);
-- insert into future_competition(sportsman_id, competition_id) values(13,15);
-- insert into future_competition(sportsman_id, competition_id) values(14,15);
-- insert into future_competition(sportsman_id, competition_id) values(15,18);
-- insert into future_competition(sportsman_id, competition_id) values(15,19);
-- insert into future_competition(sportsman_id, competition_id) values(18,14);
-- insert into future_competition(sportsman_id, competition_id) values(19,18);
