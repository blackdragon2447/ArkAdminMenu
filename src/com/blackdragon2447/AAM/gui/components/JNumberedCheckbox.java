package com.blackdragon2447.AAM.gui.components;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBox;

public class JNumberedCheckbox extends JCheckBox{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int number;
	
	 public JNumberedCheckbox () {
	        super(null, null, false);
	    }

	    /**
	     * Creates an initially unselected check box with an icon.
	     *
	     * @param icon  the Icon image to display
	     */
	    public JNumberedCheckbox(Icon icon) {
	        super(null, icon, false);
	    }

	    /**
	     * Creates a check box with an icon and specifies whether
	     * or not it is initially selected.
	     *
	     * @param icon  the Icon image to display
	     * @param selected a boolean value indicating the initial selection
	     *        state. If <code>true</code> the check box is selected
	     */
	    public JNumberedCheckbox(Icon icon, boolean selected) {
	        super(null, icon, selected);
	    }

	    /**
	     * Creates an initially unselected check box with text.
	     *
	     * @param text the text of the check box.
	     */
	    public JNumberedCheckbox (String text) {
	        super(text, null, false);
	    }

	    /**
	     * Creates a check box where properties are taken from the
	     * Action supplied.
	     *
	     * @param a the {@code Action} used to specify the new check box
	     * @since 1.3
	     */
	    public JNumberedCheckbox(Action a) {
	        this();
	        setAction(a);
	    }


	    /**
	     * Creates a check box with text and specifies whether
	     * or not it is initially selected.
	     *
	     * @param text the text of the check box.
	     * @param selected a boolean value indicating the initial selection
	     *        state. If <code>true</code> the check box is selected
	     */
	    public JNumberedCheckbox (String text, boolean selected) {
	        super(text, null, selected);
	    }

	    /**
	     * Creates an initially unselected check box with
	     * the specified text and icon.
	     *
	     * @param text the text of the check box.
	     * @param icon  the Icon image to display
	     */
	    public JNumberedCheckbox(String text, Icon icon) {
	        super(text, icon, false);
	    }
	    
		public JNumberedCheckbox (int number) {
	        super(null, null, false);
			this.number = number;
	    }

		    /**
		     * Creates an initially unselected check box with an icon.
		     *
		     * @param icon  the Icon image to display
		     */
		public JNumberedCheckbox(Icon icon, int number) {
			super(null, icon, false);
			this.number = number;
		}
	
	    /**
	     * Creates a check box with an icon and specifies whether
	     * or not it is initially selected.
	     *
	     * @param icon  the Icon image to display
	     * @param selected a boolean value indicating the initial selection
	     *        state. If <code>true</code> the check box is selected
	     */
	    public JNumberedCheckbox(Icon icon, boolean selected, int number) {
	        super(null, icon, selected);
			this.number = number;
	    }
	
	    /**
	     * Creates an initially unselected check box with text.
	     *
	     * @param text the text of the check box.
	     * @param number 
	     */
	    public JNumberedCheckbox (String text, int number) {
	        super(text, null, false);
			this.number = number;
	    }
	
	    /**
	     * Creates a check box where properties are taken from the
	     * Action supplied.
	     *
	     * @param a the {@code Action} used to specify the new check box
	     * @param number 
	     * @since 1.3
	     */
	    public JNumberedCheckbox(Action a, int number) {
	        this();
	        setAction(a);
			this.number = number;
	    }
	
	
	    /**
	     * Creates a check box with text and specifies whether
	     * or not it is initially selected.
	     *
	     * @param text the text of the check box.
	     * @param selected a boolean value indicating the initial selection
	     *        state. If <code>true</code> the check box is selected
	     * @param number 
	     */
	    public JNumberedCheckbox (String text, boolean selected, int number) {
	        super(text, null, selected);
			this.number = number;
	    }
	
	    /**
	     * Creates an initially unselected check box with
	     * the specified text and icon.
	     *
	     * @param text the text of the check box.
	     * @param icon  the Icon image to display
	     * @param number 
	     */
	    public JNumberedCheckbox(String text, Icon icon, int number) {
	        super(text, icon, false);
			this.number = number;
	    }

		public void setNumber(int number) {
			this.number = number;
		}
		
		public int getNumber() {
			return this.number;
		}

}
