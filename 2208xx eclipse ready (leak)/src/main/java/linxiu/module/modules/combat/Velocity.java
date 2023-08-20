/*
 * Decompiled with CFR 0_132.
 */
package linxiu.module.modules.combat;

import linxiu.api.EventHandler;
import linxiu.api.events.world.EventPacketReceive;
import linxiu.api.events.world.EventUpdate;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.utils.ChatUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S27PacketExplosion;

import java.util.Queue;
import java.awt.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Velocity extends Module {
	private static final Option kbAlert = new Option("Alert", true);
	private static final Option newvalue = new Option("New Value", false);
	private static final Option Suffix = new Option("Set Suffix", "Set Suffix", true);
	public Numbers<Number> Vertical = new Numbers<Number>("Vertical", 0.0, 0.0, 100.0, 1.0);
	public Numbers<Number> Horizontal = new Numbers<Number>("Horizon", 0.0, 0.0, 100.0, 1.0);
    private Numbers<Number> delay = new Numbers<Number>("Choke Delay", 400, 0, 800 , 50);
    private Numbers<Number> limit = new Numbers<Number>("Choke Limit", 8000, 0, 25000 , 500);
	private final Queue<TimestampedPacket> packets = new ConcurrentLinkedDeque<>();

	public Velocity() {
		super("Velocity", new String[] { "velocity" }, ModuleType.Combat);
		this.setColor(new Color(191, 191, 191).getRGB());
	}

	@EventHandler
	private void onUpdate(EventUpdate event) {
		resetPackets(mc.getNetHandler().getNetworkManager().getNetHandler());
	}
	
	@EventHandler
	private void onPacket(EventPacketReceive event) {
		if (Suffix.getValue()) {
			this.setSuffix("Cancel");
		} else {
			this.setSuffix("");
		}
		if (newvalue.getValue()) {
			if (event.getPacket() instanceof S12PacketEntityVelocity) {
				event.setCancelled(true);
				S12PacketEntityVelocity packetIn = (S12PacketEntityVelocity) event.getPacket();
				Entity entity = mc.theWorld.getEntityByID(packetIn.getEntityID());
				if (entity != null)
					entity.setVelocity((double) packetIn.getMotionX() / 8000.0D,
							(double) packetIn.getMotionY() / 8000.0D, (double) packetIn.getMotionZ() / 8000.0D);
				if (entity == mc.thePlayer) {
					mc.thePlayer.motionX *= -1;
					mc.thePlayer.motionZ *= -1;
				}
			}
		} else {
			float hor = Horizontal.getValue().floatValue() / 100;
			float ver = Vertical.getValue().floatValue() / 100;
			if (EventPacketReceive.getPacket() instanceof S27PacketExplosion) {
				final S27PacketExplosion s12 = (S27PacketExplosion) EventPacketReceive.getPacket();
				if (kbAlert.getValue()) kbAlert(event);
				event.setCancelled(Horizontal.getValue().intValue() == 0 && Vertical.getValue().intValue() == 0);
				float xx = s12.func_149149_c();
				float yy = s12.func_149144_d();
				float zz = s12.func_149147_e();
				xx = s12.func_149149_c() * hor;
				yy = s12.func_149144_d() * ver;
				zz = s12.func_149147_e() * hor;
				if (!event.isCancelled()) { // 是否被取消 如果没有进行Choke处理
					if (Math.abs(s12.func_149149_c()) + Math.abs(s12.func_149144_d()) + Math.abs(s12.func_149147_e()) * 8000 < limit.getValue().floatValue()) {
						// 取消这个包的效果
						event.setCancelled(true);
						// 增加这个的Packet
						addPackets(new TimestampedPacket(event.getPacket(), System.currentTimeMillis()), event);
					}
				}
			}

			if (EventPacketReceive.getPacket() instanceof S12PacketEntityVelocity) {
				final S12PacketEntityVelocity packet = (S12PacketEntityVelocity) EventPacketReceive.getPacket();
				if (packet.getEntityID() == mc.thePlayer.getEntityId()) {
					double x = packet.getMotionX() * hor, y = packet.getMotionY() * ver, z = packet.getMotionZ() * hor;
					if (kbAlert.getValue()) kbAlert(event);
					// 移除该包效果 改为自定义
					event.setCancelled(true);
					if (Horizontal.getValue().intValue() == 0 && Vertical.getValue().intValue() == 0)
						return;
					if (Math.abs(packet.getMotionX()) + Math.abs(packet.getMotionZ()) + Math.abs(packet.getMotionY()) < limit.getValue().floatValue()) {
						// 取消这个包的效果
						event.setCancelled(true);
						// 重新定义Packet
						event.setPacket(new S12PacketEntityVelocity(mc.thePlayer.getEntityId(), x / 8000, y / 8000, z / 8000));
						// 增加这个定义后的Packet
						addPackets(new TimestampedPacket(event.getPacket(), System.currentTimeMillis()), event);
					} else {
						// 设置KnockBack
						mc.thePlayer.setVelocity(x / 8000, y / 8000, z / 8000);
					}
				}
			}
		}
	}

	private void addPackets(TimestampedPacket packet, EventPacketReceive eventReadPacket) {
		synchronized (packets) {
			if (blockPacket(packet.packet)) {
				packets.add(packet);
				eventReadPacket.setCancelled(true);
			}
		}
	}

	private void resetPackets(INetHandler netHandler) {
		if (packets.size() > 0) {
			synchronized (packets) {
				try {
					for (final TimestampedPacket timestampedPacket : packets) {
						final long timestamp = timestampedPacket.timestamp;
						if (Math.abs(timestamp - System.currentTimeMillis()) >= delay.getValue().longValue()) {
							timestampedPacket.packet.processPacket(netHandler);
							packets.remove(timestampedPacket);
						}
					}
				} catch (Exception ignored) {
				}
			}
		}
	}

	private boolean blockPacket(Packet<?> packet) {
		return packet instanceof S12PacketEntityVelocity || packet instanceof S27PacketExplosion;
	}

	private static class TimestampedPacket {
		private final Packet<INetHandler> packet;
		private final long timestamp;

		public TimestampedPacket(final Packet<INetHandler> packet, final long timestamp) {
			this.packet = packet;
			this.timestamp = timestamp;
		}
	}

	// KB Alert by belris2u
	private void kbAlert(EventPacketReceive e) {
		if (mc.thePlayer.hurtTime == 0 && mc.thePlayer.ticksExisted > 60) {
			// 收到击退包的tick 如果没有收到伤害 新建线程延迟1tick继续检测
			new Thread(() -> {
				try {
					Thread.sleep(250); // After 1 tick
					if (mc.thePlayer.hurtTime == 0) { // 如果还是没有收到任何伤害
						if (e.getPacket() instanceof S12PacketEntityVelocity) { // handle S12
							S12PacketEntityVelocity packet = (S12PacketEntityVelocity) e.getPacket();
							ChatUtils.info("You may have been KB checked! S12 #" + mc.thePlayer.ticksExisted);
							// 如果包被cancel就补充一个 不要把所有包都cancel掉然后用setVelocity, 这样我获取不到状态
							mc.thePlayer.setVelocity((double) packet.getMotionX() / 8000.0D,
									(double) packet.getMotionY() / 8000.0D, (double) packet.getMotionZ() / 8000.0D);
						} else { // handle S27
							S27PacketExplosion packet = (S27PacketExplosion) e.getPacket();
							ChatUtils.info("You may have been KB checked! S27 #" + mc.thePlayer.ticksExisted);
							mc.thePlayer.setVelocity(packet.getX(), packet.getY(), packet.getZ());
						}
					}
				} catch (InterruptedException exception) {
					exception.printStackTrace();
				}
			}).start();
		}
	}
}
