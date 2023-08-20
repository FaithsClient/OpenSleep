package ft.sleep.util.music;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Objects;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.FloatControl.Type;

public class PlayMusic implements Runnable {
   public AudioInputStream nylon$;
   public String virtual$;
   public float giants$;

   public PlayMusic(String zevoroye, float fogasega) {
      senaziro.virtual$ = (String)zevoroye;
      senaziro.giants$ = (float)fogasega;
      super();
   }

   public void run() {
      Object thinking = AudioSystem.getClip();
      Object snapshot = AudioSystem.getAudioInputStream(new BufferedInputStream((InputStream)Objects.requireNonNull(balanced.getClass().getResourceAsStream("/assets/minecraft/sleep/" + balanced.virtual$))));
      thinking.open(snapshot);
      thinking.start();
      Object affairs = (FloatControl)thinking.getControl(Type.MASTER_GAIN);
      affairs.setValue(balanced.giants$);
      thinking.start();
   }
}
