package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
	public static void main(String args[])  {
		// first get input
	
			ReadSymptomDataFromFile maClasseDanalyse = new ReadSymptomDataFromFile("D:/symptoms.txt");
			
			HashMap<String, Integer> symptomHashMap = maClasseDanalyse.GetSymptoms();
			
			WriteSymptomInFile maClasseDeResultat = new WriteSymptomInFile("D:/result.out");
			
			maClasseDeResultat.WriteSymptoms(symptomHashMap);
	

	}
}
