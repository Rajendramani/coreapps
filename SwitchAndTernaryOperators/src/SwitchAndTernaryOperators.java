import java.util.Scanner;


public class SwitchAndTernaryOperators {

	public static void main(String[] args)
	{
		//create a new runner
		Runner r = new Runner();
		r.setRaceID(146720);
		r.setName("Tom");
		
		//create a new swimmer (default)
		Swimmer s = new Swimmer();
		s.setRaceID(726198);
		
		//create a new swimmer (explicit)
		Swimmer s2 = new Swimmer(235971, "Jason");
		
		System.out.println(r);
		System.out.println(s);
		System.out.println(s2);
		
		//NSE
		System.out.println("X equals Y? " + Utilities.nullSafeEquals("X", "Y"));
		
		System.out.println("rName = sName? " + Utilities.nullSafeEquals(r.getName(), s.getName()));
		System.out.println("rName = s2Name? " + Utilities.nullSafeEquals(r.getName(), s2.getName()));
		System.out.println("rName = Tom? " + Utilities.nullSafeEquals(r.getName(), "Tom"));
		
		System.out.println("sName = s2Name? " + Utilities.nullSafeEquals(s.getName(), s2.getName()));
		System.out.println("sName = rName? " + Utilities.nullSafeEquals(s.getName(), r.getName()));
		System.out.println("sName = null? " + Utilities.nullSafeEquals(s.getName(), null));
		
		System.out.println("s2Name = rName? " + Utilities.nullSafeEquals(s2.getName(), r.getName()));
		System.out.println("s2Name = sName? " + Utilities.nullSafeEquals(s2.getName(), s.getName()));
		System.out.println("s2Name = Jason? " + Utilities.nullSafeEquals(s2.getName(), "Jason"));

		Runner raceRunner;
		Swimmer raceSwimmer;
		
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
				break;
			default:
				break;
		}
		System.out.println("Complete");
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
