package com.blackdragon2447.AAM.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.aeonbits.owner.ConfigFactory;

import com.blackdragon2447.AAM.Main;
import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.gui.actionlistners.ActionlistnerAAM;
import com.blackdragon2447.AAM.gui.auth.CreateServersDialog;
import com.blackdragon2447.AAM.gui.components.JNumberedButton;
import com.blackdragon2447.AAM.gui.components.JNumberedCheckbox;
import com.blackdragon2447.AAM.gui.components.JNumberedPanel;
import com.blackdragon2447.AAM.gui.dialog.HelpDialog;
import com.blackdragon2447.AAM.gui.dialog.ImportItemsDialog;
import com.blackdragon2447.AAM.gui.dialog.CC.AddNewPluginCommand;
import com.blackdragon2447.AAM.gui.dialog.CC.AddNewScriptGui;
import com.blackdragon2447.AAM.util.CustomButtonBuilder;
import com.blackdragon2447.AAM.util.FavButtonPanelBuilder;
import com.blackdragon2447.AAM.util.ThemeButtonBuilder;
import com.blackdragon2447.AAM.util.Themes;
import com.blackdragon2447.AAM.util.Utils;
import com.blackdragon2447.AAM.util.iface.AAMConfig;

public class AAMGui extends JFrame {

	/**
	 * all the global variables for the main GUI window.
	 * all the swing components in this part needed to be accesed outside the
	 * constructor.
	 */
	private static final long serialVersionUID = -735583961255908606L;
	private static JPanel ContentPane;
	static JPanel SimpleCommandsPanel = new JPanel();
	static JPanel AdvancedCommandsPanel = new JPanel();
	ButtonGroup group = new ButtonGroup();

	public static JPanel QueuePanel = new JPanel();
	public static JPanel QueueList = new JPanel();
	public static GridBagConstraints gbc_QueueList = new GridBagConstraints();
	public static GridBagLayout gbl_queuePanel = new GridBagLayout();
	public static GridBagLayout gbl_QueueList = new GridBagLayout();
	public static JLabel CommandLable = new JLabel("command");
	public static GridBagConstraints gbc_commandLable = new GridBagConstraints();
	public static JLabel RemoveLabel = new JLabel("remove");
	public static GridBagConstraints gbc_RemoveLabel = new GridBagConstraints();
	public static GridBagConstraints gbc_commandList = new GridBagConstraints();
	public static GridBagConstraints gbc_commandButtonList = new GridBagConstraints();
	public static JTabbedPane tabbedPaneOut;
	public static JSpinner DelaySpinner = new JSpinner(new SpinnerNumberModel(0, 0, 30, 0.1));
	JScrollPane ScrollPane;
	Rectangle DefSPbounds;
	JPanel ScrollPanel;
	JButton SCHelpButton;
	AAMConfig cfg = ConfigFactory.create(AAMConfig.class);
	GridBagConstraints gbc_FavButtons = new GridBagConstraints();
	JNumberedButton ToggleDNButton = new JNumberedButton("toggle damage numbers", 3);
	JNumberedCheckbox ToggleDNCheckBox = new JNumberedCheckbox("", 3);
	JNumberedButton BroadCastButton = new JNumberedButton("broadcast", 4);
	JNumberedCheckbox BroadCastCheckBox = new JNumberedCheckbox("", 4);
	JNumberedButton ChatMessageButton = new JNumberedButton("send chat message", 5);
	JNumberedCheckbox ChatMessageCheckBox = new JNumberedCheckbox("", 5);
	JNumberedButton ChatLogButton = new JNumberedButton("get chat log", 6);
	JNumberedCheckbox ChatLogCheckBox = new JNumberedCheckbox("", 6);
	JNumberedButton GameLogButton = new JNumberedButton("get game log", 7);
	JNumberedCheckbox GameLogCheckBox = new JNumberedCheckbox("", 7);
	JNumberedButton StopServerButton = new JNumberedButton("stop server", 8);
	JNumberedButton SaveGameButton = new JNumberedButton("save game files", 9);
	JNumberedCheckbox SaveGameCheckBox = new JNumberedCheckbox("", 9);
	JNumberedButton DinoWipeButton = new JNumberedButton("dino wipe", 10);
	JNumberedCheckbox DinoWipeCheckBox = new JNumberedCheckbox("", 10);
	JNumberedButton BanButton = new JNumberedButton("ban player", 11);
	JNumberedCheckbox BanCheckBox = new JNumberedCheckbox("", 11);
	JNumberedButton UnbanButton = new JNumberedButton("unban player", 12);
	JNumberedCheckbox UnbanCheckBox = new JNumberedCheckbox("", 12);
	JNumberedButton KickButton = new JNumberedButton("kick player", 13);
	JNumberedCheckbox KickCheckBox = new JNumberedCheckbox("", 13);
	JNumberedButton GFIPlayerButton = new JNumberedButton("give item to player", 14);
	JNumberedCheckbox GFIPlayerCheckBox = new JNumberedCheckbox("", 14);
	JNumberedButton RenamePlayerButton = new JNumberedButton("rename rlayer", 15);
	JNumberedCheckbox RenamePlayerCheckBox = new JNumberedCheckbox("", 15);
	JNumberedButton RenameTribeButton = new JNumberedButton("rename tribe", 16);
	JNumberedCheckbox RenameTribeCheckBox = new JNumberedCheckbox("", 16);
	JNumberedButton ForcePlayerToTribeButton = new JNumberedButton("force player into tribe", 17);
	JNumberedCheckbox ForcePlayerToTribeCheckbox = new JNumberedCheckbox("", 17);
	JNumberedButton GivePlayerXPButton = new JNumberedButton("give xp to player", 18);
	JNumberedCheckbox GivePlayerXPCheckbox = new JNumberedCheckbox("", 18);
	JNumberedButton GetUE4IDButton = new JNumberedButton("get player ingame id", 19);
	JNumberedCheckbox GetUE4IDCheckbox = new JNumberedCheckbox("", 19);
	JNumberedButton ListAllIDButton = new JNumberedButton("List All Steam ID", 20);
	JNumberedCheckbox ListAllIDCheckBox = new JNumberedCheckbox("", 20);
	JNumberedButton SpawnDinoNearButton = new JNumberedButton("Spawn Dino Near Player", 21);
	JNumberedCheckbox SpawnDinoNearCheckBox = new JNumberedCheckbox("", 21);
	JNumberedButton SpawnDinoCoordsButton = new JNumberedButton("Spawn Dino At Coords", 22);
	JNumberedCheckbox SpawnDinoCoordsCheckBox = new JNumberedCheckbox("", 22);
	private final JScrollPane scrollPane = new JScrollPane();
	private final JPanel ButtonPanel = new JPanel();
	private final JSeparator separator = new JSeparator();
	private final JSeparator separator_1 = new JSeparator();
	public static final JMenu ThemeMenu = new JMenu("Theme");
	static JMenuBar menuBar = new JMenuBar();
	JNumberedButton ListPlayerPosButton = new JNumberedButton("List All Player Pos", 23);
	JNumberedCheckbox ListPlayerPosCheckbox = new JNumberedCheckbox("", 23);
	JNumberedButton ListAllUNCDinoButton = new JNumberedButton("List All Unclaimed Dinos", 24);
	JNumberedCheckbox ListAllUNCDinoCheckBox = new JNumberedCheckbox("", 24);
	private final JSeparator separator_2 = new JSeparator();
	private final JLabel lblNewLabel = new JLabel("Command Sequences");
	private final JPanel RconPanel = new JPanel();
	private final JScrollPane RconScrollPane = new JScrollPane();
	public static final JPanel RconLogPanel = new JPanel();
	public static final JTextField RconField = new JTextField();
	public static final JButton RconRunButton = new JButton("Run");
	public static int GridY = 1;
	private final JButton ServersButton = new JButton("Servers");
	private final JNumberedButton DinoWipeSeqButton = new JNumberedButton("Dino Wipe", 25);
	private final JNumberedCheckbox DinoWipeSeqCheckBox = new JNumberedCheckbox("", 25);
	private final JNumberedButton ShutdownSeqButton = new JNumberedButton("Shut Down", 26);
	private final JNumberedCheckbox ShutdownSeqCheckBox = new JNumberedCheckbox("", 26);

	/**
	 * the method for opening the GUI.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void createGui() throws UnsupportedLookAndFeelException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new AAMGui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * the constructor for the main GUI, contains practically all the code that
	 * controls the main GUI.
	 * 
	 * @throws NumberFormatException
	 * @throws CloneNotSupportedException
	 */
	public AAMGui() throws NumberFormatException, CloneNotSupportedException {
		RconField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					RconRunButton.doClick();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		RconField.setColumns(10);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AAMGui.class.getResource("/com/blackdragon2447/AAM/assets/AAM.logo.png")));
		
		/**
		 * setting the default settings for the GUI
		 */
		setTitle("ArkAdminManager");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		
		/**
		 * adding the menu bar the options are pretty self explanatory by name.
		 */
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

		JMenuItem ServersMenuItem = new JMenuItem("Servers");
		settingsMenu.add(ServersMenuItem);
		ServersMenuItem.addActionListener(new ActionListener() {
		
		JMenuItem ConnectionsMenuItem = new JMenuItem("Connections");
		settingsMenu.add(ConnectionsMenuItem);
		ConnectionsMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ServersGUI.createGui();
			}
		});

		settingsMenu.add(ThemeMenu);

		Themes[] themes = Themes.values();
		for (Themes themes2 : themes) {
			ThemeMenu.add(ThemeButtonBuilder.BuildThemeButton(themes2));
		}

		JMenuItem helpMenuItem = new JMenuItem("help");
		settingsMenu.add(helpMenuItem);
		
		ServersButton.setOpaque(false);
		ServersButton.setContentAreaFilled(false);
		ServersButton.setBorderPainted(false);
		if(Reference.currentUser.isOwner()) menuBar.add(ServersButton);
		Main.logger.LogDebug(Reference.currentUser.isOwner().toString(), Level.INFO);
		
		ServersButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					CreateServersDialog.createGui();
				}
		});
		ContentPane = new JPanel();
		ContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ContentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(ContentPane);
		helpMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				HelpDialog.createDialog();
			}
		});

		/**
		 * this set the theme on starting the program, invoked after setting the menu
		 * bar to make it so the look of the bar can actually be set.
		 */

		setVisual(Themes.getLookAndFeel(cfg.Theme()));
		Reference.theme = cfg.Theme();

		/**
		 * this part of the constructor builds the tabbed pane and the panels in it
		 * most if not all of the buttons in this part have a name explaining their use
		 */
		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		ContentPane.add(tabbedPane, BorderLayout.CENTER);
		tabbedPaneOut = tabbedPane;

		JPanel FavoritesPanel = new JPanel();
		FavoritesPanel.setToolTipText("");
		tabbedPane.addTab("favorites", null, FavoritesPanel, null);
		GridBagLayout gbl_FavoritesPanel = new GridBagLayout();
		gbl_FavoritesPanel.rowWeights = new double[] {};
		gbl_FavoritesPanel.columnWidths = new int[] { 240, 240, 240, 0 };
		gbl_FavoritesPanel.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		FavoritesPanel.setLayout(gbl_FavoritesPanel);

		SimpleCommandsPanel.setToolTipText("");
		tabbedPane.addTab("simple commands", null, SimpleCommandsPanel, null);
		GridBagLayout gbl_SimpleCommandsPanel = new GridBagLayout();
		gbl_SimpleCommandsPanel.columnWidths = new int[] { 185, 0, 185, 0, 185, 0, 0 };
		gbl_SimpleCommandsPanel.rowHeights = new int[] { 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_SimpleCommandsPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_SimpleCommandsPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		SimpleCommandsPanel.setLayout(gbl_SimpleCommandsPanel);

		JLabel SCDescLabel = new JLabel("Simple Commands");
		SCDescLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_SCDescLabel = new GridBagConstraints();
		gbc_SCDescLabel.gridwidth = 5;
		gbc_SCDescLabel.insets = new Insets(0, 0, 5, 5);
		gbc_SCDescLabel.gridx = 0;
		gbc_SCDescLabel.gridy = 0;
		SimpleCommandsPanel.add(SCDescLabel, gbc_SCDescLabel);

		JLabel BasicCLabel = new JLabel("basic commands");
		GridBagConstraints gbc_BasicCLabel = new GridBagConstraints();
		gbc_BasicCLabel.insets = new Insets(0, 0, 5, 5);
		gbc_BasicCLabel.gridx = 2;
		gbc_BasicCLabel.gridy = 1;
		SimpleCommandsPanel.add(BasicCLabel, gbc_BasicCLabel);

		SCHelpButton = new JButton("?");
		SCHelpButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_SCHelpButton = new GridBagConstraints();
		gbc_SCHelpButton.insets = new Insets(0, 0, 5, 0);
		gbc_SCHelpButton.fill = GridBagConstraints.BOTH;
		gbc_SCHelpButton.gridx = 5;
		gbc_SCHelpButton.gridy = 1;
		SimpleCommandsPanel.add(SCHelpButton, gbc_SCHelpButton);
		SCHelpButton.setToolTipText(
				"<html>these are simple commands, thier argument can<br>be set after clicking the button and will need to be<br>reset after every run. saving of full comands is comming, hopefully.</html>");

		GridBagConstraints gbc_ToggleDNNewButton = new GridBagConstraints();
		gbc_ToggleDNNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_ToggleDNNewButton.fill = GridBagConstraints.BOTH;
		gbc_ToggleDNNewButton.gridx = 0;
		gbc_ToggleDNNewButton.gridy = 2;
		SimpleCommandsPanel.add(ToggleDNButton, gbc_ToggleDNNewButton);
		ToggleDNButton.addActionListener(ActionlistnerAAM.SimpleSCBListner);

		GridBagConstraints gbc_ToggleDNCheckBox = new GridBagConstraints();
		gbc_ToggleDNCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_ToggleDNCheckBox.gridx = 1;
		gbc_ToggleDNCheckBox.gridy = 2;
		SimpleCommandsPanel.add(ToggleDNCheckBox, gbc_ToggleDNCheckBox);
		ToggleDNCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);

		JLabel MessagingCLabel = new JLabel("messaging");
		GridBagConstraints gbc_MessagingCLabel = new GridBagConstraints();
		gbc_MessagingCLabel.insets = new Insets(0, 0, 5, 5);
		gbc_MessagingCLabel.gridx = 2;
		gbc_MessagingCLabel.gridy = 3;
		SimpleCommandsPanel.add(MessagingCLabel, gbc_MessagingCLabel);

		GridBagConstraints gbc_BroadCastButton = new GridBagConstraints();
		gbc_BroadCastButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_BroadCastButton.anchor = GridBagConstraints.SOUTH;
		gbc_BroadCastButton.insets = new Insets(0, 0, 5, 5);
		gbc_BroadCastButton.gridx = 0;
		gbc_BroadCastButton.gridy = 4;
		SimpleCommandsPanel.add(BroadCastButton, gbc_BroadCastButton);
		BroadCastButton.addActionListener(ActionlistnerAAM.SimpleSCBListner);

		GridBagConstraints gbc_BroadCastCheckBox = new GridBagConstraints();
		gbc_BroadCastCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_BroadCastCheckBox.gridx = 1;
		gbc_BroadCastCheckBox.gridy = 4;
		SimpleCommandsPanel.add(BroadCastCheckBox, gbc_BroadCastCheckBox);
		BroadCastCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);

		GridBagConstraints gbc_ChatMessageButton = new GridBagConstraints();
		gbc_ChatMessageButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_ChatMessageButton.insets = new Insets(0, 0, 5, 5);
		gbc_ChatMessageButton.gridx = 2;
		gbc_ChatMessageButton.gridy = 4;
		SimpleCommandsPanel.add(ChatMessageButton, gbc_ChatMessageButton);
		ChatMessageButton.addActionListener(ActionlistnerAAM.SimpleSCBListner);

		GridBagConstraints gbc_ChatMessageCheckBox = new GridBagConstraints();
		gbc_ChatMessageCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_ChatMessageCheckBox.gridx = 3;
		gbc_ChatMessageCheckBox.gridy = 4;
		SimpleCommandsPanel.add(ChatMessageCheckBox, gbc_ChatMessageCheckBox);
		ChatMessageCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);

		JLabel LogsLabel = new JLabel("logs");
		GridBagConstraints gbc_LogsLabel = new GridBagConstraints();
		gbc_LogsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_LogsLabel.gridx = 2;
		gbc_LogsLabel.gridy = 5;
		SimpleCommandsPanel.add(LogsLabel, gbc_LogsLabel);

		GridBagConstraints gbc_ChatLogButton = new GridBagConstraints();
		gbc_ChatLogButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_ChatLogButton.insets = new Insets(0, 0, 5, 5);
		gbc_ChatLogButton.gridx = 0;
		gbc_ChatLogButton.gridy = 6;
		SimpleCommandsPanel.add(ChatLogButton, gbc_ChatLogButton);
		ChatLogButton.addActionListener(ActionlistnerAAM.SimpleSCBListner);

		GridBagConstraints gbc_ChatLogCheckBox = new GridBagConstraints();
		gbc_ChatLogCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_ChatLogCheckBox.gridx = 1;
		gbc_ChatLogCheckBox.gridy = 6;
		SimpleCommandsPanel.add(ChatLogCheckBox, gbc_ChatLogCheckBox);
		ChatLogCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);

		GridBagConstraints gbc_GameLogButton = new GridBagConstraints();
		gbc_GameLogButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_GameLogButton.insets = new Insets(0, 0, 5, 5);
		gbc_GameLogButton.gridx = 2;
		gbc_GameLogButton.gridy = 6;
		SimpleCommandsPanel.add(GameLogButton, gbc_GameLogButton);
		GameLogButton.addActionListener(ActionlistnerAAM.SimpleSCBListner);

		GridBagConstraints gbc_GameLogCheckBox = new GridBagConstraints();
		gbc_GameLogCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_GameLogCheckBox.gridx = 3;
		gbc_GameLogCheckBox.gridy = 6;
		SimpleCommandsPanel.add(GameLogCheckBox, gbc_GameLogCheckBox);
		GameLogCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);

		JLabel ServerManagementLabel = new JLabel("server managemnt");
		GridBagConstraints gbc_ServerManagementLabel = new GridBagConstraints();
		gbc_ServerManagementLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ServerManagementLabel.gridx = 2;
		gbc_ServerManagementLabel.gridy = 7;
		SimpleCommandsPanel.add(ServerManagementLabel, gbc_ServerManagementLabel);

		GridBagConstraints gbc_StopServerButton = new GridBagConstraints();
		gbc_StopServerButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_StopServerButton.insets = new Insets(0, 0, 5, 5);
		gbc_StopServerButton.gridx = 0;
		gbc_StopServerButton.gridy = 8;
		SimpleCommandsPanel.add(StopServerButton, gbc_StopServerButton);
		StopServerButton.addActionListener(ActionlistnerAAM.SimpleSCBListner);

		JNumberedCheckbox StopServerCheckBox = new JNumberedCheckbox("", 8);
		GridBagConstraints gbc_StopServerCheckBox = new GridBagConstraints();
		gbc_StopServerCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_StopServerCheckBox.gridx = 1;
		gbc_StopServerCheckBox.gridy = 8;
		SimpleCommandsPanel.add(StopServerCheckBox, gbc_StopServerCheckBox);
		StopServerCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);

		GridBagConstraints gbc_SaveGameButton = new GridBagConstraints();
		gbc_SaveGameButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_SaveGameButton.insets = new Insets(0, 0, 5, 5);
		gbc_SaveGameButton.gridx = 2;
		gbc_SaveGameButton.gridy = 8;
		SimpleCommandsPanel.add(SaveGameButton, gbc_SaveGameButton);
		SaveGameButton.addActionListener(ActionlistnerAAM.SimpleSCBListner);

		GridBagConstraints gbc_SaveGameCheckBox = new GridBagConstraints();
		gbc_SaveGameCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_SaveGameCheckBox.gridx = 3;
		gbc_SaveGameCheckBox.gridy = 8;
		SimpleCommandsPanel.add(SaveGameCheckBox, gbc_SaveGameCheckBox);
		SaveGameCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);

		GridBagConstraints gbc_DinoWipeButton = new GridBagConstraints();
		gbc_DinoWipeButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_DinoWipeButton.insets = new Insets(0, 0, 5, 5);
		gbc_DinoWipeButton.gridx = 4;
		gbc_DinoWipeButton.gridy = 8;
		SimpleCommandsPanel.add(DinoWipeButton, gbc_DinoWipeButton);
		DinoWipeButton.addActionListener(ActionlistnerAAM.SimpleSCBListner);

		GridBagConstraints gbc_DinoWipeCheckBox = new GridBagConstraints();
		gbc_DinoWipeCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_DinoWipeCheckBox.gridx = 5;
		gbc_DinoWipeCheckBox.gridy = 8;
		SimpleCommandsPanel.add(DinoWipeCheckBox, gbc_DinoWipeCheckBox);
		DinoWipeCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);

		JLabel Moderation = new JLabel("moderation");
		GridBagConstraints gbc_Moderation = new GridBagConstraints();
		gbc_Moderation.insets = new Insets(0, 0, 5, 5);
		gbc_Moderation.gridx = 2;
		gbc_Moderation.gridy = 9;
		SimpleCommandsPanel.add(Moderation, gbc_Moderation);

		GridBagConstraints gbc_BanButton = new GridBagConstraints();
		gbc_BanButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_BanButton.insets = new Insets(0, 0, 5, 5);
		gbc_BanButton.gridx = 0;
		gbc_BanButton.gridy = 10;
		SimpleCommandsPanel.add(BanButton, gbc_BanButton);
		BanButton.addActionListener(ActionlistnerAAM.SimpleSCBListner);

		GridBagConstraints gbc_BanCheckBox = new GridBagConstraints();
		gbc_BanCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_BanCheckBox.gridx = 1;
		gbc_BanCheckBox.gridy = 10;
		SimpleCommandsPanel.add(BanCheckBox, gbc_BanCheckBox);
		BanCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);

		GridBagConstraints gbc_UnbanButton = new GridBagConstraints();
		gbc_UnbanButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_UnbanButton.insets = new Insets(0, 0, 5, 5);
		gbc_UnbanButton.gridx = 2;
		gbc_UnbanButton.gridy = 10;
		SimpleCommandsPanel.add(UnbanButton, gbc_UnbanButton);
		UnbanButton.addActionListener(ActionlistnerAAM.SimpleSCBListner);

		GridBagConstraints gbc_UnbanCheckBox = new GridBagConstraints();
		gbc_UnbanCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_UnbanCheckBox.gridx = 3;
		gbc_UnbanCheckBox.gridy = 10;
		SimpleCommandsPanel.add(UnbanCheckBox, gbc_UnbanCheckBox);
		UnbanCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);

		GridBagConstraints gbc_KickButton = new GridBagConstraints();
		gbc_KickButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_KickButton.insets = new Insets(0, 0, 5, 5);
		gbc_KickButton.gridx = 4;
		gbc_KickButton.gridy = 10;
		SimpleCommandsPanel.add(KickButton, gbc_KickButton);
		KickButton.addActionListener(ActionlistnerAAM.SimpleSCBListner);

		GridBagConstraints gbc_KickCheckBox = new GridBagConstraints();
		gbc_KickCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_KickCheckBox.gridx = 5;
		gbc_KickCheckBox.gridy = 10;
		SimpleCommandsPanel.add(KickCheckBox, gbc_KickCheckBox);
		KickCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);

		/**
		 * this tab is the one used for the more advanced commands
		 * all the buttons in this tab have their own actionlistners because they all
		 * have their own dialog class
		 */
		tabbedPane.addTab("advanced commands", null, AdvancedCommandsPanel, null);
		GridBagLayout gbl_AdvancedCommandsPanel = new GridBagLayout();
		gbl_AdvancedCommandsPanel.columnWidths = new int[]{185, 0, 185, 0, 185, 0, 0};
		gbl_AdvancedCommandsPanel.rowHeights = new int[]{23, 0, 0, 10, 0, 10, 0, 10, 0, 0, 0, 0};
		gbl_AdvancedCommandsPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_AdvancedCommandsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		AdvancedCommandsPanel.setLayout(gbl_AdvancedCommandsPanel);

		JLabel ACDescLabel = new JLabel("Advanced Commands\r\n");
		ACDescLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_ACDescLabel = new GridBagConstraints();
		gbc_ACDescLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ACDescLabel.gridx = 2;
		gbc_ACDescLabel.gridy = 0;
		AdvancedCommandsPanel.add(ACDescLabel, gbc_ACDescLabel);

		JButton ACHelpButton = new JButton("?");
		ACHelpButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		ACHelpButton.setToolTipText(
				"<html>this tab has more advanced<br>\r\ncommands like giving items to players<br>\r\nand spawning dinos. all of these commands<br>\r\nhave their own gui and are compatible with<br>\r\nmods, this compatibility is achived by<br>\r\nallown the user to import the items from<br>\r\nmods. see the help for more info on importing.</html>");
		GridBagConstraints gbc_ACHelpButton = new GridBagConstraints();
		gbc_ACHelpButton.insets = new Insets(0, 0, 5, 0);
		gbc_ACHelpButton.gridx = 5;
		gbc_ACHelpButton.gridy = 1;
		AdvancedCommandsPanel.add(ACHelpButton, gbc_ACHelpButton);

		GridBagConstraints gbc_GFIPlayerButton = new GridBagConstraints();
		gbc_GFIPlayerButton.anchor = GridBagConstraints.SOUTH;
		gbc_GFIPlayerButton.insets = new Insets(0, 0, 5, 5);
		gbc_GFIPlayerButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_GFIPlayerButton.gridx = 0;
		gbc_GFIPlayerButton.gridy = 2;
		AdvancedCommandsPanel.add(GFIPlayerButton, gbc_GFIPlayerButton);
		GFIPlayerButton.addActionListener(ActionlistnerAAM.AdvancedComListener);

		GridBagConstraints gbc_GFIPlayerCheckBox = new GridBagConstraints();
		gbc_GFIPlayerCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_GFIPlayerCheckBox.gridx = 1;
		gbc_GFIPlayerCheckBox.gridy = 2;
		AdvancedCommandsPanel.add(GFIPlayerCheckBox, gbc_GFIPlayerCheckBox);
		GFIPlayerCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);

		GridBagConstraints gbc_RenamePlayerButton = new GridBagConstraints();
		gbc_RenamePlayerButton.insets = new Insets(0, 0, 5, 5);
		gbc_RenamePlayerButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_RenamePlayerButton.gridx = 2;
		gbc_RenamePlayerButton.gridy = 2;
		AdvancedCommandsPanel.add(RenamePlayerButton, gbc_RenamePlayerButton);
		RenamePlayerButton.addActionListener(ActionlistnerAAM.AdvancedComListener);

		GridBagConstraints gbc_RenamePlayerCheckBox = new GridBagConstraints();
		gbc_RenamePlayerCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_RenamePlayerButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_RenamePlayerCheckBox.gridx = 3;
		gbc_RenamePlayerCheckBox.gridy = 2;
		AdvancedCommandsPanel.add(RenamePlayerCheckBox, gbc_RenamePlayerCheckBox);
		RenamePlayerCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);

		GridBagConstraints gbc_RenameTribeButton = new GridBagConstraints();
		gbc_RenameTribeButton.insets = new Insets(0, 0, 5, 5);
		gbc_RenameTribeButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_RenameTribeButton.gridx = 4;
		gbc_RenameTribeButton.gridy = 2;
		AdvancedCommandsPanel.add(RenameTribeButton, gbc_RenameTribeButton);
		RenameTribeButton.addActionListener(ActionlistnerAAM.AdvancedComListener);

		GridBagConstraints gbc_RenameTribeCheckBox = new GridBagConstraints();
		gbc_RenameTribeCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_RenameTribeCheckBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_RenameTribeCheckBox.gridx = 5;
		gbc_RenameTribeCheckBox.gridy = 2;
		AdvancedCommandsPanel.add(RenameTribeCheckBox, gbc_RenameTribeCheckBox);
		RenameTribeCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);

		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 6;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 3;
		AdvancedCommandsPanel.add(separator, gbc_separator);

		GridBagConstraints gbc_ForcePlayerToTribeButton = new GridBagConstraints();
		gbc_ForcePlayerToTribeButton.insets = new Insets(0, 0, 5, 5);
		gbc_ForcePlayerToTribeButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_ForcePlayerToTribeButton.gridx = 0;
		gbc_ForcePlayerToTribeButton.gridy = 4;
		AdvancedCommandsPanel.add(ForcePlayerToTribeButton, gbc_ForcePlayerToTribeButton);
		ForcePlayerToTribeButton.addActionListener(ActionlistnerAAM.AdvancedComListener);

		GridBagConstraints gbc_ForcePlayerToTribeCheckbox = new GridBagConstraints();
		gbc_ForcePlayerToTribeCheckbox.insets = new Insets(0, 0, 5, 5);
		gbc_ForcePlayerToTribeCheckbox.gridx = 1;
		gbc_ForcePlayerToTribeCheckbox.gridy = 4;
		AdvancedCommandsPanel.add(ForcePlayerToTribeCheckbox, gbc_ForcePlayerToTribeCheckbox);
		ForcePlayerToTribeCheckbox.addActionListener(ActionlistnerAAM.FavButtonListner);

		GridBagConstraints gbc_GivePlayerXPButton = new GridBagConstraints();
		gbc_GivePlayerXPButton.insets = new Insets(0, 0, 5, 5);
		gbc_GivePlayerXPButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_GivePlayerXPButton.gridx = 2;
		gbc_GivePlayerXPButton.gridy = 4;
		AdvancedCommandsPanel.add(GivePlayerXPButton, gbc_GivePlayerXPButton);
		GivePlayerXPButton.addActionListener(ActionlistnerAAM.AdvancedComListener);

		GridBagConstraints gbc_GivePlayerXPCheckbox = new GridBagConstraints();
		gbc_GivePlayerXPCheckbox.insets = new Insets(0, 0, 5, 5);
		gbc_GivePlayerXPCheckbox.gridx = 3;
		gbc_GivePlayerXPCheckbox.gridy = 4;
		AdvancedCommandsPanel.add(GivePlayerXPCheckbox, gbc_GivePlayerXPCheckbox);
		GivePlayerXPCheckbox.addActionListener(ActionlistnerAAM.FavButtonListner);

		GridBagConstraints gbc_GetUE4IDButton = new GridBagConstraints();
		gbc_GetUE4IDButton.insets = new Insets(0, 0, 5, 5);
		gbc_GetUE4IDButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_GetUE4IDButton.gridx = 4;
		gbc_GetUE4IDButton.gridy = 4;
		AdvancedCommandsPanel.add(GetUE4IDButton, gbc_GetUE4IDButton);
		GetUE4IDButton.addActionListener(ActionlistnerAAM.AdvancedComListener);

		GridBagConstraints gbc_GetUE4IDCheckbox = new GridBagConstraints();
		gbc_GetUE4IDCheckbox.insets = new Insets(0, 0, 5, 0);
		gbc_RenamePlayerButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_GetUE4IDCheckbox.gridx = 5;
		gbc_GetUE4IDCheckbox.gridy = 4;
		AdvancedCommandsPanel.add(GetUE4IDCheckbox, gbc_GetUE4IDCheckbox);
		GetUE4IDCheckbox.addActionListener(ActionlistnerAAM.FavButtonListner);

		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridwidth = 6;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 5;
		AdvancedCommandsPanel.add(separator_1, gbc_separator_1);

		GridBagConstraints gbc_SpawnDinoNearButton = new GridBagConstraints();
		gbc_SpawnDinoNearButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_SpawnDinoNearButton.insets = new Insets(0, 0, 5, 5);
		gbc_SpawnDinoNearButton.gridx = 0;
		gbc_SpawnDinoNearButton.gridy = 6;
		AdvancedCommandsPanel.add(SpawnDinoNearButton, gbc_SpawnDinoNearButton);
		SpawnDinoNearButton.addActionListener(ActionlistnerAAM.AdvancedComListener);

		GridBagConstraints gbc_SpawnDinoNearCheckBox = new GridBagConstraints();
		gbc_SpawnDinoNearCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_SpawnDinoNearCheckBox.gridx = 1;
		gbc_SpawnDinoNearCheckBox.gridy = 6;
		AdvancedCommandsPanel.add(SpawnDinoNearCheckBox, gbc_SpawnDinoNearCheckBox);
		SpawnDinoNearCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);

		GridBagConstraints gbc_SpawnDinoCoordsButton = new GridBagConstraints();
		gbc_SpawnDinoCoordsButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_SpawnDinoCoordsButton.insets = new Insets(0, 0, 5, 5);
		gbc_SpawnDinoCoordsButton.gridx = 2;
		gbc_SpawnDinoCoordsButton.gridy = 6;
		AdvancedCommandsPanel.add(SpawnDinoCoordsButton, gbc_SpawnDinoCoordsButton);
		SpawnDinoCoordsButton.addActionListener(ActionlistnerAAM.AdvancedComListener);

		GridBagConstraints gbc_SpawnDinoCoordsCheckBox = new GridBagConstraints();
		gbc_SpawnDinoCoordsCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_SpawnDinoCoordsCheckBox.gridx = 3;
		gbc_SpawnDinoCoordsCheckBox.gridy = 6;
		AdvancedCommandsPanel.add(SpawnDinoCoordsCheckBox, gbc_SpawnDinoCoordsCheckBox);
		SpawnDinoCoordsCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);

		/**
		 * this command is special cause it doesnt have a gui like the others but will
		 * rather run a command and only show the response.
		 */
		GridBagConstraints gbc_ListAllIDButton = new GridBagConstraints();
		gbc_ListAllIDButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListAllIDButton.insets = new Insets(0, 0, 5, 5);
		gbc_ListAllIDButton.gridx = 4;
		gbc_ListAllIDButton.gridy = 6;
		AdvancedCommandsPanel.add(ListAllIDButton, gbc_ListAllIDButton);
		ListAllIDButton.addActionListener(ActionlistnerAAM.AdvancedComListener);
		ListAllIDButton.setToolTipText("refreshes itself every 30 sec");

		GridBagConstraints gbc_ListAllIDCheckBox = new GridBagConstraints();
		gbc_ListAllIDButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListAllIDCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_ListAllIDCheckBox.gridx = 5;
		gbc_ListAllIDCheckBox.gridy = 6;
		AdvancedCommandsPanel.add(ListAllIDCheckBox, gbc_ListAllIDCheckBox);

		GridBagConstraints gbc_numberedButton = new GridBagConstraints();
		gbc_numberedButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListAllIDButton.fill = GridBagConstraints.HORIZONTAL;

		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.gridwidth = 6;
		gbc_separator_2.insets = new Insets(0, 0, 5, 0);
		gbc_separator_2.gridx = 0;
		gbc_separator_2.gridy = 7;
		AdvancedCommandsPanel.add(separator_2, gbc_separator_2);
		gbc_numberedButton.insets = new Insets(0, 0, 5, 5);
		gbc_numberedButton.gridx = 0;
		gbc_numberedButton.gridy = 8;
		AdvancedCommandsPanel.add(ListPlayerPosButton, gbc_numberedButton);
		ListPlayerPosButton.addActionListener(ActionlistnerAAM.AdvancedComListener);

		GridBagConstraints gbc_numberedCheckbox = new GridBagConstraints();
		gbc_numberedCheckbox.insets = new Insets(0, 0, 5, 5);
		gbc_numberedCheckbox.gridx = 1;
		gbc_numberedCheckbox.gridy = 8;
		AdvancedCommandsPanel.add(ListPlayerPosCheckbox, gbc_numberedCheckbox);
		ListPlayerPosCheckbox.addActionListener(ActionlistnerAAM.FavButtonListner);

		GridBagConstraints gbc_numberedButton_1 = new GridBagConstraints();
		gbc_numberedButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListAllIDButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_numberedButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_numberedButton_1.gridx = 2;
		gbc_numberedButton_1.gridy = 8;
		AdvancedCommandsPanel.add(ListAllUNCDinoButton, gbc_numberedButton_1);
		ListAllUNCDinoButton.addActionListener(ActionlistnerAAM.AdvancedComListener);

		GridBagConstraints gbc_numberedCheckbox_1 = new GridBagConstraints();
		gbc_numberedCheckbox_1.insets = new Insets(0, 0, 5, 5);
		gbc_numberedCheckbox_1.gridx = 3;
		gbc_numberedCheckbox_1.gridy = 8;
		AdvancedCommandsPanel.add(ListAllUNCDinoCheckBox, gbc_numberedCheckbox_1);		
		ListAllUNCDinoCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 9;
		AdvancedCommandsPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		GridBagConstraints gbc_DinoWipeSeqButton = new GridBagConstraints();
		gbc_DinoWipeSeqButton.fill = GridBagConstraints.BOTH;
		gbc_DinoWipeSeqButton.insets = new Insets(0, 0, 0, 5);
		gbc_DinoWipeSeqButton.gridx = 0;
		gbc_DinoWipeSeqButton.gridy = 10;
		AdvancedCommandsPanel.add(DinoWipeSeqButton, gbc_DinoWipeSeqButton);
		DinoWipeSeqButton.addActionListener(ActionlistnerAAM.AdvancedComListener);
		
		GridBagConstraints gbc_DinoWipeSeqCheckBox = new GridBagConstraints();
		gbc_DinoWipeSeqCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_DinoWipeSeqCheckBox.gridx = 1;
		gbc_DinoWipeSeqCheckBox.gridy = 10;
		AdvancedCommandsPanel.add(DinoWipeSeqCheckBox, gbc_DinoWipeSeqCheckBox);
		DinoWipeSeqCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		GridBagConstraints gbc_ShutdownSeqButton = new GridBagConstraints();
		gbc_ShutdownSeqButton.fill = GridBagConstraints.BOTH;
		gbc_ShutdownSeqButton.insets = new Insets(0, 0, 0, 5);
		gbc_ShutdownSeqButton.gridx = 2;
		gbc_ShutdownSeqButton.gridy = 10;
		AdvancedCommandsPanel.add(ShutdownSeqButton, gbc_ShutdownSeqButton);
		ShutdownSeqButton.addActionListener(ActionlistnerAAM.AdvancedComListener);
		
		GridBagConstraints gbc_ShutdownSeqCheckBox = new GridBagConstraints();
		gbc_ShutdownSeqCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_ShutdownSeqCheckBox.gridx = 3;
		gbc_ShutdownSeqCheckBox.gridy = 10;
		AdvancedCommandsPanel.add(ShutdownSeqCheckBox, gbc_ShutdownSeqCheckBox);
		ShutdownSeqCheckBox.addActionListener(ActionlistnerAAM.FavButtonListner);
		
		
		/**
		 * this panel is just a plain rcon
		 */
		tabbedPane.addTab("RCon", null, RconPanel, null);
		GridBagLayout gbl_RconPanel = new GridBagLayout();
		gbl_RconPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_RconPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_RconPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_RconPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		RconPanel.setLayout(gbl_RconPanel);
		
		GridBagConstraints gbc_RconScrollPane = new GridBagConstraints();
		gbc_RconScrollPane.gridwidth = 2;
		gbc_RconScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_RconScrollPane.fill = GridBagConstraints.BOTH;
		gbc_RconScrollPane.gridx = 1;
		gbc_RconScrollPane.gridy = 1;
		RconPanel.add(RconScrollPane, gbc_RconScrollPane);
		
		RconScrollPane.setViewportView(RconLogPanel);
		RconLogPanel.setLayout(new BoxLayout(RconLogPanel, BoxLayout.Y_AXIS));
		
		final JLabel StartLabel = new JLabel(new Date().toString() + ": \t Start of the log");
		RconLogPanel.add(StartLabel);
		
		GridBagConstraints gbc_RconField = new GridBagConstraints();
		gbc_RconField.insets = new Insets(0, 0, 5, 5);
		gbc_RconField.fill = GridBagConstraints.HORIZONTAL;
		gbc_RconField.gridx = 1;
		gbc_RconField.gridy = 2;
		RconPanel.add(RconField, gbc_RconField);
		
		GridBagConstraints gbc_RconRunButton = new GridBagConstraints();
		gbc_RconRunButton.insets = new Insets(0, 0, 5, 5);
		gbc_RconRunButton.gridx = 2;
		gbc_RconRunButton.gridy = 2;
		RconPanel.add(RconRunButton, gbc_RconRunButton);
		RconRunButton.addActionListener(ActionlistnerAAM.RconRunListner);
		
		
		/**
		 * this is the panel for the custom commands, this is a dynamicly build panel.
		 */

		tabbedPane.addTab("RCon", null, RconPanel, null);
		GridBagLayout gbl_RconPanel = new GridBagLayout();
		gbl_RconPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_RconPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_RconPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_RconPanel.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		RconPanel.setLayout(gbl_RconPanel);

		GridBagConstraints gbc_RconScrollPane = new GridBagConstraints();
		gbc_RconScrollPane.gridwidth = 2;
		gbc_RconScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_RconScrollPane.fill = GridBagConstraints.BOTH;
		gbc_RconScrollPane.gridx = 1;
		gbc_RconScrollPane.gridy = 1;
		RconPanel.add(RconScrollPane, gbc_RconScrollPane);

		RconScrollPane.setViewportView(RconLogPanel);
		RconLogPanel.setLayout(new BoxLayout(RconLogPanel, BoxLayout.Y_AXIS));

		final JLabel StartLabel = new JLabel(new Date().toString() + ": \t Start of the log");
		RconLogPanel.add(StartLabel);

		GridBagConstraints gbc_RconField = new GridBagConstraints();
		gbc_RconField.insets = new Insets(0, 0, 5, 5);
		gbc_RconField.fill = GridBagConstraints.HORIZONTAL;
		gbc_RconField.gridx = 1;
		gbc_RconField.gridy = 2;
		RconPanel.add(RconField, gbc_RconField);

		GridBagConstraints gbc_RconRunButton = new GridBagConstraints();
		gbc_RconRunButton.insets = new Insets(0, 0, 5, 5);
		gbc_RconRunButton.gridx = 2;
		gbc_RconRunButton.gridy = 2;
		RconPanel.add(RconRunButton, gbc_RconRunButton);
		RconRunButton.addActionListener(ActionlistnerAAM.RconRunListner);

		JPanel CustomCommandsPanel = new JPanel();
		tabbedPane.addTab("custom commands", null, CustomCommandsPanel, null);
		GridBagLayout gbl_CustomCommandsPanel = new GridBagLayout();
		gbl_CustomCommandsPanel.columnWidths = new int[] { 0, 592, 24, 0 };
		gbl_CustomCommandsPanel.rowHeights = new int[] { 30, 0, 0, 0, 0 };
		gbl_CustomCommandsPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_CustomCommandsPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		CustomCommandsPanel.setLayout(gbl_CustomCommandsPanel);

		JLabel CCDescLabel = new JLabel("Custom Commands");
		CCDescLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_CCDescLabel = new GridBagConstraints();
		gbc_CCDescLabel.insets = new Insets(0, 0, 5, 5);
		gbc_CCDescLabel.gridx = 1;
		gbc_CCDescLabel.gridy = 0;
		CustomCommandsPanel.add(CCDescLabel, gbc_CCDescLabel);

		/**
		 * the building of the button for adding custom commands and its corresponding
		 * menu
		 */
		JButton CCNewButton = new JButton("\u2795");
		GridBagConstraints gbc_CCNewButton = new GridBagConstraints();
		gbc_CCNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_CCNewButton.gridx = 2;
		gbc_CCNewButton.gridy = 0;
		CustomCommandsPanel.add(CCNewButton, gbc_CCNewButton);

		JPopupMenu AddCommandPopup = new JPopupMenu();
		AddCommandPopup.add(new JMenuItem(new AbstractAction("Add Script Command") {
			private static final long serialVersionUID = 3544446822075232063L;

			@Override
			public void actionPerformed(ActionEvent e) {
				AddNewScriptGui.createGui();
			}
		}));
		AddCommandPopup.add(new JMenuItem(new AbstractAction("Add Plugin Command") {
			private static final long serialVersionUID = -5126190973173806036L;

			@Override
			public void actionPerformed(ActionEvent e) {
				AddNewPluginCommand.createGui();
			}
		}));
		AddCommandPopup.add(new JMenuItem(new AbstractAction("Add Command Series") {
			private static final long serialVersionUID = -2072104664682254395L;

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(ContentPane, "not functional");
			}
		}));

		CCNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddCommandPopup.show(CCNewButton, 0, 22);
			}
		});

		JLabel CCHelpLabel = new JLabel("press the + to add more commands hover over ? for more help");
		GridBagConstraints gbc_CCHelpLabel = new GridBagConstraints();
		gbc_CCHelpLabel.insets = new Insets(0, 0, 5, 5);
		gbc_CCHelpLabel.gridx = 1;
		gbc_CCHelpLabel.gridy = 1;
		CustomCommandsPanel.add(CCHelpLabel, gbc_CCHelpLabel);

		JButton CCHelpButton = new JButton("?");
		CCHelpButton.setToolTipText(
				"<html>this tab allows you to register custom commands,<br>\r\n\nthese can consist of if mods that support them are installed,<br>\r\nusing the \n\"ScriptCommand\" command for use with mods.<br>\r\nanother possibility is to add commands added by the plugins<br>\r\nfor a service called ark api see \"help\" under settings for a<br>\r\ndetailed explanation of the command creation GUI.</html>");
		CCHelpButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_CCHelpButton = new GridBagConstraints();
		gbc_CCHelpButton.insets = new Insets(0, 0, 5, 0);
		gbc_CCHelpButton.gridx = 2;
		gbc_CCHelpButton.gridy = 1;
		CustomCommandsPanel.add(CCHelpButton, gbc_CCHelpButton);

		/**
		 * a scrollpane is used inside the custom command pane to accomodate for more
		 * commands that that can physically on screen
		 */
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		CustomCommandsPanel.add(scrollPane, gbc_scrollPane);

		scrollPane.setViewportView(ButtonPanel);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());

		ButtonPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.insets = new Insets(0, 0, 5, 5);
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 0;

		try {
			for (int i = 0; i < cfg.ScriptCommandsNames().length; i++) {
				ButtonPanel.add(CustomButtonBuilder.BuildScriptButton(
						cfg.ScriptCommandsNames()[i].replace("[", "").replace("]", ""),
						cfg.ScriptCommands()[i].replace("[", "").replace("]", "")), gbc_buttonPanel);
				gbc_buttonPanel.gridx++;
				if (gbc_buttonPanel.gridx == 5) {
					gbc_buttonPanel.gridx = 0;
					gbc_buttonPanel.gridy++;
				}
			}
		} catch (NullPointerException e) {
		}

		try {
			for (int i = 0; i < cfg.PluginCommandsNames().length; i++) {
				ButtonPanel.add(
						CustomButtonBuilder.BuildPluginButton(
								cfg.PluginCommandsNames()[i].replace("[", "").replace("]", ""),
								cfg.PluginCommands()[i].replace("[", "").replace("]", ""),
								Boolean.valueOf(cfg.PluginCommandsArgs()[i].replace("[", "").replace("]", ""))),
						gbc_buttonPanel);
				gbc_buttonPanel.gridx++;
				if (gbc_buttonPanel.gridx == 5) {
					gbc_buttonPanel.gridx = 0;
					gbc_buttonPanel.gridy++;
				}
			}
		} catch (NullPointerException e) {
		}

		/**
		 * the panel for showing the items imported by the user, also makes use of a
		 * scrollpane
		 */
		JNumberedPanel ImpotedItemsPanel = new JNumberedPanel();
		tabbedPane.addTab("imported items", null, ImpotedItemsPanel, null);
		GridBagLayout gbl_ImpotedItemsPanel = new GridBagLayout();
		gbl_ImpotedItemsPanel.columnWidths = new int[] { 40, 564, 40, 0 };
		gbl_ImpotedItemsPanel.rowHeights = new int[] { 40, 310, 40, 0 };
		gbl_ImpotedItemsPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_ImpotedItemsPanel.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		ImpotedItemsPanel.setLayout(gbl_ImpotedItemsPanel);

		JLabel IIDescLabel = new JLabel("Imported Items");
		IIDescLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_IIDescLabel = new GridBagConstraints();
		gbc_IIDescLabel.insets = new Insets(0, 0, 5, 5);
		gbc_IIDescLabel.gridx = 1;
		gbc_IIDescLabel.gridy = 0;
		ImpotedItemsPanel.add(IIDescLabel, gbc_IIDescLabel);

		JButton IIHelpButton = new JButton("?");
		IIHelpButton.setToolTipText(
				"<html>this tab shows the imported items per group<br>\r\n\nand their blueprint paths, you can use this to see which<br>\r\n\nitems you have imported and to check if specific PB paths<br>\r\n\nare up to date, see the \"help\" option under settings for an <br>\r\nexplanation of importing item lists<html>");
		IIHelpButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_IIHelpButton = new GridBagConstraints();
		gbc_IIHelpButton.insets = new Insets(0, 0, 5, 0);
		gbc_IIHelpButton.gridx = 2;
		gbc_IIHelpButton.gridy = 0;
		ImpotedItemsPanel.add(IIHelpButton, gbc_IIHelpButton);

		ScrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane1 = new GridBagConstraints();
		gbc_scrollPane1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane1.gridx = 1;
		gbc_scrollPane1.gridy = 1;
		ImpotedItemsPanel.add(ScrollPane, gbc_scrollPane1);
		DefSPbounds = new Rectangle(564, 310);

		ScrollPanel = new JPanel();
		ScrollPane.setViewportView(ScrollPanel);
		GridBagLayout gbl_scrollPanel = new GridBagLayout();
		gbl_scrollPanel.columnWidths = new int[] { 0 };
		gbl_scrollPanel.rowHeights = new int[] { 0 };
		gbl_scrollPanel.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_scrollPanel.rowWeights = new double[] { Double.MIN_VALUE };
		ScrollPanel.setLayout(gbl_scrollPanel);

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

		for (int i = 0; i < Reference.ImportedItemGroups.size(); i++) {

			for (int x = 0; x < Reference.ImportedItemGroups.get(i).getSecondValue().size(); x++) {
				ScrollPanel.add(
						new JLabel(Reference.ImportedItemGroups.get(i).getSecondValue().get(x).getSecondValue()),
						gbc_ImItemLabel);
				gbc_ImItemLabel.gridy++;
			}

			for (int y = 0; y < Reference.ImportedItemGroups.get(i).getSecondValue().size(); y++) {
				ScrollPanel.add(new JLabel(Reference.ImportedItemGroups.get(i).getSecondValue().get(y).getFirstValue()),
						gbc_ImItemLabel2);
				gbc_ImItemLabel2.gridy++;
			}

		}

		/**
		 * the panel used for seeing and running queued commands
		 */
		tabbedPane.addTab("queue", null, QueuePanel, null);
		tabbedPane.setEnabledAt(6, true);
		GridBagLayout gbl_QueuePanel = new GridBagLayout();
		gbl_QueuePanel.columnWidths = new int[] { 40, 293, 0, 40, 0 };
		gbl_QueuePanel.rowHeights = new int[] { 40, 0, 30, 30, 0 };
		gbl_QueuePanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_QueuePanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		QueuePanel.setLayout(gbl_QueuePanel);

		JLabel QDescLabel = new JLabel("Queue");
		QDescLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_QDescLabel = new GridBagConstraints();
		gbc_QDescLabel.gridwidth = 2;
		gbc_QDescLabel.insets = new Insets(0, 0, 5, 5);
		gbc_QDescLabel.gridx = 1;
		gbc_QDescLabel.gridy = 0;
		QueuePanel.add(QDescLabel, gbc_QDescLabel);

		gbc_QueueList.gridwidth = 2;
		gbc_QueueList.insets = new Insets(0, 0, 5, 5);
		gbc_QueueList.fill = GridBagConstraints.BOTH;
		gbc_QueueList.gridx = 1;
		gbc_QueueList.gridy = 1;
		QueuePanel.add(QueueList, gbc_QueueList);
		GridBagLayout gbl_QueueList = new GridBagLayout();
		gbl_QueueList.columnWidths = new int[] { 514, 40, 0 };
		gbl_QueueList.rowHeights = new int[] { 30, 0 };
		gbl_QueueList.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_QueueList.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		QueueList.setLayout(gbl_QueueList);

		gbc_commandLable.insets = new Insets(0, 0, 0, 5);
		gbc_commandLable.gridx = 0;
		gbc_commandLable.gridy = 0;
		QueueList.add(CommandLable, gbc_commandLable);

		gbc_RemoveLabel.gridx = 1;
		gbc_RemoveLabel.gridy = 0;
		QueueList.add(RemoveLabel, gbc_RemoveLabel);

		JButton QHelpButton = new JButton("?");
		QHelpButton.setToolTipText(
				"<html>this is the command queue, commads<br>\r\nqueued up will appear here and can be run all in<br>\r\n\nquick succession by pressing \"Run\" or ran with<br>\r\n\na delay by setting the delay in seconds and then<br>\n\r\npressing the \"Run With Delay\" button</html>");
		QHelpButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GridBagConstraints gbc_QHelpButton = new GridBagConstraints();
		gbc_QHelpButton.insets = new Insets(0, 0, 5, 0);
		gbc_QHelpButton.gridx = 3;
		gbc_QHelpButton.gridy = 1;
		QueuePanel.add(QHelpButton, gbc_QHelpButton);

		GridBagConstraints gbc_DelaySpinner = new GridBagConstraints();
		gbc_DelaySpinner.insets = new Insets(0, 0, 5, 5);
		gbc_DelaySpinner.gridx = 1;
		gbc_DelaySpinner.gridy = 2;
		QueuePanel.add(DelaySpinner, gbc_DelaySpinner);

		JButton RunDelayButton = new JButton("Run With Delay");
		GridBagConstraints gbc_RunDelayButton = new GridBagConstraints();
		gbc_RunDelayButton.insets = new Insets(0, 0, 0, 5);
		gbc_RunDelayButton.gridx = 1;
		gbc_RunDelayButton.gridy = 3;
		QueuePanel.add(RunDelayButton, gbc_RunDelayButton);

		JButton RunButton = new JButton("Run");
		GridBagConstraints gbc_RunButton = new GridBagConstraints();
		gbc_RunButton.insets = new Insets(0, 0, 0, 5);
		gbc_RunButton.gridx = 2;
		gbc_RunButton.gridy = 3;
		QueuePanel.add(RunButton, gbc_RunButton);
		RunButton.addActionListener(ActionlistnerAAM.RunListner);

		gbc_commandList.gridx = 0;
		gbc_commandList.gridy = 1;
		gbc_commandList.weighty = 1;
		gbc_commandButtonList.gridx = 1;
		gbc_commandButtonList.gridy = 1;
		gbc_commandButtonList.weighty = 1;
		for (int i = 0; i < Reference.Queue.size(); i++) {
			QueueList.add(new JLabel(Reference.Queue.get(i).generateCommand()), gbc_commandList);
			QueueList.add(new JNumberedButton("X", ActionlistnerAAM.QueueRemoveListner, i), gbc_commandButtonList);
			gbc_commandList.gridy++;
			gbc_commandButtonList.gridy++;
		}

		/**
		 * this added the favorite commands to the the favorites panel. the buttons are
		 * clones of the ones used in original panels
		 */
		int[] favoriteInts = cfg.Favorites();

		for (int integer : favoriteInts) {
			if (integer == 0)
				continue;
			Reference.FavoriteButtonList.add((JNumberedButton) Utils.findButtonByNumber(integer).clone());
			Utils.findCheckboxByNumber(integer).setSelected(true);
		}

		gbc_FavButtons.insets = new Insets(0, 0, 0, 5);
		gbc_FavButtons.gridx = 0;
		gbc_FavButtons.gridy = 0;
		gbc_FavButtons.fill = GridBagConstraints.BOTH;

		if (Reference.FavoriteButtonList != null) {
			for (JNumberedButton button : Reference.FavoriteButtonList) {
				if (button != null)
					FavoritesPanel.add(FavButtonPanelBuilder.buildPanel(button), gbc_FavButtons);
				if (gbc_FavButtons.gridx != 2) {
					gbc_FavButtons.gridx++;
				} else {
					gbc_FavButtons.gridx = 0;
					gbc_FavButtons.gridy++;
				}
			}
		}

		/**
		 * setting up the welcome panel that overlays the program on first launch.
		 */
		final JPanel glass = (JPanel) getGlassPane();

		GridBagLayout gbl_WelcomePanel = new GridBagLayout();
		gbl_WelcomePanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_WelcomePanel.rowHeights = new int[] { 0, 0, 29, 0, 0, 0 };
		gbl_WelcomePanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_WelcomePanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		glass.setLayout(gbl_WelcomePanel);

		JLabel welcomeLabel = new JLabel("Welcome");
		welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 38));
		GridBagConstraints gbc_welcomeLabel = new GridBagConstraints();
		gbc_welcomeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_welcomeLabel.gridx = 1;
		gbc_welcomeLabel.gridy = 1;
		glass.add(welcomeLabel, gbc_welcomeLabel);

		JLabel WelcomeTextLabel = new JLabel(
				"<html>Welcome to Ark Admin Manager aka AAM, this is a \"simple\" tool to help ark server admins manage their<br>\r\nservers, to get started choose one of the tabs on the top or read the help under settings. all tabs also have a<br>\r\nhover over \"?\" in case you need a little reminder on how to use, to setup servers to run commands on, click<br>settings in the menu bar and select servers from the popup.<html>");
		GridBagConstraints gbc_WelcomeTextLabel = new GridBagConstraints();
		gbc_WelcomeTextLabel.insets = new Insets(0, 0, 5, 5);
		gbc_WelcomeTextLabel.gridx = 1;
		gbc_WelcomeTextLabel.gridy = 2;
		glass.add(WelcomeTextLabel, gbc_WelcomeTextLabel);

		JButton WelcomeOkButton = new JButton("OK");
		GridBagConstraints gbc_WelcomeOkButton = new GridBagConstraints();
		gbc_WelcomeOkButton.insets = new Insets(0, 0, 5, 5);
		gbc_WelcomeOkButton.gridx = 1;
		gbc_WelcomeOkButton.gridy = 3;
		glass.add(WelcomeOkButton, gbc_WelcomeOkButton);
		WelcomeOkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				glass.setVisible(true);
				glass.removeAll();
				glass.setOpaque(false);
				glass.revalidate();
				glass.repaint();

				JLabel LoginLabel = new JLabel("logged in as " + Reference.UserName);
				GridBagConstraints gbc_LoginLabel = new GridBagConstraints();
				gbc_LoginLabel.insets = new Insets(2, 0, 0, 5);
				gbc_LoginLabel.gridx = 10;
				gbc_LoginLabel.gridy = 0;
				glass.add(LoginLabel, gbc_LoginLabel);
			}
		});

		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Dont Show Again\r\n");
		GridBagConstraints gbc_chckbxNewCheckBox_3 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_3.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox_3.gridx = 1;
		gbc_chckbxNewCheckBox_3.gridy = 4;
		glass.add(chckbxNewCheckBox_3, gbc_chckbxNewCheckBox_3);
		chckbxNewCheckBox_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cfg.setProperty("ShowWelcome", "false");
				try {
					cfg.store(new FileOutputStream("AAMConfig.properties"), "no comments");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		});

		glass.setOpaque(true);
		SwingUtilities.updateComponentTreeUI(glass);

		if (cfg.ShowWelcome())
			glass.setVisible(true);
		else
			WelcomeOkButton.doClick();

		AAMGui.tabbedPaneOut.setSelectedIndex(-1);

		/**
		 * this ChangeListner makes it so panels are reloaded when someone opens the
		 * corresponding tab.
		 * this also reloads the look and feel to prevent errors with it.
		 */
		tabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {

				if (tabbedPane.getSelectedIndex() == 0) {

					SwingUtilities.updateComponentTreeUI(FavoritesPanel);
					FavoritesPanel.removeAll();
					FavoritesPanel.revalidate();
					FavoritesPanel.repaint();
					gbc_FavButtons.insets = new Insets(0, 0, 0, 5);
					gbc_FavButtons.gridx = 0;
					gbc_FavButtons.gridy = 0;

					if (Reference.FavoriteButtonList != null) {
						for (JNumberedButton button : Reference.FavoriteButtonList) {
							// favorites_panel.add(button, gbc_FavButtons);
							FavoritesPanel.add(FavButtonPanelBuilder.buildPanel(button), gbc_FavButtons);
							if (gbc_FavButtons.gridx != 2) {
								gbc_FavButtons.gridx++;
							} else {
								gbc_FavButtons.gridx = 0;
								gbc_FavButtons.gridy++;
							}
						}
					}
				} else if (tabbedPane.getSelectedIndex() == 1) {
					SwingUtilities.updateComponentTreeUI(SimpleCommandsPanel);
				} else if (tabbedPane.getSelectedIndex() == 2) {
					SwingUtilities.updateComponentTreeUI(AdvancedCommandsPanel);
				}else if (tabbedPane.getSelectedIndex() == 3) {
					SwingUtilities.updateComponentTreeUI(RconPanel);
				}else if (tabbedPane.getSelectedIndex() == 4) {
					SwingUtilities.updateComponentTreeUI(CustomCommandsPanel);

					ButtonPanel.removeAll();
					ButtonPanel.revalidate();
					ButtonPanel.repaint();

					AAMConfig cfg = ConfigFactory.create(AAMConfig.class);

					gbc_buttonPanel.insets = new Insets(0, 0, 5, 5);
					gbc_buttonPanel.fill = GridBagConstraints.BOTH;
					gbc_buttonPanel.gridx = 0;
					gbc_buttonPanel.gridy = 0;

					try {
						for (int i = 0; i < cfg.ScriptCommandsNames().length; i++) {
							ButtonPanel.add(
									CustomButtonBuilder.BuildScriptButton(
											cfg.ScriptCommandsNames()[i].replace("[", "").replace("]", ""),
											cfg.ScriptCommands()[i].replace("[", "").replace("]", "")),
									gbc_buttonPanel);
							gbc_buttonPanel.gridx++;
							if (gbc_buttonPanel.gridx == 5) {
								gbc_buttonPanel.gridx = 0;
								gbc_buttonPanel.gridy++;
							}
						}
					} catch (NullPointerException e1) {
						e1.printStackTrace();
					}

					try {
						for (int i = 0; i < cfg.PluginCommandsNames().length; i++) {
							ButtonPanel.add(
									CustomButtonBuilder.BuildPluginButton(
											cfg.PluginCommandsNames()[i].replace("[", "").replace("]", ""),
											cfg.PluginCommands()[i].replace("[", "").replace("]", ""),
											Boolean.valueOf(
													cfg.PluginCommandsArgs()[i].replace("[", "").replace("]", ""))),
									gbc_buttonPanel);
							gbc_buttonPanel.gridx++;
							if (gbc_buttonPanel.gridx == 5) {
								gbc_buttonPanel.gridx = 0;
								gbc_buttonPanel.gridy++;
							}
						}
					} catch (NullPointerException e1) {
						e1.printStackTrace();
					}
				} else if (tabbedPane.getSelectedIndex() == 5) {
					SwingUtilities.updateComponentTreeUI(ImpotedItemsPanel);

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

					ScrollPanel.removeAll();
					ScrollPanel.revalidate();
					ScrollPanel.repaint();

					for (int i = 0; i < Reference.ImportedItemGroups.size(); i++) {

						for (int x = 0; x < Reference.ImportedItemGroups.get(i).getSecondValue().size(); x++) {
							ScrollPanel.add(new JLabel(
									Reference.ImportedItemGroups.get(i).getSecondValue().get(x).getSecondValue()),
									gbc_ImItemLabel);
							gbc_ImItemLabel.gridy++;
						}

						for (int y = 0; y < Reference.ImportedItemGroups.get(i).getSecondValue().size(); y++) {
							ScrollPanel.add(new JLabel(
									Reference.ImportedItemGroups.get(i).getSecondValue().get(y).getFirstValue()),
									gbc_ImItemLabel2);
							gbc_ImItemLabel2.gridy++;
						}

					}
				} else if (tabbedPane.getSelectedIndex() == 6) {
					SwingUtilities.updateComponentTreeUI(QueuePanel);
					QueuePanel.removeAll();
					QueuePanel.revalidate();
					QueuePanel.repaint();
					QueuePanel.add(QDescLabel, gbc_QDescLabel);
					QueuePanel.add(QueueList, gbc_QueueList);

					QueueList.setLayout(gbl_QueueList);
					QueueList.removeAll();
					QueueList.revalidate();
					QueueList.repaint();

					QueueList.add(CommandLable, gbc_commandLable);
					QueueList.add(RemoveLabel, gbc_RemoveLabel);

					QueuePanel.add(DelaySpinner, gbc_DelaySpinner);

					QueuePanel.add(RunDelayButton, gbc_RunDelayButton);
					QueuePanel.add(RunButton, gbc_RunButton);

					GridBagConstraints gbc_commandList = new GridBagConstraints();
					gbc_commandList.gridx = 0;
					gbc_commandList.gridy = 1;
					gbc_commandList.weighty = 1;
					gbc_commandButtonList.gridx = 1;
					gbc_commandButtonList.gridy = 1;
					gbc_commandButtonList.weighty = 1;
					for (int i = 0; i < Reference.Queue.size(); i++) {
						QueueList.add(new JLabel(Reference.Queue.get(i).generateCommand()), gbc_commandList);
						QueueList.add(new JNumberedButton("X", ActionlistnerAAM.QueueRemoveListner, i),
								gbc_commandButtonList);
						gbc_commandList.gridy++;
						gbc_commandButtonList.gridy++;
					}

					QueuePanel.add(QHelpButton, gbc_QHelpButton);
				}

			}
		});

		/**
		 * this set the tooltips for the fav checkboxes, done with a loop for more
		 * efficiency
		 */
		Component[] components = SimpleCommandsPanel.getComponents();
		for (int i = 1; i < components.length; i++) {
			if (components[i] instanceof JNumberedCheckbox)
				((JNumberedCheckbox) components[i]).setToolTipText("click this to favorite the command");
		}

		/**
		 * setting up the settings for the tooltips
		 */
		int dismissDelay = Integer.MAX_VALUE;
		ToolTipManager.sharedInstance().setDismissDelay(dismissDelay);
		ToolTipManager.sharedInstance().setInitialDelay(0);
		ScrollPane.setBorder(BorderFactory.createEmptyBorder());
		ScrollPane.getVerticalScrollBar().setUnitIncrement(16);

		/**
		 * this window listener is used to save any information on closing the window
		 */
		addWindowListener(new WindowListener() {

			public void windowClosing(WindowEvent arg0) {

				ArrayList<Integer> ButtonNumbers = new ArrayList<Integer>();
				String ButtonNumbersString = "0";

				for (JNumberedButton button : Reference.FavoriteButtonList) {
					ButtonNumbers.add(button.getNumber());
					ButtonNumbersString = ButtonNumbersString + "," + button.getNumber();
				}

				// if(ButtonNumbersString != "") ButtonNumbersString =
				// ButtonNumbersString.substring(1);

				cfg = ConfigFactory.create(AAMConfig.class);

				cfg.setProperty("Theme", String.valueOf(Reference.theme));

				cfg.setProperty("Favorites", ButtonNumbersString);
				try {
					cfg.store(new FileOutputStream("AAMConfig.properties"), "no comments");
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				Main.logger.LogUser("Session with " + Reference.UserName + " ended", Level.INFO);

				System.exit(0);
			}

			public void windowOpened(WindowEvent arg0) {
			}

			public void windowClosed(WindowEvent arg0) {
			}

			public void windowIconified(WindowEvent arg0) {
			}

			public void windowDeiconified(WindowEvent arg0) {
			}

			public void windowActivated(WindowEvent arg0) {
			}

			public void windowDeactivated(WindowEvent arg0) {
			}
	    ToolTipManager.sharedInstance().setDismissDelay(dismissDelay);
	    ToolTipManager.sharedInstance().setInitialDelay(0);
	    ScrollPane.setBorder(BorderFactory.createEmptyBorder());
	    ScrollPane.getVerticalScrollBar().setUnitIncrement(16);
	    
	    /**
	     * this window listener is used to save any information on closing the window
	     */
	    addWindowListener(new WindowListener() {
	    	
	    	@Override
			public void windowClosing(WindowEvent arg0) {
				  
				  ArrayList<Integer> ButtonNumbers = new ArrayList<Integer>();
				  String ButtonNumbersString = "0";
				  
				  for(JNumberedButton button : Reference.FavoriteButtonList) {
					  ButtonNumbers.add(button.getNumber());
					  ButtonNumbersString = ButtonNumbersString + "," + button.getNumber();
				  }
				  
				  //if(ButtonNumbersString != "") ButtonNumbersString = ButtonNumbersString.substring(1);
				  
				  cfg = ConfigFactory.create(AAMConfig.class);
				  
				  cfg.setProperty("Theme", String.valueOf(Reference.theme));
				  
				  cfg.setProperty("Favorites", ButtonNumbersString);
				  try {
					  cfg.store(new FileOutputStream("AAMConfig.properties"), "no comments");
				  } catch (IOException e1) {
					  e1.printStackTrace();
				  }
				  
				  Main.logger.LogUser("Session with " + Reference.UserName + " ended", Level.INFO);
				  
				  System.exit(0);
			  }

			  @Override
			public void windowOpened(WindowEvent arg0) {}
			  @Override
			public void windowClosed(WindowEvent arg0) {}
			  @Override
			public void windowIconified(WindowEvent arg0) {}
			  @Override
			public void windowDeiconified(WindowEvent arg0) {}
			  @Override
			public void windowActivated(WindowEvent arg0) {}
			  @Override
			public void windowDeactivated(WindowEvent arg0) {}
		});

		setVisible(true);

		/**
		 * this code is used to make it so a user is asked to relog on restart.
		 */
		int logon = 1;
		if (cfg.LastLogin() != -1) {
			logon = JOptionPane.showConfirmDialog(ContentPane, "Do you want to log on to the server form last session?",
					"relog", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		}
		if (logon == 0) {
			ServersGUI.Authenticate(cfg.LastLogin());
		} else {
			cfg.setProperty("LastLogin", "-1");
			try {
				cfg.store(new FileOutputStream("AAMConfig.properties"), "no comments");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		for (int i : Reference.currentUser.getDisabledCommands()) {
			Utils.findButtonByNumber(i).setEnabled(false);
			Utils.findCheckboxByNumber(i).setEnabled(false);
		}

	    
	    try {
	    	for(int i : Reference.currentUser.getDisabledCommands()) {
	    		try {
	    			Utils.findButtonByNumber(i).setEnabled(false);
	    			Utils.findCheckboxByNumber(i).setEnabled(false);
	    		} catch (NullPointerException e) {}
	    	}
	    } catch (NullPointerException e) {
		}
	}

	/**
	 * adding buttons to the favorite list
	 * 
	 * @param button the button to be added to the favorite list
	 */
	public static void AddFavorite(JNumberedButton button) {
		Reference.FavoriteButtonList.add(button);
	}

	/**
	 * removing buttons to the favorite list
	 * 
	 * @param button the button to be removed from the favorite list
	 */
	public static void RemoveFavorite(JNumberedButton Button) {
		Reference.FavoriteButtonList.remove(Button);
	}

	/**
	 * @return the simple command panel
	 */
	public static JPanel GetSCPanel() {
		return SimpleCommandsPanel;
	}

	/**
	 * @return the advanced command panel
	 */
	public static JPanel GetACPanel() {
		return AdvancedCommandsPanel;
	}

	/**
	 * @return the look and feel
	 */
	public static LookAndFeel getLookAndFeel() {
		return UIManager.getLookAndFeel();
	}

	public static JPanel getContentPanel() {
		return ContentPane;
	}

	/**
	 * setting the look and feel for the gui. this is used to se t
	 * 
	 * @param lookAndFeel
	 */
	public static void setVisual(LookAndFeel lookAndFeel) {
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(ContentPane);
		SwingUtilities.updateComponentTreeUI(menuBar);

	}

}
