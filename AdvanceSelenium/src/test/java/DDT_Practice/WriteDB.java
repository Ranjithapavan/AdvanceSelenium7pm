package DDT_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class WriteDB {

	public static void main(String[] args) throws SQLException {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ninza_Selenium", "root", "Ridit@202117");
		Statement stmt = conn.createStatement();
		int result = stmt.executeUpdate("update Ninza_crm set uname='admin' where browser='firefox'");
		System.out.println(result);
		
		if (result!=0)
		{
		System.out.println("data stored successfully");	
		}
		else
		{
		System.out.println("operation failed");
		}
		conn.close();
	}
}


