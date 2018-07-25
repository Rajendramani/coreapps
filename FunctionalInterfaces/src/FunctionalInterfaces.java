import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import CustomObjects.Person;


public class FunctionalInterfaces 
{

	public static void main(String[] args)
	{
		//a quick functional interface Function<T,R>
		//use Function<inputType, outputType> var = (inputType arg) -> { //return type expr };
		Function<Integer, String> getString = (Integer i) -> {
			return "You sent me " + i;
		};
		System.out.println(getString.apply(30));
		System.out.println(getString.apply(45));
		System.out.println(getString.apply(-30));
		
		//create a Function that takes an object and returns a String
		Function<Object, String> myOTS = (o) -> {
			return String.format("You sent me : %s", o.toString());
		};
		
		//print some out
		System.out.println(myOTS.apply("Any Object works!"));
		System.out.println(myOTS.apply(50));
		System.out.println(myOTS.apply(true));
		System.out.println(myOTS.apply(new Person("John", "Smith", 48)));
		
		//another functional interface: Comparator
		//comparator [use type inference!]:
		Comparator<String> c = (a, b) -> a.compareTo(b);
		CommonPrinter.po.printConsole(c.compare("Mike", "Marty"));
		CommonPrinter.po.printConsole(c.compare("Dan", "David"));
		CommonPrinter.po.printConsole(c.compare("John", "Andrew"));

		//note: We get type inference on a and b:
		Comparator<String> quickCompare = (a, b) -> {
			System.out.println("You can run any code you would like here!");
			System.out.println(String.format("%s vs. %s", a, b));
			return c.compare(a, b);
		};
		
		CommonPrinter.po.printConsole(quickCompare.compare("Mike", "Marty"));
		CommonPrinter.po.printConsole(quickCompare.compare("Dan", "David"));
		CommonPrinter.po.printConsole(quickCompare.compare("John", "Andrew"));
		
		//and now check out binary function, which takes two arguments and returns a result
		String one = "John";
		String two = "Andrew";
		if (c.compare(one,  two) > 0)
		{
			CommonPrinter.po.printConsole(one + " is greater than " + two + "!");
		}
		else
		{
			CommonPrinter.po.printConsole(two + " is greater than " + one + "!");
		}
		
		
		//binary operator
		
		//System.out.println("Add 3 + 2: " + a.apply(3, 2));
		//System.out.println("Add 7 + 10: " + a.apply(7, 10));
		
		//look, we also have some type inference here:

		//System.out.println(dbo.apply(8.0, 2.0));
		//System.out.println(dbo.apply(8.0, 0.0));
		
		
		//predicate testing
		/*
		System.out.println("What contains Value? " + containsValue.test("What?"));
		System.out.println("Value contains Value? " + containsValue.test("Value?"));
		*/
	
		//again, we can use type inference:
		/*
		System.out.println("32? " + isEven.test(32));
		System.out.println("55? " + isEven.test(55));
		*/
		
		//filter a collection
		/*
		List<Integer> productIDs = new ArrayList<Integer>(); 
		Random r = new Random(48915);
		for (int i = 0; i < 50; i++)
		{
			productIDs.add(r.nextInt(999999));
		}
		*/
		
		//create the filtered list here:
		
		/*
		for (Integer i : filteredIDs)
		{
			System.out.println("Next Value: " + i);
		}
		*/
		
	}
	
	/**
	 * Filter a list of items based on a predicate test.
	 * @param p the predicate expression
	 * @param items the list of items to filter
	 * @return a list containing only valid items
	 */
	public static <T> List<T> filterList(Predicate<T> p, List<T> items)
	{
		List<T> result = new ArrayList<T>();
		for (T data : items)
		{
			if (p.test(data)){
				result.add(data);
			}
		}
		return result;
	}
}
