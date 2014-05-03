//import AudioPlayer;
import javax.swing.*;

public class Music {
	private static AudioPlayer2 bgMusic;
	private static AudioPlayer2[] numbers;

	public static void main (String[] args) throws Exception {
		bgMusic = new AudioPlayer2();
		numbers = new AudioPlayer2[75];
		bgMusic.play();
		System.out.println("Done");
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // A GUI element to prevent the Clip's daemon Thread
                // from terminating at the end of the main()
                JOptionPane.showMessageDialog(null, "Close to exit!");
            }
        });

	}
}