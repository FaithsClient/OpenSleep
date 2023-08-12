package linxiu.injection.mixins;

import net.minecraft.network.status.client.C01PacketPing;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;



@Mixin(C01PacketPing.class)
public class MixinC01PacketPing {
	  @Shadow
	  public long clientTime;
}
