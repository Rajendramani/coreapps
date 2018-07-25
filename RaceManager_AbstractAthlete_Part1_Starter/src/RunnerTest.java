import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class RunnerTest
{
    private Runner r;
    private String name = "TestName";
    private int age = 32;
    private int racerId = 123456;
    private String raceActivity = "Running";
    private String shoes = "Any Shoe Brand";
    
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
        
        Runner r2 = new Runner(name, age, racerId, shoes);
        assertNotNull("Explicit Runner could not be created", r2);
        assertEquals("Name not set correctly on R2"
                        , name
                        , r2.getName());
        assertEquals("Age not set correctly on R2"
                        , age
                        , r2.getAge());
        assertEquals("RacerID not set correctly on R2"
                        , racerId
                        , r2.getRacerId());
        assertEquals("Shoes not set correctly on R2"
                , shoes
                , r2.getShoeBrand());
    }
    
    @Test
    public void testGetSetName()
    {
        r.setName(name);
        assertEquals("The name could not be set as expected"
                        , name
                        , r.getName());
    }
    
    @Test
    public void testGetSetAge()
    {
        r.setAge(age);
        assertEquals("The age could not be set as expected"
                        , age
                        , r.getAge());
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
    public void testGetSetShoeBrand()
    {
        r.setShoeBrand(shoes);
        assertEquals("The shoes could not be set as expected"
                        , shoes
                        , r.getShoeBrand());
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
        r.setName(name);
        r.setAge(age);
        r.setRacerId(racerId);
        r.setShoeBrand(shoes);
        String rts = r.toString();
        assertTrue("To String does not contain name"
                    , rts.contains(name));
        assertTrue("To String does not contain age"
                    , rts.contains(String.format("%d", age)));
        assertTrue("To String does not contain racer id"
                    , rts.contains(String.format("%d", racerId)));
        assertTrue("To String does not contain shoes"
                , rts.contains(shoes));
        String rc = r.getClass().toString();
        assertTrue("To String does not contain class"
                    , rts.contains(rc));
        assertTrue("To string does not contain performRaceActivity"
                    , rts.contains(raceActivity));
                                                        
    }
}
