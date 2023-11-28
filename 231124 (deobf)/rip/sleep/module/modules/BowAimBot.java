package rip.sleep.module.modules;

import java.awt.Color;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.INpc;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.event.events.Render3DEvent;
import rip.sleep.event.events.StartUpdateEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.RotationUtilC;
import rip.sleep.util.TimerUtilB;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.NumberValue;

public class BowAimBot extends Module {
   public ModeValue c15735 = new ModeValue("Priority", new String[]{"Fov", "Range", "Angle", "Armor", "Health", "Hurt Time"}, "Fov");
   private final NumberValue<Number> c27737 = new NumberValue<Number>("Range", Integer.valueOf(50), Integer.valueOf(40), Integer.valueOf(120), Integer.valueOf(1));
   private final NumberValue<Number> c58309 = new NumberValue<Number>("FOV", 360.0F, 0.0F, 360.0F, 1.0F);
   private final BooleanValue c20390 = new BooleanValue("Invisibles", false);
   private final BooleanValue c80206 = new BooleanValue("Players", true);
   private final BooleanValue c17199 = new BooleanValue("Animals", false);
   private final BooleanValue c17629 = new BooleanValue("Mobs", true);
   private final BooleanValue c79887 = new BooleanValue("Armor Stand", true);
   private final BooleanValue c5450 = new BooleanValue("Villagers", false);
   private final BooleanValue c38709 = new BooleanValue("Team", false);
   private final BooleanValue c36464 = new BooleanValue("Slient", true);
   private final BooleanValue c89107 = new BooleanValue("Auto Release", true);
   private final BooleanValue c67057 = new BooleanValue("Through Walls", true);
   private final BooleanValue c30253 = new BooleanValue("Clamp", false);
   private final BooleanValue c91825 = new BooleanValue("Prediction", false);
   private Entity c25456;
   float c80993;
   float c59658;
   final TimerUtilB c69755 = new TimerUtilB();

   public BowAimBot() {
      super("Bow AimBot", new String[]{"BowAimBot", "BowAimBot"}, ModuleType.c13050, ModuleType.c21190.c28329);
      this.c36162((new Color(235, 194, 138)).getRGB());
   }

   @EventTarget
   private void c78334(Render3DEvent var1) {
      Value.c27574();
      EntityLivingBase var3 = this.c9();
      this.c25456 = var3;
      if (this.c81978(mc.thePlayer) && var3 != null && var3 != mc.thePlayer) {
         double var4 = var3.posX - mc.thePlayer.posX;
         double var6 = var3.posY + (double)var3.getEyeHeight() - (mc.thePlayer.posY + (double) mc.thePlayer.getEyeHeight());
         double var8 = var3.posZ - mc.thePlayer.posZ;
         if (!(var3 instanceof EntityPlayer)) {
            var6 = var3.posY + (double)var3.getEyeHeight() - (mc.thePlayer.posY + (double) mc.thePlayer.getEyeHeight());
         }

         double var10 = (double)MathHelper.sqrt_double(var4 * var4 + var8 * var8);
         double var12 = this.c19151();
         double var14 = this.c31509();
         float var16 = c67220(var12, var14, var10, var6);
         float[] var17 = RotationUtilC.c38390(var3, false, false, false, this.c91825.c1473().booleanValue(), true, false, 0.0D, this.c30253.c1473().booleanValue(), 180.0F, 6.0D, false, 0);
         var16 = MathHelper.clamp_float(var16, -90.0F, 90.0F);
         this.c80993 = var17[0];
         this.c59658 = var16;
         if (var12 == 1.0D && this.c89107.c1473().booleanValue()) {
            if (!this.c69755.c59305(200L)) {
               return;
            }

            mc.playerController.onStoppedUsingItem(mc.thePlayer);
         }

         if (this.c89107.c1473().booleanValue()) {
            this.c69755.c69505();
         }
      }

   }

   @EventTarget
   private void c73835(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (this.c36464.c1473().booleanValue() && this.c33000(mc.thePlayer) && !Float.isNaN(this.c59658)) {
         var1.c6297(this.c80993);
         var1.c78602(this.c59658);
      }

   }

   @EventTarget
   private void c71217(StartUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (!this.c36464.c1473().booleanValue() && this.c33000(mc.thePlayer)) {
         mc.thePlayer.rotationYaw = this.c80993;
         mc.thePlayer.rotationPitch = this.c59658;
      }

   }

   public static float c67220(double var0, double var2, double var4, double var6) {
      return (float)(-Math.toDegrees(Math.atan2(Math.pow(var0, 2.0D) - Math.sqrt(Math.pow(var0, 4.0D) - var2 * (var2 * Math.pow(var4, 2.0D) + 2.0D * var6 * Math.pow(var0, 2.0D))), var2 * var4)));
   }

   private boolean c8314(EntityLivingBase var1) {
      Module[] var2 = Value.c27574();
      if (var1 instanceof EntityPlayer || var1 instanceof EntityAnimal || var1 instanceof EntityMob || var1 instanceof INpc) {
         if (var1 instanceof EntityPlayer && !this.c80206.c1473().booleanValue()) {
            return false;
         }

         if (var1 instanceof EntityAnimal && !this.c17199.c1473().booleanValue()) {
            return false;
         }

         if (var1 instanceof EntityMob && !this.c17629.c1473().booleanValue()) {
            return false;
         }

         if (var1 instanceof INpc && !this.c5450.c1473().booleanValue()) {
            return false;
         }
      }

      if (var1 instanceof EntityArmorStand && !this.c79887.c1473().booleanValue()) {
         return false;
      } else if (Teams.c55703(var1) && !this.c38709.c1473().booleanValue()) {
         return false;
      } else if (var1.isInvisible() && !this.c20390.c1473().booleanValue()) {
         return false;
      } else if (!this.c28507(var1, this.c58309.c53968().doubleValue())) {
         return false;
      } else if (!this.c67057.c1473().booleanValue() && !var1.canEntityBeSeen(mc.thePlayer)) {
         return false;
      } else if (AntiBot.c13506(var1)) {
         return false;
      } else {
         return var1 != mc.thePlayer && var1.isEntityAlive() && mc.thePlayer.getDistanceToEntity(var1) <= this.c27737.c53968().floatValue();
      }
   }

   private boolean c28507(EntityLivingBase var1, double var2) {
      var2 = var2 * 0.5D;
      Value.c27574();
      double var5 = (double)c96437(mc.thePlayer.rotationYaw, this.c97167(var1.posX, var1.posY, var1.posZ)[0]);
      return var5 > 0.0D && var5 < var2 || -var2 < var5 && var5 < 0.0D;
   }

   private static float c96437(float var0, float var1) {
      Value.c27574();
      float var3 = Math.abs(var1 - var0) % 360.0F;
      return var3 > 180.0F ? 360.0F - var3 : var3;
   }

   private float[] c97167(double var1, double var3, double var5) {
      double var7 = var1 + 0.5D - mc.thePlayer.posX;
      double var9 = (var3 + 0.5D) / 2.0D - (mc.thePlayer.posY + (double) mc.thePlayer.getEyeHeight());
      double var11 = var5 + 0.5D - mc.thePlayer.posZ;
      double var13 = (double)MathHelper.sqrt_double(var7 * var7 + var11 * var11);
      float var15 = (float)(Math.atan2(var11, var7) * 180.0D / 3.141592653589793D) - 90.0F;
      float var16 = (float)(-(Math.atan2(var9, var13) * 180.0D / 3.141592653589793D));
      return new float[]{var15, var16};
   }

   private static float[] c69867(Entity var0) {
      Module[] var1 = Value.c27574();
      if (var0 == null) {
         return null;
      } else {
         double var2 = var0.posX - Minecraft.getMinecraft().thePlayer.posX;
         double var4 = var0.posZ - Minecraft.getMinecraft().thePlayer.posZ;
         if (var0 instanceof EntityLivingBase) {
            EntityLivingBase var8 = (EntityLivingBase)var0;
            double var6 = var8.posY + (double)var8.getEyeHeight() - (Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight());
         }

         double var12 = (var0.getEntityBoundingBox().minY + var0.getEntityBoundingBox().maxY) / 2.0D - (Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight());
         double var13 = (double)MathHelper.sqrt_double(var2 * var2 + var4 * var4);
         float var10 = (float)(Math.atan2(var4, var2) * 180.0D / 3.141592653589793D) - 90.0F;
         float var11 = (float)(-(Math.atan2(var12, var13) * 180.0D / 3.141592653589793D));
         return new float[]{var10, var11};
      }
   }

   private static float c52660(float var0, float var1) {
      Value.c27574();
      float var3 = Math.abs(var0 - var1) % 360.0F;
      if (var3 > 180.0F) {
         var3 = 0.0F;
      }

      return var3;
   }

   private double c19151() {
      Value.c27574();
      int var2 = mc.thePlayer.getCurrentEquippedItem().getMaxItemUseDuration() - mc.thePlayer.getItemInUseCount();
      float var3 = (float)var2 / 20.0F;
      var3 = (var3 * var3 + var3 * 2.0F) / 3.0F;
      if (var3 > 1.0F) {
         var3 = 1.0F;
      }

      return (double)var3;
   }

   public boolean c33000(EntityPlayer var1) {
      Module[] var2 = Value.c27574();
      return this.c81978(var1) && this.c25456 != null;
   }

   public boolean c81978(EntityPlayer var1) {
      Module[] var2 = Value.c27574();
      return var1.isUsingItem() && mc.thePlayer.getCurrentEquippedItem() != null && mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemBow;
   }

   private double c31509() {
      return 0.006D;
   }

   private float c93304(Entity var1) {
      float var3 = 0.0F;
      Vec3 var4 = mc.thePlayer.getPositionEyes(1.0F);
      Value.c27574();
      float var8 = (float)var4.xCoord;
      float var9 = (float)var4.yCoord;
      float var10 = (float)var4.zCoord;
      var8 = (float)((double)var8 - (double)(MathHelper.cos(this.c80993 / 180.0F * 3.1415927F) * 0.16F));
      var9 = (float)((double)var9 - 0.10000000149011612D);
      var10 = (float)((double)var10 - (double)(MathHelper.sin(this.c80993 / 180.0F * 3.1415927F) * 0.16F));
      float var5 = -MathHelper.sin(this.c80993 / 180.0F * 3.1415927F) * MathHelper.cos(this.c59658 / 180.0F * 3.1415927F);
      float var7 = MathHelper.cos(this.c80993 / 180.0F * 3.1415927F) * MathHelper.cos(this.c59658 / 180.0F * 3.1415927F);
      float var6 = -MathHelper.sin(this.c59658 / 180.0F * 3.1415927F);

      while(true) {
         ++var3;
         float var11 = 0.99F;
         float var12 = 0.05F;
         Block var13 = mc.theWorld.getBlockState(new BlockPos((double)var8, (double)var9, (double)var10)).getBlock();
         if (var13 instanceof BlockLiquid) {
            var11 = 0.6F;
         }

         var8 += var5;
         var9 += var6;
         var10 += var7;
         var5 = (float)((double)var5 * (double)var11);
         var6 = (float)((double)var6 * (double)var11);
         var7 = (float)((double)var7 * (double)var11);
         var6 = (float)((double)var6 - 0.05000000074505806D);
         if (var1.getDistance((double)var8, (double)var9, (double)var10) <= 1.0D) {
            ;
         }

         if (mc.thePlayer.getDistance((double)var8, (double)var9, (double)var10) > (double) mc.thePlayer.getDistanceToEntity(var1)) {
            break;
         }
      }

      return var3;
   }

   private EntityLivingBase c9() {
      Value.c27574();
      Stream var2 = mc.theWorld.loadedEntityList.stream().filter((var0) -> {
         return var0 instanceof EntityLivingBase;
      }).map((var0) -> {
         return (EntityLivingBase)var0;
      }).filter(this::c8314);
      if (Objects.equals(this.c15735.c54460(), "Armor")) {
         var2 = var2.sorted(Comparator.comparingInt((var0) -> {
            Module[] var1 = Value.c27574();
            return var0 instanceof EntityPlayer ? ((EntityPlayer)var0).inventory.getTotalArmorValue() : (int)var0.getHealth();
         }));
      }

      if (Objects.equals(this.c15735.c54460(), "Range")) {
         var2 = var2.sorted((var0, var1) -> {
            return (int)(var0.getDistanceToEntity(mc.thePlayer) - var1.getDistanceToEntity(mc.thePlayer));
         });
      }

      if (Objects.equals(this.c15735.c54460(), "Fov")) {
         var2 = var2.sorted(Comparator.comparingDouble((var0) -> {
            return (double)c52660(mc.thePlayer.rotationPitch, c69867(var0)[0]);
         }));
      }

      if (Objects.equals(this.c15735.c54460(), "Angle")) {
         var2 = var2.sorted((var0, var1) -> {
            float[] var2 = c69867(var0);
            float[] var3 = c69867(var1);
            return (int)(mc.thePlayer.rotationYaw - var2[0] - (mc.thePlayer.rotationYaw - var3[0]));
         });
      }

      if (Objects.equals(this.c15735.c54460(), "Health")) {
         var2 = var2.sorted((var0, var1) -> {
            return (int)(var0.getHealth() - var1.getHealth());
         });
      }

      if (Objects.equals(this.c15735.c54460(), "Hurt Time")) {
         var2 = var2.sorted(Comparator.comparingInt((var0) -> {
            return 20 - var0.hurtResistantTime;
         }));
      }

      return (EntityLivingBase)var2.findFirst().orElse((Object)null);
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
