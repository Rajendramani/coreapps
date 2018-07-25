import java.util.Scanner;


public class Driver 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		try
		{
			System.out.println("Dividing by zero is illegal. "
								+ "Enter any number but zero.");
			
			int x = Integer.parseInt(input.nextLine());
			try
			{
				int y = 32 / x;
				System.out.println("The result is: " + y);
			}
			finally
			{
				System.out.println("In the finally, we are done with division!");
			}
			
			throw new RuntimeException("Our custom message goes here!");
		}
		catch(NumberFormatException nfe)
		{
			try
			{
				System.out.println("A number format happened.  Please enter a number");
			}
			catch (Exception ex2)
			{
				System.out.println("Nested NFE completed");
			}
		}
		catch (ArithmeticException aex)
		{
			try
			{
				System.out.println("Outer arithmetic exception");
				throw new IllegalArgumentException("IAEX thrown for fun");
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Pretty much unreachable code here");
			}
			catch(Exception ex2)
			{
				//since we are already in a catch, we can't hit the catch at the
				//next level...Would have to wrap the whole thing in a try!
				throw new RuntimeException("You can't catch this!");
			}
			finally
			{
				System.out.println("Nested NFE completed");
			}
		}
		catch(RuntimeException rex)
		{
			//won't get hit because we are already in a catch when
			//this was thrown
			System.out.println("Runtime Exception!");
			//rex.printStackTrace();
			//System.out.println(rex.getMessage());
		}
		finally
		{
			System.out.println("This is the end of the line");
		}
		
		System.out.println("Done");
	}
}
