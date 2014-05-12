/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
import javax.swing.*;

public class BingoGUI extends JFrame {
    private final JLabel backgroundJL = new JLabel(new ImageIcon(getClass().getResource("/img/BingoGUI/Background.gif")));
    private final JPanel masterCardPanel = new JPanel(new BorderLayout());
    private final JPanel cardPanel = new JPanel();
    private final GridBagConstraints pcUpperLeft, pcUpperRight, pcLowerLeft, pcLowerRight;
    private final JPanel statusPanel = new JPanel();
    private final MasterCard mc = new MasterCard();
    private final BallTicker bt = new BallTicker();
    private final StatusWindow sw;
    //private final ExecutorService executor = Executors.newCachedThreadPool();
    
    public BingoGUI(Bingo b) {	
	backgroundJL.setLayout(new GridBagLayout());
	GridBagConstraints mainFrameConstraint = new GridBagConstraints();
	
	// Place JPanel to hold master card
	masterCardPanel.setPreferredSize(new Dimension(162, 364));
	mainFrameConstraint.insets = new Insets(-23, -16, 0, 25);
	mainFrameConstraint.gridx = 0;
	backgroundJL.add(masterCardPanel, mainFrameConstraint);
	
	// Place master card in masterCardPanel
	masterCardPanel.add(mc);
	
	// Place JPanel to hold player card(s)
	cardPanel.setPreferredSize(new Dimension(434, 515));
	cardPanel.setOpaque(false);
	mainFrameConstraint.insets = new Insets(25, 0, 0, 37);
	mainFrameConstraint.gridx = 1;
	backgroundJL.add(cardPanel, mainFrameConstraint);
	
	// Set layout for cardPanel
	cardPanel.setLayout(new GridBagLayout());
	
	pcUpperLeft = new GridBagConstraints();
	pcUpperLeft.gridx = 0;
	pcUpperLeft.gridy = 0;
	pcUpperLeft.insets = new Insets(5, 5, 5, 5);
	
	pcUpperRight = new GridBagConstraints();
	pcUpperRight.gridx = 1;
	pcUpperRight.gridy = 0;
	pcUpperRight.insets = new Insets(5, 5, 5, 5);
	
	pcLowerLeft = new GridBagConstraints();
	pcLowerLeft.gridx = 0;
	pcLowerLeft.gridy = 1;
	pcLowerLeft.insets = new Insets(5, 5, 5, 5);
	
	pcLowerRight = new GridBagConstraints();
	pcLowerRight.gridx = 1;
	pcLowerRight.gridy = 1;
	pcLowerRight.insets = new Insets(5, 5, 5, 5);
	
	if (Bingo.player.getNumberOfCards() == 1) {
	    PlayerCard bigCard = new PlayerCard(b);
	    bigCard.convertToLargeCard();
	    cardPanel.add(bigCard);
	}
	else {
	    GridBagConstraints[] orderOfCardInsertion = {pcUpperLeft, pcUpperRight, pcLowerLeft, pcLowerRight};
	
	    for (int i = 0; i < Bingo.player.getNumberOfCards(); i++) {
		cardPanel.add(new PlayerCard(b), orderOfCardInsertion[i]);
	    }
	}
	
	// Place JPanel to hold number ticker & bingo status window
	statusPanel.setPreferredSize(new Dimension(268, 295));
	statusPanel.setBackground(new Color(0,0,0,90)); // Delete this line when no longer needed
	mainFrameConstraint.insets = new Insets(61, 0, 0, 0);
	mainFrameConstraint.gridx = 2;
	backgroundJL.add(statusPanel, mainFrameConstraint);
	
	// Set layout for statusPanel
	statusPanel.setLayout(new GridBagLayout());
	
	GridBagConstraints statusTop = new GridBagConstraints();
	statusTop.gridy = 0;
	GridBagConstraints statusMiddle = new GridBagConstraints();
	statusMiddle.gridy = 1;
	GridBagConstraints statusBottom = new GridBagConstraints();
	statusBottom.gridy = 2;
	
	// Add BallTicker to statusPanel
	statusPanel.add(bt, statusTop);
	
	// Add StatusWindow to statusPanel
	sw = new StatusWindow(b);
	statusPanel.add(sw, statusMiddle);
	
	// Add everything to Jframe and set static size
	this.add(backgroundJL);
	this.setSize(1000, 576);
	
	// Set some default properties
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    // Updates all necessary GUI objects to display newly-called numbers.
    public void showNewNumber(int n) {
	//executor.execute(new BallTickerNewNumberTask(n));
	bt.addBall(n);
	mc.toggleToken(n);
    }
    
    /*
    Returns a font to use for GUI elements.
    First tries to get pre-installed Cooper Black font.
    If not found, loads Cooper Black from .TTF file.
    If all else fails, uses Impact font.
    Font is returned at 1-point size.
    */
    public static Font getGameFont() {
	GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = g.getAllFonts();
	for (Font font : fonts) {
	    if (font.getFontName().equals("Cooper Black")) {
		return font;
	    }
	}
	
	try {
	    InputStream cooperFromFile = BingoGUI.class.getResourceAsStream("/fonts/COOPBL.TTF");
	    return Font.createFont(Font.TRUETYPE_FONT, cooperFromFile);
	}
	catch (FontFormatException | IOException ex) {
	    return new Font("Impact", Font.PLAIN, 1);
	}
    }
    
    /*
    // Task for adding a new Ball to BallTicker without needing to wait for animation to finish.
    private class BallTickerNewNumberTask implements Runnable {
	private final int newNumber;
	
	private BallTickerNewNumberTask (int n) {
	    newNumber = n;
	}
	
	@Override
	public void run() {
	    bt.addBall(newNumber);
	}
    }
    */
}