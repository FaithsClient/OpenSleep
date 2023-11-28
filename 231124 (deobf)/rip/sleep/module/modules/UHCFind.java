package rip.sleep.module.modules;

import java.awt.Color;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import rip.sleep.injection.in.IRenderManager;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.network.play.server.S0FPacketSpawnMob;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.PacketReceiveEvent;
import rip.sleep.event.events.Render3DEvent;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.ColorUtil;
import rip.sleep.util.RenderUtilD;
import rip.sleep.util.RenderUtilK;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;

public class UHCFind extends Module {
   private final NumberValue<Number> c58939 = new NumberValue<Number>("Range", () -> {
      Module[] var0 = Value.c27574();
      return c68488.c1473().booleanValue() || c73349.c1473().booleanValue();
   }, 30.0D, 0.0D, 30.0D, 1.0D);
   public static BooleanValue c68488 = new BooleanValue("Cane", true);
   public static BooleanValue c73349 = new BooleanValue("Wart", true);
   public BooleanValue c9480 = new BooleanValue("Mob Spawner", true);
   public BooleanValue c27391 = new BooleanValue("Player Zombie", true);
   public BooleanValue c61837 = new BooleanValue("Enderman", true);
   public BooleanValue c3062 = new BooleanValue("Creeper", true);
   public BooleanValue c79368 = new BooleanValue("Blaze", true);
   public BooleanValue c49528 = new BooleanValue("Slime", true);
   public BooleanValue c82119 = new BooleanValue("Magma Cube", true);

   public UHCFind() {
      super("UHC Find", new String[]{"UHCFind"}, ModuleType.c31770, ModuleType.c21190.c76367);
      this.c36162((new Color(158, 205, 125)).getRGB());
   }

   private void c19905(BlockPos var1, int var2, int var3, int var4) {
      RenderUtilD.c52429(var1, ColorUtil.c74045(var2, var3, var4));
   }

   @EventTarget
   public void c57709(Render3DEvent var1) {
      List var3 = mc.theWorld.getLoadedEntityList();
      Value.c27574();
      var3.sort(Comparator.comparingDouble(UHCFind::c64351));
      int var4 = 0;
      if (c68488.c1473().booleanValue() || c73349.c1473().booleanValue()) {
         int var5 = this.c58939.c53968().intValue();
         if (var5 >= -var5) {
            int var7 = -var5;
            if (var7 <= var5) {
               int var8 = -var5;
               if (var8 <= var5) {
                  BlockPos var9 = new BlockPos(mc.thePlayer.posX + (double)var7, mc.thePlayer.posY + (double)var5, mc.thePlayer.posZ + (double)var8);
                  Block var10 = mc.theWorld.getBlockState(var9).getBlock();
                  if (var10 == Blocks.reeds && c68488.c1473().booleanValue()) {
                     this.c19905(var9, 0, 155, 0);
                  }

                  if (var10 == Blocks.nether_wart && c73349.c1473().booleanValue()) {
                     this.c19905(var9, 255, 0, 0);
                  }

                  ++var8;
               }

               ++var7;
            }

            int var6 = var5 - 1;
         }
      }

      Iterator var14 = var3.iterator();
      if (var14.hasNext()) {
         Entity var16 = (Entity)var14.next();
         double var19 = var16.lastTickPosX + (var16.posX - var16.lastTickPosX) * (double)var1.c36064() - ((IRenderManager) mc.getRenderManager()).getRenderPosX();
         double var21 = var16.lastTickPosY + (var16.posY - var16.lastTickPosY) * (double)var1.c36064() - ((IRenderManager) mc.getRenderManager()).getRenderPosY();
         double var11 = var16.lastTickPosZ + (var16.posZ - var16.lastTickPosZ) * (double)var1.c36064() - ((IRenderManager) mc.getRenderManager()).getRenderPosZ();
         if (this.c61837.c1473().booleanValue() && var16 instanceof EntityEnderman) {
            RenderUtilK.c32520(var19, var21, var11, (double)var16.width / 1.5D, var16.getEntityBoundingBox().maxY - var16.getEntityBoundingBox().minY, (new Color(143, 0, 226)).getRGB());
         }

         if (this.c79368.c1473().booleanValue() && var16 instanceof EntityBlaze) {
            RenderUtilK.c32520(var19, var21, var11, (double)var16.width / 1.5D, var16.getEntityBoundingBox().maxY - var16.getEntityBoundingBox().minY, (new Color(239, 128, 2)).getRGB());
         }

         if (this.c49528.c1473().booleanValue() && var16 instanceof EntitySlime) {
            RenderUtilK.c32520(var19, var21, var11, (double)var16.width / 1.5D, var16.getEntityBoundingBox().maxY - var16.getEntityBoundingBox().minY, (new Color(41, 255, 0)).getRGB());
         }

         if (this.c82119.c1473().booleanValue() && var16 instanceof EntityMagmaCube) {
            RenderUtilK.c32520(var19, var21, var11, (double)var16.width / 1.5D, var16.getEntityBoundingBox().maxY - var16.getEntityBoundingBox().minY, (new Color(177, 22, 53)).getRGB());
         }

         if (this.c3062.c1473().booleanValue() && var16 instanceof EntityCreeper && var4 < 2) {
            RenderUtilK.c32520(var19, var21, var11, (double)var16.width / 1.5D, var16.getEntityBoundingBox().maxY - var16.getEntityBoundingBox().minY, (new Color(29, 156, 7)).getRGB());
            ++var4;
         }

         if (this.c27391.c1473().booleanValue() && var16 instanceof EntityZombie && !(var16 instanceof EntityPigZombie) && var16.getDisplayName() != null && Objects.nonNull(((EntityZombie)var16).func_71124_b(4)) && ((EntityZombie)var16).func_71124_b(4).getItem() == Items.skull) {
            RenderUtilK.c32520(var19, var21, var11, 0.4D, var16.getEntityBoundingBox().maxY - var16.getEntityBoundingBox().minY, (new Color(255, 255, 255)).getRGB());
         }
      }

      if (this.c9480.c1473().booleanValue()) {
         var14 = mc.theWorld.loadedTileEntityList.iterator();
         if (var14.hasNext()) {
            TileEntity var17 = (TileEntity)var14.next();
            if (var17 instanceof TileEntityMobSpawner) {
               GL11.glPushMatrix();
               RenderUtilD.c77416(2.0F);
               TileEntityRendererDispatcher.instance.renderTileEntity(var17, var1.c36064(), -1);
               RenderUtilD.c49560();
               TileEntityRendererDispatcher.instance.renderTileEntity(var17, var1.c36064(), -1);
               RenderUtilD.c19347();
               TileEntityRendererDispatcher.instance.renderTileEntity(var17, var1.c36064(), -1);
               RenderUtilD.c33760((new Color(0, 86, 255)).getRGB());
               TileEntityRendererDispatcher.instance.renderTileEntity(var17, var1.c36064(), -1);
               RenderUtilD.c11067();
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               GL11.glPopMatrix();
            }
         }
      }

   }

   @EventTarget
   public void c98799(PacketReceiveEvent var1) {
      Module[] var2 = Value.c27574();
      if (PacketReceiveEvent.getPacket() instanceof S0FPacketSpawnMob) {
         S0FPacketSpawnMob var3 = (S0FPacketSpawnMob) PacketReceiveEvent.getPacket();
         EntityLivingBase var4 = (EntityLivingBase)EntityList.createEntityByID(var3.getEntityType(), mc.theWorld);
         double var5 = (double)var3.getX() / 32.0D;
         double var7 = (double)var3.getY() / 32.0D;
         double var9 = (double)var3.getZ() / 32.0D;
         float var11 = (float)(var3.getYaw() * 360) / 256.0F;
         float var12 = (float)(var3.getPitch() * 360) / 256.0F;
         var4.serverPosX = var3.getX();
         var4.serverPosY = var3.getY();
         var4.serverPosZ = var3.getZ();
         var4.renderYawOffset = var4.rotationYawHead = (float)(var3.getHeadPitch() * 360) / 256.0F;
         int var13 = 0;
         Entity[] var14 = var4.getParts();
         int var15 = var3.getEntityID() - var4.getEntityId();
         var13 = 0;
         if (var13 < var14.length) {
            var14[var13].setEntityId(var14[var13].getEntityId() + var15);
            ++var13;
         }

         var4.setEntityId(var3.getEntityID());
         var4.setPositionAndRotation(var5, var7, var9, var11, var12);
         var4.motionX = (double)((float)var3.getVelocityX() / 8000.0F);
         var4.motionY = (double)((float)var3.getVelocityY() / 8000.0F);
         var4.motionZ = (double)((float)var3.getVelocityZ() / 8000.0F);
         List var16 = var3.func_149027_c();
         var4.getDataWatcher().updateWatchedObjectsFromList(var16);
         var13 = var3.getX() / 32;
         int var17 = var3.getY() / 32;
         int var18 = var3.getZ() / 32;
         float var19 = (float)(mc.thePlayer.posX - (double)var13);
         float var20 = (float)(mc.thePlayer.posY - (double)var17);
         float var21 = (float)(mc.thePlayer.posZ - (double)var18);
         float var22 = MathHelper.sqrt_float(var19 * var19 + var20 * var20 + var21 * var21);
         if (this.c61837.c1473().booleanValue() && var4 instanceof EntityEnderman) {
            mc.thePlayer.addChatMessage(new ChatComponentText("§3[Find] §r" + var4.getName() + "§e " + (int)var22 + "§7m"));
            mc.thePlayer.addChatMessage(new ChatComponentText("§3[Find] §r§5X: §r" + var13 + " §5Y: §r" + var17 + " §5Z: §r" + var18));
         }

         if (this.c82119.c1473().booleanValue() && var4 instanceof EntityMagmaCube) {
            mc.thePlayer.addChatMessage(new ChatComponentText("§3[Find] §r" + var4.getName() + "§e " + (int)var22 + "§7m"));
            mc.thePlayer.addChatMessage(new ChatComponentText("§3[Find] §r§5X: §r" + var13 + " §5Y: §r" + var17 + " §5Z: §r" + var18));
         }

         if (this.c79368.c1473().booleanValue() && var4 instanceof EntityBlaze) {
            mc.thePlayer.addChatMessage(new ChatComponentText("§3[Find] §r" + var4.getName() + "§e " + (int)var22 + "§7m"));
            mc.thePlayer.addChatMessage(new ChatComponentText("§3[Find] §r§5X: §r" + var13 + " §5Y: §r" + var17 + " §5Z: §r" + var18));
         }

         if (this.c27391.c1473().booleanValue() && var4 instanceof EntityZombie && !(var4 instanceof EntityPigZombie) && var4.getDisplayName() != null && !var4.getDisplayName().getUnformattedText().equalsIgnoreCase("Zombie") && !var4.getDisplayName().getUnformattedText().equalsIgnoreCase("僵尸") && !var4.getDisplayName().getFormattedText().startsWith("§")) {
            mc.thePlayer.addChatMessage(new ChatComponentText("§3[Find] §r" + var4.getName() + "§e " + (int)var22 + "§7m"));
            mc.thePlayer.addChatMessage(new ChatComponentText("§3[Find] §r§5X: §r" + var13 + " §5Y: §r" + var17 + " §5Z: §r" + var18));
         }
      }

   }

   public void c77060(Entity var1, Color var2) {
      double var3 = var1.lastTickPosX + (var1.posX - var1.lastTickPosX) * (double) mc.timer.renderPartialTicks - mc.getRenderManager().renderPosX;
      double var5 = var1.lastTickPosY + (var1.posY - var1.lastTickPosY) * (double) mc.timer.renderPartialTicks - mc.getRenderManager().renderPosY;
      double var7 = var1.lastTickPosZ + (var1.posZ - var1.lastTickPosZ) * (double) mc.timer.renderPartialTicks - mc.getRenderManager().renderPosZ;
      double var9 = (double)var1.width / 1.5D;
      double var11 = var1.getEntityBoundingBox().maxY - var1.getEntityBoundingBox().minY;
      GL11.glPushMatrix();
      RenderUtilD.c77416(2.0F);
      GL11.glDisable(2848);
      RenderUtilD.c37613(new AxisAlignedBB(var3 - var9, var5, var7 - var9, var3 + var9, var5 + var11, var7 + var9));
      RenderUtilD.c49560();
      RenderUtilD.c37613(new AxisAlignedBB(var3 - var9, var5, var7 - var9, var3 + var9, var5 + var11, var7 + var9));
      RenderUtilD.c19347();
      RenderUtilD.c37613(new AxisAlignedBB(var3 - var9, var5, var7 - var9, var3 + var9, var5 + var11, var7 + var9));
      RenderUtilD.c33760(var2.getRGB());
      RenderUtilD.c37613(new AxisAlignedBB(var3 - var9, var5, var7 - var9, var3 + var9, var5 + var11, var7 + var9));
      RenderUtilD.c11067();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPopMatrix();
   }

   private static double c64351(Entity var0) {
      return (double)Minecraft.getMinecraft().thePlayer.getDistanceToEntity(var0);
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
