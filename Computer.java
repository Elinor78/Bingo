/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.util.Random;

public class Computer {
    static int NumComputerPlayers = 0;
    
    /*Instance variables*/
    private double responseTime;
    
    /*Default constructor calls generateResponseTime() & generateNumberOfCards() & increments totalCards.*/
    public Computer() {
        generateResponseTime();
        generateNumberOfCards();
	NumComputerPlayers++;
    }
    
    /*Randomly generates # of cards between 1 and 4.*/
    public final void generateNumberOfCards() {
        int numberOfCards = new Random().nextInt(4) + 1;   
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
