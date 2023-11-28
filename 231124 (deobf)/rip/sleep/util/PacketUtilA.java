package rip.sleep.util;

import rip.sleep.injection.in.INetworkManager;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.login.client.C00PacketLoginStart;
import net.minecraft.network.login.client.C01PacketEncryptionResponse;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.status.client.C00PacketServerQuery;
import net.minecraft.network.status.client.C01PacketPing;
import net.minecraft.util.BlockPos;
import org.json.JSONException;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class PacketUtilA {
   private static final Minecraft c97292 = Minecraft.getMinecraft();

   public static void sendPacketNoEvent(Packet<?> var0) {
      Module[] var1 = Value.c27574();
      if (c97292.thePlayer != null) {
         ((INetworkManager)Minecraft.getMinecraft().thePlayer.sendQueue.getNetworkManager()).sendPacketNoEvent(var0);
      }

   }

   public static void c61987(Packet<?> var0) {
      Module[] var1 = Value.c27574();
      if (c97292.thePlayer != null) {
         c97292.thePlayer.sendQueue.addToSendQueue(var0);
      }

   }

   public static void c54618(Packet var0) {
   }

   public static boolean isCancelled(Packet var0) {
      Module[] var1 = Value.c27574();
      return var0 instanceof C00PacketLoginStart || var0 instanceof C01PacketEncryptionResponse || var0 instanceof C00Handshake || var0 instanceof C00PacketServerQuery || var0 instanceof C01PacketPing;
   }

   public static void c82013(boolean var0, boolean var1) {
      Module[] var2 = Value.c27574();
      C08PacketPlayerBlockPlacement var3 = new C08PacketPlayerBlockPlacement(new BlockPos(-1, -1, -1), 255, c97292.thePlayer.getHeldItem(), 0.0F, 0.0F, 0.0F);
      c61987(var3);
      sendPacketNoEvent(var3);
   }

   private static JSONException c13626(JSONException var0) {
      return var0;
   }
}
