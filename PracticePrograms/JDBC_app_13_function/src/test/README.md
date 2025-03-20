# JDBC Function Demonstration

## Overview
This application demonstrates how to use a function in JDBC to retrieve an employee's total salary based on their employee ID.

## Step 1: Creating the Function in Oracle Database
The following PL/SQL function retrieves the total salary (TotSal) of an employee from the `EmpSalary72` table using their employee ID (`eid`).

```sql
CREATE OR REPLACE FUNCTION RetrieveTotSal72
(id VARCHAR2) RETURN NUMBER AS ts NUMBER;
BEGIN
   SELECT totsal INTO ts FROM EmpSalary72 WHERE eid = id;
   RETURN ts;
END;
/
```

## Step 2: JDBC Application to Execute the Function
The Java program `DBCon13.java` is designed to connect to an Oracle database and execute the `RetrieveTotSal72` function. It takes an employee ID as input and retrieves the corresponding total salary.

### Java Program: `DBCon13.java`
```java
package test;

import java.util.*;
import java.sql.*;

public class DBCon13 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try (s) {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish connection to database
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger"
            );

            // Prepare callable statement to execute the function
            CallableStatement cs = con.prepareCall("{call ?:=RetrieveTotSal72(?)}");

            // Take employee ID input
            System.out.println("Enter the Emp-Id to retrieve TotSal:");
            String eId = s.nextLine();

            // Set input and output parameters
            cs.setString(2, eId);
            cs.registerOutParameter(1, Types.FLOAT);

            // Execute function
            cs.execute();

            // Display retrieved details
            System.out.println("******Details******");
            System.out.println("Emp-Id: " + eId);
            System.out.println("TotSal: " + cs.getFloat(1));

            // Close connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## Expected Output
```
Enter the Emp-Id to retrieve TotSal:
T121
******Details******
Emp-Id: T121
TotSal: 114300.0
```

## Prerequisites
- Oracle Database installed and running.
- Table `EmpSalary72` with columns `eid` (VARCHAR2) and `totsal` (NUMBER) created and populated with data.
- Oracle JDBC driver (`ojdbc8.jar`) added to the classpath.
- Java Development Kit (JDK) installed.

## How to Run the Application
1. Ensure the Oracle Database is running.
2. Compile the Java program:
   ```sh
   javac DBCon13.java
   ```
3. Run the Java program:
   ```sh
   java test.DBCon13
   ```
4. Enter the employee ID when prompted and view the total salary retrieved from the database.

## Conclusion
This project demonstrates how to use JDBC to call a stored function in an Oracle database. The function fetches an employee's total salary based on their ID, and the Java program executes the function using a callable statement.
