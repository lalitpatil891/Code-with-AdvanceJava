/**
 * Construct JDBC Application to read Customer details from Console and insert into Customer72
 * 
 * */

package test;

import java.util.*;
import java.sql.*;

public class DBcon3 {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			// step-1 : Load JDBC Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step-2 : Create a Connection to the Database
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			// step-3 : Prepare a JDBC Statement
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

			// step-4 : Execute the SQL Query
			int k = stm.executeUpdate("insert into Customer72 values(" + phno + ",'" + cid + "','" + custName + "','"
					+ city + "','" + mid + "')");

			if (k > 0) {

				System.out.println("Customer Details added Successfully...");
			}

			// step-5 : Close the Database Connection
			con.close();

		} catch (SQLIntegrityConstraintViolationException ee) {
			System.out.println("This Phone No. already registered..!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
