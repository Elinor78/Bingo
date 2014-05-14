/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.BorderLayout;
import static java.awt.Color.white;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PlayerCard extends Card {
    private final Bingo b;
    private final int NUMBER_OF_ROWS = 5;
    private final Random numberGenerator = new Random();
    private final JButton callButton = new JButton(new ImageIcon(getClass().getResource("/img/Card/Button.png")));
    private final JPanel callButtonPanel = new JPanel();
    private final CellMouseListener cellListener = new CellMouseListener();
    static int totalPlayerCards = 0;
    static boolean isLarge = false;
    final JPanel freezePanel = new JPanel();
	    
    public PlayerCard(Bingo b) {
	this.b = b;
	totalPlayerCards++;
	
	headerImg = new ImageIcon(getClass().getResource("/img/Card/CardHeader.jpg"));
	Image scaledImg = headerImg.getImage().getScaledInstance(205, 39, java.awt.Image.SCALE_SMOOTH);  
	headerImg = new ImageIcon(scaledImg);
	
	header.setIcon(headerImg);
	cellLayout.setRows(NUMBER_OF_ROWS);
	
	generateCardLayout();
	addCallButton();
    }
    
    public class freezeThread extends Thread {
        
    @Override
    public void run() {
        int tim = 5;
        long delay = 5000;
        
        PlayerCard.this.remove(cellPanel);
        freezePanel.setBackground(white);
        freezePanel.setPreferredSize( new Dimension( cellPanel.getWidth(), cellPanel.getHeight() ) );
        PlayerCard.this.add(freezePanel);
        System.out.println("In freeze panel");
        do{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PlayerCard.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(tim / 1);
            tim = tim - 1;
           delay = delay - 1000;
        }while (delay != 0);
        
        PlayerCard.this.remove(freezePanel);
        PlayerCard.this.add(cellPanel);
        
        System.out.println("end freeze panel");
    }
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
		cardLayout[row][column].addMouseListener(cellListener);
		cellPanel.add(cardLayout[row][column]);
	    }
	}
	
	// Create proper center cell
	cardLayout[2][2].setText("");
	cardLayout[2][2].setNumber(-1);
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
	    if( isValidBingo())
                cardWin();
            else
                cardFreeze();
	}
    }
    
    public void convertToLargeCard() {
	header.setIcon(new ImageIcon(getClass().getResource("/img/Card/CardHeader.jpg")));
	for (int row = 0; row < NUMBER_OF_ROWS; row++) {
	    for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
		cardLayout[row][column].convertToLargeCell();
	    }
	}
	isLarge = true;
	cardLayout[2][2].convertToLargeCell();
	cardLayout[2][2].toggleToken();
	cardLayout[2][2].toggleToken();
	repaint();
    }
    
    boolean isLargeCard(){
        return isLarge;
    }
    
    private boolean isValidBingo() {
        
        boolean isBingo = false;

        //////////////////////// CHECKS VERTICAL BINGO ////////////////////////////
        for( int j = 0 ; j < 5 ; j++ ){
            for( int i = 0 ; i < 5 ; i++){
                if( !cardLayout[i][j].isMarked() || !b.isNumberCalled(cardLayout[i][j].getNumber())){//<--checks if card is marked, 
                    isBingo = false;                                                                 //then takes the value in the cell and checks if that
                    break;                                                                           //number has been called or not
                }
                else
                    isBingo = true;
            }
            if( isBingo )
                break;
        }
        
        //////////////////////// CHECKS HORIZONTAL BINGO ////////////////////////////
        for( int i = 0 ; i < 5 ; i++ ){
            for( int j = 0 ; j < 5 ; j++){
                if( !cardLayout[i][j].isMarked() || !b.isNumberCalled(cardLayout[i][j].getNumber())){//<--same as above ^^^^
                    isBingo = false;
                    break;
                }
                else
                    isBingo = true;
            }
            if( isBingo )
                break;
        }
        
        //////////////////////// CHECKS DIAGONAL AND CORNER BINGOS ////////////////////////////
        if( !isBingo ){
            if( ( cardLayout[0][0].isMarked() && b.isNumberCalled(cardLayout[0][0].getNumber())) && 
                ( cardLayout[1][1].isMarked() && b.isNumberCalled(cardLayout[1][1].getNumber())) && 
                ( cardLayout[3][3].isMarked() && b.isNumberCalled(cardLayout[3][3].getNumber())) && 
                ( cardLayout[4][4].isMarked() && b.isNumberCalled(cardLayout[4][4].getNumber())))//CHECKS DIAGONAL LEFT -> RIGHT
                isBingo = true;
            else if(
                ( cardLayout[4][0].isMarked() && b.isNumberCalled(cardLayout[4][0].getNumber())) && 
                ( cardLayout[3][1].isMarked() && b.isNumberCalled(cardLayout[3][1].getNumber())) && 
                ( cardLayout[1][3].isMarked() && b.isNumberCalled(cardLayout[1][3].getNumber())) && 
                ( cardLayout[0][4].isMarked() && b.isNumberCalled(cardLayout[0][4].getNumber())))//CHECKS DIAGONAL LEFT <- RIGHT
                isBingo = true;
            else if( 
                ( cardLayout[0][0].isMarked() && b.isNumberCalled(cardLayout[0][0].getNumber())) && 
                ( cardLayout[0][4].isMarked() && b.isNumberCalled(cardLayout[0][4].getNumber())) && 
                ( cardLayout[4][0].isMarked() && b.isNumberCalled(cardLayout[4][0].getNumber())) && 
                ( cardLayout[4][4].isMarked() && b.isNumberCalled(cardLayout[4][4].getNumber())))//CHECKS CORNERS
                isBingo = true;
        }
        return isBingo;
    }
    
    /*Dims card & disables input for 5 seconds.*/
    private void cardFreeze() {
        System.out.println("Start cardFreeze()");
        (new freezeThread()).start();
        System.out.println("End cardFreeze()");
    }
    
    /*Congratulates user & disables input on card.*/
    private void cardWin() {
        //this.remove(cellPanel);
        System.out.println("In cardWin()");
    }
}