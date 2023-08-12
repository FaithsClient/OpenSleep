package linxiu.injection.mixins;

import linxiu.module.modules.uhc.TimeChanger;
import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(FaceBakery.class)
public class MixinFaceBakery {

    /**
     * @author LinXiu
     * @reason Zenith
     */
    @SideOnly(Side.CLIENT)
    @Overwrite
    public static float getFaceBrightness(final EnumFacing p_178412_0_) {
        switch (p_178412_0_) {
            case DOWN:
                return TimeChanger.gaoliang.getValue().floatValue();

            case UP:
                return 1.0F;

            case NORTH:
            case SOUTH:
                return TimeChanger.gaoliang.getValue().floatValue();

            case WEST:
            case EAST:
                return TimeChanger.gaoliang.getValue().floatValue();

            default:
                return 1.0F;
        }
    }
}
