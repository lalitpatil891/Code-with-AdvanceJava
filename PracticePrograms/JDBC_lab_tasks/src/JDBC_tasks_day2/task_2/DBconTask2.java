/**
 * Program_02:
 * ==========
 * Step01=>Create Table: emp_info
 * Columns: empId,empName,empAddress,empMailId,empPhNo,empResume(text file).
 * Step02:Write a JDBC program to insert employee details into database table. 
 * 
 * Create Table emp_info (empId number(4) Primary Key, empName varchar2(20), empAddress varchar2(30),empMailId varchar2(20),empPhNO Number(12), empResume BLOB); 
 * 
 **/

package JDBC_tasks_day2.task_2;

import java.util.*;
import java.sql.*;
import java.io.*;

public class DBconTask2 {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			PreparedStatement insertQuery = con.prepareStatement("insert into emp_info values(?,?,?,?,?,?)");

			System.out.print("Enter empId: ");
			int empId = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter empName: ");
			String empName = sc.nextLine();
			System.out.print("Enter empAddress: ");
			String empAddress = sc.nextLine();
			System.out.print("Enter empMailId: ");
			String empMailId = sc.nextLine();
			System.out.print("Enter empPhNo: ");
			long empPhNo = sc.nextLong();
			sc.nextLine();
			System.out.print("Enter empResume Text file path: ");
			String path = sc.nextLine();
			File f = new File(path);

			if (f.exists()) {
				FileInputStream fis = new FileInputStream(path);
				insertQuery.setInt(1, empId);
				insertQuery.setString(2, empName);
				insertQuery.setString(3, empAddress);
				insertQuery.setString(4, empMailId);
				insertQuery.setLong(5, empPhNo);
				insertQuery.setBinaryStream(6, fis, f.length());
				int k = insertQuery.executeUpdate();

				if (k > 0) {
					System.out.println("Image Stored Successfully...");
				}
				fis.close();
			} else {
				System.out.println("Invalid fpath or fName..! ");
			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

/**
 * 
 * EMPID EMPNAME  EMPADDRESS  EMPMAILID      EMPPHNO     EMPRESUME
 * ----- -------  ----------- ------------- ----------- ------------
 * 246   Lalit    Hyderabad   lp@gmail.com  7038898338  2A2A2A2A2A526573756D652A2A2A2A2A2A0D0A4E616D650D0A6C616C69740D0A0D0A6C2C6B6A736461660D0A73
 * 
 */

/*
 * OUTPUT
 * 
 * Enter empId: 246 Enter empName: Lalit Enter empAddress: Hyderabad Enter
 * empMailId: lp@gmail.com Enter empPhNo: 7038898338 Enter empResume Text file
 * path: D:\@Java Placement Course\Advance
 * Java\Code-with-AdvanceJava\Code-with-AdvanceJava\PracticePrograms\
 * JDBC_lab_tasks\src\JDBC_tasks_day2\task_2\mfile\DummyResume.txt Image Stored
 * Successfully...
 * 
 * 
 */
