package com.blackdragon2447.AAM.gui.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.blackdragon2447.AAM.gui.AAMGui;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class HelpDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3536957765367588913L;
	private final JPanel ContentPanel = new JPanel();

	
	public static void createDialog() {
		try {
			HelpDialog dialog = new HelpDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HelpDialog() {

		try {
			UIManager.setLookAndFeel(AAMGui.getLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setBounds(100, 100, 470, 538);
		getContentPane().setLayout(new BorderLayout());
		ContentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(ContentPanel, BorderLayout.CENTER);
		ContentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		ContentPanel.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{362, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 63, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Help");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("!warning, no all settings implemented!");
		lblNewLabel_1.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_7 = new JLabel("The Command Tabs");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 2;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_2 = new JLabel("<html>The simple and advanced command tabs are the main tabs that you will<br>\r\nuse they both have buttons for each of the commands set for their catagory,<br>\r\nclicking one of these buttons will open a dialog that is going to allow you to<br>set the arguments for the command if it needs one or more.\r\n</html>");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(HelpDialog.class.getResource("/com/blackdragon2447/AAM/assets/simpleCommadDialogEmpty.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Image dimg = img.getScaledInstance(362, 203, Image.SCALE_SMOOTH);
		
		JLabel lblNewLabel_3 = new JLabel("\r\n");
		lblNewLabel_3.setIcon(new ImageIcon(dimg));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("<html>the image you see here is the dialog for the command for setting the time<br>\r\nof day, on top, underneath \"command\" you see the full command as it will<br>\r\nbe executed, in this example, there is no argument added so the displayed<br>\r\ncommand doesn't have one either, see the image below for an example of a<br>\r\ncommand with set argument(s), underneath that, under \"argument description\"<br>\r\nyou will see how you will have to enter the argument(s) with the textbox<br>\r\nunderneath being the place where you enter the argument if there is no<br>\r\nargument needed the description will reflect that and the text box will be<br>\r\ndisabled. the run button will run the command immediately, as of the time of<br>\r\nwriting this isn't functional, the queue button will add the command to the<br>\r\nqueue, see the description for the queue for more info on queueing commands.</html>");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		img = null;
		try {
			img = ImageIO.read(HelpDialog.class.getResource("/com/blackdragon2447/AAM/assets/simpleCommadDialogFilled.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		dimg = img.getScaledInstance(362, 203, Image.SCALE_SMOOTH);
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setIcon(new ImageIcon(dimg));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Command queueing");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		img = null;
		try {
			img = ImageIO.read(HelpDialog.class.getResource("/com/blackdragon2447/AAM/assets/QueueTab.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		dimg = img.getScaledInstance(362, 274, Image.SCALE_SMOOTH);
		
		JLabel lblNewLabel_9 = new JLabel("<html>Instead of running a command imediatly after entering its arguments you<br>\r\ncan also queue it. A queued command will appear in the queue tab, commands in<br>\r\nthe queue tab can be removed by pressing the X next to them, or executed by<br>\r\npressing \"Run\", the other option is running with a delay, to do this, set the delay<br>\r\nin seconds and click \"Run With Delay\".");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 8;
		panel.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(dimg));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("Custom commands");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 10;
		panel.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("<html>custom commands arent implemented yet, when they are they will allow<br>\r\nyou to add commands in the for of multiple commands on one line with arks<br>\r\ndefault way of doing it: \"cheat playersonly | cheat doexit\", for example, this is<br>\r\njust seperating multiple commands with a | (vertical line), or make use of<br>\r\n\"scriptcommand\" to run mod spicific commands, and in case the hosts api would<br>\r\nadd more commands they will be implmented here</html>");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 11;
		panel.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
	    scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
	    scrollPane.getVerticalScrollBar().setUnitIncrement(16);

	}
}
