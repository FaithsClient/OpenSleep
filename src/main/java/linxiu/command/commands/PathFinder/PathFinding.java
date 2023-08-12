package linxiu.command.commands.PathFinder;


import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

public class PathFinding {
    public PathFinding parent;
    private final boolean walkable;
    private final BlockPos blockPos;

    public PathFinding(boolean walkable, BlockPos blockPos) {
        this.walkable = walkable;
        this.blockPos = blockPos;
    }

    public double getG_Cost(PathFinding startNode) {
        return this.distance(this.blockPos, startNode.getBlockpos());
    }

    public double getH_Cost(PathFinding endNode) {
        return this.distance(this.blockPos, endNode.getBlockpos());
    }

    public double getF_Cost(PathFinding startNode, PathFinding endNode) {
        return this.getG_Cost(startNode) + this.getH_Cost(endNode);
    }

    public BlockPos getBlockpos() {
        return this.blockPos;
    }

    public boolean isWalkable() {
        return this.walkable;
    }

    public double distance(BlockPos b1, BlockPos b2) {
        float f2 = b1.getX() - b2.getX();
        float f1 = b1.getY() - b2.getY();
        float f22 = b1.getZ() - b2.getZ();
        return MathHelper.sqrt_float(f2 * f2 + f1 * f1 + f22 * f22);
    }
}

