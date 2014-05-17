/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class NewBingoNotification extends JLabel {
    private final TestListener testListener = new TestListener();
    
    private int alphaValue = 255;
    private Color textColor = new Color(130, 150, 160, alphaValue);
    
    private final ActionListener decreaseOpacity = new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent evt) {
	    textColor = new Color(130, 150, 160, alphaValue--);
	    setBingoText();
	    
	    if (alphaValue == 0) {
		textTimer.stop();
		alphaValue = 255;
	    }
	}
     };
    private final Timer textTimer = new Timer(5, decreaseOpacity);
    
    public NewBingoNotification() {
	this.setFont(BingoGUI.getGameFont().deriveFont(17f));
	this.setHorizontalTextPosition(JLabel.CENTER);
	this.setHorizontalAlignment(JLabel.CENTER);
	this.setText("");
	this.setIcon(new ImageIcon(getClass().getResource("/img/StatusWindow/NewBingoBubble.png")));
	
	this.addMouseListener(testListener);
    }
    
    public void showClaimedBingo() {
	textColor = new Color(130, 150, 160, 255);
	textTimer.start();
    }
    
    private void setBingoText() {
	this.setForeground(textColor);
	this.setText("An opponent got a bingo!");
    }
    
       private class TestListener extends MouseAdapter {
	@Override
	public void mousePressed(MouseEvent e) {
	    showClaimedBingo();
	}
    }
}