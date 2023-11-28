package rip.sleep.util;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Objects;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.FloatControl.Type;

public class SoundPlayerA {
   public static synchronized void c24997(final String var0, final float var1) {
      (new Thread(new Runnable() {
         AudioInputStream c29981;

         public void run() {
            try {
               Clip var1x = AudioSystem.getClip();
               AudioInputStream var2 = AudioSystem.getAudioInputStream(new BufferedInputStream((InputStream)Objects.requireNonNull(this.getClass().getResourceAsStream("/assets/minecraft/sleep/" + var0))));
               var1x.open(var2);
               var1x.start();
               FloatControl var3 = (FloatControl)var1x.getControl(Type.MASTER_GAIN);
               var3.setValue(var1);
               var1x.start();
            } catch (Exception var4) {
               System.err.println(var4.getMessage());
            }

         }
      })).start();
   }
}
