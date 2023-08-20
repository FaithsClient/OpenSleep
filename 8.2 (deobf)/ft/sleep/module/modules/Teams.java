//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.Client;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.misc.EventTitle;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import java.util.regex.Pattern;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumChatFormatting;

public class Teams extends Module {
   public static Option cabinets$ = new Option("RED", false);
   public static Option plays$ = new Option("BLUE", false);
   public static Option favors$ = new Option("GREEN", false);
   public static Option retained$ = new Option("YELLOW", false);
   public static Option bedroom$ = new Option("Pink", false);
   public static Option romantic$ = new Option("Auto Team", false);
   public static Option ranks$ = new Option("Color Mode", false);
   public static Option customer$ = new Option("Transperent", false);
   public static Numbers colors$ = new Numbers("Inv Alpha", 0.5D, 0.1D, 1.0D, 0.05D);
   public boolean catholic$ = false;

   public Teams() {
      super("ft.sleep.module.modules.Teams", new String[0], ModuleType.Player);
   }

   @EventHandler
   public void _notebook(EventTitle picked) {
      if (romantic$.getValue().booleanValue() && ranks$.getValue().booleanValue()) {
         Object lately = ((EventTitle)picked).getMessage();
         if (lately.contains(EnumChatFormatting.RED + "You are on Red Team")) {
            cabinets$.setValue(Boolean.valueOf(true));
            plays$.setValue(Boolean.valueOf(false));
            favors$.setValue(Boolean.valueOf(false));
            retained$.setValue(Boolean.valueOf(false));
         }

         if (lately.contains(EnumChatFormatting.BLUE + "You are on Blue Team")) {
            cabinets$.setValue(Boolean.valueOf(false));
            plays$.setValue(Boolean.valueOf(true));
            favors$.setValue(Boolean.valueOf(false));
            retained$.setValue(Boolean.valueOf(false));
         }

         if (lately.contains(EnumChatFormatting.GREEN + "You are on Green Team")) {
            cabinets$.setValue(Boolean.valueOf(false));
            plays$.setValue(Boolean.valueOf(false));
            favors$.setValue(Boolean.valueOf(true));
            retained$.setValue(Boolean.valueOf(false));
         }

         if (lately.contains(EnumChatFormatting.YELLOW + "You are on Yellow Team")) {
            cabinets$.setValue(Boolean.valueOf(false));
            plays$.setValue(Boolean.valueOf(false));
            favors$.setValue(Boolean.valueOf(false));
            retained$.setValue(Boolean.valueOf(true));
         }
      }

   }

   public static boolean _issued(EntityLivingBase ebesapuz) {
      if (ModuleManager._herbs(Teams.class)._central() && ebesapuz != Minecraft.getMinecraft().thePlayer) {
         if (ranks$.getValue().booleanValue()) {
            if (((EntityLivingBase)ebesapuz).getDisplayName().getUnformattedText().startsWith("§")) {
               if (plays$.getValue().booleanValue() && ((EntityLivingBase)ebesapuz).getDisplayName().getUnformattedText().startsWith("§9")) {
                  return true;
               }

               if (favors$.getValue().booleanValue() && ((EntityLivingBase)ebesapuz).getDisplayName().getUnformattedText().startsWith("§a")) {
                  return true;
               }

               if (cabinets$.getValue().booleanValue() && ((EntityLivingBase)ebesapuz).getDisplayName().getUnformattedText().startsWith("§c")) {
                  return true;
               }

               if (retained$.getValue().booleanValue() && ((EntityLivingBase)ebesapuz).getDisplayName().getUnformattedText().startsWith("§e")) {
                  return true;
               }

               if (bedroom$.getValue().booleanValue() && ((EntityLivingBase)ebesapuz).getDisplayName().getUnformattedText().startsWith("§d")) {
                  return true;
               }
            }
         } else if (Minecraft.getMinecraft().thePlayer.getDisplayName().getUnformattedText().startsWith("§")) {
            if (Minecraft.getMinecraft().thePlayer.getDisplayName().getUnformattedText().length() > 2 && ((EntityLivingBase)ebesapuz).getDisplayName().getUnformattedText().length() > 2) {
               return Minecraft.getMinecraft().thePlayer.getDisplayName().getUnformattedText().substring(0, 2).equals(((EntityLivingBase)ebesapuz).getDisplayName().getUnformattedText().substring(0, 2));
            }

            return false;
         }

         return false;
      } else {
         return false;
      }
   }

   public static boolean _exposure(Entity ocuyubaf) {
      if (ModuleManager._herbs(Teams.class)._central() && ocuyubaf != Minecraft.getMinecraft().thePlayer) {
         if (ranks$.getValue().booleanValue()) {
            if (((Entity)ocuyubaf).getDisplayName().getUnformattedText().startsWith("§")) {
               if (plays$.getValue().booleanValue() && ((Entity)ocuyubaf).getDisplayName().getUnformattedText().startsWith("§9")) {
                  return true;
               }

               if (favors$.getValue().booleanValue() && ((Entity)ocuyubaf).getDisplayName().getUnformattedText().startsWith("§a")) {
                  return true;
               }

               if (cabinets$.getValue().booleanValue() && ((Entity)ocuyubaf).getDisplayName().getUnformattedText().startsWith("§c")) {
                  return true;
               }

               if (retained$.getValue().booleanValue() && ((Entity)ocuyubaf).getDisplayName().getUnformattedText().startsWith("§e")) {
                  return true;
               }

               if (bedroom$.getValue().booleanValue() && ((Entity)ocuyubaf).getDisplayName().getUnformattedText().startsWith("§d")) {
                  return true;
               }
            }
         } else if (Minecraft.getMinecraft().thePlayer.getDisplayName().getUnformattedText().startsWith("§")) {
            if (Minecraft.getMinecraft().thePlayer.getDisplayName().getUnformattedText().length() > 2 && ((Entity)ocuyubaf).getDisplayName().getUnformattedText().length() > 2) {
               return Minecraft.getMinecraft().thePlayer.getDisplayName().getUnformattedText().substring(0, 2).equals(((Entity)ocuyubaf).getDisplayName().getUnformattedText().substring(0, 2));
            }

            return false;
         }

         return false;
      } else {
         return false;
      }
   }

   public static boolean _arrange(ICommandSender enazudon, ICommandSender uvelecel) {
      Object selonutu = "§" + _dodge((ICommandSender)enazudon);
      return ((ICommandSender)enazudon).getDisplayName().getFormattedText().contains(selonutu) && ((ICommandSender)uvelecel).getDisplayName().getFormattedText().contains(selonutu);
   }

   public static boolean _jones(ICommandSender reyunose) {
      return _arrange(Minecraft.getMinecraft().thePlayer, (ICommandSender)reyunose);
   }

   public static String _dodge(ICommandSender dufapodo) {
      Object igomesep = Pattern.compile("§(.).*§r").matcher(((ICommandSender)dufapodo).getDisplayName().getFormattedText());
      return igomesep.find() ? igomesep.group(1) : "f";
   }

   public boolean _windows(EntityLivingBase ovepelav) {
      if (ofinevit._central() && customer$.getValue().booleanValue()) {
         if (ovepelav != ofinevit.mc.thePlayer && Client.�?().�?().friendsConfig.isFriend(((EntityLivingBase)ovepelav).getName()) && ofinevit.mc.thePlayer.getDistanceToEntity((Entity)ovepelav) < 5.0F) {
            return true;
         } else {
            return ovepelav != ofinevit.mc.thePlayer && _issued((EntityLivingBase)ovepelav) && ofinevit.mc.thePlayer.getDistanceToEntity((Entity)ovepelav) < 5.0F;
         }
      } else {
         return false;
      }
   }
}
