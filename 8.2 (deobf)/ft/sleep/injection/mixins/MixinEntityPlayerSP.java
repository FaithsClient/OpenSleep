//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import com.mojang.authlib.GameProfile;
import ft.sleep.api.EventBus;
import ft.sleep.api.events.misc.EventChat;
import ft.sleep.api.events.world.EventMove;
import ft.sleep.api.events.world.EventPostUpdate;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.events.world.EventUpdate;
import ft.sleep.api.events.world.LivingUpdateEvent;
import ft.sleep.api.events.world.SlowdownEvent;
import ft.sleep.injection.interfaces.IEntityPlayerSP;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0CPacketInput;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.network.play.client.C03PacketPlayer.C05PacketPlayerLook;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import net.minecraft.network.play.client.C0BPacketEntityAction.Action;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.potion.Potion;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovementInput;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({EntityPlayerSP.class})
public abstract class MixinEntityPlayerSP extends AbstractClientPlayer implements IEntityPlayerSP {
   @Shadow
   public MovementInput movementInput;
   public int offGroundTicks;
   public int onGroundTicks;
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

   public MixinEntityPlayerSP() {
      super((World)null, (GameProfile)null);
   }

   @Shadow
   protected abstract void sendHorseJump();

   @Shadow
   public abstract boolean isRidingHorse();

   @Inject(
      method = {"sendChatMessage"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void sendChatMessage(String message, CallbackInfo callbackInfo) {
      EventChat event = new EventChat(message);
      EventBus.getInstance().call(event);
      if (event.isCancelled()) {
         callbackInfo.cancel();
      }

   }

   public double getOnGroundTicks() {
      return (double)this.onGroundTicks;
   }

   public double getoffGroundTicks() {
      return (double)this.offGroundTicks;
   }

   public double getlastReportedPosY() {
      return this.lastReportedPosY;
   }

   public double getlastReportedPosX() {
      return this.lastReportedPosX;
   }

   public double getlastReportedPosZ() {
      return this.lastReportedPosZ;
   }

   @Inject(
      method = {"onUpdate"},
      at = {@At("HEAD")}
   )
   public void onUpdate(CallbackInfo ci) {
      EventBus.getInstance().call(new EventUpdate());
   }

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
            this.mc.displayGuiScreen((GuiScreen)null);
         }

         if (this.timeInPortal == 0.0F) {
            this.mc.getSoundHandler().playSound(PositionedSoundRecord.create(new ResourceLocation("portal.trigger"), this.rand.nextFloat() * 0.4F + 0.8F));
         }

         this.timeInPortal += 0.0125F;
         if (this.timeInPortal >= 1.0F) {
            this.timeInPortal = 1.0F;
         }

         this.inPortal = false;
      } else if (this.isPotionActive(Potion.confusion) && this.getActivePotionEffect(Potion.confusion).getDuration() > 60) {
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
       ns = ().�?(.class);
      if (this.getHeldItem() != null && (this.isUsingItem() || this.getHeldItem().getItem() instanceof ItemSword && .) && !this.isRiding()) {
         SlowdownEvent slowDownEvent = new SlowdownEvent(0.2F, 0.2F);
         EventBus.getInstance().call(slowDownEvent);
         this.movementInput.moveStrafe *= slowDownEvent.getStrafe();
         this.movementInput.moveForward *= slowDownEvent.getForward();
      }

      this.pushOutOfBlocks(this.posX - (double)this.width * 0.35D, this.getEntityBoundingBox().minY + 0.5D, this.posZ + (double)this.width * 0.35D);
      this.pushOutOfBlocks(this.posX - (double)this.width * 0.35D, this.getEntityBoundingBox().minY + 0.5D, this.posZ - (double)this.width * 0.35D);
      this.pushOutOfBlocks(this.posX + (double)this.width * 0.35D, this.getEntityBoundingBox().minY + 0.5D, this.posZ - (double)this.width * 0.35D);
      this.pushOutOfBlocks(this.posX + (double)this.width * 0.35D, this.getEntityBoundingBox().minY + 0.5D, this.posZ + (double)this.width * 0.35D);
       sp = ().�?(.class);
      boolean flag3 = (float)this.getFoodStats().getFoodLevel() > 6.0F || this.capabilities.allowFlying;
      if (this.onGround && !flag1 && !flag2 && (this.movementInput.moveForward >= f || sp.�?() && ..getValue().booleanValue() && (this.movementInput.moveForward != 0.0F || this.movementInput.moveStrafe != 0.0F)) && !this.isSprinting() && flag3 && !this.isUsingItem() && !this.isPotionActive(Potion.blindness)) {
         if (this.sprintToggleTimer <= 0 && !this.mc.gameSettings.keyBindSprint.isKeyDown()) {
            this.sprintToggleTimer = 7;
         } else {
            this.setSprinting(true);
         }
      }

      if (!this.isSprinting() && (this.movementInput.moveForward >= f || sp.�?() && ..getValue().booleanValue() && (this.movementInput.moveForward != 0.0F || this.movementInput.moveStrafe != 0.0F)) && flag3 && (ns.�?() || !this.isUsingItem()) && !this.isPotionActive(Potion.blindness) && this.mc.gameSettings.keyBindSprint.isKeyDown()) {
         this.setSprinting(true);
      }

      if (this.isSprinting() && ((!sp.�?() || !..getValue().booleanValue()) && this.movementInput.moveForward < f || this.isCollidedHorizontally || !flag3)) {
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
            this.motionY -= (double)(this.capabilities.getFlySpeed() * 3.0F);
         }

         if (this.movementInput.jump) {
            this.motionY += (double)(this.capabilities.getFlySpeed() * 3.0F);
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
               this.horseJumpPower = (float)this.horseJumpPowerCounter * 0.1F;
            } else {
               this.horseJumpPower = 0.8F + 2.0F / (float)(this.horseJumpPowerCounter - 9) * 0.1F;
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

   @Overwrite
   public void onUpdateWalkingPlayer() {
      if (this.onGround) {
         this.offGroundTicks = 0;
         ++this.onGroundTicks;
      } else {
         this.onGroundTicks = 0;
         ++this.offGroundTicks;
      }

      EventPreUpdate PRE = new EventPreUpdate(this.lastReportedYaw, this.lastReportedPitch, this.rotationYaw, this.rotationPitch, this.posX, this.posY, this.posZ, this.onGround);
      EventBus.getInstance().call(PRE);
      �?.prevYaw = �?.yaw;
      �?.prevPitch = �?.pitch;
      �?.yaw = this.rotationYaw;
      �?.pitch = this.rotationPitch;
      float preYaw = this.rotationYaw;
      float prePitch = this.rotationPitch;
      this.rotationYaw = EventPreUpdate.getYaw();
      this.rotationPitch = PRE.getPitch();
      float a = MathHelper.wrapAngleTo180_float(this.rotationYaw - �?.yaw);
      this.rotationYaw = �?.yaw + a;
      �?.�? = �?.yaw;
      �?.yaw += a;
      boolean flag = this.isSprinting();
      if (flag != this.serverSprintState) {
         if (flag) {
            this.sendQueue.addToSendQueue(new C0BPacketEntityAction((EntityPlayerSP)this, Action.START_SPRINTING));
         } else {
            this.sendQueue.addToSendQueue(new C0BPacketEntityAction((EntityPlayerSP)this, Action.STOP_SPRINTING));
         }

         this.serverSprintState = flag;
      }

      boolean flag1 = this.isSneaking();
      if (flag1 != this.serverSneakState) {
         if (flag1) {
            this.sendQueue.addToSendQueue(new C0BPacketEntityAction((EntityPlayerSP)this, Action.START_SNEAKING));
         } else {
            this.sendQueue.addToSendQueue(new C0BPacketEntityAction((EntityPlayerSP)this, Action.STOP_SNEAKING));
         }

         this.serverSneakState = flag1;
      }

      if (!PRE.isCancelled()) {
         if (this.isCurrentViewEntity()) {
            double d0 = PRE.getX() - this.lastReportedPosX;
            double d1 = PRE.getY() - this.lastReportedPosY;
            double d2 = PRE.getZ() - this.lastReportedPosZ;
            double d3 = (double)(EventPreUpdate.getYaw() - this.lastReportedYaw);
            double d4 = (double)(PRE.getPitch() - this.lastReportedPitch);
            boolean flag2 = d0 * d0 + d1 * d1 + d2 * d2 > 9.0E-4D || this.positionUpdateTicks >= 20;
            boolean flag3 = d3 != 0.0D || d4 != 0.0D;
            if (this.ridingEntity == null) {
               if (flag2 && flag3) {
                  this.sendQueue.addToSendQueue(new C06PacketPlayerPosLook(PRE.getX(), PRE.getY(), PRE.getZ(), EventPreUpdate.getYaw(), PRE.getPitch(), PRE.isOnground()));
               } else if (flag2) {
                  this.sendQueue.addToSendQueue(new C04PacketPlayerPosition(PRE.getX(), PRE.getY(), PRE.getZ(), PRE.isOnground()));
               } else if (flag3) {
                  this.sendQueue.addToSendQueue(new C05PacketPlayerLook(EventPreUpdate.getYaw(), PRE.getPitch(), PRE.isOnground()));
               } else {
                  this.sendQueue.addToSendQueue(new C03PacketPlayer(PRE.isOnground()));
               }

               ++this.positionUpdateTicks;
               if (flag2) {
                  this.lastReportedPosX = PRE.getX();
                  this.lastReportedPosY = PRE.getY();
                  this.lastReportedPosZ = PRE.getZ();
                  this.positionUpdateTicks = 0;
               }

               if (flag3) {
                  this.lastReportedYaw = EventPreUpdate.getYaw();
                  this.lastReportedPitch = PRE.getPitch();
               }
            } else {
               this.sendQueue.addToSendQueue(new C05PacketPlayerLook(EventPreUpdate.getYaw(), PRE.getPitch(), PRE.isOnground()));
               this.sendQueue.addToSendQueue(new C0CPacketInput(this.moveStrafing, this.moveForward, this.movementInput.jump, this.movementInput.sneak));
            }
         }

         EventPostUpdate POST = new EventPostUpdate(this.rotationYaw, this.rotationPitch);
         EventBus.getInstance().call(POST);
         this.rotationYaw = preYaw;
         this.rotationPitch = prePitch;
      }
   }

   public void attackTargetEntityWithCurrentItem(Entity targetEntity) {
      if (targetEntity.canAttackWithItem() && !targetEntity.hitByEntity(this)) {
         float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
         int i = 0;
         float f1 = 0.0F;
         if (targetEntity instanceof EntityLivingBase) {
            f1 = EnchantmentHelper.getModifierForCreature(this.getHeldItem(), ((EntityLivingBase)targetEntity).getCreatureAttribute());
         } else {
            f1 = EnchantmentHelper.getModifierForCreature(this.getHeldItem(), EnumCreatureAttribute.UNDEFINED);
         }

         i = i + EnchantmentHelper.getKnockbackModifier(this);
         if (this.isSprinting()) {
            ++i;
         }

         if (f > 0.0F || f1 > 0.0F) {
            boolean flag = this.fallDistance > 0.0F && !this.onGround && !this.isOnLadder() && !this.isInWater() && !this.isPotionActive(Potion.blindness) && this.ridingEntity == null && targetEntity instanceof EntityLivingBase;
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
                  label121: {
                     targetEntity.addVelocity((double)(-MathHelper.sin(this.rotationYaw * 3.1415927F / 180.0F) * (float)i * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * 3.1415927F / 180.0F) * (float)i * 0.5F));
                     �?.�?();
                     �?.�?();
                     if (!.�?(.class).�?()) {
                        �?.�?();
                        �?.�?();
                        if (!.�?(.class).�?()) {
                           this.motionX *= 0.6D;
                           this.motionZ *= 0.6D;
                           this.setSprinting(false);
                           break label121;
                        }
                     }

                     .�?(targetEntity);
                  }
               }

               if (targetEntity instanceof EntityPlayerMP && targetEntity.velocityChanged) {
                  ((EntityPlayerMP)targetEntity).playerNetServerHandler.sendPacket(new S12PacketEntityVelocity(targetEntity));
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
                  EnchantmentHelper.applyThornEnchantments((EntityLivingBase)targetEntity, this);
               }

               EnchantmentHelper.applyArthropodEnchantments(this, targetEntity);
               ItemStack itemstack = this.getCurrentEquippedItem();
               Entity entity = targetEntity;
               if (targetEntity instanceof EntityDragonPart) {
                  IEntityMultiPart ientitymultipart = ((EntityDragonPart)targetEntity).entityDragonObj;
                  if (ientitymultipart instanceof EntityLivingBase) {
                     entity = (EntityLivingBase)ientitymultipart;
                  }
               }

               if (itemstack != null && entity instanceof EntityLivingBase) {
                  itemstack.hitEntity((EntityLivingBase)entity, this);
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

   @Shadow
   public boolean isCurrentViewEntity() {
      return false;
   }

   public boolean moving() {
      return (double)this.moveForward > 0.0D | (double)this.moveStrafing > 0.0D;
   }

   public float getSpeed() {
      float vel = (float)Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
      return vel;
   }

   public void setSpeed(double speed) {
      this.motionX = (double)(-MathHelper.sin(this.getDirection())) * speed;
      this.motionZ = (double)MathHelper.cos(this.getDirection()) * speed;
   }

   public float getDirection() {
      float yaw = this.rotationYaw;
      float forward = this.moveForward;
      float strafe = this.moveStrafing;
      yaw = yaw + (float)(forward < 0.0F ? 180 : 0);
      if (strafe < 0.0F) {
         yaw += forward < 0.0F ? -45.0F : (forward == 0.0F ? 90.0F : 45.0F);
      }

      if (strafe > 0.0F) {
         yaw -= forward < 0.0F ? -45.0F : (forward == 0.0F ? 90.0F : 45.0F);
      }

      return yaw * 0.017453292F;
   }

   public void setYaw(double yaw) {
      this.rotationYaw = (float)yaw;
   }

   public void setPitch(double pitch) {
      this.rotationPitch = (float)pitch;
   }

   public void setMoveSpeed(EventMove event, double speed) {
      double forward = (double)this.movementInput.moveForward;
      double strafe = (double)this.movementInput.moveStrafe;
      float yaw = this.rotationYaw;
      if (forward == 0.0D && strafe == 0.0D) {
         event.setX(0.0D);
         event.setZ(0.0D);
      } else {
         if (forward != 0.0D) {
            if (strafe > 0.0D) {
               yaw += (float)(forward > 0.0D ? -45 : 45);
            } else if (strafe < 0.0D) {
               yaw += (float)(forward > 0.0D ? 45 : -45);
            }

            strafe = 0.0D;
            if (forward > 0.0D) {
               forward = 1.0D;
            } else if (forward < 0.0D) {
               forward = -1.0D;
            }
         }

         event.setX(forward * speed * Math.cos(Math.toRadians((double)(yaw + 90.0F))) + strafe * speed * Math.sin(Math.toRadians((double)(yaw + 90.0F))));
         event.setZ(forward * speed * Math.sin(Math.toRadians((double)(yaw + 90.0F))) - strafe * speed * Math.cos(Math.toRadians((double)(yaw + 90.0F))));
      }

   }

   public void setLastReportedPosY(double f) {
      this.lastReportedPosY = f;
   }
}
