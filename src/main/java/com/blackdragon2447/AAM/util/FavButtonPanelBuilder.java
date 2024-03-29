package com.blackdragon2447.AAM.util;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.aeonbits.owner.ConfigFactory;

import com.blackdragon2447.AAM.gui.actionlistners.ActionlistnerAAM;
import com.blackdragon2447.AAM.gui.components.JNumberedPanel;
import com.blackdragon2447.AAM.util.iface.AAMConfig;

public class FavButtonPanelBuilder {
	

	static AAMConfig cfg = ConfigFactory.create(AAMConfig.class);
	
	/**
	 * builds a panel with a favorited button a button to remove it and some arrows
	 * @param button the button to be put in the panel.
	 * @return returns a numbered panel with the needed components added
	 */
	public static JNumberedPanel buildPanel(JButton button) {
		
		
		try {
			UIManager.setLookAndFeel(Themes.getLookAndFeel(cfg.Theme()));
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(button == null) return new JNumberedPanel();
		
		
		JNumberedPanel panel = new JNumberedPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		JButton backwardButton = new JButton("<");
		panel.add(backwardButton);
		backwardButton.addActionListener(ActionlistnerAAM.FavBackwardListner);
		panel.add(Box.createHorizontalGlue());
		panel.add(button);
		button.setBounds(new Rectangle(149, 23));
		JButton deleteButton = new JButton("X");
		deleteButton.addActionListener(ActionlistnerAAM.FavRemoveListner);
		panel.add(deleteButton);
		panel.add(Box.createHorizontalGlue());
		JButton forwardButton = new JButton(">");
		panel.add(forwardButton);
		forwardButton.addActionListener(ActionlistnerAAM.FavForwardListner);
		panel.setBounds(new Rectangle(215, 23));
		panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		return panel;
		
	}

}
