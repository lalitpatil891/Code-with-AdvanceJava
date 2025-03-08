## Inventory Management System

### Introduction

This is a Java-based Inventory Management System using JDBC and Oracle Database. The application allows users to perform CRUD (Create, Read, Update, Delete) operations on an inventory database.

### Features

- Add a new product to the inventory.
- View all products.
- Search for a product by its code.
- Update product details.
- Delete a product from the inventory.

### Technologies Used

- Java
- JDBC (Java Database Connectivity)
- Oracle Database

### Prerequisites

- Install Oracle Database (XE or Standard Edition)
- Set up JDBC Driver for Oracle
- Configure database connection with appropriate credentials

### Database Table Structure

Execute the following SQL command to create the `product72` table in your Oracle database:

```sql
CREATE TABLE product72 (
    code NUMBER(5) PRIMARY KEY,
    name VARCHAR2(30),
    price NUMBER(5,2),
    qty NUMBER(5)
);
```

### How to Run the Program

1. Ensure that the Oracle JDBC driver is available in your classpath.
2. Modify the database connection URL, username, and password as required in the Java program.
3. Compile and run the Java file.
4. Follow the menu-driven interface to perform operations.

### Program Source Code

You can find the complete source code for this project at:
[Program Link](https://github.com/lalitpatil891/Code-with-AdvanceJava/tree/main/PracticePrograms/JDBC_Inventory_App/src/test)

### Usage Instructions

1. **Adding a Product**

   - Enter product code, name, price, and quantity.
   - If the code already exists, an error message will be displayed.

2. **Viewing All Products**

   - Displays a formatted table of all available products.

3. **Searching for a Product**

   - Enter the product code to retrieve details.

4. **Updating a Product**

   - Enter the product code, followed by new price and quantity.

5. **Deleting a Product**

   - Enter the product code and confirm deletion.

6. **Exit the Application**

   - Select option 6 and confirm to exit the program.

### Error Handling

- Handles SQL exceptions for database operations.
- Prevents invalid inputs using exception handling.
- Ensures proper validation of product codes before operations.
---

Developed by: **Lalit**
