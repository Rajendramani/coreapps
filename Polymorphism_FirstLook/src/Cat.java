/**
 * A Cat.
 * @author Brian
 */
public class Cat extends Animal
{
	private boolean _isDeclawed;
	
	/**
	 * Default Cat constructor.
	 */
	public Cat()
	{
		super();
	}
	
	/**
	 * Explicit Cat Constructor
	 * @param name String name of the cat.
	 * @param breed String breed of the cat.
	 * @param isDeclawed Boolean is declawed.
	 */
	public Cat(String name, String breed, boolean isDeclawed)
	{
		super(name, breed);
		_isDeclawed = isDeclawed;
	}
	
	/**
	 * Get the value for isDeclawed.
	 * @return boolean value for isDeclawed
	 */
	public boolean getIsDeclawed()
	{
		return _isDeclawed;
	}
	
	/**
	 * Set the value for isDeclawed.
	 * @param isDeclawed boolean to set for isDeclawed
	 */
	public void setIsDeclawed(boolean isDeclawed)
	{
		_isDeclawed = isDeclawed;
	}
	
	/**
	 * Return the Cat as a String.
	 * @return String representing the Cat's state.
	 */
	public String toString()
	{
		return String.format("%s\tIs declawed: %b\n"
								, super.toString()
								, _isDeclawed
							);
	}
}
