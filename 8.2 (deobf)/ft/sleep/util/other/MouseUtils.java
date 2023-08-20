package ft.sleep.util.other;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import org.lwjgl.input.Mouse;

public class MouseUtils {
   public static Field specs$;
   public static String flooring$;

   public static void _courts(Object[] carrier) {
      Object today = ((Integer)((Object[])carrier)[0]).intValue();
      Object generate = ((Boolean)((Object[])carrier)[1]).booleanValue();
      specs$.setAccessible(true);
      Object eleven = (ByteBuffer)specs$.get((Object)null);
      specs$.setAccessible(false);
      eleven.put(today, (byte)(generate ? 1 : 0));
   }

   public static void _decrease(String worry) {
      flooring$ = (String)worry;
   }

   public static String _strap() {
      return flooring$;
   }

   static {
      if (_strap() == null) {
         _decrease("kSNXuc");
      }

      specs$ = Mouse.class.getDeclaredField("buttons");
   }
}
