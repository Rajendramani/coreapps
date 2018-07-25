/**
 * A runner is an athlete that runs.
 * @author Brian
 *
 */
public class Runner 
{
	private int raceID;
	
	/**
	 * Default constructor.
	 */
	public Runner()
	{
		//do nothing.
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
		return String.format("%d is %s\n"
				, this.raceID
				, performSport());
	}
}
