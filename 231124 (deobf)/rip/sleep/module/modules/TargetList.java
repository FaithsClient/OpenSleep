package rip.sleep.module.modules;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.entity.Entity;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.Render2DEventA;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.ui.font.FontManager;
import rip.sleep.util.MathUtilB;
import rip.sleep.util.RenderUtilB;
import rip.sleep.util.TargetUtil;
import rip.sleep.value.Value;

public class TargetList extends Module {
   private static int c63014 = 118;
   private static int c94566 = 34;

   public TargetList() {
      super("Target List", new String[]{"TargetList"}, ModuleType.c12482, ModuleType.c21190.c94221);
   }

   public static int c70725() {
      return c63014;
   }

   public static void c93075(int var0) {
      c63014 = var0;
   }

   public static int c78433() {
      return c94566;
   }

   public static void c92639(int var0) {
      c94566 = var0;
   }

   public static boolean c91289(int var0, int var1) {
      Module[] var2 = Value.c27574();
      boolean var3;
      if (MathUtilB.c23165((double)var0, (double)var1, (double)(c63014 + 110), (double)(c94566 + 35), (double)(c63014 + 10), (double)(c94566 + 15))) {
         Sleep var10000 = Sleep.INSTANCE;
         Sleep.c33759();
         if (ModuleManager.c25475(TargetList.class).c24622()) {
            var3 = true;
            return var3;
         }
      }

      var3 = false;
      return var3;
   }

   private List<Entity> c4802() {
      return (List) mc.theWorld.getLoadedEntityList().stream().filter((var0) -> {
         return TargetUtil.c45033(var0);
      }).collect(Collectors.toCollection(ArrayList::new));
   }

   @EventTarget
   void c44340(Render2DEventA var1) {
      int var3 = 13;
      byte var4 = 10;
      byte var5 = 8;
      Value.c27574();
      List var6 = this.c4802();
      int var7 = 0;
      Iterator var8 = var6.iterator();
      if (var8.hasNext()) {
         Entity var9 = (Entity)var8.next();
         var3 += FontManager.c58773.c5657() + 1;
         int var10 = FontManager.c58773.c65036(var9.getDisplayName().getFormattedText());
         if (var10 > var7) {
            var7 = var10;
         }
      }

      GL11.glPushMatrix();
      GL11.glTranslatef((float)c63014, (float)c94566, 0.0F);
      var7 = Math.max(100, var7 + 25);
      var7 = var7 + (var7 == 100 ? 0 : 30);
      var3 = var3 - (FontManager.c58773.c5657() + 1);
      if (var6.isEmpty()) {
         var3 -= 2;
      }

      RenderUtilB.c12036((double)var4, (double)(var5 + 10), (double)(var4 + var7 - 8), (double)(var5 + var3));
      FontManager.c48288.c12918("Targets", (double)(var4 + 5), (double)(var5 + 16), Color.WHITE.getRGB(), false);
      int var14 = var5 + 20;
      Iterator var15 = var6.iterator();
      if (var15.hasNext()) {
         Entity var16 = (Entity)var15.next();
         FontManager.c53569.c59386(var16.getDisplayName().getFormattedText(), (float)var4 + 5.5F, (float)(var14 + 4), (new Color(200, 200, 200, 255)).getRGB());
         int var10000 = var14 + FontManager.c53569.c5657() + 2;
      }

      GL11.glPopMatrix();
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
