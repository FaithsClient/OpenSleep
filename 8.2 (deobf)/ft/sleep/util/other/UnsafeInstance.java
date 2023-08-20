package ft.sleep.util.other;

import sun.misc.Unsafe;

public class UnsafeInstance {
   public static Unsafe essays$;

   static {
      Object ilodefel = Unsafe.class.getDeclaredField("theUnsafe");
      ilodefel.setAccessible(true);
      essays$ = (Unsafe)ilodefel.get((Object)null);
   }
}
