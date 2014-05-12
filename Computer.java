/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.util.Random;

public class Computer {
    static int totalComputerPlayers = 0;
    static int totalComputerCards = 0;
    
    /*Instance variables*/
    private double responseTime;
    private final ComputerCard[] cards;
    
    /*Default constructor calls generateResponseTime() & generateNumberOfCards() & increments totalCards.*/
    public Computer() {
        generateResponseTime();
        cards = generateComputerCards();
	totalComputerPlayers++;
    }
    
    /*Randomly generates # of cards between 1 and 4.*/
    private ComputerCard[] generateComputerCards() {
	int numberOfCards = new Random().nextInt(4) + 1;
	ComputerCard[] temp = new ComputerCard[numberOfCards];
	
	for (int i = 0; i < numberOfCards; i++) {
	    temp[i] = new ComputerCard();
	}
	
	return temp;
    }
    
    /*Randomly generates # of seconds between 0 and 3.*/
    private void generateResponseTime() {
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
    
    public void receiveNewNumber(int n) {
	for (ComputerCard card : cards) {
	    if (!card.isBingo()) {
		card.markAndCall(n);
	    }
	}
    }
    
    private class ComputerCard {
	private boolean isBingo = false;
	// Something that stores the numbers
	// Something that stores whether a given number is marked or not
	
	private ComputerCard() {
	    totalComputerCards++;
	    // Generate random numbers
	}
	
	public boolean isBingo() {
	    return isBingo;
	}
	
	public void markAndCall(int n) {
	// For efficiency, search only the column that "n" could possibly be in, and mark if found.
	// Then, search the entire card for the any valid bingo pattern.
	// If bingo, set isBingo to true and decrement the number of bingos available.
	}
    }
}
