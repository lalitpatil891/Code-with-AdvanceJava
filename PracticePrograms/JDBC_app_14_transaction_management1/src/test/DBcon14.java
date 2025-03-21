/**DB Table : Bank72(accNo,name,bal,accType)
           		Primary Key:accNo
create table Bank72(accno number(15),name varchar2(15),bal number(10,2),accType varchar2(15),
primary key(accno));

insert into Bank72 values(6123456,'Alex',12000,'Savings');
insert into Bank72 values(313131,'Ram',500,'Savings');
*/

package test;

import java.util.*;
import java.sql.*;

public class DBcon14 {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			PreparedStatement ps1 = con.prepareStatement("Select * from Bank72 where accNo=?");

			PreparedStatement ps2 = con.prepareStatement("Update Bank72 set bal=bal+? where accNo=?");

			System.out.println("Commit-Status: " + con.getAutoCommit()); // true
			con.setAutoCommit(false); // Auto-commit opration stoped.
			System.out.println("Commit-Status: " + con.getAutoCommit()); // false

			System.out.println("Enter the home-AccNO: ");
			long hAccNo = sc.nextLong();
			ps1.setLong(1, hAccNo);

			ResultSet rs1 = ps1.executeQuery();

			if (rs1.next()) {
				float b1 = rs1.getFloat(3);
				System.out.print("Enter the benificieryAccNo:");
				long bAccNo = sc.nextLong();
				ps1.setLong(1, bAccNo);

				ResultSet rs2 = ps1.executeQuery();

				if (rs2.next()) {

					System.out.print("Enter the Amount to be Transferred:");
					float amt = sc.nextFloat();
					if (amt <= b1) {
						// Statement-1 : Subtract amt:5000/- from accNo:6123456

						ps2.setFloat(1, -amt);
						ps2.setLong(2, hAccNo);
						int p = ps2.executeUpdate(); // Updated in Buffer

						// Statement-2 : Add amt:5000/- to accNo:313131
						ps2.setFloat(1, +amt);
						ps2.setLong(2, bAccNo);
						int q = ps2.executeUpdate(); // Updated in Buffer

						if (p == 1 && q == 1) {
							System.out.println("Transaction Successfull...");

							con.commit();

						} else {
							System.err.println("Transaction Failed!!!");
						}
						con.rollback();

					} else {
						System.out.println("InSufficient Fund...");
					}
				} else {
					System.out.println("Invalid bAccNo!!!");
				}

			} else {
				System.out.println("Invalid HomeAccNO!!!");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
