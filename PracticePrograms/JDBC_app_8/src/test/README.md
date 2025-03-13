# JDBC Customer & Bank Management Program

## Overview
This Java program demonstrates JDBC (Java Database Connectivity) operations using an Oracle database. The program allows users to interact with two tables: `Customer72` and `BankCustomer72`. It supports retrieving records in different orders and navigating customer records efficiently.

## Prerequisites
1. Install Oracle Database (or use an existing instance).
2. Configure the database connection (`jdbc:oracle:thin:@localhost:1521:xe`).
3. Ensure the Oracle JDBC driver is available in the classpath.

## Table Structures
The program interacts with the following tables:

### Customer72 Table
```sql
CREATE TABLE Customer72 (
    customerId NUMBER(5) PRIMARY KEY,
    customerName VARCHAR2(50),
    contactNumber VARCHAR2(15),
    email VARCHAR2(50),
    address VARCHAR2(100)
);
```

### BankCustomer72 Table
```sql
CREATE TABLE BankCustomer72 (
    accountId NUMBER(5) PRIMARY KEY,
    accountHolder VARCHAR2(50),
    bankName VARCHAR2(50),
    branch VARCHAR2(50),
    ifscCode VARCHAR2(20)
);
```

## Features
### Customer Operations
1. **Retrieve All Customers**: Fetches all records from `Customer72`.
2. **Navigate Customer Records**: Move to a specific record using absolute or relative positioning.
3. **Retrieve Last and First Customer Records**: Displays first and last customers in the table.

### Bank Customer Operations
1. **Retrieve All Bank Customers**: Fetches all records from `BankCustomer72`.
2. **Retrieve Bank Customers in Reverse Order**: Displays records in descending order.

## Usage
1. Run the program.
2. Select an option from the menu.
3. Follow the on-screen instructions to interact with the database.
4. Exit the program when finished.

## Sample Data
```sql
INSERT INTO Customer72 VALUES (101, 'John Doe', '9876543210', 'john.doe@example.com', 'New York');
INSERT INTO Customer72 VALUES (102, 'Jane Smith', '8765432109', 'jane.smith@example.com', 'Los Angeles');

INSERT INTO BankCustomer72 VALUES (201, 'Alice Brown', 'State Bank', 'Downtown', 'SBIN0001234');
INSERT INTO BankCustomer72 VALUES (202, 'Bob White', 'HDFC Bank', 'City Center', 'HDFC0005678');
```

## Dependencies
- Java SE (JDK 8+ recommended)
- Oracle Database
- Oracle JDBC Driver

## Notes
- Ensure the Oracle JDBC driver is correctly configured in your project.
- Modify database credentials in the `getConnection()` method if needed.
- Use `ResultSet.TYPE_SCROLL_INSENSITIVE` for efficient navigation of result sets.
