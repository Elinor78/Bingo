/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

public class Computer extends Player {
    
    /*Instance variables*/
    private double responseTime;
    
    /*Default constructor calls generateResponseTime() & generateNumberOfCards() & increments totalCards.*/
    public Computer() {
        generateResponseTime();
        generateNumberOfCards();
        Card.totalCards++;
    }
    
    /*Randomly generates # of cards between 1 and 4.*/
    public final void generateNumberOfCards() {
        int numberOfCards = (int)((Math.random() * (4 - 1)) + 1);
        for (int i = 0; i < numberOfCards; i++) {
            playerCards.add(new Card());
        }
    }
    
    /*Randomly generates # of seconds between 0 and 3.*/
    public final void generateResponseTime() {
        responseTime = ((Math.random() * (4 - 1)) + 1);
    }
    
    /*Set the response time.*/
    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }
    
    /*Returns the response time.*/
    public double getResponseTime() {
        return responseTime;
    } 
}
