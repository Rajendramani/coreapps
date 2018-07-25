/**
 * A runner.
 * 
 * @author  Brian
 * @version 1.0
 */
public class Runner implements RaceParticipant, Person
{
    private String _name;
    private int _age;
    private int _racerId;
    
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
    public Runner(String name, int age, int racerId)
    {
        _name = name;
        _age = age;
        _racerId = racerId;
    }
    
    /**
     * Get the name of the Runner.
     * @return String representing Runner's name
     */
    public String getName()
    {
        return _name;
    }
    
    /**
     * Set the name of the Runner.
     * @param value String to set as Runner's name
     */
    public void setName(String value)
    {
        _name = value;
    }
    
    /**
     * Get the age of the Runner.
     * @return int representing Runner's age
     */
    public int getAge()
    {
        return _age;
    }
    
    /**
     * Set the age of the Runner.
     * @param value int to set as Runner's age.
     */
    public void setAge(int value)
    {
        _age = value;
    }
    
    /**
     * Get the RacerID of the Runner.
     * @return int representing Runner's racerId
     */
    public int getRacerId()
    {
        return _racerId;
    }
    
    /**
     * Set the racer id for the runner.
     * @param int to set as Runner's RacerId
     */
    public void setRacerId(int value)
    {
        _racerId = value;
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
        return String.format("%s]\tName: %s\tAge: %d\tRacerID: %d\tActivity: %s\n"
                                , getClass()
                                , getName()
                                , getAge()
                                , getRacerId()
                                , performRaceActivity());
    }
}
