//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.injection.mixins;

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

@Mixin({BlockModelRenderer.class})
public abstract class MixinBlockModelRenderer {
   @Shadow
   public boolean renderModelAmbientOcclusion(IBlockAccess blockAccessIn, IBakedModel modelIn, Block blockIn, BlockPos blockPosIn, WorldRenderer worldRendererIn, boolean checkSides) {
      return false;
   }

   @Shadow
   public boolean renderModelStandard(IBlockAccess blockAccessIn, IBakedModel modelIn, Block blockIn, BlockPos blockPosIn, WorldRenderer worldRendererIn, boolean checkSides) {
      return checkSides;
   }

   @Overwrite
   public boolean renderModel(IBlockAccess blockAccessIn, IBakedModel modelIn, IBlockState blockStateIn, BlockPos blockPosIn, WorldRenderer worldRendererIn, boolean checkSides) {
      boolean flag = Minecraft.isAmbientOcclusionEnabled() && blockStateIn.getBlock().getLightValue() == 0 && modelIn.isAmbientOcclusion();

      try {
         Block block = blockStateIn.getBlock();
         if (.) {
            for(EnumFacing enumfacing : EnumFacing.VALUES) {
               List list = modelIn.getFaceQuads(enumfacing);
               if (!list.isEmpty()) {
                  BlockPos blockpos = blockPosIn.offset(enumfacing);
                  if ((!checkSides || block.shouldSideBeRendered(blockAccessIn, blockpos, enumfacing)) && . && .()) {
                     Block blockk = Minecraft.getMinecraft().theWorld.getBlockState(blockPosIn).getBlock();
                     if (blockk instanceof BlockOre || blockk instanceof BlockRedstoneOre) {
                        double x = (double)blockPosIn.getX();
                        double y = (double)blockPosIn.getY();
                        double z = (double)blockPosIn.getZ();
                        if (Minecraft.getMinecraft().thePlayer.getDistance(x, y, z) <= (double).�?()) {
                           BlockPos pos = new BlockPos(x, y, z);
                           if (!.�?.contains(pos)) {
                              .�?.add(pos);
                           }
                        }
                     }
                  }
               }
            }
         }

         boolean flag1;
         if (.) {
            if (.�?.contains(blockStateIn.getBlock()) && (!.�?.getValue().booleanValue() || .�?.contains(blockPosIn))) {
               checkSides = false;
            }

            flag1 = this.renderModelAmbientOcclusion(blockAccessIn, modelIn, block, blockPosIn, worldRendererIn, checkSides);
         } else {
            flag1 = flag ? this.renderModelAmbientOcclusion(blockAccessIn, modelIn, block, blockPosIn, worldRendererIn, checkSides) : this.renderModelStandard(blockAccessIn, modelIn, block, blockPosIn, worldRendererIn, checkSides);
         }

         return flag1;
      } catch (Throwable var23) {
         CrashReport crashreport = CrashReport.makeCrashReport(var23, "Tesselating block model");
         CrashReportCategory crashreportcategory = crashreport.makeCategory("Block model being tesselated");
         CrashReportCategory.addBlockInfo(crashreportcategory, blockPosIn, blockStateIn);
         crashreportcategory.addCrashSection("Using AO", Boolean.valueOf(flag));
         throw new ReportedException(crashreport);
      }
   }
}
