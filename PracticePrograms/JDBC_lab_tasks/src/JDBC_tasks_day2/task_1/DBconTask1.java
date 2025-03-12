/**
Program_01:
==========
Program1:Write a jdbc program as follows:
Note:Create a table:-Product40 (U can create table from database).
              Table Columns:-productId,productName,productPrice,productQty.
Give Option to the user:
          1.Insert productdetails into product table.
          2.Retrieve productdetails in forward direction.
          3.Retrieve productdetails in reverse direction.
          4.Retrieve 3rd record from top.
          5.Retrieve 3rd record from bottom. 
          6.Retrieve last three record from product table. 
*/

package JDBC_tasks_day2.task_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DBconTask1 {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			PreparedStatement insertQuery = con.prepareStatement("INSERT INTO PRODUCT40 VALUES(?,?,?,?)"); 
			PreparedStatement ViewAllQuery = con.prepareStatement("SELECT * FROM PRODUCT40",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 
			
			while (true) {
			System.out.println("\n***Choose Option***");

			System.out.println("1.Insert productdetails into product table.\r\n"
					+ "2.Retrieve productdetails in forward direction.\r\n"
					+ "3.Retrieve productdetails in reverse direction.\r\n" + "4.Retrieve 3rd record from top.\r\n"
					+ "5.Retrieve 3rd record from bottom. \r\n" + "6.Retrieve last three record from product table. \r\n"+ "7.Exit");
			System.out.print("Enter your Choice: ");
			int choice = sc.nextInt();

			
				switch (choice) {
				//1.Insert productdetails into product table.
				case 1:
					System.out.println("=== Insert Data ===");
					System.out.print("Enter productId: ");
					int productId = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter productName: ");
					String productName = sc.nextLine();
					System.out.print("Enter productPrice: ");
					double productPrice = sc.nextDouble();
					System.out.print("Enter productQty: ");
					int productQty = sc.nextInt();
					
					insertQuery.setInt(1, productId);
					insertQuery.setString(2, productName);
					insertQuery.setDouble(3, productPrice);
					insertQuery.setInt(4, productQty);
					
					int k = insertQuery.executeUpdate();
					
					if (k > 0) {
		                System.out.println("Product inserted successfully!");
		            } else {
		                System.err.println("Insertion failed! Please try again.");
		            }
					break;
					
				//2.Retrieve productdetails in forward direction.
				case 2:
					
					ResultSet rs = ViewAllQuery.executeQuery();
					System.out.println("productId |  productName  |  productPrice  |  productQty");
					int count =0;
					while(rs.next())
					{
						count++;
						System.out.println(rs.getInt(1)+" \t "+rs.getString(2)+" \t "+rs.getFloat(3)+" \t "+rs.getInt(4));
					}
					
					if(count!=0)
					{
						System.out.print("");
					}
					else 
					{
						System.err.println("No record Found");
					}
					
					
					
					
					
					break;
					
				//3.Retrieve productdetails in reverse direction.
				case 3:
					ResultSet rss = ViewAllQuery.executeQuery();
					rss.afterLast();
	
					System.out.println("productId |  productName  |  productPrice  |  productQty");
					count =0;
					while(rss.previous())
					{
						count++;
						System.out.println(rss.getInt(1)+" \t "+rss.getString(2)+" \t "+rss.getFloat(3)+" \t "+rss.getInt(4));
					}
					
					if(count!=0)
					{
						System.out.print("");
					}
					else 
					{
						System.err.println("No record Found");
					}
					
					
					break;
				
				//4.Retrieve 3rd record from top.
				case 4:
					
					ResultSet rsss = ViewAllQuery.executeQuery();
					rsss.absolute(3);
					
	
					System.out.println("productId |  productName  |  productPrice  |  productQty");
				
					System.out.println(rsss.getInt(1)+" \t "+rsss.getString(2)+" \t "+rsss.getFloat(3)+" \t "+rsss.getInt(4));
				
					break;
					
				//5.Retrieve 3rd record from bottom.
				case 5:
				

					ResultSet r = ViewAllQuery.executeQuery();
					r.absolute(-3);
					
	
					System.out.println("productId |  productName  |  productPrice  |  productQty");
				
					System.out.println(r.getInt(1)+" \t "+r.getString(2)+" \t "+r.getFloat(3)+" \t "+r.getInt(4));
				
					break;
					
				//6.Retrieve last three record from product table.
				case 6:
					
					ResultSet result = ViewAllQuery.executeQuery();
					result.afterLast();
	
					System.out.println("productId |  productName  |  productPrice  |  productQty");
					count = 0;
			        while (result.previous() && count < 3)
					{
						count++;
						System.out.println(result.getInt(1)+" \t "+result.getString(2)+" \t "+result.getFloat(3)+" \t "+result.getInt(4));
					}
					
					if(count!=0)
					{
						System.out.print("");
					}
					else 
					{
						System.err.println("No record Found");
					}
					
					break;
					
				//exit	
				case 7:
					System.out.println("Exit successfully.");
					System.exit(0);

				}// switch-end

			} // while-end
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}

/*
 * 
 * SQL> Create table Product40 ( productId NUMBER(3) PRIMARY KEY,productName
 * VARCHAR2(30) ,productPrice NUMBER(10,2),productQty NUMBER(5));
 * 
 * SQL> INSERT INTO PRODUCT40 VALUES(201, 'headphone', 499, 80 ); INSERT INTO
 * PRODUCT40 VALUES(202, 'Realme9', 11000, 30 ); INSERT INTO PRODUCT40
 * VALUES(203, 'SamsungJ2',8000, 80 ); INSERT INTO PRODUCT40 VALUES(204,
 * 'Readmi9', 12000, 20 );
 */
