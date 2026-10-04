Student Management SystemA robust, console-based Java application built using Core Java, JDBC, and MySQL. This application provides complete record management (CRUD operations) for academic student data, automated performance metrics (Total, Percentage, Grade), and direct database persistence.📌 FeaturesCRUD Operations:Create: Add new student records with personal details and exam marks.Read: View complete list of student records in clean tabular layout or search by Student ID.Update: Modify existing personal details or marks; performance metrics update automatically.Delete: Remove student records securely using Student ID.Automated Calculations: Automatically calculates Total Marks, Percentage, and assigns Letter Grades ($A+$, $A$, $B$, $C$, $D$, $F$) based on individual subject scores.Secure Database Access: Uses JDBC PreparedStatement interfaces to prevent SQL Injection vulnerabilities.Robust Input Validation: Prevents application crashes from invalid data types or runtime input errors.🛠️ Tech Stack & ConceptsProgramming Language: Java (JDK 17+)Database: MySQL Server 8.0+Connectivity: JDBC (Java Database Connectivity) & MySQL Connector/JDesign Patterns/Concepts: Object-Oriented Programming (OOP), Data Access Object (DAO) Pattern, Model-View-Controller (MVC) Separation, Exception Handling, Structured Query Language (SQL)📂 Project ArchitectureStudentManagementSystem/
│
├── lib/
│   └── mysql-connector-j-8.x.x.jar    # JDBC Driver
├── schema.sql                          # Database creation & sample data script
├── DatabaseConfig.java                 # Handles MySQL database connections
├── Student.java                        # Model class (Encapsulation & Business Logic)
├── StudentDAO.java                     # Data Access Object (CRUD Operations / SQL Queries)
├── Main.java                           # Menu-driven CLI interface
└── README.md                           # Documentation
🚀 Getting StartedPrerequisitesEnsure you have the following installed on your machine:Java Development Kit (JDK 17 or higher)MySQL Community ServerMySQL Connector/J JARSetup & Installation1. Database SetupOpen MySQL Workbench or MySQL CLI and run the contents of schema.sql:CREATE DATABASE IF NOT EXISTS student_db;
USE student_db;

CREATE TABLE IF NOT EXISTS students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    department VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL,
    mark1 DOUBLE DEFAULT 0.0,
    mark2 DOUBLE DEFAULT 0.0,
    mark3 DOUBLE DEFAULT 0.0,
    total_marks DOUBLE DEFAULT 0.0,
    percentage DOUBLE DEFAULT 0.0,
    grade VARCHAR(5) DEFAULT 'F'
);
2. Configure Database CredentialsOpen DatabaseConfig.java and update the PASSWORD field with your MySQL root password:private static final String PASSWORD = "your_mysql_password";
3. Compilation & ExecutionPlace your mysql-connector-j-8.x.x.jar inside a lib folder in your project root directory.On Windows:javac -cp ".;lib/*" *.java
java -cp ".;lib/*" Main
On macOS / Linux:javac -cp ".:lib/*" *.java
java -cp ".:lib/*" Main
💻 Sample Terminal Interface--- STUDENT MANAGEMENT SYSTEM ---
1. Add New Student
2. View All Students
3. Search Student by ID
4. Update Student Details
5. Delete Student
6. Exit
Enter choice: 2

ID    Name            Age   Department      Phone        Total    Percentage Grade
1     Rahul Sharma    20    Computer Sci... 9876543210   263.00   87.67      A    
2     Priya Patel     21    Information ... 9876543211   225.00   75.00      B    
