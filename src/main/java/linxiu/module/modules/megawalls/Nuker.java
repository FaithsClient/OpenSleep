package linxiu.module.modules.megawalls;

import java.util.Objects;

import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender3D;
import linxiu.api.events.world.EventPacketSend;
import linxiu.api.events.world.EventPostUpdate;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.events.world.EventTick;
import linxiu.api.events.world.EventUpdate;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.injection.interfaces.INetworkManager;
import linxiu.injection.interfaces.IPlayerControllerMP;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.Helper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;

public class Nuker extends Module {

	public Nuker() {
		super("Nuker", new String[] { "Nuker" }, ModuleType.Movement);
	}

	private int posX, posY, posZ;
	public Numbers<Number> radius = new Numbers<Number>("Horizontal Radius", 3, 1, 50, 1);
	public Numbers<Number> height = new Numbers<Number>("Height Radius", 1, 1, 50, 1);
	public Option silent = new Option("Silent", true);
	private boolean isRunning;
	private final Timer timer = new Timer();
	private boolean destroy = false;
	private float progress = 0.0f;
	private BlockPos blockPos;
	private EnumFacing facing;

	@Override
	public void onDisable() {
		progress = 0.0f;
		destroy = false;
		blockPos = null;
		facing = null;
		isRunning = false;
		posX = posY = posZ = 0;
	}

	@EventHandler
	void onUpdate(EventUpdate event) {

		// 箱子判断
		IPlayerControllerMP controller = (IPlayerControllerMP) mc.playerController;
		if (mc.playerController.extendedReach()) {
			controller.setBlockHitDelay(0);
			if (controller.getCurBlockDamageMP() >= 0.3) {
				controller.setCurBlockDamageMP(1.0F);
			}
		} else if (destroy && mc.thePlayer
				.canHarvestBlock(mc.theWorld.getBlockState(mc.objectMouseOver.getBlockPos()).getBlock())) {
			Block block = mc.theWorld.getBlockState(blockPos).getBlock();
			progress += block.getPlayerRelativeBlockHardness(mc.thePlayer, mc.theWorld, blockPos) * 2.0;

			if (progress >= 1.0f) {
				mc.theWorld.setBlockState(blockPos, Blocks.air.getDefaultState(), 11);
				((INetworkManager) mc.thePlayer.sendQueue.getNetworkManager()).sendPacketNoEvent(
						new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos, facing));
				destroy = false;
			}
		}

	}

	@EventHandler
	void onPacket(EventPacketSend event) {
		// 箱子判断
		if (EventPacketSend.getPacket() instanceof C07PacketPlayerDigging && !mc.playerController.extendedReach()) {
			C07PacketPlayerDigging packet = (C07PacketPlayerDigging) EventPacketSend.getPacket();

			if (isRunning) {
				destroy = true;
				blockPos = packet.getPosition();
				facing = packet.getFacing();
				progress = 0.0f;
				Helper.getTimer().timerSpeed = 1.0f;
			} else if (!isRunning) {
				destroy = false;
				blockPos = null;
				facing = null;
				Helper.getTimer().timerSpeed = 1.0f;
			}
		}
	}

	@EventHandler
	public void onPre(EventPreUpdate e) {
		this.isRunning = false;
		int radius = this.radius.getValue().intValue();
		int height = this.height.getValue().intValue();
		for (int y = height; y >= -height; --y) {
			for (int x = -radius; x < radius; ++x) {
				for (int z = -radius; z < radius; ++z) {
					this.posX = (int) Math.floor(this.mc.thePlayer.posX) + x;
					this.posY = (int) Math.floor(this.mc.thePlayer.posY) + y;
					this.posZ = (int) Math.floor(this.mc.thePlayer.posZ) + z;
					if (this.mc.thePlayer.getDistanceSq(this.mc.thePlayer.posX + (double) x,
							this.mc.thePlayer.posY + (double) y, this.mc.thePlayer.posZ + (double) z) <= 16.0D) {
						Block block = getBlock(this.posX, this.posY, this.posZ);
						boolean blockChecks = timer.hasTimeElapsed(50L);
						Block selected = getBlock(mc.objectMouseOver.getBlockPos());

						blockChecks = blockChecks && canSeeBlock(this.posX + 0.5F, this.posY + 0.9f, this.posZ + 0.5F)
								&& !(block instanceof BlockAir);
						blockChecks = blockChecks && (block.getBlockHardness(this.mc.theWorld, BlockPos.ORIGIN) != -1.0F
								|| this.mc.playerController.isInCreativeMode());
						if (blockChecks) {
							this.isRunning = true;

							if (mc.objectMouseOver != null) {
								float strength = 1.0f;
								int bestToolSlot = -1;
								for (int i = 0; i < 9; ++i) {
									ItemStack itemStack = mc.thePlayer.inventory.getStackInSlot(i);
									if (itemStack == null || !(itemStack.getStrVsBlock(block) > strength))
										continue;
									strength = itemStack.getStrVsBlock(block);
									bestToolSlot = i;
								}
								if (bestToolSlot != -1) {
									mc.thePlayer.inventory.currentItem = bestToolSlot;
								}
							}
							float[] angles = faceBlock(this.posX + 0.5F, this.posY + 0.9, this.posZ + 0.5F);

							if (silent.getValue()) {
								e.setYaw(angles[0]);
								e.setPitch(angles[1]);

							} else {
								mc.thePlayer.rotationYaw = angles[0];
								mc.thePlayer.rotationPitch = angles[1];
							}
							return;
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onTick(EventTick e) {

	}

	@EventHandler
	public void onRender(EventRender3D e) {

	}

	@EventHandler
	public void onPost(EventPostUpdate e) {
		Block block = getBlock(this.posX, this.posY, this.posZ);
		if (this.isRunning) {
			this.mc.playerController.onPlayerDamageBlock(new BlockPos(this.posX, this.posY, this.posZ),
					getFacing(new BlockPos(this.posX, this.posY, this.posZ)));
			this.mc.thePlayer.swingItem();
			if ((double) this.mc.playerController.curBlockDamageMP >= 1.0D)
				timer.reset();
		}
	}

	public boolean canSeeBlock(float x, float y, float z) {
		return getFacing(new BlockPos(x, y, z)) != null;
	}

	public float[] faceBlock(final double posX, final double posY, final double posZ) {
		final double diffX = posX - mc.thePlayer.posX;
		final double diffZ = posZ - mc.thePlayer.posZ;
		final double diffY = posY - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
		final double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
		final float yaw = (float) (Math.atan2(diffZ, diffX) * 180.0 / 3.141592653589793) - 90.0f;
		final float pitch = (float) (-(Math.atan2(diffY, dist) * 180.0 / 3.141592653589793));
		float lyaw = mc.thePlayer.rotationYaw;
		float lpitch = mc.thePlayer.rotationPitch;
		return new float[] { lyaw += MathHelper.wrapAngleTo180_float(yaw - lyaw),
				lpitch += MathHelper.wrapAngleTo180_float(pitch - lpitch) };
	}

	public Block getBlock(final int x, final int y, final int z) {
		return mc.theWorld.getBlockState(new BlockPos(x, y, z)).getBlock();
	}

	public Block getBlock(BlockPos pos) {
		return mc.theWorld.getBlockState(pos).getBlock();
	}

	public EnumFacing getFacing(BlockPos pos) {
		EnumFacing[] orderedValues = new EnumFacing[] { EnumFacing.UP, EnumFacing.NORTH, EnumFacing.EAST,
				EnumFacing.SOUTH, EnumFacing.WEST, EnumFacing.DOWN };
		EnumFacing[] var2 = orderedValues;
		int var3 = orderedValues.length;
		for (int var4 = 0; var4 < var3; ++var4) {
			EnumFacing facing = var2[var4];
			EntitySnowball temp = new EntitySnowball(mc.theWorld);
			temp.posX = (double) pos.getX() + 0.5D;
			temp.posY = (double) pos.getY() + 0.5D;
			temp.posZ = (double) pos.getZ() + 0.5D;
			temp.posX += (double) facing.getDirectionVec().getX() * 0.5D;
			temp.posY += (double) facing.getDirectionVec().getY() * 0.5D;
			temp.posZ += (double) facing.getDirectionVec().getZ() * 0.5D;
			if (mc.thePlayer.canEntityBeSeen(temp)) {
				return facing;
			}
		}

		return null;
	}

	public final class Timer {
		private long time;

		public Timer() {
			this.time = System.nanoTime() / 1000000L;
		}

		public boolean hasTimeElapsed(final long time, final boolean reset) {
			if (this.time() >= time) {
				if (reset)
					this.reset();
				return true;
			}
			return false;
		}

		public boolean hasTimeElapsed(final long time) {
			return this.time() >= time;
		}

		public boolean hasTicksElapsed(int ticks) {
			return this.time() >= (1000 / ticks) - 50;
		}

		public boolean hasTicksElapsed(int time, int ticks) {
			return this.time() >= (time / ticks) - 50;
		}

		public long time() {
			return System.nanoTime() / 1000000L - this.time;
		}

		public void reset() {
			this.time = System.nanoTime() / 1000000L;
		}
	}
}