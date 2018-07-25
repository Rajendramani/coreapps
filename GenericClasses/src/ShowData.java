
public class ShowData 
{
	public static void main(String[] args)
	{
		DataContainer<String> sData = new DataContainer<String>("Something");
		DataContainer<Integer> iData = new DataContainer<Integer>(0);
		
		System.out.println(sData);
		System.out.println(iData);
		
		BetterDataContainer<Integer, String> bdc1 = 
				new BetterDataContainer<Integer, String>(0, "Aardvark");
		BetterDataContainer<Integer, String> bdc2 = 
				new BetterDataContainer<Integer, String>(1, "Dog");
		
		BetterDataContainer<Integer, Animal> bdc3 = 
				new BetterDataContainer<Integer, Animal>(2, new Animal("Zebra"));
		
		BetterDataContainer<String, Animal> bdc4 = 
				new BetterDataContainer<String, Animal>("3", new Animal("Koala"));
		
		System.out.println(bdc1);
		System.out.println(bdc2);
		System.out.println(bdc3);
		System.out.println(bdc4);
		
		BestDataContainer<Animal> bdc0 = new BestDataContainer<Animal>();
		bdc0.add(new Animal("Aardvark"));
		bdc0.add(new Animal("Bear"));
		bdc0.add(new Animal("Chipmunk"));
		bdc0.add(new Animal("Dog"));
		bdc0.add(new Animal("Eagle"));
		bdc0.add(new Animal("Frog"));
		bdc0.add(new Animal("Giraffe"));
		bdc0.add(new Animal("Hedgehog"));
		bdc0.add(new Animal("Ibex"));
		bdc0.add(new Animal("Jaguar"));
		System.out.println(bdc0);
		
		bdc0.remove(3);
		bdc0.remove(new Animal("Frog"));
		System.out.println(bdc0);
		
		System.out.println(bdc0.get(5));
	}
}
