//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.ui.screen;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;

import ft.sleep.module.ModuleType;
import ft.sleep.util.win32.Window;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Mouse;

public class ClickUi2 extends GuiScreen {
   public static ArrayList tobago$ = Lists.newArrayList();
   public double signal$ = Double.longBitsToDouble(0L);
   public int endorsed$;
   public static boolean antonio$ = false;
   public float handed$ = 75.0F;

   public ClickUi2() {
      horizon.handed$ = 75.0F;
      if (tobago$.isEmpty()) {
         Object started = 5;

         for(Object studios : ModuleType.values()) {
            tobago$.add(new Window(studios, started, 5));
            started += 105;
         }
      }

   }

   public void drawScreen(int upetelus, int zabinesu, float idogigis) {
      emenoged.signal$ = emenoged.signal$ + 10.0D < 200.0D ? (emenoged.signal$ += 10.0D) : 200.0D;
      GlStateManager.pushMatrix();
      Object zugomisi = new ScaledResolution(emenoged.mc);
      Object usiguded = (float)zugomisi.getScaleFactor() / (float)Math.pow((double)zugomisi.getScaleFactor(), 2.0D);
      tobago$.forEach(ClickUi2::î ?);
      GlStateManager.popMatrix();
      if (Mouse.hasWheel()) {
         int var6 = Mouse.getDWheel();
         emenoged.endorsed$ = var6 < 0 ? -120 : (var6 > 0 ? 120 : 0);
      }

      tobago$.forEach(emenoged::î ?);
      super.drawScreen((int)upetelus, (int)zabinesu, (float)idogigis);
   }

   public void mouseClicked(int detector, int waiting, int posters) throws IOException {
      tobago$.forEach(ClickUi2::î ?);
      super.mouseClicked((int)detector, (int)waiting, (int)posters);
   }

   public void keyTyped(char tones, int stages) throws IOException {
      if (stages == 1 && !antonio$) {
         tigers.mc.displayGuiScreen((GuiScreen)null);
      } else {
         tobago$.forEach(ClickUi2::î ?);
      }
   }

   public void initGui() {
      super.initGui();
   }

   public void onGuiClosed() {
      latter.mc.entityRenderer.stopUseShader();
   }

   public synchronized void _/* $FF was: î ?*/(Window amazon) {
      Object credits = 0;

      for(Object breaking = 0; breaking < tobago$.size(); ++breaking) {
         if (tobago$.get(breaking) == amazon) {
            credits = breaking;
            break;
         }
      }

      Object decide = (Window)tobago$.get(tobago$.size() - 1);
      tobago$.set(tobago$.size() - 1, tobago$.get(credits));
      tobago$.set(credits, decide);
   }

   public static void _/* $FF was: î ?*/(char foods, int maria, Window ministry) {
      ((Window)ministry)._emily((char)foods, (int)maria);
   }

   public static void _/* $FF was: î ?*/(int atetonez, int nogugucu, int udivoman, Window risoviro) {
      ((Window)risoviro)._athletes((int)atetonez, (int)nogugucu, (int)udivoman);
   }

   public void _/* $FF was: î ?*/(int identify, int inkjet, Window angels) {
      ((Window)angels)._revenge((int)identify, (int)inkjet, adopt.endorsed$);
   }

   public static void _/* $FF was: î ?*/(int baporado, int ivocunup, Window bomuyifu) {
      ((Window)bomuyifu)._turkish((int)baporado, (int)ivocunup);
   }
}
