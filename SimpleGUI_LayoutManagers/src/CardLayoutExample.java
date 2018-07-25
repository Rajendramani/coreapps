import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CardLayoutExample extends JFrame implements ItemListener
{
	JPanel panelCards = null;
	private final String CARD_ONE = "Card One";
	private final String CARD_TWO = "Card Two";
	
	public CardLayoutExample()
	{
		//create a panel
		JPanel jp = new JPanel();
		
		String[] cardDetails = new String[2];
		cardDetails[0] = CARD_ONE;
		cardDetails[1] = CARD_TWO;
		JComboBox jcb = new JComboBox(cardDetails);
		jcb.setEditable(false);
		jcb.addItemListener(this);
		jp.add(jcb);
		
		JPanel c1 = new JPanel();
		c1.add(new JButton("Press Me"));
		c1.add(new JTextField("Some Text Here"));
		
		JPanel c2 = new JPanel();
		c2.add(new JLabel("Enter your name: "));
		c2.add(new JButton("Press me Instead"));
		
		panelCards = new JPanel(new CardLayout());
		panelCards.add(c1, CARD_ONE);
		panelCards.add(c2, CARD_TWO);
		
		jp.add(panelCards);
		
		this.getContentPane().add(jp);
		this.setLocation(250,250);
		this.setSize(GUIProgram.width+20,GUIProgram.height+60);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Card Layout");
		this.setBounds(0, 0, GUIProgram.width+20,GUIProgram.height+60);
		this.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		CardLayout cl = (CardLayout)(panelCards.getLayout());
        cl.show(panelCards, (String)arg0.getItem());
	}
}
