/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

//package bingo;

public class Card {
    
    /*Public variables*/
    public static int totalCards;
    /*Instance variables*/
    private boolean isBingo;
    private int cardLayout[][];
    private boolean tokenPlacement[][];
    
    /*Empty constructor calls generateCardLayout().*/
    public Card(){
        
    }
    
    /*Sets isBingo to the value of win.*/
    public void setIsBingo(boolean win) {
        
    }
    
    /*Returns the value of isbingo.*/
    public boolean getIsBingo() {
        
        return isBingo;
    }
    
    /*Generates random numbers & writes to cardLayout.*/
    public void generateCardLayout() {
        
    }
    
    /*Change matching tokenPlacement bool value.*/
    public void toggleToken(int tokenCollumn, int tokenRow) {
        
    }
    
    /*Scans cardLayout & tokenPlacement for valid Bingo and sets isBingo.*/
    public boolean checkForBingo() {
        
        return ;
    }
    
    /*Dims card & disables input for 5 seconds.*/
    public void cardFreeze() {
        
    }
    
    /*Congratulates user & disables input on card.*/
    public void cardWin() {
        
    }
    
}
