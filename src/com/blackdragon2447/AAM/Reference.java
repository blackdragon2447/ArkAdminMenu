package com.blackdragon2447.AAM;

import java.util.ArrayList;

import com.blackdragon2447.AAM.gui.components.JNumberedButton;
import com.blackdragon2447.AAM.util.Pair;
import com.blackdragon2447.AAM.util.obj.GenericCommand;

public class Reference {
	
	public static ArrayList<JNumberedButton> FavoriteButtonList = new ArrayList<JNumberedButton>();
	public static ArrayList<Pair<Integer, String>> SimpleCommandArgList = new ArrayList<Pair<Integer, String>>();
	public static ArrayList<Pair<String, Boolean>> SimpleCommandList = new ArrayList<Pair<String, Boolean>>();

	public static ArrayList<Pair<Integer, String>> AdvancedCommandArgList = new ArrayList<Pair<Integer, String>>();
	public static ArrayList<Pair<String, Integer>> AdvancedCommandList = new ArrayList<Pair<String, Integer>>();
	public static String CustomPrefix;
	public static ArrayList<GenericCommand> Queue = new ArrayList<GenericCommand>();
	public static ArrayList<Pair<String, 	 ArrayList<Pair<String, String>>>> ImportedItemGroups = new ArrayList<Pair<String, ArrayList<Pair<String, String>>>>();
	//			  groups:		 group name	 items:	   item:name	bp_path
	public static ArrayList<Pair<String, 	 ArrayList<Pair<String, String>>>> ImportedCreatureGroups = new ArrayList<Pair<String, ArrayList<Pair<String, String>>>>();
	//			  groups:		 group name	 dinos:	   dino:name	bp_path
	public static ArrayList<String> ImportedItemGroupFiles = new ArrayList<String>();
	public static ArrayList<String> ImportedCreatureGroupFiles = new ArrayList<String>();
	public static ArrayList<String> ItemFileArray = new ArrayList<String>();
	public static String Password;
	public static String RConIp;
	public static int RConPort;

}
