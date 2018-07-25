package raceManagerSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import raceManagerObjects.*;
import raceManagerSearching.*;
import raceManagerData.*;

/*
import ServerInterop.DBManager;
import ServerInterop.MySQLServerConnector;
import ServerInterop.ServerConnector;
import raceManagerDatabase.RaceManagerOperations;
import raceManagerDatabase.ShowDatabaseOperations;
*/


public class Program 
{
	public static final int menuStars = 65;
	private static InfiniteSkillsRace _isr;
	private static Scanner _input;
	
	/*
	public static void main(String[] args) 
	{
		_input = new Scanner(System.in);
		printWelcome();
		boolean completedEntries = false;
		while (!completedEntries)
		{
			try
			{
				int choice = printMenu();
				switch(choice)
				{
					case 1:
						//create a new race
						_isr = new InfiniteSkillsRace();
						System.out.println("Created a new Race");
						break;
					case 2:
						if (checkRaceCreated())
						{
							//add a racer
							System.out.println("What is the racer name?");
							String n = _input.nextLine();
							System.out.println("What is the racer's age?");
							int a = Integer.parseInt(_input.nextLine());
							System.out.println("What type of racer is this [B, R, S]?");
							String t = _input.nextLine();
							Athlete aRacer = null;
							if (t.equalsIgnoreCase("b"))
							{
								System.out.println("Does this biker use clips [y/n]?");
								String uci = _input.nextLine();
								boolean uc = false;
								if (uci.charAt(0) == 'y' || uci.charAt(0) == 'Y')
								{
									uc = true;
								}
								aRacer = new Biker(n, a, 0, uc);
							}
							else if(t.equalsIgnoreCase("s"))
							{
								aRacer = new Swimmer(n, a, 0);
							}
							else
							{
								//default to runner
								System.out.println("What brand of shoes does this runner use?");
								String shoes = _input.nextLine();
								aRacer = new Runner(n, a, 0, shoes);
							}
							
							if (aRacer != null)
							{
								boolean addRacer = _isr.addRacer(aRacer);
								if (addRacer)
								{
									printRacer("Successfully added racer: ", aRacer);
								}
								else
								{
									System.out.println("Could not add the racer!");
								}
							}
						}
						else
						{
							System.out.println("You must create the race first.");
						}
						break;
					case 3:
						//remove a racer
						if (checkRaceCreated())
						{
							System.out.println("What is the name of the racer to remove?");
							String n = _input.nextLine();
							boolean removed = _isr.removeRacer(n);
							if (removed)
							{
								System.out.println("Successfully Removed Athlete " + n);
							}
							else
							{
								System.out.println("Could not remove athlete with name: " + n);
							}
						}
						else
						{
							System.out.println("You must create the race first.");
						}
						break;
					case 4:
						if (checkRaceCreated())
						{
							//find by name or id or type
							int findByChoice = printFindMenu();
							String matchVariable = null;
							AthleteFinder af = null;
							switch(findByChoice)
							{
								case 1:
									//find by name
									System.out.println("Please enter the name or partial name to match: ");
									matchVariable = _input.nextLine();
									af = new AthleteFindByPartialName(matchVariable);
									break;
								case 2: 
									//find by id
									System.out.println("Please enter the racer id to match: ");
									matchVariable = _input.nextLine();
									af = new AthleteFindByRacerId(Integer.parseInt(matchVariable));
									break;
								case 3:
									//find by type
									int typeChoice = printTypeChoiceMenu();
									switch(typeChoice)
									{
										case 1: 
											matchVariable = "runner";
											break;
										case 2:
											matchVariable = "biker";
											break;
										case 3:
											matchVariable = "swimmer";
											break;
										default:
											break;
									}
									af = new AthleteFindByType(matchVariable);
									break;
								default:
									break;
							}
							//find all matching racers
							ArrayList<Athlete> athletes = _isr.findMatchingAthletes(af);
							for (Athlete a : athletes)
							{
								printRacer("Athlete Match Found: ", a);
							}
						}
						else
						{
							System.out.println("You must create the race first.");
						}
						break;
					case 5:
						if (checkRaceCreated())
						{
							//get winner
							Athlete a = _isr.getWinner();
							if (a != null)
							{
								printRacer("The winner is: ", a);
							}
						}
						else
						{
							System.out.println("You must create the race first.");
						}
						break;
					case 6:
						if (checkRaceCreated())
						{
							Athlete[] racers = (Athlete[])_isr.getRacers();
							if (racers != null && racers.length > 0)
							{
								for (Athlete a : racers)
								{
									printRacer("Next racer: ", a);
								}
							}
							else
							{
								System.out.println("Please add some racers first.");
							}
						}
						else
						{
							System.out.println("You must create the race first.");
						}
						break;
					case 7:
						if (checkRaceCreated()) 
						{
							//save the racers to file
							boolean success = raceManagerPopulateAndStore.writeAthletesToFile(
									dataFile.dataFilePath, _isr.getRacersList());
							if (success)
							{
								System.out.println("Athletes have been stored into data file");
							}
							else
							{
								System.out.println("No data was available so the data file is now blank");
							}
						}
						break;
					case 8:
						if (checkRaceCreated())
						{
							//load the racers from file
							_isr.setRacersList(raceManagerPopulateAndStore.getAthletesFromFile(
									dataFile.dataFilePath));
						}
						break;
					case 9:
						//save system to file
						saveSystemToFile();
						System.out.println("Saved the system to the data file");
						break;
					case 10:
						//load system from file
						loadSystemFromFile();
						System.out.println("Loaded the system from the data file");
						break;
					case 11:
						//create the connector
						ServerConnector sc = new MySQLServerConnector(ShowDatabaseOperations.CONFIG_PATH
								, ShowDatabaseOperations.DB_KEY);
						
						//create the manager
						DBManager dbm = new DBManager(sc);
						
						//connect
						dbm.openConnection();
						//load athletes from the database into the system
						loadAthletesFromDB(dbm);
						
						//close connection
						dbm.closeConnection(false);
						System.out.println("Loaded the athletes from the online database");
						break;
					case 12:
					default:
						//quit
						completedEntries = true;
				}
			}
			catch (Exception ex)
			{
				System.out.println("Error: please try again..." + ex.getMessage());
			}
		}
		printCompleted();
	}
	*/
	
	public static int printMenu()
	{
		stars(menuStars);
		System.out.println("Enter 1 to create a new race");
		System.out.println("Enter 2 to add a new racer");
		System.out.println("Enter 3 to remove a racer");
		System.out.println("Enter 4 to find a racer");
		System.out.println("Enter 5 to get the winner");
		System.out.println("Enter 6 to list the racers");
		System.out.println("Enter 7 to save the racers to file");
		System.out.println("Enter 8 to load the racers from file");
		System.out.println("Enter 9 to save the entire system to file");
		System.out.println("Enter 10 to load the entire system from file");
		System.out.println("Enter 11 to load the athletes from the database");
		System.out.println("Enter 12 to quit");
		stars(menuStars);
		return Integer.parseInt(_input.nextLine());
	}
	
	public static int printFindMenu()
	{
		stars(menuStars);
		System.out.println("Enter 1 to find by name");
		System.out.println("Enter 2 to find by Id");
		System.out.println("Enter 3 to find by type");
		stars(menuStars);
		return Integer.parseInt(_input.nextLine());
	}
	
	public static int printTypeChoiceMenu()
	{
		stars(menuStars);
		System.out.println("Enter 1 to find Runners");
		System.out.println("Enter 2 to find Bikers");
		System.out.println("Enter 3 to find Swimmers");
		stars(menuStars);
		return Integer.parseInt(_input.nextLine());
	}
	
	public static void printRacer(String message, Athlete a)
	{
		dashes(menuStars);
		String outputDetails = "%s %s] Name: %s Age: %d RacerId: %d Activity: %s %s";
		String t = null;
		String extra = null;
		if (a instanceof Runner)
		{
			t = "Runner";
			Runner r = (Runner)a;
			extra = "Shoes: " + r.getShoeBrand();
		}
		else if (a instanceof Biker)
		{
			t = "Biker";
			Biker b = (Biker)a;
			extra = "Using clips: " + b.getUsingClips();
		}
		else if (a instanceof Swimmer)
		{
			t = "Swimmer";
			extra = "";
		}
		System.out.println(String.format(outputDetails
											, message
											, t
											, a.getName()
											, a.getAge()
											, a.getRacerId()
											, a.performRaceActivity()
											, extra));
		dashes(menuStars);
	}
	
	public static boolean checkRaceCreated()
	{
		return _isr != null;
	}
	
	public static void printWelcome()
	{
		stars(menuStars);
		System.out.println("Welcome to the Infinite Skills Race Manager.");
		System.out.println("What would you like to do today?");
		stars(menuStars);
	}
	
	public static void printCompleted()
	{
		stars(menuStars);
		System.out.println("Thank you for using the Infinite Skills Race Manager");
		
		stars(menuStars);
	}
	
	public static void stars(int num)
	{
		for (int i = 0; i < num; i++)
		{
			System.out.print("*");
		}
		System.out.print("\n");
	}
	
	public static void dashes(int num)
	{
		for (int i = 0; i < num; i++)
		{
			System.out.print("-");
		}
		System.out.print("\n");
	}

	public static void saveSystemToFile()
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(dataFile.dataObjectFilePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(_isr);
		}
		catch (IOException ioex)
		{
			ioex.printStackTrace();
		}
	}
	
	public static void loadSystemFromFile()
	{
		try
		{
			FileInputStream fis = new FileInputStream(dataFile.dataObjectFilePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
        	_isr = (InfiniteSkillsRace)ois.readObject();
        	ois.close();
        	ois = null;
        	fis.close();
        	fis = null;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	/*
	public static void loadAthletesFromDB(DBManager dbm) throws SQLException
	{
		ArrayList<Athlete> athletes = restoreAthletesFromRS(dbm);
		for (Athlete a : athletes)
		{
			_isr.addRacer(a);
			printRacer("Added to the system", a);
		}
	}
	
	private static ArrayList<Athlete> restoreAthletesFromRS(DBManager dbm) throws SQLException
	{
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		
		Connection cn = dbm.GetConnection();
		PreparedStatement pst = cn.prepareStatement(RaceManagerOperations.GetAthleteData());
		ResultSet rs = pst.executeQuery();
		
		while (rs.next())
		{
			Athlete a = null;
			int nextID = rs.getInt("RacerID");
			//determine type
			int type = rs.getInt("TypeId");
			//use the typeid to get the athlete type
			HashMap athleteTypes = ShowDatabaseOperations.getAthleteTypes(dbm);
			if ((int)athleteTypes.get(ShowDatabaseOperations.RUNNER) == type)
			{
				a = new Runner();
			}
			else if ((int)athleteTypes.get(ShowDatabaseOperations.BIKER) == type)
			{
				a = new Biker();
			}
			else if ((int)athleteTypes.get(ShowDatabaseOperations.SWIMMER) == type)
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
			//add the athlete to the list to add to the system.
			athletes.add(a);
		}
		
		rs.close();
		return athletes;
	}
	*/
}
