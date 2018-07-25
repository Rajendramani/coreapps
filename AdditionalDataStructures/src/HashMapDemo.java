import java.util.HashMap;

import Utilities.StringGenerator;


public class HashMapDemo {
	public void showOperations()
	{
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(0, "White");
		hm.put(1, "Red");
		hm.put(2, "Orange");
		hm.put(3, "Yellow");
		hm.put(4, "Green");
		hm.put(5, "Blue");
		hm.put(6, "Indigo");
		hm.put(7, "Violet");
		hm.put(8, "Black");
		
		//loop on keyset size
		for (int i = 0; i < hm.keySet().size(); i++)
		{
			//get by key
			System.out.println(hm.get(i)); //where i matches Key
		}
		//loop on hm size:
		System.out.println(StringGenerator.stars());
		for (int i = 0; i < hm.size(); i++)
		{
			//get by key with default if not there:
			System.out.println(hm.getOrDefault(i*2, "Not Present"));
		}
		//loop on values collection
		System.out.println(StringGenerator.stars());
		for (String s : hm.values())
		{
			//just print out value
			System.out.println("Next Value: " + s);
		}
		
		HashMap<String, Integer> hm2 = new HashMap<String, Integer>();
		hm2.put("Red", 0);
		hm2.put("Yellow", 1);
		hm2.put("Green", 2);
		System.out.println(StringGenerator.stars());
		for (Integer i : hm2.values())
		{
			System.out.println("Next Value: " + i);
		}
		
		//remove and replace (only replaces if exists)
		hm2.remove("Yellow");
		hm2.replace("Green", 3);
		hm2.replace("Golden", -10);
		System.out.println(StringGenerator.stars());
		for (Integer i : hm2.values())
		{
			System.out.println("Next Value: " + i);
		}
		
		System.out.println(StringGenerator.stars());
		System.out.println("Contains key 1: " + hm.containsKey(1));
		if (hm2.containsKey("Red"))
		{
			System.out.println("Red: " + hm2.get("Red"));
		}
		if (hm2.containsValue(3))
		{
			System.out.println("Value is present!");
		}
	}
}
