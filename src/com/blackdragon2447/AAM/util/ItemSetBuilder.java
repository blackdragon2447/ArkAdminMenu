package com.blackdragon2447.AAM.util;

import java.io.IOException;
import java.util.ArrayList;

public class ItemSetBuilder {
	
	/**
	 * this imports the csv file for the set and returns the itemset for it.
	 * @param setName the name of the set
	 * @param Path the path of the csv file containing the set
	 * @return a pair of the setname and the an arraylist of pairs of itemname and bp path
	 * @throws IOException thrown if the file isnt found
	 */
	public static Pair<String, ArrayList<Pair<String, String>>> generatePair(String setName, String Path) throws IOException {
		
		return new Pair<String, ArrayList<Pair<String, String>>>(setName, CSVReader.readItemFile(Path));
		
	}

}
