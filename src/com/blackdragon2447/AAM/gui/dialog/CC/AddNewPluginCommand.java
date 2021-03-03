package com.blackdragon2447.AAM.gui.dialog.CC;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.aeonbits.owner.ConfigFactory;

import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.gui.components.JTextFieldLimit;
import com.blackdragon2447.AAM.util.iface.AAMConfig;

public class AddNewPluginCommand extends JFrame {

	private static final long serialVersionUID = -8571814547250385153L;
	private JPanel contentPane;
	AAMConfig cfg = ConfigFactory.create(AAMConfig.class);

	public static void createGui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNewPluginCommand frame = new AddNewPluginCommand();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AddNewPluginCommand() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Add Plugin Command");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JLabel CommandNameLabel = new JLabel("Command Name (short)");
		GridBagConstraints gbc_CommandNameLabel = new GridBagConstraints();
		gbc_CommandNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_CommandNameLabel.gridx = 1;
		gbc_CommandNameLabel.gridy = 1;
		contentPane.add(CommandNameLabel, gbc_CommandNameLabel);
		
		JTextField CommandNameField = new JTextField();
		GridBagConstraints gbc_CommandNameField = new GridBagConstraints();
		gbc_CommandNameField.insets = new Insets(0, 0, 5, 5);
		gbc_CommandNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CommandNameField.gridx = 2;
		gbc_CommandNameField.gridy = 1;
		contentPane.add(CommandNameField, gbc_CommandNameField);
		CommandNameField.setColumns(10);
		CommandNameField.setDocument(new JTextFieldLimit(32));
		
		JLabel CommandLabel = new JLabel("Command");
		GridBagConstraints gbc_CommandLabel = new GridBagConstraints();
		gbc_CommandLabel.insets = new Insets(0, 0, 5, 5);
		gbc_CommandLabel.gridx = 1;
		gbc_CommandLabel.gridy = 2;
		contentPane.add(CommandLabel, gbc_CommandLabel);
		
		JTextField CommandField = new JTextField();
		GridBagConstraints gbc_CommandField = new GridBagConstraints();
		gbc_CommandField.insets = new Insets(0, 0, 5, 5);
		gbc_CommandField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CommandField.gridx = 2;
		gbc_CommandField.gridy = 2;
		contentPane.add(CommandField, gbc_CommandField);
		CommandField.setColumns(10);
		
		JLabel ArgumentsLabel = new JLabel("Needs Arguments");
		GridBagConstraints gbc_ArgumentsLabel = new GridBagConstraints();
		gbc_ArgumentsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ArgumentsLabel.gridx = 1;
		gbc_ArgumentsLabel.gridy = 3;
		contentPane.add(ArgumentsLabel, gbc_ArgumentsLabel);
		
		JCheckBox ArgumentsCheckBox = new JCheckBox("");
		GridBagConstraints gbc_ArgumentsCheckBox = new GridBagConstraints();
		gbc_ArgumentsCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_ArgumentsCheckBox.gridx = 2;
		gbc_ArgumentsCheckBox.gridy = 3;
		contentPane.add(ArgumentsCheckBox, gbc_ArgumentsCheckBox);
		
		JButton btnNewButton = new JButton("Confirm");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] arr = cfg.PluginCommands();
				try {
					arr = Arrays.copyOf(arr, arr.length + 1);
				} catch (NullPointerException e2) {
					arr = new String[]{null};
				}
				arr[arr.length - 1] = CommandField.getText();
				cfg.setProperty("PluginCommands", Arrays.toString(arr));
				
				
				
				String[] arr1 = cfg.PluginCommandsNames();
				try {
					arr1 = Arrays.copyOf(arr1, arr1.length + 1);
				} catch (NullPointerException e2) {
					arr1 = new String[]{null};
				}
				arr1[arr1.length -1] = CommandNameField.getText();
				cfg.setProperty("PluginCommandsNames", Arrays.toString(arr1));
				
				String[] arr2 = cfg.PluginCommandsArgs();
				try {
					arr2 = Arrays.copyOf(arr2, arr2.length + 1);
				} catch (NullPointerException e2) {
					arr2 = new String[]{null};
				}
				arr2[arr2.length -1] = String.valueOf(ArgumentsCheckBox.isSelected());
				cfg.setProperty("PluginCommandsArgs", Arrays.toString(arr2));
				
				
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
		
		JButton btnNewButton_1 = new JButton("Cancel");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 4;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		
	}

}
