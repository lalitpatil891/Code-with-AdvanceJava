## Employee Management System (JDBC Application)

### Overview
This is a Java-based JDBC application that interacts with an Oracle database to manage employee records. The application allows users to perform CRUD (Create, Read, Update, Delete) operations on the `Employee72` table.

### Features
1. **Add Employee** - Insert a new employee into the database.
2. **View All Employees** - Retrieve and display all employee records.
3. **View Employee By ID** - Fetch details of an employee using their ID.
4. **Update Employee Salary By ID** - Modify the basic salary of an employee.
5. **Delete Employee By ID** - Remove an employee record.
6. **Exit** - Terminate the application.

### Database Table Structure
Table Name: **Employee72**

| Column  | Data Type      | Constraints      |
|---------|--------------|----------------|
| eid     | number(3)    | Primary Key    |
| ename   | varchar2(20) | NOT NULL       |
| edesg   | varchar2(20) | NOT NULL       |
| bsal    | number(10,2) | NOT NULL       |
| hra     | number(10)   | Computed (91% of bsal) |
| da      | number(10)   | Computed (63% of bsal) |
| totsal  | number(10,2) | Computed (bsal + hra + da) |

### Business Logic
- `hra` (House Rent Allowance) = **91%** of `bsal`
- `da` (Dearness Allowance) = **63%** of `bsal`
- `totSal` (Total Salary) = `bsal` + `hra` + `da`
- **Minimum Basic Salary** must be **₹12,000** (otherwise, an exception is raised).

### Prerequisites
- Java Development Kit (JDK) installed (Version 8 or higher)
- Oracle Database installed and running
- Oracle JDBC Driver (`ojdbc8.jar`)
- Database user credentials (Update the connection URL, username, and password in the code)

### Installation & Setup
1. **Create the Database Table:**
   ```sql
   CREATE TABLE Employee72 (
       eid NUMBER(3) PRIMARY KEY,
       ename VARCHAR2(20) NOT NULL,
       edesg VARCHAR2(20) NOT NULL,
       bsal NUMBER(10,2) NOT NULL,
       hra NUMBER(10),
       da NUMBER(10),
       totsal NUMBER(10,2)
   );
   ```

2. **Compile & Run the Java Program:**
   ```sh
   javac DBconEmployee72.java
   java test.DBconEmployee72
   ```

### Usage
- The application presents a menu-driven interface where users can choose operations by entering the corresponding number.
- Input employee details when prompted and follow on-screen instructions.

### Exception Handling
- Ensures the basic salary is at least ₹12,000 before inserting or updating records.
- Catches invalid input types to prevent runtime errors.
- Handles SQL exceptions gracefully.
