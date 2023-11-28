package rip.sleep.struct;

import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

public class PositionStructB {
   private double c83922;
   private double c28268;
   private double c15365;

   public PositionStructB(double var1, double var3, double var5) {
      this.c83922 = var1;
      this.c28268 = var3;
      this.c15365 = var5;
   }

   public PositionStructB(C03PacketPlayer var1) {
      this.c83922 = var1.getPositionX();
      this.c28268 = var1.getPositionY();
      this.c15365 = var1.getPositionZ();
   }

   public PositionStructB(Entity var1) {
      this.c83922 = var1.posX;
      this.c28268 = var1.posY;
      this.c15365 = var1.posZ;
   }

   public void c73017(double var1, double var3, double var5) {
      this.c83922 += var1;
      this.c28268 += var3;
      this.c15365 += var5;
   }

   public double c87110(double var1, double var3, double var5) {
      double var7 = this.c83922 - var1;
      double var9 = this.c28268 - var3;
      double var11 = this.c15365 - var5;
      return (double)MathHelper.sqrt_double(var7 * var7 + var9 * var9 + var11 * var11);
   }

   public double c86820(PositionStructB var1) {
      double var2 = this.c83922 - var1.c29088();
      double var4 = this.c28268 - var1.c14827();
      double var6 = this.c15365 - var1.c35042();
      return (double)MathHelper.sqrt_double(var2 * var2 + var4 * var4 + var6 * var6);
   }

   public PositionStructB c3265(double var1, double var3, double var5) {
      return new PositionStructB(this.c83922 + var1, this.c28268 + var3, this.c15365 + var5);
   }

   public void c94245(PositionStructB var1) {
      this.c83922 += var1.c29088();
      this.c28268 += var1.c14827();
      this.c15365 += var1.c35042();
   }

   public double c29088() {
      return this.c83922;
   }

   public double c14827() {
      return this.c28268;
   }

   public double c35042() {
      return this.c15365;
   }

   public void c64926(double var1) {
      this.c83922 = var1;
   }

   public void c61202(double var1) {
      this.c28268 = var1;
   }

   public void c91262(double var1) {
      this.c15365 = var1;
   }

   public BlockPos c37875() {
      return new BlockPos(this.c83922, this.c28268, this.c15365);
   }
}
