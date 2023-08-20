package linxiu.command.commands.PathFinder;

import linxiu.utils.BlockUtil;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;

import java.util.ArrayList;
import java.util.Collections;

public class Processing {
    public ArrayList<PathFinding> path = new ArrayList();
    public ArrayList<PathFinding> triedPaths = new ArrayList();

    private ArrayList<PathFinding> getNeighbors(PathFinding node) {
        ArrayList<PathFinding> neighbors = new ArrayList<PathFinding>();
        BlockPos b1 = node.getBlockpos();
        BlockPos b2 = node.getBlockpos();
        b1 = b1.add(1, 1, 1);
        b1 = b1.add(0.8, 0.8, 0.8);
        b1 = b1.add(0.6, 0.6, 0.6);
        b1 = b1.add(0.4, 0.4, 0.4);
        b1 = b1.add(0.2, 0.2, 0.2);
        b1 = b1.add(0, 0, 0);
        b2 = b2.add(0, 0, 0);
        b2 = b2.add(-1, -1, -1);
        b2 = b2.add(-2, -2, -2);
        b2 = b2.add(-3, -3, -3);
        neighbors.add(this.createNode(b1.up()));
        neighbors.add(this.createNode(b1.down()));
        neighbors.add(this.createNode(b1.east()));
        neighbors.add(this.createNode(b1.west()));
        neighbors.add(this.createNode(b1.north()));
        neighbors.add(this.createNode(b1.south()));
        for (BlockPos pos : BlockPos.getAllInBox(b1, b2)) {
            if (pos.equals(node.getBlockpos()) || pos.getX() > node.getBlockpos().getX() && pos.getZ() > node.getBlockpos().getZ() || pos.getX() < node.getBlockpos().getX() && pos.getZ() < node.getBlockpos().getZ() || pos.getX() < node.getBlockpos().getX() && pos.getZ() > node.getBlockpos().getZ() || pos.getX() > node.getBlockpos().getX() && pos.getZ() < node.getBlockpos().getZ())
                continue;
            neighbors.add(this.createNode(pos));
        }
        return neighbors;
    }

    public void getPath(BlockPos start, BlockPos finish) {
        PathFinding startNode = this.createNode(start);
        PathFinding endNode = this.createNode(finish);
        ArrayList<PathFinding> openNodes = new ArrayList<PathFinding>();
        ArrayList<PathFinding> closedNodes = new ArrayList<PathFinding>();
        openNodes.clear();
        openNodes.add(startNode);
        boolean count = false;
        while (openNodes.size() > 0) {
            PathFinding currentNode = openNodes.get(0);
            double minFCost = 100000.0;
            int i = 1;
            while (i < openNodes.size()) {
                double FCost = openNodes.get(i).getF_Cost(currentNode, endNode);
                if (FCost < minFCost) {
                    minFCost = FCost;
                    currentNode = openNodes.get(i);
                }
                ++i;
            }
            openNodes.clear();
            openNodes.remove(currentNode);
            closedNodes.add(currentNode);
            this.triedPaths.add(currentNode);
            if (currentNode.getBlockpos().equals(endNode.getBlockpos())) {
                endNode.parent = currentNode;
                this.retracePath(startNode, endNode);
                return;
            }
            for (PathFinding neighbor : this.getNeighbors(currentNode)) {
                double hCost;
                if (!neighbor.isWalkable() || this.isNodeClosed(neighbor, closedNodes) || (hCost = currentNode.getH_Cost(endNode)) < neighbor.getH_Cost(endNode) && this.isNodeClosed(neighbor, openNodes))
                    continue;
                neighbor.parent = currentNode;
                if (this.isNodeClosed(neighbor, openNodes)) continue;
                openNodes.add(neighbor);
            }
        }
    }

    private boolean isNodeClosed(PathFinding node, ArrayList<PathFinding> nodes) {
        for (PathFinding n : nodes) {
            if (!n.getBlockpos().equals(node.getBlockpos())) continue;
            return true;
        }
        return false;
    }

    private void retracePath(PathFinding startNode, PathFinding endNode) {
        ArrayList<PathFinding> path = new ArrayList<PathFinding>();
        PathFinding currentNode = endNode;
        while (!currentNode.equals(startNode)) {
            path.add(currentNode);
            currentNode = currentNode.parent;
        }
        Collections.reverse(path);
        this.path = path;
    }

    public PathFinding createNode(BlockPos pos) {
        return new PathFinding(BlockUtil.getBlock(pos).getMaterial() == Material.air && BlockUtil.getBlock(pos.up()).getMaterial() == Material.air && BlockUtil.getBlock(pos.up()).getMaterial() == Material.air, pos);
    }
}

