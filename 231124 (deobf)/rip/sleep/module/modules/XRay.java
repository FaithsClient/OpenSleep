package rip.sleep.module.modules;

import com.google.common.collect.Lists;
import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.network.login.server.S02PacketLoginSuccess;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S22PacketMultiBlockChange;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.network.play.server.S22PacketMultiBlockChange.BlockUpdateData;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.event.events.PacketReceiveEvent;
import rip.sleep.event.events.Render2DEventA;
import rip.sleep.event.events.Render3DEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.ui.font.FontManager;
import rip.sleep.util.*;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class XRay extends Module {
   public static boolean c33034;
   public static List<BlockPos> c14611 = new CopyOnWriteArrayList();
   public static List<BlockPos> c79746 = new CopyOnWriteArrayList();
   public Map<BlockPos, Block> c38643 = new HashMap();
   private final HashSet<Block> c92662 = new HashSet(Arrays.asList(Blocks.obsidian, Blocks.clay, Blocks.mossy_cobblestone, Blocks.diamond_ore, Blocks.redstone_ore, Blocks.iron_ore, Blocks.coal_ore, Blocks.gold_ore, Blocks.emerald_ore, Blocks.lapis_ore));
   private final TimerUtilD c56927 = new TimerUtilD();
   private final TimerUtilC c38545 = new TimerUtilC();
   private final TimerUtilC c13783 = new TimerUtilC();
   public static int c40423;
   public static List c44678 = Lists.newArrayList(new Integer[]{Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(14), Integer.valueOf(15), Integer.valueOf(16), Integer.valueOf(21), Integer.valueOf(41), Integer.valueOf(42), Integer.valueOf(46), Integer.valueOf(48), Integer.valueOf(52), Integer.valueOf(56), Integer.valueOf(57), Integer.valueOf(61), Integer.valueOf(62), Integer.valueOf(73), Integer.valueOf(74), Integer.valueOf(84), Integer.valueOf(89), Integer.valueOf(103), Integer.valueOf(116), Integer.valueOf(117), Integer.valueOf(118), Integer.valueOf(120), Integer.valueOf(129), Integer.valueOf(133), Integer.valueOf(137), Integer.valueOf(145), Integer.valueOf(152), Integer.valueOf(153), Integer.valueOf(154)});
   public static NumberValue<Number> c4924 = new NumberValue<Number>("Range", 50.0D, 0.0D, 500.0D, 1.0D);
   public static NumberValue<Number> c43457 = new NumberValue<Number>("Opacity", 160.0D, 0.0D, 255.0D, 5.0D);
   public static NumberValue<Number> c14210 = new NumberValue<Number>("Render Range", 17.0D, 0.0D, 28.0D, 1.0D);
   public static NumberValue<Number> c81925 = new NumberValue<Number>("World Delay", 1.0D, 0.5D, 30.0D, 0.5D);
   public static NumberValue<Number> c31630 = new NumberValue<Number>("Extreme Delay", 1.0D, 0.5D, 30.0D, 0.5D);
   public static NumberValue<Number> c41017 = new NumberValue<Number>("Extreme XZ", 5.0D, 0.0D, 8.0D, 1.0D);
   public static NumberValue<Number> c98260 = new NumberValue<Number>("Extreme Y", 2.0D, 0.0D, 8.0D, 1.0D);
   public static NumberValue<Number> c14464 = new NumberValue<Number>("ClickBlock Delay", 1.0D, 0.5D, 30.0D, 0.5D);
   public static BooleanValue c44299 = new BooleanValue("Update", true);
   public static BooleanValue c99346 = new BooleanValue("Coal", false);
   public static BooleanValue c35663 = new BooleanValue("Iron", true);
   public static BooleanValue c53905 = new BooleanValue("Gold", true);
   public static BooleanValue c36428 = new BooleanValue("LapisLazuli", false);
   public static BooleanValue c55900 = new BooleanValue("Diamond", true);
   public static BooleanValue c15638 = new BooleanValue("RedStone", false);
   public static BooleanValue c49200 = new BooleanValue("Emerald", false);
   public static BooleanValue c76139 = new BooleanValue("Tracer", true);
   public static BooleanValue c26713 = new BooleanValue("Cave", true);
   public static BooleanValue c82685 = new BooleanValue("Esp", true);
   public static BooleanValue c77876 = new BooleanValue("MW", true);
   public static BooleanValue c34820 = new BooleanValue("UHC", true);
   public static BooleanValue c44014 = new BooleanValue("Extreme", true);
   public static BooleanValue c25207 = new BooleanValue("World", false);
   Block[] c14049 = new Block[]{Blocks.diamond_ore, Blocks.gold_ore};

   public XRay() {
      super("Xray", new String[]{"Xray"}, ModuleType.c12482, ModuleType.c21190.c94221);
   }

   public void c83205() {
      this.c54523(true);
      int var1 = (int) mc.thePlayer.posX;
      int var2 = (int) mc.thePlayer.posY;
      int var3 = (int) mc.thePlayer.posZ;
      mc.renderGlobal.markBlockRangeForRenderUpdate(var1 - 900, var2 - 900, var3 - 900, var1 + 900, var2 + 900, var3 + 900);
   }

   public void c71897() {
      this.c54523(false);
   }

   private void c54523(boolean var1) {
      mc.renderGlobal.loadRenderers();
      c33034 = var1;
      this.c13783.c13539();
      this.c38545.c13539();
      this.c56927.c13251();
      this.c38643.clear();
      c79746.clear();
      c14611.clear();
   }

   @EventTarget
   public void c85637(PacketReceiveEvent var1) {
      Module[] var2 = Value.c27574();
      if (PacketReceiveEvent.getPacket() instanceof S07PacketRespawn || PacketReceiveEvent.getPacket() instanceof S02PacketLoginSuccess) {
         c79746.clear();
         this.c38643.clear();
         c14611.clear();
      }

      if (PacketReceiveEvent.getPacket() instanceof S23PacketBlockChange) {
         S23PacketBlockChange var3 = (S23PacketBlockChange) PacketReceiveEvent.getPacket();
         BlockPos var4 = var3.getBlockPosition();
         IBlockState var5 = var3.getBlockState();
         Block var6 = var5.getBlock();
         if ((var6 instanceof BlockOre || var6 instanceof BlockRedstoneOre) && !c79746.contains(var4)) {
            c79746.add(var4);
            this.c38643.put(var4, var6);
         }
      }

      if (PacketReceiveEvent.getPacket() instanceof S22PacketMultiBlockChange) {
         S22PacketMultiBlockChange var10 = (S22PacketMultiBlockChange) PacketReceiveEvent.getPacket();
         BlockUpdateData[] var11 = var10.getChangedBlocks();
         int var12 = var11.length;
         int var13 = 0;
         if (var13 < var12) {
            BlockUpdateData var7 = var11[var13];
            BlockPos var8 = var7.getPos();
            Block var9 = var7.getBlockState().getBlock();
            if ((var9 instanceof BlockOre || var9 instanceof BlockRedstoneOre) && !c79746.contains(var8)) {
               c79746.add(var8);
               this.c38643.put(var8, var9);
            }

            ++var13;
         }
      }

   }

   @EventTarget
   public void c89923(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (c40423 != c43457.c53968().intValue()) {
         c40423 = c43457.c53968().intValue();
      }

      if (this.c13783.c27234(1000.0D * c81925.c53968().doubleValue()) && c25207.c1473().booleanValue()) {
         mc.renderGlobal.loadRenderers();
         this.c13783.c13539();
      }

      if (!ServerUtilA.c92750() && c44299.c1473().booleanValue() && this.c38545.c27234(1000.0D * (mc.playerController.getIsHittingBlock() ? c14464.c53968().doubleValue() : c31630.c53968().doubleValue()))) {
         if (c44014.c1473().booleanValue() && mc.thePlayer.posY <= 25.0D) {
            this.c84500();
         }

         this.c38545.c13539();
      }

   }

   @EventTarget
   private void c82872(Render2DEventA var1) {
      Module[] var2 = Value.c27574();
      if (!ServerUtilA.c92750() && c34820.c1473().booleanValue() && mc.thePlayer.posY <= 25.0D) {
         double var3 = var1.c26056().getScaledHeight_double();
         double var5 = var1.c26056().getScaledWidth_double();
         double var7 = 100.0D;
         this.c56927.c47779(1000.0D * c31630.c53968().doubleValue(), true);
         double var9 = (double)this.c56927.c60515();
         double var11 = var9 / (1000.0D * c31630.c53968().doubleValue());
         double var13 = 0.0D;
         RenderUtilD.c56300((float)(var5 / 2.0D - var7 / 2.0D + 50.0D), (float)(var3 / 2.0D + 150.0D + 13.0D), 0.0F, 360.0F, 15.0F, (new Color(17, 17, 17, 70)).getRGB(), 2);
         RenderUtilD.c49138((float)(var5 / 2.0D - var7 / 2.0D + 50.0D), (float)(var3 / 2.0D + 150.0D + 13.0D), 0.0F, (float)(400.0D * var11), 15.0F, (new Color(HUD.c64734.c41161().intValue())).getRGB(), 2);
         var13 = (double) MathUtilC.c21701((float)var13, (float)var11, (float)(10.0D * RenderUtilF.c9977()));
         String var15 = String.format("%.2f", var11);
         FontManager.c18826.c17470("" + var15, (double)((float)(var5 / 2.0D) - (float) FontManager.c18826.c65036("" + var15) / 2.0F) - 0.1D, (double)((float)(var3 / 2.0D + 162.0D)), (new Color(HUD.c64734.c41161().intValue())).getRGB());
      }

   }

   @EventTarget
   public void c41033(Render3DEvent var1) {
      Module[] var2 = Value.c27574();
      if (c82685.c1473().booleanValue()) {
         Iterator var3 = c79746.iterator();
         if (var3.hasNext()) {
            BlockPos var4 = (BlockPos)var3.next();
            if (c79746.contains(var4) && this.c78536((double)var4.getX(), (double)var4.getZ()) <= c4924.c53968().doubleValue()) {
               Block var5 = mc.theWorld.getBlockState(var4).getBlock();
               if (var5 == Blocks.diamond_ore && c55900.c1473().booleanValue()) {
                  this.c19905(var4, 0, 255, 255);
               }

               if (var5 == Blocks.iron_ore && c35663.c1473().booleanValue()) {
                  this.c19905(var4, 225, 225, 225);
               }

               if (var5 == Blocks.lapis_ore && c36428.c1473().booleanValue()) {
                  this.c19905(var4, 0, 0, 255);
               }

               if (var5 == Blocks.redstone_ore && c15638.c1473().booleanValue()) {
                  this.c19905(var4, 255, 0, 0);
               }

               if (var5 == Blocks.coal_ore && c99346.c1473().booleanValue()) {
                  this.c19905(var4, 0, 30, 30);
               }

               if (var5 == Blocks.emerald_ore && c49200.c1473().booleanValue()) {
                  this.c19905(var4, 0, 255, 0);
               }

               if (var5 == Blocks.gold_ore && c53905.c1473().booleanValue()) {
                  this.c19905(var4, 255, 255, 0);
               }
            }
         }
      }

   }

   public void c84500() {
      int var2 = c41017.c53968().intValue();
      Value.c27574();
      int var3 = c98260.c53968().intValue();
      int var4 = -var2;
      if (var4 <= var2) {
         int var5 = -var3;
         if (var5 <= var3) {
            int var6 = -var2;
            if (var6 <= var2) {
               EntityPlayerSP var7 = mc.thePlayer;
               int var8 = (int)var7.posX + var4;
               int var9 = (int)var7.posY + var5;
               int var10 = (int)var7.posZ + var6;
               if (mc.thePlayer.getDistanceSq(mc.thePlayer.posX + (double)var4, mc.thePlayer.posY + (double)var5, mc.thePlayer.posZ + (double)var6) <= c14210.c53968().doubleValue()) {
                  BlockPos var11 = new BlockPos(mc.thePlayer.posX + (double)var4, mc.thePlayer.posY + (double)var5, mc.thePlayer.posZ + (double)var6);
                  Block var12 = mc.theWorld.getBlockState(var11).getBlock();
                  if (var12 instanceof BlockOre || var12 instanceof BlockRedstoneOre) {
                     if (!c14611.contains(var11)) {
                        PacketUtilA.sendPacketNoEvent(new C07PacketPlayerDigging(Action.ABORT_DESTROY_BLOCK, var11, EnumFacing.UP));
                     }

                     if (!c14611.contains(var11) && !c79746.contains(var11) && this.c92662.contains(var12)) {
                        c14611.add(var11);
                     }

                     if (!c14611.contains(var11) && !c79746.contains(var11) && this.c92662.contains(var12) && this.c32084(var12, var11)) {
                        c79746.add(var11);
                     }
                  }
               }

               ++var6;
            }

            ++var5;
         }

         ++var4;
      }

   }

   public boolean c32084(Block var1, BlockPos var2) {
      Value.c27574();
      EnumFacing[] var4 = EnumFacing.VALUES;
      int var5 = var4.length;
      int var6 = 0;
      if (var6 < var5) {
         EnumFacing var7 = var4[var6];
         if (c56721(mc.theWorld, var2.offset(var7), var7, var1.getBlockBoundsMinY(), var1.getBlockBoundsMaxY(), var1.getBlockBoundsMinZ(), var1.getBlockBoundsMaxZ(), var1.getBlockBoundsMinX(), var1.getBlockBoundsMaxX())) {
            return false;
         }

         ++var6;
      }

      return true;
   }

   public double c78536(double var1, double var3) {
      double var5 = mc.thePlayer.posX - var1;
      double var7 = mc.thePlayer.posZ - var3;
      return (double)MathHelper.sqrt_double(var5 * var5 + var7 * var7);
   }

   public static boolean c98888() {
      return c82685.c1473().booleanValue();
   }

   public static int c92387() {
      return c4924.c53968().intValue();
   }

   private void c19905(BlockPos var1, int var2, int var3, int var4) {
      Module[] var5 = Value.c27574();
      if (c82685.c1473().booleanValue()) {
         RenderUtilD.c18841(var1);
      }

      if (c76139.c1473().booleanValue()) {
         RenderUtilD.c64796(var1, ColorUtil.c74045(var2, var3, var4));
      }

   }

   public static boolean c56721(IBlockAccess var0, BlockPos var1, EnumFacing var2, double var3, double var5, double var7, double var9, double var11, double var13) {
      Module[] var15 = Value.c27574();
      return var2 == EnumFacing.DOWN && var3 > 0.0D || var2 == EnumFacing.UP && var5 < 1.0D || var2 == EnumFacing.NORTH && var7 > 0.0D || var2 == EnumFacing.SOUTH && var9 < 1.0D || var2 == EnumFacing.WEST && var11 > 0.0D || var2 == EnumFacing.EAST && var13 < 1.0D || !var0.getBlockState(var1).getBlock().isOpaqueCube();
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }

   private static class c83024 {
      private final double c23236;
      private final double c76318;
      private final double c1670;
      private final Block c41282;

      public c83024(double var1, double var3, double var5, Block var7) {
         this.c23236 = var1;
         this.c76318 = var3;
         this.c1670 = var5;
         this.c41282 = var7;
      }

      public double c89496() {
         return this.c23236;
      }

      public double c23114() {
         return this.c76318;
      }

      public double c54599() {
         return this.c1670;
      }

      public Block c60609() {
         return this.c41282;
      }

      public boolean c85208(BlockPos var1) {
         Module[] var2 = Value.c27574();
         return (int)this.c23236 == var1.getX() && (int)this.c76318 == var1.getY() && this.c1670 == (double)var1.getZ();
      }

      private static JSONException c34844(JSONException var0) {
         return var0;
      }
   }
}
