package raceManagerDatabase;
import raceManagerObjects.*;

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
	
	/**
	 * InsertAthleteTypeString configures a type to insert.
	 * @param aType the type to insert
	 * @return the formatted insert string
	 */
	public static String InsertAthleteTypeString(String aType)
	{
		return "INSERT INTO " + ATHLETE_TYPE_TABLE_NAME + " (`AthleteType`) "
				+ " VALUES('" + aType + "')";
	}
	
	/**
	 * InsertAthleteString gets the string formatted for insert
	 * @param a The athlete to insert
	 * @param typeId the type of athlete from the table
	 * @return the string formatted for insert.
	 */
	public static String InsertAthleteString(Athlete a, int typeId)
	{
		String athleteInsert = 
						"Insert into Athlete (`Name`, "
						+ "`Age`, "
						+ "`IsInjured`, "
						+ "`TypeId`, "
						+ "`Shoes`, "
						+ "`UsesClips`) "
						+ "VALUES "
						+ "('" + a.getName() + "', "
						+ a.getAge() + ", "
						+ a.getIsInjured() + ", "
						+ typeId + ", ";
		if (a instanceof Runner)
		{
			athleteInsert += "'" + ((Runner)a).getShoeBrand() + "', ";
		}
		else
		{
			athleteInsert += "NULL, ";
		}
		if (a instanceof Biker)
		{
			athleteInsert += ((Biker)a).getUsingClips();
		}
		else
		{
			athleteInsert += "NULL";
		}
		athleteInsert += ");";
		return athleteInsert;
	}

	/**
	 * Get the athlete type data
	 * @return String to get all athlete types
	 */
	public static String GetAthleteTypeData()
	{
		return "SELECT * FROM " + ATHLETE_TYPE_TABLE_NAME;
	}

	/**
	 * Get the athlete data.
	 * @return String to get the data
	 */
	public static String GetAthleteData()
	{
		return "SELECT * FROM " + ATHLETE_TABLE_NAME;
	}
	
	/**
	 * Get a query string to update athlete name and age
	 * @param a the athlete data to use to generate the update string
	 * @return the string to update the data with
	 */
	public static String UpdateAthleteString(Athlete a)
	{
		//clearly we could add more, but for simplicity and time, just doing name and age
		return "UPDATE " + ATHLETE_TABLE_NAME + " SET name='" + a.getName() + "', age=" + a.getAge() 
				+ " WHERE RacerID=" + a.getRacerId();
	}
}
