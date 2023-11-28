package rip.sleep.util;

import java.lang.reflect.Field;
import org.lwjgl.input.Mouse;

public class MouseUtil {
   private static Field c83531;
   private static String c12750;

   public static void c22690(Object[] param0) {
      // $FF: Couldn't be decompiled
   }

   public static void c26507(String var0) {
      c12750 = var0;
   }

   public static String c72780() {
      return c12750;
   }

   static {
      if (c72780() == null) {
         c26507("kSNXuc");
      }

      Class var10000 = Mouse.class;
      String var10001 = "buttons";

      try {
         c83531 = var10000.getDeclaredField(var10001);
      } catch (NoSuchFieldException var9) {
         var9.printStackTrace();
      }

   }

   private static ReflectiveOperationException c61025(ReflectiveOperationException var0) {
      return var0;
   }
}
