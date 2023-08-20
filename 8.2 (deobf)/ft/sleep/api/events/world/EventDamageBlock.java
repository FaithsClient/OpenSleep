package ft.sleep.api.events.world;

import ft.sleep.api.Event;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class EventDamageBlock extends Event {
   public BlockPos pos;
   public EnumFacing fac;
   public boolean cal;

   public EventDamageBlock(BlockPos p_180512_1_, EnumFacing p_180512_2_) {
      this.pos = p_180512_1_;
      this.fac = p_180512_2_;
      this.cal = false;
   }

   public BlockPos getPos() {
      return this.pos;
   }

   public EnumFacing getFac() {
      return this.fac;
   }

   public boolean isCancelled() {
      return this.cal;
   }

   public void setCancelled(boolean s) {
      this.cal = s;
   }
}
