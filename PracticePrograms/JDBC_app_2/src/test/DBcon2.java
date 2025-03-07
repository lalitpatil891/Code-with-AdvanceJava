/**
 *--> Construct JDBC Application to display Customer details based on PhoneNo.
 * 
 * */
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

			// step1: Load JDBC Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2: Create a Connection to the Database
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			// step3: Prepare a JDBC Statement
			Statement stm = con.createStatement();

			System.out.print("Enter the Cust-PhoneNo to display details: ");
			long pNo = s.nextLong();

			// step4: Execute the SQL Query
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

			// step5: Close the Database Connection

			s.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

/*
 * OUTPUT
 *
 * Enter the Cust-PhoneNo to display details: 7676761234 7676761234 HM7676761234
 * Raj Hyd rj@gmail.com
 */