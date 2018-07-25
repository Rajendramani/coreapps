package raceManagerObjects;
/**
 * A Swimmer.
 * 
 * @author  Brian
 * @version 1.0
 */
public class Swimmer extends Athlete
{
    /**
     * Create a new Swimmer.
     */
    public Swimmer()
    {
        //do nothing.
    }
    
    /**
     * Create a new Swimmer with properties set.
     * @param name String name for the Swimmer
     * @param age int age for the Swimmer
     * @param racerId int racerId for the Swimmer
     */
    public Swimmer(String name, int age, int racerId)
    {
        super(name, age, racerId);
    }
    
    /**
     * The race Activity for the Swimmer.
     * @return String representing the Swimmer's race activity.
     */
    public String performRaceActivity()
    {
        return "Swimming...";
    }
    
    /**
     * Get the state of the Swimmer as a String.
     * @return String containing state of the Swimmer.
     */
    public String toString()
    {
    	return String.format("%s %s]\tActivity: %s\n"
                , super.toString()
                , getClass()
                , performRaceActivity());
    }
}
