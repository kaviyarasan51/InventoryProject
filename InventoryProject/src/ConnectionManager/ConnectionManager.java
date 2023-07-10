package ConnectionManager;

import java.sql.*;

public class ConnectionManager 
{
	//Create connection object
	Connection con = null;
		
	public Connection establishConnection() throws ClassNotFoundException, SQLException
	{
		//Load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establish connection
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventoryProject","root","Realme@66381062628");
		
		return con;
	}
	
	public void closeConnection() throws SQLException
	{
		con.close();
	}
}
