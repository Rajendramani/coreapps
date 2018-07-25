
public class CustomCheckedException extends Exception 
{
	public CustomCheckedException()
	{
		super("A Custom Checked Exception has been encountered");
	}
	
	public CustomCheckedException(String msg)
	{
		super(msg);
	}
}
