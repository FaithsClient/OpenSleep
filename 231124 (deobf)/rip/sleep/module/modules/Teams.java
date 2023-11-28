package rip.sleep.module.modules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class Teams extends Module {
   private static final BooleanValue c98179 = new BooleanValue("Color Mode", false);
   private static final BooleanValue c23596 = new BooleanValue("RED", () -> {
      return c98179.c1473();
   }, false);
   private static final BooleanValue c78077 = new BooleanValue("BLUE", () -> {
      return c98179.c1473();
   }, false);
   private static final BooleanValue c35569 = new BooleanValue("GREEN", () -> {
      return c98179.c1473();
   }, false);
   private static final BooleanValue c52070 = new BooleanValue("YELLOW", () -> {
      return c98179.c1473();
   }, false);
   private static final BooleanValue c42033 = new BooleanValue("Pink", () -> {
      return c98179.c1473();
   }, false);
   private static final BooleanValue c10444 = new BooleanValue("Transperent", false);
   public static final NumberValue<Number> c64397 = new NumberValue<Number>("Inv Alpha", () -> {
      return c10444.c1473();
   }, 0.5D, 0.0D, 1.0D, 0.05D);

   public Teams() {
      super("Teams", new String[0], ModuleType.c31770, ModuleType.c21190.c76367);
   }

   public static boolean c55703(EntityLivingBase var0) {
      Module[] var1 = Value.c27574();
      if (ModuleManager.c25475(Teams.class).c24622() && var0 != Minecraft.getMinecraft().thePlayer) {
         if (c98179.c1473().booleanValue()) {
            if (var0.getDisplayName().getUnformattedText().startsWith("§")) {
               if (c78077.c1473().booleanValue() && var0.getDisplayName().getUnformattedText().startsWith("§9")) {
                  return true;
               }

               if (c35569.c1473().booleanValue() && var0.getDisplayName().getUnformattedText().startsWith("§a")) {
                  return true;
               }

               if (c23596.c1473().booleanValue() && var0.getDisplayName().getUnformattedText().startsWith("§c")) {
                  return true;
               }

               if (c52070.c1473().booleanValue() && var0.getDisplayName().getUnformattedText().startsWith("§e")) {
                  return true;
               }

               if (c42033.c1473().booleanValue() && var0.getDisplayName().getUnformattedText().startsWith("§d")) {
                  return true;
               }
            }

            return false;
         } else if (var0.getDisplayName().getUnformattedText().length() < 4) {
            return false;
         } else {
            char var2 = ' ';
            char var3 = ' ';
            String var5 = var0.getDisplayName().getFormattedText();
            String var6 = Minecraft.getMinecraft().thePlayer.getDisplayName().getFormattedText();
            if (var5.startsWith("§r§6[§2S§6] ")) {
               if (c42033.c1473().booleanValue()) {
                  return true;
               }

               var5 = var5.replace("§r§6[§2S§6] ", "");
            }

            if (var6.startsWith("§r§6[§2S§6] ")) {
               var6 = var6.replace("§r§6[§2S§6] ", "");
            }

            if (Minecraft.getMinecraft().theWorld.getScoreboard().getObjectiveInDisplaySlot(1) == null) {
               String var4 = " ";
            }

            String var7 = Minecraft.getMinecraft().theWorld.getScoreboard().getObjectiveInDisplaySlot(1).getDisplayName();
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

            return var2 != ' ' && var3 != ' ' && var2 == var3;
         }
      } else {
         return false;
      }
   }

   public static boolean c30985(Entity var0) {
      Module[] var1 = Value.c27574();
      if (ModuleManager.c25475(Teams.class).c24622() && var0 != Minecraft.getMinecraft().thePlayer) {
         if (c98179.c1473().booleanValue()) {
            if (var0.getDisplayName().getUnformattedText().startsWith("§")) {
               if (c78077.c1473().booleanValue() && var0.getDisplayName().getUnformattedText().startsWith("§9")) {
                  return true;
               }

               if (c35569.c1473().booleanValue() && var0.getDisplayName().getUnformattedText().startsWith("§a")) {
                  return true;
               }

               if (c23596.c1473().booleanValue() && var0.getDisplayName().getUnformattedText().startsWith("§c")) {
                  return true;
               }

               if (c52070.c1473().booleanValue() && var0.getDisplayName().getUnformattedText().startsWith("§e")) {
                  return true;
               }

               if (c42033.c1473().booleanValue() && var0.getDisplayName().getUnformattedText().startsWith("§d")) {
                  return true;
               }
            }

            return false;
         } else if (var0.getDisplayName().getUnformattedText().length() < 4) {
            return false;
         } else {
            char var2 = ' ';
            char var3 = ' ';
            String var5 = var0.getDisplayName().getFormattedText();
            String var6 = Minecraft.getMinecraft().thePlayer.getDisplayName().getFormattedText();
            if (var5.startsWith("§r§6[§2S§6] ")) {
               if (c42033.c1473().booleanValue()) {
                  return true;
               }

               var5 = var5.replace("§r§6[§2S§6] ", "");
            }

            if (var6.startsWith("§r§6[§2S§6] ")) {
               var6 = var6.replace("§r§6[§2S§6] ", "");
            }

            if (Minecraft.getMinecraft().theWorld.getScoreboard().getObjectiveInDisplaySlot(1) == null) {
               String var4 = " ";
            }

            String var7 = Minecraft.getMinecraft().theWorld.getScoreboard().getObjectiveInDisplaySlot(1).getDisplayName();
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

            return var2 != ' ' && var3 != ' ' && var2 == var3;
         }
      } else {
         return false;
      }
   }

   public static boolean c18904(ICommandSender var0, ICommandSender var1) {
      Value.c27574();
      String var3 = "§" + c18909(var0);
      return var0.getDisplayName().getFormattedText().contains(var3) && var1.getDisplayName().getFormattedText().contains(var3);
   }

   public static boolean c70399(ICommandSender var0) {
      return c18904(Minecraft.getMinecraft().thePlayer, var0);
   }

   public static String c18909(ICommandSender var0) {
      Value.c27574();
      Matcher var2 = Pattern.compile("§(.).*§r").matcher(var0.getDisplayName().getFormattedText());
      return var2.find() ? var2.group(1) : "f";
   }

   public boolean c1732(EntityLivingBase var1) {
      Module[] var2 = Value.c27574();
      if (this.c24622() && c10444.c1473().booleanValue()) {
         if (var1 != mc.thePlayer && Sleep.getInstance().c43557().c25756.c43312(var1.getName()) && mc.thePlayer.getDistanceToEntity(var1) < 5.0F) {
            return true;
         } else {
            return var1 != mc.thePlayer && c55703(var1) && mc.thePlayer.getDistanceToEntity(var1) < 5.0F;
         }
      } else {
         return false;
      }
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
