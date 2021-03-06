package com.db.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {

	public static void main(String[] args)  {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = DriverManager.getConnection("Data base URL", "user", "pass");
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs = stmt.executeQuery(
			 "Select * From employees");
				ResultSetMetaData rsmd = rs.getMetaData();
			
				int columnsNumber = rsmd.getColumnCount();                     

				// Iterate through the data in the result set and display it. 
				ArrayList<String> columnValue = new ArrayList<String>();
				while (rs.next()) {
				//Print one row          
				for(int i = 1 ; i <= columnsNumber; i++){

				      System.out.print(rs.getString(i) + " "); //Print one element of a row
				      columnValue.add(rs.getString(i) );
				}

				  System.out.println();//Move to the next line to print the next row.           

				    }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// step5 close the connection object
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		
	}

}

/**
 * ArrayList<String> salary = new ArrayList<String>();
 * 
 * while(rs.next()) { // System.out.println(rs.getInt(1)+" "+rs.getString(2)+"
 * "+rs.getString(3) +" "+rs.getString(4)+" "+rs.getString(5));
 * 
 * 
 * salary.add( rs.getString("SALARY")); }
 * 
 * for(String rank:salary) { System.out.println("Rank 9th salary is ::"+rank);
 * if (rank.equalsIgnoreCase("11000")) { System.out.println("Test is Passed");
 * 
 * } else { System.out.println("Test Failed");
 * 
 * } break; }
 */
