/**
 * Construct Application demonstrating Function in JDBC
 * step-1: Construct Function to retrieve Employee TotSal based in emp-Id
 * create or replace Function RetrieveTotSal72
 * (id varchar2) return number as ts number; 
 * begin
 * 		select totsal into ts from EmpSalary72 where eid=id;
 * return ts;	
 * end;
 * /
 * 
 * step-2: Construct JDBC Application to execute function.
*/

package test;

import java.util.*;
import java.sql.*;

public class DBcon13 {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			CallableStatement cs = con.prepareCall("{call ?:=RetrieveTotSal72(?)}");
			System.out.println("Enter the Emp-Id to retrieve TotSal:");
			String eId = sc.nextLine();
			cs.setString(2, eId);
			cs.registerOutParameter(1, Types.FLOAT);
			cs.execute();

			System.out.println("******Details******");
			System.out.println("Emp-Id:" + eId);
			System.out.println("TotSal:" + cs.getFloat(1));
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}	
