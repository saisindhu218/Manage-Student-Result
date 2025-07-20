
# Student Result Management System



A web-based Spring Boot application for managing student academic results. It allows secure user login, dashboard views of student records, and adding new student results through an intuitive form interface. The system uses a MySQL database for persistent data storage.



## Features

* **User Authentication** – Secure login using Spring Security
* **Dashboard** – View all student records with details like roll number, name, semester, subject marks, total, and CGPA
* **Add Student** – Web form to add student records with auto-calculation of total and CGPA
* **Automated Calculations** – Calculates total marks and CGPA automatically
* **Database Persistence** – Uses MySQL to store all student data



##  Tech Stack

* **Backend:** Spring Boot (Java), Spring Web, Spring Data JPA, Spring Security
* **Frontend:** Thymeleaf
* **Database:** MySQL
* **Build Tool:** Maven
* **Extras:** Lombok (for cleaner code)



## How to Run

### Prerequisites:

* JDK 21+
* Maven
* MySQL Server

### Steps:

1. **Database Setup**

   * Create a database named `studentdb`
   * Run the provided SQL script to create and populate the `student` table

2. **Update Configuration**

   * In `src/main/resources/application.properties`, update the following:

     ```properties
     spring.datasource.username=root
     spring.datasource.password=YOUR_PASSWORD
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Build & Run**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access the App**

   * Open [http://localhost:8081/login](http://localhost:8081/login)
   * **Login:**

     * Username: `admin`
     * Password: `admin123`



## License

This project is open-source and available for educational and personal use.

Rachabattuni Sai Sindhu
