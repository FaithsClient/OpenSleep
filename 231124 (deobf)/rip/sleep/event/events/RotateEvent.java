package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;

public class RotateEvent extends Event {
   private C06PacketPlayerPosLook c49701;
   private double c70955;
   private double c12252;
   private double c53034;
   private float c88806;
   private float c17815;

   public RotateEvent(C06PacketPlayerPosLook var1, double var2, double var4, double var6, float var8, float var9) {
      this.c49701 = var1;
      this.c70955 = var2;
      this.c12252 = var4;
      this.c53034 = var6;
      this.c88806 = var8;
      this.c17815 = var9;
   }

   public double c19049() {
      return this.c70955;
   }

   public double c10534() {
      return this.c12252;
   }

   public double c26301() {
      return this.c53034;
   }

   public float c74012() {
      return this.c88806;
   }

   public float c86825() {
      return this.c17815;
   }

   public Packet c17987() {
      return this.c49701;
   }

   public void c67312(double var1) {
      this.c70955 = var1;
   }

   public void c30416(double var1) {
      this.c53034 = var1;
   }

   public void c6297(float var1) {
      this.c88806 = var1;
   }

   public void c78602(float var1) {
      this.c17815 = var1;
   }
}
