package com.blackdragon2447.AAM.gui.dialog;

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
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JDialog;
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
import com.blackdragon2447.AAM.util.RconHandler;
import com.blackdragon2447.AAM.util.Utils;
import com.blackdragon2447.AAM.util.iface.AAMConfig;
import com.blackdragon2447.AAM.util.obj.SimpleCommand;

import net.kronos.rkon.core.ex.AuthenticationException;

/**
 * the dialog for setting the args for a simple command and running that command
 * @author Blackdragon2447
 */
public class SimpleCommandDialog extends JDialog {

	private static final long serialVersionUID = 3122563720977107636L;
	private JPanel contentPane;
	private JTextField ArgumentField;
	private JButton RunButton;
	private JButton QueueButton;
	private JLabel OutPutLabel;
	private JLabel ArgumentLabel;
	private JLabel ArgDescLabel;
	private JSeparator Separator;
	AAMConfig cfg = ConfigFactory.create(AAMConfig.class);
	

	/**
	 * starting the gui
	 * @param CommandNumber the number of the command to be executed
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void createGui(int CommandNumber) throws UnsupportedLookAndFeelException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCommandDialog frame = new SimpleCommandDialog(CommandNumber);
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
	 * @throws AuthenticationException 
	 * @throws IOException 
	 */
	public SimpleCommandDialog(int command) throws UnsupportedLookAndFeelException, IOException, AuthenticationException {
		
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		try {
			UIManager.setLookAndFeel(AAMGui.getLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{40, 180, 180, 40, 0};
		gbl_contentPane.rowHeights = new int[]{30, 20, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		OutPutLabel = new JLabel(Utils.GenerateCommand(command));
		GridBagConstraints gbc_outPutLabel = new GridBagConstraints();
		gbc_outPutLabel.gridwidth = 2;
		gbc_outPutLabel.insets = new Insets(0, 0, 5, 5);
		gbc_outPutLabel.gridx = 1;
		gbc_outPutLabel.gridy = 2;
		contentPane.add(OutPutLabel, gbc_outPutLabel);
		
		ArgumentLabel = new JLabel("argument description");
		ArgumentLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_argumentLabel = new GridBagConstraints();
		gbc_argumentLabel.gridwidth = 2;
		gbc_argumentLabel.insets = new Insets(0, 0, 5, 5);
		gbc_argumentLabel.gridx = 1;
		gbc_argumentLabel.gridy = 3;
		contentPane.add(ArgumentLabel, gbc_argumentLabel);
		
		ArgDescLabel = new JLabel(String.valueOf(Reference.SimpleCommandArgList.get(command).getSecondValue()));
		GridBagConstraints gbc_ArgDescLabel = new GridBagConstraints();
		gbc_ArgDescLabel.gridwidth = 2;
		gbc_ArgDescLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ArgDescLabel.gridx = 1;
		gbc_ArgDescLabel.gridy = 4;
		contentPane.add(ArgDescLabel, gbc_ArgDescLabel);
		
		ArgumentField = new JTextField();
		GridBagConstraints gbc_ArgumentField = new GridBagConstraints();
		gbc_ArgumentField.gridwidth = 2;
		gbc_ArgumentField.insets = new Insets(0, 0, 5, 5);
		gbc_ArgumentField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ArgumentField.gridx = 1;
		gbc_ArgumentField.gridy = 5;
		contentPane.add(ArgumentField, gbc_ArgumentField);
		ArgumentField.setColumns(10);
		ArgumentField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) dispose();
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(command != 4)
					OutPutLabel.setText(Utils.GenerateCommand(command) + " " + ArgumentField.getText());
				else
					OutPutLabel.setText(Utils.GenerateCommand(command) + " \'" + ArgumentField.getText() + "\' server");
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) dispose();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE) dispose();
			}
		});
		
		RunButton = new JButton("Run");
		GridBagConstraints gbc_RunButton = new GridBagConstraints();
		gbc_RunButton.insets = new Insets(0, 0, 0, 5);
		gbc_RunButton.gridx = 1;
		gbc_RunButton.gridy = 7;
		contentPane.add(RunButton, gbc_RunButton);
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
							JOptionPane.showInternalMessageDialog(contentPane, "not logged on", "", JOptionPane.ERROR_MESSAGE);
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
							JOptionPane.showInternalMessageDialog(contentPane, "not logged on", "", JOptionPane.ERROR_MESSAGE);
						}
						else {
							result = "an unkown error occured";
							e1.printStackTrace();
						}
					}
				}
				if(result.contains("no response"))
					JOptionPane.showInternalMessageDialog(contentPane, "server recived, assuming it exectued!");
				else
					JOptionPane.showInternalMessageDialog(contentPane, result);
				dispose();
			}
		});
		
		QueueButton = new JButton("Queue");
		GridBagConstraints gbc_QueueButton = new GridBagConstraints();
		gbc_QueueButton.insets = new Insets(0, 0, 0, 5);
		gbc_QueueButton.gridx = 2;
		gbc_QueueButton.gridy = 7;
		contentPane.add(QueueButton, gbc_QueueButton);
		QueueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Reference.Queue.add(new SimpleCommand(command, ArgumentField.getText()).generateGenericCommand());
				dispose();
			}
		});
		
		if(Reference.SimpleCommandList.get(command).getSecondValue() == false) ArgumentField.setEnabled(false);
		
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

	}

}
