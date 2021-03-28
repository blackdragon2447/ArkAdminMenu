package com.blackdragon2447.AAM.gui.dialog.advCom;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.aeonbits.owner.ConfigFactory;

import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.util.Pair;
import com.blackdragon2447.AAM.util.RconHandler;
import com.blackdragon2447.AAM.util.iface.AAMConfig;
import com.blackdragon2447.AAM.util.obj.GenericCommand;
import com.jidesoft.swing.ComboBoxSearchable;

import net.kronos.rkon.core.ex.AuthenticationException;

public class SpawnDinoCoordsDialog extends JDialog {

	private static final long serialVersionUID = -7611273233935193420L;
	private JPanel contentpane;
	private JButton RunButton;
	private JButton QueueButton;
	private JLabel OutPutLabel;
	private JLabel ArgumentLabel;
	private JSeparator Separator;
	AAMConfig cfg = ConfigFactory.create(AAMConfig.class);
	private JLabel PlayerSteamIDLabel;
	private JLabel LevelLabel;
	ArrayList<Pair<String, String>> FullCreaturePairList;
	RefreshThread refreshThread = new RefreshThread();
	Thread thread = new Thread(refreshThread);
	private JSpinner LevelSpinner;
	private JTextField PlayerIDField;
	private JLabel TamedLabel;
	private JCheckBox TamedCheckBox;
	private JLabel BPPathLabel;
	private JComboBox<String> DinoBPComboBox;
	private JLabel XCoordLabel;
	private JLabel YCoordLabel;
	private JLabel ZCoordLabel;
	private JTextField XField;
	private JTextField YField;
	private JTextField ZField;

	/**
	 * the method for opening the gui
	 */
	public static void createGui() throws UnsupportedLookAndFeelException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpawnDinoCoordsDialog frame = new SpawnDinoCoordsDialog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * the constructor: build the gui
	 * @throws UnsupportedLookAndFeelException 
	 */
	public SpawnDinoCoordsDialog() throws UnsupportedLookAndFeelException {

		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		try {
			UIManager.setLookAndFeel(AAMGui.getLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setBounds(100, 100, 530, 364);
		contentpane = new JPanel();
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentpane);
		GridBagLayout gbl_contentpane = new GridBagLayout();
		gbl_contentpane.columnWidths = new int[]{40, 180, 180, 40, 0};
		gbl_contentpane.rowHeights = new int[]{30, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentpane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentpane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentpane.setLayout(gbl_contentpane);
		
		Separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 2;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 0;
		contentpane.add(Separator, gbc_separator);
		
		JLabel CommandLabel = new JLabel("command");
		CommandLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_CommandLabel = new GridBagConstraints();
		gbc_CommandLabel.gridwidth = 2;
		gbc_CommandLabel.insets = new Insets(0, 0, 5, 5);
		gbc_CommandLabel.gridx = 1;
		gbc_CommandLabel.gridy = 1;
		contentpane.add(CommandLabel, gbc_CommandLabel);
		
		OutPutLabel = new JLabel(("spawndino"));
		GridBagConstraints gbc_outPutLabel = new GridBagConstraints();
		gbc_outPutLabel.gridwidth = 2;
		gbc_outPutLabel.insets = new Insets(0, 0, 5, 5);
		gbc_outPutLabel.gridx = 1;
		gbc_outPutLabel.gridy = 2;
		contentpane.add(OutPutLabel, gbc_outPutLabel);
		
		ArgumentLabel = new JLabel("arguments");
		ArgumentLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_argumentLabel = new GridBagConstraints();
		gbc_argumentLabel.gridwidth = 2;
		gbc_argumentLabel.insets = new Insets(0, 0, 5, 5);
		gbc_argumentLabel.gridx = 1;
		gbc_argumentLabel.gridy = 3;
		contentpane.add(ArgumentLabel, gbc_argumentLabel);

		PlayerSteamIDLabel = new JLabel("Player steam Id");
		GridBagConstraints gbc_PlayerSteamIDLabel = new GridBagConstraints();
		gbc_PlayerSteamIDLabel.anchor = GridBagConstraints.EAST;
		gbc_PlayerSteamIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PlayerSteamIDLabel.gridx = 1;
		gbc_PlayerSteamIDLabel.gridy = 4;
		contentpane.add(PlayerSteamIDLabel, gbc_PlayerSteamIDLabel);
		
		PlayerIDField = new JTextField();
		GridBagConstraints gbc_PlayerIDField = new GridBagConstraints();
		gbc_PlayerIDField.insets = new Insets(0, 0, 5, 5);
		gbc_PlayerIDField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PlayerIDField.gridx = 2;
		gbc_PlayerIDField.gridy = 4;
		contentpane.add(PlayerIDField, gbc_PlayerIDField);
		PlayerIDField.setColumns(10);
		
		BPPathLabel = new JLabel("Dino");
		GridBagConstraints gbc_BPPathLabel = new GridBagConstraints();
		gbc_BPPathLabel.anchor = GridBagConstraints.EAST;
		gbc_BPPathLabel.insets = new Insets(0, 0, 5, 5);
		gbc_BPPathLabel.gridx = 1;
		gbc_BPPathLabel.gridy = 5;
		contentpane.add(BPPathLabel, gbc_BPPathLabel);
		
		DinoBPComboBox = new JComboBox<String>();
		GridBagConstraints gbc_DinoBPComboBox = new GridBagConstraints();
		gbc_DinoBPComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_DinoBPComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_DinoBPComboBox.gridx = 2;
		gbc_DinoBPComboBox.gridy = 5;
		contentpane.add(DinoBPComboBox, gbc_DinoBPComboBox);
		
		DinoBPComboBox.removeAllItems();
		
		ArrayList<String> FullCreatureList = new ArrayList<String>();
		FullCreaturePairList = new ArrayList<Pair<String, String>>();
		for(int i = 0; i < Reference.ImportedCreatureGroups.size(); i++) {
			for(int x = 0; x < Reference.ImportedCreatureGroups.get(i).getSecondValue().size(); x++) {
				FullCreatureList.add(Reference.ImportedCreatureGroups.get(i).getSecondValue().get(x).getSecondValue());
				FullCreaturePairList.add(Reference.ImportedCreatureGroups.get(i).getSecondValue().get(x));
			}
			
		}
		for (String string : FullCreatureList) {
			DinoBPComboBox.addItem(string);
		}
		DinoBPComboBox.setSelectedIndex(-1);
		
		@SuppressWarnings("unused")
		ComboBoxSearchable searchable = new ComboBoxSearchable(DinoBPComboBox);
		

		LevelLabel = new JLabel("Level");
		GridBagConstraints gbc_LevelLabel = new GridBagConstraints();
		gbc_LevelLabel.anchor = GridBagConstraints.EAST;
		gbc_LevelLabel.insets = new Insets(0, 0, 5, 5);
		gbc_LevelLabel.gridx = 1;
		gbc_LevelLabel.gridy = 6;
		contentpane.add(LevelLabel, gbc_LevelLabel);
		
		LevelSpinner = new JSpinner();
		LevelSpinner.setModel(new SpinnerNumberModel(600, 0, 900, 20));
		GridBagConstraints gbc_LevelSpinner = new GridBagConstraints();
		gbc_LevelSpinner.anchor = GridBagConstraints.WEST;
		gbc_LevelSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_LevelSpinner.gridx = 2;
		gbc_LevelSpinner.gridy = 6;
		contentpane.add(LevelSpinner, gbc_LevelSpinner);
		Component spinnerEditor = LevelSpinner.getEditor();
		JFormattedTextField SpinnerTF = ((JSpinner.DefaultEditor) spinnerEditor).getTextField();
		SpinnerTF.setColumns(5);
		
		TamedLabel = new JLabel("Tamed");
		GridBagConstraints gbc_TamedLabel = new GridBagConstraints();
		gbc_TamedLabel.anchor = GridBagConstraints.EAST;
		gbc_TamedLabel.insets = new Insets(0, 0, 5, 5);
		gbc_TamedLabel.gridx = 1;
		gbc_TamedLabel.gridy = 7;
		contentpane.add(TamedLabel, gbc_TamedLabel);
		
		TamedCheckBox = new JCheckBox("");
		GridBagConstraints gbc_TamedCheckBox = new GridBagConstraints();
		gbc_TamedCheckBox.anchor = GridBagConstraints.WEST;
		gbc_TamedCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_TamedCheckBox.gridx = 2;
		gbc_TamedCheckBox.gridy = 7;
		contentpane.add(TamedCheckBox, gbc_TamedCheckBox);
		
		XCoordLabel = new JLabel("X");
		GridBagConstraints gbc_XCoordLabel = new GridBagConstraints();
		gbc_XCoordLabel.anchor = GridBagConstraints.EAST;
		gbc_XCoordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_XCoordLabel.gridx = 1;
		gbc_XCoordLabel.gridy = 8;
		contentpane.add(XCoordLabel, gbc_XCoordLabel);
		
		XField = new JTextField();
		GridBagConstraints gbc_XField = new GridBagConstraints();
		gbc_XField.insets = new Insets(0, 0, 5, 5);
		gbc_XField.fill = GridBagConstraints.HORIZONTAL;
		gbc_XField.gridx = 2;
		gbc_XField.gridy = 8;
		contentpane.add(XField, gbc_XField);
		XField.setColumns(10);
		
		YCoordLabel = new JLabel("Y");
		GridBagConstraints gbc_YCoordLabel = new GridBagConstraints();
		gbc_YCoordLabel.anchor = GridBagConstraints.EAST;
		gbc_YCoordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_YCoordLabel.gridx = 1;
		gbc_YCoordLabel.gridy = 9;
		contentpane.add(YCoordLabel, gbc_YCoordLabel);
		
		YField = new JTextField();
		GridBagConstraints gbc_YField = new GridBagConstraints();
		gbc_YField.insets = new Insets(0, 0, 5, 5);
		gbc_YField.fill = GridBagConstraints.HORIZONTAL;
		gbc_YField.gridx = 2;
		gbc_YField.gridy = 9;
		contentpane.add(YField, gbc_YField);
		YField.setColumns(10);
		
		ZCoordLabel = new JLabel("Z");
		GridBagConstraints gbc_ZCoordLabel = new GridBagConstraints();
		gbc_ZCoordLabel.anchor = GridBagConstraints.EAST;
		gbc_ZCoordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ZCoordLabel.gridx = 1;
		gbc_ZCoordLabel.gridy = 10;
		contentpane.add(ZCoordLabel, gbc_ZCoordLabel);
		
		ZField = new JTextField();
		GridBagConstraints gbc_ZField = new GridBagConstraints();
		gbc_ZField.insets = new Insets(0, 0, 5, 5);
		gbc_ZField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ZField.gridx = 2;
		gbc_ZField.gridy = 10;
		contentpane.add(ZField, gbc_ZField);
		ZField.setColumns(10);
		
		RunButton = new JButton("Run");
		GridBagConstraints gbc_RunButton = new GridBagConstraints();
		gbc_RunButton.insets = new Insets(0, 0, 0, 5);
		gbc_RunButton.gridx = 1;
		gbc_RunButton.gridy = 11;
		contentpane.add(RunButton, gbc_RunButton);
		RunButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String result = null;
				if(!Reference.MultipleServer) {
					try {
						result = RconHandler.command(OutPutLabel.getText());
					} catch (Exception e1) {
						if(e1 instanceof AuthenticationException) result = "failed to outheticate";
						else if (Reference.Password == null) {
							JOptionPane.showInternalMessageDialog(contentpane, "not logged on", "", JOptionPane.ERROR_MESSAGE);
						}
						else {
							result = "an unkown error occured";
							e1.printStackTrace();
						}
					}
				} else {
					try {
						result = RconHandler.MultipleCommand(OutPutLabel.getText());
					} catch (Exception e1) {
						if(e1 instanceof AuthenticationException) result = "failed to outheticate";
						else if (Reference.Password == null) {
							JOptionPane.showInternalMessageDialog(contentpane, "not logged on", "", JOptionPane.ERROR_MESSAGE);
						}
						else {
							result = "an unkown error occured";
							e1.printStackTrace();
						}
					}
				}
				if(result.contains("no response"))
					JOptionPane.showInternalMessageDialog(contentpane, "server recived, assuming it exectued!");
				else
					JOptionPane.showInternalMessageDialog(contentpane, result);
				dispose();
			}
		});
		
		QueueButton = new JButton("Queue");
		GridBagConstraints gbc_QueueButton = new GridBagConstraints();
		gbc_QueueButton.insets = new Insets(0, 0, 0, 5);
		gbc_QueueButton.gridx = 2;
		gbc_QueueButton.gridy = 11;
		contentpane.add(QueueButton, gbc_QueueButton);
		QueueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] arguments = {null, null, null, null, null, null, null};
				
				arguments[0] = PlayerIDField.getText();
				arguments[1] = "\"blueprint\'"+FullCreaturePairList.get(DinoBPComboBox.getSelectedIndex()).getFirstValue()+"\'\"";
				arguments[2] = String.valueOf(((Integer) LevelSpinner.getValue()));
				arguments[3] = TamedCheckBox.isSelected() ? "1" : "0";
				arguments[4] = "0";
				arguments[5] = "0";
				arguments[6] = "0";
						
				Reference.Queue.add(new GenericCommand("addexperience", arguments));
				refreshThread.stop();
				dispose();
			}
		});
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) dispose();
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) dispose();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) dispose();
				
			}
		});
		
		setFocusable(true);
		
		Component[] components = getComponents();
		
		for(Component component : components) {
			component.addKeyListener(new KeyListener() {

			
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) dispose();
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) dispose();
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) dispose();
				
			}
			});
			
			component.setFocusable(true);
			
			
		}
		
		thread.start();
		
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
				refreshThread.stop();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		});

	}
	
	/**
	 * the refresh thread, an extra thread used to refesh the shown command one a sec to prevent having to use a lot of listners
	 * @author Blackdragon2447
	 */
	class RefreshThread implements Runnable {

		Thread RefreshThead;
	    private volatile boolean exit = false;

		
		public RefreshThread() {}
		
		@Override
		public void run() {
			
			while(!exit) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				String[] arguments = {null, null, null, null, null, null, null};

				arguments[0] = PlayerIDField.getText();
				try {
					arguments[1] = "\"blueprint\'"+FullCreaturePairList.get(DinoBPComboBox.getSelectedIndex()).getFirstValue()+"\'\"";
				} catch (ArrayIndexOutOfBoundsException e) {
					arguments[1] = "";
				}
				arguments[2] = String.valueOf(((Integer) LevelSpinner.getValue()));
				arguments[3] = TamedCheckBox.isSelected() ? "1" : "0";
				arguments[4] = "0";
				arguments[5] = "0";
				arguments[6] = "0";
				
				OutPutLabel.setText(new GenericCommand("spawndino", arguments).generateCommand());
				
			}
			
		}
		
		public void stop() {
			exit = true;
		}
		
	}
	
	@Override
	public void dispose() {
		refreshThread.stop();
		super.dispose();
	}

}
