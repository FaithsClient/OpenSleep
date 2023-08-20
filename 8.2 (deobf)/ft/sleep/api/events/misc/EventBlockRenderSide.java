package ft.sleep.api.events.misc;

import ft.sleep.api.Event;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

public class EventBlockRenderSide extends Event {
   private final Block block;
   private final IBlockAccess blockAccess;
   private final BlockPos pos;
   private final EnumFacing side;
   private double maxX;
   private double maxY;
   private double maxZ;
   private double minX;
   private double minY;
   private double minZ;
   public boolean shouldRender = false;

   public EventBlockRenderSide(Block block, IBlockAccess blockAccess, BlockPos pos, EnumFacing side, double maxX, double maxY, double maxZ, double minX, double minY, double minZ) {
      this.block = block;
      this.blockAccess = blockAccess;
      this.pos = pos;
      this.side = side;
      this.maxX = maxX;
      this.maxY = maxY;
      this.maxZ = maxZ;
      this.minX = minX;
      this.minY = minY;
      this.minZ = minZ;
   }

   public Block getBlock() {
      return this.block;
   }

   public IBlockAccess getBlockAccess() {
      return this.blockAccess;
   }

   public BlockPos getPos() {
      return this.pos;
   }

   public EnumFacing getSide() {
      return this.side;
   }

   public double getMaxX() {
      return this.maxX;
   }

   public double getMaxY() {
      return this.maxY;
   }

   public double getMaxZ() {
      return this.maxZ;
   }

   public double getMinX() {
      return this.minX;
   }

   public double getMinY() {
      return this.minY;
   }

   public double getMinZ() {
      return this.minZ;
   }

   public void setMaxX(double maxX) {
      this.maxX = maxX;
   }

   public void setMaxY(double maxY) {
      this.maxY = maxY;
   }

   public void setMaxZ(double maxZ) {
      this.maxZ = maxZ;
   }

   public void setMinX(double minX) {
      this.minX = minX;
   }

   public void setMinY(double minY) {
      this.minY = minY;
   }

   public void setMinZ(double minZ) {
      this.minZ = minZ;
   }
}
