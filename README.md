# Employee CRUD API 
<!-- Project description -->
A simple Spring Boot REST API that provides CRUD (Create, Read, Update, Delete) operations for managing employee data.  
Built with **Java**, **Spring Boot**, **Spring MVC**, **Spring Data JPA**, and **MySQL**.

---

## Features <!-- Main features list -->
- Create a new employee record
- Retrieve all employees
- Update existing employee details
- Delete an employee
- Connected to MySQL database

---

## Tech Stack <!-- Technologies used -->
- **Java 17+**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **MySQL**
- **Maven**

---

## Setup & Run <!-- Step-by-step setup guide -->

1. **Clone the repository**
```bash
git clone https://github.com/MAffanG/employee-crud-api.git
cd employee-crud-api
``` 

2. **Open in any IDE**  
Open the project in your preferred IDE, such as IntelliJ IDEA, Eclipse, or VS Code.

3. **Update application.properties file** (`src/main/resources/application.properties`)  

    Configure your MySQL credentials:  

```properties
# MySQL configuration
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
```

4. **Run the Application**

    You can run the application directly from your IDE.

5. **Access the API**

    Once the application is running, the API will be available at:

   ```link
   http://localhost:8080/employees/list
   ```

   






