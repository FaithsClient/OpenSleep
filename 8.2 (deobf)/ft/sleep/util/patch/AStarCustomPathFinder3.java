//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.patch;

import java.util.ArrayList;
import java.util.Collections;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.block.BlockPistonMoving;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.BlockWall;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;

public class AStarCustomPathFinder3 {
   public static Vec3[] shared$ = new Vec3[]{new Vec3(1.0D, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L)), new Vec3(-1.0D, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L)), new Vec3(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 1.0D), new Vec3(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), -1.0D)};
   public Vec3 adult$;
   public Vec3 marathon$;
   public ArrayList jessica$ = new ArrayList();
   public ArrayList randy$ = new ArrayList();
   public double casinos$ = 9.0D;
   public boolean corps$ = true;
   public ArrayList francis$;

   public AStarCustomPathFinder3(Vec3 pecobize, Vec3 povupimu) {
      ubonomiv.casinos$ = 9.0D;
      ubonomiv.corps$ = true;
      ubonomiv.francis$ = new ArrayList();
      ubonomiv.adult$ = ((Vec3)pecobize)._shopper(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L))._salmon();
      ubonomiv.marathon$ = ((Vec3)povupimu)._shopper(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L))._salmon();
   }

   public ArrayList _stuffed() {
      return edited.francis$;
   }

   public void _barry() {
      usoriluz._auckland(1000, 4);
   }

   public void _auckland(int erayicay, int pipoyese) {
      ezadoveb.francis$.clear();
      ezadoveb.randy$.clear();
      Object oyireneb = new ArrayList();
      oyireneb.add(ezadoveb.adult$);
      ezadoveb.randy$.add(new AStarCustomPathFinder(ezadoveb, ezadoveb.adult$, (AStarCustomPathFinder)null, oyireneb, ezadoveb.adult$._hosted(ezadoveb.marathon$), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L)));

      label54:
      for(Object oyulagep = 0; oyulagep < erayicay; ++oyulagep) {
         Collections.sort(ezadoveb.randy$, new AStarCustomPathFinder2(ezadoveb));
         Object azotanic = 0;
         if (ezadoveb.randy$.size() == 0) {
            break;
         }

         for(Object acebubov : new ArrayList(ezadoveb.randy$)) {
            ++azotanic;
            if (azotanic > pipoyese) {
               break;
            }

            ezadoveb.randy$.remove(acebubov);
            ezadoveb.jessica$.add(acebubov);

            for(Object alibazim : shared$) {
               Object pomazida = acebubov._ireland()._aberdeen(alibazim)._salmon();
               if (_gordon(pomazida, false) && ezadoveb._atlas(acebubov, pomazida, Double.longBitsToDouble(0L))) {
                  break label54;
               }
            }

            Object var13 = acebubov._ireland()._shopper(Double.longBitsToDouble(0L), 1.0D, Double.longBitsToDouble(0L))._salmon();
            if (_gordon(var13, false) && ezadoveb._atlas(acebubov, var13, Double.longBitsToDouble(0L))) {
               break label54;
            }

            Object var14 = acebubov._ireland()._shopper(Double.longBitsToDouble(0L), -1.0D, Double.longBitsToDouble(0L))._salmon();
            if (_gordon(var14, false) && ezadoveb._atlas(acebubov, var14, Double.longBitsToDouble(0L))) {
               break label54;
            }
         }
      }

      Collections.sort(ezadoveb.jessica$, new AStarCustomPathFinder2(ezadoveb));
      ezadoveb.francis$ = ((AStarCustomPathFinder)ezadoveb.jessica$.get(0))._growth();
   }

   public static boolean _gordon(Vec3 repuleso, boolean fogufuro) {
      return _finest((int)((Vec3)repuleso)._largely(), (int)((Vec3)repuleso)._duties(), (int)((Vec3)repuleso)._textile(), (boolean)fogufuro);
   }

   public static boolean _finest(int releases, int eternal, int alaska, boolean enemies) {
      Object blair = new BlockPos((int)releases, (int)eternal, (int)alaska);
      Object coast = new BlockPos((int)releases, eternal + 1, (int)alaska);
      Object freebsd = new BlockPos((int)releases, eternal - 1, (int)alaska);
      return !_contrary(blair) && !_contrary(coast) && (_contrary(freebsd) || !enemies) && _persons(freebsd);
   }

   public static boolean _contrary(BlockPos already) {
      return Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)already).getBlock().isFullBlock() || Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)already).getBlock() instanceof BlockSlab || Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)already).getBlock() instanceof BlockStairs || Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)already).getBlock() instanceof BlockCactus || Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)already).getBlock() instanceof BlockChest || Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)already).getBlock() instanceof BlockEnderChest || Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)already).getBlock() instanceof BlockSkull || Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)already).getBlock() instanceof BlockPane || Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)already).getBlock() instanceof BlockFence || Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)already).getBlock() instanceof BlockWall || Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)already).getBlock() instanceof BlockGlass || Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)already).getBlock() instanceof BlockPistonBase || Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)already).getBlock() instanceof BlockPistonExtension || Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)already).getBlock() instanceof BlockPistonMoving || Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)already).getBlock() instanceof BlockStainedGlass || Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)already).getBlock() instanceof BlockTrapDoor;
   }

   public static boolean _persons(BlockPos meyezuyo) {
      return !(Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)meyezuyo).getBlock() instanceof BlockFence) && !(Minecraft.getMinecraft().theWorld.getBlockState((BlockPos)meyezuyo).getBlock() instanceof BlockWall);
   }

   public AStarCustomPathFinder _panels(Vec3 notice) {
      for(Object annie : sponsor.jessica$) {
         if (annie._ireland()._largely() == ((Vec3)notice)._largely() && annie._ireland()._duties() == ((Vec3)notice)._duties() && annie._ireland()._textile() == ((Vec3)notice)._textile()) {
            return annie;
         }
      }

      for(Object var5 : sponsor.randy$) {
         if (var5._ireland()._largely() == ((Vec3)notice)._largely() && var5._ireland()._duties() == ((Vec3)notice)._duties() && var5._ireland()._textile() == ((Vec3)notice)._textile()) {
            return var5;
         }
      }

      return null;
   }

   public boolean _atlas(AStarCustomPathFinder atlantic, Vec3 wishing, double clerk) {
      Object wrote = tanzania._panels((Vec3)wishing);
      Object equation = (double)clerk;
      if (atlantic != null) {
         equation = clerk + ((AStarCustomPathFinder)atlantic)._shall();
      }

      if (wrote == null) {
         if (((Vec3)wishing)._largely() == tanzania.marathon$._largely() && ((Vec3)wishing)._duties() == tanzania.marathon$._duties() && ((Vec3)wishing)._textile() == tanzania.marathon$._textile() || ((Vec3)wishing)._hosted(tanzania.marathon$) <= 9.0D) {
            tanzania.francis$.clear();
            tanzania.francis$ = ((AStarCustomPathFinder)atlantic)._growth();
            tanzania.francis$.add(wishing);
            return true;
         }

         ArrayList var8 = new ArrayList(((AStarCustomPathFinder)atlantic)._growth());
         var8.add(wishing);
         tanzania.randy$.add(new AStarCustomPathFinder(tanzania, (Vec3)wishing, (AStarCustomPathFinder)atlantic, var8, ((Vec3)wishing)._hosted(tanzania.marathon$), (double)clerk, equation));
      } else if (wrote._bernard() > clerk) {
         ArrayList var9 = new ArrayList(((AStarCustomPathFinder)atlantic)._growth());
         var9.add(wishing);
         wrote._searches((Vec3)wishing);
         wrote._brands((AStarCustomPathFinder)atlantic);
         wrote._genetic(var9);
         wrote._yield(((Vec3)wishing)._hosted(tanzania.marathon$));
         wrote._basics((double)clerk);
         wrote._newton(equation);
      }

      return false;
   }
}
