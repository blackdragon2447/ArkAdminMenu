package com.blackdragon2447.AAM.gui.auth;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.aeonbits.owner.ConfigFactory;

import com.blackdragon2447.AAM.util.Utils;
import com.blackdragon2447.AAM.util.iface.AAMConfig;
import javax.swing.JSeparator;

public class CreateServersDialog extends JDialog{

	private static final long serialVersionUID = 2973358479810664698L;
	private static JTextField IPField;
	private static JTextField PortField;
	private static JTextField serverNameField;
	static JList<String> list = new JList<String>();
	static AAMConfig cfg = ConfigFactory.create(AAMConfig.class);
	private JTextField adminNameField;
	private JTextField SteamIDField;

	/**
	 * Launch the application.
	 */
	public static void createGui() {
		CreateServersDialog frame = null;
		frame = new CreateServersDialog();
		frame.setVisible(true);
	}
	
	public CreateServersDialog() {
		
		setBounds(new Rectangle(450, 300));
		
		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel serversPanel = new JPanel();
		tabbedPane.addTab("Owned Addresses", null, serversPanel, null);
		GridBagLayout gbl_serversPanel = new GridBagLayout();
		gbl_serversPanel.columnWidths = new int[]{200, 0, 0};
		gbl_serversPanel.rowHeights = new int[] {0, 0, 0, 0, 0};
		gbl_serversPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_serversPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
		serversPanel.setLayout(gbl_serversPanel);
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setModal(true);
		
		JLabel serverNameLabel = new JLabel("Server Name");
		GridBagConstraints gbc_serverNameLabel = new GridBagConstraints();
		gbc_serverNameLabel.anchor = GridBagConstraints.EAST;
		gbc_serverNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_serverNameLabel.gridx = 0;
		gbc_serverNameLabel.gridy = 0;
		serversPanel.add(serverNameLabel, gbc_serverNameLabel);
		
		serverNameField = new JTextField();
		GridBagConstraints gbc_serverNameField = new GridBagConstraints();
		gbc_serverNameField.insets = new Insets(0, 0, 5, 5);
		gbc_serverNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_serverNameField.gridx = 1;
		gbc_serverNameField.gridy = 0;
		serversPanel.add(serverNameField, gbc_serverNameField);
		serverNameField.setColumns(10);
		
		JLabel IPLable = new JLabel("Server IP");
		GridBagConstraints gbc_IPLable = new GridBagConstraints();
		gbc_IPLable.insets = new Insets(0, 0, 5, 5);
		gbc_IPLable.anchor = GridBagConstraints.EAST;
		gbc_IPLable.gridx = 0;
		gbc_IPLable.gridy = 1;
		serversPanel.add(IPLable, gbc_IPLable);
		
		IPField = new JTextField();
		GridBagConstraints gbc_IPField = new GridBagConstraints();
		gbc_IPField.insets = new Insets(0, 0, 5, 5);
		gbc_IPField.fill = GridBagConstraints.HORIZONTAL;
		gbc_IPField.gridx = 1;
		gbc_IPField.gridy = 1;
		serversPanel.add(IPField, gbc_IPField);
		IPField.setColumns(10);
		
		JLabel PortLabel = new JLabel("RCon Port");
		GridBagConstraints gbc_PortLabel = new GridBagConstraints();
		gbc_PortLabel.anchor = GridBagConstraints.EAST;
		gbc_PortLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PortLabel.gridx = 0;
		gbc_PortLabel.gridy = 2;
		serversPanel.add(PortLabel, gbc_PortLabel);
		
		PortField = new JTextField();
		GridBagConstraints gbc_PortField = new GridBagConstraints();
		gbc_PortField.insets = new Insets(0, 0, 5, 5);
		gbc_PortField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PortField.gridx = 1;
		gbc_PortField.gridy = 2;
		serversPanel.add(PortField, gbc_PortField);
		PortField.setColumns(10);
		
		JButton RemoveButton = new JButton("Remove");
		GridBagConstraints gbc_RemoveButton = new GridBagConstraints();
		gbc_RemoveButton.insets = new Insets(0, 0, 5, 5);
		gbc_RemoveButton.gridx = 0;
		gbc_RemoveButton.gridy = 3;
		serversPanel.add(RemoveButton, gbc_RemoveButton);
		RemoveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeServer(list.getSelectedIndex());
			}
		});
		
		JButton AddButton = new JButton("Add");
		GridBagConstraints gbc_AddButton = new GridBagConstraints();
		gbc_AddButton.insets = new Insets(0, 0, 5, 0);
		gbc_AddButton.gridx = 1;
		gbc_AddButton.gridy = 3;
		serversPanel.add(AddButton, gbc_AddButton);
		AddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Utils.AddServer(serverNameField.getText(), IPField.getText(), Integer.valueOf(PortField.getText()));
				refresh();
				clearFields();
			}
		});
		
		String serverList[] = new String[5];
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(5, 5, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		serversPanel.add(scrollPane, gbc_scrollPane);
		scrollPane.setViewportView(list);
		
		JPanel adminsPanel = new JPanel();
		tabbedPane.addTab("Admins", null, adminsPanel, null);
		GridBagLayout gbl_adminsPanel = new GridBagLayout();
		gbl_adminsPanel.columnWidths = new int[]{200, 0, 0};
		gbl_adminsPanel.rowHeights = new int[]{0, 25, 31, 0, 0, 0};
		gbl_adminsPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_adminsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		adminsPanel.setLayout(gbl_adminsPanel);
		
		JLabel adminNameLabel = new JLabel("Name");
		GridBagConstraints gbc_adminNameLabel = new GridBagConstraints();
		gbc_adminNameLabel.anchor = GridBagConstraints.EAST;
		gbc_adminNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_adminNameLabel.gridx = 0;
		gbc_adminNameLabel.gridy = 0;
		adminsPanel.add(adminNameLabel, gbc_adminNameLabel);
		
		adminNameField = new JTextField();
		adminNameField.setColumns(10);
		GridBagConstraints gbc_adminNameField = new GridBagConstraints();
		gbc_adminNameField.insets = new Insets(0, 0, 5, 0);
		gbc_adminNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_adminNameField.gridx = 1;
		gbc_adminNameField.gridy = 0;
		adminsPanel.add(adminNameField, gbc_adminNameField);
		
		JLabel SteamIDLabel = new JLabel("Steam ID");
		GridBagConstraints gbc_SteamIDLabel = new GridBagConstraints();
		gbc_SteamIDLabel.anchor = GridBagConstraints.EAST;
		gbc_SteamIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_SteamIDLabel.gridx = 0;
		gbc_SteamIDLabel.gridy = 1;
		adminsPanel.add(SteamIDLabel, gbc_SteamIDLabel);
		
		SteamIDField = new JTextField();
		GridBagConstraints gbc_SteamIDField = new GridBagConstraints();
		gbc_SteamIDField.insets = new Insets(0, 0, 5, 0);
		gbc_SteamIDField.fill = GridBagConstraints.HORIZONTAL;
		gbc_SteamIDField.gridx = 1;
		gbc_SteamIDField.gridy = 1;
		adminsPanel.add(SteamIDField, gbc_SteamIDField);
		SteamIDField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 2;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 2;
		adminsPanel.add(separator, gbc_separator);
		
		JButton RemoveButton_1 = new JButton("Remove");
		GridBagConstraints gbc_RemoveButton_1 = new GridBagConstraints();
		gbc_RemoveButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_RemoveButton_1.gridx = 0;
		gbc_RemoveButton_1.gridy = 3;
		adminsPanel.add(RemoveButton_1, gbc_RemoveButton_1);
		
		JButton AddButton_1 = new JButton("Add");
		GridBagConstraints gbc_AddButton_1 = new GridBagConstraints();
		gbc_AddButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_AddButton_1.gridx = 1;
		gbc_AddButton_1.gridy = 3;
		adminsPanel.add(AddButton_1, gbc_AddButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(5, 5, 5, 5);
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 4;
		adminsPanel.add(scrollPane_1, gbc_scrollPane_1);
		
		JList<String> list_1 = new JList<String>();
		scrollPane_1.setViewportView(list_1);
		list.setListData(serverList);
				
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) {
				serversPanel.removeAll();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		});
		
	}
	
	public static void refresh() {
		
	}
	
	/**
	 * the method for clearing the server adding fields
	 */
	public static void clearFields() {
		serverNameField.setText("");
		IPField.setText("");
		PortField.setText("");
	}
	
	/**
	 * the method for removing the server from the list and writing the change out to the config
	 * @param index the index of the server that needs to be removed
	 */
	public static void removeServer(int index) {
		
	}


}
