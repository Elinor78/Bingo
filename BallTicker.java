/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BallTicker extends JLabel {
    private final ImageIcon background = new ImageIcon(getClass().getResource("/img/BallTicker/BallHolder.png"));
    static final Font ballFont = BingoGUI.getGameFont();
    private final JPanel interiorPanel = new JPanel();
    private final Insets insets;
    private final Queue<Ball> ballQueue = new LinkedList<>();
    
    private final Random randomGen = new Random();
    
    private final int LEFTMOST_X_POS = -65, B2_X_POS = 57;
    
    public BallTicker() {
	this.setIcon(background);
	this.setLayout(new GridBagLayout());
	GridBagConstraints interiorConstraint = new GridBagConstraints();
	
	interiorPanel.setOpaque(false);
	interiorPanel.setLayout(null);
	interiorPanel.setPreferredSize(new Dimension(240, 64));
	this.add(interiorPanel, interiorConstraint);
	
	this.insets = interiorPanel.getInsets();
	
	this.addMouseListener(new BallTicker.TestMouseListener()); // Remove when no longer needed
    }
    
    private class TestMouseListener extends MouseAdapter { // Remove when no longer needed
	@Override
	public void mousePressed(MouseEvent e) {
	    addBall(randomGen.nextInt(74) + 1);
	}
    }
    
    public void addBall(int n) {
	// Make new ball and add to the queue
	Ball newBall = new Ball(n);
	ballQueue.offer(newBall);
	
	// Put new ball into position just out of frame
	newBall.setBounds(insets.left + LEFTMOST_X_POS, insets.top + 2, 66, 60);
	interiorPanel.add(newBall);
	
	// Slide every ball 61 pixels to the right
	for (Ball b : ballQueue) {
	    Rectangle bounds = b.getBounds();
	    int x = bounds.x, y = bounds.y, width = bounds.width, height = bounds.height;
	    b.setBounds(x + 61, y, width, height);
	}
	
	// If a ball just slid out of frame, remove it from the queue
	if (ballQueue.size() > 4) {
	    ballQueue.poll();
	}
	
	interiorPanel.repaint();
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