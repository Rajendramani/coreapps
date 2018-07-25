package raceManagerDatabase;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ServerInterop.DBManager;
import ServerInterop.MySQLOperations;
import ServerInterop.MySQLServerConnector;
import ServerInterop.ServerConnector;

public class ShowDatabaseOperations 
{
	private static final String CONFIG_PATH = "C:\\JavaProjects\\MySQLDBTableOperations"
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
			
			Scanner input = new Scanner(System.in);
			String tableName;
			boolean allDone = false;
			while (!allDone)
			{
				int option = printMenu();
				switch(option)
				{
					case 1:
						listAllTables(dbm);
						break;
					case 2:
						//verify a table exists
						System.out.println("Please enter the name of the table for which to verify existence: ");
						tableName = input.nextLine();
						verifyTableExists(dbm, tableName);
						break;
					case 3:
						//create a table
						System.out.println("Enter 1 to create the Athlete Table, 2 to create the Athlete Type Table:");
						tableName = input.nextLine();
						if (tableName.equals("1"))
						{
							createTable(dbm, RaceManagerOperations.ATHLETE_TABLE_NAME
									, RaceManagerOperations.CreateAthleteTableDetails());
						}
						else if (tableName.equals("2"))
						{
							createTable(dbm, RaceManagerOperations.ATHLETE_TYPE_TABLE_NAME
									, RaceManagerOperations.CreateAthleteTypeTableDetails());
						}
						else
						{
							System.out.println("Invalid Choice");
						}
						break;
					case 4:
						//delete a table
						System.out.println("Please enter 1 to delete the Athlete table, 2 to delete the Athlete Type table. ");
						tableName = input.nextLine();
						if (tableName.equals("1"))
						{
							deleteTable(dbm, RaceManagerOperations.ATHLETE_TABLE_NAME);
						}
						else if (tableName.equals("2"))
						{
							deleteTable(dbm, RaceManagerOperations.ATHLETE_TYPE_TABLE_NAME);
						}
						else
						{
							System.out.println("Invalid choice");
						}
						
						break;
					default:
						break;
				}
				System.out.println("Would you like to do another operation [y/n]?");
				String choice = input.nextLine();
				if (choice.toLowerCase().charAt(0) == 'n')
				{
					allDone = true;
				}
			}
			
			//close connection
			dbm.closeConnection(false);
		} 
		catch (Exception e) 
		{
			// TODO need better logging...
			e.printStackTrace();
		}
		System.out.println("Thank you for using the database manager!");
	}
	
	/**
	 * Give the user some choices
	 * @return choice based on user pick
	 */
	public static int printMenu()
	{
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		int choice = -1;
		while (!valid)
		{
			try
			{
				System.out.println("Please chose a valid operation: ");
				System.out.println("Enter 1 to list all tables: ");
				System.out.println("Enter 2 to verify a specific table exists: ");
				System.out.println("Enter 3 to add a new table: ");
				System.out.println("Enter 4 to delete a table: ");
				choice = Integer.parseInt(input.nextLine());
				if (choice >= 1 && choice <= 4)
				{
					valid = true;
				}
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return choice;
	}
	
	/**
	 * List all tables
	 * @param dbm dbMananger to connect/execute
	 * @throws SQLException if one happens
	 */
	public static void listAllTables(DBManager dbm) throws SQLException
	{
		//ResultSet for table schema -- prove we connected
		ResultSet rs = dbm.ExecuteRSGetTableSchema();
		while (rs.next())
		{
			System.out.println("Table Found: " + rs.getString("TABLE_NAME"));
		}
		rs.close();
	}
	
	/**
	 * Verify a table exists
	 * @param dbm
	 * @throws SQLException
	 */
	public static void verifyTableExists(DBManager dbm, String tableName) throws SQLException
	{
		String query = MySQLOperations.TABLE_EXISTS_QUERY(dbm.GetDBName(), tableName);
		//get the value
		boolean exists = dbm.ExecuteTableExists(query, "ExistsCount");
		if (exists)
		{
			System.out.println("The table: " + tableName + " exists!");
		}
		else
		{
			System.out.println("The table: " + tableName + " does not exist!");
		}
	}
	
	/**
	 * Delete a table
	 * @param dbm
	 * @throws SQLException
	 */
	public static void deleteTable(DBManager dbm, String tableName) throws SQLException
	{
		String query = MySQLOperations.DELETE_TABLE_QUERY(tableName);
		//drop it
		dbm.ExecuteNonQuery(query);
		System.out.println("Dropped Table: " + tableName);
	}
	
	/**
	 * Create a table
	 * @param dbm
	 * @throws SQLException
	 */
	public static void createTable(DBManager dbm, String tableName, String details) throws SQLException
	{
		String query = MySQLOperations.CREATE_TABLE_QUERY(tableName, details);
		//create it
		dbm.ExecuteNonQuery(query);
		System.out.println("Created table: " + tableName);
	}
}
