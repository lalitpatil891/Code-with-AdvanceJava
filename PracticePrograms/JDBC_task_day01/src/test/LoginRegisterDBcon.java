package test;

import java.util.*;
import java.sql.*;

public class LoginRegisterDBcon {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			PreparedStatement insertQuery = con.prepareStatement("insert into StudentInfo values(?,?,?,?,?,?,?)");
			PreparedStatement regVerify = con.prepareStatement("Select * from StudentInfo where rollno=? AND fname=?");
			PreparedStatement check = con.prepareStatement("Select * from StudentInfo where rollno=?");
			PreparedStatement updateQuery = con
					.prepareStatement("update StudentInfo set mailid=?, phno=? where rollno=?");

			PreparedStatement case1Query = con.prepareStatement("select * from StudentInfo where percentage> 60");
			PreparedStatement case3Check = con.prepareStatement("Select * from StudentInfo where percentage> 30 AND percentage<60");
			PreparedStatement case3Query = con.prepareStatement("delete from StudentInfo where percentage> 30 AND percentage<60");
			PreparedStatement case4Query = con.prepareStatement("Select * from StudentInfo where percentage> 80");
			PreparedStatement viewAll = con.prepareStatement("Select * from StudentInfo");

			while (true) {

				System.out.println("**** Choose option ****");
				System.out.println(" 1. Register \n 2. Login \n 3. Exit ");
				System.out.print("Enter your Choice:");
				int choice = sc.nextInt();
//--- switch 1 ---
				switch (choice) {
				// Register
				case 1:

					System.out.print("Enter you RollNo:");
					int rollno = sc.nextInt();

					sc.nextLine();
					System.out.print("Enter your name:");
					String name = sc.nextLine().trim();

					System.out.print("Enter your percentage:");
					float per = sc.nextFloat();

					sc.nextLine();
					/*
					 * System.out.print("Enter your first name:"); String fname = sc.nextLine();
					 *
					 * System.out.print("Enter your last name:"); String lname = sc.nextLine();
					 */

					System.out.print("Enter your mailID:");
					String mailid = sc.nextLine();

					System.out.print("Enter your PhoneNumber: ");
					long phno = sc.nextLong();

					String fname = "", lname = "";

					for (int i = 0; i < name.length(); i++) {
						if (name.charAt(i) == ' ') {
							fname = name.substring(0, i);
							lname = name.substring(i + 1);
						}
					}

					if (fname.isEmpty()) {
						fname = name;
						lname = "";
					}

					insertQuery.setInt(1, rollno);
					insertQuery.setString(2, name);
					insertQuery.setFloat(3, per);
					insertQuery.setString(4, fname);
					insertQuery.setString(5, lname);
					insertQuery.setString(6, mailid);
					insertQuery.setLong(7, phno);

					int k = insertQuery.executeUpdate();
					if (k > 0) {
						System.out.println("Student record inserted successfully.");
					} else {
						System.err.println("Insertion failed. Please retry.");
					}

					break;

				// Login
				case 2:

					System.out.print("Enter you RollNo:");
					rollno = sc.nextInt();

					sc.nextLine();
					System.out.print("Enter your name:");
					name = sc.nextLine();

					regVerify.setInt(1, rollno);
					regVerify.setString(2, name);

					ResultSet verify = regVerify.executeQuery();

					if (verify.next()) {
						System.out.println("Login Successful. ");

						while (true) {

							System.out.println("\n**Menu**");
							System.out.println("--------------------------------------------------");
							System.out.println("1. Show Students Whose percentage>60%");
							System.out.println("2. Update Mailid & Phono based on RollNo");
							System.out.println("3. Delete student whose Percentage between 30% to 60%");
							System.out.println("4. Find how many student got more than 80%");
							System.out.println("5. View All records..");
							System.out.println("6. Exit");

							System.out.println("Choose Option:");
							int op = sc.nextInt();
//--- switch 2 ---
							switch (op) {
							//1. Show Students Whose percentage>60%
							case 1:

								ResultSet rs1 = case1Query.executeQuery();

								while (rs1.next()) {
									// ROLLNO NAME PERCENTAGE FNAME LNAME MAILID PHNO
									System.out.println(rs1.getInt(1) + "\t" + rs1.getString(2) + "\t" + rs1.getFloat(3)
											+ "\t" + rs1.getString(4) + "\t" + rs1.getString(5) + "\t"
											+ rs1.getString(6) + "\t" + rs1.getLong(7) + "");

								}

								break;

							//2. Update Mailid & Phono based on RollNo
							case 2:

								System.out.print("Enter you RollNo:");
								rollno = sc.nextInt();
								check.setInt(1, rollno);

								ResultSet present = check.executeQuery();

								if (present.next()) {
									System.out.println("---- Update Opration ----");
									sc.nextLine();
									System.out.print("Enter your mailID:");
									mailid = sc.nextLine();

									System.out.print("Enter your PhoneNumber: ");
									phno = sc.nextLong();

									updateQuery.setString(1, mailid);
									updateQuery.setLong(2, phno);
									updateQuery.setInt(3, rollno);

									int update = updateQuery.executeUpdate();
									if (update > 0) {
										System.out.println("Updated Successfully.");
									} else {
										System.err.println("retry... Update opration aborted.");

									}

								} else {
									System.err.println("User not found..");
								}
								break;

							//3. Delete student whose Percentage between 30% to 60%
							case 3:

								ResultSet delVerify = case3Check.executeQuery();
								int count = 0;
								while (delVerify.next()) {
									count++;
									System.out.println(delVerify.getInt(1) + "\t" + delVerify.getString(2) + "\t"
											+ delVerify.getFloat(3) + "\t" + delVerify.getString(4) + "\t"
											+ delVerify.getString(5) + "\t" + delVerify.getString(6) + "\t"
											+ delVerify.getLong(7) + "");
								}
								System.out.println("\n" + count
										+ " records found. Do you want to delete them? If yes, please enter [yes/y || no/n]: ");
								String cnf = sc.next().toLowerCase();

								if (cnf.equals("yes") || cnf.equals("y")) {
									int x = case3Query.executeUpdate();

									if (x > 0) {
										System.out.println("Record Delated Succefully.");
									} else {
										System.err.println("Opration unsuccessfull");
									}
								} else {
									System.err.println("Delete oparation aborted.");
								}

								break;

							//4. Find how many student got more than 80%
							case 4:

								ResultSet rs2 = case4Query.executeQuery();

								while (rs2.next()) {
									System.out.println(rs2.getInt(1) + "\t" + rs2.getString(2) + "\t" + rs2.getFloat(3)
											+ "\t" + rs2.getString(4) + "\t" + rs2.getString(5) + "\t"
											+ rs2.getString(6) + "\t" + rs2.getLong(7) + "");
								}

								break;

							//5. View All records..
							case 5:

								ResultSet rsAll = viewAll.executeQuery();
								while (rsAll.next()) {
									System.out.println(rsAll.getInt(1) + "\t" + rsAll.getString(2) + "\t"
											+ rsAll.getFloat(3) + "\t" + rsAll.getString(4) + "\t" + rsAll.getString(5)
											+ "\t" + rsAll.getString(6) + "\t" + rsAll.getLong(7) + "");
								}
								break;

							//6. Exit
							case 6:

								 System.out.println("Exiting the program successfully...");
								 System.exit(0);

							}//switch-end
						}//loop-end

					} else {
						System.err.println("User not found..");
					}
					break;

				case 3:
				    System.out.println("Exiting the program successfully...");
				    System.exit(0);

				default:
					System.err.println("Invalid choice!!!");
					break;
				}

			}
		} catch (SQLIntegrityConstraintViolationException ss) {
			System.err.println("The student already registered.");
		} catch (SQLDataException num) {
			System.err.println("Please enter valid data. I think you entered a number of more than 10 digits.");
		} catch (InputMismatchException inp) {
			System.err.println("Invalid input! Please enter a valid number.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

/**
 * SQL> select * from studentinfo;
 *
 * ROLLNO NAME PERCENTAGE FNAME LNAME MAILID PHNO ------- -------------
 * ---------- ------- ------- ------------- --------- 201 Lalit Patil 70.23
 * Lalit Patil lp@gmail.com 7038898336
 */
