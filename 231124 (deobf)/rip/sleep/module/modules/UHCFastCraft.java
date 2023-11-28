package rip.sleep.module.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.network.play.client.C16PacketClientStatus.EnumState;
import net.minecraft.network.play.server.S2DPacketOpenWindow;
import org.json.JSONException;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.PacketReceiveEvent;
import rip.sleep.event.events.Render2DEventA;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.ui.misc.GuiInventoryOverride;
import rip.sleep.util.PacketUtilA;
import rip.sleep.util.ServerUtilA;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;

public class UHCFastCraft extends Module {
   public static BooleanValue c80283 = new BooleanValue("Test", true);
   public static BooleanValue c15548 = new BooleanValue("Fast", true);

   public UHCFastCraft() {
      super("UHC FastCraft", new String[]{"UHC FastCraft"}, ModuleType.c31770, ModuleType.c21190.c55384);
   }

   @EventTarget
   public void c82182(Render2DEventA var1) {
      Module[] var2 = Value.c27574();
      if (Minecraft.getMinecraft().currentScreen instanceof GuiInventory && !(Minecraft.getMinecraft().currentScreen instanceof GuiInventoryOverride) && this.c24622() && ServerUtilA.c28223()) {
         Minecraft.getMinecraft().displayGuiScreen(new GuiInventoryOverride(Minecraft.getMinecraft().thePlayer));
      }

   }

   @EventTarget
   public void c93300(PacketReceiveEvent var1) {
      Module[] var2 = Value.c27574();
      if (ServerUtilA.c28223() && PacketReceiveEvent.getPacket() instanceof S2DPacketOpenWindow) {
         S2DPacketOpenWindow var3 = (S2DPacketOpenWindow) PacketReceiveEvent.getPacket();
         if (GuiInventoryOverride.c74590) {
            if (c80283.c1473().booleanValue()) {
               var1.c8253(true);
               mc.playerController.windowClick(var3.getWindowId(), 24, 0, 1, mc.thePlayer);
               PacketUtilA.sendPacketNoEvent(new C16PacketClientStatus(EnumState.OPEN_INVENTORY_ACHIEVEMENT));
               PacketUtilA.sendPacketNoEvent(new C0DPacketCloseWindow(var3.getWindowId()));
            }

            if (var3.getWindowTitle().getUnformattedText().equals("Crafting Table")) {
               var1.c8253(true);
               mc.playerController.windowClick(var3.getWindowId(), 24, 0, 1, mc.thePlayer);
               PacketUtilA.sendPacketNoEvent(new C16PacketClientStatus(EnumState.OPEN_INVENTORY_ACHIEVEMENT));
               PacketUtilA.sendPacketNoEvent(new C0DPacketCloseWindow(var3.getWindowId()));
            }

            GuiInventoryOverride.c74590 = false;
         }
      }

   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
