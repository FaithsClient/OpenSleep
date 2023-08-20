package ft.sleep.util.music;

public class PlayMusic2 {
   public static synchronized void _situated(String anime, float speeches) {
      (new Thread(new PlayMusic((String)anime, (float)speeches))).start();
   }
}
