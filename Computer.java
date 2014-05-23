/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.Timer;

public class Computer {
    /*Class variables*/
    static int totalComputerPlayers = 0;
    static int totalComputerCards = 0;
    
    /*Instance variables*/
    private int responseTime;
    private final ComputerCard[] cards;
    private final Bingo b;
    private final LimitedQueue numberQueue = new LimitedQueue(7);
    private final Timer callNumberTimer;
    private final numberReader readNumber = new numberReader();
    
    /*Default constructor calls generateResponseTime() & generateNumberOfCards() & increments totalCards.*/
    public Computer(Bingo b) {
	this.b = b;
        generateResponseTime();
	callNumberTimer = new Timer(responseTime, readNumber);
        cards = generateComputerCards();
	totalComputerPlayers++;
    }
    
    /*Randomly generates # of cards between 1 and 4.*/
    private ComputerCard[] generateComputerCards() {
        final int MAX_CARDS = 4;
	final int MIN_CARDS = 1;
	
	int numberOfCards = new Random().nextInt(MAX_CARDS) + MIN_CARDS;
	ComputerCard[] temp = new ComputerCard[numberOfCards];
	
	for (int i = 0; i < numberOfCards; i++) {
	    temp[i] = new ComputerCard();
	}
	
	return temp;
    }
    
    /*Randomly generates # of milliseconds between 1000 and 6000.*/
    private void generateResponseTime() {
        responseTime = (int)((Math.random() * (5000)) + 1000);
    }
    
    /*Returns the response time.*/
    public double getResponseTime() {
        return responseTime;
    }
    
    public void receiveNewNumber(int n) {
	numberQueue.offer(n);
	callNumberTimer.start();
    }
    
    
    private class numberReader implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent evt) {
	    int numberBeingRead = (int)numberQueue.poll();

	    for (ComputerCard card : cards) {
		if (card != null && !card.isBingo()) {
		    card.markCard(numberBeingRead);
		    
		    // if some dice roll based on the number of marks and cards is satisfied...
		    card.checkValidBingo();
		}
		else {
		    card = null;
		}
	    }

	    callNumberTimer.stop();
	}
    }
    
    private class LimitedQueue<E> extends LinkedList<E> {
	private final int limit;

	public LimitedQueue(int limit) {
	    this.limit = limit;
	}

	@Override
	public boolean add(E o) {
	    super.add(o);
	    
	    while (size() > limit) {
		super.remove();
	    }
	    
	    return true;
	}
    }
    
    final class ComputerCard {
	private final int NUMBER_OF_COLUMNS = 5;
	private final int NUMBER_OF_ROWS = 5;
	private final int CELL_VALUE = 0;
	private final int CELL_MARKED = 1;
	private final int FALSE = 0;
	private final int TRUE = 1;
	private final int B_COLUMN = 0;
	private final int I_COLUMN = 1;
	private final int N_COLUMN = 2;
	private final int G_COLUMN = 3;
	private final int O_COLUMN = 4;
	private final int B_COLUMN_END = 15;
	private final int I_COLUMN_END = 30;
	private final int N_COLUMN_END = 45;
	private final int G_COLUMN_END = 60;
	private int numberOfMarks = 0;
	private final Random numberGenerator = new Random();
	private boolean isBingo = false;
	private final int[][][] card = new int[NUMBER_OF_COLUMNS][NUMBER_OF_ROWS][2];
	
	private ComputerCard() {
	    totalComputerCards++;
	    generateRandomNumbers();
	}
	
	public void generateRandomNumbers() {
	   
	    // Generate random numbers
	    for (int row = 0, columnLowerBound = 1; row < NUMBER_OF_ROWS; row++, columnLowerBound = 1) { // Iterates rows
		for (int column = 0; column < NUMBER_OF_COLUMNS; column++, columnLowerBound += 15) { // Iterates columns
		    int numberCandidate;
		    boolean numberAlreadyExists;
		    // Attempt to place a unique number
		    do {
		    // Get random number with range of 15 and lowest possible number columnLowerBound
			numberCandidate = numberGenerator.nextInt(14) + columnLowerBound; 
			numberAlreadyExists = false; // Assume that number has not already been picked.
		    // Check all cells above the cell currently being created
			for (int rowCheck = 0; rowCheck < row; rowCheck++) {
			    if (numberCandidate == card[rowCheck][column][CELL_VALUE]) {
			    numberAlreadyExists = true;
			    }
			}
		    } while (numberAlreadyExists);
		    
		    card[row][column][CELL_VALUE] = numberCandidate;
		}
	    }
	    card[N_COLUMN][2][CELL_MARKED] = TRUE;
	    
	}
	
	private void markCard(int n) {
	    int column;
	    /*Determine the column so there is less looping.*/
	    if (n<= B_COLUMN_END) {
		column = B_COLUMN;
	    }
	    else if (n<= I_COLUMN_END) {
		column = I_COLUMN;
	    }
	    else if (n<= N_COLUMN_END) {
		column = N_COLUMN;
	    }
	    else if (n<= G_COLUMN_END) {
		column = G_COLUMN;
	    }
	    else {
		column = O_COLUMN;
	    }
	    /*Loop through each row on the column to mark matched values.*/
	    for (int row = 0; row < NUMBER_OF_ROWS; row++) {
		if (card[row][column][CELL_VALUE] == n) {
		    card[row][column][CELL_MARKED] = TRUE;
		    numberOfMarks++;
		    return;
		}
	    }
	    
	}
	
	private void checkValidBingo() {
	    boolean validPatternFound = true;
	
	    //////////////////////// CHECKS VERTICAL BINGO ////////////////////////////
	    for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {	// Iterate columns
		validPatternFound = true;	// Reset optimistic assumption for each column
		for (int row = 0; row < NUMBER_OF_ROWS; row++) {		// Iterate rows
		    if (card[column][row][CELL_MARKED] == FALSE) {
			validPatternFound = false;
			break;
                }
            }
	    // This line executes after each bottom Cell has been checked AND after any row break.
		if (validPatternFound) {
		    callBingo();
		    break;
		}
	    }
	
	    if (!validPatternFound) {
		validPatternFound = true; // Reset optimistic valid pattern assumption
		//////////////////////// CHECKS HORIZONTAL BINGO ////////////////////////////
		for (int row = 0 ; row < NUMBER_OF_ROWS; row++) {			// Iterate rows
		    validPatternFound = true;   // Reset optimistic assumption for each row
		    for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {	// Iterate columns
			if (card[column][row][CELL_MARKED] == FALSE) {
			    validPatternFound = false;
			    break;
			}
		    }
		    // This line executes after each right-most Cell has been checked AND after any column break.
		    if (validPatternFound) {
			callBingo();
			break;
		    }
		}	
	    }   

	    if (!validPatternFound) {
		/*Check Diagonal and Four Corners Bingos*/
		/*Diagonal left to right.*/
		if( 
		    (card[B_COLUMN][0][CELL_MARKED] == TRUE) && 
		    (card[I_COLUMN][1][CELL_MARKED] == TRUE) && 
		    (card[G_COLUMN][3][CELL_MARKED] == TRUE) && 
		    (card[O_COLUMN][4][CELL_MARKED] == TRUE)) {
		    callBingo();
		}
		/*Diagonal right to left.*/
		else if(
		    (card[O_COLUMN][0][CELL_MARKED] == TRUE) && 
		    (card[G_COLUMN][1][CELL_MARKED] == TRUE) && 
		    (card[I_COLUMN][3][CELL_MARKED] == TRUE) && 
		    (card[B_COLUMN][4][CELL_MARKED] == TRUE)) {
		    callBingo();
		}
		/*Four corners.*/
		else if( 
		    (card[B_COLUMN][0][CELL_MARKED] == TRUE) && 
		    (card[B_COLUMN][4][CELL_MARKED] == TRUE) && 
		    (card[O_COLUMN][0][CELL_MARKED] == TRUE) && 
		    (card[O_COLUMN][4][CELL_MARKED] == TRUE)) {
		    callBingo();
		}
	    }
	}
	
	private void callBingo() {
	    this.isBingo = true;
	    totalComputerCards--;
	    b.decrementBingos(this);
	}

	private boolean isBingo() {
	    return isBingo;
	}
	
	private int getNumberOfMarks() {
	    return numberOfMarks;
	}
	
	private void printWinningCard() {
	    System.out.println("Response time: " + responseTime);
	    System.out.println("B\tI\tN\tG\tO");
	    for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
		for (int row = 0; row < NUMBER_OF_ROWS; row++) {
		    System.out.print(card[column][row][CELL_VALUE] + " ");
		    String marked = (card[column][row][CELL_MARKED] == 1) ? "*" : "";
		    System.out.print(marked + "\t");
		}
		System.out.println();
		System.out.println("-----------------------------------");
		
	    }
	    System.out.println();
	}
	
    } // end ComputerCard
} // end Computer