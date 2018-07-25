
public class Animal 
{
	private String _name;
	
	public Animal()
	{
		//do nothing
	}
	
	public Animal(String name)
	{
		_name = name;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s] Name: %s\n"
								, getClass().getName()
								, _name);
	}
}
