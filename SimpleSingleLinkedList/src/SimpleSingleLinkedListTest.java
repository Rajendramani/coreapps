import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SimpleSingleLinkedListTest {

	SimpleSingleLinkedList ssll;
	
	@Before
	public void setUp() throws Exception {
		ssll = new SimpleSingleLinkedList<Integer>();
		
	}

	@After
	public void tearDown() throws Exception {
		//ssll = null;
	}

	@Test
	public void testConstructors() 
	{
		assertNotNull("Could not create the Single Linked List", ssll);
		//assert the size is 0
		int size = ssll.size();
		assertEquals("Size should be 0", 0, ssll.size());
	}
	
	@Test
	public void testAdd()
	{
		ssll.add(10);
		assertEquals("Size should be 1", 1, ssll.size());
		ssll.add(20);
		assertEquals("Size should be 2", 2, ssll.size());
		ssll.add(30);
		assertEquals("Size should be 3", 3, ssll.size());
		ssll.add(40);
		assertEquals("Size should be 4", 4, ssll.size());
		ssll.add(50);
		assertEquals("Size should be 5", 5, ssll.size());
	}
	
	/**
	 * buildTestList
	 */
	private void buildTestList()
	{
		ssll.add(0);
		ssll.add(10);
		ssll.add(20);
		ssll.add(30);
		ssll.add(40);
	}
	
	
	@Test
	public void testIteratorIteration()
	{	
		buildTestList();
		
		//make sure the data is accurate in the list
		Iterator<Integer> itr = ssll.iterator();
		Integer i = 0;
		while (itr.hasNext())
		{
			Integer itrNext = itr.next();
			Integer expected = i * 10;
			assertEquals("Next was not the expected value", expected, itrNext);
			i++;
		}
	}
	
	@Test
	public void testIteratorAtIndexIteration()
	{	
		buildTestList();
		
		//make sure the data is accurate in the list
		Iterator<Integer> itr = ssll.iterator(2);
		Integer i = 2;
		while (itr.hasNext())
		{
			Integer itrNext = itr.next();
			Integer expected = i * 10;
			assertEquals("Next was not the expected value when iterator was constructed at index"
					, expected, itrNext);
			i++;
		}
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testIteratorNoSuchElementException()
	{
		buildTestList();
		
		//make sure the data is accurate in the list
		Iterator<Integer> itr = ssll.iterator();
		Integer i = 0;
		while (itr.hasNext())
		{
			Integer itrNext = itr.next();
			Integer expected = i * 10;
			assertEquals("Next was not the expected value when iterator was constructed at index"
					, expected, itrNext);
			i++;
		}
		//cause the exception:
		itr.next();
	}
	
	@Test
	public void testAddAtIndex()
	{
		buildTestList();
		//0 -> 0
		//1 -> 10
		//2 -> 20
		//3 -> 30
		//4 -> 40
		//insert 15 at index 2
		ssll.addAtIndex(2, 15);
		assertEquals("Size was not correct after add at index", 6, ssll.size());
		
		Integer[] expected = {0, 10, 15, 20, 30, 40};
		for (int i = 0; i < ssll.size(); i++)
		{
			assertEquals("Values were not correctly set after add at index", expected[i], ssll.get(i));
		}
	}
	
	@Test
	public void testGetAtIndex()
	{
		buildTestList();
		for (int i = 0; i < ssll.size(); i++)
		{
			Integer expected = i * 10;
			assertEquals("Get value at index was not as expected", expected, ssll.get(i));
		}
	}
	
	@Test
	public void testRemoveByData()
	{
		buildTestList();
		for (int i = 0; i < ssll.size(); i++)
		{
			Integer expected = i * 10;
			assertEquals("Get value at index was not as expected", expected, ssll.get(i));
		}
		
		Integer remove20 = 20;
		ssll.remove(remove20);
		
		Iterator<Integer> itr = ssll.iterator();
		Integer i = 0;
		while (itr.hasNext())
		{
			Integer itrNext = itr.next();
			assertNotEquals("Did not successfully remove by data", remove20, itrNext);
			i++;
		}
	}
	
	@Test
	public void testRemoveByIndex()
	{
		buildTestList();
		for (int i = 0; i < ssll.size(); i++)
		{
			Integer expected = i * 10;
			assertEquals("Get value at index was not as expected", expected, ssll.get(i));
		}
		
		int index = 3; //remove 30
		ssll.remove(index);
		Integer notValid = 30;
		
		for (int i = 0; i < ssll.size(); i++)
		{
			assertNotEquals("Did not successfully remove by index", notValid, ssll.get(i));
		}
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testBadIndexRemoveMinusOne()
	{
		buildTestList();
		ssll.remove(-1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testBadIndexRemoveEqualToSize()
	{
		buildTestList();
		ssll.remove(ssll.size());
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testBadIndexGreaterThanSize()
	{
		buildTestList();
		ssll.remove(ssll.size() + 10);
	}
	
	@Test
	public void testFindIndex()
	{
		buildTestList();

		for (int i = 0; i < ssll.size(); i++)
		{
			Integer expected = i * 10;
			assertEquals("Get value at index was not as expected", expected, ssll.get(i));
			
			int findIndex = ssll.findIndex(expected);
			assertEquals("Data value was not found at correct index", i, findIndex);
		}
		
	}
	
	@Test
	public void testIteratorRemoveSpecific()
	{
		buildTestList();
		Iterator<Integer> itr = ssll.iterator();
		while (itr.hasNext())
		{
			Integer nextInt = itr.next();
			if (nextInt == 30)
			{
				itr.remove();
			}
		}
		assertEquals("Size was not 4 after one item removed with iterator", 4, ssll.size());
	
		//validate no 30
		Integer notValid = 30;
		
		for (int i = 0; i < ssll.size(); i++)
		{
			assertNotEquals("Did not successfully remove by index", notValid, ssll.get(i));
		}
	}
	
	@Test
	public void testIteratorRemoveAll()
	{
		buildTestList();
		Iterator<Integer> itr = ssll.iterator();
		while (itr.hasNext())
		{
			itr.next();
			itr.remove();
		}
		assertEquals("Size was not 0 after all items removed with iterator", 0, ssll.size());
	}
	
	@Test(expected=IllegalStateException.class)
	public void testIteratorPreventNoNextRemove()
	{
		buildTestList();
		Iterator<Integer> itr = ssll.iterator();
		while (itr.hasNext())
		{
			itr.remove();
		}
	}
	
	@Test(expected=IllegalStateException.class)
	public void testIteratorPreventDoubleRemove()
	{
		buildTestList();
		Iterator<Integer> itr = ssll.iterator();
		while (itr.hasNext())
		{
			itr.next();
			itr.remove();
			itr.remove();
		}
	}

}
