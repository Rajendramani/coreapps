
public class Animal implements Comparable<Animal>
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
	
	public String getName()
	{
		return _name;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s] Name: %s\n"
								, getClass().getName()
								, _name);
	}
	
	@Override
	public boolean equals(Object o1)
	{
		if (o1 == null) return false;
		if (!(o1 instanceof Animal)) return false;
		return (this.getName().equals(((Animal)o1).getName()));
	}



	@Override
	public int compareTo(Animal o) {
		if (o == null) return 1;
		
		//Strings are comparable.
		int ctVal = ((Animal)o).getName().compareTo(this.getName());
		if (ctVal < 0) return -1;
		if (ctVal > 0) return 1;
		return ctVal;
	}
}
