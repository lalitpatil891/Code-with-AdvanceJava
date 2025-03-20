/** 
 * Construct Application to demonstrate Procedure
 * Step-1 : Create the following tables
 * 	  EmpData72(eid,ename,edesg);
 *    EmpAddress72(eid,hno,sname,city,state,pincode);
 *    EmpContact72(eid,mid,phno);
 *    EmpSalary72(eid,bsal,hra,da,totsal);
 */
package test;

import java.util.*;
import java.sql.*;
import java.io.*;

public class DBcon11 {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			CallableStatement cs = con.prepareCall("{call InsertEmployee72(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			System.out.println("Enter the Emp-Id:");
			String eId = sc.nextLine();
			System.out.println("Enter the Emp-Name:");
			String eName = sc.nextLine();
			System.out.println("Enter the Emp-Desg:");
			String eDesg = sc.nextLine();
			System.out.println("Enter the Emp-HNo:");
			String hNo = sc.nextLine();
			System.out.println("Enter the Emp-SName:");
			String sName = sc.nextLine();
			System.out.println("Enter the Emp-City:");
			String city = sc.nextLine();
			System.out.println("Enter the Emp-State:");
			String state = sc.nextLine();
			System.out.println("Enter the Emp-PinCode:");
			int pinCode = Integer.parseInt(sc.nextLine());
			System.out.println("Enter the Emp-MailId:");
			String mId = sc.nextLine();
			System.out.println("Enter the Emp-PhNo:");
			long phNo = sc.nextLong();
			System.out.println("Enter the Emp-bSal:");
			int bSal = sc.nextInt();
			float hra = 0.93F * bSal;
			float da = 0.61F * bSal;
			float totSal = bSal + hra + da;

			cs.setString(1, eId);
			cs.setString(2, eName);
			cs.setString(3, eDesg);
			cs.setString(4, hNo);
			cs.setString(5, sName);
			cs.setString(6, city);
			cs.setString(7, state);
			cs.setInt(8, pinCode);
			cs.setString(9, mId);
			cs.setLong(10, phNo);
			cs.setInt(11, bSal);
			cs.setFloat(12, hra);
			cs.setFloat(13, da);
			cs.setFloat(14, totSal);
			cs.execute();// Execute Procedure
			System.out.println("Employee added Successsfully....");
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*
 * OUTPUT
 * 
 * Enter the Emp-Id: T121 Enter the Emp-Name: Lalit Enter the Emp-Desg: Manager
 * Enter the Emp-HNo: 23 Enter the Emp-SName: Lalit Patil Enter the Emp-City:
 * HYD Enter the Emp-State: Telangana Enter the Emp-PinCode: 425408 Enter the
 * Emp-MailId: lp@gmail.com Enter the Emp-PhNo: 7038898336 Enter the Emp-bSal:
 * 50000 Employee added Successsfully....
 * 
 */
