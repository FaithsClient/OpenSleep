//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.Client;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.misc.EventJump;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.events.world.LivingUpdateEvent;
import ft.sleep.api.value.Option;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import ft.sleep.util.player.MovementUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;

public class Sprint extends Module {
   public static Option material$ = new Option("MultiDir", false);
   public static Option valium$ = new Option("MultiDirJump", false);
   public boolean number$ = false;
   public boolean treaty$ = false;
   public static boolean actual$ = false;

   public Sprint() {
      super("ft.sleep.module.modules.Sprint", new String[]{"ft.sleep.module.modules.Sprint"}, ModuleType.Movement);
   }

   public void _discs() {
      oyelapap.mc.thePlayer.setSprinting(false);
      super._discs();
   }

   @EventHandler
   public void _recorder(EventJump onimovop) {
      if (taredabu.treaty$) {
         ((EventJump)onimovop).cancel();
      }

   }

   @EventHandler
   public void _criteria(LivingUpdateEvent omucuvac) {
      if (MovementUtils._bumper() && !itugalay.mc.thePlayer.isSneaking() && (itugalay.mc.thePlayer.moveForward >= 0.8F || material$.getValue().booleanValue())) {
         if (material$.getValue().booleanValue() || itugalay.mc.thePlayer.movementInput.moveForward >= 0.8F) {
            itugalay.mc.thePlayer.setSprinting(true);
         }

         Client.î ?();
         if (!ModuleManager._herbs(Speed.class)._central() && itugalay.mc.thePlayer.onGround && itugalay.mc.gameSettings.keyBindJump.isKeyDown() && valium$.getValue().booleanValue() && (itugalay.mc.thePlayer.movementInput.moveForward != Float.intBitsToFloat(0) || itugalay.mc.thePlayer.movementInput.moveStrafe != Float.intBitsToFloat(0)) && !itugalay.mc.thePlayer.isInWater() && !itugalay.mc.thePlayer.isInLava() && !itugalay.mc.thePlayer.isOnLadder() && !itugalay.mc.thePlayer.isInWeb) {
            if (itugalay.mc.gameSettings.keyBindJump.isKeyDown()) {
               itugalay.mc.gameSettings.keyBindJump.pressed = false;
               itugalay.number$ = true;
            }

            float var2 = itugalay.mc.thePlayer.rotationYaw;
            itugalay.mc.thePlayer.rotationYaw = itugalay._trades();
            itugalay.mc.thePlayer.jump();
            itugalay.mc.thePlayer.rotationYaw = var2;
            itugalay.treaty$ = true;
            if (itugalay.number$) {
               itugalay.mc.gameSettings.keyBindJump.pressed = true;
               itugalay.number$ = false;
            }
         } else {
            itugalay.treaty$ = false;
         }

      } else {
         itugalay.mc.thePlayer.setSprinting(false);
      }
   }

   @EventHandler
   public void _tuner(EventPreUpdate ecogatef) {
      actual$ = false;
      if (MovementUtils._bumper() && !sadufaro.mc.thePlayer.isSneaking() && (sadufaro.mc.thePlayer.moveForward >= 0.8F || material$.getValue().booleanValue())) {
         if ((material$.getValue().booleanValue() || sadufaro.mc.thePlayer.movementInput.moveForward >= 0.8F) && !sadufaro.mc.thePlayer.isSneaking() && sadufaro.mc.gameSettings.keyBindBack.isKeyDown()) {
            if (sadufaro._dated(sadufaro.mc.thePlayer) && sadufaro.mc.gameSettings.keyBindRight.isKeyDown()) {
               return;
            }

            actual$ = true;
            ((EventPreUpdate)ecogatef).setYaw(sadufaro._trades());
         }

      } else {
         sadufaro.mc.thePlayer.setSprinting(false);
      }
   }

   public boolean _dated(EntityPlayer gevuyadu) {
      return ((EntityPlayer)gevuyadu).inventory.getCurrentItem() != null && ((EntityPlayer)gevuyadu).inventory.getCurrentItem().getItem() instanceof ItemBlock;
   }

   public float _trades() {
      Object rinacupu = irizices.mc.thePlayer.rotationYaw;
      if (irizices.mc.thePlayer.moveForward != Float.intBitsToFloat(0) && irizices.mc.thePlayer.moveStrafing == Float.intBitsToFloat(0)) {
         rinacupu += irizices.mc.thePlayer.moveForward > Float.intBitsToFloat(0) ? Float.intBitsToFloat(0) : 180.0F;
      } else if (irizices.mc.thePlayer.moveForward != Float.intBitsToFloat(0) && irizices.mc.thePlayer.moveStrafing != Float.intBitsToFloat(0)) {
         if (irizices.mc.thePlayer.moveForward > Float.intBitsToFloat(0)) {
            rinacupu = rinacupu + (irizices.mc.thePlayer.moveStrafing > Float.intBitsToFloat(0) ? -45.0F : 45.0F);
         } else {
            rinacupu = rinacupu - (irizices.mc.thePlayer.moveStrafing > Float.intBitsToFloat(0) ? -45.0F : 45.0F);
         }

         rinacupu = rinacupu + (irizices.mc.thePlayer.moveForward > Float.intBitsToFloat(0) ? Float.intBitsToFloat(0) : 180.0F);
      } else if (irizices.mc.thePlayer.moveStrafing != Float.intBitsToFloat(0) && irizices.mc.thePlayer.moveForward == Float.intBitsToFloat(0)) {
         rinacupu += irizices.mc.thePlayer.moveStrafing > Float.intBitsToFloat(0) ? -90.0F : 90.0F;
      }

      return rinacupu;
   }
}
