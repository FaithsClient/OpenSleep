package rip.sleep.ui.bingus;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Mouse;
import rip.sleep.value.Value;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.ui.renderer.ModuleTypeRendererB;

public class GuiBingusClickGui extends GuiScreen {
   public static ArrayList<ModuleTypeRendererB> c68906 = Lists.newArrayList();
   public double c90999;
   public int c47406;
   public static boolean c65527 = false;
   public float c7089;
   public float c29043;
   public float c27203;
   public float c57252;
   public float c56548;
   public float c61058;
   private final boolean c84046;
   private boolean c31835;
   private final float c37458;

   public GuiBingusClickGui() {
      Value.c27574();
      this.c90999 = 0.0D;
      this.c84046 = false;
      this.c37458 = 75.0F;
      if (c68906.isEmpty()) {
         int var2 = 5;
         ModuleType[] var3 = ModuleType.values();
         int var4 = var3.length;
         int var5 = 0;
         if (var5 < var4) {
            ModuleType var6 = var3[var5];
            c68906.add(new ModuleTypeRendererB(var6, var2, 5));
            var2 = var2 + 105;
            ++var5;
         }
      }

   }

   public boolean doesGuiPauseGame() {
      return false;
   }

   public float c16753(double var1, double var3) {
      return (float)(var1 + (var3 - var1) / (double)(Minecraft.getDebugFPS() / 10));
   }

   public void initGui() {
      super.initGui();
   }

   public void drawScreen(int var1, int var2, float var3) {
      Module[] var4 = Value.c27574();
      this.c90999 = this.c90999 + 10.0D < 200.0D ? (this.c90999 += 10.0D) : 200.0D;
      GlStateManager.pushMatrix();
      ScaledResolution var5 = new ScaledResolution(this.mc);
      float var6 = (float)var5.getScaleFactor() / (float)Math.pow((double)var5.getScaleFactor(), 2.0D);
      c68906.forEach((var2x) -> {
         var2x.c76713(var1, var2);
      });
      GlStateManager.popMatrix();
      if (Mouse.hasWheel()) {
         int var7 = Mouse.getDWheel();
         this.c47406 = var7 < 0 ? -120 : (var7 > 0 ? 120 : 0);
      }

      c68906.forEach((var3x) -> {
         var3x.c18111(var1, var2, this.c47406);
      });
      super.drawScreen(var1, var2, var3);
   }

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      c68906.forEach((var3x) -> {
         var3x.c39582(var1, var2, var3);
      });
      super.mouseClicked(var1, var2, var3);
   }

   protected void keyTyped(char var1, int var2) throws IOException {
      Module[] var3 = Value.c27574();
      if (var2 == 1 && !c65527) {
         this.mc.displayGuiScreen((GuiScreen)null);
      } else {
         c68906.forEach((var2x) -> {
            var2x.c70776(var1, var2);
         });
      }
   }

   public void onGuiClosed() {
      this.mc.entityRenderer.stopUseShader();
   }

   public synchronized void c39137(ModuleTypeRendererB var1) {
      Value.c27574();
      int var3 = 0;
      int var4 = 0;
      if (var4 < c68906.size()) {
         if (c68906.get(var4) == var1) {
            var3 = var4;
         }

         ++var4;
      }

      ModuleTypeRendererB var5 = (ModuleTypeRendererB)c68906.get(c68906.size() - 1);
      c68906.set(c68906.size() - 1, c68906.get(var3));
      c68906.set(var3, var5);
   }

   private static Exception c83099(Exception var0) {
      return var0;
   }
}
