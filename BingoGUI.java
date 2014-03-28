/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

package bingo;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BingoGUI extends JFrame {
    private final  ImageIcon background = new ImageIcon(getClass().getResource("/resources/img/BingoGUI/Bingo_GUI_Background.jpg"));
    private final JLabel mainJL = new JLabel(background);
    private final JPanel masterCardPanel = new JPanel();
    private final JPanel cardPanel = new JPanel();
    private final JPanel statusPanel = new JPanel();
    
    public BingoGUI() {
	mainJL.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	
	// Place JPanel to hold master card
	masterCardPanel.setPreferredSize(new Dimension(162, 364));
	masterCardPanel.setBackground(new Color(255,0,0,90)); // Delete this line when no longer needed
	c.insets = new Insets(-23, -16, 0, 25);
	c.gridx = 0;
	mainJL.add(masterCardPanel, c);
	
	// Place JPanel to hold player card(s)
	cardPanel.setPreferredSize(new Dimension(434, 515));
	cardPanel.setBackground(new Color(0,255,0,90)); // Delete this line when no longer needed
	c.insets = new Insets(25, 0, 0, 37);
	c.gridx = 1;
	mainJL.add(cardPanel, c);
	
	// Place JPanel to hold number ticker & bingo status window
	statusPanel.setPreferredSize(new Dimension(268, 295));
	statusPanel.setBackground(new Color(0,0,255,90)); // Delete this line when no longer needed
	c.insets = new Insets(61, 0, 0, 0);
	c.gridx = 2;
	mainJL.add(statusPanel, c);
	
	// Add everything to Jframe and set static size
	this.add(mainJL);
	this.setSize(1000, 576);
	
	// Set some default properties
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
