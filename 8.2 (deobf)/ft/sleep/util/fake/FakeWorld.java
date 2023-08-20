//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.fake;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.profiler.Profiler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class FakeWorld extends WorldClient {
   public FakeWorld(WorldSettings afenovav, FakeNetHandlerPlayClient poletipu) {
      super((NetHandlerPlayClient)poletipu, (WorldSettings)afenovav, 0, EnumDifficulty.HARD, new Profiler());
      udufuzab.provider.registerWorld(udufuzab);
   }

   public boolean isChunkLoaded(int var1, int var2, boolean var3) {
      return false;
   }

   public BlockPos getTopSolidOrLiquidBlock(BlockPos govetace) {
      return new BlockPos(((BlockPos)govetace).getX(), 63, ((BlockPos)govetace).getZ());
   }

   public boolean isAirBlock(BlockPos isamanec) {
      return ((BlockPos)isamanec).getY() > 63;
   }

   public boolean setBlockState(BlockPos var1, IBlockState var2) {
      return true;
   }

   public boolean setBlockToAir(BlockPos var1) {
      return true;
   }

   public void markChunkDirty(BlockPos var1, TileEntity var2) {
   }

   public void _/* $FF was: î ?*/(BlockPos var1, IBlockState var2, IBlockState var3, int var4) {
   }

   public boolean destroyBlock(BlockPos deadly, boolean var2) {
      return observe.isAirBlock((BlockPos)deadly);
   }

   public void notifyNeighborsOfStateExcept(BlockPos var1, Block var2, EnumFacing var3) {
   }

   public void _/* $FF was: î ?*/(BlockPos var1, Block var2, boolean var3) {
   }

   public void _/* $FF was: î ?*/(BlockPos var1, Chunk var2, IBlockState var3, IBlockState var4, int var5) {
   }

   public void markBlocksDirtyVertical(int var1, int var2, int var3, int var4) {
   }

   public void markBlockRangeForRenderUpdate(int var1, int var2, int var3, int var4, int var5, int var6) {
   }

   public boolean isBlockTickPending(BlockPos var1, Block var2) {
      return false;
   }

   public int getLightFromNeighbors(BlockPos var1) {
      return 14;
   }

   public int getLight(BlockPos var1, boolean var2) {
      return 14;
   }

   public int getLight(BlockPos var1) {
      return 14;
   }

   public int getLightFor(EnumSkyBlock var1, BlockPos var2) {
      return 14;
   }

   public int getLightFromNeighborsFor(EnumSkyBlock var1, BlockPos var2) {
      return 14;
   }

   public boolean canBlockSeeSky(BlockPos circus) {
      return ((BlockPos)circus).getY() > 62;
   }

   public BlockPos getHeight(BlockPos facial) {
      return new BlockPos(((BlockPos)facial).getX(), 63, ((BlockPos)facial).getZ());
   }

   public int getChunksLowestHorizon(int var1, int var2) {
      return 63;
   }

   public void updateBlocks() {
   }

   public void markBlockRangeForRenderUpdate(BlockPos var1, BlockPos var2) {
   }

   public void setLightFor(EnumSkyBlock var1, BlockPos var2, int var3) {
   }

   public float getLightBrightness(BlockPos var1) {
      return 1.0F;
   }

   public float _/* $FF was: î ?*/(float var1) {
      return 1.0F;
   }

   public float getSunBrightness(float var1) {
      return 1.0F;
   }

   public float _/* $FF was: î ?*/(float var1) {
      return 1.0F;
   }

   public boolean isDaytime() {
      return true;
   }

   public boolean addWeatherEffect(Entity var1) {
      return false;
   }

   public boolean spawnEntityInWorld(Entity var1) {
      return false;
   }

   public void onEntityAdded(Entity var1) {
   }

   public void onEntityRemoved(Entity var1) {
   }

   public void removeEntity(Entity var1) {
   }

   public void _/* $FF was: î ?*/(Entity var1) {
   }

   public int calculateSkylightSubtracted(float var1) {
      return 6;
   }

   public void scheduleBlockUpdate(BlockPos var1, Block var2, int var3, int var4) {
   }

   public void updateEntities() {
   }

   public void updateEntityWithOptionalForce(Entity helping, boolean opinions) {
      if (opinions) {
         ++((Entity)helping).ticksExisted;
      }

   }

   public boolean checkNoEntityCollision(AxisAlignedBB var1) {
      return true;
   }

   public boolean checkNoEntityCollision(AxisAlignedBB var1, Entity var2) {
      return true;
   }

   public boolean checkBlockCollision(AxisAlignedBB var1) {
      return false;
   }

   public boolean _/* $FF was: î ?*/(AxisAlignedBB var1) {
      return false;
   }

   public boolean handleMaterialAcceleration(AxisAlignedBB var1, Material var2, Entity var3) {
      return false;
   }

   public boolean isMaterialInBB(AxisAlignedBB var1, Material var2) {
      return false;
   }

   public TileEntity getTileEntity(BlockPos var1) {
      return null;
   }

   public boolean extinguishFire(EntityPlayer var1, BlockPos var2, EnumFacing var3) {
      return true;
   }

   public String getDebugLoadedEntities() {
      return "";
   }

   public String getProviderName() {
      return "";
   }

   public void setTileEntity(BlockPos var1, TileEntity var2) {
   }

   public void removeTileEntity(BlockPos var1) {
   }

   public void markTileEntityForRemoval(TileEntity var1) {
   }

   public boolean isBlockNormalCube(BlockPos var1, boolean var2) {
      return true;
   }

   public void tick() {
   }

   public void updateWeather() {
   }

   public void ____/* $FF was: î “î ”î ”î ‘*/() {
   }

   public boolean canBlockFreezeWater(BlockPos var1) {
      return false;
   }

   public boolean canBlockFreezeNoWater(BlockPos var1) {
      return false;
   }

   public boolean canBlockFreeze(BlockPos var1, boolean var2) {
      return false;
   }

   public boolean _/* $FF was: î ?*/(BlockPos var1, boolean var2) {
      return false;
   }

   public boolean canSnowAt(BlockPos var1, boolean var2) {
      return false;
   }

   public boolean _/* $FF was: î ?*/(BlockPos var1, boolean var2) {
      return false;
   }

   public boolean tickUpdates(boolean var1) {
      return false;
   }

   public int getStrongPower(BlockPos var1) {
      return 0;
   }

   public int getStrongPower(BlockPos var1, EnumFacing var2) {
      return 0;
   }

   public boolean isSidePowered(BlockPos var1, EnumFacing var2) {
      return false;
   }

   public int getRedstonePower(BlockPos var1, EnumFacing var2) {
      return 0;
   }

   public boolean isBlockPowered(BlockPos var1) {
      return false;
   }

   public int isBlockIndirectlyGettingPowered(BlockPos var1) {
      return 0;
   }

   public void checkSessionLock() throws MinecraftException {
   }

   public long getSeed() {
      return (long)533835639 ^ 533835638L;
   }

   public long getTotalWorldTime() {
      return (long)-111478964 ^ -111478963L;
   }

   public long getWorldTime() {
      return (long)2044413385 ^ 2044413384L;
   }

   public void setWorldTime(long var1) {
   }

   public BlockPos getSpawnPoint() {
      return new BlockPos(0, 64, 0);
   }

   public void joinEntityInSurroundings(Entity var1) {
   }

   public boolean canSeeSky(BlockPos verify) {
      return ((BlockPos)verify).getY() > 62;
   }

   public boolean _/* $FF was: î ?*/(EntityPlayer var1, BlockPos var2) {
      return false;
   }

   public void setEntityState(Entity var1, byte var2) {
   }

   public float getThunderStrength(float var1) {
      return Float.intBitsToFloat(0);
   }

   public void addBlockEvent(BlockPos var1, Block var2, int var3, int var4) {
   }

   public void updateAllPlayersSleepingFlag() {
   }

   public boolean isRainingAt(BlockPos var1) {
      return false;
   }

   public void setThunderStrength(float var1) {
   }

   public float getRainStrength(float var1) {
      return Float.intBitsToFloat(0);
   }

   public void setRainStrength(float var1) {
   }

   public boolean isThundering() {
      return false;
   }

   public boolean isRaining() {
      return false;
   }

   public boolean isBlockinHighHumidity(BlockPos var1) {
      return false;
   }

   public void setItemData(String var1, WorldSavedData var2) {
   }

   public void playBroadcastSound(int var1, BlockPos var2, int var3) {
   }

   public void _/* $FF was: î ?*/(EntityPlayer var1, int var2, BlockPos var3, int var4) {
   }

   public void _/* $FF was: î ?*/(int var1, BlockPos var2, int var3) {
   }

   public int getHeight() {
      return 256;
   }

   public int getActualHeight() {
      return 256;
   }

   public void makeFireworks(double var1, double var3, double var5, double var7, double var9, double var11, NBTTagCompound var13) {
   }

   public boolean addTileEntity(TileEntity var1) {
      return true;
   }

   public boolean _/* $FF was: î ?*/(BlockPos patch, EnumFacing var2) {
      return ((BlockPos)patch).getY() <= 63;
   }

   public boolean _/* $FF was: î ?*/(BlockPos isatinop, EnumFacing var2, boolean var3) {
      return ((BlockPos)isatinop).getY() <= 63;
   }

   public int _/* $FF was: î ?*/(EnumCreatureType var1, boolean var2) {
      return 0;
   }

   public IChunkProvider createChunkProvider() {
      return new FakeWorld2();
   }

   public Chunk getChunkFromChunkCoords(int var1, int var2) {
      return null;
   }
}
