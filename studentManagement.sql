CREATE DATABASE IF NOT EXISTS `StudentManagement` 
CHARACTER SET utf8mb4 
COLLATE utf8mb4_general_ci;

USE StudentManagement;

CREATE TABLE `course` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `course_name` VARCHAR(50),
    `course_id` VARCHAR(50),
    `credit` INT,
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_course_id` (`course_id`)
) ENGINE=INNODB
AUTO_INCREMENT=1
DEFAULT CHARSET=UTF8MB4
COLLATE=UTF8MB4_UNICODE_CI;

CREATE TABLE `student` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `last_name` VARCHAR(45) DEFAULT NULL,
    `first_name` VARCHAR(45) DEFAULT NULL,
    `email` VARCHAR(45) DEFAULT NULL,
    `student_id` VARCHAR(50),
    `course_id` INT,
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_student_id` (`student_id`),
    FOREIGN KEY (`course_id`) REFERENCES `course`(`id`)
) ENGINE=INNODB
AUTO_INCREMENT=1
DEFAULT CHARSET=UTF8MB4
COLLATE=UTF8MB4_UNICODE_CI;

CREATE TABLE `studentdetail` (
    `id` INT,
    `phone_number` VARCHAR(11) CHECK (phone_number REGEXP '^[0-9]{10}$'),
    `address` VARCHAR(255),
    `grade` INT,
    `date_of_birth` DATE,
    FOREIGN KEY (`id`) REFERENCES `student`(`id`)
) ENGINE=INNODB
DEFAULT CHARSET=UTF8MB4
COLLATE=UTF8MB4_UNICODE_CI;

CREATE TABLE `teacher` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `last_name` VARCHAR(45) DEFAULT NULL,
    `first_name` VARCHAR(45) DEFAULT NULL,
    `email` VARCHAR(45) DEFAULT NULL,
    `teacher_id` VARCHAR(50),
    `course_id` INT,
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_teacher_id` (`teacher_id`),
    FOREIGN KEY (`course_id`) REFERENCES `course`(`id`)
) ENGINE=INNODB
AUTO_INCREMENT=1
DEFAULT CHARSET=UTF8MB4
COLLATE=UTF8MB4_UNICODE_CI;

CREATE TABLE `teacherdetail` (
    `id` INT,
    `phone_number` VARCHAR(11) CHECK (phone_number REGEXP '^[0-9]{10}$'),
    `address` VARCHAR(255),
    `major` VARCHAR(50),
    `date_of_birth` DATE,
    FOREIGN KEY (`id`) REFERENCES `teacher`(`id`)
) ENGINE=INNODB
DEFAULT CHARSET=UTF8MB4
COLLATE=UTF8MB4_UNICODE_CI;

INSERT INTO `course` (`course_name`, `course_id`, `credit`) VALUES
    ('Mathematics', 'MATH101', 3),
    ('Physics', 'PHYS201', 4);
select * from student;
INSERT INTO `student` (`last_name`, `first_name`, `email`, `student_id`, `course_id`) VALUES
    ('Nguyen', 'Van A', 'vana@gmail.com', 'STD101', 1),
    ('Tran', 'Thi B', 'thib@gmail.com', 'STD102', 2);

INSERT INTO `studentdetail` (`id`, `phone_number`, `address`, `grade`, `date_of_birth`) VALUES
    (1, '8416439760', 'Ninh Kieu, Can Tho', 10, '2003-05-15'),
    (2, '8476543210', 'An Binh, Can Tho', 11, '2002-08-20');
    

INSERT INTO `teacher` (`last_name`, `first_name`, `email`, `teacher_id`, `course_id`) VALUES
    ('Tran', 'Tien Dat', 'trandat@gmail.com', 'TCH101', 1),
    ('Le', 'Thi Phuong', 'lephuong@gmail.com', 'TCH102', 2);

INSERT INTO `teacherdetail` (`id`, `phone_number`, `address`, `major`, `date_of_birth`) VALUES
    (1, '8412345678', 'Binh Thuy, Can Tho', 'Computer Science', '1985-10-12'),
    (2, '8476541234', 'Ninh Kieu, Can Tho', 'Physics', '1980-08-25');
#create procedure to insert sutdent
DELIMITER //

CREATE PROCEDURE InsertStudentWithDetail(
    IN last_name VARCHAR(45),
    IN first_name VARCHAR(45),
    IN email VARCHAR(45),
    IN student_id VARCHAR(50),
    IN course_id INT,
    IN phone_number VARCHAR(11),
    IN address VARCHAR(255),
    IN grade INT,
    IN date_of_birth DATE
)
BEGIN
    DECLARE student_id_val INT;

    -- Insert into student table
    INSERT INTO student (last_name, first_name, email, student_id, course_id)
    VALUES (last_name, first_name, email, student_id, course_id);

    -- Get the auto-generated ID from the last insert
    SET student_id_val = LAST_INSERT_ID();

    -- Insert into studentdetail table
    INSERT INTO studentdetail (id, phone_number, address, grade, date_of_birth)
    VALUES (student_id_val, phone_number, address, grade, date_of_birth);
    
    COMMIT;
END //

DELIMITER ;

CALL InsertStudentWithDetail('Nguyen', 'Thi B', 'thib@gmail.com', 'B2111746', 1, '8412345678', '123 Street, City', 10, '2000-01-01');

#create procedure to insert teacher, teacherdetail
DELIMITER //

DROP PROCEDURE IF EXISTS InsertTeacherWithDetail;

CREATE PROCEDURE InsertTeacherWithDetail(
    IN last_name VARCHAR(45),
    IN first_name VARCHAR(45),
    IN email VARCHAR(45),
    IN teacher_id VARCHAR(50),
    IN course_id INT,
    IN phone_number VARCHAR(11),
    IN address VARCHAR(255),
    IN major VARCHAR(50),
    IN date_of_birth DATE
)
BEGIN
    DECLARE teacher_id_val INT;

    -- Insert into teacher table
    INSERT INTO teacher (last_name, first_name, email, teacher_id, course_id)
    VALUES (last_name, first_name, email, teacher_id, course_id);

    -- Get the auto-generated ID from the last insert
    SET teacher_id_val = LAST_INSERT_ID();

    -- Insert into teacherdetail table
    INSERT INTO teacherdetail (id, phone_number, address, major, date_of_birth)
    VALUES (teacher_id_val, phone_number, address, major, date_of_birth);
    COMMIT;
END //

DELIMITER ;

CALL InsertTeacherWithDetail('Nguyen', 'Van Thanh', 'thanh@gmail.com', 'B2111885', 1, '8412345678', '123 Main St', 'IT', '2000-01-01');

DELIMITER //
DROP PROCEDURE IF EXISTS ShowAllStudentsWithDetails;
CREATE PROCEDURE ShowAllStudentsWithDetails()
BEGIN
    SELECT 
        s.id,
        s.last_name,
        s.first_name,
        s.email,
        s.student_id,
        sd.phone_number,
        sd.address,
        sd.grade,
        sd.date_of_birth
    FROM 
        student s
    INNER JOIN 
        studentdetail sd ON s.id = sd.id;
        
END //

DELIMITER ;

CALL ShowAllStudentsWithDetails();




