/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Dialog;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/*This is the GUI for showing the game rules.*/
public class Rules extends JDialog {
    
    public Rules() {
        this.add(new JLabel(new ImageIcon(getClass().getResource("/img/Rules/rules.png"))));
	this.setSize(700, 500);
	this.setLocationRelativeTo(null);
	this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
	this.setAlwaysOnTop(true);
	this.setResizable(false);
        this.setVisible(true);
    }
}