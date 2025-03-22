/**
 * MetaData?
	The data which is holding information about other data is known as MetaData.
	JDBC will provide the following MetaData components:
         		1. DatabaseMetaData
         		2. ParameterMetaData
         		3. ResultSetMetaData
Examples:
*/
package test;

import java.util.*;
import java.sql.*;

public class DBcon16 {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			System.out.println("**** DatabaseMetaData ****");
			DatabaseMetaData dmd = con.getMetaData();
			System.out.println("Driver Name: " + dmd.getDriverName());
			System.out.println("Driver Version: " + dmd.getDriverMajorVersion());

			System.out.println("\n**** ParameterMetaData *****");
			PreparedStatement ps = con.prepareStatement("update Customer72 set city=? where phno=?");
			ParameterMetaData pmd = ps.getParameterMetaData();
			System.out.println("Para Count: " + pmd.getParameterCount());

			System.out.println("\n***** ResultSet Metadata *****");
			PreparedStatement ps2 = con.prepareStatement("select phno, city, mid from Customer72");
			ResultSet rs = ps2.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getLong(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));

			} // end of loop

			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("Col-Count: " + rsmd.getColumnCount());
			System.out.println("2nd Col-Name: " + rsmd.getColumnName(2));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

/*OUTPUT

**** DatabaseMetaData ****
Driver Name: Oracle JDBC driver
Driver Version: 21

**** ParameterMetaData *****
Para Count: 2

***** ResultSet Metadata *****
1212121234	SHD	s@gmail.com
2323231234	SHl	d@gmail.com
1414141234	NDB	m@gmail.com
4545451234	SHD	r@gmail.com]
7878781234	MI	r@gmail.com
Col-Count: 3
2nd Col-Name: CITY

*/
