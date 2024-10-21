# Student Management Application

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Database Design](#database-design)
- [Demo Video](#demo-video)
- [Screenshots](#screenshots)

## Project Overview
The **Student Management Application** is a web-based system built to manage student records efficiently. The system allows administrators to register, update, delete and view student details. This project follows the MVC architecture and uses **JDBC** for database connectivity, **Servlets** for server-side logic, and **JSP** for the user interface.

## Features
- Add new students.
- View student records.
- Update student details.
- Delete student records.
- User-friendly interface.

## Technologies Used
- **Frontend**: HTML, CSS, Bootstrap, JSP
- **Backend**: Java (Servlets, JSP)
- **Database**: MySQL
- **Database Connectivity**: JDBC
- **Server**: Apache Tomcat

## Demo Video
https://drive.google.com/drive/u/0/folders/1eBdHa9_L6W3XJebMYp22DOX9LfsCS9In

## Database Design
The application uses a MySQL database with the following table structure:

```sql
CREATE DATABASE studentmanagementsystem;;

USE studentmanagementsystem;

CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fname VARCHAR(40),
    lname VARCHAR(40),
    email VARCHAR(40),
    dob VARCHAR(40),
    course VARCHAR(40)
);

