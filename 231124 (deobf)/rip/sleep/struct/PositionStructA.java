package rip.sleep.struct;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;

class PositionStructA {
   private double c42791;
   private double c82509;
   private double c57408;
   private float c16350;
   private float c83551;

   public PositionStructA(double var1, double var3, double var5, float var7, float var8) {
      this.c42791 = var1;
      this.c82509 = var3;
      this.c57408 = var5;
      this.c16350 = var7;
      this.c83551 = var8;
   }

   public PositionStructA(double var1, double var3, double var5) {
      this.c42791 = var1;
      this.c82509 = var3;
      this.c57408 = var5;
      this.c16350 = 0.0F;
      this.c83551 = 0.0F;
   }

   public PositionStructA(BlockPos var1) {
      this.c42791 = (double)var1.getX();
      this.c82509 = (double)var1.getY();
      this.c57408 = (double)var1.getZ();
      this.c16350 = 0.0F;
      this.c83551 = 0.0F;
   }

   public PositionStructA(int var1, int var2, int var3) {
      this.c42791 = (double)var1;
      this.c82509 = (double)var2;
      this.c57408 = (double)var3;
      this.c16350 = 0.0F;
      this.c83551 = 0.0F;
   }

   public PositionStructA(EntityLivingBase var1) {
      this.c42791 = var1.posX;
      this.c82509 = var1.posY;
      this.c57408 = var1.posZ;
      this.c16350 = 0.0F;
      this.c83551 = 0.0F;
   }

   public PositionStructA c79772(int var1, int var2, int var3) {
      this.c42791 += (double)var1;
      this.c82509 += (double)var2;
      this.c57408 += (double)var3;
      return this;
   }

   public PositionStructA c6017(double var1, double var3, double var5) {
      this.c42791 += var1;
      this.c82509 += var3;
      this.c57408 += var5;
      return this;
   }

   public PositionStructA c31018(int var1, int var2, int var3) {
      this.c42791 -= (double)var1;
      this.c82509 -= (double)var2;
      this.c57408 -= (double)var3;
      return this;
   }

   public PositionStructA c83848(double var1, double var3, double var5) {
      this.c42791 -= var1;
      this.c82509 -= var3;
      this.c57408 -= var5;
      return this;
   }

   public Block c72001() {
      return Minecraft.getMinecraft().theWorld.getBlockState(this.c11292()).getBlock();
   }

   public double c28806() {
      return this.c42791;
   }

   public PositionStructA c70759(double var1) {
      this.c42791 = var1;
      return this;
   }

   public double c79185() {
      return this.c82509;
   }

   public PositionStructA c67177(double var1) {
      this.c82509 = var1;
      return this;
   }

   public double c58984() {
      return this.c57408;
   }

   public PositionStructA c65291(double var1) {
      this.c57408 = var1;
      return this;
   }

   public float c99821() {
      return this.c16350;
   }

   public PositionStructA c359(float var1) {
      this.c16350 = var1;
      return this;
   }

   public float c78867() {
      return this.c83551;
   }

   public PositionStructA c40742(float var1) {
      this.c83551 = var1;
      return this;
   }

   public static PositionStructA c4070(BlockPos var0) {
      return new PositionStructA(var0.getX(), var0.getY(), var0.getZ());
   }

   public BlockPos c11292() {
      return new BlockPos(this.c28806(), this.c79185(), this.c58984());
   }

   public double c7884(PositionStructA var1) {
      double var2 = var1.c42791 - this.c42791;
      double var4 = var1.c57408 - this.c57408;
      double var6 = var1.c82509 - this.c82509;
      return Math.sqrt(var2 * var2 + var6 * var6 + var4 * var4);
   }

   public double c44719(PositionStructA var1) {
      double var2 = var1.c82509 - this.c82509;
      return Math.sqrt(var2 * var2);
   }
}
