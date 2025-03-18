/** Storing Stream data to database product 
 * Step-1 :
 * Create DB Table with name StreamTab72(id, name, mfile)
 * create table StreamTab72(id varchar2(10), name varchar2(15), mfile 
 * BLOB, primary key(id));
 * 
 * Step-2 : 
 * Construct JDBC Application to store Image to Database product
 * 
*/

package test;

import java.util.*;
import java.io.*;
import java.sql.*;

public class DBcon9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc;) {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			PreparedStatement ps = con.prepareStatement("insert into StreamTab72 values(?,?,?)");

			System.out.print("Enter the User-Id:");
			String id = sc.nextLine();

			System.out.print("Enter the USer-Name: ");
			String name = sc.nextLine();

			System.out.print("Enter the Location(fPath&fName)  of user - Image(Source)");

			String path = sc.nextLine();
			File f = new File(path);

			if (f.exists()) {
				FileInputStream fis = new FileInputStream(path);
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setBinaryStream(3, fis, f.length());
				int k = ps.executeUpdate();

				if (k > 0) {
					System.out.println("Image Stored Successfully...");

				}
				fis.close();
			} else {
				System.out.println("Invalid fPath or fName or fPath...");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
