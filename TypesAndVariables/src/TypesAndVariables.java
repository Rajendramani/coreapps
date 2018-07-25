
public class TypesAndVariables {

	public static void main(String[] args) {
		//Types
		//String - Any text, wrapped in ""'s
		//Character (char) - single character - 2 bytes
		//byte - 1 signed byte - whole number range -128 to 127
		//short -2 bytes - whole number range -32768 to 32767
		//Integer (int) - any whole number from roughly -2billion to +2billion (-2^32 to 2^32 -1) when signed - 4 bytes
		//Long (long) - any whole number from roughly -2^64 to 2^64-1
		//Float (float) - any number with decimals - single precision - 4 bytes
		//Double (double) - any number with decimals - double precision - 8 bytes
		//Boolean (boolean) - represents true or false (1 or 0) - 4 bytes
		
		//Variables -- store the values we work with:
		String fName = "James";
		char middleInit = 'T';
		char middleInitSymbol = '.';
		String lName = "Kirk";
		
		byte age = 32;
		short numberOfKlingonShipsEncountered = 358;
		int numberOfPlanetsDiscovered = 127649;
		long wholeKilometersTravelled = 10734622895L;
		float numberOfhoursOfService = 43800.0F;
		double costOfMission = 62436829749.03;
		boolean missionSuccess = true;
		
		String output = String.format("Captain %s %s%s %s, age %d, spent 5 years in space.\n"
				+ "During this time, the Enterprise encountered %d Klingon ships of various type and classification.\n"
				+ "%s and the Enterprise crew also discovered %d planets, while travelling approximately %d kilometers.\n"
				+ "The Enterprise crew served efficiently for %.1f hours.\n"
				+ "The cost of the mission translated to 21st century American dollars would be $%.2f.\n"
				+ "Therefore, our finding that the mission was successful is %b.\n"
				, fName
				, middleInit
				, middleInitSymbol
				, lName
				, age
				, numberOfKlingonShipsEncountered
				, lName
				, numberOfPlanetsDiscovered
				, wholeKilometersTravelled
				, numberOfhoursOfService
				, costOfMission
				, missionSuccess);
		
		System.out.println(output);
	}

}
