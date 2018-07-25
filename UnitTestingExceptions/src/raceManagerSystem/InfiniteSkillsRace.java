package raceManagerSystem;
import raceManagerObjects.*;

import java.util.*;

public class InfiniteSkillsRace implements Race
{
	ArrayList<Athlete> _racers;
	int _nextRacerId;
	String _name;
	double _distance;
	String _location;
	Athlete _winner;
	
	/**
	 * Instantiate a race.
	 */
	public InfiniteSkillsRace()
	{
		_racers = new ArrayList<Athlete>();
		Random r = new Random();
		_nextRacerId = r.nextInt(999999);
	}
	
	/**
	 * Get the name.
	 * @return String name of race.
	 */
	public String getName() 
	{
		return _name;
	}

	/**
	 * Set the name.
	 * @return the name of the race
	 */
	public void setName(String name) 
	{
		_name = name;
	}

	/**
	 * Get the distance.
	 * @return double representing distance.
	 */
	public double getDistance() 
	{
		return _distance;
	}

	/**
	 * Set the distance.
	 * @param distance double distance in km
	 */
	public void setDistance(double distance) 
	{
		_distance = distance;
	}

	/**
	 * Get the location.
	 * @return String location of race.
	 */
	public String getLocation() 
	{
		return _location;
	}

	/**
	 * Set the location.
	 * @param location of the race
	 */
	public void setLocation(String location) 
	{
		_location = location;
	}

	/**
	 * Get the winner.
	 * @return Athlete who won the race.
	 */
	public Athlete getWinner()
	{
		calculateWinner();
		return _winner;
	}
	
	/**
	 * Calculate the winner.
	 */
	private void calculateWinner()
	{
		Random r = new Random();
		int winnerIndex = r.nextInt(_racers.size());
		_winner = _racers.get(winnerIndex);
	}
	
	/**
	 * Add a racer to the race.
	 * Set the racerid on add
	 * @param a the athlete to add
	 * @return true if successful
	 */
	public boolean addRacer(Athlete a)
	{
		//clearly, there might be races with people that have 
		//the same name in it.  For simplicity, we'll ignore that
		//because we don't want to take the time to further limit objects
		//by age, city, and/or other factors.
		if (a == null) return false;
		if (a.getName() == null) return false;
		int racerIndex = findRacer(a.getName());
		if (racerIndex >= 0) return false;
		_racers.add(a);
		a.setRacerId(_nextRacerId++);
		return true;
	}
	
	/**
	 * Remove a racer from the race.
	 * @param a the athlete to remove
	 */
	public boolean removeRacer(String name)
	{
		if (name == null) return false;
		int racerPosition = findRacer(name);
		if (racerPosition < 0) return false;
		_racers.remove(racerPosition);
		return true;
	}
	
	/**
	 * Get the current number of racers.
	 * @return number of registered racers
	 */
	public int getCurrentNumberOfRacers()
	{
		return _racers.size();
	}
	
	/**
	 * Get a racer by name.
	 * @param name The name of the racer to find.
	 * @return the athlete object by matching name.
	 */
	public Athlete getRacer(String name)
	{
		int index = findRacer(name);
		if (index < 0) return null;
		return _racers.get(index);
	}
	
	/**
	 * Find a racer by name
	 * @param name of the racer to find
	 * @return position of racer if exists
	 */
	private int findRacer(String name)
	{
		if (name == null) return -1;
		for (int i = 0; i < _racers.size(); i++)
		{
			Athlete a = _racers.get(i);
			if (a.getName().equalsIgnoreCase(name))
			{
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Get all the racers
	 * @return ArrayList<Athlete> the list of racers
	 */
	public Athlete[] getRacers()
	{
		if (_racers.size() > 0)
		{
			Athlete[] racers = new Athlete[_racers.size()];
			for (int i = 0; i < _racers.size(); i++)
			{
				racers[i] = (Athlete)_racers.get(i);
			}
			return racers;
		}
		else
		{
			return null;
		}
	}
}
