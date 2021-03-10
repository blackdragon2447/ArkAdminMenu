package com.blackdragon2447.AAM.util;

import java.io.IOException;
import java.util.ArrayList;

public class CreatureSetBuilder {
	
	/**
	 * this imports the csv file for the set and returns the creatureset for it.
	 * @param setName the name of the set
	 * @param Path the path of the csv file containing the set
	 * @return a pair of the setname and the an arraylist of pairs of creaturename and bp path
	 * @throws IOException thrown if the file isnt found
	 */
	public static Pair<String, ArrayList<Pair<String, String>>> generatePair(String setName, String Path) throws IOException {
		
		return new Pair<String, ArrayList<Pair<String, String>>>(setName, CSVReader.readCreatureFile(Path));
		
	}

}
