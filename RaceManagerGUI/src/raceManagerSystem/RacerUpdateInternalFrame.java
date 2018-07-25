package raceManagerSystem;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import raceManagerObjects.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class RacerUpdateInternalFrame extends BaseInternalFrame {
	private ArrayList<Athlete> racers;
	private JComboBox cboRacers;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtRacerID;
	private JTextField txtShoes;
	private JRadioButton rdoClipsYes;
	private JRadioButton rdoClipsNo;
	private JRadioButton rdoInjuredYes;
	private JRadioButton rdoInjuredNo;
	
	/**
	 * Create the frame.
	 */
	public RacerUpdateInternalFrame() 
	{
		super();
		setBounds(10, 10, 568, 474);
		getContentPane().setLayout(null);
		
		rdoClipsYes = new JRadioButton("Yes");
		rdoClipsNo = new JRadioButton("No");
		rdoInjuredYes = new JRadioButton("Yes");
		rdoInjuredNo = new JRadioButton("No");
		
		cboRacers = new JComboBox();
		
		cboRacers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//what racer was selected?
				if (cboRacers.getItemCount() > 0)
				{
					resetDefault();
					String selected = cboRacers.getSelectedItem().toString();
					//JOptionPane.showMessageDialog(null, "Selected Racer: " + selected);
					
					if (selected.contains("|"))
					{
						String[] values = selected.split("\\|");
						Athlete a = getRacer(Integer.parseInt(values[0]));
						if (a != null)
						{
							txtName.setText(a.getName());
							txtAge.setText(a.getAge() + "");
							txtRacerID.setText(a.getRacerId() + "");
							
							rdoInjuredYes.setSelected(false);
							rdoInjuredNo.setSelected(true);
							if (a.getIsInjured())
							{
								rdoInjuredYes.setSelected(true);
								rdoInjuredNo.setSelected(false);
							}
							
							txtShoes.setEnabled(false);
							rdoClipsNo.setSelected(false);
							rdoClipsNo.setEnabled(false);
							rdoClipsYes.setSelected(false);
							rdoClipsYes.setEnabled(false);
							
							if (a instanceof Runner)
							{
								String shoes = ((Runner)a).getShoeBrand();
								txtShoes.setText(shoes == null ? "" : shoes);
								txtShoes.setEnabled(true);
							}
							else if (a instanceof Biker)
							{
								boolean usesclips = ((Biker)a).getUsingClips();
								rdoClipsYes.setSelected(usesclips);
								rdoClipsNo.setSelected(!usesclips);
								rdoClipsYes.setEnabled(true);
								rdoClipsNo.setEnabled(true);
							}
						}
					}
				}
			}
		});
		
		cboRacers.setBounds(250, 37, 275, 20);
		getContentPane().add(cboRacers);
		
		JLabel lblSelectTheRacer = new JLabel("Select The Racer to Update");
		lblSelectTheRacer.setBounds(28, 40, 197, 14);
		getContentPane().add(lblSelectTheRacer);
		
		JLabel lblUpdateARacer = new JLabel("Update a Racer");
		lblUpdateARacer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUpdateARacer.setBounds(28, 6, 188, 23);
		getContentPane().add(lblUpdateARacer);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(28, 99, 46, 14);
		getContentPane().add(lblName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(28, 124, 46, 14);
		getContentPane().add(lblAge);
		
		JLabel lblIsInjured = new JLabel("Is Injured?");
		lblIsInjured.setBounds(28, 149, 69, 14);
		getContentPane().add(lblIsInjured);
		
		JLabel lblRacerId = new JLabel("Racer ID:");
		lblRacerId.setBounds(28, 175, 69, 14);
		getContentPane().add(lblRacerId);
		
		JLabel lblShoes = new JLabel("Shoe Brand:");
		lblShoes.setBounds(28, 200, 69, 14);
		getContentPane().add(lblShoes);
		
		JLabel lblUsesClips = new JLabel("Uses Clips?");
		lblUsesClips.setBounds(28, 225, 69, 14);
		getContentPane().add(lblUsesClips);
		
		txtName = new JTextField();
		txtName.setBounds(133, 96, 392, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(133, 121, 392, 20);
		getContentPane().add(txtAge);
		
		txtRacerID = new JTextField();
		txtRacerID.setEditable(false);
		txtRacerID.setColumns(10);
		txtRacerID.setBounds(133, 172, 392, 20);
		getContentPane().add(txtRacerID);
		
		txtShoes = new JTextField();
		txtShoes.setEnabled(false);
		txtShoes.setColumns(10);
		txtShoes.setBounds(133, 197, 392, 20);
		getContentPane().add(txtShoes);
		
		
		rdoClipsNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdoClipsNo.isSelected())
				{
					rdoClipsYes.setSelected(false);
				}
			}
		});
		
		rdoClipsYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdoClipsYes.isSelected())
				{
					rdoClipsNo.setSelected(false);
				}
			}
		});
		
		rdoClipsYes.setEnabled(false);
		rdoClipsYes.setBounds(133, 221, 57, 23);
		getContentPane().add(rdoClipsYes);
		
		
		rdoClipsNo.setEnabled(false);
		rdoClipsNo.setBounds(194, 221, 57, 23);
		getContentPane().add(rdoClipsNo);
		
		
		rdoInjuredNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdoInjuredNo.isSelected())
				{
					rdoInjuredYes.setSelected(false);
				}
			}
		});
		
		rdoInjuredYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdoInjuredYes.isSelected())
				{
					rdoInjuredNo.setSelected(false);
				}
			}
		});
		rdoInjuredYes.setBounds(133, 140, 57, 23);
		getContentPane().add(rdoInjuredYes);
		
		rdoInjuredNo.setBounds(194, 140, 57, 23);
		getContentPane().add(rdoInjuredNo);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Athlete a;
				if (rdoClipsYes.isEnabled())
				{
					a = new Biker();
					((Biker)a).setUsingClips(rdoClipsYes.isSelected());
				}
				else if (txtShoes.isEnabled())
				{
					a = new Runner();
					((Runner)a).setShoeBrand(txtShoes.getText());
				}
				else
				{
					a = new Swimmer();
				}
				a.setName(txtName.getText());
				a.setAge(Integer.parseInt(txtAge.getText()));
				a.setIsInjured(rdoInjuredYes.isSelected());
				a.setRacerId(Integer.parseInt(txtRacerID.getText()));
				boolean success = RaceManager._isr.updateRacer(a);
				if (success)
				{
					JOptionPane.showMessageDialog(null, "Succesfully updated the racer " + a.getRacerId() + " " + a.getName());
					loadRacers();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Could not update the racer " + a.getRacerId() + " " + a.getName());
				}
			}
		});
		btnUpdate.setBounds(436, 272, 89, 23);
		getContentPane().add(btnUpdate);
		
		loadRacers();
	}
	
	private void resetDefault()
	{
		txtName.setText("");
		txtAge.setText("");
		txtRacerID.setText("");
		txtShoes.setText("");
		rdoInjuredYes.setSelected(false);
		rdoInjuredNo.setSelected(false);
		txtShoes.setEnabled(false);
		rdoClipsNo.setSelected(false);
		rdoClipsNo.setEnabled(false);
		rdoClipsYes.setSelected(false);
		rdoClipsYes.setEnabled(false);
	}
	
	private void loadRacers()
	{
		resetDefault();
		
		cboRacers.removeAllItems();
		cboRacers.addItem("");
		//get the racers
		racers = RaceManager._isr.getRacersList();
		for (Athlete a : racers)
		{
			String aData = String.format("%d|%s", a.getRacerId(), a.getName());
			cboRacers.addItem(aData);
		}
	}
	
	private Athlete getRacer(int id)
	{
		racers = RaceManager._isr.getRacersList();
		for (Athlete a : racers)
		{
			if (a.getRacerId() == id)
			{
				return a;
			}
		}
		return null;
	}
}
