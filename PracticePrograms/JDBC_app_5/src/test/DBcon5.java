/**
 * Construct JDBC Application to perform Update and Delete Operations on Customer table.
 *	(based Customer PhoneNo) 
 * 
 */

package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBcon5 {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			// step-1 :
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step-2
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			// step-3
			Statement stm = con.createStatement();

			System.out.println("*******Operation Choice*****");
			System.out.println("\t 1. Update");
			System.out.println("\t 2. Delete ");
			System.out.println("\t 3. View Record");
			System.out.print("Enter your choice:");
			int choice = sc.nextInt();

			// step-4
			switch (choice) {
			case 1:
				try {
					System.out.print("Enter phone number: ");
					long pno = sc.nextLong();
					sc.nextLine();
					System.out.print("Enter city Name: ");
					String nCity = sc.nextLine();

					System.out.print("Enter Mail id: ");
					String mail = sc.nextLine();

					int k = stm.executeUpdate(
							"Update Customer72 set city='" + nCity + "',mid='" + mail + "' where phno=" + pno + "");

					System.out.println("k: " + k);
					if (k > 0) {

						System.out.println("Data update Successfully..!");
					} else {
						System.out.println("Phone number invalid");
					}

				} catch (SQLException e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;

			case 2:

				try {
					System.out.print("Enter phone number: ");
					long pnu = sc.nextLong();

					// Execute the delete query
					int rowsAffected = stm.executeUpdate("DELETE FROM customer72 WHERE phno = " + pnu);

					// Check if data was deleted
					if (rowsAffected > 0) {
						System.out.println(pnu + " Data deleted successfully..!");
					} else {
						System.out.println("Invalid phone number. No record found!");
					}

				} catch (SQLException e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;

			case 3:
				ResultSet rs = stm.executeQuery("Select * from Customer72");

				while (rs.next()) {
					System.out.println(rs.getLong(1) + "\t" +

							rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5));

				}
				break;

			default:
				System.out.println("invalid choice..!");
				break;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
