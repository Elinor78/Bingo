/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.concurrent.locks.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

public class Bingo {
    
    /*Instance variables*/
    private final ArrayList<Computer> computerPlayers = new ArrayList<>(50);
    private int numberOfBonusTickets = 10;
    private int numberOfBingos;
    private final ArrayList<Integer> availableNumbers = populateNumberArray();
    private BingoGUI bGUI;
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
	    speakNumber(nextNumber);
	    
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
        numberOfBingos = ((Computer.totalComputerCards + Shop.player.getNumberOfCards()) / 2);
    }
    
    /*Gets number of Bingos.EAH*/
    public int getNumberOfBingos() {
        return numberOfBingos;
    }
    
    public int getBonusTicketsLeft() {
	return numberOfBonusTickets;
    }
    
    public void decrementBingos(Object o) {
	if (o instanceof Computer.ComputerCard) {
	    bGUI.newNotification.showClaimedBingo();
	}
	
	if (numberOfBonusTickets > 0) {
	    numberOfBonusTickets--; // Claim a bonus ticket for the first 10 bingos
	}
	
	numberOfBingos--;
	bGUI.sw.updateAvailableBingos();
        
        if (numberOfBingos == 0) {
            signalNoBingosLeft();
        }
    }
    
    /*This locks to only one thread which signals to the others to go ahead.*/
    public void signalNoBingosLeft() {
	lock.lock();
        try {
	    noBingosLeft.signalAll();
        } finally {
	    lock.unlock();
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
        Thread sayNumber = new Thread(new SayNumberTask(numberToSpeak));
	sayNumber.start();
    }
    
    private class SayNumberTask implements Runnable {
	char letter;
	int number;
	boolean okayToProceed = false;
	Clip letterClip;
	Clip numberClip;
	
	public SayNumberTask(int numberToSpeak) {
	    number = numberToSpeak;
	}
	
	@Override
	public void run() {
	    try {
		if (number <= 15) {
		    letter = 'B';
		}
		else if (number <= 30) {
		    letter = 'I';
		}
		else if (number <= 45) {
		    letter = 'N';
		}
		else if (number <= 60) {
		    letter = 'G';
		}
		else {
		    letter = 'O';
		}
		
		letterClip = AudioSystem.getClip();
		AudioInputStream letterAIS = AudioSystem.getAudioInputStream(getClass().getResource("/Audio/Bingo Voice/" + letter + ".aif"));
		
		numberClip = AudioSystem.getClip();
		AudioInputStream numberAIS = AudioSystem.getAudioInputStream(getClass().getResource("/Audio/Bingo Voice/" + number + ".aif"));
		
		LineListener listener = new LineListener() {
		    @Override
		    public void update(LineEvent event) {
			LineEvent.Type type = event.getType();

			if (type == LineEvent.Type.STOP) {
			    okayToProceed = true;
			    if (event.getSource() == letterClip) {
				letterClip.close();
			    }
			    else {
				numberClip.close();
			    }
			}
		    }
		};
		letterClip.addLineListener(listener);
		numberClip.addLineListener(listener);

		letterClip.open(letterAIS);
		letterClip.start();
		
		Thread.sleep(500);
		
		numberClip.open(numberAIS);
		numberClip.start();
	    }
	    catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
		System.out.println("Something went wrong with saying the number.");
		System.out.println(ex.getMessage());
	    }
	    catch (InterruptedException ex) {
		Logger.getLogger(Bingo.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
    
    /*Plays background music.*/ 
    public void playBackgroundMusic() throws Exception {
        bgMusic = new AudioPlayer();
        bgMusic.loop();
    }
    
    public static void main(String[] args) {
        /*Load the shop interface with which to launch the game.*/
	Thread backgroundMusic = new Thread(new Runnable() {
	    AudioPlayer bgMusic;
	    @Override
	    public void run() {
		try {
		    bgMusic = new AudioPlayer();
		    bgMusic.loop();
		} catch (Exception ex) {
		    System.out.println("Something went wrong with the background music.");
		    System.out.println(ex.getMessage());
		}
	    }
	});
	backgroundMusic.start();
	
	Shop newShop = new Shop();
	
	Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	    
	    @Override
	    public void run() {
		/*Write the current balance to the user's home directory when the program is exited in any way.*/
		File propertiesFile = new File(System.getProperty("user.home") + "/bingo.properties");
		Properties ticketProperties = new Properties();
		InputStream ticketInputStream = null;
		OutputStream ticketOutputStream = null;

		try {
		    ticketInputStream = new FileInputStream(propertiesFile);
		    ticketProperties.load(ticketInputStream);
		    ticketProperties.setProperty(Shop.player.getName(), String.valueOf(Shop.player.getCurrentBalance()));
		    ticketOutputStream = new FileOutputStream(propertiesFile);
		    ticketProperties.store(ticketOutputStream, null);
		} catch (FileNotFoundException e) {
		    System.out.println("Could not write ticket balance. File Not Found");
		} catch (IOException ex) {
		    System.out.println("Could not write ticket balance. IO Exception");
		}
		finally {
		    try {
			if (ticketOutputStream != null) {
			    ticketOutputStream.close(); 
			}
			if (ticketInputStream != null) {
			    ticketInputStream.close();
			}
		    } catch (IOException ex) {
			System.out.println("Could not close output stream.");
		    }
		}
	    }
	}));
    }

}
