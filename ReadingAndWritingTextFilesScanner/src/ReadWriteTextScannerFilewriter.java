import java.io.*;
import java.nio.CharBuffer;
import java.util.*;


public class ReadWriteTextScannerFilewriter 
{
	public static final String inputPath = "C:\\JavaProjects\\"
			+ "ReadingAndWritingTextFilesScanner\\src\\Racers.txt";
	public static final String outputPath = "C:\\JavaProjects\\"
			+ "ReadingAndWritingTextFilesScanner\\src\\RacersModified.txt";
	
	public static void main(String[] args)
	{
		File inputFile = new File(inputPath);
		Scanner input = null;
		
		FileWriter fw = null;
		
		ArrayList<String> racers = new ArrayList<String>();
		try
		{
			//open a file using the Scanner object:
			input = new Scanner(inputFile);
			while (input.hasNextLine())
			{
				String nextRacer = input.nextLine();
				//add the racer
				racers.add(nextRacer);
				//print out each racer added
				System.out.println(nextRacer + " added...");	
			}	
			if (input != null)
			{
				input.close();
				input = null;
			}
			
			//write to a file using the Scanner object:
			fw = new FileWriter(outputPath);
			Random r = new Random();
			int max = 85;
			int min = 18;
			for (String s : racers)
			{
				//let's assign a random age to each racer
				//and then we'll save the data to a new file "RacersModified"
				int age = r.nextInt((max - min)) + min + 1;  //0 based
				
				String output = s + "|" + age + "\n";
				fw.write(output);
			}
		}
		catch (IOException ioex)
		{
			ioex.printStackTrace();
		}
		finally
		{
			if (fw != null)
			{
				try {
					fw.close();
					fw = null;
				} catch (IOException ioex2) {
					// TODO Auto-generated catch block
					ioex2.printStackTrace();
				}
			}
		}
	}
}
