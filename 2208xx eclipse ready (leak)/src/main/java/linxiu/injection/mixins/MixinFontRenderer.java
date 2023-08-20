package linxiu.injection.mixins;

import linxiu.utils.Helper;
import net.minecraft.client.gui.FontRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(FontRenderer.class)
public abstract class MixinFontRenderer {

	@ModifyArg(method = "renderString", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/FontRenderer;renderStringAtPos(Ljava/lang/String;Z)V"))
	public String changeString(final String in) {
	//	if (!Client.getModuleManager().getModuleByClass(Deobfuscator.class).isEnabled())
	//		return in;

		String title;
		if (Helper.mc.theWorld == null || Helper.mc.theWorld.getScoreboard() == null
				|| Helper.mc.theWorld.getScoreboard().getObjectiveInDisplaySlot(1) == null)
			title = " ";
		else
			title = Helper.mc.theWorld.getScoreboard().getObjectiveInDisplaySlot(1).getDisplayName();

		return in.replace("§k", "");
	}
}
