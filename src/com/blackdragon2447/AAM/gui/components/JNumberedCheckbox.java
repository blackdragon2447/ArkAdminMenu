package com.blackdragon2447.AAM.gui.components;

import java.io.Serializable;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBox;

/**
 * the JNumberedCheckbox is a a version of {@link JCheckBox} that can be numbered.
 * @author Blackdragon2447
 */
public class JNumberedCheckbox extends JCheckBox implements Serializable{


	private static final long serialVersionUID = 1L;
	public int Number;
	
	 public JNumberedCheckbox () {
	        super(null, null, false);
	    }


	    public JNumberedCheckbox(Icon icon) {
	        super(null, icon, false);
	    }


	    public JNumberedCheckbox(Icon icon, boolean selected) {
	        super(null, icon, selected);
	    }


	    public JNumberedCheckbox (String text) {
	        super(text, null, false);
	    }


	    public JNumberedCheckbox(Action a) {
	        this();
	        setAction(a);
	    }



	    public JNumberedCheckbox (String text, boolean selected) {
	        super(text, null, selected);
	    }


	    public JNumberedCheckbox(String text, Icon icon) {
	        super(text, icon, false);
	    }
	    
		public JNumberedCheckbox (int number) {
	        super(null, null, false);
			this.Number = number;
	    }


		public JNumberedCheckbox(Icon icon, int number) {
			super(null, icon, false);
			this.Number = number;
		}
	

	    public JNumberedCheckbox(Icon icon, boolean selected, int number) {
	        super(null, icon, selected);
			this.Number = number;
	    }
	

	    public JNumberedCheckbox (String text, int number) {
	        super(text, null, false);
			this.Number = number;
	    }
	

	    public JNumberedCheckbox(Action a, int number) {
	        this();
	        setAction(a);
			this.Number = number;
	    }
	
	

	    public JNumberedCheckbox (String text, boolean selected, int number) {
	        super(text, null, selected);
			this.Number = number;
	    }
	

	    public JNumberedCheckbox(String text, Icon icon, int number) {
	        super(text, icon, false);
			this.Number = number;
	    }

		public void setNumber(int number) {
			this.Number = number;
		}
		
		public int getNumber() {
			return this.Number;
		}

}
