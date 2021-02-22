package com.blackdragon2447.AAM.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
	
	@SuppressWarnings("rawtypes")
	static Pair dataPair;
	static String line;
	static ArrayList<Pair<String, Boolean>> pairList;
	static ArrayList<Pair<Integer, String>> ArgPairList;
	static ArrayList<Pair<String, String>> ItemBPList;
	
	@SuppressWarnings({ })
	public CSVReader(){
		
		
		line = "";
		pairList = new ArrayList<Pair<String, Boolean>>();
		ArgPairList = new ArrayList<Pair<Integer, String>>();
		ItemBPList = new ArrayList<Pair<String, String>>();
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Pair<String, Boolean>> readCommandList(String path) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(path));
		while((line = br.readLine()) != null) {
			String[] values = line.split(",");
			dataPair = new Pair<String, Boolean>(values[0].replace("﻿", ""), Boolean.valueOf(values[1]));
			pairList.add(dataPair);
		}
		
		br.close();
		
		return pairList;
		
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Pair<Integer, String>> readArgList(String path) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(path));
		line = "";
		while((line = br.readLine()) != null) {
			String[] values = line.split(",");
			dataPair = new Pair<Integer, String>(Integer.valueOf(values[0].replace("﻿", "")), values[1]);
			ArgPairList.add(dataPair);
		}
		
		br.close();
		return ArgPairList;
		
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Pair<String, String>> readItemFile(String path) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(path));
		line = "";
		while((line = br.readLine()) != null) {
			String[] values = line.split(",");
			dataPair = new Pair<String, String>(values[0].replace("﻿", ""), values[1]);
			ItemBPList.add(dataPair);
		}
		
		br.close();
		return ItemBPList;
		
	}
}
