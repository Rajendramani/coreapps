import java.io.*;
import java.util.*;


public class FileProcessor 
{
	public static void main(String[] args)
	{
		String invalid = null;
		Validate.StringHasContent(invalid);
		Validate.StringHasContentChecked(invalid);
		
		String path = "C:\\JavaProjects\\CheckedExceptions\\src\\data.txt";
		File f = new File(path);
		Scanner input = new Scanner(f);
		int count = 0;
		while (input.hasNextLine())
		{
			System.out.println(input.nextLine());
			count++;
		}
		
		input.close();
		
		FileWriter fw = new FileWriter(path, true);
		fw.write("I have modified the data " + (count -1) + " times!\n");
		fw.close();
		
	}
}
