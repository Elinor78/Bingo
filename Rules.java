/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*This is the GUI for showing the game rules.*/
public class Rules extends JFrame {
    /*Rules actually need to be written. If someone wants to help write them I can edit the photoshop image and display them correctly.*/
    private final JLabel backgroundJL = new JLabel(new ImageIcon(getClass().getResource("/img/Rules/rules.png")));
    
    public Rules() {
        this.add(backgroundJL);
	this.setSize(700, 500);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
        this.setVisible(true);
    }
}
