import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;


public class CreditProcessingSystem {

	public static String dataFilePath = "C:\\JavaProjects\\RandomAccessFiles"
										+ "\\src\\CreditProcessingData.dat";
	public static final int RECORD_LENGTH = 16;
	
	public static void main(String[] args)
	{
		//first, if a file exists, lets load it up.
		//otherwise, we'll just start with a new one:
		RandomAccessFile cData = null;
		try
		{
			//open the file for read/write
			cData = new RandomAccessFile(dataFilePath, "rw");
			boolean done = false;
			Scanner input = new Scanner(System.in);
			//user interaction
			while (!done)
			{
				int choice = printMenu();
				long ccNum;
				int position;
				
				switch(choice)
				{
					case 1:
						//add a new card to the end of the file
						CreditCard cc = getNewCardDetails();
						cData.seek(cData.length());
						cData.writeLong(cc.getCreditCardNumber());
						cData.writeDouble(cc.getBalance());
						System.out.println(cc.toString() + " added to the system.");
						break;
					case 2:
						//find and view 
						System.out.println("Please enter the 16-digit number of the card to view:");
						ccNum = Long.parseLong(input.nextLine());
						position = findCardPosition(ccNum, cData);
						if (position >= 0)
						{
							System.out.println("");
							displayCardDetails(position, cData);
							System.out.println("");
						}
						else
						{
							System.out.println("No card with that number found.");
						}
						break;
					case 3:
						//update card details
						System.out.println("Please enter the 16-digit number of the card to view:");
						ccNum = Long.parseLong(input.nextLine());
						position = findCardPosition(ccNum, cData);
						
						if (position >= 0)
						{
							double newBalance = getBalance();
							if (newBalance >= 0.0)
							{
								//move pointer and overwrite at position
								cData.seek(position * RECORD_LENGTH);
								cData.writeLong(ccNum);
								cData.writeDouble(newBalance);
								System.out.println("Updated: " + ccNum + " to balance $" + newBalance);
							}
						}
						else
						{
							System.out.println("No card with that number found.");
						}
						break;
					case 4:
						//list all data
						System.out.println("");
						long totalRecords = cData.length() / RECORD_LENGTH;
						if (totalRecords == 0)
						{
							System.out.println("No current cards on file.");
						}
						else
						{
							for (int i = 0; i < totalRecords; i++)
							{
								displayCardDetails(i, cData);
							}
						}
						System.out.println("");
						break;
					case 5:
					default:
						done = true;
						break;
				}
			}
			
			System.out.println("Thank you for using the credit card manager");
		}
		catch (IOException ioex)
		{
			ioex.printStackTrace();
		}
		finally
		{
			if (cData != null)
			{
				try {
					cData.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static int printMenu()
	{
		Scanner menuInput = new Scanner(System.in);
		System.out.println("Please select from the following choices:");
		System.out.println("Enter 1 for adding a new credit card");
		System.out.println("Enter 2 for viewing details of a credit card");
		System.out.println("Enter 3 to update card details");
		System.out.println("Enter 4 to list all cards and balances");
		System.out.println("Enter 5 to quit");
		return Integer.parseInt(menuInput.nextLine());
	}
	
	private static CreditCard getNewCardDetails()
	{
		CreditCard cc = new CreditCard();
		cc.setCreditCardNumber(getCardNumber());
		cc.setBalance(getBalance());
		return cc;
	}
	
	private static long getCardNumber()
	{
		Scanner getNumber = new Scanner(System.in);
		String matchPattern = "[0-9]{16}";
		boolean valid = false;
		
		while(!valid)
		{
			System.out.println("Please enter a valid 16-digit credit card number:");
			String userNum = getNumber.nextLine();
			valid = userNum.matches(matchPattern);
			//really we should make sure not used too, but not going to worry about it.
			if (valid)
			{
				return Long.parseLong(userNum);
			}
		}
		return -1;
	}
	
	private static double getBalance()
	{
		Scanner getBalance = new Scanner(System.in);
		System.out.println("Please enter the current card balance:");
		return Double.parseDouble(getBalance.nextLine());
	}

	private static int findCardPosition(long cardNumber, RandomAccessFile f) throws IOException
	{
		
		//record length = long[8 bytes] + double[8 bytes]
		long totalRecords = f.length() / RECORD_LENGTH;  
		
		for (int i = 0; i < totalRecords; i++)
		{
			f.seek(i * RECORD_LENGTH);  //move to the start of the next record
			//get the next card number
			long ccNum = f.readLong();
			//if is a match, return i
			if (ccNum == cardNumber)
			{
				return i;
			}
		}
		//if no match, return -1
		return -1;
	}
	
	private static void displayCardDetails(int position, RandomAccessFile f) throws IOException
	{
		f.seek(position * RECORD_LENGTH);
		CreditCard cc = new CreditCard(f.readLong(), f.readDouble());
		System.out.println("Card Details: " + cc.toString());
	}

}
