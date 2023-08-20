//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventUpdate;
import java.awt.Color;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;

public class SafeWalk extends Module {
   public SafeWalk() {
      super("ft.sleep.module.modules.SafeWalk", new String[]{"eagle", "parkour"}, ModuleType.Combat);
      butler._piece((new Color(198, 253, 191)).getRGB());
   }

   public Block _joyce(BlockPos kerry) {
      return august.mc.theWorld.getBlockState((BlockPos)kerry).getBlock();
   }

   public Block _finds(EntityPlayer veturonu) {
      return odarevuz._joyce(new BlockPos(((EntityPlayer)veturonu).posX, ((EntityPlayer)veturonu).posY - 1.0D, ((EntityPlayer)veturonu).posZ));
   }

   @EventHandler
   public void _explore(EventUpdate var1) {
      if (iciyulit._finds(iciyulit.mc.thePlayer) instanceof BlockAir) {
         if (iciyulit.mc.thePlayer.onGround) {
            KeyBinding.setKeyBindState(iciyulit.mc.gameSettings.keyBindSneak.getKeyCode(), true);
         }
      } else if (iciyulit.mc.thePlayer.onGround) {
         KeyBinding.setKeyBindState(iciyulit.mc.gameSettings.keyBindSneak.getKeyCode(), false);
      }

   }

   public void _regime() {
      toyadane.mc.thePlayer.setSneaking(false);
      super._regime();
   }

   public void _discs() {
      KeyBinding.setKeyBindState(seasonal.mc.gameSettings.keyBindSneak.getKeyCode(), false);
      super._discs();
   }
}
