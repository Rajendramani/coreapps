import java.io.*;
import java.util.ArrayList;

public class ReadingAndWritingStreams 
{
	public static String inFilePath = "C:\\JavaProjects\\BinaryStreams\\src\\MyData.dat";
	public static String outFilePath = "C:\\JavaProjects\\BinaryStreams\\src\\MyDataR.dat";
	
	public static void main(String[] args)
	{
		try
		{
			//reading and writing text to files using streams
			//is possible, but not the best use of resources
			//basically, all files can be read at the binary level
			File inFile = new File(inFilePath);
			FileInputStream fis = new FileInputStream(inFile);
			InputStreamReader ir = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(ir);
			ArrayList<String> lines = new ArrayList<String>();
			String nextLine = null;
			while ((nextLine = br.readLine()) != null)
			{
				lines.add(nextLine);
			}
			
			br.close();
			br = null;
			ir.close();
			ir =null;
			fis.close();
			fis = null;
			
			File outFile = new File(outFilePath);
			FileOutputStream fos = new FileOutputStream(outFile);
			PrintStream ps = new PrintStream(fos);
			for (String s : lines)
			{
				StringBuilder sb = new StringBuilder(s);
				ps.println(sb.reverse().toString());
			}
			ps.close();
			ps = null;
			fos.close();
			fos = null;
			
		}
		catch (IOException ioex)
		{
			ioex.printStackTrace();
		}
	}
}
