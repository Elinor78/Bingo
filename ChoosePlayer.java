/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

public class ChoosePlayer extends JDialog {
    private final JLabel backgroundJL = new JLabel(new ImageIcon(getClass().getResource("/img/ChoosePlayer/background.png")));
    private final JList<String> playersList = new JList<>();
    private final DefaultListModel<String> playersListModel = new DefaultListModel<>();
    private final Font shopFont = BingoGUI.getGameFont().deriveFont(30f);
    private ArrayList<String> newPlayers = new ArrayList<>();
    private final Human player;
    
    public ChoosePlayer(Human p) {
	this.player = p;
	
	configureBackground();
        configureStoreButton();
	configurePlayersList();
	configureNewPlayerButton();
	
	this.add(backgroundJL);
	this.setSize(400, 500);
	this.setLocationRelativeTo(null);
	this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
	this.setAlwaysOnTop(true);
	this.setResizable(false);
	this.setUndecorated(true);
        this.setVisible(true);
    }

    private void configureBackground() {
	backgroundJL.setSize(400, 500);
        backgroundJL.setLocation(0, 0);
    }

    private void configureStoreButton() {
	final JButton startButton = new JButton(new ImageIcon(getClass().getResource("/img/ChoosePlayer/startButton.png")));
	startButton.setContentAreaFilled(false);
	startButton.setBorder(null);
        startButton.setSize(200, 100);
        startButton.setLocation(100, 380);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
	    /*Retrieve the value from the list and set static player's name.*/
            public void mouseReleased(MouseEvent e) {
		if (playersList.getSelectedValue() == null) {
		    playersList.setSelectedIndex(0);
		    player.setName(playersList.getSelectedValue());
		}
		else {
		    player.setName(playersList.getSelectedValue());
		}
		ChoosePlayer.this.dispose();
            }
        });
        backgroundJL.add(startButton);
    }

    private void configurePlayersList() {
	final JScrollPane playersScrollPane = new JScrollPane();
	
	updatePlayersList();
	
	playersScrollPane.setViewportView(playersList);
	playersScrollPane.setSize(220, 180);
	playersScrollPane.setLocation(90, 190);
	
	playersList.setModel(playersListModel);
	playersList.setFont(shopFont);
	playersList.setSelectedIndex(0);
	
	this.add(playersScrollPane);
    }

    private void configureNewPlayerButton() {
	final JButton newPlayerButton = new JButton(new ImageIcon(getClass().getResource("/img/ChoosePlayer/newPlayerButton.png")));
	newPlayerButton.setContentAreaFilled(false);
	newPlayerButton.setBorder(null);
        newPlayerButton.setSize(40, 36);
        newPlayerButton.setLocation(5, 6);
        newPlayerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
		NewPlayer newPlayerDialog = new NewPlayer(player);
		String newPlayer = newPlayerDialog.getNewPlayer();
		playersListModel.addElement(newPlayer);
		ChoosePlayer.this.newPlayers.add(newPlayer);
            }
        });
        backgroundJL.add(newPlayerButton);
    }
    
    /*Iterate through Set of player names and add to listmodel.*/
    private void updatePlayersList() {
	for (String name : player.getPlayerNames()) {
	    if (!name.equals("Default")) {
		playersListModel.addElement(name);
	    }
	}
    }
    
    public ArrayList<String> getNewPlayers() {
	return newPlayers;
    }
}
