# University Management System

## Overview

The **University Management System (UMS)** is a Java Swing desktop application developed to manage students, professors, authentication, and semester-wise grades in a university environment.

The application provides separate login privileges for **Administrator**, **Professor**, and **Student**, ensuring role-based access to the system. Data is stored permanently in a **MySQL** database using **JDBC** connectivity.

The project demonstrates the implementation of:

- Java Swing GUI
- JDBC Database Connectivity
- MySQL Database
- Role Based Authentication
- CRUD Operations
- Relational Database Design
- PreparedStatement
- Primary Key & Foreign Key Constraints

---

# Technologies Used

| Technology | Version |
|------------|----------|
| Java | JDK 8+ |
| Java Swing | GUI |
| JDBC | MySQL Connector/J |
| MySQL | 8.0+ |
| IDE | NetBeans / Eclipse |

---

# Features

## Administrator

Administrator has complete control over the system.

Functions include:

- Register Student
- Register Professor
- Edit Student Information
- Edit Professor Information
- Delete Student
- Delete Professor
- Create User Accounts
- Manage Authentication
- Exit System

---

## Professor

Professor is responsible for academic records.

Functions include:

- Assign Semester Grade
- Modify Existing Grade
- View Complete Student Grade Snapshot
- Exit System

---

## Student

Student can only access his/her own information.

Functions include:

- View Personal Details
- View Semester-wise Grades
- Print Reports
- Exit System

---

# Authentication System

The application supports **Role-Based Login**.

Available Roles:

- Administrator
- Professor
- Student

Authentication is performed using the **USER** table.

```
USER ID
PASSWORD
ROLE
```

Only valid credentials allow access.

---

# Software Architecture

```
                +----------------+
                | Login Screen   |
                +-------+--------+
                        |
          +-------------+--------------+
          |             |              |
          |             |              |
      Administrator  Professor      Student
          |             |              |
          |             |              |
   CRUD Operations   Grade Module   View Module
          |             |              |
          +-------------+--------------+
                        |
                   JDBC Driver
                        |
                   MySQL Database
```

---

# Database Design

The system contains five tables.

```
USER
STUDENT_MASTER
PROFESSOR_MASTER
PROFESSOR_DEGREE
STUDENT_GRADE
```

---

# Entity Relationship Diagram (ER Diagram)

```
                               +----------------------+
                               |        USER          |
                               +----------------------+
                               | PK userid            |
                               | password             |
                               | role                 |
                               +----------------------+

                    (Authentication Only)



+---------------------------+
|      STUDENT_MASTER       |
+---------------------------+
| PK student_id             |
| name                      |
| father_name               |
| gender                    |
| address                   |
| dob                       |
| phone                     |
| email                     |
| course                    |
| semester                  |
+---------------------------+
             |
             | 1
             |
             |
             | M
+---------------------------+
|      STUDENT_GRADE        |
+---------------------------+
| PK/FK student_id          |
| PK semester               |
| grade                     |
+---------------------------+



+-----------------------------+
|     PROFESSOR_MASTER        |
+-----------------------------+
| PK professor_id             |
| name                        |
| address                     |
| gender                      |
| phone                       |
| email                       |
| dob                         |
| doj                         |
+-----------------------------+
              |
              | 1
              |
              |
              | M
+-----------------------------+
|    PROFESSOR_DEGREE         |
+-----------------------------+
| PK/FK professor_id          |
| PK degree                   |
+-----------------------------+
```

---

# Database Relationships

## USER

Authentication table.

No foreign key relationships.

---

## STUDENT_MASTER → STUDENT_GRADE

Relationship

```
One Student
        |
        |
        +------< Multiple Semester Grades
```

Foreign Key

```
student_grade.student_id
        references
student_master.student_id
```

Relationship Type

```
One-to-Many (1:M)
```

---

## PROFESSOR_MASTER → PROFESSOR_DEGREE

Relationship

```
One Professor
        |
        |
        +------< Multiple Degrees
```

Foreign Key

```
professor_degree.professor_id
        references
professor_master.professor_id
```

Relationship Type

```
One-to-Many (1:M)
```

---

# Database Schema

---

## USER

| Column | Data Type | Constraint |
|----------|------------|------------|
| userid | VARCHAR(20) | Primary Key |
| password | VARCHAR(20) | NOT NULL |
| role | VARCHAR(9) | NOT NULL |

SQL

```sql
CREATE TABLE USER
(
    userid VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20),
    role VARCHAR(9)
);
```

---

## STUDENT_MASTER

| Column | Data Type | Constraint |
|----------|------------|------------|
| student_id | VARCHAR(15) | Primary Key |
| name | VARCHAR(20) | NOT NULL |
| father_name | VARCHAR(20) | NOT NULL |
| gender | VARCHAR(6) | NOT NULL |
| address | VARCHAR(50) | NOT NULL |
| dob | DATE | NOT NULL |
| phone | VARCHAR(12) | NOT NULL |
| email | VARCHAR(30) | NOT NULL |
| course | VARCHAR(5) | NOT NULL |
| semester | CHAR(1) | NOT NULL |

SQL

```sql
CREATE TABLE STUDENT_MASTER
(
    student_id VARCHAR(15) PRIMARY KEY,
    name VARCHAR(20),
    father_name VARCHAR(20),
    gender VARCHAR(6),
    address VARCHAR(50),
    dob DATE,
    phone VARCHAR(12),
    email VARCHAR(30),
    course VARCHAR(5),
    semester CHAR(1)
);
```

---

## STUDENT_GRADE

| Column | Data Type | Constraint |
|----------|------------|------------|
| student_id | VARCHAR(15) | Primary Key, Foreign Key |
| semester | CHAR(1) | Primary Key |
| grade | CHAR(1) | NOT NULL |

SQL

```sql
CREATE TABLE STUDENT_GRADE
(
    student_id VARCHAR(15),
    semester CHAR(1),
    grade CHAR(1),
    PRIMARY KEY(student_id,semester),
    FOREIGN KEY(student_id)
    REFERENCES STUDENT_MASTER(student_id)
    ON DELETE CASCADE
);
```

---

## PROFESSOR_MASTER

| Column | Data Type | Constraint |
|----------|------------|------------|
| professor_id | VARCHAR(13) | Primary Key |
| name | VARCHAR(20) | NOT NULL |
| address | VARCHAR(50) | NOT NULL |
| gender | VARCHAR(6) | NOT NULL |
| phone | VARCHAR(12) | NOT NULL |
| email | VARCHAR(30) | NOT NULL |
| dob | DATE | NOT NULL |
| doj | DATE | NOT NULL |

SQL

```sql
CREATE TABLE PROFESSOR_MASTER
(
    professor_id VARCHAR(13) PRIMARY KEY,
    name VARCHAR(20),
    address VARCHAR(50),
    gender VARCHAR(6),
    phone VARCHAR(12),
    email VARCHAR(30),
    dob DATE,
    doj DATE
);
```

---

## PROFESSOR_DEGREE

| Column | Data Type | Constraint |
|----------|------------|------------|
| professor_id | VARCHAR(13) | Primary Key, Foreign Key |
| degree | VARCHAR(10) | Primary Key |

SQL

```sql
CREATE TABLE PROFESSOR_DEGREE
(
    professor_id VARCHAR(13),
    degree VARCHAR(10),
    PRIMARY KEY(professor_id,degree),
    FOREIGN KEY(professor_id)
    REFERENCES PROFESSOR_MASTER(professor_id)
    ON DELETE CASCADE
);
```

---

# Database Normalization

The database follows normalization principles.

- First Normal Form (1NF)
- Second Normal Form (2NF)
- Third Normal Form (3NF)

Advantages

- No duplicate records
- Reduced redundancy
- Better consistency
- Improved integrity
- Easy maintenance

---

# JDBC Connectivity

The application connects to MySQL using JDBC.

```java
Class.forName("com.mysql.cj.jdbc.Driver");

Connection con =
DriverManager.getConnection(
"jdbc:mysql://localhost:3306/unisys?autoReconnect=true&useSSL=false",
"root",
"1234"
);
```

---

# Modules

## Login Module

Responsible for authentication.

Operations

- Sign In
- Sign Up
- Role Verification

---

## Student Module

Operations

- Add Student
- Edit Student
- Delete Student
- View Personal Details
- View Semester Information

---

## Professor Module

Operations

- Add Professor
- Edit Professor
- Delete Professor
- Store Qualification Details

---

## Grade Module

Operations

- Assign Grade
- Edit Grade
- Semester-wise Grade Management

---

## Snapshot Module

Displays all students together with their semester grades for professors.

---

# Grade Scale

| Grade | Meaning |
|--------|---------|
| O | Outstanding |
| E | Excellent |
| A | Very Good |
| B | Good |
| C | Average |
| D | Pass |
| F | Fail |

---

# Security Features

- Login Authentication
- Role Based Authorization
- PreparedStatement to prevent SQL Injection
- Primary Key Constraints
- Foreign Key Constraints
- Cascading Delete
- Data Validation through GUI

---

# Advantages

- User-friendly graphical interface
- Centralized student records
- Permanent database storage
- Secure authentication
- Fast retrieval of information
- Reduced paperwork
- Easy maintenance
- Extensible architecture
- Modular implementation
- Relational database design

---

# Installation

Clone the repository.

```bash
git clone https://github.com/Soumyadxxp/University_Management_System.git
```

Import the project into NetBeans or Eclipse.

Add the MySQL Connector/J library.

Create a MySQL database named:

```sql
CREATE DATABASE unisys;
```

Run `LoginMain.java`.

The required tables will be created automatically on the first execution if they do not already exist.

---

# Author

**Soumyadeep Basu**
