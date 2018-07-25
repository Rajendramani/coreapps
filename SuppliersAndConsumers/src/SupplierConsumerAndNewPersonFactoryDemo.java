import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import CustomObjects.Person;


public class SupplierConsumerAndNewPersonFactoryDemo 
{
	public static void main(String[] args)
	{
		PersonGenerator<Person> personFactory = Person::new;
		Person p1 = personFactory.generate("John", "Smith", 53);
		Person p2 = personFactory.generate("Sally", "Thomas", 37);
		Person p3 = personFactory.generate("Sandy", "Davis", 62);
		Person p4 = personFactory.generate("Ryan", "Johnson", 18);
		
		List<Person> people = Stream.of(p1, p2, p3, p4).collect(Collectors.toList());
		people.forEach(x -> System.out.println("Next Person: " + x));
		
		Supplier<Person> personFactory2 = Person::new;
		System.out.println(personFactory2.get());
		
		Consumer<Person> personGreeter = (p) -> System.out.println("Hello: " + p.getFirstName());
		people.forEach(x -> personGreeter.accept(x));
	}
}
