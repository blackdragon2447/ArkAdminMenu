package com.blackdragon2447.AAM.util;

import java.awt.Component;
import java.util.ArrayList;

import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.gui.components.JNumberedButton;

public class Utils {
	
	public static JNumberedButton findButtonByNumber(int Number){
		Component[] components = AAMGui.GetSCPanel().getComponents();
		ArrayList<JNumberedButton> buttons = new ArrayList<JNumberedButton>();
		
		for(int i = 0; i < components.length; i++) {
			if(components[i].getClass() == JNumberedButton.class) {
				buttons.add((JNumberedButton) components[i]);
			}
		}
		
		JNumberedButton foundButton = buttons.stream()
				  .filter(JNumberedButton -> Number==(JNumberedButton.getNumber()))
				  .findAny()
				  .orElse(null);
		
		return foundButton;
	}
	
	public static String GenerateCommand(int commandNumber) {
		String commandPrefix = "";
		if (AAMGui.PFcheatRadioItem.isSelected() == true) {
			commandPrefix = "cheat ";
		}else if (AAMGui.PFacheatRadioItem.isSelected() == true) {
			commandPrefix = "admincheat ";
		}else {
			commandPrefix = Reference.customPrefix + " ";
		}
		String ListItem = Reference.SimpleCommandList.get(commandNumber).getFirstValue();
		
		return commandPrefix + ListItem;
	}
	
	public static String getPrefix() {
		String commandPrefix = "";
		if (AAMGui.PFcheatRadioItem.isSelected() == true) {
			commandPrefix = "cheat ";
		}else if (AAMGui.PFacheatRadioItem.isSelected() == true) {
			commandPrefix = "admincheat ";
		}else {
			commandPrefix = Reference.customPrefix + " ";
		}
		
		return commandPrefix;
	}

}
