package linxiu.injection.interfaces;

import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

public interface IBlock {

    boolean shouldSideBeRendered_(IBlockAccess var1, BlockPos var2, EnumFacing var3);
}
