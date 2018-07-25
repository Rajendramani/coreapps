/**
 * A runner.
 * 
 * @author  Brian
 * @version 1.0
 */
public class Runner extends Athlete
{
    private String _shoeBrand;
    /**
     * Create a new runner.
     */
    public Runner()
    {
        //do nothing.
    }
    
    /**
     * Create a new runner with properties set.
     * @param name String name for the Runner
     * @param age int age for the Runner
     * @param racerId int racerId for the Runner
     */
    public Runner(String name, int age, int racerId, String brand)
    {
        super(name, age, racerId);
        _shoeBrand = brand;
    }
    
    public String getShoeBrand()
    {
    	return _shoeBrand;
    }
    
    public void setShoeBrand(String value)
    {
    	_shoeBrand = value;
    }
    
    /**
     * The race Activity for the Runner.
     * @return String representing the Runner's race activity.
     */
    public String performRaceActivity()
    {
        return "Running...";
    }
    
    /**
     * Get the state of the Runner as a String.
     * @return String containing state of the Runner.
     */
    public String toString()
    {
        return String.format("%s %s]\tActivity: %s\tIs Running with shoes: %s\n"
                                , super.toString()
        						, getClass()
                                , performRaceActivity()
                                , getShoeBrand());
    }
}
