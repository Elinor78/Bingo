/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

import javax.sound.sampled.*;

public class AudioPlayer {

	private final Clip clip;

	public AudioPlayer() throws Exception {
	    AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Audio/backgroundMusic.wav"));
	    clip = AudioSystem.getClip();
	    clip.open(ais);
	    
	    // Set volume of music
	    FloatControl volume = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
	    volume.setValue(-15.0f);
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