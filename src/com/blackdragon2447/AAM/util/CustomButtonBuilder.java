package com.blackdragon2447.AAM.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.blackdragon2447.AAM.gui.dialog.CC.CommandSeriesDialog;
import com.blackdragon2447.AAM.gui.dialog.CC.PluginCommandDialog;
import com.blackdragon2447.AAM.gui.dialog.CC.ScriptCommandDialog;

public class CustomButtonBuilder {

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
