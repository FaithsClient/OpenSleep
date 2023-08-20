//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Option;
import java.util.concurrent.ThreadLocalRandom;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import net.minecraft.block.BlockFurnace;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class AntiObbyTrap extends Module {
   public static boolean deborah$ = false;
   public Option hudson$ = new Option("No Swing", false);
   public Option sheets$ = new Option("Anti Sand Trap", true);
   public float equipped$;
   public boolean carlo$;

   public AntiObbyTrap() {
      super("Anti Obby Trap", new String[]{"ft.sleep.module.modules.AntiObbyTrap"}, ModuleType.Combat);
   }

   @EventHandler
   public void _launch(EventPreUpdate aramenay) {
      Client2.î ?();
      Client2.î ?();
      if (!ModuleManager._herbs(Freecam.class)._central()) {
         if (figumicu.mc.theWorld.getBlockState(new BlockPos(((EventPreUpdate)aramenay).getX(), ((EventPreUpdate)aramenay).getY() + 1.0D, ((EventPreUpdate)aramenay).getZ())).getBlock() != Blocks.obsidian && figumicu.mc.theWorld.getBlockState(new BlockPos(((EventPreUpdate)aramenay).getX(), ((EventPreUpdate)aramenay).getY() + 1.0D, ((EventPreUpdate)aramenay).getZ())).getBlock() != Blocks.cobblestone && !(figumicu.mc.theWorld.getBlockState(new BlockPos(((EventPreUpdate)aramenay).getX(), ((EventPreUpdate)aramenay).getY() + 2.0D, ((EventPreUpdate)aramenay).getZ())).getBlock() instanceof BlockFurnace)) {
            figumicu.equipped$ = Float.intBitsToFloat(0);
            figumicu.carlo$ = false;
         } else {
            ((EventPreUpdate)aramenay).setPitch(89.0F + ThreadLocalRandom.current().nextFloat());
            Object rubetose = figumicu.mc.theWorld.getBlockState(new BlockPos(((EventPreUpdate)aramenay).getX(), ((EventPreUpdate)aramenay).getY() - 1.0D, ((EventPreUpdate)aramenay).getZ())).getBlock();
            Object lofimire = new BlockPos(((EventPreUpdate)aramenay).getX(), ((EventPreUpdate)aramenay).getY() - 1.0D, ((EventPreUpdate)aramenay).getZ());
            if (figumicu.equipped$ == Float.intBitsToFloat(0)) {
               figumicu.carlo$ = true;
               PacketUtils._payroll(new C07PacketPlayerDigging(Action.START_DESTROY_BLOCK, lofimire, EnumFacing.UP));
            }

            figumicu._probe(lofimire);
            PacketUtils._payroll(new C0APacketAnimation());
            figumicu.equipped$ += rubetose.getPlayerRelativeBlockHardness(figumicu.mc.thePlayer, figumicu.mc.theWorld, lofimire);
            figumicu.mc.theWorld.sendBlockBreakProgress(figumicu.mc.thePlayer.getEntityId(), lofimire, (int)(figumicu.equipped$ * 10.0F) - 1);
            if (figumicu.equipped$ >= 1.0F) {
               PacketUtils._payroll(new C07PacketPlayerDigging(Action.STOP_DESTROY_BLOCK, lofimire, EnumFacing.UP));
               figumicu.mc.playerController.onPlayerDestroyBlock(lofimire, EnumFacing.UP);
               figumicu.equipped$ = Float.intBitsToFloat(0);
               figumicu.carlo$ = false;
            }
         }
      }

   }

   @EventHandler
   public void _rating(EventPreUpdate textbook) {
      Client2.î ?();
      Client2.î ?();
      if (!ModuleManager._herbs(Freecam.class)._central()) {
         deborah$ = false;
         Object strap = new BlockPos(honda.mc.thePlayer.posX, honda.mc.thePlayer.posY, honda.mc.thePlayer.posZ);
         Object contacts = honda.mc.theWorld.getBlockState(strap.up()).getBlock();
         if (contacts == Blocks.gravel || contacts == Blocks.sand) {
            strap = new BlockPos(honda.mc.thePlayer.posX, honda.mc.thePlayer.posY + 1.0D, honda.mc.thePlayer.posZ);
         }

         Object perry = honda.mc.theWorld.getBlockState(strap).getBlock();
         if (perry == Blocks.gravel || perry == Blocks.sand) {
            deborah$ = false;
            if (honda.sheets$.getValue().booleanValue()) {
               ((EventPreUpdate)textbook).setPitch(90.0F);
               honda._sensor(strap, EnumFacing.UP);
            }
         }
      }

   }

   public boolean _player() {
      return amegidud.carlo$;
   }

   public void _probe(BlockPos emisisis) {
      Object cisitofo = eyagitec.mc.theWorld.getBlockState((BlockPos)emisisis).getBlock();
      Object norecopi = 1.0F;
      Object teyeyule = -1;

      for(Object atebasos = 0; atebasos < 9; ++atebasos) {
         Object olunetuf = eyagitec.mc.thePlayer.inventory.getStackInSlot(atebasos);
         if (olunetuf != null && olunetuf.getStrVsBlock(cisitofo) > norecopi) {
            teyeyule = atebasos;
            norecopi = olunetuf.getStrVsBlock(cisitofo);
         }
      }

      if (teyeyule != -1 && eyagitec.mc.thePlayer.inventory.getStackInSlot(eyagitec.mc.thePlayer.inventory.currentItem) != eyagitec.mc.thePlayer.inventory.getStackInSlot(teyeyule)) {
         eyagitec.mc.thePlayer.inventory.currentItem = teyeyule;
      }

   }

   public void _sensor(BlockPos enimudic, EnumFacing niruduma) {
      if (azocodub.hudson$.getValue().booleanValue()) {
         PacketUtils._payroll(new C0APacketAnimation());
      }

      azocodub.mc.thePlayer.swingItem();
      PacketUtils._payroll(new C07PacketPlayerDigging(Action.START_DESTROY_BLOCK, (BlockPos)enimudic, (EnumFacing)niruduma));
      PacketUtils._payroll(new C07PacketPlayerDigging(Action.STOP_DESTROY_BLOCK, (BlockPos)enimudic, (EnumFacing)niruduma));
      PacketUtils._payroll(new C07PacketPlayerDigging(Action.START_DESTROY_BLOCK, (BlockPos)enimudic, (EnumFacing)niruduma));
   }
}
