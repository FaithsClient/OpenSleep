//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender3D;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.events.world.EventUpdate;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import java.awt.Color;
import java.util.Comparator;
import java.util.Objects;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.rotation.RotationUtils5;
import ft.sleep.util.timer.TimeHelper;
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

public class BowAimBot extends Module {
   public Mode sections$ = new Mode("Priority", new String[]{"Fov", "Range", "Angle", "Armor", "Health", "Hurt Time"}, "Fov");
   public Numbers disagree$ = new Numbers("Range", Integer.valueOf(50), Integer.valueOf(40), Integer.valueOf(120), Integer.valueOf(1));
   public Numbers lambda$ = new Numbers("FOV", 360.0F, Float.intBitsToFloat(0), 360.0F, 1.0F);
   public Option announce$ = new Option("Invisibles", false);
   public Option achieve$ = new Option("Players", true);
   public Option tough$ = new Option("Animals", false);
   public Option fired$ = new Option("Mobs", true);
   public Option tribune$ = new Option("Armor Stand", true);
   public Option muscles$ = new Option("Villagers", false);
   public Option setup$ = new Option("Team", false);
   public Option joshua$ = new Option("Slient", true);
   public Option webcam$ = new Option("Auto Release", true);
   public Option wiley$ = new Option("Through Walls", true);
   public Option varied$ = new Option("Clamp", false);
   public Option lines$ = new Option("Prediction", false);
   public Entity blocking$;
   public float brighton$;
   public float trigger$;
   public TimeHelper coating$ = new TimeHelper();

   public BowAimBot() {
      super("ft.sleep.module.modules.BowAimBot", new String[]{"ft.sleep.module.modules.BowAimBot", "ft.sleep.module.modules.BowAimBot"}, ModuleType.updates$);
      failures._piece((new Color(235, 194, 138)).getRGB());
   }

   @EventHandler
   public void _platform(EventRender3D eyolubin) {
      Object tubaline = sotusepu._ricky();
      sotusepu.blocking$ = tubaline;
      if (sotusepu._scripts(sotusepu.mc.thePlayer) && tubaline != null && tubaline != sotusepu.mc.thePlayer) {
         Object efadaruc = tubaline.posX - sotusepu.mc.thePlayer.posX;
         Object fobunabu = tubaline.posY + (double)tubaline.getEyeHeight() - (sotusepu.mc.thePlayer.posY + (double)sotusepu.mc.thePlayer.getEyeHeight());
         Object tocorumu = tubaline.posZ - sotusepu.mc.thePlayer.posZ;
         if (!(tubaline instanceof EntityPlayer)) {
            fobunabu = tubaline.posY + (double)tubaline.getEyeHeight() - (sotusepu.mc.thePlayer.posY + (double)sotusepu.mc.thePlayer.getEyeHeight());
         }

         Object mozutotu = (double)MathHelper.sqrt_double(efadaruc * efadaruc + tocorumu * tocorumu);
         double var11 = sotusepu._bubble();
         double var13 = sotusepu._ideas();
         float var15 = _nigeria(var11, var13, mozutotu, fobunabu);
         float[] var16 = RotationUtils5._locks(tubaline, false, false, false, sotusepu.lines$.getValue().booleanValue(), true, false, Double.longBitsToDouble(0L), sotusepu.varied$.getValue().booleanValue(), 180.0F, 6.0D, false, 0);
         var15 = MathHelper.clamp_float(var15, -90.0F, 90.0F);
         sotusepu.brighton$ = var16[0];
         sotusepu.trigger$ = var15;
         if (var11 == 1.0D && sotusepu.webcam$.getValue().booleanValue()) {
            if (sotusepu.coating$._ascii((long)113302424 ^ 113302352L)) {
               sotusepu.mc.playerController.onStoppedUsingItem(sotusepu.mc.thePlayer);
            }
         } else if (sotusepu.webcam$.getValue().booleanValue()) {
            sotusepu.coating$._silent();
         }
      }

   }

   @EventHandler
   public void _expected(EventPreUpdate uyodugeg) {
      if (gagopuva.joshua$.getValue().booleanValue() && gagopuva._mobiles(gagopuva.mc.thePlayer) && !Float.isNaN(gagopuva.trigger$)) {
         ((EventPreUpdate)uyodugeg).setYaw(gagopuva.brighton$);
         ((EventPreUpdate)uyodugeg).setPitch(gagopuva.trigger$);
      }

   }

   @EventHandler
   public void _brave(EventUpdate var1) {
      if (!codes.joshua$.getValue().booleanValue() && codes._mobiles(codes.mc.thePlayer)) {
         codes.mc.thePlayer.rotationYaw = codes.brighton$;
         codes.mc.thePlayer.rotationPitch = codes.trigger$;
      }

   }

   public static float _nigeria(double afford, double ghost, double var4, double var6) {
      return (float)(-Math.toDegrees(Math.atan2(Math.pow((double)afford, 2.0D) - Math.sqrt(Math.pow((double)afford, 4.0D) - ghost * (ghost * Math.pow(var4, 2.0D) + 2.0D * var6 * Math.pow((double)afford, 2.0D))), ghost * var4)));
   }

   public boolean _mandate(EntityLivingBase singles) {
      if (singles instanceof EntityPlayer || singles instanceof EntityAnimal || singles instanceof EntityMob || singles instanceof INpc) {
         if (singles instanceof EntityPlayer && !fishing.achieve$.getValue().booleanValue()) {
            return false;
         }

         if (singles instanceof EntityAnimal && !fishing.tough$.getValue().booleanValue()) {
            return false;
         }

         if (singles instanceof EntityMob && !fishing.fired$.getValue().booleanValue()) {
            return false;
         }

         if (singles instanceof INpc && !fishing.muscles$.getValue().booleanValue()) {
            return false;
         }
      }

      if (singles instanceof EntityArmorStand && !fishing.tribune$.getValue().booleanValue()) {
         return false;
      } else if (Teams._issued((EntityLivingBase)singles) && !fishing.setup$.getValue().booleanValue()) {
         return false;
      } else if (((EntityLivingBase)singles).isInvisible() && !fishing.announce$.getValue().booleanValue()) {
         return false;
      } else if (!fishing._defeat((EntityLivingBase)singles, fishing.lambda$.getValue().doubleValue())) {
         return false;
      } else if (!fishing.wiley$.getValue().booleanValue() && !((EntityLivingBase)singles).canEntityBeSeen(fishing.mc.thePlayer)) {
         return false;
      } else if (AntiBot._remind((Entity)singles)) {
         return false;
      } else {
         return singles != fishing.mc.thePlayer && ((EntityLivingBase)singles).isEntityAlive() && fishing.mc.thePlayer.getDistanceToEntity((Entity)singles) <= fishing.disagree$.getValue().floatValue();
      }
   }

   public boolean _defeat(EntityLivingBase nozuvico, double iporomav) {
      iporomav = iporomav * 0.5D;
      double var4 = (double)_infinite(orizovir.mc.thePlayer.rotationYaw, orizovir._types(((EntityLivingBase)nozuvico).posX, ((EntityLivingBase)nozuvico).posY, ((EntityLivingBase)nozuvico).posZ)[0]);
      return var4 > Double.longBitsToDouble(0L) && var4 < iporomav || -iporomav < var4 && var4 < Double.longBitsToDouble(0L);
   }

   public static float _infinite(float asocisal, float liteselo) {
      Object coyenema = Math.abs((float)(liteselo - asocisal)) % 360.0F;
      return coyenema > 180.0F ? 360.0F - coyenema : coyenema;
   }

   public float[] _types(double muscles, double laundry, double tract) {
      Object martial = muscles + 0.5D - faith.mc.thePlayer.posX;
      Object context = (laundry + 0.5D) / 2.0D - (faith.mc.thePlayer.posY + (double)faith.mc.thePlayer.getEyeHeight());
      double var11 = tract + 0.5D - faith.mc.thePlayer.posZ;
      double var13 = (double)MathHelper.sqrt_double(martial * martial + var11 * var11);
      float var15 = (float)(Math.atan2(var11, martial) * 180.0D / 3.141592653589793D) - 90.0F;
      float var16 = (float)(-(Math.atan2(context, var13) * 180.0D / 3.141592653589793D));
      return new float[]{var15, var16};
   }

   public static float[] _village(Entity obanocun) {
      if (obanocun == null) {
         return null;
      } else {
         Object azibolas = ((Entity)obanocun).posX - Minecraft.getMinecraft().thePlayer.posX;
         Object zuvumite = ((Entity)obanocun).posZ - Minecraft.getMinecraft().thePlayer.posZ;
         double iripoyis;
         if (obanocun instanceof EntityLivingBase) {
            EntityLivingBase var7 = (EntityLivingBase)obanocun;
            iripoyis = var7.posY + (double)var7.getEyeHeight() - (Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight());
         } else {
            iripoyis = (((Entity)obanocun).getEntityBoundingBox().minY + ((Entity)obanocun).getEntityBoundingBox().maxY) / 2.0D - (Minecraft.getMinecraft().thePlayer.posY + (double)Minecraft.getMinecraft().thePlayer.getEyeHeight());
         }

         double var11 = (double)MathHelper.sqrt_double(azibolas * azibolas + zuvumite * zuvumite);
         float var9 = (float)(Math.atan2(zuvumite, azibolas) * 180.0D / 3.141592653589793D) - 90.0F;
         float var10 = (float)(-(Math.atan2(iripoyis, var11) * 180.0D / 3.141592653589793D));
         return new float[]{var9, var10};
      }
   }

   public static float _enemies(float bebiyape, float letuyude) {
      Object gidinasu = Math.abs((float)(bebiyape - letuyude)) % 360.0F;
      if (gidinasu > 180.0F) {
         gidinasu = Float.intBitsToFloat(0);
      }

      return gidinasu;
   }

   public double _bubble() {
      Object evuvidis = obemevef.mc.thePlayer.getCurrentEquippedItem().getMaxItemUseDuration() - obemevef.mc.thePlayer.getItemInUseCount();
      Object opelotug = (float)evuvidis / 20.0F;
      opelotug = (opelotug * opelotug + opelotug * 2.0F) / 3.0F;
      if (opelotug > 1.0F) {
         opelotug = 1.0F;
      }

      return (double)opelotug;
   }

   public boolean _mobiles(EntityPlayer nidegasu) {
      return olorebat._scripts((EntityPlayer)nidegasu) && olorebat.blocking$ != null;
   }

   public boolean _scripts(EntityPlayer logged) {
      return ((EntityPlayer)logged).isUsingItem() && adverse.mc.thePlayer.getCurrentEquippedItem() != null && adverse.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemBow;
   }

   public double _ideas() {
      return 0.006D;
   }

   public float _utils(Entity disinuvu) {
      Object avoyipel = Float.intBitsToFloat(0);
      Object egayenip = oroyavef.mc.thePlayer.getPositionEyes(1.0F);
      Object etevazim = (float)egayenip.xCoord;
      Object mivebemo = (float)egayenip.yCoord;
      Object tefebofi = (float)egayenip.zCoord;
      etevazim = (float)((double)etevazim - (double)(MathHelper.cos(oroyavef.brighton$ / 180.0F * 3.1415927F) * 0.16F));
      mivebemo = (float)((double)mivebemo - 0.10000000149011612D);
      tefebofi = (float)((double)tefebofi - (double)(MathHelper.sin(oroyavef.brighton$ / 180.0F * 3.1415927F) * 0.16F));
      Object dubeyupa = -MathHelper.sin(oroyavef.brighton$ / 180.0F * 3.1415927F) * MathHelper.cos(oroyavef.trigger$ / 180.0F * 3.1415927F);
      Object mopifonu = MathHelper.cos(oroyavef.brighton$ / 180.0F * 3.1415927F) * MathHelper.cos(oroyavef.trigger$ / 180.0F * 3.1415927F);
      Object imebinal = -MathHelper.sin(oroyavef.trigger$ / 180.0F * 3.1415927F);

      while(true) {
         ++avoyipel;
         Object zefonozu = 0.99F;
         Object azesegan = 0.05F;
         Block var12 = oroyavef.mc.theWorld.getBlockState(new BlockPos((double)etevazim, (double)mivebemo, (double)tefebofi)).getBlock();
         if (var12 instanceof BlockLiquid) {
            zefonozu = 0.6F;
         }

         etevazim += dubeyupa;
         mivebemo += imebinal;
         tefebofi += mopifonu;
         dubeyupa = (float)((double)dubeyupa * (double)zefonozu);
         imebinal = (float)((double)imebinal * (double)zefonozu);
         mopifonu = (float)((double)mopifonu * (double)zefonozu);
         imebinal = (float)((double)imebinal - 0.05000000074505806D);
         if (((Entity)disinuvu).getDistance((double)etevazim, (double)mivebemo, (double)tefebofi) <= 1.0D || oroyavef.mc.thePlayer.getDistance((double)etevazim, (double)mivebemo, (double)tefebofi) > (double)oroyavef.mc.thePlayer.getDistanceToEntity((Entity)disinuvu)) {
            break;
         }
      }

      return avoyipel;
   }

   public EntityLivingBase _ricky() {
      Object mutedoba = livogibu.mc.theWorld.loadedEntityList.stream().filter(BowAimBot::_summit).map(BowAimBot::_drama).filter(livogibu::_mandate);
      if (Objects.equals(livogibu.sections$.getValue(), "Armor")) {
         mutedoba = mutedoba.sorted(Comparator.comparingInt(BowAimBot::_italic));
      } else if (Objects.equals(livogibu.sections$.getValue(), "Range")) {
         mutedoba = mutedoba.sorted(livogibu::_retail);
      } else if (Objects.equals(livogibu.sections$.getValue(), "Fov")) {
         mutedoba = mutedoba.sorted(Comparator.comparingDouble(livogibu::_harley));
      } else if (Objects.equals(livogibu.sections$.getValue(), "Angle")) {
         mutedoba = mutedoba.sorted(livogibu::_marina);
      } else if (Objects.equals(livogibu.sections$.getValue(), "Health")) {
         mutedoba = mutedoba.sorted(BowAimBot::_uncle);
      } else if (Objects.equals(livogibu.sections$.getValue(), "Hurt Time")) {
         mutedoba = mutedoba.sorted(Comparator.comparingInt(BowAimBot::_nails));
      }

      return (EntityLivingBase)mutedoba.findFirst().orElse((Object)null);
   }

   public static int _nails(EntityLivingBase effect) {
      return 20 - ((EntityLivingBase)effect).hurtResistantTime;
   }

   public static int _uncle(EntityLivingBase holes, EntityLivingBase oxygen) {
      return (int)(((EntityLivingBase)holes).getHealth() - ((EntityLivingBase)oxygen).getHealth());
   }

   public int _marina(EntityLivingBase epifosap, EntityLivingBase ragayiye) {
      Object ogepudev = _village((Entity)epifosap);
      Object punogiza = _village((Entity)ragayiye);
      return (int)(evimodac.mc.thePlayer.rotationYaw - ogepudev[0] - (evimodac.mc.thePlayer.rotationYaw - punogiza[0]));
   }

   public double _harley(EntityLivingBase products) {
      return (double)_enemies(tongue.mc.thePlayer.rotationPitch, _village((Entity)products)[0]);
   }

   public int _retail(EntityLivingBase ibovecur, EntityLivingBase imefurac) {
      return (int)(((EntityLivingBase)ibovecur).getDistanceToEntity(ezegeput.mc.thePlayer) - ((EntityLivingBase)imefurac).getDistanceToEntity(ezegeput.mc.thePlayer));
   }

   public static int _italic(EntityLivingBase replica) {
      return replica instanceof EntityPlayer ? ((EntityPlayer)replica).inventory.getTotalArmorValue() : (int)((EntityLivingBase)replica).getHealth();
   }

   public static EntityLivingBase _drama(Entity meconibo) {
      return (EntityLivingBase)meconibo;
   }

   public static boolean _summit(Entity polidivi) {
      return polidivi instanceof EntityLivingBase;
   }
}
