package com.blackdragon2447.AAM.gui.actionlistners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.UnsupportedLookAndFeelException;

import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.gui.SimpleCommandDialog;
import com.blackdragon2447.AAM.gui.components.JNumberedButton;
import com.blackdragon2447.AAM.gui.components.JNumberedCheckbox;
import com.blackdragon2447.AAM.util.Utils;

public class ActionlistnerAAM {
	
	public static ActionListener FavButtonListner = new ActionListener() {
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JNumberedCheckbox component = (JNumberedCheckbox) e.getSource();
			if(((JNumberedCheckbox)e.getSource()).isSelected() == true) {
				AAMGui.AddFavorite(Utils.findButtonByNumber(component.getNumber()));
			}else {
				AAMGui.RemoveFavorite(Utils.findButtonByNumber(component.getNumber()));
			}

			
		}
	};
	
	public static ActionListener simpleSCBListner = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JNumberedButton component = (JNumberedButton) e.getSource();
			try {
				SimpleCommandDialog.createGui(component.getNumber()-1);
			} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException
					| UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
			
			
		}
	};
	
	

}
