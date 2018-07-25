/**
 * A Biker.
 * 
 * @author  Brian
 * @version 1.0
 */
public class Biker implements RaceParticipant, Person
{
    private String _name;
    private int _age;
    private int _racerId;
    
    /**
     * Create a new Biker.
     */
    public Biker()
    {
        //do nothing.
    }
    
    /**
     * Create a new Biker with properties set.
     * @param name String name for the Biker
     * @param age int age for the Biker
     * @param racerId int racerId for the Biker
     */
    public Biker(String name, int age, int racerId)
    {
        _name = name;
        _age = age;
        _racerId = racerId;
    }
    
    /**
     * Get the name of the Biker.
     * @return String representing Biker's name
     */
    public String getName()
    {
        return _name;
    }
    
    /**
     * Set the name of the Biker.
     * @param value String to set as Biker's name
     */
    public void setName(String value)
    {
        _name = value;
    }
    
    /**
     * Get the age of the Biker.
     * @return int representing Biker's age
     */
    public int getAge()
    {
        return _age;
    }
    
    /**
     * Set the age of the Biker.
     * @param value int to set as Biker's age.
     */
    public void setAge(int value)
    {
        _age = value;
    }
    
    /**
     * Get the RacerID of the Biker.
     * @return int representing Biker's racerId
     */
    public int getRacerId()
    {
        return _racerId;
    }
    
    /**
     * Set the racer id for the Biker.
     * @param int to set as Biker's RacerId
     */
    public void setRacerId(int value)
    {
        _racerId = value;
    }
    
    /**
     * The race Activity for the Biker.
     * @return String representing the Biker's race activity.
     */
    public String performRaceActivity()
    {
        return "Biking...";
    }
    
    /**
     * Get the state of the Biker as a String.
     * @return String containing state of the Biker.
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
