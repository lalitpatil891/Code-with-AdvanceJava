## JDBC Program to Insert Image into Database

### Program Overview
This Java program demonstrates how to insert an image into an Oracle database table using JDBC. The table `player_info` includes player ID, name, image (stored as a BLOB), and date of birth.

### Table Structure
```sql
CREATE TABLE player_info (
    pId NUMBER(3) PRIMARY KEY,
    pName VARCHAR2(20),
    pImage BLOB,
    pDateOfBirth DATE
);
```

### Requirements
- Java Development Kit (JDK) installed
- Oracle Database installed and running
- Oracle JDBC Driver (`ojdbc.jar`) added to the classpath

### How the Program Works
1. Establishes a connection with the Oracle database.
2. Takes user input for player details.
3. Reads an image file and stores it as a BLOB in the database.
4. Executes an `INSERT` SQL statement to add the data to the `player_info` table.

### Code Explanation
- The program uses `Scanner` for user input.
- `Class.forName("oracle.jdbc.driver.OracleDriver")` loads the Oracle JDBC driver.
- `Connection` is established using `DriverManager.getConnection()`.
- `PreparedStatement` is used for inserting data.
- `FileInputStream` is used to read the image file.
- Error handling is done using `try-catch` blocks.

### Usage Instructions
1. Ensure that the Oracle database is running.
2. Update database credentials in the code:
   ```java
   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");
   ```
3. Compile and run the Java program:
   ```sh
   javac DBconTask3.java
   java DBconTask3
   ```
4. Enter the required player details and provide the path to an image file.
5. Check the database to verify the inserted record.

### Sample Output
```
Enter pId: 101
Enter pName: Sachin
Enter pImage: D:\images\sachin.jpg
Enter pDateOfBirth: 1973-04-24
Image Stored Successfully...
```

### Notes
- Ensure the file path provided is correct; otherwise, the program will show an error.
- Modify the database connection string as per your Oracle DB configuration.
- The BLOB column stores binary data, useful for handling images.
