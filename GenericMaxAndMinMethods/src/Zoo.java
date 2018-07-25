
public class Zoo 
{

	public static void main(String[] args)
	{
		BestDataContainer<Animal> bdc0 = new BestDataContainer<Animal>();
		bdc0.add(new Animal("Chipmunk"));
		bdc0.add(new Animal("Aardvark"));
		bdc0.add(new Animal("Hedgehog"));
		bdc0.add(new Animal("Dog"));
		bdc0.add(new Animal("Ibex"));
		bdc0.add(new Animal("Frog"));
		bdc0.add(new Animal("Giraffe"));
		bdc0.add(new Animal("Eagle"));
		bdc0.add(new Animal("Jaguar"));
		bdc0.add(new Animal("Bear"));
		
		System.out.println(bdc0);
		System.out.println("*********************************");
		
		System.out.println("MAX: " + bdc0.getMax());
		System.out.println("MIN: " + bdc0.getMin());
	}
	
}
