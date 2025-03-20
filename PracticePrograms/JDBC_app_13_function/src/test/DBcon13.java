package test;

import java.util.*;
import java.sql.*;

public class DBcon13 {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");
			
			CallableStatement cs = con.prepareCall
	       			("{call ?:=RetrieveTotSal72(?)}");
	       	System.out.println("Enter the Emp-Id to retrieve TotSal:");
	       	String eId = sc.nextLine();
	       	cs.setString(2, eId);
	       	cs.registerOutParameter(1, Types.FLOAT);
	       	cs.execute();

	       	System.out.println("******Details******");
	       	System.out.println("Emp-Id:"+eId);
	       	System.out.println("TotSal:"+cs.getFloat(1));
	       	con.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
