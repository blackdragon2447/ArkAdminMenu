package com.blackdragon2447.AAM.gui.dialog.advCom;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.blackdragon2447.AAM.gui.AAMGui;

public class SteamIDReturnDialog extends JFrame {
static final long serialVersionUID = -7969913714004038511L;
	private JPanel contentPane;

	
	public static void createGui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SteamIDReturnDialog frame = new SteamIDReturnDialog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SteamIDReturnDialog() {
		
		try {
			UIManager.setLookAndFeel(AAMGui.getLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel ResponseLabel = new JLabel("this isnt done yet");
		GridBagConstraints gbc_ResponseLabel = new GridBagConstraints();
		gbc_ResponseLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ResponseLabel.gridx = 1;
		gbc_ResponseLabel.gridy = 1;
		contentPane.add(ResponseLabel, gbc_ResponseLabel);
	}

}
