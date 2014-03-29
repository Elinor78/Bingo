/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.util.*;

public class Bingo {
    
    /*Instance variables*/
    private ArrayList<Computer> computerPlayers;
    private int numberOfBingos;
    private boolean calledNumbers[] = new boolean[75];
    
    /*Default constructor.*/
    public Bingo() {
        
    }
    
    /*Generates random # of computer players. Increments totalPlayers.*/
    public void generateComputerPlayers() {
        
    }
    
    /*Sets number of Bingos.*/
    public void setNumberOfBingos(int numberOfBingos) {
        
    }
    
    /*Gets number of Bingos.*/
    public int getNumberOfBingos() {
        return numberOfBingos;
    }
    
    /*Calls a new number to be displayed for player.*/
    public void callNumber() {
        
    }
    
    /*Sets a called number in the calledNumbers array.*/
    public void setNumberCalled(int numberCalled) {
        
    }
    
    /*Checks if a number has been called or not.*/
    public boolean isNumberCalled(int numberCalled) {
        return calledNumbers[numberCalled -1];
    }
    
    /*Updates the position of the recently called numbers.*/
    public void changeBallPosition(int newCalledNumber) {
        
    }
    
    /*Speaks called number aloud.*/
    public void speakNumber(int numberToSpeak) {
        
    }
    
    /*Plays background music.*/ 
    public void playBackgroundMusic() {
        
    }
    
}
