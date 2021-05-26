package com.blackdragon2447.AAM.gui.auth;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import org.aeonbits.owner.ConfigFactory;

import com.blackdragon2447.AAM.Main;
import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.util.Themes;
import com.blackdragon2447.AAM.util.iface.AAMConfig;
import com.blackdragon2447.AAM.util.obj.auth.Account;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;

public class LoginDialog extends JDialog {

	private static final long serialVersionUID = -8555976832679303299L;
	private static JPanel contentPane = new JPanel();
	AAMConfig cfg = ConfigFactory.create(AAMConfig.class);
	private JTabbedPane tabbedPane;
	private JPanel loginPanel;
	private JLabel loginLabel;
	private JLabel resultLabel;
	private JLabel userNameLabel;
	private JTextField userNameField;
	private JLabel PasswordLabel;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton cancelButton;
	private JPanel createAccountPanel;
	private JToggleButton adminToggleButton;
	private JPanel adminLoginPanel;
	private JComboBox<Long> comboBox;
	private JLabel steamIDLabel;
	private JLabel usernameField;
	private JLabel newPasswordField;
	private JTextField textField;
	private JPasswordField passwordField_1;
	private JPanel ownerLoginPanel;
	private JLabel newUsernameLabel;
	private JTextField textField_1;
	private JLabel newPasswordLabel;
	private JPasswordField passwordField_2;
	private JLabel newSteamIDLabel;
	private JTextField newSteamIDField;
	
	/**
	 * Launch the application.
	 */
	public static void createGui() {
		LoginDialog frame = null;
		try {
			frame = new LoginDialog();
			frame.setVisible(true);
		}catch (NoSuchAlgorithmException e) {
			Main.logger.LogDebug(e.toString(), Level.SEVERE);
		}
	}

	/**
	 * Create the frame.
	 * @throws NoSuchAlgorithmException 
	 */
	public LoginDialog() throws NoSuchAlgorithmException {
		
		setVisual(Themes.getLookAndFeel(cfg.Theme()));
		
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 450, 247);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(SwingConstants.TOP);
		contentPane.add(tabbedPane);
		
		loginPanel = new JPanel();
		loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedPane.addTab("Log In", null, loginPanel, null);
		GridBagLayout gbl_loginPanel = new GridBagLayout();
		gbl_loginPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_loginPanel.rowHeights = new int[]{0, 19, 0, 0, 0, 0, 0};
		gbl_loginPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_loginPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		loginPanel.setLayout(gbl_loginPanel);
		
		loginLabel = new JLabel("Login");
		loginLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		GridBagConstraints gbc_loginLabel = new GridBagConstraints();
		gbc_loginLabel.gridwidth = 2;
		gbc_loginLabel.insets = new Insets(0, 0, 5, 5);
		gbc_loginLabel.gridx = 1;
		gbc_loginLabel.gridy = 0;
		loginPanel.add(loginLabel, gbc_loginLabel);
		
		resultLabel = new JLabel("");
		resultLabel.setForeground(Color.RED);
		GridBagConstraints gbc_resultLabel = new GridBagConstraints();
		gbc_resultLabel.gridwidth = 2;
		gbc_resultLabel.insets = new Insets(0, 0, 5, 5);
		gbc_resultLabel.gridx = 1;
		gbc_resultLabel.gridy = 1;
		loginPanel.add(resultLabel, gbc_resultLabel);
		
		userNameLabel = new JLabel("UserName");
		GridBagConstraints gbc_userNameLabel = new GridBagConstraints();
		gbc_userNameLabel.anchor = GridBagConstraints.EAST;
		gbc_userNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_userNameLabel.gridx = 1;
		gbc_userNameLabel.gridy = 2;
		loginPanel.add(userNameLabel, gbc_userNameLabel);
		
		userNameField = new JTextField();
		userNameField.setColumns(10);
		GridBagConstraints gbc_userNameField = new GridBagConstraints();
		gbc_userNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userNameField.insets = new Insets(0, 0, 5, 5);
		gbc_userNameField.gridx = 2;
		gbc_userNameField.gridy = 2;
		loginPanel.add(userNameField, gbc_userNameField);
		
		PasswordLabel = new JLabel("Password");
		GridBagConstraints gbc_PasswordLabel = new GridBagConstraints();
		gbc_PasswordLabel.anchor = GridBagConstraints.EAST;
		gbc_PasswordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PasswordLabel.gridx = 1;
		gbc_PasswordLabel.gridy = 3;
		loginPanel.add(PasswordLabel, gbc_PasswordLabel);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 3;
		loginPanel.add(passwordField, gbc_passwordField);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					loginButton.doClick();
				}
					
			}
		});
		
		loginButton = new JButton("Log In");
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.insets = new Insets(0, 0, 0, 5);
		gbc_loginButton.gridx = 1;
		gbc_loginButton.gridy = 5;
		loginPanel.add(loginButton, gbc_loginButton);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean CorrectName = false;
				Boolean CorrectPW = false;
				checkloop:
				for(Account account : Reference.Logins) {
					GsonBuilder builder = new GsonBuilder();
					Gson gson = builder.create();
					
					gson.toJson(account);
					
					try {
						CorrectName = account.getUserName().equals(userNameField.getText());
						CorrectPW = account.getHash().equals(toHexString(getSHA(String.valueOf(passwordField.getPassword()))));
						if(CorrectName && CorrectPW) {
							Reference.currentUser = account;
							break checkloop;
						}
					} catch (NoSuchAlgorithmException e1) {
						e1.printStackTrace();
					}
				}
				if(CorrectName && CorrectPW) {
			    	Main.logger.LogUser("User " + userNameField.getText() + " Logged On", Level.INFO);
					dispose();
				}
				else{
					Main.logger.LogUser("a faild logon attemp was made with username: " + userNameField.getText(), Level.WARNING);
					resultLabel.setText("username or password incorrect");
				}
			}
		});
		
		cancelButton = new JButton("Cancel");
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.insets = new Insets(0, 0, 0, 5);
		gbc_cancelButton.gridx = 2;
		gbc_cancelButton.gridy = 5;
		loginPanel.add(cancelButton, gbc_cancelButton);
		
		createAccountPanel = new JPanel();
		tabbedPane.addTab("Create Account", null, createAccountPanel, null);
		GridBagLayout gbl_createAccountPanel = new GridBagLayout();
		gbl_createAccountPanel.columnWidths = new int[]{0, 357, 0, 0, 0};
		gbl_createAccountPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_createAccountPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_createAccountPanel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		createAccountPanel.setLayout(gbl_createAccountPanel);
		
		adminToggleButton = new JToggleButton("Admin");
		GridBagConstraints gbc_adminToggleButton = new GridBagConstraints();
		gbc_adminToggleButton.gridwidth = 2;
		gbc_adminToggleButton.insets = new Insets(0, 0, 5, 0);
		gbc_adminToggleButton.gridx = 2;
		gbc_adminToggleButton.gridy = 0;
		createAccountPanel.add(adminToggleButton, gbc_adminToggleButton);
		
		ownerLoginPanel = new JPanel();
		GridBagConstraints gbc_ownerLoginPanel = new GridBagConstraints();
		gbc_ownerLoginPanel.gridwidth = 2;
		gbc_ownerLoginPanel.insets = new Insets(0, 0, 5, 5);
		gbc_ownerLoginPanel.fill = GridBagConstraints.BOTH;
		gbc_ownerLoginPanel.gridx = 1;
		gbc_ownerLoginPanel.gridy = 1;
		
		GridBagLayout gbl_ownerLoginPanel = new GridBagLayout();
		gbl_ownerLoginPanel.columnWidths = new int[]{70, 0, 0};
		gbl_ownerLoginPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_ownerLoginPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_ownerLoginPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		ownerLoginPanel.setLayout(gbl_ownerLoginPanel);
		
		newUsernameLabel = new JLabel("Username");
		GridBagConstraints gbc_newUsernameLabel = new GridBagConstraints();
		gbc_newUsernameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_newUsernameLabel.anchor = GridBagConstraints.EAST;
		gbc_newUsernameLabel.gridx = 0;
		gbc_newUsernameLabel.gridy = 0;
		ownerLoginPanel.add(newUsernameLabel, gbc_newUsernameLabel);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		ownerLoginPanel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		newPasswordLabel = new JLabel("Password");
		GridBagConstraints gbc_newPasswordLabel = new GridBagConstraints();
		gbc_newPasswordLabel.anchor = GridBagConstraints.EAST;
		gbc_newPasswordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_newPasswordLabel.gridx = 0;
		gbc_newPasswordLabel.gridy = 1;
		ownerLoginPanel.add(newPasswordLabel, gbc_newPasswordLabel);
		
		passwordField_2 = new JPasswordField();
		GridBagConstraints gbc_passwordField_2 = new GridBagConstraints();
		gbc_passwordField_2.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_2.gridx = 1;
		gbc_passwordField_2.gridy = 1;
		ownerLoginPanel.add(passwordField_2, gbc_passwordField_2);
		
		newSteamIDLabel = new JLabel("SteamID");
		GridBagConstraints gbc_newSteamIDLabel = new GridBagConstraints();
		gbc_newSteamIDLabel.anchor = GridBagConstraints.EAST;
		gbc_newSteamIDLabel.insets = new Insets(0, 0, 0, 5);
		gbc_newSteamIDLabel.gridx = 0;
		gbc_newSteamIDLabel.gridy = 2;
		ownerLoginPanel.add(newSteamIDLabel, gbc_newSteamIDLabel);
		
		newSteamIDField = new JTextField();
		GridBagConstraints gbc_newSteamIDField = new GridBagConstraints();
		gbc_newSteamIDField.fill = GridBagConstraints.HORIZONTAL;
		gbc_newSteamIDField.gridx = 1;
		gbc_newSteamIDField.gridy = 2;
		ownerLoginPanel.add(newSteamIDField, gbc_newSteamIDField);
		newSteamIDField.setColumns(10);
		
		adminLoginPanel = new JPanel();
		GridBagConstraints gbc_adminLoginPanel = new GridBagConstraints();
		gbc_adminLoginPanel.gridwidth = 2;
		gbc_adminLoginPanel.insets = new Insets(0, 0, 5, 5);
		gbc_adminLoginPanel.fill = GridBagConstraints.BOTH;
		gbc_adminLoginPanel.gridx = 1;
		gbc_adminLoginPanel.gridy = 1;
		createAccountPanel.add(adminLoginPanel, gbc_adminLoginPanel);
		
		GridBagLayout gbl_adminLoginPanel = new GridBagLayout();
		gbl_adminLoginPanel.columnWidths = new int[]{64, 0, 0};
		gbl_adminLoginPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_adminLoginPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_adminLoginPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		adminLoginPanel.setLayout(gbl_adminLoginPanel);
		
		steamIDLabel = new JLabel("SteamID");
		GridBagConstraints gbc_steamIDLabel = new GridBagConstraints();
		gbc_steamIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_steamIDLabel.anchor = GridBagConstraints.EAST;
		gbc_steamIDLabel.gridx = 0;
		gbc_steamIDLabel.gridy = 0;
		adminLoginPanel.add(steamIDLabel, gbc_steamIDLabel);
		
		comboBox = new JComboBox<Long>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		adminLoginPanel.add(comboBox, gbc_comboBox);
		
		usernameField = new JLabel("Username");
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.anchor = GridBagConstraints.EAST;
		gbc_usernameField.insets = new Insets(0, 0, 5, 5);
		gbc_usernameField.gridx = 0;
		gbc_usernameField.gridy = 1;
		adminLoginPanel.add(usernameField, gbc_usernameField);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		adminLoginPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		newPasswordField = new JLabel("Password");
		GridBagConstraints gbc_newPasswordField = new GridBagConstraints();
		gbc_newPasswordField.anchor = GridBagConstraints.EAST;
		gbc_newPasswordField.insets = new Insets(0, 0, 0, 5);
		gbc_newPasswordField.gridx = 0;
		gbc_newPasswordField.gridy = 2;
		adminLoginPanel.add(newPasswordField, gbc_newPasswordField);
		
		passwordField_1 = new JPasswordField();
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_1.gridx = 1;
		gbc_passwordField_1.gridy = 2;
		adminLoginPanel.add(passwordField_1, gbc_passwordField_1);
		adminToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(adminToggleButton.isSelected()) {
					System.out.println("switching to owner");
					adminToggleButton.setText("Owner");
					createAccountPanel.removeAll();
					createAccountPanel.add(adminToggleButton, gbc_adminToggleButton);
					createAccountPanel.add(ownerLoginPanel, gbc_ownerLoginPanel);
					createAccountPanel.revalidate();
					createAccountPanel.repaint();
				} else {
					System.out.println("switching to admin");
					adminToggleButton.setText("Admin");;
					createAccountPanel.removeAll();
					createAccountPanel.add(adminToggleButton, gbc_adminToggleButton);
					createAccountPanel.add(adminLoginPanel, gbc_adminLoginPanel);
					createAccountPanel.revalidate();
					createAccountPanel.repaint();
				}
			}
		});
		
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
				System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		});
	}
	
	public static void setVisual(LookAndFeel lookAndFeel) {
		try {
			UIManager.setLookAndFeel(lookAndFeel);
			SwingUtilities.updateComponentTreeUI(contentPane);
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

	}
	
	public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
    {  
        // Static getInstance method is called with hashing SHA  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
  
        // digest() method called  
        // to calculate message digest of an input  
        // and return array of byte 
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    } 
    
    public static String toHexString(byte[] hash) 
    { 
        // Convert byte array into signum representation  
        BigInteger number = new BigInteger(1, hash);  
  
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        // Pad with leading zeros 
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    }
    
    @Override
    public void dispose() {
    	Reference.UserName = userNameField.getText();
    	super.dispose();
    }

}
