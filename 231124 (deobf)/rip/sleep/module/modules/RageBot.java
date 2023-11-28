package rip.sleep.module.modules;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import rip.sleep.injection.in.IRenderManager;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.INpc;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemSword;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.MotionUpdateEvent;
import rip.sleep.event.events.Render3DEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.RayTraceUtilA;
import rip.sleep.util.RenderUtilF;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class RageBot extends Module {
   private Vec3 c61395;
   public boolean c39915;
   private final BooleanValue c91887 = new BooleanValue("Invisibles", false);
   private final BooleanValue c18382 = new BooleanValue("Players", true);
   private final BooleanValue c65259 = new BooleanValue("Animals", false);
   private final BooleanValue c45963 = new BooleanValue("Mobs", true);
   private final BooleanValue c3051 = new BooleanValue("Armor Stand", true);
   private final BooleanValue c85352 = new BooleanValue("Villagers", false);
   private final BooleanValue c80420 = new BooleanValue("Team", false);
   private final NumberValue<Number> c86538 = new NumberValue<Number>("Range", Integer.valueOf(50), Integer.valueOf(40), Integer.valueOf(120), Integer.valueOf(1));
   private final NumberValue<Number> c3587 = new NumberValue<Number>("FOV", 360.0F, 0.0F, 360.0F, 1.0F);
   private final BooleanValue c94544 = new BooleanValue("Shot Head", false);
   public static NumberValue<Number> c88487 = new NumberValue<Number>("Pre-Attack", 1.5D, 0.0D, 10.0D, 0.1D);
   private final NumberValue<Number> c69315 = new NumberValue<Number>("Y - Offset", 0.0F, -1.0F, 1.0F, 0.1F);
   public static float c54897 = 0.0F;
   List<EntityLivingBase> c8543 = new ArrayList();

   public RageBot() {
      super("Rage Bot", new String[]{"RageBot"}, ModuleType.c31770, ModuleType.c21190.c55384);
   }

   public void c83205() {
   }

   public void c71897() {
   }

   @EventTarget
   public void c79015(MotionUpdateEvent var1) {
      Value.c27574();
      this.c8543.clear();
      List var3 = (List) RayTraceUtilA.c51901().stream().filter(this::c8314).sorted(Comparator.comparing((var0) -> {
         return mc.thePlayer.getDistanceToEntity(var0);
      })).collect(Collectors.toList());
      this.c8543.addAll((Collection)var3.stream().filter((var0) -> {
         Module[] var1 = Value.c27574();
         return var0 instanceof EntityGiantZombie || var0 instanceof EntityWither;
      }).collect(Collectors.toList()));
      this.c8543.addAll((Collection)var3.stream().filter((var0) -> {
         Module[] var1 = Value.c27574();
         return !(var0 instanceof EntityGiantZombie) && !(var0 instanceof EntityWither);
      }).collect(Collectors.toList()));
      if (this.c8543.size() <= 0) {
         mc.gameSettings.keyBindUseItem.pressed = false;
         this.c39915 = false;
      } else {
         this.c39915 = true;
         this.c61395 = this.c28976((EntityLivingBase)this.c8543.get(0), c88487.c53968().floatValue(), this.c94544.c1473().booleanValue());
         float[] var4 = c12082(this.c61395);
         var1.c6297((float)((double)var4[0] + ThreadLocalRandom.current().nextGaussian() * 2.1D));
         var1.c78602((float)((double)var4[1] + ThreadLocalRandom.current().nextGaussian()));
         mc.thePlayer.rotationYawHead = (float)((double)var4[0] + ThreadLocalRandom.current().nextGaussian() * 2.1D);
         if (!(mc.thePlayer.getHeldItem().getItem() instanceof ItemSword) && !(mc.thePlayer.getHeldItem().getItem() instanceof ItemBook)) {
            mc.gameSettings.keyBindUseItem.pressed = true;
         }

      }
   }

   public static float[] c12082(Vec3 var0) {
      double var1 = var0.xCoord - Minecraft.getMinecraft().thePlayer.posX;
      double var3 = var0.yCoord - (Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight());
      double var5 = var0.zCoord - Minecraft.getMinecraft().thePlayer.posZ;
      double var7 = (double)MathHelper.sqrt_double(var1 * var1 + var5 * var5);
      float var9 = (float)(Math.atan2(var5, var1) * 180.0D / 3.141592653589793D) - 90.0F;
      float var10 = (float)(-(Math.atan2(var3, var7) * 180.0D / 3.141592653589793D));
      return new float[]{var9, var10};
   }

   private Vec3 c28976(EntityLivingBase var1, float var2, boolean var3) {
      Value.c27574();
      double var5 = var1.posX + (var1.posX - var1.lastTickPosX) * (double)var2;
      double var7 = var1.posY + (var1.posY - var1.lastTickPosY) * (double)var2 * 0.3D + (double)var1.getEyeHeight() + this.c69315.c53968().doubleValue();
      double var9 = var1.posZ + (var1.posZ - var1.lastTickPosZ) * (double)var2;
      return new Vec3(var5, var7, var9);
   }

   @EventTarget
   public void c95355(Render3DEvent var1) {
      Module[] var2 = Value.c27574();
      if (this.c39915) {
         double var3 = this.c61395.xCoord - ((IRenderManager) mc.getRenderManager()).getRenderPosX();
         double var5 = this.c61395.yCoord - ((IRenderManager) mc.getRenderManager()).getRenderPosY();
         double var7 = this.c61395.zCoord - ((IRenderManager) mc.getRenderManager()).getRenderPosZ();
         RenderUtilF.c48481(var3 - 0.5D, var5 - 0.5D, var7 - 0.5D, (new Color(255, 0, 0, 100)).getRGB(), (new Color(16771328)).getRGB(), 0.4F, 0.1F);
      }
   }

   private boolean c8314(EntityLivingBase var1) {
      Module[] var2 = Value.c27574();
      if (var1 instanceof EntityPlayer || var1 instanceof EntityAnimal || var1 instanceof EntityMob || var1 instanceof INpc) {
         if (var1 instanceof EntityPlayer && !this.c18382.c1473().booleanValue()) {
            return false;
         }

         if (var1 instanceof EntityAnimal && !this.c65259.c1473().booleanValue()) {
            return false;
         }

         if (var1 instanceof EntityMob && !this.c45963.c1473().booleanValue()) {
            return false;
         }

         if (var1 instanceof INpc && !this.c85352.c1473().booleanValue()) {
            return false;
         }
      }

      if (var1 instanceof EntityArmorStand && !this.c3051.c1473().booleanValue()) {
         return false;
      } else if (var1.isOnSameTeam(mc.thePlayer) && !this.c80420.c1473().booleanValue()) {
         return false;
      } else if (var1.isInvisible() && !this.c91887.c1473().booleanValue()) {
         return false;
      } else if (!this.c28507(var1, this.c3587.c53968().doubleValue())) {
         return false;
      } else if (!var1.canEntityBeSeen(mc.thePlayer)) {
         return false;
      } else {
         return var1 != mc.thePlayer && var1.isEntityAlive() && mc.thePlayer.getDistanceToEntity(var1) <= this.c86538.c53968().floatValue();
      }
   }

   private boolean c28507(EntityLivingBase var1, double var2) {
      Value.c27574();
      var2 = var2 * 0.5D;
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

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
