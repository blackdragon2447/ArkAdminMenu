package com.blackdragon2447.AAM.gui.actionlistners;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;

import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.gui.components.JNumberedButton;
import com.blackdragon2447.AAM.gui.components.JNumberedCheckbox;
import com.blackdragon2447.AAM.gui.dialog.DinoWipeDialog;
import com.blackdragon2447.AAM.gui.dialog.SimpleCommandDialog;
import com.blackdragon2447.AAM.gui.dialog.advCom.AllPlayerPosReturnDialog;
import com.blackdragon2447.AAM.gui.dialog.advCom.ForceIntoTribeDialog;
import com.blackdragon2447.AAM.gui.dialog.advCom.GFICommandDialog;
import com.blackdragon2447.AAM.gui.dialog.advCom.GiveExpToPlayerDialog;
import com.blackdragon2447.AAM.gui.dialog.advCom.ListUnclaimedReturnDialog;
import com.blackdragon2447.AAM.gui.dialog.advCom.RenamePlayerDialog;
import com.blackdragon2447.AAM.gui.dialog.advCom.RenameTribeDialog;
import com.blackdragon2447.AAM.gui.dialog.advCom.SpawnDinoCoordsDialog;
import com.blackdragon2447.AAM.gui.dialog.advCom.SpawnDinoNearDialog;
import com.blackdragon2447.AAM.gui.dialog.advCom.SteamIDReturnDialog;
import com.blackdragon2447.AAM.util.RconHandler;
import com.blackdragon2447.AAM.util.Utils;

import net.kronos.rkon.core.ex.AuthenticationException;

/**
 * the class that contains the actionlistners that are used multiple times in the prorgram
 * @author Blackdragon2447
 */
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
	
	public static ActionListener AdvancedComListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JNumberedButton source = (JNumberedButton) e.getSource();
			
			switch (source.getNumber()) {
			case 14:
				try {
					GFICommandDialog.createGui();
				} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
				break;
			case 15:
				try {
					RenamePlayerDialog.createGui();
				} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
				break;
			case 16:
				try {
					RenameTribeDialog.createGui();
				} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
				break;
			case 17:
				try {
					ForceIntoTribeDialog.createGui();
				} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
				break;
			case 18:
				try {
					GiveExpToPlayerDialog.createGui();
				} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
				break;
			case 19:
				JOptionPane.showMessageDialog(AAMGui.getContentPanel(), "depricated", null, JOptionPane.ERROR_MESSAGE);
				break;
			case 20:
				SteamIDReturnDialog.createGui();
				break;
			case 21:
				try {
					SpawnDinoNearDialog.createGui();
				} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException
						| UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
				break;
			case 22:
				try {
					SpawnDinoCoordsDialog.createGui();
				} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
				break;
			case 23:
				AllPlayerPosReturnDialog.createGui();
				break;
			case 24:
				ListUnclaimedReturnDialog.createGui();
				break;
			case 25:
				DinoWipeDialog.CreateGui();
			default:
				break;
			}
		}
	};
	
	public static ActionListener RconRunListner = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			GridBagConstraints gbc_RconLabel = new GridBagConstraints();
			gbc_RconLabel.gridy = AAMGui.GridY;
			JLabel label;
			label = new JLabel(new Date().toString() + ": \t " + AAMGui.RconField.getText());
			label.setForeground(Color.yellow);
			AAMGui.RconLogPanel.add(label, gbc_RconLabel);
			AAMGui.GridY++;
			gbc_RconLabel.gridy = AAMGui.GridY;
			String result = null;
			if(!Reference.MultipleServer) {
				try {
					result = RconHandler.command(AAMGui.RconField.getText());
				} catch (Exception e1) {
					if(e1 instanceof AuthenticationException) result = "failed to outheticate";
					else if (Reference.Password == null) {
						label = new JLabel(new Date().toString() + ": \t " + "Not Logged On");
						label.setForeground(Color.red);
						AAMGui.RconLogPanel.add(label, gbc_RconLabel);
					}
					else {
						result = "an unkown error occured";
						e1.printStackTrace();
					}
				}
			} else {
				try {
					result = RconHandler.MultipleCommand(AAMGui.RconField.getText());
				} catch (Exception e1) {
					if(e1 instanceof AuthenticationException) result = "failed to outheticate";
					else if (Reference.Password == null) {
						label = new JLabel(new Date().toString() + ": \t " + "Not Logged On");
						label.setForeground(Color.red);
						AAMGui.RconLogPanel.add(label, gbc_RconLabel);
					}
					else {
						result = "an unkown error occured";
						e1.printStackTrace();
					}
				}
			}
			
			String[] lineResults;
			lineResults = result.split("\n");
			String[] finalResults = new String[lineResults.length/2];
			for (int i = 0; i < finalResults.length; i++) {
				finalResults[i] = lineResults[i*2] + ": " + lineResults[(i*2)+1];
			}
			for (String string : finalResults) {
				if(result != null) {
					if(result.contains("no response")) {
						label = new JLabel(new Date().toString() + ": \t " + "server recived, assuming it executed.");
						AAMGui.RconLogPanel.add(label, gbc_RconLabel);
					}
					else{
	
						label = new JLabel(new Date().toString() + ": \t " + string);
						AAMGui.RconLogPanel.add(label, gbc_RconLabel);
					}
				}
				AAMGui.RconField.setText("");
			}
		}
	};
	
	

}
