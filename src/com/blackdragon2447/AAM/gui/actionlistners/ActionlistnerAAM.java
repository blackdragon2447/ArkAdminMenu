package com.blackdragon2447.AAM.gui.actionlistners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;

import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.gui.components.JNumberedButton;
import com.blackdragon2447.AAM.gui.components.JNumberedCheckbox;
import com.blackdragon2447.AAM.gui.dialog.SimpleCommandDialog;
import com.blackdragon2447.AAM.util.RconHandler;
import com.blackdragon2447.AAM.util.Utils;

import net.kronos.rkon.core.ex.AuthenticationException;

public class ActionlistnerAAM {
	
	public static ActionListener FavButtonListner = new ActionListener() {
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JNumberedCheckbox component = (JNumberedCheckbox) e.getSource();
			if(((JNumberedCheckbox)e.getSource()).isSelected() == true) {
				try {
					AAMGui.AddFavorite((JNumberedButton) Utils.findButtonByNumber(component.getNumber()).clone());
				} catch (CloneNotSupportedException e1) {
					e1.printStackTrace();
				}
			}else {
				AAMGui.RemoveFavorite(Utils.findButtonInListByNumber(component.getNumber()));
			}
			

			
		}
	};
	
	public static ActionListener SimpleSCBListner = new ActionListener() {
		
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
	
	public static ActionListener QueueRemoveListner = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JNumberedButton button = (JNumberedButton) e.getSource();
			Reference.Queue.remove(button.getNumber());
			
			AAMGui.tabbedPaneOut.setSelectedIndex(0);
			AAMGui.tabbedPaneOut.setSelectedIndex(5);
		}
	};
	
	public static ActionListener RunListner = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			for(int i = 0; i < Reference.Queue.size(); i++) {
				try {
					RconHandler.command(Reference.Queue.get(i).generateCommand());
				} catch (IOException | AuthenticationException e1) {
					e1.printStackTrace();
				}
			}
			Reference.Queue.clear();
			

			AAMGui.tabbedPaneOut.setSelectedIndex(0);
			AAMGui.tabbedPaneOut.setSelectedIndex(5);
		}
	};
	
	public static ActionListener RunDelayListner = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			double delay = (double) AAMGui.DelaySpinner.getValue();
			
			for(int i = 0; i < Reference.Queue.size(); i++) {
				try {
					RconHandler.command(Reference.Queue.get(i).generateCommand());
				} catch (IOException | AuthenticationException e2) {
					e2.printStackTrace();
				}
				AAMGui.tabbedPaneOut.setSelectedIndex(0);
				AAMGui.tabbedPaneOut.setSelectedIndex(5);
				try {
					TimeUnit.SECONDS.sleep((long) delay);
				} catch (NumberFormatException | InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			Reference.Queue.clear();
			
			AAMGui.tabbedPaneOut.setSelectedIndex(0);
			AAMGui.tabbedPaneOut.setSelectedIndex(5);
		}
	};
	
	public static ActionListener FavRemoveListner = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			JPanel parent = (JPanel) source.getParent();
			JNumberedButton button = null;
			JNumberedButton removeButton = null;
			Component[] components = parent.getComponents();
			for(Component component : components) {
				if(component instanceof JNumberedButton) {
					button = (JNumberedButton) component;
					break;
				}
			}
			int Number = button.getNumber();
			removeButton = Utils.findButtonInListByNumber(Number);
			
			JNumberedCheckbox checkbox = Utils.findCheckboxByNumber(Number);
			checkbox.setSelected(false);
			
			Reference.FavoriteButtonList.remove(removeButton);
			AAMGui.tabbedPaneOut.setSelectedIndex(1);
			AAMGui.tabbedPaneOut.setSelectedIndex(0);
			
		}
	};
	
	public static ActionListener FavForwardListner = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton source = (JButton) e.getSource();
			JPanel parent = (JPanel) source.getParent();
			JNumberedButton button = null;
			int index = Integer.MAX_VALUE;
			Component[] components = parent.getComponents();
			for(Component component : components) {
				if(component instanceof JNumberedButton) {
					button = (JNumberedButton) component;
					break;
				}
			}
			
			if(Reference.FavoriteButtonList.contains(button)) {
				index = Reference.FavoriteButtonList.indexOf(button);
			}
			
			Reference.FavoriteButtonList.remove(index);
			Reference.FavoriteButtonList.add(index + 1, button);
			AAMGui.tabbedPaneOut.setSelectedIndex(1);
			AAMGui.tabbedPaneOut.setSelectedIndex(0);
			
		}
	};
	
public static ActionListener FavBackwardListner = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton source = (JButton) e.getSource();
			JPanel parent = (JPanel) source.getParent();
			JNumberedButton button = null;
			int index = Integer.MAX_VALUE;
			Component[] components = parent.getComponents();
			for(Component component : components) {
				if(component instanceof JNumberedButton) {
					button = (JNumberedButton) component;
					break;
				}
			}
			
			if(Reference.FavoriteButtonList.contains(button)) {
				index = Reference.FavoriteButtonList.indexOf(button);
			}
			
			Reference.FavoriteButtonList.remove(index);
			Reference.FavoriteButtonList.add(index - 1, button);
			AAMGui.tabbedPaneOut.setSelectedIndex(1);
			AAMGui.tabbedPaneOut.setSelectedIndex(0);
			
		}
	};
	
	

}
