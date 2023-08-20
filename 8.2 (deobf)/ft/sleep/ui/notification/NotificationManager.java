//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.notification;

import ft.sleep.api.EventBus;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender2D;
import ft.sleep.module.modules.HUD;
import ft.sleep.ui.font.FontLoaders;
import ft.sleep.util.render.RenderUtil2;

import java.awt.Color;
import java.util.concurrent.CopyOnWriteArrayList;

public class NotificationManager {
   public CopyOnWriteArrayList calcium$ = new CopyOnWriteArrayList();

   public NotificationManager() {
      EventBus.getInstance().register(ipeminep);
   }

   @EventHandler
   public void _pending(EventRender2D variable) {
      Object prayers = ((EventRender2D)variable).getSR();
      Object hawaii = 25;

      for(Object struct : ecuador.calcium$) {
         Object allowed = FontLoaders.kiona17;
         Object startup = FontLoaders.kiona14;
         Object rational = struct._boxed().name().charAt(0) + struct._boxed().name().substring(1).toLowerCase();
         Object copper = Math.max(allowed.getStringWidth(rational), startup.getStringWidth(struct._sticks() + 4));
         Object resolved = struct._rebel()._heath();
         Object contract = struct._rebel()._speech();
         RenderUtil2._promoted((double)((float)prayers.getScaledWidth() - resolved - 15.0F), (double)((float)prayers.getScaledHeight() - contract - 22.0F), (double)(prayers.getScaledWidth() - 5), (double)((float)prayers.getScaledHeight() - contract), 3.0D, (new Color(7, 7, 7, 140)).getRGB());
         startup.drawString(struct._sticks(), (float)prayers.getScaledWidth() - resolved - 12.0F, (float)prayers.getScaledHeight() - contract - 9.0F, -1);
         allowed.drawString(rational, (float)prayers.getScaledWidth() - resolved - 12.0F, (float)prayers.getScaledHeight() - contract - 19.0F, (new Color(HUD.during$.getValue().intValue())).getRGB());
         FontLoaders.logo18.drawString("g", (float)(prayers.getScaledWidth() - 15), (float)prayers.getScaledHeight() - contract - 18.0F, (new Color(HUD.during$.getValue().intValue())).getRGB());
         if (struct.sitemap$) {
            struct._rebel()._watts((float)copper, -20.0F, 0.15F);
         } else if (struct._hiking()._refined(struct._holding())) {
            struct._rebel()._watts((float)copper, (float)hawaii, 0.15F);
            hawaii += 30;
         } else {
            struct._rebel()._watts((float)copper, (float)hawaii, 0.15F);
            hawaii += 35;
         }

         if (struct._before()._refined(struct._holding() + ((long)-903906258 ^ -903905830L))) {
            struct.sitemap$ = true;
         }

         if (struct._rebel()._speech() < -19.0F) {
            ecuador.calcium$.remove(struct);
         }
      }

   }

   public CopyOnWriteArrayList _arabia() {
      return rising.calcium$;
   }
}
