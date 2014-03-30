/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.util.*;

public class Bingo {
    
    /*Instance variables*/
    private ArrayList<Computer> computerPlayers = new ArrayList<Computer>();
    private int numberOfBingos;
    private boolean calledNumbers[] = new boolean[75];
    
    /*Default constructor.EAH
	This is unfinished because I am not sure what the control flow should be*/
    public Bingo() {
        BingoGUI bGUI = new BingoGUI();
		generateComputerPlayers();
		Human player = new Human();
		setNumberOfBingos(Player.totalPlayers);
	
		//bGUI.setVisible(true);
    }
    
    /*Generates random # of computer players. Increments totalPlayers.EAH*/
    public void generateComputerPlayers() {
        final int LOW = 50;
		final int HIGH = 75;
		
		Random rand = new Random();
		int randomInt = rand.nextInt(HIGH) + LOW;
		
		for(int i = 0; i < randomInt; i++){
			computerPlayers.add(new Computer());
		}
    }
    
    /*Sets number of Bingos.EAH*/
    public void setNumberOfBingos(int numberOfPlayers) {
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

    
    /*Updates the position of the recently called numbers. EAH*/
    public void changeBallPosition(int newCalledNumber) {
        
    }
    
    /*Speaks called number aloud.*/
    public void speakNumber(int numberToSpeak) {
        
    }
    
    /*Plays background music.*/ 
    public void playBackgroundMusic() {
        
    }
    
}
