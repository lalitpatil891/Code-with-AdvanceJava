## JDBC Application for Customer Table Operations

### Overview

This Java application allows users to perform **INSERT, UPDATE, DELETE, and CREATE TABLE** operations on a customer database using JDBC.

### Features

- Establishes a connection with an Oracle Database.
- Accepts SQL queries as input from the user.
- Executes **DDL (CREATE TABLE)** and **DML (INSERT, UPDATE, DELETE)** operations.
- Provides error handling for **SQL syntax errors** and **constraint violations**.

### Prerequisites

- Oracle Database installed and running.
- JDBC Driver (`ojdbc.jar`) configured in the project.
- Java Development Kit (JDK) installed.

### Technologies Used

- **Java** (JDK 8+)
- **JDBC API**
- **Oracle Database**

### How to Run the Program

1. **Compile the Java Program**
   ```sh
   javac DBcon4.java
   ```
2. **Run the Program**
   ```sh
   java test.DBcon4
   ```
3. **Enter SQL Queries** (Examples Below)

### Sample Queries

#### Insert a New Customer

```sql
INSERT INTO Customer72 (phno, cid, custname, city, mid)
VALUES (9876543210, 'HM102', 'John Doe', 'Mumbai', 'john@example.com');
```

#### Update Customer Details

```sql
UPDATE Customer72 SET city = 'Pune' WHERE phno = 9876543210;
```

#### Delete a Customer Record

```sql
DELETE FROM Customer72 WHERE phno = 9876543210;
```

#### Create a New Table

```sql
CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    CustomerID VARCHAR(20),
    OrderDate DATE,
    Amount DECIMAL(10,2)
);
```

### Error Handling

- **Syntax Errors:** If an invalid query is entered, the program will display an error message.
- **Constraint Violations:** If an entry violates a primary key or unique constraint, the program will notify the user.
