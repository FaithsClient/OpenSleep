//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import java.nio.ByteOrder;
import java.nio.IntBuffer;
import net.minecraft.client.renderer.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({WorldRenderer.class})
public abstract class MixinWorldRenderer {
   @Shadow
   private boolean noColor;
   @Shadow
   public IntBuffer rawIntBuffer;
   private int field_179007_h;

   @Shadow
   protected abstract int getColorIndex(int var1);

   @Overwrite
   public void putColorMultiplier(float red, float green, float blue, int p_178978_4_) {
      int i = this.getColorIndex(p_178978_4_);
      int j = -1;
      if (!this.noColor) {
         j = this.rawIntBuffer.get(i);
         if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            int k = (int)((float)(j & 255) * red);
            int l = (int)((float)(j >> 8 & 255) * green);
            int i1 = (int)((float)(j >> 16 & 255) * blue);
            j = j & -16777216;
            j = j | i1 << 16 | l << 8 | k;
            if (.) {
               j = �?.�?(k, l, i1, .);
            }
         } else {
            int j1 = (int)((float)(j >> 24 & 255) * red);
            int k1 = (int)((float)(j >> 16 & 255) * green);
            int l1 = (int)((float)(j >> 8 & 255) * blue);
            j = j & 255;
            j = j | j1 << 24 | k1 << 16 | l1 << 8;
            if (.) {
               j = �?.�?(j1, k1, l1, .);
            }
         }
      }

      this.rawIntBuffer.put(i, j);
   }
}
