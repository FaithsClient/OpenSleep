package ft.sleep.util.win32;

public class ProcessesFactory {
   public static ProcessesService _capable() {
      if (OSDetector2._venues()) {
         return new WindowsProcessesService();
      } else if (OSDetector2._random()) {
         return new UnixProcessesService();
      } else {
         throw new UnsupportedOperationException("Your Operating System is not supported by this library.");
      }
   }
}
