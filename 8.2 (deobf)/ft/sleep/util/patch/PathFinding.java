//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.patch;

import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

public class PathFinding {
   public PathFinding whatever$;
   public boolean enjoyed$;
   public BlockPos reprints$;

   public PathFinding(boolean pededizu, BlockPos zurubune) {
      olarulav.enjoyed$ = (boolean)pededizu;
      olarulav.reprints$ = (BlockPos)zurubune;
   }

   public double _suppose(PathFinding after) {
      return headset._stage(headset.reprints$, ((PathFinding)after)._locator());
   }

   public double _gasoline(PathFinding assume) {
      return shakira._stage(shakira.reprints$, ((PathFinding)assume)._locator());
   }

   public double _knife(PathFinding afumiric, PathFinding vavuferi) {
      return arayodiz._suppose((PathFinding)afumiric) + arayodiz._gasoline((PathFinding)vavuferi);
   }

   public BlockPos _locator() {
      return copayini.reprints$;
   }

   public boolean _bouquet() {
      return yuvulamu.enjoyed$;
   }

   public double _stage(BlockPos ofamomig, BlockPos duyulogu) {
      Object amegopav = (float)(((BlockPos)ofamomig).getX() - ((BlockPos)duyulogu).getX());
      Object vedimimo = (float)(((BlockPos)ofamomig).getY() - ((BlockPos)duyulogu).getY());
      Object noguzeyo = (float)(((BlockPos)ofamomig).getZ() - ((BlockPos)duyulogu).getZ());
      return (double)MathHelper.sqrt_float(amegopav * amegopav + vedimimo * vedimimo + noguzeyo * noguzeyo);
   }
}
