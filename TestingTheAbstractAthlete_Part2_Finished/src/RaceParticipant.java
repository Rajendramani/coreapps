
public interface RaceParticipant 
{
	/**
     * Set the racer ID.
     * @param int racerId is the ID for the racer
     */
    void setRacerId(int racerId);
    
    /**
     * Get the racer ID.
     * @return int the id of the racer
     */
    int getRacerId();
    
    /**
     * Perform the racing activity.
     * @return String the race activity being performed
     */
    String performRaceActivity();
}
