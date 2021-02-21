package com.blackdragon2447.AAM;

import java.util.ArrayList;

import com.blackdragon2447.AAM.gui.components.JNumberedButton;
import com.blackdragon2447.AAM.util.Pair;

public class Reference {
	
	public static ArrayList<JNumberedButton> FavoriteButtonList = new ArrayList<JNumberedButton>();
	public static ArrayList<Pair<Integer, String>> SimpleCommandArgList = new ArrayList<Pair<Integer, String>>();
	public static ArrayList<Pair<String, Boolean>> SimpleCommandList = new ArrayList<Pair<String, Boolean>>();
	
	public void setSCList(ArrayList<Pair<String, Boolean>> list) {
		SimpleCommandList = list;
	}

}
