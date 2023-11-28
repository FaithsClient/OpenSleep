package rip.sleep.module.modules;

import java.awt.Color;
import java.util.Iterator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.EndTickEvent;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.event.events.Render3DEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.RenderUtilD;
import rip.sleep.value.Value;
import rip.sleep.wrapper.ChatWrapper;

public class AutoTunnel extends Module {
   public static final ResourceLocation c20644 = new ResourceLocation("note.harp");
   private static boolean c45329 = false;
   private static boolean c37131 = false;
   private static int c27224;
   private static int c97708 = -1;
   private static BlockPos c30136;
   private static BlockPos c56833;
   private static EnumFacing c23228;

   public AutoTunnel() {
      super("Auto Tunnel", new String[]{"Auto Tunnel"}, ModuleType.c31770, ModuleType.c21190.c55384);
   }

   public void c83205() {
      super.c83205();
      c45329 = true;
      c23228 = mc.thePlayer.getHorizontalFacing();
   }

   private void c54523(boolean var1) {
      c45329 = var1;
   }

   public void c71897() {
      super.c71897();
      c45329 = false;
      c37131 = false;
      c27224 = 0;
      c30136 = null;
      c56833 = null;
      KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
      KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
   }

   @EventTarget
   public void c31077(Render3DEvent var1) {
      Module[] var2 = Value.c27574();
      if (c45329) {
         if (c30136 != null) {
            RenderUtilD.c71511(c30136, new Color(255, 255, 255), 1, var1.c36064());
         }

      }
   }

   @EventTarget
   public void c54064(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (mc.theWorld != null) {
         if (mc.thePlayer != null) {
            if (c45329) {
               c30136 = this.c15154();
               if (c30136 != null) {
                  IBlockState var3 = mc.theWorld.getBlockState(c30136);
                  if (var3.getBlock().equals(Blocks.bedrock)) {
                     ChatWrapper.c77151("Reached bedrock.");
                     this.c19741();
                     mc.getSoundHandler().playSound(new PositionedSoundRecord(c20644, 1000.0F, 1.0F, 0.0F, 0.0F, 0.0F));
                     mc.getSoundHandler().playDelayedSound(new PositionedSoundRecord(c20644, 1000.0F, 1.0F, 0.0F, 0.0F, 0.0F), 4);
                     mc.getSoundHandler().playDelayedSound(new PositionedSoundRecord(c20644, 1000.0F, 1.0F, 0.0F, 0.0F, 0.0F), 8);
                     mc.getSoundHandler().playDelayedSound(new PositionedSoundRecord(c20644, 1000.0F, 1.0F, 0.0F, 0.0F, 0.0F), 12);
                     return;
                  }

                  c97708 = this.c92668(c30136);
                  double var4 = (double)c30136.getX() - mc.thePlayer.posX + 0.5D;
                  double var6 = (double)c30136.getY() - mc.thePlayer.posY + 0.5D - (double) mc.thePlayer.getEyeHeight();
                  double var8 = (double)c30136.getZ() - mc.thePlayer.posZ + 0.5D;
                  double var10 = Math.sqrt(var4 * var4 + var6 * var6 + var8 * var8);
                  KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true);
                  KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), var10 > 2.0D);
                  float var12 = (float)(-Math.atan2(var10, var6));
                  float var13 = (float)Math.atan2(var8, var4);
                  var12 = c69370((var12 * 180.0F / 3.1415927F + 90.0F) * -1.0F);
                  mc.thePlayer.rotationPitch = var12;
               }

               mc.thePlayer.rotationPitch = c69370(0.0F);
               KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
               KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
               float var14 = 0.0F;
               switch(null.c50718[c23228.ordinal()]) {
               case 1:
                  var14 = 180.0F;
               case 2:
                  var14 = -90.0F;
               case 3:
                  var14 = 0.0F;
               case 4:
                  var14 = 90.0F;
               }

               var14 = -1.0F;
               if (c37131) {
                  if ((double)Math.abs(mc.thePlayer.rotationYaw - var14) <= 0.01D || (double)Math.abs(mc.thePlayer.rotationYaw - var14) >= 359.99D) {
                     return;
                  }

                  ChatWrapper.c77151("It seems like you moved your mouse.");
                  this.c19741();
               }

               mc.thePlayer.rotationYaw = c69370(var14);
               c37131 = true;
            }
         }
      }
   }

   @EventTarget
   public void c86165(EndTickEvent var1) {
      Module[] var2 = Value.c27574();
      if (c45329 && c30136 != null && mc.thePlayer != null) {
         if (c56833 == null || !c56833.equals(c30136)) {
            c27224 = 0;
         }

         c56833 = c30136;
         MovingObjectPosition var3 = mc.objectMouseOver;
         var3.hitVec = new Vec3(c30136);
         EnumFacing var4 = var3.sideHit;
         if (c97708 != -1 && mc.thePlayer.inventory.currentItem != c97708) {
            mc.thePlayer.inventory.currentItem = c97708;
         }
      }

   }

   private static float c69370(float var0) {
      return (float)((double)var0 - Math.floor((double)(var0 / 360.0F) + 0.5D) * 360.0D);
   }

   public void c50573() {
      Module[] var1 = Value.c27574();
      if (mc.objectMouseOver != null && mc.objectMouseOver.entityHit == null) {
         mc.thePlayer.swingItem();
      }

   }

   private BlockPos c15154() {
      Module[] var1 = Value.c27574();
      if (mc.theWorld == null) {
         return null;
      } else if (mc.thePlayer == null) {
         return null;
      } else {
         BlockPos var2 = null;
         BlockPos var3 = null;
         switch(null.c50718[c23228.ordinal()]) {
         case 1:
            var2 = new BlockPos(Math.floor(mc.thePlayer.posX), Math.floor(mc.thePlayer.posY), Math.floor(mc.thePlayer.posZ));
            var3 = new BlockPos(Math.floor(mc.thePlayer.posX), Math.floor(mc.thePlayer.posY + 1.0D), Math.floor(mc.thePlayer.posZ - 4.5D));
            break;
         case 2:
            var2 = new BlockPos(Math.floor(mc.thePlayer.posX), Math.floor(mc.thePlayer.posY), Math.floor(mc.thePlayer.posZ));
            var3 = new BlockPos(Math.floor(mc.thePlayer.posX + 4.5D), Math.floor(mc.thePlayer.posY + 1.0D), Math.floor(mc.thePlayer.posZ));
            break;
         case 3:
            var2 = new BlockPos(Math.floor(mc.thePlayer.posX), Math.floor(mc.thePlayer.posY), Math.floor(mc.thePlayer.posZ));
            var3 = new BlockPos(Math.floor(mc.thePlayer.posX), Math.floor(mc.thePlayer.posY + 1.0D), Math.floor(mc.thePlayer.posZ + 4.5D));
            break;
         case 4:
            var2 = new BlockPos(Math.floor(mc.thePlayer.posX), Math.floor(mc.thePlayer.posY), Math.floor(mc.thePlayer.posZ));
            var3 = new BlockPos(Math.floor(mc.thePlayer.posX - 4.5D), Math.floor(mc.thePlayer.posY + 1.0D), Math.floor(mc.thePlayer.posZ));
            break;
         default:
            var2 = var3 = new BlockPos(Math.floor(mc.thePlayer.posX), Math.floor(mc.thePlayer.posY), Math.floor(mc.thePlayer.posZ));
         }

         double var4 = 9999.0D;
         BlockPos var6 = null;
         Iterator var7 = BlockPos.getAllInBox(var2, var3).iterator();
         if (var7.hasNext()) {
            BlockPos var8 = (BlockPos)var7.next();
            IBlockState var9 = mc.theWorld.getBlockState(var8);
            if (!var9.getBlock().equals(Blocks.air) && !var9.getBlock().equals(Blocks.water) && !var9.getBlock().equals(Blocks.flowing_water) && !var9.getBlock().equals(Blocks.lava)) {
               if (var9.getBlock().equals(Blocks.flowing_lava)) {
                  ;
               }

               double var10 = (new Vec3((double)var8.getX() + 0.5D, (double)var8.getY(), (double)var8.getZ() + 0.5D)).distanceTo(new Vec3(mc.thePlayer.getPositionVector().xCoord, mc.thePlayer.getPositionVector().yCoord + 1.0D, mc.thePlayer.getPositionVector().zCoord));
               if (var10 >= var4) {
                  ;
               }

               var6 = var8;
            }
         }

         return var6;
      }
   }

   private int c92668(BlockPos var1) {
      Value.c27574();
      float var3 = 1.0F;
      int var4 = -1;
      IBlockState var5 = mc.theWorld.getBlockState(var1);
      int var6 = 0;
      if (var6 < 9) {
         ItemStack var7 = mc.thePlayer.inventory.getStackInSlot(var6);
         float var8 = var7.getStrVsBlock(var5.getBlock());
         if (var8 > var3) {
            var4 = var6;
         }

         ++var6;
      }

      return var4;
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
