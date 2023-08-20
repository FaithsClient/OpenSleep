package linxiu.injection.mixins;

import linxiu.module.modules.uhc.Xray;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;

@SideOnly(Side.CLIENT)
@Mixin(BlockGrass.class)
public abstract class MixinBlockGrass extends Block {

	public MixinBlockGrass(Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public EnumWorldBlockLayer getBlockLayer() {
        if (Xray.isEnabled) {
            return EnumWorldBlockLayer.TRANSLUCENT;
        }
        return EnumWorldBlockLayer.CUTOUT_MIPPED;
	}
}
