package com.blackdragon2447.AAM.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.aeonbits.owner.ConfigFactory;

import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.gui.actionlistners.ActionlistnerAAM;
import com.blackdragon2447.AAM.gui.components.JNumberedButton;
import com.blackdragon2447.AAM.gui.components.JNumberedCheckbox;
import com.blackdragon2447.AAM.gui.dialog.CustomPFDialog;
import com.blackdragon2447.AAM.gui.dialog.HelpDialog;
import com.blackdragon2447.AAM.gui.dialog.ImportItemsDialog;
import com.blackdragon2447.AAM.util.AAMConfig;
import com.blackdragon2447.AAM.util.FavButtonPanelBuilder;
import com.blackdragon2447.AAM.util.Utils;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class AAMGui extends JFrame {
	private static final long serialVersionUID = -735583961255908606L;
	private JPanel contentPane;
	static JPanel simple_commands_panel = new JPanel();
	public static JRadioButtonMenuItem PFcheatRadioItem = new JRadioButtonMenuItem("cheat");
	public static JRadioButtonMenuItem PFacheatRadioItem = new JRadioButtonMenuItem("admin cheat");
	public static JRadioButtonMenuItem PFcustomRadioItem = new JRadioButtonMenuItem("custom prefix");
	ButtonGroup group = new ButtonGroup();
	
	public static JPanel queuePanel = new JPanel();
	public static JPanel queueList = new JPanel();
	public static GridBagConstraints gbc_queueList = new GridBagConstraints();
	public static GridBagLayout gbl_queuePanel = new GridBagLayout();
	public static GridBagLayout gbl_queueList = new GridBagLayout();
	public static JLabel commandLable = new JLabel("command");
	public static GridBagConstraints gbc_commandLable = new GridBagConstraints();
	public static JLabel RemoveLabel = new JLabel("remove");
	public static GridBagConstraints gbc_RemoveLabel = new GridBagConstraints();
	public static GridBagConstraints gbc_commandList = new GridBagConstraints();
	public static GridBagConstraints gbc_commandButtonList = new GridBagConstraints();
	public static JTabbedPane tabbedPaneOut;
	public static JSpinner DelaySpinner = new JSpinner(new SpinnerNumberModel(0, 0, 30, 0.1));
	JScrollPane scrollPane;
	Rectangle DefSPbounds;
	JPanel scrollPanel;
	JButton HelpButton;
	AAMConfig cfg = ConfigFactory.create(AAMConfig.class);

	
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
		BPPMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ImportItemsDialog.createDialog();
			}
		});
		
		JMenuItem IGSNewMenuItem_1 = new JMenuItem("in game settings");
		settingsMenu.add(IGSNewMenuItem_1);
		
		JCheckBoxMenuItem DTCheckItem = new JCheckBoxMenuItem("dark theme");
		settingsMenu.add(DTCheckItem);
		
		JMenu prefixMenu = new JMenu("command prefix");
		settingsMenu.add(prefixMenu);
		group.add(PFacheatRadioItem);
		group.add(PFcheatRadioItem);
		group.add(PFcustomRadioItem);
		
		prefixMenu.add(PFcheatRadioItem);
		PFcheatRadioItem.setSelected(true);
		
		prefixMenu.add(PFacheatRadioItem);
		
		prefixMenu.add(PFcustomRadioItem);
		
		JMenuItem SetPFcustomMenuItem = new JMenuItem("set custom prefix");
		SetPFcustomMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomPFDialog.createDialog();
			}
		});
		prefixMenu.add(SetPFcustomMenuItem);
		
		JMenuItem helpMenuItem = new JMenuItem("help");
		helpMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpDialog.createDialog();
			}
		});
		settingsMenu.add(helpMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		System.out.println(cfg.Darkmode());
		
		if(cfg.Darkmode() == true) {
			try {
				UIManager.setLookAndFeel(new FlatDarkLaf());
				SwingUtilities.updateComponentTreeUI(contentPane);
				SwingUtilities.updateComponentTreeUI(menuBar);
			} catch (UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
			DTCheckItem.setSelected(cfg.Darkmode());
		}
		
		
		DTCheckItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
					if(DTCheckItem.isSelected() == true) {
						try {
							UIManager.setLookAndFeel(new FlatDarkLaf());
							SwingUtilities.updateComponentTreeUI(contentPane);
							SwingUtilities.updateComponentTreeUI(menuBar);
						} catch (UnsupportedLookAndFeelException e1) {
							e1.printStackTrace();
						}
						cfg.setProperty("Darkmode", "true");
						System.out.println(cfg.Darkmode());
						try {
							cfg.store(new FileOutputStream("AAMConfig.properties"), "no comments");
						} catch (IOException e1) {
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
						cfg.setProperty("Darkmode", "false");
						System.out.println(cfg.Darkmode());
						try {
							cfg.store(new FileOutputStream("AAMConfig.properties"), "no comments");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
			  }
		});
		

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		tabbedPaneOut = tabbedPane;
		
		JPanel favorites_panel = new JPanel();
		favorites_panel.setToolTipText("");
		tabbedPane.addTab("favorites", null, favorites_panel, null);
		GridBagLayout gbl_favorites_panel = new GridBagLayout();
		gbl_favorites_panel.rowWeights = new double[]{};
		gbl_favorites_panel.columnWidths = new int[]{215, 215, 215, 0};
		gbl_favorites_panel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		favorites_panel.setLayout(gbl_favorites_panel);
		
		GridBagConstraints gbc_FavButtons = new GridBagConstraints();
		gbc_FavButtons.insets = new Insets(0, 0, 0, 5);
		gbc_FavButtons.gridx = 0;
		gbc_FavButtons.gridy = 0;
		gbc_FavButtons.fill = GridBagConstraints.BOTH;
		
		@SuppressWarnings("unused")
		JButton FavHelp = new JButton("?");
		GridBagConstraints gbc_FavHelp = new GridBagConstraints();
		gbc_FavHelp.insets = new Insets(0, 0, 0, 5);
		gbc_FavHelp.gridx = 0;
		gbc_FavHelp.gridy = 0;
		
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
		
		
		simple_commands_panel.setToolTipText("");
		tabbedPane.addTab("simple commands", null, simple_commands_panel, null);
		GridBagLayout gbl_simple_commands_panel = new GridBagLayout();
		gbl_simple_commands_panel.columnWidths = new int[]{185, 0, 185, 0, 185, 0, 0};
		gbl_simple_commands_panel.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_simple_commands_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_simple_commands_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		simple_commands_panel.setLayout(gbl_simple_commands_panel);
		
		JLabel SCDescLabel = new JLabel("commands with one argument.");
		SCDescLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
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
		
		HelpButton = new JButton("?");
		HelpButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_HelpButton = new GridBagConstraints();
		gbc_HelpButton.insets = new Insets(0, 0, 5, 0);
		gbc_HelpButton.fill = GridBagConstraints.BOTH;
		gbc_HelpButton.gridx = 5;
		gbc_HelpButton.gridy = 1;
		simple_commands_panel.add(HelpButton, gbc_HelpButton);
		HelpButton.setToolTipText("<html>these are simple commands, thier argument can<br>be set after clicking the button and will need to be<br>reset after every run. saving of full comands is comming, hopefully.</html>");
		
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
		gbc_BanButton.insets = new Insets(0, 0, 5, 5);
		gbc_BanButton.gridx = 0;
		gbc_BanButton.gridy = 10;
		simple_commands_panel.add(BanButton, gbc_BanButton);
		BanButton.addActionListener(ActionlistnerAAM.simpleSCBListner);
		
		JNumberedCheckbox BanCheckBox = new JNumberedCheckbox("", 11);
		GridBagConstraints gbc_BanCheckBox = new GridBagConstraints();
		gbc_BanCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_BanCheckBox.gridx = 1;
		gbc_BanCheckBox.gridy = 10;
		simple_commands_panel.add(BanCheckBox, gbc_BanCheckBox);
		BanCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		JNumberedButton UnbanButton = new JNumberedButton("unban player", 12);
		GridBagConstraints gbc_UnbanButton = new GridBagConstraints();
		gbc_UnbanButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_UnbanButton.insets = new Insets(0, 0, 5, 5);
		gbc_UnbanButton.gridx = 2;
		gbc_UnbanButton.gridy = 10;
		simple_commands_panel.add(UnbanButton, gbc_UnbanButton);
		UnbanButton.addActionListener(ActionlistnerAAM.simpleSCBListner);
		
		JNumberedCheckbox UnbanCheckBox = new JNumberedCheckbox("", 12);
		GridBagConstraints gbc_UnbanCheckBox = new GridBagConstraints();
		gbc_UnbanCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_UnbanCheckBox.gridx = 3;
		gbc_UnbanCheckBox.gridy = 10;
		simple_commands_panel.add(UnbanCheckBox, gbc_UnbanCheckBox);
		UnbanCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		JNumberedButton KickButton = new JNumberedButton("kick player", 13);
		GridBagConstraints gbc_KickButton = new GridBagConstraints();
		gbc_KickButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_KickButton.insets = new Insets(0, 0, 5, 5);
		gbc_KickButton.gridx = 4;
		gbc_KickButton.gridy = 10;
		simple_commands_panel.add(KickButton, gbc_KickButton);
		KickButton.addActionListener(ActionlistnerAAM.simpleSCBListner);
		
		JNumberedCheckbox KickCheckBox = new JNumberedCheckbox("", 13);
		GridBagConstraints gbc_KickCheckBox = new GridBagConstraints();
		gbc_KickCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_KickCheckBox.gridx = 5;
		gbc_KickCheckBox.gridy = 10;
		simple_commands_panel.add(KickCheckBox, gbc_KickCheckBox);
		KickCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		JPanel advanced_commands_panel = new JPanel();
		tabbedPane.addTab("advanced commands", null, advanced_commands_panel, null);
		GridBagLayout gbl_advanced_commands_panel = new GridBagLayout();
		gbl_advanced_commands_panel.columnWidths = new int[]{185, 0, 185, 0, 185, 0, 0};
		gbl_advanced_commands_panel.rowHeights = new int[]{23, 0, 0, 0};
		gbl_advanced_commands_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_advanced_commands_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		advanced_commands_panel.setLayout(gbl_advanced_commands_panel);
		
		JButton btnNewButton_3 = new JButton("?");
		btnNewButton_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton_3.setToolTipText("<html>this tab is going to have more<br>\r\nadvanced commands like:<br>\r\nGFI<br>\r\nchanging a players name<br>\r\nand more but for now it is a nonfuctional<br>\r\nmess of placeholders</html>");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 5;
		gbc_btnNewButton_3.gridy = 1;
		advanced_commands_panel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton = new JNumberedButton("placeholder");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		advanced_commands_panel.add(btnNewButton, gbc_btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JNumberedCheckbox("");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 2;
		advanced_commands_panel.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JButton btnNewButton_1 = new JNumberedButton("placeholder");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 2;
		advanced_commands_panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JCheckBox chckbxNewCheckBox_1 = new JNumberedCheckbox("");
		GridBagConstraints gbc_chckbxNewCheckBox_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox_1.gridx = 3;
		gbc_chckbxNewCheckBox_1.gridy = 2;
		advanced_commands_panel.add(chckbxNewCheckBox_1, gbc_chckbxNewCheckBox_1);
		
		JButton btnNewButton_2 = new JNumberedButton("placeholder");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.gridx = 4;
		gbc_btnNewButton_2.gridy = 2;
		advanced_commands_panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JCheckBox chckbxNewCheckBox_2 = new JNumberedCheckbox("");
		GridBagConstraints gbc_chckbxNewCheckBox_2 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_2.gridx = 5;
		gbc_chckbxNewCheckBox_2.gridy = 2;
		advanced_commands_panel.add(chckbxNewCheckBox_2, gbc_chckbxNewCheckBox_2);
		
		JPanel custom_commands_panel = new JPanel();
		tabbedPane.addTab("custom commands", null, custom_commands_panel, null);
		GridBagLayout gbl_custom_commands_panel = new GridBagLayout();
		gbl_custom_commands_panel.columnWidths = new int[]{603, 24, 0};
		gbl_custom_commands_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_custom_commands_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_custom_commands_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		custom_commands_panel.setLayout(gbl_custom_commands_panel);
		
		JLabel lblNewLabel = new JLabel("Custom Commands");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		custom_commands_panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton_5 = new JButton("\u2795");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 0;
		custom_commands_panel.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("press the + to add more commands hover over ? for more help");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		custom_commands_panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnNewButton_4 = new JButton("?");
		btnNewButton_4.setToolTipText("<html>this tab allows you to register custom commands,<br>\r\n\nthese can consist of a series of commands that wil<br>\n\r\nbe executed at once by entering multiple commands<br>\r\n\nin one and separating them with a | (vertical line) or, if<br>\n\r\nmods that support them are installed, using the<br>\r\n\n\"ScriptCommand\" command for use with mods, more<br>\n\r\noptions may be added later depending on the server host API.<br>\r\n\nsee \"help\" under settings for a detailed explanation of the<br>\r\n\ncommand creation GUI.</html>");
		btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 1;
		custom_commands_panel.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JPanel impoted_items_panel = new JPanel();
		tabbedPane.addTab("imported items", null, impoted_items_panel, null);
		GridBagLayout gbl_impoted_items_panel = new GridBagLayout();
		gbl_impoted_items_panel.columnWidths = new int[]{40, 564, 40, 0};
		gbl_impoted_items_panel.rowHeights = new int[]{40, 310, 40, 0};
		gbl_impoted_items_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_impoted_items_panel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		impoted_items_panel.setLayout(gbl_impoted_items_panel);
		
		JButton btnNewButton_7 = new JButton("?");
		btnNewButton_7.setToolTipText("<html>this tab shows the imported items per group<br>\r\n\nand their blueprint paths, you can use this to see which<br>\r\n\nitems you have imported and to check if specific PB paths<br>\r\n\nare up to date, see the \"help\" option under settings for a <br>\n\r\nimage-guided explanation of importing item lists<html>");
		btnNewButton_7.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_7.gridx = 2;
		gbc_btnNewButton_7.gridy = 0;
		impoted_items_panel.add(btnNewButton_7, gbc_btnNewButton_7);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		impoted_items_panel.add(scrollPane, gbc_scrollPane);
		DefSPbounds = new Rectangle(564, 310);
		
		scrollPanel = new JPanel();
		scrollPane.setViewportView(scrollPanel);
		GridBagLayout gbl_scrollPanel = new GridBagLayout();
		gbl_scrollPanel.columnWidths = new int[]{0};
		gbl_scrollPanel.rowHeights = new int[]{0};
		gbl_scrollPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_scrollPanel.rowWeights = new double[]{Double.MIN_VALUE};
		scrollPanel.setLayout(gbl_scrollPanel);
		
		GridBagConstraints gbc_ImItemLabel = new GridBagConstraints();
		gbc_ImItemLabel.insets = new Insets(0, 0, 0, 5);
		gbc_ImItemLabel.gridx = 0;
		gbc_ImItemLabel.gridy = 0;
		gbc_ImItemLabel.weighty = 1;
		GridBagConstraints gbc_ImItemLabel2 = new GridBagConstraints();
		gbc_ImItemLabel2.insets = new Insets(0, 0, 0, 5);
		gbc_ImItemLabel2.gridx = 1;
		gbc_ImItemLabel2.gridy = 0;
		gbc_ImItemLabel2.weighty = 1;
		
		for(int i = 0; i < Reference.ImportedItemGroups.size(); i++) {
			
			scrollPanel.add(Utils.generateTitleLabel(Reference.ImportedItemGroups.get(i).getFirstValue()), gbc_ImItemLabel);
			gbc_ImItemLabel.gridy++;
			scrollPanel.add(Utils.generateTitleLabel("BP Path"), gbc_ImItemLabel2);
			gbc_ImItemLabel2.gridy++;
			
			for(int x = 0; x < Reference.ImportedItemGroups.get(i).getSecondValue().size(); x++) {
				scrollPanel.add(new JLabel(Reference.ImportedItemGroups.get(i).getSecondValue().get(x).getSecondValue()), gbc_ImItemLabel);
				gbc_ImItemLabel.gridy++;
			}
			
			for(int y = 0; y < Reference.ImportedItemGroups.get(i).getSecondValue().size(); y++) {
				scrollPanel.add(new JLabel(Reference.ImportedItemGroups.get(i).getSecondValue().get(y).getFirstValue()), gbc_ImItemLabel2);
				gbc_ImItemLabel2.gridy++;
			}
			
		}
		
		tabbedPane.addTab("queue", null, queuePanel, null);
		tabbedPane.setEnabledAt(5, true);
		GridBagLayout gbl_queuePanel = new GridBagLayout();
		gbl_queuePanel.columnWidths = new int[]{40, 293, 0, 40, 0};
		gbl_queuePanel.rowHeights = new int[]{40, 0, 30, 30, 0};
		gbl_queuePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_queuePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		queuePanel.setLayout(gbl_queuePanel);
		
		gbc_queueList.gridwidth = 2;
		gbc_queueList.insets = new Insets(0, 0, 5, 5);
		gbc_queueList.fill = GridBagConstraints.BOTH;
		gbc_queueList.gridx = 1;
		gbc_queueList.gridy = 1;
		queuePanel.add(queueList, gbc_queueList);
		GridBagLayout gbl_queueList = new GridBagLayout();
		gbl_queueList.columnWidths = new int[]{514, 40, 0};
		gbl_queueList.rowHeights = new int[]{30, 0};
		gbl_queueList.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_queueList.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		queueList.setLayout(gbl_queueList);
		
		gbc_commandLable.insets = new Insets(0, 0, 0, 5);
		gbc_commandLable.gridx = 0;
		gbc_commandLable.gridy = 0;
		queueList.add(commandLable, gbc_commandLable);
		
		gbc_RemoveLabel.gridx = 1;
		gbc_RemoveLabel.gridy = 0;
		queueList.add(RemoveLabel, gbc_RemoveLabel);
		
		JButton btnNewButton_6 = new JButton("?");
		btnNewButton_6.setToolTipText("<html>this is the command queue, commads<br>\r\nqueued up will appear here and can be run all in<br>\r\n\nquick succession by pressing \"Run\" or ran with<br>\r\n\na delay by setting the delay in seconds and then<br>\n\r\npressing the \"Run With Delay\" button</html>");
		btnNewButton_6.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_6.gridx = 3;
		gbc_btnNewButton_6.gridy = 1;
		queuePanel.add(btnNewButton_6, gbc_btnNewButton_6);
		
		GridBagConstraints gbc_DelaySpinner = new GridBagConstraints();
		gbc_DelaySpinner.insets = new Insets(0, 0, 5, 5);
		gbc_DelaySpinner.gridx = 1;
		gbc_DelaySpinner.gridy = 2;
		queuePanel.add(DelaySpinner, gbc_DelaySpinner);
		
		JButton RunDelayButton = new JButton("Run With Delay");
		GridBagConstraints gbc_RunDelayButton = new GridBagConstraints();
		gbc_RunDelayButton.insets = new Insets(0, 0, 0, 5);
		gbc_RunDelayButton.gridx = 1;
		gbc_RunDelayButton.gridy = 3;
		queuePanel.add(RunDelayButton, gbc_RunDelayButton);
		
		JButton RunButton = new JButton("Run");
		GridBagConstraints gbc_RunButton = new GridBagConstraints();
		gbc_RunButton.insets = new Insets(0, 0, 0, 5);
		gbc_RunButton.gridx = 2;
		gbc_RunButton.gridy = 3;
		queuePanel.add(RunButton, gbc_RunButton);
		RunButton.addActionListener(ActionlistnerAAM.RunListner);
		
		gbc_commandList.gridx = 0;
		gbc_commandList.gridy = 1;
		gbc_commandList.weighty = 1;
		gbc_commandButtonList.gridx = 1;
		gbc_commandButtonList.gridy = 1;
		gbc_commandButtonList.weighty = 1;
		for(int i = 0; i < Reference.Queue.size(); i ++) {
			queueList.add(new JLabel(Reference.Queue.get(i).generateCommand()), gbc_commandList);
			queueList.add(new JNumberedButton("X", ActionlistnerAAM.QueueRemoveListner, i), gbc_commandButtonList);
			gbc_commandList.gridy++;
			gbc_commandButtonList.gridy++;
		}
		
		
		tabbedPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				
				if(tabbedPane.getSelectedIndex() == 0) {
					favorites_panel.removeAll();
					favorites_panel.revalidate();
					favorites_panel.repaint();
					gbc_FavButtons.insets = new Insets(0, 0, 0, 5);
					gbc_FavButtons.gridx = 0;
					gbc_FavButtons.gridy = 0;
					
					if(Reference.FavoriteButtonList != null) {
						for(JNumberedButton button : Reference.FavoriteButtonList) {
							//favorites_panel.add(button, gbc_FavButtons);
							favorites_panel.add(FavButtonPanelBuilder.buildPanel(button), gbc_FavButtons);
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
					simple_commands_panel.add(HelpButton, gbc_HelpButton);

				}else if(tabbedPane.getSelectedIndex() == 4) {
					GridBagConstraints gbc_ImItemLabel = new GridBagConstraints();
					gbc_ImItemLabel.insets = new Insets(0, 0, 0, 5);
					gbc_ImItemLabel.gridx = 0;
					gbc_ImItemLabel.gridy = 0;
					gbc_ImItemLabel.weighty = 1;
					GridBagConstraints gbc_ImItemLabel2 = new GridBagConstraints();
					gbc_ImItemLabel2.insets = new Insets(0, 0, 0, 5);
					gbc_ImItemLabel2.gridx = 1;
					gbc_ImItemLabel2.gridy = 0;
					gbc_ImItemLabel2.weighty = 1;
					
					for(int i = 0; i < Reference.ImportedItemGroups.size(); i++) {
						
						scrollPanel.removeAll();
						scrollPanel.revalidate();
						scrollPanel.repaint();
						
						scrollPanel.add(Utils.generateTitleLabel(Reference.ImportedItemGroups.get(i).getFirstValue()), gbc_ImItemLabel);
						gbc_ImItemLabel.gridy++;
						scrollPanel.add(Utils.generateTitleLabel("BP Path"), gbc_ImItemLabel2);
						gbc_ImItemLabel2.gridy++;
						
						for(int x =0; x < Reference.ImportedItemGroups.get(i).getSecondValue().size(); x++) {
							scrollPanel.add(new JLabel(Reference.ImportedItemGroups.get(i).getSecondValue().get(x).getSecondValue()), gbc_ImItemLabel);
							gbc_ImItemLabel.gridy++;
						}
						
						for(int y = 0; y < Reference.ImportedItemGroups.get(i).getSecondValue().size(); y++) {
							scrollPanel.add(new JLabel(Reference.ImportedItemGroups.get(i).getSecondValue().get(y).getFirstValue()), gbc_ImItemLabel2);
							gbc_ImItemLabel2.gridy++;
						}
						
						
					}
				}else if(tabbedPane.getSelectedIndex() == 5) {
					queuePanel.removeAll();
					queuePanel.revalidate();
					queuePanel.repaint();
					queuePanel.add(queueList, gbc_queueList);
					
					queueList.setLayout(gbl_queueList);
					queueList.removeAll();
					queueList.revalidate();
					queueList.repaint();
					
					queueList.add(commandLable, gbc_commandLable);
					queueList.add(RemoveLabel, gbc_RemoveLabel);
					
					
					queuePanel.add(DelaySpinner, gbc_DelaySpinner);
					
					JButton RunDelayButton = new JButton("Run With Delay");
					GridBagConstraints gbc_RunDelayButton = new GridBagConstraints();
					gbc_RunDelayButton.insets = new Insets(0, 0, 0, 5);
					gbc_RunDelayButton.gridx = 1;
					gbc_RunDelayButton.gridy = 3;
					queuePanel.add(RunDelayButton, gbc_RunDelayButton);
					RunDelayButton.addActionListener(ActionlistnerAAM.RunDelayListner);
					
					JButton RunButton = new JButton("Run");
					GridBagConstraints gbc_RunButton = new GridBagConstraints();
					gbc_RunButton.insets = new Insets(0, 0, 0, 5);
					gbc_RunButton.gridx = 2;
					gbc_RunButton.gridy = 3;
					queuePanel.add(RunButton, gbc_RunButton);
					RunButton.addActionListener(ActionlistnerAAM.RunListner);
					
					GridBagConstraints gbc_commandList = new GridBagConstraints();
					gbc_commandList.gridx = 0;
					gbc_commandList.gridy = 1;
					gbc_commandList.weighty = 1;
					gbc_commandButtonList.gridx = 1;
					gbc_commandButtonList.gridy = 1;
					gbc_commandButtonList.weighty = 1;
					for(int i = 0; i < Reference.Queue.size(); i ++) {
						queueList.add(new JLabel(Reference.Queue.get(i).generateCommand()), gbc_commandList);
						queueList.add(new JNumberedButton("X", ActionlistnerAAM.QueueRemoveListner, i), gbc_commandButtonList);
						gbc_commandList.gridy++;
						gbc_commandButtonList.gridy++;
					}
					

					queuePanel.add(btnNewButton_6, gbc_btnNewButton_6);
				}
				
			}
		});
		
		Component[] components = simple_commands_panel.getComponents();
		
		for(int i = 1; i < components.length; i++) {
			
			if(components[i] instanceof JNumberedCheckbox) ((JNumberedCheckbox) components[i]).setToolTipText("click this to favorite the command");
			
		}
		
		int dismissDelay = Integer.MAX_VALUE;
	    ToolTipManager.sharedInstance().setDismissDelay(dismissDelay);
	    ToolTipManager.sharedInstance().setInitialDelay(0);

	    scrollPane.setBorder(BorderFactory.createEmptyBorder());
	    
	    scrollPane.getVerticalScrollBar().setUnitIncrement(16);

	    
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
