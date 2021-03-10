package com.blackdragon2447.AAM;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.UnsupportedLookAndFeelException;

import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.util.CSVReader;
import com.blackdragon2447.AAM.util.CreatureSetBuilder;
import com.blackdragon2447.AAM.util.ItemSetBuilder;
import com.blackdragon2447.AAM.util.Pair;

/**
 * the main class of AAM
 * 
 * AAM is an acronym for ArkAdminMenu
 * AAM is a tool for ark server admins to execute advanced commands remotely and save custom commands
 * to make the process of entering/using commands faster and easier
 * @author Blackdragon2447
 * @version 0.1
 *
 */

public class Main {
	

	

	@SuppressWarnings("unused")
	public static void main(String[] args){
		

		/**
		 * this piece of the code will import any files needed to run before opening the actual GUI to prevent delay
		 * because of loading in code
		 */
		
		CSVReader Reader = new CSVReader();
		try {
			Reference.SimpleCommandList = CSVReader.readCommandList("simpleCommands.csv");
			Reference.SimpleCommandArgList = CSVReader.readArgList("simpleCommandsArgs.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File dir = new File("ItemLists");
		String[] ItemFileList = dir.list();
		
		Pair<String, ArrayList<Pair<String, String>>> pair ;
		
		for (String string : ItemFileList) {
			try {
				pair = ItemSetBuilder.generatePair(string.substring(0, string.length() - 4), "ItemLists\\" + string);
				Reference.ImportedItemGroups.add(ItemSetBuilder.generatePair(string.substring(0, string.length() - 4), "ItemLists\\" + string));
			} catch (IOException e) {
				if(!(e instanceof FileNotFoundException))
					e.printStackTrace();
			}
		}
		
		File dir2 = new File("CreatureLists");
		String[] DinoFileList = dir2.list();
		
		
		for (String string2 : DinoFileList) {
			try {
				Reference.ImportedCreatureGroups.add(CreatureSetBuilder.generatePair(string2.substring(0, string2.length() - 4), "CreatureLists\\" + string2));
			} catch (IOException e) {
					e.printStackTrace();
			}
		}
		
		/**
		 * this code opens the GUI and would react to any thrown errors.
		 */
		
		try {
			AAMGui.createGui();
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}


	}

}
