package raceManagerDatabase;


public class RaceManagerOperations 
{

	public static final String ATHLETE_TABLE_NAME = "Athlete";
	public static final String ATHLETE_TYPE_TABLE_NAME = "AthleteType";
	
	public static String CreateAthleteTableDetails()
	{
		return "`RacerID` INT NOT NULL AUTO_INCREMENT, "
				+ "`Name` VARCHAR(100) NOT NULL, "
				+ "`Age` INT NOT NULL, "
				+ "`IsInjured` BIT NOT NULL, "
				+ "`TypeId` INT NOT NULL, "
				+ "`Shoes` VARCHAR(45) NULL, "
				+ "`UsesClips` BIT NULL, "
				+ "PRIMARY KEY (`RacerID`)";
	}
	
	public static String CreateAthleteTypeTableDetails()
	{
		return "`ID` INT NOT NULL AUTO_INCREMENT, " 
				+ "`AthleteType` VARCHAR(45) NOT NULL, "
				+ "PRIMARY KEY (`ID`)";
	}
}
