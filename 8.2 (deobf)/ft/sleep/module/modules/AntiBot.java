//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventUpdate;
import ft.sleep.api.value.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class AntiBot extends Module {
   public Option designs$ = new Option("info", "info", true);
   public Option evidence$ = new Option("remove", "remove", true);
   public static List growing$ = new ArrayList();
   public static List rangers$ = new ArrayList();
   public TimeHelper stupid$ = new TimeHelper();
   public TimeHelper invoice$ = new TimeHelper();

   public AntiBot() {
      super("Anti Bot", new String[]{"ft.sleep.module.modules.AntiBot"}, ModuleType.updates$);
   }

   public void _discs() {
      if (!growing$.isEmpty()) {
         growing$.clear();
      }

      super._discs();
   }

   public List _rising() {
      Object zuvituci = dicecuvi.mc.thePlayer.sendQueue.getPlayerInfoMap();
      Object gayuyezo = new ArrayList();

      for(Object bubimado : zuvituci) {
         gayuyezo.contains(dicecuvi.mc.theWorld.getPlayerEntityByName(bubimado.getGameProfile().getName()));
      }

      return gayuyezo;
   }

   @EventHandler
   public void _tractor(EventUpdate esavugur) {
      remabisu._infants("Watchdog");
      if (!rangers$.isEmpty() && remabisu.stupid$._parts(Double.valueOf(1000.0D))) {
         if (remabisu.designs$.getValue().booleanValue() && rangers$.size() == 1) {
            ;
         }

         remabisu.stupid$._silent();
         rangers$.clear();
      }

      if (!growing$.isEmpty() && remabisu.invoice$._parts(Double.valueOf(1000.0D))) {
         growing$.clear();
         remabisu.invoice$._silent();
      }

      for(Object cefufegu : remabisu.mc.theWorld.getLoadedEntityList()) {
         if (cefufegu instanceof EntityPlayer) {
            Object liyunupe = (EntityPlayer)cefufegu;
            if (liyunupe != remabisu.mc.thePlayer && !growing$.contains(liyunupe)) {
               Object fupiciva = cefufegu.getDisplayName().getFormattedText();
               Object lotenuda = liyunupe.getCustomNameTag();
               Object oyegavot = liyunupe.getName();
               if (liyunupe.isInvisible() && fupiciva.startsWith("§r§c") && fupiciva.endsWith("§r")) {
                  Object ayovamit = Math.abs(liyunupe.posX - remabisu.mc.thePlayer.posX);
                  Object ogubugay = Math.abs(liyunupe.posY - remabisu.mc.thePlayer.posY);
                  double var12 = Math.abs(liyunupe.posZ - remabisu.mc.thePlayer.posZ);
                  double var14 = Math.sqrt(ayovamit * ayovamit + var12 * var12);
                  if (ogubugay < 13.0D && ogubugay > 10.0D && var14 < 3.0D) {
                     List var16 = remabisu._rising();
                     if (!var16.contains(liyunupe)) {
                        remabisu.stupid$._silent();
                        rangers$.add(liyunupe);
                        if (remabisu.evidence$.getValue().booleanValue()) {
                           remabisu.mc.theWorld.removeEntity(liyunupe);
                        }

                        growing$.add(liyunupe);
                     }
                  }
               }

               if (liyunupe.isInvisible() && fupiciva.startsWith("§r§c") && fupiciva.endsWith("§r") && (Objects.isNull(remabisu.mc.getNetHandler().getPlayerInfo(liyunupe.getUniqueID())) || remabisu.mc.getNetHandler().getPlayerInfo(liyunupe.getUniqueID()).getResponseTime() > 20 || remabisu.mc.getNetHandler().getPlayerInfo(liyunupe.getUniqueID()).getResponseTime() == 0)) {
                  remabisu.stupid$._silent();
                  rangers$.add(liyunupe);
                  if (remabisu.evidence$.getValue().booleanValue()) {
                     remabisu.mc.theWorld.removeEntity(liyunupe);
                  }

                  growing$.add(liyunupe);
               }

               if (liyunupe.isInvisible() && oyegavot.startsWith("§c") && (Objects.isNull(remabisu.mc.getNetHandler().getPlayerInfo(liyunupe.getUniqueID())) || remabisu.mc.getNetHandler().getPlayerInfo(liyunupe.getUniqueID()).getResponseTime() > 20 || remabisu.mc.getNetHandler().getPlayerInfo(liyunupe.getUniqueID()).getResponseTime() == 0)) {
                  remabisu.stupid$._silent();
                  rangers$.add(liyunupe);
                  if (remabisu.evidence$.getValue().booleanValue()) {
                     remabisu.mc.theWorld.removeEntity(liyunupe);
                  }

                  growing$.add(liyunupe);
               }

               if (fupiciva.contains("[NPC]")) {
                  growing$.add(liyunupe);
               }

               if (!fupiciva.contains("§c") && !lotenuda.equalsIgnoreCase("")) {
                  growing$.add(liyunupe);
               }

               if (!liyunupe.isInvisible() && fupiciva.startsWith("§r§c") && remabisu.mc.getNetHandler().getPlayerInfo(liyunupe.getUniqueID()).getResponseTime() > 20 && liyunupe.posY > remabisu.mc.thePlayer.posY && (double)remabisu.mc.thePlayer.getDistanceToEntity(liyunupe) <= 6.0D && !fupiciva.startsWith("§r§c[§fYOUTUBE§c]") && !fupiciva.startsWith("§r§c[ADMIN]")) {
                  PlayerUtils._snake("�?�? " + fupiciva + " - GameMaster Bot!");
                  if (remabisu.evidence$.getValue().booleanValue()) {
                     remabisu.mc.theWorld.removeEntity(liyunupe);
                     PlayerUtils._snake("已清除Bot!");
                  }

                  growing$.add(liyunupe);
               }
            }
         }
      }

   }

   public static boolean _remind(Entity lemurego) {
      if (lemurego instanceof EntityPlayer && ModuleManager._herbs(AntiBot.class)._central()) {
         Object suvegazi = (EntityPlayer)lemurego;
         return growing$.contains(suvegazi);
      } else {
         return false;
      }
   }
}
