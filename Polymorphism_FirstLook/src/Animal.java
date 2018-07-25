/**
 * An Animal.
 * @author Brian
 */
public class Animal 
{
	private String _name;
	private String _breed;
	
	/**
	 * Default Animal.
	 */
	public Animal()
	{
		//do nothing
	}
	
	/**
	 * Complex Animal.
	 * @param name String representing animal name
	 * @param breed String representing animal breed
	 */
	public Animal(String name, String breed)
	{
		_name = name;
		_breed = breed;
	}
	
	/**
	 * Set the name of the animal.
	 * @param value String representing Animal name.
	 */
	public void setName(String value)
	{
		_name = value;
	}
	
	/**
	 * Get the name of the animal.
	 * @return String representing the name of the animal.
	 */
	public String getName()
	{
		return _name;
	}
	
	/**
	 * Set the breed of the animal.
	 * @param value String representing breed.
	 */
	public void setBreed(String value)
	{
		_breed = value;
	}
	
	/**
	 * Get the breed of the animal.
	 * @return String representing the breed.
	 */
	public String getBreed()
	{
		return _breed;
	}
	

	/**
	 * Get the state of the animal as a String.
	 * @return String representing Animal state.
	 */
	public String toString()
	{
		return String.format("%s] Breed: %s\tName: %s\t"
								, getClass().getName()
								, getBreed()
								, getName());
	}
}
