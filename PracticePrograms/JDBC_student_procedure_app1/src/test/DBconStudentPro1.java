package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.util.Scanner;

public class DBconStudentPro1 {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			CallableStatement cs1 = con
					.prepareCall("{call InsertStudentData72(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			ParameterMetaData pmd = cs1.getParameterMetaData();
			System.out.println("Para Count: " + pmd.getParameterCount());

			System.out.print("Enter rollno: ");
			int rollno = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Name: ");
			String name = sc.nextLine();
			System.out.print("Enter Branch: ");
			String branch = sc.nextLine();
			System.out.print("Enter House No: ");
			int hno = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Street name: ");
			String sname = sc.nextLine();
			System.out.print("Enter City: ");
			String city = sc.nextLine();
			System.out.print("Enter State: ");
			String state = sc.nextLine();
			System.out.print("Enter Pincode: ");
			long pincode = sc.nextLong();
			sc.nextLine();
			System.out.print("Enter MailId: ");
			String mailId = sc.nextLine();
			System.out.print("Enter PhoneNo: ");
			long phno = sc.nextLong();
			System.out.print("Enter Marks(telgu):");
			int telgu = sc.nextInt();
			System.out.print("Enter Marks(hindi):");
			int hindi = sc.nextInt();
			System.out.print("Enter Marks(english):");
			int english = sc.nextInt();
			System.out.print("Enter Marks(math):");
			int math = sc.nextInt();
			System.out.print("Enter Marks(science):");
			int science = sc.nextInt();
			System.out.print("Enter Marks(social):");
			int social = sc.nextInt();
			
			int totmarks = telgu+hindi+english+math+science+social;
			double per = totmarks/6;
			String grade;
			if(per>90)
			{
			    grade = "A";
			}
			if(per>80 && per<90)
			{
				grade = "B";
			}
			if(per>=35 && per<80)
			{
				 grade = "C";
			}
			else
			{
				grade = "F";
			}
			
			cs1.setInt(1, rollno);
			cs1.setString(2, name);
			cs1.setString(3, branch);
			cs1.setInt(4, hno);
			cs1.setString(5, sname); 
			cs1.setString(6,city); 
			cs1.setString(7,state); 
			cs1.setLong(8,pincode); 
			cs1.setString(9,mailId); 
			cs1.setLong(10, phno); 
			cs1.setInt(11, telgu); 
			cs1.setInt(12, hindi); 
			cs1.setInt(13, english); 
			cs1.setInt(14, math); 
			cs1.setInt(15, science); 
			cs1.setInt(16, social); 
			cs1.setInt(17,totmarks); 
			cs1.setDouble(18,per); 
			cs1.setString(19,grade);
			cs1.execute(); 
			
			System.out.println("Employee added Successfully...");
			con.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/**
 * Assignment: DT Tables: StudentData72(rollno,name,branch) -3
 * StudentAddress72(rollno,hno,sname,city,state,pincode) -6
 * StudentContact72(rollno,mid,phno) - 3 StudentMarks72(rollno,t,h,e,m,s,so) - 7
 * StudentResult72(rollno,totmarks,per,grade) -4 total 23
 * 
 * 
 * 1-> Create table StudentData72(rollno number(3) primary key, name
 * varchar2(12),branch varchar2(10));
 * 
 * 2-> Create table StudentAddress72(rollno number(3) primary key, hno
 * number(3), sname varchar2(20), city varchar2(20), state varchar2(20), pincode
 * number(6));
 * 
 * 3-> Create table StudentContact72(rollno number(3) primary key, mid
 * varchar2(20), phno number(12));
 * 
 * 4-> Create table StudentMarks72(rollno number(3) primary key, telgu
 * number(3),hindi number(3),english number(3),math number(3),science
 * number(3),social number(3));
 * 
 * 5-> Create table StudentResult72(rollno number(3) primary key, totmarks
 * number(5), per number(5,2), grade varchar2(1));
 * 
 * 
 * 
 * Application-1: Step-1 : Construct Procedure to insert student deatails to DB
 * Tables
 * 
 * SQL> create or replace procedure InsertStudentData72 
 * (rollno number,name varchar2, branch varchar2, hno number, sname varchar2, city varchar2, state varchar2, pincode number,mid varchar2, phno number, telgu number,hindi number,english number,math number,science number,social number,totmarks number, per number, grade varchar2 ) is 
 * begin 
 * INSERT INTO StudentData72 values(rollno,name,branch);  
 * INSERT INTO StudentAddress72 values(rollno,hno,sname,city,state,pincode); 
 * INSERT INTO StudentContact72 values(rollno,mid,phno); 
 * INSERT INTO StudentMarks72 values(rollno,telgu, hindi,english,math,science,social); 
 * INSERT INTO StudentResult72 values(rollno,totmarks,per,grade); 
 * end;  
 * /
 * 
 * Procedure created.
 * 
 * Step-2 : Construct JDBC Application to execute Procedure
 * 
 select * from StudentData72;
 select * from StudentAddress72;
 select * from StudentContact72;
 select * from StudentMarks72;
 select * from StudentResult72;
 * 
 */
