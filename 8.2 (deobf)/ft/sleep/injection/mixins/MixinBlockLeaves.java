//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import net.minecraft.block.BlockLeaves;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@SideOnly(Side.CLIENT)
@Mixin({BlockLeaves.class})
public abstract class MixinBlockLeaves {
   @Shadow
   protected boolean isTransparent;

   @Overwrite
   public EnumWorldBlockLayer getBlockLayer() {
      return . ? EnumWorldBlockLayer.TRANSLUCENT : (this.isTransparent ? EnumWorldBlockLayer.CUTOUT_MIPPED : EnumWorldBlockLayer.SOLID);
   }
}
