import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class RunnerTest extends AthleteTest
{
    private Runner r;
    private String raceActivity = "Running";
    private String shoes = "Any Shoe Brand";
    
    @Override
	public Athlete getAthlete() {
		return new Runner();
	}

	@Override
	public Athlete getExplicitAthlete() {
		return new Runner(_name, _age, _racerId, shoes);
	}
	
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
    	//leverage the overridden base class test.
    	super.testConstructors();
        Runner r2 = new Runner(_name, _age, _racerId, shoes);
        assertNotNull("Explicit Runner could not be created", r2);
        assertEquals("Shoes not set correctly on R2"
                , shoes
                , r2.getShoeBrand());
    }
    
    
    
    @Test
    public void testGetSetShoeBrand()
    {
        r.setShoeBrand(shoes);
        assertEquals("The shoes could not be set as expected"
                        , shoes
                        , r.getShoeBrand());
    }
    
    @Test
    public void testPerformRaceActivity()
    {
        String pra = r.performRaceActivity();
        assertTrue("Perform race activity did not contain activity"
                        , pra.contains(raceActivity));
    }
    
    @Test
    public void testToString()
    {
    	//leverage the overridden base class test.
    	super.testToString();
        
    	//test local runner properties
    	r.setName(_name);
        r.setAge(_age);
        r.setRacerId(_racerId);
        r.setShoeBrand(shoes);
        String rts = r.toString();
        assertTrue("To String does not contain shoes"
                , rts.contains(shoes));
        String rc = r.getClass().toString();
        assertTrue("To String does not contain class"
                    , rts.contains(rc));
        assertTrue("To string does not contain performRaceActivity"
                    , rts.contains(raceActivity));   
    }
}
