package rip.sleep.module;

import org.json.JSONException;

public enum ModuleType {
   c13050(new ModuleType.c21190[]{ModuleType.c21190.c47958, ModuleType.c21190.c28329}),
   c31770(new ModuleType.c21190[]{ModuleType.c21190.c55384, ModuleType.c21190.c76367}),
   c62580(new ModuleType.c21190[]{ModuleType.c21190.c88511, ModuleType.c21190.c37885}),
   c12482(new ModuleType.c21190[]{ModuleType.c21190.c94221, ModuleType.c21190.c1301});

   private final ModuleType.c21190[] c25863;
   private static boolean c40163;

   public ModuleType.c21190[] c42698() {
      return this.c25863;
   }

   private ModuleType(ModuleType.c21190[] var3) {
      this.c25863 = var3;
   }

   static {
      c68579(true);
   }

   public static void c68579(boolean var0) {
      c40163 = var0;
   }

   public static boolean c80289() {
      return c40163;
   }

   public static boolean c34034() {
      boolean var0 = c80289();
      return true;
   }

   private static JSONException c27331(JSONException var0) {
      return var0;
   }

   public static enum c21190 {
      c47958("Rage", "a"),
      c28329("Legit", "e"),
      c88511("Main", "g"),
      c37885("Extras", "f"),
      c94221("Self", "m"),
      c1301("Overlay", "h"),
      c55384("Counterattack", "n"),
      c76367("Assist", "l");

      private final String c39075;
      private final String c64829;
      private static String c14417;

      private c21190(String var3, String var4) {
         this.c39075 = var3;
         this.c64829 = var4;
      }

      public String toString() {
         return this.c39075;
      }

      public String c25928() {
         return this.c64829;
      }

      static {
         c93810((String)null);
      }

      public static void c93810(String var0) {
         c14417 = var0;
      }

      public static String c65017() {
         return c14417;
      }
   }
}
