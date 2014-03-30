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
    
    /*Default constructor.EAH*/
    public Bingo() {
        
    }
    
    /*Generates random # of computer players. Increments totalPlayers.EAH*/
    public void generateComputerPlayers() {
        final int LOW = 1;
		final int HIGH = 20;
		
		Random rand = new Random();
		int randomInt = rand.nextInt(HIGH) + LOW;
		
		for(int i = 0; i < randomInt; i++){
			computerPlayers.add(new Computer());
			Player.totalPlayer++;
		}
    }
    
    /*Sets number of Bingos.EAH*/
    public void setNumberOfBingos(int numberOfBingos) {
        this.numberOfBingos = numberOfBingos;
    }
    
    /*Gets number of Bingos.EAH*/
    public int getNumberOfBingos() {
        return numberOfBingos;
    }
    
    /*Calls a new number to be displayed for player.EAH*/
    public void callNumber() {
        
    }
    
    /*Sets a called number in the calledNumbers array. EAH*/
    public void setNumberCalled(int numberCalled) {
        
    }
    
    /*Checks if a number has been called or not. EAH*/
    public boolean isNumberCalled(int numberCalled) {
        
        return false;

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
