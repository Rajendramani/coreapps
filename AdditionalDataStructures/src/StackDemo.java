import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Stack;

import Utilities.StringGenerator;


public class StackDemo 
{
	public void showOperations()
	{
		//Create a new Stack Integer
		Stack<Integer> myNumbers = new Stack<Integer>();
		populateNumbers(myNumbers);
		
		//Create a new Stack String
		Stack<String> myStrings = new Stack<String>();
		populateStrings(myStrings);
		
		//Create a new Stack Animal
		Stack<Animal> myAnimals = new Stack<Animal>(); 
		populateAnimals(myAnimals);
		
		//print them out
		System.out.println(StringGenerator.stars());
		System.out.println("Numbers:");
		while (!myNumbers.empty())
		{
			System.out.println(myNumbers.pop());
		}
		
		System.out.println(StringGenerator.stars());
		System.out.println("Strings:");
		while (!myStrings.empty())
		{
			System.out.println(myStrings.pop());
		}
		System.out.println(StringGenerator.stars());
		System.out.println("Animals:");
		while (!myAnimals.empty())
		{
			System.out.println(myAnimals.pop());
		}
		
		populateNumbers(myNumbers);
		populateStrings(myStrings);
		populateAnimals(myAnimals);
		
		System.out.println(StringGenerator.stars());
		System.out.println("Reversed Numbers:");
		Collections.reverse(myNumbers);
		while (!myNumbers.empty())
		{
			System.out.println(myNumbers.pop());
		}
		Stack<String> revStrs = reverseStack(myStrings);
		System.out.println(StringGenerator.stars());
		System.out.println("Reversed Strings peek:");
		
		if (revStrs.peek() != null)
		{
			System.out.println(revStrs.peek());
			System.out.println(revStrs.peek());
			System.out.println(revStrs.peek());
			System.out.println(revStrs.peek());
		}
		
		System.out.println(StringGenerator.stars());
		System.out.println("Reversed Strings:");
		while (!revStrs.empty())
		{
			System.out.println(revStrs.pop());
		}
		
		//According to the documentation - the more consistent
		//set of LIFO Operations can be created with an
		//ArrayDeque object
		Deque<Integer> mccLIFO = new ArrayDeque<Integer>();
		mccLIFO.push(0);
		mccLIFO.push(10);
		mccLIFO.push(20);
		mccLIFO.push(30);
		mccLIFO.push(40);
		while(mccLIFO.peek() != null)
		{
			System.out.println(mccLIFO.pop());
		}
	}
	
	private void populateNumbers(Stack<Integer> ints)
	{
		for (int i = 0; i < 5; i++)
		{
			ints.push(i);
		}
	}
	
	private void populateStrings(Stack<String> strs)
	{
		for (int i = 0; i < 5; i++)
		{
			strs.push(StringGenerator.generateRandomString(65 + i));
		}
	}
	
	private void populateAnimals(Stack<Animal> animals)
	{
		animals.push(new Animal("Aardvark"));
		animals.push(new Animal("Gorilla"));
		animals.push(new Animal("Jaguar"));
		animals.push(new Animal("Koala"));
		animals.push(new Animal("Zebra"));
	}
	
	private <E> Stack<E> reverseStack(Stack<E> aStack)
	{
		//we have to clone the stack
		//if we don't, we'll pop the original out of data
		Stack<E> temp = (Stack<E>) aStack.clone();
		Stack<E> output = new Stack<E>();
		while (!temp.empty())
		{
			output.push(temp.pop());
		}
		return output;
	}
}
