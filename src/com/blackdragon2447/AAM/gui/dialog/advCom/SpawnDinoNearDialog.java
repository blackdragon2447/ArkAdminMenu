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
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import com.blackdragon2447.AAM.util.iface.AAMConfig;
import com.blackdragon2447.AAM.util.obj.GenericCommand;
import com.jidesoft.swing.ComboBoxSearchable;

public class SpawnDinoNearDialog extends JFrame {

	private static final long serialVersionUID = -3379509028862039726L;
	private JPanel contentPane;
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

	
	public static void createGui() throws UnsupportedLookAndFeelException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpawnDinoNearDialog frame = new SpawnDinoNearDialog();
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 */
	public SpawnDinoNearDialog() throws UnsupportedLookAndFeelException {
		

		try {
			UIManager.setLookAndFeel(AAMGui.getLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{40, 180, 180, 40, 0};
		gbl_contentPane.rowHeights = new int[]{30, 20, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		Separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 2;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 0;
		contentPane.add(Separator, gbc_separator);
		
		JLabel CommandLabel = new JLabel("command");
		CommandLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_CommandLabel = new GridBagConstraints();
		gbc_CommandLabel.gridwidth = 2;
		gbc_CommandLabel.insets = new Insets(0, 0, 5, 5);
		gbc_CommandLabel.gridx = 1;
		gbc_CommandLabel.gridy = 1;
		contentPane.add(CommandLabel, gbc_CommandLabel);
		
		OutPutLabel = new JLabel(("spawndino"));
		GridBagConstraints gbc_outPutLabel = new GridBagConstraints();
		gbc_outPutLabel.gridwidth = 2;
		gbc_outPutLabel.insets = new Insets(0, 0, 5, 5);
		gbc_outPutLabel.gridx = 1;
		gbc_outPutLabel.gridy = 2;
		contentPane.add(OutPutLabel, gbc_outPutLabel);
		
		ArgumentLabel = new JLabel("arguments");
		ArgumentLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_argumentLabel = new GridBagConstraints();
		gbc_argumentLabel.gridwidth = 2;
		gbc_argumentLabel.insets = new Insets(0, 0, 5, 5);
		gbc_argumentLabel.gridx = 1;
		gbc_argumentLabel.gridy = 3;
		contentPane.add(ArgumentLabel, gbc_argumentLabel);
		
		for (Pair<Integer, String> pair: Reference.AdvancedCommandArgList) {
			System.out.println(pair.GetcsvValue());
		}
		
		PlayerSteamIDLabel = new JLabel("Player steam Id");
		GridBagConstraints gbc_PlayerSteamIDLabel = new GridBagConstraints();
		gbc_PlayerSteamIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PlayerSteamIDLabel.gridx = 1;
		gbc_PlayerSteamIDLabel.gridy = 4;
		contentPane.add(PlayerSteamIDLabel, gbc_PlayerSteamIDLabel);
		
		PlayerIDField = new JTextField();
		GridBagConstraints gbc_PlayerIDField = new GridBagConstraints();
		gbc_PlayerIDField.insets = new Insets(0, 0, 5, 5);
		gbc_PlayerIDField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PlayerIDField.gridx = 2;
		gbc_PlayerIDField.gridy = 4;
		contentPane.add(PlayerIDField, gbc_PlayerIDField);
		PlayerIDField.setColumns(10);
		
		BPPathLabel = new JLabel("Dino");
		GridBagConstraints gbc_BPPathLabel = new GridBagConstraints();
		gbc_BPPathLabel.insets = new Insets(0, 0, 5, 5);
		gbc_BPPathLabel.gridx = 1;
		gbc_BPPathLabel.gridy = 5;
		contentPane.add(BPPathLabel, gbc_BPPathLabel);
		
		DinoBPComboBox = new JComboBox<String>();
		GridBagConstraints gbc_DinoBPComboBox = new GridBagConstraints();
		gbc_DinoBPComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_DinoBPComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_DinoBPComboBox.gridx = 2;
		gbc_DinoBPComboBox.gridy = 5;
		contentPane.add(DinoBPComboBox, gbc_DinoBPComboBox);
		
		DinoBPComboBox.removeAllItems();
		
		ArrayList<String> FullCreatureList = new ArrayList<String>();
		FullCreaturePairList = new ArrayList<Pair<String, String>>();
		for(int i = 0; i < Reference.ImportedCreatureGroups.size(); i++) {
			System.out.println(Reference.ImportedCreatureGroups.get(i).getSecondValue().size());
			for(int x = 0; x < Reference.ImportedCreatureGroups.get(i).getSecondValue().size(); x++) {
				FullCreatureList.add(Reference.ImportedCreatureGroups.get(i).getSecondValue().get(x).getSecondValue());
				FullCreaturePairList.add(Reference.ImportedCreatureGroups.get(i).getSecondValue().get(x));
				System.out.println(Reference.ImportedCreatureGroups.get(i).getSecondValue().get(x).getSecondValue());
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
		gbc_LevelLabel.insets = new Insets(0, 0, 5, 5);
		gbc_LevelLabel.gridx = 1;
		gbc_LevelLabel.gridy = 6;
		contentPane.add(LevelLabel, gbc_LevelLabel);
		
		LevelSpinner = new JSpinner();
		LevelSpinner.setModel(new SpinnerNumberModel(600, 0, 900, 20));
		GridBagConstraints gbc_LevelSpinner = new GridBagConstraints();
		gbc_LevelSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_LevelSpinner.gridx = 2;
		gbc_LevelSpinner.gridy = 6;
		contentPane.add(LevelSpinner, gbc_LevelSpinner);
		Component spinnerEditor = LevelSpinner.getEditor();
		JFormattedTextField SpinnerTF = ((JSpinner.DefaultEditor) spinnerEditor).getTextField();
		SpinnerTF.setColumns(5);
		
		TamedLabel = new JLabel("Tamed");
		GridBagConstraints gbc_TamedLabel = new GridBagConstraints();
		gbc_TamedLabel.insets = new Insets(0, 0, 5, 5);
		gbc_TamedLabel.gridx = 1;
		gbc_TamedLabel.gridy = 7;
		contentPane.add(TamedLabel, gbc_TamedLabel);
		
		TamedCheckBox = new JCheckBox("");
		GridBagConstraints gbc_TamedCheckBox = new GridBagConstraints();
		gbc_TamedCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_TamedCheckBox.gridx = 2;
		gbc_TamedCheckBox.gridy = 7;
		contentPane.add(TamedCheckBox, gbc_TamedCheckBox);
		
		RunButton = new JButton("Run");
		GridBagConstraints gbc_RunButton = new GridBagConstraints();
		gbc_RunButton.insets = new Insets(0, 0, 0, 5);
		gbc_RunButton.gridx = 1;
		gbc_RunButton.gridy = 8;
		contentPane.add(RunButton, gbc_RunButton);
		RunButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(OutPutLabel.getText());
				dispose();
				refreshThread.stop();
			}
		});
		
		QueueButton = new JButton("Queue");
		GridBagConstraints gbc_QueueButton = new GridBagConstraints();
		gbc_QueueButton.insets = new Insets(0, 0, 0, 5);
		gbc_QueueButton.gridx = 2;
		gbc_QueueButton.gridy = 8;
		contentPane.add(QueueButton, gbc_QueueButton);
		QueueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] arguments = {null, null, null, null, null, null, null};
				
				arguments[0] = PlayerIDField.getText();
				arguments[1] = "\""+FullCreaturePairList.get(DinoBPComboBox.getSelectedIndex()).getFirstValue()+"\"";
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
					arguments[1] = "\""+FullCreaturePairList.get(DinoBPComboBox.getSelectedIndex()).getFirstValue()+"\"";
				} catch (ArrayIndexOutOfBoundsException e) {
					arguments[1] = "";
				}
				arguments[2] = String.valueOf(((Integer) LevelSpinner.getValue()));
				arguments[3] = TamedCheckBox.isSelected() ? "1" : "0";
				arguments[4] = "0";
				arguments[5] = "0";
				arguments[6] = "0";
				
				System.out.println("-----");
				OutPutLabel.setText(new GenericCommand("spawndino", arguments).generateCommand());
				
			}
			
		}
		
		public void stop() {
			exit = true;
		}
		
	}

}
