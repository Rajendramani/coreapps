
public class Utilities 
{
	/**
	 * Get equality without worrying about null pointer exceptions.
	 * @param one the first object to compare to
	 * @param two the second object to compare for equality
	 * @return true if equal, else false.
	 */
	public static boolean nullSafeEquals(Object one, Object two)
	{
		//NOTE: This code is not correct yet.
		return one.equals(two);
	}
}
