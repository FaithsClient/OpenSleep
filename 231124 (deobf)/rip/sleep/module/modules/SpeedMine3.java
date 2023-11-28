package rip.sleep.module.modules;

import java.util.Objects;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.DamageBlockEvent;
import rip.sleep.event.events.PacketSendEvent;
import rip.sleep.event.events.StartUpdateEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.PacketUtilA;
import rip.sleep.value.Value;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.NumberValue;

public class SpeedMine3 extends Module {
   private final ModeValue c88275 = new ModeValue("Mode", new String[]{"FastPacket", "Packet"}, "Packet");
   public NumberValue<Number> c94879 = new NumberValue<Number>("SpeedMine", () -> {
      return this.c88275.c54460().equalsIgnoreCase("Packet");
   }, 1.4D, 0.0D, 2.0D, 0.05D);
   private boolean c8317 = false;
   private float c82229 = 0.0F;
   public BlockPos c30508;
   public EnumFacing c21528;
   public C07PacketPlayerDigging c80817;

   public SpeedMine3() {
      super("Speed Mine", new String[]{"SpeedMine", "fastmine"}, ModuleType.c31770, ModuleType.c21190.c76367);
   }

   public void c71897() {
      this.c82229 = 0.0F;
      this.c8317 = false;
      this.c30508 = null;
      this.c21528 = null;
   }

   @EventTarget
   void c14926(PacketSendEvent var1) {
      Module[] var2 = Value.c27574();
      if (Objects.equals(this.c88275.c54460(), "Packet")) {
         if (mc.thePlayer == null || mc.theWorld == null) {
            return;
         }

         if (mc.playerController.getCurrentGameType().isCreative()) {
            return;
         }

         if (PacketSendEvent.c26827 instanceof C07PacketPlayerDigging && PacketSendEvent.c81894() != this.c80817 && !mc.playerController.extendedReach() && mc.playerController != null) {
            C07PacketPlayerDigging var3 = (C07PacketPlayerDigging) PacketSendEvent.c26827;
            if (var3.getStatus() == Action.START_DESTROY_BLOCK) {
               this.c8317 = true;
               this.c30508 = var3.getPosition();
               this.c21528 = var3.getFacing();
               this.c82229 = 0.0F;
            }

            if (var3.getStatus() == Action.ABORT_DESTROY_BLOCK || var3.getStatus() == Action.STOP_DESTROY_BLOCK) {
               this.c8317 = false;
               this.c30508 = null;
               this.c21528 = null;
            }
         }
      }

   }

   @EventTarget
   public void c65000(DamageBlockEvent var1) {
      Module[] var2 = Value.c27574();
      if (mc.thePlayer != null && mc.theWorld != null) {
         if (Objects.equals(this.c88275.c54460(), "FastPacket")) {
            Block var3 = mc.theWorld.getBlockState(var1.c58103()).getBlock();
            int var4 = Block.getIdFromBlock(var3);
            mc.playerController.blockHitDelay = 0;
            if (var4 != 7) {
               PacketUtilA.c61987(new C07PacketPlayerDigging(Action.STOP_DESTROY_BLOCK, var1.c58103(), var1.c3269()));
               PacketUtilA.c61987(new C07PacketPlayerDigging(Action.STOP_DESTROY_BLOCK, var1.c58103(), var1.c3269()));
            }
         }

      }
   }

   @EventTarget
   public void c71217(StartUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (mc.thePlayer != null && mc.theWorld != null) {
         if (Objects.equals(this.c88275.c54460(), "Packet")) {
            this.c2159("" + this.c94879.c53968().doubleValue() * 100.0D / 2.0D + "%");
            if (mc.playerController.getCurrentGameType().isCreative()) {
               return;
            }

            if (mc.playerController.extendedReach()) {
               mc.playerController.blockHitDelay = 0;
            }

            if (this.c8317) {
               Block var3 = mc.theWorld.getBlockState(this.c30508).getBlock();
               int var4 = Block.getIdFromBlock(var3);
               this.c82229 = (float)((double)this.c82229 + (double)var3.getPlayerRelativeBlockHardness(mc.thePlayer, mc.theWorld, this.c30508) * (double)this.c94879.c53968().floatValue());
               if (this.c82229 >= 1.0F) {
                  mc.theWorld.setBlockState(this.c30508, Blocks.air.getDefaultState(), 11);
                  C07PacketPlayerDigging var5 = new C07PacketPlayerDigging(Action.STOP_DESTROY_BLOCK, this.c30508, this.c21528);
                  this.c80817 = var5;
                  PacketUtilA.sendPacketNoEvent(var5);
                  this.c82229 = 0.0F;
                  this.c8317 = false;
               }
            }
         }

      }
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
