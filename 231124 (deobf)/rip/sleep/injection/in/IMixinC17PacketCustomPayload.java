package rip.sleep.injection.in;

import net.minecraft.network.PacketBuffer;

public interface IMixinC17PacketCustomPayload {
   PacketBuffer setData(PacketBuffer var1);

   String setChannel(String var1);
}
