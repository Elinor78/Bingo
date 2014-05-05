/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PlayerCard extends Card {
    private final int NUMBER_OF_ROWS = 5;
    private final Random numberGenerator = new Random();
    private final JButton callButton = new JButton(new ImageIcon(getClass().getResource("/img/Card/Button.png")));
    private final JPanel callButtonPanel = new JPanel();
    
    private boolean isBingo = false;
	    
    public PlayerCard() {
	totalCards++;
	
	headerImg = new ImageIcon(getClass().getResource("/img/Card/CardHeader.jpg"));
	
	if (totalCards > 1) {
	    // Make small card
	    Image scaledImg = headerImg.getImage().getScaledInstance(205, 39, java.awt.Image.SCALE_SMOOTH);  
	    headerImg = new ImageIcon(scaledImg);  
	}
	
	header.setIcon(headerImg);
	cellLayout.setRows(NUMBER_OF_ROWS);
	
	generateCardLayout();
	addCallButton();
    }
    
    @Override
    protected final void generateCardLayout() {
	cardLayout = new Cell[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
	
	// Cells are added from left to right, row by row.
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
			if (numberCandidate == cardLayout[rowCheck][column].getNumber()) {
			    numberAlreadyExists = true;
			}
		    }
		} while (numberAlreadyExists);
	
		cardLayout[row][column] = new Cell(numberCandidate);

		//cardLayout[row][column].setFontSize(20);
		cardLayout[row][column].addMouseListener(new CellMouseListener());
		cellPanel.add(cardLayout[row][column]);
	    }
	}
	
	// Create proper center cell
	cardLayout[2][2].setText("");
	cardLayout[2][2].toggleToken();
	cardLayout[2][2].removeMouseListener(cardLayout[2][2].getMouseListeners()[0]);
    }
    
    private void addCallButton() {
	callButton.setContentAreaFilled(false);
	callButton.setBorder(null);
	callButton.addMouseListener(new CallButtonMouseListener());
	callButtonPanel.add(callButton);
	callButtonPanel.setOpaque(false);
	this.add(callButtonPanel, BorderLayout.SOUTH);
    }
    
    private class CellMouseListener extends MouseAdapter {
	@Override
	public void mousePressed(MouseEvent e) {
	    ((Cell)e.getSource()).toggleToken();
	}
    }
    
    private class CallButtonMouseListener extends MouseAdapter {
	@Override
	public void mousePressed(MouseEvent e) {
	    System.out.println("Valid pattern? " + isValidBingo());
	}
    }
    
    /*Returns the value of isbingo.*/
    public boolean getIsBingo() {
        return isBingo;
    }
    
    /*Scans cardLayout for valid Bingo and sets isBingo to true if valid. 
    Calls cardFreeze() or cardWin()? */
    private boolean isValidBingo() {
	boolean isValidBingo = false;
	boolean validPatternFound = true;
	
        //////////////////////// CHECKS VERTICAL BINGO ////////////////////////////
        for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {	// Iterate columns
	    validPatternFound = true;	// Reset optimistic assumption for each column
            for (int row = 0; row < NUMBER_OF_ROWS; row++) {		// Iterate rows
                if (!cardLayout[row][column].isMarked()) {
                    validPatternFound = false;
                    break;
                }
            }
	    // This line executes after each bottom Cell has been checked AND after any row break.
	    if (validPatternFound) {
		break;
	    }
        }
	
	if (!validPatternFound) {
	    validPatternFound = true; // Reset optimistic valid pattern assumption
	    //////////////////////// CHECKS HORIZONTAL BINGO ////////////////////////////
	    for (int row = 0 ; row < NUMBER_OF_ROWS; row++) {			// Iterate rows
		validPatternFound = true;   // Reset optimistic assumption for each row
		for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {	// Iterate columns
		    if (!cardLayout[row][column].isMarked()) {
			validPatternFound = false;
			break;
		    }
		}
		// This line executes after each right-most Cell has been checked AND after any column break.
		if (validPatternFound) {
		    break;
		}
	    }
	}
        
        if (!validPatternFound) {
            if (cardLayout[0][0].isMarked() && 
		cardLayout[1][1].isMarked() && 
		cardLayout[3][3].isMarked() && 
		cardLayout[4][4].isMarked()) //CHECKS DIAGONAL LEFT -> RIGHT
		    validPatternFound = true;
            else if (cardLayout[4][0].isMarked() && 
		cardLayout[3][1].isMarked() && 
		cardLayout[1][3].isMarked() && 
		cardLayout[0][4].isMarked()) //CHECKS DIAGONAL LEFT <- RIGHT
		    validPatternFound = true;
            else if (cardLayout[0][0].isMarked() && 
		cardLayout[0][4].isMarked() && 
		cardLayout[4][0].isMarked() && 
		cardLayout[4][4].isMarked()) //CHECKS CORNERS
		    validPatternFound = true;
        }
	
	/*
	// If valid pattern has been found, check that those numbers have been called
	if (validPatternFound) {
	    // check the numbers
	}
	*/
        
        return validPatternFound;
    }
    
    /*Dims card & disables input for 5 seconds.*/
    private void cardFreeze() {
        //freezePanel.setVisible(true);
        
        //Timer timer = new Timer();
        //timer.schedule(null, 5000);
       
        //freezePanel.setVisible(false);
    }
    
    /*Congratulates user & disables input on card.*/
    private void cardWin() {
        //winPanel.setVisible(true);
    }
}