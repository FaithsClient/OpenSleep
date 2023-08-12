/*
 * Decompiled with CFR 0_132.
 */
package linxiu.utils;

import java.util.concurrent.ThreadLocalRandom;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;

public class BlockUtil {

    public static Block getBlock(final BlockPos block) {
        return Minecraft.getMinecraft().theWorld.getBlockState(block).getBlock();
    }

    public static Vec3 getVec3(BlockPos pos, EnumFacing facing) {
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		double random1 = ThreadLocalRandom.current().nextDouble(0.47, 0.53);
		double random2 = ThreadLocalRandom.current().nextDouble(0.47, 0.53);
		
		//double random1 = ThreadLocalRandom.current().nextDouble(0.6D, 1.0D);
		//double random2 = ThreadLocalRandom.current().nextDouble(0.9D, 1.0D);
		if(facing.equals(EnumFacing.UP)) {
			x += random1;
			z += random1;
			++y;
		} else if(facing.equals(EnumFacing.DOWN)) {
			x += random1;
			z += random1;
        } else if(facing.equals(EnumFacing.WEST)) {
        	y += random2;
        	z += random1;
        } else if(facing.equals(EnumFacing.EAST)) {
        	y += random2;
        	z += random1;
        	++x;
        } else if(facing.equals(EnumFacing.SOUTH)) {
        	y += random2;
        	x += random1;
        	++z;
        } else if(facing.equals(EnumFacing.NORTH)) {
        	y += random2;
        	x += random1;
        }
		
        return new Vec3(x, y, z);
	}
	
}

