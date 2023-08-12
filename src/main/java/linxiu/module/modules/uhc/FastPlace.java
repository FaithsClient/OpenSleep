package linxiu.module.modules.uhc;

import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender2D;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.injection.interfaces.IMixinMinecraft;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.render.Nametags;
import linxiu.ui.font.FontLoaders;
import linxiu.utils.render.Colors;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import org.apache.commons.lang3.RandomUtils;

import java.util.List;
import java.awt.*;
import java.util.Arrays;

public class FastPlace extends Module {
	public Numbers<Number> placeDelay = new Numbers<>("Place Delay", 1.0, 0.0, 4.0, 1.0);
	private final Option blocks = new Option("Blocks", true);
	private final Option projectiles = new Option("Projectiles", true);
	public Option randomize = new Option("Randomize", false);
	boolean block;

	public FastPlace() {
		super("FastPlace", new String[] { "fPlace", "fc", "fp" }, ModuleType.Player);
		this.setColor(new Color(226, 197, 78).getRGB());
	}

	private boolean canFastPlace() {
		if (mc.thePlayer == null || mc.thePlayer.getCurrentEquippedItem() == null
				|| mc.thePlayer.getCurrentEquippedItem().getItem() == null)
			return false;
		Item heldItem = mc.thePlayer.getCurrentEquippedItem().getItem();
		return (blocks.getValue() && heldItem instanceof ItemBlock)
				|| (projectiles.getValue() && (heldItem instanceof ItemSnowball || heldItem instanceof ItemEgg));
	}

	@EventHandler
	public void onRender2DEvent(EventRender2D event) {
		if (canFastPlace() && blocks.getValue()) {
			int c = Colors.getColor(255, 0, 0, 200);
			if (mc.thePlayer.getHeldItem().stackSize <= 40 && mc.thePlayer.getHeldItem().stackSize >= 15) {
				c = Colors.getColor(255, 255, 0, 200);
			} else if (mc.thePlayer.getHeldItem().stackSize >= 40) {
				c = Colors.getColor(0, 255, 0, 200);
			}

			ScaledResolution res = new ScaledResolution(mc);
			String info = "" + mc.thePlayer.getHeldItem().stackSize;
			GlStateManager.enableBlend();
			Nametags name = (Nametags) ModuleManager.getModuleByClass(Nametags.class);
			mc.fontRendererObj.drawStringWithShadow(EnumChatFormatting.BOLD + info,
					(float) res.getScaledWidth() / 2.0F - (float) mc.fontRendererObj.getStringWidth(info) / 2.0F + 0.0f,
					(float) res.getScaledHeight() / 2.0F + 7.0F, c);
			// GlStateManager.disableBlend();
		}
	}

	@EventHandler
	public void onTick(EventPreUpdate event) {
		if (canFastPlace()) {
			int delay = (int) this.placeDelay.getValue().intValue();
			if (delay == 0) {
				if (randomize.getValue()) {
					delay = RandomUtils.nextInt(0, delay);
				}
				((IMixinMinecraft) this.mc).setRightClickDelayTimer(delay);
			} else {
				if (((IMixinMinecraft) this.mc).getRightClickDelayTimer() > delay) {
					if (randomize.getValue()) {
						delay = RandomUtils.nextInt(0, delay);
					}
					((IMixinMinecraft) this.mc).setRightClickDelayTimer(delay);
				}
			}
		}
	}
}