package raceManagerSystem;
import javax.swing.*;

import raceManagerObjects.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RacerAddInternalFrame extends BaseInternalFrame {
	private JTextField txtRacerName;
	private JTextField txtRacerAge;
	private JTextField txtRacerID;
	private JTextField txtShoes;
	private JRadioButton rdoClipsYes;
	private JRadioButton rdoClipsNo;
	private JRadioButton rdoInjuredYes;
	private JRadioButton rdoInjuredNo;
	
	/**
	 * Create the frame.
	 */
	public RacerAddInternalFrame() {
		super();
		
		setBounds(10, 10, 508, 461);
		getContentPane().setLayout(null);
		
		JLabel lblAddingANew = new JLabel("Adding A New Racer");
		lblAddingANew.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddingANew.setBounds(20, 11, 188, 23);
		getContentPane().add(lblAddingANew);
		
		JLabel lblRacerName = new JLabel("Racer Name:");
		lblRacerName.setBounds(41, 55, 92, 14);
		getContentPane().add(lblRacerName);
		
		JLabel lblRacerAge = new JLabel("Racer Age:");
		lblRacerAge.setBounds(41, 80, 92, 14);
		getContentPane().add(lblRacerAge);
		
		JLabel lblRacerId = new JLabel("Racer ID:");
		lblRacerId.setBounds(41, 105, 92, 14);
		getContentPane().add(lblRacerId);
		
		JLabel lblIsTheRacer = new JLabel("Is the Racer Injured?");
		lblIsTheRacer.setBounds(41, 130, 143, 14);
		getContentPane().add(lblIsTheRacer);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(41, 178, 401, 161);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		tabbedPane.addTab("Runner", null, panel, null);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the brand of shoes for the Runner:");
		lblPleaseEnterThe.setBounds(21, 22, 259, 14);
		panel.add(lblPleaseEnterThe);
		
		txtShoes = new JTextField();
		txtShoes.setBounds(21, 41, 228, 20);
		panel.add(txtShoes);
		txtShoes.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		tabbedPane.addTab("Biker", null, panel_1, null);
		
		JLabel lblIsThisBiker = new JLabel("Is this Biker Using Clips?");
		lblIsThisBiker.setBounds(20, 21, 128, 14);
		panel_1.add(lblIsThisBiker);
		
		rdoClipsYes = new JRadioButton("Yes");
		rdoClipsNo = new JRadioButton("No");
		
		rdoClipsYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//rdoClipsYes
				if (rdoClipsYes.isSelected())
				{
					rdoClipsNo.setSelected(false);
				}
			}
		});
		rdoClipsYes.setBounds(156, 17, 53, 23);
		panel_1.add(rdoClipsYes);
		
		rdoClipsNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//rdoClipsNo
				if (rdoClipsNo.isSelected())
				{
					rdoClipsYes.setSelected(false);
				}
			}
		});
		rdoClipsNo.setBounds(221, 17, 61, 23);
		panel_1.add(rdoClipsNo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		tabbedPane.addTab("Swimmer", null, panel_2, null);
		
		JLabel lblThereIsNothing = new JLabel("There is nothing unique to set for the Swimmer");
		lblThereIsNothing.setBounds(27, 31, 290, 14);
		panel_2.add(lblThereIsNothing);
		
		txtRacerName = new JTextField();
		txtRacerName.setBounds(173, 52, 269, 20);
		getContentPane().add(txtRacerName);
		txtRacerName.setColumns(10);
		
		txtRacerAge = new JTextField();
		txtRacerAge.setColumns(10);
		txtRacerAge.setBounds(173, 77, 269, 20);
		getContentPane().add(txtRacerAge);
		
		txtRacerID = new JTextField();
		txtRacerID.setColumns(10);
		txtRacerID.setBounds(173, 102, 269, 20);
		getContentPane().add(txtRacerID);
		
		
		
		rdoInjuredYes = new JRadioButton("Yes");
		rdoInjuredNo = new JRadioButton("No");
		
		rdoInjuredYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdoInjuredYes.isSelected())
				{
					rdoInjuredNo.setSelected(false);
				}
			}
		});
		rdoInjuredYes.setBounds(173, 126, 109, 23);
		getContentPane().add(rdoInjuredYes);
		
		rdoInjuredNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdoInjuredNo.isSelected())
				{
					rdoInjuredYes.setSelected(false);
				}
			}
		});
		rdoInjuredNo.setBounds(292, 126, 109, 23);
		getContentPane().add(rdoInjuredNo);
		
		JButton btnAddRacer = new JButton("Add");
		
		btnAddRacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//add the racer
				Athlete a = null;
				String shoes = null;
				Boolean usesClips = false;
				//determine what type of racer is selected
				int selTab = tabbedPane.getSelectedIndex();
				switch(selTab)
				{
					case 0:
						a = new Runner();
						shoes = txtShoes.getText();
						break;
					case 1:
						a = new Biker();
						usesClips = rdoClipsYes.isSelected();
						break;
					case 2:
						a = new Swimmer();
						break;
					default:
						break;
				}
				if (a != null)
				{
					a.setName(txtRacerName.getText());
					a.setAge(Integer.parseInt(txtRacerAge.getText()));
					a.setIsInjured(rdoInjuredYes.isSelected());
					a.setRacerId(Integer.parseInt(txtRacerID.getText()));
					if (a instanceof Runner)
					{
						((Runner) a).setShoeBrand(shoes);
					}
					else if (a instanceof Biker)
					{
						((Biker) a).setUsingClips(usesClips);
					}
					
					RaceManager._isr.addRacer(a);
					JOptionPane.showMessageDialog(null, "Successfully added the racer: " + a.getName());
					ResetForm();
				}
			}
		});
		btnAddRacer.setBounds(353, 350, 89, 23);
		getContentPane().add(btnAddRacer);

	}
	
	private void ResetForm()
	{
		txtRacerName.setText("");
		txtRacerAge.setText("");
		txtShoes.setText("");
		txtRacerID.setText("");
		rdoClipsNo.setSelected(false);
		rdoClipsYes.setSelected(false);
		rdoInjuredNo.setSelected(false);
		rdoInjuredYes.setSelected(false);
	}
}
