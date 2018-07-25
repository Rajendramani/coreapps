package Utilities;

import java.util.Random;

public class StringGenerator 
{
	private static final int MIN_VAL = 65;
	private static final int MAX_VAL = 91;
	private static final int STRING_LEN = 10;
	private static final int CHAR_COUNT = 50;
	
	public static String generateRandomString(int start)
	{
		int range = MAX_VAL - MIN_VAL;
		Random r = new Random();
		StringBuilder sb = new StringBuilder("");
		int iterationStart = 1;
		if (start > 0) 
		{
			sb.append(Character.toString((char)start));
		}
		else
		{
			iterationStart = 0;
		}
		
		for (int i = iterationStart; i < STRING_LEN; i++)
		{
			int nextChar = r.nextInt(range-1) + MIN_VAL;
			sb.append(Character.toString((char)nextChar));
		}
		
		return sb.toString();
	}
	
	
	public static String stars()
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < CHAR_COUNT; i++)
		{
			sb.append("*");
		}
		return sb.toString();
	}
	
}
