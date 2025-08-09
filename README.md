Academic Management System
A full-stack web application for managing Students, Courses, and Faculty with role-based access control. Built using Java, Spring Boot, MySQL, HTML, CSS, and JavaScript, the system allows admins to perform full CRUD operations, while students and faculty have restricted view access.

Features
Admin
Add, view, edit, and delete students, courses, and faculty.

Assign students to courses.

Manage faculty-course assignments.

Student
View student details.

View available courses.

Faculty
View faculty details.

View assigned courses.

Tech Stack
Frontend: HTML, CSS, JavaScript

Backend: Java, Spring Boot

Database: MySQL (via Spring Data JPA & Hibernate)

Tools: IntelliJ IDEA, Maven

Project Structure
bash
Copy
Edit
Academic-Management-System/
│
├── src/main/java/com/ams
│   ├── controller       # REST Controllers
│   ├── service          # Service Layer
│   ├── repository       # Data Access Layer
│   ├── model            # Entity Classes
│   └── AcademicManagementSystemApplication.java
│
├── src/main/resources
│   ├── static           # HTML, CSS, JavaScript files
│   ├── templates        # Thymeleaf/JSP templates (if applicable)
│   └── application.properties
│
└── pom.xml
