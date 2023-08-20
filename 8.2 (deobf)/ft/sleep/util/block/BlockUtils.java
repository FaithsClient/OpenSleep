//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockBasePressurePlate;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockWall;
import net.minecraft.block.BlockWeb;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

public class BlockUtils {
   public static boolean _arrested(BlockPos culifipe) {
      return _elements(Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)culifipe).getBlock(), false);
   }

   public static Block _sounds(BlockPos scout) {
      Object organize = Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)scout);
      return organize.getBlock();
   }

   public static boolean _elements(Block sademoye, boolean nipafipo) {
      if (!(sademoye instanceof BlockCarpet) && !(sademoye instanceof BlockSnow) && !(sademoye instanceof BlockContainer) && !(sademoye instanceof BlockBasePressurePlate) && !((Block)sademoye).getMaterial().isLiquid()) {
         if (!nipafipo || !(sademoye instanceof BlockSlab) && !(sademoye instanceof BlockStairs) && !(sademoye instanceof BlockLadder) && !(sademoye instanceof BlockStainedGlassPane) && !(sademoye instanceof BlockWall) && !(sademoye instanceof BlockWeb) && !(sademoye instanceof BlockCactus) && !(sademoye instanceof BlockFalling) && sademoye != Blocks.glass_pane && sademoye != Blocks.iron_bars) {
            return ((Block)sademoye).getMaterial().isSolid() || !((Block)sademoye).isTranslucent() || ((Block)sademoye).isFullBlock();
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public static boolean _weights() {
      if (Minecraft.getMinecraft().thePlayer == null) {
         return false;
      } else {
         for(Object cugopagi = MathHelper.floor_double(Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().minX); cugopagi < MathHelper.floor_double(Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().maxX) + 1; ++cugopagi) {
            for(Object ilusuzid = MathHelper.floor_double(Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().minZ); ilusuzid < MathHelper.floor_double(Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().maxZ) + 1; ++ilusuzid) {
               Object megaloni = new BlockPos(cugopagi, (int)Minecraft.getMinecraft().thePlayer.getEntityBoundingBox().minY, ilusuzid);
               Object verusapu = Minecraft.getMinecraft().theWorld.getBlockState(megaloni).getBlock();
               if (verusapu != null && !(verusapu instanceof BlockAir)) {
                  return verusapu instanceof BlockLiquid;
               }
            }
         }

         return false;
      }
   }

   public static boolean _condo() {
      if (Minecraft.getMinecraft().thePlayer == null) {
         return false;
      } else {
         Object reprints = Minecraft.getMinecraft().thePlayer.getEntityBoundingBox();
         if (reprints == null) {
            return false;
         } else {
            reprints = reprints.contract(0.01D, Double.longBitsToDouble(0L), 0.01D).offset(Double.longBitsToDouble(0L), -0.01D, Double.longBitsToDouble(0L));
            Object supply = false;
            Object western = (int)reprints.minY;

            for(Object course = MathHelper.floor_double(reprints.minX); course < MathHelper.floor_double(reprints.maxX + 1.0D); ++course) {
               for(Object voting = MathHelper.floor_double(reprints.minZ); voting < MathHelper.floor_double(reprints.maxZ + 1.0D); ++voting) {
                  Object wants = Minecraft.getMinecraft().theWorld.getBlockState(new BlockPos(course, western, voting)).getBlock();
                  if (wants != Blocks.air) {
                     if (!(wants instanceof BlockLiquid)) {
                        return false;
                     }

                     supply = true;
                  }
               }
            }

            return supply;
         }
      }
   }
}
