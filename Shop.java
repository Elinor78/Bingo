/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

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
    private final Font shopFont = BingoGUI.getGameFont().deriveFont(75f);
    private int cardsToPurchase = 1;
    private final int CARD_COST;
    public Bingo newGame;
    
    // Creates Shop with default card price of 2.
    public Shop() {
	this(2);
    }
    
    // Creates Shop with specified card price. Allows for discounts.
    public Shop(int salePrice) {
	CARD_COST = salePrice;
	
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
		if (Bingo.player.getTicketBank() < CARD_COST) {
		    JOptionPane.showMessageDialog(null, "You do not have enough tickets.", "Insufficient Funds", JOptionPane.OK_OPTION);
		}
		else {
		    startBingo();
		}
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
		    if (Integer.parseInt(ticketBankLabel.getText()) - CARD_COST >= 0) {
			cardsToPurchase++;
			cardsToPurchaseLabel.setText(String.valueOf(cardsToPurchase));
			ticketBankLabel.setText(String.valueOf(Integer.parseInt(ticketBankLabel.getText()) - CARD_COST));
		    }
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
		    ticketBankLabel.setText(String.valueOf(Integer.parseInt(ticketBankLabel.getText()) + CARD_COST));
                }
            }
        });
        backgroundJL.add(arrowDownButton);
    }

    private void configureTicketBank() {
        ticketBankLabel.setSize(155, 110);
        ticketBankLabel.setLocation(190, 190);
        ticketBankLabel.setFont(shopFont);
	if (Bingo.player.getTicketBank() < CARD_COST) {
	    ticketBankLabel.setText("0");
	}
	else {
	    ticketBankLabel.setText(String.valueOf(Bingo.player.getTicketBank() - CARD_COST));
	}
	ticketBankLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundJL.add(ticketBankLabel);
    }

    private void configureCardsToPurchase() {
        cardsToPurchaseLabel.setSize(90, 90);
        cardsToPurchaseLabel.setLocation(465, 200);
        cardsToPurchaseLabel.setFont(shopFont);
	if (Bingo.player.getTicketBank() < CARD_COST) {
	    cardsToPurchaseLabel.setText("0");
	}
	else {
	    cardsToPurchaseLabel.setText(String.valueOf(cardsToPurchase));
	}
	cardsToPurchaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundJL.add(cardsToPurchaseLabel);
    }
    
    private void startBingo() {
        /*Hide the Shop window.*/
        this.setVisible(false);
        
        /*Sends the amount of cards to purchase to static human player in Bingo Class.*/
	Bingo.player.purchaseCards(cardsToPurchase, CARD_COST);
        
        /*Create a new Bingo game instance still in the main thread.*/
        newGame = new Bingo();
        
        /*Create a new listener thread and start it.*/
        Thread checkEndState = new Thread(new CheckForEndState());
        checkEndState.start();
    }
    
    public class CheckForEndState implements Runnable {

        @Override
        public void run() {
            /*Wait for the signal that no bingos are left.*/
            newGame.awaitNoBingosLeft();
            
            /*After signal received, reshow the shop window, close Bingo, 
            and dereference the Bingo instance so that Garbage Collection can clean it up. */
            Shop.this.setVisible(true);
            newGame.closeBingo();
            newGame = null;
        }  
    }
   

}
