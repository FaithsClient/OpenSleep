package linxiu.injection.mixins;

import linxiu.api.EventBus;
import linxiu.api.events.world.ChatEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.util.IChatComponent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiNewChat.class)
public abstract class MixinGuiNewChat {
	@Shadow
	private static final Logger logger = LogManager.getLogger();

	@Shadow
	protected abstract void setChatLine(IChatComponent p_146237_1_, int p_146237_2_, int p_146237_3_,
			boolean p_146237_4_);

	/**
	 * @author 1212
	 * @reason C2112
	 */
	@Overwrite
	public void printChatMessageWithOptionalDeletion(IChatComponent chatComponent, int chatLineId) {
		ChatEvent event = new ChatEvent(chatComponent.getUnformattedText(), chatComponent);
		EventBus.getInstance().call(event);
		if (event.isCancelled())
			return;

		this.setChatLine(event.getChatComponent(), chatLineId, Minecraft.getMinecraft().ingameGUI.getUpdateCounter(), false);
		logger.info("[CHAT] " + event.getChatComponent().getUnformattedText());
	}
}
