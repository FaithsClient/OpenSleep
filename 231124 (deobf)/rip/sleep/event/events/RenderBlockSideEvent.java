package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

public class RenderBlockSideEvent extends Event {
   private final Block c57014;
   private final IBlockAccess c12838;
   private final BlockPos c52885;
   private final EnumFacing c80372;
   private double c18142;
   private double c29049;
   private double c76490;
   private double c13389;
   private double c23164;
   private double c13420;
   public boolean c98227 = false;

   public RenderBlockSideEvent(Block var1, IBlockAccess var2, BlockPos var3, EnumFacing var4, double var5, double var7, double var9, double var11, double var13, double var15) {
      this.c57014 = var1;
      this.c12838 = var2;
      this.c52885 = var3;
      this.c80372 = var4;
      this.c18142 = var5;
      this.c29049 = var7;
      this.c76490 = var9;
      this.c13389 = var11;
      this.c23164 = var13;
      this.c13420 = var15;
   }

   public Block c89619() {
      return this.c57014;
   }

   public IBlockAccess c28881() {
      return this.c12838;
   }

   public BlockPos c58103() {
      return this.c52885;
   }

   public EnumFacing c75588() {
      return this.c80372;
   }

   public double c82455() {
      return this.c18142;
   }

   public double c76225() {
      return this.c29049;
   }

   public double c26839() {
      return this.c76490;
   }

   public double c67123() {
      return this.c13389;
   }

   public double c79223() {
      return this.c23164;
   }

   public double c38407() {
      return this.c13420;
   }

   public void c17421(double var1) {
      this.c18142 = var1;
   }

   public void c48449(double var1) {
      this.c29049 = var1;
   }

   public void c30919(double var1) {
      this.c76490 = var1;
   }

   public void c88519(double var1) {
      this.c13389 = var1;
   }

   public void c32986(double var1) {
      this.c23164 = var1;
   }

   public void c14820(double var1) {
      this.c13420 = var1;
   }
}
