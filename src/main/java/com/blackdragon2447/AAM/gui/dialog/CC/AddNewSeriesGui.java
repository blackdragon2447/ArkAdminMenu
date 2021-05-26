package com.blackdragon2447.AAM.gui.dialog.CC;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import org.aeonbits.owner.ConfigFactory;

import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.util.iface.AAMConfig;

/**
 * the dialog for adding a command series
 * temp depricated til it is fixed
 * @author Blackdragon2447
 *
 */
@Deprecated
public class AddNewSeriesGui extends JFrame {

	private static final long serialVersionUID = -3517898970202091099L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	AAMConfig cfg = ConfigFactory.create(AAMConfig.class);
	private JPanel CommandPanel;
	private JButton AddButtonButton;
	private JScrollPane scrollPane;
	private JLabel NameLabel;
	private JTextField NameField;

	public static void createGui() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AddNewSeriesGui frame = new AddNewSeriesGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddNewSeriesGui() {
		
		try {
			UIManager.setLookAndFeel(AAMGui.getLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 432, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{22, 184, 0, 22, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 22, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Create New Command Series");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		NameLabel = new JLabel("Name Of The Series");
		GridBagConstraints gbc_NameLabel = new GridBagConstraints();
		gbc_NameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_NameLabel.gridx = 1;
		gbc_NameLabel.gridy = 1;
		contentPane.add(NameLabel, gbc_NameLabel);
		
		NameField = new JTextField();
		GridBagConstraints gbc_NameField = new GridBagConstraints();
		gbc_NameField.insets = new Insets(0, 0, 5, 5);
		gbc_NameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_NameField.gridx = 2;
		gbc_NameField.gridy = 1;
		contentPane.add(NameField, gbc_NameField);
		NameField.setColumns(10);
		
		AddButtonButton = new JButton("\u2795");
		GridBagConstraints gbc_AddButtonButton = new GridBagConstraints();
		gbc_AddButtonButton.insets = new Insets(0, 0, 5, 0);
		gbc_AddButtonButton.gridx = 3;
		gbc_AddButtonButton.gridy = 2;
		contentPane.add(AddButtonButton, gbc_AddButtonButton);
		AddButtonButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField TxtField = new JTextField();
				CommandPanel.add(TxtField);
				CommandPanel.revalidate();
				CommandPanel.repaint();
			}
		});
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		CommandPanel = new JPanel();
		scrollPane.setViewportView(CommandPanel);
		CommandPanel.setLayout(new BoxLayout(CommandPanel, BoxLayout.Y_AXIS));
		
		btnNewButton = new JButton("Confirm");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String [] arr = cfg.CommandSeriesName();
				try {
					arr = Arrays.copyOf(arr, arr.length + 1);
				} catch (NullPointerException e2) {
					arr = new String[]{null};
				}
				arr[arr.length - 1] = NameField.getText();
				cfg.setProperty("CommandSeriesName", Arrays.toString(arr));
				
				
				
				String[][] arr1 = {{}};
				try {
					arr1 = Arrays.copyOf(arr1, arr1.length + 1);
				} catch (NullPointerException e2) {
					arr1 = new String[][]{{null}};
				}
				ArrayList<JTextField> fields = new ArrayList<>();
				
				for (Component Component : CommandPanel.getComponents()) {
					fields.add((JTextField) Component);
				}
				
				ArrayList<String> commands = new ArrayList<>();
				for (JTextField field : fields) {
					commands.add(field.getText());
				}
				arr1[arr1.length - 1] = commands.toArray(new String[0]);
				
				cfg.setProperty("CommandSeries", Arrays.deepToString(arr1));
				
				
				
				try {
					cfg.store(new FileOutputStream("AAMConfig.properties"), "no comments");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
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
