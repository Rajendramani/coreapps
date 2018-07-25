package raceManagerSearching;

import raceManagerObjects.Athlete;

public class AthleteFindByRacerId implements AthleteFinder {
	int _racerId;
	
	public AthleteFindByRacerId(int racerId)
	{
		_racerId = racerId;
	}
	
	@Override
	public boolean searchForAthlete(Athlete searcher) {
		return searcher.getRacerId() == _racerId;
	}
}
