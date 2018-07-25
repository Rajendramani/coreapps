import CustomObjects.Person;


public class SyntaxAndBeginningLambdas 
{
	//SYNTAX EXPLANATION:
	/*
		//Just like any assignment, we have a type and a variable:
		<type> var =
		//then we have a change - [Optional] arguments
		<type> var = ([Optional, Arguments, Go, Here])
		//and next: a 'Pointer' -> we can say "Points To" or "Maps To" would be more accurate
		<type> var = ([optional args]) -> 
		//finally, we have some { expression(s) } which uses optional arguments if provided
		//as an 'anonymous' function:
		<type> var = ([optional args]) -> { 
					//code statements here 
		};
	 */
	public static void main(String[] args)
	{
		//A very simple lambda expression:
		Runnable r1 = () -> System.out.println("This is my first functional expression!");
		r1.run();
		r1.run();
		r1.run();
		
		//use the common printer
		CommonPrinter.r1.run();
		CommonPrinter.r1.run();
		CommonPrinter.r1.run();
		
		//create a common interface/format pair to get String 
		//print it to  the console
		System.out.println(CommonPrinter.fs.format("If you want to do this, you certainly can!"));
		
		//Create a common interface/format pair to print anything:
		CommonPrinter.po.printConsole("Any Object works!");
		CommonPrinter.po.printConsole(50);
		CommonPrinter.po.printConsole(true);
		CommonPrinter.po.printConsole(new Person("John", "Smith", 48));
		
		//we can stack functional expressions, 
		//if they have the right signatures
		CommonPrinter.po.printConsole(CommonPrinter.fs.format("My String is"));
		CommonPrinter.po.printConsole(CommonPrinter.fs.format("able to be formatted twice!"));
	}
}
