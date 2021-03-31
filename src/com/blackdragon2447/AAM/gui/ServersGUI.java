package com.blackdragon2447.AAM.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.lang3.ArrayUtils;

import com.blackdragon2447.AAM.Main;
import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.util.RconHandler;
import com.blackdragon2447.AAM.util.Utils;
import com.blackdragon2447.AAM.util.iface.AAMConfig;
import com.blackdragon2447.AAM.util.obj.Server;

import net.kronos.rkon.core.ex.AuthenticationException;

/**
 * the gui for the program settings atm only used for servers
 * @author Blackdragon2447
 *
 */
public class ServersGUI extends JDialog {

	private static final long serialVersionUID = 422929525233814207L;
	private static JPanel contentPane;
	private static JTextField IPField;
	private static JTextField PortField;
	private static JTextField NameField;
	static JList<String> list = new JList<String>();
	static JPanel ServersPanel = new JPanel();
	static AAMConfig cfg = ConfigFactory.create(AAMConfig.class);

	/**
	 * the method used to open the gui
	 */
	public static void createGui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ServersGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * the constructor, this builds the full gui
	 */
	public ServersGUI() {
		
		
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		
		setBounds(100, 100, 450, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("servers");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		GridBagConstraints gbc_ServersPanel = new GridBagConstraints();
		gbc_ServersPanel.fill = GridBagConstraints.BOTH;
		gbc_ServersPanel.gridx = 0;
		gbc_ServersPanel.gridy = 1;
		contentPane.add(ServersPanel, gbc_ServersPanel);
		GridBagLayout gbl_ServersPanel = new GridBagLayout();
		gbl_ServersPanel.columnWidths = new int[]{0, 0, 0};
		gbl_ServersPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_ServersPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_ServersPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		ServersPanel.setLayout(gbl_ServersPanel);
		
		JLabel NameLabel = new JLabel("Server Name");
		GridBagConstraints gbc_NameLabel = new GridBagConstraints();
		gbc_NameLabel.anchor = GridBagConstraints.EAST;
		gbc_NameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_NameLabel.gridx = 0;
		gbc_NameLabel.gridy = 0;
		ServersPanel.add(NameLabel, gbc_NameLabel);
		
		NameField = new JTextField();
		GridBagConstraints gbc_NameField = new GridBagConstraints();
		gbc_NameField.insets = new Insets(0, 0, 5, 0);
		gbc_NameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_NameField.gridx = 1;
		gbc_NameField.gridy = 0;
		ServersPanel.add(NameField, gbc_NameField);
		NameField.setColumns(10);
		
		JLabel IPLable = new JLabel("Server IP");
		GridBagConstraints gbc_IPLable = new GridBagConstraints();
		gbc_IPLable.insets = new Insets(0, 0, 5, 5);
		gbc_IPLable.anchor = GridBagConstraints.EAST;
		gbc_IPLable.gridx = 0;
		gbc_IPLable.gridy = 1;
		ServersPanel.add(IPLable, gbc_IPLable);
		
		IPField = new JTextField();
		GridBagConstraints gbc_IPField = new GridBagConstraints();
		gbc_IPField.insets = new Insets(0, 0, 5, 0);
		gbc_IPField.fill = GridBagConstraints.HORIZONTAL;
		gbc_IPField.gridx = 1;
		gbc_IPField.gridy = 1;
		ServersPanel.add(IPField, gbc_IPField);
		IPField.setColumns(10);
		
		JLabel PortLabel = new JLabel("RCon Port");
		GridBagConstraints gbc_PortLabel = new GridBagConstraints();
		gbc_PortLabel.anchor = GridBagConstraints.EAST;
		gbc_PortLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PortLabel.gridx = 0;
		gbc_PortLabel.gridy = 2;
		ServersPanel.add(PortLabel, gbc_PortLabel);
		
		PortField = new JTextField();
		GridBagConstraints gbc_PortField = new GridBagConstraints();
		gbc_PortField.insets = new Insets(0, 0, 5, 0);
		gbc_PortField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PortField.gridx = 1;
		gbc_PortField.gridy = 2;
		ServersPanel.add(PortField, gbc_PortField);
		PortField.setColumns(10);
		
		JButton AddButton = new JButton("Add");
		GridBagConstraints gbc_AddButton = new GridBagConstraints();
		gbc_AddButton.insets = new Insets(0, 0, 5, 0);
		gbc_AddButton.gridx = 1;
		gbc_AddButton.gridy = 3;
		ServersPanel.add(AddButton, gbc_AddButton);
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utils.AddServer(NameField.getText(), IPField.getText(), Integer.valueOf(PortField.getText()));
				refresh();
				clearFields();
			}
		});
		
		String serverList[];
		try {
			serverList = new String[cfg.ServerNames().length];
		} catch (NullPointerException e) {
			serverList = new String[0];
		}
		
		
		for(int i = 0; i < serverList.length; i++) {
			serverList[i] = cfg.ServerNames()[i] + ", " + cfg.IPs()[i] + ":" + cfg.Ports()[i];
		}
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		ServersPanel.add(scrollPane, gbc_scrollPane);
		scrollPane.setViewportView(list);
		list.setListData(serverList);
		
		JButton RemoveButton = new JButton("Remove");
		GridBagConstraints gbc_RemoveButton = new GridBagConstraints();
		gbc_RemoveButton.insets = new Insets(0, 0, 5, 5);
		gbc_RemoveButton.gridx = 0;
		gbc_RemoveButton.gridy = 5;
		ServersPanel.add(RemoveButton, gbc_RemoveButton);
		RemoveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeServer(list.getSelectedIndex());
			}
		});
		
		JButton AuthenticateButton = new JButton("Autheticate");
		GridBagConstraints gbc_AuthenticateButton = new GridBagConstraints();
		gbc_AuthenticateButton.insets = new Insets(0, 0, 5, 0);
		gbc_AuthenticateButton.gridx = 1;
		gbc_AuthenticateButton.gridy = 5;
		ServersPanel.add(AuthenticateButton, gbc_AuthenticateButton);
		AuthenticateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reference.MultipleServer = false;
				Reference.LoggedServers = new ArrayList<Server>();
				Authenticate(list.getSelectedIndex());
				
			}
		});
		
		JToggleButton MSToggleButton = new JToggleButton("Use Multiple Servers");
		GridBagConstraints gbc_MSToggleButton = new GridBagConstraints();
		gbc_MSToggleButton.insets = new Insets(0, 0, 0, 5);
		gbc_MSToggleButton.gridx = 0;
		gbc_MSToggleButton.gridy = 6;
		ServersPanel.add(MSToggleButton, gbc_MSToggleButton);
		MSToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reference.MultipleServer = MSToggleButton.isSelected();
			}
		});
		
		JButton AuthenticateAllButton = new JButton("Authenticate All");
		GridBagConstraints gbc_AuthenticateAllButton = new GridBagConstraints();
		gbc_AuthenticateAllButton.gridx = 1;
		gbc_AuthenticateAllButton.gridy = 6;
		ServersPanel.add(AuthenticateAllButton, gbc_AuthenticateAllButton);
		AuthenticateAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!MSToggleButton.isSelected()) {
					if(0 == JOptionPane.showOptionDialog(contentPane, "use multiple servers is disabled, do you want to enable it", null, JOptionPane.YES_NO_OPTION, 0, null, null, null)) {
						MSToggleButton.setSelected(true);
					}
				}
				for (int server : list.getSelectedIndices()) {
					Reference.LoggedServers.add(Authenticate(server));
				}
				Reference.MultipleServer = MSToggleButton.isSelected();
			}
		});
		
		setVisible(true);
		
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
				ServersPanel.removeAll();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		});
		
	}
	
	/**
	 * the method for refreshing the list of server
	 */
	public static void refresh() {
		

		cfg = ConfigFactory.create(AAMConfig.class);

		String serverList[];
		try {
			serverList = new String[cfg.ServerNames().length];
		} catch (NullPointerException e) {
			serverList = new String[0];
		}
		
		
		for(int i = 0; i < serverList.length; i++) {
			serverList[i] = cfg.ServerNames()[i] + ", " + cfg.IPs()[i] + ":" + cfg.Ports()[i];
		}
		
		
		list.setListData(serverList);
	}
	
	/**
	 * the method for clearing the server adding fields
	 */
	public static void clearFields() {
		NameField.setText("");
		IPField.setText("");
		PortField.setText("");
	}
	
	/**
	 * the method for removing the server from the list and writing the change out to the config
	 * @param index the index of the server that needs to be removed
	 */
	public static void removeServer(int index) {
		
		String[] NamesList = cfg.ServerNames();
		NamesList = ArrayUtils.removeElement(NamesList, NamesList[index]);
		String[] IPList = cfg.IPs();
		IPList = ArrayUtils.removeElement(IPList, IPList[index]);
		int[] PortList = cfg.Ports();
		PortList = ArrayUtils.removeElement(PortList, PortList[index]);
		
		
		cfg.setProperty("ServerNames", Arrays.toString(NamesList).replace("[", "").replace("]", ""));
		cfg.setProperty("IPs", Arrays.toString(IPList).replace("[", "").replace("]", ""));
		cfg.setProperty("Ports", Arrays.toString(PortList).replace("[", "").replace("]", ""));
		
		try {
			cfg.store(new FileOutputStream("AAMConfig.properties"), "no comments");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		refresh();
		
	}

	/**
	 * method to check if a server password is correct and setting it to be used for further used
	 * @param serverNum the number of the selected server
	 */
	public static Server Authenticate(int serverNum) {

		Reference.RConIp = null;
		Reference.RConPort = 0;
		Reference.Password = null;
		
		Boolean succeeded = true;
		Boolean loop = true;
		Reference.RConIp = cfg.IPs()[serverNum];
		Reference.RConPort = cfg.Ports()[serverNum];
		final JPasswordField pwd = new JPasswordField(10);
	    int Cancel = JOptionPane.showConfirmDialog(contentPane, pwd, "Enter Password",JOptionPane.OK_CANCEL_OPTION);
	    pwd.addComponentListener(new ComponentAdapter() {
	    	public void componentShown(ComponentEvent ce){
				pwd.requestFocusInWindow();
			}
		});
	    loop = Cancel != 1? true : false;
	    Reference.Password = String.valueOf(pwd.getPassword());
	    pwd.setText("");
	    int cancel = 1;
	    
	    
	    try {
	    	Main.logger.LogUser("using pritcolors command to verify a valid connection", Level.INFO);
			RconHandler.command("printcolors", cfg.ServerNames()[serverNum]);
		} catch (IOException e1) {
			succeeded = false;
			e1.printStackTrace();
		} catch (AuthenticationException e1) {
			Main.logger.LogUser(Reference.UserName + " unsuccesfully tried to log onto " + cfg.ServerNames()[serverNum], Level.WARNING);
			succeeded = false;
			JOptionPane.showMessageDialog(contentPane, "Password incorrect", "", JOptionPane.ERROR_MESSAGE);
		}
	    
	    while(true) {
	    	if(succeeded == true) {
	    		JOptionPane.showMessageDialog(contentPane, "Logged On", "", JOptionPane.INFORMATION_MESSAGE);
	    		cfg.setProperty("LastLogin", String.valueOf(serverNum));
	    		try {
	    			cfg.store(new FileOutputStream("AAMConfig.properties"), "no comments");
	    		} catch (IOException e1) {
	    			e1.printStackTrace();
	    		}
	    	    Main.logger.LogUser(Reference.UserName + " logged succesfully onto " + cfg.ServerNames()[serverNum], Level.INFO);
	    		break;
	    	}else if (!loop) {
				break;
			}
	    	else{
	    		Reference.ServerName = cfg.ServerNames()[serverNum];
	    		Reference.RConIp = cfg.IPs()[serverNum];
	    		Reference.RConPort = cfg.Ports()[serverNum];
	    		cancel = JOptionPane.showConfirmDialog(null, pwd, "Try Again" ,JOptionPane.OK_CANCEL_OPTION);
	    		if(cancel == 2) break;
	    		Reference.Password = String.valueOf(pwd.getPassword());
	    		try {
	    			RconHandler.command("printcolors", cfg.ServerNames()[serverNum]);
	    			succeeded = true;
	    		} catch (IOException e1) {
	    			succeeded = false;
	    			e1.printStackTrace();
	    		} catch (AuthenticationException e1) {
	    			succeeded = false;
	    			if(!loop) JOptionPane.showMessageDialog(contentPane, "Password incorrect", "", JOptionPane.ERROR_MESSAGE);
	    		}
	    	}
	    }
	    
	    
	    return new Server(cfg.ServerNames()[serverNum], cfg.IPs()[serverNum], Integer.valueOf(cfg.Ports()[serverNum]), Reference.Password);
	}
	
	
	
	
	
	
}