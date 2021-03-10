package com.blackdragon2447.AAM.gui.components;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * a limitor for textfield length
 * @author Blackdragon2447
 */
public class JTextFieldLimit extends PlainDocument {

	private static final long serialVersionUID = -3756897035798057855L;
	
	private int limit;
	  public JTextFieldLimit(int limit) {
	    super();
	    this.limit = limit;
	  }

	  JTextFieldLimit(int limit, boolean upper) {
	    super();
	    this.limit = limit;
	  }

	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	    if (str == null)
	      return;

	    if ((getLength() + str.length()) <= limit) {
	      super.insertString(offset, str, attr);
	    }
	  }
}
