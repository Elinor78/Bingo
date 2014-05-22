/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class RoundSummary extends JDialog {
    private final JLabel backgroundJL = new JLabel(new ImageIcon(getClass().getResource("/img/RoundSummary/background.png")));
    private final Font shopFont = BingoGUI.getGameFont().deriveFont(55f);
    private final Shop shop;
    
    public RoundSummary(Shop s) {
	this.shop = s;
	configureBackground();
        configureShopButton();
	configureYouWonLabel();
	
	this.add(backgroundJL);
	this.setSize(300, 400);
	this.setLocationRelativeTo(null);
	this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
	this.setAlwaysOnTop(true);
	this.setResizable(false);
	this.setUndecorated(true);
        this.setVisible(true);
    }

    private void configureBackground() {
	backgroundJL.setSize(300, 400);
        backgroundJL.setLocation(0, 0);
    }

    private void configureShopButton() {
	final JButton shopButton = new JButton(new ImageIcon(getClass().getResource("/img/RoundSummary/storeButton.png")));
	shopButton.setContentAreaFilled(false);
	shopButton.setBorder(null);
        shopButton.setSize(200, 100);
        shopButton.setLocation(50, 275);
        shopButton.addMouseListener(new MouseAdapter() {
            @Override
            /*When the start button is clicked a new Bingo game instance is created.*/
            public void mouseReleased(MouseEvent e) {
		shop.setVisible(true);
		RoundSummary.this.dispose();
            }
        });
        backgroundJL.add(shopButton);
    }

    private void configureYouWonLabel() {
	final JLabel youWonLabel = new JLabel();
	youWonLabel.setSize(250, 250);
        youWonLabel.setLocation(25, 5);
        youWonLabel.setFont(shopFont);
	youWonLabel.setText("<html><div style=\"text-align: center;\">" + "You won " + String.valueOf(PlayerCard.cardsWon) + " tickets" + "</html>");
	youWonLabel.setHorizontalAlignment(SwingConstants.CENTER);
	youWonLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.add(youWonLabel);
    }
}
