package rip.sleep.ui.notification;

import java.awt.Color;
import java.util.Objects;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.ui.font.FontManager;
import rip.sleep.value.Value;

public class NotificationTypeA {
   public String c60156;
   public String c98928;
   public int c94372;
   public int c71536;
   private static final int c29870 = (new Color(255, 80, 80)).getRGB();
   private static final int c33018 = (new Color(135, 227, 49)).getRGB();
   private static final int c24710 = (new Color(255, 215, 100)).getRGB();
   private static final int c16992 = (new Color(255, 255, 255)).getRGB();

   public NotificationTypeA(String var1, String var2, int var3) {
      this.c60156 = var1;
      this.c98928 = var2;
      this.c94372 = var3;
   }

   public void c26404() {
      this.c71536 = 8 * this.c94372 + 12;
      FontManager.c84287.c59386(this.c98928, 100.0F, (float)(6 + this.c71536), this.c22369(this.c98928));
      FontManager.c27293.c59386(this.c60156, (float)(103 + FontManager.c84287.c65036(this.c98928)), (float)(5 + this.c71536), -1);
   }

   public int c22369(String var1) {
      Module[] var2 = Value.c27574();
      if (Objects.equals(var1, "I")) {
         return c29870;
      } else if (var1.equals("J")) {
         return c24710;
      } else if (var1.equals("H")) {
         return c33018;
      } else {
         return var1.equals("K") ? c16992 : -1;
      }
   }

   private static JSONException c6184(JSONException var0) {
      return var0;
   }
}
