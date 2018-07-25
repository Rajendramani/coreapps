package raceManagerSearching;
import raceManagerObjects.*;

public class AthleteFindByType implements AthleteFinder {

	private String _type;
	
	public AthleteFindByType(String type)
	{
		_type = type;
	}
	
	@Override
	public boolean searchForAthlete(Athlete searcher) {
		if (_type.equalsIgnoreCase("runner"))
		{
			return searcher instanceof Runner;
		}
		else if (_type.equalsIgnoreCase("swimmer"))
		{
			return searcher instanceof Swimmer;
		}
		else if (_type.equalsIgnoreCase("biker"))
		{
			return searcher instanceof Biker;
		}
		return false;
	}
}
