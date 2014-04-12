/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
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
    
    private boolean isBingo;
	    
    public PlayerCard() {
	totalCards++;
	
	headerImg = new ImageIcon(getClass().getResource("/img/Card/CardHeader.jpg"));
	
	if (totalCards > 1) {
	    // Make small card
	    this.setPreferredSize(new Dimension(205, 228));
	    
	    Image scaledImg = headerImg.getImage().getScaledInstance(205, 39, java.awt.Image.SCALE_SMOOTH);  
	    headerImg = new ImageIcon(scaledImg);  
	}
	else {
	    // Make large card
	    this.setPreferredSize(new Dimension(375, 418));
	}
	
	int height = this.getPreferredSize().height;
	
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

		cardLayout[row][column].setFontSize(20);
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
	    System.out.println("I'm calling BINGO. This will call isValidBingo().");
	}
    }
    
    /*Sets isBingo to true. No point in allowing a card to be set from true to false.*/
    private void setIsBingo() {
        this.isBingo = true;
    }
    
    /*Returns the value of isbingo.*/
    public boolean getIsBingo() {
        return isBingo;
    }
    
    /*Scans cardLayout for valid Bingo and sets isBingo to true if valid. 
    Calls cardFreeze() or cardWin()? */
    private boolean isValidBingo() {
        if (/*the claim is*/ true) {
	    return true;
	}
	else {
	 return false;   
	}
    }
    
    /*Dims card & disables input for 5 seconds.*/
    private void cardFreeze() {
        
    }
    
    /*Congratulates user & disables input on card.*/
    private void cardWin() {
        
    }
}