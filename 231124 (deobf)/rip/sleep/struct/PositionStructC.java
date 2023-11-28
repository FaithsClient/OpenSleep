package rip.sleep.struct;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;

class PositionStructC {
   private double c84718;
   private double c79510;
   private double c47112;
   private float c91700;
   private float c42660;

   public PositionStructC(double var1, double var3, double var5, float var7, float var8) {
      this.c84718 = var1;
      this.c79510 = var3;
      this.c47112 = var5;
      this.c91700 = var7;
      this.c42660 = var8;
   }

   public PositionStructC(double var1, double var3, double var5) {
      this.c84718 = var1;
      this.c79510 = var3;
      this.c47112 = var5;
      this.c91700 = 0.0F;
      this.c42660 = 0.0F;
   }

   public PositionStructC(BlockPos var1) {
      this.c84718 = (double)var1.getX();
      this.c79510 = (double)var1.getY();
      this.c47112 = (double)var1.getZ();
      this.c91700 = 0.0F;
      this.c42660 = 0.0F;
   }

   public PositionStructC(int var1, int var2, int var3) {
      this.c84718 = (double)var1;
      this.c79510 = (double)var2;
      this.c47112 = (double)var3;
      this.c91700 = 0.0F;
      this.c42660 = 0.0F;
   }

   public PositionStructC c53599(int var1, int var2, int var3) {
      this.c84718 += (double)var1;
      this.c79510 += (double)var2;
      this.c47112 += (double)var3;
      return this;
   }

   public PositionStructC c50851(double var1, double var3, double var5) {
      this.c84718 += var1;
      this.c79510 += var3;
      this.c47112 += var5;
      return this;
   }

   public PositionStructC c89676(int var1, int var2, int var3) {
      this.c84718 -= (double)var1;
      this.c79510 -= (double)var2;
      this.c47112 -= (double)var3;
      return this;
   }

   public PositionStructC c16932(double var1, double var3, double var5) {
      this.c84718 -= var1;
      this.c79510 -= var3;
      this.c47112 -= var5;
      return this;
   }

   public Block c59773() {
      return Minecraft.getMinecraft().theWorld.getBlockState(this.c15267()).getBlock();
   }

   public double c41232() {
      return this.c84718;
   }

   public PositionStructC c95556(double var1) {
      this.c84718 = var1;
      return this;
   }

   public double c72985() {
      return this.c79510;
   }

   public PositionStructC c85524(double var1) {
      this.c79510 = var1;
      return this;
   }

   public double c76166() {
      return this.c47112;
   }

   public PositionStructC c94070(double var1) {
      this.c47112 = var1;
      return this;
   }

   public float c10681() {
      return this.c91700;
   }

   public PositionStructC c5780(float var1) {
      this.c91700 = var1;
      return this;
   }

   public float c58460() {
      return this.c42660;
   }

   public PositionStructC c4941(float var1) {
      this.c42660 = var1;
      return this;
   }

   public static PositionStructC c83949(BlockPos var0) {
      return new PositionStructC(var0.getX(), var0.getY(), var0.getZ());
   }

   public BlockPos c15267() {
      return new BlockPos(this.c41232(), this.c72985(), this.c76166());
   }

   public double c1740(PositionStructC var1) {
      double var2 = var1.c84718 - this.c84718;
      double var4 = var1.c47112 - this.c47112;
      double var6 = var1.c79510 - this.c79510;
      return Math.sqrt(var2 * var2 + var6 * var6 + var4 * var4);
   }

   public double c5901(PositionStructC var1) {
      double var2 = var1.c79510 - this.c79510;
      return Math.sqrt(var2 * var2);
   }
}
