import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;


public class RunnerTest 
{
	private Runner r;
    private int racerId = 123456;
    private String raceActivity = "Running";
    
    @Before
    public void setUp()
    {
        r = new Runner();
    }

    @After
    public void tearDown()
    {
        r = null;
    }
    
    @Test
    public void testConstructors()
    {
        assertNotNull("Default Runner could not be created", r);
        
        Runner r2 = new Runner(racerId);
        assertNotNull("Explicit Runner could not be created", r2);
        assertEquals("RacerID not set correctly on R2"
                        , racerId
                        , r2.getRacerId());
    }
    
    @Test
    public void testGetSetRacerId()
    {
        r.setRacerId(racerId);
        assertEquals("The racerId could not be set as expected"
                        , racerId
                        , r.getRacerId());
    }
    
    @Test
    public void performRaceActivity()
    {
        String pra = r.performRaceActivity();
        assertTrue("Perform race activity did not contain activity"
                        , pra.contains(raceActivity));
    }
    
    @Test
    public void testToString()
    {
        r.setRacerId(racerId);
        String rts = r.toString();
        assertTrue("To String does not contain racer id"
                    , rts.contains(String.format("%d", racerId)));
        String rc = r.getClass().toString();
        assertTrue("To String does not contain class"
                    , rts.contains(rc));
        assertTrue("To string does not contain performRaceActivity"
                    , rts.contains(raceActivity));           
    }

}
