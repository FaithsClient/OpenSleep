package rip.sleep.module.modules;

import java.awt.Color;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import org.json.JSONException;
import rip.sleep.event.events.StartUpdateEvent;
import rip.sleep.event.EventTarget;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.value.Value;

public class SafeWalk extends Module {
   public SafeWalk() {
      super("Safe Walk", new String[]{"safewalk", "eagle"}, ModuleType.c62580, ModuleType.c21190.c37885);
      this.c36162((new Color(198, 253, 191)).getRGB());
   }

   public Block c41485(BlockPos var1) {
      return mc.theWorld.getBlockState(var1).getBlock();
   }

   public Block c99685(EntityPlayer var1) {
      return this.c41485(new BlockPos(var1.posX, var1.posY - 1.0D, var1.posZ));
   }

   @EventTarget
   public void c71217(StartUpdateEvent var1) {
      Module[] var2 = Value.c27574();
      if (this.c99685(mc.thePlayer) instanceof BlockAir) {
         if (!mc.thePlayer.onGround) {
            return;
         }

         KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), true);
      }

      if (mc.thePlayer.onGround) {
         KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
      }

   }

   public void c83205() {
      mc.thePlayer.setSneaking(false);
      super.c83205();
   }

   public void c71897() {
      KeyBinding.setKeyBindState(mc.gameSettings.keyBindSneak.getKeyCode(), false);
      super.c71897();
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
