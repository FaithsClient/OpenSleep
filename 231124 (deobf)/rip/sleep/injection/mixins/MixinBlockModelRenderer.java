package rip.sleep.injection.mixins;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ReportedException;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import rip.sleep.module.modules.XRay;

@Mixin({BlockModelRenderer.class})
public abstract class MixinBlockModelRenderer {
   @Shadow
   public boolean func_178265_a(IBlockAccess var1, IBakedModel var2, Block var3, BlockPos var4, WorldRenderer var5, boolean var6) {
      return false;
   }

   @Shadow
   public boolean func_178258_b(IBlockAccess var1, IBakedModel var2, Block var3, BlockPos var4, WorldRenderer var5, boolean var6) {
      return var6;
   }

   @Overwrite
   public boolean func_178267_a(IBlockAccess var1, IBakedModel var2, IBlockState var3, BlockPos var4, WorldRenderer var5, boolean var6) {
      boolean var7 = Minecraft.isAmbientOcclusionEnabled() && var3.getBlock().getLightValue() == 0 && var2.isAmbientOcclusion();
      IBlockState var10000 = var3;

      boolean var25;
      try {
         Block var8 = var10000.getBlock();
         if (XRay.c33034) {
            for(EnumFacing var12 : EnumFacing.VALUES) {
               List var13 = var2.getFaceQuads(var12);
               if (!var13.isEmpty()) {
                  BlockPos var14 = var4.offset(var12);
                  if (var8.shouldSideBeRendered(var1, var14, var12) && XRay.c33034 && XRay.c98888()) {
                     Block var15 = Minecraft.getMinecraft().theWorld.getBlockState(var4).getBlock();
                     if (var15 instanceof BlockOre || var15 instanceof BlockRedstoneOre) {
                        double var16 = (double)var4.getX();
                        double var18 = (double)var4.getY();
                        double var20 = (double)var4.getZ();
                        if (Minecraft.getMinecraft().thePlayer.getDistance(var16, var18, var20) <= (double) XRay.c92387()) {
                           BlockPos var22 = new BlockPos(var16, var18, var20);
                           if (!XRay.c79746.contains(var22)) {
                              XRay.c79746.add(var22);
                           }
                        }
                     }
                  }
               }
            }
         }

         if (XRay.c33034) {
            if (XRay.c44678.contains(var3.getBlock()) && (!XRay.c34820.c1473().booleanValue() || XRay.c79746.contains(var4))) {
               var6 = false;
            }

            var25 = this.func_178265_a(var1, var2, var8, var4, var5, var6);
            return var25;
         }

         var27 = this.func_178265_a(var1, var2, var8, var4, var5, var6);
      } catch (Throwable var23) {
         CrashReport var9 = CrashReport.makeCrashReport(var23, "Tesselating block model");
         CrashReportCategory var10 = var9.makeCategory("Block model being tesselated");
         CrashReportCategory.addBlockInfo(var10, var4, var3);
         var10.addCrashSection("Using AO", Boolean.valueOf(var7));
         throw new ReportedException(var9);
      }

      var25 = var27;
      return var25;
   }
}
