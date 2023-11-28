package rip.sleep.event.events;

import rip.sleep.event.Event;

public class MoveEvent extends Event {
   public double c49055;
   public double c14691;
   public double c27627;

   public MoveEvent(double var1, double var3, double var5) {
      this.c49055 = var1;
      this.c14691 = var3;
      this.c27627 = var5;
   }

   public double c524() {
      return this.c49055;
   }

   public void c97676(double var1) {
      this.c49055 = var1;
   }

   public double c13885() {
      return this.c14691;
   }

   public void c59560(double var1) {
      this.c14691 = var1;
   }

   public double c92054() {
      return this.c27627;
   }

   public void c90383(double var1) {
      this.c27627 = var1;
   }
}
