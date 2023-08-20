package linxiu.module.modules.uhc;

import io.netty.util.internal.ThreadLocalRandom;
import linxiu.api.EventHandler;
import linxiu.api.events.world.EventMove;
import linxiu.api.events.world.EventPacketReceive;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.events.world.EventTick;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.ghost.Reach;
import linxiu.utils.DimensionHelper;
import linxiu.utils.MovementUtils;
import linxiu.utils.PlayerUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.client.C03PacketPlayer.C05PacketPlayerLook;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S2CPacketSpawnGlobalEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class UhcHelper extends Module {
	public Option RemoveOBS = new Option("Remove OBS", false);
	public Option WaterNoMove = new Option("Water NoMove", false);
	public Option WaterBucket = new Option("Water Bucket", false);
	public Option LightningCheck = new Option("Lightning Check", false);
	private static final Numbers<Number> distance = new Numbers<>("Fall Distance", 3, 1, 10, 0.1);
	private boolean handling;
	public static int x;
	public static int y;
	public static int z;
	private float currentDamage;
	private boolean digging;

	public UhcHelper() {
		super("UhcHelper", new String[] { "UhcHelper" }, ModuleType.Player);
	}

	@EventHandler
	public void Water(EventMove event) {
		if (WaterNoMove.getValue()) {
			if (mc.thePlayer.isInWater()) {
				if (!MovementUtils.isMoving()) {
					event.setX(0);
					event.setZ(0);
				}
			}
		}
	}

	public static boolean tp;

	@EventHandler
	public void onRe(EventPreUpdate ev) {
		if (this.handling) {
			ev.setPitch(85);
		}
	}
	
	@EventHandler
	public void onTick(EventTick ev) {
		if (WaterBucket.getValue()) {
			if (Reach.isPlayerInGame() && !mc.isGamePaused()) {
				if (DimensionHelper.isPlayerInNether())
					this.disable();

				if (this.inPosition() && this.holdWaterBucket()) {
					this.handling = true;
				}

				if (this.handling) {
					this.mlg();
					if (mc.thePlayer.onGround || mc.thePlayer.motionY > 0.0D) {
						this.reset();
					}
				}
			}
		}
	}

	@EventHandler
	public void Pre(EventPreUpdate event) {
		if (RemoveOBS.getValue()) {
			if (this.mc.theWorld.getBlockState(new BlockPos(event.getX(), event.getY() + 1, event.getZ()))
					.getBlock() == Blocks.obsidian
					|| this.mc.theWorld.getBlockState(new BlockPos(event.getX(), event.getY() + 1, event.getZ()))
							.getBlock() == Blocks.cobblestone
					|| this.mc.theWorld.getBlockState(new BlockPos(event.getX(), event.getY() + 2, event.getZ()))
							.getBlock() instanceof BlockFurnace) {
				event.setPitch(89 + ThreadLocalRandom.current().nextFloat());
				Block currentBlock = this.mc.theWorld
						.getBlockState(new BlockPos(event.getX(), event.getY() - 1, event.getZ())).getBlock();
				BlockPos pos = new BlockPos(event.getX(), event.getY() - 1, event.getZ());

				if (this.currentDamage == 0.0F) {
					this.digging = true;
					mc.thePlayer.sendQueue.getNetworkManager().sendPacket(new C07PacketPlayerDigging(
							C07PacketPlayerDigging.Action.START_DESTROY_BLOCK, pos, EnumFacing.UP));
				}

				updateTool(pos);
				mc.thePlayer.sendQueue.getNetworkManager().sendPacket(new C0APacketAnimation());
				this.currentDamage += currentBlock.getPlayerRelativeBlockHardness(this.mc.thePlayer, this.mc.theWorld,
						pos);
				this.mc.theWorld.sendBlockBreakProgress(this.mc.thePlayer.getEntityId(), pos,
						(int) (this.currentDamage * 10.0F) - 1);

				if (this.currentDamage >= 1.0F) {
					mc.thePlayer.sendQueue.getNetworkManager().sendPacket(new C07PacketPlayerDigging(
							C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK, pos, EnumFacing.UP));
					this.mc.playerController.onPlayerDestroyBlock(pos, EnumFacing.UP);
					this.currentDamage = 0.0F;
					this.digging = false;
				}
			} else {
				this.currentDamage = 0.0F;
				this.digging = false;
			}
		}
	}

	@EventHandler
	public void onPacketReceive(EventPacketReceive packetEvent) {
		if (LightningCheck.getValue()) {
			if (EventPacketReceive.packet instanceof S2CPacketSpawnGlobalEntity) {
				S2CPacketSpawnGlobalEntity packetIn = (S2CPacketSpawnGlobalEntity) EventPacketReceive.packet;
				if (packetIn.func_149053_g() == 1) {
					x = (int) ((double) packetIn.func_149051_d() / 32.0D);
					y = (int) ((double) packetIn.func_149050_e() / 32.0D);
					z = (int) ((double) packetIn.func_149049_f() / 32.0D);
					PlayerUtils.tellPlayer("Found Lightning X:" + x + "-Y:" + y + "-Z:" + z);
				}
			}
		}
	}

	@Override
	public void onEnable() {

		super.onEnable();
	}

	@Override
	public void onDisable() {

		super.onDisable();
	}

	private boolean inPosition() {
		if (mc.thePlayer.motionY < -0.6D && !mc.thePlayer.onGround && !mc.thePlayer.capabilities.isFlying
				&& !mc.thePlayer.capabilities.isCreativeMode && !this.handling
				&& mc.thePlayer.fallDistance > distance.getValue().floatValue()) {
			BlockPos playerPos = mc.thePlayer.getPosition();

			for (int i = 1; i < 3; ++i) {
				BlockPos blockPos = playerPos.down(i);
				Block block = mc.theWorld.getBlockState(blockPos).getBlock();
				if (block.isBlockSolid(mc.theWorld, blockPos, EnumFacing.UP)) {
					return false;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	private boolean holdWaterBucket() {
		if (this.containsItem(mc.thePlayer.getHeldItem(), Items.water_bucket)) {
			return true;
		} else {
			for (int i = 0; i < InventoryPlayer.getHotbarSize(); ++i) {
				if (this.containsItem(mc.thePlayer.inventory.mainInventory[i], Items.water_bucket)) {
					mc.thePlayer.inventory.currentItem = i;
					return true;
				}
			}

			return false;
		}
	}

	private void mlg() {
		ItemStack heldItem = mc.thePlayer.getHeldItem();
		if (this.containsItem(heldItem, Items.water_bucket) && mc.thePlayer.rotationPitch >= 70.0F) {
			MovingObjectPosition object = mc.objectMouseOver;
			if (object.typeOfHit == MovingObjectType.BLOCK && object.sideHit == EnumFacing.UP) {
				mc.playerController.sendUseItem(mc.thePlayer, mc.theWorld, heldItem);
			}
		}

	}

	private void reset() {
		ItemStack heldItem = mc.thePlayer.getHeldItem();
		if (this.containsItem(heldItem, Items.bucket)) {
			mc.playerController.sendUseItem(mc.thePlayer, mc.theWorld, heldItem);
		}

		this.handling = false;
	}

	private boolean containsItem(ItemStack itemStack, Item item) {
		return itemStack != null && itemStack.getItem() == item;
	}

	public void updateTool(BlockPos pos) {
		Block block = mc.theWorld.getBlockState(pos).getBlock();
		float strength = 1.0F;
		int slot = -1;

		for (int i = 0; i < 9; ++i) {
			ItemStack itemStack = mc.thePlayer.inventory.getStackInSlot(i);

			if (itemStack != null && itemStack.getStrVsBlock(block) > strength) {
				slot = i;
				strength = itemStack.getStrVsBlock(block);
			}
		}

		if (slot != -1 && mc.thePlayer.inventory
				.getStackInSlot(mc.thePlayer.inventory.currentItem) != mc.thePlayer.inventory.getStackInSlot(slot)) {
			mc.thePlayer.inventory.currentItem = slot;
		}
	}
}
