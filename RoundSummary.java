/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class RoundSummary extends JFrame {
    private final JLabel backgroundJL = new JLabel(new ImageIcon(getClass().getResource("/img/RoundSummary/background.png")));
    private final JButton shopButton = new JButton(new ImageIcon(getClass().getResource("/img/RoundSummary/logo.png")));
    private final JLabel youWonLabel = new JLabel();
    private final Font shopFont = BingoGUI.getGameFont().deriveFont(65f);
    private final Shop shop;
    
    public RoundSummary(Shop s) {
	this.shop = s;
	configureBackground();
        configureShopButton();
	configureYouWonLabel();
	
	
	this.add(backgroundJL);
	this.setSize(400, 500);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	this.setUndecorated(true);
        this.setVisible(true);
    }

    private void configureBackground() {
	backgroundJL.setSize(400, 500);
        backgroundJL.setLocation(0, 0);
    }

    private void configureShopButton() {
	shopButton.setContentAreaFilled(false);
	shopButton.setBorder(null);
        shopButton.setSize(266, 103);
        shopButton.setLocation(67, 330);
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
	youWonLabel.setSize(350, 300);
        youWonLabel.setLocation(40, 5);
        youWonLabel.setFont(shopFont);
	youWonLabel.setText(String.format("<html><div WIDTH=%d>%s <div style=\"text-align: center;\"</div><html>", 350, "You won 0 tickets"));
	youWonLabel.setHorizontalAlignment(SwingConstants.CENTER);
	youWonLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.add(youWonLabel);
    }
}
