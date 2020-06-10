package consignment.usedUpcycle.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {

	/*
	 * It would helpful is only one Connection object ever exists. So we can control
	 * the creation of additional objects through the use of the Singleton design
	 * pattern.
	 * 
	 * The intent of the Singleton design pattern is to limit a Class to only having
	 * at most 1 instance at a time.
	 * 
	 * if(object doesnt exist) { create it; } else { dont; }
	 */

	public static Connection conn = null;

	// This will be the only method that you will use to access
	// your connection object.
	public static Connection getConnection() {
		try {
			if (conn == null) {
				// Oracle is stupid. They had a bug. And
				// they made a 'hotfix' for it.
				// JDBC drivers weren't loading properly upon
				// start up.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String endpoint = "database-1.cql7btcmzqrr.us-east-2.rds.amazonaws.com";
				String username = "Admin";
				String password = "password";
				
				conn = DriverManager.getConnection(endpoint, username, password);
				return conn;
				
				//return DriverMananger.getConnection("jdbc:oracle:thin:@ryancodefirst2005.chxttewop8dc.us-east-2.rds.amazonaws.com:1521:ORCL", "ryan", "password");
				
			} else {
				return conn;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	}
	
	//This main method is only for testing purposes
	//It won't be where our actual application runs from.
	public static void main(String[] args) {
		Connection conn1 = getConnection();
		Connection conn2 = getConnection();
		Connection conn3 = getConnection();
		
		System.out.println(conn1);
		System.out.println(conn2);
		System.out.println(conn3);
	}

}
