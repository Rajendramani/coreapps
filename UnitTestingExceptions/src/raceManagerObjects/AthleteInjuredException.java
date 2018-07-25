package raceManagerObjects;

public class AthleteInjuredException extends RuntimeException
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
