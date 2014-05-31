/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.text.*;

public class NewPlayer extends JDialog {
    private final JLabel backgroundJL = new JLabel(new ImageIcon(getClass().getResource("/img/NewPlayer/background.png")));
    private final JTextField textField = new JTextField();
    private String newPlayer;

    public NewPlayer() {
	
	configureAddPlayerButton();
	configureTextField();
	configureCloseButton();
	
	/*Places focus in text field. Requesting focus normal way was unsuccessful*/
	this.addWindowListener(new WindowAdapter() {
	    @Override
	    public void windowOpened(WindowEvent e) {
		textField.requestFocus();
	    }
	});
	
	this.add(backgroundJL);
	this.setSize(300, 400);
	
	/*Places the window adjacent to the ChoosePlayer Dialog because on certain systems 
	the background would turn invisible if it was sitting on top. */
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension windowSize = this.getSize();
	
	int windowX = Math.max(0, (screenSize.width  + 400 ) / 2);
	int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
	
	this.setLocation(windowX, windowY);
	this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
	this.setAlwaysOnTop(true);
	this.setResizable(false);
	this.setUndecorated(true);
        this.setVisible(true);
    }

    private void configureAddPlayerButton() {
	final JButton addPlayerButton = new JButton(new ImageIcon(getClass().getResource("/img/NewPlayer/addButton.png")));
	addPlayerButton.setContentAreaFilled(false);
	addPlayerButton.setFocusPainted(false);
	addPlayerButton.setBorder(null);
        addPlayerButton.setSize(200, 100);
        addPlayerButton.setLocation(50, 280);
        addPlayerButton.addMouseListener(new MouseAdapter() {
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
        backgroundJL.add(addPlayerButton);
    }

    private void configureTextField() {
	textField.setSize(200, 40);
        textField.setLocation(50, 220);
        textField.setFont(BingoGUI.getGameFont().deriveFont(30f));
	
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
	
	textField.setDocument(new JTextFieldLimit(8));
	
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
        closeButton.setLocation(2, 2);
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
		NewPlayer.this.dispose();
            }
        });
        backgroundJL.add(closeButton);
    }
}
