/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import javax.swing.JOptionPane;

public class Human {
    
    /*Initial ticket count of 10.*/
    private int ticketBank = 10;
    
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
    public void purchaseCards(int cardsToPurchase) {
        if (cardsToPurchase < ticketBank) {
            ticketBank -= cardsToPurchase;
            }
        else
            JOptionPane.showMessageDialog(null, "You do not have enough tickets", "Insufficient Funds", JOptionPane.OK_OPTION);
    }
    
}
