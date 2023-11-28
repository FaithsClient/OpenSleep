package rip.sleep.ui.element.elements;

import java.awt.Color;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import org.json.JSONException;
import rip.sleep.util.RenderUtilC;
import rip.sleep.value.Value;

public class ChangeLogMenu {
   private static final List<ChangeLogElement> c89143 = Arrays.asList(new ChangeLogElement("Sleep Reborn", ChangeLogMenu.c41455.c68091), new ChangeLogElement("Fix", ChangeLogMenu.c41455.c38780));

   public static void c89457() {
      Value.c27574();
      Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("Changelog", 4.0F, 4.0F, (new Color(255, 255, 255, 200)).getRGB());
      GlStateManager.pushMatrix();
      GlStateManager.scale(0.5F, 0.5F, 0.5F);
      Minecraft.getMinecraft().fontRendererObj.drawString("Build #230501", 16.0F, 28.0F, (new Color(255, 255, 255, 180)).getRGB(), true);
      GlStateManager.popMatrix();
      int var1 = 76;
      int var2 = 76;
      Iterator var3 = c89143.iterator();
      if (var3.hasNext()) {
         ChangeLogElement var4 = (ChangeLogElement)var3.next();
         GlStateManager.pushMatrix();
         GlStateManager.scale(0.5F, 0.5F, 0.5F);
         Minecraft.getMinecraft().fontRendererObj.drawString(var4.c69252, 33.0F, (float)var1 * 0.5F + 1.0F, (new Color(0, 0, 0, 80)).getRGB(), false);
         Minecraft.getMinecraft().fontRendererObj.drawString(var4.c69252, 32.0F, (float)var1 * 0.5F, (new Color(255, 255, 255, 180)).getRGB(), false);
         GlStateManager.popMatrix();
         var1 = var1 + 24;
      }

      var3 = c89143.iterator();
      if (var3.hasNext()) {
         ChangeLogElement var8 = (ChangeLogElement)var3.next();
         GlStateManager.pushMatrix();
         GlStateManager.scale(0.5F, 0.5F, 0.5F);
         RenderUtilC.c32834(21.0D, (double)(((float)var2 + 3.0F) * 0.5F), 26.0D, (double)(((float)var2 + 4.0F) * 0.5F + 5.0F), var8.c30534.c3546);
         GlStateManager.popMatrix();
         var2 = var2 + 24;
      }

   }

   private static JSONException c16965(JSONException var0) {
      return var0;
   }

   private static class ChangeLogElement {
      String c69252;
      ChangeLogMenu.c41455 c30534;

      public ChangeLogElement(String var1, ChangeLogMenu.c41455 var2) {
         this.c69252 = var1;
         this.c30534 = var2;
      }
   }

   private static enum c41455 {
      c5567((new Color(100, 200, 100, 255)).getRGB()),
      c38780((new Color(75, 125, 200, 255)).getRGB()),
      c20230((new Color(200, 75, 75, 255)).getRGB()),
      c68091((new Color(200, 200, 200, 255)).getRGB()),
      c57075((new Color(200, 175, 50, 255)).getRGB());

      int c3546;

      private c41455(int var3) {
         this.c3546 = var3;
      }
   }
}
