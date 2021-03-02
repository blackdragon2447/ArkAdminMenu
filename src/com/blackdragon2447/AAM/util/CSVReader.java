package com.blackdragon2447.AAM.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
	
	@SuppressWarnings("rawtypes")
	static Pair DataPair;
	static String Line;
	static ArrayList<Pair<String, Boolean>> PairList;
	static ArrayList<Pair<String, Integer>> PairListAdvanced;
	static ArrayList<Pair<Integer, String>> ArgPairList;
	static ArrayList<Pair<String, String>> ItemBPList;
	
	@SuppressWarnings({ })
	public CSVReader(){
		
		
		Line = "";
		PairList = new ArrayList<Pair<String, Boolean>>();
		PairListAdvanced = new ArrayList<Pair<String, Integer>>();
		ArgPairList = new ArrayList<Pair<Integer, String>>();
		ItemBPList = new ArrayList<Pair<String, String>>();
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Pair<String, Boolean>> readCommandList(String path) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(path));
		while((Line = br.readLine()) != null) {
			String[] values = Line.split(",");
			DataPair = new Pair<String, Boolean>(values[0].replace("﻿", ""), Boolean.valueOf(values[1]));
			PairList.add(DataPair);
		}
		
		br.close();
		
		return PairList;
		
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Pair<String, Integer>> readCommandAdvancedList(String path) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(path));
		while((Line = br.readLine()) != null) {
			String[] values = Line.split(",");
			DataPair = new Pair<String, Integer>(values[0].replace("﻿", ""), Integer.valueOf(values[1]));
			PairListAdvanced.add(DataPair);
		}
		
		br.close();
		
		return PairListAdvanced;
		
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Pair<Integer, String>> readArgList(String path) throws IOException {
		
		ArgPairList.clear();
		
		BufferedReader br = new BufferedReader(new FileReader(path));
		Line = "";
		while((Line = br.readLine()) != null) {
			String[] values = Line.split(",");
			DataPair = new Pair<Integer, String>(Integer.valueOf(values[0].replace("﻿", "")), values[1]);
			ArgPairList.add(DataPair);
		}
		
		br.close();
		return ArgPairList;
		
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Pair<String, String>> readItemFile(String path) throws IOException {
		
		ItemBPList.clear();
		
		BufferedReader br = new BufferedReader(new FileReader(path));
		Line = "";
		while((Line = br.readLine()) != null) {
			String[] values = Line.split(",");
			DataPair = new Pair<String, String>(values[0].replace("﻿", ""), values[1]);
			ItemBPList.add(DataPair);
		}
		
		br.close();
		return ItemBPList;
		
	}
}
