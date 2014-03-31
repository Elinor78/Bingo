/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;

public class PlayerCard extends Card {
    private final int NUMBER_OF_ROWS = 5;
    Random numberGenerator = new Random();
    
    private boolean isBingo;
	    
    public PlayerCard() {
	headerImg = new ImageIcon(getClass().getResource("/img/Card/CardHeader.jpg"));
	header.setIcon(headerImg);
	cellLayout.setRows(NUMBER_OF_ROWS);
	
	generateCardLayout();
	
	totalCards++;
    }
    
    @Override
    protected final void generateCardLayout() {
	cardLayout = new Cell[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
	
	for (int row = 0, columnLowerBound = 1; row < NUMBER_OF_ROWS; row++, columnLowerBound = 1) {
	    for (int column = 0; column < NUMBER_OF_COLUMNS; column++, columnLowerBound += 15) {
		int numberCandidate;
		boolean numberAlreadyExists;
		
		// Attempt to place a unique number
		do {
		   numberCandidate = numberGenerator.nextInt(14) + columnLowerBound;
		   numberAlreadyExists = false;
		    // Check all cells above cell being created
		    for (int rowCheck = 0; rowCheck < row; rowCheck++) {
			if (numberCandidate == Integer.parseInt(cardLayout[rowCheck][column].getText())) {
			    numberAlreadyExists = true;
			}
		    } 
		} while (numberAlreadyExists);
	
		cardLayout[row][column] = new Cell(numberCandidate);

		//cardLayout[row][column].setFontSize(30);
		cardLayout[row][column].addMouseListener(new CellMouseListener());
		cellPanel.add(cardLayout[row][column]);
	    }
	}
	
	// Create proper center cell
	cardLayout[2][2].setText("");
	cardLayout[2][2].toggleToken();
	cardLayout[2][2].removeMouseListener(cardLayout[2][2].getMouseListeners()[0]);
    }
    
    private class CellMouseListener extends MouseAdapter {
	@Override
	public void mousePressed(MouseEvent e) {
	    ((Cell)e.getSource()).toggleToken();
	}
    }
    
    /*Sets isBingo to true. No point in allowing a card to be set from true to false.*/
    public void setIsBingo() {
        this.isBingo = true;
    }
    
    /*Returns the value of isbingo.*/
    public boolean getIsBingo() {
        return isBingo;
    }
    
    /*Scans cardLayout for valid Bingo and sets isBingo to true if valid.*/
    public boolean isValidBingo() {
        if (/*the claim is*/ true) {
	    return true;
	}
	else {
	 return false;   
	}
    }
    
    /*Dims card & disables input for 5 seconds.*/
    public void cardFreeze() {
        
    }
    
    /*Congratulates user & disables input on card.*/
    public void cardWin() {
        
    }
}