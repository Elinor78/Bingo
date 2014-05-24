/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class NewPlayer extends JDialog {
    private final JLabel backgroundJL = new JLabel(new ImageIcon(getClass().getResource("/img/NewPlayer/background.png")));
    private final JTextField textField = new JTextField();
    private final Font shopFont = BingoGUI.getGameFont().deriveFont(30f);
    private String newPlayer;
    private final Human player;

    public NewPlayer(Human p) {
	this.player = p;
	
	configureStartButton();
	configureTextField();
	
	this.add(backgroundJL);
	this.setSize(300, 400);
	this.setLocationRelativeTo(null);
	this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
	this.setAlwaysOnTop(true);
	this.setResizable(false);
	this.setUndecorated(true);
        this.setVisible(true);
    }

    private void configureStartButton() {
	final JButton startButton = new JButton(new ImageIcon(getClass().getResource("/img/ChoosePlayer/startButton.png")));
	startButton.setContentAreaFilled(false);
	startButton.setBorder(null);
        startButton.setSize(200, 100);
        startButton.setLocation(50, 280);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
		if (textField.getText().equals("")) {
		    ;
		}
		else {
		    player.setName(textField.getText());
		    /*This part seems redundant but its necessary for if you make a new player FROM the Choose Player dialog.*/
		    newPlayer = textField.getText();
		    NewPlayer.this.dispose();
		}
            }
        });
        backgroundJL.add(startButton);
    }

    private void configureTextField() {
	textField.setSize(200, 40);
        textField.setLocation(50, 220);
        textField.setFont(shopFont);
	
	this.add(textField);
    }
    
    public String getNewPlayer() {
	return newPlayer;
    }
    
}
