package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class DamageBlockEvent extends Event {
   public BlockPos c542;
   public EnumFacing c28703;
   public boolean c94814;

   public DamageBlockEvent(BlockPos var1, EnumFacing var2) {
      this.c542 = var1;
      this.c28703 = var2;
      this.c94814 = false;
   }

   public BlockPos c58103() {
      return this.c542;
   }

   public EnumFacing c3269() {
      return this.c28703;
   }

   public boolean c58917() {
      return this.c94814;
   }

   public void c8253(boolean var1) {
      this.c94814 = var1;
   }
}
