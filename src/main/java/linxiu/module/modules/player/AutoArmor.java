package linxiu.module.modules.player;

import java.util.Objects;

import linxiu.api.EventHandler;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.events.world.EventTick;
import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.timer.TimerUtil;
import net.minecraft.client.*;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.item.*;
import net.minecraft.enchantment.*;

public class AutoArmor extends Module {
	private final Mode MODE = new Mode("Mode", new String[] { "FakeInv", "OpenInv", "Basic" }, "FakeInv");
	private TimerUtil timer;
	private final Numbers<Number> DELAY = new Numbers<Number>("Delay", 1.0, 0.0, 10.0, 1.0);

	public AutoArmor() {
		super("AutoArmor", new String[] { "AutoArmor" }, ModuleType.Player);
		this.timer = new TimerUtil();
		super.setRemoved(true);
	}

	@EventHandler
	public void onEvent(EventPreUpdate event) {
		this.setSuffix(MODE.getValue());
		final long delay = DELAY.getValue().longValue() * 50L;
		if (Objects.equals(MODE.getValue(), "OpenInv") && !(mc.currentScreen instanceof GuiInventory)) {
			return;
		}
		if ((mc.currentScreen == null || mc.currentScreen instanceof GuiInventory
				|| mc.currentScreen instanceof GuiChat) && this.timer.hasTimeElapsed(delay)) {
			this.getBestArmor();
		}
	}

	public void getBestArmor() {
		for (int type = 1; type < 5; ++type) {
			if (mc.thePlayer.inventoryContainer.getSlot(4 + type).getHasStack()) {
				final ItemStack is = mc.thePlayer.inventoryContainer.getSlot(4 + type).getStack();
				if (isBestArmor(is, type)) {
					continue;
				}
				if (Objects.equals(MODE.getValue(), "FakeInv")) {
					final C16PacketClientStatus p = new C16PacketClientStatus(
							C16PacketClientStatus.EnumState.OPEN_INVENTORY_ACHIEVEMENT);
					mc.thePlayer.sendQueue.addToSendQueue(p);
				}
				this.drop(4 + type);
			}
			for (int i = 9; i < 45; ++i) {
				if (mc.thePlayer.inventoryContainer.getSlot(i).getHasStack()) {
					final Minecraft mc5 = mc;
					final ItemStack is2 = mc.thePlayer.inventoryContainer.getSlot(i).getStack();
					if (isBestArmor(is2, type) && getProtection(is2) > 0.0f) {
						if (Objects.equals(MODE.getValue(), "FakeInv")) {
							final C16PacketClientStatus p = new C16PacketClientStatus(
									C16PacketClientStatus.EnumState.OPEN_INVENTORY_ACHIEVEMENT);
							mc.thePlayer.sendQueue.addToSendQueue(p);
						}
						this.shiftClick(i);
						if (Objects.equals(MODE.getValue(), "FakeInv")) {
							mc.thePlayer.sendQueue.addToSendQueue(new C0DPacketCloseWindow(0));
						}
						this.timer.reset();
						if (DELAY.getValue().longValue() > 0L) {
							return;
						}
					}
				}
			}
		}
	}

	public boolean isBestArmor(final ItemStack stack, final int type) {
		final float prot = getProtection(stack);
		String strType = "";
		if (type == 1) {
			strType = "helmet";
		} else if (type == 2) {
			strType = "chestplate";
		} else if (type == 3) {
			strType = "leggings";
		} else if (type == 4) {
			strType = "boots";
		}
		if (!stack.getUnlocalizedName().contains(strType)) {
			return false;
		}
		for (int i = 5; i < 45; ++i) {
			if (mc.thePlayer.inventoryContainer.getSlot(i).getHasStack()) {
				final Minecraft mc2 = mc;
				final ItemStack is = mc.thePlayer.inventoryContainer.getSlot(i).getStack();
				if (getProtection(is) > prot && is.getUnlocalizedName().contains(strType)) {
					return false;
				}
			}
		}
		return true;
	}

	public void shiftClick(final int slot) {
		final PlayerControllerMP playerController = mc.playerController;
		final int windowId = mc.thePlayer.inventoryContainer.windowId;
		final int mouseButtonClicked = 0;
		final int mode = 1;
		playerController.windowClick(windowId, slot, mouseButtonClicked, mode, mc.thePlayer);
	}

	public void drop(final int slot) {
		final PlayerControllerMP playerController = mc.playerController;
		final int windowId = mc.thePlayer.inventoryContainer.windowId;
		final int mouseButtonClicked = 1;
		final int mode = 4;
		playerController.windowClick(windowId, slot, mouseButtonClicked, mode, mc.thePlayer);
	}

	public static float getProtection(final ItemStack stack) {
		float prot = 0.0f;
		if (stack.getItem() instanceof ItemArmor) {
			final ItemArmor armor = (ItemArmor) stack.getItem();
			prot += armor.damageReduceAmount + (100 - armor.damageReduceAmount)
					* EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, stack) * 0.0075;
			prot += EnchantmentHelper.getEnchantmentLevel(Enchantment.blastProtection.effectId, stack) / 100.0;
			prot += EnchantmentHelper.getEnchantmentLevel(Enchantment.fireProtection.effectId, stack) / 100.0;
			prot += EnchantmentHelper.getEnchantmentLevel(Enchantment.thorns.effectId, stack) / 100.0;
			prot += EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, stack) / 50.0;
			prot += EnchantmentHelper.getEnchantmentLevel(Enchantment.featherFalling.effectId, stack) / 100.0;
		}
		return prot;
	}

	private enum EMode {
		Basic, OpenInv, FakeInv
	}
}
