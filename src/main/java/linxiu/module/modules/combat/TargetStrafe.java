package linxiu.module.modules.combat;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import javax.vecmath.Vector3d;

import linxiu.module.modules.movement.LegitSpeed;
import linxiu.module.modules.movement.Speed;
import net.minecraft.block.BlockAir;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Vec3;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;
import linxiu.Client;
import linxiu.api.EventHandler;
import linxiu.api.events.rendering.EventRender3D;
import linxiu.api.events.world.EventMove;
import linxiu.api.value.Mode;
import linxiu.api.value.Numbers;
import linxiu.api.value.Option;
import linxiu.management.ModuleManager;
import linxiu.module.Module;
import linxiu.module.ModuleType;
import linxiu.module.modules.combat.AntiBot;
import linxiu.module.modules.combat.KillAura;
import linxiu.module.modules.player.Teams;
import linxiu.module.modules.render.HUD;
import linxiu.utils.Helper;
import linxiu.utils.MoveUtils;
import linxiu.utils.PlayerUtil;
import linxiu.utils.PlayerUtils;
import linxiu.utils.RotationUtils;
import linxiu.utils.Timer;
import linxiu.utils.RotationUtils.Rotation;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;

import net.minecraft.block.BlockAir;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Vec3;

public class TargetStrafe extends Module {
	private static int myStrafe = 0;
	double lastDist = 0.0;
	private static boolean working;
	private final Mode modeValue = new Mode("Mode", new String[] { "Circle", "Points" }, "Points");

	private static final Option keepRangeValue = new Option("Keep Range", "Keep Range", true),
			renderValue = new Option("Render", "Render", false), pressValue = new Option("Press", "Press", true),
			GodmodValue = new Option("AutoF5", "AutoF5", true);

	private static final Numbers<Number> rangeValue = new Numbers<>("Range", "Range", 2.0, 0.0, 4.5, 0.1);
	private static final Numbers<Number> closeRangeValue = new Numbers<>("Close Range", "Close Range", 0.5, 0.0, 1.0,
			0.1);
	private int oldPer = mc.gameSettings.thirdPersonView;
	public double yLevel;
	boolean decreasing;

	public TargetStrafe() {
		super("Target Strafe", new String[] { "TargetStrafe" }, ModuleType.Combat);
	}

	@Override
	public void onEnable() {
		super.onEnable();
		working = false;
	}

	@EventHandler
	public void onRender3D(EventRender3D event) {
		if (canDraw()) {
			if (Objects.equals(modeValue.getValue(), "Points")) {
				this.renderCircle(KillAura.target, event.getPartialTicks(), rangeValue.getValue().floatValue(),
						new Color(HUD.colorValue.getValue()).getRGB());
			} else {
				drawESP(event);
			}
		}
	}

	public boolean canDraw() {
		AntiBot antibots = (AntiBot) Client.getModuleManager().getModuleByClass(AntiBot.class);
		return renderValue.getValue() && Client.getModuleManager().getModuleByClass(KillAura.class).isEnabled()
				&& KillAura.target != null && !antibots.isBot(KillAura.target)
				&& Client.getModuleManager().getModuleByClass(TargetStrafe.class).isEnabled();
	}

	private void drawESP(EventRender3D render) {
		esp(KillAura.target, render.getPartialTicks(), rangeValue.getValue().floatValue(),
				new Color(HUD.colorValue.getValue()).getRGB());
	}

	@EventHandler
	public void esp(Entity entity, float partialTicks, double rad, int color) {
		float points = 90F;
		GlStateManager.enableDepth();
		for (double il = 0; il < 4.9E-324; il += 4.9E-324) {
			GL11.glPushMatrix();
			GL11.glDisable(3553);
			GL11.glEnable(2848);
			GL11.glEnable(2881);
			GL11.glEnable(2832);
			GL11.glEnable(3042);
			GL11.glBlendFunc(770, 771);
			GL11.glHint(3154, 4354);
			GL11.glHint(3155, 4354);
			GL11.glHint(3153, 4354);
			GL11.glDisable(2929);
			GL11.glLineWidth(4.5f);
			GL11.glBegin(3);
			final double x = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * partialTicks
					- mc.getRenderManager().viewerPosX;
			final double y = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * partialTicks
					- mc.getRenderManager().viewerPosY;
			final double z = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * partialTicks
					- mc.getRenderManager().viewerPosZ;
			final double pix2 = 6.283185307179586;
			float speed = 5000f;
			float baseHue = System.currentTimeMillis() % (int) speed;
			while (baseHue > speed) {
				baseHue -= speed;
			}
			baseHue /= speed;
			for (int i = 0; i <= 90; ++i) {
				float max = ((float) i + (float) (il * 8)) / points;
				float hue = max + baseHue;
				while (hue > 1) {
					hue -= 1;
				}
				color(color);
				GL11.glVertex3d(x + rad * Math.cos(i * pix2 / 7), y + il, z + rad * Math.sin(i * pix2 / 7));
			}
			GL11.glEnd();
			GL11.glDepthMask(true);
			GL11.glEnable(2929);
			GL11.glDisable(2848);
			GL11.glDisable(2881);
			GL11.glEnable(2832);
			GL11.glEnable(3553);
			GL11.glPopMatrix();
			GlStateManager.color(255, 255, 255);
		}
	}

	public void renderCircle(EntityLivingBase entity, float partialTicks, float range, int color) {
		Teams te = (Teams) Client.getModuleManager().getModuleByClass(Teams.class);
		AntiBot ab = (AntiBot) Client.getModuleManager().getModuleByClass(AntiBot.class);
		GL11.glPushMatrix();
		mc.entityRenderer.disableLightmap();
		GL11.glDisable(3553);
		GL11.glEnable(3042);
		GL11.glBlendFunc(770, 771);
		GL11.glDisable(2929);
		GL11.glEnable(2848);
		GL11.glDepthMask(false);

		final double posX = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * partialTicks
				- mc.getRenderManager().viewerPosX;
		final double posY = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * partialTicks
				- mc.getRenderManager().viewerPosY;
		final double posZ = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * partialTicks
				- mc.getRenderManager().viewerPosZ;

		GL11.glPushMatrix();
		final double tau = 6.283185307179586;
		final double fans = 45.0;
		GL11.glLineWidth(2.0f);

		GL11.glEnable(GL11.GL_POINT_SMOOTH);
		GL11.glPointSize(7.0f);
		GL11.glBegin(GL11.GL_POINTS);
		for (int i = 0; i <= 90; ++i) {
			color(color);
			GL11.glVertex3d(posX + range * Math.cos(i * Math.PI * 2 / 45.0), posY,
					posZ + range * Math.sin(i * Math.PI * 2 / 45.0));
		}
		GL11.glEnd();

		GL11.glPopMatrix();

		GL11.glDepthMask(true);
		GL11.glDisable(2848);
		GL11.glEnable(2929);
		GL11.glDisable(3042);
		GL11.glEnable(3553);
		mc.entityRenderer.enableLightmap();
		GL11.glPopMatrix();
	}

	public static void color(int color) {
		float f = (float) (color >> 24 & 255) / 255.0f;
		float f1 = (float) (color >> 16 & 255) / 255.0f;
		float f2 = (float) (color >> 8 & 255) / 255.0f;
		float f3 = (float) (color & 255) / 255.0f;
		GL11.glColor4f((float) f1, (float) f2, (float) f3, (float) f);
	}

	@EventHandler
	public void TargetStraMove(EventMove e) {
		double xDist = e.getX();
		double zDist = e.getZ();
		lastDist = Math.sqrt(xDist * xDist + zDist * zDist);
		if (rangeValue.getValue().floatValue() <= 0)
			return;

		if (Client.getINSTANCE().getModuleManager().getModuleByClass(Speed.class).isEnabled()) {
			if (canStrafe()) {
				if (KillAura.target != null) {
					this.doingStrafe(e, lastDist - 0.02, PlayerUtils.getNeededRotations(KillAura.getTarget())[0],
							rangeValue.getValue().floatValue(), 1.0);
				}
			}
		}

		if (Client.getINSTANCE().getModuleManager().getModuleByClass(LegitSpeed.class).isEnabled()) {
			if (canStrafe()) {
				if (KillAura.target != null) {
					this.doingStrafe(e, lastDist - 0.02, PlayerUtils.getNeededRotations(KillAura.getTarget())[0],
							rangeValue.getValue().floatValue(), 1.0);
				}
			}
		}

		if (!GodmodValue.getValue())
			return;
		for (int i = 0; i <= mc.gameSettings.thirdPersonView; ++i) {
			if (canStrafe())
				mc.gameSettings.thirdPersonView = 4;
			else if (mc.gameSettings.thirdPersonView > 3)
				mc.gameSettings.thirdPersonView = oldPer;
		}
	}

	public static boolean doingStrafe(EventMove event, double moveSpeed, float pseudoYaw, float pseudoStrafe,
			double pseudoForward) {
		working = false;
		float yaw = pseudoYaw;
		double forward = pseudoForward;
		float strafe = pseudoStrafe;
		float strafe2 = 0f;
		check();

		strafe = myStrafe;

		if (forward != 0.0) {
			if (strafe > 0.0) {
				if (keepRangeValue.getValue() && getEnemyDistance() < rangeValue.getValue().floatValue()
						&& !(Minecraft.getMinecraft().thePlayer.isCollidedHorizontally
								|| checkVoid(KillAura.getTarget())))
					yaw += forward > 0 ? -canSize() : canSize();
				strafe2 += forward > 0 ? (-90 / getAlgorithm()) : (90 / getAlgorithm());
			} else if (strafe < 0.0) {
				if (keepRangeValue.getValue() && getEnemyDistance() < rangeValue.getValue().floatValue()
						&& !(Minecraft.getMinecraft().thePlayer.isCollidedHorizontally
								|| checkVoid(KillAura.getTarget())))
					yaw += forward > 0 ? canSize() : -canSize();
				strafe2 += forward > 0 ? (90 / getAlgorithm()) : (-90 / getAlgorithm());
			}
			strafe = 0;
			if (forward > 0.0) {
				forward = 1;
			} else if (forward < 0.0) {
				forward = -1;
			}
		}
		if (strafe > 0.0) {
			strafe = 1.0f;
		} else if (strafe < 0.0) {
			strafe = -1.0f;
		}

		double mx = Math.cos(Math.toRadians(yaw + 90.0 + strafe2));
		double mz = Math.sin(Math.toRadians(yaw + 90.0 + strafe2));
		event.x = forward * moveSpeed * mx + strafe * moveSpeed * mz;
		event.z = forward * moveSpeed * mz - strafe * moveSpeed * mx;
		working = true;
		return true;
	}

	public boolean canStrafe() {
		return Client.getModuleManager().getModuleByClass(TargetStrafe.class).isEnabled() && PlayerUtil.MovementInput()
				&& KillAura.getTarget() != null
				&& (!pressValue.getValue() || Keyboard.isKeyDown(mc.gameSettings.keyBindJump.getKeyCode()));
	}

	private static float canSize() {
		return (float) (60F / getEnemyDistance());
	}

	private static double getEnemyDistance() {
		return Minecraft.getMinecraft().thePlayer.getDistance(KillAura.getTarget().posX,
				Minecraft.getMinecraft().thePlayer.posY, KillAura.getTarget().posZ)
				+ closeRangeValue.getValue().floatValue() - 0.1;
	}

	private static float getAlgorithm() {
		return (float) Math.max((getEnemyDistance() - rangeValue.getValue().floatValue()), getEnemyDistance()
				- (getEnemyDistance() - rangeValue.getValue().floatValue() / (rangeValue.getValue().floatValue() * 2)));
	}

	private static void check() {
		if (Minecraft.getMinecraft().thePlayer.isCollidedHorizontally || checkVoid(KillAura.getTarget())) {
			if (myStrafe < 2)
				myStrafe += 1;
			else
				myStrafe = -1;
		}
		switch (myStrafe) {
		case 0:
			myStrafe = 1;
			break;
		case 2:
			myStrafe = -1;
			break;
		}
	}

	private static boolean checkVoid(EntityLivingBase entity) {
		for (int x = -1; x <= 0; ++x) {
			for (int z = -1; z <= 0; ++z) {
				if (isVoid(x, z, entity)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isVoid(int x, int z, EntityLivingBase entity) {
		if (Minecraft.getMinecraft().thePlayer.posY < 0)
			return true;
		int off = 0;
		while (off < entity.posY + 2) {
			AxisAlignedBB bb = entity.getEntityBoundingBox().offset(x, -off, z);
			if (Minecraft.getMinecraft().theWorld.getCollidingBoundingBoxes(entity, bb).isEmpty()) {
				off += 2;
				continue;
			}
			return false;
		}
		return true;
	}
}