/**Assignment:
DB Tables:
      StudentData72(rollno,name,branch)
      StudentAddress72(rollno,hno,sname,city,state,pincode)
      StudentContact72(rollno,mid,phno)
      StudentMarks72(rollno,t,h,e,m,s,so)
      StudentResult72(rollno,totmarks,per,grade)

Application-2 :
     Step-1 : Construct Procedure to retrieve student details based on rollNo
     Step-2 : Construct JDBC Application to execute Procedure
*/

package test;

import java.util.*;
import java.sql.*;

public class DBconStudentPro2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try (sc;) {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "lalit");

			CallableStatement cs = con.prepareCall("{call InsertStudentData72(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ParameterMetaData pmd = cs.getParameterMetaData();
			System.out.println("Parameter Count:" + pmd.getParameterCount());

			System.out.print("Enter Student rollNo:");
			int rollno = sc.nextInt();

			cs.setInt(1, rollno);

			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.INTEGER); // houseno
			cs.registerOutParameter(5, Types.VARCHAR); // street name
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.BIGINT); //
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.registerOutParameter(10, Types.BIGINT); // phono
			cs.registerOutParameter(11, Types.INTEGER);
			cs.registerOutParameter(12, Types.INTEGER);
			cs.registerOutParameter(13, Types.INTEGER);
			cs.registerOutParameter(14, Types.INTEGER);
			cs.registerOutParameter(15, Types.INTEGER);
			cs.registerOutParameter(16, Types.INTEGER);
			cs.registerOutParameter(17, Types.INTEGER);
			cs.registerOutParameter(18, Types.FLOAT);
			cs.registerOutParameter(19, Types.VARCHAR);

			cs.execute();

			System.out.println("**** Details ****");

			System.out.println("rollno: " + rollno);
			System.out.println("Name: " + cs.getString(2));
			System.out.println("Branch: " + cs.getString(3));
			System.out.println("House No: " + cs.getInt(4));
			System.out.println("Street name: " + cs.getString(5));
			System.out.println("City: " + cs.getString(6));
			System.out.println("State: " + cs.getString(7));
			System.out.println("Pincode: " + cs.getString(8));
			System.out.println("MailId: " + cs.getString(9));
			System.out.println("PhoneNo: " + cs.getLong(10));
			System.out.println("Marks(telgu):" + cs.getInt(11));
			System.out.println("Marks(hindi):" + cs.getInt(12));
			System.out.println("Marks(english):" + cs.getInt(13));
			System.out.println("Marks(math):" + cs.getInt(14));
			System.out.println("Marks(science):" + cs.getInt(15));
			System.out.println("Marks(social):" + cs.getInt(16));
			System.out.println("Total Marks: " + cs.getInt(17));
			System.out.println("Percentage: " + cs.getDouble(18));
			System.out.println("Grade: " + cs.getString(19));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

/**
 * SQL> CREATE OR REPLACE PROCEDURE InsertStudentData72 ( 1 rno NUMBER, n OUT
 * VARCHAR2, br OUT VARCHAR2, hn OUT NUMBER, sn OUT VARCHAR2, cty OUT VARCHAR2,
 * ste OUT VARCHAR2, pin OUT NUMBER, id OUT VARCHAR2, ph OUT NUMBER, t OUT
 * NUMBER, h OUT NUMBER, eng OUT NUMBER, m OUT NUMBER, sci OUT NUMBER, so OUT
 * NUMBER, tot OUT NUMBER, pe OUT NUMBER, gr OUT VARCHAR2 ) IS BEGIN -- Fetch
 * Name and Branch SELECT name, branch INTO n, br FROM StudentData72 WHERE
 * rollno = rno;
 *
 * -- Fetch Address Details SELECT hno, sname, city, state, pincode INTO hn, sn,
 * cty, ste, pin FROM StudentAddress72 WHERE rollno = rno;
 *
 * -- Fetch Contact Details SELECT mid, phno INTO id, ph FROM StudentContact72
 * WHERE rollno = rno;
 *
 * -- Fetch Marks Details SELECT telgu, hindi, english, math, science, social
 * INTO t, h, eng, m, sci, so FROM StudentMarks72 WHERE rollno = rno;
 *
 * -- Fetch Results SELECT totmarks, per, grade INTO tot, pe, gr FROM
 * StudentResult72 WHERE rollno = rno;
 *
 * EXCEPTION WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('No data found for
 * roll number: ' || rno); WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('Error: ' ||
 * SQLERRM); END; /
 *
 * Step-1 : Construct Procedure to retrieve student details based on rollNo
 *
 * -> Create or replace procedure retrieveStudentData72 ()
 *
 *
 */
