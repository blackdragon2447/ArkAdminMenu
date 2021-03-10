package com.blackdragon2447.AAM.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * used to read in csv files
 * @author Blackdragon2447
 */
public class CSVReader {
	
	@SuppressWarnings("rawtypes")
	static Pair DataPair;
	static String Line;
	static ArrayList<Pair<String, Boolean>> PairList;
	static ArrayList<Pair<String, Integer>> PairListAdvanced;
	static ArrayList<Pair<Integer, String>> ArgPairList;
	
	/**
	 * constuctor: sets the variables
	 */
	public CSVReader(){
		Line = "";
		PairList = new ArrayList<Pair<String, Boolean>>();
		PairListAdvanced = new ArrayList<Pair<String, Integer>>();
		ArgPairList = new ArrayList<Pair<Integer, String>>();
	}
	
	/**
	 * reads a list of commands
	 * @param path the path of the file
	 * @return the list of commands and if they need an arg.
	 * @throws IOException
	 */
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
	@Deprecated
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
	
	/**
	 * reads a list of command arg desc.
	 * @param path the path of the file
	 * @return the list of command numbers and the desc.
	 * @throws IOException
	 */
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
	
	/**
	 * reads in item files producing a ArrayList<Pair<String, String>> containing a bp path and name for each item
	 * @param path the path of the file
	 * @return an ArrayList<Pair<String, String>> of the items
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Pair<String, String>> readItemFile(String path) throws IOException {
		
		ArrayList<Pair<String, String>> ItemBPList;
		ItemBPList = new ArrayList<Pair<String, String>>();
		ItemBPList.clear();
		DataPair = new Pair<String, String>(null, null);
		BufferedReader br = new BufferedReader(new FileReader(path));
		Line = "";
		while((Line = br.readLine()) != null) {
			String[] values = Line.split(",");
			DataPair = new Pair<String, String>(values[0].replace("﻿", ""), values[1]);
			ItemBPList.add(DataPair);
		}
		
		br.close();
		path = null;
		return ItemBPList;
		
	}
	
	/**
	 * reads in creature files producing a ArrayList<Pair<String, String>> containing a bp path and name for each creatures
	 * @param path the path of the file
	 * @return an ArrayList<Pair<String, String>> of the creatures
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Pair<String, String>> readCreatureFile(String path) throws IOException {
		

		ArrayList<Pair<String, String>> CreatureBPList;
		CreatureBPList = new ArrayList<Pair<String, String>>();
		CreatureBPList.clear();
		DataPair = new Pair<String, String>(null, null);
		BufferedReader br = new BufferedReader(new FileReader(path));
		Line = "";
		while((Line = br.readLine()) != null) {
			String[] values = Line.split(",");
			DataPair = new Pair<String, String>(values[0].replace("﻿", ""), values[0]);
			CreatureBPList.add(DataPair);
		}
		
		br.close();
		return CreatureBPList;
		
	}
}
