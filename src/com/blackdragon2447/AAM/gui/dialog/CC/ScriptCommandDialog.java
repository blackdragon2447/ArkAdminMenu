package com.blackdragon2447.AAM.gui.dialog.CC;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.blackdragon2447.AAM.util.RconHandler;

import net.kronos.rkon.core.ex.AuthenticationException;

/**
 * the dialog for entering arg and running a script command
 * @author Blackdragon2447
 */
public class ScriptCommandDialog extends JDialog {

	private static final long serialVersionUID = -640493604537651948L;
	private final JPanel contentPanel = new JPanel();
	private static String Command;
	JLabel CommandLabel = new JLabel();

	/**
	 * the method for opening the gui
	 * @param command
	 */
	public static void createGui(String command) {
		Command = command;
		try {
			ScriptCommandDialog dialog = new ScriptCommandDialog();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * the constructor: builds the gui
	 */
	public ScriptCommandDialog() {
		setBounds(100, 100, 450, 149);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			GridBagConstraints gbc_CommandLabel = new GridBagConstraints();
			gbc_CommandLabel.insets = new Insets(0, 0, 0, 5);
			gbc_CommandLabel.gridx = 1;
			gbc_CommandLabel.gridy = 1;
			contentPanel.add(CommandLabel, gbc_CommandLabel);
			CommandLabel.setText("scriptcommand " + Command);
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
						try {
							RconHandler.command(CommandLabel.getText());
						} catch (IOException | AuthenticationException e1) {
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
			
			pack();
		}
	}

}
