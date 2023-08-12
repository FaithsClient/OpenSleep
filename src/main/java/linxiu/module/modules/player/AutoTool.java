package linxiu.module.modules.player;

import linxiu.api.EventHandler;
import linxiu.api.events.world.EventAttack;
import linxiu.api.events.world.EventPacketSend;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.events.world.EventTick;
import linxiu.api.events.world.EventUpdate;
import linxiu.api.value.Option;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import scala.reflect.runtime.ReflectionUtils;

import java.util.Iterator;
import java.util.Objects;

import org.lwjgl.input.Mouse;

public class AutoTool extends Module {
	private int oldSlot = -1;
	private boolean wasBreaking = false;

	public AutoTool() {
		super("AutoTool", new String[] { "AutoTool" }, ModuleType.Player);
		super.setRemoved(true);
	}

	@EventHandler
	public void onUpdate(EventUpdate var1) {
		Minecraft var10000;
		Minecraft var10001;
		if (mc.currentScreen == null) {
			var10000 = mc;
			if (mc.thePlayer != null) {
				var10000 = mc;
				if (mc.theWorld != null && mc.objectMouseOver != null && mc.objectMouseOver.getBlockPos() != null
						&& mc.objectMouseOver.entityHit == null && Mouse.isButtonDown(0)) {
					float var2 = 1.0F;
					int var3 = -1;
					var10000 = mc;
					Block var4 = mc.theWorld.getBlockState(mc.objectMouseOver.getBlockPos()).getBlock();

					for (int var5 = 0; var5 < 9; ++var5) {
						var10000 = mc;
						ItemStack var6 = mc.thePlayer.inventory.getStackInSlot(var5);
						if (var6 != null) {
							float var7 = var6.getStrVsBlock(var4);
							if (var7 > var2) {
								var2 = var7;
								var3 = var5;
							}
						}
					}

					if (var3 != -1) {
						var10000 = mc;
						if (mc.thePlayer.inventory.currentItem != var3) {
							var10000 = mc;
							mc.thePlayer.inventory.currentItem = var3;
							this.wasBreaking = true;
							return;
						}
					}

					if (var3 == -1) {
						if (this.wasBreaking) {
							var10000 = mc;
							mc.thePlayer.inventory.currentItem = this.oldSlot;
							this.wasBreaking = false;
						}

						var10001 = mc;
						this.oldSlot = mc.thePlayer.inventory.currentItem;
					}

					return;
				}
			}
		}

		var10000 = mc;
		if (mc.thePlayer != null) {
			var10000 = mc;
			if (mc.theWorld != null) {
				if (this.wasBreaking) {
					var10000 = mc;
					mc.thePlayer.inventory.currentItem = this.oldSlot;
					this.wasBreaking = false;
				}
				var10001 = mc;
				this.oldSlot = mc.thePlayer.inventory.currentItem;
			}
		}
	}
}