package raceManagerValidation;

public class Validate 
{
	/**
	 * Validate that a String is not null or empty.
	 * @param test the String to test.
	 * @throws IllegalArgumentException if null or empty String
	 */
	public static void StringHasContent(String test)
	{
		if (test == null || test.length() == 0)
		{
			throw new IllegalArgumentException("Null or Empty String encountered");
		}
	}
	
	/**
	 * Test to make sure a number is at least a certain value
	 * @param min the minimum valid number for the range
	 * @throws IllegalArgumentException if validation fails
	 */
	public static void NumberRangeValidation(int min, int value)
	{
		if (value < min)
		{
			throw new IllegalArgumentException("Number is not valid");
		}
	}
	
	/**
	 * Test to make sure a number is in a range (both inclusive)
	 * @param min int minimum acceptable number
	 * @param max int maximum acceptable number
	 * @throws IllegalArgumentException if validation fails
	 */
	public static void NumberRangeValidation(int min, int max, int value)
	{
		if (value < min || value > max)
		{
			throw new IllegalArgumentException("Number is not valid");
		}
	}
	
}
