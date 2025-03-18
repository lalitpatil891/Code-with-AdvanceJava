## Retrieving Stream (Image) from Database

### Overview
This Java program demonstrates how to retrieve an image stored as a BLOB in an Oracle database and save it to a specified file location.

## Diagram
![Diagram](https://github.com/lalitpatil891/Code-with-AdvanceJava/blob/main/PracticePrograms/JDBC_app_10_Stream2/src/test/Dia-12.png)


### Prerequisites
- Oracle Database (installed and running)
- Oracle JDBC Driver (`ojdbc.jar`)
- Java Development Kit (JDK)
- Basic knowledge of JDBC

### Database Setup
Before running the program, ensure that the `StreamTab72` table exists and contains image data. The table can be created using:

```sql
CREATE TABLE StreamTab72 (
    id VARCHAR2(10) PRIMARY KEY,
    name VARCHAR2(15),
    mfile BLOB
);
```

### Steps to Run the Program
1. **Compile the Java Program:**
   ```sh
   javac DBcon10.java
   ```

2. **Run the Program:**
   ```sh
   java test.DBcon10
   ```

3. **Provide the following inputs:**
   - User ID to retrieve details
   - Destination file path to save the retrieved image

### Code Explanation
- **Step 1:** Load the Oracle JDBC driver.
- **Step 2:** Establish a connection to the Oracle database.
- **Step 3:** Use `PreparedStatement` to fetch the image from the `StreamTab72` table using the provided user ID.
- **Step 4:** Retrieve the image as a BLOB and store it in a byte array.
- **Step 5:** Save the byte array as an image file at the specified location.

### Error Handling
- If the provided user ID does not exist, an error message is displayed.
- Any SQL or file handling errors are printed in the console.

### Notes
- Ensure the Oracle database is running before executing the program.
- Modify the database connection string (`jdbc:oracle:thin:@localhost:1521:xe`) if required.
- Replace `system` and `lalit` with the appropriate database username and password.
- Ensure that the destination file path is valid and writable.
