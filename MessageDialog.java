/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public final class MessageDialog extends JDialog {
    private final JLabel backgroundJL = new JLabel(new ImageIcon(getClass().getResource("/img/RoundSummary/background.png")));
    private final JButton dialogButton = new JButton();
    private final JLabel dialogLabel = new JLabel();
    private String dialogMessage = null;
    private final Font dialogFont;
    
    public MessageDialog(String message, ImageIcon buttonImage) {
	this.dialogMessage = message;
	this.dialogButton.setIcon(buttonImage);
	int messageLength = message.length();
	
	/*I understand this is a pretty terrible way to do this. I plan on making it so that the text area
	fits into a certain bounding box and changes the font size based on getFontMetrics. */
	if (messageLength <= 18) {
	    dialogFont = BingoGUI.getGameFont().deriveFont(55f);
	}
	else if (messageLength <= 40) {
	    dialogFont = BingoGUI.getGameFont().deriveFont(45f);
	}
	else if (messageLength <= 80) {
	    dialogFont = BingoGUI.getGameFont().deriveFont(35f);
	}
	else
	    dialogFont = BingoGUI.getGameFont().deriveFont(20f);
	
	configureBackground();
	configureButton();
	configureLabel();
	
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
    
    public void configureLabel() {
	dialogLabel.setSize(250, 250);
        dialogLabel.setLocation(25, 5);
        dialogLabel.setFont(dialogFont);
	dialogLabel.setHorizontalAlignment(SwingConstants.CENTER);
	dialogLabel.setVerticalAlignment(SwingConstants.CENTER);
	dialogLabel.setText("<html><div style=\"text-align: center;\">" + dialogMessage + "</html>");
        this.add(dialogLabel);
    }
    
}
