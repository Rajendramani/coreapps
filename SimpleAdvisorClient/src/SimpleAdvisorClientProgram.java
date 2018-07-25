import java.awt.EventQueue;
import javax.swing.JFrame;

public class SimpleAdvisorClientProgram {
	public static void main(String[] args0)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleAdvisorClientForm frame = new SimpleAdvisorClientForm();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100,100,500,450);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
