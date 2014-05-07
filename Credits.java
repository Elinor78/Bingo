/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Dialog;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/*This is the GUI for showing the team's credits.*/
public class Credits extends JDialog{
    
    private final JLabel backgroundJL = new JLabel(new ImageIcon(getClass().getResource("/img/Credits/credits.png")));
    
    public Credits() {
        this.add(backgroundJL);
        this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
	this.setSize(300, 400);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
        this.setVisible(true);
    }
    
}
