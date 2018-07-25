import java.util.*;

public class StringOperations 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please insert any verb: ");
		String aString = input.nextLine();
		String anotherString = " to the store!";
		
		//char at [also shows length]
		for (int i = 0; i < aString.length(); i++)
		{
			System.out.println(i + "] " + aString.charAt(i));
		}
		
		//compare to
		System.out.print(aString + " compared to ZZZZ: ");
		System.out.println(aString.compareTo("ZZZZ"));
		System.out.print("ZZZZ compared to " + aString + ": " );
		System.out.println("ZZZZ".compareTo(aString));
		System.out.print(aString + " compared to AAAA: ");
		System.out.println(aString.compareTo("AAAA"));
		System.out.print("AAAA compared to " + aString + ": " );
		System.out.println("AAAA".compareTo(aString));
		System.out.print(aString + " compared to " + aString + ": ");
		System.out.println(aString.compareTo(aString));
		
		//there is also a compareToIgnoreCase if you want to be case-insensitive.
		
		//concat
		System.out.println(aString + " concatenated to " + anotherString);
		System.out.println(aString.concat(anotherString));
		
		//contains
		System.out.println("Does " + aString + " contain any letter r's? ");
		if (aString.contains("r"))
		{
			System.out.println("Yes!");
		}
		else
		{
			System.out.println("NO!");
		}
		System.out.println("Does " + aString + " contain 'wal' ? ");
		if (aString.contains("wal"))
		{
			System.out.println("Yes!");
		}
		else
		{
			System.out.println("NO!");
		}
		//no contains ignore case so if that matters, do a toUpperCase or toLowerCase
		
		//equals and equalsIgnoreCase
		System.out.println("Does " + aString + " equal " + anotherString);
		System.out.println(aString.equals(anotherString));
		System.out.println(aString.equalsIgnoreCase(anotherString));
		System.out.println(anotherString.equals(aString));
		System.out.println(anotherString.equalsIgnoreCase(aString));
		
		//formatting
		String name = "Ted";
		int age = 32;
		double price = 3.99;
		boolean isFalse = false;
		char period = '.';
		String formattedString = String.format("%s, age %d, paid $%.2f for bread%c\t%b\n"
										, name, age, price, period, isFalse);
		System.out.println(formattedString);
		
		//find the index of any character
		System.out.println("The first index of r in " + aString + " is: " 
				+ aString.indexOf('r'));
		System.out.println("The first index of g in " + aString + " is: " 
				+ aString.indexOf('g'));
		
		System.out.println("The last index of r in " + aString + " is: " 
				+ aString.lastIndexOf('r'));
		System.out.println("The last index of g in " + aString + " is: " 
				+ aString.lastIndexOf('g'));
		
		//replace
		System.out.println("Replace all 'r' chars in " + aString + " with '@' chars");
		System.out.println(aString.replace('r', '@'));
		System.out.println(aString.replace('R', '@'));
		
		//startsWith
		System.out.println("Does " + aString + " start with rev? "
				+ aString.startsWith("rev"));
		System.out.println("Does " + aString + " start with rev? "
				+ aString.toLowerCase().startsWith("rev"));
		
		
		//substring
		System.out.println("Remove the first char of a string using Substring: "
				+ aString.substring(1));
		System.out.println("Remove the last 2 chars of a String using Substring: "
				+ aString.substring(0, aString.length()-2));
		System.out.println("Get something from the middle: "
				+ aString.substring(2, 6));
		
		//toLowerCase()
		System.out.println(aString + " to UpperCase: " + aString.toLowerCase());
		
		//toUpperCase
		System.out.println(aString + " to UpperCase: " + aString.toUpperCase());
		
	}
}
