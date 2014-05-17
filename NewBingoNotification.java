/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class NewBingoNotification extends JLabel {
    private int alphaValue = 255;
    private Color textColor = new Color(0, 0, 0, alphaValue);
    
    private final ActionListener decreaseOpacity = new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent evt) {
	    textColor = new Color(0, 0, 0, alphaValue--);
	    setBingoText();
	    
	    if (alphaValue == 0) {
		textTimer.stop();
	    }
	}
     };
    private final Timer textTimer = new Timer(10, decreaseOpacity);
    
    public NewBingoNotification() {
	this.setFont(BingoGUI.getGameFont().deriveFont(17f));
	this.setHorizontalTextPosition(JLabel.CENTER);
	this.setHorizontalAlignment(JLabel.CENTER);
	this.setText("");
	this.setIcon(new ImageIcon(getClass().getResource("/img/StatusWindow/NewBingoBubble.png")));
    }
    
    public void showClaimedBingo() {
	textTimer.stop(); 
	
	alphaValue = 255;
	textTimer.start();
    }
    
    private void setBingoText() {
	this.setForeground(textColor);
	this.setText("An opponent got a bingo!");
    }
}