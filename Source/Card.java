/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

package Source;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Abstract class defines common elements of MasterCard and PlayerCard.
public abstract class Card extends JPanel {
    // Top "BINGO" header
    ImageIcon headerImg;
    final JLabel header = new JLabel();
    
    // JPanel with GridLayout to hold undefined number of Cells
    final GridLayout cellLayout = new GridLayout();
    final JPanel cellPanel = new JPanel(cellLayout);
    
    // MasterCard and PlayerCard are both 5 columns wide
    final int NUMBER_OF_COLUMNS = 5;
    Cell cardLayout[][];
    
    // Card gets and stores game font so that each individual Cell doesn't have to search the computer or load from file.
    static final Font cellFont = BingoGUI.getGameFont();
     
    public Card() {
	this.setLayout(new BorderLayout());
	this.add(header, BorderLayout.NORTH);
	
	// Add panel for Cells, undefined number of rows.
	cellLayout.setColumns(5);
	this.add(cellPanel);
	
	this.setOpaque(false);
    }
    
    // Abstract method for adding the proper number of cells, numbers, cell behavior.
    protected abstract void generateCardLayout();
}