package linxiu.injection.mixins;

import linxiu.api.EventBus;
import linxiu.api.events.misc.EventBlockRenderSide;
import linxiu.api.events.misc.EventCollideWithBlock;
import linxiu.module.modules.uhc.Xray;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

import static net.minecraft.block.Block.getIdFromBlock;

@Mixin(Block.class)
public abstract class MixinBlock {

	@Shadow
	public abstract AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state);

	@Shadow
	@Final
	protected BlockState blockState;
	@Shadow
	protected double minX;
	@Shadow
	protected double minY;
	@Shadow
	protected double minZ;
	@Shadow
	protected double maxX;
	@Shadow
	protected double maxY;
	@Shadow
	protected double maxZ;

	@Final
	@Shadow
	protected Material blockMaterial;
	Minecraft mc = Minecraft.getMinecraft();

	/**
	 * @author idk
	 * @reason can't inject
	 */
	@Overwrite
	public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask,
			List<AxisAlignedBB> list, Entity collidingEntity) {
		AxisAlignedBB axisalignedbb = this.getCollisionBoundingBox(worldIn, pos, state);
		EventCollideWithBlock blockBBEvent = new EventCollideWithBlock(blockState.getBlock(), pos, axisalignedbb);
		EventBus.getInstance().call(blockBBEvent);
		axisalignedbb = blockBBEvent.getBoundingBox();
		if (axisalignedbb != null && mask.intersectsWith(axisalignedbb))
			list.add(axisalignedbb);
	}

	public boolean shouldSideBeRendered_(final IBlockAccess worldIn, final BlockPos pos, final EnumFacing side) {
		return (side == EnumFacing.DOWN && this.minY > 0.0) || (side == EnumFacing.UP && this.maxY < 1.0)
				|| (side == EnumFacing.NORTH && this.minZ > 0.0) || (side == EnumFacing.SOUTH && this.maxZ < 1.0)
				|| (side == EnumFacing.WEST && this.minX > 0.0) || (side == EnumFacing.EAST && this.maxX < 1.0)
				|| !worldIn.getBlockState(pos).getBlock().isOpaqueCube();
	}

	@Shadow
	public final IBlockState getDefaultState() {
		return null;
	}

	/**
	 * @author idk
	 * @reason can't inject
	 */
	@SideOnly(Side.CLIENT)
	@Overwrite
	public EnumWorldBlockLayer getBlockLayer() {
		return Xray.isEnabled
				? Xray.blockIdList.contains(getIdFromBlock(getDefaultState().getBlock())) ? EnumWorldBlockLayer.SOLID
						: EnumWorldBlockLayer.TRANSLUCENT
				: EnumWorldBlockLayer.SOLID;
	}

	/**
	 * @author idk
	 * @reason can't inject
	 */
	@SideOnly(Side.CLIENT)
	@Overwrite
	public int getMixedBrightnessForBlock(IBlockAccess worldIn, BlockPos pos) {
		if (Xray.isEnabled) {
			return 200;
		} else {
			Block block = worldIn.getBlockState(pos).getBlock();
			int i = worldIn.getCombinedLight(pos, block.getLightValue());
			if (i == 0 && block instanceof BlockSlab) {
				pos = pos.down();
				block = worldIn.getBlockState(pos).getBlock();
				return worldIn.getCombinedLight(pos, block.getLightValue());
			} else {
				return i;
			}
		}
	}

	/**
	 * @author idk
	 * @reason can't inject
	 */
	@Overwrite
	public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {

		if (Xray.isEnabled && Xray.uhc.getValue()
				&& Xray.blockIdList.contains(getIdFromBlock(getDefaultState().getBlock()))) {

			final EnumFacing[] values;
			final int length = (values = EnumFacing.VALUES).length;
			int n = 0;
			while (true) {
				final EnumFacing u2 = values[n];
				if (this.shouldSideBeRendered_(worldIn, pos.offset(u2), u2)) {
					return true;
				}
				++n;
				if (n < length) {
					continue;
				}
				break;
			}
		}
		EventBlockRenderSide event = new EventBlockRenderSide((Block) (Object) this, worldIn, pos, side, this.maxX,
				this.maxY, this.maxZ, this.minX, this.minY, this.minZ);
		EventBus.getInstance().call(event);

		return this.shouldSideBeRendered_(worldIn, pos, side);
	}

	@Shadow
	public boolean isFullCube() {
		return true;
	}

	/**
	 * @author idk
	 * @reason can't inject
	 */
	public boolean isVisuallyOpaque() {
		return this.blockMaterial.blocksMovement() && isFullCube();
	}
}
