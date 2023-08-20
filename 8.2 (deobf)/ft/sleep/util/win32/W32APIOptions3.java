package ft.sleep.util.win32;

import java.util.Collections;
import java.util.Map;

public interface W32APIOptions3 extends StdCallLibrary2 {
   Map moscow$ = Collections.unmodifiableMap(new W32APIOptions());
   Map latino$ = Collections.unmodifiableMap(new W32APIOptions2());
   Map optimal$ = Boolean.getBoolean("w32.ascii") ? latino$ : moscow$;
}
