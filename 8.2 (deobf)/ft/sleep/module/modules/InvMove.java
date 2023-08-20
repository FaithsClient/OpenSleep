//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.GuiCloseEvent;
import ft.sleep.api.events.world.EventMove;
import ft.sleep.api.events.world.EventPacketSend;
import ft.sleep.api.events.world.LivingUpdateEvent;
import ft.sleep.api.value.Option;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.player.MovementUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import org.lwjgl.input.Keyboard;

public class InvMove extends Module {
   public boolean devil$;
   public static Option round$ = new Option("Cancel", Boolean.TRUE);
   public static Option school$ = new Option("inventory", Boolean.TRUE);

   public InvMove() {
      super("Inventory Move", new String[]{"InventoryMove"}, ModuleType.Movement);
   }

   public static void _hughes() {
      Object inecuzin = new KeyBinding[]{Minecraft.getMinecraft().gameSettings.keyBindForward, Minecraft.getMinecraft().gameSettings.keyBindRight, Minecraft.getMinecraft().gameSettings.keyBindBack, Minecraft.getMinecraft().gameSettings.keyBindLeft, Minecraft.getMinecraft().gameSettings.keyBindJump};

      for(Object yufiduco : inecuzin) {
         KeyBinding.setKeyBindState(yufiduco.getKeyCode(), Keyboard.isKeyDown(yufiduco.getKeyCode()));
      }

   }

   @EventHandler
   public void _shirts(LivingUpdateEvent var1) {
      if (!(sasodego.mc.currentScreen instanceof GuiChat) && (sasodego.mc.currentScreen instanceof GuiInventory || !school$.getValue().booleanValue())) {
         if (sasodego.mc.currentScreen != null) {
            _hughes();
         }

      }
   }

   @EventHandler
   public void _million(GuiCloseEvent var1) {
      if (!(spirits.mc.currentScreen instanceof GuiChat) && (spirits.mc.currentScreen instanceof GuiInventory || !school$.getValue().booleanValue())) {
         _hughes();
      }
   }

   @EventHandler
   public void _quizzes(EventMove suraladi) {
      if (round$.getValue().booleanValue() && oyuligor.devil$) {
         MovementUtils._blocks((EventMove)suraladi, Double.longBitsToDouble(0L));
      }

   }

   @EventHandler
   public void _songs(EventPacketSend var1) {
      if (round$.getValue().booleanValue()) {
         if (printers.mc.currentScreen != null && !(printers.mc.currentScreen instanceof GuiChat)) {
            if (EventPacketSend.getPacket() instanceof C0EPacketClickWindow) {
               printers.devil$ = true;
            }
         } else {
            printers.devil$ = false;
         }
      }

   }
}
