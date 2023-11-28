package rip.sleep.ui.element.elements;

import com.google.common.collect.Lists;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.ui.font.FontManager;
import rip.sleep.ui.renderer.HiddenRenderer;
import rip.sleep.ui.renderer.KeyBindRenderer;
import rip.sleep.ui.renderer.ModuleRenderer;
import rip.sleep.ui.renderer.ModuleTypeRendererB;
import rip.sleep.util.Frame;
import rip.sleep.value.Value;

public class MainPanel {
   public Module c59445;
   public ModuleTypeRendererB c32111;
   public int c54544;
   public int c56216;
   public int c94446;
   public int c34402;
   public int c9582;
   public int c5241;
   private final int c38467;
   public double c32419 = 0.0D;
   public ArrayList<ModuleRenderer> c12333 = Lists.newArrayList();
   public boolean c76668;
   int c48301;
   public ModuleType c38058;

   public MainPanel(ModuleType var1, Module var2, int var3, int var4) {
      this.c38058 = var1;
      Value.c27574();
      this.c59445 = var2;
      this.c54544 = var3;
      this.c56216 = var4;
      int var6 = var4 + 15;
      this.c38467 = 0;
      this.c12333.add(new HiddenRenderer(var1, var2, var3 + 5, var6));
      this.c12333.add(new KeyBindRenderer(var1, var2, var3 + 5, var6));
      Iterator var7 = var2.c22326().iterator();
      if (var7.hasNext()) {
         Value var8 = (Value)var7.next();
         this.c12333.add(new ModuleRenderer(var1, var8, var3 + 5, var6));
         var6 = var6 + 20;
      }

   }

   public static void c71562(int var0, int var1, int var2, int var3) {
      Minecraft var5 = Minecraft.getMinecraft();
      Value.c27574();
      int var6 = 1;
      int var7 = var5.gameSettings.guiScale;
      if (var7 == 0) {
         var7 = 1000;
      }

      if (var6 < var7 && var5.displayWidth / (var6 + 1) >= 320 && var5.displayHeight / (var6 + 1) >= 240) {
         ++var6;
      }

      GL11.glScissor(var0 * var6, var5.displayHeight - (var1 + var3) * var6, var2 * var6, var3 * var6);
   }

   public void c37210(int var1, int var2, Frame var3) {
      Module[] var4 = Value.c27574();
      if (this.c9582 != 0) {
         MainPanel var5 = (MainPanel)this.c32111.c30979.get(this.c9582 - 1);
         this.c56216 = var5.c56216 + 15 + (var5.c76668 ? 15 * var5.c12333.size() : 0);
      }

      int var7 = 0;
      if (var7 < this.c12333.size()) {
         ((ModuleRenderer)this.c12333.get(var7)).c61951 = this.c56216 + 14 + 15 * var7;
         ((ModuleRenderer)this.c12333.get(var7)).c20520 = this.c54544 + 5;
         ++var7;
      }

      if (this.c32111.c87103.name().equals("Combat")) {
         this.c48301 = (new Color(231, 76, 60)).getRGB();
      }

      if (this.c32111.c87103.name().equals("Render")) {
         this.c48301 = (new Color(54, 1, 205)).getRGB();
      }

      if (this.c32111.c87103.name().equals("Movement")) {
         this.c48301 = (new Color(45, 203, 113)).getRGB();
      }

      if (this.c32111.c87103.name().equals("Player")) {
         this.c48301 = (new Color(141, 68, 173)).getRGB();
      }

      if (this.c32111.c87103.name().equals("Ghost")) {
         this.c48301 = (new Color(38, 154, 255)).getRGB();
      }

      GL11.glPushMatrix();
      GL11.glEnable(3089);
      c71562(this.c54544 - 5, this.c56216 - 5, 90, FontManager.c43464.c25901(this.c59445.getName()) + 5);
      var3.c94845();
      Gui.drawRect(this.c54544 - 4, this.c56216 - 3, this.c54544 + 95, this.c56216 + 7 + FontManager.c43464.c25901(this.c59445.getName()), (new Color(5, 5, 5, 110)).getRGB());
      if (this.c59445.c24622()) {
         var3.c94845();
      }

      if (this.c59445.c24622()) {
         if (this.c94446 < 180) {
            this.c94446 += 10;
         }

         var3.c94845();
         FontManager.c43464.c17470(this.c59445.getName(), (double)(this.c54544 - 2), (double)(this.c56216 + 3), (new Color(255, 255, 255)).getRGB());
         if (!this.c76668) {
            FontManager.c78217.c17470("h", (double)(this.c54544 + 91 - FontManager.c78217.c65036("h")), (double)(this.c56216 + 4), (new Color(255, 255, 255)).getRGB());
         }

         FontManager.c78217.c17470("i", (double)(this.c54544 + 91 - FontManager.c78217.c65036("i")), (double)(this.c56216 + 5), (new Color(255, 255, 255)).getRGB());
      }

      if (this.c94446 > 0) {
         this.c94446 -= 10;
      }

      var3.c94845();
      GlStateManager.pushMatrix();
      float var6 = 0.5F;
      FontManager.c43464.c17470(this.c59445.getName(), (double)(this.c54544 - 2), (double)(this.c56216 + 3), (new Color(180, 180, 180)).getRGB());
      if (!this.c76668) {
         FontManager.c78217.c17470("h", (double)(this.c54544 + 91 - FontManager.c78217.c65036("h")), (double)(this.c56216 + 5), (new Color(255, 255, 255)).getRGB());
      }

      FontManager.c78217.c17470("i", (double)(this.c54544 + 91 - FontManager.c78217.c65036("i")), (double)(this.c56216 + 5), (new Color(255, 255, 255)).getRGB());
      GlStateManager.popMatrix();
      GL11.glDisable(3089);
      GL11.glPopMatrix();
      if (this.c76668) {
         this.c12333.forEach((var3x) -> {
            var3x.c74493(var1, var2, var3);
         });
      }

   }

   public void c61047(char var1, int var2) {
      this.c12333.forEach((var2x) -> {
         var2x.c89714(var1, var2);
      });
   }

   private boolean c40850(int var1, int var2) {
      Module[] var3 = Value.c27574();
      boolean var4 = var1 >= this.c54544 && var1 <= this.c54544 - 7 && var2 >= this.c56216 && var2 <= this.c56216 + FontManager.c2780.c25901(this.c59445.getName());
      return var4;
   }

   public void c91091(int var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      if (var1 > this.c54544 - 7 && var1 < this.c54544 + 85 && var2 > this.c56216 - 6 && var2 < this.c56216 + FontManager.c2780.c25901(this.c59445.getName())) {
         if (var3 == 0) {
            this.c59445.c23631(!this.c59445.c24622());
         }

         if (var3 == 1 && !this.c12333.isEmpty()) {
            boolean var5 = this.c76668 = !this.c76668;
         }

         if (var3 == 2) {
            this.c59445.c68609(!this.c59445.c41971());
         }
      }

      if (this.c76668) {
         this.c12333.forEach((var3x) -> {
            var3x.c35654(var1, var2, var3);
         });
      }

   }

   public void c52689(ModuleTypeRendererB var1) {
      Value.c27574();
      this.c32111 = var1;
      int var3 = 0;
      if (var3 < this.c32111.c30979.size()) {
         if (this.c32111.c30979.get(var3) == this) {
            this.c9582 = var3;
            this.c5241 = this.c32111.c30979.size() - var3;
         }

         ++var3;
      }

   }

   private static JSONException c38441(JSONException var0) {
      return var0;
   }
}
