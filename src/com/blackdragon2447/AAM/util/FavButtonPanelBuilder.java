package com.blackdragon2447.AAM.util;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import com.blackdragon2447.AAM.gui.components.JNumberedPanel;

public class FavButtonPanelBuilder {
	
	public static JNumberedPanel buildPanel(JButton button) {
		
		JNumberedPanel panel = new JNumberedPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		panel.add(new JButton("<"));
		panel.add(button);
		panel.add(new JButton("X"));
		panel.add(new JButton(">"));
		
		return panel;
		
	}

}
