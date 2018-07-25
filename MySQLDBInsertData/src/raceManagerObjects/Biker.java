package raceManagerObjects;
import java.io.Serializable;

/**
 * A Biker.
 * 
 * @author  Brian
 * @version 1.0
 */
public class Biker extends Athlete implements Serializable
{
	private boolean _usesClips;
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
    public Biker(String name, int age, int racerId, boolean usesClips)
    {
        super(name, age, racerId);
        _usesClips = usesClips;
    }
    
    public void setUsingClips(boolean value)
    {
    	_usesClips = value;
    }
    
    public boolean getUsingClips()
    {
    	return _usesClips;
    }
    
    /**
     * The race Activity for the Biker.
     * @return String representing the Biker's race activity.
     */
    public String performRaceActivity()
    {
    	if (getIsInjured())
    	{
    		throw new AthleteInjuredException("The biker got a knee injury.");
    	}
        return "Biking...";
    }
    
    /**
     * Get the state of the Biker as a String.
     * @return String containing state of the Biker.
     */
    public String toString()
    {
    	return String.format("%s %s]\tActivity: %s\tIs Biking with clips: %b\n"
                , super.toString()
                , getClass()
				, performRaceActivity()
                , getUsingClips());
    }
    
    /**
     * Get the data String for a Biker
     * @return String to match: BIKER|name=somestring;age=someint;...;clips=someboolean
     */
    public String toDataString()
    {
    	return String.format("BIKER|%s;clips=%b"
    			, super.toDataString()
    			, getUsingClips());
    }
}
