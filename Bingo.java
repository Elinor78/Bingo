/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.concurrent.locks.*;

public class Bingo {
    
    /*Instance variables*/
    private final ArrayList<Computer> computerPlayers = new ArrayList<>();
    private int numberOfBingos;
    private final ArrayList<Integer> availableNumbers = populateNumberArray();
    private BingoGUI bGUI;
    public static Human player = new Human();
    private int nextNumber;
    private static final Lock lock = new ReentrantLock();
    private static final Condition noBingosLeft = lock.newCondition();
    
    ///// Testing number calls /////
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
    private final javax.swing.Timer testBallTimer = new javax.swing.Timer(5000, callNewNumber);
    ///// Testing number calls /////
    
    /*Default constructor.EAH
	This is unfinished because I am not sure what the control flow should be*/
    public Bingo() {
	generateComputerPlayers();
	
	/*The ratio I came up with is all the computer cards divided by 4. It comes out to close to the iPad game we looked at.*/
	setInitialBingos((Computer.totalComputerCards + player.getNumberOfCards()) / 4);
	
        bGUI = new BingoGUI(this);
	bGUI.setVisible(true);
	
	testBallTimer.start();
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
    private void setInitialBingos(int numberOfPlayers) {
        numberOfBingos = (int)(0.4*numberOfPlayers);
    }
    
    /*Gets number of Bingos.EAH*/
    public int getNumberOfBingos() {
        return numberOfBingos;
    }
    
    public void decrementBingos() {
	System.out.println("In decrement bingos");
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
    public void closeBingoGUI() {
        bGUI.dispose();
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
    public void playBackgroundMusic() {
        
    }
    
    public static void main(String[] args) {
        /*Load the shop interface with which to launch the game.*/
	Shop newShop = new Shop();  
    }

}
