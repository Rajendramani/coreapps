package CustomObjects;

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	
	public Person()
	{}
	
	public Person(String first, String last, int a)
	{
		firstName = first;
		lastName = last;
		age = a;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String value)
	{
		firstName = value;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String value)
	{
		lastName = value;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int value)
	{
		age = value;
	}
	
	public String toString(){
		return String.format("First: %s\tLast: %s\tAge: %d\n"
				, this.getFirstName()
				, this.getLastName()
				, this.getAge());
	}

}
