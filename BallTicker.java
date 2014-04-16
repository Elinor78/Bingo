/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Font;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BallTicker extends JLabel {
    private final ImageIcon background = new ImageIcon(getClass().getResource("/img/BallTicker/BallHolder.png"));
    static final Font ballFont = BingoGUI.getGameFont();
    private final Ball b1 = new Ball(14), b2 = new Ball(45), b3 = new Ball(46), b4 = new Ball(61);
    private final int B1_X_POS = 6, B2_X_POS = 65, B3_X_POS = 124, B4_X_POS = 183;
    
    public BallTicker() {
	this.setIcon(background);
	//this.setLayout(new GridLayout(0, 4));
	this.setLayout(null);
	
	// Test adding balls
	this.add(b1);
	this.add(b2);
	this.add(b3);
	this.add(b4);
	
	// Testing resting coordinates for balls
	Insets insets = this.getInsets();
	b1.setBounds(insets.left + B1_X_POS, insets.top + 6, 66, 60);
	b2.setBounds(insets.left + B2_X_POS, insets.top + 6, 66, 60);
	b3.setBounds(insets.left + B3_X_POS, insets.top + 6, 66, 60);
	b4.setBounds(insets.left + B4_X_POS, insets.top + 6, 66, 60);
    }
    
    public void changeBallPosition(int n) {
	
    }
    
    private class Ball extends JLabel {
	private final float FONT_SIZE = 21;
	private final ImageIcon background;
	
	private Ball(int n) {
	    this.setFont(BallTicker.ballFont.deriveFont(FONT_SIZE));
	    this.setHorizontalTextPosition(JLabel.CENTER);
	    this.setVerticalTextPosition(JLabel.CENTER);
	    this.setVerticalAlignment(JLabel.CENTER);
	    
	    if (n >= 1 && n <= 15) {
		background = new ImageIcon(getClass().getResource("/img/BallTicker/B_Ball.png"));
		this.setText("<html><center>b<br>" + n + "</center></html>");
	    }
	    else if (n <= 30) {
		background = new ImageIcon(getClass().getResource("/img/BallTicker/I_Ball.png"));
		this.setText("<html><center>i<br>" + n + "</center></html>");
	    }
	    else if (n <= 45) {
		background = new ImageIcon(getClass().getResource("/img/BallTicker/N_Ball.png"));
		this.setText("<html><center>n<br>" + n + "</center></html>");
	    }
	    else if (n <= 60) {
		background = new ImageIcon(getClass().getResource("/img/BallTicker/G_Ball.png"));
		this.setText("<html><center>g<br>" + n + "</center></html>");
	    }
	    else {
		background = new ImageIcon(getClass().getResource("/img/BallTicker/O_Ball.png"));
		this.setText("<html><center>o<br>" + n + "</center></html>");
	    }
	    
	    this.setIcon(background);
	}
    }
}