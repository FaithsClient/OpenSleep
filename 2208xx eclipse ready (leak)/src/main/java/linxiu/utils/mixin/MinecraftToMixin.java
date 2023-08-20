package linxiu.utils.mixin;

import linxiu.injection.interfaces.IMixinMinecraft;
import net.minecraft.client.Minecraft;

/**
 * Created by Keir on 21/04/2017.
 */
public interface MinecraftToMixin {

	Minecraft mc = Minecraft.getMinecraft();
	IMixinMinecraft mixMC = (IMixinMinecraft) mc;
}
