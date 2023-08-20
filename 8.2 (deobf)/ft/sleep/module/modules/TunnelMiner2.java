package ft.sleep.module.modules;

import net.minecraft.util.EnumFacing;

public class TunnelMiner2 {
   public static int[] direct$ = new int[EnumFacing.values().length];

   static {
      direct$[EnumFacing.NORTH.ordinal()] = 1;
      direct$[EnumFacing.EAST.ordinal()] = 2;
      direct$[EnumFacing.SOUTH.ordinal()] = 3;
      direct$[EnumFacing.WEST.ordinal()] = 4;
   }
}
