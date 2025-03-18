/** 
 * Retrieving Stream(image)from Database Product
 * 
 * */

package test;

import java.util.*;
import java.sql.*;
import java.io.*;


public class DBcon10 {

	public static void main(String[] args) {
			
		try(Scanner sc = new Scanner(System.in))
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");
			
			PreparedStatement ps = con.prepareStatement("Select * from StreamTab72 where id=?");
			
			System.out.print("Enter the User-Id to retrive details:");
			String id = sc.nextLine();
			
			ps.setString(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				Blob b = rs.getBlob(3);
				byte by[] = b.getBytes(1, (int)b.length());
				
				System.out.println("Use-Id: "+rs.getString(1));
				System.out.println("User-Name: "+rs.getString(2));
				System.out.println("Enter the Location(fPath&fName)-destination to store stream:");
				
				String path = sc.nextLine();
				FileOutputStream fos = new FileOutputStream(path);
				fos.write(by);
				System.out.println("Stream stored to specified");
				fos.close();
			}
			else
			{
				System.out.println("Invalid user Id...");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}
