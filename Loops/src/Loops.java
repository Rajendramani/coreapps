import java.util.Scanner;


public class Loops {

	public static void main(String[] args)
	{
		Runner raceRunner;
		Swimmer raceSwimmer;
		//while loops can run 0 to n number of times based on user input and start condition.
		//if we set runRaceManager = false, no loops will execute.
		boolean runRaceManager = true;
		while (runRaceManager)
		{
			int menuChoice = printMenu();
			switch (menuChoice)
			{
				case 1:
					System.out.println("You chose to create a new runner.");
					raceRunner = getNewRunner();
					System.out.println("You created the runner: " + raceRunner.toString());
					break;
				case 2:
					System.out.println("You chose to create a new swimmer.");
					raceSwimmer = getNewSwimmer();
					System.out.println("You created the swimmer: " + raceSwimmer.toString());
					break;
				case 3:
					System.out.println("Thank you for using Infinite Skills Race Manager!");
					runRaceManager = false;
					break;
				default:
					break;
			}
		}
		
		System.out.println("************* LOOP 1 COMPLETED *****************************");
		
		//do...while loops will run at least once, then continue n number of times
		do
		{
			//remember, from exit of last loop, RRM is false, but this still executes once..
			//set to true if want more than one execution
			//runRaceManager = true;
			int menuChoice = printMenu();
			switch (menuChoice)
			{
				case 1:
					System.out.println("You chose to create a new runner.");
					raceRunner = getNewRunner();
					System.out.println("You created the runner: " + raceRunner.toString());
					runRaceManager = true;
					break;
				case 2:
					System.out.println("You chose to create a new swimmer.");
					raceSwimmer = getNewSwimmer();
					System.out.println("You created the swimmer: " + raceSwimmer.toString());
					runRaceManager = true;
					break;
				case 3:
					System.out.println("Thank you for using Infinite Skills Race Manager!");
					runRaceManager = false;
					break;
				default:
					break;
			}
		} while (runRaceManager);
		

		System.out.println("************* LOOP 2 COMPLETED *****************************");
		//for loops run a set number of times no matter what
		for (int i = 0; i < 4; i++)
		{
			int menuChoice = printMenu();
			switch (menuChoice)
			{
				case 1:
					System.out.println("You chose to create a new runner.");
					raceRunner = getNewRunner();
					System.out.println("You created the runner: " + raceRunner.toString());
					break;
				case 2:
					System.out.println("You chose to create a new swimmer.");
					raceSwimmer = getNewSwimmer();
					System.out.println("You created the swimmer: " + raceSwimmer.toString());
					break;
				case 3:
					System.out.println("Thank you for using Infinite Skills Race Manager!");
					runRaceManager = false;
					break;
				default:
					break;
			}
		}
		
		System.out.println("************* LOOP 3 COMPLETED *****************************");
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
