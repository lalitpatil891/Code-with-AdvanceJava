/**
 * Construct JDBC Application to perform Update and Delete Operations on Customer table.
 * (Based on Customer PhoneNo)
 */

package test;

import java.util.*;
import java.sql.*;

public class DBcon4 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            // Load JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish Database Connection
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "lalit");

            // Prepare JDBC Statement
            Statement stm = con.createStatement();

            // Get User Input for SQL Query
            System.out.println("Enter the query (INSERT/UPDATE/DELETE/CREATE TABLE):");
            String qry = sc.nextLine().trim().toLowerCase();

            boolean isDDL = qry.startsWith("create");

            if (isDDL) {
                stm.execute(qry);
                System.out.println("DDL Query executed successfully.");
            } else {
                int k = stm.executeUpdate(qry);
                System.out.println("Rows affected: " + k);
                if (k >= 0) {
                    System.out.println("Query executed successfully.");
                }
            }

            // Close Connection
            con.close();
        } catch (SQLSyntaxErrorException sqe) {
            System.out.println("Syntax Error: " + sqe.getMessage());
            System.out.println("Error Code: " + sqe.getErrorCode());
        } catch (SQLIntegrityConstraintViolationException sie) {
            System.out.println("Integrity Violation: " + sie.getMessage());
            System.out.println("Error Code: " + sie.getErrorCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
