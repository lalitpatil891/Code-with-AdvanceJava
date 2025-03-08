/** Assignment:
DB Table : Product72(code,name,price,qty)
           Primary key : code

Construct JDBC Application to perform the following operations based on User Choice:
     1.AddProduct
     2.ViewAllProducts
     3.ViewProductByCode  
     4.UpdateProductByCode(price-qty)
     5.DeleteProductByCode
     6.Exit
Note:
  =>repeat the above choice(operations) until we perform exit-operation
*/
package test;

import java.util.*;
import java.sql.*;

public class InventoryAppDBcon {

	public static void main(String[] args) 
	{
		
		try(Scanner sc = new Scanner(System.in))
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","lalit");
			
			Statement stm = con.createStatement();
			
			System.out.println("***Choose option***");
			System.out.println("\t 1. Add Product");
			System.out.println("\t 2. view All Products");
			System.out.println("\t 3. view product by id");
			System.out.println("\t 4. Update product by code ");
			System.out.println("\t 5. Delete product by code");
			System.out.println("\t 6. Exit");
			System.out.println("--------------------------------------");
			
			System.out.print("Enter your Option:");
			int op = sc.nextInt();
			
			switch(op) {
			//Add products
			case 1 : 
					
					System.out.println("Enter how many record do you want to insert:");
					int num = sc.nextInt();
					
					System.out.print("Enter product code: ");
					int code = sc.nextInt();
					
					sc.nextLine();
					System.out.print("Enter Product name: ");
					String name =sc.nextLine();
	
					System.out.print("Enter price: ");
					double price = sc.nextDouble();
					
					System.out.print("Enter qty: ");
					int qty = sc.nextInt();
					
					//SQL> Insert into Product72 values(101, 'Realme9', 9000, 30);
					int add = stm.executeUpdate("INSERT INTO product72 VALUES("+code+",'"+name+"',"+price+", "+qty+")");
					
					if(add>0)
					{
						System.out.println("Product Insert Successfully..!");
					}
					else
					{
						System.out.println("Something else..!");
					}
					
					break;
					
			//view all products
			case 2 : break;
			
			
			//view product by id
			case 3 : break;
			
			//update product by code
			case 4 : break;
			
			
			//delete product by code
			case 5 : break;
			
			
			//exit
			case 6 : break;
			
			default: 
				System.out.println("Wrong options");
				break;
			
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}


/*
 * SQL> Create table Product72(  code Number(5) primary key, name varchar2(30), price number(5,2),qty number(5));
 * 
 * SQL> desc product72
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 CODE                                      NOT NULL NUMBER(5)
 NAME                                               VARCHAR2(30)
 PRICE                                              NUMBER(5,2)
 QTY                                                NUMBER(5)
 */