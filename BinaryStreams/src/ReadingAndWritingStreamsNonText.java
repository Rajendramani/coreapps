import java.io.*;
import java.util.Scanner;


public class ReadingAndWritingStreamsNonText 
{
	public static String imgFilePath = "C:\\JavaProjects\\BinaryStreams\\src\\MIM_BINARY_MEME.jpg";
	public static String imgFilePath2 = "C:\\JavaProjects\\BinaryStreams\\src\\data.bin";
	public static String imgFilePath3 = "C:\\JavaProjects\\BinaryStreams\\src\\MIM_BINARY_MEME_Decrypted.jpg";
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a shift to encrypt/decrypt the file:");
		int shift = Integer.parseInt(input.nextLine());
		
		try
		{
			FileInputStream fis = null;
			FileOutputStream fos = null;
			PrintStream ps = null;
			
			if (shift > 0)
			{
				fis = new FileInputStream(imgFilePath);
				fos = new FileOutputStream(imgFilePath2);
				ps = new PrintStream(fos);
			}
			else
			{
				fis = new FileInputStream(imgFilePath2);
				fos = new FileOutputStream(imgFilePath3);
				ps = new PrintStream(fos);
			}
			
			boolean done = false;
	        while (!done)
	        {
	        	//read in the file
	            int next = fis.read();
	            if (next == -1)
	            {
	                done = true;
	            }
	            else
	            {
	            	//encrypt or decrypt based on shift
	            	ps.write(((byte) next) + shift);
	            }
	        }
	        
	        ps.close();
	        ps = null;
	        fos.close();
	        fos = null;
	        fis.close();
	        fis = null;
		}
		catch (IOException ioex)
		{
			ioex.printStackTrace();
		}
		System.out.println("Operation Completed");
	}
}
