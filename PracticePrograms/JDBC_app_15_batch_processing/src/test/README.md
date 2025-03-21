## JDBC Batch Processing

### Overview
Batch Processing in JDBC is a technique where multiple SQL queries are collected as a batch and executed on the database in one go. This approach enhances performance by reducing the number of database calls.

### Key Concepts
- **Batch Processing**: Collecting multiple queries and executing them together.
- **Only Non-Select Queries**: Batch processing supports only non-select queries (INSERT, UPDATE, DELETE), hence it is also called "Batch Update Processing".
- **Statement Usage**: In real-time applications, batch processing is usually performed using the `Statement` object.

### Important Methods
1. `addBatch(String sql)`: Adds a SQL statement to the batch.
2. `executeBatch()`: Executes all the statements in the batch.
3. `clearBatch()`: Clears the current batch of statements.

### Program Description
This Java program demonstrates batch processing using JDBC. It:
1. Inserts a new record into the `Bank72` table.
2. Deletes a record from the `Customer72` table based on a provided phone number.
3. Executes both queries as a batch operation.

### Prerequisites
- Oracle Database installed and running.
- JDBC Driver for Oracle (ojdbc.jar) included in the classpath.

### Code Explanation
- Establishes a database connection.
- Accepts user input for account details.
- Adds an `INSERT` and a `DELETE` query to the batch.
- Executes the batch operation.
- Prints the number of queries executed successfully.

### Execution Steps
1. Compile the Java file:
   ```sh
   javac DBcon15.java
   ```
2. Run the program:
   ```sh
   java test.DBcon15
   ```

### Sample Input/Output
```
****Insert on Bank72*****
Enter the AccNo: 123456
Enter the name: John Doe
Enter the balance: 5000.75
Enter the AccType: Savings

**** Delete on Customer72 ****
Enter the Cust-phoneNo to delete the details: 9876543210

query executed: 1
query executed: 1
```

### Notes
- Ensure that the database schema has the required tables (`Bank72` and `Customer72`).
- Handle SQL exceptions properly in a real-world scenario.
- Consider using PreparedStatement to prevent SQL injection.
