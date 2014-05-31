/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

public class ChoosePlayer extends JDialog {
    private final JLabel backgroundJL = new JLabel(new ImageIcon(getClass().getResource("/img/ChoosePlayer/background.png")));
    private final JList<String> playersList = new JList<>();
    private final DefaultListModel<String> playersListModel = new DefaultListModel<>();
    static final ArrayList<String> newPlayers = new ArrayList<>();
    static final ArrayList<String> deletedPlayers = new ArrayList<>();
    private final Human player;
    
    public ChoosePlayer(Human p) {
	this.player = p;
	
	configureBackground();
        configureStartButton();
	configurePlayersList();
	configureNewPlayerButton();
	configureDeletePlayerButton();
	configureQuitButton();
	
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

    private void configureStartButton() {
	final JButton startButton = new JButton(new ImageIcon(getClass().getResource("/img/ChoosePlayer/startButton.png")));
	startButton.setContentAreaFilled(false);
	startButton.setFocusPainted(false);
	startButton.setBorder(null);
        startButton.setSize(200, 70);
        startButton.setLocation(100, 425);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
	    /*Retrieve the value from the list and set static player's name.*/
            public void mouseReleased(MouseEvent e) {
		if (!playersListModel.isEmpty()) {
		    if (playersList.getSelectedValue() == null) {
			System.out.println("Selected value was null");
			playersList.setSelectedIndex(0);
			Human.name = playersList.getSelectedValue();
		    }
		    else {
			Human.name = playersList.getSelectedValue();
		    }
		    ChoosePlayer.this.dispose();
		}
            }
        });
        backgroundJL.add(startButton);
    }

    private void configurePlayersList() {
	final JScrollPane playersScrollPane = new JScrollPane();
	
	updatePlayersList();
	
	playersScrollPane.setViewportView(playersList);
	playersScrollPane.setSize(220, 180);
	playersScrollPane.setLocation(90, 175);
	
	playersList.setModel(playersListModel);
	playersList.setFont(BingoGUI.getGameFont().deriveFont(30f));
	playersList.setSelectedIndex(0);
	
	this.add(playersScrollPane);
    }

    private void configureNewPlayerButton() {
	final JButton newPlayerButton = new JButton(new ImageIcon(getClass().getResource("/img/ChoosePlayer/addButton.png")));
	newPlayerButton.setContentAreaFilled(false);
	newPlayerButton.setFocusPainted(false);
	newPlayerButton.setBorder(null);
        newPlayerButton.setSize(150, 75);
        newPlayerButton.setLocation(45, 355);
        newPlayerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
		ChoosePlayer.this.setOpacity(0.75f);
		NewPlayer newPlayerDialog = new NewPlayer();
		if (newPlayerDialog.getNewPlayer() != null) {
		    String newPlayer = newPlayerDialog.getNewPlayer();
		    playersListModel.addElement(newPlayer);
		    playersList.setSelectedIndex(playersListModel.size() - 1);
		    newPlayers.add(newPlayer);
		}
		ChoosePlayer.this.setOpacity(1f);
            }
        });
        backgroundJL.add(newPlayerButton);
    }
    
    private void configureDeletePlayerButton() {
	final JButton deletePlayerButton = new JButton(new ImageIcon(getClass().getResource("/img/ChoosePlayer/deleteButton.png")));
	deletePlayerButton.setContentAreaFilled(false);
	deletePlayerButton.setFocusPainted(false);
	deletePlayerButton.setBorder(null);
        deletePlayerButton.setSize(150, 75);
        deletePlayerButton.setLocation(205, 355);
        deletePlayerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
		if (!playersList.isSelectionEmpty()) {
		    /*Save the name of the player to delete.*/
		String playerToDelete = playersList.getSelectedValue();
		/*Remove that player from the visual list.*/
		playersListModel.removeElement(playerToDelete);
		/*If that player had not been played before, just prevent adding it to the list.*/
		if (newPlayers.contains(playerToDelete)) {
		    newPlayers.remove(playerToDelete);
		}
		/*If it is an existing player, add it to the deletedPlayers list.*/
		else {
		    deletedPlayers.add(playerToDelete);
		}
		playersList.setSelectedIndex(0);
		}
            }
        });
        backgroundJL.add(deletePlayerButton);
    }
    
    /*Iterate through Set of player names and add to listmodel.*/
    private void updatePlayersList() {
	for (String name : player.getPlayerNames()) {
	    if (!name.equals("Default")) {
		playersListModel.addElement(name);
	    }
	}
    }

    private void configureQuitButton() {
	final JButton quitButton = new JButton(new ImageIcon(getClass().getResource("/img/ChoosePlayer/quitButton.png")));
	quitButton.setContentAreaFilled(false);
	quitButton.setFocusPainted(false);
	quitButton.setBorder(null);
        quitButton.setSize(31, 30);
        quitButton.setLocation(6, 4);
        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
		new ShutDownTask();
		System.exit(0);
            }
        });
        backgroundJL.add(quitButton);
    }

}
