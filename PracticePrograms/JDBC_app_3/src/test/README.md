## **JDBC Application: Insert Customer Details into Oracle Database**  

### **Project Overview**  
This Java program reads customer details from the console and inserts them into the `Customer72` table in an **Oracle database** using **JDBC**.  

---

<!-- ## **Diagram**
![Diagram](path/to/image.png) -->

---

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

## **Prerequisites**
- Install **Oracle Database** (XE or full version).  
- Ensure **Oracle JDBC Driver** is available in the classpath.  
- Update the **database credentials** (`username`, `password`, `host`) in the `getConnection()` method if needed.  

---

## **How to Run**
1. **Compile the Java file**  
   ```sh
   javac DBcon3.java
   ```
2. **Run the program**  
   ```sh
   java test.DBcon3
   ```

---
