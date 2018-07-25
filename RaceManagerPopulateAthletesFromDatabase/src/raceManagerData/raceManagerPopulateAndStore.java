package raceManagerData;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import raceManagerObjects.*;

public class raceManagerPopulateAndStore 
{	
	/**
	 * Get the athletes out of a flat text file
	 * @param path the path of the data file
	 * @return an ArrayList containing valid athletes
	 * @throws IOException if the file is not found or not accessible for some reason
	 */
	public static ArrayList<Athlete> getAthletesFromFile(String path) throws IOException
	{
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String nextLine = null;
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		
		while ((nextLine = br.readLine()) != null)
		{
			Athlete a = processAthlete(nextLine);
			if (a != null)
			{
				athletes.add(a);
			}
		}
		
		br.close();
		br = null;
		fr.close();
		fr = null;
		
		return athletes;
	}
	
	/**
	 * Get an athlete from flat-file data
	 * @param data String containing athlete information
	 * 			must be formatted:
	 * 				TYPE|key=value;key=value;key=value;key=value
	 * @return an athlete generated based on the String values
	 */
	private static Athlete processAthlete(String data)
	{
		Athlete a = null;
		
		String[] dataValues = data.split("\\|");
		//get the type
		switch(dataValues[0])
		{
			case "RUNNER":
				a = new Runner();
				break;
			case "BIKER":
				a = new Biker();
				break;
			case "SWIMMER":
				a = new Swimmer();
				break;
			default:
				a = null;
				break;
		}
		if (a == null) return null;
		
		String[] properties = dataValues[1].split(";");
		for (String s : properties)
		{
			String[] propValues = s.split("="); 
			switch(propValues[0])
			{
				case "name":
					a.setName(propValues[1]);
					break;
				case "age" :
					a.setAge(Integer.parseInt(propValues[1]));
					break;
				case "id" :
					a.setRacerId(Integer.parseInt(propValues[1]));
					break;
				case "injured":
					a.setIsInjured(Boolean.parseBoolean(propValues[1]));
					break;
				case "shoes":
					((Runner)a).setShoeBrand(propValues[1]);
					break;
				case "clips":
					((Biker)a).setUsingClips(Boolean.parseBoolean(propValues[1]));
					break;
				default:
					break;
			}
		}
		return a;
	}
	
	/**
	 * Write an array of athletes out to a datafile for later retrieval
	 * @param path the path of the data file
	 * @param athletes the array of athletes to store
	 * @return true on success and at least one athlete written
	 * @throws IOException if path is invalid or file is not accessible for some reason
	 */
	public static boolean writeAthletesToFile(String path, ArrayList<Athlete> athletes) throws IOException
	{
		FileWriter fw = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(fw);
		boolean atLeastOne = false;
		for (Athlete a : athletes)
		{
			bw.write(a.toDataString());
			bw.newLine();
			atLeastOne = true;
		}
		
		bw.close();
		bw = null;
		fw.close();
		fw = null;
		
		return atLeastOne;
	}

}
