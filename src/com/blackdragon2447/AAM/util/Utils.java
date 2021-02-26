package com.blackdragon2447.AAM.util;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;

import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.gui.components.JNumberedButton;
import com.blackdragon2447.AAM.gui.components.JNumberedCheckbox;

public class Utils {
	
	public static JNumberedButton findButtonByNumber(int Number){
		Component[] components = AAMGui.GetSCPanel().getComponents();
		ArrayList<JNumberedButton> buttons = new ArrayList<JNumberedButton>();
		
		for(int i = 0; i < components.length; i++) {
			if(components[i] instanceof JNumberedButton) {
				buttons.add((JNumberedButton) components[i]);
			}
		}
		
		JNumberedButton foundButton = buttons.stream()
				  .filter(JNumberedButton -> Number==(JNumberedButton.getNumber()))
				  .findAny()
				  .orElse(null);
		
		return foundButton;
	}
	
	public static JNumberedButton findButtonInListByNumber(int Number){
		ArrayList<JNumberedButton> buttons = Reference.FavoriteButtonList;
		
		JNumberedButton foundButton = buttons.stream()
				  .filter(JNumberedButton -> Number==(JNumberedButton.getNumber()))
				  .findAny()
				  .orElse(null);
		
		return foundButton;
	}
	
	public static JNumberedCheckbox findCheckboxByNumber(int Number){
		Component[] components = AAMGui.GetSCPanel().getComponents();
		ArrayList<JNumberedCheckbox> boxes = new ArrayList<JNumberedCheckbox>();
		
		for(int i = 0; i < components.length; i++) {
			if(components[i] instanceof JNumberedCheckbox) {
				boxes.add((JNumberedCheckbox) components[i]);
			}
		}
		
		JNumberedCheckbox foundBox = boxes.stream()
				  .filter(JNumberedCheckbox -> Number==(JNumberedCheckbox.getNumber()))
				  .findAny()
				  .orElse(null);
		
		return foundBox;
	}
	
	public static String GenerateCommand(int commandNumber) {
		String commandPrefix = "";
		if (AAMGui.PFcheatRadioItem.isSelected() == true) {
			commandPrefix = "cheat ";
		}else if (AAMGui.PFacheatRadioItem.isSelected() == true) {
			commandPrefix = "admincheat ";
		}else {
			commandPrefix = Reference.CustomPrefix + " ";
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
			commandPrefix = Reference.CustomPrefix + " ";
		}
		
		return commandPrefix;
	}
	
	public static JLabel generateTitleLabel(String text) {
		
		JLabel label = new JLabel(text);
		label.setFont(new Font(label.getFont().getFontName(), label.getFont().getStyle(), 18));
		return label;
		
	}

}
