# **JDBC Application: Fetch Customer Details by Phone Number**  

## **Project Overview**  
This Java program connects to an **Oracle database** using **JDBC** and retrieves customer details based on a phone number entered by the user.  

---

### **Diagram**  
![Diagram](path/to/image.png)

---

### **Steps in the Program**
1. **Load JDBC Driver** – Load the Oracle JDBC driver.  
2. **Establish Database Connection** – Connect to the Oracle database.  
3. **User Input** – Accept a phone number from the user.  
4. **Execute SQL Query** – Retrieve customer details based on the phone number.  
5. **Display Data** – Show the customer details if found; otherwise, show an error message.  
6. **Close Resources** – Close the database connection and scanner.

---

### **Code Implementation**
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

---

### **Expected Output**
```
Enter the Cust-PhoneNo to display details: 7676761234  
7676761234    HM7676761234    Raj    Hyd    rj@gmail.com
```
If the phone number does not exist:
```
Invalid Customer phone no..!
```

---

### **Prerequisites**
- Install **Oracle Database** (XE or full version).  
- Ensure **Oracle JDBC Driver** is available in the classpath.  
- Update the **database credentials** (`username`, `password`, `host`) in the `getConnection()` method if needed.  

---

### **How to Run**
1. **Compile the Java file**  
   ```sh
   javac DBcon2.java
   ```
2. **Run the program**  
   ```sh
   java test.DBcon2
   ```
---
