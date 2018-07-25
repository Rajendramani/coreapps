import javax.swing.JTextField;


public class JTextFieldExample extends JTextField
{

	public JTextFieldExample(String text, int width)
	{
		super(text);
		setColumns(width);
	}
}
