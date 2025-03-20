# Employee Details Retrieval using JDBC and Stored Procedure

### Overview
This project demonstrates how to retrieve employee details from an Oracle database using a stored procedure and a JDBC application.

### Prerequisites
- Oracle Database installed and running.
- Oracle JDBC Driver (`ojdbc.jar` added to the classpath).
- Java Development Kit (JDK) installed.
- An Integrated Development Environment (IDE) or a text editor.

## Database Schema
The project retrieves employee details from the following tables:
1. **EmpData72** - Stores Employee ID, Name, and Designation.
2. **EmpAddress72** - Stores Employee Address Details (House No, Street Name, City, State, Pincode).
3. **EmpContact72** - Stores Employee Contact Information (Mail ID, Phone Number).
4. **EmpSalary72** - Stores Employee Salary Details (Basic Salary, HRA, DA, Total Salary).

### Stored Procedure
The `RetrieveEmployee72` procedure fetches the employee details based on the given Employee ID (`eid`).

```sql
CREATE OR REPLACE PROCEDURE RetrieveEmployee72
(id VARCHAR2, en OUT VARCHAR2, ed OUT VARCHAR2, hn OUT VARCHAR2, sn OUT VARCHAR2,
cty OUT VARCHAR2, st OUT VARCHAR2, pcode OUT NUMBER, md OUT VARCHAR2, pno OUT NUMBER,
bs OUT NUMBER, h OUT NUMBER, d OUT NUMBER, ts OUT NUMBER) IS
BEGIN
   SELECT ename, edesg INTO en, ed FROM EmpData72 WHERE eid = id;
   SELECT hno, sname, city, state, pincode INTO hn, sn, cty, st, pcode FROM EmpAddress72 WHERE eid = id;
   SELECT mid, phno INTO md, pno FROM EmpContact72 WHERE eid = id;
   SELECT bsal, hra, da, totsal INTO bs, h, d, ts FROM EmpSalary72 WHERE eid = id;
END;
/
```

### Java JDBC Application
The `DBcon12.java` class connects to the Oracle database and executes the stored procedure using `CallableStatement`.

### Steps in the Java Application:
1. Load the Oracle JDBC driver.
2. Establish a database connection.
3. Prepare a callable statement to execute the stored procedure.
4. Register output parameters to retrieve results.
5. Execute the procedure and display retrieved employee details.
6. Close the database connection.

### How to Run the Application
1. Ensure the Oracle database is running and the required tables are populated.
2. Compile the Java program:
   ```sh
   javac DBcon12.java
   ```
3. Run the Java program:
   ```sh
   java test.DBcon12
   ```
4. Enter the Employee ID when prompted.
5. The application will fetch and display the employee details.

### Expected Output
```
Enter id to retrieve details: 101
******Details******
Emp-Id: 101
Emp-Name: John Doe
Emp-Desg: Software Engineer
Emp-HNo: 123
Emp-SName: Maple Street
Emp-City: New York
Emp-State: NY
Emp-PinCode: 10001
Emp-MailId: john.doe@example.com
Emp-PhoneNo: 9876543210
Emp-BSal: 50000
Emp-HRA: 5000.0
Emp-DA: 3000.0
Emp-TotSal: 58000.0
```

### Notes
- Ensure that the database credentials (`username`, `password`, and `connection URL`) are correct in the Java file.
- If any table is missing, create it and populate it with sample data before running the procedure.
- Modify the procedure or Java file as needed to fit specific requirements.
