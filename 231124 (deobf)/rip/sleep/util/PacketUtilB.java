package rip.sleep.util;

import rip.sleep.event.EventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C00PacketKeepAlive;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import org.json.JSONException;
import rip.sleep.event.events.PacketSendEvent;
import rip.sleep.event.EventTarget;
import rip.sleep.module.Module;
import rip.sleep.interfaces.IInstanceAccess;
import rip.sleep.value.Value;

public class PacketUtilB implements IInstanceAccess {
   private final CopyOnWriteArrayList<Packet> c57386 = new CopyOnWriteArrayList();
   private boolean c34924;
   private boolean c15896;
   private boolean c78063;
   private boolean c15790;

   public PacketUtilB() {
      EventBus.getInstance().register(this);
   }

   @EventTarget
   public void c35150(PacketSendEvent var1) {
      Module[] var2 = Value.c27574();
      if (!c56767.isSingleplayer()) {
         label50: {
            if (c56767.thePlayer == null || c56767.thePlayer.ticksExisted < 5) {
               if (this.c15790) {
                  break label50;
               }

               this.c57386.clear();
               this.c24455();
               this.c15790 = true;
            }

            this.c15790 = false;
         }

         Packet var3 = PacketSendEvent.c81894();
         if (!var1.c58917()) {
            if (this.c14745(var3)) {
               if (!this.c34924) {
                  return;
               }

               var1.c8253(true);
               this.c57386.add(var3);
            }

            if (this.c33756(var3)) {
               if (!this.c15896) {
                  return;
               }

               var1.c8253(true);
               this.c57386.add(var3);
            }

            if (this.c78063) {
               var1.c8253(true);
               this.c57386.add(var3);
            }
         }

      }
   }

   public void c10080() {
      this.c34924 = true;
   }

   public void c93564() {
      Module[] var1 = Value.c27574();
      if (!this.c57386.isEmpty()) {
         ArrayList var2 = new ArrayList();
         Iterator var3 = this.c57386.iterator();
         if (var3.hasNext()) {
            Packet var4 = (Packet)var3.next();
            if (this.c14745(var4)) {
               PacketUtilA.sendPacketNoEvent(var4);
               var2.add(var4);
            }
         }

         if (!var2.isEmpty()) {
            var3 = var2.iterator();
            if (var3.hasNext()) {
               Packet var6 = (Packet)var3.next();
               this.c57386.remove(var6);
            }
         }

         var2.clear();
      }

   }

   public void c30510() {
      this.c93564();
      this.c34924 = false;
   }

   public void c93804() {
      this.c15896 = true;
   }

   public void c37561() {
      Module[] var1 = Value.c27574();
      if (!this.c57386.isEmpty()) {
         ArrayList var2 = new ArrayList();
         Iterator var3 = this.c57386.iterator();
         if (var3.hasNext()) {
            Packet var4 = (Packet)var3.next();
            if (this.c33756(var4)) {
               PacketUtilA.sendPacketNoEvent(var4);
               var2.add(var4);
            }
         }

         if (!var2.isEmpty()) {
            var3 = var2.iterator();
            if (var3.hasNext()) {
               Packet var6 = (Packet)var3.next();
               this.c57386.remove(var6);
            }
         }

         var2.clear();
      }

   }

   public void c99053() {
      this.c37561();
      this.c15896 = false;
   }

   public void c36872() {
      this.c78063 = true;
   }

   public void c12042() {
      Module[] var1 = Value.c27574();
      if (!this.c57386.isEmpty()) {
         ArrayList var2 = new ArrayList();
         Iterator var3 = this.c57386.iterator();
         if (var3.hasNext()) {
            Packet var4 = (Packet)var3.next();
            if (!this.c14745(var4) && !this.c33756(var4)) {
               PacketUtilA.sendPacketNoEvent(var4);
               var2.add(var4);
            }
         }

         if (!var2.isEmpty()) {
            var3 = var2.iterator();
            if (var3.hasNext()) {
               Packet var6 = (Packet)var3.next();
               this.c57386.remove(var6);
            }
         }

         var2.clear();
      }

   }

   public void c61884() {
      this.c12042();
      this.c78063 = false;
   }

   public void c46507() {
      Module[] var1 = Value.c27574();
      if (!this.c57386.isEmpty()) {
         ArrayList var2 = new ArrayList();
         Iterator var3 = this.c57386.iterator();
         if (var3.hasNext()) {
            Packet var4 = (Packet)var3.next();
            if (this.c14745(var4)) {
               var2.add(var4);
            }
         }

         if (!var2.isEmpty()) {
            var3 = var2.iterator();
            if (var3.hasNext()) {
               Packet var6 = (Packet)var3.next();
               this.c57386.remove(var6);
            }
         }

         var2.clear();
      }

   }

   public void c7743() {
      Module[] var1 = Value.c27574();
      if (!this.c57386.isEmpty()) {
         ArrayList var2 = new ArrayList();
         Iterator var3 = this.c57386.iterator();
         if (var3.hasNext()) {
            Packet var4 = (Packet)var3.next();
            if (this.c33756(var4)) {
               var2.add(var4);
            }
         }

         if (!var2.isEmpty()) {
            var3 = var2.iterator();
            if (var3.hasNext()) {
               Packet var6 = (Packet)var3.next();
               this.c57386.remove(var6);
            }
         }

         var2.clear();
      }

   }

   public void c96061() {
      Module[] var1 = Value.c27574();
      if (!this.c57386.isEmpty()) {
         ArrayList var2 = new ArrayList();
         Iterator var3 = this.c57386.iterator();
         if (var3.hasNext()) {
            Packet var4 = (Packet)var3.next();
            if (!this.c14745(var4) && !this.c33756(var4)) {
               var2.add(var4);
            }
         }

         if (!var2.isEmpty()) {
            var3 = var2.iterator();
            if (var3.hasNext()) {
               Packet var6 = (Packet)var3.next();
               this.c57386.remove(var6);
            }
         }

         var2.clear();
      }

   }

   public void c23594() {
      this.c34924 = true;
      this.c15896 = true;
      this.c78063 = true;
   }

   public void c35331() {
      this.c34924 = true;
      this.c78063 = true;
   }

   public void c80538() {
      Module[] var1 = Value.c27574();
      if (!this.c57386.isEmpty()) {
         Iterator var2 = this.c57386.iterator();
         if (var2.hasNext()) {
            Packet var3 = (Packet)var2.next();
            PacketUtilA.sendPacketNoEvent(var3);
         }

         this.c57386.clear();
      }

   }

   public void c76926() {
      this.c80538();
      this.c34924 = false;
      this.c78063 = false;
   }

   public void c24455() {
      this.c80538();
      this.c34924 = false;
      this.c15896 = false;
      this.c78063 = false;
   }

   public boolean c42175() {
      Module[] var1 = Value.c27574();
      return this.c34924 || this.c15896 || this.c78063;
   }

   public boolean c83020() {
      Module[] var1 = Value.c27574();
      return this.c34924 && this.c15896 && this.c78063;
   }

   public boolean c14745(Packet var1) {
      Module[] var2 = Value.c27574();
      return var1 instanceof C03PacketPlayer || var1 instanceof C0BPacketEntityAction;
   }

   public boolean c33756(Packet var1) {
      Module[] var2 = Value.c27574();
      return var1 instanceof C0FPacketConfirmTransaction || var1 instanceof C00PacketKeepAlive;
   }

   private static JSONException c14498(JSONException var0) {
      return var0;
   }
}
