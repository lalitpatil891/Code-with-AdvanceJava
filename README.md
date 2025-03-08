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
  - programs
     - [Write the following JDBC code to display all Customer details](#write-the-following-jdbc-code-to-display-all-Customer-details)
     - [JDBC Application: Insert Customer Details into Oracle Database](#jdbc-application:-insert-customer-details-into-oracle-database)
     - [JDBC Application for Customer Table Operations](#jdbc-application-for-customer-table-operations)
     - [BookTrackDBcon - JDBC Oracle Database Connectivity](#booktrackdbcon-jdbc-oracle-database-connectivity)
     - [Inventory Management System JDBC](#inventory-management-system-jdbc) (jdbc-app)


<!--
- Servlets & JSP (Java Server Pages)
- Spring Framework (Spring Boot, Spring MVC)
- Hibernate & JPA (Java Persistence API)
- Web Services (REST & SOAP APIs)
- Multithreading & Concurrency
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
## [JDBC Application: Insert Customer Details into Oracle Database]()  

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

---
## Contribution
If you want to contribute or suggest improvements, feel free to fork the repository and create a pull request.

## Author
Maintained by Lalit Patil
