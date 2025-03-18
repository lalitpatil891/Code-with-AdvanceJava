## Code-with-AdvanceJava

### Description
This repository contains daily notes, practice programs, and learning resources related to **Advanced Java**. The goal is to track progress, improve coding skills, and maintain a well-structured reference for future use.

### Repository Structure
```
Code-with-AdvanceJava/
│── Notes/            # Theoretical concepts, explanations, and study notes
│── Practice/         # Hands-on coding exercises and solved problems
│── Projects/         # Mini-projects and real-world implementations
│── README.md         # Overview of the repository
```

## Topics Covered
- JDBC (Java Database Connectivity)
  1) [JDBC Application Setup Guide](#jdbc-application-setup-guide)
  2) [ResultSet in JDBC](#resultset-in-jdbc)
  - programs on statement
     - [Write the following JDBC code to display all Customer details](#write-the-following-jdbc-code-to-display-all-Customer-details)
     - [JDBC Application Insert Customer Details into Oracle Database](#jdbc-application-insert-customer-details-into-oracle-database)
     - [JDBC Application for Customer Table Operations](#jdbc-application-for-customer-table-operations)
     - [BookTrackDBcon - JDBC Oracle Database Connectivity](#booktrackdbcon-jdbc-oracle-database-connectivity)
     - [Product Management System](#product-management-system)
     - [Inventory Management System JDBC](#inventory-management-system-jdbc) (jdbc-app)
  - programs on preparedStatement
     - [JDBC Bank Customer Management Application](#jdbc-bank-customer-management-application)
     - [JDBC Application Bank Customer Management](#jdbc-application-bank-customer-management)
     - [Student Registration and Login System](#student-registration-and-login-system)
     - [JDBC Product Management Program](#jdbc-product-management-program)
     - [JDBC Customer & Bank Management Program](#jdbc-customer--bank-management-program)
     - [Employee Management System (JDBC Application)]()

<!--
- Servlets & JSP (Java Server Pages)
- Spring Framework (Spring Boot, Spring MVC)
- Hibernate & JPA (Java Persistence API)
- Web Services (REST & SOAP APIs)
- Multithreading & ConcurrencyG
- Design Patterns in Java
- Networking in Java

--->
## How to Use
- Navigate through the folders to find relevant topics.
- Check the `Notes/` directory for theoretical concepts.
- Explore `Practice/` for coding exercises.
- Look into `Projects/` for applied learning and real-world examples.

---
## [JDBC Application Setup Guide](https://github.com/lalitpatil891/Code-with-AdvanceJava/tree/main/PracticePrograms/JDBC_app_1/src/test)

### Step 1: Download and Install Database Product (Oracle)

- Download and install Oracle Database.

### Step 2: Perform Login Process to Database Product

- **DB Username**: `system`
- **DB Password**: `tiger`

### Step 3: Create a Table (Customer72)

Execute the following SQL command to create the `Customer72` table:

```sql
CREATE TABLE Customer72 (
    phno NUMBER(15),
    cid VARCHAR2(15),
    name VARCHAR2(15),
    city VARCHAR2(15),
    mid VARCHAR2(25),
    PRIMARY KEY (phno)
);
```

### Step 4: Insert Customer Details

Insert at least 5 records using SQL Command-Line:

```sql
INSERT INTO Customer72 VALUES (9898981234, 'HM9898981234', 'Alex', 'Hyd', 'a@gmail.com');
INSERT INTO Customer72 VALUES (7676761234, 'HM7676761234', 'Raj', 'Hyd', 'rj@gmail.com');
INSERT INTO Customer72 VALUES (8686861234, 'HM8686861234', 'Ram', 'Hyd', 'rm@gmail.com');
```

Verify the data:

```sql
SELECT * FROM Customer72;
```

### Step 5: Copy DB-JAR File for JDBC Driver

- Navigate to the `lib` folder of Oracle and copy the JDBC JAR file to a user-defined folder (e.g., Desktop):
  ```
  C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6.jar
  ```

### FAQ: What is a JAR File?

- **JAR (Java Archive)** is a compressed format containing multiple class files.
- The **DB-JAR** file provides JDBC drivers required for database communication.

### Step 6: Find Database Port Number and Service Name

- Locate the `tnsnames.ora` file in the `Admin` folder of the network directory:
  ```
  C:\oraclexe\app\oracle\product\11.2.0\server\network\ADMIN
  ```
- **Port Number**: `1521`
- **Service Name**: `XE`

### Steps to Establish JDBC Communication

1. **Load JDBC Driver**
2. **Create a Connection to the Database**
3. **Prepare a JDBC Statement**
4. **Execute the SQL Query**
5. **Close the Database Connection**

### Understanding `getConnection()` Method

- We use `getConnection()` method from `DriverManager` to create an implementation object for the `Connection` interface.
- `getConnection()` internally holds an **Anonymous Local InnerClass** as the implementation class of the `Connection` interface and generates the Connection-Implementation Object.

#### Method Signature of `getConnection()`
```java
public static java.sql.Connection getConnection(java.lang.String, java.lang.String, java.lang.String)
    throws java.sql.SQLException;
```
#### Syntax:
```java
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
```

### JDBC Statements

- JDBC statements specify the type of operation to be performed on the database product.
- These are categorized into three types:
  1. **Statement**
  2. **PreparedStatement**
  3. **CallableStatement**

#### 1. Statement:
- `Statement` is an interface from `java.sql` package used to execute normal queries without IN-Parameters (Create, Insert, Select, Update, and Delete).
- We use `createStatement()` method from the `Connection` interface to create an implementation object for the `Statement` interface.
- This method internally holds an **Anonymous Local InnerClass** as an implementation class of `Statement` interface and generates the Statement object.

##### Method Signature of `createStatement()`:
```java
public abstract java.sql.Statement createStatement() throws java.sql.SQLException;
```
##### Syntax:
```java
Statement stm = con.createStatement();
```

##### Important Methods of `Statement` Interface:

(a) `executeQuery()`:
- Used to execute **SELECT** queries.

##### Signature:
```java
public abstract java.sql.ResultSet executeQuery(java.lang.String) throws java.sql.SQLException;
```
##### Syntax:
```java
ResultSet rs = stm.executeQuery("SELECT * FROM Customer72");
```

(b) `executeUpdate()`:
- Used to execute **Non-SELECT** queries.

##### Signature:
```java
public abstract int executeUpdate(java.lang.String) throws java.sql.SQLException;
```
##### Syntax:
```java
int k = stm.executeUpdate("UPDATE Customer72 SET name = 'John' WHERE phno = 9898981234");
```

## Creating JDBC Application Using IDE Eclipse

### Step 1: Open Eclipse IDE

- While opening, name the **Workspace** and click 'Launch'.

### Step 2: Create a Java Project

### Step 3: Add DB-JAR File to Java Project

- **Right Click on Project** → **Build Path** → **Configure Build Path** → **Libraries**
- Select **Classpath** and click **Add External JARs**
- Browse and select **DB-JAR file** from the user-defined folder
- Click **Open** → **Apply** → **Apply and Close**

### Step 4: Create a Package in `src`

### Step 5: Create a Class (JDBC Program) in the Package

---
## Write the following JDBC code to display all Customer details.

### DBCon1.java
```java
package test;

import java.sql.*;

public class DBCon1 {
    public static void main(String[] args) {
        try {
            // Step 1: Load JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Create Connection to Database
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");

            // Step 3: Prepare JDBC Statement
            Statement stm = con.createStatement();

            // Step 4: Execute the Query
            ResultSet rs = stm.executeQuery("SELECT * FROM Customer72");

            while (rs.next()) {
                System.out.println(rs.getLong(1) + "\t"
                    + rs.getString(2) + "\t"
                    + rs.getString(3) + "\t"
                    + rs.getString(4) + "\t"
                    + rs.getString(5));
            }

            // Step 5: Close the Connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
     This program connects to the Oracle database, retrieves all customer details from the `Customer72` table, and displays them in the console.
---
### ResultSet in JDBC

### Overview
`ResultSet` is an interface from the `java.sql` package, used to hold the results generated from `SELECT` queries in JDBC.

## Types of ResultSet Objects
### 1. Non-Scrollable ResultSet Objects
- In Non-Scrollable ResultSet Objects, the cursor can move only in one direction: **forward**.
- Syntax to create a Non-Scrollable `ResultSet` Object:

  **Using `Statement`**:
  ```java
  Statement stm = con.createStatement();
  ResultSet rs = stm.executeQuery("SELECT * FROM table_name");
  ```

  **Using `PreparedStatement`**:
  ```java
  PreparedStatement ps = con.prepareStatement("SELECT * FROM table_name");
  ResultSet rs = ps.executeQuery();
  ```

### 2. Scrollable ResultSet Objects
- In Scrollable ResultSet Objects, the cursor can move **both forward and backward**.
- Syntax to create a Scrollable `ResultSet` Object:

  **Using `Statement`**:
  ```java
  Statement stm = con.createStatement(type, mode);
  ResultSet rs = stm.executeQuery("SELECT * FROM table_name");
  ```

  **Using `PreparedStatement`**:
  ```java
  PreparedStatement ps = con.prepareStatement("SELECT * FROM table_name", type, mode);
  ResultSet rs = ps.executeQuery();
  ```

### Explanation of Parameters
### `type`
Specifies the **cursor direction** on the `ResultSet` Object. It can take the following values from the `ResultSet` interface:
```java
public static final int TYPE_FORWARD_ONLY;
public static final int TYPE_SCROLL_INSENSITIVE;
public static final int TYPE_SCROLL_SENSITIVE;
```

### `mode`
Specifies the **action** that can be performed on the `ResultSet` Object. It can take the following values:
```java
public static final int CONCUR_READ_ONLY;
public static final int CONCUR_UPDATABLE;
```

### Important Cursor Methods
To control the cursor on a `ResultSet` Object, the following methods are used:

1. `afterLast()` - Moves the cursor **after the last row**.
2. `beforeFirst()` - Moves the cursor **before the first row**.
3. `first()` - Moves the cursor to the **first row**.
4. `last()` - Moves the cursor to the **last row**.
5. `previous()` - Moves the cursor **backward**.
6. `next()` - Moves the cursor **forward**.
7. `absolute(int rowNumber)` - Moves the cursor to the **specified row number**.
8. `relative(int rowOffset)` - Moves the cursor **forward or backward** based on the offset value.

---
## [Construct JDBC Application to display Customer details based on PhoneNo.](https://github.com/lalitpatil891/Code-with-AdvanceJava/tree/main/PracticePrograms/JDBC_app_2/src/test)

 ```java
 package test;

 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.ResultSet;
 import java.sql.Statement;
 import java.util.Scanner;

 public class DBcon2 {

 	public static void main(String[] args) {

 		Scanner s = new Scanner(System.in);

 		try (s;) {

 			// Step 1: Load JDBC Driver
 			Class.forName("oracle.jdbc.driver.OracleDriver");

 			// Step 2: Create a Connection to the Database
 			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

 			// Step 3: Prepare a JDBC Statement
 			Statement stm = con.createStatement();

 			System.out.print("Enter the Cust-PhoneNo to display details: ");
 			long pNo = s.nextLong();

 			// Step 4: Execute the SQL Query
 			ResultSet rs = stm.executeQuery("Select * from Customer72 where phno =" + pNo + "");

 			if (rs.next()) {
 				System.out.println(rs.getLong(1) + "\t" +
 						rs.getString(2) + "\t" +
 						rs.getString(3) + "\t" +
 						rs.getString(4) + "\t" +
 						rs.getString(5));
 			} else {
 				System.out.println("Invalid Customer phone no..!");
 			}

 			// Step 5: Close the Database Connection
 			s.close();
 			con.close();

 		} catch (Exception e) {
 			e.printStackTrace();
 		}

 	}

 }

```

### **Expected Output**
```
Enter the Cust-PhoneNo to display details: 7676761234  
7676761234    HM7676761234    Raj    Hyd    rj@gmail.com
```
If the phone number does not exist:
```
Invalid Customer phone no..!
```
	This Java program connects to an Oracle database using JDBC and retrieves customer details based on a phone number input.
---
### [JDBC Application Insert Customer Details into Oracle Database]()  

### **Project Overview**  
This Java program reads customer details from the console and inserts them into the `Customer72` table in an **Oracle database** using **JDBC**.  

---

<!-- ## **Diagram**
![Diagram](path/to/image.png)

--- -->

## **Steps in the Program**
1. **Load JDBC Driver** – Load the Oracle JDBC driver.  
2. **Establish Database Connection** – Connect to the Oracle database.  
3. **Accept User Input** – Get customer details from the console.  
4. **Execute SQL Query** – Insert the data into the `Customer72` table.  
5. **Handle Errors** – Check for duplicate phone numbers and other SQL exceptions.  
6. **Close Resources** – Properly close the database connection.  

---

## **Code Implementation**
```java
/**
 * Construct JDBC Application to read Customer details from Console and insert into Customer72
 */

package test;

import java.util.*;
import java.sql.*;

public class DBcon3 {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			// Step 1: Load JDBC Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Step 2: Create a Connection to the Database
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			// Step 3: Prepare a JDBC Statement
			Statement stm = con.createStatement();

			System.out.print("Enter custo phoneNo: ");
			long phno = Long.parseLong(sc.nextLine());

			System.out.print("Enter cutomer id: ");
			String cid = "HM" + sc.nextLine();

			System.out.println("Enter cutomer name: ");
			String custName = sc.nextLine();

			System.out.println("Enter city name: ");
			String city = sc.nextLine();

			System.out.println("Enter mail ID: ");
			String mid = sc.nextLine();

			// Step 4: Execute the SQL Query
			int k = stm.executeUpdate("insert into Customer72 values(" + phno + ",'" + cid + "','" + custName + "','"
					+ city + "','" + mid + "')");

			if (k > 0) {
				System.out.println("Customer Details added Successfully...");
			}

			// Step 5: Close the Database Connection
			con.close();

		} catch (SQLIntegrityConstraintViolationException ee) {
			System.out.println("This Phone No. already registered..!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
```

---

## **Expected Output**
### **Successful Insertion**
```
Enter custo phoneNo: 7676761234  
Enter cutomer id: 101  
Enter cutomer name: Raj  
Enter city name: Hyderabad  
Enter mail ID: rj@gmail.com  
Customer Details added Successfully...
```

### **If Phone Number Already Exists**
```
This Phone No. already registered..!
```

---
## [JDBC Application for Customer Table Operations](https://github.com/lalitpatil891/Code-with-AdvanceJava/tree/main/PracticePrograms/JDBC_app_3/src/test)

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

---
## [BookTrackDBcon - JDBC Oracle Database Connectivity](https://github.com/lalitpatil891/Code-with-AdvanceJava/tree/main/PracticePrograms/BookTrack72_JDBC_app_1/src/test)

### Project Overview
BookTrackDBcon is a Java-based console application that interacts with an Oracle database to manage book records. The application allows users to:
- Insert multiple book records
- View all book details
- Search for a book by its book code

### Features
- Uses JDBC to connect to an Oracle database
- Supports inserting, viewing, and searching book records
- Handles user input errors gracefully
- Implements exception handling for robustness

### Technologies Used
- Java
- JDBC (Java Database Connectivity)
- Oracle Database

### Database Schema
Table: **BookDetails72**
```
BCODE    NUMBER(38)     PRIMARY KEY
BNAME    VARCHAR2(100)  NOT NULL
BAUTHOR  VARCHAR2(100)  NOT NULL
BPRICE   NUMBER(10,2)   NOT NULL
BQTY     NUMBER(38)     NOT NULL
```

### Setup Instructions
1. Install Oracle Database and create a schema.
2. Create the **BookDetails72** table using the following SQL command:
```sql
CREATE TABLE BookDetails72 (
    bcode NUMBER(38) PRIMARY KEY,
    bname VARCHAR2(100) NOT NULL,
    bauthor VARCHAR2(100) NOT NULL,
    bprice NUMBER(10,2) NOT NULL,
    bqty NUMBER(38) NOT NULL
);
```
3. Update database credentials in the `BookTrackDBcon.java` file:
```java
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "your_username", "your_password");
```
4. Compile and run the Java program:
```sh
javac BookTrackDBcon.java
java test.BookTrackDBcon
```

### Usage
1. **Insert Book Details**: Allows the user to insert multiple book records.
2. **View All Book Details**: Displays all stored book records.
3. **Find Book by Code**: Searches for a book using its unique book code.

### Error Handling
- Prevents SQL injection risks by ensuring correct data types.
- Catches `InputMismatchException` if non-integer values are entered where integers are expected.
- Displays meaningful error messages when queries fail.

---
## [Inventory Management System JDBC](https://github.com/lalitpatil891/Code-with-AdvanceJava/tree/main/PracticePrograms/JDBC_Inventory_App/src/test)

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

## [Product Management System](https://github.com/lalitpatil891/Code-with-AdvanceJava/tree/main/PracticePrograms/JDBC_product_app_Exam/src/test)

### Introduction
This is a Java-based Product Management System using JDBC and Oracle Database. The application allows users to perform basic operations on the `product72` table.

### Features
- Add a new product.
- View all products.
- Search for a product by its code.

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
```java
package test;

import java.util.*;
import java.sql.*;

public class ProductDBcon2 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");
            Statement stm = con.createStatement();

            System.out.println("\n** Choose an Operation **");
            System.out.println("  1. Add Product");
            System.out.println("  2. View All Products");
            System.out.println("  3. View Product by Code");
            System.out.print("Enter your choice: ");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Enter product code: ");
                    int codee = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Product name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter qty: ");
                    int qty = sc.nextInt();

                    int add = stm.executeUpdate("INSERT INTO product72 VALUES(" + codee + ",'" + name + "'," + price + ", " + qty + ")");
                    if (add > 0) {
                        System.out.println("Product Inserted Successfully!");
                    } else {
                        System.out.println("Insertion Failed!");
                    }
                    break;
                case 2:
                    ResultSet result = stm.executeQuery("SELECT * FROM product72");
                    while (result.next()) {
                        System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getDouble(3) + "\t" + result.getInt(4));
                    }
                    break;
                case 3:
                    System.out.print("Enter product code: ");
                    int code = sc.nextInt();
                    ResultSet rs = stm.executeQuery("SELECT * FROM product72 WHERE code=" + code);
                    while (rs.next()) {
                        System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3) + "\t" + rs.getInt(4));
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Usage Instructions
1. **Adding a Product**  
   - Enter product code, name, price, and quantity.
   - The product is added to the `product72` table.

2. **Viewing All Products**  
   - Displays all available products.

3. **Searching for a Product**  
   - Enter the product code to retrieve details.

### Error Handling
- Catches SQL exceptions for database operations.
- Ensures valid input from the user.

---
## [JDBC Bank Customer Management Application](https://github.com/lalitpatil891/Code-with-AdvanceJava/tree/main/PracticePrograms/JDBC_app_6/src/test)

### Description
This is a simple JDBC-based application that allows users to perform the following operations on a bank customer database:

1. **Add a Bank Customer**
2. **View All Bank Customers**
3. **Exit the Application**

The application continuously runs until the user chooses to exit.


### Diagram
![Program Diagram](https://github.com/lalitpatil891/Code-with-AdvanceJava/blob/main/Notes/Diagram's/JDBC_app_6.png)


### Prerequisites
To run this application, ensure you have the following installed:

- **Java Development Kit (JDK) 8 or later**
- **Oracle Database**
- **Oracle JDBC Driver**
- **Eclipse/IntelliJ IDEA (Optional)**

### Database Setup
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

### Code Execution Flow
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

### Code Implementation
Below is the Java code for the JDBC Bank Customer Management Application:

```java
package test;

import java.sql.*;
import java.util.*;

public class DBcon6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (sc;) {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "<your-username>", "<your-password>");
            PreparedStatement ps1 = con.prepareStatement("insert into BankCustomer72 values(?,?,?,?,?)");
            PreparedStatement ps2 = con.prepareStatement("select * from BankCustomer72");

            while (true) {
                System.out.println("***Operations Choice***");
                System.out.println("	 1. AddBankCustomer
	 2. ViewAllBankCustomer
	 3. Exit");
                System.out.println("Enter your Choice:");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter the custAccNo: ");
                        long accNo = Long.parseLong(sc.nextLine());
                        String cId = "SB" + accNo;
                        System.out.print("Enter the CustName: ");
                        String name = sc.nextLine();
                        System.out.print("Enter the Cust-Balance: ");
                        float balance = Float.parseFloat(sc.nextLine());
                        System.out.print("Enter the Cust-AccType: ");
                        String accType = sc.nextLine();
                        ps1.setLong(1, accNo);
                        ps1.setString(2, cId);
                        ps1.setString(3, name);
                        ps1.setFloat(4, balance);
                        ps1.setString(5, accType);
                        int k = ps1.executeUpdate();
                        if (k > 0) {
                            System.out.println("BankCustomer Added Successfully");
                        } else {
                            System.out.println("Something else..retry.!");
                        }
                        break;
                    case 2:
                        ResultSet rs = ps2.executeQuery();
                        while (rs.next()) {
                            System.out.println(rs.getLong(1) + "	" + rs.getString(2) + "	" + rs.getString(3) + "	" + rs.getFloat(4) + "	" + rs.getString(5));
                        }
                        break;
                    case 3:
                        System.out.println("Exit Successfully.");
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Invalid Choice!");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Execution Process
1. **Compile the Java Program**:
   ```sh
   javac DBcon6.java
   ```
2. **Run the Application**:
   ```sh
   java test.DBcon6
   ```

### How to Use
- **Add a Bank Customer**: Enter the customer's account number, name, balance, and account type when prompted.
- **View All Bank Customers**: Displays all records stored in the database.
- **Exit**: Terminates the application.

### JDBC Connection Details
The application connects to an Oracle database. Ensure you update your database credentials in the code before running the application.

- **JDBC URL**: `jdbc:oracle:thin:@localhost:1521:xe`
- **Username**: `<your-username>`
- **Password**: `<your-password>`

> **Note**: Replace `<your-username>` and `<your-password>` with your actual database credentials while configuring the application.

### Exception Handling
- The program handles potential SQL and input exceptions.
- If any database operation fails, the error stack trace is printed for debugging.

---
## [JDBC Application Bank Customer Management](https://github.com/lalitpatil891/Code-with-AdvanceJava/tree/main/PracticePrograms/JDBC_app_7/src/test)

### Description
This Java application connects to an Oracle database using JDBC and allows users to perform the following operations based on a given Account Number:
1. **Update Bank Customer** - Modify the balance and account type of an existing customer.
2. **Delete Bank Customer** - Remove a customer record from the database.

### Diagram
![Diagram](https://github.com/lalitpatil891/Code-with-AdvanceJava/blob/main/PracticePrograms/JDBC_app_7/src/test/JDBC_app_7.png)

### Prerequisites
- Java Development Kit (JDK) installed.
- Oracle Database installed and running.
- Oracle JDBC Driver (`ojdbc.jar`) added to the classpath.

### Database Schema
The application interacts with a table named `BankCustomer72`, which has the following structure:

| Column  | Data Type     | Constraints |
|---------|--------------|-------------|
| ACCNO   | NUMBER(15)   | NOT NULL (Primary Key) |
| CID     | VARCHAR2(15) | |
| CNAME   | VARCHAR2(15) | |
| BALANCE | NUMBER(10,2) | |
| ACCTYPE | VARCHAR2(15) | |

### Features
- Uses JDBC to connect to an Oracle database.
- Retrieves customer details before performing updates or deletions.
- Provides a simple text-based menu for user interaction.
- Implements input validation to prevent SQL errors and incorrect data modifications.

### How It Works
1. The user is prompted to enter a customer account number.
2. The system checks if the account exists in the database.
3. If the account exists, the user is given three choices:
   - **Update Customer**: Modify balance and account type.
   - **Delete Customer**: Confirm deletion before removing the record.
   - **Exit**: Terminate the program.
4. Based on user input, the corresponding SQL operations are performed.

### Error Handling
- Catches SQL syntax and connection errors.
- Handles invalid user input and provides meaningful messages.

### Sample SQL Queries
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

### Usage Instructions
1. Compile the Java program:
   ```sh
   javac DBcon7.java
   ```
2. Run the program:
   ```sh
   java test.DBcon7
   ```
3. Follow the on-screen instructions to update or delete customer records.

### Notes
- Ensure that the Oracle database is running and the connection details (host, port, username, password) are correctly set.
- Modify SQL queries if using a different database schema.
- Implement additional security measures, such as prepared statements, to prevent SQL injection.


---
# [Student Registration and Login System](https://github.com/lalitpatil891/Code-with-AdvanceJava/tree/main/PracticePrograms/JDBC_task_day01/src/test)

## Diagram
![Diagram](https://github.com/lalitpatil891/Code-with-AdvanceJava/blob/main/PracticePrograms/JDBC_task_day01/src/test/jdbc_task_day01.png)

## Description

This is a Java-based console application that implements a **Student Registration and Login System** using **JDBC** with an Oracle Database. The system allows students to:

- Register with their details.
- Log in using their roll number and first name.
- Perform various database operations such as updating contact information, viewing records, and deleting records.

## Features

- **Student Registration**: New students can register by entering their roll number, name, percentage, email, and phone number.
- **Login System**: Allows students to log in using roll number and first name.
- **Database Operations**:
  - Show students with percentage > 60%.
  - Update email and phone number.
  - Delete students whose percentage is between 30% and 60%.
  - Find students with a percentage greater than 80%.
  - View all student records.

---

## Database Setup

### **Table Structure**

Run the following SQL command to create the required **StudentInfo** table in Oracle Database:

```sql
CREATE TABLE StudentInfo (
    rollno NUMBER(3) PRIMARY KEY,
    name VARCHAR2(30),
    percentage DECIMAL(3,2),
    fname VARCHAR2(10),
    lname VARCHAR2(10),
    mailid VARCHAR2(30),
    phno NUMBER(10)
);
```

### **Sample Data (Insert Queries)**

```sql
INSERT INTO StudentInfo VALUES (101, 'Lalit Patil', 70.23, 'Lalit', 'Patil', 'lp@gmail.com', 7038898336);
INSERT INTO StudentInfo VALUES (102, 'Amit Sharma', 85.50, 'Amit', 'Sharma', 'amit.sh@gmail.com', 9876543210);
INSERT INTO StudentInfo VALUES (103, 'Priya Desai', 45.67, 'Priya', 'Desai', 'priya.d@gmail.com', 9234567890);
INSERT INTO StudentInfo VALUES (104, 'Rahul Verma', 59.80, 'Rahul', 'Verma', 'rahul.v@gmail.com', 8345678901);
INSERT INTO StudentInfo VALUES (105, 'Neha Joshi', 90.00, 'Neha', 'Joshi', 'neha.j@gmail.com', 9123456789);
INSERT INTO StudentInfo VALUES (106, 'Vikram Singh', 78.45, 'Vikram', 'Singh', 'vikram.s@gmail.com', 9345678901);
INSERT INTO StudentInfo VALUES (107, 'Sneha More', 32.50, 'Sneha', 'More', 'sneha.m@gmail.com', 9456789012);
INSERT INTO StudentInfo VALUES (108, 'Rajesh Gupta', 66.80, 'Rajesh', 'Gupta', 'rajesh.g@gmail.com', 9765432108);
INSERT INTO StudentInfo VALUES (109, 'Swati Pandey', 55.90, 'Swati', 'Pandey', 'swati.p@gmail.com', 8890123456);
INSERT INTO StudentInfo VALUES (110, 'Karan Mehta', 48.20, 'Karan', 'Mehta', 'karan.m@gmail.com', 9543216789);
```

---

## Prerequisites

- **Java JDK 8+**
- **Oracle Database 11g or higher**
- **Oracle JDBC Driver** (ojdbc8.jar)

### **Add JDBC Driver to Project**

1. Download the **ojdbc8.jar** file from Oracle’s website.
2. Add it to your project’s classpath.
3. If using an IDE like **Eclipse** or **IntelliJ IDEA**:
   - Right-click on the project → Properties → Java Build Path → Add External JARs.
   - Select **ojdbc8.jar** and apply the changes.

---

## How to Run

1. **Compile the program:**
   ```sh
   javac LoginRegisterDBcon.java
   ```
2. **Run the program:**
   ```sh
   java test.LoginRegisterDBcon
   ```

---

## Execution Flow

### **Main Menu**

```
**** Choose option ****
 1. Register
 2. Login
 3. Exit
Enter your Choice:
```

### **If Register (Option 1)**

```
Enter your RollNo: 101
Enter your name: Lalit Patil
Enter your percentage: 70.23
Enter your mailID: lp@gmail.com
Enter your PhoneNumber: 7038898336
Student record inserted successfully.
```

### **If Login (Option 2)**

```
Enter your RollNo: 101
Enter your name: Lalit
Login Successful.

**Menu**
--------------------------------------------------
1. Show Students Whose percentage > 60%
2. Update Mailid & Phone Number based on RollNo
3. Delete student whose Percentage is between 30% to 60%
4. Find how many students got more than 80%
5. View All records
6. Exit
Choose Option:
```

---

## Error Handling

The program handles errors using `try-catch` blocks for:

- **Duplicate Roll Numbers** (`SQLIntegrityConstraintViolationException`)
- **Invalid Data Entries** (`SQLDataException` and `InputMismatchException`)
- **Unexpected Errors** (Generic `Exception` handling)
---
# [JDBC Product Management Program](https://github.com/lalitpatil891/Code-with-AdvanceJava/tree/main/PracticePrograms/JDBC_lab_tasks/src/JDBC_tasks_day2/task_1)

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

---
# [JDBC Customer & Bank Management Program](https://github.com/lalitpatil891/Code-with-AdvanceJava/tree/main/PracticePrograms/JDBC_app_8/src/test)

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


---
## [Employee Management System (JDBC Application)](https://github.com/lalitpatil891/Code-with-AdvanceJava/tree/main/PracticePrograms/JDBC_app_Employee72/src/test)

### Overview
This is a Java-based JDBC application that interacts with an Oracle database to manage employee records. The application allows users to perform CRUD (Create, Read, Update, Delete) operations on the `Employee72` table.

### Features
1. **Add Employee** - Insert a new employee into the database.
2. **View All Employees** - Retrieve and display all employee records.
3. **View Employee By ID** - Fetch details of an employee using their ID.
4. **Update Employee Salary By ID** - Modify the basic salary of an employee.
5. **Delete Employee By ID** - Remove an employee record.
6. **Exit** - Terminate the application.

### Database Table Structure
Table Name: **Employee72**

| Column  | Data Type      | Constraints      |
|---------|--------------|----------------|
| eid     | number(3)    | Primary Key    |
| ename   | varchar2(20) | NOT NULL       |
| edesg   | varchar2(20) | NOT NULL       |
| bsal    | number(10,2) | NOT NULL       |
| hra     | number(10)   | Computed (91% of bsal) |
| da      | number(10)   | Computed (63% of bsal) |
| totsal  | number(10,2) | Computed (bsal + hra + da) |

### Business Logic
- `hra` (House Rent Allowance) = **91%** of `bsal`
- `da` (Dearness Allowance) = **63%** of `bsal`
- `totSal` (Total Salary) = `bsal` + `hra` + `da`
- **Minimum Basic Salary** must be **₹12,000** (otherwise, an exception is raised).

### Prerequisites
- Java Development Kit (JDK) installed (Version 8 or higher)
- Oracle Database installed and running
- Oracle JDBC Driver (`ojdbc8.jar`)
- Database user credentials (Update the connection URL, username, and password in the code)

### Installation & Setup
1. **Create the Database Table:**
   ```sql
   CREATE TABLE Employee72 (
       eid NUMBER(3) PRIMARY KEY,
       ename VARCHAR2(20) NOT NULL,
       edesg VARCHAR2(20) NOT NULL,
       bsal NUMBER(10,2) NOT NULL,
       hra NUMBER(10),
       da NUMBER(10),
       totsal NUMBER(10,2)
   );
   ```

2. **Compile & Run the Java Program:**
   ```sh
   javac DBconEmployee72.java
   java test.DBconEmployee72
   ```

### Usage
- The application presents a menu-driven interface where users can choose operations by entering the corresponding number.
- Input employee details when prompted and follow on-screen instructions.

### Exception Handling
- Ensures the basic salary is at least ₹12,000 before inserting or updating records.
- Catches invalid input types to prevent runtime errors.
- Handles SQL exceptions gracefully.


---

## Contribution
If you want to contribute or suggest improvements, feel free to fork the repository and create a pull request.

## Author
Maintained by Lalit Patil
