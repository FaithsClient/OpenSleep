package rip.sleep.injection.mixins;

import rip.sleep.event.EventBus;
import java.util.List;
import rip.sleep.injection.in.IBlock;
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
import rip.sleep.event.events.RenderBlockSideEvent;
import rip.sleep.module.modules.XRay;
import rip.sleep.event.events.EventCollideWithBlock;

@Mixin({Block.class})
public abstract class MixinBlock implements IBlock {
   @Shadow
   @Final
   protected BlockState field_176227_L;
   @Shadow
   protected double field_149759_B;
   @Shadow
   protected double field_149760_C;
   @Shadow
   protected double field_149754_D;
   @Shadow
   protected double field_149755_E;
   @Shadow
   protected double field_149756_F;
   @Shadow
   protected double field_149757_G;
   @Final
   @Shadow
   protected Material field_149764_J;
   Minecraft mc = Minecraft.getMinecraft();

   @Shadow
   public abstract AxisAlignedBB func_180640_a(World var1, BlockPos var2, IBlockState var3);

   @Shadow
   public abstract boolean func_176214_u();

   @Overwrite
   public void func_180638_a(World var1, BlockPos var2, IBlockState var3, AxisAlignedBB var4, List<AxisAlignedBB> var5, Entity var6) {
      AxisAlignedBB var7 = this.func_180640_a(var1, var2, var3);
      EventCollideWithBlock var8 = new EventCollideWithBlock(this.field_176227_L.getBlock(), var2, var7);
      EventBus.getInstance().call(var8);
      var7 = var8.c488();
      if (var4.intersectsWith(var7)) {
         var5.add(var7);
      }

   }

   @SideOnly(Side.CLIENT)
   @Overwrite
   public float func_149685_I() {
      return XRay.c33034 ? 1.0F : (this.func_176214_u() ? 0.2F : 1.0F);
   }

   @SideOnly(Side.CLIENT)
   @Overwrite
   public EnumWorldBlockLayer func_180664_k() {
      return XRay.c33034 ? (XRay.c77876.c1473().booleanValue() ? EnumWorldBlockLayer.TRANSLUCENT : (XRay.c44678.contains(Integer.valueOf(Block.getIdFromBlock((Block)this))) ? EnumWorldBlockLayer.SOLID : EnumWorldBlockLayer.TRANSLUCENT)) : EnumWorldBlockLayer.SOLID;
   }

   public boolean shouldSideBeRendered_(IBlockAccess var1, BlockPos var2, EnumFacing var3) {
      return var3 == EnumFacing.DOWN && this.field_149760_C > 0.0D || var3 == EnumFacing.UP && this.field_149756_F < 1.0D || var3 == EnumFacing.NORTH && this.field_149754_D > 0.0D || var3 == EnumFacing.SOUTH && this.field_149757_G < 1.0D || var3 == EnumFacing.WEST && this.field_149759_B > 0.0D || var3 == EnumFacing.EAST && this.field_149755_E < 1.0D || !var1.getBlockState(var2).getBlock().isOpaqueCube();
   }

   @Overwrite
   public boolean func_176225_a(IBlockAccess var1, BlockPos var2, EnumFacing var3) {
      if (XRay.c33034 && XRay.c44678.contains(Integer.valueOf(Block.getIdFromBlock((Block)this))) && XRay.c34820.c1473().booleanValue()) {
         EnumFacing[] var4 = EnumFacing.VALUES;
         int var5 = EnumFacing.VALUES.length;
         int var6 = 0;

         while(true) {
            EnumFacing var7 = var4[var6];
            if (this.shouldSideBeRendered_(var1, var2.offset(var7), var7)) {
               return true;
            }

            ++var6;
            if (var6 >= var5) {
               break;
            }
         }
      }

      RenderBlockSideEvent var8 = new RenderBlockSideEvent((Block)this, var1, var2, var3, this.field_149755_E, this.field_149756_F, this.field_149757_G, this.field_149759_B, this.field_149760_C, this.field_149754_D);
      EventBus.getInstance().call(var8);
      return var3 == EnumFacing.DOWN && this.field_149760_C > 0.0D || var3 == EnumFacing.UP && this.field_149756_F < 1.0D || var3 == EnumFacing.NORTH && this.field_149754_D > 0.0D || var3 == EnumFacing.SOUTH && this.field_149757_G < 1.0D || var3 == EnumFacing.WEST && this.field_149759_B > 0.0D || var3 == EnumFacing.EAST && this.field_149755_E < 1.0D || !var1.getBlockState(var2).getBlock().isOpaqueCube();
   }
}
