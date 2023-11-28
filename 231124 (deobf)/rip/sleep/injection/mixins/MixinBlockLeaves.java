package rip.sleep.injection.mixins;

import net.minecraft.block.BlockLeaves;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import rip.sleep.module.modules.XRay;

@SideOnly(Side.CLIENT)
@Mixin({BlockLeaves.class})
public abstract class MixinBlockLeaves {
   @Shadow
   protected boolean field_176238_O;

   @Overwrite
   public EnumWorldBlockLayer func_180664_k() {
      return XRay.c33034 ? EnumWorldBlockLayer.TRANSLUCENT : (this.field_176238_O ? EnumWorldBlockLayer.CUTOUT_MIPPED : EnumWorldBlockLayer.SOLID);
   }
}
