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
    int currentBingoNumber = 0;
    
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
	this.setFont(BingoGUI.getGameFont().deriveFont(16f));
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
	String appendix;
	
	switch (currentBingoNumber) {
	    case 1:
	    case 21:
	    case 31:
	    case 41:
	    case 51:
	    case 61:
	    case 71:
		appendix = "st"; break;
	    case 2:
	    case 22:
	    case 32:
	    case 42:
	    case 52:
	    case 62:
	    case 72:
		appendix = "nd"; break;
	    case 3:
	    case 23:
	    case 33:
	    case 43:
	    case 53:
	    case 63:
	    case 73:
		appendix = "rd"; break;
	    default:
		appendix = "th";
	}
        
	this.setForeground(textColor);
	this.setText( currentBingoNumber + appendix + " Bingo has been called");
    }
}