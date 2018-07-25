package raceManagerObjects;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public abstract class AthleteTest 
{
	private Athlete a1;
	private Athlete a2;
	protected String _name = "Test Athlete";
	protected int _age = 32;
	protected int _racerId = 987654;
	
	public abstract Athlete getAthlete();
	public abstract Athlete getExplicitAthlete();
	
	/**
	 * Construct the AthleteTest.
	 */
	public AthleteTest()
	{
		a1 = getAthlete();
		a2 = getExplicitAthlete();
	}
	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
    public void testConstructors()
    {
        assertNotNull("Default Athlete could not be created", a1);
        
        assertNotNull("Explicit Athlete could not be created", a2);
        assertEquals("Name not set correctly on a2"
                        , _name
                        , a2.getName());
        assertEquals("Age not set correctly on a2"
                        , _age
                        , a2.getAge());
        assertEquals("RacerID not set correctly on a2"
                        , _racerId
                        , a2.getRacerId());
    }

	@Test
    public void testGetSetName()
    {
        a1.setName(_name);
        assertEquals("The name could not be set as expected"
                        , _name
                        , a1.getName());
    }
    
    @Test
    public void testGetSetAge()
    {
        a1.setAge(_age);
        assertEquals("The age could not be set as expected"
                        , _age
                        , a1.getAge());
    }
    
    @Test
    public void testGetSetRacerId()
    {
        a1.setRacerId(_racerId);
        assertEquals("The racerId could not be set as expected"
                        , _racerId
                        , a1.getRacerId());
    }
    
    /**
     * Make sure racer activity is tested.
     */
    public abstract void testPerformRaceActivity();
    
    @Test
    public void testToString()
    {
        a1.setName(_name);
        a1.setAge(_age);
        a1.setRacerId(_racerId);
        String rts = a1.toString();
        assertTrue("To String does not contain name"
                    , rts.contains(_name));
        assertTrue("To String does not contain age"
                    , rts.contains(String.format("%d", _age)));
        assertTrue("To String does not contain racer id"
                    , rts.contains(String.format("%d", _racerId)));
        String rc = a1.getClass().toString();
        assertTrue("To String does not contain class"
                    , rts.contains(rc));
                                                        
    }
}
