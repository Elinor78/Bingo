/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Human {
    private int numberOfCards = 0;
    private final ArrayList<Integer> bankHistory= new ArrayList<>();
    private int ticketsWonInLatestRound = 0;
    private Set<String> playerNames;
    private ChoosePlayer choosePlayer;
    private String name = null;
    private Exception Exception;
    
    public Human() {
	
	initiatePlayer();
    }
    
    /*Change value of ticketBank in positive or negative values.*/
    public void setTicketBank(int amountOfTickets) {
	bankHistory.add(getCurrentBalance() + amountOfTickets);
    }
    
    /*Retrieve value of ticketBank.*/
    public int getCurrentBalance() {
        return bankHistory.get(bankHistory.size() - 1);
    }
    
    public int getLatestWinnings() {
	if (bankHistory.size() > 1) {
	    final int latestWinnings = getCurrentBalance() - bankHistory.get(bankHistory.size() - 2);
	    return latestWinnings > 0 ? latestWinnings : 0;
	}
	else
	    return 0;
    }
    
    /*Adjusts ticketBank.*/
    public void purchaseCards(int cards, int cardCost) {
	bankHistory.add(getCurrentBalance() - (cards * cardCost));
	this.numberOfCards = cards;
    }
    
    public int getNumberOfCards() {
	return this.numberOfCards;
    }
    
    public void addTicketsWonInLatestRound(int t) {
	ticketsWonInLatestRound += t;
    }
    
    public void resetTicketsWonInLatestRound() {
	ticketsWonInLatestRound = 0;
    }
    
    public int getTicketsWonInLatestRound() {
	return ticketsWonInLatestRound;
    }
    
    public void setName(String n) {
	this.name = n;
    }
    
    public String getName() {
	return name;
    }
    
    public Set<String> getPlayerNames() {
	return playerNames;
    }

    private void initiatePlayer() {
	
	/*Locate the properties file and prepare streams.*/
	File propertiesFile = new File(System.getProperty("user.home") + "/bingo.properties");
	Properties ticketProperties = new Properties();
	InputStream ticketInputStream = null;
	OutputStream ticketOutputStream = null;
	
	try {
	    /*Load the properties.*/
	    ticketInputStream = new FileInputStream(propertiesFile);
	    ticketProperties.load(ticketInputStream);
	    
	    /*If there are no properties, head on to the Catch where a brand new properties file is created.*/
	    if (ticketProperties.isEmpty()) {
		throw Exception;
	    }
	    /*If there is one property and it's name is "Default", create a new player with 20 tickets.*/
	    else if (ticketProperties.size() == 1) {
		playerNames = ticketProperties.stringPropertyNames();
		for (String tempName : playerNames) {
		    if (tempName.equals("Default")) {
			new NewPlayer(this);
			bankHistory.add(20);
		    }
		    /*If it's name is something else, use that name and retrieve its tickets.*/
		    else {
			name = tempName;
			bankHistory.add(Integer.parseInt(ticketProperties.getProperty(tempName)));
		    }
		}
	    }
	    /*If there is more than 1 property, open the choose player dialog and if the chosen name had no ticket value, give them 20.*/
	    else if (ticketProperties.size() > 1) {
		playerNames = ticketProperties.stringPropertyNames();
		choosePlayer = new ChoosePlayer(this);
		if (ticketProperties.getProperty(name) == null) {
		    bankHistory.add(20);
		}
		/*Otherwise give them what they had in the properties file.*/
		else {
		    bankHistory.add(Integer.parseInt(ticketProperties.getProperty(name)));
		}
		/*If a few different new players were created but not used in the game, keep the names anyway.*/
		if (!choosePlayer.getNewPlayers().isEmpty()) {
		    ticketOutputStream = new FileOutputStream(propertiesFile);
		    for (String newName : choosePlayer.getNewPlayers()) {
			ticketProperties.setProperty(newName, String.valueOf(20));
		    }
		    ticketProperties.store(ticketOutputStream, null);
		    ticketOutputStream.close();
		}
	    }
	    /*Create a new properties file from scratch.*/
	} catch (Exception e) {
	    try {
		ticketOutputStream = new FileOutputStream(propertiesFile);
		ticketProperties.setProperty("Default", String.valueOf(20));
		ticketProperties.store(ticketOutputStream, null);
		ticketInputStream = new FileInputStream(propertiesFile);
		ticketProperties.load(ticketInputStream);
		playerNames = ticketProperties.stringPropertyNames();
		new NewPlayer(this);
		bankHistory.add(20);
	    } catch (FileNotFoundException ex) {
		Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (IOException ex) {
		Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	finally {
	    try {
		/*Close the streams.*/
		if (ticketInputStream != null) {
		   ticketInputStream.close(); 
		}
		if (ticketOutputStream != null) {
		    ticketOutputStream.close();
		}
	    } catch (IOException ex) {
		System.out.println("Couldn't close the properties input and/or output stream.");
	    }
	}
    }
   
}