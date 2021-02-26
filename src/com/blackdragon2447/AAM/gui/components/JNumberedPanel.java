package com.blackdragon2447.AAM.gui.components;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.io.Serializable;

import javax.accessibility.Accessible;
import javax.swing.JPanel;

public class JNumberedPanel extends JPanel implements Accessible, Serializable{

	private static final long serialVersionUID = 1L;
	private int number;
	
	public JNumberedPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public JNumberedPanel(LayoutManager layout) {
        this(layout, true);
    }

    public JNumberedPanel(boolean isDoubleBuffered) {
        this(new FlowLayout(), isDoubleBuffered);
    }

    public JNumberedPanel() {
        this(true);
    }
    

	public JNumberedPanel(LayoutManager layout, boolean isDoubleBuffered, int Number) {
        super(layout, isDoubleBuffered);
        this.number = Number;
    }

    public JNumberedPanel(LayoutManager layout, int Number) {
        this(layout, true);
        this.number = Number;
    }

    public JNumberedPanel(boolean isDoubleBuffered, int Number) {
        this(new FlowLayout(), isDoubleBuffered);
        this.number = Number;
    }

    public JNumberedPanel(int Number) {
        this(true);
        this.number = Number;
    }
    
    public int getNumber() {
		return number;
	}
    
    public void setNumber(int number) {
		this.number = number;
	}

    
	
	
}
