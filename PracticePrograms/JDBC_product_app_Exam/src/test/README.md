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
