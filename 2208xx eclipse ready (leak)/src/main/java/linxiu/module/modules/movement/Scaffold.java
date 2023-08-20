package linxiu.module.modules.movement;

import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender2D;
import linxiu.api.events.world.EventMove;
import linxiu.api.events.world.EventPostUpdate;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.events.world.SafeWalkEvent;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.render.Nametags;
import linxiu.ui.MoveUtil;
import linxiu.ui.ScaffoldUtils;
import linxiu.utils.MoveUtils;
import linxiu.utils.MovementUtils;
import linxiu.utils.PacketUtils;
import linxiu.utils.PlayerUtil;
import linxiu.utils.math.MathUtil;
import linxiu.utils.render.Colors;
import linxiu.utils.timer.TimerUtil;
import net.minecraft.block.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.potion.Potion;
import net.minecraft.util.*;
import org.apache.commons.lang3.RandomUtils;
import org.lwjgl.input.Keyboard;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Scaffold extends Module {

	private BlockData data;

	private int slot;

	private int towerTicks;

	public static ScaffoldUtils.Rotation rotation;

	private final TimerUtil timer = new TimerUtil();

	private final TimerUtil timer2 = new TimerUtil();

	private double posY;

	private final MoveUtil move = new MoveUtil();

	private final Numbers<Number> delayValue = new Numbers<>("Delay", 0.5, 0.0, 10.0, 0.1);

	private final Option towerMoveValue = new Option("Tower Move", true), keepYValue = new Option("Keep Y", false),
			safeWalkValue = new Option("Safe Walk", true), sprintValue = new Option("Sprint", true),
			swingValue = new Option("Swing", true), silentValue = new Option("Silent", true),
			towerValue = new Option("Tower", true), eagleValue = new Option("Eagle", false);

	private final List<Block> blacklisted = Arrays.asList(Blocks.air, Blocks.water, Blocks.flowing_water, Blocks.lava,
			Blocks.flowing_lava, Blocks.enchanting_table, Blocks.ender_chest, Blocks.sand, Blocks.tnt,
			Blocks.yellow_flower, Blocks.carpet, Blocks.glass_pane, Blocks.stained_glass_pane, Blocks.iron_bars,
			Blocks.crafting_table, Blocks.snow_layer, Blocks.packed_ice, Blocks.coal_ore, Blocks.diamond_ore,
			Blocks.emerald_ore, Blocks.chest, Blocks.torch, Blocks.stone_slab, Blocks.wooden_slab, Blocks.stone_slab2,
			Blocks.double_stone_slab2, Blocks.double_wooden_slab, Blocks.anvil, Blocks.trapped_chest, Blocks.noteblock,
			Blocks.gold_ore, Blocks.lapis_ore, Blocks.lit_redstone_ore, Blocks.redstone_ore,
			Blocks.wooden_pressure_plate, Blocks.stone_pressure_plate, Blocks.light_weighted_pressure_plate,
			Blocks.heavy_weighted_pressure_plate, Blocks.stone_button, Blocks.wooden_button, Blocks.cactus,
			Blocks.oak_stairs, Blocks.stone_brick_stairs, Blocks.nether_brick_stairs, Blocks.stone_stairs,
			Blocks.brick_stairs, Blocks.sandstone_stairs, Blocks.lever, Blocks.activator_rail, Blocks.rail,
			Blocks.spruce_stairs, Blocks.detector_rail, Blocks.golden_rail, Blocks.furnace, Blocks.ladder,
			Blocks.acacia_stairs, Blocks.double_stone_slab2, Blocks.dark_oak_stairs, Blocks.birch_stairs,
			Blocks.jungle_stairs, Blocks.quartz_stairs, Blocks.oak_fence, Blocks.redstone_torch, Blocks.iron_trapdoor,
			Blocks.trapdoor, Blocks.tripwire_hook, Blocks.hopper, Blocks.acacia_fence_gate, Blocks.birch_fence_gate,
			Blocks.dark_oak_fence_gate, Blocks.jungle_fence_gate, Blocks.spruce_fence_gate, Blocks.oak_fence_gate,
			Blocks.dispenser, Blocks.sapling, Blocks.tallgrass, Blocks.deadbush, Blocks.web, Blocks.red_flower,
			Blocks.red_mushroom, Blocks.brown_mushroom, Blocks.nether_brick_fence, Blocks.vine, Blocks.double_plant,
			Blocks.flower_pot, Blocks.beacon, Blocks.pumpkin, Blocks.lit_pumpkin);

	public Scaffold() {
		super("Scaffold", new String[] { "magiccarpet", "blockplacer", "airwalk" }, ModuleType.Movement);
		rotation = new ScaffoldUtils.Rotation(999.0f, 999.0f);
	}

	@Override
	public void onEnable() {
		super.onEnable();
		data = null;
		slot = -1;
		timer.reset();
		posY = MathHelper.floor_double(mc.thePlayer.posY);
		rotation.setYaw(999.0f);
		rotation.setPitch(999.0f);
	}

	@Override
	public void onDisable() {
		super.onDisable();
		mc.timer.timerSpeed = 1;
		rotation.setYaw(999.0f);
		rotation.setPitch(999.0f);
		if (eagleValue.getValue()) {
			mc.gameSettings.keyBindSneak.pressed = Keyboard.isKeyDown(mc.gameSettings.keyBindSneak.getKeyCode());
		}
	}

	@EventHandler
	public void move(EventMove e) {
		if (!sprintValue.getValue()) {
			if (MovementUtils.isMoving()) {
				MovementUtils.setSpeed(e, 0.22);
			}
		}
	}

	@EventHandler
	void onUpdate(EventPreUpdate event) {
		this.setSuffix("" + getAllBlockCount());
		if (getAllBlockCount() <= 0)
			return;

		if (!sprintValue.getValue()) {
			if (mc.thePlayer.isPotionActive(Potion.moveSpeed)) {
				mc.thePlayer.motionX *= 0.800000011920929;
				mc.thePlayer.motionZ *= 0.800000011920929;
			}
		}

		if (!sprintValue.getValue()) {
			mc.thePlayer.setSprinting(false);
		}

		if (keepYValue.getValue()) {
			if (posY > mc.thePlayer.posY || mc.thePlayer.fallDistance > 1.5)
				posY = mc.thePlayer.posY;

			if (PlayerUtil.isOnGround(1.15) && !PlayerUtil.MovementInput() && !PlayerUtil.isOnGround(-2)
					&& Keyboard.isKeyDown(Keyboard.KEY_SPACE) && towerMoveValue.getValue()) {
				posY = mc.thePlayer.posY;
			}
		} else {
			posY = mc.thePlayer.posY;
		}

		if (this.getBlockCountHotBar() <= 0) {
			final int spoofSlot = this.getBestSpoofSlot();
			this.getBlock(spoofSlot);
		}

		this.data = ((this
				.getBlockData(new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 1.0, mc.thePlayer.posZ)) == null)
						? this.getBlockData(
								new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 1.0, mc.thePlayer.posZ).down(1))
						: this.getBlockData(
								new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 1.0, mc.thePlayer.posZ)));

		this.slot = getBlockSlot();

		mc.thePlayer.inventoryContainer.getSlot(this.slot + 36).getStack();

		if (this.data == null || this.slot == -1 || this.getBlockCountHotBar() <= 0
				|| (!MoveUtils.isMoving() && !mc.gameSettings.keyBindJump.isKeyDown())) {
			return;
		}
		if (mc.theWorld.getBlockState(new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 0.5, mc.thePlayer.posZ))
				.getBlock() == Blocks.air) {
			float rot = 0.0f;
			if (mc.thePlayer.movementInput.moveForward > 0.0f) {
				rot = 180.0f;
				if (mc.thePlayer.movementInput.moveStrafe > 0.0f) {
					rot = -120.0f;
				} else if (mc.thePlayer.movementInput.moveStrafe < 0.0f) {
					rot = 120.0f;
				}
			} else if (mc.thePlayer.movementInput.moveForward == 0.0f) {
				rot = 180.0f;
				if (mc.thePlayer.movementInput.moveStrafe > 0.0f) {
					rot = -90.0f;
				} else if (mc.thePlayer.movementInput.moveStrafe < 0.0f) {
					rot = 90.0f;
				}
			} else if (mc.thePlayer.movementInput.moveForward < 0.0f) {
				if (mc.thePlayer.movementInput.moveStrafe > 0.0f) {
					rot = -45.0f;
				} else if (mc.thePlayer.movementInput.moveStrafe < 0.0f) {
					rot = 45.0f;
				}
			}
			if (PlayerUtil.isAirUnder((Entity) mc.thePlayer) && mc.gameSettings.keyBindJump.isKeyDown()
					&& !PlayerUtil.MovementInput() && this.towerValue.getValue()) {
				rot = 180.0f;
			}
			rotation.setYaw(MathHelper.wrapAngleTo180_float(mc.thePlayer.rotationYaw) - rot);
			rotation.setPitch(87.5f);
		}
		if (rotation.getYaw() != 999.0f) {
			event.setYaw(rotation.getYaw());
		}
		if (rotation.getPitch() != 999.0f) {
			event.setPitch(rotation.getPitch());
		}

		if (eagleValue.getValue())
			mc.gameSettings.keyBindSneak.pressed = PlayerUtil.isAirUnder(mc.thePlayer);
	}

	@EventHandler
	public void post(EventPostUpdate e) {
		if (slot == -1) {
			timer.reset();
			return;
		}

		if (!timer.hasTimeElapsed(delayValue.getValue().intValue() * 100L))
			return;
		
		if (towerValue.getValue()) {
			if (mc.gameSettings.keyBindJump.isKeyDown()) {
				if (mc.thePlayer.onGround) {
					mc.thePlayer.motionY = 0.42f;
				} else if (mc.thePlayer.motionY < 0.17D && mc.thePlayer.motionY > 0.16D) {
					mc.thePlayer.motionY = -0.02f;
				}
			}
		}
		
		if (towerMoving()) {
			if (MovementUtils.isOnGround(0.76) && !MovementUtils.isOnGround(0.75) && mc.thePlayer.motionY > 0.23
					&& mc.thePlayer.motionY < 0.25) {
				mc.thePlayer.motionY = Math.round(mc.thePlayer.posY) - mc.thePlayer.posY;
			}
			if (MovementUtils.isOnGround(1.0E-4)) {
				mc.thePlayer.motionY = MovementUtils.getJumpHeight(0.419999986886978D);
				mc.thePlayer.motionX *= 0.9;
				mc.thePlayer.motionZ *= 0.9;
			} else if (mc.thePlayer.posY >= Math.round(mc.thePlayer.posY) - 1.0E-4
					&& mc.thePlayer.posY <= Math.round(mc.thePlayer.posY) + 1.0E-4
					&& !mc.gameSettings.keyBindSneak.isKeyDown()) {
				mc.thePlayer.motionY = 0.0;
			}
		}

		final int last = mc.thePlayer.inventory.currentItem;
		mc.thePlayer.inventory.currentItem = this.slot;
		if (this.data != null) {
			if (mc.playerController.onPlayerRightClick(mc.thePlayer, mc.theWorld, mc.thePlayer.getCurrentEquippedItem(),
					this.data.getBlockPos(), this.data.getEnumFacing(),
					getVec3(this.data.getBlockPos(), this.data.getEnumFacing()))) {
				if (mc.thePlayer.inventory.getStackInSlot(mc.thePlayer.inventory.currentItem).getItem() != null
						&& mc.thePlayer.inventory.getStackInSlot(mc.thePlayer.inventory.currentItem)
								.getItem() instanceof ItemBlock
						&& !mc.isSingleplayer()) {
					mc.thePlayer.inventory.getStackInSlot(mc.thePlayer.inventory.currentItem).getItem();
				}
				if (swingValue.getValue()) {
					mc.thePlayer.swingItem();
				} else {
					PacketUtils.sendPacketNoEvent((Packet<?>) new C0APacketAnimation());
				}
			}
			mc.thePlayer.inventory.currentItem = last;
		}
		timer.reset();
	}

	@EventHandler
	public void onRender2DEvent(EventRender2D event) {
		int c = Colors.getColor(255, 0, 0, 150);
		if (this.getAllBlockCount() >= 64 && 128 > this.getAllBlockCount()) {
			c = Colors.getColor(255, 255, 0, 150);
		} else if (this.getAllBlockCount() >= 128) {
			c = Colors.getColor(0, 255, 0, 150);
		}

		ScaledResolution res = new ScaledResolution(mc);
		String info = "" + this.getAllBlockCount();
		GlStateManager.enableBlend();
		Nametags name = (Nametags) ModuleManager.getModuleByClass(Nametags.class);
		name.drawOutlinedString(info,
				(float) res.getScaledWidth() / 2.0F - (float) mc.fontRendererObj.getStringWidth(info) / 2.0F,
				(float) res.getScaledHeight() / 2.0F - 25.0F, c);
		GlStateManager.disableBlend();
	}

	@EventHandler
	void onSafeWalk(SafeWalkEvent event) {
		if (!safeWalkValue.getValue() && getAllBlockCount() > 0 || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
			return;
		event.setCancelled(true);
	}

	private boolean towering() {
		return towerValue.getValue() && !MovementUtils.isMoving() && Keyboard.isKeyDown(Keyboard.KEY_SPACE)
				&& !mc.thePlayer.isPotionActive(Potion.jump);
	}

	private boolean towerMoving() {
		return towerMoveValue.getValue() && Keyboard.isKeyDown(Keyboard.KEY_SPACE) && MovementUtils.isMoving();
	}

	public void setMotion(double speed) {
		double forward = mc.thePlayer.movementInput.moveForward;
		double strafe = mc.thePlayer.movementInput.moveStrafe;
		float yaw = mc.thePlayer.rotationYaw;
		if (forward == 0.0 && strafe == 0.0) {
			mc.thePlayer.motionX = 0.0;
			mc.thePlayer.motionZ = 0.0;
		} else {
			if (forward != 0.0) {
				if (strafe > 0.0) {
					yaw += (float) (forward > 0.0 ? -45 : 45);
				} else if (strafe < 0.0) {
					yaw += (float) (forward > 0.0 ? 45 : -45);
				}
				strafe = 0.0;
				if (forward > 0.0) {
					forward = 1.0;
				} else if (forward < 0.0) {
					forward = -1.0;
				}
			}
			mc.thePlayer.motionX = forward * speed * (-Math.sin(Math.toRadians(yaw)))
					+ strafe * speed * Math.cos(Math.toRadians(yaw));
			mc.thePlayer.motionZ = forward * speed * Math.cos(Math.toRadians(yaw))
					- strafe * speed * (-Math.sin(Math.toRadians(yaw)));
		}
	}

	private int neededSlot() {
		for (int i = 0; i < 9; ++i) {
			if (mc.thePlayer.inventory.getStackInSlot(i) != null
					&& mc.thePlayer.inventory.getStackInSlot(i).stackSize != 0) {
				Item item = mc.thePlayer.inventory.getStackInSlot(i).getItem();

				if (isValid(item)) {
					return i;
				}
			}
		}

		return mc.thePlayer.inventory.currentItem;
	}

	public static double randomNumber(final double max, final double min) {
		return Math.random() * (max - min) + min;
	}

	public static Vec3 getVec3(final BlockPos pos, final EnumFacing face) {
		double x = pos.getX() + 0.5;
		double y = pos.getY() + 0.5;
		double z = pos.getZ() + 0.5;
		if (face == EnumFacing.UP || face == EnumFacing.DOWN) {
			x += randomNumber(0.3, -0.3);
			z += randomNumber(0.3, -0.3);
		} else {
			y += randomNumber(0.3, -0.3);
		}
		if (face == EnumFacing.WEST || face == EnumFacing.EAST) {
			z += randomNumber(0.3, -0.3);
		}
		if (face == EnumFacing.SOUTH || face == EnumFacing.NORTH) {
			x += randomNumber(0.3, -0.3);
		}
		return new Vec3(x, y, z);
	}

	public boolean isAirBlock(Block block) {
		if (block.getMaterial().isReplaceable()) {
			return !(block instanceof BlockSnow) || !(block.getBlockBoundsMaxY() > 0.125);
		}
		return false;
	}

	public static void a(net.minecraft.util.Timer timer, float f) {
		timer.timerSpeed = f;
	}

	public static Vec3 a(BlockPos var0, EnumFacing var1) {
		double var2 = var0.getX();
		double var4 = var0.getY();
		double var6 = var0.getZ();
		double var8 = ThreadLocalRandom.current().nextDouble(0.6D, 1.0D);
		double var10 = ThreadLocalRandom.current().nextDouble(0.9D, 1.0D);
		if (var1.equals(EnumFacing.UP)) {
			var2 += var8;
			var6 += var8;
			++var4;
		} else if (var1.equals(EnumFacing.DOWN)) {
			var2 += var8;
			var6 += var8;
		} else if (var1.equals(EnumFacing.WEST)) {
			var4 += var10;
			var6 += var8;
		} else if (var1.equals(EnumFacing.EAST)) {
			var4 += var10;
			var6 += var8;
			++var2;
		} else if (var1.equals(EnumFacing.SOUTH)) {
			var4 += var10;
			var2 += var8;
			++var6;
		} else if (var1.equals(EnumFacing.NORTH)) {
			var4 += var10;
			var2 += var8;
		}

		return new Vec3(var2, var4, var6);
	}

	private int down(double n) {
		int n2 = (int) n;

		try {
			if (n < (double) n2) {
				return n2 - 1;
			}
		} catch (IllegalArgumentException var5) {
		}
		return n2;
	}

	public long randomDelay(final int minDelay, final int maxDelay) {
		return RandomUtils.nextInt(minDelay, maxDelay);
	}

	public long randomClickDelay(final int minCPS, final int maxCPS) {
		return (long) ((Math.random() * (1000 / minCPS - 1000 / maxCPS + 1)) + 1000 / maxCPS);
	}

	public boolean isBlockAccessible(Block paramBlock) {
		if (paramBlock.getMaterial().isReplaceable()) {
			return ((!(paramBlock instanceof BlockSnow))) || (!(paramBlock.getBlockBoundsMaxY() > 0.125D));
		}
		return false;
	}

	public void eventMotion(EventPostUpdate paramEventMotion) {
		BlockPos localBlockPos = new BlockPos(mc.thePlayer.posX, mc.thePlayer.posY - 1.0D, mc.thePlayer.posZ);
		Block localBlock = mc.theWorld.getBlockState(localBlockPos).getBlock();
		BlockData localBlockData = getBlockData(localBlockPos);

		if ((isBlockAccessible(localBlock)) && (localBlockData != null)) {
			mc.thePlayer.motionY = 0.41999998688697815D;
			mc.thePlayer.motionX *= 0.0D;
			mc.thePlayer.motionZ *= 0.0D;
		}
	}

	private boolean isValid(Item item) {
		if (!(item instanceof ItemBlock)) {
			return false;
		} else {
			ItemBlock iBlock = (ItemBlock) item;
			Block block = iBlock.getBlock();
			return !blacklisted.contains(block);
		}
	}

	public static Vec3 getHypixelVec3(BlockData data) {
		BlockPos pos = data.pos;
		EnumFacing face = data.facing;
		double x = (double) pos.getX() + 0.5, y = (double) pos.getY() + 0.5, z = (double) pos.getZ() + 0.5;
		if (face != EnumFacing.UP && face != EnumFacing.DOWN) {
			y += 0.5;
		} else {
			x += 0.3;
			z += 0.3;
		}
		if (face == EnumFacing.WEST || face == EnumFacing.EAST) {
			z += 0.15;
		}
		if (face == EnumFacing.SOUTH || face == EnumFacing.NORTH) {
			x += 0.15;
		}
		return new Vec3(x, y, z);
	}

	public int getBlockSlot() {
		for (int i = 0; i < 9; ++i) {
			if (mc.thePlayer.inventoryContainer.getSlot(i + 36).getHasStack()
					&& mc.thePlayer.inventoryContainer.getSlot(i + 36).getStack().getItem() instanceof ItemBlock) {
				return i;
			}
		}
		return -1;
	}

	public int getAllBlockCount() {
		int blockCount = 0;
		for (int i = 0; i < 45; i++) {
			blockCount += (mc.thePlayer.inventoryContainer.getSlot(i).getHasStack()
					&& mc.thePlayer.inventoryContainer.getSlot(i).getStack().getItem() instanceof ItemBlock)
							? mc.thePlayer.inventoryContainer.getSlot(i).getStack().stackSize
							: 0;
		}
		return blockCount;
	}

	public int getHotBarBlockCount() {
		int blockCount = 0;
		for (int i = 36; i < 45; i++) {
			blockCount += (mc.thePlayer.inventoryContainer.getSlot(i).getHasStack()
					&& mc.thePlayer.inventoryContainer.getSlot(i).getStack().getItem() instanceof ItemBlock)
							? mc.thePlayer.inventoryContainer.getSlot(i).getStack().stackSize
							: 0;
		}
		return blockCount;
	}

	public void swap(int currentSlot, int targetSlot) {
		mc.playerController.windowClick(mc.thePlayer.inventoryContainer.windowId, currentSlot, targetSlot, 2,
				mc.thePlayer);
	}

	void getBlock(final int hotbarSlot) {
		for (int i = 9; i < 45; ++i) {
			if (mc.thePlayer.inventoryContainer.getSlot(i).getHasStack()
					&& (mc.currentScreen == null || mc.currentScreen instanceof GuiInventory)) {
				final ItemStack is = mc.thePlayer.inventoryContainer.getSlot(i).getStack();
				if (is.getItem() instanceof ItemBlock) {
					final ItemBlock block = (ItemBlock) is.getItem();
					if (this.isValid((Item) block)) {
						if (36 + hotbarSlot != i) {
							this.swap(i, hotbarSlot);
							break;
						}
						break;
					}
				}
			}
		}
	}

	private int getBlockCountHotBar() {
		int blockCount = 0;

		for (int i = 36; i < 45; ++i) {
			if (mc.thePlayer.inventoryContainer.getSlot(i).getHasStack()) {
				ItemStack is = mc.thePlayer.inventoryContainer.getSlot(i).getStack();
				Item item = is.getItem();

				if (is.getItem() instanceof ItemBlock && !this.blacklisted.contains(((ItemBlock) item).getBlock())) {
					blockCount += is.stackSize;
				}
			}
		}

		return blockCount;
	}

	int getBestSpoofSlot() {
		int spoofSlot = 5;
		for (int i = 36; i < 45; ++i) {
			if (!mc.thePlayer.inventoryContainer.getSlot(i).getHasStack()) {
				spoofSlot = i - 36;
				break;
			}
		}
		return spoofSlot;
	}

	private int getBiggestBlockSlotInv() {
		int slot = -1;
		int size = 0;

		if (this.getAllBlockCount() == 0) {
			return -1;
		} else {
			for (int i = 9; i < 36; ++i) {
				Slot s = mc.thePlayer.inventoryContainer.getSlot(i);

				if (s.getHasStack()) {
					Item item = s.getStack().getItem();
					ItemStack is = s.getStack();

					if (item instanceof ItemBlock && this.isValid(item) && is.stackSize > size) {
						size = is.stackSize;
						slot = i;
					}
				}
			}

			return slot;
		}
	}

	private int getBestBlockSlotHotBar() {
		int slot = -1;
		int size = 0;
		for (int i = 36; i < 45; i++) {
			if (mc.thePlayer.inventoryContainer.getSlot(i).getHasStack()) {
				Item item = mc.thePlayer.inventoryContainer.getSlot(i).getStack().getItem();
				ItemStack is = mc.thePlayer.inventoryContainer.getSlot(i).getStack();
				if (item instanceof ItemBlock && isValid(item)) {
					if (is.stackSize > size) {
						size = is.stackSize;
						slot = i;
					}
				}
			}
		}
		return slot;
	}

	private int getBestBlockSlotInventory() {
		int slot = -1;
		int size = 0;
		for (int i = 9; i < 36; i++) {
			if (mc.thePlayer.inventoryContainer.getSlot(i).getHasStack()) {
				Item item = mc.thePlayer.inventoryContainer.getSlot(i).getStack().getItem();
				ItemStack is = mc.thePlayer.inventoryContainer.getSlot(i).getStack();
				if (item instanceof ItemBlock && isValid(item)) {
					if (is.stackSize > size) {
						size = is.stackSize;
						slot = i;
					}
				}
			}
		}
		return slot;
	}

	private BlockData getBlockData(BlockPos pos) {
		if (this.isPosValid(pos.add(0, -1, 0))) {
			return new BlockData(pos.add(0, -1, 0), EnumFacing.UP);
		}
		if (this.isPosValid(pos.add(-1, 0, 0))) {
			return new BlockData(pos.add(-1, 0, 0), EnumFacing.EAST);
		}
		if (this.isPosValid(pos.add(1, 0, 0))) {
			return new BlockData(pos.add(1, 0, 0), EnumFacing.WEST);
		}
		if (this.isPosValid(pos.add(0, 0, 1))) {
			return new BlockData(pos.add(0, 0, 1), EnumFacing.NORTH);
		}
		if (this.isPosValid(pos.add(0, 0, -1))) {
			return new BlockData(pos.add(0, 0, -1), EnumFacing.SOUTH);
		}
		final BlockPos pos2 = pos.add(-1, 0, 0);
		if (this.isPosValid(pos2.add(0, -1, 0))) {
			return new BlockData(pos2.add(0, -1, 0), EnumFacing.UP);
		}
		if (this.isPosValid(pos2.add(-1, 0, 0))) {
			return new BlockData(pos2.add(-1, 0, 0), EnumFacing.EAST);
		}
		if (this.isPosValid(pos2.add(1, 0, 0))) {
			return new BlockData(pos2.add(1, 0, 0), EnumFacing.WEST);
		}
		if (this.isPosValid(pos2.add(0, 0, 1))) {
			return new BlockData(pos2.add(0, 0, 1), EnumFacing.NORTH);
		}
		if (this.isPosValid(pos2.add(0, 0, -1))) {
			return new BlockData(pos2.add(0, 0, -1), EnumFacing.SOUTH);
		}
		final BlockPos pos3 = pos.add(1, 0, 0);
		if (this.isPosValid(pos3.add(0, -1, 0))) {
			return new BlockData(pos3.add(0, -1, 0), EnumFacing.UP);
		}
		if (this.isPosValid(pos3.add(-1, 0, 0))) {
			return new BlockData(pos3.add(-1, 0, 0), EnumFacing.EAST);
		}
		if (this.isPosValid(pos3.add(1, 0, 0))) {
			return new BlockData(pos3.add(1, 0, 0), EnumFacing.WEST);
		}
		if (this.isPosValid(pos3.add(0, 0, 1))) {
			return new BlockData(pos3.add(0, 0, 1), EnumFacing.NORTH);
		}
		if (this.isPosValid(pos3.add(0, 0, -1))) {
			return new BlockData(pos3.add(0, 0, -1), EnumFacing.SOUTH);
		}
		final BlockPos pos4 = pos.add(0, 0, 1);
		if (this.isPosValid(pos4.add(0, -1, 0))) {
			return new BlockData(pos4.add(0, -1, 0), EnumFacing.UP);
		}
		if (this.isPosValid(pos4.add(-1, 0, 0))) {
			return new BlockData(pos4.add(-1, 0, 0), EnumFacing.EAST);
		}
		if (this.isPosValid(pos4.add(1, 0, 0))) {
			return new BlockData(pos4.add(1, 0, 0), EnumFacing.WEST);
		}
		if (this.isPosValid(pos4.add(0, 0, 1))) {
			return new BlockData(pos4.add(0, 0, 1), EnumFacing.NORTH);
		}
		if (this.isPosValid(pos4.add(0, 0, -1))) {
			return new BlockData(pos4.add(0, 0, -1), EnumFacing.SOUTH);
		}
		final BlockPos pos5 = pos.add(0, 0, -1);
		if (this.isPosValid(pos5.add(0, -1, 0))) {
			return new BlockData(pos5.add(0, -1, 0), EnumFacing.UP);
		}
		if (this.isPosValid(pos5.add(-1, 0, 0))) {
			return new BlockData(pos5.add(-1, 0, 0), EnumFacing.EAST);
		}
		if (this.isPosValid(pos5.add(1, 0, 0))) {
			return new BlockData(pos5.add(1, 0, 0), EnumFacing.WEST);
		}
		if (this.isPosValid(pos5.add(0, 0, 1))) {
			return new BlockData(pos5.add(0, 0, 1), EnumFacing.NORTH);
		}
		if (this.isPosValid(pos5.add(0, 0, -1))) {
			return new BlockData(pos5.add(0, 0, -1), EnumFacing.SOUTH);
		}
		pos.add(-2, 0, 0);
		if (this.isPosValid(pos2.add(0, -1, 0))) {
			return new BlockData(pos2.add(0, -1, 0), EnumFacing.UP);
		}
		if (this.isPosValid(pos2.add(-1, 0, 0))) {
			return new BlockData(pos2.add(-1, 0, 0), EnumFacing.EAST);
		}
		if (this.isPosValid(pos2.add(1, 0, 0))) {
			return new BlockData(pos2.add(1, 0, 0), EnumFacing.WEST);
		}
		if (this.isPosValid(pos2.add(0, 0, 1))) {
			return new BlockData(pos2.add(0, 0, 1), EnumFacing.NORTH);
		}
		if (this.isPosValid(pos2.add(0, 0, -1))) {
			return new BlockData(pos2.add(0, 0, -1), EnumFacing.SOUTH);
		}
		pos.add(2, 0, 0);
		if (this.isPosValid(pos3.add(0, -1, 0))) {
			return new BlockData(pos3.add(0, -1, 0), EnumFacing.UP);
		}
		if (this.isPosValid(pos3.add(-1, 0, 0))) {
			return new BlockData(pos3.add(-1, 0, 0), EnumFacing.EAST);
		}
		if (this.isPosValid(pos3.add(1, 0, 0))) {
			return new BlockData(pos3.add(1, 0, 0), EnumFacing.WEST);
		}
		if (this.isPosValid(pos3.add(0, 0, 1))) {
			return new BlockData(pos3.add(0, 0, 1), EnumFacing.NORTH);
		}
		if (this.isPosValid(pos3.add(0, 0, -1))) {
			return new BlockData(pos3.add(0, 0, -1), EnumFacing.SOUTH);
		}
		pos.add(0, 0, 2);
		if (this.isPosValid(pos4.add(0, -1, 0))) {
			return new BlockData(pos4.add(0, -1, 0), EnumFacing.UP);
		}
		if (this.isPosValid(pos4.add(-1, 0, 0))) {
			return new BlockData(pos4.add(-1, 0, 0), EnumFacing.EAST);
		}
		if (this.isPosValid(pos4.add(1, 0, 0))) {
			return new BlockData(pos4.add(1, 0, 0), EnumFacing.WEST);
		}
		if (this.isPosValid(pos4.add(0, 0, 1))) {
			return new BlockData(pos4.add(0, 0, 1), EnumFacing.NORTH);
		}
		if (this.isPosValid(pos4.add(0, 0, -1))) {
			return new BlockData(pos4.add(0, 0, -1), EnumFacing.SOUTH);
		}
		pos.add(0, 0, -2);
		if (this.isPosValid(pos5.add(0, -1, 0))) {
			return new BlockData(pos5.add(0, -1, 0), EnumFacing.UP);
		}
		if (this.isPosValid(pos5.add(-1, 0, 0))) {
			return new BlockData(pos5.add(-1, 0, 0), EnumFacing.EAST);
		}
		if (this.isPosValid(pos5.add(1, 0, 0))) {
			return new BlockData(pos5.add(1, 0, 0), EnumFacing.WEST);
		}
		if (this.isPosValid(pos5.add(0, 0, 1))) {
			return new BlockData(pos5.add(0, 0, 1), EnumFacing.NORTH);
		}
		if (this.isPosValid(pos5.add(0, 0, -1))) {
			return new BlockData(pos5.add(0, 0, -1), EnumFacing.SOUTH);
		}
		final BlockPos pos6 = pos.add(0, -1, 0);
		if (this.isPosValid(pos6.add(0, -1, 0))) {
			return new BlockData(pos6.add(0, -1, 0), EnumFacing.UP);
		}
		if (this.isPosValid(pos6.add(-1, 0, 0))) {
			return new BlockData(pos6.add(-1, 0, 0), EnumFacing.EAST);
		}
		if (this.isPosValid(pos6.add(1, 0, 0))) {
			return new BlockData(pos6.add(1, 0, 0), EnumFacing.WEST);
		}
		if (this.isPosValid(pos6.add(0, 0, 1))) {
			return new BlockData(pos6.add(0, 0, 1), EnumFacing.NORTH);
		}
		if (this.isPosValid(pos6.add(0, 0, -1))) {
			return new BlockData(pos6.add(0, 0, -1), EnumFacing.SOUTH);
		}
		final BlockPos pos7 = pos6.add(1, 0, 0);
		if (this.isPosValid(pos7.add(0, -1, 0))) {
			return new BlockData(pos7.add(0, -1, 0), EnumFacing.UP);
		}
		if (this.isPosValid(pos7.add(-1, 0, 0))) {
			return new BlockData(pos7.add(-1, 0, 0), EnumFacing.EAST);
		}
		if (this.isPosValid(pos7.add(1, 0, 0))) {
			return new BlockData(pos7.add(1, 0, 0), EnumFacing.WEST);
		}
		if (this.isPosValid(pos7.add(0, 0, 1))) {
			return new BlockData(pos7.add(0, 0, 1), EnumFacing.NORTH);
		}
		if (this.isPosValid(pos7.add(0, 0, -1))) {
			return new BlockData(pos7.add(0, 0, -1), EnumFacing.SOUTH);
		}
		final BlockPos pos8 = pos6.add(-1, 0, 0);
		if (this.isPosValid(pos8.add(0, -1, 0))) {
			return new BlockData(pos8.add(0, -1, 0), EnumFacing.UP);
		}
		if (this.isPosValid(pos8.add(-1, 0, 0))) {
			return new BlockData(pos8.add(-1, 0, 0), EnumFacing.EAST);
		}
		if (this.isPosValid(pos8.add(1, 0, 0))) {
			return new BlockData(pos8.add(1, 0, 0), EnumFacing.WEST);
		}
		if (this.isPosValid(pos8.add(0, 0, 1))) {
			return new BlockData(pos8.add(0, 0, 1), EnumFacing.NORTH);
		}
		if (this.isPosValid(pos8.add(0, 0, -1))) {
			return new BlockData(pos8.add(0, 0, -1), EnumFacing.SOUTH);
		}
		final BlockPos pos9 = pos6.add(0, 0, 1);
		if (this.isPosValid(pos9.add(0, -1, 0))) {
			return new BlockData(pos9.add(0, -1, 0), EnumFacing.UP);
		}
		if (this.isPosValid(pos9.add(-1, 0, 0))) {
			return new BlockData(pos9.add(-1, 0, 0), EnumFacing.EAST);
		}
		if (this.isPosValid(pos9.add(1, 0, 0))) {
			return new BlockData(pos9.add(1, 0, 0), EnumFacing.WEST);
		}
		if (this.isPosValid(pos9.add(0, 0, 1))) {
			return new BlockData(pos9.add(0, 0, 1), EnumFacing.NORTH);
		}
		if (this.isPosValid(pos9.add(0, 0, -1))) {
			return new BlockData(pos9.add(0, 0, -1), EnumFacing.SOUTH);
		}
		final BlockPos pos10 = pos6.add(0, 0, -1);
		if (this.isPosValid(pos10.add(0, -1, 0))) {
			return new BlockData(pos10.add(0, -1, 0), EnumFacing.UP);
		}
		if (this.isPosValid(pos10.add(-1, 0, 0))) {
			return new BlockData(pos10.add(-1, 0, 0), EnumFacing.EAST);
		}
		if (this.isPosValid(pos10.add(1, 0, 0))) {
			return new BlockData(pos10.add(1, 0, 0), EnumFacing.WEST);
		}
		if (this.isPosValid(pos10.add(0, 0, 1))) {
			return new BlockData(pos10.add(0, 0, 1), EnumFacing.NORTH);
		}
		if (this.isPosValid(pos10.add(0, 0, -1))) {
			return new BlockData(pos10.add(0, 0, -1), EnumFacing.SOUTH);
		}
		return null;
	}

	private boolean isPosValid(BlockPos pos) {
		Block block = mc.theWorld.getBlockState(pos).getBlock();
		return (block.getMaterial().isSolid() || !block.isTranslucent() || block.isVisuallyOpaque()
				|| block instanceof BlockLadder || block instanceof BlockCarpet || block instanceof BlockSnow
				|| block instanceof BlockSkull) && !block.getMaterial().isLiquid()
				&& !(block instanceof BlockContainer);
	}

	public static double getRandomHypixelValues() {
		SecureRandom secureRandom = new SecureRandom();
		double value = secureRandom.nextDouble() * (1.0 / System.currentTimeMillis());
		for (int i = 0; i < MathUtil.getRandom(MathUtil.getRandom(4, 6), MathUtil.getRandom(8, 20)); i++)
			value *= (1.0 / System.currentTimeMillis());
		return value;
	}

	public static double[] yawPos(float yaw, double value) {
		return new double[] { -MathHelper.sin(yaw) * value, MathHelper.cos(yaw) * value };
	}

	private static class Rotation {
		float yaw;
		float pitch;

		public Rotation(final float yaw, final float pitch) {
			this.yaw = yaw;
			this.pitch = pitch;
		}

		public float getYaw() {
			return this.yaw;
		}

		public float getPitch() {
			return this.pitch;
		}

		public void toPlayer(final EntityPlayer player) {
			if (Float.isNaN(this.yaw) || Float.isNaN(this.pitch)) {
				return;
			}
			this.fixedSensitivity(Minecraft.getMinecraft().gameSettings.mouseSensitivity);
			player.rotationYaw = this.yaw;
			player.rotationPitch = this.pitch;
		}

		public void fixedSensitivity(final Float sensitivity) {
			final float f = sensitivity * 0.6f + 0.2f;
			final float gcd = f * f * f * 1.2f;
			this.yaw -= this.yaw % gcd;
			this.pitch -= this.pitch % gcd;
		}

		public void setYaw(final float f) {
			this.yaw = f;

		}

		public void setPitch(final float f) {
			this.pitch = f;

		}
	}

	private static class BlockData {
		private Vec3 vec;
		private final BlockPos pos;
		private final EnumFacing facing;

		public BlockData(BlockPos pos, EnumFacing facing) {
			this.pos = pos;
			this.facing = facing;
			this.vec = getHitVec();
		}

		private Vec3 getHitVec() {
			Vec3i directionVec = facing.getDirectionVec();
			double x = directionVec.getX() * 0.5D;
			double z = directionVec.getZ() * 0.5D;

			if (facing.getAxisDirection() == EnumFacing.AxisDirection.NEGATIVE) {
				x = -x;
				z = -z;
			}

			Vec3 hitVec = (new Vec3(this.pos)).addVector(x + z, directionVec.getY() * 0.5D, x + z);

			Vec3 src = Minecraft.getMinecraft().thePlayer.getPositionEyes(1.0F);
			MovingObjectPosition obj = Minecraft.getMinecraft().theWorld.rayTraceBlocks(src, hitVec, false, false,
					true);

			if (obj == null || obj.hitVec == null || obj.typeOfHit != MovingObjectPosition.MovingObjectType.BLOCK) {
				return null;
			}
			if (facing != EnumFacing.DOWN && facing != EnumFacing.UP) {
				obj.hitVec = obj.hitVec.addVector(0.0D, -0.2D, 0.0D);
			}
			return obj.hitVec;
		}

		public Vec3 getVec() {
			return vec;
		}

		public void setVec(Vec3 vec) {
			this.vec = vec;
		}

		public BlockPos getBlockPos() {
			return pos;
		}

		public EnumFacing getEnumFacing() {
			return facing;
		}
	}
}