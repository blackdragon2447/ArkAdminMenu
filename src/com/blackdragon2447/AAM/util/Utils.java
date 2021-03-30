package com.blackdragon2447.AAM.util;

import java.awt.Component;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;

import org.aeonbits.owner.ConfigFactory;

import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.gui.components.JNumberedButton;
import com.blackdragon2447.AAM.gui.components.JNumberedCheckbox;
import com.blackdragon2447.AAM.util.iface.AAMConfig;

/**
 * the utils class, contains multiple utility methods
 * @author Blackdragon2447
 */
public class Utils {
	
	/**
	 * this method finds buttons in the SCPanel and ACPanel by their number, for numbering these the JNumberedButton.java class is used
	 * @param Number the number of the button
	 * @return the found button
	 */
	public static JNumberedButton findButtonByNumber(int Number){
		Component[] components = AAMGui.GetSCPanel().getComponents();
		Component[] components2 = AAMGui.GetACPanel().getComponents();
		ArrayList<JNumberedButton> buttons = new ArrayList<JNumberedButton>();
		
		for(int i = 0; i < components.length; i++) {
			if(components[i] instanceof JNumberedButton) {
				buttons.add((JNumberedButton) components[i]);
			}
		}
		for(int i = 0; i < components2.length; i++) {
			if(components2[i] instanceof JNumberedButton) {
				buttons.add((JNumberedButton) components2[i]);
			}
		}
		
		JNumberedButton foundButton = buttons.stream()
				  .filter(JNumberedButton -> Number==(JNumberedButton.getNumber()))
				  .findAny()
				  .orElse(null);
		
		return foundButton;
	}
	
	/**
	 * same as findButtonByNumber but finds the button in the instead.
	 * @param Number the number of the button
	 * @return the found button
	 */
	public static JNumberedButton findButtonInListByNumber(int Number){
		ArrayList<JNumberedButton> buttons = Reference.FavoriteButtonList;
		
		JNumberedButton foundButton = buttons.stream()
				  .filter(JNumberedButton -> Number==(JNumberedButton.getNumber()))
				  .findAny()
				  .orElse(null);
		
		return foundButton;
	}
	
	/**
	 * same as the findButtonByNumber but for checkboxes, uses {@link JNumberedCheckbox}
	 * @param Number the number of the button
	 * @return the found button
	 */
	public static JNumberedCheckbox findCheckboxByNumber(int Number){
		Component[] components = AAMGui.GetSCPanel().getComponents();
		Component[] components2 = AAMGui.GetACPanel().getComponents();
		ArrayList<JNumberedCheckbox> boxes = new ArrayList<JNumberedCheckbox>();
		
		for(int i = 0; i < components.length; i++) {
			if(components[i] instanceof JNumberedCheckbox) {
				boxes.add((JNumberedCheckbox) components[i]);
			}
		}
		
		for(int i = 0; i < components2.length; i ++) {
			if(components2[i] instanceof JNumberedCheckbox) {
				boxes.add((JNumberedCheckbox) components2[i]);
			}
		}
		
		JNumberedCheckbox foundBox = boxes.stream()
				  .filter(JNumberedCheckbox -> Number==(JNumberedCheckbox.getNumber()))
				  .findAny()
				  .orElse(null);
		
		return foundBox;
	}
	
	/**
	 * finds a command in the list of commands
	 * @param commandNumber the number of the command
	 * @return the found command
	 */
	public static String GenerateCommand(int commandNumber) {
		String ListItem = Reference.SimpleCommandList.get(commandNumber).getFirstValue();
		return ListItem;
	}

	
	/**
	 * generates a label with text in a bigger font fur use as a title, used for generated lists of labels
	 * @param text the text to be put in the label
	 * @return the generated label
	 */
	public static JLabel generateTitleLabel(String text) {
		
		JLabel label = new JLabel(text);
		label.setFont(new Font(label.getFont().getFontName(), label.getFont().getStyle(), 18));
		return label;
		
	}
	
	/**
	 * adds a server to the config
	 * @param name the server name
	 * @param ip the server ip
	 * @param port the server port
	 */
	public static void AddServer(String name, String ip, int port) {
		AAMConfig cfg = ConfigFactory.create(AAMConfig.class);
		

		String [] arr = cfg.ServerNames();
		try {
			arr = Arrays.copyOf(arr, arr.length + 1);
		} catch (NullPointerException e2) {
			arr = new String[]{null};
		}
		arr[arr.length - 1] = name;
		cfg.setProperty("ServerNames", Arrays.toString(arr).replace("[", "").replace("]", ""));
		

		arr = cfg.IPs();
		try {
			arr = Arrays.copyOf(arr, arr.length + 1);
		} catch (NullPointerException e2) {
			arr = new String[]{null};
		}
		arr[arr.length - 1] = ip;
		cfg.setProperty("IPs", Arrays.toString(arr).replace("[", "").replace("]", ""));
		

		int[] arr2 = cfg.Ports();
		try {
			arr2 = Arrays.copyOf(arr2, arr2.length + 1);
		} catch (NullPointerException e2) {
			arr2 = new int[]{0};
		}
		arr2[arr2.length - 1] = port;
		cfg.setProperty("Ports", Arrays.toString(arr2).replace("[", "").replace("]", ""));
		
		try {
			cfg.store(new FileOutputStream("AAMConfig.properties"), "no comments");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public static <T>T[] AddToArray(T[] arr, T obj) {
	    arr = Arrays.copyOf(arr, arr.length + 1);
	    arr[arr.length - 1] = obj;
	    return arr;
	}
	
}
