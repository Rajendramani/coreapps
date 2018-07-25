import java.util.Scanner;


public class ShowCustomCheckedExceptions 
{

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter any number");
		int anyNumber = Integer.parseInt(input.nextLine());
		if (anyNumber < 100)
		{
			throw new CustomUncheckedException("Number is too small!");
			//throw new CustomCheckedException("Number is too small!");
		}
		
		/*
		try
		{
			int anyNumber = Integer.parseInt(input.nextLine());
			if (anyNumber < 100)
			{
				throw new CustomCheckedException("Number is too small!");
			}
		}
		catch (NumberFormatException nfe)
		{
			System.out.println("Please enter a number next time");
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		*/
	}
	
}
