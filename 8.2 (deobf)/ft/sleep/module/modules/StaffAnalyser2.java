//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.Client;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender2D;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.injection.Hypixel;
import java.awt.Color;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import ft.sleep.util.render.RenderUtils;
import ft.sleep.util.render.RoundedUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

public class StaffAnalyser2 extends Module {
   public Minecraft fancy$ = Minecraft.getMinecraft();
   public boolean surname$ = false;
   public static Numbers quilt$ = new Numbers("Delay", 10.0D, 1.0D, 60.0D, 1.0D);
   public static Option strike$ = new Option("Render", true);
   public static Option talented$ = new Option("Message", true);
   public static Option breeding$ = new Option("New Render", true);

   public StaffAnalyser2() {
      super("Staff Analyser", new String[]{"ft.sleep.module.modules.StaffAnalyser"}, ModuleType.ignored$);
   }

   @EventHandler
   public void _funded(EventRender2D lotasiba) {
      Object avobibas = ((long)940899810 ^ 940899850L) * quilt$.getValue().longValue();
      Object malumaye = new ScaledResolution(usafafeb.fancy$);
      Object yifesecu = malumaye.getScaledWidth();
      Object peruboro = malumaye.getScaledHeight();
      if (Hypixel.bansSinceStart == null) {
         Hypixel.getBanStats();
      } else {
         Object obesegic = (System.currentTimeMillis() - Client.crowd$) / ((long)-102480399 ^ -102480359L);
         Object cocofano = "";
         if (obesegic > ((long)-1902615717 ^ -1902615705L)) {
            Object atezimim = Double.toString(Math.floor((double)(obesegic / ((long)-1724223499 ^ -1724223543L))));
            cocofano = atezimim.substring(0, atezimim.indexOf(".")) + "m " + obesegic % ((long)-899352395 ^ -899352439L) + "s";
         } else {
            cocofano = obesegic + "s";
         }

         Object var17 = 5.0F;
         Object difeyozu = 36.0F;
         float var12 = 18.0F;
         float var13 = 26.0F;
         float var14 = 11.0F;
         Client.î ?();
         Client.î ?();
         if (ModuleManager._herbs(HUD.class)._central() && HUD.seems$.getValue().booleanValue()) {
            if (breeding$.getValue().booleanValue()) {
               var17 = 35.0F;
               difeyozu = 35.0F;
               var12 = 48.0F;
               var13 = 56.0F;
               var14 = 41.0F;
            } else {
               var17 = 35.0F;
               difeyozu = 66.0F;
               var12 = 48.0F;
               var13 = 56.0F;
               var14 = 41.0F;
            }
         }

         if (strike$.getValue().booleanValue()) {
            float var15 = (float)usafafeb.fancy$.fontRendererObj.getStringWidth(Hypixel.bansSinceStart[0] + " <- Watchdog | Staff -> " + Hypixel.bansSinceStart[1]);
            if (breeding$.getValue().booleanValue()) {
               RoundedUtil._ticket((float)(yifesecu / 2) - var15 / 3.0F, var17, (float)(yifesecu / 2) + var15 / 3.0F - (float)(yifesecu / 2) + (float)(Hypixel.bansSinceStart[1] > 10 ? 45 : 43), difeyozu - 5.0F, 4.0F, new Color(15, 15, 15, 40));
               RenderUtils._laptops((float)(yifesecu / 2) - var15 / 3.0F - 1.0F, var17 - 1.0F, (float)(yifesecu / 2) + var15 / 3.0F - (float)(yifesecu / 2) + (float)(Hypixel.bansSinceStart[1] > 10 ? 47 : 47), difeyozu - 3.0F, 15, new Color(15, 15, 15, 120));
            } else {
               RenderUtils._pregnant((double)((float)(yifesecu / 2) - var15 / 3.0F), (double)var17, (double)((float)(yifesecu / 2) + var15 / 3.0F), (double)difeyozu);
            }

            usafafeb._dozens("Session Time : " + cocofano, (float)(yifesecu / 2), var14, -1);
            usafafeb._dozens(Hypixel.bansSinceStart[0] + " <- Watchdog | Staff -> " + Hypixel.bansSinceStart[1], (float)(yifesecu / 2), var12, -1);
            usafafeb._dozens("Updating in " + (avobibas - System.currentTimeMillis() % avobibas) / ((long)665850983 ^ 665851791L) + "s", (float)(yifesecu / 2), var13, -1);
         }

         if (System.currentTimeMillis() % avobibas > avobibas - ((long)-1034082931 ^ -1034082937L)) {
            if (usafafeb.surname$) {
               return;
            }

            usafafeb.surname$ = true;
            if (talented$.getValue().booleanValue()) {
               Client.î ?().î ?("Updating Ban Stats...");
            }

            (new Thread(new StaffAnalyser(usafafeb))).start();
         } else {
            usafafeb.surname$ = false;
         }

      }
   }

   public void _dozens(String usecopuc, float alumiyaz, float ayayagit, int azurofur) {
      GlStateManager.scale(0.5D, 0.5D, 1.0D);
      obagirec.fancy$.fontRendererObj.drawStringWithShadow((String)usecopuc, alumiyaz * 2.0F - (float)(obagirec.fancy$.fontRendererObj.getStringWidth((String)usecopuc) / 2), ayayagit * 2.0F, (int)azurofur);
      GlStateManager.scale(2.0F, 2.0F, 1.0F);
   }
}
