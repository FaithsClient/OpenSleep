//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import java.util.BitSet;
import net.minecraft.client.renderer.chunk.VisGraph;
import net.minecraft.util.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({VisGraph.class})
public abstract class MixinVisGraph {
   @Shadow
   private final BitSet field_178612_d = new BitSet(4096);
   @Shadow
   private int field_178611_f = 4096;

   @Shadow
   public static int getIndex(BlockPos pos) {
      return getIndex(pos.getX() & 15, pos.getY() & 15, pos.getZ() & 15);
   }

   @Shadow
   private static int getIndex(int x, int y, int z) {
      return x << 0 | y << 8 | z << 4;
   }

   @Overwrite
   public void func_178606_a(BlockPos pos) {
      if (!. && !.�?.getValue().booleanValue()) {
         this.field_178612_d.set(getIndex(pos), true);
         --this.field_178611_f;
      }
   }
}
