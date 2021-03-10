package com.blackdragon2447.AAM.gui.dialog.CC;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.aeonbits.owner.ConfigFactory;

import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.gui.components.JTextFieldLimit;
import com.blackdragon2447.AAM.util.iface.AAMConfig;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.awt.event.ActionEvent;

/**
 * the dialog for adding a new script command
 * @author Blackdragon2447
 *
 */
public class AddNewScriptGui extends JFrame {

	private static final long serialVersionUID = -3517898970202091099L;
	private JPanel contentPane;
	private JTextField CommandNameField;
	private JSeparator separator;
	private JLabel CommandLabel;
	private JTextField CommandField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	AAMConfig cfg = ConfigFactory.create(AAMConfig.class);

	/**
	 * the method for opening the gui
	 */
	public static void createGui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewScriptGui frame = new AddNewScriptGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * the constructor: build the gui
	 */
	public AddNewScriptGui() {
		
		try {
			UIManager.setLookAndFeel(AAMGui.getLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 192, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 21, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Create New Command");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 2;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 1;
		contentPane.add(separator, gbc_separator);
		
		JLabel CommandNameLabel = new JLabel("Command Name (short)");
		GridBagConstraints gbc_CommandNameLabel = new GridBagConstraints();
		gbc_CommandNameLabel.anchor = GridBagConstraints.EAST;
		gbc_CommandNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_CommandNameLabel.gridx = 1;
		gbc_CommandNameLabel.gridy = 2;
		contentPane.add(CommandNameLabel, gbc_CommandNameLabel);
		
		CommandNameField = new JTextField();
		GridBagConstraints gbc_CommandNameField = new GridBagConstraints();
		gbc_CommandNameField.insets = new Insets(0, 0, 5, 5);
		gbc_CommandNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CommandNameField.gridx = 2;
		gbc_CommandNameField.gridy = 2;
		contentPane.add(CommandNameField, gbc_CommandNameField);
		CommandNameField.setColumns(10);
		CommandNameField.setDocument(new JTextFieldLimit(32));
		
		CommandLabel = new JLabel("Command");
		GridBagConstraints gbc_CommandLabel = new GridBagConstraints();
		gbc_CommandLabel.anchor = GridBagConstraints.EAST;
		gbc_CommandLabel.insets = new Insets(0, 0, 5, 5);
		gbc_CommandLabel.gridx = 1;
		gbc_CommandLabel.gridy = 3;
		contentPane.add(CommandLabel, gbc_CommandLabel);
		
		CommandField = new JTextField();
		GridBagConstraints gbc_CommandField = new GridBagConstraints();
		gbc_CommandField.insets = new Insets(0, 0, 5, 5);
		gbc_CommandField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CommandField.gridx = 2;
		gbc_CommandField.gridy = 3;
		contentPane.add(CommandField, gbc_CommandField);
		CommandField.setColumns(10);
		
		btnNewButton = new JButton("Confirm");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] arr = cfg.ScriptCommands();
				try {
					arr = Arrays.copyOf(arr, arr.length + 1);
				} catch (NullPointerException e2) {
					arr = new String[]{null};
				}
				arr[arr.length - 1] = CommandField.getText();
				cfg.setProperty("ScriptCommands", Arrays.toString(arr));
				
				
				
				String [] arr1 = cfg.ScriptCommandsNames();
				try {
					arr1 = Arrays.copyOf(arr1, arr1.length + 1);
				} catch (NullPointerException e2) {
					arr1 = new String[]{null};
				}
				arr1[arr1.length -1] = CommandNameField.getText();
				cfg.setProperty("ScriptCommandsNames", Arrays.toString(arr1));
				
				
				
				try {
					cfg.store(new FileOutputStream("AAMConfig.properties"), "no comments");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				

				AAMGui.tabbedPaneOut.setSelectedIndex(-1);
				AAMGui.tabbedPaneOut.setSelectedIndex(3);
				
				dispose();
			}
		});
		
		btnNewButton_1 = new JButton("Cancel");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 4;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
	}

}
