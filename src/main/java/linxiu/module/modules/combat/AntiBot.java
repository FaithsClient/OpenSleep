/*
 * Decompiled with CFR 0_132.
 */
package linxiu.module.modules.combat;

import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.world.EventPacketReceive;
import linxiu.api.events.world.EventPacketSend;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.events.world.EventUpdate;
import linxiu.api.value.Option;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.ui.notification.Notification;
import linxiu.utils.ChatUtils;
import linxiu.utils.PlayerUtil;
import linxiu.utils.PlayerUtils;
import linxiu.utils.timer.TimeHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.S0CPacketSpawnPlayer;
import net.minecraft.network.play.server.S18PacketEntityTeleport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public final class AntiBot extends Module {
	public static List botList = new ArrayList();
	public static List botList2 = new ArrayList();
	public Option info = new Option("info", "info", true);
	public Option remove = new Option("remove", "remove", true);
	TimeHelper timer2 = new TimeHelper();
	TimeHelper timer = new TimeHelper();

	public AntiBot() {
		super("AntiBot", new String[] { "AntiBot" }, ModuleType.Combat);
	}

	public void onDisable() {
		if (!botList.isEmpty()) {
			botList.clear();
		}

		super.onDisable();
	}

	public List getTabPlayer() {
		Collection var1 = mc.thePlayer.sendQueue.getPlayerInfoMap();
		ArrayList var2 = new ArrayList();
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			NetworkPlayerInfo var4 = (NetworkPlayerInfo) var3.next();
			var2.contains(mc.theWorld.getPlayerEntityByName(var4.getGameProfile().getName()));
		}
		return var2;
	}

	@EventHandler
	public void onUpdate(EventUpdate event) {
		this.setSuffix("Advanced");

		if (!botList2.isEmpty() && this.timer2.isDelayComplete(1000.0)) {
			if (this.info.getValue()) {
				if (botList2.size() == 1) {
					PlayerUtils.tellPlayer(" Kill " + botList2.size() + " Watchdog !!!");
				}
				PlayerUtils.tellPlayer(" Kill " + botList2.size() + " Bots!");
			}
			this.timer2.reset();
			botList2.clear();
		}

		if (!botList.isEmpty() && this.timer.isDelayComplete(1000.0)) {
			botList.clear();
			this.timer.reset();
		}

		if (!mc.theWorld.getLoadedEntityList().isEmpty()) {
			for (Entity ent : mc.theWorld.getLoadedEntityList()) {
				if (ent instanceof EntityPlayer) {
					EntityPlayer var6 = (EntityPlayer) ent;
					if (var6 != mc.thePlayer && !botList.contains(var6)) {
						String var7 = ent.getDisplayName().getFormattedText();
						String var8 = var6.getCustomNameTag();
						String var9 = var6.getName();
						// PlayerUtil.debug(formatted);
						// name check
						// npc check
						if (var6.isInvisible() && var7.startsWith("§r§c") && var7.endsWith("§r")) {
							double var10 = Math.abs(var6.posX - mc.thePlayer.posX);
							double var12 = Math.abs(var6.posY - mc.thePlayer.posY);
							double var14 = Math.abs(var6.posZ - mc.thePlayer.posZ);
							double var16 = Math.sqrt(var10 * var10 + var14 * var14);
							if (var12 < 13.0 && var12 > 10.0 && var16 < 3.0) {
								List var18 = this.getTabPlayer();
								if (!var18.contains(var6)) {
									this.timer2.reset();
									botList2.add(var6);
									mc.theWorld.removeEntity(var6);
									botList.add(var6);
								}
							}
						}

						if (var6.isInvisible() && var7.startsWith("§r§c") && var7.endsWith("§r")
								&& (Objects.isNull(mc.getNetHandler().getPlayerInfo(var6.getUniqueID()))
										|| mc.getNetHandler().getPlayerInfo(var6.getUniqueID()).getResponseTime() > 20
										|| mc.getNetHandler().getPlayerInfo(var6.getUniqueID())
												.getResponseTime() == 0)) {
							this.timer2.reset();
							botList2.add(var6);
							mc.theWorld.removeEntity(var6);
							botList.add(var6);
						}

						if (var6.isInvisible() && var9.startsWith("§c")
								&& (Objects.isNull(mc.getNetHandler().getPlayerInfo(var6.getUniqueID()))
										|| mc.getNetHandler().getPlayerInfo(var6.getUniqueID()).getResponseTime() > 20
										|| mc.getNetHandler().getPlayerInfo(var6.getUniqueID())
												.getResponseTime() == 0)) {
							this.timer2.reset();
							botList2.add(var6);
							mc.theWorld.removeEntity(var6);
							botList.add(var6);
						}

						if (!var6.isInvisible() && var7.startsWith("§r§c") && var7.endsWith("§r")
								&& mc.getNetHandler().getPlayerInfo(var6.getUniqueID()).getResponseTime() > 20) {

							if (var6.posY > mc.thePlayer.posY && (double) mc.thePlayer.getDistanceToEntity(var6) <= 6.0
									&& !var7.startsWith("§r§c[§fYOUTUBE§c]")
									&& !var7.startsWith("§r§c[ADMIN]")) {
								PlayerUtils.tellPlayer("检测 " + var7 + " - GameMaster Bot!");
								mc.theWorld.removeEntity(var6);
								PlayerUtils.tellPlayer("已清除Bot!");
								botList.add(var6);
							}
						}
					}
				}
			}
		}
	}

	public static boolean isBot(Entity e) {
		if (!(e instanceof EntityPlayer) || !ModuleManager.getModuleByClass(AntiBot.class).isEnabled())
			return false;
		EntityPlayer player = (EntityPlayer) e;

		return botList.contains(player);
	}
}