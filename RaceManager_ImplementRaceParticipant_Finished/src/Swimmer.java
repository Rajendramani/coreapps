/**
 * A Swimmer.
 * 
 * @author  Brian
 * @version 1.0
 */
public class Swimmer implements RaceParticipant
{
    private int _racerId;
    
    /**
     * Create a new Swimmer.
     */
    public Swimmer()
    {
        //do nothing.
    }
    
    /**
     * Create a new Swimmer with properties set.
     * @param racerId int racerId for the Swimmer
     */
    public Swimmer(int racerId)
    {
        _racerId = racerId;
    }
    
    /**
     * Get the RacerID of the Swimmer.
     * @return int representing Swimmer's racerId
     */
    public int getRacerId()
    {
        return _racerId;
    }
    
    /**
     * Set the racer id for the Swimmer.
     * @param int to set as Swimmer's RacerId
     */
    public void setRacerId(int value)
    {
        _racerId = value;
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
        return String.format("%s]\tRacerID: %d\tActivity: %s\n"
                                , getClass()
                                , getRacerId()
                                , performRaceActivity());
    }
}
