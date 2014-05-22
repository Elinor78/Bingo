
import java.util.ArrayList;

/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

public class Human {
    private int numberOfCards = 0;
    private final ArrayList<Integer> bankHistory= new ArrayList<>();
    
    public Human() {
	/*Initial ticket count of 20.*/
	bankHistory.add(20);
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
	System.out.println("I now have " + getCurrentBalance() + " tickets.");
    }
    
    public int getNumberOfCards() {
	return numberOfCards;
    }
   
}