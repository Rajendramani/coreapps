import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SwimmerTest {
	Swimmer s;
	String name = "Jill";
	int racerID = 319515;
	
	@Before
	public void setUp() throws Exception {
		s = new Swimmer();
	}

	@After
	public void tearDown() throws Exception {
		s = null;
	}

	@Test
	public void testConstructors() {
		assertNotNull("Could not create basic Swimmer", s);
		Swimmer s2 = new Swimmer(racerID, name);
		assertNotNull("Could not create complex Swimmer", s2);
		assertEquals("Name not set as expected on complex constructor"
						, name
						, s2.getName());
		assertEquals("ID not set as expected on complex constructor"
						, racerID
						, s2.getRaceID());
	}
	
	@Test
	public void testGetSetName()
	{
		s.setName(name);
		assertEquals("Name not set as expected"
					, name
					, s.getName());
	}
	
	@Test
	public void testGetSetRacerID()
	{
		s.setRaceID(racerID);
		assertEquals("ID Not set as expected"
					, racerID
					, s.getRaceID());
	}
	
	@Test
	public void testToString()
	{
		s.setName(name);
		s.setRaceID(racerID);
		String outputString = s.toString();
		assertTrue("To String does not contain name"
					, outputString.contains(name));
		assertTrue("To String does not contain id"
				, outputString.contains(String.format("%d", racerID)));
	}
}
