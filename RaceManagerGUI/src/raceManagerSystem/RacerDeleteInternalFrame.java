package raceManagerSystem;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;

import raceManagerObjects.Athlete;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class RacerDeleteInternalFrame extends BaseInternalFrame {
	JComboBox cboRacers;
	ArrayList<Athlete> racers;
	/**
	 * Create the frame.
	 */
	public RacerDeleteInternalFrame() {
		setBounds(10, 10, 598, 486);
		getContentPane().setLayout(null);
		
		JLabel lblDeleteARacer = new JLabel("Delete A Racer");
		lblDeleteARacer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDeleteARacer.setBounds(28, 26, 135, 23);
		getContentPane().add(lblDeleteARacer);
		
		JLabel lblSelectTheRacer = new JLabel("Select The Racer to Delete");
		lblSelectTheRacer.setBounds(28, 64, 197, 14);
		getContentPane().add(lblSelectTheRacer);
		
		cboRacers = new JComboBox();
		cboRacers.setBounds(250, 61, 275, 20);
		getContentPane().add(cboRacers);
		
		//get the racers
		loadRacers();
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//get the athlete ID to delete
				String athleteID = cboRacers.getSelectedItem().toString();
				//split out the athleteid
				String[] values = athleteID.split("\\|");
				int racerID = Integer.parseInt(values[0]);
				boolean modified = false;
				//use the racer ID to remove the item from the list
				for (Athlete a : racers)
				{
					if (a.getRacerId() == racerID)
					{
						RaceManager._isr.removeRacer(values[1]);
						JOptionPane.showMessageDialog(null, "Successfully deleted racer: " + values[1]);
						modified = true;
						break;
					}
				}
				if (!modified)
				{
					JOptionPane.showMessageDialog(null, "Unable to delete racer");
				}
				else
				{
					//reset the racer list
					loadRacers();
				}
			}
		});
		btnDelete.setBounds(436, 123, 89, 23);
		getContentPane().add(btnDelete);

	}
	
	private void loadRacers()
	{
		cboRacers.removeAllItems();
		cboRacers.addItem("");
		racers = RaceManager._isr.getRacersList();
		for (Athlete a : racers)
		{
			String aData = String.format("%d|%s", a.getRacerId(), a.getName());
			cboRacers.addItem(aData);
		}
	}
}
