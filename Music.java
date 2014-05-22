/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import javax.swing.*;

public class Music {
    private static AudioPlayer bgMusic;
    private static AudioPlayer[] numbers;

    public static void main (String[] args) throws Exception {
	bgMusic = new AudioPlayer();
	numbers = new AudioPlayer[75];
	bgMusic.play();
	System.out.println("Done");
	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // A GUI element to prevent the Clip's daemon Thread
                // from terminating at the end of the main()
                JOptionPane.showMessageDialog(null, "Close to exit!");
            }
        });
    }
}