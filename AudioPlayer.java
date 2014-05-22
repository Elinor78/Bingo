/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import java.io.File;
import javax.sound.sampled.*;

public class AudioPlayer {

	static Clip clip;

	public AudioPlayer() throws Exception {
	    System.out.println("In AudioPlayer()");
	    clip = AudioSystem.getClip();
	    System.out.println("Got Clip");
	    AudioInputStream ais = AudioSystem.getAudioInputStream(new File("/Audio/backgroundMusic.wav"));
	    System.out.println("Saved Input Stream");
	    clip.open(ais);
	    System.out.println("Open Input Stream");
	}

	public void play() {
	    clip.start();
	}

	public void loop() {
	    clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stop() {
	    if(clip.isRunning()) {
		clip.stop();
	    }
	}

	public void close() {
	    stop();
	    clip.close();
	}

}