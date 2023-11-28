package rip.sleep.injection.mixins;

import java.util.BitSet;
import net.minecraft.client.renderer.chunk.VisGraph;
import net.minecraft.util.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import rip.sleep.module.modules.XRay;

@Mixin({VisGraph.class})
public abstract class MixinVisGraph {
   @Shadow
   private final BitSet field_178612_d = new BitSet(4096);
   @Shadow
   private int field_178611_f = 4096;

   @Shadow
   public static int func_178608_c(BlockPos var0) {
      return func_178605_a(var0.getX() & 15, var0.getY() & 15, var0.getZ() & 15);
   }

   @Shadow
   private static int func_178605_a(int var0, int var1, int var2) {
      return var0 << 0 | var1 << 8 | var2 << 4;
   }

   @Overwrite
   public void func_178606_a(BlockPos var1) {
      if (!XRay.c33034) {
         this.field_178612_d.set(func_178608_c(var1), true);
         --this.field_178611_f;
      }
   }
}
