package Tester;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * A Class that makes the connection to the Database, hiding Username and Password
 * @author Chidalu Agbalwa
 *
 */
public class DB {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacymanagementsystem", DBInfo.getUsername(), DBInfo.getPassword());
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
