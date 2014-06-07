/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.io.*;
import java.util.Properties;

public class ShutDownTask {

    public ShutDownTask() {
	/*Locate the properties file and prepare streams.*/
	File propertiesFile = new File(System.getProperty("user.home") + "/bingo.properties");
	Properties ticketProperties = new Properties();
	InputStream ticketInputStream = null;
	OutputStream ticketOutputStream = null;
	/*Write the user's current balance to the associated property.*/
	try {
	    ticketInputStream = new FileInputStream(propertiesFile);
	    ticketProperties.load(ticketInputStream);
	    if (!Human.bankHistory.isEmpty()) {
		ticketProperties.setProperty(Human.name, String.valueOf(Shop.player.getCurrentBalance()));
	    }
	    /*If there are new players, write them to the file.*/
	    if (!ChoosePlayer.newPlayers.isEmpty()) {
		for (String newName : ChoosePlayer.newPlayers) {
		    /*Only add the name if it isn't the player that was actually used.*/
		    if (!newName.equals(Human.name) || Human.bankHistory.isEmpty()) {
			ticketProperties.setProperty(newName, String.valueOf(20));
		    }
		}
	    }
	    /*If there are deleted players, remove them from the file.*/
	    if (!ChoosePlayer.deletedPlayers.isEmpty()) {
		for (String deletedName : ChoosePlayer.deletedPlayers) {
		    if (!deletedName.equals(Human.name)) {
			ticketProperties.remove(deletedName);
		    }
		}
	    }
	    ticketOutputStream = new FileOutputStream(propertiesFile);
	    ticketProperties.store(ticketOutputStream, null);
	} catch (FileNotFoundException e) {
	    System.out.println("Could not write ticket balance. File Not Found");
	} catch (IOException ex) {
	    System.out.println("Could not write ticket balance. IO Exception");
	} finally {
	    try {
		/*Close Streams.*/
		if (ticketOutputStream != null) {
		    ticketOutputStream.close(); 
		}
		if (ticketInputStream != null) {
		    ticketInputStream.close();
		}
	    } catch (IOException ex) {
		System.out.println("Could not close output stream.");
	    }
	}
    }
}
