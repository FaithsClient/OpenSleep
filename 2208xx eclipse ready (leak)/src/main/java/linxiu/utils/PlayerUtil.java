/*
 * Decompiled with CFR 0.152.
 */
package linxiu.utils;

import io.netty.util.internal.ThreadLocalRandom;
import linxiu.api.events.world.EventMove;
import linxiu.ui.Rotation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

public class PlayerUtil {
	private static final Minecraft mc = Minecraft.getMinecraft();

	public static double getBaseMoveSpeed() {
		double baseSpeed = 0.2873;
		if (PlayerUtil.mc.thePlayer.isPotionActive(Potion.moveSpeed)) {
			int amplifier = PlayerUtil.mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier();
			baseSpeed *= 1.0 + 0.2 * (double) (amplifier + 1);
		}
		return baseSpeed;
	}

	public static int g() {
		int var2 = 0;
		if (var2 < 500) {
			if (!mc.theWorld.getCollidingBoundingBoxes(mc.thePlayer,
					mc.thePlayer.getEntityBoundingBox().offset(0.0, -var2, 0.0)).isEmpty()) {
				return (int) (Math.floor(mc.thePlayer.posY) - var2);
			}

			++var2;
		}
		return -1;
	}

	public static boolean isBlockUnder() {
		if (PlayerUtil.mc.thePlayer.posY < 0.0) {
			return false;
		}
		int off = 0;
		while (off < (int) PlayerUtil.mc.thePlayer.posY + 2) {
			AxisAlignedBB bb = PlayerUtil.mc.thePlayer.getEntityBoundingBox().offset(0.0, -off, 0.0);
			if (!PlayerUtil.mc.theWorld.getCollidingBoundingBoxes(PlayerUtil.mc.thePlayer, bb).isEmpty()) {
				return true;
			}
			off += 2;
		}
		return false;
	}

	public static boolean isBlockUnder(Entity ent) {
		if (ent.posY < 0.0) {
			return false;
		}
		int off = 0;
		while (off < (int) ent.posY + 2) {
			AxisAlignedBB bb = ent.getEntityBoundingBox().offset(0.0, -off, 0.0);
			if (!PlayerUtil.mc.theWorld.getCollidingBoundingBoxes(ent, bb).isEmpty()) {
				return true;
			}
			off += 2;
		}
		return false;
	}

	public static boolean isAirUnder(Entity ent) {
		return PlayerUtil.mc.theWorld.getBlockState(new BlockPos(ent.posX, ent.posY - 1.0, ent.posZ))
				.getBlock() == Blocks.air;
	}

	public static void TeleportByDist(double dist) {
		double forward = PlayerUtil.mc.thePlayer.movementInput.moveForward;
		double strafe = PlayerUtil.mc.thePlayer.movementInput.moveStrafe;
		float yaw = PlayerUtil.mc.thePlayer.rotationYaw;
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
		double cos = Math.cos(Math.toRadians(yaw + 90.0f));
		double sin = Math.sin(Math.toRadians(yaw + 90.0f));
		double x = forward * dist * cos + strafe * dist * sin;
		double z = forward * dist * sin - strafe * dist * cos;
		PlayerUtil.mc.thePlayer.setPosition(PlayerUtil.mc.thePlayer.posX + x, PlayerUtil.mc.thePlayer.posY,
				PlayerUtil.mc.thePlayer.posZ + z);
	}

	public static void doStrafe() {
		if (!PlayerUtil.MovementInput()) {
			return;
		}
		float rotationYaw = PlayerUtil.mc.thePlayer.rotationYaw;
		if (PlayerUtil.mc.thePlayer.moveForward < 0.0f) {
			rotationYaw += 180.0f;
		}
		float forward = 1.0f;
		if (PlayerUtil.mc.thePlayer.moveForward < 0.0f) {
			forward = -0.5f;
		} else if (PlayerUtil.mc.thePlayer.moveForward > 0.0f) {
			forward = 0.5f;
		}
		if (PlayerUtil.mc.thePlayer.moveStrafing > 0.0f) {
			rotationYaw -= 90.0f * forward;
		}
		if (PlayerUtil.mc.thePlayer.moveStrafing < 0.0f) {
			rotationYaw += 90.0f * forward;
		}
		double direction = Math.toRadians(rotationYaw);
		float speed = (float) Math.sqrt(PlayerUtil.mc.thePlayer.motionX * PlayerUtil.mc.thePlayer.motionX
				+ PlayerUtil.mc.thePlayer.motionZ * PlayerUtil.mc.thePlayer.motionZ);
		PlayerUtil.mc.thePlayer.motionX = -Math.sin(direction) * (double) speed;
		PlayerUtil.mc.thePlayer.motionZ = Math.cos(direction) * (double) speed;
	}

	public static void doStrafe(double speedA) {
		if (!PlayerUtil.MovementInput()) {
			return;
		}
		float rotationYaw = PlayerUtil.mc.thePlayer.rotationYaw;
		if (PlayerUtil.mc.thePlayer.moveForward < 0.0f) {
			rotationYaw += 180.0f;
		}
		float forward = 1.0f;
		if (PlayerUtil.mc.thePlayer.moveForward < 0.0f) {
			forward = -0.5f;
		} else if (PlayerUtil.mc.thePlayer.moveForward > 0.0f) {
			forward = 0.5f;
		}
		if (PlayerUtil.mc.thePlayer.moveStrafing > 0.0f) {
			rotationYaw -= 90.0f * forward;
		}
		if (PlayerUtil.mc.thePlayer.moveStrafing < 0.0f) {
			rotationYaw += 90.0f * forward;
		}
		double direction = Math.toRadians(rotationYaw);
		float speed = (float) Math.sqrt(PlayerUtil.mc.thePlayer.motionX * PlayerUtil.mc.thePlayer.motionX
				+ PlayerUtil.mc.thePlayer.motionZ * PlayerUtil.mc.thePlayer.motionZ);
		PlayerUtil.mc.thePlayer.motionX = -Math.sin(direction) * speedA;
		PlayerUtil.mc.thePlayer.motionZ = Math.cos(direction) * speedA;
	}

	public static boolean MovementInput() {
		return PlayerUtil.mc.gameSettings.keyBindForward.isKeyDown()
				|| PlayerUtil.mc.gameSettings.keyBindLeft.isKeyDown()
				|| PlayerUtil.mc.gameSettings.keyBindRight.isKeyDown()
				|| PlayerUtil.mc.gameSettings.keyBindBack.isKeyDown();
	}

	public static boolean isOnGround(double height) {
		return !PlayerUtil.mc.theWorld.getCollidingBoundingBoxes(PlayerUtil.mc.thePlayer,
				PlayerUtil.mc.thePlayer.getEntityBoundingBox().offset(0.0, -height, 0.0)).isEmpty();
	}

	public static boolean isOnGround(double height, Entity e) {
		return !PlayerUtil.mc.theWorld.getCollidingBoundingBoxes(e, e.getEntityBoundingBox().offset(0.0, -height, 0.0))
				.isEmpty();
	}

	public static int getJumpEffect() {
		return PlayerUtil.mc.thePlayer.isPotionActive(Potion.jump)
				? PlayerUtil.mc.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier() + 1
				: 0;
	}

	public static int getSpeedEffect() {
		return PlayerUtil.mc.thePlayer.isPotionActive(Potion.moveSpeed)
				? PlayerUtil.mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1
				: 0;
	}

	public static boolean isHoldingFood(Item item) {
		return !(item instanceof ItemSword) && !(item instanceof ItemBow);
	}

	public static boolean InsideBlock() {
		int x = MathHelper.floor_double(PlayerUtil.mc.thePlayer.getEntityBoundingBox().minX);
		while (x < MathHelper.floor_double(PlayerUtil.mc.thePlayer.getEntityBoundingBox().maxX) + 1) {
			int y = MathHelper.floor_double(PlayerUtil.mc.thePlayer.getEntityBoundingBox().minY);
			while (y < MathHelper.floor_double(PlayerUtil.mc.thePlayer.getEntityBoundingBox().maxY) + 1) {
				int z = MathHelper.floor_double(PlayerUtil.mc.thePlayer.getEntityBoundingBox().minZ);
				while (z < MathHelper.floor_double(PlayerUtil.mc.thePlayer.getEntityBoundingBox().maxZ) + 1) {
					Block block = PlayerUtil.mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock();
					if (block != null && !(block instanceof BlockAir)) {
						AxisAlignedBB boundingBox = block.getCollisionBoundingBox(PlayerUtil.mc.theWorld,
								new BlockPos(x, y, z), PlayerUtil.mc.theWorld.getBlockState(new BlockPos(x, y, z)));
						if (block instanceof BlockHopper) {
							boundingBox = new AxisAlignedBB(x, y, z, x + 1, y + 1, z + 1);
						}
						if (boundingBox != null
								&& PlayerUtil.mc.thePlayer.getEntityBoundingBox().intersectsWith(boundingBox)) {
							return true;
						}
					}
					++z;
				}
				++y;
			}
			++x;
		}
		return false;
	}

	public static boolean InsideBlock(EntityPlayer player) {
		int x = MathHelper.floor_double(player.getEntityBoundingBox().minX);
		while (x < MathHelper.floor_double(player.getEntityBoundingBox().maxX) + 1) {
			int y = MathHelper.floor_double(player.getEntityBoundingBox().minY);
			while (y < MathHelper.floor_double(player.getEntityBoundingBox().maxY) + 1) {
				int z = MathHelper.floor_double(player.getEntityBoundingBox().minZ);
				while (z < MathHelper.floor_double(player.getEntityBoundingBox().maxZ) + 1) {
					Block block = PlayerUtil.mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock();
					if (block != null && !(block instanceof BlockAir)) {
						AxisAlignedBB boundingBox = block.getCollisionBoundingBox(PlayerUtil.mc.theWorld,
								new BlockPos(x, y, z), PlayerUtil.mc.theWorld.getBlockState(new BlockPos(x, y, z)));
						if (block instanceof BlockHopper) {
							boundingBox = new AxisAlignedBB(x, y, z, x + 1, y + 1, z + 1);
						}
						if (boundingBox != null && player.getEntityBoundingBox().intersectsWith(boundingBox)) {
							return true;
						}
					}
					++z;
				}
				++y;
			}
			++x;
		}
		return false;
	}

	public static boolean isInLiquid() {
		if (PlayerUtil.mc.thePlayer.isInWater()) {
			return true;
		}
		boolean inLiquid = false;
		int y = (int) PlayerUtil.mc.thePlayer.getEntityBoundingBox().minY;
		int x = MathHelper.floor_double(PlayerUtil.mc.thePlayer.getEntityBoundingBox().minX);
		while (x < MathHelper.floor_double(PlayerUtil.mc.thePlayer.getEntityBoundingBox().maxX) + 1) {
			int z = MathHelper.floor_double(PlayerUtil.mc.thePlayer.getEntityBoundingBox().minZ);
			while (z < MathHelper.floor_double(PlayerUtil.mc.thePlayer.getEntityBoundingBox().maxZ) + 1) {
				Block block = PlayerUtil.mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock();
				if (block != null && block.getMaterial() != Material.air) {
					if (!(block instanceof BlockLiquid)) {
						return false;
					}
					inLiquid = true;
				}
				++z;
			}
			++x;
		}
		return inLiquid;
	}

	public static boolean isOnLiquid() {
		AxisAlignedBB boundingBox = PlayerUtil.mc.thePlayer.getEntityBoundingBox();
		if (boundingBox == null) {
			return false;
		}
		boundingBox = boundingBox.contract(0.01, 0.0, 0.01).offset(0.0, -0.01, 0.0);
		boolean onLiquid = false;
		int y = (int) boundingBox.minY;
		int x = MathHelper.floor_double(boundingBox.minX);
		while (x < MathHelper.floor_double(boundingBox.maxX + 1.0)) {
			int z = MathHelper.floor_double(boundingBox.minZ);
			while (z < MathHelper.floor_double(boundingBox.maxZ + 1.0)) {
				Block block = PlayerUtil.mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock();
				if (block != Blocks.air) {
					if (!(block instanceof BlockLiquid)) {
						return false;
					}
					onLiquid = true;
				}
				++z;
			}
			++x;
		}
		return onLiquid;
	}

	public static boolean isOnLiquid(double profondeur) {
		boolean onLiquid = PlayerUtil.mc.theWorld.getBlockState(new BlockPos(PlayerUtil.mc.thePlayer.posX,
				PlayerUtil.mc.thePlayer.posY - profondeur, PlayerUtil.mc.thePlayer.posZ)).getBlock().getMaterial()
				.isLiquid();
		return onLiquid;
	}

	public static boolean isTotalOnLiquid(double profondeur) {
		double x = PlayerUtil.mc.thePlayer.getEntityBoundingBox().minX;
		while (x < PlayerUtil.mc.thePlayer.getEntityBoundingBox().maxX) {
			double z = PlayerUtil.mc.thePlayer.getEntityBoundingBox().minZ;
			while (z < PlayerUtil.mc.thePlayer.getEntityBoundingBox().maxZ) {
				Block block = PlayerUtil.mc.theWorld
						.getBlockState(new BlockPos(x, PlayerUtil.mc.thePlayer.posY - profondeur, z)).getBlock();
				if (!(block instanceof BlockLiquid) && !(block instanceof BlockAir)) {
					return false;
				}
				z += 0.01f;
			}
			x += 0.01f;
		}
		return true;
	}

	public static void setSpeed(EventMove event, double speed) {
		float yaw = PlayerUtil.mc.thePlayer.rotationYaw;
		double forward = PlayerUtil.mc.thePlayer.movementInput.moveForward;
		double strafe = PlayerUtil.mc.thePlayer.movementInput.moveStrafe;
		if (forward == 0.0 && strafe == 0.0) {
			event.setX(0.0);
			event.setZ(0.0);
		} else {
			if (forward != 0.0) {
				if (strafe > 0.0) {
					yaw += (float) (forward > 0.0 ? -45 : 45);
				} else if (strafe < 0.0) {
					yaw += (float) (forward > 0.0 ? 45 : -45);
				}
				strafe = 0.0;
				forward = forward > 0.0 ? 1.0 : -1.0;
			}
			event.setX(forward * speed * Math.cos(Math.toRadians((double) yaw + 87.88867))
					+ strafe * speed * Math.sin(Math.toRadians((double) yaw + 87.88867)));
			event.setZ(forward * speed * Math.sin(Math.toRadians((double) yaw + 87.88867))
					- strafe * speed * Math.cos(Math.toRadians((double) yaw + 87.88867)));
		}
	}

	public static void setSpeed(double speed) {
		float yaw = PlayerUtil.mc.thePlayer.rotationYaw;
		double forward = PlayerUtil.mc.thePlayer.movementInput.moveForward;
		double strafe = PlayerUtil.mc.thePlayer.movementInput.moveStrafe;
		if (forward == 0.0 && strafe == 0.0) {
			PlayerUtil.mc.thePlayer.motionX = 0.0;
			PlayerUtil.mc.thePlayer.motionZ = 0.0;
		} else {
			if (forward != 0.0) {
				if (strafe > 0.0) {
					yaw += (float) (forward > 0.0 ? -45 : 45);
				} else if (strafe < 0.0) {
					yaw += (float) (forward > 0.0 ? 45 : -45);
				}
				strafe = 0.0;
				forward = forward > 0.0 ? 1.0 : -1.0;
			}
			PlayerUtil.mc.thePlayer.motionX = forward * speed * Math.cos(Math.toRadians(yaw + 90.0f))
					+ strafe * speed * Math.sin(Math.toRadians(yaw + 90.0f));
			PlayerUtil.mc.thePlayer.motionZ = forward * speed * Math.sin(Math.toRadians(yaw + 90.0f))
					- strafe * speed * Math.cos(Math.toRadians(yaw + 90.0f));
		}
	}

	public static double getLastDist() {
		double xDist = PlayerUtil.mc.thePlayer.posX - PlayerUtil.mc.thePlayer.prevPosX;
		double zDist = PlayerUtil.mc.thePlayer.posZ - PlayerUtil.mc.thePlayer.prevPosZ;
		return Math.sqrt(xDist * xDist + zDist * zDist);
	}

	public static double getLastDist(Entity entIn) {
		double xDist = entIn.posX - entIn.prevPosX;
		double zDist = entIn.posZ - entIn.prevPosZ;
		return Math.sqrt(xDist * xDist + zDist * zDist);
	}

	public static double getBPS() {
		double bps = PlayerUtil.getLastDist() * 20.0;
		return ((double) ((int) bps) + bps - (double) ((int) bps)) * (double) Helper.getTimer().timerSpeed;
	}

	public static double getBPS(Entity entityIn) {
		double bps = PlayerUtil.getLastDist(entityIn) * 20.0;
		return (double) ((int) bps) + bps - (double) ((int) bps);
	}

	public static Rotation attemptFacePosition(double x, double y, double z) {
		double xDiff = x - mc.thePlayer.posX;
		double yDiff = y - mc.thePlayer.posY - 1.2;
		double zDiff = z - mc.thePlayer.posZ;

		double dist = Math.hypot(xDiff, zDiff);
		float yaw = (float) (Math.atan2(zDiff, xDiff) * 180 / Math.PI) - 90;
		float pitch = (float) -(Math.atan2(yDiff, dist) * 180 / Math.PI);
		return new Rotation(yaw, pitch);
	}

	public static Rotation getRotationsRandom(EntityLivingBase entity) {

		ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
		double randomXZ = threadLocalRandom.nextDouble(-0.05, 0.1);
		double randomY = threadLocalRandom.nextDouble(-0.05, 0.1);
		double x = entity.posX + randomXZ;
		double y = entity.posY + (entity.getEyeHeight() / 2.05) + randomY;
		double z = entity.posZ + randomXZ;
		return attemptFacePosition(x, y, z);
	}

	public static float getBaseMoveSpeedFloat() {
		float baseSpeed = 0.2873F;
		if (Minecraft.getMinecraft().thePlayer.isPotionActive(Potion.moveSpeed)) {
			int amplifier = Minecraft.getMinecraft().thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier();
			baseSpeed *= 1.0F + (0.2F * (float) (amplifier + 1));
		}

		return baseSpeed;
	}

	public static double getDirection() {
		float rotationYaw = mc.thePlayer.rotationYaw;

		if (mc.thePlayer.moveForward < 0F)
			rotationYaw += 180F;

		float forward = 1F;
		if (mc.thePlayer.moveForward < 0F)
			forward = -0.5F;
		else if (mc.thePlayer.moveForward > 0F)
			forward = 0.5F;

		if (mc.thePlayer.moveStrafing > 0F)
			rotationYaw -= 90F * forward;

		if (mc.thePlayer.moveStrafing < 0F)
			rotationYaw += 90F * forward;
		return Math.toRadians(rotationYaw);
	}

	public static Block getBlock(final double offsetX, final double offsetY, final double offsetZ) {
		return mc.theWorld.getBlockState(new BlockPos(offsetX, offsetY, offsetZ)).getBlock();
	}

	public static void blinkToPos(double[] startPos, BlockPos endPos, double slack, double[] pOffset) {
		double curX = startPos[0];
		double curY = startPos[1];
		double curZ = startPos[2];

		try {
			double endX = (double) endPos.getX() + 0.5D;
			double endY = (double) endPos.getY() + 1.0D;
			double endZ = (double) endPos.getZ() + 0.5D;
			double distance = Math.abs(curX - endX) + Math.abs(curY - endY) + Math.abs(curZ - endZ);

			for (int count = 0; distance > slack; ++count) {
				distance = Math.abs(curX - endX) + Math.abs(curY - endY) + Math.abs(curZ - endZ);
				if (count > 120) {
					break;
				}

				boolean next = false;
				double diffX = curX - endX;
				double diffY = curY - endY;
				double diffZ = curZ - endZ;
				double offset = (count & 1) == 0 ? pOffset[0] : pOffset[1];
				if (diffX < 0.0D) {
					if (Math.abs(diffX) > offset) {
						curX += offset;
					} else {
						curX += Math.abs(diffX);
					}
				}

				if (diffX > 0.0D) {
					if (Math.abs(diffX) > offset) {
						curX -= offset;
					} else {
						curX -= Math.abs(diffX);
					}
				}

				if (diffY < 0.0D) {
					if (Math.abs(diffY) > 0.25D) {
						curY += 0.25D;
					} else {
						curY += Math.abs(diffY);
					}
				}

				if (diffY > 0.0D) {
					if (Math.abs(diffY) > 0.25D) {
						curY -= 0.25D;
					} else {
						curY -= Math.abs(diffY);
					}
				}

				if (diffZ < 0.0D) {
					if (Math.abs(diffZ) > offset) {
						curZ += offset;
					} else {
						curZ += Math.abs(diffZ);
					}
				}

				if (diffZ > 0.0D) {
					if (Math.abs(diffZ) > offset) {
						curZ -= offset;
					} else {
						curZ -= Math.abs(diffZ);
					}
				}

				Minecraft.getMinecraft().getNetHandler()
						.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(curX, curY, curZ, true));
			}
		} catch (Exception var29) {
		}

	}

	public static int findHead() {
		for (int i = 36; i < 45; i++) {
			final ItemStack itemStack = mc.thePlayer.inventoryContainer.getSlot(i).getStack();

			if (itemStack != null && itemStack.getDisplayName().contains("Head") && itemStack.stackSize > 0) {
				return i;
			}
		}

		return -1;
	}

	public static Block getBlockRelativeToPlayer(final double offsetX, final double offsetY, final double offsetZ) {
		return mc.theWorld.getBlockState(
				new BlockPos(mc.thePlayer.posX + offsetX, mc.thePlayer.posY + offsetY, mc.thePlayer.posZ + offsetZ))
				.getBlock();
	}
}
