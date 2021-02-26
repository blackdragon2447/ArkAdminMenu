package com.blackdragon2447.AAM.gui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.util.ItemSetBuilder;

public class ImportItemsDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2730499381240887555L;
	private final JPanel ContentPanel = new JPanel();
	private JTextField TextField;
	JComboBox<String> ComboBox;
	
	public static void createDialog() {
		try {
			ImportItemsDialog dialog = new ImportItemsDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ImportItemsDialog() {

		try {
			UIManager.setLookAndFeel(AAMGui.getLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setBounds(100, 100, 450, 208);
		getContentPane().setLayout(new BorderLayout());
		ContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(ContentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 60, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		ContentPanel.setLayout(gbl_contentPanel);
		{
			JLabel setFileLabel = new JLabel("File");
			GridBagConstraints gbc_setFileLabel = new GridBagConstraints();
			gbc_setFileLabel.anchor = GridBagConstraints.EAST;
			gbc_setFileLabel.insets = new Insets(0, 0, 5, 5);
			gbc_setFileLabel.gridx = 1;
			gbc_setFileLabel.gridy = 1;
			ContentPanel.add(setFileLabel, gbc_setFileLabel);
		}
		{
			ComboBox = new JComboBox<String>();
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 0);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 2;
			gbc_comboBox.gridy = 1;
			ContentPanel.add(ComboBox, gbc_comboBox);
			ComboBox.addItem(null);
			for(int i=0; i < Reference.ItemFileArray.size(); i++) {
				ComboBox.addItem(Reference.ItemFileArray.get(i));
			}
		}
		{
			JLabel setNameLabel = new JLabel("set name");
			GridBagConstraints gbc_setNameLabel = new GridBagConstraints();
			gbc_setNameLabel.anchor = GridBagConstraints.EAST;
			gbc_setNameLabel.insets = new Insets(0, 0, 0, 5);
			gbc_setNameLabel.gridx = 1;
			gbc_setNameLabel.gridy = 3;
			ContentPanel.add(setNameLabel, gbc_setNameLabel);
		}
		{
			TextField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 3;
			ContentPanel.add(TextField, gbc_textField);
			TextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							Reference.ImportedItemGroups.add(ItemSetBuilder.generatePair(TextField.getText(), "ItemLists\\" + (String) ComboBox.getSelectedItem()));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						dispose();
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
			}
		}
		
		pack();
	}

}
