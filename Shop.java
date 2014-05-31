/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;
import javax.swing.*;

public final class Shop extends JFrame {

    private final JLabel backgroundJL = new JLabel(new ImageIcon(getClass().getResource("/img/Shop/background.png")));
    private final JLabel ticketBankLabel = new JLabel();
    private final JLabel cardsToPurchaseLabel = new JLabel();
    private final JButton resetTicketBankButton = new JButton();
    private final Font shopFont = BingoGUI.getGameFont().deriveFont(75f);
    private int cardsToPurchase = 1;
    private final int CARD_COST;
    public static Human player = new Human();
    Bingo newGame;
    
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
	configureName();
	configureResetTicketBankButton();
	
	new MessageDialog("", new ImageIcon(getClass().getResource("/img/MessageDialog/storeButton.png")));

        this.add(backgroundJL);
	this.setSize(700, 450);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	// This allows the 20-ticket freebie to appear when the program launches if tickets == 0, but maybe we just want to create a new player in that case...
	resetTicketLabels(); 
    }
    
    private void configureBackground() {
        backgroundJL.setSize(700, 450);
        backgroundJL.setLocation(0, 0);
    }

    private void configureStartButton() {
	final JButton startButton = new JButton(new ImageIcon(getClass().getResource("/img/Shop/startButton.png")));
	startButton.setFocusPainted(false);
        startButton.setContentAreaFilled(false);
	startButton.setBorder(null);
        startButton.setSize(160, 60);
        startButton.setLocation(525, 345);//450 345
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            /*When the start button is clicked a new Bingo game instance is created.*/
            public void mouseReleased(MouseEvent e) {
		if (player.getCurrentBalance() > 0) {
		    startBingo();
		}
            }
        });
        backgroundJL.add(startButton);
    }

    private void configureQuitButton() {
	final JButton quitButton = new JButton(new ImageIcon(getClass().getResource("/img/Shop/quitButton.png")));
	quitButton.setFocusPainted(false);
        quitButton.setContentAreaFilled(false);
	quitButton.setBorder(null);
        quitButton.setSize(160, 60);
        quitButton.setLocation(15, 345);
        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            /*Close the app if the Quit button is clicked.*/
            public void mouseReleased(MouseEvent e) {
                new ShutDownTask();
		System.exit(0);
            }
        });
        backgroundJL.add(quitButton);
    }

    private void configureCreditsButton() {
	final JButton creditsButton = new JButton(new ImageIcon(getClass().getResource("/img/Shop/creditsButton.png")));
	creditsButton.setFocusPainted(false);
        creditsButton.setContentAreaFilled(false);
	creditsButton.setBorder(null);
        creditsButton.setSize(160, 60);
        creditsButton.setLocation(190, 345);
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
	final JButton rulesButton = new JButton(new ImageIcon(getClass().getResource("/img/Shop/rulesButton.png")));
	rulesButton.setFocusPainted(false);
        rulesButton.setContentAreaFilled(false);
        rulesButton.setBorder(null);
        rulesButton.setSize(160, 60);
        rulesButton.setLocation(360, 345);
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
	final JButton arrowUpButton = new JButton(new ImageIcon(getClass().getResource("/img/Shop/arrowUp.png")));
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
	final JButton arrowDownButton = new JButton(new ImageIcon(getClass().getResource("/img/Shop/arrowDown.png")));
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
        ticketBankLabel.setLocation(228, 186);
        ticketBankLabel.setFont(shopFont);
	if (player.getCurrentBalance() < CARD_COST) {
	    ticketBankLabel.setText("0");
	}
	else {
	    ticketBankLabel.setText(String.valueOf(player.getCurrentBalance() - CARD_COST));
	}
	ticketBankLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundJL.add(ticketBankLabel);
    }

    private void configureCardsToPurchase() {
        cardsToPurchaseLabel.setSize(90, 90);
        cardsToPurchaseLabel.setLocation(470, 195);
        cardsToPurchaseLabel.setFont(shopFont);
	if (player.getCurrentBalance() < CARD_COST) {
	    cardsToPurchaseLabel.setText("0");
	}
	else {
	    cardsToPurchaseLabel.setText(String.valueOf(cardsToPurchase));
	}
	cardsToPurchaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundJL.add(cardsToPurchaseLabel);
    }
    
    private void configureName() {
	final JLabel nameLabel = new JLabel();
	nameLabel.setSize(250, 50);
        nameLabel.setLocation(420, 1);
        nameLabel.setFont(shopFont.deriveFont(22f));
	nameLabel.setText("Hi, " + Human.name + "!");
	nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundJL.add(nameLabel);
    }
    
    private void configureResetTicketBankButton () {
        resetTicketBankButton.setContentAreaFilled(true);
        resetTicketBankButton.setBorder(null);
	resetTicketBankButton.setFocusPainted(false);
        resetTicketBankButton.setSize(75, 75);
        resetTicketBankButton.setLocation(350, 40);
	resetTicketBankButton.setText("Reset");
	resetTicketBankButton.setVisible(false);
	if (player.getCurrentBalance() <= 4) {
		resetTicketBankButton.setVisible(true);
	    }
        resetTicketBankButton.addMouseListener(new MouseAdapter() {
            @Override
            /*Decrease the amount of cards to be purchased down to 1.*/
            public void mouseReleased(MouseEvent e) {
		Human.bankHistory.add(20);
		resetTicketLabels();
		resetTicketBankButton.setVisible(false);
            }
        });
        backgroundJL.add(resetTicketBankButton);
    }
    
    public void resetTicketLabels() {
	if (player.getCurrentBalance() > 0) {
	    ticketBankLabel.setText(String.valueOf(player.getCurrentBalance() - CARD_COST));
	    cardsToPurchaseLabel.setText(String.valueOf(cardsToPurchase));
	}
	else {
	    ticketBankLabel.setText("0");
	    cardsToPurchaseLabel.setText("0");
	}
	
	repaint();
    }
    
    private void startBingo() {
        /*Hide the Shop window.*/
        this.setVisible(false);
        
        /*Sends the amount of cards to purchase to static human player in Bingo Class.*/
	player.purchaseCards(cardsToPurchase, CARD_COST);
        
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
            newGame.closeBingo();
            newGame = null;
	    
	    AudioInputStream ais;
	    Clip airhorn = null;
	    try {
		ais = AudioSystem.getAudioInputStream(getClass().getResource("/Audio/Air Horn.wav"));
		airhorn = AudioSystem.getClip();
		airhorn.open(ais);
		airhorn.start();
	    }
	    catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
		Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, null, ex);
		System.out.println(ex.getMessage());
	    }
	    
	    /*Open a new Round Summary.*/
	    //new RoundSummary(Shop.this);
	    new MessageDialog("You won " + String.valueOf(player.getTicketsWonInLatestRound()) + " tickets, " + Human.name + "!", 
		    new ImageIcon(getClass().getResource("/img/MessageDialog/storeButton.png")));
	    
	    airhorn.close();
	    
	    player.resetTicketsWonInLatestRound();
	    
	    if (player.getCurrentBalance() <= 4) {
		resetTicketBankButton.setVisible(true);
	    }
	    
	    /*Reset values in Shop.*/
	    Shop.this.cardsToPurchase = 1;
	    Shop.this.resetTicketLabels();
	    Shop.this.setVisible(true);
        }  
    }
}
