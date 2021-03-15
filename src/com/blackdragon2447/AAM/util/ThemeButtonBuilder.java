package com.blackdragon2447.AAM.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.gui.AAMGui;

public class ThemeButtonBuilder {

	public static JMenuItem BuildThemeButton(Themes Theme) {
		
		JMenuItem item = new JMenuItem(Theme.toString());
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Themes theme[] = Themes.values();
				for (int i = 0; i < theme.length; i++) {
					if(theme[i].equals(Theme)){
						AAMGui.setVisual(Themes.getLookAndFeel(i));
						Reference.theme = i;
					}
				}
			}
		});
		
		return item;
	}
}
