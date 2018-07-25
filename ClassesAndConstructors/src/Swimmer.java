/**
 * A Swimmer is an athlete that swims.
 * @author Brian
 *
 */
public class Swimmer 
{
	private int raceID;
	
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
	 */
	public Swimmer(int racerID) 
	{
		raceID = racerID;
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
		return String.format("%d is %s\n"
				, this.raceID
				, performSport());
	}
}
