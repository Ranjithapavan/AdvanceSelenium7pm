package Generic_Utility;

import java.awt.Desktop.Action;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.mysql.jdbc.Driver;

public class DataBaseUtilities {
	
	Connection conn;
	
	public void getDBConnection(String url,String name,String password)
	{
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
		   conn = DriverManager.getConnection(url, name, password);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Connection not Established");
		}	
	}
	public void closeDBConnection()
	{
		try {
			conn.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public ResultSet executeResultQuery(String query)
	{
		ResultSet result=null;
		try {
			Statement stmt=conn.createStatement();
			result=stmt.executeQuery(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public int executeNonSelectQuery(String query)
	{
		int result=0;
		try
		{
			Statement stmt=conn.createStatement();
			result=stmt.executeUpdate(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	}
