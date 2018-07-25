
public class DataContainer<T> 
{
	T containerData;
	public DataContainer(T data)
	{
		containerData = data;
	}
	
	public T getData()
	{
		return containerData;
	}
	
	public void setData(T value)
	{
		containerData = value;
	}
	
	/**
	 * Get the data printout.
	 * Relies on T having toString() defined.
	 * Returns String representing the state of the container data
	 */
	public String toString()
	{
		return containerData == null 
							? null  
							: String.format("%s"
									, containerData.toString());
	}
}
