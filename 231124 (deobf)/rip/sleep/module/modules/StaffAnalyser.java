package rip.sleep.module.modules;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.Render2DEventA;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.HttpUtilD;
import rip.sleep.util.RenderUtilD;
import rip.sleep.util.ShaderUtilB;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class StaffAnalyser extends Module {
   public Minecraft c39222 = Minecraft.getMinecraft();
   public boolean c80902 = false;
   public static NumberValue<Number> c30345 = new NumberValue<Number>("Delay", 10.0D, 1.0D, 60.0D, 1.0D);
   public static BooleanValue c87821 = new BooleanValue("Render", true);
   public static BooleanValue c76264 = new BooleanValue("Message", true);
   public static BooleanValue c23700 = new BooleanValue("New Render", true);

   public StaffAnalyser() {
      super("Staff Analyser", new String[]{"StaffAnalyser"}, ModuleType.c12482, ModuleType.c21190.c94221);
   }

   @EventTarget
   public void c80062(Render2DEventA var1) {
      long var3 = 1000L * c30345.c53968().longValue();
      ScaledResolution var5 = new ScaledResolution(this.c39222);
      int var6 = var5.getScaledWidth();
      Value.c27574();
      int var7 = var5.getScaledHeight();
      if (HttpUtilD.c84272 == null) {
         HttpUtilD.c60972();
      } else {
         long var8 = (System.currentTimeMillis() - Sleep.c6391) / 1000L;
         String var10 = "";
         if (var8 > 60L) {
            String var11 = Double.toString(Math.floor((double)(var8 / 60L)));
            var10 = var11.substring(0, var11.indexOf(".")) + "m " + var8 % 60L + "s";
         }

         var10 = var8 + "s";
         float var19 = 5.0F;
         float var12 = 36.0F;
         float var13 = 18.0F;
         float var14 = 26.0F;
         float var15 = 11.0F;
         Sleep.getInstance();
         Sleep.c33759();
         if (ModuleManager.c25475(HUD.class).c24622() && HUD.c7166.c1473().booleanValue()) {
            if (c23700.c1473().booleanValue()) {
               var19 = 35.0F;
               var12 = 35.0F;
               var13 = 48.0F;
               var14 = 56.0F;
               var15 = 41.0F;
            }

            var19 = 35.0F;
            var12 = 66.0F;
            var13 = 48.0F;
            var14 = 56.0F;
            var15 = 41.0F;
         }

         if (c87821.c1473().booleanValue()) {
            float var16 = (float)this.c39222.fontRendererObj.getStringWidth(HttpUtilD.c84272[0] + " <- Watchdog | Staff -> " + HttpUtilD.c84272[1]);
            if (c23700.c1473().booleanValue()) {
               ShaderUtilB.c25830((float)(var6 / 2) - var16 / 3.0F, var19, (float)(var6 / 2) + var16 / 3.0F - (float)(var6 / 2) + (float)(HttpUtilD.c84272[1] > 10 ? 45 : 43), var12 - 5.0F, 4.0F, new Color(15, 15, 15, 40));
               RenderUtilD.c15402((float)(var6 / 2) - var16 / 3.0F - 1.0F, var19 - 1.0F, (float)(var6 / 2) + var16 / 3.0F - (float)(var6 / 2) + (float)(HttpUtilD.c84272[1] > 10 ? 47 : 47), var12 - 3.0F, 15, new Color(15, 15, 15, 120));
            }

            RenderUtilD.c69751((double)((float)(var6 / 2) - var16 / 3.0F), (double)var19, (double)((float)(var6 / 2) + var16 / 3.0F), (double)var12);
            this.c80894("Session Time : " + var10, (float)(var6 / 2), var15, -1);
            this.c80894(HttpUtilD.c84272[0] + " <- Watchdog | Staff -> " + HttpUtilD.c84272[1], (float)(var6 / 2), var13, -1);
            this.c80894("Updating in " + (var3 - System.currentTimeMillis() % var3) / 1000L + "s", (float)(var6 / 2), var14, -1);
         }

         if (System.currentTimeMillis() % var3 > var3 - 10L) {
            if (this.c80902) {
               return;
            }

            this.c80902 = true;
            if (c76264.c1473().booleanValue()) {
               Sleep.getInstance().c33306("Updating Ban Stats...");
            }

            (new Thread(new Runnable() {
               public void run() {
                  Value.c27574();
                  int[] var2 = HttpUtilD.c60972();
                  if (StaffAnalyser.c76264.c1473().booleanValue()) {
                     Sleep.getInstance().c82417("Watchdog (+" + var2[0] + ")");
                     Sleep.getInstance().c82417("Staff (+" + var2[1] + ")");
                  }

               }

               private static JSONException c43076(JSONException var0) {
                  return var0;
               }
            })).start();
         }

         this.c80902 = false;
      }
   }

   public void c80894(String var1, float var2, float var3, int var4) {
      GlStateManager.scale(0.5D, 0.5D, 1.0D);
      this.c39222.fontRendererObj.drawStringWithShadow(var1, var2 * 2.0F - (float)(this.c39222.fontRendererObj.getStringWidth(var1) / 2), var3 * 2.0F, var4);
      GlStateManager.scale(2.0F, 2.0F, 1.0F);
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
