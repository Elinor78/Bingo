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
    private final boolean calledNumbers[] = new boolean[75];
    private boolean areBingosLeft = true;
    private BingoGUI bGUI;
    
    ///// Testing number calls /////
    private final Random randomGen = new Random();
    private final ActionListener timerListener = new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent evt) {
	    bGUI.showNewNumber(randomGen.nextInt(75) + 1);
	}
     };
    private final javax.swing.Timer testBallTimer = new javax.swing.Timer(5000, timerListener);
    ///// Testing number calls /////
    
    /*Default constructor.EAH
	This is unfinished because I am not sure what the control flow should be*/
    public Bingo() {
        bGUI = new BingoGUI();
	generateComputerPlayers();
	Human player = new Human();
	setNumberOfBingos(Player.totalPlayers);

	bGUI.setVisible(true);

	testBallTimer.start();
    }
    
    /*Generates random # of computer players. Increments totalPlayers.EAH*/
    private void generateComputerPlayers() {
        final int LOW = 50;
		final int HIGH = 75;
		
		Random rand = new Random();
		int randomInt = rand.nextInt(HIGH) + LOW;
		
		for(int i = 0; i < randomInt; i++){
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
    
    /*Sets a called number in the calledNumbers array. EAH*/
    public void setNumberCalled(int numberCalled) {
        calledNumbers[numberCalled - 1] = true;
    }
    
    /*Checks if a number has been called or not. EAH*/
    public boolean isNumberCalled(int numberCalled) {
        
        return calledNumbers[numberCalled - 1];

    }
    
    /*Speaks called number aloud.*/
    public void speakNumber(int numberToSpeak) {
        
    }
    
    /*Plays background music.*/ 
    public void playBackgroundMusic() {
        
    }
    
    public static void main(String[] args) {
	// If player selected "Play Bingo"...
        Bingo newGame = new Bingo();
	// Else show Instructions or Credits
        //This is a test.
    }
    
}
