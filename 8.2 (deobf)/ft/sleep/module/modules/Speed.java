//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.Client;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.misc.EventJump;
import ft.sleep.api.events.misc.StrafeEvent;
import ft.sleep.api.events.world.EventPacketReceive;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import java.awt.Color;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import ft.sleep.util.player.MovementUtils;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockPos;

public class Speed extends Module {
   public static Option chips$ = new Option("Full Strafe", false);
   public static Option praise$ = new Option("Lag backcheck", false);
   public static Numbers ghost$ = new Numbers("Air ft.sleep.module.modules.Timer", 1.0D, 1.0D, 3.0D, 0.01D);
   public static Numbers score$ = new Numbers("Ground Stay", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(10), 1.0D);
   public static Numbers tamil$ = new Numbers("Ground ft.sleep.module.modules.Timer", 1.0D, 1.0D, 3.0D, 0.01D);
   public static Numbers worried$ = new Numbers("Custom Strength", 0.67D, Double.longBitsToDouble(0L), 1.0D, 0.01D);
   public static double hotel$ = 0.221D;
   public static double visible$ = 1.2999999523162842D;
   public static double assigned$ = 0.30000001192092896D;
   public static double coastal$ = 2.5D;
   public static double things$ = 0.4751131221719457D;
   public static double miami$ = 0.5203620003898759D;
   public static double[] belfast$ = new double[]{1.0D, 1.4304347400741908D, 1.7347825295420372D, 1.9217390955733897D};
   public int skills$;

   public Speed() {
      super("Bhop", new String[]{"Bhop"}, ModuleType.Movement);
      adesatim._piece((new Color(99, 248, 91)).getRGB());
   }

   public void _regime() {
      Object tapolabi = new Module[]{ModuleManager._herbs(Scaffold.class)};
      Object bebanera = 0;

      for(Object viridavu : tapolabi) {
         if (viridavu._central()) {
            viridavu._myanmar();
            ++bebanera;
         }
      }

      if (bebanera > 0) {
         Client.surround$.î ?()._arabia().add(new Notification("Disabled " + bebanera + " clash modules"));
      }

      Helper._pillow().timerSpeed = 1.0F;
   }

   public void _discs() {
      Helper._pillow().timerSpeed = 1.0F;
   }

   @EventHandler
   public void _heads(EventPacketReceive var1) {
      if (praise$.getValue().booleanValue() && EventPacketReceive.getPacket() instanceof S08PacketPlayerPosLook) {
         Client.surround$.î ?()._arabia().add(new Notification("ft.sleep.module.modules.Speed was disabled to prevent flags/errors", (long)-1451629990 ^ -1451628062L));
         alerts._serial(false);
      }

   }

   @EventHandler
   public void _tests(StrafeEvent propose) {
      Object yellow = Math.sqrt(sheets.mc.thePlayer.motionX * sheets.mc.thePlayer.motionX + sheets.mc.thePlayer.motionZ * sheets.mc.thePlayer.motionZ);
      Object shannon = yellow * worried$.getValue().doubleValue();
      Object promise = sheets.mc.thePlayer.motionX * (1.0D - worried$.getValue().doubleValue());
      double var8 = sheets.mc.thePlayer.motionZ * (1.0D - worried$.getValue().doubleValue());
      double var10 = sheets.mc.thePlayer.hurtTime > 8 && sheets.mc.thePlayer.fallDistance < 3.0F && !sheets.mc.thePlayer.isPotionActive(Potion.poison) && !sheets.mc.thePlayer.isBurning() ? 0.4D : Double.longBitsToDouble(0L);
      double var12 = Math.hypot(sheets.mc.thePlayer.motionX, sheets.mc.thePlayer.motionZ) * var10;
      double var10000 = sheets.mc.thePlayer.motionX * (1.0D - var10);
      var10000 = sheets.mc.thePlayer.motionZ * (1.0D - var10);
      if (chips$.getValue().booleanValue() && !sheets.mc.thePlayer.onGround) {
         float var18 = sheets._imagine();
         sheets.mc.thePlayer.motionX = -Math.sin((double)var18) * shannon + promise;
         sheets.mc.thePlayer.motionZ = Math.cos((double)var18) * shannon + var8;
      }

   }

   @EventHandler
   public void _blessed(EventPreUpdate var1) {
      pubmed._infants("Watchdog");
      if (!pubmed.mc.thePlayer.isInWater()) {
         if (MovementUtils._bumper()) {
            _junction(Helper._pillow(), ghost$.getValue().floatValue());
            ++pubmed.skills$;
            if (pubmed.mc.thePlayer.onGround && pubmed.skills$ >= score$.getValue().intValue()) {
               _junction(Helper._pillow(), tamil$.getValue().floatValue());
               MovementUtils._parallel(0.428F);
               pubmed.mc.thePlayer.motionY = MovementUtils._turkey(0.41999998688698D, true);
               if (pubmed.mc.thePlayer.isPotionActive(Potion.moveSpeed) && pubmed.mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() == 0) {
                  MovementUtils._parallel(0.51F);
               }

               if (pubmed.mc.thePlayer.isPotionActive(Potion.moveSpeed) && pubmed.mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() == 1) {
                  MovementUtils._parallel(0.56F);
               }
            }
         } else {
            pubmed.skills$ = 0;
         }

      }
   }

   @EventHandler
   public void _cardiff(EventJump onopofep) {
      if (MovementUtils._bumper() && !MovementUtils._chapter()) {
         ((EventJump)onopofep).setCancelled(true);
      }

   }

   public int _maybe() {
      return EnchantmentHelper.getDepthStriderModifier(pibesebu.mc.thePlayer);
   }

   public boolean _featured(boolean idipofuy) {
      return idipofuy ? pupodive.mc.thePlayer.moveForward >= 0.8F && !pupodive.mc.thePlayer.isCollidedHorizontally && (pupodive.mc.thePlayer.getFoodStats().getFoodLevel() > 6 || pupodive.mc.thePlayer.capabilities.allowFlying) && !pupodive.mc.thePlayer.isPotionActive(Potion.blindness) && !pupodive.mc.thePlayer.isUsingItem() && !pupodive.mc.thePlayer.isSneaking() : pupodive._samba();
   }

   public boolean _samba() {
      return Math.abs(section.mc.thePlayer.moveForward) >= 0.8F || Math.abs(section.mc.thePlayer.moveStrafing) >= 0.8F;
   }

   public boolean _mental() {
      return irolizur.mc.thePlayer.isInWater() || irolizur.mc.thePlayer.isInLava();
   }

   public double _follow() {
      Object assault = false;
      double oakland;
      if (stephen.mc.thePlayer.isInWeb) {
         oakland = 0.105D;
      } else if (stephen._mental()) {
         oakland = 0.11500000208616258D;
         int var4 = stephen._maybe();
         if (var4 > 0) {
            oakland *= belfast$[var4];
            assault = true;
         }
      } else if (stephen.mc.thePlayer.isSneaking()) {
         oakland = 0.0663000026345253D;
      } else {
         oakland = 0.221D;
         assault = true;
      }

      if (assault) {
         if (stephen._featured(false)) {
            oakland *= 1.2999999523162842D;
         }

         if (stephen.mc.thePlayer.isPotionActive(Potion.moveSpeed) && stephen.mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getDuration() > 0) {
            oakland *= 1.0D + 0.2D * (double)(stephen.mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1);
         }

         if (stephen.mc.thePlayer.isPotionActive(Potion.moveSlowdown)) {
            oakland = 0.29D;
         }
      }

      Block var5 = stephen._treating(Double.longBitsToDouble(0L), -1.0D, Double.longBitsToDouble(0L));
      if (var5 == Blocks.ice || var5 == Blocks.packed_ice) {
         oakland *= 1.2D;
      }

      return oakland;
   }

   public Block _treating(double jeremy, double proposed, double var5) {
      return brings.mc.theWorld.getBlockState((new BlockPos(brings.mc.thePlayer)).add((double)jeremy, (double)proposed, var5)).getBlock();
   }

   public float _imagine() {
      Object ebuparur = (double)folipoda.mc.thePlayer.rotationYaw;
      if (folipoda.mc.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         ebuparur += 180.0D;
      }

      float var3 = 1.0F;
      if (folipoda.mc.thePlayer.moveForward < Float.intBitsToFloat(0)) {
         var3 = -0.5F;
      } else if (folipoda.mc.thePlayer.moveForward > Float.intBitsToFloat(0)) {
         var3 = 0.5F;
      }

      if (folipoda.mc.thePlayer.moveStrafing > Float.intBitsToFloat(0)) {
         ebuparur -= (double)(90.0F * var3);
      }

      if (folipoda.mc.thePlayer.moveStrafing < Float.intBitsToFloat(0)) {
         ebuparur += (double)(90.0F * var3);
      }

      return (float)Math.toRadians(ebuparur);
   }

   public static void _junction(net.minecraft.util.Timer factory, float passed) {
      ((net.minecraft.util.Timer)factory).timerSpeed = (float)passed;
   }
}
