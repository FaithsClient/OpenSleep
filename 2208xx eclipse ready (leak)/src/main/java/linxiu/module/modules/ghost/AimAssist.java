package linxiu.module.modules.ghost;

import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.world.EventPreUpdate;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.combat.AntiBot;
import linxiu.module.modules.player.Teams;
import linxiu.utils.Helper;
import linxiu.utils.math.RotationUtil;
import linxiu.utils.timer.Timer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import org.lwjgl.input.Mouse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AimAssist extends Module {
	private static float yaw;
	private static float pitch;
	private static Entity target;
	private static List<Entity> targets = new ArrayList<>(0);

	private final Timer timer = new Timer();
	private final Comparator<Entity> angleComparator = Comparator
			.comparingDouble(entity -> getRotationsNeeded(entity)[0]);

	private int index;
	public static Numbers<Number> reach = new Numbers<Number>("Reach", 3.0D, 1.0D, 6.0D, 0.1D);
	public static Numbers<Number> aimDelay = new Numbers<Number>("Aim Delay", 0.0D, 0.0D, 1000.0D, 50.0D);
	public static Numbers<Number> height = new Numbers<Number>("Height", 3.5D, -8.0D, 8.0D, 1.0D);
	public static Numbers<Number> horizontalLeft = new Numbers<Number>("Horizontal Left", 1.0D, 0.0D, 5.0D, 0.1D);
	public static Numbers<Number> horizontalRight = new Numbers<Number>("Horizontal Right", 1.0D, 0.0D, 5.0D, 0.1D);
	public static Numbers<Number> verticalUp = new Numbers<Number>("Vertical Up", 1.0D, 0.0D, 5.0D, 0.1D);
	public static Numbers<Number> verticalDown = new Numbers<Number>("Vertical Down", 1.0D, 0.0D, 5.0D, 0.1D);
	private static final Option onlyAxeSword = new Option("Only Sword/Axe", false);
	private static final Option rayTrace = new Option("Raytrace", false);
	private static final Option clickAim = new Option("Click Aim", false);

	public AimAssist() {
		super("AimAssist", new String[] { "AimAssist" }, ModuleType.Legit);
	}

	private List<Entity> loadTargets() {
		return this.mc.theWorld.getLoadedEntityList().stream()
				.filter(e -> this.mc.thePlayer.getDistanceToEntity(e) <= reach.getValue().floatValue() && this.qualifies(e))
				.sorted(Comparator.comparingDouble(o -> ((Entity) o).getDistanceToEntity(this.mc.thePlayer)).reversed())
				.collect(Collectors.toCollection(ArrayList::new));
	}

	private boolean qualifies(Entity entity) {
		Teams te = (Teams) ModuleManager.getModuleByClass(Teams.class);
		return entity != this.mc.thePlayer && !AntiBot.isBot(entity) && entity.isEntityAlive() && !Client.getINSTANCE().getFileManager().friendsConfig.isFriend(entity.getName())
				&& !Teams.isOnSameTeam(entity) && entity instanceof EntityPlayer;
	}

	@EventHandler
	private void onPreUpdate(EventPreUpdate event) {
		targets = this.loadTargets();
		targets.sort(this.angleComparator);

		if (target instanceof EntityPlayer || target instanceof EntityMob || target instanceof EntityAnimal) {
			target = null;
		}

		if (this.mc.thePlayer.ticksExisted % 50 == 0 && targets.size() > 1)
			++this.index;
		if (clickAim.getValue() && !Mouse.isButtonDown(0))
			return;

		if (!targets.isEmpty()) {
			if (this.index >= targets.size())
				this.index = 0;

			target = targets.get(this.index);
			final double[] rotationPosition = getRotationsNeeded(target);

			if (this.timer.delay(aimDelay.getValue().doubleValue())) {
				pitch = (float) (rotationPosition[1] + height.getValue().doubleValue());
				yaw = (float) rotationPosition[0];

				this.timer.reset();
			}

			final boolean notOnlyAxeSword = !onlyAxeSword.getValue();

			if (rayTrace.getValue()) {
				if (this.mc.thePlayer.canEntityBeSeen(target)
						&& (notOnlyAxeSword || this.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword
								|| this.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemAxe)) {
					aim();
				}
			} else if (notOnlyAxeSword) {
				aim();
			} else if (this.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword
					|| this.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemAxe) {
				aim();
			}
		}
	}

	private void aim() {
		final EntityPlayerSP player = this.mc.thePlayer;

		final float yaw = player.rotationYaw, // @off
				pitch = player.rotationPitch; // @on

		if (yaw < AimAssist.yaw) {
			player.rotationYaw += horizontalRight.getValue().floatValue();
		} else if (player.rotationYaw > AimAssist.yaw) {
			player.rotationYaw -= horizontalLeft.getValue().floatValue();
		}

		if (pitch < AimAssist.pitch) {
			player.rotationPitch += verticalDown.getValue().floatValue();
		} else if (player.rotationPitch > AimAssist.pitch) {
			player.rotationPitch -= verticalUp.getValue().floatValue();
		}
	}

	public static double[] getRotationsNeeded(Entity entity) {
		if (entity == null)
			return null;

		final EntityPlayerSP player = Helper.mc.thePlayer;
		final double diffX = entity.posX - player.posX, // @off
				diffY = entity.posY + entity.getEyeHeight() * 0.9
						- (player.posY + player.getEyeHeight()),
				diffZ = entity.posZ - player.posZ; // @on

		return RotationUtil.getDistance(diffX, diffZ, diffY);
	}
}
