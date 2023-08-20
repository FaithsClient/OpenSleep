//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.world.EventPreUpdate;
import ft.sleep.api.value.Numbers;
import java.util.ArrayList;
import java.util.List;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;

public class BedNuker extends Module {
   public static BlockPos virginia$;
   public List martin$ = new ArrayList();
   public Numbers wants$ = new Numbers("BedNukerRange", 3.0D, 1.0D, 8.0D, 1.0D);

   public BedNuker() {
      super("ft.sleep.module.modules.BedNuker", new String[]{"ft.sleep.module.modules.BedNuker"}, ModuleType.Player);
   }

   public boolean _clear(Block motaboyo) {
      return motaboyo == Blocks.bed;
   }

   public void _discs() {
      if (virginia$ != null) {
         virginia$ = null;
      }

      super._discs();
   }

   public void _regime() {
      super._regime();
   }

   @EventHandler
   public void _crazy(EventPreUpdate tepisafe) {
      Object anunolop = (int)ocucefub.wants$.getValue().floatValue();

      for(Object ivufegoz = anunolop; ivufegoz >= -anunolop; --ivufegoz) {
         for(Object doceropa = -anunolop; doceropa <= anunolop; ++doceropa) {
            for(Object meracepu = -anunolop; meracepu <= anunolop; ++meracepu) {
               if (ocucefub.mc.thePlayer.isSneaking()) {
                  return;
               }

               Object remudoca = new BlockPos(ocucefub.mc.thePlayer.posX + (double)doceropa, ocucefub.mc.thePlayer.posY + (double)ivufegoz, ocucefub.mc.thePlayer.posZ + (double)meracepu);
               if (ocucefub._fridge(remudoca) != null && ocucefub._clear(ocucefub.mc.theWorld.getBlockState(remudoca).getBlock()) && ocucefub.mc.thePlayer.getDistance(ocucefub.mc.thePlayer.posX + (double)doceropa, ocucefub.mc.thePlayer.posY + (double)ivufegoz, ocucefub.mc.thePlayer.posZ + (double)meracepu) < (double)ocucefub.mc.playerController.getBlockReachDistance() - 0.2D && !ocucefub.martin$.contains(remudoca)) {
                  ocucefub.martin$.add(remudoca);
               }
            }
         }
      }

      Object var7 = null;
      if (!ocucefub.martin$.isEmpty()) {
         for(Object var8 = 0; var8 < ocucefub.martin$.size(); ++var8) {
            Object var11 = (BlockPos)ocucefub.martin$.get(var8);
            if (ocucefub.mc.thePlayer.getDistance((double)var11.getX(), (double)var11.getY(), (double)var11.getZ()) > (double)ocucefub.mc.playerController.getBlockReachDistance() - 0.2D || ocucefub.mc.theWorld.getBlockState(var11).getBlock() != Blocks.bed) {
               ocucefub.martin$.remove(var8);
            }

            if (var7 == null || ocucefub.mc.thePlayer.getDistance((double)var11.getX(), (double)var11.getY(), (double)var11.getZ()) < ocucefub.mc.thePlayer.getDistance((double)var7.getX(), (double)var7.getY(), (double)var7.getZ())) {
               var7 = var11;
            }
         }
      }

      if (var7 != null) {
         Object var10 = ocucefub._tools(var7, ocucefub._tracks(var7));
         ((EventPreUpdate)tepisafe).setYaw(var10[0]);
         ((EventPreUpdate)tepisafe).setPitch(var10[1]);
         virginia$ = var7;
         Object var12 = ocucefub._tracks(virginia$);
         ocucefub.mc.playerController.onPlayerDamageBlock(virginia$, var12);
      } else {
         virginia$ = null;
         if (virginia$ != null) {
            if (ocucefub.mc.playerController.blockHitDelay > 1) {
               ocucefub.mc.playerController.blockHitDelay = 1;
            }

            ocucefub.mc.thePlayer.swingItem();
            Object var9 = ocucefub._tracks(virginia$);
            if (var9 != null) {
               ocucefub.mc.playerController.onPlayerDamageBlock(virginia$, var9);
            }
         }

      }
   }

   public float[] _tools(BlockPos fonts, EnumFacing victoria) {
      Object causes = (double)((BlockPos)fonts).getX() + 0.5D - prisoner.mc.thePlayer.posX + (double)((EnumFacing)victoria).getFrontOffsetX() / 2.0D;
      Object former = (double)((BlockPos)fonts).getZ() + 0.5D - prisoner.mc.thePlayer.posZ + (double)((EnumFacing)victoria).getFrontOffsetZ() / 2.0D;
      Object logging = prisoner.mc.thePlayer.posY + (double)prisoner.mc.thePlayer.getEyeHeight() - (double)((BlockPos)fonts).getY() + 0.5D;
      double var9 = (double)MathHelper.sqrt_double(causes * causes + former * former);
      float var11 = (float)(Math.atan2(former, causes) * 180.0D / 3.141592653589793D) - 90.0F;
      float var12 = (float)(Math.atan2(logging, var9) * 180.0D / 3.141592653589793D);
      if (var11 < Float.intBitsToFloat(0)) {
         var11 += 360.0F;
      }

      return new float[]{var11, var12};
   }

   public EnumFacing _tracks(BlockPos laptop) {
      Object emacs = EnumFacing.UP;
      Object cement = MathHelper.wrapAngleTo180_float(citizen._tools((BlockPos)laptop, EnumFacing.UP)[0]);
      if (cement >= 45.0F && cement <= 135.0F) {
         emacs = EnumFacing.EAST;
      } else if ((cement < 135.0F || cement > 180.0F) && (cement > -135.0F || cement < -180.0F)) {
         if (cement <= -45.0F && cement >= -135.0F) {
            emacs = EnumFacing.WEST;
         } else if (cement >= -45.0F && cement <= Float.intBitsToFloat(0) || cement <= 45.0F && cement >= Float.intBitsToFloat(0)) {
            emacs = EnumFacing.NORTH;
         }
      } else {
         emacs = EnumFacing.SOUTH;
      }

      if (MathHelper.wrapAngleTo180_float(citizen._tools((BlockPos)laptop, EnumFacing.UP)[1]) > 75.0F || MathHelper.wrapAngleTo180_float(citizen._tools((BlockPos)laptop, EnumFacing.UP)[1]) < -75.0F) {
         emacs = EnumFacing.UP;
      }

      return emacs;
   }

   public EnumFacing _fridge(BlockPos uzuvofat) {
      Object pigemonu = null;
      if (!efedogot.mc.theWorld.getBlockState(((BlockPos)uzuvofat).add(0, 1, 0)).getBlock().isBlockNormalCube() && !(efedogot.mc.theWorld.getBlockState(((BlockPos)uzuvofat).add(0, 1, 0)).getBlock() instanceof BlockBed)) {
         pigemonu = EnumFacing.UP;
      } else if (!efedogot.mc.theWorld.getBlockState(((BlockPos)uzuvofat).add(0, -1, 0)).getBlock().isBlockNormalCube() && !(efedogot.mc.theWorld.getBlockState(((BlockPos)uzuvofat).add(0, -1, 0)).getBlock() instanceof BlockBed)) {
         pigemonu = EnumFacing.DOWN;
      } else if (!efedogot.mc.theWorld.getBlockState(((BlockPos)uzuvofat).add(1, 0, 0)).getBlock().isBlockNormalCube() && !(efedogot.mc.theWorld.getBlockState(((BlockPos)uzuvofat).add(1, 0, 0)).getBlock() instanceof BlockBed)) {
         pigemonu = EnumFacing.EAST;
      } else if (!efedogot.mc.theWorld.getBlockState(((BlockPos)uzuvofat).add(-1, 0, 0)).getBlock().isBlockNormalCube() && !(efedogot.mc.theWorld.getBlockState(((BlockPos)uzuvofat).add(-1, 0, 0)).getBlock() instanceof BlockBed)) {
         pigemonu = EnumFacing.WEST;
      } else if (!efedogot.mc.theWorld.getBlockState(((BlockPos)uzuvofat).add(0, 0, 1)).getBlock().isBlockNormalCube() && !(efedogot.mc.theWorld.getBlockState(((BlockPos)uzuvofat).add(0, 0, 1)).getBlock() instanceof BlockBed)) {
         pigemonu = EnumFacing.SOUTH;
      } else if (!efedogot.mc.theWorld.getBlockState(((BlockPos)uzuvofat).add(0, 0, 1)).getBlock().isBlockNormalCube() && !(efedogot.mc.theWorld.getBlockState(((BlockPos)uzuvofat).add(0, 0, -1)).getBlock() instanceof BlockBed)) {
         pigemonu = EnumFacing.NORTH;
      }

      Object veseloyo = efedogot.mc.theWorld.rayTraceBlocks(new net.minecraft.util.Vec3(efedogot.mc.thePlayer.posX, efedogot.mc.thePlayer.posY + (double)efedogot.mc.thePlayer.getEyeHeight(), efedogot.mc.thePlayer.posZ), new net.minecraft.util.Vec3((double)((BlockPos)uzuvofat).getX() + 0.5D, (double)((BlockPos)uzuvofat).getY(), (double)((BlockPos)uzuvofat).getZ() + 0.5D));
      return veseloyo != null && veseloyo.getBlockPos() == uzuvofat ? veseloyo.sideHit : pigemonu;
   }
}
