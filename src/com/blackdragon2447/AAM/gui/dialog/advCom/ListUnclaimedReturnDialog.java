package com.blackdragon2447.AAM.gui.dialog.advCom;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.blackdragon2447.AAM.Reference;
import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.util.RconHandler;

import net.kronos.rkon.core.ex.AuthenticationException;

public class ListUnclaimedReturnDialog extends JFrame {
	static final long serialVersionUID = -7969913714004038511L;
	private JPanel contentPane;
	JTextArea ResponseLabel;
	RefreshThread refreshThread = new RefreshThread();
	Thread thread = new Thread(refreshThread);

	/**
	 * the method for opening the gui
	 */
	public static void createGui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListUnclaimedReturnDialog frame = new ListUnclaimedReturnDialog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * the constructor: build the gui
	 */
	public ListUnclaimedReturnDialog() {
		
		try {
			UIManager.setLookAndFeel(AAMGui.getLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		String result = null;
		if(!Reference.MultipleServer) {
			try {
				result = RconHandler.command("ListUnclaimedDinos");
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
				result = RconHandler.MultipleCommand("ListUnclaimedDinos");
			} catch (Exception e1) {
				if(e1 instanceof AuthenticationException) result = "failed to autheticate";
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
		

		ResponseLabel = new JTextArea(result);
		ResponseLabel.setEditable(false);
		GridBagConstraints gbc_ResponseLabel = new GridBagConstraints();
		gbc_ResponseLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ResponseLabel.gridx = 1;
		gbc_ResponseLabel.gridy = 1;
		contentPane.add(ResponseLabel, gbc_ResponseLabel);
		
		setBounds(getBounds().x, getBounds().y, getBounds().width, 20 * ResponseLabel.getLineCount());
		
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
	
	class RefreshThread implements Runnable{
		
		Thread RefreshThead;
	    private volatile boolean exit = false;
		
		public RefreshThread() {}
		
		@Override
		public void run() {
			
			while(!exit) {
				String result = null;
				if(!Reference.MultipleServer) {
					try {
						result = RconHandler.command("ListUnclaimedDinos");
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
						result = RconHandler.MultipleCommand("ListUnclaimedDinos");
					} catch (Exception e1) {
						if(e1 instanceof AuthenticationException) result = "failed to autheticate";
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
				
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ResponseLabel.setText(result);
				setBounds(getBounds().x, getBounds().y, getBounds().width, 20 * ResponseLabel.getLineCount());
			}
			
		}
		
		public void stop() {
			exit = true;
		}
	}

}
