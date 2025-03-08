/** Assignment:
DB Table : Product72(code,name,price,qty)
           Primary key : code

Construct JDBC Application to perform the following operations based on User Choice:
     1.AddProduct
     2.ViewAllProducts
     3.ViewProductByCode  
     4.UpdateProductByCode(price-qty)
     5.DeleteProductByCode
     6.Exit
Note:
  =>repeat the above choice(operations) until we perform exit-operation
*/
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InventoryAppDBcon {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

			Statement stm = con.createStatement();

			while (true) {

				System.out.println("\n*** Choose an Operation ***");
				System.out.println("\t 1. Add Product");
				System.out.println("\t 2. View All Products");
				System.out.println("\t 3. View product by ID");
				System.out.println("\t 4. Update product by code ");
				System.out.println("\t 5. Delete product by code");
				System.out.println("\t 6. Exit");
				System.out.println("--------------------------------------");

				System.out.print("Enter your choice:");
				int op = sc.nextInt();

				switch (op) {
				// Add products
				case 1:
				    try {
				        System.out.print("Enter product code: ");
				        int code = sc.nextInt();
				        
				        // Step 1: Check if the product code already exists
				        String checkQuery = "SELECT * FROM product72 WHERE code = " + code;
				        ResultSet rs = stm.executeQuery(checkQuery);

				        if (rs.next()) { // If product code exists
				            System.err.println("A product with this code already exists! Try a different code.");
				        } else {
				            // Step 2: Proceed with insertion if code is unique
				            sc.nextLine(); // Consume newline
				            System.out.print("Enter Product name: ");
				            String name = sc.nextLine();

				            System.out.print("Enter price: ");
				            double price = sc.nextDouble();

				            System.out.print("Enter quantity: ");
				            int qty = sc.nextInt();

				            // Construct SQL query
				            String insertQuery = "INSERT INTO product72 VALUES(" + code + ", '" + name + "', " + price + ", " + qty + ")";
				            int add = stm.executeUpdate(insertQuery);

				            if (add > 0) {
				                System.out.println("Product inserted successfully!");
				            } else {
				                System.err.println("Insertion failed! Please try again.");
				            }
				        }
				    } catch (InputMismatchException mis) {
				        System.err.println("Invalid input! Please enter a valid number.");
				        sc.next(); // Clear the incorrect input to avoid infinite loop issues
				    } catch (SQLException e) {
				        System.err.println("Database error: " + e.getMessage());
				    } catch (Exception e) {
				        System.err.println("An unexpected error occurred: " + e.getMessage());
				    }
				    break;


				// view all products
				case 2:
				    try {
				        ResultSet result = stm.executeQuery("SELECT * FROM product72");

				        // Check if the table has any products
				        if (!result.isBeforeFirst()) { // No data available
				            System.out.println("No products found in the inventory.");
				        } else {
				            System.out.println("--------------------------------------------------");
				            System.out.println("Product Code | Product Name    | Price   | Quantity");
				            System.out.println("--------------------------------------------------");

				            while (result.next()) {
				                System.out.printf("%-12d | %-15s | %-8.2f | %-8d %n",
				                        result.getInt(1),
				                        result.getString(2),
				                        result.getDouble(3),
				                        result.getInt(4));
				            }
				            System.out.println("--------------------------------------------------");
				        }
				    } catch (SQLException e) {
				        System.err.println("Database error: " + e.getMessage());
				    } catch (Exception e) {
				        System.err.println("An unexpected error occurred: " + e.getMessage());
				    }
				    break;


				// view product by id
				case 3:
				    try {
				        System.out.print("Enter product code: ");
				        int codee = sc.nextInt();

				        // Query using Statement
				        String query = "SELECT * FROM product72 WHERE code = " + codee;
				        ResultSet rs = stm.executeQuery(query);

				        // Check if the product exists
				        if (!rs.isBeforeFirst()) {  
				            System.out.println("No product found with the given code.");
				        } else {
				            System.out.println("---------------------------------------");
				            System.out.println("Code | Product Name | Price   | Quantity");
				            System.out.println("---------------------------------------");

				            while (rs.next()) {
				                System.out.printf("%-5d | %-12s | %-8.2f | %-8d %n",
				                        rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
				            }
				            System.out.println("---------------------------------------");
				        }
				    } catch (InputMismatchException e) {
				        System.out.println("Invalid input! Please enter a numeric product code.");
				        sc.next(); // Clear incorrect input to prevent infinite loop
				    } catch (SQLException e) {
				        System.out.println("Database error: " + e.getMessage());
				    } catch (Exception e) {
				        System.out.println("An unexpected error occurred: " + e.getMessage());
				    }
				    break;


				case 4:
				    try {
				        System.out.print("Enter product code: ");
				        int codeee = sc.nextInt();

				        // Verify if the product code exists
				        String checkQuery = "SELECT * FROM product72 WHERE code = " + codeee;
				        ResultSet rs = stm.executeQuery(checkQuery);

				        if (!rs.next()) { // If no records found
				            System.err.println("No product found with the given code. Update operation aborted.");
				        } else {
				            // If product exists, proceed with update
				            System.out.print("Enter new price: ");
				            double priceee = sc.nextDouble();

				            System.out.print("Enter new quantity: ");
				            int qtyyy = sc.nextInt();

				            // Constructing the update query safely
				            String updateQuery = "UPDATE product72 SET price = " + priceee + ", qty = " + qtyyy + " WHERE code = " + codeee;
				            int k = stm.executeUpdate(updateQuery);

				            if (k > 0) {
				                System.out.println("Product updated successfully!");
				            } else {
				                System.err.println("Update failed! Please try again.");
				            }
				        }
				    } catch (InputMismatchException e) {
				        System.err.println("Invalid input! Please enter valid numbers.");
				        sc.next(); // Clear incorrect input to prevent infinite loop
				    } catch (SQLException e) {
				        System.err.println("Database error: " + e.getMessage());
				    } catch (Exception e) {
				        System.err.println("An unexpected error occurred: " + e.getMessage());
				    }
				    break;

				// delete product by code
				case 5:
				    try {
				        System.out.print("Enter product code: ");
				        int c = sc.nextInt();

				        // Step 1: Check if the product exists before deleting
				        String checkQuery = "SELECT * FROM product72 WHERE code = " + c;
				        ResultSet rs = stm.executeQuery(checkQuery);

				        if (!rs.next()) { // No product found
				            System.err.println("No product found with the given code. Deletion aborted.");
				        } else {
				            // Step 2: Confirm deletion before executing
				            System.out.print("Are you sure you want to delete this product? (yes/no): ");
				            sc.nextLine(); // Clear buffer
				            String confirm = sc.nextLine().trim().toLowerCase();

				            if (confirm.equals("yes") || confirm.equals("y")) {
				                // Step 3: Perform delete operation
				                String deleteQuery = "DELETE FROM product72 WHERE code = " + c;
				                int kk = stm.executeUpdate(deleteQuery);

				                if (kk > 0) {
				                    System.out.println("Product deleted successfully!");
				                } else {
				                    System.err.println("Deletion failed! Please try again.");
				                }
				            } else {
				                System.out.println("Deletion canceled. Returning to menu...");
				            }
				        }
				    } catch (InputMismatchException e) {
				        System.err.println("Invalid input! Please enter a numeric product code.");
				        sc.next(); // Clear incorrect input to prevent infinite loop
				    } catch (SQLException e) {
				        System.err.println("Database error: " + e.getMessage());
				    } catch (Exception e) {
				        System.err.println("An unexpected error occurred: " + e.getMessage());
				    }
				    break;


				//Exit
				case 6:
				    System.out.print("Are you sure you want to exit? (yes/no): ");
				    sc.nextLine(); // Consume newline character
				    String confirmExit = sc.nextLine().trim().toLowerCase();

				    if (confirmExit.equals("yes") || confirmExit.equals("y")) {
				        System.out.println("Exiting successfully...");
				        System.exit(0);
				    } else {
				        System.out.println("Exit canceled. Returning to menu...");
				    }
				    break;

				default:
				    System.err.println("Invalid choice! Please enter a valid option.");
				    break;

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

