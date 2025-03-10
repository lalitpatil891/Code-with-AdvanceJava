/**Construct JDBC Application to perform the following operations based on Choice:
    
    1.AddBankCustomer
    2.ViewAllBankCustomers
    3.Exit
	
	Note: repeat the process until we perform exit operation
*/

package test;

import java.sql.*;
import java.util.*;

public class DBcon6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try (sc;) {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");
			PreparedStatement ps1 = con.prepareStatement("insert into BankCustomer72 values(?,?,?,?,?)");
			
			// Compilation Process
			PreparedStatement ps2 = con.prepareStatement("select * from BankCustomer72"); // Compilation process

			while (true) {
				System.out.println("***Operations Choice***");
				System.out.println("\t 1. AddBankCustomer" + "\n\t 2. ViewAllBankCustomer" + "\n\t 3. Exit");

				System.out.println("Enter your Choice:");
				int choice = Integer.parseInt(sc.nextLine());

				switch (choice) {
				
				// AddBankCustomer
				case 1:

					System.out.print("Enter the custAccNo: ");
					long accNo = Long.parseLong(sc.nextLine());
					String cId = "SB" + accNo;

					System.out.print("Enter the CustName: ");
					String name = sc.nextLine();

					System.out.print("Enter the Cust-Balance: ");
					float balance = Float.parseFloat(sc.nextLine());

					System.out.print("Enter the Cust-AccType:");
					String accType = sc.nextLine();

					// Load data to PreparedStatement Object using setter Methods
					ps1.setLong(1, accNo);
					ps1.setString(2, cId);
					ps1.setString(3, name);
					ps1.setFloat(4, balance);
					ps1.setString(5, accType);

					int k = ps1.executeUpdate(); // Execution Process

					if (k > 0) {
						System.out.println("BankCustomer Added Successfully");
					} else {
						System.out.println("Something else..retry.!");
					}
					break;

				// ViewAllVBankCustomer
				case 2:
					ResultSet rs = ps2.executeQuery();

					while (rs.next()) {

						System.out.println(rs.getLong(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getFloat(4) + "\t" + rs.getString(5) + "");

					} // loop-end

					break;

				// Exit
				case 3:
					System.out.println("Exit Successfully.");
					System.exit(0);
					break;

				default:
					System.err.println("Invalid Choice!");
					break;

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
