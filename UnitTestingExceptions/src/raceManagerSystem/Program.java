package raceManagerSystem;

import java.util.Scanner;
import raceManagerObjects.*;

public class Program 
{
	public static final int menuStars = 65;
	private static InfiniteSkillsRace _isr;
	private static Scanner _input;
	
	public static void main(String[] args) 
	{
		_input = new Scanner(System.in);
		printWelcome();
		boolean completedEntries = false;
		while (!completedEntries)
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
						//find a racer
						System.out.println("What is the name of the racer to find?");
						String n = _input.nextLine();
						Athlete a = _isr.getRacer(n);
						if (a != null)
						{
							printRacer("Racer Details: ", a);
						}
						else
						{
							System.out.println("Could not find athlete with name " + a);
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
				default:
					//quit
					completedEntries = true;
			}
		}
		printCompleted();
	}
	
	public static int printMenu()
	{
		stars(menuStars);
		System.out.println("Enter 1 to create a new race");
		System.out.println("Enter 2 to add a new racer");
		System.out.println("Enter 3 to remove a racer");
		System.out.println("Enter 4 to find a racer");
		System.out.println("Enter 5 to get the winner");
		System.out.println("Enter 6 to list the racers");
		System.out.println("Enter 7 to quit");
		stars(menuStars);
		return Integer.parseInt(_input.nextLine());
	}
	
	public static void printRacer(String message, Athlete a)
	{
		dashes(menuStars);
		String outputDetails = "%s] Name: %s Age: %d RacerId: %d Activity: %s %s";
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
}
