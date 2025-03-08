package test;

import java.util.*;
import java.sql.*;

public class BookTrackDBcon {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			Statement stm = con.createStatement();

			System.out.println("****Options****");
			System.out.println("\t 1. Insert Book Details ");
			System.out.println("\t 2. View All Book Details ");
			System.out.println("\t 3. Find Book Details based on BookCode:");

			System.out.println("type option");
			int op = sc.nextInt();

			switch (op) {

			case 1:

				System.out.print("Enter the number of records you want to insert:");
				int num = sc.nextInt();

				if (num < 0) {
					System.out.println("Please enter positive value!");
				} else {

					while (num > 0) {

						System.out.println("*** Enter " + num + " book Information ***");
						System.out.print("Enter Book Code: ");
						int bcode = sc.nextInt();

						sc.nextLine();
						System.out.print("Enter Book Name: ");
						String bname = sc.nextLine();

						System.out.print("Enter Book Author: ");
						String bauthor = sc.nextLine();

						System.out.print("Enter Book Price: ");
						double bprice = sc.nextDouble();

						System.out.print("Enter Book Qty: ");
						int bqty = sc.nextInt();

						int rowsAffected = stm
								.executeUpdate("INSERT INTO BookDetails72(bcode,bname,bauthor,bprice,bqty)VALUES("
										+ bcode + ",'" + bname + "','" + bauthor + "'," + bprice + "," + bqty + ")");

						if (rowsAffected > 0) {
							System.out.println("Data Inserted successfully..!");
						} else {
							System.out.println("Invalid Data.");
						}

						num--;
					}
				}
				break;

			case 2:

				ResultSet rs = stm.executeQuery("Select * from bookdetails72");
		
				while (rs.next()) {
					System.out.println(rs.getInt(1) + "\t" +

							rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getDouble(4) + "\t" + rs.getInt(5));
				}

				break;

			case 3:
				try {
					
				
				System.out.print("Enter bookCode: ");
				int bcode = sc.nextInt();

				ResultSet result = stm.executeQuery("SELECT * FROM bookdetails72 WHERE bcode = " + bcode);

				if (!result.isBeforeFirst()) { // Checks if the ResultSet is empty
					System.out.println("No book found with the given BookCode: " + bcode);
				} else {
					while (result.next()) {
						System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3)
								+ "\t" + result.getDouble(4) + "\t" + result.getInt(5));
					}
				}
				
				}
				catch(InputMismatchException mis)
				{
					System.err.println("Enter only integer value.");
				}
				catch(Exception eee)
				{
					eee.printStackTrace();
				}
				break;

			default:

				System.out.println("Invalid Choice!");
				break;

			} // switch

		} // try ended

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/**
 * Name Null? Type ----------------------------------------- --------
 * ---------------------------- BCODE NOT NULL NUMBER(38) BNAME NOT NULL
 * VARCHAR2(100) BAUTHOR NOT NULL VARCHAR2(100) BPRICE NOT NULL NUMBER(10,2)
 * BQTY NOT NULL NUMBER(38)
 * 
 */