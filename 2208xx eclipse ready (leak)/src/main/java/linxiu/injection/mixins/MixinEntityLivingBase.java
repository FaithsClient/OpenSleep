package linxiu.injection.mixins;

import linxiu.api.EventBus;
import linxiu.api.events.misc.EventJump;
import linxiu.api.events.rendering.EventLivingUpdate;
import linxiu.injection.interfaces.IEntityLivingBase;
import linxiu.management.ModuleManager;
import linxiu.module.modules.ghost.NoJumpDelay;
import linxiu.module.modules.megawalls.MwHelper;
import linxiu.module.modules.render.Animations;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityLivingBase.class)
public abstract class MixinEntityLivingBase extends Entity implements IEntityLivingBase {
	public float rotationPitchHead;

	public float prevRotationPitchHead;

	public MixinEntityLivingBase() {
		super(null);
	}

	@Shadow
	private int jumpTicks;
	@Shadow
	protected int newPosRotationIncrements;
	@Shadow
	protected double newPosX;
	@Shadow
	protected double newPosY;
	@Shadow
	protected double newPosZ;
	@Shadow
	protected double newRotationYaw;
	@Shadow
	protected double newRotationPitch;
	@Shadow
	public boolean isJumping;
	@Shadow
	public float moveStrafing;
	@Shadow
	public float moveForward;
	@Shadow
	protected float randomYawVelocity;

	@Shadow
	protected abstract float getJumpUpwardsMotion();

	@Shadow
	public abstract boolean isServerWorld();

	@Shadow
	protected abstract boolean isMovementBlocked();

	@Shadow
	protected abstract void updateAITick();

	@Shadow
	protected abstract void handleJumpLava();

	@Shadow
	protected abstract void updateEntityActionState();

	@Shadow
	protected abstract void collideWithNearbyEntities();

	@Shadow
	public abstract PotionEffect getActivePotionEffect(Potion potionIn);

	@Shadow
	public abstract boolean isPotionActive(Potion potionIn);
	
	@Shadow
	public abstract void moveEntityWithHeading(float strafe, float forward);

	@Override
	public int runGetArmSwingAnimationEnd() {
		return this.getArmSwingAnimationEnd();
	}

	@Override
	public int getJumpTicks() {
		return jumpTicks;
	}

	@Inject(method = "onEntityUpdate", at = @At("HEAD"))
	public void onEntityUpdate(CallbackInfo callbackInfo) {
		EventBus.getInstance().call(new EventLivingUpdate((EntityLivingBase) (Object) this));
		this.prevRotationPitchHead = rotationPitchHead;
	}

	@Override
	public float getprevRotationPitchHead() {
		return prevRotationPitchHead;
	}

	@Override
	public float getrotationPitchHead() {
		return rotationPitchHead;
	}

	@Override
	public float setrotationPitchHead(float a) {
		return rotationPitchHead = a;
	}

	/**
	 * @reason can't inject
	 * @author
	 */
	@Overwrite
	private int getArmSwingAnimationEnd() {
		int speed;
		if (this.isPotionActive(Potion.digSpeed))
			speed = 6 - (1 + this.getActivePotionEffect(Potion.digSpeed).getAmplifier());
		else
			speed = this.isPotionActive(Potion.digSlowdown)
					? 6 + (1 + this.getActivePotionEffect(Potion.digSlowdown).getAmplifier()) * 2
					: 6;
		if ((EntityLivingBase) ((Object) this) instanceof EntityPlayerSP)
			speed += ((Animations) ModuleManager.getModuleByClass(Animations.class)).swingSlowValue.getValue()
					.intValue();
		return speed;
	}

	/**
	 * @reason can't inject
	 * @author
	 */
	@Overwrite
	public void jump() {
		double ymot = !MwHelper.elementValue.getSetting("wwJump").getValue() && this.isPotionActive(Potion.jump)
				? getJumpUpwardsMotion() + (getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F
				: getJumpUpwardsMotion();
		EventJump ej = new EventJump(ymot, true);
		EventBus.getInstance().call(ej);
		if (ej.isCancelled())
			return;

		motionY = ej.getMotionY();
		if (!MwHelper.elementValue.getSetting("wwJump2").getValue()) {
			if (isPotionActive(Potion.jump)) {
				this.motionY += (float) (this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F;
			}
		}
		if (this.isSprinting()) {
			float f = this.rotationYaw * 0.017453292F;
			this.motionX -= MathHelper.sin(f) * 0.2F;
			this.motionZ += MathHelper.cos(f) * 0.2F;
		}

		this.isAirBorne = true;
	}

	/**
	 * @reason can't inject
	 * @author
	 */
	@Overwrite
	public void onLivingUpdate() {
		if (this.jumpTicks > 0) {
			--this.jumpTicks;
		}

		if (this.newPosRotationIncrements > 0) {
			double d0 = this.posX + (this.newPosX - this.posX) / (double) this.newPosRotationIncrements;
			double d1 = this.posY + (this.newPosY - this.posY) / (double) this.newPosRotationIncrements;
			double d2 = this.posZ + (this.newPosZ - this.posZ) / (double) this.newPosRotationIncrements;
			double d3 = MathHelper.wrapAngleTo180_double(this.newRotationYaw - (double) this.rotationYaw);
			this.rotationYaw = (float) ((double) this.rotationYaw + d3 / (double) this.newPosRotationIncrements);
			this.rotationPitch = (float) ((double) this.rotationPitch
					+ (this.newRotationPitch - (double) this.rotationPitch) / (double) this.newPosRotationIncrements);
			--this.newPosRotationIncrements;
			this.setPosition(d0, d1, d2);
			this.setRotation(this.rotationYaw, this.rotationPitch);
		} else if (!this.isServerWorld()) {
			this.motionX *= 0.98D;
			this.motionY *= 0.98D;
			this.motionZ *= 0.98D;
		}

		if (Math.abs(this.motionX) < 0.005D) {
			this.motionX = 0.0D;
		}

		if (Math.abs(this.motionY) < 0.005D) {
			this.motionY = 0.0D;
		}

		if (Math.abs(this.motionZ) < 0.005D) {
			this.motionZ = 0.0D;
		}

		this.worldObj.theProfiler.startSection("ai");

		if (this.isMovementBlocked()) {
			this.isJumping = false;
			this.moveStrafing = 0.0F;
			this.moveForward = 0.0F;
			this.randomYawVelocity = 0.0F;
		} else if (this.isServerWorld()) {
			this.worldObj.theProfiler.startSection("newAi");
			this.updateEntityActionState();
			this.worldObj.theProfiler.endSection();
		}

		this.worldObj.theProfiler.endSection();
		this.worldObj.theProfiler.startSection("jump");

		if (this.isJumping) {
			if (this.isInWater()) {
				this.updateAITick();
			} else if (this.isInLava()) {
				this.handleJumpLava();
			} else if (this.onGround && this.jumpTicks == 0) {
				this.jump();
				if (ModuleManager.getModuleByClass(NoJumpDelay.class).isEnabled()) {
					jumpTicks = NoJumpDelay.delay.getValue().intValue();
				} else {
					this.jumpTicks = 10;
				}
			}
		} else {
			this.jumpTicks = 0;
		}

		this.worldObj.theProfiler.endSection();
		this.worldObj.theProfiler.startSection("travel");
		this.moveStrafing *= 0.98F;
		this.moveForward *= 0.98F;
		this.randomYawVelocity *= 0.9F;
		this.moveEntityWithHeading(this.moveStrafing, this.moveForward);
		this.worldObj.theProfiler.endSection();
		this.worldObj.theProfiler.startSection("push");

		if (!this.worldObj.isRemote) {
			this.collideWithNearbyEntities();
		}

		this.worldObj.theProfiler.endSection();
	}

	@Override
	public void setJumpTicks(int a) {
		jumpTicks = a;
	}

}
