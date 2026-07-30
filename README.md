# University Management System

## Overview

The **University Management System** is a Java Swing desktop application developed to manage students, professors, authentication, and semester-wise grades in a university environment.

The application provides separate login privileges for **Administrator**, **Professor**, and **Student**, ensuring role-based access to the system. Data is stored permanently in a **MySQL** database using **JDBC** connectivity.

<img width="588" height="351" alt="Screenshot 2026-07-30 221144" src="https://github.com/user-attachments/assets/1bc0d767-820e-43df-af26-d3c235467fc3" />
<img width="559" height="303" alt="Screenshot 2026-07-30 221204" src="https://github.com/user-attachments/assets/d1a0fe9f-5836-44f7-a564-8299450bd871" />
<img width="543" height="327" alt="Screenshot 2026-07-30 221219" src="https://github.com/user-attachments/assets/d03145d1-8763-4e9c-ac94-a09ba2070c07" />
<img width="894" height="670" alt="Screenshot 2026-07-30 221234" src="https://github.com/user-attachments/assets/8d9f15ab-8fd2-44ad-91eb-88ef97c35fc3" />
<img width="934" height="679" alt="Screenshot 2026-07-30 221246" src="https://github.com/user-attachments/assets/8dfc9cd1-1c59-4c0e-9992-91e2855c558b" />
<img width="929" height="686" alt="Screenshot 2026-07-30 221256" src="https://github.com/user-attachments/assets/b1398d66-4f8d-4196-9adb-925c9c98ce4c" />
<img width="932" height="684" alt="Screenshot 2026-07-30 221306" src="https://github.com/user-attachments/assets/e87f132a-be5d-4676-957f-f1b180bbc4ac" />
<img width="926" height="659" alt="Screenshot 2026-07-30 221317" src="https://github.com/user-attachments/assets/06112408-efbd-40e3-be01-6b607108e68b" />
<img width="546" height="575" alt="Screenshot 2026-07-30 224348" src="https://github.com/user-attachments/assets/07676b5d-ed8a-4306-80a2-42a2a235dc62" />
<img width="825" height="644" alt="Screenshot 2026-07-30 224413" src="https://github.com/user-attachments/assets/fde33a38-f587-432f-becb-c80b65941612" />
<img width="559" height="608" alt="Screenshot 2026-07-30 224502" src="https://github.com/user-attachments/assets/c4fd4d69-1255-494b-bb34-5ee3af9c140d" />
<img width="569" height="571" alt="Screenshot 2026-07-30 224539" src="https://github.com/user-attachments/assets/888a6d88-0bef-49ea-afd5-a6718fb8e94e" />
<img width="872" height="641" alt="Screenshot 2026-07-30 224609" src="https://github.com/user-attachments/assets/1bd7ddf7-d7b3-4308-a56e-d30c17a9f973" />
<img width="844" height="676" alt="Screenshot 2026-07-30 224622" src="https://github.com/user-attachments/assets/d55fb585-7cd3-4fbc-9dfe-c8aeb1d7e3e6" />
<img width="860" height="657" alt="Screenshot 2026-07-30 224639" src="https://github.com/user-attachments/assets/bd735da5-e541-4bd3-b145-8cfe3a9f5b82" />
<img width="842" height="649" alt="Screenshot 2026-07-30 224650" src="https://github.com/user-attachments/assets/a7762ec0-5b59-4602-9eda-4a639d80639d" />
<img width="952" height="662" alt="Screenshot 2026-07-30 224708" src="https://github.com/user-attachments/assets/fbf237aa-2a06-421a-8d9a-4ee70cb6d3fd" />
<img width="842" height="660" alt="Screenshot 2026-07-30 224850" src="https://github.com/user-attachments/assets/67ce50a3-399d-45c7-a868-9c3ccf96bab9" />
<img width="928" height="713" alt="Screenshot 2026-07-30 224903" src="https://github.com/user-attachments/assets/4bb06b9e-729c-4492-9572-23863e66d46b" />


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
