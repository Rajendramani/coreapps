import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

@SuppressWarnings("serial")
public class BaseInternalFrame extends JInternalFrame
{
	public BaseInternalFrame()
	{
		SetupForm();
	}
	
	/**
     * Common Setup features for all of our forms.
     */
    private void SetupForm()
    {
        setBackground(Color.WHITE);
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        
        
        //pack and show:
        pack();
        setVisible(true);
    }
}
