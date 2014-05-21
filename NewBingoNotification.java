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
    int currentBingoNumber = 1;
        String appendix = null;
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
        currentBingoNumber++;
	textTimer.start();
    }
    
    private void setBingoText() {
        
        if( currentBingoNumber == 1 || currentBingoNumber == 21 || currentBingoNumber == 31 || currentBingoNumber == 41 || currentBingoNumber == 51 || currentBingoNumber == 61 || currentBingoNumber == 71)
            appendix = "st";
        else if( currentBingoNumber == 2 || currentBingoNumber == 22 || currentBingoNumber == 32 || currentBingoNumber == 42 || currentBingoNumber == 52 || currentBingoNumber == 62 || currentBingoNumber == 72)
            appendix = "nd";
        else if( currentBingoNumber == 3 || currentBingoNumber == 23 || currentBingoNumber == 33 || currentBingoNumber == 43 || currentBingoNumber == 53 || currentBingoNumber == 63 || currentBingoNumber == 73)
            appendix = "rd";
        else if( currentBingoNumber > 3 && currentBingoNumber < 21 || currentBingoNumber > 23 && currentBingoNumber < 31 || currentBingoNumber > 33 && currentBingoNumber < 41 || currentBingoNumber > 43 && currentBingoNumber < 51 || currentBingoNumber > 53 && currentBingoNumber < 61 || currentBingoNumber > 63 && currentBingoNumber < 71)
            appendix = "th";
            
	this.setForeground(textColor);
	this.setText( currentBingoNumber + appendix + " Bingo has been called");
    }
}