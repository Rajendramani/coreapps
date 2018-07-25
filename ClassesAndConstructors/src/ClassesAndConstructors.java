
public class ClassesAndConstructors {
	public static void main(String[] args) {
		//create a new runner
		Runner r = new Runner();
		
		//create a new swimmer (default)
		Swimmer s = new Swimmer();
		
		//create a new swimmer (explicit)
		Swimmer s2 = new Swimmer(235971);
		
		System.out.println(r);
		System.out.println(s);
		System.out.println(s2);
	}
}
