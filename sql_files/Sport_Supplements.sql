create database sport_supplements;
use sport_supplements;

-- tables
-- Table: coach
CREATE TABLE coach (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    surname varchar(50) NOT NULL,
    birthday date NULL,
    phone varchar(13) NOT NULL,
    adress varchar(50) NULL,
    CONSTRAINT coach_pk PRIMARY KEY (id)
);

-- Table: competitions
CREATE TABLE competitions (
    id int NOT NULL AUTO_INCREMENT,
    info varchar(200) NOT NULL,
    date_of_event date NOT NULL,
    place_id int NOT NULL,
    name varchar(50) NOT NULL,
    CONSTRAINT competitions_pk PRIMARY KEY (id)
);

-- Table: dishes
CREATE TABLE dishes (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    components varchar(300) NULL,
    calories int NOT NULL,
    manufacturer varchar(50) NULL,
    production_date date NOT NULL,
    consumption_date date NOT NULL,
    CONSTRAINT dishes_pk PRIMARY KEY (id)
);

-- Table: doctor
CREATE TABLE doctor (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    surname varchar(50) NOT NULL,
    birthday date NULL,
    phone varchar(13) NOT NULL,
    adress varchar(50) NULL,
    CONSTRAINT doctor_pk PRIMARY KEY (id)
);

-- Table: future_competitions
CREATE TABLE future_competitions (
    sportsman_id int NOT NULL,
    competitions_id int NOT NULL,
    CONSTRAINT future_competitions_pk PRIMARY KEY (sportsman_id,competitions_id)
);

-- Table: past_competitions
CREATE TABLE past_competitions (
    sportsman_id int NOT NULL,
    competitions_id int NOT NULL,
    place_in_tournament int NOT NULL,
    CONSTRAINT past_competitions_pk PRIMARY KEY (sportsman_id,competitions_id)
);

-- Table: place
CREATE TABLE place (
    id int NOT NULL AUTO_INCREMENT,
    street_adress varchar(50) NOT NULL,
    CONSTRAINT place_pk PRIMARY KEY (id)
);

-- Table: schedule
CREATE TABLE schedule (
    id int NOT NULL AUTO_INCREMENT,
    start_dieting date NULL,
    end_dieting date NULL,
    description varchar(300) NULL,
    CONSTRAINT schedule_pk PRIMARY KEY (id)
);

-- Table: schedule_dishes
CREATE TABLE schedule_dishes (
    dishies_id int NOT NULL,
    schedule_id int NOT NULL,
    CONSTRAINT schedule_dishes_pk PRIMARY KEY (dishies_id,schedule_id)
);

-- Table: schedule_supplements
CREATE TABLE schedule_supplements (
    schedule_id int NOT NULL,
    supplements_id int NOT NULL,
    CONSTRAINT schedule_supplements_pk PRIMARY KEY (schedule_id,supplements_id)
);

-- Table: sportsman
CREATE TABLE sportsman (
    id int NOT NULL AUTO_INCREMENT,
    kind_of_sport varchar(50) NOT NULL,
    height int NOT NULL,
    weight int NOT NULL,
    doctor_id int NOT NULL,
    coach_id int NOT NULL,
    schedule_id int NOT NULL,
    CONSTRAINT sportsman_pk PRIMARY KEY (id)
);

-- Table: supplements
CREATE TABLE supplements (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    components varchar(300) NOT NULL,
    calories int NOT NULL,
    manufacturer varchar(50) NOT NULL,
    production_date date NOT NULL,
    consumption_date date NOT NULL,
    CONSTRAINT supplements_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Table_11_schedule (table: schedule_supplements)
ALTER TABLE schedule_supplements ADD CONSTRAINT Table_11_schedule FOREIGN KEY Table_11_schedule (schedule_id)
    REFERENCES schedule (id);

-- Reference: Table_11_supplements (table: schedule_supplements)
ALTER TABLE schedule_supplements ADD CONSTRAINT Table_11_supplements FOREIGN KEY Table_11_supplements (supplements_id)
    REFERENCES supplements (id);

-- Reference: competition_history_sportsman (table: past_competitions)
ALTER TABLE past_competitions ADD CONSTRAINT competition_history_sportsman FOREIGN KEY competition_history_sportsman (sportsman_id)
    REFERENCES sportsman (id);

-- Reference: competitions_place (table: competitions)
ALTER TABLE competitions ADD CONSTRAINT competitions_place FOREIGN KEY competitions_place (place_id)
    REFERENCES place (id);

-- Reference: future_competitions_competitions (table: future_competitions)
ALTER TABLE future_competitions ADD CONSTRAINT future_competitions_competitions FOREIGN KEY future_competitions_competitions (competitions_id)
    REFERENCES competitions (id);

-- Reference: future_competitions_sportsman (table: future_competitions)
ALTER TABLE future_competitions ADD CONSTRAINT future_competitions_sportsman FOREIGN KEY future_competitions_sportsman (sportsman_id)
    REFERENCES sportsman (id);

-- Reference: past_competitions_competitions (table: past_competitions)
ALTER TABLE past_competitions ADD CONSTRAINT past_competitions_competitions FOREIGN KEY past_competitions_competitions (competitions_id)
    REFERENCES competitions (id);

-- Reference: schedule_dishies_dishies (table: schedule_dishes)
ALTER TABLE schedule_dishes ADD CONSTRAINT schedule_dishies_dishies FOREIGN KEY schedule_dishies_dishies (dishies_id)
    REFERENCES dishes (id);

-- Reference: schedule_dishies_schedule (table: schedule_dishes)
ALTER TABLE schedule_dishes ADD CONSTRAINT schedule_dishies_schedule FOREIGN KEY schedule_dishies_schedule (schedule_id)
    REFERENCES schedule (id);

-- Reference: sportsman_coach (table: sportsman)
ALTER TABLE sportsman ADD CONSTRAINT sportsman_coach FOREIGN KEY sportsman_coach (coach_id)
    REFERENCES coach (id);

-- Reference: sportsman_doctor (table: sportsman)
ALTER TABLE sportsman ADD CONSTRAINT sportsman_doctor FOREIGN KEY sportsman_doctor (doctor_id)
    REFERENCES doctor (id);

-- Reference: sportsman_schedule (table: sportsman)
ALTER TABLE sportsman ADD CONSTRAINT sportsman_schedule FOREIGN KEY sportsman_schedule (schedule_id)
    REFERENCES schedule (id);

-- End of file.

