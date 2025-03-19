## JDBC Program to Insert Employee Details into Database

### Program Overview
This Java program demonstrates how to insert employee details into an Oracle database table using JDBC. The table `emp_info` includes employee ID, name, address, email ID, phone number, and resume (stored as a BLOB).

### Table Structure
```sql
CREATE TABLE emp_info (
    empId NUMBER(4) PRIMARY KEY,
    empName VARCHAR2(20),
    empAddress VARCHAR2(30),
    empMailId VARCHAR2(20),
    empPhNO NUMBER(12),
    empResume BLOB
);
```

### Requirements
- Java Development Kit (JDK) installed
- Oracle Database installed and running
- Oracle JDBC Driver (`ojdbc.jar`) added to the classpath

### How the Program Works
1. Establishes a connection with the Oracle database.
2. Takes user input for employee details.
3. Reads a text file (resume) and stores it as a BLOB in the database.
4. Executes an `INSERT` SQL statement to add the data to the `emp_info` table.

### Code Explanation
- The program uses `Scanner` for user input.
- `Class.forName("oracle.jdbc.driver.OracleDriver")` loads the Oracle JDBC driver.
- `Connection` is established using `DriverManager.getConnection()`.
- `PreparedStatement` is used for inserting data.
- `FileInputStream` is used to read the resume file.
- Error handling is done using `try-catch` blocks.

### Usage Instructions
1. Ensure that the Oracle database is running.
2. Update database credentials in the code:
   ```java
   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");
   ```
3. Compile and run the Java program:
   ```sh
   javac DBconTask2.java
   java DBconTask2
   ```
4. Enter the required employee details and provide the path to a text file as a resume.
5. Check the database to verify the inserted record.

### Sample Output
```
Enter empId: 246
Enter empName: Lalit
Enter empAddress: Hyderabad
Enter empMailId: lp@gmail.com
Enter empPhNo: 7038898338
Enter empResume Text file path: D:\mfile\DummyResume.txt
Image Stored Successfully...
```

### Notes
- Ensure the file path provided is correct; otherwise, the program will show an error.
- Modify the database connection string as per your Oracle DB configuration.
- The BLOB column stores binary data, useful for handling large files like resumes.
