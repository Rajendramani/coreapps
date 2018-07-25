/**
 * A runner is an athlete that runs.
 * @author Brian
 *
 */
public class Runner 
{
	private int raceID;
	private String name;
	
	/**
	 * Default constructor.
	 */
	public Runner()
	{
		//do nothing.
	}
	
	/** add the mutators/accessors for runner **/
	/**
	 * Get the raceID for this runner.
	 * @return int representing raceID
	 */
	public int getRaceID()
	{
		return raceID;
	}
	
	/**
	 * Set the raceID for this runner.
	 * @param value the int representing this runner's race ID
	 */
	public void setRaceID(int value)
	{
		raceID = value;
	}
	
	/**
	 * Get the runner's name.
	 * @return String representing the name of the runner
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Set the name of the runner. 
	 * @param value String representing runner's name.
	 */
	public void setName(String value)
	{
		name = value;
	}
	
	/**
	 * Make the runner perform.
	 * @return the action of this athlete
	 */
	public String performSport() 
	{
		return "Running";
	}
	
	/**
	 * Get the runner toString() details.
	 * @return String representing state of the runner.
	 */
	public String toString()
	{
		return String.format("%s:\t%d is %s\n"
				, getName()
				, getRaceID()
				, performSport());
	}
}
