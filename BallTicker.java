/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BallTicker extends JLabel {
    static final Font ballFont = BingoGUI.getGameFont();
    private final JPanel interiorPanel = new JPanel();
    private final Insets insets;
    private final Queue<Ball> ballQueue = new LinkedList<>();
    private int numberOfPixelsSlid;
    private final int LEFTMOST_X_POS = -65;
    
    private final ActionListener timerListener = new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent evt) {
	    slideBalls1px();
	    
	    if (numberOfPixelsSlid == 61) {
		slideTimer.stop();
	    }
	}
     };
    private final Timer slideTimer = new Timer(1, timerListener);
    
    public BallTicker() {
	this.setIcon(new ImageIcon(getClass().getResource("/img/BallTicker/BallHolder.png")));
	this.setLayout(new GridBagLayout());
	GridBagConstraints interiorConstraint = new GridBagConstraints();
	
	interiorPanel.setOpaque(false);
	interiorPanel.setLayout(null);
	interiorPanel.setPreferredSize(new Dimension(240, 64));
	this.add(interiorPanel, interiorConstraint);
	
	this.insets = interiorPanel.getInsets();
    }
    
    public void addBall(int n) {
	    // Make new ball and add to the queue
	    Ball newBall = new Ball(n);
	    ballQueue.offer(newBall);

	    // Put new ball into position just out of frame
	    newBall.setBounds(insets.left + LEFTMOST_X_POS, insets.top + 2, 66, 60);
	    interiorPanel.add(newBall);

	    // Reset counter for slideTimer.stop() evaluation.
	    numberOfPixelsSlid = 0;

	    slideTimer.start();

	    // If a ball just slid out of frame, remove it from the panel and the queue
	    if (ballQueue.size() > 5) {
		interiorPanel.remove(ballQueue.poll());
	    }
    }
    
    private void slideBalls1px() {
	    for (Ball b : ballQueue) {
		Rectangle bounds = b.getBounds();
		b.setBounds(bounds.x + 1, bounds.y, bounds.width, bounds.height);
	    }

	    interiorPanel.repaint();

	    numberOfPixelsSlid++;
    }
    
    private static class Ball extends JLabel {
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