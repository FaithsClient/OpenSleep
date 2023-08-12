package linxiu.module.modules.combat;

import java.util.Objects;

import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.world.EventPacketSend;
import linxiu.api.events.world.EventTick;
import linxiu.api.events.world.EventUpdate;
import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.injection.interfaces.INetworkManager;
import linxiu.injection.interfaces.IPlayerControllerMP;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.megawalls.Nuker;
import linxiu.utils.Helper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class SpeedMine extends Module {
	private final Mode modeValue = new Mode("Mode", new String[] { "Legit", "Packet" }, "Packet");
	public Numbers<Number> Speed = new Numbers<Number>("SpeedMine", 1.4, 0.0, 3.0, 0.1);
	public Numbers<Number> damage = new Numbers<Number>("Damage", 0.8, 0.1, 1.0, 0.05);

	private enum modeEnums {
		Legit, Packet
	}

	private boolean destroy = false;
	private float progress = 0.0f;
	private BlockPos blockPos;
	private EnumFacing facing;

	public SpeedMine() {
		super("SpeedMine", new String[] { "SpeedMine", "fastmine" }, ModuleType.Combat);
	}

	@Override
	public void onDisable() {
		progress = 0.0f;
		destroy = false;
		blockPos = null;
		facing = null;
	}

	private boolean blockChecks(Block block) {
		return block == Blocks.chest;
	}

	@EventHandler
	void onUpdate(EventTick event) {
		if (Client.getModuleManager().getModuleByClass(Nuker.class).isEnabled())
			return;
		if (Objects.equals(modeValue.getValue(), "Legit")) {
			IPlayerControllerMP controller = (IPlayerControllerMP) mc.playerController;
			controller.setBlockHitDelay(0);
			if (controller.getCurBlockDamageMP() >= damage.getValue().floatValue()) {
				controller.setCurBlockDamageMP(1.0F);
			}
		}
	}

	@EventHandler
	void onUpdate(EventUpdate event) {
		if (Client.getModuleManager().getModuleByClass(Nuker.class).isEnabled())
			return;
		if (Objects.equals(modeValue.getValue(), "Packet")) {
			// 箱子判断
			IPlayerControllerMP controller = (IPlayerControllerMP) mc.playerController;
			if (mc.playerController.extendedReach()) {
				controller.setBlockHitDelay(0);
				if (controller.getCurBlockDamageMP() >= damage.getValue().floatValue()) {
					controller.setCurBlockDamageMP(1.0F);
				}
			} else if (destroy && mc.playerController.getIsHittingBlock() && mc.thePlayer
					.canHarvestBlock(mc.theWorld.getBlockState(mc.objectMouseOver.getBlockPos()).getBlock())) {
				Block block = mc.theWorld.getBlockState(blockPos).getBlock();
				progress += block.getPlayerRelativeBlockHardness(mc.thePlayer, mc.theWorld, blockPos)
						* Speed.getValue().floatValue();

				if (progress >= 1.0f) {
					mc.theWorld.setBlockState(blockPos, Blocks.air.getDefaultState(), 11);
					((INetworkManager) mc.thePlayer.sendQueue.getNetworkManager()).sendPacketNoEvent(
							new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK, blockPos,
									facing));
					destroy = false;
				}
			}
		}
	}

	@EventHandler
	void onPacket(EventPacketSend event) {
		if (Client.getModuleManager().getModuleByClass(Nuker.class).isEnabled())
			return;
		if (Objects.equals(modeValue.getValue(), "Packet")) {
			// 箱子判断
			if (EventPacketSend.getPacket() instanceof C07PacketPlayerDigging && !mc.playerController.extendedReach()
					&& mc.playerController != null) {
				C07PacketPlayerDigging packet = (C07PacketPlayerDigging) EventPacketSend.getPacket();

				if (packet.getStatus() == C07PacketPlayerDigging.Action.START_DESTROY_BLOCK) {
					destroy = true;
					blockPos = packet.getPosition();
					facing = packet.getFacing();
					progress = 0.0f;
					Helper.getTimer().timerSpeed = 1.0f;
				} else if (packet.getStatus() == C07PacketPlayerDigging.Action.ABORT_DESTROY_BLOCK
						|| packet.getStatus() == C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK) {
					destroy = false;
					blockPos = null;
					facing = null;
					Helper.getTimer().timerSpeed = 1.0f;
				}
			}
		}
	}
}
