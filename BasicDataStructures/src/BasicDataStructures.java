import java.util.ArrayList;
import java.util.Scanner;


public class BasicDataStructures {

	public static void main(String[] args)
	{
		final int MAX_RACE_RUNNERS = 5;
		Runner[] raceRunners = new Runner[MAX_RACE_RUNNERS];
		int raceRunnersCount = 0;
		ArrayList<Swimmer> raceSwimmers = new ArrayList<Swimmer>();

		boolean runRaceManager = true;
		while (runRaceManager)
		{
			int menuChoice = printMenu();
			switch (menuChoice)
			{
				case 1:
					System.out.println("You chose to create a new runner.");
					if (raceRunnersCount < MAX_RACE_RUNNERS)
					{
						raceRunners[raceRunnersCount] = getNewRunner();
						raceRunnersCount++;
					}
					else
					{
						System.out.println("The Race is full: No more runners can be added");
					}
					break;
				case 2:
					System.out.println("You chose to create a new swimmer.");
					raceSwimmers.add(getNewSwimmer());
					break;
				case 3:
					System.out.println("Thank you for using Infinite Skills Race Manager!");
					runRaceManager = false;
					break;
			}
		}
		
		System.out.println("************* Results *****************************");
		System.out.println("RUNNERS: ");
		for (int i = 0; i < raceRunnersCount; i++)
		{
			System.out.println(raceRunners[i]);
		}
		System.out.println("SWIMMERS: ");
		for (int i = 0; i < raceSwimmers.size(); i++)
		{
			System.out.println(raceSwimmers.get(i));
		}
		
	}
	
	/**
	 * Print the options menu.
	 * @return the int selected by the user for menu options
	 */
	public static int printMenu()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("*******************************************");
		System.out.println("* Welcome to Infinite Skills Race Manager *");
		System.out.println("*******************************************");
		System.out.println("What would you like to do today?");
		System.out.println("-------------------------------------------");
		System.out.println("Enter '1' to add a new Runner");
		System.out.println("Enter '2' to add a new Swimmer");
		System.out.println("Enter '3' to quit");
		System.out.println("-------------------------------------------");
		System.out.println("*******************************************");
		int result = Integer.parseInt(input.nextLine());
		return result;
	}
	
	/**
	 * Get a new runner from the user.
	 * @return Runner with details as entered by the user.
	 */
	public static Runner getNewRunner()
	{
		Scanner input = new Scanner(System.in);
		Runner r = new Runner();
		System.out.println("Please enter the name of the runner:");
		r.setName(input.nextLine());
		System.out.println("Please enter the raceID of the runner:");
		r.setRaceID(Integer.parseInt(input.nextLine()));
		return r;
	}
	
	/**
	 * Get a new Swimmer from the user.
	 * @return Swimmer with details as entered by the user.
	 */
	public static Swimmer getNewSwimmer()
	{
		Scanner input = new Scanner(System.in);
		Swimmer r = new Swimmer();
		System.out.println("Please enter the name of the athlete:");
		r.setName(input.nextLine());
		System.out.println("Please enter the raceID of the Swimmer:");
		r.setRaceID(Integer.parseInt(input.nextLine()));
		return r;
	}
}
