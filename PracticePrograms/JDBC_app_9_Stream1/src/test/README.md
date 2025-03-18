## Storing Stream Data (Image) to Database Product

### Overview
This Java program demonstrates how to store image files in an Oracle database using JDBC. The application prompts the user for an ID, name, and image file path, then inserts the image as a BLOB into the database.

### Prerequisites
- Oracle Database (installed and running)
- Oracle JDBC Driver (`ojdbc.jar`)
- Java Development Kit (JDK)
- Basic knowledge of JDBC

### Database Setup
Before running the program, create the required database table:

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
   javac DBcon9.java
   ```

2. **Run the Program:**
   ```sh
   java test.DBcon9
   ```

3. **Provide the following inputs:**
   - User ID
   - User Name
   - Image file path

### Code Explanation
- **Step 1:** Load the Oracle JDBC driver.
- **Step 2:** Establish a connection to the Oracle database.
- **Step 3:** Use `PreparedStatement` to insert data into the `StreamTab72` table.
- **Step 4:** Read the image file as a binary stream and store it in the database.
- **Step 5:** Execute the update and confirm the successful storage of the image.

### Error Handling
- If the provided file path is incorrect or the file does not exist, an error message will be displayed.
- Any SQL or connection-related errors will be printed in the console.

### Notes
- Ensure the Oracle database is running before executing the program.
- Modify the database connection string (`jdbc:oracle:thin:@localhost:1521:xe`) if required.
- Replace `system` and `lalit` with the appropriate database username and password.
