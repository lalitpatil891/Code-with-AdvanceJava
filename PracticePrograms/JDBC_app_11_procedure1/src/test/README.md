## Employee Management System

This project demonstrates how to create and manage an employee database using Oracle SQL and Java JDBC. It includes table creation, a stored procedure for inserting employee data, and a Java program to execute the procedure.

### Database Schema
The following tables are created to store employee details:

1. **EmpData72** (Stores basic employee details)
```sql
CREATE TABLE EmpData72(
    eid VARCHAR2(10) PRIMARY KEY,
    ename VARCHAR2(15),
    edesg VARCHAR2(10)
);
```

2. **EmpAddress72** (Stores employee address details)
```sql
CREATE TABLE EmpAddress72(
    eid VARCHAR2(10) PRIMARY KEY,
    hno VARCHAR2(15),
    sname VARCHAR2(15),
    city VARCHAR2(15),
    state VARCHAR2(15),
    pincode NUMBER(10)
);
```

3. **EmpContact72** (Stores employee contact details)
```sql
CREATE TABLE EmpContact72(
    eid VARCHAR2(10) PRIMARY KEY,
    mid VARCHAR2(25),
    phno NUMBER(15)
);
```

4. **EmpSalary72** (Stores employee salary details)
```sql
CREATE TABLE EmpSalary72(
    eid VARCHAR2(10) PRIMARY KEY,
    bsal NUMBER(10),
    hra NUMBER(10,2),
    da NUMBER(10,2),
    totsal NUMBER(10,2)
);
```

### Stored Procedure
A stored procedure `InsertEmployee72` is created to insert employee details into all tables.
```sql
CREATE OR REPLACE PROCEDURE InsertEmployee72(
    id VARCHAR2, en VARCHAR2, ed VARCHAR2,
    hn VARCHAR2, sn VARCHAR2, cty VARCHAR2,
    st VARCHAR2, pcode NUMBER, md VARCHAR2,
    pno NUMBER, bs NUMBER, h NUMBER, d NUMBER, ts NUMBER
) IS
BEGIN
    INSERT INTO EmpData72 VALUES(id, en, ed);
    INSERT INTO EmpAddress72 VALUES(id, hn, sn, cty, st, pcode);
    INSERT INTO EmpContact72 VALUES(id, md, pno);
    INSERT INTO EmpSalary72 VALUES(id, bs, h, d, ts);
END;
/
```

### JDBC Application
A Java program is used to execute the stored procedure and insert data into the database.

### Prerequisites
- Oracle Database
- Java Development Kit (JDK)
- JDBC Driver for Oracle

### Code Snippet
```java
import java.util.*;
import java.sql.*;

public class DBcon11 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");
            CallableStatement cs = con.prepareCall("{call InsertEmployee72(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            System.out.println("Enter the Emp-Id:");
            String eId = sc.nextLine();
            System.out.println("Enter the Emp-Name:");
            String eName = sc.nextLine();
            System.out.println("Enter the Emp-Desg:");
            String eDesg = sc.nextLine();
            System.out.println("Enter the Emp-HNo:");
            String hNo = sc.nextLine();
            System.out.println("Enter the Emp-SName:");
            String sName = sc.nextLine();
            System.out.println("Enter the Emp-City:");
            String city = sc.nextLine();
            System.out.println("Enter the Emp-State:");
            String state = sc.nextLine();
            System.out.println("Enter the Emp-PinCode:");
            int pinCode = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the Emp-MailId:");
            String mId = sc.nextLine();
            System.out.println("Enter the Emp-PhNo:");
            long phNo = sc.nextLong();
            System.out.println("Enter the Emp-bSal:");
            int bSal = sc.nextInt();
            float hra = 0.93F * bSal;
            float da = 0.61F * bSal;
            float totSal = bSal + hra + da;

            cs.setString(1, eId);
            cs.setString(2, eName);
            cs.setString(3, eDesg);
            cs.setString(4, hNo);
            cs.setString(5, sName);
            cs.setString(6, city);
            cs.setString(7, state);
            cs.setInt(8, pinCode);
            cs.setString(9, mId);
            cs.setLong(10, phNo);
            cs.setInt(11, bSal);
            cs.setFloat(12, hra);
            cs.setFloat(13, da);
            cs.setFloat(14, totSal);

            cs.execute(); // Execute Procedure
            System.out.println("Employee added successfully....");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Installation & Execution
1. Install Oracle Database and ensure it is running.
2. Create the tables and stored procedure in SQL.
3. Compile and run the Java program:
   ```sh
   javac DBcon11.java
   java DBcon11
   ```

### Conclusion
This project demonstrates how to manage employee records using a relational database and Java. The combination of stored procedures and JDBC provides an efficient way to handle structured data.
