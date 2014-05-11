/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

public class Human {
    private int numberOfCards = 0;
    /*Initial ticket count of 20.*/
    private int ticketBank = 20;
    
    /*Default constructor increments totalPlayers.*/
    public Human() {
        Bingo.totalPlayers++;
    }
    
    /*Change value of ticketBank in positive or negative values.*/
    public void setTicketBank(int amountOfTickets) {
        ticketBank += amountOfTickets;
    }
    
    /*Retrieve value of ticketBank.*/
    public int getTicketBank() {
        return ticketBank;
    }
    
    /*Adjusts ticketBank.*/
    public void purchaseCards(int numberOfCards, int cardCost) {
	ticketBank -= numberOfCards * cardCost;
	this.numberOfCards = numberOfCards;
    }
    
    public int getNumberOfCards() {
	return numberOfCards;
    }
}