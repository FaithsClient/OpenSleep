package rip.sleep.injection.mixins;

import java.nio.ByteOrder;
import java.nio.IntBuffer;
import net.minecraft.client.renderer.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import rip.sleep.module.modules.XRay;
import rip.sleep.util.ColorUtil;

@Mixin({WorldRenderer.class})
public abstract class MixinWorldRenderer {
   @Shadow
   private boolean field_78939_q;
   @Shadow
   public IntBuffer field_178999_b;
   private int field_179007_h;

   @Shadow
   protected abstract int func_78909_a(int var1);

   @Overwrite
   public void func_178978_a(float var1, float var2, float var3, int var4) {
      int var5 = this.func_78909_a(var4);
      int var6 = -1;
      if (!this.field_78939_q) {
         var6 = this.field_178999_b.get(var5);
         if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            int var7 = (int)((float)(var6 & 255) * var1);
            int var8 = (int)((float)(var6 >> 8 & 255) * var2);
            int var9 = (int)((float)(var6 >> 16 & 255) * var3);
            var6 = var6 & -16777216;
            var6 = var6 | var9 << 16 | var8 << 8 | var7;
            if (XRay.c33034) {
               var6 = ColorUtil.c64483(var7, var8, var9, XRay.c40423);
            }
         } else {
            int var13 = (int)((float)(var6 >> 24 & 255) * var1);
            int var14 = (int)((float)(var6 >> 16 & 255) * var2);
            int var15 = (int)((float)(var6 >> 8 & 255) * var3);
            var6 = var6 & 255;
            var6 = var6 | var13 << 24 | var14 << 16 | var15 << 8;
            if (XRay.c33034) {
               var6 = ColorUtil.c64483(var13, var14, var15, XRay.c40423);
            }
         }
      }

      this.field_178999_b.put(var5, var6);
   }
}
