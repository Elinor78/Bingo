/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BingoGUI extends JFrame {
    private static Font gameFont;
    private final ImageIcon background = new ImageIcon(getClass().getResource("/img/BingoGUI/Background.gif"));
    private final JLabel backgroundJL = new JLabel(background);
    private final JPanel masterCardPanel = new JPanel(new BorderLayout());
    private final JPanel cardPanel = new JPanel();
    private final GridBagConstraints mcUpperLeft, mcUpperRight, mcLowerLeft, mcLowerRight;
    private final JPanel statusPanel = new JPanel();
    private final MasterCard mc = new MasterCard();
    private final BallTicker bt = new BallTicker();
    
    public BingoGUI() {	
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
	
	mcUpperLeft = new GridBagConstraints();
	mcUpperLeft.gridx = 0;
	mcUpperLeft.gridy = 0;
	mcUpperLeft.insets = new Insets(5, 5, 5, 5);
	
	mcUpperRight = new GridBagConstraints();
	mcUpperRight.gridx = 1;
	mcUpperRight.gridy = 0;
	mcUpperRight.insets = new Insets(5, 5, 5, 5);
	
	mcLowerLeft = new GridBagConstraints();
	mcLowerLeft.gridx = 0;
	mcLowerLeft.gridy = 1;
	mcLowerLeft.insets = new Insets(5, 5, 5, 5);
	
	mcLowerRight = new GridBagConstraints();
	mcLowerRight.gridx = 1;
	mcLowerRight.gridy = 1;
	mcLowerRight.insets = new Insets(5, 5, 5, 5);
	
	// Test PlayerCards
	PlayerCard[] cardArray = new PlayerCard[5];
	
	cardArray[0] = new PlayerCard();
	
	cardArray[1] = new PlayerCard();
	cardArray[2] = new PlayerCard();
	cardArray[3] = new PlayerCard();
	cardArray[4] = new PlayerCard();
	
	if (PlayerCard.totalCards == 1) {
	    cardPanel.add(cardArray[0]);
	}
	else {
	    cardPanel.add(cardArray[1], mcUpperLeft);
	    cardPanel.add(cardArray[2], mcUpperRight);
	    cardPanel.add(cardArray[3], mcLowerLeft);
	    cardPanel.add(cardArray[4], mcLowerRight);
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
	
	// Add everything to Jframe and set static size
	this.add(backgroundJL);
	this.setSize(1000, 576);
	
	// Set some default properties
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    /*
    Returns a font to use for GUI elements.
    First tries to get pre-installed Cooper Black font.
    If not found, loads Cooper Black from .TTF file.
    If all else fails, uses Impact font.
    Font is returned at 1-point size.
    */
    public static Font getGameFont() {
	boolean foundCooper = false;
	GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = g.getAllFonts();
	for (Font font : fonts) {
	    if (font.getFontName().equals("Cooper Black")) {
		gameFont = font;
		foundCooper = true;
		break;
	    }
	}
	if (!foundCooper) {
	    try {
		InputStream cooperFromFile = BingoGUI.class.getResourceAsStream("/fonts/COOPBL.TTF");
		gameFont = Font.createFont(Font.TRUETYPE_FONT, cooperFromFile);
	    }
	    catch (FontFormatException | IOException ex) {
		gameFont = new Font("Impact", Font.PLAIN, 1);
	    }
	}

	return gameFont;
    }
}