/**
 * A Biker.
 * 
 * @author  Brian
 * @version 1.0
 */
public class Biker implements RaceParticipant
{
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
     * @param racerId int racerId for the Biker
     */
    public Biker(int racerId)
    {
        _racerId = racerId;
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
        return String.format("%s]\tRacerID: %d\tActivity: %s\n"
                                , getClass()
                                , getRacerId()
                                , performRaceActivity());
    }
}
