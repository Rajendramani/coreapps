/**
 * A Swimmer is an athlete that swims.
 * @author Brian
 *
 */
public class Swimmer 
{
	private int raceID;
	private String name;
	
	/**
	 * Default Constructor.
	 */
	public Swimmer() 
	{
		//do nothing.
	}
	
	/**
	 * Explicit Constructor.
	 * @param racerID int representing ID of the swimmer
	 * @param swimmerName String representing name of the swimmer
	 */
	public Swimmer(int racerID, String swimmerName) 
	{
		raceID = racerID;
		name = swimmerName;
	}
	
	/** add the mutators/accessors for swimmer **/
	/**
	 * Get the raceID for this swimmer.
	 * @return int representing raceID
	 */
	public int getRaceID()
	{
		return raceID;
	}
	
	/**
	 * Set the raceID for this swimmer.
	 * @param value the int representing this swimmer's race ID
	 */
	public void setRaceID(int value)
	{
		raceID = value;
	}
	
	/**
	 * Get the swimmer's name.
	 * @return String representing the name of the swimmer
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Set the name of the swimmer. 
	 * @param value String representing swimmer's name.
	 */
	public void setName(String value)
	{
		name = value;
	}
	
	/**
	 * Make the swimmer perform.
	 * @return the action of this athlete
	 */
	public String performSport() 
	{
		return "Swimming";
	}
	
	/**
	 * Get the swimmer toString() details.
	 * @return String representing state of the swimmer.
	 */
	public String toString()
	{
		return String.format("%s:\t%d is %s\n"
				, getName()
				, getRaceID()
				, performSport());
	}
}
