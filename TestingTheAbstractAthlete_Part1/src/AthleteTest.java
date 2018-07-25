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
        assertNotNull("Default Runner could not be created", a1);
        assertNotNull("Explicit Runner could not be created", a2);
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

}
