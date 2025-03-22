/**Batch Processing in JDBC
	The process of collecting multiple queries as batch and executing on Database product at-a-time, is known as Batch Processing.
	Batch Processing Support only NonSelect queries, and which is also known as Batch Update processing.
	In real time, the Batch Processing is performed using 'Statement'.
	The following are some important methods related to barch processing:
        		(a) addBatch()
        		(b) executeBatch()
        		(c) clearBatch()
*/

package test;

import java.util.*;
import java.sql.*;

public class DBcon15 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try (sc;) {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			Statement stm = con.createStatement();

			System.out.println("****Insert on Bank72*****");

			System.out.print("Enter the AccNo:");
			long accNo = Long.parseLong(sc.nextLine());

			System.out.print("Enter the name: ");
			String name = sc.nextLine();

			System.out.print("Enter the balance: ");
			float bal = Float.parseFloat(sc.nextLine());

			System.out.print("Enter the AccType: ");
			String accType = sc.nextLine();

			stm.addBatch("insert into Bank72 values(" + accNo + ",'" + name + "'," + bal + ",'" + accType + "')");

			System.out.println("**** Delete on Customer72 ****");

			System.out.print("Enter the Cust-phoneNo to delete the details: ");
			long pNo = Long.parseLong(sc.nextLine());

			stm.addBatch("delete from Customer72 where phno = "+ pNo +"");

			int k[] = stm.executeBatch();
			for (int i : k) {
				System.out.println("query executed: " + i);
			} // end of loop

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
