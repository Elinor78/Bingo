/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerCard extends Card {
    private final Bingo bingo;
    private final NewBingoNotification newBingo;
    private final BingoGUI gui;
    private final int NUMBER_OF_ROWS = 5;
    private final JButton callButton = new JButton(new ImageIcon(getClass().getResource("/img/Card/Button.png")));
    private final CallButtonMouseListener buttonListener = new CallButtonMouseListener();  
    private final JPanel bingoFeedbackPanel = new JPanel();
    private final JLabel freezeLabel = new JLabel();
    private Font freezeFont = getFreezeFont().deriveFont(35f);
    
    public PlayerCard(Bingo b, NewBingoNotification n, BingoGUI g) {
	this.bingo = b;
	this.newBingo = n;
	this.gui = g;
	gui.totalPlayerCards++;
	
	headerImg = new ImageIcon(getClass().getResource("/img/Card/CardHeader.jpg"));
	Image scaledImg = headerImg.getImage().getScaledInstance(205, 39, java.awt.Image.SCALE_SMOOTH);  
	headerImg = new ImageIcon(scaledImg);
	
	header.setIcon(headerImg);
	cellLayout.setRows(NUMBER_OF_ROWS);
	
	generateCardLayout();
	addCallButton();
	
	// Make the cell cursor
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Image cursorImage = new ImageIcon(this.getClass().getResource("/img/Card/PlayerCard/Dauber.png")).getImage();
	Cursor cursor = toolkit.createCustomCursor(cursorImage, new Point(0, 0), "Dauber");
	cellPanel.setCursor(cursor);
    }
    
    @Override
    protected final void generateCardLayout() {
	Random numberGenerator = new Random();
	CellMouseListener cellListener = new CellMouseListener();
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
	
	JPanel callButtonPanel = new JPanel();
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
	    if ( isValidBingo() ) {
                bingo.decrementBingos(this);
		
		int ticketsToAward;
		if (bingo.getBonusTicketsLeft() >= 0) {
		    ticketsToAward = 3;
		}
		else {
		    ticketsToAward = 2;
		}
		
		Shop.player.setTicketBank(ticketsToAward);
		Shop.player.addTicketsWonInLatestRound(ticketsToAward);
		
		newBingo.currentBingoNumber++;
		
		gui.totalPlayerCards--;
	
		if (gui.totalPlayerCards == 0) {
		    
		    bingo.signalNoBingosLeft();
		}

                cardWin();
            }
            else {
		System.out.println("Total Player Cards = " + gui.totalPlayerCards);
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
        freezeFont = getFreezeFont().deriveFont(70f);
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
		if (!cardLayout[row][column].isMarked() || !bingo.isNumberCalled(cardLayout[row][column].getNumber())) {
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
		    if (!cardLayout[row][column].isMarked() || !bingo.isNumberCalled(cardLayout[row][column].getNumber())) {
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
	    if (cardLayout[0][0].isMarked() && cardLayout[1][1].isMarked() && cardLayout[3][3].isMarked() && cardLayout[4][4].isMarked() && bingo.isNumberCalled(new int[] {cardLayout[0][0].getNumber(), cardLayout[1][1].getNumber(), cardLayout[3][3].getNumber(), cardLayout[4][4].getNumber()})) { //CHECKS DIAGONAL LEFT -> RIGHT
		isValid = true;
	    }
	    else if (cardLayout[4][0].isMarked() && cardLayout[3][1].isMarked() && cardLayout[1][3].isMarked() && cardLayout[0][4].isMarked() && bingo.isNumberCalled(new int[] {cardLayout[4][0].getNumber(), cardLayout[3][1].getNumber(), cardLayout[1][3].getNumber(), cardLayout[0][4].getNumber()})) { //CHECKS DIAGONAL LEFT <- RIGHT
		isValid = true;
	    }
	    else if (cardLayout[0][0].isMarked() && cardLayout[0][4].isMarked() && cardLayout[4][0].isMarked() && cardLayout[4][4].isMarked() && bingo.isNumberCalled(new int[] {cardLayout[0][0].getNumber(), cardLayout[0][4].getNumber(), cardLayout[4][0].getNumber(), cardLayout[4][4].getNumber()})) { //CHECKS CORNERS
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
    
    private Font getFreezeFont() {
	GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();

	try {
	    InputStream getIgloo = BingoGUI.class.getResourceAsStream("/fonts/IGLOO.TTF");
	    Font iglooFromFile = Font.createFont(Font.TRUETYPE_FONT, getIgloo);
	    g.registerFont(iglooFromFile);

	    return iglooFromFile;
	}
	catch (FontFormatException | IOException ex) {
	    return new Font("Impact", Font.PLAIN, 1);
	}
    }
    
    /*Congratulates user & disables input on card.*/
    private void cardWin() {
	JLabel winLabel = new JLabel();
   
        callButton.removeMouseListener( buttonListener );
	bingoFeedbackPanel.setPreferredSize( new Dimension(cellPanel.getWidth(), cellPanel.getHeight()));
     
	winLabel.setPreferredSize( new Dimension( cellPanel.getWidth(), cellPanel.getHeight() ));
        
        ImageIcon winImg;
        winImg = new ImageIcon(getClass().getResource( "/img/Card/PlayerCard/CardWin.jpg" ));
	Image scaledImg = winImg.getImage().getScaledInstance( cellPanel.getWidth(), cellPanel.getHeight(), java.awt.Image.SCALE_SMOOTH);  
	winImg = new ImageIcon( scaledImg );
        winLabel.setIcon( winImg );

	remove( cellPanel );
	add( bingoFeedbackPanel );
	bingoFeedbackPanel.add( winLabel );
	
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
            
            //Sets freeze Image
            ImageIcon freezeImg;
            freezeImg = new ImageIcon(getClass().getResource("/img/Card/PlayerCard/FrozenCard.jpg"));
	    Image scaledImg = freezeImg.getImage().getScaledInstance( cellPanel.getWidth(), cellPanel.getHeight(), java.awt.Image.SCALE_SMOOTH);  
	    freezeImg = new ImageIcon(scaledImg);
            freezeLabel.setIcon(freezeImg);
            
            //Sets labels text information
            freezeLabel.setFont(freezeFont);
            freezeLabel.setForeground( new Color( 97, 97, 97 ));
            freezeLabel.setVerticalTextPosition(JLabel.CENTER);
            freezeLabel.setHorizontalTextPosition(JLabel.CENTER);

	    remove(cellPanel);
	    add(bingoFeedbackPanel);
	    bingoFeedbackPanel.add(freezeLabel);
	    freezeLabel.setText("<html></html>");
	    revalidate();
	    repaint();

	    int timeLeft = 5000;
	    int countDown = 5;
	    
	    do{
		try {
		    freezeLabel.setText("<html><center>Card Frozen<br>0:0" + countDown + "</center></html>");
		    Thread.sleep( 1000 );
		    countDown--;
		} catch (InterruptedException ex) {
		}
		timeLeft -= 1000;
	    }while ( timeLeft != 0);
  
	    //Puts number grid back up
	    bingoFeedbackPanel.remove(freezeLabel);
	    remove(bingoFeedbackPanel);
	    add(cellPanel);
	    revalidate();
	    repaint();
	    
	    callButton.addMouseListener(buttonListener);
	}
    }
}