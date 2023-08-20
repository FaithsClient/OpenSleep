//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender3D;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.events.world.EventTick;
import java.awt.Color;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.render.RenderUtils;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;

public class TunnelMiner extends Module {
   public static ResourceLocation raise$ = new ResourceLocation("note.harp");
   public static boolean floors$ = false;
   public static boolean beats$ = false;
   public static int raymond$;
   public static int protein$ = -1;
   public static BlockPos nights$;
   public static BlockPos title$;
   public static EnumFacing phantom$;

   public TunnelMiner() {
      super("ft.sleep.module.modules.TunnelMiner", new String[]{"ft.sleep.module.modules.TunnelMiner"}, ModuleType.Player);
   }

   public void _regime() {
      super._regime();
      floors$ = true;
      phantom$ = dasavovu.mc.thePlayer.getHorizontalFacing();
   }

   public void _homepage(boolean patio) {
      floors$ = (boolean)patio;
   }

   public void _discs() {
      super._discs();
      floors$ = false;
      beats$ = false;
      raymond$ = 0;
      nights$ = null;
      title$ = null;
      KeyBinding.setKeyBindState(columbia.mc.gameSettings.keyBindForward.getKeyCode(), false);
      KeyBinding.setKeyBindState(columbia.mc.gameSettings.keyBindAttack.getKeyCode(), false);
   }

   @EventHandler
   public void _ocean(EventRender3D cleaners) {
      if (floors$) {
         if (nights$ != null) {
            RenderUtils._craig(nights$, new Color(255, 255, 255), 1, ((EventRender3D)cleaners).getPartialTicks());
         }

      }
   }

   @EventHandler
   public void _punch(EventPreUpdate genre) {
      // $FF: Couldn't be decompiled
   }

   @EventHandler
   public void _resolved(EventTick massive) {
      if (floors$ && nights$ != null && creek.mc.thePlayer != null) {
         if (title$ == null || !title$.equals(nights$)) {
            raymond$ = 0;
         }

         title$ = nights$;
         MovingObjectPosition var2 = creek.mc.objectMouseOver;
         var2.hitVec = new net.minecraft.util.Vec3(nights$);
         EnumFacing var3 = var2.sideHit;
         if (protein$ != -1 && creek.mc.thePlayer.inventory.currentItem != protein$) {
            creek.mc.thePlayer.inventory.currentItem = protein$;
            creek.mc.thePlayer.sendQueue.addToSendQueue(new C09PacketHeldItemChange(protein$));
         }
      }

   }

   public static float _sigma(float nosacuco) {
      return (float)((double)nosacuco - Math.floor((double)(nosacuco / 360.0F) + 0.5D) * 360.0D);
   }

   public void _sleeping() {
      if (dollars.mc.objectMouseOver != null && dollars.mc.objectMouseOver.entityHit == null) {
         dollars.mc.thePlayer.swingItem();
      }

   }

   public BlockPos _assuming() {
      // $FF: Couldn't be decompiled
   }

   public int _viewed(BlockPos tuvunade) {
      Object inufotem = 1.0F;
      Object reborepa = -1;
      Object eramidid = pidayena.mc.theWorld.getBlockState((BlockPos)tuvunade);

      for(Object dizacici = 0; dizacici < 9; ++dizacici) {
         Object disotise = pidayena.mc.thePlayer.inventory.getStackInSlot(dizacici);
         if (disotise != null) {
            Object uraporoz = disotise.getStrVsBlock(eramidid.getBlock());
            if (uraporoz > inufotem) {
               inufotem = uraporoz;
               reborepa = dizacici;
            }
         }
      }

      return reborepa;
   }
}
