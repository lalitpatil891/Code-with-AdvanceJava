# JDBC Bank Customer Management Application

## Description
This is a simple JDBC-based application that allows users to perform the following operations on a bank customer database:

1. **Add a Bank Customer**
2. **View All Bank Customers**
3. **Exit the Application**

The application continuously runs until the user chooses to exit.

## Prerequisites
To run this application, ensure you have the following installed:

- **Java Development Kit (JDK) 8 or later**
- **Oracle Database**
- **Oracle JDBC Driver**
- **Eclipse/IntelliJ IDEA (Optional)**

## Database Setup
Ensure that you have an Oracle database running and execute the following SQL commands to create the required table:

```sql
CREATE TABLE BankCustomer72 (
    custAccNo NUMBER PRIMARY KEY,
    custId VARCHAR2(20) NOT NULL,
    custName VARCHAR2(100) NOT NULL,
    balance FLOAT NOT NULL,
    accType VARCHAR2(50) NOT NULL
);
```

## Code Execution Flow
1. **Program Startup**:
   - The program loads the Oracle JDBC driver.
   - Establishes a connection to the database.
   - Prepares SQL statements for inserting and retrieving customer data.

2. **User Interaction**:
   - Displays a menu with options to add a customer, view all customers, or exit.
   - Reads user input and processes it accordingly.

3. **Adding a Bank Customer**:
   - Prompts the user for customer details (account number, name, balance, account type).
   - Generates a unique customer ID.
   - Inserts the data into the database using a prepared statement.
   - Displays a success message if the operation is successful.

4. **Viewing All Bank Customers**:
   - Executes a query to retrieve all records from the database.
   - Iterates through the result set and displays customer details.

5. **Exit Operation**:
   - Terminates the program when the user selects the exit option.

## Execution Process
1. **Compile the Java Program**:
   ```sh
   javac DBcon6.java
   ```
2. **Run the Application**:
   ```sh
   java test.DBcon6
   ```

## How to Use
- **Add a Bank Customer**: Enter the customer's account number, name, balance, and account type when prompted.
- **View All Bank Customers**: Displays all records stored in the database.
- **Exit**: Terminates the application.

## JDBC Connection Details
The application connects to an Oracle database. Ensure you update your database credentials in the code before running the application.

- **JDBC URL**: `jdbc:oracle:thin:@localhost:1521:xe`
- **Username**: `<your-username>`
- **Password**: `<your-password>`

> **Note**: Replace `<your-username>` and `<your-password>` with your actual database credentials while configuring the application.

## Exception Handling
- The program handles potential SQL and input exceptions.
- If any database operation fails, the error stack trace is printed for debugging.
