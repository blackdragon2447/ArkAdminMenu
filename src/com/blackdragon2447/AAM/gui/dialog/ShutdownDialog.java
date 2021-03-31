package com.blackdragon2447.AAM.gui.dialog;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.blackdragon2447.AAM.Main;
import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.util.RconHandler;

import net.kronos.rkon.core.ex.AuthenticationException;

public class ShutdownDialog extends JFrame {

	private static final long serialVersionUID = -3428022636212201058L;
	private JPanel contentPane;
	private Object commonObject = new Object();
	private RunThread runThread = new RunThread();
	private Thread thread = new Thread(runThread);
	JButton PauseButton = new JButton("Pause");
	JButton RunButton = new JButton("Run");
	private ActionListener StartStopListner = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(thread.isAlive()) {
				runThread.stop();
				thread.interrupt();
				dispose();
			} else {
				thread.start();
				RunButton.setText("Cancel");
			}
		}
	};
	private ActionListener pauseListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
				if(runThread.isPaused()) {
					synchronized (commonObject) {
						commonObject.notify();
						runThread.unpause();
						PauseButton.setText("Pause");
					}
				} else {
					runThread.pause();
					PauseButton.setText("Restart");
				}
		}
	};
	JLabel Command1Label = new JLabel("<html>broadcast wiping dinos in 10 min,<br>let an admin know in discord if you need more time</html>");
	JLabel Wait1Label = new JLabel("wait 5 min");
	JLabel Command2Label = new JLabel("<html>broadcast wiping dinos in 5 min,<br>let an admin know in discord if you need more time</html>");
	JLabel Wait2Label = new JLabel("wait 2 min");
	JLabel Command3Label = new JLabel("<html>broadcast wiping dinos in 3 min,<br>let an admin know in discord if you need more time</html>");
	JLabel StopLabel = new JLabel("kick everyone and stop the server");
	private final JLabel Wait3Label = new JLabel("wait 3 min");

	/**
	 * Launch the application.
	 */
	public static void CreateGui() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ShutdownDialog frame = new ShutdownDialog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShutdownDialog() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		Command1Label.setForeground(Color.RED);
		GridBagConstraints gbc_Command1Label = new GridBagConstraints();
		gbc_Command1Label.gridwidth = 2;
		gbc_Command1Label.insets = new Insets(0, 0, 5, 5);
		gbc_Command1Label.gridx = 1;
		gbc_Command1Label.gridy = 1;
		contentPane.add(Command1Label, gbc_Command1Label);
		
		GridBagConstraints gbc_Wait1Label = new GridBagConstraints();
		gbc_Wait1Label.gridwidth = 2;
		gbc_Wait1Label.insets = new Insets(0, 0, 5, 5);
		gbc_Wait1Label.gridx = 1;
		gbc_Wait1Label.gridy = 2;
		contentPane.add(Wait1Label, gbc_Wait1Label);
		
		GridBagConstraints gbc_Command2Label = new GridBagConstraints();
		gbc_Command2Label.gridwidth = 2;
		gbc_Command2Label.insets = new Insets(0, 0, 5, 5);
		gbc_Command2Label.gridx = 1;
		gbc_Command2Label.gridy = 3;
		contentPane.add(Command2Label, gbc_Command2Label);
		
		GridBagConstraints gbc_Wait2Label = new GridBagConstraints();
		gbc_Wait2Label.gridwidth = 2;
		gbc_Wait2Label.insets = new Insets(0, 0, 5, 5);
		gbc_Wait2Label.gridx = 1;
		gbc_Wait2Label.gridy = 4;
		contentPane.add(Wait2Label, gbc_Wait2Label);
		
		GridBagConstraints gbc_Command3Label = new GridBagConstraints();
		gbc_Command3Label.gridwidth = 2;
		gbc_Command3Label.insets = new Insets(0, 0, 5, 5);
		gbc_Command3Label.gridx = 1;
		gbc_Command3Label.gridy = 5;
		contentPane.add(Command3Label, gbc_Command3Label);
		
		GridBagConstraints gbc_Wait3Label = new GridBagConstraints();
		gbc_Wait3Label.gridwidth = 2;
		gbc_Wait3Label.insets = new Insets(0, 0, 5, 5);
		gbc_Wait3Label.gridx = 1;
		gbc_Wait3Label.gridy = 6;
		contentPane.add(Wait3Label, gbc_Wait3Label);
		
		GridBagConstraints gbc_StopLabel = new GridBagConstraints();
		gbc_StopLabel.gridwidth = 2;
		gbc_StopLabel.insets = new Insets(0, 0, 5, 5);
		gbc_StopLabel.gridx = 1;
		gbc_StopLabel.gridy = 7;
		contentPane.add(StopLabel, gbc_StopLabel);
		
		GridBagConstraints gbc_PauseButton = new GridBagConstraints();
		gbc_PauseButton.insets = new Insets(0, 0, 0, 5);
		gbc_PauseButton.gridx = 1;
		gbc_PauseButton.gridy = 8;
		contentPane.add(PauseButton, gbc_PauseButton);
		PauseButton.addActionListener(pauseListener);
		
		RunButton.setToolTipText("");
		GridBagConstraints gbc_RunButton = new GridBagConstraints();
		gbc_RunButton.insets = new Insets(0, 0, 0, 5);
		gbc_RunButton.gridx = 2;
		gbc_RunButton.gridy = 8;
		contentPane.add(RunButton, gbc_RunButton);
		RunButton.addActionListener(StartStopListner);
		
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
				thread.interrupt();
				runThread.stop();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		});
		
	}
	
	class RunThread implements Runnable{
		
		Thread RunThead;
	    private volatile boolean exit = false;
	    private volatile boolean paused = false;
		
		public RunThread() {}
		
		@Override
		public void run() {
			synchronized (commonObject) {
				bodyLoop:
				while(!exit) {
					//send 10 min waring
					if(exit) continue bodyLoop;
					sendMessage("shutting down in 10 min, let an admin know in discord if you need more time");
					Command1Label.setForeground(Wait1Label.getForeground());
					if(paused) {
						try {
							commonObject.wait();
						} catch (InterruptedException e) {
							Main.logger.LogDebug(e.toString(), Level.SEVERE);
						}
					}
				
					//wait 5 min
					Wait1Label.setForeground(Color.RED);
					for(int i = 1; i < 300; i++) {
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							Main.logger.LogDebug(e.toString(), Level.SEVERE);
						}
						if(paused) {
							try {
								commonObject.wait();
							} catch (InterruptedException e) {
								Main.logger.LogDebug(e.toString(), Level.SEVERE);
							}
						}
						if(exit) continue bodyLoop;
					}
					Wait1Label.setForeground(Command2Label.getForeground());
					
					//send 5 min message
					Command2Label.setForeground(Color.RED);
					if(exit) continue bodyLoop;
					sendMessage("shutting down dinos in 5 min, let an admin know in discord if you need more time");
					if(paused) {
						try {
							commonObject.wait();
						} catch (InterruptedException e) {
							Main.logger.LogDebug(e.toString(), Level.SEVERE);
						}
					}
					Command2Label.setForeground(Wait2Label.getForeground());
				
					//wait 2 min
					Wait2Label.setForeground(Color.RED);
					for(int i = 1; i < 120; i++) {
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							Main.logger.LogDebug(e.toString(), Level.SEVERE);
						}
						if(paused) {
							try {
								commonObject.wait();
							} catch (InterruptedException e) {
								Main.logger.LogDebug(e.toString(), Level.SEVERE);
							}
						}
						if(exit) continue bodyLoop;
					}
					Wait2Label.setForeground(Command3Label.getForeground());
					
					//send 3 min message
					Command3Label.setForeground(Color.RED);
					if(exit) continue bodyLoop;
					sendMessage("sutting down in 3 min, let an admin know in discord if you need more time");
					if(paused) {
						try {
							commonObject.wait();
						} catch (InterruptedException e) {
							Main.logger.LogDebug(e.toString(), Level.SEVERE);
						}
					}
					Command3Label.setForeground(Wait3Label.getForeground());
				
					//wait 3 min
					Wait3Label.setForeground(Color.RED);
					for(int i = 1; i < 180; i++) {
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							Main.logger.LogDebug(e.toString(), Level.SEVERE);
						}
						if(paused) {
							try {
								commonObject.wait();
							} catch (InterruptedException e) {
								Main.logger.LogDebug(e.toString(), Level.SEVERE);
							}
						}
						if(exit) continue bodyLoop;
					}
					Wait3Label.setForeground(StopLabel.getForeground());
					
					if (!Reference.MultipleServer) {
						try {
							RconHandler.command("saveworld");
							try {
								TimeUnit.SECONDS.sleep(30);
							} catch (InterruptedException e) {
							}
							RconHandler.command("kickallplayers");
							try {
								TimeUnit.SECONDS.sleep(30);
							} catch (InterruptedException e) {
							}
							RconHandler.MultipleCommand("doexit");
						} catch (IOException | AuthenticationException e) {
							Main.logger.LogDebug(e.toString(), Level.SEVERE);
						}
					} else {
						try {
							RconHandler.MultipleCommand("saveworld");
							try {
								TimeUnit.SECONDS.sleep(30);
							} catch (InterruptedException e) {
							}
							RconHandler.MultipleCommand("kickallplayers");
							try {
								TimeUnit.SECONDS.sleep(30);
							} catch (InterruptedException e) {
							}
							RconHandler.MultipleCommand("doexit");
						} catch (IOException | AuthenticationException e) {
							Main.logger.LogDebug(e.toString(), Level.SEVERE);
						}
					}
				}
				exit = true;
			}
		}
		
		public void stop() {
			exit = true;
		}
		
		public void pause() {
			paused = true;
		}
		
		public void unpause() {
			paused = false;
		}
		
		public boolean isPaused() {
			return paused;
		}
		
		private void sendMessage(String message) {
			if(!Reference.MultipleServer) {
				String result = null;
				try {
					result = RconHandler.command("broadcast " + message);
				} catch (IOException | AuthenticationException e) {
					Main.logger.LogDebug(e.toString(), Level.SEVERE);
				}
				System.out.println(result);
			} else {
				String result = null;
				try {
					result = RconHandler.MultipleCommand("broadcast " + message);
				} catch (IOException | AuthenticationException e) {
					Main.logger.LogDebug(e.toString(), Level.SEVERE);
				}
				System.out.println(result);
			}
		}
	}

}
