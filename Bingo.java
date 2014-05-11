/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Bingo {
    
    /*Instance variables*/
    private final ArrayList<Computer> computerPlayers = new ArrayList<>();
    private int numberOfBingos;
    private final ArrayList<Integer> availableNumbers = populateNumberArray();
    private boolean areBingosLeft = true;
    private BingoGUI bGUI;
    public static Human player = new Human();
    private int nextNumber;
    
    ///// Testing number calls /////
    private final Random randomGen = new Random();
    private final ActionListener callNewNumber = new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent evt) {
	    nextNumber = availableNumbers.get( randomGen.nextInt(availableNumbers.size()) );
	    bGUI.showNewNumber(nextNumber);
	    setNumberCalled(nextNumber);
	}
     };
    private final javax.swing.Timer testBallTimer = new javax.swing.Timer(5000, callNewNumber);
    ///// Testing number calls /////
    
    /*Default constructor.EAH
	This is unfinished because I am not sure what the control flow should be*/
    public Bingo() {
	generateComputerPlayers();
	setNumberOfBingos(Computer.NumComputerPlayers + 1);
        bGUI = new BingoGUI(this);

	bGUI.setVisible(true);
System.out.println("Number of Computer: " + computerPlayers.size());
System.out.println("Number of bingos: " + numberOfBingos);
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
	    computerPlayers.add(new Computer());
	}
    }
    
    /*Sets number of Bingos.EAH*/
    private void setNumberOfBingos(int numberOfPlayers) {
        numberOfBingos = (int)(0.4*numberOfPlayers);
    }
    
    /*Gets number of Bingos.EAH*/
    public int getNumberOfBingos() {
        return numberOfBingos;
    }
    
    /*Calls a new number to be displayed for player.EAH*/
	/*changed return from void to int - EAH */
    public void callNumber() {
		while(areBingosLeft()){
			boolean isCalled = true;			
			Random rand = new Random();
			int randomNumber = rand.nextInt(75) + 1;
			while(isCalled){
				if(isNumberCalled(randomNumber)){
					isCalled = true;
					rand = new Random();
					randomNumber = rand.nextInt(75) +1;
				}
				else{
					setNumberCalled(randomNumber);
					isCalled = false;
				}
			}
			speakNumber(randomNumber);//We also need some method to control where this is sent so it can be displayed.
		}
    }
	/* */
	public boolean areBingosLeft(){
		return true;
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
