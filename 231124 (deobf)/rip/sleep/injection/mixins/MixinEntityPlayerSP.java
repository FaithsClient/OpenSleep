package rip.sleep.injection.mixins;

import rip.sleep.event.EventBus;
import com.mojang.authlib.GameProfile;
import rip.sleep.injection.in.IEntityPlayerSP;
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
import net.minecraft.network.play.client.C0BPacketEntityAction;
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
import rip.sleep.event.events.MoveEvent;
import rip.sleep.event.events.EndUpdateEvent;
import rip.sleep.event.events.SlowdownEvent;
import rip.sleep.unmap.c39134;
import rip.sleep.event.events.ChatSendEvent;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.module.modules.KeepSprint;
import rip.sleep.event.events.LivingUpdateEvent;
import rip.sleep.module.modules.KillAura;
import rip.sleep.module.modules.Sprint;
import rip.sleep.event.events.StartUpdateEvent;
import rip.sleep.Sleep;
import rip.sleep.module.modules.NoSlowdown;
import rip.sleep.management.ModuleManager;
import rip.sleep.event.events.PostUpdateEvent;

@Mixin({EntityPlayerSP.class})
public abstract class MixinEntityPlayerSP extends AbstractClientPlayer implements IEntityPlayerSP {
   @Shadow
   public MovementInput field_71158_b;
   public int offGroundTicks;
   public int onGroundTicks;
   @Shadow
   public int field_71157_e;
   @Shadow
   protected int field_71156_d;
   @Shadow
   public float field_71086_bY;
   @Shadow
   public float field_71080_cy;
   @Shadow
   public float field_110321_bQ;
   @Shadow
   public int field_110320_a;
   @Shadow
   protected Minecraft field_71159_c;
   @Shadow
   private boolean field_175171_bO;
   @Shadow
   @Final
   public NetHandlerPlayClient field_71174_a;
   @Shadow
   private boolean field_175170_bN;
   @Shadow
   private double field_175172_bI;
   @Shadow
   private double field_175166_bJ;
   @Shadow
   private double field_175167_bK;
   @Shadow
   private float field_175164_bL;
   @Shadow
   private float field_175165_bM;
   @Shadow
   private int field_175168_bP;

   public MixinEntityPlayerSP() {
      super((World)null, (GameProfile)null);
   }

   @Shadow
   protected abstract void func_110318_g();

   @Shadow
   public abstract boolean func_110317_t();

   @Inject(
      method = {"sendChatMessage"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void sendChatMessage(String var1, CallbackInfo var2) {
      ChatSendEvent var3 = new ChatSendEvent(var1);
      EventBus.getInstance().call(var3);
      if (var3.c58917()) {
         var2.cancel();
      }

   }

   public double getOnGroundTicks() {
      return (double)this.onGroundTicks;
   }

   public double getoffGroundTicks() {
      return (double)this.offGroundTicks;
   }

   public double getlastReportedPosY() {
      return this.field_175166_bJ;
   }

   public double getlastReportedPosX() {
      return this.field_175172_bI;
   }

   public double getlastReportedPosZ() {
      return this.field_175167_bK;
   }

   @Inject(
      method = {"onUpdate"},
      at = {@At("HEAD")}
   )
   public void onUpdate(CallbackInfo var1) {
      EventBus.getInstance().call(new StartUpdateEvent());
   }

   @Inject(
      method = {"onUpdate"},
      at = {@At("RETURN")}
   )
   public void onUpdate1(CallbackInfo var1) {
      EventBus.getInstance().call(new EndUpdateEvent());
   }

   @Overwrite
   public void onLivingUpdate() {
      EventBus.getInstance().call(new LivingUpdateEvent());
      if (this.field_71157_e > 0) {
         --this.field_71157_e;
         if (this.field_71157_e == 0) {
            this.setSprinting(false);
         }
      }

      if (this.field_71156_d > 0) {
         --this.field_71156_d;
      }

      this.field_71080_cy = this.field_71086_bY;
      if (this.inPortal) {
         if (this.field_71159_c.currentScreen != null && !this.field_71159_c.currentScreen.doesGuiPauseGame()) {
            this.field_71159_c.displayGuiScreen((GuiScreen)null);
         }

         if (this.field_71086_bY == 0.0F) {
            this.field_71159_c.getSoundHandler().playSound(PositionedSoundRecord.create(new ResourceLocation("portal.trigger"), this.rand.nextFloat() * 0.4F + 0.8F));
         }

         this.field_71086_bY += 0.0125F;
         if (this.field_71086_bY >= 1.0F) {
            this.field_71086_bY = 1.0F;
         }

         this.inPortal = false;
      } else if (this.isPotionActive(Potion.confusion) && this.getActivePotionEffect(Potion.confusion).getDuration() > 60) {
         this.field_71086_bY += 0.006666667F;
         if (this.field_71086_bY > 1.0F) {
            this.field_71086_bY = 1.0F;
         }
      } else {
         if (this.field_71086_bY > 0.0F) {
            this.field_71086_bY -= 0.05F;
         }

         if (this.field_71086_bY < 0.0F) {
            this.field_71086_bY = 0.0F;
         }
      }

      if (this.timeUntilPortal > 0) {
         --this.timeUntilPortal;
      }

      boolean var1 = this.field_71158_b.jump;
      boolean var2 = this.field_71158_b.sneak;
      float var3 = 0.8F;
      boolean var4 = this.field_71158_b.moveForward >= var3;
      this.field_71158_b.updatePlayerMoveState();
      NoSlowdown var5 = (NoSlowdown) ModuleManager.c25475(NoSlowdown.class);
      if (this.getHeldItem() != null && (this.isUsingItem() || this.getHeldItem().getItem() instanceof ItemSword && KillAura.c62171) && !this.isRiding()) {
         SlowdownEvent var6 = new SlowdownEvent(0.2F, 0.2F);
         EventBus.getInstance().call(var6);
         this.field_71158_b.moveStrafe *= var6.c3185();
         this.field_71158_b.moveForward *= var6.c60583();
      }

      this.pushOutOfBlocks(this.posX - (double)this.width * 0.35D, this.getEntityBoundingBox().minY + 0.5D, this.posZ + (double)this.width * 0.35D);
      this.pushOutOfBlocks(this.posX - (double)this.width * 0.35D, this.getEntityBoundingBox().minY + 0.5D, this.posZ - (double)this.width * 0.35D);
      this.pushOutOfBlocks(this.posX + (double)this.width * 0.35D, this.getEntityBoundingBox().minY + 0.5D, this.posZ - (double)this.width * 0.35D);
      this.pushOutOfBlocks(this.posX + (double)this.width * 0.35D, this.getEntityBoundingBox().minY + 0.5D, this.posZ + (double)this.width * 0.35D);
      Sprint var8 = (Sprint) ModuleManager.c25475(Sprint.class);
      if ((float)this.getFoodStats().getFoodLevel() <= 6.0F && !this.capabilities.allowFlying) {
         boolean var9 = false;
      } else {
         boolean var10000 = true;
      }

      if (this.onGround && (this.field_71158_b.moveForward >= var3 || var8.c24622() && Sprint.c92168.c1473().booleanValue() && (this.field_71158_b.moveForward != 0.0F || this.field_71158_b.moveStrafe != 0.0F)) && !this.isSprinting() && !this.isUsingItem() && !this.isPotionActive(Potion.blindness)) {
         if (this.field_71156_d <= 0 && !this.field_71159_c.gameSettings.keyBindSprint.isKeyDown()) {
            this.field_71156_d = 7;
         } else {
            this.setSprinting(true);
         }
      }

      if (!this.isSprinting() && (this.field_71158_b.moveForward >= var3 || var8.c24622() && Sprint.c92168.c1473().booleanValue() && (this.field_71158_b.moveForward != 0.0F || this.field_71158_b.moveStrafe != 0.0F)) && (var5.c24622() || !this.isUsingItem()) && !this.isPotionActive(Potion.blindness) && this.field_71159_c.gameSettings.keyBindSprint.isKeyDown()) {
         this.setSprinting(true);
      }

      if (this.isSprinting()) {
         if ((var8.c24622() && Sprint.c92168.c1473().booleanValue() || this.field_71158_b.moveForward >= var3) && !this.isCollidedHorizontally) {
            ;
         }

         this.setSprinting(false);
      }

      if (this.capabilities.allowFlying) {
         if (this.field_71159_c.playerController.isSpectatorMode()) {
            if (!this.capabilities.isFlying) {
               this.capabilities.isFlying = true;
               this.sendPlayerAbilities();
            }
         } else if (this.field_71158_b.jump) {
            if (this.flyToggleTimer == 0) {
               this.flyToggleTimer = 7;
            } else {
               this.capabilities.isFlying = !this.capabilities.isFlying;
               this.sendPlayerAbilities();
               this.flyToggleTimer = 0;
            }
         }
      }

      if (this.capabilities.isFlying && this.func_175160_A()) {
         if (this.field_71158_b.sneak) {
            this.motionY -= (double)(this.capabilities.getFlySpeed() * 3.0F);
         }

         if (this.field_71158_b.jump) {
            this.motionY += (double)(this.capabilities.getFlySpeed() * 3.0F);
         }
      }

      if (this.func_110317_t()) {
         if (this.field_110320_a < 0) {
            ++this.field_110320_a;
            if (this.field_110320_a == 0) {
               this.field_110321_bQ = 0.0F;
            }
         }

         if (!this.field_71158_b.jump) {
            this.field_110320_a = -10;
            this.func_110318_g();
         } else if (this.field_71158_b.jump) {
            this.field_110320_a = 0;
            this.field_110321_bQ = 0.0F;
         } else {
            ++this.field_110320_a;
            if (this.field_110320_a < 10) {
               this.field_110321_bQ = (float)this.field_110320_a * 0.1F;
            } else {
               this.field_110321_bQ = 0.8F + 2.0F / (float)(this.field_110320_a - 9) * 0.1F;
            }
         }
      } else {
         this.field_110321_bQ = 0.0F;
      }

      super.onLivingUpdate();
      if (this.onGround && this.capabilities.isFlying && !this.field_71159_c.playerController.isSpectatorMode()) {
         this.capabilities.isFlying = false;
         this.sendPlayerAbilities();
      }

   }

   @Overwrite
   public void func_175161_p() {
      if (this.onGround) {
         this.offGroundTicks = 0;
         ++this.onGroundTicks;
      } else {
         this.onGroundTicks = 0;
         ++this.offGroundTicks;
      }

      MotionUpdateEvent var1 = new MotionUpdateEvent(this.field_175164_bL, this.field_175165_bM, this.rotationYaw, this.rotationPitch, this.posX, this.posY, this.posZ, this.onGround);
      EventBus.getInstance().call(var1);
      c39134.c23336 = c39134.c49330;
      c39134.c9966 = c39134.c21639;
      c39134.c49330 = this.rotationYaw;
      c39134.c21639 = this.rotationPitch;
      float var2 = this.rotationYaw;
      float var3 = this.rotationPitch;
      this.rotationYaw = MotionUpdateEvent.c74012();
      this.rotationPitch = var1.c86825();
      float var4 = MathHelper.wrapAngleTo180_float(this.rotationYaw - Sleep.c6432);
      this.rotationYaw = Sleep.c6432 + var4;
      Sleep.c34963 = Sleep.c6432;
      Sleep.c6432 += var4;
      boolean var5 = this.isSprinting();
      if (var5 != this.field_175171_bO) {
         this.field_71174_a.addToSendQueue(new C0BPacketEntityAction((EntityPlayerSP)this, Action.START_SPRINTING));
         this.field_175171_bO = var5;
      }

      boolean var6 = this.isSneaking();
      if (var6 != this.field_175170_bN) {
         this.field_71174_a.addToSendQueue(new C0BPacketEntityAction((EntityPlayerSP)this, Action.START_SNEAKING));
         this.field_175170_bN = var6;
      }

      if (this.func_175160_A()) {
         double var8 = var1.c524();
         double var10 = var1.c13885();
         double var12 = var1.c92054();
         float var14 = MotionUpdateEvent.c74012();
         float var15 = var1.c86825();
         boolean var16 = var1.c87166();
         double var17 = var8 - this.field_175172_bI;
         double var19 = var10 - this.field_175166_bJ;
         double var21 = var12 - this.field_175167_bK;
         double var23 = (double)(var14 - this.field_175164_bL);
         double var25 = (double)(var15 - this.field_175165_bM);
         if (var17 * var17 + var19 * var19 + var21 * var21 <= 9.0E-4D && this.field_175168_bP < 20) {
            boolean var30 = false;
         } else {
            boolean var10000 = true;
         }

         if (var23 == 0.0D && var25 == 0.0D) {
            boolean var32 = false;
         } else {
            boolean var31 = true;
         }

         this.field_71174_a.addToSendQueue(new C06PacketPlayerPosLook(var8, var10, var12, var14, var15, var16));
         ++this.field_175168_bP;
         this.field_175172_bI = var8;
         this.field_175166_bJ = var10;
         this.field_175167_bK = var12;
         this.field_175168_bP = 0;
         this.field_175164_bL = var14;
         this.field_175165_bM = var15;
         PostUpdateEvent var29 = new PostUpdateEvent(this.rotationYaw, this.rotationPitch);
         EventBus.getInstance().call(var29);
         this.rotationYaw = var2;
         this.rotationPitch = var3;
      }

   }

   public void moveEntity(double param1, double param3, double param5) {
      // $FF: Couldn't be decompiled
   }

   public void attackTargetEntityWithCurrentItem(Entity var1) {
      if (var1.canAttackWithItem() && !var1.hitByEntity(this)) {
         float var2 = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
         int var3 = 0;
         float var4 = 0.0F;
         if (var1 instanceof EntityLivingBase) {
            var4 = EnchantmentHelper.getModifierForCreature(this.getHeldItem(), ((EntityLivingBase)var1).getCreatureAttribute());
         } else {
            var4 = EnchantmentHelper.getModifierForCreature(this.getHeldItem(), EnumCreatureAttribute.UNDEFINED);
         }

         var3 = var3 + EnchantmentHelper.getKnockbackModifier(this);
         if (this.isSprinting()) {
            ++var3;
         }

         if (var2 > 0.0F || var4 > 0.0F) {
            if (this.fallDistance > 0.0F && !this.onGround && !this.isOnLadder() && !this.isInWater() && !this.isPotionActive(Potion.blindness) && this.ridingEntity == null && var1 instanceof EntityLivingBase) {
               boolean var22 = true;
            } else {
               boolean var10000 = false;
            }

            if (var2 > 0.0F) {
               var2 *= 1.5F;
            }

            var2 = var2 + var4;
            boolean var6 = false;
            int var7 = EnchantmentHelper.getFireAspectModifier(this);
            if (var1 instanceof EntityLivingBase && !var1.isBurning()) {
               var6 = true;
               var1.setFire(1);
            }

            double var8;
            double var10;
            double var12;
            label75: {
               var8 = var1.motionX;
               var10 = var1.motionY;
               var12 = var1.motionZ;
               var1.attackEntityFrom(DamageSource.causePlayerDamage(this), var2);
               var1.addVelocity((double)(-MathHelper.sin(this.rotationYaw * 3.1415927F / 180.0F) * (float)var3 * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * 3.1415927F / 180.0F) * (float)var3 * 0.5F));
               Sleep.getInstance();
               Sleep.c33759();
               if (!ModuleManager.c25475(KeepSprint.class).c24622()) {
                  Sleep.getInstance();
                  Sleep.c33759();
                  if (!ModuleManager.c25475(KillAura.class).c24622()) {
                     this.motionX *= 0.6D;
                     this.motionZ *= 0.6D;
                     this.setSprinting(false);
                     break label75;
                  }
               }

               KeepSprint.c18686(var1);
            }

            if (var1 instanceof EntityPlayerMP && var1.velocityChanged) {
               ((EntityPlayerMP)var1).playerNetServerHandler.sendPacket(new S12PacketEntityVelocity(var1));
               var1.velocityChanged = false;
               var1.motionX = var8;
               var1.motionY = var10;
               var1.motionZ = var12;
            }

            this.onCriticalHit(var1);
            if (var4 > 0.0F) {
               this.onEnchantmentCritical(var1);
            }

            if (var2 >= 18.0F) {
               this.triggerAchievement(AchievementList.overkill);
            }

            this.setLastAttacker(var1);
            if (var1 instanceof EntityLivingBase) {
               EnchantmentHelper.applyThornEnchantments((EntityLivingBase)var1, this);
            }

            EnchantmentHelper.applyArthropodEnchantments(this, var1);
            ItemStack var15 = this.getCurrentEquippedItem();
            Object var16 = var1;
            if (var1 instanceof EntityDragonPart) {
               IEntityMultiPart var17 = ((EntityDragonPart)var1).entityDragonObj;
               if (var17 instanceof EntityLivingBase) {
                  var16 = (EntityLivingBase)var17;
               }
            }

            if (var16 instanceof EntityLivingBase) {
               var15.hitEntity((EntityLivingBase)var16, this);
               if (var15.stackSize <= 0) {
                  this.destroyCurrentEquippedItem();
               }
            }

            if (var1 instanceof EntityLivingBase) {
               this.addStat(StatList.damageDealtStat, Math.round(var2 * 10.0F));
               var1.setFire(var7 * 4);
            }

            this.addExhaustion(0.3F);
         }
      }

   }

   @Shadow
   public boolean func_175160_A() {
      return false;
   }

   public boolean moving() {
      return (double)this.moveForward > 0.0D | (double)this.moveStrafing > 0.0D;
   }

   public float getSpeed() {
      float var1 = (float)Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
      return var1;
   }

   public void setSpeed(double var1) {
      this.motionX = (double)(-MathHelper.sin(this.getDirection())) * var1;
      this.motionZ = (double)MathHelper.cos(this.getDirection()) * var1;
   }

   public float getDirection() {
      float var1 = this.rotationYaw;
      float var2 = this.moveForward;
      float var3 = this.moveStrafing;
      var1 = var1 + (float)(var2 < 0.0F ? 180 : 0);
      if (var3 < 0.0F) {
         var1 += var2 < 0.0F ? -45.0F : (var2 == 0.0F ? 90.0F : 45.0F);
      }

      if (var3 > 0.0F) {
         var1 -= var2 < 0.0F ? -45.0F : (var2 == 0.0F ? 90.0F : 45.0F);
      }

      return var1 * 0.017453292F;
   }

   public void setYaw(double var1) {
      this.rotationYaw = (float)var1;
   }

   public void setPitch(double var1) {
      this.rotationPitch = (float)var1;
   }

   public void setMoveSpeed(MoveEvent var1, double var2) {
      double var4 = (double)this.field_71158_b.moveForward;
      double var6 = (double)this.field_71158_b.moveStrafe;
      float var8 = this.rotationYaw;
      if (var4 == 0.0D && var6 == 0.0D) {
         var1.c97676(0.0D);
         var1.c90383(0.0D);
      } else {
         if (var4 != 0.0D) {
            if (var6 > 0.0D) {
               var8 += (float)(var4 > 0.0D ? -45 : 45);
            } else if (var6 < 0.0D) {
               var8 += (float)(var4 > 0.0D ? 45 : -45);
            }

            var6 = 0.0D;
            if (var4 > 0.0D) {
               var4 = 1.0D;
            } else if (var4 < 0.0D) {
               var4 = -1.0D;
            }
         }

         var1.c97676(var4 * var2 * Math.cos(Math.toRadians((double)(var8 + 90.0F))) + var6 * var2 * Math.sin(Math.toRadians((double)(var8 + 90.0F))));
         var1.c90383(var4 * var2 * Math.sin(Math.toRadians((double)(var8 + 90.0F))) - var6 * var2 * Math.cos(Math.toRadians((double)(var8 + 90.0F))));
      }

   }

   public void setLastReportedPosY(double var1) {
      this.field_175166_bJ = var1;
   }
}
