
public class UsingTheStringBuilder 
{
	public static void main(String[] args)
	{
		//up to this point, most likely Strings
		//have been concatenated in one of two ways
		//1) Using the "+" operator
		String one = "Welcome to";
		String two = "Java programming";
		String result1 = one + " " + two;
		System.out.println(result1);
		
		//2) Using a String.format
		String result2 = String.format("%s %s"
										, one
										, two);
		System.out.println(result2);
				
		//The good news is that Java has optimized
		//the + symbol for concatenation, since
		//Strings are immutable, resizing would cost
		//a lot of overhead.  However, in a loop, the "+"
		//is not optimized, and running a new String.format
		//will not be as desirable because of the time it
		//takes to parse the formatting String.
		
		//Therefore we can use StringBuilder,
		//but in a straight situation like this it's not
		//an advantage.
		StringBuilder sb = new StringBuilder();
		sb.append(one);
		sb.append(" ");
		sb.append(two);
		System.out.println(sb.toString());
		
		//There is a also a StringBuffer, but it is slower than
		//StringBuilder because it was thread safe.
		//so the only time you should use it is if you
		//need to keep things synchronized across threads.
		StringBuffer sb2 = new StringBuffer();
		sb2.append(one);
		sb2.append(" ");
		sb2.append(two);
		System.out.println(sb2.toString());
		
		//therefore the best time to use a StringBuilder is
		//in a non thread-safe loop
		sb = new StringBuilder();
		for (int i = 0; i < 1000; i++)
		{
			sb.append(i);
			sb.append("] ");
			sb.append("completed");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
