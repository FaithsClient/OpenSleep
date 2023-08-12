package linxiu.module.modules.megawalls;

import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender3D;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.events.world.EventTick;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.PlayerUtils;
import linxiu.utils.render.RenderUtils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.awt.*;

public class TunnelMiner extends Module {
    public static final ResourceLocation notifySound = new ResourceLocation("note.harp");
    private static boolean enable = false, rotated = false;
	private static int currentDamage, tool = -1;
	private static BlockPos blockToMine;
	private static BlockPos lastBlock;
	private static EnumFacing dir;
	private static final Minecraft mc = Minecraft.getMinecraft();

	public TunnelMiner() {
		super("TunnelMiner", new String[] { "TunnelMiner" }, ModuleType.Player);
	}

	@Override
	public void onEnable() {
		super.onEnable();
		onToggle(true);
		dir = mc.thePlayer.getHorizontalFacing();
	}

	private void onToggle(boolean enabled) {
		enable = enabled;
	}

	@Override
	public void onDisable() {
		super.onDisable();
		 rotated = false;
		currentDamage = 0;
		blockToMine = null;
		lastBlock = null;
		onToggle(false);
		KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
		KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false);
	}

	@EventHandler
	public void renderWorld(EventRender3D event) {
		if (!enable)
			return;
		if (blockToMine != null) {
			RenderUtils.drawBlockBox(blockToMine, new Color(255, 255, 255), 1, event.getPartialTicks());
		}
	}

	
	@EventHandler
	public void onMovePre(EventPreUpdate event) {
        if(mc.theWorld == null) return;
        if(mc.thePlayer == null) return;
        if (!enable) return;
        blockToMine = shouldMine();
        if (blockToMine != null) {
            IBlockState blockState = mc.theWorld.getBlockState(blockToMine);
            if (blockState.getBlock().equals(Blocks.bedrock)) {
            	PlayerUtils.tellPlayer("Reached bedrock.");
                toggle();
                mc.getSoundHandler().playSound(new PositionedSoundRecord(notifySound, 1000, 1.0F, 0, 0, 0));
                mc.getSoundHandler().playDelayedSound(new PositionedSoundRecord(notifySound, 1000, 1.0F, 0, 0, 0), 4);
                mc.getSoundHandler().playDelayedSound(new PositionedSoundRecord(notifySound, 1000, 1.0F, 0, 0, 0), 8);
                mc.getSoundHandler().playDelayedSound(new PositionedSoundRecord(notifySound, 1000, 1.0F, 0, 0, 0), 12);
                return;
            }
            tool = getBestItem(blockToMine);
            double diffX = blockToMine.getX() - mc.thePlayer.posX + 0.5;
            double diffY = blockToMine.getY() - mc.thePlayer.posY + 0.5 - mc.thePlayer.getEyeHeight();
            double diffZ = blockToMine.getZ() - mc.thePlayer.posZ + 0.5;
            double dist = Math.sqrt(diffX * diffX + diffY * diffY + diffZ * diffZ);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), true); //todo: to remove
            if (dist <= 2d) KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false); //todo: to remove
            else KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true); //todo: to remove
            float pitch = (float) -Math.atan2(dist, diffY);
            float yaw = (float) Math.atan2(diffZ, diffX);
            pitch = (float) wrapAngleTo180((pitch * 180F / (float) Math.PI + 90) * -1);
            mc.thePlayer.rotationPitch = pitch;
        } else {
            mc.thePlayer.rotationPitch = wrapAngleTo180(0);
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true); //todo: to remove
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(), false); //todo: to remove
        }
        float yaw;
        switch (dir) {
            case NORTH:
                yaw = 180;
                break;
            case EAST:
                yaw = -90;
                break;
            case SOUTH:
                yaw = 0;
                break;
            case WEST:
                yaw = 90;
                break;
            default:
                yaw = -1;
        }
        if (rotated) {
            if (Math.abs(mc.thePlayer.rotationYaw - yaw) > 1e-2 && Math.abs(mc.thePlayer.rotationYaw - yaw) < 360 - 1e-2) {
            	PlayerUtils.tellPlayer("It seems like you moved your mouse.");
                toggle();
            }
        } else {
            mc.thePlayer.rotationYaw = (float) wrapAngleTo180(yaw); //todo: to remove
            rotated = true;
        }
    }
	
	@EventHandler
	public void onTick(EventTick event) {
		if (enable) {
			if (blockToMine != null && mc.thePlayer != null) {
				if (lastBlock == null || !lastBlock.equals(blockToMine))
					currentDamage = 0;
				lastBlock = blockToMine;
				MovingObjectPosition fake = mc.objectMouseOver;
				fake.hitVec = new Vec3(blockToMine);
				EnumFacing enumFacing = fake.sideHit;
				if (tool != -1 && mc.thePlayer.inventory.currentItem != tool) {
					mc.thePlayer.inventory.currentItem = tool;
					mc.thePlayer.sendQueue.addToSendQueue(new C09PacketHeldItemChange(tool));
				}
				this.mc.thePlayer.swingItem();
				this.mc.playerController.onPlayerDamageBlock(blockToMine, enumFacing);
			}
		}
	}

	private static float wrapAngleTo180(float angle) {
		return (float) (angle - Math.floor(angle / 360 + 0.5) * 360);
	}

	public static void swingItem() {
		if (mc.objectMouseOver != null && mc.objectMouseOver.entityHit == null)
			mc.thePlayer.swingItem();
	}

	private BlockPos shouldMine() {
		if (mc.theWorld == null)
			return null;
		if (mc.thePlayer == null)
			return null;
		BlockPos closePos;
		BlockPos farPos;
		switch (dir) {
		case NORTH:
			closePos = new BlockPos(Math.floor(mc.thePlayer.posX), Math.floor(mc.thePlayer.posY),
					Math.floor(mc.thePlayer.posZ));
			farPos = new BlockPos(Math.floor(mc.thePlayer.posX), Math.floor(mc.thePlayer.posY + 1),
					Math.floor(mc.thePlayer.posZ - 4.5d));
			break;
		case EAST:
			closePos = new BlockPos(Math.floor(mc.thePlayer.posX), Math.floor(mc.thePlayer.posY),
					Math.floor(mc.thePlayer.posZ));
			farPos = new BlockPos(Math.floor(mc.thePlayer.posX + 4.5d), Math.floor(mc.thePlayer.posY + 1),
					Math.floor(mc.thePlayer.posZ));
			break;
		case SOUTH:
			closePos = new BlockPos(Math.floor(mc.thePlayer.posX), Math.floor(mc.thePlayer.posY),
					Math.floor(mc.thePlayer.posZ));
			farPos = new BlockPos(Math.floor(mc.thePlayer.posX), Math.floor(mc.thePlayer.posY + 1),
					Math.floor(mc.thePlayer.posZ + 4.5d));
			break;
		case WEST:
			closePos = new BlockPos(Math.floor(mc.thePlayer.posX), Math.floor(mc.thePlayer.posY),
					Math.floor(mc.thePlayer.posZ));
			farPos = new BlockPos(Math.floor(mc.thePlayer.posX - 4.5d), Math.floor(mc.thePlayer.posY + 1),
					Math.floor(mc.thePlayer.posZ));
			break;
		default:
			closePos = new BlockPos(Math.floor(mc.thePlayer.posX), Math.floor(mc.thePlayer.posY),
					Math.floor(mc.thePlayer.posZ));
			farPos = closePos;
		}
		double smallest = 9999;
		BlockPos closest = null;
		for (BlockPos blockPos : BlockPos.getAllInBox(closePos, farPos)) {
			IBlockState blockState = mc.theWorld.getBlockState(blockPos);
			if (blockState.getBlock().equals(Blocks.air) || blockState.getBlock().equals(Blocks.water)
					|| blockState.getBlock().equals(Blocks.flowing_water) || blockState.getBlock().equals(Blocks.lava)
					|| blockState.getBlock().equals(Blocks.flowing_lava))
				continue;

			double dist = new Vec3(blockPos.getX() + 0.5, blockPos.getY(), blockPos.getZ() + 0.5)
					.distanceTo(new Vec3(mc.thePlayer.getPositionVector().xCoord,
							mc.thePlayer.getPositionVector().yCoord + 1d, mc.thePlayer.getPositionVector().zCoord));
			if (dist < smallest) {
				smallest = dist;
				closest = blockPos;
			}
		}
		return closest;
	}

	private int getBestItem(final BlockPos blockPos) {
		float bestSpeed = 1F;
		int bestSlot = -1;

		final IBlockState blockState = mc.theWorld.getBlockState(blockPos);

		for (int i = 0; i < 9; i++) {
			final ItemStack item = mc.thePlayer.inventory.getStackInSlot(i);
			if (item == null)
				continue;

			final float speed = item.getStrVsBlock(blockState.getBlock());

			if (speed > bestSpeed) {
				bestSpeed = speed;
				bestSlot = i;
			}
		}

		return bestSlot;
	}
}
