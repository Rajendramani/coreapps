import java.util.*;

public class BasicRegexRules 
{
	/*
	 *        '.'  ==> match any character [A-Za-z0-9!@# etc..
	 *        '^{...}'  ==> match at start [starts with]   //{...} denotes ANY REGEX in this key
	 *        '{...}$' ==> match at end [ends with]
	 *        '[A-Za-z0-9]' ==> match any cap, any small, and 0-9 //can be separated out to each.
	 *        '[^somevalue] ==> doesn't match somevalue...
	 *        '*' ==> Match ANY number of times
	 *        '+' ==> Match One or more times
	 *        '?' ==> 0 or 1 times only
	 *        '{n}' ==> match 'n' number of times
	 *        '\w' ==> Matches a normal char and underscore [A-Za-z0-9_]
	 *        '\s' ==> matches whitespace
	 *        '\d' ==> matches digit [0-9]
	 */
	
	//lets see some of this in action
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		//let's determine if a String that is input is a phone number
		String regexPhoneNumber = "\\d{3}-\\d{3}-\\d{4}";
		System.out.println("Please enter a phone number as XXX-XXX-XXXX: ");
		String inPhone = input.nextLine();
		if (inPhone.matches(regexPhoneNumber))
		{
			System.out.println("Thank you for entering a valid phone number!");
		}
		else
		{
			System.out.println("This number: " + inPhone + " is not a valid phone number in format XXX-XXX-XXXX");
		}
		
		//let's determine if a string has any "invalid" characters:
		String validCharactersRegex = "[0-9A-Za-z]*";
		System.out.println("Please enter a new password, using only letters and numbers: ");
		String inPassword = input.nextLine();
		if (inPassword.matches(validCharactersRegex))
		{
			System.out.println("Your new password has been recorded!");
		}
		else
		{
			System.out.println("We're sorry, this password is invalid!");
		}
		
		//now let's not allow a blank one, and make it have to be 8 characters long!
		String validCharactersRegex2 = "[0-9A-Za-z]{8}";
		System.out.println("Please enter a new password, using exactly any 8 letters and numbers: ");
		inPassword = input.nextLine();
		if (inPassword.matches(validCharactersRegex2))
		{
			System.out.println("Your new password has been recorded!");
		}
		else
		{
			System.out.println("We're sorry, this password is invalid!");
		}
		
		//now let's make it 8 chars long with at least one special character
		String validCharactersRegex3 = "[0-9A-Za-z]{7}[^0-9A-Za-z]{1}";
		System.out.println("Please enter a new password, using exactly any 7 letters and numbers,"
				+ " and exactly one special character in it at the end: ");
		inPassword = input.nextLine();
		if (inPassword.matches(validCharactersRegex3))
		{
			System.out.println("Your new password has been recorded!");
		}
		else
		{
			System.out.println("We're sorry, this password is invalid!");
		}
		
		//now let's search for a partial name....
		String nameStrSWB = "^B[\\w]*";
		String nameStrEWn = "[\\w]*n$";
		String nameStrA = ".*a.*";
		ArrayList<String> names = new ArrayList<String>();
		names.add("Adam");
		names.add("Jason");
		names.add("Brian");
		names.add("Suzanne");
		names.add("Melissa");
		names.add("Angie");
		names.add("Belinda");
		names.add("Becky");
		
		for (String n : names)
		{
			if (n.matches(nameStrSWB))
			{
				System.out.println("Starts with B: " + n);
			}
			if (n.matches(nameStrEWn))
			{
				System.out.println("Ends with N: " + n);
			}
			if (n.matches(nameStrA))
			{
				System.out.println("Contains an a: " + n);
			}
		}
		
	}
}
