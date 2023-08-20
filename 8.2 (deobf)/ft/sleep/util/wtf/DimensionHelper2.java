//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.wtf;

import net.minecraft.client.Minecraft;

public class DimensionHelper2 {
   public static boolean _admin() {
      return Minecraft.getMinecraft().thePlayer != null && Minecraft.getMinecraft().theWorld != null;
   }

   public static boolean _payable() {
      if (!_admin()) {
         return false;
      } else {
         return Minecraft.getMinecraft().thePlayer.dimension == DimensionHelper.qatar$._improve();
      }
   }

   public static boolean _combined() {
      if (!_admin()) {
         return false;
      } else {
         return Minecraft.getMinecraft().thePlayer.dimension == DimensionHelper.never$._improve();
      }
   }

   public static boolean _timothy() {
      if (!_admin()) {
         return false;
      } else {
         return Minecraft.getMinecraft().thePlayer.dimension == DimensionHelper.accepts$._improve();
      }
   }
}
