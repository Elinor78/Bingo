/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Dialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.text.*;

public final class MessageDialog extends JDialog {
    private final JLabel backgroundJL = new JLabel(new ImageIcon(getClass().getResource("/img/RoundSummary/background.png")));
    private final JButton dialogButton = new JButton();
    private String dialogMessage = null;
    
    public MessageDialog(String message, ImageIcon buttonImage) {
	this.dialogMessage = message;
	this.dialogButton.setIcon(buttonImage);
	
	configureBackground();
	configureButton();
	configureTextArea();
	
	this.add(backgroundJL);
	this.setSize(300, 400);
	this.setLocationRelativeTo(null);
	this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
	this.setAlwaysOnTop(true);
	this.setResizable(false);
	this.setUndecorated(true);
        this.setVisible(true);
    }
    
    public final void configureBackground() {
	backgroundJL.setSize(300, 400);
        backgroundJL.setLocation(0, 0);
    }
    
    public void configureButton() {
	dialogButton.setContentAreaFilled(false);
	dialogButton.setBorder(null);
        dialogButton.setSize(200, 100);
        dialogButton.setLocation(50, 275);
	dialogButton.addMouseListener(new MouseAdapter() {
            @Override
            /*When the start button is clicked a new Bingo game instance is created.*/
            public void mouseReleased(MouseEvent e) {
		MessageDialog.this.dispose();
	    }
	});
	backgroundJL.add(dialogButton);
    }

    private void configureTextArea() {
	final JTextPane dialogText = new JTextPane();
	Font dialogFont = BingoGUI.getGameFont().deriveFont(65f);
	FontMetrics fontMetrics = dialogText.getFontMetrics(dialogFont);
<<<<<<< HEAD
	final int MAX_STRING_WIDTH = 1271;
	
	/*This loops down from a font size of 65 and compares the string's measured width to a predefined width that is known to fit properly.
	Unfortunately It works down to that width (which is about 71 characters long in Cooper 35f) and then after that it makes text much smaller
	than I would anticipate. Would appreciate it if someone could take a stab at it. Otherwise, it works decently. It at least ensures that any 
	text passed will fit just that longer messages will be smaller than anticipated.*/

	for (float fontSize = 65; (fontMetrics.stringWidth(dialogMessage) >= MAX_STRING_WIDTH) && (fontSize > 12); fontSize -= 0.5) {
=======
	
	/*This loops down from a font size of 65 and compares the string's measured width to a predefined width that is known to fit properly.
	Unfortunately It works down to that width (which is about 71 characters long in Cooper 35f) and then after that it makes text much smaller than I would anticipate. Would appreciate it if someone could take a stab at it. Otherwise, it works decently. It at least ensures that any text passed will fit just that longer messages will be smaller than anticipated.*/
	for (float fontSize = 65; (fontMetrics.stringWidth(dialogMessage) >= 1271) && (fontSize > 12); fontSize -= 0.5) {
>>>>>>> FETCH_HEAD
	    dialogFont = dialogFont.deriveFont(fontSize);
	    fontMetrics = dialogText.getFontMetrics(dialogFont);
	}
	
	dialogText.setSize(250, 250);
        dialogText.setLocation(25, 20);
        dialogText.setFont(dialogFont);
	dialogText.setText(dialogMessage);
	dialogText.setOpaque(false);
	
	/*Creates a style with which to align the text centered.*/
	StyledDocument document = dialogText.getStyledDocument();
	SimpleAttributeSet attributes = new SimpleAttributeSet();
	StyleConstants.setAlignment(attributes, StyleConstants.ALIGN_CENTER);
	document.setParagraphAttributes(0, document.getLength(), attributes, false);
	
	this.add(dialogText);
    }
    
}
