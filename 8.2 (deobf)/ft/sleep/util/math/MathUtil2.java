package ft.sleep.util.math;

public class MathUtil2 {
   public static byte knight$ = 0;
   public static byte ensuring$ = 1;
   public static byte shell$ = 2;
   public static byte discount$ = 3;
   public static byte theory$ = 4;
   public static byte removed$ = 5;

   public static byte _jackets(Class licking) {
      if (licking == Short.class) {
         return 0;
      } else if (licking == Byte.class) {
         return 1;
      } else if (licking == Integer.class) {
         return 2;
      } else if (licking == Float.class) {
         return 3;
      } else if (licking == Double.class) {
         return 4;
      } else {
         return (byte)(licking == Long.class ? 5 : -1);
      }
   }
}
