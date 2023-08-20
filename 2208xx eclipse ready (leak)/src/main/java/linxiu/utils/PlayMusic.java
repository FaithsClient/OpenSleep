package linxiu.utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.BufferedInputStream;
import java.util.Objects;

public class PlayMusic {

	public static synchronized void playSound(final String url, float volume) {
		new Thread(new Runnable() {
			AudioInputStream as;

			// The wrapper thread is unnecessary, unless it blocks on the
			// Clip finishing; see comments.
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(Objects
							.requireNonNull(this.getClass().getResourceAsStream("/assets/minecraft/sleep/" + url))));
					clip.open(inputStream);
					clip.start();
					FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
					gainControl.setValue(volume); // Reduce volume by 10 decibels.
					clip.start();
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}).start();
	}
}
