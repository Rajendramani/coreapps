import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import CustomObjects.Person;
import Utilities.StringGenerator;
public class StreamsAdvancedSortingAndMapping 
{
	public static void main(String[] args)
	{
		List<Person> newEmps = null;
		
		//ADVANCED SORTING:
		//create a list of people
		System.out.println(StringGenerator.stars());
		System.out.println("DEFAULT EMPLOYEES:");
		List<Person> myEmployees = StreamsSortingAndMapping.getEmployees();
		myEmployees.forEach(e -> System.out.println("Next Employee: " + e));
		System.out.println(StringGenerator.stars());
		
		//sort the "Old Fashioned" way {won't work, not comparable!} 
		//LinkedList<Person> empClone = (LinkedList<Person>) myEmployees.clone();
		//Collections.sort(empClone);
		
		//without ability to compare, can't just easily sort
		//List<Person> sortedEmps = myEmployees.sorted().collect(Collectors.toList());
		//List<Person> sortedEmps = myEmployees.sorted((Person a, Person b) -> {return a.getLastName().compareTo(b.getLastName());});
		
		//use a comparator to sort:
		System.out.println("Sorted Employees with Comparator on Last Name");
		Comparator<Person> personComparator = (Person a, Person b) -> {return a.getLastName().compareTo(b.getLastName());};
		Collections.sort(myEmployees, personComparator);
		myEmployees.forEach(e -> System.out.println("Next Emp by Last Name: " + e));
		System.out.println(StringGenerator.stars());
		
		//create a list and sort it with the comparator, but sort by age this time
		personComparator = (a, b) -> {
			return ((Integer)a.getAge()).compareTo((Integer)b.getAge());
		};
		newEmps = myEmployees.stream().sorted(personComparator).collect(Collectors.toList());
		newEmps.forEach(e -> System.out.println("Emps by Age: " + e));
		System.out.println(StringGenerator.stars());
		
		//sorted by age where age > 25
		System.out.println(StringGenerator.stars());
		System.out.println("Sorted Employees with Comparator on Age and Filter > 25");
		
		newEmps = myEmployees.stream()
								.filter(x -> x.getAge() > 25)
								.sorted(personComparator)
								.collect(Collectors.toList());
		newEmps.forEach(e -> System.out.println("Emps by Age > 25: " + e));
		System.out.println(StringGenerator.stars());
		

		//MAPPING:
		//using mapping to create the data:
		newEmps = StreamsSortingAndMapping.getEmployees();
		List<String> empsOver25 = newEmps.stream()
										.filter(x -> x.getAge() > 25)
										.map(x -> x.getFirstName() + " " + x.getLastName() + ": " + x.getAge() + " years old.")
										.collect(Collectors.toList());
		
		empsOver25.forEach(e -> System.out.println(e));
		System.out.println(StringGenerator.stars());
		
		
		//create a function and use it in any map
		Function <Person, String> personReport = (a) -> { return a.getLastName() + ", " + a.getFirstName() + ": " + a.getAge() + " years old.";};
		List<String> empsOver40 = newEmps.stream()
								.filter(x -> x.getAge() > 40)
								.sorted(personComparator)
								.map(personReport)
								.collect(Collectors.toList());
		empsOver40.forEach(e -> System.out.println(e));
		System.out.println(StringGenerator.stars());
		
		
		//use mapping to get subsets
		//use a map to get part of the list to a new list
		List<Person> people = StreamsSortingAndMapping.getPeople(20);
		List<Integer> ageList = people.stream().map(Person::getAge).collect(Collectors.toList());
		ageList.stream().sorted().collect(Collectors.toList()).forEach(x -> System.out.println("Next Age: " + x));
		System.out.println(StringGenerator.stars());
		
		personComparator = (Person a, Person b) -> { return a.getFirstName().compareTo(b.getFirstName()); };
		List<String> nameList = people.stream().sorted(personComparator).map(Person::getFirstName).collect(Collectors.toList());
		nameList.forEach(x -> System.out.println("Next Name: " + x));
		System.out.println(StringGenerator.stars());
		
		//use a mapToInt to get a value, then average it as double
		double average = people.stream().filter(x -> x.getAge() > 25)
							.mapToInt(Person::getAge)
							.average()
							.getAsDouble();
		System.out.println("Average age of employees over 25 is: " + average);
		
		//mapping to a Java map:
		//create a map of all Employees by age:
		Map<Integer, List<Person>> empsByAge = 
						people.stream().collect(Collectors.groupingBy(Person::getAge));
		empsByAge.forEach((k,v) -> System.out.println(StringGenerator.stars() + "\nAge: " + k + "\nNames:\n" + v));
		System.out.println(StringGenerator.stars());
		//get the age x employees by key
		System.out.println("My employees that are age 25: " + empsByAge.get(25));
		
		System.out.println(StringGenerator.stars());
	}
}
