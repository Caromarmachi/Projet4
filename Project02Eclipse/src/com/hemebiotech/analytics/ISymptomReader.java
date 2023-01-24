package com.hemebiotech.analytics;

import java.util.HashMap;

/**
 * Anything that will read symptom data from a source
 * 
 * Nous choisissons l'objet MAP pour créer un dictionnaire de symptomes sans doublons contenant un compteur
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * @return a MAP obtained from a data source, duplicates are not possible
	 */
	HashMap<String, Integer> GetSymptoms ();

}


