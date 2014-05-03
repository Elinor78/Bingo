import java.io.File;
import javax.sound.sampled.*;

public class AudioPlayer2 {

	static Clip clip;

	public AudioPlayer2() throws Exception {
		clip = AudioSystem.getClip();
        AudioInputStream ais = AudioSystem.getAudioInputStream( new File("level1-1.wav") );
        clip.open(ais);
	}

	public static void play() {
		clip.start();
	}

	public static void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stop() {
		if(clip.isRunning()) clip.stop();
	}

	public void close() {
		stop();
		clip.close();
	}

}