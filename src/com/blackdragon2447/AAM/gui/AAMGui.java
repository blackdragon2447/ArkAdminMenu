package com.blackdragon2447.AAM.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.gui.actionlistners.ActionlistnerAAM;
import com.blackdragon2447.AAM.gui.components.JNumberedButton;
import com.blackdragon2447.AAM.gui.components.JNumberedCheckbox;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class AAMGui extends JFrame {
	private static final long serialVersionUID = -735583961255908606L;
	private JPanel contentPane;
	static JPanel simple_commands_panel = new JPanel();
	public static JRadioButtonMenuItem PFcheatRadioItem = new JRadioButtonMenuItem("cheat");
	public static JRadioButtonMenuItem PFacheatRadioItem = new JRadioButtonMenuItem("admin cheat");
	public static JRadioButtonMenuItem PFcustomRadioItem = new JRadioButtonMenuItem("custom prefix");

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws UnsupportedLookAndFeelException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		createGui();
	}
	
	public static void createGui() throws UnsupportedLookAndFeelException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		UIManager.setLookAndFeel(new FlatLightLaf());
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AAMGui frame = new AAMGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AAMGui() {
		setTitle("ArkAdminManager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 675, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu settingsMenu = new JMenu("settings");
		menuBar.add(settingsMenu);
		
		JMenuItem BPPMenuItem = new JMenuItem("import bp paths");
		settingsMenu.add(BPPMenuItem);
		
		JMenuItem IGSNewMenuItem_1 = new JMenuItem("in game settings");
		settingsMenu.add(IGSNewMenuItem_1);
		
		JCheckBoxMenuItem DTCheckItem = new JCheckBoxMenuItem("dark theme");
		settingsMenu.add(DTCheckItem);
		
		JMenu prefixMenu = new JMenu("command prefix");
		settingsMenu.add(prefixMenu);
		
		prefixMenu.add(PFcheatRadioItem);
		
		prefixMenu.add(PFacheatRadioItem);
		
		prefixMenu.add(PFcustomRadioItem);
		
		JMenuItem SetPFcustomMenuItem = new JMenuItem("set custom prefix");
		prefixMenu.add(SetPFcustomMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		DTCheckItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
					if(DTCheckItem.isSelected() == true == true) {
						try {
							UIManager.setLookAndFeel(new FlatDarkLaf());
							SwingUtilities.updateComponentTreeUI(contentPane);
							SwingUtilities.updateComponentTreeUI(menuBar);
						} catch (UnsupportedLookAndFeelException e1) {
							e1.printStackTrace();
						}
					}
					else {
						try {
							UIManager.setLookAndFeel(new FlatLightLaf());
							SwingUtilities.updateComponentTreeUI(contentPane);
							SwingUtilities.updateComponentTreeUI(menuBar);
						} catch (UnsupportedLookAndFeelException e1) {
							e1.printStackTrace();
						}
					}
			  }
		});
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel favorites_panel = new JPanel();
		favorites_panel.setToolTipText("");
		tabbedPane.addTab("favorites", null, favorites_panel, null);
		GridBagLayout gbl_favorites_panel = new GridBagLayout();
		gbl_favorites_panel.columnWidths = new int[]{215, 215, 215, 0};
		gbl_favorites_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		//gbl_favorites_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		favorites_panel.setLayout(gbl_favorites_panel);
		
		GridBagConstraints gbc_FavButtons = new GridBagConstraints();
		gbc_FavButtons.insets = new Insets(0, 0, 0, 5);
		gbc_FavButtons.gridx = 0;
		gbc_FavButtons.gridy = 0;
		gbc_FavButtons.fill = GridBagConstraints.BOTH;
		if(Reference.FavoriteButtonList != null) {
			for(JNumberedButton button : Reference.FavoriteButtonList) {
				favorites_panel.add(button, gbc_FavButtons);
				if(gbc_FavButtons.gridx != 2) {
					gbc_FavButtons.gridx++;
				}
				else{
					gbc_FavButtons.gridx = 0; gbc_FavButtons.gridy++;
				}
			}
		}
		
		simple_commands_panel.setToolTipText("commands requiring at max one argument");
		tabbedPane.addTab("simple commands", null, simple_commands_panel, null);
		GridBagLayout gbl_simple_commands_panel = new GridBagLayout();
		gbl_simple_commands_panel.columnWidths = new int[]{185, 0, 185, 0, 185, 0, 0};
		gbl_simple_commands_panel.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_simple_commands_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_simple_commands_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		simple_commands_panel.setLayout(gbl_simple_commands_panel);
		
		JLabel SCDescLabel = new JLabel("commands requiring at max one argument");
		SCDescLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		SCDescLabel.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_SCDescLabel = new GridBagConstraints();
		gbc_SCDescLabel.gridwidth = 5;
		gbc_SCDescLabel.insets = new Insets(0, 0, 5, 5);
		gbc_SCDescLabel.gridx = 0;
		gbc_SCDescLabel.gridy = 0;
		simple_commands_panel.add(SCDescLabel, gbc_SCDescLabel);
		
		JLabel BasicCLabel = new JLabel("basic commands");
		GridBagConstraints gbc_BasicCLabel = new GridBagConstraints();
		gbc_BasicCLabel.insets = new Insets(0, 0, 5, 5);
		gbc_BasicCLabel.gridx = 2;
		gbc_BasicCLabel.gridy = 1;
		simple_commands_panel.add(BasicCLabel, gbc_BasicCLabel);
		
		JNumberedButton SetTimeButton = new JNumberedButton("set time", 1);
		GridBagConstraints gbc_SetTimeButton = new GridBagConstraints();
		gbc_SetTimeButton.fill = GridBagConstraints.BOTH;
		gbc_SetTimeButton.insets = new Insets(0, 0, 5, 5);
		gbc_SetTimeButton.gridx = 0;
		gbc_SetTimeButton.gridy = 2;
		simple_commands_panel.add(SetTimeButton, gbc_SetTimeButton);
		SetTimeButton.addActionListener(ActionlistnerAAM.simpleSCBListner);
		
		JNumberedCheckbox SetTimeCheckBox = new JNumberedCheckbox("", 1);
		GridBagConstraints gbc_SetTimeCheckBox = new GridBagConstraints();
		gbc_SetTimeCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_SetTimeCheckBox.gridx = 1;
		gbc_SetTimeCheckBox.gridy = 2;
		simple_commands_panel.add(SetTimeCheckBox, gbc_SetTimeCheckBox);
		SetTimeCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		JNumberedButton PlayerOnlyButton = new JNumberedButton("players only", 2);
		GridBagConstraints gbc_PlayerOnlyButton = new GridBagConstraints();
		gbc_PlayerOnlyButton.fill = GridBagConstraints.BOTH;
		gbc_PlayerOnlyButton.insets = new Insets(0, 0, 5, 5);
		gbc_PlayerOnlyButton.gridx = 2;
		gbc_PlayerOnlyButton.gridy = 2;
		simple_commands_panel.add(PlayerOnlyButton, gbc_PlayerOnlyButton);
		PlayerOnlyButton.addActionListener(ActionlistnerAAM.simpleSCBListner);
		
		JNumberedCheckbox PlayerOnlyCheckBox = new JNumberedCheckbox("", 2);
		GridBagConstraints gbc_PlayerOnlyCheckBox = new GridBagConstraints();
		gbc_PlayerOnlyCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_PlayerOnlyCheckBox.gridx = 3;
		gbc_PlayerOnlyCheckBox.gridy = 2;
		simple_commands_panel.add(PlayerOnlyCheckBox, gbc_PlayerOnlyCheckBox);
		PlayerOnlyCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		JNumberedButton ToggleDNButton = new JNumberedButton("toggle damage numbers", 3);
		GridBagConstraints gbc_ToggleDNNewButton = new GridBagConstraints();
		gbc_ToggleDNNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_ToggleDNNewButton.fill = GridBagConstraints.BOTH;
		gbc_ToggleDNNewButton.gridx = 4;
		gbc_ToggleDNNewButton.gridy = 2;
		simple_commands_panel.add(ToggleDNButton, gbc_ToggleDNNewButton);
		ToggleDNButton.addActionListener(ActionlistnerAAM.simpleSCBListner);
		
		JNumberedCheckbox ToggleDNCheckBox = new JNumberedCheckbox("", 3);
		GridBagConstraints gbc_ToggleDNCheckBox = new GridBagConstraints();
		gbc_ToggleDNCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_ToggleDNCheckBox.gridx = 5;
		gbc_ToggleDNCheckBox.gridy = 2;
		simple_commands_panel.add(ToggleDNCheckBox, gbc_ToggleDNCheckBox);
		ToggleDNCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		JLabel MessagingCLabel = new JLabel("messaging");
		GridBagConstraints gbc_MessagingCLabel = new GridBagConstraints();
		gbc_MessagingCLabel.insets = new Insets(0, 0, 5, 5);
		gbc_MessagingCLabel.gridx = 2;
		gbc_MessagingCLabel.gridy = 3;
		simple_commands_panel.add(MessagingCLabel, gbc_MessagingCLabel);
		
		JNumberedButton BroadCastButton = new JNumberedButton("broadcast", 4);
		GridBagConstraints gbc_BroadCastButton = new GridBagConstraints();
		gbc_BroadCastButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_BroadCastButton.anchor = GridBagConstraints.SOUTH;
		gbc_BroadCastButton.insets = new Insets(0, 0, 5, 5);
		gbc_BroadCastButton.gridx = 0;
		gbc_BroadCastButton.gridy = 4;
		simple_commands_panel.add(BroadCastButton, gbc_BroadCastButton);
		BroadCastButton.addActionListener(ActionlistnerAAM.simpleSCBListner);
		
		JNumberedCheckbox BroadCastCheckBox = new JNumberedCheckbox("", 4);
		GridBagConstraints gbc_BroadCastCheckBox = new GridBagConstraints();
		gbc_BroadCastCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_BroadCastCheckBox.gridx = 1;
		gbc_BroadCastCheckBox.gridy = 4;
		simple_commands_panel.add(BroadCastCheckBox, gbc_BroadCastCheckBox);
		BroadCastCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		JNumberedButton ChatMessageButton = new JNumberedButton("send chat message", 5);
		GridBagConstraints gbc_ChatMessageButton = new GridBagConstraints();
		gbc_ChatMessageButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_ChatMessageButton.insets = new Insets(0, 0, 5, 5);
		gbc_ChatMessageButton.gridx = 2;
		gbc_ChatMessageButton.gridy = 4;
		simple_commands_panel.add(ChatMessageButton, gbc_ChatMessageButton);
		ChatMessageButton.addActionListener(ActionlistnerAAM.simpleSCBListner);
		
		JNumberedCheckbox ChatMessageCheckBox = new JNumberedCheckbox("", 5);
		GridBagConstraints gbc_ChatMessageCheckBox = new GridBagConstraints();
		gbc_ChatMessageCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_ChatMessageCheckBox.gridx = 3;
		gbc_ChatMessageCheckBox.gridy = 4;
		simple_commands_panel.add(ChatMessageCheckBox, gbc_ChatMessageCheckBox);
		ChatMessageCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		JLabel LogsLabel = new JLabel("logs");
		LogsLabel.setBackground(Color.GRAY);
		GridBagConstraints gbc_LogsLabel = new GridBagConstraints();
		gbc_LogsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_LogsLabel.gridx = 2;
		gbc_LogsLabel.gridy = 5;
		simple_commands_panel.add(LogsLabel, gbc_LogsLabel);
		
		JNumberedButton ChatLogButton = new JNumberedButton("get chat log", 6);
		GridBagConstraints gbc_ChatLogButton = new GridBagConstraints();
		gbc_ChatLogButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_ChatLogButton.insets = new Insets(0, 0, 5, 5);
		gbc_ChatLogButton.gridx = 0;
		gbc_ChatLogButton.gridy = 6;
		simple_commands_panel.add(ChatLogButton, gbc_ChatLogButton);
		ChatLogButton.addActionListener(ActionlistnerAAM.simpleSCBListner);
		
		JNumberedCheckbox ChatLogCheckBox = new JNumberedCheckbox("", 6);
		GridBagConstraints gbc_ChatLogCheckBox = new GridBagConstraints();
		gbc_ChatLogCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_ChatLogCheckBox.gridx = 1;
		gbc_ChatLogCheckBox.gridy = 6;
		simple_commands_panel.add(ChatLogCheckBox, gbc_ChatLogCheckBox);
		ChatLogCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		JNumberedButton GameLogButton = new JNumberedButton("get game log", 7);
		GridBagConstraints gbc_GameLogButton = new GridBagConstraints();
		gbc_GameLogButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_GameLogButton.insets = new Insets(0, 0, 5, 5);
		gbc_GameLogButton.gridx = 2;
		gbc_GameLogButton.gridy = 6;
		simple_commands_panel.add(GameLogButton, gbc_GameLogButton);
		GameLogButton.addActionListener(ActionlistnerAAM.simpleSCBListner);
		
		JNumberedCheckbox GameLogCheckBox = new JNumberedCheckbox("", 7);
		GridBagConstraints gbc_GameLogCheckBox = new GridBagConstraints();
		gbc_GameLogCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_GameLogCheckBox.gridx = 3;
		gbc_GameLogCheckBox.gridy = 6;
		simple_commands_panel.add(GameLogCheckBox, gbc_GameLogCheckBox);
		GameLogCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		JLabel ServerManagementLabel = new JLabel("server managemnt");
		ServerManagementLabel.setBackground(Color.GRAY);
		GridBagConstraints gbc_ServerManagementLabel = new GridBagConstraints();
		gbc_ServerManagementLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ServerManagementLabel.gridx = 2;
		gbc_ServerManagementLabel.gridy = 7;
		simple_commands_panel.add(ServerManagementLabel, gbc_ServerManagementLabel);
		
		JNumberedButton StopServerButton = new JNumberedButton("stop server", 8);
		GridBagConstraints gbc_StopServerButton = new GridBagConstraints();
		gbc_StopServerButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_StopServerButton.insets = new Insets(0, 0, 5, 5);
		gbc_StopServerButton.gridx = 0;
		gbc_StopServerButton.gridy = 8;
		simple_commands_panel.add(StopServerButton, gbc_StopServerButton);
		StopServerButton.addActionListener(ActionlistnerAAM.simpleSCBListner);
		
		JNumberedCheckbox StopServerCheckBox = new JNumberedCheckbox("", 8);
		GridBagConstraints gbc_StopServerCheckBox = new GridBagConstraints();
		gbc_StopServerCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_StopServerCheckBox.gridx = 1;
		gbc_StopServerCheckBox.gridy = 8;
		simple_commands_panel.add(StopServerCheckBox, gbc_StopServerCheckBox);
		StopServerCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		JNumberedButton SaveGameButton = new JNumberedButton("save game files", 9);
		GridBagConstraints gbc_SaveGameButton = new GridBagConstraints();
		gbc_SaveGameButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_SaveGameButton.insets = new Insets(0, 0, 5, 5);
		gbc_SaveGameButton.gridx = 2;
		gbc_SaveGameButton.gridy = 8;
		simple_commands_panel.add(SaveGameButton, gbc_SaveGameButton);
		SaveGameButton.addActionListener(ActionlistnerAAM.simpleSCBListner);
		
		JNumberedCheckbox SaveGameCheckBox = new JNumberedCheckbox("", 9);
		GridBagConstraints gbc_SaveGameCheckBox = new GridBagConstraints();
		gbc_SaveGameCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_SaveGameCheckBox.gridx = 3;
		gbc_SaveGameCheckBox.gridy = 8;
		simple_commands_panel.add(SaveGameCheckBox, gbc_SaveGameCheckBox);
		SaveGameCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		JNumberedButton DinoWipeButton = new JNumberedButton("dino wipe", 10);
		GridBagConstraints gbc_DinoWipeButton = new GridBagConstraints();
		gbc_DinoWipeButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_DinoWipeButton.insets = new Insets(0, 0, 5, 5);
		gbc_DinoWipeButton.gridx = 4;
		gbc_DinoWipeButton.gridy = 8;
		simple_commands_panel.add(DinoWipeButton, gbc_DinoWipeButton);
		DinoWipeButton.addActionListener(ActionlistnerAAM.simpleSCBListner);
		
		JNumberedCheckbox DinoWipeCheckBox = new JNumberedCheckbox("", 10);
		GridBagConstraints gbc_DinoWipeCheckBox = new GridBagConstraints();
		gbc_DinoWipeCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_DinoWipeCheckBox.gridx = 5;
		gbc_DinoWipeCheckBox.gridy = 8;
		simple_commands_panel.add(DinoWipeCheckBox, gbc_DinoWipeCheckBox);
		DinoWipeCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		JLabel Moderation = new JLabel("moderation");
		GridBagConstraints gbc_Moderation = new GridBagConstraints();
		gbc_Moderation.insets = new Insets(0, 0, 5, 5);
		gbc_Moderation.gridx = 2;
		gbc_Moderation.gridy = 9;
		simple_commands_panel.add(Moderation, gbc_Moderation);
		
		JNumberedButton BanButton = new JNumberedButton("ban player", 11);
		GridBagConstraints gbc_BanButton = new GridBagConstraints();
		gbc_BanButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_BanButton.insets = new Insets(0, 0, 0, 5);
		gbc_BanButton.gridx = 0;
		gbc_BanButton.gridy = 10;
		simple_commands_panel.add(BanButton, gbc_BanButton);
		BanButton.addActionListener(ActionlistnerAAM.simpleSCBListner);
		
		JNumberedCheckbox BanCheckBox = new JNumberedCheckbox("", 11);
		GridBagConstraints gbc_BanCheckBox = new GridBagConstraints();
		gbc_BanCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_BanCheckBox.gridx = 1;
		gbc_BanCheckBox.gridy = 10;
		simple_commands_panel.add(BanCheckBox, gbc_BanCheckBox);
		BanCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		JNumberedButton UnbanButton = new JNumberedButton("unban player", 12);
		GridBagConstraints gbc_UnbanButton = new GridBagConstraints();
		gbc_UnbanButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_UnbanButton.insets = new Insets(0, 0, 0, 5);
		gbc_UnbanButton.gridx = 2;
		gbc_UnbanButton.gridy = 10;
		simple_commands_panel.add(UnbanButton, gbc_UnbanButton);
		UnbanButton.addActionListener(ActionlistnerAAM.simpleSCBListner);
		
		JNumberedCheckbox UnbanCheckBox = new JNumberedCheckbox("", 12);
		GridBagConstraints gbc_UnbanCheckBox = new GridBagConstraints();
		gbc_UnbanCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_UnbanCheckBox.gridx = 3;
		gbc_UnbanCheckBox.gridy = 10;
		simple_commands_panel.add(UnbanCheckBox, gbc_UnbanCheckBox);
		UnbanCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		JNumberedButton KickButton = new JNumberedButton("kick player", 13);
		GridBagConstraints gbc_KickButton = new GridBagConstraints();
		gbc_KickButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_KickButton.insets = new Insets(0, 0, 0, 5);
		gbc_KickButton.gridx = 4;
		gbc_KickButton.gridy = 10;
		simple_commands_panel.add(KickButton, gbc_KickButton);
		KickButton.addActionListener(ActionlistnerAAM.simpleSCBListner);
		
		JNumberedCheckbox KickCheckBox = new JNumberedCheckbox("", 13);
		GridBagConstraints gbc_KickCheckBox = new GridBagConstraints();
		gbc_KickCheckBox.gridx = 5;
		gbc_KickCheckBox.gridy = 10;
		simple_commands_panel.add(KickCheckBox, gbc_KickCheckBox);
		KickCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		JPanel advanced_commands_panel = new JPanel();
		tabbedPane.addTab("advanced commands", null, advanced_commands_panel, null);
		
		JPanel custom_commands_panel = new JPanel();
		tabbedPane.addTab("custom commands", null, custom_commands_panel, null);
		
		JPanel impoted_items_panel = new JPanel();
		tabbedPane.addTab("imported items", null, impoted_items_panel, null);
		
		tabbedPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				favorites_panel.removeAll();
				favorites_panel.revalidate();
				favorites_panel.repaint();
				gbc_FavButtons.insets = new Insets(0, 0, 0, 5);
				gbc_FavButtons.gridx = 0;
				gbc_FavButtons.gridy = 0;
				if(tabbedPane.getSelectedIndex() == 0) {
					if(Reference.FavoriteButtonList != null) {
						for(JNumberedButton button : Reference.FavoriteButtonList) {
							favorites_panel.add(button, gbc_FavButtons);
							if(gbc_FavButtons.gridx != 2) {
								gbc_FavButtons.gridx++;
							}
							else{
								gbc_FavButtons.gridx = 0; gbc_FavButtons.gridy++;
							}
						}
					}
				}else if(tabbedPane.getSelectedIndex() == 1) {
					simple_commands_panel.removeAll();
					simple_commands_panel.revalidate();
					simple_commands_panel.repaint();
					simple_commands_panel.add(SCDescLabel, gbc_SCDescLabel);
					simple_commands_panel.add(BasicCLabel, gbc_BasicCLabel);
					simple_commands_panel.add(SetTimeButton, gbc_SetTimeButton);
					simple_commands_panel.add(SetTimeCheckBox, gbc_SetTimeCheckBox);
					simple_commands_panel.add(PlayerOnlyButton, gbc_PlayerOnlyButton);
					simple_commands_panel.add(PlayerOnlyCheckBox, gbc_PlayerOnlyCheckBox);
					simple_commands_panel.add(ToggleDNButton, gbc_ToggleDNNewButton);
					simple_commands_panel.add(ToggleDNCheckBox, gbc_ToggleDNCheckBox);
					simple_commands_panel.add(MessagingCLabel, gbc_MessagingCLabel);
					simple_commands_panel.add(BroadCastButton, gbc_BroadCastButton);
					simple_commands_panel.add(BroadCastCheckBox, gbc_BroadCastCheckBox);
					simple_commands_panel.add(ChatMessageButton, gbc_ChatMessageButton);
					simple_commands_panel.add(ChatMessageCheckBox, gbc_ChatMessageCheckBox);
					simple_commands_panel.add(LogsLabel, gbc_LogsLabel);
					simple_commands_panel.add(ChatLogButton, gbc_ChatLogButton);
					simple_commands_panel.add(ChatLogCheckBox, gbc_ChatLogCheckBox);
					simple_commands_panel.add(GameLogButton, gbc_GameLogButton);
					simple_commands_panel.add(GameLogCheckBox, gbc_GameLogCheckBox);
					simple_commands_panel.add(ServerManagementLabel, gbc_ServerManagementLabel);
					simple_commands_panel.add(StopServerButton, gbc_StopServerButton);
					simple_commands_panel.add(StopServerCheckBox, gbc_StopServerCheckBox);
					simple_commands_panel.add(SaveGameButton, gbc_SaveGameButton);
					simple_commands_panel.add(SaveGameCheckBox, gbc_SaveGameCheckBox);
					simple_commands_panel.add(DinoWipeButton, gbc_DinoWipeButton);
					simple_commands_panel.add(DinoWipeCheckBox, gbc_DinoWipeCheckBox);
					simple_commands_panel.add(Moderation, gbc_Moderation);
					simple_commands_panel.add(BanButton, gbc_BanButton);
					simple_commands_panel.add(BanCheckBox, gbc_BanCheckBox);
					simple_commands_panel.add(UnbanButton, gbc_UnbanButton);
					simple_commands_panel.add(UnbanCheckBox, gbc_UnbanCheckBox);
					simple_commands_panel.add(KickButton, gbc_KickButton);
					simple_commands_panel.add(KickCheckBox, gbc_KickCheckBox);

				}
				
			}
		});
	}
	
	public static void AddFavorite(JNumberedButton button) {
		Reference.FavoriteButtonList.add(button);
	}
	
	public static void RemoveFavorite(JNumberedButton Button) {
		Reference.FavoriteButtonList.remove(Button);
	}
	
	public static JPanel GetSCPanel() {
		return simple_commands_panel;
	}

}
