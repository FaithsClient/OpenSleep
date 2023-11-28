package rip.sleep.injection.mixins;

import net.minecraft.block.BlockBush;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import rip.sleep.module.modules.XRay;

@SideOnly(Side.CLIENT)
@Mixin({BlockBush.class})
public abstract class MixinBlockBush {
   @Overwrite
   public EnumWorldBlockLayer func_180664_k() {
      return XRay.c33034 ? EnumWorldBlockLayer.TRANSLUCENT : EnumWorldBlockLayer.CUTOUT;
   }
}
