//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import net.minecraft.block.BlockGlass;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@SideOnly(Side.CLIENT)
@Mixin({BlockGlass.class})
public abstract class MixinBlockGlass {
   @Overwrite
   public EnumWorldBlockLayer getBlockLayer() {
      return . ? EnumWorldBlockLayer.TRANSLUCENT : EnumWorldBlockLayer.CUTOUT;
   }
}
