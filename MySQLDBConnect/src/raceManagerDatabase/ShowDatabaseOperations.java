package raceManagerDatabase;

import java.io.IOException;
import java.sql.ResultSet;

import ServerInterop.DBManager;
import ServerInterop.MySQLServerConnector;
import ServerInterop.ServerConnector;

public class ShowDatabaseOperations 
{
	private static final String CONFIG_PATH = "C:\\JavaProjects\\MySQLDBConnect"
				+ "\\src\\ServerInterop\\dataconfig.json";
	private static final String DB_KEY = "racemanagerdb";
	
	public static void main(String[] args)
	{
		try 
		{
			//create the connector
			ServerConnector sc = new MySQLServerConnector(CONFIG_PATH, DB_KEY);
			
			//create the manager
			DBManager dbm = new DBManager(sc);
			
			//connect
			dbm.openConnection();
			
			//ResultSet for table schema -- prove we connected
			ResultSet rs = dbm.ExecuteRSGetTableSchema();
			while (rs.next())
			{
				System.out.println("Table Found: " + rs.getString("TABLE_NAME"));
			}
			rs.close();
			
			//close connection
			dbm.closeConnection(false);
		} 
		catch (Exception e) 
		{
			// TODO need better logging...
			e.printStackTrace();
		}
		
	}
}
