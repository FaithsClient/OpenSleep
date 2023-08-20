//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender2D;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import java.awt.Color;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.color.ColorUtils2;
import ft.sleep.util.render.RenderUtil2;
import ft.sleep.util.render.RenderUtils;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.input.Mouse;

public class MiniMap extends Module {
   public boolean major$;
   public float fallen$;
   public Option granted$ = new Option("Exh Radar", false);
   public Numbers interest$ = new Numbers("Scale", "Scale", 2.0D, 1.0D, 5.0D, 0.1D);
   public Numbers manage$ = new Numbers("X", "X", 500.0D, 1.0D, 1920.0D, 5.0D);
   public Numbers nokia$ = new Numbers("Y", "Y", 2.0D, 1.0D, 1080.0D, 5.0D);
   public Numbers dryer$ = new Numbers("Size", "Size", 125.0D, 50.0D, 500.0D, 5.0D);

   public MiniMap() {
      super("ft.sleep.module.modules.MiniMap", new String[]{"ft.sleep.module.modules.MiniMap"}, ModuleType.ignored$);
   }

   @EventHandler
   public void _reseller(EventRender2D heroes) {
      Object asbestos = new ScaledResolution(semester.mc);
      Object packs = semester.dryer$.getValue().intValue();
      Object pharmacy = semester.manage$.getValue().floatValue();
      Object athletic = semester.nokia$.getValue().floatValue();
      Object stated = (float)semester.mc.thePlayer.posX;
      Object carolina = (float)semester.mc.thePlayer.posZ;
      Object whole = asbestos.getScaledWidth();
      Object domains = asbestos.getScaledHeight();
      Object beads = Mouse.getX() * whole / semester.mc.displayWidth;
      Object cartoon = domains - Mouse.getY() * domains / semester.mc.displayHeight - 1;
      if ((float)beads >= pharmacy && (float)beads <= pharmacy + (float)packs && (float)cartoon >= athletic - 3.0F && (float)cartoon <= athletic + 10.0F && Mouse.getEventButton() == 0) {
         semester.major$ = !semester.major$;
         Object minds = semester.major$;
      }

      if (semester.major$ && semester.mc.currentScreen instanceof GuiChat) {
         Object var32 = _extras(Double.toString((double)(beads - packs / 2)), Integer.valueOf(5));
         semester.manage$.setValue((Double)var32);
         Object depth = _extras(Double.toString((double)(cartoon - 2)), Integer.valueOf(5));
         semester.nokia$.setValue((Double)depth);
      } else {
         semester.major$ = false;
      }

      if (semester.fallen$ > 255.0F) {
         semester.fallen$ = Float.intBitsToFloat(0);
      }

      Object var33 = semester.fallen$;
      Object var34 = semester.fallen$ + 85.0F;
      Object mobility = semester.fallen$ + 170.0F;
      if (var33 > 255.0F) {
         var33 = Float.intBitsToFloat(0);
      }

      if (var34 > 255.0F) {
         var34 -= 255.0F;
      }

      if (mobility > 255.0F) {
         mobility -= 255.0F;
      }

      Object python = Color.getHSBColor(var33 / 255.0F, 0.9F, 1.0F);
      Object sells = Color.getHSBColor(var34 / 255.0F, 0.9F, 1.0F);
      Object license = Color.getHSBColor(mobility / 255.0F, 0.9F, 1.0F);
      Object adjusted = python.getRGB();
      Object albums = sells.getRGB();
      Object formed = license.getRGB();
      semester.fallen$ = (float)((double)semester.fallen$ + 0.1D);
      if (semester.granted$.getValue().booleanValue()) {
         RenderUtil2._treated((double)pharmacy, (double)athletic, (double)(pharmacy + (float)packs), (double)(athletic + (float)packs), 0.5D, ColorUtils2._focuses(90), ColorUtils2._focuses(0));
         RenderUtil2._treated((double)(pharmacy + 1.0F), (double)(athletic + 1.0F), (double)(pharmacy + (float)packs - 1.0F), (double)(athletic + (float)packs - 1.0F), 1.0D, ColorUtils2._focuses(90), ColorUtils2._focuses(61));
         RenderUtil2._treated((double)pharmacy + 2.5D, (double)athletic + 2.5D, (double)(pharmacy + (float)packs) - 2.5D, (double)(athletic + (float)packs) - 2.5D, 0.5D, ColorUtils2._focuses(61), ColorUtils2._focuses(0));
      }

      RenderUtils._storage(pharmacy + 3.0F, athletic + 3.0F, pharmacy + (float)packs - 3.0F, athletic + (float)packs - 3.0F, (new Color(0, 0, 0, 150)).getRGB());
      RenderUtil2._persian((double)(pharmacy + 3.0F), (double)(athletic + 3.0F), (double)(pharmacy + (float)(packs - 3)), (double)athletic + 3.6D, ColorUtils2._reward(new Color(HUD.during$.getValue().intValue()), (int)(pharmacy * 1.0F), 5).getRGB(), ColorUtils2._reward(new Color(HUD.cosmetic$.getValue().intValue()), (int)(pharmacy * 1.0F), 5).getRGB());
      RenderUtil2._america((double)pharmacy + ((double)(packs / 2) - 0.5D), (double)athletic + 3.5D, (double)pharmacy + (double)(packs / 2) + 0.5D, (double)(athletic + (float)packs) - 3.5D, ColorUtils2._wallet(255, 80));
      RenderUtil2._america((double)pharmacy + 3.5D, (double)athletic + ((double)(packs / 2) - 0.5D), (double)(pharmacy + (float)packs) - 3.5D, (double)athletic + (double)(packs / 2) + 0.5D, ColorUtils2._wallet(255, 80));

      for(Object created : semester.mc.theWorld.getLoadedEntityList()) {
         EntityPlayer harrison;
         if (created instanceof EntityPlayer && (harrison = (EntityPlayer)created).isEntityAlive() && harrison != semester.mc.thePlayer && !harrison.isInvisible() && !harrison.isInvisibleToPlayer(semester.mc.thePlayer)) {
            Object logos = semester.mc.timer.renderPartialTicks;
            Object harris = (float)((harrison.posX + (harrison.posX - harrison.lastTickPosX) * (double)logos - (double)stated) * semester.interest$.getValue().doubleValue());
            Object medicare = (float)((harrison.posZ + (harrison.posZ - harrison.lastTickPosZ) * (double)logos - (double)carolina) * semester.interest$.getValue().doubleValue());
            Object creation = !PlayerManager._deviant(harrison) && !Teams._issued(harrison) ? Color.RED.getRGB() : Color.CYAN.getRGB();
            float var28 = (float)Math.cos((double)semester.mc.thePlayer.rotationYaw * 0.017453292519943295D);
            float var29 = (float)Math.sin((double)semester.mc.thePlayer.rotationYaw * 0.017453292519943295D);
            float var30 = -(medicare * var28 - harris * var29);
            float var31 = -(harris * var28 + medicare * var29);
            if (var30 > (float)(packs / 2) - 5.0F) {
               var30 = (float)(packs / 2) - 5.0F;
            } else if (var30 < (float)(-(packs / 2)) + 5.0F) {
               var30 = (float)(-(packs / 2)) + 5.0F;
            }

            if (var31 > (float)(packs / 2) - 5.0F) {
               var31 = (float)(packs / 2 - 5);
            } else if (var31 < (float)(-(packs / 2 - 5))) {
               var31 = -((float)(packs / 2) - 5.0F);
            }

            RenderUtil2._treated((double)(pharmacy + (float)(packs / 2) + var31) - 1.5D, (double)(athletic + (float)(packs / 2) + var30) - 1.5D, (double)(pharmacy + (float)(packs / 2) + var31) + 1.5D, (double)(athletic + (float)(packs / 2) + var30) + 1.5D, 0.5D, creation, ColorUtils2._focuses(46));
         }
      }

   }

   public void _discs() {
      super._discs();
   }

   public void _regime() {
      super._central();
   }

   public static boolean _angola(String nicholas) {
      Integer.parseInt((String)nicholas);
      return true;
   }

   public static Object _extras(String nosabuya, Object var1) {
      if (((String)nosabuya).contains(".")) {
         return ((String)nosabuya).toLowerCase().contains("f") ? Float.parseFloat((String)nosabuya) : Double.parseDouble((String)nosabuya);
      } else {
         return _angola((String)nosabuya) ? Integer.parseInt((String)nosabuya) : nosabuya;
      }
   }

   public float _forth(float fimodosu, float taticala, float camulopu, float duletezo) {
      return (float)(Math.atan2((double)(duletezo - camulopu), (double)(taticala - fimodosu)) * 180.0D / 3.141592653589793D);
   }
}
