/*
 * CS 56 Team #1 - Bingo
 * Authors: Joshua Wallace, Sidney Eubanks, Greg Knight, 
 * Elinor Huntington, Linus Carlsson, Armand Flores
 */

package Source;

import javax.sound.sampled.*;

public class AudioPlayer {

	private Clip clip;

	public AudioPlayer() throws Exception {
	    clip = AudioSystem.getClip();
	    AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource("/Audio/backgroundMusic.wav"));
	    clip.open(ais);
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