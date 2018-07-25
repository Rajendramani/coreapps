import java.util.Scanner;


public class GUIProgram 
{
    public static final int width = 640;
    public static final int height = 480;
    
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		System.out.println("Enter 1 for BorderLayout Demo");
		System.out.println("Enter 2 for BoxLayout Demo");
		System.out.println("Enter 3 for CardLayout Demo");
		System.out.println("Enter 4 for FlowLayout Demo");
		System.out.println("Enter 5 for GridLayout Demo");
		int choice = Integer.parseInt(input.nextLine());
		
		BorderLayoutExample ble = null;
		BoxLayoutExample boxle = null;
		CardLayoutExample cle = null;
		FlowLayoutExample fle = null;
		GridLayoutExample gle = null;
		switch(choice)
		{
			case 1:
				ble = new BorderLayoutExample();
				break;
			case 2:
				boxle = new BoxLayoutExample();
				break;
			case 3:
				cle = new CardLayoutExample();
				break;
			case 4:
				fle = new FlowLayoutExample();
				break;
			case 5:
				gle = new GridLayoutExample();
				break;
			default:
				break;
		}
	}
}
