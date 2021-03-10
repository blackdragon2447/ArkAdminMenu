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
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
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

import net.kronos.rkon.core.ex.AuthenticationException;

public class ForceIntoTribeDialog extends JFrame {

	private static final long serialVersionUID = 3122563720977107636L;
	private JPanel contentPane;
	private JTextField PlayerIDField;
	private JButton RunButton;
	private JButton QueueButton;
	private JLabel OutPutLabel;
	private JLabel ArgumentLabel;
	private JSeparator Separator;
	AAMConfig cfg = ConfigFactory.create(AAMConfig.class);
	private JLabel PlayerIDLabel;
	private JLabel TribeNameLabel;
	ArrayList<Pair<String, String>> FullItemPairList;
	RefreshThread refreshThread = new RefreshThread();
	Thread thread = new Thread(refreshThread);
	private JTextField TribeNameField;

	/**
	 * the method for opening the gui
	 */
	public static void createGui() throws UnsupportedLookAndFeelException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForceIntoTribeDialog frame = new ForceIntoTribeDialog();
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	public ForceIntoTribeDialog() throws UnsupportedLookAndFeelException {
		

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
		gbl_contentPane.rowHeights = new int[]{30, 20, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		OutPutLabel = new JLabel("forceplayertojointribe");
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
		
		PlayerIDLabel = new JLabel("PlayerId");
		GridBagConstraints gbc_PlayerIDLabel = new GridBagConstraints();
		gbc_PlayerIDLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PlayerIDLabel.gridx = 1;
		gbc_PlayerIDLabel.gridy = 4;
		contentPane.add(PlayerIDLabel, gbc_PlayerIDLabel);
		
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
		
		TribeNameLabel = new JLabel("Tribe name");
		GridBagConstraints gbc_TribeNameLabel = new GridBagConstraints();
		gbc_TribeNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_TribeNameLabel.gridx = 1;
		gbc_TribeNameLabel.gridy = 5;
		contentPane.add(TribeNameLabel, gbc_TribeNameLabel);
		
		TribeNameField = new JTextField();
		GridBagConstraints gbc_TribeNameField = new GridBagConstraints();
		gbc_TribeNameField.insets = new Insets(0, 0, 5, 5);
		gbc_TribeNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_TribeNameField.gridx = 2;
		gbc_TribeNameField.gridy = 5;
		contentPane.add(TribeNameField, gbc_TribeNameField);
		TribeNameField.setColumns(10);
		
		RunButton = new JButton("Run");
		GridBagConstraints gbc_RunButton = new GridBagConstraints();
		gbc_RunButton.insets = new Insets(0, 0, 0, 5);
		gbc_RunButton.gridx = 1;
		gbc_RunButton.gridy = 6;
		contentPane.add(RunButton, gbc_RunButton);
		RunButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String result = null;
					try {
						result = RconHandler.command(OutPutLabel.getText());
					} catch (AuthenticationException e1) {
						if(e1 instanceof AuthenticationException) result = "failed to outheticate";
						else {
							result = "an unkown error occured";
							e1.printStackTrace();
						}
					}
					JOptionPane.showInternalMessageDialog(contentPane, result);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
				refreshThread.stop();
			}
		});
		
		QueueButton = new JButton("Queue");
		GridBagConstraints gbc_QueueButton = new GridBagConstraints();
		gbc_QueueButton.insets = new Insets(0, 0, 0, 5);
		gbc_QueueButton.gridx = 2;
		gbc_QueueButton.gridy = 6;
		contentPane.add(QueueButton, gbc_QueueButton);
		QueueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] arguments = {null, null};
				
				arguments[0] = PlayerIDField.getText();
				arguments[1] = TribeNameField.getText();
				
				Reference.Queue.add(new GenericCommand("forceplayertojointribe", arguments));
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
				
				String[] arguments = {null, null};
				
				arguments[0] = PlayerIDField.getText();
				arguments[1] = TribeNameField.getText();
				
				System.out.println("-----");
				OutPutLabel.setText(new GenericCommand("forceplayertojointribe", arguments).generateCommand());
				
			}
			
		}
		
		public void stop() {
			exit = true;
		}
		
	}

}
