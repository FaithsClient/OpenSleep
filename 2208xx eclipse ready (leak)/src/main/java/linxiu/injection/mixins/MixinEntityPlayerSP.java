package linxiu.injection.mixins;

import linxiu.api.EventBus;
import linxiu.api.events.misc.EventChat;
import linxiu.api.events.world.*;
import linxiu.injection.interfaces.IEntityPlayerSP;
import linxiu.management.ModuleManager;
import linxiu.module.modules.ghost.KeepSprint;
import linxiu.module.modules.megawalls.MwHelper;
import linxiu.module.modules.movement.NoSlow;
import linxiu.module.modules.movement.Sprint;
import linxiu.utils.RotationHook;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.potion.Potion;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(EntityPlayerSP.class)
public abstract class MixinEntityPlayerSP extends AbstractClientPlayer implements IEntityPlayerSP {

	@Shadow
	public MovementInput movementInput;

	public MixinEntityPlayerSP() {
		super(null, null);
	}

	@Shadow
	public int sprintingTicksLeft;

	@Shadow
	protected int sprintToggleTimer;

	@Shadow
	public float timeInPortal;

	@Shadow
	public float prevTimeInPortal;
	@Shadow
	public float horseJumpPower;

	@Shadow
	public int horseJumpPowerCounter;

	@Shadow
	protected Minecraft mc;
	@Shadow
	private boolean serverSprintState;
	@Shadow
	@Final
	public NetHandlerPlayClient sendQueue;
	@Shadow
	private boolean serverSneakState;
	@Shadow
	private double lastReportedPosX;
	@Shadow
	private double lastReportedPosY;
	@Shadow
	private double lastReportedPosZ;
	@Shadow
	private float lastReportedYaw;
	@Shadow
	private float lastReportedPitch;
	@Shadow
	private int positionUpdateTicks;

	@Shadow
	protected abstract void sendHorseJump();

	@Shadow
	public abstract boolean isRidingHorse();

	/**
	 * @author
	 */
	@Inject(method = "onUpdate", at = @At("HEAD"))
	public void eventUpdate(CallbackInfo info) {
		if (Minecraft.getMinecraft().thePlayer != null && Minecraft.getMinecraft().theWorld != null) {
			EventUpdate event = new EventUpdate();
			EventBus.getInstance().call(event);
		}
	}

	@Inject(method = "sendChatMessage", at = @At("HEAD"), cancellable = true)
	public void sendChatMessage(String message, CallbackInfo callbackInfo) {
		EventChat event = new EventChat(message);
		EventBus.getInstance().call(event);
		if (event.isCancelled()) {
			callbackInfo.cancel();
		}
	}

	@Override
	public double getlastReportedPosY() {
		return lastReportedPosY;
	}

	@Override
	public double getlastReportedPosX() {
		return lastReportedPosX;
	}

	@Override
	public double getlastReportedPosZ() {
		return lastReportedPosZ;
	}

	/**
	 * @author 1212
	 * @reason C2112
	 */
	@Overwrite
	public void onLivingUpdate() {
		EventBus.getInstance().call(new LivingUpdateEvent());
		if (this.sprintingTicksLeft > 0) {
			--this.sprintingTicksLeft;
			if (this.sprintingTicksLeft == 0) {
				this.setSprinting(false);
			}
		}
		if (this.sprintToggleTimer > 0) {
			--this.sprintToggleTimer;
		}
		this.prevTimeInPortal = this.timeInPortal;
		if (this.inPortal) {
			if (this.mc.currentScreen != null && !this.mc.currentScreen.doesGuiPauseGame()) {
				this.mc.displayGuiScreen((GuiScreen) null);
			}
			if (this.timeInPortal == 0.0F) {
				this.mc.getSoundHandler().playSound(PositionedSoundRecord.create(new ResourceLocation("portal.trigger"),
						this.rand.nextFloat() * 0.4F + 0.8F));
			}
			this.timeInPortal += 0.0125F;
			if (this.timeInPortal >= 1.0F) {
				this.timeInPortal = 1.0F;
			}
			this.inPortal = false;
		} else if (this.isPotionActive(Potion.confusion)
				&& this.getActivePotionEffect(Potion.confusion).getDuration() > 60) {
			this.timeInPortal += 0.006666667F;

			if (this.timeInPortal > 1.0F) {
				this.timeInPortal = 1.0F;
			}
		} else {
			if (this.timeInPortal > 0.0F) {
				this.timeInPortal -= 0.05F;
			}

			if (this.timeInPortal < 0.0F) {
				this.timeInPortal = 0.0F;
			}
		}

		if (this.timeUntilPortal > 0) {
			--this.timeUntilPortal;
		}

		boolean flag = this.movementInput.jump;
		boolean flag1 = this.movementInput.sneak;
		float f = 0.8F;
		boolean flag2 = this.movementInput.moveForward >= f;
		this.movementInput.updatePlayerMoveState();

		NoSlow ns = (NoSlow) ModuleManager.getModuleByClass(NoSlow.class);
		if (this.isUsingItem() && !this.isRiding() && ns.isEnabled()) {
			this.movementInput.moveStrafe *= ns.Reduceslow.getValue().floatValue() / 100.0;
			this.movementInput.moveForward *= ns.Reduceslow.getValue().floatValue() / 100.0;
		} else if (this.isUsingItem() && !this.isRiding()) {
			this.movementInput.moveStrafe *= 0.2F;
			this.movementInput.moveForward *= 0.2F;
			this.sprintToggleTimer = 0;
		}

		this.pushOutOfBlocks(this.posX - (double) this.width * 0.35D, this.getEntityBoundingBox().minY + 0.5D,
				this.posZ + (double) this.width * 0.35D);
		this.pushOutOfBlocks(this.posX - (double) this.width * 0.35D, this.getEntityBoundingBox().minY + 0.5D,
				this.posZ - (double) this.width * 0.35D);
		this.pushOutOfBlocks(this.posX + (double) this.width * 0.35D, this.getEntityBoundingBox().minY + 0.5D,
				this.posZ - (double) this.width * 0.35D);
		this.pushOutOfBlocks(this.posX + (double) this.width * 0.35D, this.getEntityBoundingBox().minY + 0.5D,
				this.posZ + (double) this.width * 0.35D);
		Sprint sp = (Sprint) ModuleManager.getModuleByClass(Sprint.class);
		boolean flag3 = (float) this.getFoodStats().getFoodLevel() > 6.0F || this.capabilities.allowFlying;
		if (this.onGround && !flag1 && !flag2
				&& ((this.movementInput.moveForward >= f) || (sp.isEnabled() && sp.MultiDirection.getValue()
						&& ((movementInput.moveForward != 0) || (movementInput.moveStrafe != 0))))
				&& !this.isSprinting() && flag3 && !this.isUsingItem() && !this.isPotionActive(Potion.blindness)) {
			if (this.sprintToggleTimer <= 0 && !this.mc.gameSettings.keyBindSprint.isKeyDown()) {
				this.sprintToggleTimer = 7;
			} else {
				this.setSprinting(true);
			}
		}

		if (!this.isSprinting()
				&& ((this.movementInput.moveForward >= f) || (sp.isEnabled() && sp.MultiDirection.getValue()
						&& ((movementInput.moveForward != 0) || (movementInput.moveStrafe != 0))))
				&& flag3 && (ns.isEnabled() || !this.isUsingItem()) && !this.isPotionActive(Potion.blindness)
				&& this.mc.gameSettings.keyBindSprint.isKeyDown()) {
			this.setSprinting(true);
		}

		if (this.isSprinting()
				&& ((!(sp.isEnabled() && sp.MultiDirection.getValue()) && this.movementInput.moveForward < f)
						|| (MwHelper.elementValue.getSetting("WallSprint").getValue() && this.isCollidedHorizontally)
						|| !flag3)) {
			this.setSprinting(false);
		}

		if (this.capabilities.allowFlying) {
			if (this.mc.playerController.isSpectatorMode()) {
				if (!this.capabilities.isFlying) {
					this.capabilities.isFlying = true;
					this.sendPlayerAbilities();
				}
			} else if (!flag && this.movementInput.jump) {
				if (this.flyToggleTimer == 0) {
					this.flyToggleTimer = 7;
				} else {
					this.capabilities.isFlying = !this.capabilities.isFlying;
					this.sendPlayerAbilities();
					this.flyToggleTimer = 0;
				}
			}
		}

		if (this.capabilities.isFlying && this.isCurrentViewEntity()) {
			if (this.movementInput.sneak) {
				this.motionY -= (double) (this.capabilities.getFlySpeed() * 3.0F);
			}

			if (this.movementInput.jump) {
				this.motionY += (double) (this.capabilities.getFlySpeed() * 3.0F);
			}
		}

		if (this.isRidingHorse()) {
			if (this.horseJumpPowerCounter < 0) {
				++this.horseJumpPowerCounter;

				if (this.horseJumpPowerCounter == 0) {
					this.horseJumpPower = 0.0F;
				}
			}

			if (flag && !this.movementInput.jump) {
				this.horseJumpPowerCounter = -10;
				this.sendHorseJump();
			} else if (!flag && this.movementInput.jump) {
				this.horseJumpPowerCounter = 0;
				this.horseJumpPower = 0.0F;
			} else if (flag) {
				++this.horseJumpPowerCounter;
				if (this.horseJumpPowerCounter < 10) {
					this.horseJumpPower = (float) this.horseJumpPowerCounter * 0.1F;
				} else {
					this.horseJumpPower = 0.8F + 2.0F / (float) (this.horseJumpPowerCounter - 9) * 0.1F;
				}
			}
		} else {
			this.horseJumpPower = 0.0F;
		}

		super.onLivingUpdate();
		if (this.onGround && this.capabilities.isFlying && !this.mc.playerController.isSpectatorMode()) {
			this.capabilities.isFlying = false;
			this.sendPlayerAbilities();
		}
	}

	/**
	 * @reason can't inject
	 * @author
	 */
	@Overwrite
	public void onUpdateWalkingPlayer() {
		boolean flag = this.isSprinting();
		EventPreUpdate pre = new EventPreUpdate(this.lastReportedYaw, this.lastReportedPitch, this.rotationYaw,
				this.rotationPitch, posX, posY, posZ, onGround);
		EventBus.getInstance().call(pre);
		EventPostUpdate post = new EventPostUpdate(this.posX, this.posZ, this.rotationYaw, this.rotationPitch);
		if (pre.isCancelled()) {
			EventBus.getInstance().call(post);
			return;
		}

		if (flag != this.serverSprintState) {
			if (flag) {
				this.sendQueue.addToSendQueue(new C0BPacketEntityAction((EntityPlayerSP) (Object) this,
						C0BPacketEntityAction.Action.START_SPRINTING));
			} else {
				this.sendQueue.addToSendQueue(new C0BPacketEntityAction((EntityPlayerSP) (Object) this,
						C0BPacketEntityAction.Action.STOP_SPRINTING));
			}
			this.serverSprintState = flag;
		}
		boolean flag1 = this.isSneaking();
		if (flag1 != this.serverSneakState) {
			if (flag1) {
				this.sendQueue.addToSendQueue(new C0BPacketEntityAction((EntityPlayerSP) (Object) this,
						C0BPacketEntityAction.Action.START_SNEAKING));
			} else {
				this.sendQueue.addToSendQueue(new C0BPacketEntityAction((EntityPlayerSP) (Object) this,
						C0BPacketEntityAction.Action.STOP_SNEAKING));
			}
			this.serverSneakState = flag1;
		}
		if (this.isCurrentViewEntity()) {
			final double eventX = pre.getX();
			double eventY = pre.getY();
			final double eventZ = pre.getZ();
			final float eventYaw = pre.getYaw();
			final float eventPitch = pre.getPitch();
			final boolean eventGround = pre.isOnground();
			double d0 = eventX - this.lastReportedPosX;
			double d1 = eventY - this.lastReportedPosY;
			double d2 = eventZ - this.lastReportedPosZ;
			double d3 = eventYaw - this.lastReportedYaw;
			double d4 = eventPitch - this.lastReportedPitch;
			boolean flag2 = d0 * d0 + d1 * d1 + d2 * d2 > 9.0E-4D || this.positionUpdateTicks >= 20;
			boolean flag3 = d3 != 0.0D || d4 != 0.0D;

			if (this.ridingEntity == null) {
				if (flag2 && flag3) {
					this.sendQueue.addToSendQueue(new C03PacketPlayer.C06PacketPlayerPosLook(eventX, eventY, eventZ,
							eventYaw, eventPitch, eventGround));
				} else if (flag2) {
					this.sendQueue.addToSendQueue(new C03PacketPlayer.C06PacketPlayerPosLook(eventX, eventY, eventZ,
							eventYaw, eventPitch, eventGround));
				} else if (flag3) {
					this.sendQueue
							.addToSendQueue(new C03PacketPlayer.C05PacketPlayerLook(eventYaw, eventPitch, eventGround));
				} else {
					this.sendQueue.addToSendQueue(new C03PacketPlayer(eventGround));
				}
			} else {
				this.sendQueue.addToSendQueue(new C03PacketPlayer.C06PacketPlayerPosLook(this.motionX, -999.0D,
						this.motionZ, eventYaw, eventPitch, eventGround));
				flag2 = false;
			}

			++this.positionUpdateTicks;

			if (flag2) {
				this.lastReportedPosX = eventX;
				this.lastReportedPosY = eventY;
				this.lastReportedPosZ = eventZ;
				this.positionUpdateTicks = 0;
			}

			if (flag3) {
				this.lastReportedYaw = eventYaw;
				this.lastReportedPitch = eventPitch;
			}

			RotationHook.prevYaw = RotationHook.yaw;
			RotationHook.prevPitch = RotationHook.pitch;

			RotationHook.yaw = rotationYaw;
			RotationHook.pitch = rotationPitch;

			EventBus.getInstance().call(post);
		}
	}

	@Override
	public void attackTargetEntityWithCurrentItem(Entity targetEntity) {
		if (targetEntity.canAttackWithItem()) {
			if (!targetEntity.hitByEntity(this)) {
				float f = (float) this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
				int i = 0;
				float f1 = 0.0F;

				if (targetEntity instanceof EntityLivingBase) {
					f1 = EnchantmentHelper.getModifierForCreature(this.getHeldItem(),
							((EntityLivingBase) targetEntity).getCreatureAttribute());
				} else {
					f1 = EnchantmentHelper.getModifierForCreature(this.getHeldItem(), EnumCreatureAttribute.UNDEFINED);
				}

				i = i + EnchantmentHelper.getKnockbackModifier(this);

				if (this.isSprinting()) {
					++i;
				}

				if (f > 0.0F || f1 > 0.0F) {
					boolean flag = this.fallDistance > 0.0F && !this.onGround && !this.isOnLadder() && !this.isInWater()
							&& !this.isPotionActive(Potion.blindness) && this.ridingEntity == null
							&& targetEntity instanceof EntityLivingBase;

					if (flag && f > 0.0F) {
						f *= 1.5F;
					}

					f = f + f1;
					boolean flag1 = false;
					int j = EnchantmentHelper.getFireAspectModifier(this);

					if (targetEntity instanceof EntityLivingBase && j > 0 && !targetEntity.isBurning()) {
						flag1 = true;
						targetEntity.setFire(1);
					}

					double d0 = targetEntity.motionX;
					double d1 = targetEntity.motionY;
					double d2 = targetEntity.motionZ;
					boolean flag2 = targetEntity.attackEntityFrom(DamageSource.causePlayerDamage(this), f);

					if (flag2) {
						if (i > 0) {
							targetEntity.addVelocity(
									-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F,
									0.1D,
									MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * (float) i * 0.5F);

							if (ModuleManager.getModuleByClass(KeepSprint.class).isEnabled()) {
								KeepSprint.sl(targetEntity);
							} else {
								this.motionX *= 0.6D;
								this.motionZ *= 0.6D;
								this.setSprinting(false);
							}
						}

						if (targetEntity instanceof EntityPlayerMP && targetEntity.velocityChanged) {
							((EntityPlayerMP) targetEntity).playerNetServerHandler
									.sendPacket(new S12PacketEntityVelocity(targetEntity));
							targetEntity.velocityChanged = false;
							targetEntity.motionX = d0;
							targetEntity.motionY = d1;
							targetEntity.motionZ = d2;
						}

						if (flag) {
							this.onCriticalHit(targetEntity);
						}

						if (f1 > 0.0F) {
							this.onEnchantmentCritical(targetEntity);
						}

						if (f >= 18.0F) {
							this.triggerAchievement(AchievementList.overkill);
						}

						this.setLastAttacker(targetEntity);

						if (targetEntity instanceof EntityLivingBase) {
							EnchantmentHelper.applyThornEnchantments((EntityLivingBase) targetEntity, this);
						}

						EnchantmentHelper.applyArthropodEnchantments(this, targetEntity);
						ItemStack itemstack = this.getCurrentEquippedItem();
						Entity entity = targetEntity;

						if (targetEntity instanceof EntityDragonPart) {
							IEntityMultiPart ientitymultipart = ((EntityDragonPart) targetEntity).entityDragonObj;

							if (ientitymultipart instanceof EntityLivingBase) {
								entity = (EntityLivingBase) ientitymultipart;
							}
						}

						if (itemstack != null && entity instanceof EntityLivingBase) {
							itemstack.hitEntity((EntityLivingBase) entity, this);

							if (itemstack.stackSize <= 0) {
								this.destroyCurrentEquippedItem();
							}
						}

						if (targetEntity instanceof EntityLivingBase) {
							this.addStat(StatList.damageDealtStat, Math.round(f * 10.0F));

							if (j > 0) {
								targetEntity.setFire(j * 4);
							}
						}

						this.addExhaustion(0.3F);
					} else if (flag1) {
						targetEntity.extinguish();
					}
				}
			}
		}
	}

	@Shadow
	public boolean isCurrentViewEntity() {
		return false;
	}

	public boolean moving() {
		return this.moveForward > 0.0 | this.moveStrafing > 0.0;
	}

	public float getSpeed() {
		final float vel = (float) Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
		return vel;
	}

	public void setSpeed(final double speed) {
		this.motionX = -MathHelper.sin(this.getDirection()) * speed;
		this.motionZ = MathHelper.cos(this.getDirection()) * speed;
	}

	public float getDirection() {
		float yaw = this.rotationYaw;
		final float forward = this.moveForward;
		final float strafe = this.moveStrafing;
		yaw += ((forward < 0.0f) ? 180 : 0);

		if (strafe < 0.0f) {
			yaw += ((forward < 0.0f) ? -45.0f : ((forward == 0.0f) ? 90.0f : 45.0f));
		}

		if (strafe > 0.0f) {
			yaw -= ((forward < 0.0f) ? -45.0f : ((forward == 0.0f) ? 90.0f : 45.0f));
		}

		return yaw * 0.017453292f;
	}

	public void setYaw(double yaw) {
		this.rotationYaw = (float) yaw;
	}

	public void setPitch(double pitch) {
		this.rotationPitch = (float) pitch;
	}

	public void setMoveSpeed(EventMove event, double speed) {
		double forward = this.movementInput.moveForward;
		double strafe = this.movementInput.moveStrafe;
		float yaw = this.rotationYaw;
		if (forward == 0.0 && strafe == 0.0) {
			event.setX(0.0);
			event.setZ(0.0);
		} else {
			if (forward != 0.0) {
				if (strafe > 0.0) {
					yaw += ((forward > 0.0) ? -45 : 45);
				} else if (strafe < 0.0) {
					yaw += ((forward > 0.0) ? 45 : -45);
				}
				strafe = 0.0;
				if (forward > 0.0) {
					forward = 1.0;
				} else if (forward < 0.0) {
					forward = -1.0;
				}
			}
			event.setX(forward * speed * Math.cos(Math.toRadians(yaw + 90.0f))
					+ strafe * speed * Math.sin(Math.toRadians(yaw + 90.0f)));
			event.setZ(forward * speed * Math.sin(Math.toRadians(yaw + 90.0f))
					- strafe * speed * Math.cos(Math.toRadians(yaw + 90.0f)));
		}
	}

	@Override
	public void setLastReportedPosY(double f) {
		lastReportedPosY = f;
		// TODO Auto-generated method stub
	}
}
