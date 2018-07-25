import CustomObjects.Person;

public interface PersonGenerator<T extends Person> {
	T generate(String first, String last, int age);
}
