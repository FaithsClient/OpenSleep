package linxiu.command.commands.PathFinder;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PathUtil {
    private static final Minecraft mc = Minecraft.getMinecraft();
    private final Vec3 startVec3;
    private final Vec3 endVec3;
    private ArrayList<Vec3> path = new ArrayList<>();
    private final ArrayList<Hub> hubs = new ArrayList<>();
    private final ArrayList<Hub> hubsToWork = new ArrayList<>();
    private final double minDistanceSquared = 9;
    private final boolean nearest = true;

    private static final Vec3[] flatCardinalDirections = {
            new Vec3(1, 0, 0),
            new Vec3(-1, 0, 0),
            new Vec3(0, 0, 1),
            new Vec3(0, 0, -1)
    };

    public PathUtil(Vec3 startVec3, Vec3 endVec3) {
        this.startVec3 = startVec3.addVector(0, 0, 0).floor();
        this.endVec3 = endVec3.addVector(0, 0, 0).floor();
    }

    public ArrayList<Vec3> getPath() {
        return path;
    }

    public void compute() {
        compute(1000, 4);
    }

    public void compute(int loops, int depth) {
        path.clear();
        hubsToWork.clear();
        ArrayList<Vec3> initPath = new ArrayList<Vec3>();
        initPath.add(startVec3);
        hubsToWork.add(new Hub(startVec3, null, initPath, startVec3.squareDistanceTo(endVec3), 0, 0));
        search:
        for (int i = 0; i < loops; i++) {
            hubsToWork.sort(new CompareHub());
            int j = 0;
            if (hubsToWork.size() == 0) {
                break;
            }
            for (Hub hub : new ArrayList<Hub>(hubsToWork)) {
                j++;
                if (j > depth) {
                    break;
                } else {
                    hubsToWork.remove(hub);
                    hubs.add(hub);

                    for (Vec3 direction : flatCardinalDirections) {
                        Vec3 loc = hub.getLoc().add(direction).floor();
                        if (checkPositionValidity(loc, false)) {
                            if (addHub(hub, loc, 0)) {
                                break search;
                            }
                        }
                    }

                    Vec3 loc1 = hub.getLoc().addVector(0, 1, 0).floor();
                    if (checkPositionValidity(loc1, false)) {
                        if (addHub(hub, loc1, 0)) {
                            break search;
                        }
                    }

                    Vec3 loc2 = hub.getLoc().addVector(0, -1, 0).floor();
                    if (checkPositionValidity(loc2, false)) {
                        if (addHub(hub, loc2, 0)) {
                            break search;
                        }
                    }
                }
            }
        }
        if (nearest) {
            Collections.sort(hubs, new CompareHub());
            path = hubs.get(0).getPath();
        }
    }

    public static boolean checkPositionValidity(net.minecraft.util.Vec3 vec3) {
        BlockPos pos = new BlockPos(vec3);
        if (PathUtil.isBlockSolid(pos) || PathUtil.isBlockSolid(pos.add(0, 1, 0))) {
            return false;
        }
        return PathUtil.isSafeToWalkOn(pos.add(0, -1, 0));
    }

    public static boolean checkPositionValidity(Vec3 loc, boolean checkGround) {
        return checkPositionValidity((int) loc.getX(), (int) loc.getY(), (int) loc.getZ(), checkGround);
    }

    public static boolean checkPositionValidity(int x, int y, int z, boolean checkGround) {
        BlockPos block1 = new BlockPos(x, y, z);
        BlockPos block2 = new BlockPos(x, y + 1, z);
        BlockPos block3 = new BlockPos(x, y - 1, z);
        return !isBlockSolid(block1) && !isBlockSolid(block2) && (isBlockSolid(block3) || !checkGround) && isSafeToWalkOn(block3);
    }

    private static boolean isBlockSolid(BlockPos block) {
        return mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock().isBlockNormalCube() ||
                (mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock() instanceof BlockSlab) ||
                (mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock() instanceof BlockStairs) ||
                (mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock() instanceof BlockCactus) ||
                (mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock() instanceof BlockChest) ||
                (mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock() instanceof BlockEnderChest) ||
                (mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock() instanceof BlockSkull) ||
                (mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock() instanceof BlockPane) ||
                (mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock() instanceof BlockFence) ||
                (mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock() instanceof BlockWall) ||
                (mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock() instanceof BlockGlass) ||
                (mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock() instanceof BlockPistonBase) ||
                (mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock() instanceof BlockPistonExtension) ||
                (mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock() instanceof BlockPistonMoving) ||
                (mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock() instanceof BlockStainedGlass) ||
                (mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock() instanceof BlockTrapDoor);
    }

    private static boolean isSafeToWalkOn(BlockPos block) {
        return !(mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock() instanceof BlockFence) &&
                !(mc.theWorld.getBlockState(new BlockPos(block.getX(), block.getY(), block.getZ())).getBlock() instanceof BlockWall);
    }

    public Hub isHubExisting(Vec3 loc) {
        for (Hub hub : hubs) {
            if (hub.getLoc().getX() == loc.getX() && hub.getLoc().getY() == loc.getY() && hub.getLoc().getZ() == loc.getZ()) {
                return hub;
            }
        }
        for (Hub hub : hubsToWork) {
            if (hub.getLoc().getX() == loc.getX() && hub.getLoc().getY() == loc.getY() && hub.getLoc().getZ() == loc.getZ()) {
                return hub;
            }
        }
        return null;
    }

    public boolean addHub(Hub parent, Vec3 loc, double cost) {
        Hub existingHub = isHubExisting(loc);
        double totalCost = cost;
        if (parent != null) {
            totalCost += parent.getTotalCost();
        }
        if (existingHub == null) {
            if ((loc.getX() == endVec3.getX() && loc.getY() == endVec3.getY() && loc.getZ() == endVec3.getZ()) || (minDistanceSquared != 0 && loc.squareDistanceTo(endVec3) <= minDistanceSquared)) {
                path.clear();
                path = parent.getPath();
                path.add(loc);
                return true;
            } else {
                ArrayList<Vec3> path = new ArrayList<Vec3>(parent.getPath());
                path.add(loc);
                hubsToWork.add(new Hub(loc, parent, path, loc.squareDistanceTo(endVec3), cost, totalCost));
            }
        } else if (existingHub.getCost() > cost) {
            ArrayList<Vec3> path = new ArrayList<Vec3>(parent.getPath());
            path.add(loc);
            existingHub.setLoc(loc);
            existingHub.setParent(parent);
            existingHub.setPath(path);
            existingHub.setSquareDistanceToFromTarget(loc.squareDistanceTo(endVec3));
            existingHub.setCost(cost);
            existingHub.setTotalCost(totalCost);
        }
        return false;
    }

    public static ArrayList<Vec3> computePath(PathUtil.Vec3 topFrom, PathUtil.Vec3 to) {
        if (!canPassThrow(new BlockPos(topFrom.mc()))) {
            topFrom = topFrom.addVector(0, 1, 0);
        }
        PathUtil pathfinder = new PathUtil(topFrom, to);
        pathfinder.compute();

        int i = 0;
        PathUtil.Vec3 lastLoc = null;
        PathUtil.Vec3 lastDashLoc = null;
        ArrayList<PathUtil.Vec3> path = new ArrayList<>();
        ArrayList<PathUtil.Vec3> pathFinderPath = pathfinder.getPath();
        for (PathUtil.Vec3 pathElm : pathFinderPath) {
            if (i == 0 || i == pathFinderPath.size() - 1) {
                if (lastLoc != null) {
                    path.add(lastLoc.addVector(0.5, 0, 0.5));
                }
                path.add(pathElm.addVector(0.5, 0, 0.5));
                lastDashLoc = pathElm;
            } else {
                boolean canContinue = true;
                if (pathElm.squareDistanceTo(lastDashLoc) > 5 * 5) {
                    canContinue = false;
                } else {
                    double smallX = Math.min(lastDashLoc.getX(), pathElm.getX());
                    double smallY = Math.min(lastDashLoc.getY(), pathElm.getY());
                    double smallZ = Math.min(lastDashLoc.getZ(), pathElm.getZ());
                    double bigX = Math.max(lastDashLoc.getX(), pathElm.getX());
                    double bigY = Math.max(lastDashLoc.getY(), pathElm.getY());
                    double bigZ = Math.max(lastDashLoc.getZ(), pathElm.getZ());
                    cordsLoop:
                    for (int x = (int) smallX; x <= bigX; x++) {
                        for (int y = (int) smallY; y <= bigY; y++) {
                            for (int z = (int) smallZ; z <= bigZ; z++) {
                                if (!PathUtil.checkPositionValidity(x, y, z, false)) {
                                    canContinue = false;
                                    break cordsLoop;
                                }
                            }
                        }
                    }
                }
                if (!canContinue) {
                    path.add(lastLoc.addVector(0.5, 0, 0.5));
                    lastDashLoc = lastLoc;
                }
            }
            lastLoc = pathElm;
            i++;
        }
        return path;
    }

    private static boolean canPassThrow(BlockPos pos) {
        Block block = mc.theWorld.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ())).getBlock();
        return block.getMaterial() == Material.air || block.getMaterial() == Material.plants || block.getMaterial() == Material.vine || block == Blocks.ladder || block == Blocks.water || block == Blocks.flowing_water || block == Blocks.wall_sign || block == Blocks.standing_sign;
    }

    private static class Hub {
        private Vec3 loc = null;
        private Hub parent = null;
        private ArrayList<Vec3> path;
        private double squareDistanceToFromTarget;
        private double cost;
        private double totalCost;

        public Hub(Vec3 loc, Hub parent, ArrayList<Vec3> path, double squareDistanceToFromTarget, double cost, double totalCost) {
            this.loc = loc;
            this.parent = parent;
            this.path = path;
            this.squareDistanceToFromTarget = squareDistanceToFromTarget;
            this.cost = cost;
            this.totalCost = totalCost;
        }

        public Vec3 getLoc() {
            return loc;
        }

        public Hub getParent() {
            return parent;
        }

        public ArrayList<Vec3> getPath() {
            return path;
        }

        public double getSquareDistanceToFromTarget() {
            return squareDistanceToFromTarget;
        }

        public double getCost() {
            return cost;
        }

        public void setLoc(Vec3 loc) {
            this.loc = loc;
        }

        public void setParent(Hub parent) {
            this.parent = parent;
        }

        public void setPath(ArrayList<Vec3> path) {
            this.path = path;
        }

        public void setSquareDistanceToFromTarget(double squareDistanceToFromTarget) {
            this.squareDistanceToFromTarget = squareDistanceToFromTarget;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public double getTotalCost() {
            return totalCost;
        }

        public void setTotalCost(double totalCost) {
            this.totalCost = totalCost;
        }
    }

    public class CompareHub implements Comparator<Hub> {
        @Override
        public int compare(Hub o1, Hub o2) {
            return (int) (
                    (o1.getSquareDistanceToFromTarget() + o1.getTotalCost()) - (o2.getSquareDistanceToFromTarget() + o2.getTotalCost())
            );
        }
    }

    public static class Vec3 {
        private final double x, y, z;

        public Vec3(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getZ() {
            return z;
        }

        public Vec3 addVector(double x, double y, double z) {
            return new Vec3(this.x + x, this.y + y, this.z + z);
        }

        public Vec3 floor() {
            return new Vec3(Math.floor(this.x), Math.floor(this.y), Math.floor(this.z));
        }

        public double squareDistanceTo(Vec3 v) {
            return Math.pow(v.x - this.x, 2) + Math.pow(v.y - this.y, 2) + Math.pow(v.z - this.z, 2);
        }

        public Vec3 add(Vec3 v) {
            return addVector(v.getX(), v.getY(), v.getZ());
        }

        public net.minecraft.util.Vec3 mc() {
            return new net.minecraft.util.Vec3(x, y, z);
        }

        @Override
        public String toString() {
            return "[" + x + ";" + y + ";" + z + "]";
        }
    }
}