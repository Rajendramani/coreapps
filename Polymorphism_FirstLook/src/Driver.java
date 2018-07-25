
public class Driver {
	public static void main(String[] args) 
	{
		//Working with arrays/lists, we've seen you can't mix types
		String[] words = new String[4];
		int [] numbers = new int[4];
		
		//can do this:
		words[0] = "The";
		words[1] = "Infinite Skills";
		words[2] = "Animal System Version: ";
		//can't do this:
		//words[3] = 2.0;
		
		//can do this:
		numbers[0] = 7;
		numbers[1] = 15;
		numbers[2] = 19;
		//can't do this:
		//numbers[3] = "21"; 
		
		//so we build objects and store them in arrays/lists
		//but here is the cool part: we can store any 
		//super/subclass objects as the superclass type
		//with implicit upcasting
		Animal[] myPets = new Animal[5];
		Dog d = new Dog("Fido", "Black Lab", false);
		Cat c = new Cat("Fluffy", "Persian", true);
		myPets[0] = d;
	    myPets[1] = new Dog("Woofy", "German Shepherd", true);
	    myPets[2] = c;
	    myPets[3] = new Cat("Spot", "Siamese", false);
	    myPets[4] = new Animal("Tank", "Turtle");
		
		//and now we can print out all the details using a loop:
	    for (Animal a : myPets)
	    {
	    	System.out.println(a);
	    }
	    //that's great, but how does it know what to print out
	    //if we're casting them to Animals? -- the "underlying"
	    //type is really a Dog or Cat, so the object's toString()
	    //is called.  If it's an animal, the toString() for animal 
	    //is called on that specific object.
	    
	    //for reference: 
	    //myPets[0] = dog
	    //myPets[2] = cat

	    //and since it really knows they are a Cat or Dog, we should be
	    //able to do this, right?:

	    myPets[0].setBreed("Vizsla");
	    //myPets[0].setIsAServiceAnimal(true);
	    //myPets[2].setIsDeclawed(true);
	    
	    //but we can't, so how do we do it?
	    //we can use a downcast to get the more specific type:
	    ((Dog)myPets[0]).setIsAServiceAnimal(true);
	    ((Cat)myPets[2]).setIsDeclawed(true);
	    
	    //but what if animal[2] is not a cat? and we don't want
	    //to write code that is this tightly coupled, do we?
	    //NO! and in fact, this is an error:
	    //((Cat)myPets[0]).setIsDeclawed(false);
	    //==> ClassCastException!
	    
	    //so, let's fix both problems using 'instanceof'
	    for (Animal a : myPets)
	    {
	    	if (a instanceof Dog)
	    	{
	    		Dog myPetDog = (Dog)a;
	    		myPetDog.setIsAServiceAnimal(true);
	    		System.out.println("Set " + a.getName() + "'s value for"
	    				+ " is a service animal to false.");
	    	}
	    	else if (a instanceof Cat)
	    	{
	    		Cat myPetCat = (Cat)a;
	    		myPetCat.setIsDeclawed(false);
	    		System.out.println("Set " + myPetCat.getName() + "'s value"
	    				+ " for is declawed to false.");
	    	}
	    
	    	System.out.println(a);
	    }
	    
	}
}
