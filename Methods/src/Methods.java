
public class Methods {
	public static void main(String[] args)
	{
		//create a new runner
		Runner r = new Runner();
		r.setRaceID(146720);
		
		//create a new swimmer (default)
		Swimmer s = new Swimmer();
		s.setRaceID(726198);
		
		//create a new swimmer (explicit)
		Swimmer s2 = new Swimmer(235971);
		
		System.out.println(r);
		System.out.println(s);
		System.out.println(s2);
		
		//NSE
		System.out.println("X equals Y? " + Utilities.nullSafeEquals("X", "Y"));
	
		
	}
}
