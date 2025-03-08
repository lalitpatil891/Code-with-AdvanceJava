/**
  2.Construct JDBC Application to perform the following Operations on Product table(10 marks)
    	1.AddPoduct
   		2.ViewAllProducts
   		3.ViewProductByCode

*/

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

				// SQL> Insert into Product72 values(101, 'Realme9', 9000, 30);
				int add = stm.executeUpdate(
						"INSERT INTO product72 VALUES(" + codee + ",'" + name + "'," + price + ", " + qty + ")");

				if (add > 0) {
					System.out.println("Product Insert Successfully..!");
				} else {
					System.out.println("Something else..!");
				}
				break;

			// view All product
			case 2:

				ResultSet result = stm.executeQuery("Select * from product72");

				while (result.next()) {
					System.out.println(result.getInt(1) + "\t" + 
				
							result.getString(2) + "\t" + 
							result.getDouble(3) + "\t" +
							result.getInt(4));
				}
				break;

			// view product by code
			case 3:

				System.out.print("Enter product code: ");
				int code = sc.nextInt();
				
				ResultSet rs = stm.executeQuery("Select * from product72 where code="+code+"");

				while (rs.next()) {
					System.out.println(rs.getInt(1) + "\t" + 
				
							rs.getString(2) + "\t" + 
							rs.getDouble(3) + "\t" +
							rs.getInt(4));
				}
				
				break;

			default:
				System.out.println("Invalid chooice");
				break;

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
