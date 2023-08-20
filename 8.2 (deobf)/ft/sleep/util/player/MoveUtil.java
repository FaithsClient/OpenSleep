//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.player;

import ft.sleep.Client;
import ft.sleep.api.events.world.EventMove;
import javax.vecmath.Vector2d;

import ft.sleep.module.ModuleManager;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

public class MoveUtil {
   public static double guests$ = 0.221D;
   public static double curves$ = 1.2999999523162842D;
   public static double baker$ = 0.30000001192092896D;
   public static double diverse$ = 2.5D;
   public static double judgment$ = 0.4751131221719457D;
   public static double medicine$ = 0.5203620003898759D;
   public static double[] planning$ = new double[]{1.0D, 1.4304347400741908D, 1.7347825295420372D, 1.9217390955733897D};
   public static Minecraft finance$ = Minecraft.getMinecraft();
   public static double print$ = 0.41999998688697815D;

   public static float _reading() {
      return (float)_focus(finance$.thePlayer.motionX, finance$.thePlayer.motionZ);
   }

   public static double _focus(double gopedipu, double var2) {
      return Math.sqrt(gopedipu * gopedipu + var2 * var2);
   }

   public static double _lottery() {
      return Math.hypot(finance$.thePlayer.motionX, finance$.thePlayer.motionZ);
   }

   public static void _congo() {
      _builds(_reading());
   }

   public static boolean _viral() {
      return finance$.thePlayer != null && (finance$.thePlayer.movementInput.moveForward != Float.intBitsToFloat(0) || finance$.thePlayer.movementInput.moveStrafe != Float.intBitsToFloat(0));
   }

   public static void _apparent() {
      finance$.thePlayer.motionX = finance$.thePlayer.motionZ = Double.longBitsToDouble(0L);
   }

   public static Block _sherman(double built, double shipping, double var4) {
      return Minecraft.getMinecraft().theWorld.getBlockState(new BlockPos(Minecraft.getMinecraft().thePlayer.posX + built, Minecraft.getMinecraft().thePlayer.posY + shipping, Minecraft.getMinecraft().thePlayer.posZ + var4)).getBlock();
   }

   public static void _builds(float yabiledi) {
      if (_viral()) {
         Object bovunuto = _changing();
         finance$.thePlayer.motionX = -Math.sin(bovunuto) * (double)yabiledi;
         finance$.thePlayer.motionZ = Math.cos(bovunuto) * (double)yabiledi;
      }
   }

   public static void _barbie(float names, float beneath) {
      if (_viral()) {
         Object artwork = (float)Math.toRadians((double)beneath);
         finance$.thePlayer.motionX = -Math.sin((double)artwork) * (double)names;
         finance$.thePlayer.motionZ = Math.cos((double)artwork) * (double)names;
      }
   }

   public void _covers(double epiyozoz) {
      double var3 = _changing();
      finance$.thePlayer.motionX = -Math.sin(var3) * epiyozoz;
      finance$.thePlayer.motionZ = Math.cos(var3) * epiyozoz;
   }

   public double _dishes() {
      if (finance$.gameSettings.keyBindSprint.isKeyDown()) {
         if (finance$.thePlayer.isPotionActive(Potion.moveSpeed)) {
            return finance$.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1 == 1 ? 0.18386012061481244D : 0.21450346015841276D;
         } else {
            return 0.15321676228437875D;
         }
      } else if (finance$.thePlayer.isPotionActive(Potion.moveSpeed)) {
         return finance$.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1 == 1 ? 0.14143085686761D : 0.16500264553372018D;
      } else {
         return 0.11785905094607611D;
      }
   }

   public static float _browsing() {
      if (Minecraft.getMinecraft().thePlayer.moveForward > Float.intBitsToFloat(0)) {
         if (Minecraft.getMinecraft().thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
            return 45.0F;
         }

         if (Minecraft.getMinecraft().thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
            return -45.0F;
         }
      } else {
         if (Minecraft.getMinecraft().thePlayer.moveForward < Float.intBitsToFloat(0)) {
            if (Minecraft.getMinecraft().thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
               return 135.0F;
            }

            if (Minecraft.getMinecraft().thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
               return -135.0F;
            }

            return -180.0F;
         }

         if (Minecraft.getMinecraft().thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
            return 90.0F;
         }

         if (Minecraft.getMinecraft().thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
            return -90.0F;
         }
      }

      return Float.intBitsToFloat(0);
   }

   public static float _award() {
      if (Minecraft.getMinecraft().thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
         if (Minecraft.getMinecraft().thePlayer.moveForward < Float.intBitsToFloat(0)) {
            return 45.0F;
         }

         if (Minecraft.getMinecraft().thePlayer.moveForward > Float.intBitsToFloat(0)) {
            return -45.0F;
         }
      } else {
         if (Minecraft.getMinecraft().thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
            if (Minecraft.getMinecraft().thePlayer.moveForward < Float.intBitsToFloat(0)) {
               return 135.0F;
            }

            if (Minecraft.getMinecraft().thePlayer.moveForward > Float.intBitsToFloat(0)) {
               return -135.0F;
            }

            return -180.0F;
         }

         if (Minecraft.getMinecraft().thePlayer.moveForward < Float.intBitsToFloat(0)) {
            return 90.0F;
         }

         if (Minecraft.getMinecraft().thePlayer.moveForward > Float.intBitsToFloat(0)) {
            return -90.0F;
         }
      }

      return Float.intBitsToFloat(0);
   }

   public static double _changing() {
      Object ronebolo = finance$.thePlayer.rotationYaw;
      if (finance$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         ronebolo += 180.0F;
      }

      Object cinenide = 1.0F;
      if (finance$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         cinenide = -0.5F;
      } else if (finance$.thePlayer.moveForward > Float.intBitsToFloat(0)) {
         cinenide = 0.5F;
      }

      if (finance$.thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
         ronebolo -= 90.0F * cinenide;
      }

      if (finance$.thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
         ronebolo += 90.0F * cinenide;
      }

      return Math.toRadians((double)ronebolo);
   }

   public double _person() {
      Object autumn = finance$.thePlayer.rotationYaw;
      if (finance$.thePlayer.moveForward < Float.intBitsToFloat(0) && finance$.thePlayer.moveStrafing == Float.intBitsToFloat(0)) {
         autumn += 180.0F;
      }

      float var2 = 1.0F;
      if (finance$.thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
         autumn -= 90.0F;
      }

      if (finance$.thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
         autumn += 90.0F;
      }

      return Math.toRadians((double)autumn);
   }

   public double _extra(float inegifat) {
      Object mufilefe = (float)inegifat;
      if (finance$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         mufilefe = inegifat + 180.0F;
      }

      Object ococufuy = 1.0F;
      if (finance$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         ococufuy = -0.5F;
      } else if (finance$.thePlayer.moveForward > Float.intBitsToFloat(0)) {
         ococufuy = 0.5F;
      }

      if (finance$.thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
         mufilefe -= 90.0F * ococufuy;
      }

      if (finance$.thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
         mufilefe += 90.0F * ococufuy;
      }

      return Math.toRadians((double)mufilefe);
   }

   public static double _planner() {
      Object ezoromur = 0.2873D;
      if (finance$.thePlayer.isPotionActive(Potion.moveSpeed)) {
         ezoromur *= 1.0D + 0.2D * (double)(finance$.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1);
      }

      return ezoromur;
   }

   public double _acquired() {
      Object zamuzaso = 0.2875D;
      if (finance$.thePlayer.isPotionActive(Potion.moveSpeed)) {
         zamuzaso *= 1.0D + 0.2D * (double)(finance$.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1);
      }

      return zamuzaso;
   }

   public double _genres(float cliff) {
      Object petition = Potion.jump;
      if (finance$.thePlayer.isPotionActive(petition)) {
         Object interior = finance$.thePlayer.getActivePotionEffect(petition).getAmplifier();
         cliff += (float)(interior + 1) * 0.1F;
      }

      return (double)cliff;
   }

   public static double _bermuda(double isaac) {
      return (isaac - 0.08D) * 0.9800000190734863D;
   }

   public void _listed(EventMove aserasas, double acezaviv) {
      isuyeyil._pleasant((EventMove)aserasas, (double)acezaviv, finance$.thePlayer.rotationYaw, (double)finance$.thePlayer.movementInput.moveStrafe, (double)finance$.thePlayer.movementInput.moveForward);
   }

   public boolean _dylan(double abosecin) {
      return !finance$.theWorld.getCollidingBoundingBoxes(finance$.thePlayer, finance$.thePlayer.getEntityBoundingBox().offset(Double.longBitsToDouble(0L), (double)(-abosecin), Double.longBitsToDouble(0L))).isEmpty();
   }

   public Vector2d _disco(double talavoze) {
      Object durofonu = finance$.thePlayer.movementInput;
      Object nofudanu = (double)durofonu.moveForward;
      Object ugotubet = (double)durofonu.moveStrafe;
      double var8 = (double)finance$.thePlayer.rotationYaw;
      if (nofudanu == Double.longBitsToDouble(0L) && ugotubet == Double.longBitsToDouble(0L)) {
         return new Vector2d(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L));
      } else {
         if (ugotubet > Double.longBitsToDouble(0L)) {
            ugotubet = 1.0D;
         } else if (ugotubet < Double.longBitsToDouble(0L)) {
            ugotubet = -1.0D;
         }

         if (nofudanu != Double.longBitsToDouble(0L)) {
            if (ugotubet > Double.longBitsToDouble(0L)) {
               var8 += nofudanu > Double.longBitsToDouble(0L) ? -45.0D : 45.0D;
            } else if (ugotubet < Double.longBitsToDouble(0L)) {
               var8 += nofudanu > Double.longBitsToDouble(0L) ? 45.0D : -45.0D;
            }

            ugotubet = Double.longBitsToDouble(0L);
            if (nofudanu > Double.longBitsToDouble(0L)) {
               nofudanu = 1.0D;
            } else if (nofudanu < Double.longBitsToDouble(0L)) {
               nofudanu = -1.0D;
            }
         }

         var8 = var8 * 0.995D;
         double var10 = Math.cos(Math.toRadians(var8 + 90.0D));
         double var12 = Math.sin(Math.toRadians(var8 + 90.0D));
         return new Vector2d(nofudanu * talavoze * var10 + ugotubet * talavoze * var12, nofudanu * talavoze * var12 - ugotubet * talavoze * var10);
      }
   }

   public void _pleasant(EventMove izidelor, double ebuforog, float badobiza, double esuyamic, double imanivog) {
      Object ayapupoc = (double)imanivog;
      double var11 = (double)esuyamic;
      float var13 = (float)badobiza;
      if (imanivog != Double.longBitsToDouble(0L)) {
         if (esuyamic > Double.longBitsToDouble(0L)) {
            var13 = badobiza + (float)(imanivog > Double.longBitsToDouble(0L) ? -45 : 45);
         } else if (esuyamic < Double.longBitsToDouble(0L)) {
            var13 = badobiza + (float)(imanivog > Double.longBitsToDouble(0L) ? 45 : -45);
         }

         var11 = Double.longBitsToDouble(0L);
         if (imanivog > Double.longBitsToDouble(0L)) {
            ayapupoc = 1.0D;
         } else if (imanivog < Double.longBitsToDouble(0L)) {
            ayapupoc = -1.0D;
         }
      }

      if (var11 > Double.longBitsToDouble(0L)) {
         var11 = 1.0D;
      } else if (var11 < Double.longBitsToDouble(0L)) {
         var11 = -1.0D;
      }

      double var14 = Math.cos(Math.toRadians((double)(var13 + 90.0F)));
      double var16 = Math.sin(Math.toRadians((double)(var13 + 90.0F)));
      ((EventMove)izidelor).setX(ayapupoc * ebuforog * var14 + var11 * ebuforog * var16);
      ((EventMove)izidelor).setZ(ayapupoc * ebuforog * var16 - var11 * ebuforog * var14);
   }

   public static float _slovak() {
      Object teyorafe = 3.0F;
      if (finance$.thePlayer.isPotionActive(Potion.jump)) {
         Object gezemoyo = finance$.thePlayer.getActivePotionEffect(Potion.jump).getAmplifier();
         teyorafe += (float)(gezemoyo + 1);
      }

      return teyorafe;
   }

   public static double _uruguay(double tefipalo) {
      return (double)Math.round(tefipalo / 0.015625D) * 0.015625D;
   }

   public static int _surrey() {
      return EnchantmentHelper.getDepthStriderModifier(finance$.thePlayer);
   }

   public static boolean _serves(boolean enutusas) {
      return enutusas ? finance$.thePlayer.moveForward >= 0.8F && !finance$.thePlayer.isCollidedHorizontally && (finance$.thePlayer.getFoodStats().getFoodLevel() > 6 || finance$.thePlayer.capabilities.allowFlying) && !finance$.thePlayer.isPotionActive(Potion.blindness) && !finance$.thePlayer.isUsingItem() && !finance$.thePlayer.isSneaking() : _emacs();
   }

   public static boolean _emacs() {
      return Math.abs(finance$.thePlayer.moveForward) >= 0.8F || Math.abs(finance$.thePlayer.moveStrafing) >= 0.8F;
   }

   public static boolean _crops() {
      return finance$.thePlayer.isInWater() || finance$.thePlayer.isInLava();
   }

   public static double _julia() {
      Object auction = false;
      double nobody;
      if (finance$.thePlayer.isInWeb) {
         nobody = 0.105D;
      } else if (_crops()) {
         nobody = 0.11500000208616258D;
         int var3 = _surrey();
         if (var3 > 0) {
            nobody *= planning$[var3];
            auction = true;
         }
      } else if (finance$.thePlayer.isSneaking()) {
         nobody = 0.0663000026345253D;
      } else {
         nobody = 0.221D;
         auction = true;
      }

      if (auction) {
         if (_serves(false)) {
            nobody *= 1.2999999523162842D;
         }

         Client.î ?();
         Scaffold var4 = (Scaffold) ModuleManager._herbs(Scaffold.class);
         if (finance$.thePlayer.isPotionActive(Potion.moveSpeed) && finance$.thePlayer.getActivePotionEffect(Potion.moveSpeed).getDuration() > 0) {
            nobody *= 1.0D + 0.2D * (double)(finance$.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1);
         }

         if (finance$.thePlayer.isPotionActive(Potion.moveSlowdown)) {
            nobody = 0.29D;
         }
      }

      Block var5 = _labor(Double.longBitsToDouble(0L), -1.0D, Double.longBitsToDouble(0L));
      if (var5 == Blocks.ice || var5 == Blocks.packed_ice) {
         nobody *= 1.2D;
      }

      return nobody;
   }

   public static double _divided() {
      Object pidareme = finance$.thePlayer.rotationYaw;
      if (finance$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         pidareme += 180.0F;
      }

      Object efezacan = 1.0F;
      if (finance$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         efezacan = -0.5F;
      } else if (finance$.thePlayer.moveForward > Float.intBitsToFloat(0)) {
         efezacan = 0.5F;
      }

      if (finance$.thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
         pidareme -= 90.0F * efezacan;
      }

      if (finance$.thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
         pidareme += 90.0F * efezacan;
      }

      return Math.toRadians((double)pidareme);
   }

   public static Block _labor(double amateset, double pesuluma, double var4) {
      return finance$.theWorld.getBlockState((new BlockPos(finance$.thePlayer)).add((double)amateset, (double)pesuluma, var4)).getBlock();
   }

   public static double _mating() {
      return _visitor(0.41999998688697815D);
   }

   public static double _visitor(double ugapatuv) {
      // $FF: Couldn't be decompiled
   }

   public static void _buried(double enhance, float var2) {
      if (_viral()) {
         var2 = (float)Math.toRadians((double)var2);
         finance$.thePlayer.motionX = (double)(-MathHelper.sin(var2)) * enhance;
         finance$.thePlayer.motionZ = (double)MathHelper.cos(var2) * enhance;
      }
   }

   public static double _goals() {
      return Math.hypot(finance$.thePlayer.motionX, finance$.thePlayer.motionZ);
   }

   public static void _consent(double slave) {
      if (_viral()) {
         double var2 = _banking();
         finance$.thePlayer.motionX = (double)(-MathHelper.sin((float)var2)) * slave;
         finance$.thePlayer.motionZ = (double)MathHelper.cos((float)var2) * slave;
      }
   }

   public static double _banking() {
      Object cazidude = finance$.thePlayer.rotationYaw;
      if (finance$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         cazidude += 180.0F;
      }

      Object ivomezis = 1.0F;
      if (finance$.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         ivomezis = -0.5F;
      } else if (finance$.thePlayer.moveForward > Float.intBitsToFloat(0)) {
         ivomezis = 0.5F;
      }

      if (finance$.thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
         cazidude -= 70.0F * ivomezis;
      }

      if (finance$.thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
         cazidude += 70.0F * ivomezis;
      }

      return Math.toRadians((double)cazidude);
   }
}
