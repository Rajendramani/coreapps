import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Iterator;

import Utilities.StringGenerator;

public class LinkedListDemo 
{
	public void showOperations()
	{
		//Create a new LL Integer
		LinkedList<Integer> myNumbers = new LinkedList<Integer>();
		//Create a new LL String
		LinkedList<String> myStrings = new LinkedList<String>();
		//Create a new LL Animal
		LinkedList<Animal> myAnimals = new LinkedList<Animal>();
		
		//Add 5 of each to each list (Random Strings and junk Animal names)
		int offset = 65;
		//add to the end of the list
		for (int i = 0; i < 5; i++)
		{
			Integer nextInt = i * 10;
			myNumbers.add(nextInt);
		}
		for (int i = 0; i < 5; i++)
		{
			int firstChar = i + offset + (i*2);
			myStrings.add(StringGenerator.generateRandomString(firstChar));
		}
		for (int i = 0; i < 5; i++)
		{
			int firstChar = i + offset + (i*2);
			myAnimals.add(
					new Animal(StringGenerator.generateRandomString(firstChar)));
		}
		
		//print out all three
		System.out.println(StringGenerator.stars());
		System.out.println("Numbers:");
		for (Integer i : myNumbers)
		{
			System.out.println(i);
		}
		System.out.println(StringGenerator.stars());
		System.out.println("Strings:");
		ListIterator<String> litr = myStrings.listIterator();
		while (litr.hasNext())
		{
			System.out.println(litr.next());
		}
		System.out.println(StringGenerator.stars());
		System.out.println("Animals:");
		for (int i = 0; i < myAnimals.size(); i++)
		{
			System.out.println(myAnimals.get(i));
		}
		
		//insert at index in order
		myNumbers.add(1, 5);
		myStrings.add(2, StringGenerator.generateRandomString(offset+5));
		myAnimals.add(4, new Animal(
							StringGenerator.generateRandomString(offset+11)));
		
		//print them again:
		System.out.println(StringGenerator.stars());
		System.out.println("AFTER ADD AT INDEX");
		System.out.println(StringGenerator.stars());
		System.out.println("Numbers:");
		for (Integer i : myNumbers)
		{
			System.out.println(i);
		}
		System.out.println(StringGenerator.stars());
		System.out.println("Strings:");
		for (String s : myStrings)
		{
			System.out.println(s);
		}
		System.out.println(StringGenerator.stars());
		System.out.println("Animals:");
		for (Animal a : myAnimals)
		{
			System.out.println(a);
		}
		
		//JUST USING INTEGERS GOING FORWARD (with a few exceptions) - UNDERSTAND GENERIC TYPE CAN BE ANY TYPE
		//addAll to end
		LinkedList<Integer> insertMeEnd = new LinkedList();
		insertMeEnd.add(100);
		insertMeEnd.add(200);
		insertMeEnd.add(300);
		myNumbers.addAll(insertMeEnd);
		
		//addAll at index
		LinkedList<Integer> insertMeAtFive = new LinkedList();
		insertMeAtFive.add(31);
		insertMeAtFive.add(32);
		insertMeAtFive.add(33);
		insertMeAtFive.add(34);
		myNumbers.addAll(5, insertMeAtFive);
		System.out.println(StringGenerator.stars());
		System.out.println("Numbers:");
		for (Integer i : myNumbers)
		{
			System.out.println(i);
		}
		
		//add first
		myNumbers.addFirst(-1);
		//add last
		myNumbers.addLast(1000);
		System.out.println(StringGenerator.stars());
		System.out.println("FIRST: " + myNumbers.getFirst());
		System.out.println("LAST: " + myNumbers.getLast());
		
		//contains
		System.out.println(StringGenerator.stars());
		System.out.println("My Numbers contains 100? " + myNumbers.contains(100));
		System.out.println("My Numbers contains 250? " + myNumbers.contains(250));
		if (myNumbers.contains(1000))
		{
			System.out.println("Index of 1000: " + myNumbers.indexOf(1000));
		}
		myNumbers.add(1000);
		myNumbers.add(1000);
		myNumbers.add(2000);
		myNumbers.add(3000);
		myNumbers.add(4000);
		myNumbers.add(1000);
		myNumbers.add(5000);
		System.out.println("Last Index of 1000: " + myNumbers.lastIndexOf(1000));
		
		//Contains all
		LinkedList<Integer> myTestNumbers = new LinkedList<Integer>();
		myTestNumbers.add(1000);
		myTestNumbers.add(2000);
		myTestNumbers.add(3000);
		myTestNumbers.add(4000);
		myTestNumbers.add(5000);
		System.out.println("Contains all? " + myNumbers.containsAll(myTestNumbers));
		myTestNumbers.add(25000);
		System.out.println("Contains all? " + myNumbers.containsAll(myTestNumbers));
		
		
		//removeFirst
		myNumbers.removeFirst();   //removes -1;
		//removeLast
		myNumbers.removeLast();    //removes 5000;
		System.out.println(StringGenerator.stars());
		System.out.println("Numbers:");
		for (Integer i : myNumbers)
		{
			System.out.println(i);
		}
		
		//remove at lastIndexOf 1000
		System.out.println(myNumbers.remove(myNumbers.lastIndexOf(1000)));
		//remove at indexOf 2000
		myNumbers.remove(myNumbers.indexOf(2000));
		System.out.println(StringGenerator.stars());
		System.out.println("Numbers:");
		for (Integer i : myNumbers)
		{
			System.out.println(i);
		}
		
		//to remove by object I'm going to use the strings
		System.out.println(StringGenerator.stars());
		System.out.println("Strings:");
		for (String s : myStrings)
		{
			System.out.println(s);
		}
		String s4 = myStrings.get(4);
		System.out.println("REMOVE " + s4 + ": " + myStrings.remove(s4));
		System.out.println(StringGenerator.stars());
		System.out.println("Strings:");
		for (String s : myStrings)
		{
			System.out.println(s);
		}
		
		//add and remove by object
		//CLEAR
		myStrings.clear();
		myStrings.add("Han");
		myStrings.add("Darth");
		myStrings.add("Luke");
		myStrings.add("Leia");
		myStrings.add("Darth");
		myStrings.add("Chewy");
		myStrings.add("Darth");
		myStrings.add("Ben");
		myStrings.add("Yoda");
		System.out.println(StringGenerator.stars());
		System.out.println("Strings:");
		for (String s : myStrings)
		{
			System.out.println(s);
		}
		//remove firstOccurrence/lastOccurrence
		myStrings.removeFirstOccurrence("Darth");
		myStrings.removeLastOccurrence("Darth");
		
		System.out.println(StringGenerator.stars());
		System.out.println("Cleaned up characters:");
		for (String s : myStrings)
		{
			System.out.println(s);
		}
		

		
		//use clone to make copies
		LinkedList<String> anotherStringList = (LinkedList<String>) myStrings.clone();
		//use static collections methods to sort
		Collections.sort(anotherStringList);
		System.out.println(StringGenerator.stars());
		System.out.println("Sorted Star Wars Characters:");
		for (String s : anotherStringList)
		{
			System.out.println(s);
		}
		System.out.println("Unsorted Star Wars Characters:");
		for (String s : myStrings)
		{
			System.out.println(s);
		}
		
		//use toArray if you want to get the items in a plain old array
		System.out.println(StringGenerator.stars());
		System.out.println("To Array:");
		Object[] myStringArray = myStrings.toArray();
		for (int i = 0; i < myStringArray.length; i++)
		{
			System.out.println(myStringArray[i]);
		}
		
		//go in reverse using descendingIterator
		System.out.println(StringGenerator.stars());
		System.out.println("List in reverse using descending iterator");
		Iterator<String> reverseList = anotherStringList.descendingIterator();
		while (reverseList.hasNext())
		{
			System.out.println(reverseList.next());
		}
		
		//go in reverse using List Iterator
		System.out.println(StringGenerator.stars());
		System.out.println("List in reverse using List Iterator");
		ListIterator<String> litrReverse = anotherStringList.listIterator(anotherStringList.size());
		while (litrReverse.hasPrevious())
		{
			System.out.println(litrReverse.previous());
		}
		
		//go in reverse after reversing collection
		System.out.println(StringGenerator.stars());
		System.out.println("numbers in reverse after using collections.reverse");
		Collections.reverse(myNumbers);
		for (Integer i : myNumbers)
		{
			System.out.println(i);
		}

		//ListIterator actions
		System.out.println(StringGenerator.stars());
		System.out.println("List Iterator Actions");
		Collections.reverse(myNumbers);
		ListIterator<Integer> litrInts = myNumbers.listIterator();
		while (litrInts.hasNext())
		{
			Integer x = litrInts.next();
			litrInts.set(x * 2);
		}
		litrInts = myNumbers.listIterator(4);
		litrInts.next();
		litrInts.add(252525);
		
		litrInts = myNumbers.listIterator(7);
		litrInts.next();
		litrInts.remove();
		
		System.out.println("NEXT INDEX: " + litrInts.nextIndex());
		System.out.println("PREV INDEX: " + litrInts.previousIndex());
		
		for (ListIterator<Integer> liInts = myNumbers.listIterator(); liInts.hasNext(); )
		{
			System.out.println(liInts.next());
		}
		
		//CLEAR
		myNumbers.clear();
		System.out.println(StringGenerator.stars());
		System.out.println("Numbers:");
		if (myNumbers.size() == 0) System.out.println("NO NUMBERS");
		for (Integer i : myNumbers)
		{
			System.out.println(i);
		}
	}

}
