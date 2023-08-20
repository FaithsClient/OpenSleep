//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.screen;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;

import ft.sleep.module.ModuleType;
import ft.sleep.util.win32.Window2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Mouse;

public class ClickUi extends GuiScreen {
   public static ArrayList shade$ = Lists.newArrayList();
   public double needle$ = Double.longBitsToDouble(0L);
   public int chair$;
   public static boolean dover$ = false;
   public float cingular$;
   public float blood$;
   public float telecom$;
   public float saves$;
   public float billion$;
   public float lenses$;
   public boolean david$ = false;
   public boolean choices$;
   public float chelsea$ = 75.0F;

   public ClickUi() {
      gibson.david$ = false;
      gibson.chelsea$ = 75.0F;
      if (shade$.isEmpty()) {
         Object logical = 5;

         for(Object anyway : ModuleType.values()) {
            shade$.add(new Window2(anyway, logical, 5));
            logical += 105;
         }
      }

   }

   public float _/* $FF was: î ?*/(double overhead, double var3) {
      return (float)(overhead + (var3 - overhead) / (double)(Minecraft.getDebugFPS() / 10));
   }

   public void initGui() {
      super.initGui();
   }

   public void drawScreen(int failure, int backed, float diane) {
      primary.needle$ = primary.needle$ + 10.0D < 200.0D ? (primary.needle$ += 10.0D) : 200.0D;
      GlStateManager.pushMatrix();
      Object divorce = new ScaledResolution(primary.mc);
      Object formal = (float)divorce.getScaleFactor() / (float)Math.pow((double)divorce.getScaleFactor(), 2.0D);
      shade$.forEach(ClickUi::î ?);
      GlStateManager.popMatrix();
      if (Mouse.hasWheel()) {
         int var6 = Mouse.getDWheel();
         primary.chair$ = var6 < 0 ? -120 : (var6 > 0 ? 120 : 0);
      }

      shade$.forEach(primary::î ?);
      super.drawScreen((int)failure, (int)backed, (float)diane);
   }

   public void mouseClicked(int bulgaria, int origins, int chose) throws IOException {
      shade$.forEach(ClickUi::î ?);
      super.mouseClicked((int)bulgaria, (int)origins, (int)chose);
   }

   public void keyTyped(char moreover, int talking) throws IOException {
      if (talking == 1 && !dover$) {
         common.mc.displayGuiScreen((GuiScreen)null);
      } else {
         shade$.forEach(ClickUi::î ?);
      }
   }

   public void onGuiClosed() {
      moves.mc.entityRenderer.stopUseShader();
   }

   public synchronized void _/* $FF was: î ?*/(Window2 avobirir) {
      Object udamugon = 0;

      for(Object rutucazi = 0; rutucazi < shade$.size(); ++rutucazi) {
         if (shade$.get(rutucazi) == avobirir) {
            udamugon = rutucazi;
            break;
         }
      }

      Object nenelefi = (Window2)shade$.get(shade$.size() - 1);
      shade$.set(shade$.size() - 1, shade$.get(udamugon));
      shade$.set(udamugon, nenelefi);
   }

   public static void _/* $FF was: î ?*/(char montreal, int drives, Window2 consult) {
      ((Window2)consult)._heavily((char)montreal, (int)drives);
   }

   public static void _/* $FF was: î ?*/(int rwanda, int march, int kruger, Window2 norton) {
      ((Window2)norton)._reduces((int)rwanda, (int)march, (int)kruger);
   }

   public void _/* $FF was: î ?*/(int mabedegu, int macedazo, Window2 emiceceg) {
      ((Window2)emiceceg)._contact((int)mabedegu, (int)macedazo, zidavipe.chair$);
   }

   public static void _/* $FF was: î ?*/(int eneyeyuz, int adumubed, Window2 garinudo) {
      ((Window2)garinudo)._paris((int)eneyeyuz, (int)adumubed);
   }
}
