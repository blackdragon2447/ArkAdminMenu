package com.blackdragon2447.AAM;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.UnsupportedLookAndFeelException;

import org.aeonbits.owner.ConfigFactory;

import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.util.CSVReader;
import com.blackdragon2447.AAM.util.ItemSetBuilder;
import com.blackdragon2447.AAM.util.iface.AAMConfig;

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
		

		AAMConfig cfg = ConfigFactory.create(AAMConfig.class);
		
		CSVReader Reader = new CSVReader();
		try {
			Reference.SimpleCommandList = CSVReader.readCommandList("simpleCommands.csv");
			Reference.SimpleCommandArgList = CSVReader.readArgList("simpleCommandsArgs.csv");
			Reference.AdvancedCommandList = CSVReader.readCommandAdvancedList("AdvancedCommands.csv");
			Reference.AdvancedCommandArgList = CSVReader.readArgList("AdvancedCommandsArgs.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File dir = new File("ItemLists");
		String[] ItemFileList = dir.list();
		
		System.out.println(ItemFileList.length);
		
		for (String string : ItemFileList) {
			try {
				Reference.ImportedItemGroups.add(ItemSetBuilder.generatePair(string.substring(0, string.length() - 4), "ItemLists\\" + (String) string));
			} catch (IOException e) {
				if(!(e instanceof FileNotFoundException))
					e.printStackTrace();
			}
		}
		
		Reference.CustomPrefix = cfg.CustomPrefix();
		
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
