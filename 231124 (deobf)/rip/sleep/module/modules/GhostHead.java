package rip.sleep.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;

public class GhostHead extends Module {
   private static final Minecraft c25507 = Minecraft.getMinecraft();
   private static final BooleanValue c57307 = new BooleanValue("Sword", true);
   private static final BooleanValue c96353 = new BooleanValue("Tools", true);
   private static final BooleanValue c62055 = new BooleanValue("Bow", true);
   private static final BooleanValue c37489 = new BooleanValue("fense", true);

   public GhostHead() {
      super("Ghost Hand", new String[]{"ghosthand"}, ModuleType.c13050, ModuleType.c21190.c28329);
   }

   public static boolean c52608(Entity var0) {
      Module[] var1 = Value.c27574();
      if (c25507.thePlayer.getHeldItem() == null || (!c96353.c1473().booleanValue() || !c25507.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("pickaxe") && !c25507.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("hatchet") && !c25507.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("shovel") && !c25507.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("hoe") || c25507.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("shovelDiamond")) && (!c62055.c1473().booleanValue() || !c25507.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("bow"))) {
         if (Sleep.getInstance().c43557().c25756.c43312(var0.getName())) {
            return true;
         } else if (var0.getDisplayName().getUnformattedText().length() < 4) {
            return false;
         } else {
            char var2 = ' ';
            char var3 = ' ';
            String var5 = var0.getDisplayName().getFormattedText();
            String var6 = c25507.thePlayer.getDisplayName().getFormattedText();
            if (var5.startsWith("§r§6[§2S§6] ")) {
               if (c37489.c1473().booleanValue()) {
                  return true;
               }

               var5 = var5.replace("§r§6[§2S§6] ", "");
            }

            if (var6.startsWith("§r§6[§2S§6] ")) {
               var6 = var6.replace("§r§6[§2S§6] ", "");
            }

            if (c25507.theWorld.getScoreboard().getObjectiveInDisplaySlot(1) == null) {
               String var4 = " ";
            }

            String var7 = c25507.theWorld.getScoreboard().getObjectiveInDisplaySlot(1).getDisplayName();
            if (var5.charAt(2) == 167) {
               var2 = var5.charAt(3);
            }

            if (var5.charAt(0) == 167 && var5.charAt(1) != 'r') {
               var2 = var5.charAt(1);
            }

            if (var6.charAt(2) == 167) {
               var3 = var6.charAt(3);
            }

            if (var6.charAt(0) == 167 && var6.charAt(2) != 167 && var6.charAt(1) == 'r' && var7.charAt(0) == 167) {
               var3 = var7.charAt(1);
            }

            if (var2 != ' ' && var3 != ' ' && var2 == var3 && c25507.thePlayer.getHeldItem() != null && c96353.c1473().booleanValue() && c25507.thePlayer.getHeldItem().getItem().getUnlocalizedName().contains("sword")) {
               return true;
            } else {
               return var2 != ' ' && var3 != ' ' && var2 == var3;
            }
         }
      } else {
         return true;
      }
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
