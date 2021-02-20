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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.JCheckBoxMenuItem;

public class AAMGui extends JFrame {
	private static final long serialVersionUID = -735583961255908606L;
	private JPanel contentPane;

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
		
		JMenu mnNewMenu = new JMenu("settings");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("import bp paths");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("in game settings");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("dark theme");
		mnNewMenu.add(chckbxmntmNewCheckItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		chckbxmntmNewCheckItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
					if(chckbxmntmNewCheckItem.isSelected() == true) {
						try {
							UIManager.setLookAndFeel(new FlatDarkLaf());
						} catch (UnsupportedLookAndFeelException e1) {
							e1.printStackTrace();
						}
					}
					else {
						try {
							UIManager.setLookAndFeel(new FlatLightLaf());
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
		
		JPanel simple_commands_panel = new JPanel();
		simple_commands_panel.setToolTipText("commands requiring at max one argument");
		tabbedPane.addTab("simple commands", null, simple_commands_panel, null);
		GridBagLayout gbl_simple_commands_panel = new GridBagLayout();
		gbl_simple_commands_panel.columnWidths = new int[]{185, 0, 185, 0, 185, 0, 0};
		gbl_simple_commands_panel.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_simple_commands_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_simple_commands_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		simple_commands_panel.setLayout(gbl_simple_commands_panel);
		
		JLabel lblNewLabel = new JLabel("commands requiring at max one argument");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		simple_commands_panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton = new JButton("set time");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("basic commands");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 1;
		simple_commands_panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		simple_commands_panel.add(btnNewButton, gbc_btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 2;
		simple_commands_panel.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JButton btnNewButton_1 = new JButton("players only");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 2;
		simple_commands_panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox_5 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_5.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_5.gridx = 3;
		gbc_chckbxNewCheckBox_5.gridy = 2;
		simple_commands_panel.add(chckbxNewCheckBox_5, gbc_chckbxNewCheckBox_5);
		
		JButton btnNewButton_2 = new JButton("toggle damage numbers");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.gridx = 4;
		gbc_btnNewButton_2.gridy = 2;
		simple_commands_panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox_9 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_9.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox_9.gridx = 5;
		gbc_chckbxNewCheckBox_9.gridy = 2;
		simple_commands_panel.add(chckbxNewCheckBox_9, gbc_chckbxNewCheckBox_9);
		
		JLabel lblNewLabel_4 = new JLabel("messaging");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 3;
		simple_commands_panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JButton btnNewButton_4 = new JButton("broadcast");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_4.anchor = GridBagConstraints.SOUTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 4;
		simple_commands_panel.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_8 = new JButton("send chat message");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_1.gridx = 1;
		gbc_chckbxNewCheckBox_1.gridy = 4;
		simple_commands_panel.add(chckbxNewCheckBox_1, gbc_chckbxNewCheckBox_1);
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_8.gridx = 2;
		gbc_btnNewButton_8.gridy = 4;
		simple_commands_panel.add(btnNewButton_8, gbc_btnNewButton_8);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox_6 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_6.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_6.gridx = 3;
		gbc_chckbxNewCheckBox_6.gridy = 4;
		simple_commands_panel.add(chckbxNewCheckBox_6, gbc_chckbxNewCheckBox_6);
		
		JLabel lblNewLabel_2 = new JLabel("logs");
		lblNewLabel_2.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 5;
		simple_commands_panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JButton btnNewButton_6 = new JButton("get chat log");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 0;
		gbc_btnNewButton_6.gridy = 6;
		simple_commands_panel.add(btnNewButton_6, gbc_btnNewButton_6);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox_2 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_2.gridx = 1;
		gbc_chckbxNewCheckBox_2.gridy = 6;
		simple_commands_panel.add(chckbxNewCheckBox_2, gbc_chckbxNewCheckBox_2);
		
		JButton btnNewButton_7 = new JButton("get game log");
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_7.gridx = 2;
		gbc_btnNewButton_7.gridy = 6;
		simple_commands_panel.add(btnNewButton_7, gbc_btnNewButton_7);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox_7 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_7.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_7.gridx = 3;
		gbc_chckbxNewCheckBox_7.gridy = 6;
		simple_commands_panel.add(chckbxNewCheckBox_7, gbc_chckbxNewCheckBox_7);
		
		JLabel lblNewLabel_1 = new JLabel("server managemnt");
		lblNewLabel_1.setBackground(Color.GRAY);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 7;
		simple_commands_panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnNewButton_5 = new JButton("stop server");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 8;
		simple_commands_panel.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox_3 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_3.gridx = 1;
		gbc_chckbxNewCheckBox_3.gridy = 8;
		simple_commands_panel.add(chckbxNewCheckBox_3, gbc_chckbxNewCheckBox_3);
		
		JButton btnNewButton_9 = new JButton("save game files");
		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_9.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_9.gridx = 2;
		gbc_btnNewButton_9.gridy = 8;
		simple_commands_panel.add(btnNewButton_9, gbc_btnNewButton_9);
		
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox_8 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_8.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_8.gridx = 3;
		gbc_chckbxNewCheckBox_8.gridy = 8;
		simple_commands_panel.add(chckbxNewCheckBox_8, gbc_chckbxNewCheckBox_8);
		
		JButton btnNewButton_12 = new JButton("dino wipe");
		GridBagConstraints gbc_btnNewButton_12 = new GridBagConstraints();
		gbc_btnNewButton_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_12.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_12.gridx = 4;
		gbc_btnNewButton_12.gridy = 8;
		simple_commands_panel.add(btnNewButton_12, gbc_btnNewButton_12);
		
		JCheckBox chckbxNewCheckBox_12 = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox_12 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_12.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox_12.gridx = 5;
		gbc_chckbxNewCheckBox_12.gridy = 8;
		simple_commands_panel.add(chckbxNewCheckBox_12, gbc_chckbxNewCheckBox_12);
		
		JLabel lblNewLabel_5 = new JLabel("moderation");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 9;
		simple_commands_panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JButton btnNewButton_3 = new JButton("ban player");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 10;
		simple_commands_panel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox_4 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_4.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox_4.gridx = 1;
		gbc_chckbxNewCheckBox_4.gridy = 10;
		simple_commands_panel.add(chckbxNewCheckBox_4, gbc_chckbxNewCheckBox_4);
		
		JButton btnNewButton_10 = new JButton("unban player");
		GridBagConstraints gbc_btnNewButton_10 = new GridBagConstraints();
		gbc_btnNewButton_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_10.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_10.gridx = 2;
		gbc_btnNewButton_10.gridy = 10;
		simple_commands_panel.add(btnNewButton_10, gbc_btnNewButton_10);
		
		JCheckBox chckbxNewCheckBox_10 = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox_10 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_10.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox_10.gridx = 3;
		gbc_chckbxNewCheckBox_10.gridy = 10;
		simple_commands_panel.add(chckbxNewCheckBox_10, gbc_chckbxNewCheckBox_10);
		
		JButton btnNewButton_11 = new JButton("kick player");
		GridBagConstraints gbc_btnNewButton_11 = new GridBagConstraints();
		gbc_btnNewButton_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_11.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_11.gridx = 4;
		gbc_btnNewButton_11.gridy = 10;
		simple_commands_panel.add(btnNewButton_11, gbc_btnNewButton_11);
		
		JCheckBox chckbxNewCheckBox_11 = new JCheckBox("");
		GridBagConstraints gbc_chckbxNewCheckBox_11 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_11.gridx = 5;
		gbc_chckbxNewCheckBox_11.gridy = 10;
		simple_commands_panel.add(chckbxNewCheckBox_11, gbc_chckbxNewCheckBox_11);
		
		JPanel advanced_commands_panel = new JPanel();
		tabbedPane.addTab("advanced commands", null, advanced_commands_panel, null);
		
		JPanel custom_commands_panel = new JPanel();
		tabbedPane.addTab("custom commands", null, custom_commands_panel, null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("inported items", null, panel, null);
	}

}
