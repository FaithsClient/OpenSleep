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
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;

public class PathUtil {
   public static Minecraft concrete$ = Minecraft.getMinecraft();
   public PathUtil3 sierra$;
   public PathUtil3 reynolds$;
   public ArrayList strategy$ = new ArrayList();
   public ArrayList however$ = new ArrayList();
   public ArrayList compute$ = new ArrayList();
   public double ordered$ = 9.0D;
   public boolean freebsd$ = true;
   public static PathUtil3[] scored$ = new PathUtil3[]{new PathUtil3(1.0D, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L)), new PathUtil3(-1.0D, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L)), new PathUtil3(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 1.0D), new PathUtil3(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), -1.0D)};

   public PathUtil(PathUtil3 sleeping, PathUtil3 trading) {
      honor.ordered$ = 9.0D;
      honor.freebsd$ = true;
      honor.sierra$ = ((PathUtil3)sleeping)._jewel(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L))._exempt();
      honor.reynolds$ = ((PathUtil3)trading)._jewel(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L))._exempt();
   }

   public ArrayList _cooked() {
      return peaceful.strategy$;
   }

   public void _chick() {
      tried._morocco(1000, 4);
   }

   public void _morocco(int cucogada, int motazeso) {
      citiyoza.strategy$.clear();
      citiyoza.compute$.clear();
      Object apicibos = new ArrayList();
      apicibos.add(citiyoza.sierra$);
      citiyoza.compute$.add(new PathUtil2(citiyoza.sierra$, (PathUtil2)null, apicibos, citiyoza.sierra$._adipex(citiyoza.reynolds$), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L)));

      label54:
      for(Object cagusiye = 0; cagusiye < cucogada; ++cagusiye) {
         citiyoza.compute$.sort(new PathUtil4(citiyoza));
         Object cenilalu = 0;
         if (citiyoza.compute$.size() == 0) {
            break;
         }

         for(Object mepezami : new ArrayList(citiyoza.compute$)) {
            ++cenilalu;
            if (cenilalu > motazeso) {
               break;
            }

            citiyoza.compute$.remove(mepezami);
            citiyoza.however$.add(mepezami);

            for(Object idayudud : scored$) {
               Object ebotocov = mepezami._figures()._trace(idayudud)._exempt();
               if (_pleased(ebotocov, false) && citiyoza._betty(mepezami, ebotocov, Double.longBitsToDouble(0L))) {
                  break label54;
               }
            }

            Object var13 = mepezami._figures()._jewel(Double.longBitsToDouble(0L), 1.0D, Double.longBitsToDouble(0L))._exempt();
            if (_pleased(var13, false) && citiyoza._betty(mepezami, var13, Double.longBitsToDouble(0L))) {
               break label54;
            }

            Object var14 = mepezami._figures()._jewel(Double.longBitsToDouble(0L), -1.0D, Double.longBitsToDouble(0L))._exempt();
            if (_pleased(var14, false) && citiyoza._betty(mepezami, var14, Double.longBitsToDouble(0L))) {
               break label54;
            }
         }
      }

      Collections.sort(citiyoza.however$, new PathUtil4(citiyoza));
      citiyoza.strategy$ = ((PathUtil2)citiyoza.however$.get(0))._kills();
   }

   public static boolean _handling(net.minecraft.util.Vec3 imabitiv) {
      Object uravizuf = new BlockPos((net.minecraft.util.Vec3)imabitiv);
      return !_epson(uravizuf) && !_epson(uravizuf.add(0, 1, 0)) ? _samples(uravizuf.add(0, -1, 0)) : false;
   }

   public static boolean _pleased(PathUtil3 avoyucom, boolean ufenafun) {
      return _consult((int)((PathUtil3)avoyucom)._infant(), (int)((PathUtil3)avoyucom)._regard(), (int)((PathUtil3)avoyucom)._journal(), (boolean)ufenafun);
   }

   public static boolean _consult(int motion, int drinking, int greatly, boolean sarah) {
      Object revision = new BlockPos((int)motion, (int)drinking, (int)greatly);
      Object lesbians = new BlockPos((int)motion, drinking + 1, (int)greatly);
      Object query = new BlockPos((int)motion, drinking - 1, (int)greatly);
      return !_epson(revision) && !_epson(lesbians) && (_epson(query) || !sarah) && _samples(query);
   }

   public static boolean _epson(BlockPos forestry) {
      return concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)forestry).getX(), ((BlockPos)forestry).getY(), ((BlockPos)forestry).getZ())).getBlock().isBlockNormalCube() || concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)forestry).getX(), ((BlockPos)forestry).getY(), ((BlockPos)forestry).getZ())).getBlock() instanceof BlockSlab || concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)forestry).getX(), ((BlockPos)forestry).getY(), ((BlockPos)forestry).getZ())).getBlock() instanceof BlockStairs || concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)forestry).getX(), ((BlockPos)forestry).getY(), ((BlockPos)forestry).getZ())).getBlock() instanceof BlockCactus || concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)forestry).getX(), ((BlockPos)forestry).getY(), ((BlockPos)forestry).getZ())).getBlock() instanceof BlockChest || concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)forestry).getX(), ((BlockPos)forestry).getY(), ((BlockPos)forestry).getZ())).getBlock() instanceof BlockEnderChest || concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)forestry).getX(), ((BlockPos)forestry).getY(), ((BlockPos)forestry).getZ())).getBlock() instanceof BlockSkull || concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)forestry).getX(), ((BlockPos)forestry).getY(), ((BlockPos)forestry).getZ())).getBlock() instanceof BlockPane || concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)forestry).getX(), ((BlockPos)forestry).getY(), ((BlockPos)forestry).getZ())).getBlock() instanceof BlockFence || concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)forestry).getX(), ((BlockPos)forestry).getY(), ((BlockPos)forestry).getZ())).getBlock() instanceof BlockWall || concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)forestry).getX(), ((BlockPos)forestry).getY(), ((BlockPos)forestry).getZ())).getBlock() instanceof BlockGlass || concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)forestry).getX(), ((BlockPos)forestry).getY(), ((BlockPos)forestry).getZ())).getBlock() instanceof BlockPistonBase || concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)forestry).getX(), ((BlockPos)forestry).getY(), ((BlockPos)forestry).getZ())).getBlock() instanceof BlockPistonExtension || concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)forestry).getX(), ((BlockPos)forestry).getY(), ((BlockPos)forestry).getZ())).getBlock() instanceof BlockPistonMoving || concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)forestry).getX(), ((BlockPos)forestry).getY(), ((BlockPos)forestry).getZ())).getBlock() instanceof BlockStainedGlass || concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)forestry).getX(), ((BlockPos)forestry).getY(), ((BlockPos)forestry).getZ())).getBlock() instanceof BlockTrapDoor;
   }

   public static boolean _samples(BlockPos nathan) {
      return !(concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)nathan).getX(), ((BlockPos)nathan).getY(), ((BlockPos)nathan).getZ())).getBlock() instanceof BlockFence) && !(concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)nathan).getX(), ((BlockPos)nathan).getY(), ((BlockPos)nathan).getZ())).getBlock() instanceof BlockWall);
   }

   public PathUtil2 _emotions(PathUtil3 leads) {
      for(Object yukon : blogging.however$) {
         if (yukon._figures()._infant() == ((PathUtil3)leads)._infant() && yukon._figures()._regard() == ((PathUtil3)leads)._regard() && yukon._figures()._journal() == ((PathUtil3)leads)._journal()) {
            return yukon;
         }
      }

      for(Object var5 : blogging.compute$) {
         if (var5._figures()._infant() == ((PathUtil3)leads)._infant() && var5._figures()._regard() == ((PathUtil3)leads)._regard() && var5._figures()._journal() == ((PathUtil3)leads)._journal()) {
            return var5;
         }
      }

      return null;
   }

   public boolean _betty(PathUtil2 prostate, PathUtil3 parent, double included) {
      Object thumb = state._emotions((PathUtil3)parent);
      Object israel = (double)included;
      if (prostate != null) {
         israel = included + ((PathUtil2)prostate)._hills();
      }

      if (thumb == null) {
         if (((PathUtil3)parent)._infant() == state.reynolds$._infant() && ((PathUtil3)parent)._regard() == state.reynolds$._regard() && ((PathUtil3)parent)._journal() == state.reynolds$._journal() || ((PathUtil3)parent)._adipex(state.reynolds$) <= 9.0D) {
            state.strategy$.clear();
            state.strategy$ = ((PathUtil2)prostate)._kills();
            state.strategy$.add(parent);
            return true;
         }

         ArrayList var8 = new ArrayList(((PathUtil2)prostate)._kills());
         var8.add(parent);
         state.compute$.add(new PathUtil2((PathUtil3)parent, (PathUtil2)prostate, var8, ((PathUtil3)parent)._adipex(state.reynolds$), (double)included, israel));
      } else if (thumb._baths() > included) {
         ArrayList var9 = new ArrayList(((PathUtil2)prostate)._kills());
         var9.add(parent);
         thumb._laser((PathUtil3)parent);
         thumb._titled((PathUtil2)prostate);
         thumb._marking(var9);
         thumb._thesis(((PathUtil3)parent)._adipex(state.reynolds$));
         thumb._cloud((double)included);
         thumb._accept(israel);
      }

      return false;
   }

   public static ArrayList _blowing(PathUtil3 showing, PathUtil3 proof) {
      if (!_posters(new BlockPos(((PathUtil3)showing)._factors()))) {
         showing = ((PathUtil3)showing)._jewel(Double.longBitsToDouble(0L), 1.0D, Double.longBitsToDouble(0L));
      }

      Object marking = new PathUtil((PathUtil3)showing, (PathUtil3)proof);
      marking._chick();
      Object decade = 0;
      Object medline = null;
      Object fitted = null;
      Object matrix = new ArrayList();
      Object agreed = marking._cooked();

      for(Object sports : agreed) {
         if (decade != 0 && decade != agreed.size() - 1) {
            Object coaches = true;
            if (sports._adipex(fitted) > 25.0D) {
               coaches = false;
            } else {
               Object lindsay = Math.min(fitted._infant(), sports._infant());
               Object noise = Math.min(fitted._regard(), sports._regard());
               Object latinas = Math.min(fitted._journal(), sports._journal());
               Object edition = Math.max(fitted._infant(), sports._infant());
               Object empire = Math.max(fitted._regard(), sports._regard());
               double var21 = Math.max(fitted._journal(), sports._journal());

               label54:
               for(int var23 = (int)lindsay; (double)var23 <= edition; ++var23) {
                  for(int var24 = (int)noise; (double)var24 <= empire; ++var24) {
                     for(int var25 = (int)latinas; (double)var25 <= var21; ++var25) {
                        if (!_consult(var23, var24, var25, false)) {
                           coaches = false;
                           break label54;
                        }
                     }
                  }
               }
            }

            if (!coaches) {
               matrix.add(medline._jewel(0.5D, Double.longBitsToDouble(0L), 0.5D));
               fitted = medline;
            }
         } else {
            if (medline != null) {
               matrix.add(medline._jewel(0.5D, Double.longBitsToDouble(0L), 0.5D));
            }

            matrix.add(sports._jewel(0.5D, Double.longBitsToDouble(0L), 0.5D));
            fitted = sports;
         }

         medline = sports;
         ++decade;
      }

      return matrix;
   }

   public static boolean _posters(BlockPos nevogedi) {
      Object omatutop = concrete$.theWorld.getBlockState(new BlockPos(((BlockPos)nevogedi).getX(), ((BlockPos)nevogedi).getY(), ((BlockPos)nevogedi).getZ())).getBlock();
      return omatutop.getMaterial() == Material.air || omatutop.getMaterial() == Material.plants || omatutop.getMaterial() == Material.vine || omatutop == Blocks.ladder || omatutop == Blocks.water || omatutop == Blocks.flowing_water || omatutop == Blocks.wall_sign || omatutop == Blocks.standing_sign;
   }
}
