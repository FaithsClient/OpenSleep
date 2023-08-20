//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import java.awt.Color;
import java.util.Random;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraft.util.BlockPos;

public class Reach extends Module {
   public static Numbers penguin$ = new Numbers("ft.sleep.module.modules.Reach (Max Combo)", 3.0D, 3.0D, 6.0D, 0.1D);
   public static Numbers apart$ = new Numbers("ft.sleep.module.modules.Reach (Min Combo)", 3.0D, 3.0D, 6.0D, 0.1D);
   public static Option bacon$ = new Option("Weapon Only", false);
   public static Option animals$ = new Option("Moving only", false);
   public static Option preview$ = new Option("ft.sleep.module.modules.Sprint only", false);
   public static Option prague$ = new Option("Hit through blocks", false);
   public static Random picture$ = new Random();

   public Reach() {
      super("ft.sleep.module.modules.Reach", new String[]{"ft.sleep.module.modules.Reach"}, ModuleType.Combat);
      mobidosa._piece((new Color(191, 191, 191)).getRGB());
   }

   public static double _advised(double acuraget, double elomogay) {
      Object butodazu = new Random();
      Object oluvaguv = (double)(elomogay - acuraget);
      double var7 = butodazu.nextDouble() * oluvaguv;
      double var9 = var7 + acuraget;
      return var9;
   }

   @EventHandler
   public void _laptop(EventPreUpdate var1) {
   }

   public static double _edition() {
      Object epurilod = (Reach) ModuleManager._herbs(Reach.class);
      Object gugaliya = (KillAura)ModuleManager._herbs(KillAura.class);
      if (gugaliya._central()) {
         return KillAura.formula$.getValue().doubleValue();
      } else {
         Object isorodaf = Minecraft.getMinecraft().playerController.extendedReach() ? 5.0D : 3.0D;
         if (!_latter()) {
            return isorodaf;
         } else if (bacon$.getValue().booleanValue() && !_station()) {
            return isorodaf;
         } else if (animals$.getValue().booleanValue() && (double)Minecraft.getMinecraft().thePlayer.moveForward == Double.longBitsToDouble(0L) && (double)Minecraft.getMinecraft().thePlayer.moveStrafing == Double.longBitsToDouble(0L)) {
            return isorodaf;
         } else if (preview$.getValue().booleanValue() && !Minecraft.getMinecraft().thePlayer.isSprinting()) {
            return isorodaf;
         } else {
            if (!prague$.getValue().booleanValue() && Minecraft.getMinecraft().objectMouseOver != null) {
               BlockPos var4 = Minecraft.getMinecraft().objectMouseOver.getBlockPos();
               if (var4 != null && Minecraft.getMinecraft().theWorld.getBlockState(var4).getBlock() != Blocks.air) {
                  return isorodaf;
               }
            }

            return _western(_future()) + (double)(Minecraft.getMinecraft().playerController.extendedReach() ? 2 : 0);
         }
      }
   }

   public static double _western(Random stuart) {
      return apart$.getValue().doubleValue() == penguin$.getValue().doubleValue() ? apart$.getValue().doubleValue() : apart$.getValue().doubleValue() + ((Random)stuart).nextDouble() * (penguin$.getValue().doubleValue() - apart$.getValue().doubleValue());
   }

   public static Random _future() {
      return picture$;
   }

   public static boolean _latter() {
      return Minecraft.getMinecraft().thePlayer != null && Minecraft.getMinecraft().theWorld != null;
   }

   public static boolean _station() {
      Object quickly = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem();
      return quickly != null && (quickly.getItem() instanceof ItemSword || quickly.getItem() instanceof ItemAxe);
   }
}
