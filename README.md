# University Management System

## Project Overview

The University Management System is a desktop application developed using Java Swing, JDBC, and MySQL. It provides a secure role-based platform for managing university operations, including student records, professor records, academic grades, and user authentication.

The system is designed with three user roles:

- Administrator
- Professor
- Student

Each role has its own permissions and functionalities to ensure secure and efficient management of university data.

---

## Features

### Administrator

- Secure Login
- Register New Administrator
- Add Student
- Edit Student
- Delete Student
- Add Professor
- Edit Professor
- Delete Professor

---

### Professor

- Secure Login
- Assign Grades
- Modify Assigned Grades
- View Student Academic Records

---

### Student

- Secure Login
- View Personal Information
- View Semester-wise Grades

---

## Technology Stack

| Technology | Description |
|------------|-------------|
| Java | Programming Language |
| Java Swing | Graphical User Interface |
| JDBC | Database Connectivity |
| MySQL | Relational Database |
| NetBeans IDE | Development Environment |
| SQL | Database Language |

---

## System Architecture

```
                     UNIVERSITY MANAGEMENT SYSTEM

                             Login Module
                                   │
            ┌──────────────────────┼──────────────────────┐
            │                      │                      │
            ▼                      ▼                      ▼

     Administrator            Professor              Student

            │                      │                      │

   Student Management      Grade Management      Student Portal
   Professor Management    Grade Modification    Personal Details
   User Management         Student Snapshot      Grade Report

                           MySQL Database
```

---

## Modules

### Authentication Module

- User Login
- User Registration
- Role-Based Authentication

### Administrator Module

- Student Management
- Professor Management
- User Management

### Professor Module

- Grade Assignment
- Grade Modification
- Student Grade Report

### Student Module

- Personal Information
- Semester-wise Grade Report

---

## Database

The system uses MySQL as the backend database and consists of the following tables:

- USER
- STUDENT_MASTER
- PROFESSOR_MASTER
- PROFESSOR_DEGREE
- STUDENT_GRADE
