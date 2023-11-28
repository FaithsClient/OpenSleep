package rip.sleep.module.modules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.ChatReceivedEvent;
import rip.sleep.event.events.EndTickEvent;
import rip.sleep.event.events.StartUpdateEvent;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.ui.notification.Notification;
import rip.sleep.util.PlayerUtilG;
import rip.sleep.util.TimerUtilB;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;

public final class AntiBot extends Module {
   public BooleanValue c31826 = new BooleanValue("Kill", "Kill", true);
   public BooleanValue c45820 = new BooleanValue("Info", "Info", true);
   public BooleanValue c57329 = new BooleanValue("Remove", "Remove", true);
   public static List c80759 = new ArrayList();
   public static List c75492 = new ArrayList();
   TimerUtilB c57345 = new TimerUtilB();
   TimerUtilB c88305 = new TimerUtilB();
   private int c54739 = 0;

   public AntiBot() {
      super("Anti Bot", new String[]{"AntiBot"}, ModuleType.c13050, ModuleType.c21190.c47958);
   }

   public void c71897() {
      Module[] var1 = Value.c27574();
      if (!c80759.isEmpty()) {
         c80759.clear();
      }

      super.c71897();
   }

   public List c73639() {
      Value.c27574();
      Collection var2 = mc.thePlayer.sendQueue.getPlayerInfoMap();
      ArrayList var3 = new ArrayList();
      Iterator var4 = var2.iterator();
      if (var4.hasNext()) {
         NetworkPlayerInfo var5 = (NetworkPlayerInfo)var4.next();
         var3.contains(mc.theWorld.getPlayerEntityByName(var5.getGameProfile().getName()));
      }

      return var3;
   }

   @EventTarget
   public void c42117(ChatReceivedEvent var1) {
      Module[] var2 = Value.c27574();
      if (this.c31826.c1473().booleanValue() && (var1.c49307().contains("Cages opened!") || var1.c49307().contains("The Blitz Star will be released in 3 minutes!"))) {
         this.c54739 = 0;
      }

   }

   @EventTarget
   public void c16271(EndTickEvent var1) {
      Module[] var2 = Value.c27574();
      if (this.c31826.c1473().booleanValue()) {
         ++this.c54739;
         if (this.c54739 == 10) {
            this.c62370();
         }
      }

   }

   private void c62370() {
      Value.c27574();
      Iterator var2 = mc.theWorld.getLoadedEntityList().iterator();
      if (var2.hasNext()) {
         Entity var3 = (Entity)var2.next();
         if (var3 instanceof EntityPlayer) {
            EntityPlayer var4 = (EntityPlayer)var3;
            if (var4.isInvisible()) {
               mc.theWorld.removeEntity(var4);
            }
         }
      }

   }

   @EventTarget
   public void c71217(StartUpdateEvent var1) {
      Value.c27574();
      this.c2159("Watchdog");
      if (mc.thePlayer != null && mc.theWorld != null) {
         if (!c75492.isEmpty() && this.c57345.c13761(Double.valueOf(1000.0D))) {
            if (this.c45820.c1473().booleanValue() && c75492.size() == 1) {
               ;
            }

            this.c57345.c69505();
            c75492.clear();
         }

         if (!c80759.isEmpty() && this.c88305.c13761(Double.valueOf(1000.0D))) {
            c80759.clear();
            this.c88305.c69505();
         }

         Iterator var3 = mc.theWorld.getLoadedEntityList().iterator();
         if (var3.hasNext()) {
            Entity var4 = (Entity)var3.next();
            if (var4 instanceof EntityPlayer) {
               EntityPlayer var5 = (EntityPlayer)var4;
               if (var5 != mc.thePlayer && !c80759.contains(var5)) {
                  String var6 = var4.getDisplayName().getFormattedText();
                  String var7 = var5.getCustomNameTag();
                  String var8 = var5.getName();
                  if (var5.isInvisible() && var6.startsWith("§r§c") && var6.endsWith("§r")) {
                     double var9 = Math.abs(var5.posX - mc.thePlayer.posX);
                     double var11 = Math.abs(var5.posY - mc.thePlayer.posY);
                     double var13 = Math.abs(var5.posZ - mc.thePlayer.posZ);
                     double var15 = Math.sqrt(var9 * var9 + var13 * var13);
                     if (var11 < 13.0D && var11 > 10.0D && var15 < 3.0D) {
                        List var17 = this.c73639();
                        if (!var17.contains(var5)) {
                           this.c57345.c69505();
                           c75492.add(var5);
                           if (this.c57329.c1473().booleanValue()) {
                              mc.theWorld.removeEntity(var5);
                           }

                           c80759.add(var5);
                        }
                     }
                  }

                  if (var5.isInvisible() && var6.startsWith("§r§c") && var6.endsWith("§r") && (Objects.isNull(mc.getNetHandler().getPlayerInfo(var5.getUniqueID())) || mc.getNetHandler().getPlayerInfo(var5.getUniqueID()).getResponseTime() > 20 || mc.getNetHandler().getPlayerInfo(var5.getUniqueID()).getResponseTime() == 0)) {
                     this.c57345.c69505();
                     c75492.add(var5);
                     if (this.c57329.c1473().booleanValue()) {
                        mc.theWorld.removeEntity(var5);
                     }

                     c80759.add(var5);
                  }

                  if (var5.isInvisible() && var8.startsWith("§c") && (Objects.isNull(mc.getNetHandler().getPlayerInfo(var5.getUniqueID())) || mc.getNetHandler().getPlayerInfo(var5.getUniqueID()).getResponseTime() > 20 || mc.getNetHandler().getPlayerInfo(var5.getUniqueID()).getResponseTime() == 0)) {
                     this.c57345.c69505();
                     c75492.add(var5);
                     if (this.c57329.c1473().booleanValue()) {
                        mc.theWorld.removeEntity(var5);
                     }

                     c80759.add(var5);
                  }

                  if (var6.contains("[NPC]")) {
                     c80759.add(var5);
                  }

                  if (!var6.contains("§c") && !var7.equalsIgnoreCase("")) {
                     c80759.add(var5);
                  }

                  if (!var5.isInvisible() && var6.startsWith("§r§c") && mc.getNetHandler().getPlayerInfo(var5.getUniqueID()).getResponseTime() > 20 && var5.posY > mc.thePlayer.posY && (double) mc.thePlayer.getDistanceToEntity(var5) <= 6.0D && !var6.startsWith("§r§c[§fYOUTUBE§c]") && !var6.startsWith("§r§c[ADMIN]")) {
                     Sleep.getInstance().c83083().c43114().add(new Notification("Detect " + var6 + " - GameMaster Bot!", 5000L));
                     PlayerUtilG.c11143("Detect " + var6 + " - GameMaster Bot!");
                     if (this.c57329.c1473().booleanValue()) {
                        mc.theWorld.removeEntity(var5);
                        Sleep.getInstance().c83083().c43114().add(new Notification("Clear Bot!", 5000L));
                        PlayerUtilG.c11143("Clear Bot!");
                     }

                     c80759.add(var5);
                  }
               }
            }
         }

      }
   }

   public static boolean c13506(Entity var0) {
      Module[] var1 = Value.c27574();
      if (var0 instanceof EntityPlayer && ModuleManager.c25475(AntiBot.class).c24622()) {
         EntityPlayer var2 = (EntityPlayer)var0;
         return c80759.contains(var2);
      } else {
         return false;
      }
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
