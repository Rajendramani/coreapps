import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Utilities.StringGenerator;

public class StreamsFilterCollectAndSorted 
{

	public static void main(String[] args)
	{
		//generate a list of 20 random integers:
		List<Integer> testList = StreamsSortingAndMapping.listGenerator(20);
		
		//First, let's examine something that does "Lazy Loading"
		//This means it will not run until needed:
		testList.stream().filter(x -> {
			System.out.println("Lazy Evaluating " + x + " for evenness");
			return x % 2 == 0;
		});
		System.out.println(StringGenerator.stars());
		
		//FILTER
		//once we return it to an object, it will evaluate:
		Object[] evens = testList.stream().filter(x -> {
						System.out.println("Lazy Evaluating " + x + " for evenness");
						return x % 2 == 0;
					}).toArray();
		System.out.println(StringGenerator.stars());
		
		//and we could just get a count if we wanted:
		long numEvens =  testList.stream().filter(x -> {
			return x % 2 == 0;
		}).count();
		System.out.println("There are [" + numEvens + "] even numbers in the testList!");
		System.out.println(StringGenerator.stars());
		
		try
		{
			Integer[] realEvens = 
				(Integer[]) testList.stream().filter(x -> { 
					return x % 2 == 0;
				}).toArray();
		}
		catch (Exception ex)
		{
			//squelch it  (or turn this on if you want to see it)
			//ex.printStackTrace();
		}
		
		//COLLECT
		//but there is a better way to get values anyway, using "collect":
		List<Integer> newTestList = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());
		for (Integer i : newTestList)
		{
			System.out.println("List from stream collect: " + i);
		}
		System.out.println(StringGenerator.stars());
		
		//now combine our filter and our collect in a chain:
		List<Integer> betterEvens = testList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		for (Integer i : betterEvens)
		{
			System.out.println("better evens: " + i);
		}
		System.out.println(StringGenerator.stars());
		
		//hey, we've been running a lot of the same lambda expressions.  Is there a 
		//better way to do this? Sure, you can always combine and create better lambdas:
		Predicate<Integer> isEven = x -> x % 2 == 0;
		List<Integer> bestEvens = testList.stream().filter(isEven).collect(Collectors.toList());
		for (Integer i : bestEvens)
		{
			System.out.println("best evens: " + i);
		}
		System.out.println(StringGenerator.stars());
		
		//but why are you using a for loop now when we have lambdas?  Good question!
		//let's stop using our for loops!
		bestEvens.forEach(x -> System.out.println("Inline Next Even: " + x));
		System.out.println(StringGenerator.stars());
		
		
		//SORTED 
		//and now we can easily sort them!!!
		List<Integer> bestBestEvens = testList.stream()
												.filter(isEven)
												.sorted()
												.collect(Collectors.toList());
		bestBestEvens.forEach(x -> System.out.println("Inline Sorted Next Even: " + x));
		System.out.println(StringGenerator.stars());
		
		//END PART ONE
	}
	
}
