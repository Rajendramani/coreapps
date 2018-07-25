
public abstract class Athlete implements RaceParticipant, Person 
{
	private String _name;
    private int _age;
    private int _racerId;
    
    /**
     * Create a new Athlete.
     */
    public Athlete()
    {
        //do nothing.
    }
    
    /**
     * Create a new Athlete with properties set.
     * @param name String name for the Athlete
     * @param age int age for the Athlete
     * @param racerId int racerId for the Athlete
     */
    public Athlete(String name, int age, int racerId)
    {
        _name = name;
        _age = age;
        _racerId = racerId;
    }
    
    /**
     * Get the name of the Athlete.
     * @return String representing Athlete's name
     */
    public String getName()
    {
        return _name;
    }
    
    /**
     * Set the name of the Athlete.
     * @param value String to set as Athlete's name
     */
    public void setName(String value)
    {
        _name = value;
    }
    
    /**
     * Get the age of the Athlete.
     * @return int representing Athlete's age
     */
    public int getAge()
    {
        return _age;
    }
    
    /**
     * Set the age of the Athlete.
     * @param value int to set as Athlete's age.
     */
    public void setAge(int value)
    {
        _age = value;
    }
    
    /**
     * Get the RacerID of the Athlete.
     * @return int representing Athlete's racerId
     */
    public int getRacerId()
    {
        return _racerId;
    }
    
    /**
     * Set the racer id for the Athlete.
     * @param int to set as Athlete's RacerId
     */
    public void setRacerId(int value)
    {
        _racerId = value;
    }
    
    /**
     * The race Activity for the Athlete.
     * @return String representing the Athlete's race activity.
     */
    public abstract String performRaceActivity();
    
    /**
     * Get the state of the Athlete as a String.
     * @return String containing state of the Athlete.
     */
    public String toString()
    {
        return String.format("%s]\tName: %s\tAge: %d\tRacerID: %d\t"
                                , getClass()
                                , getName()
                                , getAge()
                                , getRacerId());
    }
    
}
