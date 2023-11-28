package rip.sleep.injection.mixins;

import net.minecraft.block.BlockGrass;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import rip.sleep.module.modules.XRay;

@SideOnly(Side.CLIENT)
@Mixin({BlockGrass.class})
public abstract class MixinBlockGrass {
   @Overwrite
   public EnumWorldBlockLayer func_180664_k() {
      return XRay.c33034 ? EnumWorldBlockLayer.TRANSLUCENT : EnumWorldBlockLayer.CUTOUT_MIPPED;
   }
}
