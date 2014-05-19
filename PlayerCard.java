/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerCard extends Card {
    private final Bingo b;
    private final int NUMBER_OF_ROWS = 5;
    private final Random numberGenerator = new Random();
    private final JButton callButton = new JButton(new ImageIcon(getClass().getResource("/img/Card/Button.png")));
    private final JPanel callButtonPanel = new JPanel();
    private final CellMouseListener cellListener = new CellMouseListener();
    private final CallButtonMouseListener buttonListener = new CallButtonMouseListener();
    static int totalPlayerCards = 0;    
    private final JPanel bingoFeedbackPanel = new JPanel();
    private final JLabel freezeLabel = new JLabel("<html><center>PLACEHOLDER TEXT<br>Wait 5 seconds...</center><html>");
    private final JLabel winLabel = new JLabel("<html><center>PLACEHOLDER TEXT<br>You won!</center><html>");
    
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
	callButton.addMouseListener(buttonListener);
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
	    if (isValidBingo()) {
                b.decrementBingos(this);
                cardWin();
            }
            else {
                cardFreeze();
            }
	}
    }
    
    public void convertToLargeCard() {
	header.setIcon(new ImageIcon(getClass().getResource("/img/Card/CardHeader.jpg")));
	for (int row = 0; row < NUMBER_OF_ROWS; row++) {
	    for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
		cardLayout[row][column].convertToLargeCell();
	    }
	}

	cardLayout[2][2].convertToLargeCell();
	cardLayout[2][2].toggleToken();
	cardLayout[2][2].toggleToken();
	repaint();
    }
    
    private boolean isValidBingo() {
	boolean isValid = true; // Optimistic assumption

	//////////////////////// CHECKS VERTICAL BINGO ////////////////////////////
	for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {	// Iterate columns
	    isValid = true;	// Reset optimistic assumption for each column
	    for (int row = 0; row < NUMBER_OF_ROWS; row++) {		// Iterate rows
		if (!cardLayout[row][column].isMarked() || !b.isNumberCalled(cardLayout[row][column].getNumber())) {
		    isValid = false;
		    break;
		}
	    }
	    // This line executes after each bottom Cell has been checked AND after any row break.
	    if (isValid) {
		break;
	    }
	}

	if (!isValid) {
	    //////////////////////// CHECKS HORIZONTAL BINGO ////////////////////////////
	    for (int row = 0 ; row < NUMBER_OF_ROWS; row++) {			// Iterate rows
		isValid = true;   // Reset optimistic assumption for each row
		for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {	// Iterate columns
		    if (!cardLayout[row][column].isMarked() || !b.isNumberCalled(cardLayout[row][column].getNumber())) {
			isValid = false;
			break;
		    }
		}
		// This line executes after each right-most Cell has been checked AND after any column break.
		if (isValid) {
		    break;
		}
	    }
	}

	if (!isValid) {
	    if (cardLayout[0][0].isMarked() && cardLayout[1][1].isMarked() && cardLayout[3][3].isMarked() && cardLayout[4][4].isMarked() && b.isNumberCalled(new int[] {cardLayout[0][0].getNumber(), cardLayout[1][1].getNumber(), cardLayout[3][3].getNumber(), cardLayout[4][4].getNumber()})) { //CHECKS DIAGONAL LEFT -> RIGHT
		isValid = true;
	    }
	    else if (cardLayout[4][0].isMarked() && cardLayout[3][1].isMarked() && cardLayout[1][3].isMarked() && cardLayout[0][4].isMarked() && b.isNumberCalled(new int[] {cardLayout[4][0].getNumber(), cardLayout[3][1].getNumber(), cardLayout[1][3].getNumber(), cardLayout[0][4].getNumber()})) { //CHECKS DIAGONAL LEFT <- RIGHT
		isValid = true;
	    }
	    else if (cardLayout[0][0].isMarked() && cardLayout[0][4].isMarked() && cardLayout[4][0].isMarked() && cardLayout[4][4].isMarked() && b.isNumberCalled(new int[] {cardLayout[0][0].getNumber(), cardLayout[0][4].getNumber(), cardLayout[4][0].getNumber(), cardLayout[4][4].getNumber()})) { //CHECKS CORNERS
		isValid = true;
	    }
	}

	return isValid;
    }
    
    /*Dims card & disables input for 5 seconds.*/
    private void cardFreeze() {
	Thread freezeThread = new Thread(new FreezeCardTask());
	freezeThread.start();
    }
    
    /*Congratulates user & disables input on card.*/
    private void cardWin() {
        callButton.removeMouseListener(buttonListener);
	bingoFeedbackPanel.setPreferredSize(new Dimension(cellPanel.getWidth(), cellPanel.getHeight()));

	winLabel.setPreferredSize(new Dimension(cellPanel.getWidth(), cellPanel.getHeight()));
	winLabel.setBackground(new Color(212,175,55));
	winLabel.setOpaque(true);
	winLabel.setHorizontalAlignment(JLabel.CENTER);

	remove(cellPanel);
	add(bingoFeedbackPanel);
	bingoFeedbackPanel.add(winLabel);
	revalidate();
	repaint();
    }
    
    private class FreezeCardTask implements Runnable {
	@Override
	public void run() {
	    callButton.removeMouseListener(buttonListener);
	    bingoFeedbackPanel.setPreferredSize(new Dimension(cellPanel.getWidth(), cellPanel.getHeight()));
	    
	    freezeLabel.setPreferredSize(new Dimension(cellPanel.getWidth(), cellPanel.getHeight()));
	    freezeLabel.setBackground(Color.white);
	    freezeLabel.setOpaque(true);
	    freezeLabel.setHorizontalAlignment(JLabel.CENTER);

	    remove(cellPanel);
	    add(bingoFeedbackPanel);
	    bingoFeedbackPanel.add(freezeLabel);
	    revalidate();
	    repaint();

	    try {
		Thread.sleep(5000);
	    } catch (InterruptedException ex) {
            }

	    bingoFeedbackPanel.remove(freezeLabel);
	    remove(bingoFeedbackPanel);
	    add(cellPanel);
	    revalidate();
	    repaint();
	    
	    callButton.addMouseListener(buttonListener);
	}
    }
}