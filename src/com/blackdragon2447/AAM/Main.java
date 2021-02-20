package com.blackdragon2447.AAM;

import java.lang.reflect.InvocationTargetException;

import javax.swing.UnsupportedLookAndFeelException;

import com.blackdragon2447.AAM.gui.AAMGui;

/**
 * the main class of AAM
 * 
 * AAM is an acronym for ArkAdminMenu
 * AAM is a tool for ark server admins to execute advanced commands remotely and save custom commands
 * to make the process of entering/using commands faster and easyer
 * @author Blackdragon2447
 * @version 0.1
 *
 */

public class Main {
	

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		AAMGui.createGui();
		System.out.print("done");

	}

}
