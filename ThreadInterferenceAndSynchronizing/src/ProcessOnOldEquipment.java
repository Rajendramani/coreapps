
public class ProcessOnOldEquipment implements Runnable {

	private DataServer ds = null;
	private int sleepTime = 2000;
	private String ID = "OLD";
	
	public ProcessOnOldEquipment(DataServer d) {
		ds = d;
	}
	
	@Override
	public void run() {
		//execute 5 times with old equipment
		for (int i = 0; i < 5; i++)
		{
			ds.setCount(sleepTime, ID);
		}
		ProcessCounterGUI.addMessage("Run complete for " + ID);
		
	}

}
