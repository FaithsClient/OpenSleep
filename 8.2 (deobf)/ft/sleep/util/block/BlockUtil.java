//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.block;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBasePressurePlate;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockWall;
import net.minecraft.block.BlockWeb;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class BlockUtil {
   public static Block _anywhere(BlockPos repeated) {
      return Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)repeated).getBlock();
   }

   public static net.minecraft.util.Vec3 _further(BlockPos dialogue, EnumFacing reviews) {
      Object april = (double)((BlockPos)dialogue).getX();
      Object seconds = (double)((BlockPos)dialogue).getY();
      Object flush = (double)((BlockPos)dialogue).getZ();
      double var8 = ThreadLocalRandom.current().nextDouble(0.47D, 0.53D);
      double var10 = ThreadLocalRandom.current().nextDouble(0.47D, 0.53D);
      if (((EnumFacing)reviews).equals(EnumFacing.UP)) {
         april += var8;
         flush += var8;
         ++seconds;
      } else if (((EnumFacing)reviews).equals(EnumFacing.DOWN)) {
         april += var8;
         flush += var8;
      } else if (((EnumFacing)reviews).equals(EnumFacing.WEST)) {
         seconds += var10;
         flush += var8;
      } else if (((EnumFacing)reviews).equals(EnumFacing.EAST)) {
         seconds += var10;
         flush += var8;
         ++april;
      } else if (((EnumFacing)reviews).equals(EnumFacing.SOUTH)) {
         seconds += var10;
         april += var8;
         ++flush;
      } else if (((EnumFacing)reviews).equals(EnumFacing.NORTH)) {
         seconds += var10;
         april += var8;
      }

      return new net.minecraft.util.Vec3(april, seconds, flush);
   }

   public static boolean _cursor(Block unidiyin, boolean gezunuyi) {
      if (!(unidiyin instanceof BlockCarpet) && !(unidiyin instanceof BlockSnow) && !(unidiyin instanceof BlockContainer) && !(unidiyin instanceof BlockBasePressurePlate) && !((Block)unidiyin).getMaterial().isLiquid()) {
         if (!gezunuyi || !(unidiyin instanceof BlockSlab) && !(unidiyin instanceof BlockStairs) && !(unidiyin instanceof BlockLadder) && !(unidiyin instanceof BlockStainedGlassPane) && !(unidiyin instanceof BlockWall) && !(unidiyin instanceof BlockWeb) && !(unidiyin instanceof BlockCactus) && !(unidiyin instanceof BlockFalling) && unidiyin != Blocks.glass_pane && unidiyin != Blocks.iron_bars) {
            return ((Block)unidiyin).getMaterial().isSolid() || !((Block)unidiyin).isTranslucent() || ((Block)unidiyin).isFullBlock();
         } else {
            return false;
         }
      } else {
         return false;
      }
   }
}
