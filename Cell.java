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
    private ImageIcon marker;
    private int cellNumber = -1;
    private boolean isMarked = false;
    private float FONT_SIZE;
    
    public Cell(int number) {
	marker = new ImageIcon(getClass().getResource("/img/Card/markerSmall.png"));
	
	FONT_SIZE = (float)(marker.getIconHeight() * .9);
	
	cellNumber = number;
	genericInitializations();
	this.setText(String.valueOf(number));
    }
    
    private void genericInitializations() {
	this.setBorder(new LineBorder(Color.black, 1));
	this.setOpaque(true);
	this.setBackground(Color.white);
	
	this.setFont(Card.cellFont.deriveFont(FONT_SIZE));
	this.setHorizontalTextPosition(JLabel.CENTER);
	this.setHorizontalAlignment(JLabel.CENTER);
	this.setVerticalTextPosition(JLabel.CENTER);
	this.setVerticalAlignment(JLabel.CENTER);
    }
    
    public void convertToLargeCell() {
	marker = new ImageIcon(getClass().getResource("/img/Card/marker.png"));
	
	FONT_SIZE = ((float)(marker.getIconHeight() * .9));
	setFont(Card.cellFont.deriveFont(FONT_SIZE));
	
	repaint();
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
    
    public void setNumber(int n) {
	cellNumber = n;
    }
    
    public boolean isMarked() {
	return isMarked;
    }
}