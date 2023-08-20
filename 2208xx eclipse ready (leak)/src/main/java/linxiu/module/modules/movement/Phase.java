/*
 * Decompiled with CFR 0_132.
 */
package linxiu.module.modules.movement;

import linxiu.api.EventHandler;
import linxiu.api.events.misc.EventCollideWithBlock;
import linxiu.api.events.world.EventMove;
import linxiu.api.events.world.EventPostUpdate;
import linxiu.api.value.Option;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.MovementUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

import java.awt.*;
import static java.lang.StrictMath.toRadians;

public class Phase extends Module {
	public static Option soulsandValue = new Option("New", true);

	public Phase() {
		super("Phase", new String[] { "Phase" }, ModuleType.Movement);
		this.setColor(new Color(216, 253, 100).getRGB());
	}

	public boolean isInsideBlock() {
		final EntityPlayerSP player = mc.thePlayer;
		final WorldClient world = mc.theWorld;
		final AxisAlignedBB bb = player.getEntityBoundingBox();
		for (int x = MathHelper.floor_double(bb.minX); x < MathHelper.floor_double(bb.maxX) + 1; ++x) {
			for (int y = MathHelper.floor_double(bb.minY); y < MathHelper.floor_double(bb.maxY) + 1; ++y) {
				for (int z = MathHelper.floor_double(bb.minZ); z < MathHelper.floor_double(bb.maxZ) + 1; ++z) {
					final Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
					final AxisAlignedBB boundingBox;
					if (block != null && !(block instanceof BlockAir)
							&& (boundingBox = block.getCollisionBoundingBox(world, new BlockPos(x, y, z),
									world.getBlockState(new BlockPos(x, y, z)))) != null
							&& player.getEntityBoundingBox().intersectsWith(boundingBox)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public void onDisable() {
		if (mc.thePlayer != null)
			mc.thePlayer.stepHeight = 0.6f;

	}
	
	@EventHandler
	public void move(EventCollideWithBlock event) {
		if (isInsideBlock())
			event.setBoundingBox(null);
	}

	@EventHandler
	public void move(EventMove event) {
		if (isInsideBlock()) {
			if (mc.gameSettings.keyBindJump.isKeyDown()) {
				event.setY(mc.thePlayer.motionY += 0.09f);
			} else if (mc.gameSettings.keyBindSneak.isKeyDown()) {
				event.setY(mc.thePlayer.motionY -= 0.09f);
			} else {
				event.setY(mc.thePlayer.motionY = 0.0f);
			}
			MovementUtils.setSpeed(event, MovementUtils.getBaseMoveSpeed());
		}
	}

	@EventHandler
	public void move(EventPostUpdate e) {
		if (mc.thePlayer.stepHeight > 0)
			mc.thePlayer.stepHeight = 0;

		float moveStrafe = mc.thePlayer.movementInput.moveStrafe, // @off
				moveForward = mc.thePlayer.movementInput.moveForward, rotationYaw = mc.thePlayer.rotationYaw;

		double multiplier = 0.3, mx = -MathHelper.sin((float) toRadians(rotationYaw)),
				mz = MathHelper.cos((float) toRadians(rotationYaw)),
				x = moveForward * multiplier * mx + moveStrafe * multiplier * mz,
				z = moveForward * multiplier * mz - moveStrafe * multiplier * mx; // @on

		if (mc.thePlayer.isCollidedHorizontally && !mc.thePlayer.isOnLadder() && mc.thePlayer.onGround) {
			double posX = mc.thePlayer.posX, posY = mc.thePlayer.posY, posZ = mc.thePlayer.posZ;
			mc.getNetHandler().getNetworkManager()
					.sendPacket(new C03PacketPlayer.C04PacketPlayerPosition(posX + x, posY, posZ + z, true));
			mc.getNetHandler().getNetworkManager()
					.sendPacket(new C03PacketPlayer.C04PacketPlayerPosition(posX, posY + 3, posZ, true));
			mc.thePlayer.setPosition(posX + x, posY, posZ + z);
		}
	}
}
