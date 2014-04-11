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
    private final JPanel statusPanel = new JPanel();
    private final MasterCard mc = new MasterCard();
    
    public BingoGUI() {	
	backgroundJL.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	
	// Place JPanel to hold master card
	masterCardPanel.setPreferredSize(new Dimension(162, 364));
	c.insets = new Insets(-23, -16, 0, 25);
	c.gridx = 0;
	backgroundJL.add(masterCardPanel, c);
	
	// Place master card in masterCardPanel
	masterCardPanel.add(mc);
	
	// Place JPanel to hold player card(s)
	cardPanel.setPreferredSize(new Dimension(434, 515));
	cardPanel.setBackground(new Color(0,0,0,90)); // Delete this line when no longer needed
	c.insets = new Insets(25, 0, 0, 37);
	c.gridx = 1;
	backgroundJL.add(cardPanel, c);
	
	// Place JPanel to hold number ticker & bingo status window
	statusPanel.setPreferredSize(new Dimension(268, 295));
	statusPanel.setBackground(new Color(0,0,0,90)); // Delete this line when no longer needed
	c.insets = new Insets(61, 0, 0, 0);
	c.gridx = 2;
	backgroundJL.add(statusPanel, c);
	
	// Add everything to Jframe and set static size
	this.add(backgroundJL);
	this.setSize(1000, 576);
	
	// Set some default properties
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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