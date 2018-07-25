
public class SynchronizedDataServer implements DataServer
{
	private int executionCount;
	
	public SynchronizedDataServer()
	{
		executionCount = 0;
	}

	public synchronized void setCount(int sleepTime, String ID) {
		int tempExecCount = executionCount;
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tempExecCount++;
		executionCount = tempExecCount;
		ProcessCounterGUI.setExecutionText(executionCount + "");
		ProcessCounterGUI.addMessage("Execution Count set to " 
				+ executionCount + " by " + ID);
	}
	
	
}
