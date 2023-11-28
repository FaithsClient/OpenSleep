package rip.sleep.util;

import Sleep.native0;
import rip.sleep.Sleep;
import rip.sleep.event.EventBus;
import java.awt.AWTException;
import java.awt.TrayIcon.MessageType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import org.json.JSONException;
import org.lwjgl.input.Keyboard;
import rip.sleep.event.events.*;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.modules.KillAura;
import rip.sleep.module.modules.XRay;
import rip.sleep.util.PlayerUtilG;
import rip.sleep.util.SystemTrayUtil;
import rip.sleep.value.Value;

@native0
public class MixinHelper {
   public static void c61698() {
      EventBus.getInstance().call(new LoopEvent());
   }

   public static void c5354() {
      if (XRay.c33034) {
         ModuleManager.c25475(XRay.class).c19741();
      }

      Sleep.getInstance().c28024();
   }

   public static void c7820(WorldClient var0) {
      WorldEvent var1 = new WorldEvent(var0);
      EventBus.getInstance().call(var1);
   }

   public static void c70436() {
      if (Keyboard.getEventKeyState() && Minecraft.getMinecraft().currentScreen == null) {
         EventBus.getInstance().call(new KeyPressEvent(Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey()));
      }

   }

   public static void c63932() {
      Sleep.getInstance().GameInitiatedEvent();
   }

   public static void c48150() {
      EventBus.getInstance().call(new EndTickEvent());
   }

   public static void c42863() {
   }

   public static void c66871() {
      if (Keyboard.getEventKeyState() && Minecraft.getMinecraft().currentScreen == null) {
         EventBus.getInstance().call(new KeyPressEvent(Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey()));
      }

   }

   public static void c59931() {
      String var10000 = "Client Injecting";
      String var10001 = "Injecting";
      MessageType var10002 = MessageType.INFO;
      long var10003 = 1000L;

      try {
         SystemTrayUtil.c85430(var10000, var10001, var10002, Long.valueOf(var10003));
      } catch (AWTException var1) {
         var1.printStackTrace();
      }

   }

   public static void c59991() {
      EventBus.getInstance().call(new BinEvent());
   }

   public static void c70586() {
      Module[] var0 = Value.c27574();
      if (!Minecraft.getMinecraft().playerController.getIsHittingBlock()) {
         Minecraft.getMinecraft().rightClickDelayTimer = 4;
         boolean var1 = true;
         ItemStack var2 = Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem();
         if (Minecraft.getMinecraft().objectMouseOver != null) {
            switch(null.c39699[Minecraft.getMinecraft().objectMouseOver.typeOfHit.ordinal()]) {
            case 1:
               if (Minecraft.getMinecraft().playerController.isPlayerRightClickingOnEntity(Minecraft.getMinecraft().thePlayer, Minecraft.getMinecraft().objectMouseOver.entityHit, Minecraft.getMinecraft().objectMouseOver)) {
                  var1 = false;
               }

               if (!Minecraft.getMinecraft().playerController.interactWithEntitySendPacket(Minecraft.getMinecraft().thePlayer, Minecraft.getMinecraft().objectMouseOver.entityHit)) {
                  break;
               }

               var1 = false;
            case 2:
               BlockPos var3 = Minecraft.getMinecraft().objectMouseOver.getBlockPos();
               Sleep var10000 = Sleep.INSTANCE;
               Sleep.c33759();
               KillAura var4 = (KillAura) ModuleManager.c25475(KillAura.class);
               if (Minecraft.getMinecraft().theWorld.getBlockState(var3).getBlock().getMaterial() != Material.air && (!var4.c24622() || KillAura.c79073() == null || !PlayerUtilG.c42924())) {
                  int var5 = var2 != null ? var2.stackSize : 0;
                  if (Minecraft.getMinecraft().playerController.onPlayerRightClick(Minecraft.getMinecraft().thePlayer, Minecraft.getMinecraft().theWorld, var2, var3, Minecraft.getMinecraft().objectMouseOver.sideHit, Minecraft.getMinecraft().objectMouseOver.hitVec)) {
                     var1 = false;
                     Minecraft.getMinecraft().thePlayer.swingItem();
                  }

                  if (var2 == null) {
                     return;
                  }

                  if (var2.stackSize == 0) {
                     Minecraft.getMinecraft().thePlayer.inventory.mainInventory[Minecraft.getMinecraft().thePlayer.inventory.currentItem] = null;
                  }

                  if (var2.stackSize != var5 || Minecraft.getMinecraft().playerController.isInCreativeMode()) {
                     Minecraft.getMinecraft().entityRenderer.itemRenderer.resetEquippedProgress();
                  }
               }
            }
         }

         if (var1) {
            ItemStack var6 = Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem();
            if (Minecraft.getMinecraft().playerController.sendUseItem(Minecraft.getMinecraft().thePlayer, Minecraft.getMinecraft().theWorld, var6)) {
               Minecraft.getMinecraft().entityRenderer.itemRenderer.resetEquippedProgress2();
            }
         }
      }

   }

   private static JSONException c55217(JSONException var0) {
      return var0;
   }
}
