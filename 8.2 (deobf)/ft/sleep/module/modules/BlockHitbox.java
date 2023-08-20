//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.value.Option;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;

public class BlockHitbox extends Module {
   public static Minecraft promise$ = Minecraft.getMinecraft();
   public static Option episodes$ = new Option("Tools", true);
   public static Option victim$ = new Option("Bow", true);
   public static Option action$ = new Option("fense", true);

   public BlockHitbox() {
      super("Ghost Hand", new String[]{"GhostHand"}, ModuleType.Player);
   }

   public static boolean _baseline(Entity gacefoge) {
      if (promise$.thePlayer.getHeldItem() == null || (!episodes$.getValue().booleanValue() || !promise$.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("pickaxe") && !promise$.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("hatchet") && !promise$.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("shovel") && !promise$.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("hoe") || promise$.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("shovelDiamond")) && (!victim$.getValue().booleanValue() || !promise$.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("bow"))) {
         if (((Entity)gacefoge).getDisplayName().getUnformattedText().length() < 4) {
            return false;
         } else {
            Object amamizay = ' ';
            Object sugorazu = ' ';
            Object oyicarab = ((Entity)gacefoge).getDisplayName().getFormattedText();
            Object ubagenip = promise$.thePlayer.getDisplayName().getFormattedText();
            if (oyicarab.startsWith("§r§6[§2S§6] ")) {
               if (action$.getValue().booleanValue()) {
                  return true;
               }

               oyicarab = oyicarab.replace("§r§6[§2S§6] ", "");
            }

            if (ubagenip.startsWith("§r§6[§2S§6] ")) {
               ubagenip = ubagenip.replace("§r§6[§2S§6] ", "");
            }

            String ragaciva;
            if (promise$.theWorld.getScoreboard().getObjectiveInDisplaySlot(1) == null) {
               ragaciva = " ";
            } else {
               ragaciva = promise$.theWorld.getScoreboard().getObjectiveInDisplaySlot(1).getDisplayName();
            }

            if (oyicarab.charAt(2) == 167) {
               amamizay = oyicarab.charAt(3);
            } else if (oyicarab.charAt(0) == 167 && oyicarab.charAt(1) != 'r') {
               amamizay = oyicarab.charAt(1);
            }

            if (ubagenip.charAt(2) == 167) {
               sugorazu = ubagenip.charAt(3);
            } else if (ubagenip.charAt(0) == 167 && ubagenip.charAt(2) != 167 && ubagenip.charAt(1) == 'r' && ragaciva.charAt(0) == 167) {
               sugorazu = ragaciva.charAt(1);
            }

            return amamizay != ' ' && sugorazu != ' ' && amamizay == sugorazu;
         }
      } else {
         return true;
      }
   }
}
