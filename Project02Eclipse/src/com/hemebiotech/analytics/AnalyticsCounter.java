package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Carolina
 * Classe AnalyticsCounter permettant d'analyser un fichier de symptome
 * et de compter toutes les occurences de chaque symptome
 * 
 */
public class AnalyticsCounter {
	
	/**
	 * Methode Main (point d'entree)
	 * Cette methode lit le fichier de symptome en input et genere un fichier de resultat en output
	 * @param args (non utilises)
	 * @throws Exception
	 * 
	 */	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("D:/symptoms.txt"));
		String line = reader.readLine();
		
		HashMap<String, Integer> symptomHashMap = new HashMap<>();
		
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
		
		// next generate output
		FileWriter writer = new FileWriter ("D:/result.out");
		
		for (Map.Entry<String, Integer> entry : symptomHashMap.entrySet()) { 
			String key = entry.getKey();
			int val = entry.getValue();
			writer.write(key + ": " + val + "\n"); 
			System.out.println(key + ": " + val); 
		}

		writer.close();
	}
}
