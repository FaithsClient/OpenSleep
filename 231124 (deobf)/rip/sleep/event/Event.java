package rip.sleep.event;

import rip.sleep.module.Module;

public abstract class Event {
   public boolean cancelled;
   public byte type;
   private static Module[] z;

   public boolean c58917() {
      return this.cancelled;
   }

   public void setCanceled() {
      this.cancelled = true;
   }

   public void cancel() {
      this.cancelled = true;
   }

   public void c8253(boolean var1) {
      this.cancelled = var1;
   }

   public byte getType() {
      return this.type;
   }

   public void setType(byte var1) {
      this.type = var1;
   }

   public static void b(Module[] var0) {
      z = var0;
   }

   public static Module[] v() {
      return z;
   }

   static {
      if (v() != null) {
         b(new Module[5]);
      }

   }
}
