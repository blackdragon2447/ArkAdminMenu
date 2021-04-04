package com.blackdragon2447.AAM.gui.dialog.CC;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 * the gui for entering args and running the plugin commands
 * @author Blackdragon2447
 *
 */
public class PluginCommandDialog extends JDialog {

	private static final long serialVersionUID = -640493604537651948L;
	private final JPanel contentPanel = new JPanel();
	private static String Command;
	private static Boolean Args;
	JLabel CommandLabel = new JLabel();
	private JTextField textField;

	/**
	 * the method for opening the gui
	 * @param command the command
	 * @param args the args for the command
	 */
	public static void createGui(String command, Boolean args) {
		Command = command;
		Args = args;
		try {
			PluginCommandDialog dialog = new PluginCommandDialog();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * the constructor: builds the gui
	 */
	public PluginCommandDialog() {
		setBounds(100, 100, 283, 165);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			GridBagConstraints gbc_CommandLabel = new GridBagConstraints();
			gbc_CommandLabel.insets = new Insets(0, 0, 5, 5);
			gbc_CommandLabel.gridx = 1;
			gbc_CommandLabel.gridy = 1;
			contentPanel.add(CommandLabel, gbc_CommandLabel);
			CommandLabel.setText(Command);
		}
		{
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 0, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 2;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
			textField.setEnabled(Args);
			textField.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {}
				
				@Override
				public void keyReleased(KeyEvent e) {
					CommandLabel.setText(Command + " " + textField.getText());
				}
				
				@Override
				public void keyPressed(KeyEvent e) {}
			});
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Run");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
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
	}

}
