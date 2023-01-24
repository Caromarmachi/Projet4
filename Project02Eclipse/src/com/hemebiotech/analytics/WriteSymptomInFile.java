package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.time.Instant;
import java.time.InstantSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class WriteSymptomInFile implements ISymptomWriter {

	private String filepath;
	
	/**
	 * @param filepath chemin du fichier de resultat
	 */
	public WriteSymptomInFile (String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void WriteSymptoms(HashMap<String, Integer> symptomHashMap) {
		try {
			//On tri les données
			List<String> listeTrieeSymptome = new ArrayList<String>(); // on crée une liste vide
			listeTrieeSymptome.addAll(symptomHashMap.keySet());  // on remplit la liste vide par toutes les clés de la map
			Collections.sort(listeTrieeSymptome);  // on trie la liste des clés.
			
			
			// next generate output
			FileWriter writer = new FileWriter (filepath);
			
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
