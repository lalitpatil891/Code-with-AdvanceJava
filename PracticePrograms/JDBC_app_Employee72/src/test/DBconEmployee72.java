/**DB Table: Employee72(eid,ename,edesg,bsal,hra,da,totsal)
               Primary Key : eid
              
Construct JDBC Application to perform the following Operations based on Choice:
     1.AddEmployee
     2.ViewAllEmployees
     3.ViewEmployeeByCode
     4.UpdateEmployeeById(bSal)  
     5.DeleteEmployeeById
     6.Exit
Calcutions:
   hra = 91% of bSal
   da  = 63% of bSal
   totSal = bSal+hra+da
Exception: Min bSal must be 12000/-,else raise the exception

*/
package test;

import java.util.*;
import java.sql.*;

public class DBconEmployee72 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc;) {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			PreparedStatement insertQuery = con.prepareStatement("Insert into Employee72 values(?,?,?,?,?,?,?)");

			PreparedStatement viewQuery = con.prepareStatement("Select * from Employee72");

			PreparedStatement viewbyCode = con.prepareStatement("Select * from Employee72 where eid =?");

			PreparedStatement updatebyid = con.prepareStatement("update Employee72 set bsal=? where eid =?");

			PreparedStatement deletebyid = con.prepareStatement("delete from Employee72 where eid =?");

			while (true) {
				System.out.println("\n****Choose Option*******");
				System.out.println(
						" 1.AddEmployee \n 2.ViewAllEmployees \n 3.ViewEmployeeByCode \n 4.UpdateEmployeeById(bSal) \n 5.DeleteEmployeeById \n 6.Exit");

				System.out.print("Enter your Choice: ");
				int choice = sc.nextInt();

				switch (choice) {

//		 1.AddEmployee
				case 1:
					// eid,ename,edesg,bsal,hra,da,totsal

					System.out.print("Enter eid: ");
					int eid = sc.nextInt();
					sc.nextLine();

					System.out.print("Enter ename: ");
					String ename = sc.nextLine();

					System.out.print("Enter edesg: ");
					String edesg = sc.nextLine();

					System.out.print("Enter bsal: ");
					double bsal = sc.nextDouble();

					double hra = 0.91 * bsal;
					double da = 0.63 * bsal;
					double tatsal = hra + da + bsal;

					insertQuery.setInt(1, eid);
					insertQuery.setString(2, ename);
					insertQuery.setString(3, edesg);
					insertQuery.setDouble(4, bsal);
					insertQuery.setDouble(5, hra);
					insertQuery.setDouble(6, da);
					insertQuery.setDouble(7, tatsal);

					int k = insertQuery.executeUpdate();

					if (k > 0) {
						System.out.println("Employee added successfully!");
					}
					break;

//	     2.ViewAllEmployees
				case 2:

					ResultSet rs1 = viewQuery.executeQuery();

					while (rs1.next()) {
						System.out.println(rs1.getInt(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
								+ rs1.getDouble(4) + "\t" + rs1.getDouble(5) + "\t" + rs1.getDouble(6) + "\t"
								+ rs1.getDouble(7));
					}

					break;
//	     3.ViewEmployeeByCode
				case 3:
					System.out.println("Enter Employeeid: ");
					eid = sc.nextInt();
					viewbyCode.setInt(1, eid);

					ResultSet rs2 = viewbyCode.executeQuery();
					int count = 0;
					if (rs2.next()) {
						System.out.println("\n==== Employee Found ====");
						System.out.println("ID: " + rs2.getInt(1));
						System.out.println("Name: " + rs2.getString(2));
						System.out.println("Designation: " + rs2.getString(3));
						System.out.println("Basic Salary: " + rs2.getDouble(4));
						System.out.println("HRA: " + rs2.getDouble(5));
						System.out.println("DA: " + rs2.getDouble(6));
						System.out.println("Total Salary: " + rs2.getDouble(7));
					} else {
						System.out.println("No record found for Employee ID: " + eid);
					}
					break;

//	     4.UpdateEmployeeById(bSal)
				case 4:
					System.out.println("Enter Employeeid: ");
					eid = sc.nextInt();
					viewbyCode.setInt(1, eid);

					ResultSet rs3 = viewbyCode.executeQuery();
					count = 0;
					while (rs3.next()) {
						count++;
					}

					if (count > 0) {

						System.out.print("Enter bsal: ");
						bsal = sc.nextDouble();

						updatebyid.setDouble(1, bsal);
						updatebyid.setInt(2, eid);

						int k1 = updatebyid.executeUpdate();

						if (k1 > 0) {
							System.out.println("Employee salary updated successfully!");
						} else {
							System.out.print("No record found for Employee ID:");
						}
					} else {
						System.out.println("No record found!!!");
					}
					break;

//	     5.DeleteEmployeeById
				case 5:

					System.out.println("Enter Employeeid: ");
					eid = sc.nextInt();
					viewbyCode.setInt(1, eid);

					ResultSet rs4 = viewbyCode.executeQuery();
					int c = 0;
					while (rs4.next()) {
						c++;
					}

					if (c > 0) {
						sc.nextLine();
						System.out.println("RECORD FOUND!!");
						System.out.print("Do you want to delete the record whose Name->" + eid + " Enter [yes/no]");
						String cnf = sc.nextLine().toLowerCase();

						if (cnf.equals("yes") || cnf.equals("y")) {
							deletebyid.setInt(1, eid);

							int k3 = deletebyid.executeUpdate();

							if (k3 > 0) {
								System.out.println("Employee deleted successfully!");
							} else {
								System.err.print("failed!!! Please retry!!");
							}
						} else {
							System.err.println("Delete operation aborted.!");
						}

					} else {
						System.err.println("No record found for Employee ID: " + eid + "");
					}
					break;

//	     6.Exit
				case 6:
					System.err.println("Exiting application. Goodbye!");
					System.exit(0);

				default:
					System.err.println("Invalid choice! Please enter a valid option.");
					break;
				}
			}
		} catch (InputMismatchException ee) {
			System.err.println(" Error: Please enter valid input.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

/** -> Create table Employee72(
               eid number(3),
               ename varchar2(20),
               edesg varchar2(20),
               bsal number(10,2),
               hra number(10),
               da number(10),
               totsal number(10,2),
               primary key(eid));*/
