import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class CreditProcessingSystem 
{
	public static String dataFilePath = "C:\\JavaProjects\\BinaryStateFiles"
			+ "\\src\\CreditProcessingData.bin";
	
	public static void main(String[] args)
	{	
		boolean done = false;
		Scanner input = new Scanner(System.in);
		//use a list to manage all the current cards in the system
		ArrayList<CreditCard> cards = null;
		CreditCard cc = null;
		
		//user interaction
		while (!done)
		{
			int choice = printMenu();
			long ccNum;
			int position;
			
			switch(choice)
			{
				case 1:
					if (cards == null)
					{
						cards = new ArrayList<CreditCard>();
					}
					//add a new card to the list
					cc = getNewCardDetails();
					//we should validate the card and make sure it's not already in the system...
					//but for simplicity, going to ignore this
					if (cc != null)
					{
						cards.add(cc);
						System.out.println(cc.toString() + " added to the system.");
					}
					break;
				case 2:
					if (cards == null || cards.size() == 0)
					{
						System.out.println("There are currently no cards in the system.");
					}
					else
					{
						//find and view 
						System.out.println("Please enter the 16-digit number of the card to view:");
						cc = findCard(Long.parseLong(input.nextLine()), cards);
						if (cc != null)
						{
							displayCardDetails(cc);
						}
						else
						{
							System.out.println("No card with that number found.");
						}
					}
					break;
				case 3:
					if (cards == null || cards.size() == 0)
					{
						System.out.println("There are currently no cards in the system.");
					}
					else
					{
						//update card details
						System.out.println("Please enter the 16-digit number of the card to view:");
						cc = findCard(Long.parseLong(input.nextLine()), cards);
						
						if (cc != null)
						{
							cc.setBalance(getBalance());
						}
						else
						{
							System.out.println("No card with that number found.");
						}
					}
					break;
				case 4:
					//list all data
					if (cards!= null && cards.size() > 0)
					{
						System.out.println("");
						
						for (CreditCard c : cards)
						{
							displayCardDetails(c);
						}
						System.out.println("");
					}
					else
					{
						System.out.println("No Cards in the system at this time");
					}
					break;
				case 5:
					//load existing data from file
					cards = loadCardDataFromFile();
					System.out.println("Loaded " + cards.size() + " cards from file into the system.");
					break;
				case 6:
					//save data to file
					saveCardDataToFile(cards);
					System.out.println("Saved: " + cards.size() + " cards to file from the system.");
					break;
				case 7:
				default:
					done = true;
					break;
			}
		}
		
		System.out.println("Thank you for using the credit card manager");
	}
	
	private static int printMenu()
	{
		Scanner menuInput = new Scanner(System.in);
		System.out.println("Please select from the following choices:");
		System.out.println("Enter 1 for adding a new credit card");
		System.out.println("Enter 2 for viewing details of a credit card");
		System.out.println("Enter 3 to update card details");
		System.out.println("Enter 4 to list all cards and balances");
		System.out.println("Enter 5 to load existing data");
		System.out.println("Enter 6 to save data to file");
		System.out.println("Enter 7 to quit");
		return Integer.parseInt(menuInput.nextLine());
	}
	
	private static CreditCard getNewCardDetails()
	{
		CreditCard cc = new CreditCard();
		cc.setCreditCardNumber(getCardNumber());
		cc.setBalance(getBalance());
		return cc;
	}
	
	private static CreditCard findCard(long cardNum, ArrayList<CreditCard> cards)
	{
		for (CreditCard c : cards)
		{
			if (c.getCreditCardNumber() == cardNum)
			{
				return c;
			}
		}
		return null;
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
	
	private static void displayCardDetails(CreditCard cc)
	{
		System.out.println("Card Details: " + cc.toString());
	}

	private static ArrayList<CreditCard> loadCardDataFromFile()
	{
		ArrayList<CreditCard> cards = null;
		try
		{
			//here we'll read the entire array list object from the file
			FileInputStream fis = new FileInputStream(dataFilePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
        	cards = (ArrayList<CreditCard>)ois.readObject();
        	ois.close();
        	ois = null;
        	fis.close();
        	fis = null;
		}
		catch (Exception ex)
		{
			//IO Exception or ClassCastException
			ex.printStackTrace();
		}
		return cards;
	}
	
	private static void saveCardDataToFile(ArrayList<CreditCard> cards)
	{
		try
		{
			//here we'll store the entire arraylist object to the data file
			FileOutputStream fos = new FileOutputStream(dataFilePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cards);
		}
		catch (IOException ioex)
		{
			//here we only have to worry about file io exceptions
			ioex.printStackTrace();
		}
	}
}
