CREATE DATABASE IF NOT EXISTS campusbookstore;
USE campusbookstore;
CREATE TABLE Student (
    studentId INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    dateOfBirth DATE
);
CREATE TABLE Employee (
    employeeId INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    dateOfBirth DATE,
    startDate DATE
);
INSERT INTO Student (studentId, name, dateOfBirth)
VALUES
(1001, 'Ali', '2002-05-14'),
(1002, 'Ayse', '2001-11-03');

INSERT INTO Employee (employeeId, name, dateOfBirth, startDate)
VALUES
(1, 'Mehmet', '1985-02-20', '2015-09-01'),
(2, 'Elif', '1990-07-10', '2018-03-15');
SELECT * FROM Student;
SELECT * FROM Employee;
