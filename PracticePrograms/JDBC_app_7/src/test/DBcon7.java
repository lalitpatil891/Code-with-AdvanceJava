/**
 *  Construct JDBC Application to perform the following operations on Choice based on AccNo
 * 		1.UpdateBankCustomer
 * 		2.DeleteBankCustomer
 */

package test;

import java.util.*;
import java.sql.*;

public class DBcon7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try (sc;) {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			PreparedStatement updateQuery = con
					.prepareStatement("update BankCustomer72 set BALANCE=?, ACCTYPE=? where ACCNO=?");

			PreparedStatement deleteQuery = con.prepareStatement("delete BankCustomer72 where accno = ?");

			PreparedStatement verify = con.prepareStatement("select * from BankCustomer72 where accno = ?");

			while (true) {
				System.out.println("=====================================");
				System.out.print("Enter customer account Number: ");
				long accno = sc.nextLong();

				verify.setLong(1, accno);
				ResultSet check = verify.executeQuery();

				if (check.next()) {
					System.out.println("-----------------------------");
					System.out.println("**** Choose Option ****");
					System.out.println(" 1. UpdateBankCustomer \n 2. DeleteBankCustomer \n 3. Exit");
					System.out.println("-----------------------------");

					System.out.print("Enter your Choice:");
					int choice = sc.nextInt();

					switch (choice) {
					// UpdateBankCustomer ----------------------------------------------
					case 1:
						System.out.println("---- Update Operation ----");
						System.out.println("--------------------------");
						System.out.println("Existing balance: " + check.getFloat(4));

						System.out.print("Enter Customer Balance: ");
						float bal = sc.nextFloat();

						sc.nextLine();
						System.out.print("Enter Account Type: ");
						String type = sc.nextLine();

						updateQuery.setFloat(1, bal);
						updateQuery.setString(2, type);
						updateQuery.setLong(3, accno);

						int k = updateQuery.executeUpdate();

						if (k > 0) {
							System.out.println("Data updated Successfully.");

						} else {
							System.err.println("Update failed! Invalid Account number");
						}

						break;

					// DeleteBankCustomer -------------------------------------------------
					case 2:

						System.out.println("Customer Name: " + check.getString(3));

						System.out.print("Are you sure you want to delete this product? (yes/no): ");
						sc.nextLine(); // Clear buffer
						String confirm = sc.nextLine().trim().toLowerCase();

						if (confirm.equals("yes") || confirm.equals("y")) {

							deleteQuery.setLong(1, accno);
							int kk = deleteQuery.executeUpdate();

							if (kk > 0) {
								System.out.println("Product deleted successfully!");
							} else {
								System.err.println("Deletion failed! Please try again.");
							}
						} else {
							System.out.println("Deletion canceled. Returning to menu...");
						}

						break;

					// Exit
					case 3:
						break;

					default:
						System.err.println("Invalid Option.. Please Enter valid Option!");
						break;
					}

				} else {
					System.err.println("No customer found with the given code. Update operation aborted.");
				}

			}

		} catch (SQLSyntaxErrorException sql) {
			System.err.println("Error:" + sql.getMessage() + "\t ErrorCode:" + sql.getErrorCode());
		} catch (SQLException sqle) {
			System.err.println("Error:" + sqle.getMessage() + "\t ErrorCode:" + sqle.getErrorCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * SQL> select * from BankCustomer72 ;
 *
 * 1 2 3 4 5 ACCNO CID CNAME BALANCE ACCTYPE
 *
 * ======================================================================== SQL>
 * desc BankCustomer72; Name Null? Type
 * ----------------------------------------- --------
 * ---------------------------- ACCNO NOT NULL NUMBER(15) CID VARCHAR2(15) CNAME
 * VARCHAR2(15) BALANCE NUMBER(10,2) ACCTYPE VARCHAR2(15)
 *
 */
