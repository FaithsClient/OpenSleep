package ft.sleep.util.win32;

import com.sun.jna.Callback;

public interface DLLCallback extends Callback {
   int flush$ = 16;
}
