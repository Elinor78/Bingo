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
	//final float MAX_STRING_WIDTH = 685;
	int stringWidth = fontMetrics.stringWidth(dialogMessage);
	
	/*This loops down from a font size of 65 and compares the string's measured width to a predefined width that is known to fit properly.
	Unfortunately It works down to that width (which is about 71 characters long in Cooper 35f) and then after that it makes text much smaller
	than I would anticipate. Would appreciate it if someone could take a stab at it. Otherwise, it works decently. It at least ensures that any 
	text passed will fit just that longer messages will be smaller than anticipated.*/

	/*for (float fontSize = 65, maxStringWidth = MAX_STRING_WIDTH; (fontMetrics.stringWidth(dialogMessage) > maxStringWidth) && (fontSize > 12); fontSize -= 1, maxStringWidth++) {
	    dialogFont = dialogFont.deriveFont(fontSize);
	    fontMetrics = dialogText.getFontMetrics(dialogFont);
	    System.out.println("Font Size: " + fontSize + " String Width: " + fontMetrics.stringWidth(dialogMessage) + " Max String Width: " + maxStringWidth);
	}*/
	
	
	/*This is the temporary solution I came up with to change the font but it really should be dynamic.*/
	if (stringWidth >= 0 && stringWidth <= 200) {
	    dialogFont = dialogFont.deriveFont(70f);
	} else if (stringWidth <= 600) {
	    dialogFont = dialogFont.deriveFont(65f);
	} else if (stringWidth <= 800) {
	    dialogFont = dialogFont.deriveFont(54f);
	} else if (stringWidth <= 1000) {
	    dialogFont = dialogFont.deriveFont(48f); 
	} else if (stringWidth <= 1200) {
	    dialogFont = dialogFont.deriveFont(44f);
	} else if (stringWidth <= 1600) {
	    dialogFont = dialogFont.deriveFont(41f);
	} else if (stringWidth <= 1800) {
	    dialogFont = dialogFont.deriveFont(38f);
	} else if (stringWidth <= 2000) {
	    dialogFont = dialogFont.deriveFont(36f);
	} else if (stringWidth <= 2200) {
	    dialogFont = dialogFont.deriveFont(34f);
	} else if (stringWidth <= 2400) {
	    dialogFont = dialogFont.deriveFont(32f);
	} else if (stringWidth <= 2600) {
	    dialogFont = dialogFont.deriveFont(29f);
	} else if (stringWidth <= 2800) {
	    dialogFont = dialogFont.deriveFont(25f);
	} else if (stringWidth <= 3000) {
	    dialogFont = dialogFont.deriveFont(21f);
	} else if (stringWidth <= 3200) {
	    dialogFont = dialogFont.deriveFont(17f);
	} else if (stringWidth <= 3400) {
	    dialogFont = dialogFont.deriveFont(13f);
	} else if (stringWidth > 3400) {
	    dialogMessage = "Not Enough Space.";
	    dialogFont = dialogFont.deriveFont(65f);
	}

	
	dialogText.setSize(276, 250);
        dialogText.setLocation(12, 20);
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
