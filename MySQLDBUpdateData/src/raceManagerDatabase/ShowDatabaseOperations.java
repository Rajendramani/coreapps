package raceManagerDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import raceManagerObjects.*;
import ServerInterop.DBManager;
import ServerInterop.MySQLOperations;
import ServerInterop.MySQLServerConnector;
import ServerInterop.ServerConnector;

public class ShowDatabaseOperations 
{
	private static final String CONFIG_PATH = "C:\\JavaProjects\\MySQLDBUpdateData"
				+ "\\src\\ServerInterop\\dataconfig.json";
	private static final String DB_KEY = "racemanagerdb";
	
	private static final String RUNNER = "Runner";
	private static final String BIKER = "Biker";
	private static final String SWIMMER = "Swimmer";
	
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
			String userEntry;
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
						userEntry = input.nextLine();
						verifyTableExists(dbm, userEntry);
						break;
					case 3:
						//create a table
						System.out.println("Enter 1 to create the Athlete Table, 2 to create the Athlete Type Table:");
						userEntry = input.nextLine();
						if (userEntry.equals("1"))
						{
							createTable(dbm, RaceManagerOperations.ATHLETE_TABLE_NAME
									, RaceManagerOperations.CreateAthleteTableDetails());
						}
						else if (userEntry.equals("2"))
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
						userEntry = input.nextLine();
						if (userEntry.equals("1"))
						{
							deleteTable(dbm, RaceManagerOperations.ATHLETE_TABLE_NAME);
						}
						else if (userEntry.equals("2"))
						{
							deleteTable(dbm, RaceManagerOperations.ATHLETE_TYPE_TABLE_NAME);
						}
						else
						{
							System.out.println("Invalid choice");
						}
						break;
					case 5:
						//insert athlete types
						insertAthleteTypes(dbm);
						System.out.println("Inserted Athlete Types!");
						break;
					case 6:
						//insert a new athlete.
						System.out.println("Please enter 1 to insert a new Runner, "
								+ "2 to insert a new Biker, or 3 to insert a new Swimmer. ");
						userEntry = input.nextLine();
						Athlete a = null;
						if (userEntry.equals("1"))
						{
							a = new Runner();
						}
						else if (userEntry.equals("2"))
						{
							a = new Biker();
						}
						else if (userEntry.equals("3"))
						{
							a = new Swimmer();
						}
						buildAthlete(a);
						insertAthlete(a, dbm);
						System.out.println("Inserted the athlete: " + a.getName());
						break;
					case 7:
						printAthletes(dbm);
						break;
					case 8:
						printAthletes(dbm);
						System.out.println("Please enter the racerID to update: ");
						userEntry = input.nextLine(); 
						updateAthlete(dbm, Integer.parseInt(userEntry));
						System.out.println("Updated the Athlete Data!");
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
				System.out.println("Enter 5 to insert the athlete types: ");
				System.out.println("Enter 6 to insert a new athlete: ");
				System.out.println("Enter 7 to list athletes: ");
				System.out.println("Enter 8 to update an athlete: ");
				choice = Integer.parseInt(input.nextLine());
				if (choice >= 1 && choice <= 8)
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

	/**
	 * Build an athlete from user input.
	 * @param a the athlete to set up for insert
	 * NOTE: There is no validation in the interest of time and simplicity.
	 *       Therefore be careful when entering values
	 */
	public static void buildAthlete(Athlete a)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the athlete's name:");
		a.setName(input.nextLine());
		System.out.println("Please enter the athlete's age:");
		a.setAge(Integer.parseInt(input.nextLine()));
		System.out.println("Is the athlete injured [y/n]?");
		String isInjured = input.nextLine();
		boolean injured = false;
		if (isInjured.toLowerCase().charAt(0) == 'y')
		{
			injured = true;
		}
		a.setIsInjured(injured);
		if (a instanceof Runner)
		{
			System.out.println("Please enter the brand of shoes:");
			((Runner) a).setShoeBrand(input.nextLine());
		}
		else if (a instanceof Biker)
		{
			System.out.println("Does the biker wear clips [y/n]?");
			String clips = input.nextLine();
			if (clips.toLowerCase().charAt(0) == 'y')
			{
				((Biker)a).setUsingClips(true);
			}
		}
	}
	
	/**
	 * Insert an athlete
	 * @param a the athlete to insert
	 * @return true on success
	 * @throws SQLException 
	 * Note: Records in the DB must contain "Runner, Biker, Swimmer" to work as expected
	 */
	public static void insertAthlete(Athlete a, DBManager dbm) throws SQLException
	{
		//get the types to get the id
		HashMap<String, Integer> athleteTypes = getAthleteTypes(dbm);
		int typeID = 0;
		
		//type string has to match whatever is in the database
		if (a instanceof Runner)
		{
			typeID = athleteTypes.get(RUNNER);
		}
		else if (a instanceof Biker)
		{
			typeID = athleteTypes.get(BIKER);
		}
		else if (a instanceof Swimmer)
		{
			typeID = athleteTypes.get(SWIMMER);
		}
		
		//get the insert query string
		String insertAthlete = RaceManagerOperations.InsertAthleteString(a, typeID);
		
		//insert the athlete
		dbm.ExecuteNonQuery(insertAthlete);
	}
	
	/**
	 * List the athletes.
	 * @param dbm the database manager
	 * @throws SQLException if it happens
	 */
	public static void printAthletes(DBManager dbm) throws SQLException
	{
		System.out.println("********************************");
		System.out.println("ATHLETES: ");
		Connection cn = dbm.GetConnection();
		PreparedStatement pst = cn.prepareStatement(RaceManagerOperations.GetAthleteData());
		ResultSet rs = pst.executeQuery();
		while (rs.next())
		{
			System.out.println("RacerID: " + rs.getInt("RacerID") + " Name: " + rs.getString("Name") + " Age: " + rs.getInt("Age"));
		}
		rs.close();
		System.out.println("********************************");
	}
	
	/**
	 * Get the athlete types.
	 * @param dbm The dbmanager
	 * @return list of types
	 * @throws SQLException if it happens
	 */
	public static HashMap<String, Integer> getAthleteTypes(DBManager dbm) throws SQLException
	{
		Connection cn = dbm.GetConnection();
		PreparedStatement pst = cn.prepareStatement(RaceManagerOperations.GetAthleteTypeData());
		ResultSet rs = pst.executeQuery();
		HashMap<String, Integer> types = new HashMap<String, Integer>();
		while (rs.next())
		{
			types.put(rs.getString("AthleteType"), rs.getInt("ID"));
		}
		rs.close();
		return types;
	}

	/**
	 * Make sure the athlete types are inserted
	 * @param dbm the dbmanager to insert types
	 * @throws SQLException if it happens
	 */
	public static void insertAthleteTypes(DBManager dbm) throws SQLException
	{
		HashMap<String, Integer> types = getAthleteTypes(dbm);
		if (types.size() == 0)
		{
			dbm.ExecuteNonQuery(RaceManagerOperations.InsertAthleteTypeString(RUNNER));
			dbm.ExecuteNonQuery(RaceManagerOperations.InsertAthleteTypeString(BIKER));
			dbm.ExecuteNonQuery(RaceManagerOperations.InsertAthleteTypeString(SWIMMER));
		}
	}
	
	/**
	 * Update an athlete
	 * @param dbm the dbmanager to update with
	 * @throws SQLException if it happens
	 */
	public static void updateAthlete(DBManager dbm, int racerID) throws SQLException
	{
		Athlete a = getAthlete(dbm, racerID);
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 1 to update name, 2 to update age");
		int userChoice = Integer.parseInt(input.nextLine());
		if (userChoice == 1)
		{
			System.out.println("Please enter the new name: ");
			a.setName(input.nextLine());
			
		}
		else if (userChoice == 2)
		{
			System.out.println("Please enter the new age: ");
			a.setAge(Integer.parseInt(input.nextLine()));
		}
		String updateSyntax = RaceManagerOperations.UpdateAthleteString(a);
		dbm.ExecuteNonQuery(updateSyntax);
		return;
	}
	
	/**
	 * Get an athlete by id
	 * @param dbm the manager
	 * @param racerID the id to find
	 * @return the athlete to match the id 
	 * @throws SQLException if it happens
	 */
	public static Athlete getAthlete(DBManager dbm, int racerID) throws SQLException
	{
		String query = RaceManagerOperations.GetAthleteData();
		Connection cn = dbm.GetConnection();
		PreparedStatement pst = cn.prepareStatement(RaceManagerOperations.GetAthleteData());
		ResultSet rs = pst.executeQuery();
		Athlete a = null;
		while (rs.next())
		{
			int nextID = rs.getInt("RacerID");
			
			if (nextID == racerID)
			{
				//determine type
				int type = rs.getInt("TypeId");
				//use the typeid to get the athlete type
				HashMap athleteTypes = getAthleteTypes(dbm);
				if ((int)athleteTypes.get(RUNNER) == type)
				{
					a = new Runner();
				}
				else if ((int)athleteTypes.get(BIKER) == type)
				{
					a = new Biker();
				}
				else if ((int)athleteTypes.get(SWIMMER) == type)
				{
					a = new Swimmer();
				}
				
				//get Athlete Details
				a.setRacerId(nextID);
				a.setName(rs.getString("Name"));
				a.setAge(rs.getInt("Age"));
				a.setIsInjured(rs.getBoolean("IsInjured"));
				if (a instanceof Runner)
				{
					((Runner)a).setShoeBrand(rs.getString("Shoes"));
				}
				else if (a instanceof Biker)
				{
					((Biker)a).setUsingClips(rs.getBoolean("UsesClips"));
				}
			}
		}
		rs.close();
		return a;
	}
}
