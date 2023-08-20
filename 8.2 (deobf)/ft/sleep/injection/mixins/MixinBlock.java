//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

import ft.sleep.api.EventBus;
import ft.sleep.api.events.misc.EventBlockRenderSide;
import ft.sleep.api.events.misc.EventCollideWithBlock;
import ft.sleep.injection.interfaces.IBlock;
import java.util.List;
import net.minecraft.block.Block;
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

@Mixin({Block.class})
public abstract class MixinBlock implements IBlock {
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

   @Shadow
   public abstract AxisAlignedBB getCollisionBoundingBox(World var1, BlockPos var2, IBlockState var3);

   @Shadow
   public abstract boolean isVisuallyOpaque();

   @Overwrite
   public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List list, Entity collidingEntity) {
      AxisAlignedBB axisalignedbb = this.getCollisionBoundingBox(worldIn, pos, state);
      EventCollideWithBlock blockBBEvent = new EventCollideWithBlock(this.blockState.getBlock(), pos, axisalignedbb);
      EventBus.getInstance().call(blockBBEvent);
      axisalignedbb = blockBBEvent.getBoundingBox();
      if (axisalignedbb != null && mask.intersectsWith(axisalignedbb)) {
         list.add(axisalignedbb);
      }

   }

   @SideOnly(Side.CLIENT)
   @Overwrite
   public float getAmbientOcclusionLightValue() {
      return . ? 1.0F : (this.isVisuallyOpaque() ? 0.2F : 1.0F);
   }

   @SideOnly(Side.CLIENT)
   @Overwrite
   public EnumWorldBlockLayer getBlockLayer() {
      return . ? (.�?.getValue().booleanValue() ? EnumWorldBlockLayer.TRANSLUCENT : (.�?.contains(Integer.valueOf(Block.getIdFromBlock((Block)this))) ? EnumWorldBlockLayer.SOLID : EnumWorldBlockLayer.TRANSLUCENT)) : EnumWorldBlockLayer.SOLID;
   }

   public boolean shouldSideBeRendered_(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
      return side == EnumFacing.DOWN && this.minY > 0.0D || side == EnumFacing.UP && this.maxY < 1.0D || side == EnumFacing.NORTH && this.minZ > 0.0D || side == EnumFacing.SOUTH && this.maxZ < 1.0D || side == EnumFacing.WEST && this.minX > 0.0D || side == EnumFacing.EAST && this.maxX < 1.0D || !worldIn.getBlockState(pos).getBlock().isOpaqueCube();
   }

   @Overwrite
   public boolean shouldSideBeRendered(IBlockAccess world, BlockPos blockPos, EnumFacing facing) {
      if (. && .�?.contains(Integer.valueOf(Block.getIdFromBlock((Block)this)))) {
         EnumFacing[] values = EnumFacing.VALUES;
         int length = EnumFacing.VALUES.length;
         int n = 0;

         while(true) {
            EnumFacing u2 = values[n];
            if (this.shouldSideBeRendered_(world, blockPos.offset(u2), u2)) {
               return true;
            }

            ++n;
            if (n >= length) {
               break;
            }
         }
      }

      EventBlockRenderSide event = new EventBlockRenderSide((Block)this, world, blockPos, facing, this.maxX, this.maxY, this.maxZ, this.minX, this.minY, this.minZ);
      EventBus.getInstance().call(event);
      return facing == EnumFacing.DOWN && this.minY > 0.0D || facing == EnumFacing.UP && this.maxY < 1.0D || facing == EnumFacing.NORTH && this.minZ > 0.0D || facing == EnumFacing.SOUTH && this.maxZ < 1.0D || facing == EnumFacing.WEST && this.minX > 0.0D || facing == EnumFacing.EAST && this.maxX < 1.0D || !world.getBlockState(blockPos).getBlock().isOpaqueCube();
   }
}
