/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class StatusWindow extends JLabel {
    private final Bingo b;
    private final Font smallerFont = BingoGUI.getGameFont().deriveFont(25f);
    private final JLabel bingosLeft = new JLabel();
    private final JLabel compOpponents = new JLabel();
    private final JLabel cardsInPlay = new JLabel();
    
    public StatusWindow(Bingo b) {
	this.b = b;
	
	this.setIcon(new ImageIcon(getClass().getResource("/img/StatusWindow/GameplayTracker.png")));
	
	bingosLeft.setSize(75, 45);
        bingosLeft.setLocation(155, 20);
        bingosLeft.setFont(BingoGUI.getGameFont().deriveFont(35f));
	bingosLeft.setText(String.valueOf(b.getNumberOfBingos()));
	bingosLeft.setHorizontalAlignment(JLabel.CENTER);
	this.add(bingosLeft);
	
	compOpponents.setSize(50, 25);
        compOpponents.setLocation(65, 80);
        compOpponents.setFont(smallerFont);
	compOpponents.setText(String.valueOf(Computer.totalComputerPlayers));
	compOpponents.setHorizontalAlignment(JLabel.CENTER);
	this.add(compOpponents);
	
	cardsInPlay.setSize(50, 25);
        cardsInPlay.setLocation(185, 80);
        cardsInPlay.setFont(smallerFont);
	cardsInPlay.setText(String.valueOf(Computer.totalComputerCards));
	cardsInPlay.setHorizontalAlignment(JLabel.CENTER);
	this.add(cardsInPlay);
    }
    
    public void updateAvailableBingos() {
	bingosLeft.setText(String.valueOf(b.getNumberOfBingos()));
	repaint();
    }
}