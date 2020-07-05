CREATE SCHEMA IF NOT EXISTS `university_db`;

CREATE TABLE IF NOT EXISTS `university_db`.`department` (
    `id_department` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `description` VARCHAR(255) NULL DEFAULT NULL,
    `prefix` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`id_department`));


CREATE TABLE IF NOT EXISTS `university_db`.`student` (
  `registry_number` VARCHAR(45) NOT NULL,
  `id_user` VARCHAR(45) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `surname` VARCHAR(255) NULL DEFAULT NULL,
  `enroll_date` DATE NULL DEFAULT NULL,
  `semester` INT(11) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `id_department` INT(11) NOT NULL,
  PRIMARY KEY (`registry_number`),
--   INDEX `fk_student_department_idx` (`id_department` ASC) VISIBLE,
--   UNIQUE INDEX `id_user_UNIQUE` (`id_user` ASC) VISIBLE,
  CONSTRAINT `fk_student_department`
    FOREIGN KEY (`id_department`)
    REFERENCES `university_db`.`department` (`id_department`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `university_db`.`announcement` (
  `id_announcement` INT(11) NOT NULL,
  `id_department` INT(11) NOT NULL,
  `title` VARCHAR(45) NULL DEFAULT NULL,
  `content` VARCHAR(255) NULL DEFAULT NULL,
  `ins_date` DATE NULL DEFAULT NULL,
  `id_employee` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_announcement`),
  CONSTRAINT `fk_announcement_department1`
      FOREIGN KEY (`id_department`)
          REFERENCES `university_db`.`department` (`id_department`)
          ON DELETE NO ACTION
          ON UPDATE NO ACTION,
  CONSTRAINT `fk_announcement_employee1`
      FOREIGN KEY (`id_employee`)
          REFERENCES `university_db`.`employee` (`id_employee`)
          ON DELETE NO ACTION
          ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `university_db`.`employee` (
  `id_employee` VARCHAR(45) NOT NULL,
  `id_user` VARCHAR(45) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `surname` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `site_url` VARCHAR(255) NULL DEFAULT NULL,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `title` VARCHAR(45) NULL DEFAULT NULL,
  `id_department` INT(11) NOT NULL,
  PRIMARY KEY (`id_employee`),
--   UNIQUE INDEX `id_user_UNIQUE` (`id_user` ASC) VISIBLE,
--   INDEX `fk_employee_department1_idx` (`id_department` ASC) VISIBLE,
  CONSTRAINT `fk_employee_department1`
    FOREIGN KEY (`id_department`)
    REFERENCES `university_db`.`department` (`id_department`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `university_db`.`course` (
  `id_course` INT(11) NOT NULL,
  `id_department` INT(11) NOT NULL,
  `course_registry_number` VARCHAR(45) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `name_english` VARCHAR(255) NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `description_english` VARCHAR(255) NULL DEFAULT NULL,
  `semester` INT(11) NULL DEFAULT NULL,
  `ects` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_course`),
--   INDEX `fk_course_department1_idx` (`id_department` ASC) VISIBLE,
--   UNIQUE INDEX `course_registry_number_UNIQUE` (`course_registry_number` ASC) VISIBLE,
  CONSTRAINT `fk_course_department1`
    FOREIGN KEY (`id_department`)
    REFERENCES `university_db`.`department` (`id_department`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `university_db`.`professor_has_course` (
  `id_employee` VARCHAR(45) NOT NULL,
  `id_course` INT(11) NOT NULL,
  PRIMARY KEY (`id_employee`, `id_course`),
--   INDEX `fk_employee_has_course_course1_idx` (`id_course` ASC) VISIBLE,
--   INDEX `fk_employee_has_course_employee1_idx` (`id_employee` ASC) VISIBLE,
  CONSTRAINT `fk_employee_has_course_employee1`
    FOREIGN KEY (`id_employee`)
    REFERENCES `university_db`.`employee` (`id_employee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employee_has_course_course1`
    FOREIGN KEY (`id_course`)
    REFERENCES `university_db`.`course` (`id_course`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `university_db`.`course_has_student` (
  `id_course` INT(11) NOT NULL,
  `student_registry_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_course`, `student_registry_number`),
--   INDEX `fk_course_has_student_student1_idx` (`student_registry_number` ASC) VISIBLE,
--   INDEX `fk_course_has_student_course1_idx` (`id_course` ASC) VISIBLE,
  CONSTRAINT `fk_course_has_student_course1`
    FOREIGN KEY (`id_course`)
    REFERENCES `university_db`.`course` (`id_course`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_course_has_student_student1`
    FOREIGN KEY (`student_registry_number`)
    REFERENCES `university_db`.`student` (`registry_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `university_db`.`university_service` (
  `id_university_service` INT(11) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_university_service`));

CREATE TABLE IF NOT EXISTS `university_db`.`university_application_type` (
  `id_university_application_type` INT(11) NOT NULL,
  `id_university_service` INT(11) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id_university_application_type`),
--   INDEX `fk_university_application_type_university_service1_idx` (`id_university_service` ASC) VISIBLE,
  CONSTRAINT `fk_university_application_type_university_service1`
    FOREIGN KEY (`id_university_service`)
    REFERENCES `university_db`.`university_service` (`id_university_service`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `university_db`.`student_application` (
  `id_student_application` INT(11) NOT NULL,
  `notes` VARCHAR(255) NULL DEFAULT NULL,
  `id_university_application_type` INT(11) NOT NULL,
  `student_registry_number` VARCHAR(45) NOT NULL,
  `application_date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id_student_application`),
--   INDEX `fk_student_application_university_application_type1_idx` (`id_university_application_type` ASC) VISIBLE,
--   INDEX `fk_student_application_student1_idx` (`student_registry_number` ASC) VISIBLE,
  CONSTRAINT `fk_student_application_university_application_type1`
    FOREIGN KEY (`id_university_application_type`)
    REFERENCES `university_db`.`university_application_type` (`id_university_application_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_student_application_student1`
    FOREIGN KEY (`student_registry_number`)
    REFERENCES `university_db`.`student` (`registry_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);