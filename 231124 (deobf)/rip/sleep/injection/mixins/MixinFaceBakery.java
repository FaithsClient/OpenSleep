package rip.sleep.injection.mixins;

import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import rip.sleep.module.modules.Camera;

@SideOnly(Side.CLIENT)
@Mixin({FaceBakery.class})
public class MixinFaceBakery {
   @Overwrite
   public static float func_178412_b(EnumFacing var0) {
      float var1 = Camera.c10369.c53968().floatValue();
      switch(null.$SwitchMap$net$minecraft$util$EnumFacing[var0.ordinal()]) {
      case 1:
         return Math.min(var1 * 0.5F, 1.0F);
      case 2:
         return Math.min(var1, 1.0F);
      case 3:
      case 4:
         return Math.min(var1 * 0.8F, 1.0F);
      case 5:
      case 6:
         return Math.min(var1 * 0.6F, 1.0F);
      default:
         return Math.min(var1, 1.0F);
      }
   }
}
