/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

public class MasterCard extends Card {
    private final int NUMBER_OF_ROWS = 15;
	    
    public MasterCard() {
	headerImg = new ImageIcon(getClass().getResource("/img/Card/CardHeader.jpg")); 
	Image scaledImg = headerImg.getImage().getScaledInstance(161, 30, java.awt.Image.SCALE_SMOOTH);  
	headerImg = new ImageIcon(scaledImg);  
	
	header.setIcon(headerImg);
	cellLayout.setRows(NUMBER_OF_ROWS);
	
	generateCardLayout();
    }
    
    @Override
    protected final void generateCardLayout() {
	cardLayout = new Cell[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
	
	// Add 75 cells with ascending number values. Cells are added from left to right, row by row.
	for (int row = 0, cellNumber = 1; row < NUMBER_OF_ROWS; row++, cellNumber -= 74) { // Iterates rows
	    for (int column = 0; column < NUMBER_OF_COLUMNS; column++, cellNumber += 15) { // Iterates columns
		cardLayout[row][column] = new Cell(cellNumber);
		cardLayout[row][column].setFontSize(16);
		cellPanel.add(cardLayout[row][column]);
	    }
	}
    }
    
    // Given a bingo number, mark the appropriate Cell in MasterCard.
    public void toggleToken(int number) {
	// Do this:
	//cardLayout[THE_RIGHT_ROW][THE_RIGHT_COLUMN].toggleToken();
	//
	// Example coordinates: 1 is [0][0]. 46 is [0][3].
	//
	// How to find out the right coordinates?
	//
	// if (n >= 1 && n <= 15)
	//      column is 0
	// else if (n <= 30)
	//      column is 1
	//etc.
	//
	// Then find the row.
	//
	// Or maybe use an array that holds the coordinates in an (n - 1) index. Faster.
    }
}