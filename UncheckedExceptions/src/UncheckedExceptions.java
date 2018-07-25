import java.util.Scanner;


public class UncheckedExceptions 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String name;
		int age;
		try
		{
			System.out.println("Please enter your name:");
			name = input.nextLine();
			System.out.println("Please enter your age:");
			age = Integer.parseInt(input.nextLine());
			System.out.println("Name: " + name + " Age: " + age);
		}
		catch (Exception ex)
		{
			System.out.println(ex.toString());
		}
		
		try
		{
			int x = 10;
			System.out.println("Please enter an integer");
			int y = Integer.parseInt(input.nextLine());
			System.out.println(x / y);
			try
			{
				System.out.println("Please enter another integer");
				int z = Integer.parseInt(input.nextLine());
				System.out.println(x / z);
			}
			finally
			{
				System.out.println("The nested finally");
			}
		}
		catch (NumberFormatException nfe)
		{
			System.out.println("Number format exception");
			System.out.println(nfe.toString());
		}
		catch (ArithmeticException ae)
		{
			System.out.println("Arithmetic Exception");
			System.out.println(ae.toString());
		}
		catch (Exception ex)
		{
			System.out.println("Some other exception");
			System.out.println(ex.toString());
		}
		finally
		{
			System.out.println("External Finally");
		}
	}
}
