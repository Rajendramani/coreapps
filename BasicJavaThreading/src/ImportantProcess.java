
public class ImportantProcess implements Runnable {

	@Override
	public void run() {
		
		try {
			SimpleThreadingSample.txtWithThread.setText("Started");
			for (int i = 0; i < 30; i++)
			{
				Thread.sleep(1000);
				SimpleThreadingSample.txtWithThread.setText("Another cycle completed: " + i);
			}
			SimpleThreadingSample.txtWithThread.setText("Completed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

}
