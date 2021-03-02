package com.blackdragon2447.AAM.util;

import java.io.IOException;
import java.util.ArrayList;

public class CreatureSetBuilder {
	
	
	public CreatureSetBuilder() {
		
		
	}
	
	public static Pair<String, ArrayList<Pair<String, String>>> generatePair(String setName, String Path) throws IOException {
		
		return new Pair<String, ArrayList<Pair<String, String>>>(setName, CSVReader.readItemFile(Path));
		
	}

}
