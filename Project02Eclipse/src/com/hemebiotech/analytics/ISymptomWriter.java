package com.hemebiotech.analytics;

import java.util.HashMap;

/**
 * Interface utilitaire qui genere un fichier de symptome trie à partir d'une MAP en input
 * 
 * 
 */
public interface ISymptomWriter {
	/**
	 * Genere un fichier de resultat
	 */
	void WriteSymptoms (HashMap<String, Integer> symptomHashMap);

}


