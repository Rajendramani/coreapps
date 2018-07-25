import java.util.Iterator;


public class Zoo 
{

	public static void main(String[] args)
	{
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
		
		//you can't do this because our original structure was not iterable!
		/*
		for (Animal a : bdc0)
		{
			
		}
		*/
		
		//you can do this:
		IterableBestDataContainer<Animal> bdc1 = new IterableBestDataContainer<Animal>();
		bdc1.add(new Animal("Aardvark"));
		bdc1.add(new Animal("Bear"));
		bdc1.add(new Animal("Chipmunk"));
		bdc1.add(new Animal("Dog"));
		bdc1.add(new Animal("Eagle"));
		bdc1.add(new Animal("Frog"));
		bdc1.add(new Animal("Giraffe"));
		bdc1.add(new Animal("Hedgehog"));
		bdc1.add(new Animal("Ibex"));
		bdc1.add(new Animal("Jaguar"));
		
		for (Animal a : bdc1)
		{
			System.out.println(a);
		}
		
		//we can also just get the iterator and use it directly
		for (Iterator<Animal> itr = bdc1.iterator(); itr.hasNext(); )
		{
			//we have a for loop that is getting the iterator and going while itr.hasNext().
			
			//to get out of the loop we have to actually call to next
			Animal a = itr.next();
			System.out.println(a);
			
			if (a.getName().equals("Dog"))
			{
				itr.remove();
				//try to call itr.remove() again...
				//itr.remove();
			}
		}
		
		for (Animal a : bdc1)
		{
			System.out.println(a);
		}
		
		//and we can get an iterator at position based on how this was created (as long as position is valid)
		Iterator<Animal> itr = bdc1.iterator(3);
		//move a couple of places
		if (itr.hasNext()) itr.next();
		if (itr.hasNext()) itr.next();
		itr.remove();
		
		for (Animal a : bdc1)
		{
			System.out.println(a);
		}
		
	}
	
}
