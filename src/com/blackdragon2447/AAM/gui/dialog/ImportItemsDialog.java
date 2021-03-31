package com.blackdragon2447.AAM.gui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.util.ItemSetBuilder;

/**
 * the dialog for importing items.
 * @author Blackdragon2447
 */
public class ImportItemsDialog extends JDialog {

	private static final long serialVersionUID = -2730499381240887555L;
	private final JPanel ContentPanel = new JPanel();
	private JFileChooser FileChooser = new JFileChooser();
	private File SelectedFile;
	
	/**
	 * the method for opening the dialog
	 */
	public static void createDialog() {
		try {
			ImportItemsDialog dialog = new ImportItemsDialog();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
		gbl_contentPanel.columnWidths = new int[]{0, 60, 100, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
			JLabel lblNewLabel = new JLabel("");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 2;
			gbc_lblNewLabel.gridy = 1;
			ContentPanel.add(lblNewLabel, gbc_lblNewLabel);
			

			FileChooser.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					lblNewLabel.setText(FileChooser.getSelectedFile().getName());
					SelectedFile = FileChooser.getSelectedFile();
				}
			});
			
		}
		{
			JButton btnNewButton = new JButton("open");
			btnNewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
					FileChooser.setFileFilter(filter);
					FileChooser.showOpenDialog(ContentPanel);
					
				}
			});
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
			gbc_btnNewButton.gridx = 3;
			gbc_btnNewButton.gridy = 1;
			ContentPanel.add(btnNewButton, gbc_btnNewButton);
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
							Files.copy(Paths.get(SelectedFile.getAbsolutePath()), Paths.get("ItemLists\\" + SelectedFile.getName()), StandardCopyOption.REPLACE_EXISTING);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						Reference.ItemFileArray.add(FileChooser.getSelectedFile().getName());
						try {
							Reference.ImportedItemGroups.add(ItemSetBuilder.generatePair(SelectedFile.getName().substring(0, SelectedFile.getName().length() - 4), "ItemLists\\" + FileChooser.getSelectedFile().getName()));
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
