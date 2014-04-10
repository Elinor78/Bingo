/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.*;
import java.util.Timer;
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
    
    static int totalCards = 0;
     
    public Card() {
	this.setLayout(new BorderLayout());
	this.add(header, BorderLayout.NORTH);
	
	// Add panel for Cells, undefined number of rows.
	cellLayout.setColumns(5);
	this.add(cellPanel);
    }
    
    // Abstract method for adding the proper number of cells, numbers, cell behavior.
    protected abstract void generateCardLayout();
    
    // Method for Cells to retrieve game font without numerously pinging the operating system.
    public static Font getCellFont() {
	return cellFont;
    }
    
    public void checkForBingo(){
        
        boolean isBingo = false;
        
        //////////////////////// CHECKS VERTICAL BINGO ////////////////////////////
        for( int i = 0 ; i < 5 ; i++ ){
            for( int j = 0 ; j < 5 ; j++){
                if(!cardLayout[i][j] ){
                    isBingo = false;
                    break;
                }
                else
                    isBingo = true;
            }
            if(isBingo)
                break;
        }
        if(!isBingo){
        //////////////////////// CHECKS HORIZONTAL BINGO ////////////////////////////
        for( int j = 0 ; j < NUMBER_OF_COLUMNS ; j++ ){
            for( int i = 0 ; i < NUMBER_OF_COLUMNS ; i++){
                if(!cardLayout[i][j] ){
                    isBingo = false;
                    break;
                }
                else
                    isBingo = true;
            }
            if(isBingo)
                break;
        }
        }
        
        if(!isBingo){//IF THERE HAS BEEN A BINGO SKIP OVER
            if( cardLayout[0][0] && cardLayout[1][1] && cardLayout[3][3] && cardLayout[4][4])//CHECKS DIAGONAL LEFT -> RIGHT
                isBingo = true;
            else if( cardLayout[4][0] && cardLayout[3][1] && cardLayout[1][3] && cardLayout[0][4] )//CHECKS DIAGONAL LEFT <- RIGHT
                isBingo = true;
            else if( cardLayout[0][0] && cardLayout[0][4] && cardLayout[4][0] && cardLayout[4][4] )//CHECKS CORNERS
                isBingo = true;
        }
        
        if(isBingo)
            cardWin();
        else
            cardFreeze();
    }
    
    public void cardWin(){
        //winPanel.setVisible(true);
    }
    
    public void cardFreeze(){
        //freezePanel.setVisible(true);
        
        //Timer timer = new Timer();
        //timer.schedule(null, 5000);
       
        //freezePanel.setVisible(false);
    }
}