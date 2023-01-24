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
		try {
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
			
			//On tri les données
			List<String> listeTrieeSymptome = new ArrayList<String>(); // on crée une liste vide
			listeTrieeSymptome.addAll(symptomHashMap.keySet());  // on remplit la liste vide par toutes les clés de la map
			Collections.sort(listeTrieeSymptome);  // on trie la liste des clés.
			
			
			// next generate output
			FileWriter writer = new FileWriter ("D:/result.out");
			
			for (Iterator iterator = listeTrieeSymptome.iterator(); iterator.hasNext();) { //on boucle sur la liste triée de clés
				String key = (String) iterator.next();
				int val = symptomHashMap.get(key); // on récupère le compteur dans la map (la valeur de la clé)
				writer.write(key + ": " + val + "\n"); // on écrit dans le fichier de résultat la ligne : Clé : compteur
				System.out.println(key + ": " + val); // on écrit la même chose dans la sortie standard pour information
			}
	
			writer.close();
			
		} catch (Exception e) { // on gère l'exception ici en l'affichant simplement.
			System.out.println("Erreur lors de l'execution." + e.getMessage());
			e.printStackTrace();
		}

	}
}
