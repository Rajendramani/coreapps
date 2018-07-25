
public class CustomUncheckedException extends RuntimeException 
{
	public CustomUncheckedException()
	{
		super("A custom unchecked exception has been encountered!");
	}
	
	public CustomUncheckedException(String msg)
	{
		super(msg);
	}
}
