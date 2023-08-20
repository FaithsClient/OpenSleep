package linxiu.injection.mixins;

import linxiu.injection.interfaces.IMixinC17PacketCustomPayload;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(C17PacketCustomPayload.class)
public class MixinC17PacketCustomPayload implements IMixinC17PacketCustomPayload {
	@Shadow
	private String channel;

	@Shadow
	private PacketBuffer data;
	
	@Override
	public PacketBuffer setData(PacketBuffer data) {
		return this.data = data;
	}
	
	@Override
	public String setChannel(String channel) {
		return this.channel = channel;
	}
}
