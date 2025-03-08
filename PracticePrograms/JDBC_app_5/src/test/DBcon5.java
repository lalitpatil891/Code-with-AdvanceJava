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
import java.util.InputMismatchException;
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

					ResultSet check = stm.executeQuery("select * from Customer72 where phno =" + pno + "");

					if (!check.next()) {
						System.err.println("No customer found with the given code. Update operation aborted.");
					} else {

						System.out.print("Enter city Name: ");
						String nCity = sc.nextLine();

						System.out.print("Enter Mail id: ");
						String mail = sc.nextLine();

						int k = stm.executeUpdate(
								"Update Customer72 set city='" + nCity + "',mid='" + mail + "' where phno=" + pno + "");

						System.out.println("k: " + k);

						if (k > 0) {
							System.out.println("Data updated successfully!");
						} else {
							System.err.println("Update failed: Invalid phone number or no matching record found.");
						}

					}

				} catch (SQLException e) {
					System.err.println("Error: " + e.getMessage());
				} catch (Exception ee) {
					ee.printStackTrace();
				}
				break;

			case 2:

				try {
					System.out.print("Enter phone number: ");
					long pnu = sc.nextLong();

					ResultSet pre = stm.executeQuery("select * from Customer72 where phno =" + pnu + "");

					if (!pre.next()) {
						System.err.println("No product found with the given code. Delete operation aborted.");
					} else {

					
						int rowsAffected = stm.executeUpdate("DELETE FROM customer72 WHERE phno = " + pnu);

						
						if (rowsAffected > 0) {
							System.out.println(pnu + " Data deleted successfully..!");
						} else {
							System.out.println("Invalid phone number. No record found!");
						}
					}
				} catch (SQLException e) {
					System.err.println("Error: " + e.getMessage());
				}catch(InputMismatchException ee)
				{
					System.err.println("Invalid phone number.!");
				}
				catch(Exception eee)
				{
					eee.printStackTrace();
				}
				break;

			case 3:

				ResultSet rs = stm.executeQuery("Select * from Customer72");

				while (rs.next()) {

					System.out.println(rs.getLong(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t"
							+ rs.getString(4) + "\t" + rs.getString(5));
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
