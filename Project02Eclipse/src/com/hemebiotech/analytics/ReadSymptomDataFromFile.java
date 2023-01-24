package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public HashMap<String, Integer> GetSymptoms() {
		HashMap<String, Integer> symptomHashMap = new HashMap<>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				
				while (line != null) {
					if (symptomHashMap.get(line)!=null) {
						int counter = symptomHashMap.get(line);
						symptomHashMap.put(line,(counter +1));
					} else  {
						symptomHashMap.put(line,1);
					} 
					line = reader.readLine();	// get another symptom
				}
				reader.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return symptomHashMap;
	}

}
