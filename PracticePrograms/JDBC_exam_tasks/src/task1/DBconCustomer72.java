/** Create table with name:
           Customer7(cid,cname,city,mid,phno)
    Create and execute stored-Procedure to insert details

    Create and execute Stored-function to retrieve phone number based on cid
------
-> Create table Customer7(cid number(3) primary key, cname varchar2(20), city varchar2(10), mid varchar2(10), phno number(10));
------
-> create or replace Procedure storedCustomer7
  (cid number, cname varchar2, city varchar2, mid varchar2, phno number) is 
  begin 
  INSERT INTO Customer7 values(cid, cname, city, mid, phno);  
  end;  
  /
------
create or replace Function retrieveCustomer7
(id number) return number as mob number; 
begin
   select phno into mob from Customer7 where cid=id;
   return mob;
end;
/
------ */

package task1;

import java.util.*;
import java.sql.*;

public class DBconCustomer72 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");
			// Insert Statement
			CallableStatement cs = con.prepareCall("{call storedCustomer7(?,?,?,?,?)}");

			// Retrive Statement
			CallableStatement cs1 = con.prepareCall("{call ?:= retrieveCustomer7(?)}");

			System.out.println("**** Choose Option ****");
			System.out.println("1. Insert Data");
			System.out.println("2. Retrive Data");

			System.out.print("Enter option:");
			int op = sc.nextInt();

			switch (op) {

			case 1:
				System.out.println("*** Strored Data ***");
				System.out.print("Enter cid: ");
				int cid = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter cname: ");
				String cname = sc.nextLine();
				System.out.print("Enter city: ");
				String city = sc.nextLine();
				System.out.print("Enter mid: ");
				String mid = sc.nextLine();
				System.out.print("Enter phno: ");
				long phno = sc.nextLong();

				cs.setInt(1, cid);
				cs.setString(2, cname);
				cs.setString(3, city);
				cs.setString(4, mid);
				cs.setLong(5, phno);
				int x = cs.executeUpdate();
				if (x > 0) {
					System.out.println("Data Inserted Successfully");
				} else {
					System.out.println("something else...");
				}

				break;

			case 2:
				//Retrive Data
				System.out.print("Enter the Emp-id to retrive Phone No: ");
				int id = sc.nextInt();

				cs1.setInt(2, id);
				cs1.registerOutParameter(1, Types.BIGINT);
				cs1.execute();

				System.out.println("**** Details ****");
				System.out.println("Emp-Id: " + id);
				System.out.println("Mobile No: " + cs1.getInt(1));

				con.close();
				break;

			default:
				System.out.println("Invalid Option!!!");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
