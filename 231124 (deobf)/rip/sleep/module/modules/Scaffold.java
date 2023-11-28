package rip.sleep.module.modules;

import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import org.json.JSONException;
import org.lwjgl.input.Keyboard;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.*;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.struct.OffsetFacing;
import rip.sleep.struct.RotationStruct;
import rip.sleep.ui.font.FontManager;
import rip.sleep.struct.AnimationState;
import rip.sleep.util.AnimationUtilA;
import rip.sleep.util.AnimationUtilD;
import rip.sleep.util.KeyBindReflection;
import rip.sleep.util.*;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.NumberValue;

public class Scaffold extends Module {
   private OffsetFacing c12391;
   private Vec3 c44070;
   private double c41118;
   private RotationStruct c32866;
   private boolean c38810;
   private int c28477 = -1;
   private ModeValue c91406 = new ModeValue("Jump", new String[]{"Disabled", "Enabled", "Hypixel"}, "Disabled");
   private NumberValue<Number> c77868 = new NumberValue<Number>("Speed", () -> {
      return c57423.c1473();
   }, 0.2D, 0.1D, 0.5D, 0.005D);
   private NumberValue<Number> c2793 = new NumberValue<Number>("Pot Speed", () -> {
      return c57423.c1473();
   }, 0.2D, Integer.valueOf(0), 0.2D, 0.005D);
   private AnimationUtilA c72818 = new AnimationUtilD(250, 1.0D);
   private int c42529;
   private boolean c33097;
   private boolean c41772;
   private boolean c16306 = false;
   private int c69753;
   boolean c88838 = false;
   private boolean c45193;
   private int c7436;
   private boolean c32041;
   public static final List<Block> c73587 = Arrays.asList(Blocks.air, Blocks.water, Blocks.flowing_water, Blocks.lava, Blocks.flowing_lava, Blocks.enchanting_table, Blocks.ender_chest, Blocks.sand, Blocks.tnt, Blocks.yellow_flower, Blocks.carpet, Blocks.glass_pane, Blocks.stained_glass_pane, Blocks.iron_bars, Blocks.crafting_table, Blocks.snow_layer, Blocks.packed_ice, Blocks.coal_ore, Blocks.diamond_ore, Blocks.emerald_ore, Blocks.chest, Blocks.torch, Blocks.stone_slab, Blocks.wooden_slab, Blocks.stone_slab2, Blocks.double_stone_slab2, Blocks.double_wooden_slab, Blocks.anvil, Blocks.trapped_chest, Blocks.noteblock, Blocks.gold_ore, Blocks.lapis_ore, Blocks.lit_redstone_ore, Blocks.redstone_ore, Blocks.wooden_pressure_plate, Blocks.stone_pressure_plate, Blocks.light_weighted_pressure_plate, Blocks.heavy_weighted_pressure_plate, Blocks.stone_button, Blocks.wooden_button, Blocks.cactus, Blocks.oak_stairs, Blocks.stone_brick_stairs, Blocks.nether_brick_stairs, Blocks.stone_stairs, Blocks.brick_stairs, Blocks.sandstone_stairs, Blocks.lever, Blocks.activator_rail, Blocks.rail, Blocks.spruce_stairs, Blocks.detector_rail, Blocks.golden_rail, Blocks.furnace, Blocks.ladder, Blocks.acacia_stairs, Blocks.double_stone_slab2, Blocks.dark_oak_stairs, Blocks.birch_stairs, Blocks.jungle_stairs, Blocks.quartz_stairs, Blocks.oak_fence, Blocks.redstone_torch, Blocks.iron_trapdoor, Blocks.trapdoor, Blocks.tripwire_hook, Blocks.hopper, Blocks.acacia_fence_gate, Blocks.birch_fence_gate, Blocks.dark_oak_fence_gate, Blocks.jungle_fence_gate, Blocks.spruce_fence_gate, Blocks.oak_fence_gate, Blocks.dispenser, Blocks.sapling, Blocks.tallgrass, Blocks.deadbush, Blocks.web, Blocks.red_flower, Blocks.red_mushroom, Blocks.brown_mushroom, Blocks.nether_brick_fence, Blocks.vine, Blocks.double_plant, Blocks.flower_pot, Blocks.beacon, Blocks.pumpkin, Blocks.lit_pumpkin);
   private static int c40918 = 0;
   public static BooleanValue c57423 = new BooleanValue("Strafe", true);
   public static BooleanValue c57682 = new BooleanValue("Tower Move", true);
   public static BooleanValue c847 = new BooleanValue("Safe Walk", true);
   public static BooleanValue c77014 = new BooleanValue("Swing Item", true);
   public static BooleanValue c7297 = new BooleanValue("Random Speed", () -> {
      return c57423.c1473();
   }, false);

   public Scaffold() {
      super("Scaffold", new String[]{"magiccarpet", "blockplacer", "airwalk"}, ModuleType.c62580, ModuleType.c21190.c88511);
   }

   public void c83205() {
      this.c28477 = mc.thePlayer.inventory.currentItem;
      this.c32866 = new RotationStruct(mc.thePlayer.rotationYaw, mc.thePlayer.rotationPitch);
      this.c12391 = null;
      this.c44070 = null;
      this.c69753 = 0;
      this.c38810 = false;
      this.c88838 = false;
   }

   public void c71897() {
      KeyBindReflection.c18932(mc.gameSettings.keyBindSprint, mc.gameSettings.keyBindSneak);
      this.c42529 = 0;
      this.c69753 = 0;
      this.c88838 = false;
      mc.thePlayer.inventory.currentItem = this.c28477;
   }

   private void c35599() {
      mc.thePlayer.inventory.currentItem = this.c28477;
   }

   @EventTarget
   public void c71217(StartUpdateEvent var1) {
      Value.c27574();
      this.c2159("Hypixel");
      if (mc.thePlayer.ticksExisted < 10) {
         this.c23631(false);
      } else {
         label100: {
            label104: {
               if (this.c91406.c54460().equals("Disabled")) {
                  Sleep var10000 = Sleep.INSTANCE;
                  Sleep.c33759();
                  if (!ModuleManager.c25475(Speed.class).c24622()) {
                     break label104;
                  }
               }

               if (!mc.thePlayer.onGround && !mc.gameSettings.keyBindJump.isKeyDown()) {
                  break label100;
               }

               this.c41118 = mc.thePlayer.posY;
            }

            this.c41118 = mc.thePlayer.posY;
         }

         this.c12391 = RayTraceUtilA.c81999(this.c41118, 3);
         int var3 = this.c10353();
         if (var3 != -1) {
            if (!this.c88838) {
               mc.thePlayer.inventory.currentItem = var3;
               this.c88838 = true;
            }

            if (this.c33097) {
               ++this.c42529;
            }

            if (this.c42529 >= 3) {
               mc.thePlayer.inventory.currentItem = var3;
               this.c41772 = true;
               this.c42529 = 0;
            }

            float var4 = this.c32866.c14509();
            float var5 = this.c32866.c86023();
            if (this.c12391 != null) {
               Vec3 var6 = RayTraceUtilA.c80666(this.c12391.c99329(), this.c12391.c42433(), true);
               float[] var7 = RotationUtilA.c16718(var6.xCoord, var6.yCoord, var6.zCoord);
               var4 = var7[0];
               var5 = var7[1];
            }

            this.c32866.c87872(var4, var5);
            boolean var8 = RayTraceUtilA.c28418(new BlockPos(mc.thePlayer.posX, this.c41118 - 1.0D, mc.thePlayer.posZ));
            if (this.c91406.c54460().equals("Enabled") && mc.thePlayer.onGround && PlayerUtil.c71257() && !mc.gameSettings.keyBindJump.isKeyDown()) {
               mc.thePlayer.jump();
            }

            if (c57682.c1473().booleanValue() && Keyboard.isKeyDown(mc.gameSettings.keyBindJump.getKeyCode()) && PlayerUtilG.c25285()) {
               if (Keyboard.isKeyDown(29)) {
                  mc.gameSettings.keyBindSprint.pressed = true;
                  mc.thePlayer.setSprinting(true);
               }

               mc.gameSettings.keyBindSprint.pressed = false;
               mc.thePlayer.setSprinting(false);
            }

            mc.gameSettings.keyBindSprint.pressed = false;
            mc.thePlayer.setSprinting(false);
            if (this.c12391 != null) {
               this.c36363();
            }

            if (this.c69753 > 0) {
               ++this.c69753;
               if (this.c69753 > 16) {
                  this.c69753 = 0;
               }
            }

            if (c57682.c1473().booleanValue() && Keyboard.isKeyDown(mc.gameSettings.keyBindJump.getKeyCode()) && PlayerUtilG.c25285()) {
               if (mc.thePlayer.onGround) {
                  if (this.c69753 != 0 && this.c69753 != 5) {
                     return;
                  }

                  float var10 = mc.thePlayer.rotationYaw * 0.017453292F;
                  mc.thePlayer.motionX -= (double)(MathHelper.sin(var10) * 0.2F) * 0.0D / 100.0D;
                  mc.thePlayer.motionY = 0.41999998688697815D;
                  mc.thePlayer.motionZ += (double)(MathHelper.cos(var10) * 0.2F) * 0.0D / 100.0D;
                  return;
               }

               if (mc.thePlayer.motionY > -0.0784000015258789D) {
                  int var9 = (int)Math.round(mc.thePlayer.posY % 1.0D * 100.0D);
                  switch(var9) {
                  case 42:
                     mc.thePlayer.motionY = 0.33D;
                  case 75:
                     mc.thePlayer.motionY = 1.0D - mc.thePlayer.posY % 1.0D;
                     this.c16306 = true;
                  case 0:
                     mc.thePlayer.motionY = -0.0784000015258789D;
                  }
               }
            }

         }
      }
   }

   @EventTarget
   void c97578(UnknownUselessEvent var1) {
      Module[] var2 = Value.c27574();
      var1.c8253(c847.c1473().booleanValue() && mc.thePlayer.onGround);
   }

   @EventTarget
   public void c24869(EndUpdateEvent var1) {
   }

   @EventTarget
   public void c72464(PostUpdateEvent var1) {
   }

   @EventTarget
   public void c42000(MotionUpdateEvent var1) {
      EntityPlayerSP var2 = mc.thePlayer;
      var1.c6297(this.c32866.c14509());
      var1.c78602(this.c32866.c86023());
   }

   public double c80769() {
      return Math.hypot(mc.thePlayer.motionX, mc.thePlayer.motionZ);
   }

   public void c56700(double var1) {
      PlayerUtil.c98475(var1, MathHelper.abs((float)Math.toDegrees(Math.atan2(mc.thePlayer.motionZ, mc.thePlayer.motionX)) - 90.0F));
   }

   @EventTarget
   public void c28198(MoveEvent var1) {
      Module[] var2 = Value.c27574();
      if (c57423.c1473().booleanValue()) {
         double var3 = c7297.c1473().booleanValue() ? Math.random() * 1.0E-4D : 0.0D;
         if (mc.thePlayer.onGround && mc.thePlayer.onGround && !mc.gameSettings.keyBindJump.isKeyDown()) {
            PlayerUtil.c75623(var1, this.c77868.c53968().doubleValue() + (double) PlayerUtil.c74275() * this.c2793.c53968().doubleValue() - var3);
         }
      }

      if (this.c91406.c54460().equals("Hypixel")) {
         if (!PlayerUtil.c71257()) {
            this.c38810 = false;
         }

         if (mc.thePlayer.onGround) {
            if (!PlayerUtil.c71257()) {
               return;
            }

            if (this.c38810 && !mc.gameSettings.keyBindJump.isKeyDown()) {
               if (RayTraceUtilA.c28418(new BlockPos(mc.thePlayer.posX + var1.c524(), mc.thePlayer.posY - 1.0D, mc.thePlayer.posZ + var1.c92054()))) {
                  return;
               }

               var1.c59560(mc.thePlayer.motionY = 5.0E-4D);
            }

            PlayerUtil.c70057(var1);
         }

         if (var1.c13885() > 0.3D) {
            this.c38810 = true;
         }
      }

   }

   @EventTarget
   public void c64594(PacketSendEvent var1) {
      Module[] var2 = Value.c27574();
      Packet var3 = PacketSendEvent.c81894();
      if (var3 instanceof C08PacketPlayerBlockPlacement) {
         this.c42529 = 0;
         this.c33097 = true;
      }

   }

   @EventTarget
   public void c87848(Render2DEventA var1) {
      Module[] var2 = Value.c27574();
      this.c72818.c96546(this.c24622() ? AnimationState.Forward : AnimationState.Backward);
      if (this.c24622() || !this.c72818.c44256()) {
         int var3 = this.c10353();
         if (var3 == -1) {
            Object var10000 = null;
         } else {
            ItemStack var19 = mc.thePlayer.inventory.mainInventory[var3];
         }

         int var5 = var3 == -1 ? 0 : this.c48082();
         String var6 = String.valueOf(var5);
         ScaledResolution var7 = new ScaledResolution(mc);
         (new StringBuilder()).append(var6).append(" block").append(var5 != 1 ? "s" : "").toString();
         float var12 = (float)this.c72818.c53286();
         float var13 = 15.0F;
         byte var14 = 3;
         String var15 = "" + this.c48082() + "§r Block" + (var5 != 1 ? "s" : "");
         float var16 = (float) FontManager.c59902.c65036(var15);
         float var17 = (var16 + var13 + (float)var14 + 6.0F) * var12;
         float var9 = (float)var7.getScaledWidth() / 2.0F + 20.0F - var17 / 2.0F;
         float var10 = (float)var7.getScaledHeight() - ((float)var7.getScaledHeight() / 2.0F + 9.0F);
         float var18 = 20.0F;
         mc.fontRendererObj.drawStringWithShadow(var15, var9 + 3.0F + var13 + (float)var14, var10 + 10.0F - (float) FontManager.c59902.c5657() / 2.0F + 0.5F, -1);
      }
   }

   public boolean c8278() {
      byte var2 = 1;
      Value.c27574();
      int var3 = 1;
      if (var3 <= var2) {
         BlockPos var4 = mc.thePlayer.getPosition();
         if (!mc.theWorld.getBlockState(var4.down(var3)).getBlock().equals(Blocks.air)) {
            return false;
         }

         ++var3;
      }

      return true;
   }

   public float c63700() {
      Value.c27574();
      float var2 = mc.thePlayer.rotationYaw;
      float var3 = mc.thePlayer.rotationPitch;
      float var4 = mc.thePlayer.movementInput.moveForward;
      float var5 = mc.thePlayer.movementInput.moveStrafe;
      if (var4 == 0.0F && var5 == 0.0F) {
         return var2;
      } else {
         boolean var7 = var4 < 0.0F;
         if (var4 > 0.0F) {
            float var6 = 45.0F;
         }

         if (var7) {
            float var8 = -45.0F;
         }

         float var9 = 90.0F;
         if (var7) {
            var2 += 180.0F;
         }

         if (var5 > 0.0F) {
            var2 -= var9;
         }

         if (var5 < 0.0F) {
            var2 += var9;
         }

         return var2;
      }
   }

   private static boolean c85660(Block var0) {
      Module[] var1 = Value.c27574();
      return (var0.isFullBlock() || var0 == Blocks.glass) && var0 != Blocks.sand && var0 != Blocks.gravel && var0 != Blocks.dispenser && var0 != Blocks.command_block && var0 != Blocks.noteblock && var0 != Blocks.furnace && var0 != Blocks.crafting_table && var0 != Blocks.tnt && var0 != Blocks.dropper && var0 != Blocks.beacon;
   }

   public int c10353() {
      int var2 = -1;
      Value.c27574();
      int var3 = -1;
      int var4 = 0;
      if (var4 < 9) {
         ItemStack var5 = mc.thePlayer.inventory.mainInventory[var4];
         if (var5.getItem() instanceof ItemBlock && var5.stackSize > 0) {
            ItemBlock var6 = (ItemBlock)var5.getItem();
            if (!c73587.contains(var6.getBlock()) && var5.stackSize > var3) {
               var3 = var5.stackSize;
               var2 = var4;
            }
         }

         ++var4;
      }

      return var2;
   }

   public int c72921() {
      byte var1 = -1;
      return var1;
   }

   public int c48082() {
      int var2 = 0;
      Value.c27574();
      int var3 = 0;
      if (var3 < 9) {
         ItemStack var4 = mc.thePlayer.inventory.mainInventory[var3];
         if (var4.getItem() instanceof ItemBlock && var4.stackSize > 0) {
            ItemBlock var5 = (ItemBlock)var4.getItem();
            if (c85660(var5.getBlock())) {
               var2 += var4.stackSize;
            }
         }

         ++var3;
      }

      return var2;
   }

   private boolean c16774() {
      Value.c27574();
      MovingObjectPosition var2 = RayTraceUtilA.c77027(MotionUpdateEvent.c20086, MotionUpdateEvent.c49492);
      if (var2 != null && var2.sideHit == this.c12391.c42433() && var2.getBlockPos().equals(this.c12391.c99329())) {
         this.c44070 = var2.hitVec;
         return true;
      } else {
         return false;
      }
   }

   public void c36363() {
      Module[] var1 = Value.c27574();
      if (((String)this.c91406.c26356).equals("Disabled") || ((String)this.c91406.c26356).equals("Hypixel") || ((String)this.c91406.c26356).equals("Enabled") || this.c16774()) {
         ItemStack var2 = mc.thePlayer.getHeldItem();
         Vec3 var3 = this.c44070 != null ? this.c44070 : RayTraceUtilA.c80666(this.c12391.c99329(), this.c12391.c42433(), true);
         if (c77014.c1473().booleanValue()) {
            mc.thePlayer.swingItem();
         }

         PacketUtilA.c61987(new C0APacketAnimation());
         mc.playerController.onPlayerRightClick(mc.thePlayer, mc.theWorld, var2, this.c12391.c99329(), this.c12391.c42433(), var3);
         this.c44070 = null;
      }

   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
