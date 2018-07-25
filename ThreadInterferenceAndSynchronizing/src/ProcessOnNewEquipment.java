
public class ProcessOnNewEquipment extends Thread 
{	
	private DataServer ds = null;
	private int sleepTime = 1000;
	private String ID = "NEW";
	
	public ProcessOnNewEquipment(DataServer d) {
		ds = d;
	}
	
	@Override
	public void run() {
		//increment 5 times with new equipment
		for (int i = 0; i < 5; i++)
		{
			ds.setCount(sleepTime, ID);
		}
		ProcessCounterGUI.addMessage("Run complete for " + ID);
	}
	
}
