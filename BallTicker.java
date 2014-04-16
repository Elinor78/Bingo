/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BallTicker extends JLabel {
    private final ImageIcon background = new ImageIcon(getClass().getResource("/img/BallTicker/BallHolder.png"));
    static final Font ballFont = BingoGUI.getGameFont();
    // Test balls. In final code, balls will be instantiated in changeBallPosition().
    private final Ball b1 = new Ball(14), b2 = new Ball(45), b3 = new Ball(46), b4 = new Ball(61);
    // Resting x-coordinates for balls
    private final int B1_X_POS = -4, B2_X_POS = 57, B3_X_POS = 118, B4_X_POS = 179;
    
    public BallTicker() {
	this.setIcon(background);
	this.setLayout(new GridBagLayout());
	GridBagConstraints interiorConstraint = new GridBagConstraints();
	
	JPanel interiorPanel = new JPanel();
	interiorPanel.setOpaque(false);
	interiorPanel.setLayout(null);
	interiorPanel.setPreferredSize(new Dimension(240, 64));
	
	this.add(interiorPanel, interiorConstraint);
	
	// Test display of balls
	interiorPanel.add(b1);
	interiorPanel.add(b2);
	interiorPanel.add(b3);
	interiorPanel.add(b4);
	
	// Testing resting coordinates for balls
	Insets insets = interiorPanel.getInsets();
	b1.setBounds(insets.left + B1_X_POS, insets.top + 2, 66, 60);
	b2.setBounds(insets.left + B2_X_POS, insets.top + 2, 66, 60);
	b3.setBounds(insets.left + B3_X_POS, insets.top + 2, 66, 60);
	b4.setBounds(insets.left + B4_X_POS, insets.top + 2, 66, 60);
    }
    
    public void changeBallPosition(int n) {
	
    }
    
    private class Ball extends JLabel {
	private final float FONT_SIZE = 21;
	private final ImageIcon background;
	
	private Ball(int n) {
	    this.setFont(BallTicker.ballFont.deriveFont(FONT_SIZE));
	    this.setHorizontalTextPosition(JLabel.CENTER);
	    
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