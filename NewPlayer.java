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
import javax.swing.text.*;

public class NewPlayer extends JDialog {
    private final JLabel backgroundJL = new JLabel(new ImageIcon(getClass().getResource("/img/NewPlayer/background.png")));
    private final JTextField textField = new JTextField();
    private final Font shopFont = BingoGUI.getGameFont().deriveFont(30f);
    private String newPlayer;

    public NewPlayer() {
	
	configureStartButton();
	configureTextField();
	configureCloseButton();
	
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
	final JButton startButton = new JButton(new ImageIcon(getClass().getResource("/img/NewPlayer/addButton.png")));
	startButton.setContentAreaFilled(false);
	startButton.setFocusPainted(false);
	startButton.setBorder(null);
        startButton.setSize(200, 100);
        startButton.setLocation(50, 280);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
		if (!textField.getText().equals("")) {
		    Human.name = textField.getText();
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
	
	/*This class prevents the field from being typed in longer than a specified length. 
	This is done to prevent really long user names which would make other interface
	elements look ugly or not fit. */
	class JTextFieldLimit extends PlainDocument {
	    private int limit;
	    
	    JTextFieldLimit(int limit) {
		super();
		this.limit = limit;
	    }

	    @Override
	    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		if (str == null) {
		    return;		    
		}

		if ((getLength() + str.length()) <= limit) {
		    super.insertString(offset, str, attr);
		}
	    }
	}
	
	textField.setDocument(new JTextFieldLimit(12));
	
	this.add(textField);
    }
    
    public String getNewPlayer() {
	return newPlayer;
    }

    private void configureCloseButton() {
	final JButton closeButton = new JButton(new ImageIcon(getClass().getResource("/img/NewPlayer/closeButton.png")));
	closeButton.setContentAreaFilled(false);
	closeButton.setFocusPainted(false);
	closeButton.setBorder(null);
        closeButton.setSize(31, 30);
        closeButton.setLocation(6, 4);
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
		NewPlayer.this.dispose();
            }
        });
        backgroundJL.add(closeButton);
    }
    
}
