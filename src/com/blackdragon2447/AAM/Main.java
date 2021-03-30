package com.blackdragon2447.AAM;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

import com.blackdragon2447.AAM.gui.AAMGui;
import com.blackdragon2447.AAM.gui.auth.LoginDialog;
import com.blackdragon2447.AAM.util.CSVReader;
import com.blackdragon2447.AAM.util.CreatureSetBuilder;
import com.blackdragon2447.AAM.util.ItemSetBuilder;
import com.blackdragon2447.AAM.util.Pair;
import com.blackdragon2447.AAM.util.logger.AAMLogger;
import com.blackdragon2447.AAM.util.obj.auth.Account;
import com.blackdragon2447.AAM.util.tools.AccountMaker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * the main class of AAM
 * 
 * AAM is an acronym for ArkAdminMenu
 * AAM is a tool for ark server admins to execute advanced commands remotely and save custom commands
 * to make the process of entering/using commands faster and easier
 * @author Blackdragon2447
 * @version 0.1
 *
 */

public class Main {

	public static Boolean firstRun = true;
	public static AAMLogger logger;
	@SuppressWarnings("unused")
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException{
		try {
			if(args[1] != null) {
				AccountMaker.CreateGui();
				TimeUnit.HOURS.sleep(1);
			}
		} catch (Exception e) {}
		
		String systemipaddress = ""; 
        try{ 
            URL url_name = new URL("http://bot.whatismyipaddress.com"); 
  
            BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream())); 
  
            systemipaddress = sc.readLine().trim(); 
        } catch (Exception e) { 
            systemipaddress = "Cannot Execute Properly"; 
        } 
		
		logger = new AAMLogger(Level.INFO, Level.ALL, Boolean.valueOf(args[0]));
		
		FileHandler UserFileHandler = new FileHandler("UserLog.txt");
		FileHandler DebugFileHandler = new FileHandler("DebugLog.txt");
		
		logger.AddFileHandlerUser(UserFileHandler);
		logger.AddFileHandlerDebug(DebugFileHandler);
		
		logger.LogDebug("Starting Debug Log", Level.INFO);
		logger.LogUser("Starting new session at: " + systemipaddress, Level.INFO);
		
		try (BufferedInputStream in = new BufferedInputStream(new URL("https://github.com/blackdragon2447/ArkAdminMenu/releases/download/latest/AAMUpdater.exe").openStream());
			FileOutputStream fileOutputStream = new FileOutputStream("AAMUpdater(new).exe")) {
			    byte dataBuffer[] = new byte[1024];
			    int bytesRead;
			    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
			        fileOutputStream.write(dataBuffer, 0, bytesRead);
			    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file = null;
		file = new File("AAMUpdater.exe");
		File file2 = new File("AAMUpdater(new).exe");
		
		byte[] f1 = null;
		try {
			f1 = Files.readAllBytes(file.toPath());
		}catch (Exception e) {
			e.printStackTrace();
			firstRun = true;
		}
		
		if (firstRun) {
			//Files.copy(file2.toPath(), new File("AAMUpdater.exe").toPath());
			f1 = Files.readAllBytes(file.toPath());
		}
		byte[] f2 = Files.readAllBytes(file2.toPath());
				
		if (!(Arrays.equals(f1, f2))) {
			
			if(JOptionPane.showConfirmDialog(null, "a new update is available, do you wanna update?") == 0) {
				file.delete();
				file2.renameTo(file);
				ProcessBuilder pb = new ProcessBuilder("AAMUpdater.exe");
				pb.directory(new File(System.getProperty("user.dir")));
				Process p = pb.start();
				System.exit(0);
			}
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader("Users.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	GsonBuilder builder = new GsonBuilder();
				Gson gson = builder.create();
				
				Account user = gson.fromJson(line, Account.class);
		    	Reference.Logins.add(user);
		    }
		}
		
		//LoginDialog.createGui();
		Reference.currentUser = new Account(null, null, null, true);
		
		/**
		 * this piece of the code will import any files needed to run before opening the actual GUI to prevent delay
		 * because of loading in code
		 */
		
		CSVReader Reader = new CSVReader();
		try {
			Reference.SimpleCommandList = CSVReader.readCommandList("simpleCommands.csv");
			Reference.SimpleCommandArgList = CSVReader.readArgList("simpleCommandsArgs.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File dir = new File("ItemLists");
		String[] ItemFileList = dir.list();
		
		Pair<String, ArrayList<Pair<String, String>>> pair ;
		
		for (String string : ItemFileList) {
			try {
				pair = ItemSetBuilder.generatePair(string.substring(0, string.length() - 4), "ItemLists\\" + string);
				Reference.ImportedItemGroups.add(ItemSetBuilder.generatePair(string.substring(0, string.length() - 4), "ItemLists\\" + string));
			} catch (IOException e) {
				if(!(e instanceof FileNotFoundException))
					e.printStackTrace();
			}
		}
		
		File dir2 = new File("CreatureLists");
		String[] DinoFileList = dir2.list();
		
		
		for (String string2 : DinoFileList) {
			try {
				Reference.ImportedCreatureGroups.add(CreatureSetBuilder.generatePair(string2.substring(0, string2.length() - 4), "CreatureLists\\" + string2));
			} catch (IOException e) {
					e.printStackTrace();
			}
		}
		
		/**
		 * this code opens the GUI and would react to any thrown errors.
		 */
		
		try {
			AAMGui.createGui();
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}


	}

}
