/**
 * A Dog.
 * @author Brian
 */
public class Dog extends Animal 
{
	private boolean _isServiceAnimal;
	
	/**
	 * Default constructor for the Dog.
	 */
	public Dog() 
	{
		//do nothing - call to super() is implicit.
	}

	/**
	 * Explicit constructor for a Dog.
	 * @param name String name of the dog.
	 * @param breed String breed of the dog.
	 * @param isServiceAnimal Boolean is a service animal.
	 */
	public Dog(String name, String breed, boolean isServiceAnimal) 
	{
		super(name, breed);
		_isServiceAnimal = isServiceAnimal;
	}

	/**
	 * Get the value for is a Service Animal.
	 * @return boolean representing if the dog is a service animal.
	 */
	public boolean getIsAServiceAnimal()
	{
		return _isServiceAnimal;
	}
	
	/**
	 * Set the value for is a Service Animal.
	 * @param isServiceAnimal boolean representing if dog is a service animal.
	 */
	public void setIsAServiceAnimal(boolean isServiceAnimal)
	{
		_isServiceAnimal = isServiceAnimal;
	}
	
	/**
	 * Get the Dog as a String.
	 * @return String representing the state of the dog.
	 */
	public String toString()
	{
		return String.format("%s\tIs a service animal: %b\n"
								, super.toString()
								, _isServiceAnimal
							);
	}
}
