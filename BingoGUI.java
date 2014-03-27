/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

package bingo;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BingoGUI extends JFrame {
    private final ImageIcon background = new ImageIcon(getClass().getResource("/img/BingoGUI/Bingo_GUI_Background.jpg"));
    private final JLabel mainJL = new JLabel(background);
    
    public BingoGUI() {
	this.add(mainJL);
	this.setSize(1000, 576);
	
	// Set some default properties
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
