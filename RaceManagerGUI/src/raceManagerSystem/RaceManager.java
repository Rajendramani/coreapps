package raceManagerSystem;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import javax.swing.border.*;

import raceManagerData.*;


public class RaceManager extends JFrame {

	private JPanel contentPane;
	public static InfiniteSkillsRace _isr;
	private RacerAddInternalFrame racerAddInternalFrame;
	private RacerUpdateInternalFrame racerUpdateInternalFrame;
	private RacerDeleteInternalFrame racerDeleteInternalFrame;
	private RacerListInternalFrame racerListInternalFrame;
	
	/**
	 * Create the frame.
	 */
	public RaceManager() {
		_isr = new InfiniteSkillsRace();
		String choice = JOptionPane.showInputDialog("Enter 1 "
				+ "to load the racers from the flat text file, 2 to load from the System state file");
		
		if (choice.equals("1"))
		{
			try
			{
				_isr.setRacersList(raceManagerPopulateAndStore.getAthletesFromFile(dataFile.dataFilePath));
			}
			catch (Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Could not load racers from the flat file " + ex.getMessage());
			}
		}
		else if (choice.equals("2"))
		{
			try
			{
				FileInputStream fis = new FileInputStream(dataFile.dataObjectFilePath);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	        	_isr = (InfiniteSkillsRace)ois.readObject();
	        	ois.close();
	        	ois = null;
	        	fis.close();
	        	fis = null;
			}
			catch (Exception ex)
			{
				//if the file doesn't exist, can't load it.
				JOptionPane.showMessageDialog(null, "Could not load the system from state: " + ex.getMessage());
			}
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 23, 644, 479);
		contentPane.add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 97, 21);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//exit
                int close = JOptionPane.showConfirmDialog(null
                                , "Are you sure you want to exit?"
                                , "End Application?"
                                , JOptionPane.YES_NO_OPTION
                                , JOptionPane.INFORMATION_MESSAGE);
                if (close == 1) return;
                System.exit(0);
			}
		});
		menu.add(menuItem);
		
		JMenuItem mntmLoadRacers = new JMenuItem("Load Racers");
		mntmLoadRacers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Load the System from file
				try
				{
					FileInputStream fis = new FileInputStream(dataFile.dataObjectFilePath);
		            ObjectInputStream ois = new ObjectInputStream(fis);
		        	_isr = (InfiniteSkillsRace)ois.readObject();
		        	ois.close();
		        	ois = null;
		        	fis.close();
		        	fis = null;
		        	JOptionPane.showMessageDialog(null, "Successfully loaded the system from file!");
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Could not load the system from file: " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		});
		menu.add(mntmLoadRacers);
		
		JMenuItem mntmSaveSystem = new JMenuItem("Save System");
		mntmSaveSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Save the System to file
				try
				{
					FileOutputStream fos = new FileOutputStream(dataFile.dataObjectFilePath);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(_isr);
					JOptionPane.showMessageDialog(null, "Successfully saved the system to file!");
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Could not save the system to file: " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		});
		menu.add(mntmSaveSystem);
		
		JMenu mnRaceActions = new JMenu("Race Actions");
		menuBar.add(mnRaceActions);
		
		JMenuItem mntmAddARacer = new JMenuItem("Add A Racer");
		mntmAddARacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//show the form to add A Racer
				racerAddInternalFrame = new RacerAddInternalFrame();
				desktopPane.add(racerAddInternalFrame);
			}
		});
		mnRaceActions.add(mntmAddARacer);
		
		JMenuItem mntmUpdateARacer = new JMenuItem("Update A Racer");
		mntmUpdateARacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//show the form to update A Racer
				racerUpdateInternalFrame = new RacerUpdateInternalFrame();
				desktopPane.add(racerUpdateInternalFrame);
			}
		});
		mnRaceActions.add(mntmUpdateARacer);
		
		JMenuItem mntmDeleteARacer = new JMenuItem("Delete A Racer");
		mntmDeleteARacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//show the form to delete A Racer
				racerDeleteInternalFrame = new RacerDeleteInternalFrame();
				desktopPane.add(racerDeleteInternalFrame);
			}
		});
		mnRaceActions.add(mntmDeleteARacer);
		
		JMenuItem mntmListRacers = new JMenuItem("List Racers");
		mntmListRacers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//show the form to list the racers
				racerListInternalFrame = new RacerListInternalFrame();
				desktopPane.add(racerListInternalFrame);
			}
		});
		mnRaceActions.add(mntmListRacers);
	}
}
