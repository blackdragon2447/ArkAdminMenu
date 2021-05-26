package com.blackdragon2447.AAM.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.blackdragon2447.AAM.gui.dialog.CC.CommandSeriesDialog;
import com.blackdragon2447.AAM.gui.dialog.CC.PluginCommandDialog;
import com.blackdragon2447.AAM.gui.dialog.CC.ScriptCommandDialog;

/**
 * used to build the buttons used for the custom commands
 * @author Blackdragon2447
 *
 */
@SuppressWarnings("deprecation")
public class CustomButtonBuilder {

	/**
	 * builds the button for scriptcommands
	 * @param Name the name of the command
	 * @param Command the command itself
	 * @return the build button
	 */
	public static JButton BuildScriptButton(String Name, String Command){
		
		JButton button = new JButton(Name);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ScriptCommandDialog.createGui(Command);
			}
		});
		
		return button;
	}
	
	/**
	 * builds the button for scriptcommands
	 * @param Name the name of the command
	 * @param Command the command itself
	 * @param Args if the command needs args
	 * @return the build button
	 */
	public static JButton BuildPluginButton(String Name, String Command, Boolean Args){
		
		JButton button = new JButton(Name);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PluginCommandDialog.createGui(Command, Args);
			}
		});
		
		return button;
	}
	
	/**
	 * builds the button for scriptcommands
	 * @param Name the name of the command
	 * @param Commands the commands themselfs
	 * @return the build button
	 * 
	 * this one is not used at the moment and thus temporairly depricated
	 */

	@Deprecated
	public static JButton BuildSeriesButton(String Name, String[] Commands){
		
		JButton button = new JButton(Name);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CommandSeriesDialog.createGui(Commands);
			}
		});
		
		return button;
	}
	
}
