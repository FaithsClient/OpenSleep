package rip.sleep.module.modules;

import antiLeak.Loader;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import rip.sleep.injection.in.IEntityPlayer;
import rip.sleep.injection.in.IRenderManager;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockSign;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
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
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import org.json.JSONException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.*;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.struct.RotationStruct;
import rip.sleep.ui.notification.Notification;
import rip.sleep.util.*;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.MultiBooleanValue;
import rip.sleep.value.values.NumberValue;

public class KillAura extends Module {
   public static EntityLivingBase c19685;
   public static EntityLivingBase c62628;
   public static EntityLivingBase c97080;
   public static float c61744;
   public static float c73002;
   public static float c92377;
   private TimerUtilB c76731;
   public TimerUtilB c29301;
   private TimerUtilB c3899;
   private TimerUtilB c41923;
   public ArrayList<EntityLivingBase> c42084;
   private int c49650;
   private long c74044;
   private int c1199;
   private boolean c49604;
   private int c35912;
   private Random c72532;
   private final Random c64426;
   private final Random c23628;
   private final Random c45454;
   private final Random c96007;
   public static boolean c62171;
   public static boolean c1172;
   private boolean c16130;
   private boolean c87970;
   private int c86728;
   private int c48825;
   private RotationStruct c77852;
   private boolean c47966;
   public static ModeValue c18641;
   public ModeValue c98547;
   private ModeValue c21191;
   private ModeValue c30709;
   public ModeValue c23464;
   public static ModeValue c92537;
   public static MultiBooleanValue c55170;
   private final NumberValue<Number> c18799;
   private final NumberValue<Number> c39302;
   public static NumberValue<Number> c17384;
   private final NumberValue<Number> c65454;
   private final NumberValue<Number> c83890;
   private final NumberValue<Number> c12580;
   public static NumberValue<Number> c7038;
   private final NumberValue<Number> c31409;
   private final NumberValue<Number> c14002;
   private final NumberValue<Number> c69062;
   private final NumberValue<Number> c58253;
   private final NumberValue<Number> c28000;
   private final NumberValue<Number> c18391;
   private final NumberValue<Number> c57310;
   private final MultiBooleanValue c32195;
   private final NumberValue<Number> c50609;
   public static final BooleanValue c53732;
   public static final BooleanValue c83677;
   public static final BooleanValue c14566;
   public static final BooleanValue c90981;
   private static final String[] c34422;

   public KillAura() {
      String[] var1 = c34422;
      super(var1[20], new String[]{var1[19], var1[79], var1[9]}, ModuleType.c13050, ModuleType.c21190.c47958);
      this.c76731 = new TimerUtilB();
      this.c29301 = new TimerUtilB();
      this.c3899 = new TimerUtilB();
      this.c41923 = new TimerUtilB();
      this.c42084 = new ArrayList();
      this.c72532 = new Random();
      this.c64426 = new Random();
      this.c23628 = new Random();
      this.c45454 = new Random();
      this.c96007 = new Random();
      this.c47966 = false;
      this.c98547 = new ModeValue(var1[73], new String[]{var1[4], var1[8], var1[80], var1[77], var1[29], var1[100]}, var1[81]);
      this.c21191 = new ModeValue(var1[54], new String[]{var1[61], var1[85]}, var1[85]);
      this.c30709 = new ModeValue(var1[65], new String[]{var1[30], var1[51]}, var1[30]);
      this.c23464 = new ModeValue(var1[105], new String[]{var1[21], var1[17], var1[92], var1[62], var1[85]}, var1[21]);
      this.c18799 = new NumberValue<Number>(var1[93], var1[101], () -> {
         return this.c21191.c54460().equalsIgnoreCase(c34422[85]);
      }, Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(20), 0.1D);
      this.c39302 = new NumberValue<Number>(var1[86], var1[68], () -> {
         return this.c21191.c54460().equalsIgnoreCase(c34422[85]);
      }, Integer.valueOf(10), Integer.valueOf(0), Integer.valueOf(20), 0.1D);
      this.c65454 = new NumberValue<Number>(var1[87], var1[26], () -> {
         Module[] var0 = Value.c27574();
         return c92537.c54460().equalsIgnoreCase(c34422[58]) || c92537.c54460().equalsIgnoreCase(c34422[76]);
      }, 1.2D, Integer.valueOf(0), 1.5D, 0.1D);
      this.c83890 = new NumberValue<Number>(var1[81], var1[81], 180.0D, 10.0D, 360.0D, 10.0D);
      this.c12580 = new NumberValue<Number>(var1[49], var1[32], () -> {
         Module[] var0 = Value.c27574();
         return !c55170.c72319(c34422[16]).c1473().booleanValue();
      }, 180.0D, 10.0D, 360.0D, 10.0D);
      this.c31409 = new NumberValue<Number>(var1[50], var1[25], () -> {
         Module[] var0 = Value.c27574();
         return c18641.c54460().equalsIgnoreCase(c34422[106]) || c18641.c54460().equalsIgnoreCase(c34422[109]);
      }, 180.0D, 10.0D, 360.0D, 10.0D);
      this.c14002 = new NumberValue<Number>(var1[60], var1[6], () -> {
         Module[] var0 = Value.c27574();
         return !c55170.c72319(c34422[16]).c1473().booleanValue();
      }, 5.0D, 1.0D, 15.0D, 0.05D);
      this.c69062 = new NumberValue<Number>(var1[72], var1[39], () -> {
         return c55170.c72319(c34422[52]).c1473();
      }, 4.2D, 1.0D, 6.0D, 0.05D);
      this.c58253 = new NumberValue<Number>(var1[37], var1[3], () -> {
         Module[] var0 = Value.c27574();
         return c55170.c72319(c34422[63]).c1473().booleanValue() || c18641.c54460().equalsIgnoreCase(c34422[106]) || c18641.c54460().equalsIgnoreCase(c34422[113]);
      }, 1.0D, 1.0D, 50.0D, 1.0D);
      this.c28000 = new NumberValue<Number>(var1[57], var1[102], () -> {
         Module[] var0 = Value.c27574();
         return c18641.c54460().equalsIgnoreCase(c34422[106]) || c18641.c54460().equalsIgnoreCase(c34422[109]);
      }, 15.0D, 0.0D, 20.0D, 0.5D);
      this.c18391 = new NumberValue<Number>(var1[2], var1[27], 0.4D, 0.0D, 2.0D, 0.05D);
      this.c57310 = new NumberValue<Number>(var1[0], var1[97], () -> {
         Module[] var0 = Value.c27574();
         return c92537.c54460().equalsIgnoreCase(c34422[58]) || c92537.c54460().equalsIgnoreCase(c34422[76]);
      }, 6.0D, 0.0D, 25.0D, 1.0D);
      this.c32195 = new MultiBooleanValue(var1[44], new BooleanValue[]{new BooleanValue(var1[56], true), new BooleanValue(var1[99], false), new BooleanValue(var1[96], false), new BooleanValue(var1[94], false), new BooleanValue(var1[13], false), new BooleanValue(var1[48], false)});
      this.c50609 = new NumberValue<Number>(var1[14], var1[107], () -> {
         Module[] var0 = Value.c27574();
         return c92537.c54460().equalsIgnoreCase(c34422[58]) || c92537.c54460().equalsIgnoreCase(c34422[76]) && c55170.c72319(c34422[104]).c1473().booleanValue();
      }, 180.0D, 45.0D, 360.0D, 1.0D);
      this.c36162((new Color(226, 54, 30)).getRGB());
   }

   public void c83205() {
      super.c83205();
      this.c77852 = new RotationStruct(mc.thePlayer.rotationYaw, mc.thePlayer.rotationPitch);
      this.c42084.clear();
      c19685 = null;
      c97080 = null;
      this.c16130 = false;
      this.c49650 = 0;
      this.c76731.c69505();
      this.c41923.c69505();
      this.c3899.c69505();
      this.c29301.c69505();
   }

   public void c71897() {
      Value.c27574();
      super.c71897();
      if (mc.thePlayer != null) {
         this.c42084.clear();
         c97080 = null;
         this.c37888();
         this.c16130 = false;
         mc.gameSettings.keyBindUseItem.pressed = false;
      }

   }

   @EventTarget
   public final void c89547(StartUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (c14566.c1473().booleanValue()) {
         if (Objects.equals(c18641.c54460(), c34422[36])) {
            this.c2159("" + this.c42084.size());
         }

         if (Objects.equals(c18641.c54460(), c34422[112])) {
            this.c2159(c34422[106]);
         }

         if (!Objects.equals(c18641.c54460(), c34422[28])) {
            return;
         }

         this.c2159(c34422[53]);
      }

      int var3 = 0;
      int var4 = 0;
      if (var4 < 101) {
         var3 = var4++;
      }

      var4 = 0;
      if (c19685 != null) {
         var4 = c19685.hurtTime > 1 ? var3 : (int)c61278(40.0D, 90.0D);
      }

      if (mc.thePlayer.ticksExisted % HUD.c38600.c53968().intValue() == 0) {
         this.c2159(CPSRender.c45886 + c34422[91] + (c19685 != null ? "0" : var4) + c34422[115]);
      }

   }

   @EventTarget
   public void c86165(EndTickEvent var1) {
      Module[] var2 = Value.c27574();
      if ((!c55170.c72319(c34422[103]).c1473().booleanValue() || this.c99863(mc.thePlayer)) && (!c55170.c72319(c34422[12]).c1473().booleanValue() || Mouse.isButtonDown(0)) && (!c55170.c72319(c34422[18]).c1473().booleanValue() || !Mouse.isButtonDown(1))) {
         this.c20555();
         if (c55170.c72319(c34422[84]).c1473().booleanValue() && c97080 == null && !c47945(c19685, (double)c17384.c53968().floatValue())) {
            return;
         }

         this.c51287(var1);
      }

      String[] var3 = c34422;
      if (c55170.c72319(var3[18]).c1473().booleanValue() && Mouse.isButtonDown(1)) {
         this.c37888();
         this.c16130 = false;
         c97080 = null;
         this.c42084.clear();
      }

      var3 = c34422;
      if (c55170.c72319(var3[103]).c1473().booleanValue() && !this.c99863(mc.thePlayer)) {
         this.c37888();
         this.c16130 = false;
         c97080 = null;
         this.c42084.clear();
      }

      if (c55170.c72319(c34422[12]).c1473().booleanValue() && !Mouse.isButtonDown(0)) {
         this.c37888();
         this.c16130 = false;
         c97080 = null;
         this.c42084.clear();
      }

   }

   @EventTarget
   public void c24741(MotionUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (mc.currentScreen != null) {
         this.c37888();
         this.c16130 = false;
      } else {
         if (this.c34862()) {
            ((IEntityPlayer) mc.thePlayer).setItemInUseCount(999999);
            c1172 = true;
         }

         if (c19685 != null && (!this.c48596(mc.thePlayer) || !this.c99863(mc.thePlayer) && !mc.playerController.getIsHittingBlock())) {
            this.c70027(var1);
            if (Objects.equals(c92537.c54460(), c34422[58]) || Objects.equals(c92537.c54460(), c34422[76])) {
               if (!this.c3899.c65833(350L)) {
                  if (c53732.c1473().booleanValue()) {
                     mc.thePlayer.rotationYaw = this.c77852.c14509();
                     mc.thePlayer.rotationPitch = this.c77852.c86023();
                  }

                  var1.c6297(this.c77852.c14509());
                  var1.c78602(this.c77852.c86023());
               }

               c61744 = mc.thePlayer.rotationYaw;
               c73002 = mc.thePlayer.rotationPitch;
            }
         }

         if (!c55170.c72319(c34422[16]).c1473().booleanValue() && c97080 != null && this.c29301.c98583(this.c95379(), false)) {
            mc.thePlayer.swingItem();
            this.c29301.c69505();
         }

      }
   }

   @EventTarget
   public void c74166(EndUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (this.c16130) {
         this.c91446();
      }

   }

   public native void c51287(EndTickEvent var1);

   private native boolean c34862();

   private native void c45469();

   private native void c91446();

   private native boolean c82098();

   private native void c20039();

   private void c37888() {
      c19685 = null;
      this.c20039();
      this.c29301.c69505();
      this.c86728 = 0;
   }

   private void c70027(MotionUpdateEvent var1) {
      Value.c27574();
      float var3 = this.c77852.c14509();
      float var4 = this.c77852.c86023();
      if (Objects.equals(c92537.c54460(), c34422[21]) && c19685 != null) {
         ;
      }

      String var10000 = c92537.c54460();
      String[] var10 = c34422;
      if (Objects.equals(var10000, var10[76]) && c19685 != null && c64006(c19685, c7038.c53968().floatValue())) {
         if (this.c41923.c13761(Double.valueOf(c61278(150.0D, 250.0D)))) {
            c92377 = (float)c61278((double)(-this.c57310.c53968().floatValue()), (double)this.c57310.c53968().floatValue());
            this.c41923.c69505();
         }

         if (this.c42084.isEmpty()) {
            c19685 = null;
            if (this.c3899.c59305(150L) && !this.c3899.c59305(350L) && c55170.c72319(c34422[104]).c1473().booleanValue() && !ModuleManager.c25475(Scaffold.class).c24622()) {
               float[] var6 = new float[]{var3, var4};
               float[] var7 = new float[]{mc.thePlayer.rotationYaw, Math.max(Math.min(mc.thePlayer.rotationPitch, 90.0F), -90.0F)};
               float[] var8 = this.c45028(var7, var6);
               var3 = var8[0];
               var4 = Math.max(Math.min(var8[1], 90.0F), -90.0F);
            }
         }

         if (!this.c42084.isEmpty() && c19685 != null) {
            this.c3899.c69505();
            float[] var5 = this.c66315(c19685);
            float var14 = MathHelper.wrapAngleTo180_float(var5[0] + c92377 - var3);
            if (c55170.c72319(c34422[104]).c1473().booleanValue()) {
               float[] var17 = new float[]{var3, var4};
               float[] var20 = new float[]{var3 + var14, Math.max(Math.min(var5[1], 90.0F), -90.0F)};
               float[] var9 = this.c45028(var20, var17);
               var3 = var9[0];
               var4 = Math.max(Math.min(var9[1], 90.0F), -90.0F);
            }

            var3 = (float)((double)(var3 + var14) + ThreadLocalRandom.current().nextGaussian() * 1.1D);
            var4 = (float)Math.max(Math.min((double)var5[1] + ThreadLocalRandom.current().nextGaussian(), 90.0D), -90.0D);
         }
      }

      var10000 = c92537.c54460();
      var10 = c34422;
      if (Objects.equals(var10000, var10[58])) {
         if (this.c41923.c13761(Double.valueOf(c61278(150.0D, 250.0D)))) {
            c92377 = (float)c61278((double)(-this.c57310.c53968().floatValue()), (double)this.c57310.c53968().floatValue());
            this.c41923.c69505();
         }

         if (this.c42084.isEmpty()) {
            c19685 = null;
            if (this.c3899.c59305(150L) && !this.c3899.c59305(350L) && c55170.c72319(c34422[104]).c1473().booleanValue() && !ModuleManager.c25475(Scaffold.class).c24622()) {
               float[] var15 = new float[]{var3, var4};
               float[] var18 = new float[]{mc.thePlayer.rotationYaw, Math.max(Math.min(mc.thePlayer.rotationPitch, 90.0F), -90.0F)};
               float[] var21 = this.c45028(var18, var15);
               var3 = var21[0];
               var4 = Math.max(Math.min(var21[1], 90.0F), -90.0F);
            }
         }

         if (!this.c42084.isEmpty() && c19685 != null) {
            this.c3899.c69505();
            float[] var13 = this.c66315(c19685);
            float var16 = MathHelper.wrapAngleTo180_float(var13[0] + c92377 - var3);
            if (c55170.c72319(c34422[104]).c1473().booleanValue()) {
               float[] var19 = new float[]{var3, var4};
               float[] var22 = new float[]{var3 + var16, Math.max(Math.min(var13[1], 90.0F), -90.0F)};
               float[] var23 = this.c45028(var22, var19);
               var3 = var23[0];
               var4 = Math.max(Math.min(var23[1], 90.0F), -90.0F);
            }

            var3 = (float)((double)(var3 + var16) + ThreadLocalRandom.current().nextGaussian() * 1.1D);
            var4 = (float)Math.max(Math.min((double)var13[1] + ThreadLocalRandom.current().nextGaussian(), 90.0D), -90.0D);
         }
      }

      this.c77852.c87872(var3, var4);
      c61744 = var3;
      c73002 = var4;
   }

   private void c20555() {
      Value.c27574();
      c97080 = null;
      Iterator var2 = mc.theWorld.getLoadedEntityList().iterator();
      if (var2.hasNext()) {
         Entity var3 = (Entity)var2.next();
         if (var3 instanceof EntityLivingBase) {
            EntityLivingBase var4 = (EntityLivingBase)var3;
            if (this.c25103(var4)) {
               c97080 = var4;
            }
         }
      }

      c19685 = null;
      this.c42084.clear();
      var2 = mc.theWorld.getLoadedEntityList().iterator();
      if (var2.hasNext()) {
         Entity var11 = (Entity)var2.next();
         if (var11 instanceof EntityLivingBase) {
            EntityLivingBase var16 = (EntityLivingBase)var11;
            if (!this.c38129(var16)) {
               ;
            }

            if (TargetUtil.c45033(var11)) {
               this.c42084.clear();
               this.c42084.add(var16);
            }

            c97080 = null;
            this.c42084.add(var16);
            String var10000 = this.c98547.c54460();
            String[] var5 = c34422;
            if (Objects.equals(var10000, var5[70])) {
               this.c42084.sort(Comparator.comparingInt((var0) -> {
                  Module[] var1 = Value.c27574();
                  return var0 instanceof EntityPlayer ? ((EntityPlayer)var0).inventory.getTotalArmorValue() : (int)var0.getHealth();
               }));
            }

            if (Objects.equals(this.c98547.c54460(), c34422[8])) {
               this.c42084.sort((var0, var1) -> {
                  return (int)(var0.getDistanceToEntity(mc.thePlayer) - var1.getDistanceToEntity(mc.thePlayer));
               });
            }

            if (Objects.equals(this.c98547.c54460(), c34422[81])) {
               this.c42084.sort(Comparator.comparingDouble(this::c47394));
            }

            if (Objects.equals(this.c98547.c54460(), c34422[95])) {
               this.c42084.sort(Comparator.comparingInt((var0) -> {
                  return 20 - var0.hurtResistantTime;
               }));
            }

            if (Objects.equals(this.c98547.c54460(), c34422[35])) {
               this.c42084.sort((var0, var1) -> {
                  float[] var2 = c69867(var0);
                  float[] var3 = c69867(var1);
                  return (int)(mc.thePlayer.rotationYaw - var2[0] - (mc.thePlayer.rotationYaw - var3[0]));
               });
            }

            if (Objects.equals(this.c98547.c54460(), c34422[75])) {
               this.c42084.sort((var0, var1) -> {
                  return (int)(var0.getHealth() - var1.getHealth());
               });
            }
         }
      }

      String[] var17 = c34422;
      if (this.c32195.c72319(var17[67]).c1473().booleanValue()) {
         var2 = this.c42084.iterator();
         if (var2.hasNext()) {
            EntityLivingBase var12 = (EntityLivingBase)var2.next();
            if (var12 instanceof EntityWither) {
               this.c42084.clear();
               this.c42084.add(var12);
            }
         }
      }

      if (this.c76731.c65833((long)this.c28000.c53968().intValue() * 100L) && this.c42084.size() > 1) {
         this.c76731.c69505();
         ++this.c49650;
      }

      if (!this.c42084.isEmpty() && this.c49650 >= this.c42084.size()) {
         this.c49650 = 0;
      }

      if (c90981.c1473().booleanValue()) {
         var2 = this.c42084.iterator();
         if (var2.hasNext()) {
            EntityLivingBase var13 = (EntityLivingBase)var2.next();
            if (var13 instanceof EntityPlayer && this.c38129(var13) && !TargetUtil.c45033(var13) && var13.getHealth() < 10.0F && !Teams.c55703(var13)) {
               Sleep.INSTANCE.c43557().c36876.c30803(var13.getName());
               PlayerUtilG.c11143(c34422[45] + var13.getName());
               Sleep.INSTANCE.c83083().c43114().add(new Notification(c34422[114] + var13.getName()));
            }
         }
      }

      if (c90981.c1473().booleanValue()) {
         var2 = this.c42084.iterator();
         if (var2.hasNext()) {
            EntityLivingBase var14 = (EntityLivingBase)var2.next();
            if (var14 instanceof EntityPlayer && TargetUtil.c45033(var14) && ((double) mc.thePlayer.getDistanceToEntity(var14) >= (double)c17384.c53968().floatValue() || var14.isDead) && !Teams.c55703(var14)) {
               Sleep.INSTANCE.c43557().c36876.c36634(var14.getName());
            }
         }
      }

      String var20 = c18641.c54460();
      var17 = c34422;
      if (Objects.equals(var20, var17[109])) {
         if (!this.c42084.isEmpty()) {
            c19685 = (EntityLivingBase)this.c42084.get(this.c49650);
         }

         var2 = this.c42084.iterator();
         if (var2.hasNext()) {
            EntityLivingBase var15 = (EntityLivingBase)var2.next();
            if (var15 instanceof EntityPlayer && this.c38129(var15) && var15.getHealth() < 10.0F && !Teams.c55703(var15) && !this.c42084.isEmpty()) {
               c19685 = (EntityLivingBase)this.c42084.get(0);
            }
         }
      }

      var20 = c18641.c54460();
      var17 = c34422;
      if (!Objects.equals(var20, var17[109]) && !this.c42084.isEmpty()) {
         c19685 = (EntityLivingBase)this.c42084.get(Objects.equals(c18641.c54460(), c34422[106]) ? this.c49650 : 0);
         if (!this.c66110(c19685, this.c31409.c53968().floatValue())) {
            c19685 = (EntityLivingBase)this.c42084.get(0);
         }
      }

   }

   private boolean c6367() {
      Value.c27574();
      String var2 = mc.thePlayer.getHeldItem().getDisplayName();
      return var2 != null && var2.matches(c34422[24]);
   }

   private static float[] c60423(Entity var0, float var1, float var2, float var3) {
      Value.c27574();
      EntityPlayerSP var7 = Minecraft.getMinecraft().thePlayer;
      double var8 = var0.posX - var7.posX;
      double var10 = var0.posZ - var7.posZ;
      double var12 = var0.posY - var7.posY;
      double var14 = StrictMath.sqrt(var8 * var8 + var10 * var10);
      AxisAlignedBB var16 = var0.getEntityBoundingBox().expand(0.10000000149011612D, 0.10000000149011612D, 0.10000000149011612D);
      double var17 = var7.posY + (double)var7.getEyeHeight();
      boolean var19 = var14 < 3.0D && Math.abs(var12) < 3.0D;
      boolean var6 = var14 < 1.0D && Math.abs(var12) < 1.0D;
      if (var19 && var17 > var16.minY) {
         if (var6 && var17 > var16.minY) {
            float var24 = 90.0F;
         } else {
            float var10000 = 60.0F;
         }
      }

      var12 = var17 > var16.maxY ? var16.maxY - var17 : (var17 < var16.minY ? var16.minY - var17 : 0.0D);
      float var5 = (float)(-(StrictMath.atan2(var12, var14) * 57.29577951308232D));
      float var21 = (float)(StrictMath.atan2(var10, var8) * 57.29577951308232D) - 90.0F;
      if (var19 && var6) {
         int var22 = var14 < 1.0D ? 180 : 90;
         var21 = (float)(Math.round(var21 / (float)var22) * var22);
      }

      return new float[]{var21, var5};
   }

   private boolean c25103(EntityLivingBase var1) {
      Value.c27574();
      double var3 = mc.thePlayer.posX - var1.posX;
      double var5 = mc.thePlayer.posZ - var1.posZ;
      boolean var7 = (double)MathHelper.sqrt_double(var3 * var3 + var5 * var5) <= this.c18391.c53968().doubleValue();
      Teams var8 = (Teams) ModuleManager.c25475(Teams.class);
      AntiBot var9 = (AntiBot) ModuleManager.c25475(AntiBot.class);
      if (!this.c66110(var1, this.c12580.c53968().floatValue()) && !var7) {
         return false;
      } else if (mc.thePlayer.isEntityAlive() && !mc.thePlayer.isPlayerSleeping() && !mc.thePlayer.isDead && mc.thePlayer.getHealth() > 0.0F && !Teams.c55703(var1) && (double) mc.thePlayer.getDistanceToEntity(var1) < (double)this.c14002.c53968().floatValue() && var1.isEntityAlive() && !var1.isDead && var1.getHealth() > 0.0F && !(var1 instanceof EntityArmorStand) && !AntiBot.c13506(var1) && var1 != mc.thePlayer) {
         if (var1 instanceof EntityPlayer) {
            EntityPlayer var10 = (EntityPlayer)var1;
            if (var10.getDisplayName().getFormattedText().contains(c34422[34])) {
               return false;
            }

            if (Sleep.getInstance().c43557().c25756.c43312(var10.getName())) {
               return false;
            }

            String[] var11 = c34422;
            if (!this.c32195.c72319(var11[56]).c1473().booleanValue()) {
               return false;
            }

            if (var10.isPlayerSleeping()) {
               return false;
            }

            if (var10.isPotionActive(Potion.invisibility) && !this.c32195.c72319(c34422[48]).c1473().booleanValue()) {
               return false;
            }
         }

         return this.c84439(var1);
      } else {
         return false;
      }
   }

   public double c94663(EntityLivingBase var1) {
      Value.c27574();
      Vec3 var3 = new Vec3(mc.thePlayer.posX, mc.thePlayer.posY + (double) mc.thePlayer.getEyeHeight(), mc.thePlayer.posZ);
      double var4 = mc.thePlayer.posY - var1.posY;
      double var6 = var4 > 0.0D ? var1.posY + (double)var1.getEyeHeight() : (-var4 < (double) mc.thePlayer.getEyeHeight() ? mc.thePlayer.posY + (double) mc.thePlayer.getEyeHeight() : var1.posY);
      Vec3 var8 = new Vec3(var1.posX, var6, var1.posZ);
      return var3.distanceTo(var8) - 0.30000001192092896D;
   }

   public boolean c38129(EntityLivingBase var1) {
      Value.c27574();
      double var3 = mc.thePlayer.posX - var1.posX;
      double var5 = mc.thePlayer.posZ - var1.posZ;
      boolean var7 = (double)MathHelper.sqrt_double(var3 * var3 + var5 * var5) <= this.c18391.c53968().doubleValue();
      if (!this.c66110(var1, this.c83890.c53968().floatValue()) && !var7) {
         return false;
      } else {
         if (mc.thePlayer.isEntityAlive() && !mc.thePlayer.isPlayerSleeping() && !mc.thePlayer.isDead && mc.thePlayer.getHealth() > 0.0F && !Teams.c55703(var1)) {
            if (mc.thePlayer.canEntityBeSeen(var1)) {
               if ((double) mc.thePlayer.getDistanceToEntity(var1) >= (double)c17384.c53968().floatValue()) {
                  return false;
               }
            } else {
               String[] var9 = c34422;
               if (!c55170.c72319(var9[52]).c1473().booleanValue() || (double) mc.thePlayer.getDistanceToEntity(var1) >= (double)this.c69062.c53968().floatValue()) {
                  return false;
               }
            }

            if (var1.isEntityAlive() && !var1.isDead && var1.getHealth() > 0.0F && !(var1 instanceof EntityArmorStand) && !AntiBot.c13506(var1) && var1 != mc.thePlayer) {
               if (var1 instanceof EntityPlayer) {
                  EntityPlayer var8 = (EntityPlayer)var1;
                  if (var8.getDisplayName().getFormattedText().contains(c34422[23])) {
                     return false;
                  }

                  if (Sleep.getInstance().c43557().c25756.c43312(var8.getName())) {
                     return false;
                  }

                  String[] var10 = c34422;
                  if (!this.c32195.c72319(var10[43]).c1473().booleanValue()) {
                     return false;
                  }

                  if (var8.isPlayerSleeping()) {
                     return false;
                  }

                  if (var8.isPotionActive(Potion.invisibility) && !this.c32195.c72319(c34422[82]).c1473().booleanValue()) {
                     return false;
                  }
               }

               return this.c84439(var1);
            }
         }

         return false;
      }
   }

   public long c95379() {
      Value.c27574();
      int var2 = this.c39302.c53968().intValue();
      int var3 = this.c18799.c53968().intValue();
      int var4 = var2 - var3;
      int var5 = var4 <= 0 ? var3 : this.c64426.nextInt(var4) + var3 + 1;
      if (var5 == 0) {
         var5 = 1;
      }

      if (!this.c49604) {
         this.c74044 = (long)(1000 / var5);
         if (this.c96007.nextInt(4) == 1) {
            this.c49604 = true;
            this.c35912 = 1 + this.c96007.nextInt(5);
         }

         if (this.c96007.nextInt(10) != 1 && this.c96007.nextInt(10) == 1) {
            this.c49604 = true;
            this.c35912 = 5 + this.c96007.nextInt(10);
         }
      }

      if (this.c49604) {
         ++this.c1199;
         if (this.c1199 >= this.c35912) {
            this.c1199 = 0;
            this.c49604 = false;
         }
      }

      boolean var6 = true;
      if (this.c23628.nextInt(48) % 10 == 0 && !this.c49604) {
         boolean var7 = true;
         this.c74044 += (long)(this.c45454.nextInt(45) + 25);
      }

      return this.c74044;
   }

   public boolean c47068() {
      Module[] var1 = Value.c27574();
      return mc.objectMouseOver.getBlockPos() != null && (PlayerUtil.c59727(mc.objectMouseOver.getBlockPos()) instanceof BlockEnderChest || PlayerUtil.c59727(mc.objectMouseOver.getBlockPos()) instanceof BlockChest || PlayerUtil.c59727(mc.objectMouseOver.getBlockPos()) instanceof BlockSign) || PlayerUtil.c59727(mc.objectMouseOver.getBlockPos()) instanceof BlockWorkbench || PlayerUtil.c59727(mc.objectMouseOver.getBlockPos()) instanceof BlockFurnace || PlayerUtil.c59727(mc.objectMouseOver.getBlockPos()) instanceof BlockAnvil;
   }

   public static boolean c64006(Entity var0, float var1) {
      Module[] var2 = Value.c27574();
      return (Math.abs(c69867(var0)[0] - Minecraft.getMinecraft().thePlayer.rotationYaw) % 360.0F > 180.0F ? 360.0F - Math.abs(c69867(var0)[0] - Minecraft.getMinecraft().thePlayer.rotationYaw) % 360.0F : Math.abs(c69867(var0)[0] - Minecraft.getMinecraft().thePlayer.rotationYaw) % 360.0F) >= var1;
   }

   public float[] c66315(EntityLivingBase var1) {
      double var5 = var1.posX;
      Value.c27574();
      double var7 = var1.posZ;
      if (var1 instanceof EntityEnderman) {
         double var3 = var1.posY - mc.thePlayer.posY;
      }

      double var9 = (double) mc.thePlayer.getEyeHeight() - (1.65D + this.c65454.c53968().doubleValue());
      double var11 = var1.posY + (double)var1.getEyeHeight() - 1.5D < mc.thePlayer.posY + var9 ? var1.posY + (double)var1.getEyeHeight() - mc.thePlayer.posY + ((double) mc.thePlayer.getEyeHeight() - 3.0D) : (var1.posY - 1.5D > mc.thePlayer.posY + var9 ? var1.posY - 3.0D - mc.thePlayer.posY + (double) mc.thePlayer.getEyeHeight() : var9);
      return this.c59039(var5, var7, var11);
   }

   public float[] c59039(double var1, double var3, double var5) {
      double var7 = var1 - mc.thePlayer.posX;
      double var9 = var3 - mc.thePlayer.posZ;
      double var11 = (double)MathHelper.sqrt_double(var7 * var7 + var9 * var9);
      float var13 = (float)(Math.atan2(var9, var7) * 180.0D / 3.141592653589793D) - 90.0F;
      float var14 = (float)(-(Math.atan2(var5, var11) * 180.0D / 3.141592653589793D));
      return new float[]{var13, var14};
   }

   private double c47394(EntityLivingBase var1) {
      Value.c27574();
      Vec3 var3 = var1.getPositionVector().addVector(0.0D, (double)(var1.getEyeHeight() / 2.0F), 0.0D).subtract(mc.thePlayer.getPositionVector().addVector(0.0D, (double) mc.thePlayer.getEyeHeight(), 0.0D));
      double var4 = Math.abs((double) mc.thePlayer.rotationYaw - (Math.toDegrees(Math.atan2(var3.zCoord, var3.xCoord)) - 90.0D)) % 360.0D;
      return var4 > 180.0D ? 360.0D - var4 : var4;
   }

   private float[] c45028(float[] var1, float[] var2) {
      float[] var4 = c95859(new float[]{var2[0] - var1[0], var2[1] - var1[1]});
      float var5 = MathUtilF.c25789(this.c50609.c53968().floatValue() - 20.0F, this.c50609.c53968().floatValue() - 10.0F);
      Value.c27574();
      float var6 = MathUtilF.c25789(this.c50609.c53968().floatValue() - 10.0F, this.c50609.c53968().floatValue());
      if (c19685 != null) {
         Iterator var7 = this.c18435(var2[0], var2[1]).iterator();
         if (var7.hasNext()) {
            MovingObjectPosition var8 = (MovingObjectPosition)var7.next();
            if (var8.entityHit != null && var8.entityHit != mc.thePlayer && this.c38129((EntityLivingBase)var8.entityHit)) {
               var6 = (float)((double)var6 * 0.3D);
            }
         }
      }

      var4[0] = var2[0] - var4[0] / 180.0F * (var5 / 2.0F);
      var4[1] = var2[1];
      var4[0] = PlayerUtilF.c55769(var4[0], var1[0], var5);
      var4[1] = PlayerUtilF.c55769(var4[1], Math.max(Math.min(var1[1], 90.0F), -90.0F), var6);
      return var4;
   }

   public static boolean c47945(Entity var0, double var1) {
      return RayTraceUtilB.c45144(var1, (var1x) -> {
         Module[] var2 = Value.c27574();
         return var0 != null && var0.equals(var1x);
      }) != null;
   }

   public List<MovingObjectPosition> c18435(float var1, float var2) {
      Value.c27574();
      ArrayList var4 = new ArrayList();
      Entity var5 = mc.getRenderViewEntity();
      if (var5 != null && mc.theWorld != null) {
         float var6 = c19685.getCollisionBorderSize();
         float var7 = 1.0F;
         Vec3 var8 = var5.getPositionEyes(1.0F);
         Vec3 var9 = RotationUtilA.getVectorForRotation(var1, var2);
         Vec3 var10 = var8.addVector(var9.xCoord * (double)var6, var9.yCoord * (double)var6, var9.zCoord * (double)var6);
         List var11 = mc.theWorld.getEntitiesInAABBexcluding(var5, var5.getEntityBoundingBox().addCoord(var9.xCoord * (double)var6, var9.yCoord * (double)var6, var9.zCoord * (double)var6).expand((double)var7, (double)var7, (double)var7), Predicates.and(EntitySelectors.NOT_SPECTATING, Entity::canBeCollidedWith));
         Iterator var12 = var11.iterator();
         if (var12.hasNext()) {
            Entity var13 = (Entity)var12.next();
            float var14 = var13.getCollisionBorderSize();
            AxisAlignedBB var15 = var13.getEntityBoundingBox().expand((double)var14, (double)var14, (double)var14);
            MovingObjectPosition var16 = var15.calculateIntercept(var8, var10);
            if (var16 != null) {
               var16.entityHit = var13;
               var4.add(new MovingObjectPosition(var13, var16.hitVec));
            }
         }
      }

      if (var5 != null) {
         var4.sort((var1x, var2x) -> {
            Vec3 var3 = var5.getPositionEyes(1.0F);
            return (int)((var3.distanceTo(var1x.hitVec) - var3.distanceTo(var2x.hitVec)) * 100.0D);
         });
      }

      return var4;
   }

   public static float[] c95859(float[] var0) {
      var0[0] %= 360.0F;
      Value.c27574();
      var0[1] %= 360.0F;
      if (var0[0] <= -180.0F) {
         var0[0] += 360.0F;
      }

      if (var0[1] <= -180.0F) {
         var0[1] += 360.0F;
      }

      if (var0[0] > 180.0F) {
         var0[0] -= 360.0F;
      }

      if (var0[1] > 180.0F) {
         var0[1] -= 360.0F;
      }

      return var0;
   }

   @EventTarget
   public void c80909(Render3DEvent var1) {
      Module[] var2 = Value.c27574();
      if ((!c55170.c72319(c34422[46]).c1473().booleanValue() || this.c99863(mc.thePlayer)) && (!c55170.c72319(c34422[47]).c1473().booleanValue() || Mouse.isButtonDown(0))) {
         if (c19685 != null && Objects.equals(this.c23464.c54460(), c34422[5])) {
            Color var3 = new Color(200, 255, 100, 75);
            String[] var33 = c34422;
            if (c55170.c72319(var33[78]).c1473().booleanValue()) {
               Iterator var4 = this.c42084.iterator();
               if (var4.hasNext()) {
                  EntityLivingBase var5 = (EntityLivingBase)var4.next();
                  int var6 = this.c58253.c53968().intValue();
                  if (c55170.c72319(c34422[63]).c1473().booleanValue() && this.c42084.size() > var6) {
                     this.c42084.subList(var6, this.c42084.size()).clear();
                  }

                  RenderUtilD.c96014(var5, var5.hurtTime > 3 ? var3 : new Color(235, 40, 40, 75));
               }
            }

            EntityLivingBase var39 = c19685;
            RenderUtilD.c96014(var39, var39.hurtTime > 3 ? var3 : new Color(235, 40, 40, 75));
         }

         if (c19685 != null && Objects.equals(this.c23464.c54460(), c34422[110])) {
            if (c55170.c72319(c34422[63]).c1473().booleanValue()) {
               Iterator var34 = this.c42084.iterator();
               if (var34.hasNext()) {
                  EntityLivingBase var40 = (EntityLivingBase)var34.next();
                  int var45 = this.c58253.c53968().intValue();
                  if (c55170.c72319(c34422[63]).c1473().booleanValue() && this.c42084.size() > var45) {
                     this.c42084.subList(var45, this.c42084.size()).clear();
                  }

                  this.c32023(var40, 0.67D, (new Color(HUD.c64734.c41161().intValue())).getRGB(), true);
               }
            }

            EntityLivingBase var35 = c19685;
            this.c32023(var35, 0.67D, (new Color(HUD.c64734.c41161().intValue())).getRGB(), true);
         }

         if (c19685 != null && Objects.equals(this.c23464.c54460(), c34422[10])) {
            Color var36 = new Color(200, 255, 100, 75);
            String[] var62 = c34422;
            if (c55170.c72319(var62[63]).c1473().booleanValue()) {
               Iterator var41 = this.c42084.iterator();
               if (var41.hasNext()) {
                  EntityLivingBase var46 = (EntityLivingBase)var41.next();
                  int var49 = this.c58253.c53968().intValue();
                  if (c55170.c72319(c34422[63]).c1473().booleanValue() && this.c42084.size() > var49) {
                     this.c42084.subList(var49, this.c42084.size()).clear();
                  }

                  RenderUtilD.c41893(var46, var46.hurtTime >= 1 ? var36 : new Color(235, 40, 40, 75));
               }
            }

            EntityLivingBase var42 = c19685;
            GL11.glPushMatrix();
            RenderUtilD.c72684();
            mc.entityRenderer.setupCameraTransform(mc.timer.renderPartialTicks, 2);
            double var47 = c19685.prevPosX + (c19685.posX - c19685.prevPosX) * (double)var1.c36064() - mc.getRenderManager().renderPosX;
            double var7 = c19685.prevPosY + (c19685.posY - c19685.prevPosY) * (double)var1.c36064() - mc.getRenderManager().renderPosY;
            double var9 = c19685.prevPosZ + (c19685.posZ - c19685.prevPosZ) * (double)var1.c36064() - mc.getRenderManager().renderPosZ;
            double var11 = c19685.posX;
            double var13 = c19685.posY;
            double var15 = c19685.posZ;
            double var17 = c19685.posX;
            double var19 = c19685.posY;
            double var21 = c19685.posZ;
            double var23 = 0.008333333333333333D;
            double var25 = (var17 - var11) / var23;
            double var27 = (var19 - var13) / var23;
            double var29 = (var21 - var15) / var23;
            double var31 = Math.sqrt(var25 * var25 + var27 * var27 + var29 * var29);
            GlStateManager.translate(var47 + var31, var7 + var31, var9 + var31);
            GL11.glPushMatrix();
            RenderUtilD.c41893(var42, var42.hurtTime >= 1 ? var36 : new Color(235, 40, 40, 75));
            GL11.glPopMatrix();
            RenderUtilD.c19925();
            GL11.glPopMatrix();
         }

         if (c19685 != null && Objects.equals(this.c23464.c54460(), c34422[1])) {
            if (c55170.c72319(c34422[63]).c1473().booleanValue()) {
               Iterator var37 = this.c42084.iterator();
               if (var37.hasNext()) {
                  EntityLivingBase var43 = (EntityLivingBase)var37.next();
                  double var48 = var43.lastTickPosX + (var43.posX - var43.lastTickPosX) * (double) ChatUtilA.c14057().renderPartialTicks - ((IRenderManager) mc.getRenderManager()).getRenderPosX();
                  double var51 = var43.lastTickPosY + (var43.posY - var43.lastTickPosY) * (double) ChatUtilA.c14057().renderPartialTicks - ((IRenderManager) mc.getRenderManager()).getRenderPosY();
                  double var52 = var43.lastTickPosZ + (var43.posZ - var43.lastTickPosZ) * (double) ChatUtilA.c14057().renderPartialTicks - ((IRenderManager) mc.getRenderManager()).getRenderPosZ();
                  double var53 = var43.getEntityBoundingBox().maxX - var43.getEntityBoundingBox().minX - 0.2D;
                  double var54 = var43.getEntityBoundingBox().maxY - var43.getEntityBoundingBox().minY + 0.15D;
                  float var55 = 10.0F - (float)(var43.hurtTime * 5) / 255.0F;
                  float var16 = (float)(var43.hurtTime * 10) / 255.0F;
                  float var58 = (float)(var43.hurtTime * 2) / 255.0F;
                  float var18 = (float)(80 + var43.hurtTime * 10) / 350.0F;
                  float var61 = (float)(80 + var43.hurtTime * 10) / 500.0F;
                  int var20 = this.c58253.c53968().intValue();
                  if (c55170.c72319(c34422[63]).c1473().booleanValue() && this.c42084.size() > var20) {
                     this.c42084.subList(var20, this.c42084.size()).clear();
                  }

                  if (var43.hurtTime >= 1) {
                     RenderUtilF.c63437(var48, var51, var52, var53, var54, var55, var16, var58, var18, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
                  }

                  RenderUtilF.c63437(var48, var51, var52, var53, var54, var55, var16, var58, var61, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
               }
            }

            EntityLivingBase var38 = c19685;
            double var44 = var38.lastTickPosX + (var38.posX - var38.lastTickPosX) * (double) ChatUtilA.c14057().renderPartialTicks - ((IRenderManager) mc.getRenderManager()).getRenderPosX();
            double var50 = var38.lastTickPosY + (var38.posY - var38.lastTickPosY) * (double) ChatUtilA.c14057().renderPartialTicks - ((IRenderManager) mc.getRenderManager()).getRenderPosY();
            double var8 = var38.lastTickPosZ + (var38.posZ - var38.lastTickPosZ) * (double) ChatUtilA.c14057().renderPartialTicks - ((IRenderManager) mc.getRenderManager()).getRenderPosZ();
            double var10 = var38.getEntityBoundingBox().maxX - var38.getEntityBoundingBox().minX - 0.2D;
            double var12 = var38.getEntityBoundingBox().maxY - var38.getEntityBoundingBox().minY + 0.15D;
            float var14 = 10.0F - (float)(var38.hurtTime * 5) / 255.0F;
            float var56 = (float)(var38.hurtTime * 10) / 255.0F;
            float var57 = (float)(var38.hurtTime * 2) / 255.0F;
            float var59 = (float)(80 + var38.hurtTime * 10) / 350.0F;
            float var60 = (float)(80 + var38.hurtTime * 10) / 500.0F;
            if (var38.hurtTime >= 1) {
               RenderUtilF.c63437(var44, var50, var8, var10, var12, var14, var56, var57, var59, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
            }

            RenderUtilF.c63437(var44, var50, var8, var10, var12, var14, var56, var57, var60, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
         }
      }

   }

   public boolean c84439(Entity var1) {
      Module[] var2 = Value.c27574();
      if (var1 instanceof EntityAnimal) {
         return this.c32195.c72319(c34422[108]).c1473().booleanValue();
      } else if (var1 instanceof EntityMob) {
         return this.c32195.c72319(c34422[83]).c1473().booleanValue();
      } else {
         return !(var1 instanceof EntityVillager) && !(var1 instanceof EntityIronGolem) && !(var1 instanceof EntitySnowman) ? true : this.c32195.c72319(c34422[55]).c1473().booleanValue();
      }
   }

   public static float[] c69867(Entity var0) {
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

   private void c32023(Entity var1, double var2, int var4, boolean var5) {
      Value.c27574();
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
      GlStateManager.alphaFunc(516, 0.0F);
      if (var5) {
         GL11.glShadeModel(7425);
      }

      GlStateManager.disableCull();
      GL11.glBegin(5);
      double var7 = var1.lastTickPosX + (var1.posX - var1.lastTickPosX) * (double) mc.timer.renderPartialTicks;
      mc.getRenderManager();
      double var9 = var7 - ((IRenderManager) mc.getRenderManager()).getRenderPosX();
      var7 = var1.lastTickPosY + (var1.posY - var1.lastTickPosY) * (double) mc.timer.renderPartialTicks;
      mc.getRenderManager();
      double var11 = var7 - ((IRenderManager) mc.getRenderManager()).getRenderPosY() + Math.sin((double)System.currentTimeMillis() / 200.0D) + 1.0D;
      var7 = var1.lastTickPosZ + (var1.posZ - var1.lastTickPosZ) * (double) mc.timer.renderPartialTicks;
      mc.getRenderManager();
      double var13 = var7 - ((IRenderManager) mc.getRenderManager()).getRenderPosZ();
      float var15 = 0.0F;
      if ((double)var15 < 6.283185307179586D) {
         double var16 = var9 + var2 * Math.cos((double)var15);
         double var18 = var13 + var2 * Math.sin((double)var15);
         Color var20 = new Color(HUD.c64734.c41161().intValue());
         if (var5) {
            GL11.glColor4f((float)var20.getRed() / 255.0F, (float)var20.getGreen() / 255.0F, (float)var20.getBlue() / 255.0F, 0.0F);
            GL11.glVertex3d(var16, var11 - Math.cos((double)System.currentTimeMillis() / 200.0D) / 2.0D, var18);
            GL11.glColor4f((float)var20.getRed() / 255.0F, (float)var20.getGreen() / 255.0F, (float)var20.getBlue() / 255.0F, 0.65F);
         }

         GL11.glVertex3d(var16, var11, var18);
         var15 = (float)((double)var15 + 0.09817477042468103D);
      }

      GL11.glEnd();
      if (var5) {
         GL11.glShadeModel(7424);
      }

      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GlStateManager.alphaFunc(516, 0.1F);
      GlStateManager.enableCull();
      GL11.glDisable(2848);
      GL11.glDisable(2848);
      GL11.glEnable(2832);
      GL11.glEnable(3553);
      GL11.glPopMatrix();
      GL11.glColor3f(255.0F, 255.0F, 255.0F);
   }

   private boolean c99863(EntityPlayer var1) {
      Module[] var2 = Value.c27574();
      return var1.inventory.getCurrentItem() != null && var1.inventory.getCurrentItem().getItem() instanceof ItemSword;
   }

   private boolean c98039(EntityPlayer var1) {
      Module[] var2 = Value.c27574();
      return var1.inventory.getCurrentItem() != null && var1.inventory.getCurrentItem().getItem() instanceof ItemAxe;
   }

   private boolean c48596(EntityPlayer var1) {
      Module[] var2 = Value.c27574();
      return var1.inventory.getCurrentItem() != null && var1.inventory.getCurrentItem().getItem() instanceof ItemBlock;
   }

   public boolean c73086(Entity var1) {
      Module[] var2 = Value.c27574();
      return Math.abs(PlayerUtilF.c26164(mc.thePlayer.rotationYaw, var1.posX, var1.posY, var1.posZ)) > 100.0F;
   }

   public boolean c66110(Entity var1, float var2) {
      Value.c27574();
      var2 = (float)((double)var2 * 0.5D);
      double var4 = ((double)(mc.thePlayer.rotationYaw - this.c35986(var1)) % 360.0D + 540.0D) % 360.0D - 180.0D;
      return var4 > 0.0D && var4 < (double)var2 || (double)(-var2) < var4 && var4 < 0.0D;
   }

   public static double c61278(double var0, double var2) {
      Value.c27574();
      Random var5 = new Random();
      double var6 = var2 - var0;
      double var8 = var5.nextDouble() * var6;
      if (var8 > var2) {
         var8 = var2;
      }

      double var10 = var8 + var0;
      if (var10 > var2) {
         var10 = var2;
      }

      return var10;
   }

   public float c35986(Entity var1) {
      double var2 = var1.posX - mc.thePlayer.posX;
      double var4 = var1.posZ - mc.thePlayer.posZ;
      double var6 = Math.atan2(var2, var4) * 57.2957795D;
      return (float)(var6 * -1.0D);
   }

   public static EntityLivingBase c79073() {
      return c19685;
   }

   public static boolean c22942() {
      return c1172;
   }

   // $FF: synthetic method
   private static Boolean c9440() {
      return c18641.c54460().equalsIgnoreCase(c34422[74]);
   }

   // $FF: synthetic method
   private static Boolean c79984() {
      Module[] var0 = Value.c27574();
      return !c92537.c54460().equalsIgnoreCase(c34422[21]);
   }

   // $FF: synthetic method
   private static Boolean c35497() {
      return c92537.c54460().equalsIgnoreCase(c34422[76]);
   }

   // $FF: synthetic method
   private static Boolean c19647() {
      Module[] var0 = Value.c27574();
      return !c92537.c54460().equalsIgnoreCase(c34422[21]);
   }

   static {
      Loader.registerNativesForClass(0, KillAura.class);
      c2724();
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }

   // $FF: synthetic method
   private static native void c2724();
}
