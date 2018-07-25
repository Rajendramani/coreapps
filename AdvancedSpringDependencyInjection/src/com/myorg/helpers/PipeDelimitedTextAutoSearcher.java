package com.myorg.helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.myorg.beans.Car;

public class PipeDelimitedTextAutoSearcher implements AutoSearcher 
{
	private String PLFilePath = null;
	
	public PipeDelimitedTextAutoSearcher(String path) {
		PLFilePath = path;
	}
	
	@Override
	public ArrayList<Car> getAutos() {
		ArrayList<Car> theCars = new ArrayList<Car>();
		FileReader fr = null;
		Scanner input = null;
		try
		{
			fr = new FileReader(PLFilePath);
			input = new Scanner(fr);
			
			String auto = "";
			while (input.hasNextLine())
			{
				auto = input.nextLine();
				String[] d = auto.split("\\|");
				theCars.add(new Car(d[0], d[1]));
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if (fr != null)
			{
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return theCars;
	}

}
