# JDBC Product Management Program

## Overview
This Java program demonstrates JDBC (Java Database Connectivity) operations using an Oracle database. The program allows users to interact with a `Product40` table through various operations, including inserting product details and retrieving records in different orders.

## Prerequisites
1. Install Oracle Database (or use an existing instance).
2. Configure the database connection (`jdbc:oracle:thin:@localhost:1521:xe`).
3. Ensure the Oracle JDBC driver is available in the classpath.

## Table Structure
The program interacts with the `Product40` table, which has the following schema:
```sql
CREATE TABLE Product40 (
    productId NUMBER(3) PRIMARY KEY,
    productName VARCHAR2(30),
    productPrice NUMBER(10,2),
    productQty NUMBER(5)
);
```

## Features
1. **Insert Product Details**: Allows users to add new products to the `Product40` table.
2. **Retrieve All Products (Forward Order)**: Displays all products in ascending order.
3. **Retrieve All Products (Reverse Order)**: Displays all products in descending order.
4. **Retrieve 3rd Record from Top**: Fetches and displays the third record from the top.
5. **Retrieve 3rd Record from Bottom**: Fetches and displays the third record from the bottom.
6. **Retrieve Last Three Records**: Displays the last three records in the table.

## Usage
1. Run the program.
2. Select an option from the menu.
3. Follow the on-screen instructions to interact with the database.
4. Exit the program when finished.

## Sample Data
```sql
INSERT INTO Product40 VALUES (201, 'Headphone', 499, 80);
INSERT INTO Product40 VALUES (202, 'Realme9', 11000, 30);
INSERT INTO Product40 VALUES (203, 'SamsungJ2', 8000, 80);
INSERT INTO Product40 VALUES (204, 'Redmi9', 12000, 20);
```

## Dependencies
- Java SE (JDK 8+ recommended)
- Oracle Database
- Oracle JDBC Driver

## Notes
- Ensure the Oracle JDBC driver is correctly configured in your project.
- Modify database credentials in the `getConnection()` method if needed.
- Use `ResultSet.TYPE_SCROLL_INSENSITIVE` for efficient navigation of result sets.
