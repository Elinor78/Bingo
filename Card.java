/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Card extends JPanel {
    ImageIcon headerImg;
    final JLabel header = new JLabel();
    
    final GridLayout cellLayout = new GridLayout();
    final JPanel cellPanel = new JPanel(cellLayout);
    
    final int NUMBER_OF_COLUMNS = 5;
    Cell cardLayout[][];
    
    static final Font cellFont = BingoGUI.getGameFont();
    static int totalCards = 0;
     
    public Card() {
	this.setLayout(new BorderLayout());
	this.add(header, BorderLayout.NORTH);
	
	cellLayout.setColumns(5);
	this.add(cellPanel);
    }
    
    protected abstract void generateCardLayout();
    
    public static Font getCellFont() {
	return cellFont;
    }
}