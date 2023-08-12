package linxiu.module.modules.uhc;

import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender3D;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.events.world.EventUpdate;
import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.combat.AntiBot;
import linxiu.module.modules.player.Teams;
import linxiu.utils.RandomUtil;
import linxiu.utils.RotationHook;
import linxiu.utils.RotationUtils;
import linxiu.utils.math.RotationUtil;
import linxiu.utils.timer.TimeHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

public class BowAimBot extends Module {
	private Entity curEntity;
	float yaw, pitch;
	final TimeHelper timeHelper = new TimeHelper();
	private final Mode mode = new Mode("Mode", new String[] { "Angle", "Armor", "Range", "Fov", "Health", "HurtTime" },
			"FOV");
	private final Option clamp = new Option("Clamp", false);
	private final Option silent = new Option("Silent", true);
	private final Option players = new Option("Players", true);
	private final Option animals = new Option("Animals", false);
	private final Option mobs = new Option("Mobs", false);
	private final Option invisibles = new Option("Invisibles", false);
	private final Option auto = new Option("Auto Release", true);
	private final Option prediction = new Option("Prediction", false);
	public Numbers<Number> range = new Numbers<Number>("Range", 70.0, 1.0, 150.0, 0.1);
	public Numbers<Number> fov = new Numbers<Number>("Fov", 90.0, 1.0, 360.0, 0.1);

	public BowAimBot() {
		super("BowAimbot", new String[] { "bow", "bowaim", "bowaimbot" }, ModuleType.Combat);
	}

	@EventHandler
	private void onUpdate(EventPreUpdate event) {
		if (silent.getValue() && allowAiming(mc.thePlayer)) {
			if (!Float.isNaN(pitch)) {
				event.setYaw(yaw);
				event.setPitch(pitch);
			}
		}
	}

	@EventHandler
	private void onUpdate(EventUpdate event) {
		if (!silent.getValue() && allowAiming(mc.thePlayer)) {
			mc.thePlayer.rotationYaw = yaw;
			mc.thePlayer.rotationPitch = pitch;
		}
	}

	@EventHandler
	private void onRender(EventRender3D event) {
		Entity entity = getClosestEntity();
		curEntity = entity;
		if (isUsing(mc.thePlayer)) {
			if (entity != null && entity != mc.thePlayer) {
				final double deltaX = entity.posX - mc.thePlayer.posX;
				double deltaY = (entity.posY + entity.getEyeHeight())
						- (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());
				final double deltaZ = entity.posZ - mc.thePlayer.posZ;

				if (!(entity instanceof EntityPlayer))
					deltaY = (entity.posY + entity.getEyeHeight()) - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());

				final double x = MathHelper.sqrt_double(deltaX * deltaX + deltaZ * deltaZ); // distance
				final double v = getVelocity();
				final double g = getGravity();

				float pitch = getProjectileMotion(v, g, x, deltaY);
				float[] rotations = facePlayer(entity, false, false, false, prediction.getValue(), true,
						false, 0, clamp.getValue(), 180, 6, false, 0);
				pitch = MathHelper.clamp_float(pitch, -90, 90);

				yaw = rotations[0];
				this.pitch = pitch;

				if (v == 1F && auto.getValue()) {
					if (timeHelper.hasReached(200))
						mc.playerController.onStoppedUsingItem(mc.thePlayer);
				} else if (auto.getValue()) {
					timeHelper.reset();
				}

			}
		}
	}

	public static float getProjectileMotion(double velocity, double gravity, double x, double y) {
		return (float) -Math.toDegrees(Math.atan2(
				Math.pow(velocity, 2) - Math.sqrt(
						Math.pow(velocity, 4) - gravity * (gravity * Math.pow(x, 2) + 2 * y * Math.pow(velocity, 2))),
				gravity * x));
	}

	private boolean allowAiming(EntityPlayer player) {
		return isUsing(player) && curEntity != null;
	}

	public boolean isUsing(EntityPlayer player) {
		return player.isUsingItem() && mc.thePlayer.getCurrentEquippedItem() != null
				&& mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemBow;
	}

	private EntityLivingBase getClosestEntity() {
		Stream<EntityLivingBase> stream = mc.theWorld.loadedEntityList.stream()
				.filter(entity -> entity instanceof EntityLivingBase).map(entity -> (EntityLivingBase) entity)
				.filter(this::getEntityValid);

		switch (this.mode.getValue()) {
		case "Armor": {
			stream = stream.sorted(Comparator
					.comparingInt(o -> ((o instanceof EntityPlayer ? ((EntityPlayer) o).inventory.getTotalArmorValue()
							: (int) o.getHealth()))));
			break;
		}
		case "Range": {
			stream = stream.sorted(
					(o1, o2) -> (int) (o1.getDistanceToEntity(mc.thePlayer) - o2.getDistanceToEntity(mc.thePlayer)));
			break;
		}
		case "Fov": {
			stream = stream.sorted(Comparator
					.comparingDouble(o -> getDistanceBetweenAngles(mc.thePlayer.rotationPitch, getRotations(o)[0])));
			break;
		}
		case "Angle": {
			stream = stream.sorted((o1, o2) -> {
				float[] rot1 = getRotations(o1);
				float[] rot2 = getRotations(o2);
				return (int) (mc.thePlayer.rotationYaw - rot1[0] - (mc.thePlayer.rotationYaw - rot2[0]));
			});
			break;
		}
		case "Health": {
			stream = stream.sorted((o1, o2) -> (int) (o1.getHealth() - o2.getHealth()));
			break;
		}
		case "HurtTime": {
			stream = stream.sorted(Comparator.comparingInt(o -> (20 - o.hurtResistantTime)));
		}
		}
		return stream.findFirst().orElse(null);
	}

	private static float getDistanceBetweenAngles(float angle1, float angle2) {
		float angle3 = Math.abs((angle1 - angle2)) % 360.0f;
		if (angle3 > 180.0f) {
			angle3 = 0.0f;
		}
		return angle3;
	}

	private boolean notInFov(Entity entity) {
		return !(Math.abs(RotationUtil.getYawDifference(mc.thePlayer.rotationYaw, entity.posX, entity.posY,
				entity.posZ)) <= fov.getValue().floatValue());
	}

	public boolean getEntityValid(EntityLivingBase entity) {
		if (!mc.thePlayer.isEntityAlive() || mc.thePlayer.isPlayerSleeping() || mc.thePlayer.isDead
				|| mc.thePlayer.getHealth() <= 0 || Teams.isOnSameTeam(entity)
				|| (double) mc.thePlayer.getDistanceToEntity(entity) >= range.getValue().floatValue()
				|| !entity.isEntityAlive() || entity.isDead || entity.getHealth() <= 0
				|| entity instanceof EntityArmorStand || AntiBot.isBot(entity) || notInFov(entity)
				|| entity == mc.thePlayer) {
			return false;
		}
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			if (Client.getINSTANCE().getFileManager().friendsConfig.isFriend(player.getName()))
				return false;
			if (!players.getValue())
				return false;
			if (player.isPlayerSleeping())
				return false;
			if (!RotationUtil.canEntityBeSeen(player))
				return false;
			if (player.isPotionActive(Potion.invisibility) && !invisibles.getValue())
				return false;
		}

		if (entity instanceof EntityAnimal) {
			return animals.getValue();
		}
		if (entity instanceof EntityMob) {
			return mobs.getValue();
		}
		return true;
	}

	private double getArmorVal(EntityLivingBase ent) {
		if (ent instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) ent;
			double armorstrength = 0;
			for (int index = 3; index >= 0; index--) {
				ItemStack stack = player.inventory.armorInventory[index];
				if (stack != null) {
					armorstrength += getArmorStrength(stack);
				}
			}
			return armorstrength;
		}
		return 0;
	}

	private double getVelocity() {
		int i = mc.thePlayer.getCurrentEquippedItem().getMaxItemUseDuration() - mc.thePlayer.getItemInUseCount();

		float f = (float) i / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;

		if (f > 1.0F) {
			f = 1.0F;
		}
		return f;
	}

	private double getGravity() {
		return 0.006;
	}

	private static float[] getRotations(final Entity entity) {
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

	private double getArmorStrength(final ItemStack itemStack) {
		if (!(itemStack.getItem() instanceof ItemArmor))
			return -1;
		float damageReduction = ((ItemArmor) itemStack.getItem()).damageReduceAmount;
		Map enchantments = EnchantmentHelper.getEnchantments(itemStack);
		if (enchantments.containsKey(Enchantment.protection.effectId)) {
			int level = (int) enchantments.get(Enchantment.protection.effectId);
			damageReduction += Enchantment.protection.calcModifierDamage(level, DamageSource.generic);
		}
		return damageReduction;
	}

	private double yawDist(EntityLivingBase e) {
		final Vec3 difference = e.getPositionVector().addVector(0.0, e.getEyeHeight() / 2.0f, 0.0)
				.subtract(mc.thePlayer.getPositionVector().addVector(0.0, mc.thePlayer.getEyeHeight(), 0.0));
		final double d = Math.abs(
				mc.thePlayer.rotationYaw - (Math.toDegrees(Math.atan2(difference.zCoord, difference.xCoord)) - 90.0f))
				% 360.0f;
		return (d > 180.0f) ? (360.0f - d) : d;
	}

	private double yawDistCycle(EntityLivingBase e, float yaw) {
		final Vec3 difference = e.getPositionVector().addVector(0.0, e.getEyeHeight() / 2.0f, 0.0)
				.subtract(mc.thePlayer.getPositionVector().addVector(0.0, mc.thePlayer.getEyeHeight(), 0.0));
		final double d = Math.abs(yaw - Math.atan2(difference.zCoord, difference.xCoord)) % 90.0f;
		return d;
	}

	public float[] facePlayer(Entity e, boolean a3, boolean heuristics, boolean smooth, boolean prediction,
			boolean mouseFix, boolean bestVector, double inaccuracy, boolean clampYaw, float rotationSpeed,
			double range, boolean custom, int customRange) {
		final RandomUtil randomUtil = RandomUtil.getInstance();

		final double eyeX = (mc.thePlayer.getEntityBoundingBox().minX + mc.thePlayer.getEntityBoundingBox().maxX) / 2;
		final double eyeY = mc.thePlayer.getEntityBoundingBox().minY + mc.thePlayer.getEyeHeight();
		final double eyeZ = (mc.thePlayer.getEntityBoundingBox().minZ + mc.thePlayer.getEntityBoundingBox().maxZ) / 2;

		double x = e.posX - eyeX;
		double y = e.posY + e.getEyeHeight() - eyeY;
		double z = e.posZ - eyeZ;

		if (bestVector) {
			final Vec3 bestVec = getBestVector(mc.thePlayer.getPositionEyes(mc.timer.renderPartialTicks),
					e.getEntityBoundingBox()).addVector(-inaccuracy / 10, -inaccuracy / 10, -inaccuracy / 10);
			x = bestVec.xCoord - eyeX;
			y = bestVec.yCoord - eyeY;
			z = bestVec.zCoord - eyeZ;
		}

		if (!(e instanceof EntityLivingBase)) {
			y = (e.getEntityBoundingBox().minY + e.getEntityBoundingBox().maxY) / 2.0D
					- (mc.thePlayer.getEntityBoundingBox().minY + (double) mc.thePlayer.getEyeHeight());
		}

		if (custom)
			y *= customRange * 0.02;

		if (heuristics) {
			final float randomPitch = (float) MathHelper.getRandomDoubleInRange(new Random(), 0.015, 0.018);
			float randomizedPitch = (float) MathHelper.getRandomDoubleInRange(new Random(), 0.010, randomPitch);
			float randomizedYaw = (float) MathHelper.getRandomDoubleInRange(new Random(), -0.1, -0.3);
			x += randomUtil.getRandomDouble(-randomizedPitch, randomizedPitch);
			z += randomUtil.getRandomDouble(-randomizedPitch, randomizedPitch);
			y += randomUtil.getRandomDouble(randomizedYaw, -0.01);
		}

		if (prediction) {
			boolean sprinting = e.isSprinting();
			boolean sprintingPlayer = mc.thePlayer.isSprinting();

			float walkingSpeed = 0.10000000149011612f; // https://minecraft.fandom.com/wiki/Sprinting

			float sprintMultiplication = sprinting ? 1.25f : walkingSpeed;
			float sprintMultiplicationPlayer = sprintingPlayer ? 1.25f : walkingSpeed;

			float xMultiplication = (float) ((e.posX - e.prevPosX) * sprintMultiplication);
			float zMultiplication = (float) ((e.posZ - e.prevPosZ) * sprintMultiplication);

			float xMultiplicationPlayer = (float) ((mc.thePlayer.posX - mc.thePlayer.prevPosX)
					* sprintMultiplicationPlayer);
			float zMultiplicationPlayer = (float) ((mc.thePlayer.posZ - mc.thePlayer.prevPosZ)
					* sprintMultiplicationPlayer);

			if (xMultiplication != 0.0f && zMultiplication != 0.0f
					|| xMultiplicationPlayer != 0.0f && zMultiplicationPlayer != 0.0f) {
				x += xMultiplication + xMultiplicationPlayer;
				z += zMultiplication + zMultiplicationPlayer;
			}
		}

		double angle = MathHelper.sqrt_double(x * x + z * z);

		float yawAngle = (float) (MathHelper.atan2(z, x) * 180.0D / Math.PI) - 90.0F;
		float pitchAngle = (float) (-(MathHelper.atan2(y, angle) * 180.0D / Math.PI));

		double rangeToEntity = mc.thePlayer.getDistanceToEntity(e);
		double rangeSetting = range + 1;

		double rotationDelta = Math.hypot(RotationHook.yaw - yawAngle, RotationHook.pitch - pitchAngle);
		double speed = rotationDelta * ((rangeSetting - rangeToEntity) / rangeSetting);

		float yaw = clampYaw ? yawAngle
				: updateRotation(RotationHook.yaw, yawAngle, smooth ? MathHelper.abs((float) speed) : rotationSpeed);
		float pitch = updateRotation(RotationHook.pitch, pitchAngle,
				smooth ? MathHelper.abs((float) speed) : rotationSpeed);

		if (!mouseFix)
			return new float[] { yaw, clampPitch(pitch) };
		final float[] mouseSensitivity = applyMouseSensitivity(yaw, pitch, a3);

		return new float[] { mouseSensitivity[0], clampPitch(mouseSensitivity[1]) };
	}

	public Vec3 getBestVector(Vec3 look, AxisAlignedBB axisAlignedBB) {
		return new Vec3(MathHelper.clamp_double(look.xCoord, axisAlignedBB.minX, axisAlignedBB.maxX),
				MathHelper.clamp_double(look.yCoord, axisAlignedBB.minY, axisAlignedBB.maxY),
				MathHelper.clamp_double(look.zCoord, axisAlignedBB.minZ, axisAlignedBB.maxZ));
	}

	public float clampPitch(float pitch) {
		return MathHelper.clamp_float(pitch, -90, 90);
	}

	public float[] applyMouseSensitivity(float yaw, float pitch, boolean a3) {
		float sensitivity = mc.gameSettings.mouseSensitivity;
		if (sensitivity == 0) {
			sensitivity = 0.0070422534F; // 1% Sensitivity <- to fix 0.0 sensitivity
		}
		sensitivity = Math.max(0.1F, sensitivity);
		int deltaYaw = (int) ((yaw - RotationHook.yaw) / (sensitivity / 2));
		int deltaPitch = (int) ((pitch - RotationHook.pitch) / (sensitivity / 2)) * -1;

		if (a3) {
			deltaYaw -= deltaYaw % 0.5 + 0.25;
			deltaPitch -= deltaPitch % 0.5 + 0.25;
		}
		float f = sensitivity * 0.6F + 0.2F;
		float f1 = (float) (Math.pow(f, 3.0) * 8F);
		float f2 = (float) deltaYaw * f1;
		float f3 = (float) deltaPitch * f1;

		float endYaw = (float) ((double) RotationHook.yaw + (double) f2 * 0.15);
		float endPitch = (float) ((double) RotationHook.pitch - (double) f3 * 0.15);
		return new float[] { endYaw, endPitch };
	}

	float updateRotation(float currentRotation, float nextRotation, float rotationSpeed) {
		float f = MathHelper.wrapAngleTo180_float(nextRotation - currentRotation);
		if (f > rotationSpeed) {
			f = rotationSpeed;
		}
		if (f < -rotationSpeed) {
			f = -rotationSpeed;
		}
		return currentRotation + f;
	}
}