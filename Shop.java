/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Shop extends JFrame {

    private final JLabel backgroundJL = new JLabel(new ImageIcon(getClass().getResource("/img/Shop/background.png")));
    private final JButton startButton = new JButton(new ImageIcon(getClass().getResource("/img/Shop/startButton.png")));
    private final JButton quitButton = new JButton(new ImageIcon(getClass().getResource("/img/Shop/quitButton.png")));
    private final JButton creditsButton = new JButton(new ImageIcon(getClass().getResource("/img/Shop/creditsButton.png")));
    private final JButton rulesButton = new JButton(new ImageIcon(getClass().getResource("/img/Shop/rulesButton.png")));
    private final JButton arrowUpButton = new JButton(new ImageIcon(getClass().getResource("/img/Shop/arrowUp.png")));
    private final JButton arrowDownButton = new JButton(new ImageIcon(getClass().getResource("/img/Shop/arrowDown.png")));
    private final JLabel ticketBankLabel = new JLabel();
    private final JLabel cardsToPurchaseLabel = new JLabel();
    private Font shopFont;
    public static int cardsToPurchase = 1;
    
    public Shop() {
        configureBackground();
        configureStartButton();
        configureQuitButton();
        configureCreditsButton();
        configureRulesButton();
        configureArrowUpButton();
        configureArrowDownButton();
        configureTicketBank();
        configureCardsToPurchase();

        this.add(backgroundJL);
	this.setSize(700, 450);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void configureBackground() {
        backgroundJL.setSize(700, 450);
        backgroundJL.setLocation(0, 0);
    }

    private void configureStartButton() {
        startButton.setContentAreaFilled(false);
	startButton.setBorder(null);
        startButton.setSize(200, 70);
        startButton.setLocation(450, 345);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            /*When the start button is clicked a new Bingo game instance is created.*/
            public void mouseReleased(MouseEvent e) {
                /*Sends the amount of cards to purchase to Bingo.*/
                Bingo newGame = new Bingo();
                Bingo.player.purchaseCards(cardsToPurchase);
                /*Close the Shop window.*/
                dispose();
            }
        });
        backgroundJL.add(startButton);
    }

    private void configureQuitButton() {
        quitButton.setContentAreaFilled(false);
	quitButton.setBorder(null);
        quitButton.setSize(200, 66);
        quitButton.setLocation(50, 345);
        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            /*Close the app if the Quit button is clicked.*/
            public void mouseReleased(MouseEvent e) {
                System.exit(0);
            }
        });
        backgroundJL.add(quitButton);
    }

    private void configureCreditsButton() {
        creditsButton.setContentAreaFilled(false);
	creditsButton.setBorder(null);
        creditsButton.setSize(160, 58);
        creditsButton.setLocation(516, 30);
        creditsButton.addMouseListener(new MouseAdapter() {
            @Override
            /*Open a new credits window.*/
            public void mouseReleased(MouseEvent e) {
                Credits newCredits = new Credits();
            }
        });
        backgroundJL.add(creditsButton);
    }

    private void configureRulesButton() {
        rulesButton.setContentAreaFilled(false);
        rulesButton.setBorder(null);
        rulesButton.setSize(160, 58);
        rulesButton.setLocation(325, 30);
        rulesButton.addMouseListener(new MouseAdapter() {
            @Override
            /*Open a new Rules window.*/
            public void mouseReleased(MouseEvent e) {
                Rules newRules = new Rules();
            }
        });
        backgroundJL.add(rulesButton);
    }

    private void configureArrowUpButton() {
        arrowUpButton.setContentAreaFilled(false);
        arrowUpButton.setBorder(null);
        arrowUpButton.setSize(60, 61);
        arrowUpButton.setLocation(575, 185);
        arrowUpButton.addMouseListener(new MouseAdapter() {
            @Override
            /*Increase the amount of cards to be purchased up to 4.*/
            public void mouseReleased(MouseEvent e) {
                if (cardsToPurchase < 4) {
                    cardsToPurchase++;
                    cardsToPurchaseLabel.setText(String.valueOf(cardsToPurchase));
                }
            }
        });
        backgroundJL.add(arrowUpButton);
    }

    private void configureArrowDownButton() {
        arrowDownButton.setContentAreaFilled(false);
        arrowDownButton.setBorder(null);
        arrowDownButton.setSize(60, 61);
        arrowDownButton.setLocation(575, 250);
        arrowDownButton.addMouseListener(new MouseAdapter() {
            @Override
            /*Decrease the amount of cards to be purchased down to 1.*/
            public void mouseReleased(MouseEvent e) {
                if (cardsToPurchase > 1) {
                    cardsToPurchase--;
                    cardsToPurchaseLabel.setText(String.valueOf(cardsToPurchase));
                }
            }
        });
        backgroundJL.add(arrowDownButton);
    }

    private void configureTicketBank() {
	shopFont = BingoGUI.getGameFont().deriveFont(80f);
        ticketBankLabel.setSize(115, 80);
        ticketBankLabel.setLocation(225, 200);
        ticketBankLabel.setFont(shopFont);
        ticketBankLabel.setText("10");
        backgroundJL.add(ticketBankLabel);
    }

    private void configureCardsToPurchase() {
	shopFont = BingoGUI.getGameFont().deriveFont(75f);
        cardsToPurchaseLabel.setSize(60, 80);
        cardsToPurchaseLabel.setLocation(492, 200);
        cardsToPurchaseLabel.setFont(shopFont);
        cardsToPurchaseLabel.setText(String.valueOf(cardsToPurchase));
        backgroundJL.add(cardsToPurchaseLabel);
    }
}
