package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Databaseconnection {

	@Test
	void databasesetup() throws SQLException
	{
		String host = "localhost";
		String port = "3306";
		
		Connection con = DriverManager.getConnection("jbdc:mysql://" +host+ ":"+port+ "/banking", "root", "Madvan@4050");
	Statement st = con.createStatement();
	
	
	}
}
