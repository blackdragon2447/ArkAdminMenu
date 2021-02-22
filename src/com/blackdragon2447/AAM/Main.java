package com.blackdragon2447.AAM;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.UnsupportedLookAndFeelException;

import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.util.CSVReader;

/**
 * the main class of AAM
 * 
 * AAM is an acronym for ArkAdminMenu
 * AAM is a tool for ark server admins to execute advanced commands remotely and save custom commands
 * to make the process of entering/using commands faster and easyer
 * @author Blackdragon2447
 * @version 0.1
 *
 */

public class Main {
	

	

	@SuppressWarnings("unused")
	public static void main(String[] args){
		
		CSVReader reader = new CSVReader();
		try {
			Reference.SimpleCommandList = CSVReader.readCommandList("simpleCommands.csv");
			Reference.SimpleCommandArgList = CSVReader.readArgList("simpleCommandsArgs.csv");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		for(int i=0; i < Reference.SimpleCommandList.size(); i++) {
			System.out.println(Reference.SimpleCommandArgList.get(i).GetcsvValue());
		}
		
		//open gui
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
