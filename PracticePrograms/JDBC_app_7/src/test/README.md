# JDBC Application: Bank Customer Management

## Description
This Java application connects to an Oracle database using JDBC and allows users to perform the following operations based on a given Account Number:
1. **Update Bank Customer** - Modify the balance and account type of an existing customer.
2. **Delete Bank Customer** - Remove a customer record from the database.

### Diagram
![Diagram](https://github.com/lalitpatil891/Code-with-AdvanceJava/blob/main/PracticePrograms/JDBC_app_7/src/test/JDBC_app_7.png)

## Prerequisites
- Java Development Kit (JDK) installed.
- Oracle Database installed and running.
- Oracle JDBC Driver (`ojdbc.jar`) added to the classpath.

## Database Schema
The application interacts with a table named `BankCustomer72`, which has the following structure:

| Column  | Data Type     | Constraints |
|---------|--------------|-------------|
| ACCNO   | NUMBER(15)   | NOT NULL (Primary Key) |
| CID     | VARCHAR2(15) | |
| CNAME   | VARCHAR2(15) | |
| BALANCE | NUMBER(10,2) | |
| ACCTYPE | VARCHAR2(15) | |

## Features
- Uses JDBC to connect to an Oracle database.
- Retrieves customer details before performing updates or deletions.
- Provides a simple text-based menu for user interaction.
- Implements input validation to prevent SQL errors and incorrect data modifications.

## How It Works
1. The user is prompted to enter a customer account number.
2. The system checks if the account exists in the database.
3. If the account exists, the user is given three choices:
   - **Update Customer**: Modify balance and account type.
   - **Delete Customer**: Confirm deletion before removing the record.
   - **Exit**: Terminate the program.
4. Based on user input, the corresponding SQL operations are performed.

## Error Handling
- Catches SQL syntax and connection errors.
- Handles invalid user input and provides meaningful messages.

## Sample SQL Queries
### Table Creation
```sql
CREATE TABLE BankCustomer72 (
    ACCNO NUMBER(15) PRIMARY KEY,
    CID VARCHAR2(15),
    CNAME VARCHAR2(15),
    BALANCE NUMBER(10,2),
    ACCTYPE VARCHAR2(15)
);
```

### Select Data
```sql
SELECT * FROM BankCustomer72;
```

### Update Customer
```sql
UPDATE BankCustomer72 SET BALANCE = ?, ACCTYPE = ? WHERE ACCNO = ?;
```

### Delete Customer
```sql
DELETE FROM BankCustomer72 WHERE ACCNO = ?;
```

## Usage Instructions
1. Compile the Java program:
   ```sh
   javac DBcon7.java
   ```
2. Run the program:
   ```sh
   java test.DBcon7
   ```
3. Follow the on-screen instructions to update or delete customer records.

## Notes
- Ensure that the Oracle database is running and the connection details (host, port, username, password) are correctly set.
- Modify SQL queries if using a different database schema.
- Implement additional security measures, such as prepared statements, to prevent SQL injection.
