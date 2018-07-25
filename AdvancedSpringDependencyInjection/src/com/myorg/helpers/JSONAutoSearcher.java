package com.myorg.helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.*;

import com.myorg.beans.Car;

public class JSONAutoSearcher implements AutoSearcher
{
	private String JSONFilePath = null;
	
	public JSONAutoSearcher(String path)
	{
		JSONFilePath = path;
	}
	
	@Override
	public ArrayList<Car> getAutos() {
		ArrayList<Car> theCars = new ArrayList<Car>();
		
		FileReader fr = null;
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try
		{
			fr = new FileReader(JSONFilePath);
			br = new BufferedReader(fr);
			String nextLine = null;
			sb = new StringBuilder();
			while((nextLine = br.readLine()) != null)
			{
				sb.append(nextLine);
			}
			

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if (br != null) br.close();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			try
			{
				if (fr != null) fr.close();
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		JSONArray cars = new JSONArray(sb.toString());
		for (int i = 0; i < cars.length(); i++)
		{
			JSONObject jso = cars.getJSONObject(i);
			theCars.add(new Car((String)jso.get("make"), (String)jso.get("model")));
		}
		return theCars;
	}

}
