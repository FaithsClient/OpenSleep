//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@SideOnly(Side.CLIENT)
@Mixin({FaceBakery.class})
public class MixinFaceBakery {
   @Overwrite
   public static float getFaceBrightness(EnumFacing facing) {
      float i = ..getValue().floatValue();
      switch(facing) {
      case DOWN:
         return Math.min(i * 0.5F, 1.0F);
      case UP:
         return Math.min(i, 1.0F);
      case NORTH:
      case SOUTH:
         return Math.min(i * 0.8F, 1.0F);
      case WEST:
      case EAST:
         return Math.min(i * 0.6F, 1.0F);
      default:
         return Math.min(i, 1.0F);
      }
   }
}
