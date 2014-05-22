/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.locks.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bingo {
    
    /*Instance variables*/
    private final ArrayList<Computer> computerPlayers = new ArrayList<>(50);
    private int numberOfBingos;
    private final ArrayList<Integer> availableNumbers = populateNumberArray();
    private BingoGUI bGUI;
    public static Human player = new Human();
    private int nextNumber;
    private static final Lock lock = new ReentrantLock();
    private static final Condition noBingosLeft = lock.newCondition();
    
    /*Audio objects*/
    private static AudioPlayer bgMusic;
    private static AudioPlayer[] numbers;
    
    // Number calls
    private final Random randomGen = new Random();
    private final ActionListener callNewNumber = new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent evt) {
	    nextNumber = availableNumbers.get( randomGen.nextInt(availableNumbers.size()) );
	    bGUI.showNewNumber(nextNumber);
	    setNumberCalled(nextNumber);
	    for (Computer computer : computerPlayers) {
		computer.receiveNewNumber(nextNumber);
	    }
	}
     };
    private final javax.swing.Timer callNumberTimer = new javax.swing.Timer(5000, callNewNumber);
    
    public Bingo() {
	generateComputerPlayers();
	
	setInitialBingos();
	
        bGUI = new BingoGUI(this);
	bGUI.setVisible(true);
	
	callNumberTimer.start();
    }
    
    private ArrayList<Integer> populateNumberArray(){
		ArrayList<Integer> list = new ArrayList<>(75);
		for(int i = 1; i <= 75; i++){
			list.add(i);									
		}	
		return list;
	}
    
    /*Generates random # of computer players.EAH*/
    private void generateComputerPlayers() {
        final int LOWEST = 50;
	final int RANGE = 75;

	for(int i = 0; i < new Random().nextInt(RANGE) + LOWEST; i++){
	    computerPlayers.add(new Computer(this));
	}
    }
    
    /*Sets number of Bingos.EAH*/
    private void setInitialBingos() {
        numberOfBingos = ((Computer.totalComputerCards + player.getNumberOfCards()) / 3);
    }
    
    /*Gets number of Bingos.EAH*/
    public int getNumberOfBingos() {
        return numberOfBingos;
    }
    
    public void decrementBingos(Object o) {
	if (o instanceof Computer.ComputerCard) {
	    bGUI.newBingo.showClaimedBingo();
	}
	
	numberOfBingos--;
	bGUI.sw.updateAvailableBingos();
        
        /*If the number of bingos after decrementing is zero, this locks to only one thread which signals to the others to go ahead.*/
        if (numberOfBingos == 0) {
            lock.lock();
            try {
                noBingosLeft.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
    
    /*This method is locked to one thread which waits for the signal that no bingos are left.*/
    public void awaitNoBingosLeft() {
        lock.lock();
        try {
            noBingosLeft.await();
        } catch (InterruptedException ex) {
            System.out.println("Thread had trouble waiting.");
        }
        finally {
            lock.unlock();
        }
    }
    
    /*Method to dispose of the BingoGUI when the round is over.*/
    public void closeBingo() {
        bGUI.dispose();
	callNumberTimer.stop();
	Computer.totalComputerCards = 0;
	Computer.totalComputerPlayers = 0;
	computerPlayers.clear();
    }
    
    private void setNumberCalled(int numberCalled) {
        availableNumbers.remove((Integer)numberCalled);
    }
    
    // If numberCalled is not in availableNumbers, returns true.
    public boolean isNumberCalled(int numberCalled) {
	return Collections.binarySearch(availableNumbers, numberCalled) < 0;
    }
    
    // Returns true if all numbers in array were called.
    public boolean isNumberCalled(int[] array) {
	boolean allNumbersWereCalled = true;
	
	for (int i = 0; i < array.length; i++) {
	    if (!isNumberCalled(array[i])) {
		allNumbersWereCalled = false;
	    }
	}
	
	return allNumbersWereCalled;
    }
    
    /*Speaks called number aloud.*/
    public void speakNumber(int numberToSpeak) {
        
    }
    
    /*Plays background music.*/ 
    public void playBackgroundMusic() throws Exception {
        bgMusic = new AudioPlayer();
        bgMusic.loop();
    }
    
    public static void main(String[] args) {
        /*Load the shop interface with which to launch the game.*/
	Shop newShop = new Shop();
	/*Thread backgroundMusic = new Thread(new Runnable() {
	    AudioPlayer bgMusic;
	    @Override
	    public void run() {
		try {
		    bgMusic = new AudioPlayer();
		} catch (Exception ex) {
		    System.out.println("Something went wrong with audio.");
		}
		bgMusic.loop();
	    }
	});
	backgroundMusic.start();*/
    }

}
