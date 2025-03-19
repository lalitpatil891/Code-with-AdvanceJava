/**
 * 	Program_03:
 *  JDBC program to insert image into database table.
 *  Hints:Table-Player_info
 *  Table columns:pId,pName,pImage,pDateOfBirth.
 *  
 *  create table player_info(pId number(3) primary key,pName varchar2(20), pImage BLOB, pDateOfBirth date);
 *  
*/
package JDBC_tasks_day2.task_3;

import java.util.*;
import java.sql.*;
import java.io.*;

public class DBconTask3 {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			PreparedStatement insertQuery = con.prepareStatement("insert into player_info values(?,?,?,?)");

			System.out.print("Enter pId:");
			int pId = sc.nextInt();
			sc.nextLine();

			System.out.print("Enter pName:");
			String pName = sc.nextLine();

			System.out.print("Enter pImage:");
			String pImage = sc.nextLine();
			File f = new File(pImage);

			if (f.exists()) {

				System.out.print("Enter pDateOfBirth:");
				String pDateOfBirth = sc.nextLine();

				FileInputStream fis = new FileInputStream(pImage);

				insertQuery.setInt(1, pId);
				insertQuery.setString(2, pName);
				insertQuery.setBinaryStream(3, fis, f.length());
				insertQuery.setString(4, pDateOfBirth);

				int k = insertQuery.executeUpdate();

				if (k > 0) {
					System.out.println("Image Stored Successfully...");
				}
				fis.close();
			} else {
				System.out.println("Invalid file path or file name..!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
