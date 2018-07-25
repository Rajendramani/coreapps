import java.util.*;
import Utilities.StringGenerator;

public class Driver 
{
	public static void main(String[] args)
	{
		printMenu();
		Scanner input = new Scanner(System.in);
		int choice = Integer.parseInt(input.nextLine());
		
		switch (choice)
		{
			case 1:
				System.out.println("Linked List");
				LinkedListDemo lld = new LinkedListDemo();
				lld.showOperations();
				break;
			case 2:
				System.out.println("Stack");
				StackDemo sd = new StackDemo();
				sd.showOperations();
				break;
			case 3:
				System.out.println("Queue");
				QueueDemo qd = new QueueDemo();
				qd.showOperations();
				break;
			case 4:
				System.out.println("Vector");
				VectorDemo vd = new VectorDemo();
				vd.showOperations();
				break;
			case 5:
				System.out.println("HashMap");
				HashMapDemo hmd = new HashMapDemo();
				hmd.showOperations();
				break;
		}
	}
	
	public static void printMenu()
	{
		System.out.println(StringGenerator.stars());
		System.out.println("Please enter 1 for the Linked List");
		System.out.println("Please enter 2 for the Stack");
		System.out.println("Please enter 3 for the Queue");
		System.out.println("Please enter 4 for the Vector");
		System.out.println("Please enter 5 for the HashMap");
		System.out.println(StringGenerator.stars());
	}
}
