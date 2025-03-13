package test;

import java.util.*;
import java.sql.*;

public class DBcon8 {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			System.out.println("******Statement*******");
			Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs1 = stm.executeQuery("Select * from Customer72");
			// All record
			System.out.println("---All Record (Forward Direction)---");
			while (rs1.next()) {

				System.out.println(rs1.getLong(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
						+ rs1.getString(4) + "\t" + rs1.getString(5));
			}
			// 3rd row record
			System.out.println("---3rd row---");
			rs1.absolute(3);
			System.out.println(rs1.getLong(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
					+ rs1.getString(4) + "\t" + rs1.getString(5));

			// relative(-2)
			System.out.println("--- relative(-2)----");
			rs1.relative(-2);
			System.out.println(rs1.getLong(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
					+ rs1.getString(4) + "\t" + rs1.getString(5));

			// Last row
			System.out.println("---- Last row ----");
			rs1.last();
			System.out.println(rs1.getLong(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
					+ rs1.getString(4) + "\t" + rs1.getString(5));

			// first row
			System.out.println("----First Row-----");
			rs1.first();
			System.out.println(rs1.getLong(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
					+ rs1.getString(4) + "\t" + rs1.getString(5));

			// PreparedStatement
			System.out.println("***PreparedStatement*****");
			PreparedStatement ps = con.prepareStatement("Select * from BankCustomer72",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs2 = ps.executeQuery();

			System.out.println("****All BankCustomers*******");
			while (rs2.next()) {
				System.out.println(rs2.getLong(1) + "\t" + rs2.getString(2) + "\t" + rs2.getString(3) + "\t"
						+ rs2.getString(4) + "\t" + rs2.getString(5));
			}

			// reverse Order
			System.out.println("---- reverse ----");
			rs2.afterLast();

			while (rs2.previous()) {
				System.out.println(rs2.getLong(1) + "\t" + rs2.getString(2) + "\t" + rs2.getString(3) + "\t"
						+ rs2.getString(4) + "\t" + rs2.getString(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
