package linxiu.module.modules.uhc;

import com.mojang.realmsclient.util.Pair;
import linxiu.api.EventHandler;
import linxiu.api.events.world.EventTick;
import linxiu.api.value.Option;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.combat.AntiBot;
import linxiu.utils.PlayerUtil;
import linxiu.utils.PlayerUtils;
import linxiu.utils.timer.TimerUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HackerDetector extends Module {
	public static Option speed = new Option("speed", true);
	public static Option killaura = new Option("killaura", true);
	private int bufferSpeed;
	private int bufferNoFall;
	private final List<Pair<EntityPlayer, String>> data;
	public static final ArrayList<EntityPlayer> hackers;
	private final ArrayList<String> hacker;
	double auravl;
	double NoKBvl;
	double noslowvl;
	double speedvl;
	TimerUtil time;
	public static boolean enabled;
	static {
		hackers = new ArrayList<EntityPlayer>();
		enabled = false;
	}

	public HackerDetector() {
		super("HackerDetector", new String[] { "HackerDetector" }, ModuleType.Render);
		this.setColor(new Color(208, 30, 142).getRGB());
		this.data = new ArrayList<Pair<EntityPlayer, String>>();
		this.hacker = new ArrayList<String>();
		this.time = new TimerUtil();
	}

	@Override
	public void onEnable() {
		super.onEnable();
		hackers.clear();
		this.data.clear();
		this.hacker.clear();
		enabled = true;
	}

	@Override
	public void onDisable() {
		super.onDisable();
		hackers.clear();
		enabled = false;
	}

	@EventHandler
	public void onUpdate(EventTick e) {
		if (mc.thePlayer.ticksExisted <= 105) {
			hackers.clear();
			return;
		}
		if (mc.theWorld == null) {
			return;
		}
		AntiBot ab = (AntiBot) ModuleManager.getModuleByClass(AntiBot.class);
		for (final Entity entity : mc.theWorld.playerEntities) {
			final EntityPlayer player = (EntityPlayer) entity;
			if (!(player instanceof EntityPlayerSP) && player != mc.thePlayer && player.ticksExisted >= 105
					&& !hackers.contains(player) && !player.capabilities.isFlying && !AntiBot.isBot(entity)) {
				if (player.capabilities.isCreativeMode) {
					continue;
				}
				if (killaura.getValue().booleanValue()) {
					boolean highYawRate = Math.abs(player.rotationYaw - player.prevRotationYaw) > 50.0f;
					if (Math.abs(player.rotationYaw - player.prevRotationYaw) > 50 && player.swingProgress != 0F) {
						PlayerUtils.hack("§1" + player.getName() + "§3 is Flagged Kill Aura");
						hackers.add((EntityPlayer) player);
					}
				}
			}

			double playerSpeed = PlayerUtil.getBPS(player);
			if (speed.getValue().booleanValue()
					&& !mc.theWorld.getCollidingBoundingBoxes(player,
							mc.thePlayer.getEntityBoundingBox().offset(0.0, player.motionY, 0.0)).isEmpty()
					&& player.motionY > 0 && playerSpeed > 10 && player.isBlocking()) {
				PlayerUtils.hack("§1" + player.getName() + "§3 is Flagged Speed");
				hackers.add(player);
			}
		}
	}

	public static boolean isHacker(final EntityLivingBase ent) {
		for (final EntityPlayer hacker : hackers) {
			if (!ent.getName().equals(hacker.getName())) {
				continue;
			}
			return true;
		}
		return false;
	}
}
