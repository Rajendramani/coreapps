package raceManagerObjects;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SwimmerTest extends AthleteTest
{
    private Swimmer s;
    private String raceActivity = "Swimming";
    
    @Override
	public Athlete getAthlete() {
		return new Swimmer();
	}

	@Override
	public Athlete getExplicitAthlete() {
		return new Swimmer(_name, _age, _racerId);
	}
	
    @Before
    public void setUp()
    {
        s = new Swimmer();
    }

    @After
    public void tearDown()
    {
        s = null;
    }
    
    @Test
    public void testPerformRaceActivity()
    {
        String pra = s.performRaceActivity();
        assertTrue("Perform race activity did not contain activity"
                        , pra.contains(raceActivity));
    }
    
    @Test
    public void testToString()
    {
    	super.testToString();
        s.setName(_name);
        s.setAge(_age);
        s.setRacerId(_racerId);
        String rts = s.toString();
        String sc = s.getClass().toString();
        assertTrue("To String does not contain class"
                    , rts.contains(sc));
        assertTrue("To string does not contain performRaceActivity"
                    , rts.contains(raceActivity));       
    }
}
