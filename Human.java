/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

public class Human {
    
    /*Initial ticket count of 10.*/
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
    public void purchaseCards(int cardsToPurchase, int cardCost) {
            ticketBank -= cardsToPurchase * cardCost;
            }
    }