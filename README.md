# Campus Bookstore Management System

A Java desktop application for managing students, employees, textbook reservations, and bookstore-related operations.

The project combines **Java OOP**, **Swing GUI**, **MySQL**, **JDBC**, file persistence, and basic data-integrity checking.

## Features

- Student management
  - Add students
  - Delete students
  - View student details
  - List registered students

- Employee management
  - Add employees
  - Delete employees
  - View employee details
  - List employees

- Textbook reservations
  - Create reservations
  - Add multiple book items
  - Track payment status
  - Calculate reservation cost
  - Retrieve reservation details by student and date

- Student loyalty comparison
  - Compares students based on the total quantity of reserved books

- Student identity-check records

- MySQL database persistence using JDBC

- File-based persistence

- Student data integrity verification using MD5 checksums

- Java Swing graphical user interface

## Technologies

- Java
- Java Swing
- JDBC
- MySQL
- SQL
- Object-Oriented Programming
- Java Serialization
- File I/O
- MD5 File Integrity Checking

## Object-Oriented Design

The application uses several OOP concepts including:

- Inheritance
- Abstract classes
- Interfaces
- Encapsulation
- Polymorphism
- Comparable
- Serialization

The base `User` class is extended by:

```text
User
├── Student
└── Employee
