package rip.sleep.ui.renderer;

import com.google.common.collect.Lists;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.json.JSONException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.ui.font.FontManager;
import rip.sleep.ui.element.elements.MainPanel;
import rip.sleep.util.Frame;
import rip.sleep.util.RenderUtilF;
import rip.sleep.value.Value;

public class ModuleTypeRendererB {
   public ModuleType c87103;
   public ArrayList<MainPanel> c30979;
   public boolean c17317;
   public boolean c80585;
   public int c65432;
   public int c8174;
   public int c41354;
   public int c27715;
   public int c32122;
   public int c40354;
   public int c18908;
   public int c70068;
   public double c80784;
   int c66473;
   public int c60327;
   int c88546;

   public ModuleTypeRendererB(ModuleType var1, int var2, int var3) {
      Value.c27574();
      this.c30979 = Lists.newArrayList();
      this.c87103 = var1;
      this.c65432 = var2;
      this.c8174 = var3;
      this.c40354 = 120;
      int var5 = var3 + 25;
      Iterator var6 = ModuleManager.c84590().iterator();
      if (var6.hasNext()) {
         Module var7 = (Module)var6.next();
         if (var7.c78173() != var1) {
            ;
         }

         this.c30979.add(new MainPanel(var1, var7, var2 + 5, var5));
         var5 = var5 + 15;
      }

      var6 = this.c30979.iterator();
      if (var6.hasNext()) {
         MainPanel var10 = (MainPanel)var6.next();
         var10.c52689(this);
      }

   }

   public void c76713(int var1, int var2) {
      Value.c27574();
      int var4 = 0;
      int var5 = this.c8174 + 20;
      this.c60327 = 15;
      Iterator var6 = this.c30979.iterator();
      if (var6.hasNext()) {
         MainPanel var7 = (MainPanel)var6.next();
         var7.c56216 = var5 - this.c88546;
         var5 = var5 + 15;
         this.c60327 += 15;
         if (var7.c76668) {
            Iterator var8 = var7.c12333.iterator();
            if (var8.hasNext()) {
               ModuleRenderer var9 = (ModuleRenderer)var8.next();
               var4 += 15;
               this.c60327 += 15;
            }
         }

         var4 += 15;
      }

      int var12 = 15 + var4;
      if (var12 > 316) {
         var12 = 316;
      }

      if (this.c80585) {
         this.c41354 = var12;
         this.c80784 = 180.0D;
      }

      this.c41354 = 0;
      this.c80784 = 0.0D;
      boolean var13 = var1 > this.c65432 - 2 && var1 < this.c65432 + 92 && var2 > this.c8174 - 2 && var2 < this.c8174 + this.c41354;
      if (var13) {
         this.c69373(var12);
      }

      if (this.c87103.name().equals("Combat")) {
         this.c66473 = (new Color(231, 76, 60)).getRGB();
      }

      if (this.c87103.name().equals("Visual")) {
         this.c66473 = (new Color(54, 1, 205)).getRGB();
      }

      if (this.c87103.name().equals("Movement")) {
         this.c66473 = (new Color(45, 203, 113)).getRGB();
      }

      if (this.c87103.name().equals("Player")) {
         this.c66473 = (new Color(141, 68, 173)).getRGB();
      }

      if (this.c87103.name().equals("Other")) {
         this.c66473 = (new Color(38, 154, 255)).getRGB();
      }

      if (this.c41354 > 0) {
         ;
      }

      RenderUtilF.c80877((double)this.c65432, (double)(this.c8174 + 4), (double)(this.c65432 + 101), (double)(this.c8174 + 17), (new Color(255, 255, 255, 235)).getRGB(), (new Color(255, 255, 255, 235)).getRGB());
      new ScaledResolution(Minecraft.getMinecraft());
      if (this.c87103.name().equals("Combat")) {
         FontManager.c28966.c17470("Blatant", (double)(this.c65432 + 3), (double)(this.c8174 + 8), (new Color(255, 255, 255)).getRGB());
      }

      if (this.c87103.name().equals("Render")) {
         FontManager.c28966.c17470("Visual", (double)(this.c65432 + 3), (double)(this.c8174 + 8), (new Color(255, 255, 255)).getRGB());
      }

      if (this.c87103.name().equals("Movement")) {
         FontManager.c28966.c17470("Movement", (double)(this.c65432 + 3), (double)(this.c8174 + 8), (new Color(255, 255, 255)).getRGB());
      }

      if (this.c87103.name().equals("Player")) {
         FontManager.c28966.c17470("Player", (double)(this.c65432 + 3), (double)(this.c8174 + 8), (new Color(255, 255, 255)).getRGB());
      }

      if (this.c87103.name().equals("Legit")) {
         FontManager.c28966.c17470("Legit", (double)(this.c65432 + 3), (double)(this.c8174 + 8), (new Color(255, 255, 255)).getRGB());
      }

      if (this.c41354 > 0) {
         Iterator var14 = this.c30979.iterator();
         if (var14.hasNext()) {
            MainPanel var10 = (MainPanel)var14.next();
            var10.c37210(var1, var2, new Frame(this.c65432, this.c8174 + 16, this.c65432 + 90, this.c8174 + this.c41354));
         }
      }

      if (this.c17317) {
         if (!Mouse.isButtonDown(0)) {
            this.c17317 = false;
         }

         this.c65432 = var1 - this.c27715;
         this.c8174 = var2 - this.c32122;
         ((MainPanel)this.c30979.get(0)).c56216 = this.c8174 + 22 - this.c88546;
         Iterator var15 = this.c30979.iterator();
         if (var15.hasNext()) {
            MainPanel var16 = (MainPanel)var15.next();
            var16.c54544 = this.c65432 + 5;
         }
      }

   }

   public static void c32621(int var0, int var1, int var2, int var3) {
      Value.c27574();
      Minecraft var5 = Minecraft.getMinecraft();
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

   protected void c69373(int var1) {
      Module[] var2 = Value.c27574();
      if (Mouse.hasWheel()) {
         int var3 = Mouse.getDWheel();
         if (this.c60327 - var1 <= 0) {
            return;
         }

         if (var3 < 0) {
            if (this.c88546 >= this.c60327 - var1) {
               return;
            }

            this.c88546 += 20;
            if (this.c88546 >= 0) {
               return;
            }

            this.c88546 = 0;
         }

         if (var3 > 0) {
            this.c88546 -= 20;
            if (this.c88546 < 0) {
               this.c88546 = 0;
            }
         }
      }

   }

   public void c70776(char var1, int var2) {
      this.c30979.forEach((var2x) -> {
         var2x.c61047(var1, var2);
      });
   }

   public void c18111(int var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      if (var1 > this.c65432 - 2 && var1 < this.c65432 + 92 && var2 > this.c8174 - 2 && var2 < this.c8174 + 17 + this.c41354) {
         this.c70068 = (int)((float)this.c70068 - (float)(var3 / 120 * 28));
      }

   }

   public void c39582(int var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      if (var1 > this.c65432 - 2 && var1 < this.c65432 + 92 && var2 > this.c8174 - 2 && var2 < this.c8174 + 17) {
         if (var3 == 1) {
            boolean var5 = this.c80585 = !this.c80585;
         }

         if (var3 == 0) {
            this.c17317 = true;
            this.c27715 = var1 - this.c65432;
            this.c32122 = var2 - this.c8174;
         }
      }

      if (this.c80585) {
         this.c30979.stream().filter((var1x) -> {
            Module[] var2 = Value.c27574();
            return var1x.c56216 < this.c8174 + this.c41354;
         }).forEach((var3x) -> {
            var3x.c91091(var1, var2, var3);
         });
      }

   }

   private static JSONException c80019(JSONException var0) {
      return var0;
   }
}
