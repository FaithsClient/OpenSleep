package rip.sleep.module.modules;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.ChatReceivedEvent;
import rip.sleep.event.events.PostUpdateEvent;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.util.ServerUtilA;
import rip.sleep.value.Value;
import rip.sleep.value.values.NumberValue;
import rip.sleep.module.ModuleType;

public class Phase extends Module {
   public static final NumberValue<Number> c93518 = new NumberValue<Number>("Ticks", 0.0D, 0.0D, 20.0D, 1.0D);
   private boolean c26702;
   private boolean c30520;
   private int c87908;

   public Phase() {
      super("Phase", new String[]{"Phase", "Phase"}, ModuleType.c62580, ModuleType.c21190.c37885);
   }

   public void c71897() {
      this.c26702 = false;
      super.c71897();
   }

   @EventTarget
   public void c42117(ChatReceivedEvent var1) {
      Value.c27574();
      String var3 = var1.c49307();
      String var4 = null;
      if (ServerUtilA.c51439()) {
         var4 = "The games begin in 5 seconds!";
      }

      if (ServerUtilA.c77818()) {
         var4 = "The game starts in 5 seconds!";
      }

      if (ServerUtilA.c92750()) {
         var4 = null;
      }

      if (var3.equals(var4)) {
         this.c26702 = true;
         this.c30520 = false;
         this.c87908 = 0;
         Sleep var10000 = Sleep.INSTANCE;
         Sleep.c33759();
         if (!ModuleManager.c25475(Blink.class).c24622()) {
            var10000 = Sleep.INSTANCE;
            Sleep.c33759();
            ModuleManager.c25475(Blink.class).c23631(true);
         }
      }

   }

   @EventTarget
   public void c29181(PostUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (mc.thePlayer != null && mc.theWorld != null) {
         double var3 = mc.thePlayer.posX;
         double var5 = mc.thePlayer.posY;
         double var7 = mc.thePlayer.posZ;
         ++this.c87908;
         if (mc.thePlayer.ticksExisted < 10) {
            this.c26702 = false;
         }

         if (this.c87908 > 100 + c93518.c53968().intValue()) {
            this.c26702 = false;
            Sleep var10000 = Sleep.INSTANCE;
            Sleep.c33759();
            if (ModuleManager.c25475(Blink.class).c24622()) {
               var10000 = Sleep.INSTANCE;
               Sleep.c33759();
               ModuleManager.c25475(Blink.class).c23631(false);
            }
         }

         if (this.c26702 && !this.c30520) {
            if (ServerUtilA.c51439()) {
               mc.theWorld.setBlockState(new BlockPos(var3 + 1.0D, var5, var7), Blocks.air.getDefaultState(), 4);
               mc.theWorld.setBlockState(new BlockPos(var3 + 1.0D, var5 + 1.0D, var7), Blocks.air.getDefaultState(), 4);
               mc.theWorld.setBlockState(new BlockPos(var3 + 1.0D, var5 + 2.0D, var7), Blocks.air.getDefaultState(), 4);
               mc.theWorld.setBlockState(new BlockPos(var3 - 1.0D, var5, var7), Blocks.air.getDefaultState(), 4);
               mc.theWorld.setBlockState(new BlockPos(var3 - 1.0D, var5 + 1.0D, var7), Blocks.air.getDefaultState(), 4);
               mc.theWorld.setBlockState(new BlockPos(var3 - 1.0D, var5 + 2.0D, var7), Blocks.air.getDefaultState(), 4);
               mc.theWorld.setBlockState(new BlockPos(var3, var5, var7 + 1.0D), Blocks.air.getDefaultState(), 4);
               mc.theWorld.setBlockState(new BlockPos(var3, var5 + 1.0D, var7 + 1.0D), Blocks.air.getDefaultState(), 4);
               mc.theWorld.setBlockState(new BlockPos(var3, var5 + 2.0D, var7 + 1.0D), Blocks.air.getDefaultState(), 4);
               mc.theWorld.setBlockState(new BlockPos(var3, var5, var7 - 1.0D), Blocks.air.getDefaultState(), 4);
               mc.theWorld.setBlockState(new BlockPos(var3, var5 + 1.0D, var7 - 1.0D), Blocks.air.getDefaultState(), 4);
               mc.theWorld.setBlockState(new BlockPos(var3, var5 + 2.0D, var7 - 1.0D), Blocks.air.getDefaultState(), 4);
            }

            if (ServerUtilA.c77818()) {
               mc.theWorld.setBlockState(new BlockPos(var3, var5 - 1.0D, var7), Blocks.air.getDefaultState(), 4);
            }

            if (ServerUtilA.c92750()) {
               mc.theWorld.setBlockState(new BlockPos(var3 + 1.0D, var5, var7), Blocks.air.getDefaultState(), 4);
               mc.theWorld.setBlockState(new BlockPos(var3 + 1.0D, var5 + 1.0D, var7), Blocks.air.getDefaultState(), 4);
            }

            this.c30520 = true;
         }

      }
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
