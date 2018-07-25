package raceManagerObjects;
import java.io.Serializable;

public class AthleteInjuredException extends RuntimeException implements Serializable
{
	public AthleteInjuredException()
	{
		super("The athlete was unable to complete the race due to injury.");
	}
	
	public AthleteInjuredException(String msg)
	{
		super(msg);
	}
}
