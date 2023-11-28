package rip.sleep.event.events;

import rip.sleep.event.Event;

public class MotionUpdateEvent extends Event {
   public static float c20086;
   public static float c9047;
   public static float c49492;
   public static float c94080;
   public double c74087;
   public static double c52396;
   public double c55398;
   public static boolean c37557;
   public static float c99755;
   public static float c71909;

   public MotionUpdateEvent(float var1, float var2, float var3, float var4, double var5, double var7, double var9, boolean var11) {
      c9047 = c20086;
      c94080 = c49492;
      c20086 = var3;
      c49492 = var4;
      this.c74087 = var5;
      c52396 = var7;
      this.c55398 = var9;
      c37557 = var11;
      c71909 = var2;
      c99755 = var1;
   }

   public static float c74012() {
      return c20086;
   }

   public void c6297(float var1) {
      c20086 = var1;
   }

   public float c86825() {
      return c49492;
   }

   public void c78602(float var1) {
      c49492 = var1;
   }

   public static float c16556() {
      return c99755;
   }

   public static float c42229() {
      return c71909;
   }

   public double c92054() {
      return this.c55398;
   }

   public void c90383(double var1) {
      this.c55398 = var1;
   }

   public double c524() {
      return this.c74087;
   }

   public void c97676(double var1) {
      this.c74087 = var1;
   }

   public double c13885() {
      return c52396;
   }

   public static void c59560(double var0) {
      c52396 = var0;
   }

   public boolean c87166() {
      return c37557;
   }

   public static void c93198(boolean var0) {
      c37557 = var0;
   }
}
