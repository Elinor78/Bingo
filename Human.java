/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import javax.swing.JOptionPane;

public class Human extends Player{
    
    /*Instance variables*/
    private int ticketBank;
    
    /*Default constructor w/ 1 card, increments totalCards & totalPlayers.*/
    public Human() {
        totalPlayers++;
        /*Addes a new PlayerCard object to the playerCards ArrayList.*/
        playerCards.add(new PlayerCard());
    }
    
    /*Constructor to start human player with tickets.*/
    public Human(int initialTicketBank) {
        this();
        ticketBank = initialTicketBank;
    }
    
    /*Change value of ticketBank in positive or negative values.*/
    public void setTicketBank(int amountOfTickets) {
        ticketBank += amountOfTickets;
    }
    
    /*Retrieve value of ticketBank.*/
    public int getTicketBank() {
        return ticketBank;
    }
    
    /*Adds cards to playerCards ArrayList and adjusts ticketBank.*/
    public void purchaseCards(int amountOfCards) {
        if (amountOfCards < ticketBank) {
            for (int i = 0; i < amountOfCards; i++) {
                playerCards.add(new PlayerCard());
                ticketBank--;
            }
        }
        else
            JOptionPane.showMessageDialog(null, "You do not have enough tickets", "Insufficient Funds", JOptionPane.OK_OPTION);
    }
    
}
