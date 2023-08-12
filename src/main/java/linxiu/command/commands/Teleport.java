package linxiu.command.commands;

import linxiu.Client;
import linxiu.api.EventBus;
import linxiu.api.EventHandler;
import linxiu.api.events.world.EventMove;
import linxiu.api.events.world.EventPacketReceive;
import linxiu.api.events.world.EventPacketSend;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.command.Command;
import linxiu.command.commands.PathFinder.AStarCustomPathFinder;
import linxiu.command.commands.PathFinder.Vec3;
import linxiu.module.modules.uhc.UhcHelper;
import linxiu.ui.notification.Notification;
import linxiu.utils.Helper;
import linxiu.utils.MovementUtils;
import linxiu.utils.PacketUtils;
import linxiu.utils.PlayerUtils;
import linxiu.utils.timer.TimerUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.client.C03PacketPlayer.C05PacketPlayerLook;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.util.BlockPos;

import java.util.ArrayList;

public class Teleport extends Command {
	public Teleport() {
		super("Teleport", new String[] { "teleport", "tp" }, "", "Teleport");
	}

	boolean packet;
	public static Minecraft mc = Minecraft.getMinecraft();
	private ArrayList<Vec3> path = new ArrayList<>();
	public boolean tp;
	public static BlockPos target;
	public Entity targetEntity;
	public TimerUtil timer = new TimerUtil();
	public TimerUtil time2r = new TimerUtil();
	public static boolean enabled;

	@Override
	public String execute(String[] args) {
		timer = new TimerUtil();
		if (args.length != 3 && args.length != 1) {
			return null;
		} else {
//            if (!ServerUtils.INSTANCE.isOnHypixel()) {
//                PlayerUtils.tellPlayer("Teleport is only for Hypixel!");
//                return;
//            }

			Helper.sendMessage("Please Wait...");
			timer.reset();
			tp = false;
			targetEntity = null;
			target = null;
			packet = false;
			enabled = false;

			if (args.length == 3) {
//                Helper.sendMessage(Arrays.toString(args));

				try {
					target = new BlockPos(Integer.parseInt(args[0]), Integer.parseInt(args[1]),
							Integer.parseInt(args[2]));
				} catch (Exception e) {
					Helper.sendMessage("Invalid Position!");
					return null;
				}

//                Helper.sendMessage((target.getY() < 20) + " ");

			} else {
				for (Entity entity : mc.theWorld.loadedEntityList) {
					if (entity instanceof EntityPlayer && mc.thePlayer != entity) {
						if (entity.getName().equalsIgnoreCase(args[0])) {
							targetEntity = entity;
							break;
						}
					}
				}

				if (targetEntity == null) {
					Helper.sendMessage("Can not locate " + args[0]);
					return null;
				} else {
					Helper.sendMessage("Located Player " + targetEntity.getName() + "!");
				}
			}

			PlayerUtils.tellPlayer("§b" + "Server Lag!");
			enabled = true;
			mc.thePlayer.sendChatMessage("/lobby");
			new Thread(() -> {
				try {
					Thread.sleep(150L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				mc.thePlayer.sendChatMessage("/back");
			}).start();
			EventBus.getInstance().register(this);
		}
		return null;
	}

	@EventHandler
	public final void onSendPacket(EventPacketSend event) {
		if (!tp && (EventPacketSend.getPacket() instanceof C03PacketPlayer || EventPacketSend.getPacket() instanceof C04PacketPlayerPosition
				|| EventPacketSend.getPacket() instanceof C05PacketPlayerLook
				|| EventPacketSend.getPacket() instanceof C06PacketPlayerPosLook)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public final void onReceivePacket(EventPacketReceive event) {
		if (EventPacketReceive.getPacket() instanceof S08PacketPlayerPosLook) {
			S08PacketPlayerPosLook packet = new S08PacketPlayerPosLook();
			enabled = true;
			this.tp = true;
			mc.thePlayer.setPosition(target.getX() + 0.5, target.getY() + 0.5, target.getZ() + 0.5);
		}
	}

	private BlockPos endPos;

	@EventHandler
	public void onPre(EventPreUpdate e) {
		if (timer.delay(8500)) {
			Helper.sendMessage("Failed to teleport. Please make sure you are in Hypixel Gaming!");
			PacketUtils.sendPacketNoEvent(
					new C0BPacketEntityAction(mc.thePlayer, C0BPacketEntityAction.Action.START_SPRINTING));
			PacketUtils.sendPacketNoEvent(
					new C0BPacketEntityAction(mc.thePlayer, C0BPacketEntityAction.Action.STOP_SNEAKING));
			EventBus.getInstance().unregister(this);
		}
		Vec3 topFrom = new Vec3(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ);
		if (target == null)
			target = new BlockPos(targetEntity.posX, targetEntity.posY + 1, targetEntity.posZ);

		Vec3 to = new Vec3(target.getX(), target.getY(), target.getZ());
		path = computePath(topFrom, to);
		Helper.sendMessage("Teleporting to X:" + target.getX() + " Y:" + target.getY() + " Z:" + target.getZ());
		EventBus.getInstance().unregister(this);
		new Thread(() -> {
			try {
				Thread.sleep(2450);
			} catch (InterruptedException interruptedException) {
				interruptedException.printStackTrace();
			}
			double posX = mc.thePlayer.posX, posY = mc.thePlayer.posY, posZ = mc.thePlayer.posZ;
			for (Vec3 pathElm : path) {
				PacketUtils.sendPacketNoEvent(new C03PacketPlayer.C04PacketPlayerPosition(pathElm.getX(),
						pathElm.getY(), pathElm.getZ(), true));
			}

			PacketUtils.sendPacketNoEvent(new C03PacketPlayer.C06PacketPlayerPosLook(target.getX(), target.getY(),
					target.getZ(), mc.thePlayer.rotationYaw, mc.thePlayer.rotationPitch, false));
			PacketUtils.sendPacketNoEvent(new C03PacketPlayer(false));
			PacketUtils.sendPacketNoEvent(new C03PacketPlayer.C06PacketPlayerPosLook(target.getX(), target.getY(),
					target.getZ(), mc.thePlayer.rotationYaw, mc.thePlayer.rotationPitch, false));
			PacketUtils.sendPacketNoEvent(new C03PacketPlayer(false));

			Client.INSTANCE.getNotificationManager().getNotifications().add(new Notification("Tppppppp"));
			mc.thePlayer.setPosition(target.getX() + 0.5, target.getY() + 100.0D, target.getZ() + 0.5);
			enabled = false;
			UhcHelper.tp = false;
			PacketUtils.sendPacketNoEvent(
					new C0BPacketEntityAction(mc.thePlayer, C0BPacketEntityAction.Action.START_SPRINTING));
			PacketUtils.sendPacketNoEvent(
					new C0BPacketEntityAction(mc.thePlayer, C0BPacketEntityAction.Action.STOP_SNEAKING));
		}).start();
	}

	@EventHandler
	public void onMove(EventMove event) {
		if (this.tp) {

			MovementUtils.setSpeed(event, 0.0);
			mc.thePlayer.motionY = 0.0;
			event.setY(0.0);
		}
	}

	private ArrayList<Vec3> computePath(Vec3 topFrom, Vec3 to) {
		if (!canPassThrow(new BlockPos(topFrom.mc()))) {
			topFrom = topFrom.addVector(0, 1, 0);
		}
		AStarCustomPathFinder pathfinder = new AStarCustomPathFinder(topFrom, to);
		pathfinder.compute();

		int i = 0;
		Vec3 lastLoc = null;
		Vec3 lastDashLoc = null;
		ArrayList<Vec3> path = new ArrayList<Vec3>();
		ArrayList<Vec3> pathFinderPath = pathfinder.getPath();
		for (Vec3 pathElm : pathFinderPath) {
			if (i == 0 || i == pathFinderPath.size() - 1) {
				if (lastLoc != null) {
					path.add(lastLoc.addVector(0.5, 0, 0.5));
				}
				path.add(pathElm.addVector(0.5, 0, 0.5));
				lastDashLoc = pathElm;
			} else {
				boolean canContinue = true;
				if (pathElm.squareDistanceTo(lastDashLoc) > 80) {
					canContinue = false;
				} else {
					double smallX = Math.min(lastDashLoc.getX(), pathElm.getX());
					double smallY = Math.min(lastDashLoc.getY(), pathElm.getY());
					double smallZ = Math.min(lastDashLoc.getZ(), pathElm.getZ());
					double bigX = Math.max(lastDashLoc.getX(), pathElm.getX());
					double bigY = Math.max(lastDashLoc.getY(), pathElm.getY());
					double bigZ = Math.max(lastDashLoc.getZ(), pathElm.getZ());
					cordsLoop: for (int x = (int) smallX; x <= bigX; x++) {
						for (int y = (int) smallY; y <= bigY; y++) {
							for (int z = (int) smallZ; z <= bigZ; z++) {
								if (!AStarCustomPathFinder.checkPositionValidity(x, y, z, false)) {
									canContinue = false;
									break cordsLoop;
								}
							}
						}
					}
				}
				if (!canContinue) {
					path.add(lastLoc.addVector(0.5, 0, 0.5));
					lastDashLoc = lastLoc;
				}
			}
			lastLoc = pathElm;
			i++;
		}
		return path;
	}

	private boolean canPassThrow(BlockPos pos) {
		Block block = Minecraft.getMinecraft().theWorld
				.getBlockState(new net.minecraft.util.BlockPos(pos.getX(), pos.getY(), pos.getZ())).getBlock();
		return block.getMaterial() == Material.air || block.getMaterial() == Material.plants
				|| block.getMaterial() == Material.vine || block == Blocks.ladder || block == Blocks.water
				|| block == Blocks.flowing_water || block == Blocks.wall_sign || block == Blocks.standing_sign;
	}
}
