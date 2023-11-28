package rip.sleep.management;

import rip.sleep.event.EventBus;
import java.awt.Color;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.client.gui.ScaledResolution;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.Render2DEventA;
import rip.sleep.module.modules.HUD;
import rip.sleep.ui.notification.Notification;
import rip.sleep.ui.font.FontManager;
import rip.sleep.ui.font.FontRendererB;
import rip.sleep.util.ColorUtil;
import rip.sleep.util.RenderUtilF;
import rip.sleep.value.Value;

public class NotificationManager {
   private final CopyOnWriteArrayList<Notification> c81361 = new CopyOnWriteArrayList();

   public NotificationManager() {
      EventBus.getInstance().register(this);
   }

   @EventTarget
   void c90652(Render2DEventA var1) {
      Value.c27574();
      ScaledResolution var3 = var1.c26056();
      int var4 = 25;
      Iterator var5 = this.c81361.iterator();
      if (var5.hasNext()) {
         Notification var6 = (Notification)var5.next();
         FontRendererB var7 = FontManager.c54334;
         FontRendererB var8 = FontManager.c43464;
         String var9 = var6.c53608().name().charAt(0) + var6.c53608().name().substring(1).toLowerCase();
         int var10 = Math.max(var7.c65036(var9), var8.c65036(var6.c31064() + 4));
         float var11 = var6.c92876().c57180();
         float var12 = var6.c92876().c57180();
         float var13 = var6.c92876().c19122();
         int var14 = ColorUtil.c3182(new Color(HUD.c64734.c41161().intValue()), (int)((float)var3.getScaledWidth() - var11 - 0.0F), 14).getRGB();
         RenderUtilF.c6631((double)((float)var3.getScaledWidth() - var11 - 10.0F), (double)((float)var3.getScaledHeight() - var13 - 13.0F), (double)(var3.getScaledWidth() - 5), (double)((float)var3.getScaledHeight() - var13), 3.0D, (new Color(7, 7, 7, 140)).getRGB());
         RenderUtilF.c38259((double)((float)var3.getScaledWidth() - Math.max(var11 * (float)(var6.c21476() - var6.c17863().c75337()) / (float)var6.c21476(), 0.0F) - 5.0F), (double)((float)var3.getScaledHeight() - var13 - 1.0F), (double)(var3.getScaledWidth() - 5), (double)((float)var3.getScaledHeight() - var13), var14);
         var8.c59386(var6.c31064(), (float)var3.getScaledWidth() - var11 - 6.0F, (float)var3.getScaledHeight() - var13 - 8.5F, -1);
         if (var6.c33063) {
            var6.c92876().c21288((float)var10, -20.0F, 0.15F);
         }

         if (var6.c17863().c75125(var6.c21476())) {
            var6.c92876().c21288((float)var10, (float)var4, 0.15F);
            var4 += 10;
         }

         var6.c92876().c21288((float)var10, (float)var4, 0.15F);
         var4 = var4 + 20;
         if (var6.c67096().c75125(var6.c21476() + 0L)) {
            var6.c33063 = true;
         }

         if (var6.c92876().c19122() < -19.0F) {
            this.c81361.remove(var6);
         }
      }

   }

   public CopyOnWriteArrayList<Notification> c43114() {
      return this.c81361;
   }

   private static JSONException c89436(JSONException var0) {
      return var0;
   }
}
