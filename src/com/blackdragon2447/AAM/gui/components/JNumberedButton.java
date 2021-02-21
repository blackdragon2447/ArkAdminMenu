package com.blackdragon2447.AAM.gui.components;

import java.beans.ConstructorProperties;

import javax.swing.Icon;
import javax.swing.JButton;

public class JNumberedButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int number;
	
	public JNumberedButton() {
        super(null, null);
    }

    /**
     * Creates a button with an icon.
     *
     * @param icon  the Icon image to display on the button
     */
    public JNumberedButton(Icon icon) {
        super(null, icon);
    }

    /**
     * Creates a button with text.
     *
     * @param text  the text of the button
     */
    @ConstructorProperties({"text"})
    public JNumberedButton(String text) {
        super(text, null);
    }
    
    public JNumberedButton(int number) {
        super(null, null);
        this.number = number;
    }

    /**
     * Creates a button with an icon.
     *
     * @param icon  the Icon image to display on the button
     */
    public JNumberedButton(Icon icon, int number) {
        super(null, icon);
        this.number = number;
    }

    /**
     * Creates a button with text.
     *
     * @param text  the text of the button
     */
    @ConstructorProperties({"text"})
    public JNumberedButton(String text, int number) {
        super(text, null);
        this.number = number;
    }
    
    public void setNumber(int number) {
    	this.number = number;
    }
    
    public int getNumber() {
    	return this.number;
    }


}
