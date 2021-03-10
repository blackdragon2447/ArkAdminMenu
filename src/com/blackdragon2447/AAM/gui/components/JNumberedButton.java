package com.blackdragon2447.AAM.gui.components;

import java.awt.event.ActionListener;
import java.beans.ConstructorProperties;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 * the JNumberedButton is a a version of {@link JButton} that can be numbered
 * @author Blackdragon2447
 */
public class JNumberedButton extends JButton implements Cloneable{

	private static final long serialVersionUID = 1L;
	public int Number;
	

    @ConstructorProperties({"text"})
    public JNumberedButton(String text, int number) {
        super(text, null);
        this.Number = number;
    }
	
	public JNumberedButton() {
        super(null, null);
    }

    public JNumberedButton(Icon icon) {
        super(null, icon);
    }

    @ConstructorProperties({"text"})
    public JNumberedButton(String text) {
        super(text, null);
    }
    
    public JNumberedButton(int number) {
        super(null, null);
        this.Number = number;
    }

    public JNumberedButton(Icon icon, int number) {
        super(null, icon);
        this.Number = number;
    }

    
    public JNumberedButton(ActionListener actioListner, int number) {
    	super(null, null);
    	this.Number = number;
    	addActionListener(actioListner);
    	
    }
    
    public JNumberedButton(String text, ActionListener actioListner, int number) {
    	super(text, null);
    	this.Number = number;
    	addActionListener(actioListner);
    	
    }
    
    public JNumberedButton(JButton button, int number) {
    	super(button.getText(), button.getIcon());
    	this.Number = number;
    	ActionListener[] listners = button.getActionListeners();
    	for(ActionListener ActtioListner : listners) {
    		addActionListener(ActtioListner);
    	}
    	setBounds(button.getBounds());
    }
    
    @Override
	public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public void setNumber(int number) {
    	this.Number = number;
    }
    
    public int getNumber() {
    	return this.Number;
    }


}
