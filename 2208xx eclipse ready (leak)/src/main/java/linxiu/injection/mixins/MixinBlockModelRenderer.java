package linxiu.injection.mixins;

import linxiu.module.modules.uhc.Xray;
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

import java.util.List;

@Mixin(BlockModelRenderer.class)
public abstract class MixinBlockModelRenderer {
	@Shadow
    public boolean renderModelAmbientOcclusion(IBlockAccess blockAccessIn, IBakedModel modelIn, Block blockIn, BlockPos blockPosIn, WorldRenderer worldRendererIn, boolean checkSides) {
        return false;
    }

    @Shadow
    public boolean renderModelStandard(IBlockAccess blockAccessIn, IBakedModel modelIn, Block blockIn, BlockPos blockPosIn, WorldRenderer worldRendererIn, boolean checkSides) {
        return checkSides;
    }
    /**
     * @author qingjiu
     * @reason can't inject
     */
    @Overwrite
    public boolean renderModel(IBlockAccess blockAccessIn, IBakedModel modelIn, IBlockState blockStateIn, BlockPos blockPosIn, WorldRenderer worldRendererIn, boolean checkSides) {
        boolean flag = Minecraft.isAmbientOcclusionEnabled() && blockStateIn.getBlock().getLightValue() == 0 && modelIn.isAmbientOcclusion();

        try {
            Block block = blockStateIn.getBlock();

            if (Xray.isEnabled) {
                for (EnumFacing enumfacing : EnumFacing.VALUES) {
                    List list = modelIn.getFaceQuads(enumfacing);
                    if (!list.isEmpty()) {
                        BlockPos blockpos = blockPosIn.offset(enumfacing);

                        if (!checkSides || block.shouldSideBeRendered(blockAccessIn, blockpos, enumfacing)) {

                            if (Xray.isEnabled && Xray.showESP()) {
                                Block blockk = Minecraft.getMinecraft().theWorld.getBlockState(blockPosIn).getBlock();

                                if (blockk instanceof BlockOre || blockk instanceof BlockRedstoneOre) {
                                    double x = blockPosIn.getX(), y = blockPosIn.getY(), z = blockPosIn.getZ();

                                    if (Minecraft.getMinecraft().thePlayer.getDistance(x, y, z) <= Xray.getDistance()) {
                                        BlockPos pos = new BlockPos(x, y, z);

                                        if (!Xray.blockPosList.contains(pos)) {
                                            Xray.blockPosList.add(pos);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            return flag ? this.renderModelAmbientOcclusion(blockAccessIn, modelIn, block, blockPosIn, worldRendererIn, checkSides) : this.renderModelStandard(blockAccessIn, modelIn, block, blockPosIn, worldRendererIn, checkSides);
        } catch (Throwable var11) {
            CrashReport crashreport = CrashReport.makeCrashReport(var11, "Tesselating block model");
            CrashReportCategory crashreportcategory = crashreport.makeCategory("Block model being tesselated");
            CrashReportCategory.addBlockInfo(crashreportcategory, blockPosIn, blockStateIn);
            crashreportcategory.addCrashSection("Using AO", flag);
            throw new ReportedException(crashreport);
        }
    }
}