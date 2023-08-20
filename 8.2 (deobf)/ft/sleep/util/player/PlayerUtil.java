//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.player;

import ft.sleep.api.events.world.EventMove;
import ft.sleep.util.rotation.Rotation;
import io.netty.util.internal.ThreadLocalRandom;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C03PacketPlayer.C04PacketPlayerPosition;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

public class PlayerUtil {
   public static Minecraft mount$ = Minecraft.getMinecraft();

   public static double _democrat() {
      Object ufalifit = 0.2873D;
      if (mount$.thePlayer.isPotionActive(Potion.moveSpeed)) {
         int var2 = mount$.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier();
         ufalifit *= 1.0D + 0.2D * (double)(var2 + 1);
      }

      return ufalifit;
   }

   public static boolean _claimed(double skirt) {
      return _courier((double)skirt, true);
   }

   public static boolean _courier(double sends, boolean heather) {
      if (heather) {
         for(Object madonna = 0; (double)madonna < sends; madonna += 2) {
            AxisAlignedBB var4 = mount$.thePlayer.getEntityBoundingBox().offset(Double.longBitsToDouble(0L), (double)(-madonna), Double.longBitsToDouble(0L));
            if (!mount$.theWorld.getCollidingBoundingBoxes(mount$.thePlayer, var4).isEmpty()) {
               return true;
            }
         }
      } else {
         for(Object var5 = 0; (double)var5 < sends; ++var5) {
            if (_performs(Double.longBitsToDouble(0L), (double)(-var5), Double.longBitsToDouble(0L)).isFullBlock()) {
               return true;
            }
         }
      }

      return false;
   }

   public static boolean _reality() {
      return _claimed(mount$.thePlayer.posY + (double)mount$.thePlayer.getEyeHeight());
   }

   public static boolean _dealers(Entity volumes) {
      if (((Entity)volumes).posY < Double.longBitsToDouble(0L)) {
         return false;
      } else {
         for(Object casual = 0; casual < (int)((Entity)volumes).posY + 2; casual += 2) {
            Object retreat = ((Entity)volumes).getEntityBoundingBox().offset(Double.longBitsToDouble(0L), (double)(-casual), Double.longBitsToDouble(0L));
            if (!mount$.theWorld.getCollidingBoundingBoxes((Entity)volumes, retreat).isEmpty()) {
               return true;
            }
         }

         return false;
      }
   }

   public static boolean _triangle(Entity tivecogo) {
      return mount$.theWorld.getBlockState(new BlockPos(((Entity)tivecogo).posX, ((Entity)tivecogo).posY - 1.0D, ((Entity)tivecogo).posZ)).getBlock() == Blocks.air;
   }

   public static void _picnic(double pulled) {
      Object integral = (double)mount$.thePlayer.movementInput.moveForward;
      Object assessed = (double)mount$.thePlayer.movementInput.moveStrafe;
      Object rooms = mount$.thePlayer.rotationYaw;
      if (integral != Double.longBitsToDouble(0L)) {
         if (assessed > Double.longBitsToDouble(0L)) {
            rooms += (float)(integral > Double.longBitsToDouble(0L) ? -45 : 45);
         } else if (assessed < Double.longBitsToDouble(0L)) {
            rooms += (float)(integral > Double.longBitsToDouble(0L) ? 45 : -45);
         }

         assessed = Double.longBitsToDouble(0L);
         if (integral > Double.longBitsToDouble(0L)) {
            integral = 1.0D;
         } else if (integral < Double.longBitsToDouble(0L)) {
            integral = -1.0D;
         }
      }

      Object andrea = Math.cos(Math.toRadians((double)(rooms + 90.0F)));
      double var9 = Math.sin(Math.toRadians((double)(rooms + 90.0F)));
      double var11 = integral * pulled * andrea + assessed * pulled * var9;
      double var13 = integral * pulled * var9 - assessed * pulled * andrea;
      mount$.thePlayer.setPosition(mount$.thePlayer.posX + var11, mount$.thePlayer.posY, mount$.thePlayer.posZ + var13);
   }

   public static void _waiver() {
      if (_posing()) {
         Object abulabet = mount$.thePlayer.rotationYaw;
         if (mount$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
            abulabet += 180.0F;
         }

         Object loyegabe = 1.0F;
         if (mount$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
            loyegabe = -0.5F;
         } else if (mount$.thePlayer.moveForward > Float.intBitsToFloat(0)) {
            loyegabe = 0.5F;
         }

         if (mount$.thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
            abulabet -= 90.0F * loyegabe;
         }

         if (mount$.thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
            abulabet += 90.0F * loyegabe;
         }

         Object casusocu = Math.toRadians((double)abulabet);
         float var4 = (float)Math.sqrt(mount$.thePlayer.motionX * mount$.thePlayer.motionX + mount$.thePlayer.motionZ * mount$.thePlayer.motionZ);
         mount$.thePlayer.motionX = -Math.sin(casusocu) * (double)var4;
         mount$.thePlayer.motionZ = Math.cos(casusocu) * (double)var4;
      }
   }

   public static void _showed(double olidibor) {
      if (_posing()) {
         Object avacasav = mount$.thePlayer.rotationYaw;
         if (mount$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
            avacasav += 180.0F;
         }

         Object loriside = 1.0F;
         if (mount$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
            loriside = -0.5F;
         } else if (mount$.thePlayer.moveForward > Float.intBitsToFloat(0)) {
            loriside = 0.5F;
         }

         if (mount$.thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
            avacasav -= 90.0F * loriside;
         }

         if (mount$.thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
            avacasav += 90.0F * loriside;
         }

         double var4 = Math.toRadians((double)avacasav);
         float var6 = (float)Math.sqrt(mount$.thePlayer.motionX * mount$.thePlayer.motionX + mount$.thePlayer.motionZ * mount$.thePlayer.motionZ);
         mount$.thePlayer.motionX = -Math.sin(var4) * olidibor;
         mount$.thePlayer.motionZ = Math.cos(var4) * olidibor;
      }
   }

   public static boolean _posing() {
      return mount$.gameSettings.keyBindForward.isKeyDown() || mount$.gameSettings.keyBindLeft.isKeyDown() || mount$.gameSettings.keyBindRight.isKeyDown() || mount$.gameSettings.keyBindBack.isKeyDown();
   }

   public static boolean _bones(double years) {
      return !mount$.theWorld.getCollidingBoundingBoxes(mount$.thePlayer, mount$.thePlayer.getEntityBoundingBox().offset(Double.longBitsToDouble(0L), (double)(-years), Double.longBitsToDouble(0L))).isEmpty();
   }

   public static boolean _family(double eyusumev, Entity var2) {
      return !mount$.theWorld.getCollidingBoundingBoxes(var2, var2.getEntityBoundingBox().offset(Double.longBitsToDouble(0L), (double)(-eyusumev), Double.longBitsToDouble(0L))).isEmpty();
   }

   public static int _alter() {
      return mount$.thePlayer.isPotionActive(Potion.jump) ? mount$.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier() + 1 : 0;
   }

   public static int _covering() {
      return mount$.thePlayer.isPotionActive(Potion.moveSpeed) ? mount$.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1 : 0;
   }

   public static boolean _remedy(Item filefopo) {
      return !(filefopo instanceof ItemSword) && !(filefopo instanceof ItemBow);
   }

   public static boolean _endif() {
      for(Object queen = MathHelper.floor_double(mount$.thePlayer.getEntityBoundingBox().minX); queen < MathHelper.floor_double(mount$.thePlayer.getEntityBoundingBox().maxX) + 1; ++queen) {
         for(Object hearing = MathHelper.floor_double(mount$.thePlayer.getEntityBoundingBox().minY); hearing < MathHelper.floor_double(mount$.thePlayer.getEntityBoundingBox().maxY) + 1; ++hearing) {
            for(Object shanghai = MathHelper.floor_double(mount$.thePlayer.getEntityBoundingBox().minZ); shanghai < MathHelper.floor_double(mount$.thePlayer.getEntityBoundingBox().maxZ) + 1; ++shanghai) {
               Object lives = mount$.theWorld.getBlockState(new BlockPos(queen, hearing, shanghai)).getBlock();
               if (lives != null && !(lives instanceof BlockAir)) {
                  Object angela = lives.getCollisionBoundingBox(mount$.theWorld, new BlockPos(queen, hearing, shanghai), mount$.theWorld.getBlockState(new BlockPos(queen, hearing, shanghai)));
                  if (lives instanceof BlockHopper) {
                     angela = new AxisAlignedBB((double)queen, (double)hearing, (double)shanghai, (double)(queen + 1), (double)(hearing + 1), (double)(shanghai + 1));
                  }

                  if (angela != null && mount$.thePlayer.getEntityBoundingBox().intersectsWith(angela)) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public static boolean _canberra(EntityPlayer vendors) {
      for(Object grants = MathHelper.floor_double(((EntityPlayer)vendors).getEntityBoundingBox().minX); grants < MathHelper.floor_double(((EntityPlayer)vendors).getEntityBoundingBox().maxX) + 1; ++grants) {
         for(Object charles = MathHelper.floor_double(((EntityPlayer)vendors).getEntityBoundingBox().minY); charles < MathHelper.floor_double(((EntityPlayer)vendors).getEntityBoundingBox().maxY) + 1; ++charles) {
            for(Object rugby = MathHelper.floor_double(((EntityPlayer)vendors).getEntityBoundingBox().minZ); rugby < MathHelper.floor_double(((EntityPlayer)vendors).getEntityBoundingBox().maxZ) + 1; ++rugby) {
               Object witch = mount$.theWorld.getBlockState(new BlockPos(grants, charles, rugby)).getBlock();
               if (witch != null && !(witch instanceof BlockAir)) {
                  Object american = witch.getCollisionBoundingBox(mount$.theWorld, new BlockPos(grants, charles, rugby), mount$.theWorld.getBlockState(new BlockPos(grants, charles, rugby)));
                  if (witch instanceof BlockHopper) {
                     american = new AxisAlignedBB((double)grants, (double)charles, (double)rugby, (double)(grants + 1), (double)(charles + 1), (double)(rugby + 1));
                  }

                  if (american != null && ((EntityPlayer)vendors).getEntityBoundingBox().intersectsWith(american)) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public static boolean _resource() {
      if (mount$.thePlayer.isInWater()) {
         return true;
      } else {
         Object votoretu = false;
         Object fosutuva = (int)mount$.thePlayer.getEntityBoundingBox().minY;

         for(Object totugeca = MathHelper.floor_double(mount$.thePlayer.getEntityBoundingBox().minX); totugeca < MathHelper.floor_double(mount$.thePlayer.getEntityBoundingBox().maxX) + 1; ++totugeca) {
            for(Object talapicu = MathHelper.floor_double(mount$.thePlayer.getEntityBoundingBox().minZ); talapicu < MathHelper.floor_double(mount$.thePlayer.getEntityBoundingBox().maxZ) + 1; ++talapicu) {
               Object ufoyufuz = mount$.theWorld.getBlockState(new BlockPos(totugeca, fosutuva, talapicu)).getBlock();
               if (ufoyufuz != null && ufoyufuz.getMaterial() != Material.air) {
                  if (!(ufoyufuz instanceof BlockLiquid)) {
                     return false;
                  }

                  votoretu = true;
               }
            }
         }

         return votoretu;
      }
   }

   public static boolean _whether() {
      Object climate = mount$.thePlayer.getEntityBoundingBox();
      if (climate == null) {
         return false;
      } else {
         climate = climate.contract(0.01D, Double.longBitsToDouble(0L), 0.01D).offset(Double.longBitsToDouble(0L), -0.01D, Double.longBitsToDouble(0L));
         Object loves = false;
         Object catering = (int)climate.minY;

         for(Object charged = MathHelper.floor_double(climate.minX); charged < MathHelper.floor_double(climate.maxX + 1.0D); ++charged) {
            for(Object nearest = MathHelper.floor_double(climate.minZ); nearest < MathHelper.floor_double(climate.maxZ + 1.0D); ++nearest) {
               Object theater = mount$.theWorld.getBlockState(new BlockPos(charged, catering, nearest)).getBlock();
               if (theater != Blocks.air) {
                  if (!(theater instanceof BlockLiquid)) {
                     return false;
                  }

                  loves = true;
               }
            }
         }

         return loves;
      }
   }

   public static boolean _roommate(double obunifof) {
      boolean var2 = mount$.theWorld.getBlockState(new BlockPos(mount$.thePlayer.posX, mount$.thePlayer.posY - obunifof, mount$.thePlayer.posZ)).getBlock().getMaterial().isLiquid();
      return var2;
   }

   public static boolean _maker(double utivagul) {
      for(Object lupezeza = mount$.thePlayer.getEntityBoundingBox().minX; lupezeza < mount$.thePlayer.getEntityBoundingBox().maxX; lupezeza += 0.009999999776482582D) {
         for(double var4 = mount$.thePlayer.getEntityBoundingBox().minZ; var4 < mount$.thePlayer.getEntityBoundingBox().maxZ; var4 += 0.009999999776482582D) {
            Block var6 = mount$.theWorld.getBlockState(new BlockPos(lupezeza, mount$.thePlayer.posY - utivagul, var4)).getBlock();
            if (!(var6 instanceof BlockLiquid) && !(var6 instanceof BlockAir)) {
               return false;
            }
         }
      }

      return true;
   }

   public static void _eugene(EventMove inayisir, double govomiyo) {
      Object yebanire = mount$.thePlayer.rotationYaw;
      Object cadurega = (double)mount$.thePlayer.movementInput.moveForward;
      double var6 = (double)mount$.thePlayer.movementInput.moveStrafe;
      if (cadurega == Double.longBitsToDouble(0L) && var6 == Double.longBitsToDouble(0L)) {
         ((EventMove)inayisir).setX(Double.longBitsToDouble(0L));
         ((EventMove)inayisir).setZ(Double.longBitsToDouble(0L));
      } else {
         if (cadurega != Double.longBitsToDouble(0L)) {
            if (var6 > Double.longBitsToDouble(0L)) {
               yebanire += (float)(cadurega > Double.longBitsToDouble(0L) ? -45 : 45);
            } else if (var6 < Double.longBitsToDouble(0L)) {
               yebanire += (float)(cadurega > Double.longBitsToDouble(0L) ? 45 : -45);
            }

            var6 = Double.longBitsToDouble(0L);
            cadurega = cadurega > Double.longBitsToDouble(0L) ? 1.0D : -1.0D;
         }

         ((EventMove)inayisir).setX(cadurega * govomiyo * Math.cos(Math.toRadians((double)yebanire + 87.88867D)) + var6 * govomiyo * Math.sin(Math.toRadians((double)yebanire + 87.88867D)));
         ((EventMove)inayisir).setZ(cadurega * govomiyo * Math.sin(Math.toRadians((double)yebanire + 87.88867D)) - var6 * govomiyo * Math.cos(Math.toRadians((double)yebanire + 87.88867D)));
      }

   }

   public static void _opera(double botemoyu) {
      Object isovodib = mount$.thePlayer.rotationYaw;
      Object inaralus = (double)mount$.thePlayer.movementInput.moveForward;
      double var5 = (double)mount$.thePlayer.movementInput.moveStrafe;
      if (inaralus == Double.longBitsToDouble(0L) && var5 == Double.longBitsToDouble(0L)) {
         mount$.thePlayer.motionX = Double.longBitsToDouble(0L);
         mount$.thePlayer.motionZ = Double.longBitsToDouble(0L);
      } else {
         if (inaralus != Double.longBitsToDouble(0L)) {
            if (var5 > Double.longBitsToDouble(0L)) {
               isovodib += (float)(inaralus > Double.longBitsToDouble(0L) ? -45 : 45);
            } else if (var5 < Double.longBitsToDouble(0L)) {
               isovodib += (float)(inaralus > Double.longBitsToDouble(0L) ? 45 : -45);
            }

            var5 = Double.longBitsToDouble(0L);
            inaralus = inaralus > Double.longBitsToDouble(0L) ? 1.0D : -1.0D;
         }

         mount$.thePlayer.motionX = inaralus * botemoyu * Math.cos(Math.toRadians((double)(isovodib + 90.0F))) + var5 * botemoyu * Math.sin(Math.toRadians((double)(isovodib + 90.0F)));
         mount$.thePlayer.motionZ = inaralus * botemoyu * Math.sin(Math.toRadians((double)(isovodib + 90.0F))) - var5 * botemoyu * Math.cos(Math.toRadians((double)(isovodib + 90.0F)));
      }

   }

   public static double _devoted() {
      Object afilutur = mount$.thePlayer.posX - mount$.thePlayer.prevPosX;
      double var2 = mount$.thePlayer.posZ - mount$.thePlayer.prevPosZ;
      return Math.sqrt(afilutur * afilutur + var2 * var2);
   }

   public static double _spend(Entity podcasts) {
      Object never = ((Entity)podcasts).posX - ((Entity)podcasts).prevPosX;
      double var3 = ((Entity)podcasts).posZ - ((Entity)podcasts).prevPosZ;
      return Math.sqrt(never * never + var3 * var3);
   }

   public static double _stored() {
      Object diguyuvu = _devoted() * 20.0D;
      return ((double)((int)diguyuvu) + diguyuvu - (double)((int)diguyuvu)) * (double) Helper._pillow().timerSpeed;
   }

   public static double _gather(Entity cutomeyi) {
      Object esibarez = _spend((Entity)cutomeyi) * 20.0D;
      return (double)((int)esibarez) + esibarez - (double)((int)esibarez);
   }

   public static Rotation _delete(double dozoyovo, double osoroboz, double iconucer) {
      Object imoretas = dozoyovo - mount$.thePlayer.posX;
      Object nuduzabe = osoroboz - mount$.thePlayer.posY - 1.2D;
      double var10 = iconucer - mount$.thePlayer.posZ;
      double var12 = Math.hypot(imoretas, var10);
      float var14 = (float)(Math.atan2(var10, imoretas) * 180.0D / 3.141592653589793D) - 90.0F;
      float var15 = (float)(-(Math.atan2(nuduzabe, var12) * 180.0D / 3.141592653589793D));
      return new Rotation(var14, var15);
   }

   public static Rotation _planes(EntityLivingBase asofecum) {
      Object nimigina = ThreadLocalRandom.current();
      Object ocodasim = nimigina.nextDouble(-0.05D, 0.1D);
      Object obomedub = nimigina.nextDouble(-0.05D, 0.1D);
      Object izecimum = ((EntityLivingBase)asofecum).posX + ocodasim;
      double var8 = ((EntityLivingBase)asofecum).posY + (double)((EntityLivingBase)asofecum).getEyeHeight() / 2.05D + obomedub;
      double var10 = ((EntityLivingBase)asofecum).posZ + ocodasim;
      return _delete(izecimum, var8, var10);
   }

   public static float _kissing() {
      Object strikes = 0.2873F;
      if (Minecraft.getMinecraft().thePlayer.isPotionActive(Potion.moveSpeed)) {
         Object obtained = Minecraft.getMinecraft().thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier();
         strikes *= 1.0F + 0.2F * (float)(obtained + 1);
      }

      return strikes;
   }

   public static double _kennedy() {
      Object lulanoba = mount$.thePlayer.rotationYaw;
      if (mount$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         lulanoba += 180.0F;
      }

      Object cebavamo = 1.0F;
      if (mount$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         cebavamo = -0.5F;
      } else if (mount$.thePlayer.moveForward > Float.intBitsToFloat(0)) {
         cebavamo = 0.5F;
      }

      if (mount$.thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
         lulanoba -= 90.0F * cebavamo;
      }

      if (mount$.thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
         lulanoba += 90.0F * cebavamo;
      }

      return Math.toRadians((double)lulanoba);
   }

   public static Block _fever(double burivira, double lefopulu, double var4) {
      return mount$.theWorld.getBlockState(new BlockPos((double)burivira, (double)lefopulu, var4)).getBlock();
   }

   public static void _leads(double[] edufiyem, BlockPos zogulesu, double uvodenep, double[] tubayozo) {
      Object inobivol = (double)((Object[])edufiyem)[0];
      Object poyesifo = (double)((Object[])edufiyem)[1];
      Object dediboci = (double)((Object[])edufiyem)[2];
      Object ugucisaf = (double)((BlockPos)zogulesu).getX() + 0.5D;
      Object atugevuf = (double)((BlockPos)zogulesu).getY() + 1.0D;
      Object mosalimu = (double)((BlockPos)zogulesu).getZ() + 0.5D;
      double var17 = Math.abs(inobivol - ugucisaf) + Math.abs(poyesifo - atugevuf) + Math.abs(dediboci - mosalimu);

      for(int var19 = 0; var17 > uvodenep; ++var19) {
         var17 = Math.abs(inobivol - ugucisaf) + Math.abs(poyesifo - atugevuf) + Math.abs(dediboci - mosalimu);
         if (var19 > 120) {
            break;
         }

         boolean var20 = false;
         double var21 = inobivol - ugucisaf;
         double var23 = poyesifo - atugevuf;
         double var25 = dediboci - mosalimu;
         double var27 = (double)((var19 & 1) == 0 ? ((Object[])tubayozo)[0] : ((Object[])tubayozo)[1]);
         if (var21 < Double.longBitsToDouble(0L)) {
            if (Math.abs(var21) > var27) {
               inobivol += var27;
            } else {
               inobivol += Math.abs(var21);
            }
         }

         if (var21 > Double.longBitsToDouble(0L)) {
            if (Math.abs(var21) > var27) {
               inobivol -= var27;
            } else {
               inobivol -= Math.abs(var21);
            }
         }

         if (var23 < Double.longBitsToDouble(0L)) {
            if (Math.abs(var23) > 0.25D) {
               poyesifo += 0.25D;
            } else {
               poyesifo += Math.abs(var23);
            }
         }

         if (var23 > Double.longBitsToDouble(0L)) {
            if (Math.abs(var23) > 0.25D) {
               poyesifo -= 0.25D;
            } else {
               poyesifo -= Math.abs(var23);
            }
         }

         if (var25 < Double.longBitsToDouble(0L)) {
            if (Math.abs(var25) > var27) {
               dediboci += var27;
            } else {
               dediboci += Math.abs(var25);
            }
         }

         if (var25 > Double.longBitsToDouble(0L)) {
            if (Math.abs(var25) > var27) {
               dediboci -= var27;
            } else {
               dediboci -= Math.abs(var25);
            }
         }

         Minecraft.getMinecraft().getNetHandler().addToSendQueue(new C04PacketPlayerPosition(inobivol, poyesifo, dediboci, true));
      }

   }

   public static int _chile() {
      for(Object girls = 36; girls < 45; ++girls) {
         Object circuit = mount$.thePlayer.inventoryContainer.getSlot(girls).getStack();
         if (circuit != null && circuit.getDisplayName().contains("Head") && circuit.stackSize > 0) {
            return girls;
         }
      }

      return -1;
   }

   public static Block _musical(double didemuge, double ibalicis, double var4) {
      return mount$.theWorld.getBlockState(new BlockPos(mount$.thePlayer.posX + didemuge, mount$.thePlayer.posY + ibalicis, mount$.thePlayer.posZ + var4)).getBlock();
   }

   public static boolean _worst() {
      return mount$.theWorld.getBlockState(new BlockPos(mount$.thePlayer.posX, mount$.thePlayer.posY, mount$.thePlayer.posZ)).getBlock().getMaterial() == Material.water;
   }

   public static Block _performs(double operate, double devel, double var4) {
      return mount$.theWorld.getBlockState((new BlockPos(mount$.thePlayer)).add((double)operate, (double)devel, var4)).getBlock();
   }

   public static void _fleet(int vigogete, boolean oposevef) {
      Object umisilov = vigogete == 0 ? mount$.gameSettings.keyBindAttack.getKeyCode() : mount$.gameSettings.keyBindUseItem.getKeyCode();
      KeyBinding.setKeyBindState(umisilov, (boolean)oposevef);
      if (oposevef) {
         KeyBinding.onTick(umisilov);
      }

   }

   public static Block _knives(BlockPos table) {
      return mount$.theWorld.getBlockState((BlockPos)table).getBlock();
   }

   public static Block _shadows(double satadizu, double ocotuguy, double var4) {
      return mount$.theWorld.getBlockState(new BlockPos((double)satadizu, (double)ocotuguy, var4)).getBlock();
   }
}
