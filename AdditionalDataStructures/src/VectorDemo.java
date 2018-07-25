import java.util.Vector;

import Utilities.StringGenerator;


public class VectorDemo {

	public void showOperations()
	{
		Vector<Integer> myNumbers = new Vector<Integer>();
		
		for (int i = 0; i < 5; i++)
		{
			myNumbers.add(i);
		}
		
		System.out.println(myNumbers.get(0));
		System.out.println(myNumbers.get(1));
		System.out.println(myNumbers.get(4));
		
		System.out.println(StringGenerator.stars());
		//add at index
		myNumbers.add(3, 10);
		for (Integer i : myNumbers)
		{
			System.out.println(i);
		}
		
		System.out.println("What is the capacity: " + myNumbers.capacity());
		for (int i = 1000; i < 2000; i++)
		{
			myNumbers.add(i);
		}
		System.out.println("What is the capacity: " + myNumbers.capacity());
		
		//ensure capacity
		myNumbers = new Vector<Integer>();
		System.out.println("What is the capacity: " + myNumbers.capacity());
		myNumbers.ensureCapacity(25000);
		System.out.println("What is the capacity: " + myNumbers.capacity());
		
		//of course you can do any of the other operations on
		//vector that we've already seen with linked list
		
		
	}
}
