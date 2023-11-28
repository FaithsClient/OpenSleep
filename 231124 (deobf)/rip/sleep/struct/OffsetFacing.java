package rip.sleep.struct;

import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class OffsetFacing {
   private BlockPos c91379;
   private EnumFacing c63942;

   public OffsetFacing(BlockPos var1, EnumFacing var2) {
      this.c91379 = var1;
      this.c63942 = var2;
   }

   public BlockPos c99329() {
      return this.c91379;
   }

   public EnumFacing c42433() {
      return this.c63942;
   }
}
