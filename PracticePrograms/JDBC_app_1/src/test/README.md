## [JDBC Application Setup Guide]()

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

Write the following JDBC code to display all Customer details.

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
