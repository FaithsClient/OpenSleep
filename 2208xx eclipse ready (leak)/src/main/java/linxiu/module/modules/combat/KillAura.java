package linxiu.module.modules.combat;

import com.google.common.base.Predicates;
import linxiu.Client;
import linxiu.api.EventBus;
import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender3D;
import linxiu.api.events.world.EventAttack;
import linxiu.api.events.world.EventPostUpdate;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.events.world.EventUpdate;
import linxiu.api.value.ColorValue;
import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.injection.interfaces.IKeyBinding;
import linxiu.injection.interfaces.IRenderManager;
import linxiu.management.ModuleManager;
import linxiu.management.PlayerManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.movement.NoSlow;
import linxiu.module.modules.movement.Scaffold;
import linxiu.module.modules.player.Teams;
import linxiu.module.modules.render.HUD;
import linxiu.ui.notification.Notification;
import linxiu.utils.Helper;
import linxiu.utils.math.MathUtil;
import linxiu.utils.math.RotationUtil;
import linxiu.utils.render.RenderUtil;
import linxiu.utils.render.RenderUtils;
import linxiu.utils.timer.TimeHelper;
import linxiu.utils.timer.TimerUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.server.S0CPacketSpawnPlayer;
import net.minecraft.network.play.server.S18PacketEntityTeleport;
import net.minecraft.network.play.server.S30PacketWindowItems;
import net.minecraft.potion.Potion;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import org.apache.commons.lang3.RandomUtils;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static linxiu.utils.RotationUtils.getVectorForRotation;

public class KillAura extends Module {
	private final Mode mode = new Mode("Mode", new String[] { "Switch", "Single" }, "Switch");
	private final Mode priority = (Mode) new Mode("Priority",
			new String[] { "Fov", "Range", "Angle", "Armor", "Health" }, "Fov");
	private final Mode espMode = new Mode("ESP", new String[] { "None", "Vape", "Box", "Rise", "Icarus" }, "None");

	public static Mode rotateMode = new Mode("Rotate", new String[] { "Smart", "Zenith", "None", "Zeriy" }, "Zenith");
	public static Mode renderMode = new Mode("Render", new String[] { "Zenith", "Sigma", "Astolfo" }, "Zenith");

	public final Numbers<Number> switchDelayValue = new Numbers<>("SwitchDelay", "SwitchDelay", 15.0, 0.0, 20.0, 0.5),
			rangeValue = new Numbers<>("Range", "Range", 4.20, 1.00, 8.00, 0.05),
			maxAPSProperty = new Numbers<Number>("Max APS", "MaxAPS", 12.1, 0, 20, 0.1),
			minAPSProperty = new Numbers<Number>("Min APS", "MinAPS", 10.1, 0, 20, 0.1),
			attackRangeValue = new Numbers<>("AttackRange", "AttackRange", 5.00, 1.00, 15.00, 0.05),
			wallRangeValue = new Numbers<>("WallRange", "WallRange", 4.20, 1.00, 5.00, 0.05),
			heightProperty = new Numbers<Number>("Height", "Height", 1.2, 0, 1.5, 0.1),
			fovValue = new Numbers<>("Fov", "Fov", 180.0, 10.0, 360.0, 10.0),
			maxTargets = new Numbers<>("MaxTarget", 1.0, 1.0, 50.0, 1.0);

	public static final Option playerValue = new Option("Player", "Player", true),
			animalValue = new Option("Animal", "Animal", false), monsterValue = new Option("Monster", "Monster", false),
			neutralValue = new Option("Neutral", "Neutral", false), preferValue = new Option("Prefer", "Prefer", false),
			deathValue = new Option("Death", "Death", true), multi = new Option("Multi", "Multi", false),
			rayCast = new Option("RayCast", "RayCast", false),
			invisibleValue = new Option("Invisible", "invisible", false),
			autoValue = new Option("AutoToggle", "AutoToggle", false),
			throughWallValue = new Option("ThroughWall", "ThroughWall", false),
			HeadValue = new Option("Head Only", "Head Only", false),
			smoothValue = new Option("Smooth Aim", "Smooth Aim", true),
			suffixValue = new Option("New Suffix", "New Suffix", true),
			rainbowValue = new Option("ESP Rainbow", "ESP Rainbow", true),
			autoBlockValue = new Option("Auto Block", "Auto Block", false);

	public static final ColorValue colorValue = new ColorValue("Color", Color.RED.getRGB());
	public static final ColorValue color2Value = new ColorValue("Color2", Color.PINK.getRGB());
	public static EntityLivingBase target;
	public static EntityLivingBase vip;
	public static EntityLivingBase blockTarget;
	public static boolean blocking = false;
	public static float yaw;
	public static float pitch;
	public static float c = 0.0F;
	private final TimeHelper switchTimer = new TimeHelper();
	private final TimerUtil attacker = new TimerUtil();
	private final TimeHelper RotTimer = new TimeHelper();
	public ArrayList<EntityLivingBase> targetList = new ArrayList<>();
	private int index;
	public static float[] facing12;
	private float[] facing01;
	private float[] facing11;
	private float[] facing21;
	private float[] facing31;
	private float[] facing41;

	public KillAura() {
		super("Kill Aura", new String[] { "ka", "aura", "killa" }, ModuleType.Combat);
		this.setColor(new Color(226, 54, 30).getRGB());
	}

	public static EntityLivingBase getTarget() {
		return target;
	}

	public static double getRandomBetween(double min, double max) {
		double shifted;
		Random random = new Random();
		double range = max - min;
		double scaled = random.nextDouble() * range;
		if (scaled > max) {
			scaled = max;
		}
		if ((shifted = scaled + min) > max) {
			shifted = max;
		}
		return shifted;
	}

	public static float random(float min, float max) {
		Random random = new Random();
		float range = max - min;
		float scaled = random.nextFloat() * range;
		float shifted = scaled + min;
		return shifted;
	}

	public static float[] cahgnle(float[] vector) {
		vector[0] %= 360.0F;

		for (vector[1] %= 360.0F; vector[0] <= -180.0F; vector[0] += 360.0F) {
		}

		while (vector[1] <= -180.0F) {
			vector[1] += 360.0F;
		}

		while (vector[0] > 180.0F) {
			vector[0] -= 360.0F;
		}

		while (vector[1] > 180.0F) {
			vector[1] -= 360.0F;
		}

		return vector;
	}

	public static boolean canAttackEntity(Entity entity) {
		if (entity instanceof EntityAnimal) {
			return animalValue.getValue();
		}
		if (entity instanceof EntityMob) {
			return monsterValue.getValue();
		}
		if (entity instanceof EntityVillager || entity instanceof EntityIronGolem || entity instanceof EntitySnowman) {
			return neutralValue.getValue();
		}
		return true;
	}

	@Override
	public void onEnable() {
		super.onEnable();
		// target
		targetList.clear();
		target = null;
		blockTarget = null;

		yaw = mc.thePlayer != null ? mc.thePlayer.rotationYaw : 0.0F;
		pitch = mc.thePlayer != null ? mc.thePlayer.rotationPitch : 0.0F;

		// switch
		index = 0;
		switchTimer.reset();
		RotTimer.reset();

		blocking = mc.gameSettings.keyBindUseItem.isKeyDown();
	}

	@Override
	public void onDisable() {
		super.onDisable();
		// target
		targetList.clear();
		target = null;
		blockTarget = null;
		((IKeyBinding) mc.gameSettings.keyBindUseItem).setPress(Mouse.isButtonDown(1));
		unblock();
	}

	@EventHandler
	public final void On(EventUpdate event) {
		if (autoValue.getValue()) {
			if (target != null) {
				if (mc.thePlayer.getHeldItem() != null) {
					if (mc.thePlayer.getHeldItem().getDisplayName().contains("Chest")) {
						this.toggle();
						if (Client.getModuleManager().getModuleByClass(NoSlow.class).isEnabled()) {
							Client.getModuleManager().getModuleByClass(NoSlow.class).toggle();
							Client.getINSTANCE().getNotificationManager().getNotifications()
									.add(new Notification("Check Chest " + "AutoToggle NoSlow", 3000L));
						}

						Client.getINSTANCE().getNotificationManager().getNotifications()
								.add(new Notification("Check Chest " + "AutoToggle KillAura", 3000L));
					}
				}
			}
		}
		if (suffixValue.getValue()) {
			this.setSuffix(Objects.equals(mode.getValue(), "Switch") ? "Switch" : "Priority");
		} else {
			if (target == null) {
				this.setSuffix("0 (" + "0%)");
			}
			int sum2 = 0;
			for (int i = 0; i < 100 + 1; i++) {
				sum2 = i;
			}

			double cps = ranModuleVal(MathUtil.rand());
			long delay = (int) Math.round(1000.0D / cps);

			int sum3 = 0;
			for (int i = 0; i < cps; i++) {
				sum3 = i;
			}

			if (target != null) {
				int hit = target.hurtTime >= 1 ? sum2 : (int) getRandomBetween(40, 90);
				if (mc.thePlayer.ticksExisted % HUD.tick.getValue().intValue() == 0) {
					this.setSuffix(sum3 + " (" + hit + "%)");
				}
			}
		}
	}

	@EventHandler
	public void onWorldReload(EventPreUpdate event) {
		if (mc.thePlayer.ticksExisted <= 1 && deathValue.getValue()) {
			Client.getINSTANCE().getNotificationManager().getNotifications()
					.add(new Notification("Disabled aura due to death", 3000L));
			this.setEnabled(false);
		}
	}

	@EventHandler
	public void onUpdate(EventPreUpdate event) {
		blockTarget = null;
		for (Entity entity : mc.theWorld.getLoadedEntityList()) {
			if (entity instanceof EntityLivingBase) {
				EntityLivingBase livingBase = (EntityLivingBase) entity;
				if (getEntityValidBlock(livingBase)) {
					blockTarget = livingBase;
					break;
				}
			}
		}

		if (target == null) {
			((IKeyBinding) mc.gameSettings.keyBindUseItem).setPress(Mouse.isButtonDown(1));
		}

		if (targetList.isEmpty()) {
			unblock();
		}

		target = null;
		targetList.clear();

		for (Entity entity : mc.theWorld.getLoadedEntityList()) {
			if (entity instanceof EntityLivingBase) {
				EntityLivingBase livingBase = (EntityLivingBase) entity;
				if (!getEntityValid(livingBase))
					continue;

				if (PlayerManager.isTarget(entity)) {
					targetList.clear();
					targetList.add(livingBase);
				}

				targetList.add(livingBase);
				if (Objects.equals(priority.getValue(), "Armor")) {
					targetList.sort(Comparator.comparingInt(
							o -> ((o instanceof EntityPlayer ? ((EntityPlayer) o).inventory.getTotalArmorValue()
									: (int) o.getHealth()))));
				} else {
					if (Objects.equals(priority.getValue(), "Range")) {
						targetList.sort((o1, o2) -> (int) (o1.getDistanceToEntity(mc.thePlayer)
								- o2.getDistanceToEntity(mc.thePlayer)));

					} else {
						if (Objects.equals(priority.getValue(), "Fov")) {
							targetList.sort(Comparator.comparingDouble(this::yawDist));
						} else if (Objects.equals(priority.getValue(), "Angle")) {
							targetList.sort((o1, o2) -> {
								float[] rot1 = getRotations(o1);
								float[] rot2 = getRotations(o2);
								return (int) (mc.thePlayer.rotationYaw - rot1[0]
										- (mc.thePlayer.rotationYaw - rot2[0]));
							});
						} else if (Objects.equals(priority.getValue(), "Health")) {
							targetList.sort((o1, o2) -> (int) (o1.getHealth() - o2.getHealth()));
						}
					}
				}

			}
		}

		if (preferValue.getValue()) {
			for (EntityLivingBase entityLivingBase : targetList) {
				if (entityLivingBase instanceof EntityWither) {
					targetList.clear();
					targetList.add(entityLivingBase);
					break;
				}
			}
		}

		if (switchTimer.isDelayComplete(switchDelayValue.getValue().intValue() * 100L) && targetList.size() > 1) {
			switchTimer.reset();
			++index;
		}

		if (index >= targetList.size()) {
			index = 0;
		}
		if (!targetList.isEmpty()) {
			target = targetList.get(Objects.equals(mode.getValue(), "Switch") ? index : 0);
		}
	}

	@EventHandler
	public void onPre(EventPreUpdate e) {
		if (target != null) {
			if (hasBlock(mc.thePlayer))
				return;

			if (mc.playerController.getIsHittingBlock())
				return;
		}

		if (target != null) {
			if (Objects.equals(rotateMode.getValue(), "None")) {

			}
			if (Objects.equals(renderMode.getValue(), "Astolfo")) {
				if (isVisibleFOV(target, 100)) {
					RotTimer.reset();
				}
			}
		}
		if (target != null) {
			if (Objects.equals(rotateMode.getValue(), "Smart")) {
				if (isVisibleFOV(target, 100)) {

					float[] rotations;
					if (target != null) {
						RotTimer.reset();
						rotations = getRotation(target);
						float a = MathHelper.wrapAngleTo180_float(rotations[0] + c - yaw);
						yaw = (float) ((double) (yaw + a) + ThreadLocalRandom.current().nextGaussian() * 1.1D);
						pitch = (float) Math.max(
								Math.min((double) rotations[1] + ThreadLocalRandom.current().nextGaussian(), 90.0),
								-90.0);

						boolean canAttack = false;
						if (!this.rayCastByRotation(yaw, pitch).isEmpty()) {
							for (MovingObjectPosition position : this.rayCastByRotation(yaw, pitch)) {
								if (position.entityHit != mc.thePlayer && position.entityHit == target) {
									canAttack = true;
									break;
								}
							}
						}
					}

					if (target != null) {
						e.setYaw(yaw);
						e.setPitch(pitch);
					}
				}
			}
		}

		if (target != null) {
			if (Objects.equals(rotateMode.getValue(), "Zeriy")) {
				new Random();
				this.facing11 = this.getExhRotations(target);
				this.facing21 = this.ExgetHypixelRotationsNeededBlock(target.posX, target.posY, target.posZ);
				this.facing31 = this.ExgetRotationFromPosition(target.posX, target.posY, target.posZ);
				this.facing41 = this.getRotationsNeededBlock(target.posX, target.posY, target.posZ);

				for (int var8 = 0; var8 <= 3; ++var8) {
					switch (randomNumber(1.0D, 2.0D)) {
					case 1:
						facing12 = this.facing11;
						break;
					case 2:
						facing12 = this.facing21;
						break;
					case 3:
						facing12 = this.facing31;
						break;
					case 4:
						facing12 = this.facing41;
					}
				}

				if (facing12.length >= 0) {
					e.setYaw(facing12[0]);
					e.setPitch(facing12[1]);
				}
			}
		}

		if (Objects.equals(rotateMode.getValue(), "Zenith")) {
			float[] rotations;
			if (target != null) {
				if (RotTimer.hasReached(150L) && !RotTimer.hasReached(350L) && smoothValue.getValue()
						&& !ModuleManager.getModuleByClass(Scaffold.class).isEnabled()) {
					rotations = new float[] { yaw, pitch };
					float[] targetRotations = new float[] { mc.thePlayer.rotationYaw,
							Math.max(Math.min(mc.thePlayer.rotationPitch, 90.0F), -90.0F) };
					float[] smoothedAim = this.Zenith(targetRotations, rotations);
					yaw = smoothedAim[0];
					pitch = Math.max(Math.min(smoothedAim[1], 90.0F), -90.0F);
				}
			}

			if (target != null) {
				RotTimer.reset();
				rotations = getRotation(target);
				float a = MathHelper.wrapAngleTo180_float(rotations[0] + c - yaw);
				if (!smoothValue.getValue()) {

					yaw = (float) ((double) (yaw + a) + ThreadLocalRandom.current().nextGaussian() * 1.1D);
					pitch = (float) Math.max(
							Math.min((double) rotations[1] + ThreadLocalRandom.current().nextGaussian(), 90.0), -90.0);
				} else {
					float[] srcRotations = new float[] { yaw, pitch };
					float[] targetRotations = new float[] { yaw + a, Math.max(Math.min(rotations[1], 90.0F), -90.0F) };
					float[] smoothedAim = this.Zenith(targetRotations, srcRotations);

					yaw = smoothedAim[0];
					pitch = Math.max(Math.min(smoothedAim[1], 90.0F), -90.0F);

					boolean canAttack = false;

					if (!this.rayCastByRotation(yaw, pitch).isEmpty()) {
						for (MovingObjectPosition position : this.rayCastByRotation(yaw, pitch)) {
							if (position.entityHit != mc.thePlayer && position.entityHit == target) {
								canAttack = true;
								break;
							}
						}
					}
				}
			}
			if (target != null) {
				e.setYaw(yaw);
				e.setPitch(pitch);
			}
		}
	}

	@EventHandler
	private void onUpdatePost(EventPostUpdate e) {
		if (target != null) {
			if (autoBlockValue.getValue().equals(Boolean.valueOf(false))) {
				if (hasSword(mc.thePlayer) && mc.thePlayer.isBlocking()) {
					mc.thePlayer.sendQueue
							.addToSendQueue(new C08PacketPlayerBlockPlacement(mc.thePlayer.getHeldItem()));
				}
			}
		}
		if (target != null) {
			boolean canAttack = false;
			EntityLivingBase attackTarget = target;
			if (!this.rayCastByRotation(yaw, pitch).isEmpty()) {
				for (MovingObjectPosition position : this.rayCastByRotation(yaw, pitch)) {
					if (rayCast.getValue() && position.entityHit != null && position.entityHit != mc.thePlayer
							&& getEntityValid((EntityLivingBase) position.entityHit)) {
						attackTarget = (EntityLivingBase) position.entityHit;
						canAttack = true;
						break;
					}
					if (position.entityHit != mc.thePlayer && position.entityHit != null
							&& position.entityHit == attackTarget) {
						canAttack = true;
						break;
					}
				}
			}
			double cps = ranModuleVal(MathUtil.rand());
			long delay = (int) Math.round(1000.0D / cps);
			Criticals cri = (Criticals) Client.getModuleManager().getModuleByClass(Criticals.class);
			if (attacker.hasTimeElapsed(delay, true)) {
				EventBus.getInstance().call(new EventAttack(canAttack ? attackTarget : target, true));
				if (multi.getValue()) {
					int targets = 0;
					for (EntityLivingBase entityLivingBase : this.targetList) {
						if (this.getEntityValid(entityLivingBase)) {
							int maxSize = maxTargets.getValue().intValue();
							if (multi.getValue() && targetList.size() > maxSize) {
								targetList.subList(maxSize, targetList.size()).clear();
							}
							mc.thePlayer.swingItem();
							mc.thePlayer.sendQueue.addToSendQueue(
									new C02PacketUseEntity(entityLivingBase, C02PacketUseEntity.Action.ATTACK));
							++targets;
						}
					}
				} else {
					mc.thePlayer.swingItem();
					mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(canAttack ? attackTarget : target,
							C02PacketUseEntity.Action.ATTACK));
					EventBus.getInstance().call(new EventAttack(canAttack ? attackTarget : target, false));
				}
				attacker.reset();
			}
		}

		double cps;
		cps = ranModuleVal(MathUtil.rand()) + (0.1 * MathUtil.rand().nextDouble());
		if (autoBlockValue.getValue().equals(Boolean.valueOf(false)) && blockTarget != null) {
			if (attacker.hasTimeElapsed(1000 / cps, true)) {
				mc.thePlayer.swingItem();
				attacker.reset();
			}
		}

		if (target != null) {
			int count = 0;
			while (count++ < 1.0 && target != null) {
				if (multi.getValue()) {
					for (final EntityLivingBase entity : targetList) {
						int maxSize = maxTargets.getValue().intValue();
						if (multi.getValue() && targetList.size() > maxSize) {
							targetList.subList(maxSize, targetList.size()).clear();
						}
						mc.effectRenderer.emitParticleAtEntity(entity, EnumParticleTypes.CRIT);
					}
				} else {
					mc.effectRenderer.emitParticleAtEntity(target, EnumParticleTypes.CRIT);
				}
			}
		}

		if (target != null) {
			if (autoBlockValue.getValue()) {
				if (hasSword(mc.thePlayer) && !mc.thePlayer.isBlocking()) {
					this.blocking = true;
					if (mc.thePlayer.swingProgressInt == 1) {
						mc.thePlayer.sendQueue.addToSendQueue(
								new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM,
										new BlockPos(-1, -1, -1), EnumFacing.DOWN));
					}
					mc.thePlayer.sendQueue
							.addToSendQueue(new C08PacketPlayerBlockPlacement(mc.thePlayer.getHeldItem()));
				}
			}
		}
	}

	public double ranModuleVal(Random r) {
		return minAPSProperty.getValue().doubleValue() == maxAPSProperty.getValue().doubleValue()
				? minAPSProperty.getValue().doubleValue()
				: minAPSProperty.getValue().doubleValue() + (r.nextDouble()
						* (maxAPSProperty.getValue().doubleValue() - minAPSProperty.getValue().doubleValue()));
	}

	public static float getRotationsa(EntityLivingBase ent) {
		final double x = ent.posX - Minecraft.getMinecraft().thePlayer.posX;
		final double z = ent.posZ - Minecraft.getMinecraft().thePlayer.posZ;
		final float yaw = (float) (-(Math.atan2(x, z) * 57.29577951308232));
		return yaw;
	}

	public static boolean isVisibleFOV(final Entity e, final float fov) {
		return ((Math.abs(getRotations(e)[0] - Minecraft.getMinecraft().thePlayer.rotationYaw) % 360.0f > 180.0f)
				? (360.0f - Math.abs(getRotations(e)[0] - Minecraft.getMinecraft().thePlayer.rotationYaw) % 360.0f)
				: (Math.abs(getRotations(e)[0] - Minecraft.getMinecraft().thePlayer.rotationYaw) % 360.0f)) >= fov;
	}

	private void unblock() {
		if (blocking) {
			mc.getNetHandler().addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM,
					BlockPos.ORIGIN, EnumFacing.DOWN));
			blocking = false;
		}
	}

	@EventHandler
	public void onRender2D(EventRender3D event) {
		ScaledResolution sr = new ScaledResolution(mc);
		if (target != null && Objects.equals(espMode.getValue(), "Icarus")) {
			if (multi.getValue()) {
				for (final EntityLivingBase entity : targetList) {
					int maxSize = maxTargets.getValue().intValue();
					if (multi.getValue() && targetList.size() > maxSize) {
						targetList.subList(maxSize, targetList.size()).clear();
					}
					RenderUtils.drawIcarusESP(entity, new Color(color2Value.getValue().intValue()), rainbowValue.getValue());
				}
			} else {
				EntityLivingBase entity = target;
				RenderUtils.drawIcarusESP(entity, new Color(color2Value.getValue().intValue()), rainbowValue.getValue());
			}
		}
	}

	@EventHandler
	public void onRender3D2(EventRender3D event) {
		if (target != null && Objects.equals(espMode.getValue(), "Rise")) {
			if (multi.getValue()) {
				for (final EntityLivingBase entity : targetList) {
					int maxSize = maxTargets.getValue().intValue();
					if (multi.getValue() && targetList.size() > maxSize) {
						targetList.subList(maxSize, targetList.size()).clear();
					}
					draw2Shadow(entity, 0.67, new Color(HUD.colorValue.getValue()).getRGB(), true);
				}
			} else {
				EntityLivingBase entity = target;
				draw2Shadow(entity, 0.67, new Color(HUD.colorValue.getValue()).getRGB(), true);
			}
		}

		if (target != null && Objects.equals(espMode.getValue(), "Box")) {
			if (multi.getValue()) {
				for (final EntityLivingBase entity : targetList) {
					int maxSize = maxTargets.getValue().intValue();
					if (multi.getValue() && targetList.size() > maxSize) {
						targetList.subList(maxSize, targetList.size()).clear();
					}
					RenderUtils.drawPlatform(entity, (target.hurtTime > 3) ? new Color(colorValue.getValue().intValue())
							: new Color(color2Value.getValue().intValue()));
				}
			} else {
				EntityLivingBase entity = target;
				RenderUtils.drawPlatform(entity, (target.hurtTime > 3) ? new Color(colorValue.getValue().intValue())
						: new Color(color2Value.getValue().intValue()));
			}
		}
		if (target != null && Objects.equals(espMode.getValue(), "Vape")) {
			if (multi.getValue()) {
				for (final EntityLivingBase entity : targetList) {
					double x1 = entity.lastTickPosX
							+ (entity.posX - entity.lastTickPosX) * (double) Helper.getTimer().renderPartialTicks
							- ((IRenderManager) mc.getRenderManager()).getRenderPosX();

					double y1 = entity.lastTickPosY
							+ (entity.posY - entity.lastTickPosY) * (double) Helper.getTimer().renderPartialTicks
							- ((IRenderManager) mc.getRenderManager()).getRenderPosY();

					double z1 = entity.lastTickPosZ
							+ (entity.posZ - entity.lastTickPosZ) * (double) Helper.getTimer().renderPartialTicks
							- ((IRenderManager) mc.getRenderManager()).getRenderPosZ();

					double width = entity.getEntityBoundingBox().maxX - entity.getEntityBoundingBox().minX - 0.2;
					double height = entity.getEntityBoundingBox().maxY - entity.getEntityBoundingBox().minY + 0.15;
					float red = 10 - entity.hurtTime * 5 / 255.0f;
					float green = entity.hurtTime * 10 / 255.0f;
					float blue = entity.hurtTime * 2 / 255.0f;
					float alpha = (float) (80 + entity.hurtTime * 10) / 350.0f;

					float alpha2 = (float) (80 + entity.hurtTime * 10) / 500.0f;
					int maxSize = maxTargets.getValue().intValue();
					if (multi.getValue() && targetList.size() > maxSize) {
						targetList.subList(maxSize, targetList.size()).clear();
					}
					if (entity.hurtTime >= 1) {
						RenderUtil.drawEntityESP(x1, y1, z1, width, height, red, green, blue, alpha, 0.1f, 0.1f, 0.1f,
								0.1f, 0.1f);
					} else {
						RenderUtil.drawEntityESP(x1, y1, z1, width, height, red, green, blue, alpha2, 0.1f, 0.1f, 0.1f,
								0.1f, 0.1f);
					}
				}
			} else {
				EntityLivingBase entity = target;
				double x1 = entity.lastTickPosX
						+ (entity.posX - entity.lastTickPosX) * (double) Helper.getTimer().renderPartialTicks
						- ((IRenderManager) mc.getRenderManager()).getRenderPosX();

				double y1 = entity.lastTickPosY
						+ (entity.posY - entity.lastTickPosY) * (double) Helper.getTimer().renderPartialTicks
						- ((IRenderManager) mc.getRenderManager()).getRenderPosY();

				double z1 = entity.lastTickPosZ
						+ (entity.posZ - entity.lastTickPosZ) * (double) Helper.getTimer().renderPartialTicks
						- ((IRenderManager) mc.getRenderManager()).getRenderPosZ();

				double width = entity.getEntityBoundingBox().maxX - entity.getEntityBoundingBox().minX - 0.2;
				double height = entity.getEntityBoundingBox().maxY - entity.getEntityBoundingBox().minY + 0.15;
				float red = 10 - entity.hurtTime * 5 / 255.0f;
				float green = entity.hurtTime * 10 / 255.0f;
				float blue = entity.hurtTime * 2 / 255.0f;
				float alpha = (float) (80 + entity.hurtTime * 10) / 350.0f;

				float alpha2 = (float) (80 + entity.hurtTime * 10) / 500.0f;
				if (entity.hurtTime >= 1) {
					RenderUtil.drawEntityESP(x1, y1, z1, width, height, red, green, blue, alpha, 0.1f, 0.1f, 0.1f, 0.1f,
							0.1f);
				} else {
					RenderUtil.drawEntityESP(x1, y1, z1, width, height, red, green, blue, alpha2, 0.1f, 0.1f, 0.1f,
							0.1f, 0.1f);
				}
			}
		}
	}

	// Target
	private boolean isAutismShopKeeperCheck(final Entity entity) {
		final IChatComponent displayName = entity.getDisplayName();
		final String formattedText = displayName.getFormattedText();
		displayName.getUnformattedText();
		final boolean b = !formattedText.substring(0, formattedText.length() - 2).contains("§");
		final boolean contains = formattedText.substring(formattedText.length() - 2).contains("§");
		return b && contains;
	}

	private boolean getEntityValidBlock(EntityLivingBase entity) {
		Teams te = (Teams) ModuleManager.getModuleByClass(Teams.class);
		AntiBot ab = (AntiBot) ModuleManager.getModuleByClass(AntiBot.class);
		if (!mc.thePlayer.isEntityAlive() || mc.thePlayer.isPlayerSleeping() || mc.thePlayer.isDead
				|| mc.thePlayer.getHealth() <= 0 || Teams.isOnSameTeam(entity)
				|| (double) mc.thePlayer.getDistanceToEntity(entity) >= attackRangeValue.getValue().floatValue()
				|| !entity.isEntityAlive() || entity.isDead || entity.getHealth() <= 0
				|| entity instanceof EntityArmorStand || AntiBot.isBot(entity) || this.isAutismShopKeeperCheck(entity)
				|| notInFov(entity) || entity == mc.thePlayer) {
			return false;
		}
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			if (player.getDisplayName().getFormattedText().contains("[NPC]"))
				return false;
			if (Client.getINSTANCE().getFileManager().friendsConfig.isFriend(player.getName()))
				return false;
			if (!playerValue.getValue())
				return false;
			if (player.isPlayerSleeping())
				return false;
			if (player.isPotionActive(Potion.invisibility) && !invisibleValue.getValue())
				return false;
		}
		if (entity instanceof EntityAnimal) {
			return animalValue.getValue();
		}
		if (entity instanceof EntityMob) {
			return monsterValue.getValue();
		}
		if (entity instanceof EntityVillager || entity instanceof EntityIronGolem || entity instanceof EntitySnowman) {
			return neutralValue.getValue();
		}
		return true;
	}

	public boolean getEntityValid(EntityLivingBase entity) {
		return getEntityValid(entity, true);
	}

	public boolean getEntityValid(EntityLivingBase entity, boolean blocking) {
		if (!mc.thePlayer.isEntityAlive() || mc.thePlayer.isPlayerSleeping() || mc.thePlayer.isDead
				|| mc.thePlayer.getHealth() <= 0 || Teams.isOnSameTeam(entity)
				|| (double) mc.thePlayer.getDistanceToEntity(entity) >= rangeValue.getValue().floatValue()
				|| !entity.isEntityAlive() || entity.isDead || entity.getHealth() <= 0
				|| entity instanceof EntityArmorStand || AntiBot.isBot(entity) || this.isAutismShopKeeperCheck(entity)
				|| notInFov(entity) || entity == mc.thePlayer) {
			return false;
		}
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			if (player.getDisplayName().getFormattedText().contains("[NPC]"))
				return false;
			if (Client.getINSTANCE().getFileManager().friendsConfig.isFriend(player.getName()))
				return false;
			if (!playerValue.getValue())
				return false;
			if (player.isPlayerSleeping())
				return false;
			boolean wallChecks = blocking && (!throughWallValue.getValue()
					|| (double) mc.thePlayer.getDistanceToEntity(player) >= wallRangeValue.getValue().floatValue());
			if (!RotationUtil.canEntityBeSeen(player) && wallChecks)
				return false;
			if (player.isPotionActive(Potion.invisibility) && !invisibleValue.getValue())
				return false;
		}
		return canAttackEntity(entity);
	}

	public boolean hitBox(Entity entity) {
		if (!mc.thePlayer.isEntityAlive() || mc.thePlayer.isPlayerSleeping() || mc.thePlayer.isDead
				|| mc.thePlayer.getHealth() <= 0 || Teams.isOnSameTeam(entity) || !entity.isEntityAlive()
				|| entity.isDead || entity instanceof EntityArmorStand || AntiBot.isBot(entity)
				|| this.isAutismShopKeeperCheck(entity) || notInFov(entity) || entity == mc.thePlayer) {
			return false;
		}

		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			if (player.getDisplayName().getFormattedText().contains("[NPC]"))
				return false;
			if (Client.getINSTANCE().getFileManager().friendsConfig.isFriend(player.getName()))
				return false;
			if (!playerValue.getValue())
				return false;
			if (player.isPlayerSleeping())
				return false;
			boolean wallChecks = blocking && (!throughWallValue.getValue()
					|| (double) mc.thePlayer.getDistanceToEntity(player) >= wallRangeValue.getValue().floatValue());
			if (!RotationUtil.canEntityBeSeen(player) && wallChecks)
				return false;
			if (player.isPotionActive(Potion.invisibility) && !invisibleValue.getValue())
				return false;
		}

		return canAttackEntity(entity);
	}

	private boolean hasSword(EntityPlayer playerIn) {
		return playerIn.inventory.getCurrentItem() != null
				&& playerIn.inventory.getCurrentItem().getItem() instanceof ItemSword;
	}

	private boolean hasBlock(EntityPlayer playerIn) {
		return playerIn.inventory.getCurrentItem() != null
				&& playerIn.inventory.getCurrentItem().getItem() instanceof ItemBlock;
	}

	public boolean notInFovrender(Entity entity) {
		return !(Math.abs(
				RotationUtil.getYawDifference(mc.thePlayer.rotationYaw, entity.posX, entity.posY, entity.posZ)) <= 100);
	}

	private boolean notInFov(Entity entity) {
		return !(Math.abs(RotationUtil.getYawDifference(mc.thePlayer.rotationYaw, entity.posX, entity.posY,
				entity.posZ)) <= fovValue.getValue().floatValue());
	}

	private void draw2Shadow(final Entity entity, final double rad, final int color, final boolean shade) {
		GL11.glPushMatrix();
		GL11.glDisable(3553);
		GL11.glEnable(2848);
		GL11.glEnable(2832);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glHint(3154, 4354);
		GL11.glHint(3155, 4354);
		GL11.glHint(3153, 4354);
		GL11.glDepthMask(false);
		GlStateManager.alphaFunc(GL11.GL_GREATER, 0.0F);
		if (shade)
			GL11.glShadeModel(GL11.GL_SMOOTH);
		GlStateManager.disableCull();
		GL11.glBegin(GL11.GL_TRIANGLE_STRIP);

		final double x = entity.lastTickPosX
				+ (entity.posX - entity.lastTickPosX) * Helper.getTimer().renderPartialTicks
				- ((IRenderManager) mc.getRenderManager()).getRenderPosX();
		final double y = (entity.lastTickPosY
				+ (entity.posY - entity.lastTickPosY) * Helper.getTimer().renderPartialTicks
				- ((IRenderManager) mc.getRenderManager()).getRenderPosY())
				+ Math.sin(System.currentTimeMillis() / 2E+2) + 1;
		final double z = entity.lastTickPosZ
				+ (entity.posZ - entity.lastTickPosZ) * Helper.getTimer().renderPartialTicks
				- ((IRenderManager) mc.getRenderManager()).getRenderPosZ();

		Color c;
		Color c2;
		for (float i = 0; i < Math.PI * 2; i += Math.PI * 2 / 64.F) {
			final double vecX = x + rad * Math.cos(i);
			final double vecZ = z + rad * Math.sin(i);

			c = new Color(HUD.colorValue.getValue());
			c2 = new Color(HUD.colorValue.getValue());
			if (shade) {
				GL11.glColor4f(c.getRed() / 255.F, c.getGreen() / 255.F, c.getBlue() / 255.F, 0);
				GL11.glVertex3d(vecX, y - Math.cos(System.currentTimeMillis() / 2E+2) / 2.6F, vecZ);
				GL11.glColor4f(c2.getRed() / 255.F, c2.getGreen() / 255.F, c2.getBlue() / 255.F, 0.85F);
			}
			GL11.glVertex3d(vecX, y, vecZ);
		}

		GL11.glEnd();
		if (shade)
			GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glDepthMask(true);
		GL11.glEnable(2929);
		GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1F);
		GlStateManager.enableCull();
		GL11.glDisable(2848);
		GL11.glDisable(2848);
		GL11.glEnable(2832);
		GL11.glEnable(3553);
		GL11.glPopMatrix();
		GL11.glColor3f(255, 255, 255);
	}

	public float[] getRotation(EntityLivingBase ent) {
		double y;
		final double x = ent.posX;
		final double z = ent.posZ;
		if (ent instanceof EntityEnderman) {
			y = ent.posY - mc.thePlayer.posY;
		} else {
			double targetY = (double) mc.thePlayer.getEyeHeight() - (1.65 + heightProperty.getValue().doubleValue());
			y = ent.posY + (double) ent.getEyeHeight() - 1.5 < mc.thePlayer.posY + targetY
					? ent.posY + (double) ent.getEyeHeight() - mc.thePlayer.posY
							+ ((double) mc.thePlayer.getEyeHeight() - 3.0)
					: (ent.posY - 1.5 > mc.thePlayer.posY + targetY
							? ent.posY - 3.0 - mc.thePlayer.posY + (double) mc.thePlayer.getEyeHeight()
							: targetY);
		}
		return getRotationsToPos(x, z, y);
	}

	public float[] getRotationsToPos(double x, double z, double y) {
		final double diffX = x - mc.thePlayer.posX;
		final double diffZ = z - mc.thePlayer.posZ;
		final double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
		float yaw = (float) (Math.atan2(diffZ, diffX) * 180.0 / Math.PI) - 90.0f;
		float pitch = (float) (-(Math.atan2(y, dist) * 180.0 / Math.PI));
		return new float[] { yaw, pitch };
	}

	private double yawDist(EntityLivingBase e) {
		final Vec3 difference = e.getPositionVector().addVector(0.0, e.getEyeHeight() / 2.0f, 0.0)
				.subtract(mc.thePlayer.getPositionVector().addVector(0.0, mc.thePlayer.getEyeHeight(), 0.0));
		final double d = Math.abs(
				mc.thePlayer.rotationYaw - (Math.toDegrees(Math.atan2(difference.zCoord, difference.xCoord)) - 90.0f))
				% 360.0f;
		return (d > 180.0f) ? (360.0f - d) : d;
	}

	private float[] Zenith(float[] dst, float[] src) {
		float[] smoothedAngle = cahgnle(new float[] { src[0] - dst[0], src[1] - dst[1] });
		float horizontalSpeed = Objects.equals(mode.getValue(), "Switch") ? random(180.0f, 180.0f)
				: random(15.0F, 25.0F);
		float verticalSpeed = Objects.equals(mode.getValue(), "Switch") ? random(180.0f, 180.0f) : random(25.0f, 35.0f);
		if (target != null) {
			for (MovingObjectPosition obj : this.rayCastByRotation(src[0], src[1])) {
				if (obj.entityHit != null && obj.entityHit != mc.thePlayer
						&& getEntityValid((EntityLivingBase) obj.entityHit)) {
					verticalSpeed = (float) ((double) verticalSpeed * 0.3D);
					break;
				}
			}
		}
		smoothedAngle[0] = src[0] - smoothedAngle[0] / 180.0F * (horizontalSpeed / 2.0F);
		smoothedAngle[1] = src[1];
		smoothedAngle[0] = RotationUtil.changeRotation(smoothedAngle[0], dst[0], horizontalSpeed);
		smoothedAngle[1] = RotationUtil.changeRotation(smoothedAngle[1], Math.max(Math.min(dst[1], 90.0F), -90.0F),
				verticalSpeed);
		return smoothedAngle;
	}

	public java.util.List<MovingObjectPosition> rayCastByRotation(float yaw, float pitch) {
		ArrayList<MovingObjectPosition> targets1 = new ArrayList<MovingObjectPosition>();
		Entity entity = mc.getRenderViewEntity();

		if (entity != null && mc.theWorld != null) {
			float reach = target.getCollisionBorderSize();
			float f = 1.0F;
			Vec3 eyeVec = entity.getPositionEyes(1.0F);
			Vec3 lookVec = getVectorForRotation(yaw, pitch);
			Vec3 vec32 = eyeVec.addVector(lookVec.xCoord * (double) reach, lookVec.yCoord * (double) reach,
					lookVec.zCoord * (double) reach);

			List<Entity> list = mc.theWorld.getEntitiesInAABBexcluding(entity,
					entity.getEntityBoundingBox()
							.addCoord(lookVec.xCoord * (double) reach, lookVec.yCoord * (double) reach,
									lookVec.zCoord * (double) reach)
							.expand(f, f, f),
					Predicates.and(EntitySelectors.NOT_SPECTATING, Entity::canBeCollidedWith));

			for (Entity entity1 : list) {
				float f1 = entity1.getCollisionBorderSize();
				AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().expand(f1, f1, f1);
				MovingObjectPosition movingobjectposition = axisalignedbb.calculateIntercept(eyeVec, vec32);
				if (movingobjectposition != null) {
					movingobjectposition.entityHit = entity1;
					targets1.add(new MovingObjectPosition(entity1, movingobjectposition.hitVec));
				}
			}
		}

		if (entity != null) {
			targets1.sort((o1, o2) -> {
				Vec3 eyeVec = entity.getPositionEyes(1.0F);
				return (int) ((eyeVec.distanceTo(o1.hitVec) - eyeVec.distanceTo(o2.hitVec)) * 100.0);
			});
		}
		return targets1;
	}

	public float[] getExhRotations(Entity entity) {
		if (entity == null) {
			return null;
		}
		Minecraft.getMinecraft();
		double diffX = entity.posX - mc.thePlayer.posX;
		Minecraft.getMinecraft();
		double diffZ = entity.posZ - mc.thePlayer.posZ;
		double diffY;

		diffY = entity.posY - (mc.thePlayer.posY + (double) mc.thePlayer.getEyeHeight())
				+ heightProperty.getValue().doubleValue();

		double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
		float yaw = (float) (Math.atan2(diffZ, diffX) * 180.0 / 3.141592653589793) - 90.0f;
		float pitch = (float) (-Math.atan2(diffY, dist) * 180.0 / 3.141592653589793);
		return new float[] { yaw, pitch };
	}

	public static float[] getRotations(final Entity entity) {
		if (entity == null) {
			return null;
		}
		final double diffX = entity.posX - Minecraft.getMinecraft().thePlayer.posX;
		final double diffZ = entity.posZ - Minecraft.getMinecraft().thePlayer.posZ;
		double diffY;
		if (entity instanceof EntityLivingBase) {
			final EntityLivingBase elb = (EntityLivingBase) entity;
			diffY = elb.posY + (elb.getEyeHeight())
					- (Minecraft.getMinecraft().thePlayer.posY + Minecraft.getMinecraft().thePlayer.getEyeHeight());
		} else {
			diffY = (entity.getEntityBoundingBox().minY + entity.getEntityBoundingBox().maxY) / 2.0
					- (Minecraft.getMinecraft().thePlayer.posY + Minecraft.getMinecraft().thePlayer.getEyeHeight());
		}
		final double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
		final float yaw = (float) (Math.atan2(diffZ, diffX) * 180.0 / Math.PI) - 90.0f;
		final float pitch = (float) (-(Math.atan2(diffY, dist) * 180.0 / Math.PI));
		return new float[] { yaw, pitch };
	}

	public static float getDistanceBetweenAngles(float angle1, float angle2) {
		float angle3 = Math.abs((angle1 - angle2)) % 360.0f;
		if (angle3 > 180.0f) {
			angle3 = 0.0f;
		}
		return angle3;
	}

	public float[] getRotationsNeededBlock(double x, double y, double z) {
		double diffX = x + 0.5 - Minecraft.getMinecraft().thePlayer.posX;
		double diffZ = z + 0.5 - Minecraft.getMinecraft().thePlayer.posZ;
		double diffY = y - Minecraft.getMinecraft().thePlayer.posY - 0.2;

		double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
		float yaw = (float) (Math.atan2(diffZ, diffX) * 180.0 / 3.141592653589793) - 90.0f;
		float pitch = (float) (-Math.atan2(diffY, dist) * 180.0 / 3.141592653589793);
		return new float[] {
				Minecraft.getMinecraft().thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(yaw - 180f),
				Minecraft.getMinecraft().thePlayer.rotationPitch
						+ MathHelper.wrapAngleTo180_float(pitch - Minecraft.getMinecraft().thePlayer.rotationPitch) };

	}

	private static int randomNumber(double min, double max) {
		Random random = new Random();
		return (int) (min + (random.nextDouble() * (max - min)));
	}

	public float[] ExgetHypixelRotationsNeededBlock(double x2, double y2, double z2) {
		double diffX = x2 + 0.5 - Minecraft.getMinecraft().thePlayer.posX;
		double diffZ = z2 + 0.5 - Minecraft.getMinecraft().thePlayer.posZ;
		double diffY = y2 - Minecraft.getMinecraft().thePlayer.posY - 0.2;
		double dist = (double) MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
		float yaw = (float) (Math.atan2(diffZ, diffX) * 180.0 / 3.141592653589793) - 90.0f;
		float pitch = (float) (-Math.atan2(diffY, dist) * 180.0 / 3.141592653589793);
		float[] arrf = new float[2];
		Minecraft.getMinecraft();
		arrf[0] = mc.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(yaw - 180F);
		Minecraft.getMinecraft();
		Minecraft.getMinecraft();
		arrf[1] = mc.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(pitch - mc.thePlayer.rotationPitch);
		return arrf;
	}

	public static float[] ExgetRotationFromPosition(double x, double z, double y) {
		double xDiff = x - Minecraft.getMinecraft().thePlayer.posX;
		double zDiff = z - Minecraft.getMinecraft().thePlayer.posZ;
		double yDiff = y - Minecraft.getMinecraft().thePlayer.posY - 1.2D;
		double dist = (double) MathHelper.sqrt_double(xDiff * xDiff + zDiff * zDiff);
		float yaw = (float) (Math.atan2(zDiff, xDiff) * 180.0D / 3.141592653589793D) - 90.0F;
		float pitch = (float) (-(Math.atan2(yDiff, dist) * 180.0D / 3.141592653589793D));
		return new float[] { yaw, pitch };
	}

	public boolean isEntityNearbyAttack() {
		return mc.thePlayer.getDistanceToEntity(getTarget()) <= rangeValue.getValue().floatValue();
	}
}