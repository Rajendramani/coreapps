package raceManagerObjects;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BikerTest extends AthleteTest
{
    private Biker b;
    private String raceActivity = "Biking";
    private boolean usesClips = false;
    
    @Override
	public Athlete getAthlete() {
		return new Biker();
	}

	@Override
	public Athlete getExplicitAthlete() {
		return new Biker(_name, _age, _racerId, usesClips);
	}
	
    @Before
    public void setUp()
    {
        b = new Biker();
    }

    @After
    public void tearDown()
    {
        b = null;
    }
    
    @Test
    public void testConstructors()
    {
        super.testConstructors();
        Biker b2 = new Biker(_name, _age, _racerId, usesClips);
        assertNotNull("Explicit Biker could not be created", b2);
        assertEquals("UsesClips not set correctly on R2"
                , usesClips
                , b2.getUsingClips());
    }
    
    
    @Test
    public void testGetSetUsingClips()
    {
        b.setUsingClips(usesClips);
        assertEquals("The clips could not be set as expected"
                        , usesClips
                        , b.getUsingClips());
    }
    
    @Test
    public void testPerformRaceActivity()
    {
        String pra = b.performRaceActivity();
        assertTrue("Perform race activity did not contain activity"
                        , pra.contains(raceActivity));
    }
    
    @Test
    public void testToString()
    {
    	super.testToString();
        b.setName(_name);
        b.setAge(_age);
        b.setRacerId(_racerId);
        b.setUsingClips(usesClips);
        String rts = b.toString();
        assertTrue("To String does not contain using clips"
                , rts.contains(String.format("%b", usesClips)));
        String bc = b.getClass().toString();
        assertTrue("To String does not contain class"
                    , rts.contains(bc));
        assertTrue("To string does not contain performRaceActivity"
                    , rts.contains(raceActivity));                   
    }

	
}
