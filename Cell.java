/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Cell extends JLabel {
    private final ImageIcon marker;
    private int cellNumber = -1;
    private boolean isMarked = false;
    private float FONT_SIZE;
    
    public Cell(int number) {
	if (Card.totalCards > 1) {
	    // Card is small
	    marker = new ImageIcon(getClass().getResource("/img/Card/markerSmall.png"));
	}
	else {
	    marker = new ImageIcon(getClass().getResource("/img/Card/marker.png"));
	}
	
	FONT_SIZE = (float)(marker.getIconHeight() * .9);
	
	cellNumber = number;
	genericInitializations();
	this.setText(String.valueOf(number));
    }
    
    public Cell(char c) {
	marker = new ImageIcon(getClass().getResource("/img/Card/markerSmall.png"));
	genericInitializations();
	this.setText(String.valueOf(c));
    }
    
    private void genericInitializations() {
	this.setBorder(new LineBorder(Color.black, 1));
	this.setOpaque(true);
	this.setBackground(Color.white);
	
	this.setFont(Card.getCellFont().deriveFont(FONT_SIZE));
	this.setHorizontalTextPosition(JLabel.CENTER);
	this.setHorizontalAlignment(JLabel.CENTER);
	this.setVerticalTextPosition(JLabel.CENTER);
	this.setVerticalAlignment(JLabel.CENTER);
    }
    
    public void setFontSize(int n) {
	FONT_SIZE = n;
	this.setFont(Card.getCellFont().deriveFont(FONT_SIZE));
    }

    public void toggleToken() {
	    if (isMarked) {
		this.setIcon(null);
		repaint();
		isMarked = false;
	    }
	    else {
		this.setIcon(marker);
		repaint();
		isMarked = true;
	    }
    }
    
    public int getNumber() {
	return cellNumber;
    }
    
    public boolean isMarked() {
	return isMarked;
    }
}