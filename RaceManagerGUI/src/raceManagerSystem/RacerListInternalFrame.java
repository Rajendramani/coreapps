package raceManagerSystem;

import javax.swing.JButton;

import raceManagerObjects.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.Font;

public class RacerListInternalFrame extends BaseInternalFrame {

	private int currentPosition;
	private ArrayList<Athlete> racers;
	private JLabel lblName;
	private JLabel lblAge;
	private JLabel lblInjured;
	private JLabel lblRacerID;
	private JLabel lblShoeBrand;
	private JLabel lblusesclips;
	private JLabel lblType;
	
	/**
	 * Create the frame.
	 */
	public RacerListInternalFrame() {
		setBounds(5, 5, 602, 503);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Name:");
		label.setBounds(179, 116, 46, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Age:");
		label_1.setBounds(179, 141, 46, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Is Injured?");
		label_2.setBounds(179, 166, 69, 14);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Racer ID:");
		label_3.setBounds(179, 192, 69, 14);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Shoe Brand:");
		label_4.setBounds(179, 245, 69, 14);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Uses Clips?");
		label_5.setBounds(179, 270, 69, 14);
		getContentPane().add(label_5);
		
		lblName = new JLabel("[lblName]");
		lblName.setBounds(303, 116, 256, 14);
		getContentPane().add(lblName);

		lblAge = new JLabel("[lblAge]");
		lblAge.setBounds(303, 141, 256, 14);
		getContentPane().add(lblAge);
		
		lblInjured = new JLabel("[lblInjured]");
		lblInjured.setBounds(303, 166, 256, 14);
		getContentPane().add(lblInjured);
		
		lblRacerID = new JLabel("[lblRacerID]");
		lblRacerID.setBounds(303, 192, 256, 14);
		getContentPane().add(lblRacerID);
		
		lblShoeBrand = new JLabel("[lblShoeBrand]");
		lblShoeBrand.setBounds(303, 245, 256, 14);
		getContentPane().add(lblShoeBrand);
		
		lblusesclips = new JLabel("[lblUsesClips]");
		lblusesclips.setBounds(303, 270, 256, 14);
		getContentPane().add(lblusesclips);
		
		JLabel lblTypeDesc = new JLabel("Type");
		lblTypeDesc.setBounds(179, 217, 69, 14);
		getContentPane().add(lblTypeDesc);
		
		lblType = new JLabel("[lblType]");
		lblType.setBounds(303, 217, 256, 14);
		getContentPane().add(lblType);
		
		JLabel lblViewRacers = new JLabel("View Racers");
		lblViewRacers.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblViewRacers.setBounds(50, 27, 135, 23);
		getContentPane().add(lblViewRacers);
		
		currentPosition = 0;
		loadAthlete();
		JButton btnNext = new JButton(">>");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentPosition++;
				loadAthlete();
			}
		});
		btnNext.setBounds(278, 63, 110, 23);
		getContentPane().add(btnNext);
		
		JButton btnPrev = new JButton("<<");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentPosition--;
				loadAthlete();
			}
		});
		btnPrev.setBounds(146, 63, 110, 23);
		getContentPane().add(btnPrev);
	}

	private void loadAthlete()
	{
		racers = RaceManager._isr.getRacersList();
		if (currentPosition >= racers.size())
		{
			currentPosition = 0;
		}
		else if (currentPosition < 0)
		{
			currentPosition = racers.size() - 1;
		}
		Athlete a = racers.get(currentPosition);
		lblName.setText(a.getName());
		lblAge.setText(a.getAge() + "");
		lblInjured.setText((a.getIsInjured() ? "Yes" : "No"));
		if (lblInjured.getText().equalsIgnoreCase("Yes"))
		{
			lblInjured.setForeground(Color.RED);
		}
		else
		{
			lblInjured.setForeground(Color.GREEN);
		}
		lblRacerID.setText(a.getRacerId() + "");
		lblShoeBrand.setText("");
		lblusesclips.setText("");
		lblType.setText("Swimmer");
		if (a instanceof Runner)
		{
			lblType.setText("Runner");
			lblShoeBrand.setText(((Runner)a).getShoeBrand());
		}
		else if (a instanceof Biker)
		{
			lblType.setText("Biker");
			lblusesclips.setText(((Biker)a).getUsingClips() ? "Yes" : "No");
		}
	}
}
