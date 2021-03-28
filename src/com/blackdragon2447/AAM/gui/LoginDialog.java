package com.blackdragon2447.AAM.gui;

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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.aeonbits.owner.ConfigFactory;

import com.blackdragon2447.AAM.Main;
import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.util.Themes;
import com.blackdragon2447.AAM.util.iface.AAMConfig;
import com.blackdragon2447.AAM.util.obj.auth.Account;

public class LoginDialog extends JDialog {

	private static final long serialVersionUID = -8555976832679303299L;
	private static JPanel contentPane;
	private JTextField UserNameField;
	private JPasswordField passwordField;
	AAMConfig cfg = ConfigFactory.create(AAMConfig.class);
	private JButton LogInButton;
	private JButton CancelButton;
	private JLabel resultLabel;
	
	/**
	 * Launch the application.
	 */
	public static void CreateGui() {
		LoginDialog frame = null;
		try {
			frame = new LoginDialog();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 * @throws NoSuchAlgorithmException 
	 */
	public LoginDialog() throws NoSuchAlgorithmException {
		
		setVisual(Themes.getLookAndFeel(cfg.Theme()));
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 450, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 19, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel LoginLabel = new JLabel("Login");
		LoginLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		GridBagConstraints gbc_LoginLabel = new GridBagConstraints();
		gbc_LoginLabel.gridwidth = 2;
		gbc_LoginLabel.insets = new Insets(0, 0, 5, 5);
		gbc_LoginLabel.gridx = 1;
		gbc_LoginLabel.gridy = 0;
		contentPane.add(LoginLabel, gbc_LoginLabel);
		
		resultLabel = new JLabel("");
		resultLabel.setForeground(Color.RED);
		GridBagConstraints gbc_resultLabel = new GridBagConstraints();
		gbc_resultLabel.gridwidth = 2;
		gbc_resultLabel.insets = new Insets(0, 0, 5, 5);
		gbc_resultLabel.gridx = 1;
		gbc_resultLabel.gridy = 1;
		contentPane.add(resultLabel, gbc_resultLabel);
		
		JLabel UserNameLabel = new JLabel("UserName");
		GridBagConstraints gbc_UserNameLabel = new GridBagConstraints();
		gbc_UserNameLabel.anchor = GridBagConstraints.EAST;
		gbc_UserNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_UserNameLabel.gridx = 1;
		gbc_UserNameLabel.gridy = 2;
		contentPane.add(UserNameLabel, gbc_UserNameLabel);
		
		UserNameField = new JTextField();
		GridBagConstraints gbc_UserNameField = new GridBagConstraints();
		gbc_UserNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_UserNameField.insets = new Insets(0, 0, 5, 5);
		gbc_UserNameField.gridx = 2;
		gbc_UserNameField.gridy = 2;
		contentPane.add(UserNameField, gbc_UserNameField);
		UserNameField.setColumns(10);
		
		JLabel PasswordLabel = new JLabel("Password");
		GridBagConstraints gbc_PasswordLabel = new GridBagConstraints();
		gbc_PasswordLabel.anchor = GridBagConstraints.EAST;
		gbc_PasswordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PasswordLabel.gridx = 1;
		gbc_PasswordLabel.gridy = 3;
		contentPane.add(PasswordLabel, gbc_PasswordLabel);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					LogInButton.doClick();
				}
					
			}
		});
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 3;
		contentPane.add(passwordField, gbc_passwordField);
		
		LogInButton = new JButton("Log In");
		GridBagConstraints gbc_LogInButton = new GridBagConstraints();
		gbc_LogInButton.insets = new Insets(0, 0, 0, 5);
		gbc_LogInButton.gridx = 1;
		gbc_LogInButton.gridy = 5;
		contentPane.add(LogInButton, gbc_LogInButton);
		LogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean CorrectName = false;
				Boolean CorrectPW = false;
				checkloop:
				for(Account account : Reference.Logins) {
					try {
						CorrectName = account.getUserName().equals(UserNameField.getText());
						CorrectPW = account.getHash().equals(toHexString(getSHA(String.valueOf(passwordField.getPassword()))));
						if(CorrectName && CorrectPW) {Reference.currentUser = account; break checkloop;}
					} catch (NoSuchAlgorithmException e1) {
						e1.printStackTrace();
					}
				}
				if(CorrectName && CorrectPW) {
			    	Main.logger.LogUser("User " + UserNameField.getText() + " Logged On", Level.INFO);
					dispose();
				}
				else{
					Main.logger.LogUser("a faild logon attemp was made with username: " + UserNameField.getText(), Level.WARNING);
					resultLabel.setText("username or password incorrect");
				}
			}
		});
		
		CancelButton = new JButton("Cancel");
		GridBagConstraints gbc_CancelButton = new GridBagConstraints();
		gbc_CancelButton.insets = new Insets(0, 0, 0, 5);
		gbc_CancelButton.gridx = 2;
		gbc_CancelButton.gridy = 5;
		contentPane.add(CancelButton, gbc_CancelButton);
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
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
    	Reference.UserName = UserNameField.getText();
    	super.dispose();
    }

}
