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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.aeonbits.owner.ConfigFactory;

import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.util.Pair;
import com.blackdragon2447.AAM.util.Utils;
import com.blackdragon2447.AAM.util.iface.AAMConfig;
import com.blackdragon2447.AAM.util.obj.GenericCommand;
import com.jidesoft.swing.ComboBoxSearchable;

public class GFICommandDialog extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3122563720977107636L;
	private JPanel contentPane;
	private JTextField PlayerIDField;
	private JButton RunButton;
	private JButton QueueButton;
	private JLabel OutPutLabel;
	private JLabel ArgumentLabel;
	private JSeparator Separator;
	AAMConfig cfg = ConfigFactory.create(AAMConfig.class);
	private JComboBox<String> comboBox;
	private JSpinner QuantitySpinner;
	private JComboBox<String> QualityComboBox;
	private JCheckBox BlueprintCheckBox;
	private JLabel QuanityLabel;
	private JLabel blueprintLabel;
	private JLabel PlayerIdLabel;
	private JLabel ItemLabel;
	private JLabel QualityLabel;
	ArrayList<Pair<String, String>> FullItemPairList;
	RefreshThread refreshThread = new RefreshThread();
	Thread thread = new Thread(refreshThread);

	
	public static void createGui() throws UnsupportedLookAndFeelException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GFICommandDialog frame = new GFICommandDialog();
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
	public GFICommandDialog() throws UnsupportedLookAndFeelException {
		

		try {
			UIManager.setLookAndFeel(AAMGui.getLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{40, 180, 180, 40, 0};
		gbl_contentPane.rowHeights = new int[]{30, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		OutPutLabel = new JLabel(Utils.GenerateStringCommand("giveitemtoplayer"));
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
		
		PlayerIdLabel = new JLabel("player id");
		GridBagConstraints gbc_PlayerIdLabel = new GridBagConstraints();
		gbc_PlayerIdLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PlayerIdLabel.gridx = 1;
		gbc_PlayerIdLabel.gridy = 4;
		contentPane.add(PlayerIdLabel, gbc_PlayerIdLabel);
		
		PlayerIDField = new JTextField();
		GridBagConstraints gbc_PlayerIDField = new GridBagConstraints();
		gbc_PlayerIDField.insets = new Insets(0, 0, 5, 5);
		gbc_PlayerIDField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PlayerIDField.gridx = 2;
		gbc_PlayerIDField.gridy = 4;
		contentPane.add(PlayerIDField, gbc_PlayerIDField);
		PlayerIDField.setColumns(10);
		PlayerIDField.addKeyListener(new KeyListener() {
			
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
		
		ItemLabel = new JLabel("item");
		GridBagConstraints gbc_ItemLabel = new GridBagConstraints();
		gbc_ItemLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ItemLabel.gridx = 1;
		gbc_ItemLabel.gridy = 5;
		contentPane.add(ItemLabel, gbc_ItemLabel);
		
		//SortedComboBoxModel<String> model = new SortedComboBoxModel<String>();
		comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 5;
		contentPane.add(comboBox, gbc_comboBox);
		ArrayList<String> FullItemList = new ArrayList<String>();
		FullItemPairList = new ArrayList<Pair<String, String>>();
		for(int i = 0; i < Reference.ImportedItemGroups.size(); i++) {
			
			
			for(int x = 0; x < Reference.ImportedItemGroups.get(i).getSecondValue().size(); x++) {
				FullItemList.add(Reference.ImportedItemGroups.get(i).getSecondValue().get(x).getSecondValue());
				FullItemPairList.add(Reference.ImportedItemGroups.get(i).getSecondValue().get(x));
			}
			
		}
		for (String string : FullItemList) {
			comboBox.addItem(string);
		}
		comboBox.setSelectedIndex(-1);
		//comboBox.setEditable(true);
		
		@SuppressWarnings("unused")
		ComboBoxSearchable searchable = new ComboBoxSearchable(comboBox);
		
		
		QuanityLabel = new JLabel("quantity");
		GridBagConstraints gbc_QuanityLabel = new GridBagConstraints();
		gbc_QuanityLabel.insets = new Insets(0, 0, 5, 5);
		gbc_QuanityLabel.gridx = 1;
		gbc_QuanityLabel.gridy = 6;
		contentPane.add(QuanityLabel, gbc_QuanityLabel);
		
		QuantitySpinner = new JSpinner();
		GridBagConstraints gbc_QuantitySpinner = new GridBagConstraints();
		gbc_QuantitySpinner.insets = new Insets(0, 0, 5, 5);
		gbc_QuantitySpinner.gridx = 2;
		gbc_QuantitySpinner.gridy = 6;
		contentPane.add(QuantitySpinner, gbc_QuantitySpinner);
		QuantitySpinner.setValue(1);
		
		QualityLabel = new JLabel("quality");
		GridBagConstraints gbc_QualityLabel = new GridBagConstraints();
		gbc_QualityLabel.insets = new Insets(0, 0, 5, 5);
		gbc_QualityLabel.gridx = 1;
		gbc_QualityLabel.gridy = 7;
		contentPane.add(QualityLabel, gbc_QualityLabel);
		
		String[] QualityList = {"Primitive", "Ramshackle", "Journyman", "Mastercraft", "Ascendant"};
		QualityComboBox = new JComboBox<String>(QualityList);
		GridBagConstraints gbc_QualityComboBox = new GridBagConstraints();
		gbc_QualityComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_QualityComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_QualityComboBox.gridx = 2;
		gbc_QualityComboBox.gridy = 7;
		contentPane.add(QualityComboBox, gbc_QualityComboBox);
		
		blueprintLabel = new JLabel("blueprint");
		GridBagConstraints gbc_blueprintLabel = new GridBagConstraints();
		gbc_blueprintLabel.insets = new Insets(0, 0, 5, 5);
		gbc_blueprintLabel.gridx = 1;
		gbc_blueprintLabel.gridy = 8;
		contentPane.add(blueprintLabel, gbc_blueprintLabel);
		
		BlueprintCheckBox = new JCheckBox("");
		GridBagConstraints gbc_BlueprintCheckBox = new GridBagConstraints();
		gbc_BlueprintCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_BlueprintCheckBox.gridx = 2;
		gbc_BlueprintCheckBox.gridy = 8;
		contentPane.add(BlueprintCheckBox, gbc_BlueprintCheckBox);
		
		RunButton = new JButton("Run");
		GridBagConstraints gbc_RunButton = new GridBagConstraints();
		gbc_RunButton.insets = new Insets(0, 0, 0, 5);
		gbc_RunButton.gridx = 1;
		gbc_RunButton.gridy = 9;
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
		gbc_QueueButton.gridy = 9;
		contentPane.add(QueueButton, gbc_QueueButton);
		QueueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] arguments = {null, null, null, null, null};
				
				arguments[1] = PlayerIDField.getText();
				arguments[2] = FullItemPairList.get(comboBox.getSelectedIndex()).getSecondValue();
				arguments[2] = String.valueOf(QuantitySpinner.getValue());
				arguments[3] = String.valueOf(QualityComboBox.getSelectedIndex());
				arguments[4] = BlueprintCheckBox.isSelected() ? "1" : "0";
				
				Reference.Queue.add(new GenericCommand(Utils.getPrefix(), "giveitemtoplayer", arguments));
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
				
				String[] arguments = {null, null, null, null, null};
				
				arguments[0] = PlayerIDField.getText();
				arguments[1] = comboBox.getSelectedIndex() != -1 ?  FullItemPairList.get(comboBox.getSelectedIndex()).getSecondValue() : "";
				arguments[2] = String.valueOf(QuantitySpinner.getValue());
				arguments[3] = String.valueOf(QualityComboBox.getSelectedIndex());
				arguments[4] = BlueprintCheckBox.isSelected() ? "1" : "0";
				
				System.out.println("-\\|/-");
				OutPutLabel.setText(new GenericCommand(Utils.getPrefix(), "giveitemtoplayer", arguments).generateCommand());
				
			}
			
		}
		
		public void stop() {
			exit = true;
		}
		
	}

}
