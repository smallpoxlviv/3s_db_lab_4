CREATE SCHEMA IF NOT EXISTS s3_db_lab_4 DEFAULT CHARACTER SET utf8 ;
USE s3_db_lab_4;

SET foreign_key_checks = 0;
DROP TABLE IF EXISTS animal_species;
DROP TABLE IF EXISTS animal_species_has_service;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS client_has_pet;
DROP TABLE IF EXISTS diagnosis;
DROP TABLE IF EXISTS diploma;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS doctor_has_service;
DROP TABLE IF EXISTS pet;
DROP TABLE IF EXISTS service;
DROP TABLE IF EXISTS schedule;
DROP TABLE IF EXISTS visit;
SET foreign_key_checks = 1;

-- --------------------------------------------
CREATE TABLE IF NOT EXISTS animal_species (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  species VARCHAR(45) NOT NULL UNIQUE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS animal_species_has_service (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  animal_species_id BIGINT  NOT NULL,
  service_id BIGINT NOT NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS client (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(45) NOT NULL,
  name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS client_has_pet (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  client_id BIGINT NOT NULL,
  pet_id BIGINT NOT NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS diagnosis (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  diagnosis VARCHAR(300) NOT NULL,
  treatment MEDIUMTEXT)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS diploma (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  university VARCHAR(80) NOT NULL,
  date DATE NOT NULL,
  seria VARCHAR(2) NOT NULL,
  number VARCHAR(10) NOT NULL,
  doctor_id BIGINT NOT NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS doctor (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(45) NOT NULL,
  name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45),
  year_of_birth INT NOT NULL,
  speciality VARCHAR(45))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS doctor_has_service (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  doctor_id BIGINT NOT NULL,
  service_id BIGINT NOT NULL
  )ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS pet (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  animal_species_id BIGINT NOT NULL,
  name VARCHAR(45),
  weight_kg INT,
  length_cm INT,
  date_of_birth DATE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS service (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(80) NOT NULL,
  description MEDIUMTEXT,
  price_usd DECIMAL(5,2) NOT NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS schedule (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  doctor_id BIGINT NOT NULL,
  time_start TIME NOT NULL,
  time_end TIME NOT NULL,
  week_day VARCHAR(15) NOT NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS visit (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  date_time DATETIME NOT NULL,
  client_has_pet_id BIGINT NOT NULL,
  service_id BIGINT NOT NULL,
  schedule_id BIGINT NOT NULL,
  diagnosis_id BIGINT NOT NULL UNIQUE)
ENGINE = InnoDB;

-- -------------------------------------------------
ALTER TABLE animal_species_has_service
ADD CONSTRAINT fk_animal_species_has_service_service1
FOREIGN KEY (service_id)
REFERENCES service (id),
ADD CONSTRAINT fk_animal_species_has_service_animal_species1
FOREIGN KEY (animal_species_id)
REFERENCES animal_species (id);

ALTER TABLE client_has_pet
ADD CONSTRAINT fk_client_has_pet_client1
FOREIGN KEY (client_id)
REFERENCES client (id),
ADD CONSTRAINT fk_client_has_pet_pet1
FOREIGN KEY (pet_id)
REFERENCES pet (id);

ALTER TABLE diploma
ADD CONSTRAINT fk_diploma_doctor1
FOREIGN KEY (doctor_id)
REFERENCES doctor (id);

ALTER TABLE doctor_has_service
ADD CONSTRAINT fk_doctor_has_service_doctor1
FOREIGN KEY (doctor_id)
REFERENCES doctor (id),
ADD CONSTRAINT fk_doctor_has_service_service1
FOREIGN KEY (service_id)
REFERENCES service (id);

ALTER TABLE pet
ADD CONSTRAINT fk_pet_animal_species1
FOREIGN KEY (animal_species_id)
REFERENCES animal_species (id);

ALTER TABLE schedule
ADD CONSTRAINT fk_schedule_doctor1
FOREIGN KEY (doctor_id)
REFERENCES doctor (id);

ALTER TABLE visit
ADD CONSTRAINT fk_visit_client_has_pet1
FOREIGN KEY (client_has_pet_id)
REFERENCES client_has_pet (id),
ADD CONSTRAINT fk_visit_service1
FOREIGN KEY (service_id)
REFERENCES service (id),
ADD CONSTRAINT fk_visit_schedule1
FOREIGN KEY (schedule_id)
REFERENCES schedule (id),
ADD CONSTRAINT fk_visit_diagnosis1
FOREIGN KEY (diagnosis_id)
REFERENCES diagnosis (id);

-- -----------------------------------------------
CREATE INDEX schedule_doctor_idx ON schedule(doctor_id);
CREATE INDEX visit_diagnosis_idx ON visit(diagnosis_id);

INSERT INTO animal_species (id, species) VALUES
(1, 'fish'),
(2, 'horse'),
(3, 'parrot'),
(4, 'hamster'),
(5, 'cat'),
(6, 'dog'),
(7, 'turtle'),
(8, 'fox'),
(9, 'bull'),
(10, 'mouse');

INSERT INTO client (id, first_name, name, last_name) VALUES 
(1, 'Vytryk', 'Maxymilian', Null),
(2, 'Vytryk', 'Maxymilian', Null),
(3, 'Vytryk', 'Maxymilian', Null),
(4, 'Vytryk', 'Maxymilian', Null),
(5, 'Vytryk', 'Maxymilian', Null),
(6, 'Vytryk', 'Maxymilian', Null),
(7, 'Vytryk', 'Maxymilian', Null),
(8, 'Vytryk', 'Maxymilian', Null),
(9, 'Vytryk', 'Maxymilian', Null),
(10, 'Vytryk', 'Maxymilian', Null),
(11, 'Vytryk', 'Maxymilian', Null),
(12, 'Vytryk', 'Maxymilian', Null);

INSERT INTO diagnosis (id, diagnosis, treatment) VALUES 
(1, 'hronichne sisyanstvo', Null),
(2, 'hronichne sisyanstvo', Null),
(3, 'hronichne sisyanstvo', Null),
(4, 'hronichne sisyanstvo', Null),
(5, 'hronichne sisyanstvo', Null),
(6, 'hronichne sisyanstvo', Null),
(7, 'hronichne sisyanstvo', Null),
(8, 'hronichne sisyanstvo', Null),
(9, 'hronichne sisyanstvo', Null),
(10, 'hronichne sisyanstvo', Null),
(11, 'hronichne sisyanstvo', Null),
(12, 'hronichne sisyanstvo', Null),
(13, 'hronichne sisyanstvo', Null);

INSERT INTO doctor (id, first_name, name, last_name, year_of_birth, speciality) VALUES
(1, 'Vytryk', 'Maxymilian', Null, 1980, 'speciality'),
(2, 'Vytryk', 'Maxymilian', Null, 1980, 'speciality'),
(3, 'Vytryk', 'Maxymilian', Null, 1980, 'speciality'),
(4, 'Vytryk', 'Maxymilian', Null, 1980, 'speciality'),
(5, 'Vytryk', 'Maxymilian', Null, 1980, 'speciality'),
(6, 'Vytryk', 'Maxymilian', Null, 1980, 'speciality'),
(7, 'Vytryk', 'Maxymilian', Null, 1980, 'speciality'),
(8, 'Vytryk', 'Maxymilian', Null, 1980, 'speciality'),
(9, 'Vytryk', 'Maxymilian', Null, 1980, 'speciality'),
(10, 'Vytryk', 'Maxymilian', Null, 1980, 'speciality'),
(11, 'Vytryk', 'Maxymilian', Null, 1980, 'speciality'),
(12, 'Vytryk', 'Maxymilian', Null, 1980, 'speciality');

INSERT INTO diploma (id, university, date, seria, number, doctor_id) VALUES
(1, 'NULP', date('2000-01-01'), 'AA', '0000000000', 1),
(2, 'NULP', date('2000-01-01'), 'AA', '0000000000', 2),
(3, 'NULP', date('2000-01-01'), 'AA', '0000000000', 3),
(4, 'NULP', date('2000-01-01'), 'AA', '0000000000', 4),
(5, 'NULP', date('2000-01-01'), 'AA', '0000000000', 5),
(6, 'NULP', date('2000-01-01'), 'AA', '0000000000', 1),
(7, 'NULP', date('2000-01-01'), 'AA', '0000000000', 2),
(8, 'NULP', date('2000-01-01'), 'AA', '0000000000', 3),
(9, 'NULP', date('2000-01-01'), 'AA', '0000000000', 4),
(10, 'NULP', date('2000-01-01'), 'AA', '0000000000', 5),
(11, 'NULP', date('2000-01-01'), 'AA', '0000000000', 6),
(12, 'NULP', date('2000-01-01'), 'AA', '0000000000', 7),
(13, 'NULP', date('2000-01-01'), 'AA', '0000000000', 8);

INSERT INTO pet (id, animal_species_id) VALUES 
(1, 2),(2, 2),(3, 1),(4, 4),(5, 1),(6, 1),
(7, 5),(8, 1),(9, 1),(10, 1),(11, 5),(12, 1);

INSERT INTO service (id, name, price_usd) VALUES 
(1, 'Vytryk', 10.2),
(2, 'Vytryk', 10.2),
(3, 'Vytryk', 10.2),
(4, 'Vytryk', 10.2),
(5, 'Vytryk', 10.2),
(6, 'Vytryk', 10.2),
(7, 'Vytryk', 10.2),
(8, 'Vytryk', 10.2),
(9, 'Vytryk', 10.2),
(10, 'Vytryk', 10.2),
(11, 'Vytryk', 10.2),
(12, 'Vytryk', 10.2);

INSERT INTO schedule (id, doctor_id, time_start, time_end, week_day) VALUES
(1, 2, '08:00:00', '16:00:00', 'Monday'),
(2, 2, '08:00:00', '16:00:00', 'Monday'),
(3, 1, '08:00:00', '16:00:00', 'Monday'),
(4, 4, '08:00:00', '16:00:00', 'Monday'),
(5, 1, '08:00:00', '16:00:00', 'Monday'),
(6, 1, '08:00:00', '16:00:00', 'Monday'),
(7, 5, '08:00:00', '16:00:00', 'Monday'),
(8, 1, '08:00:00', '16:00:00', 'Monday'),
(9, 1, '08:00:00', '16:00:00', 'Monday'),
(10, 1, '08:00:00', '16:00:00', 'Monday'),
(11, 5, '08:00:00', '16:00:00', 'Monday'),
(12, 1, '08:00:00', '16:00:00', 'Monday');

INSERT INTO animal_species_has_service (id, animal_species_id, service_id) VALUES
(1, 1, 1),(2, 2, 1),(3, 3, 1),(4, 4, 1),(5, 5, 1),(6, 6, 1),(7, 7, 1),(8, 8, 1),(9, 9, 1),
(10, 1, 2),(11, 2, 2),(12, 3, 2),(13, 4, 2),(14, 5, 2),(15, 6, 2),(16, 7, 2),(17, 8, 2),(18, 9, 2),
(19, 1, 3),(20, 2, 3),(21, 3, 3),(22, 4, 3),(23, 5, 3),(24, 6, 3),(25, 7, 3),(26, 8, 3),(27, 9, 3);

INSERT INTO client_has_pet (id, client_id, pet_id) VALUES 
(1, 2, 2),(2, 2, 1),(3, 3, 1),(4, 4, 2),
(5, 1, 3),(6, 1, 6),(7, 5, 5),(8, 1, 1);

INSERT INTO doctor_has_service (id, doctor_id, service_id) VALUES
(1, 1, 2),(2, 2, 2),(3, 3, 1),(4, 4, 4),(5, 5, 1),(6, 6, 1),
(7, 7, 5),(8, 8, 1),(9, 9, 1),(10, 10, 1),(11, 11, 5),(12, 12, 1);

INSERT INTO visit (id, date_time, client_has_pet_id, service_id, schedule_id, diagnosis_id) VALUES
(1, '2020-01-01 10:00:00', 2, 1, 1, 1),
(2, '2020-01-01 10:00:00', 2, 1, 1, 2),
(3, '2020-01-01 10:00:00', 2, 1, 1, 3),
(4, '2020-01-01 10:00:00', 2, 1, 1, 4),
(5, '2020-01-01 10:00:00', 2, 1, 1, 5),
(6, '2020-01-01 10:00:00', 2, 1, 1, 6),
(7, '2020-01-01 10:00:00', 2, 1, 1, 7),
(8, '2020-01-01 10:00:00', 2, 1, 1, 8),
(9, '2020-01-01 10:00:00', 2, 1, 1, 9),
(10, '2020-01-01 10:00:00', 2, 1, 1, 10),
(11, '2020-01-01 10:00:00', 2, 1, 1, 11);




