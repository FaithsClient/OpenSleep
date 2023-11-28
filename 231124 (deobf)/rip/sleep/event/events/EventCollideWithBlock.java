package rip.sleep.event.events;

import rip.sleep.event.Event;
import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;

public class EventCollideWithBlock extends Event {
   private Block c90102;
   private BlockPos c4631;
   public AxisAlignedBB c20743;

   public EventCollideWithBlock(Block var1, BlockPos var2, AxisAlignedBB var3) {
      this.c90102 = var1;
      this.c4631 = var2;
      this.c20743 = var3;
   }

   public Block c89619() {
      return this.c90102;
   }

   public BlockPos c58103() {
      return this.c4631;
   }

   public AxisAlignedBB c488() {
      return this.c20743;
   }

   public void c3995(Block var1) {
      this.c90102 = var1;
   }

   public void c30422(BlockPos var1) {
      this.c4631 = var1;
   }

   public void c8664(AxisAlignedBB var1) {
      this.c20743 = var1;
   }
}
