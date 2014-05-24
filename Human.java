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
    private String name = null;
    //public ChoosePlayer choosePlayer;
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
	
	/*If a properties file exists in the user's home directory, use it. If not, just start off with 20 tickets.*/
	File propertiesFile = new File(System.getProperty("user.home") + "/bingo.properties");
	Properties ticketProperties = new Properties();
	InputStream ticketInputStream = null;
	OutputStream ticketOutputStream = null;
	
	try {
	    ticketInputStream = new FileInputStream(propertiesFile);
	    ticketProperties.load(ticketInputStream);

	    if (ticketProperties.isEmpty()) {
		throw Exception;
	    }
	    else if (ticketProperties.size() == 1) {
		playerNames = ticketProperties.stringPropertyNames();
		for (String tempName : playerNames) {
		    if (tempName.equals("Default")) {
			new NewPlayer(this);
			bankHistory.add(20);
		    }
		    else {
			name = tempName;
			bankHistory.add(Integer.parseInt(ticketProperties.getProperty(tempName)));
		    }
		}
	    }
	    else if (ticketProperties.size() > 1) {
		playerNames = ticketProperties.stringPropertyNames();
		new ChoosePlayer(this);
		if (ticketProperties.getProperty(name) == null) {
		    bankHistory.add(20);
		}
		else {
		    bankHistory.add(Integer.parseInt(ticketProperties.getProperty(name)));
		}
	    }
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