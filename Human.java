
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

public class Human {
    private int numberOfCards = 0;
    private final ArrayList<Integer> bankHistory= new ArrayList<>();
    private int ticketsWonInLatestRound = 0;
    final String name = null;
    
    public Human() {
	/*If a properties file exists in the user's home directory, use it. If not, just start off with 20 tickets.*/
	Properties ticketProperties = new Properties();
	InputStream ticketInputStream = null;
	try {
	    ticketInputStream = new FileInputStream(new File(System.getProperty("user.home") + "/bingo.properties"));
	    ticketProperties.load(ticketInputStream);
	    bankHistory.add(Integer.parseInt(ticketProperties.getProperty("Tickets")));
	} catch (IOException | NumberFormatException e) {
	    System.out.println("Couldn't load the file.");
	    bankHistory.add(20);
	}
	finally {
	    try {
		if (ticketInputStream != null) {
		   ticketInputStream.close(); 
		}
	    } catch (IOException ex) {
		System.out.println("Couldn't close the properties input stream.");
	    }
	}
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
	return numberOfCards;
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
   
}