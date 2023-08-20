//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.Client;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender2D;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ft.sleep.util.math.MathUtil;
import ft.sleep.util.render.RenderUtil4;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class TargetList extends Module {
   public static int forgot$ = 118;
   public static int factor$ = 34;

   public TargetList() {
      super("ft.sleep.module.modules.TargetList", new String[]{"ft.sleep.module.modules.TargetList"}, ModuleType.ignored$);
   }

   public static int _groups() {
      return forgot$;
   }

   public static void _designed(int ifinapuv) {
      forgot$ = (int)ifinapuv;
   }

   public static int _abortion() {
      return factor$;
   }

   public static void _valves(int unapapar) {
      factor$ = (int)unapapar;
   }

   public static boolean _blend(int italy, int township) {
      return MathUtil._alice((double)italy, (double)township, (double)(forgot$ + 110), (double)(factor$ + 35), (double)(forgot$ + 10), (double)(factor$ + 15)) && Client.î ?()._zimbabwe("ft.sleep.module.modules.TargetList")._central();
   }

   public List _diving() {
      return (List)rosasela.mc.theWorld.getLoadedEntityList().stream().filter(TargetList::_arranged).collect(Collectors.toCollection(ArrayList::new));
   }

   @EventHandler
   public void _dense(EventRender2D notes) {
      Object linked = 13;
      Object calling = 10;
      Object interest = 8;
      Object purse = defeat._diving();
      Object shirt = 0;

      for(Object winning : purse) {
         linked += FontLoaders.Tahoma13.getHeight() + 1;
         int var9 = FontLoaders.Tahoma13.getStringWidth(winning.getDisplayName().getFormattedText());
         if (var9 > shirt) {
            shirt = var9;
         }
      }

      GL11.glPushMatrix();
      GL11.glTranslatef((float)forgot$, (float)factor$, Float.intBitsToFloat(0));
      shirt = Math.max(100, shirt + 25);
      shirt = shirt + (shirt == 100 ? 0 : 30);
      linked = linked - (FontLoaders.Tahoma13.getHeight() + 1);
      if (purse.isEmpty()) {
         linked -= 2;
      }

      RenderUtil4._expanded((double)calling, (double)(interest + 10), (double)(calling + shirt - 8), (double)(interest + linked));
      FontLoaders.TahomaBold13.drawString("Targets", (double)(calling + 5), (double)(interest + 16), Color.WHITE.getRGB(), false);
      Object var13 = interest + 20;

      for(Entity var15 : purse) {
         FontLoaders.TahomaBold11.drawString(var15.getDisplayName().getFormattedText(), (float)calling + 5.5F, (float)(var13 + 4), (new Color(200, 200, 200, 255)).getRGB());
         var13 += FontLoaders.TahomaBold11.getHeight() + 2;
      }

      GL11.glPopMatrix();
   }

   public static boolean _arranged(Entity atifotiy) {
      return PlayerManager._pension((Entity)atifotiy);
   }
}
