//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender3D;
import ft.sleep.api.events.world.EventPacketReceive;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.injection.interfaces.IRenderManager;
import java.awt.Color;
import java.util.Comparator;
import java.util.Objects;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleType;
import ft.sleep.util.color.ColorUtils2;
import ft.sleep.util.render.RenderUtils;
import ft.sleep.util.render.WorldRenderUtils;
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
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class UHCFind extends Module {
   public Numbers common$ = new Numbers("Range", 50.0D, Double.longBitsToDouble(0L), 100.0D, 1.0D);
   public Option webpage$ = new Option("Cane", true);
   public Option stickers$ = new Option("Wart", true);
   public Option driving$ = new Option("Mob Spawner", true);
   public Option paint$ = new Option("Player Zombie", true);
   public Option trouble$ = new Option("Enderman", true);
   public Option temple$ = new Option("Creeper", true);
   public Option image$ = new Option("Blaze", true);
   public Option entries$ = new Option("Slime", true);
   public Option compaq$ = new Option("Magma Cube", true);

   public UHCFind() {
      super("UHC Find", new String[]{"ft.sleep.module.modules.UHCFind"}, ModuleType.Player);
      inugafad._piece((new Color(158, 205, 125)).getRGB());
   }

   public void _fighter(BlockPos ferucovi, int cunazipa, int toyurefa, int teyutige) {
      RenderUtils._supplied((BlockPos)ferucovi, ColorUtils2._despite((int)cunazipa, (int)toyurefa, (int)teyutige));
   }

   @EventHandler
   public void _admitted(EventRender3D ubomadif) {
      Object usotereb = sodizaze.mc.theWorld.getLoadedEntityList();
      usotereb.sort(Comparator.comparingDouble(UHCFind::_monday));
      Object ofovagic = 0;
      if (sodizaze.webpage$.getValue().booleanValue() || sodizaze.stickers$.getValue().booleanValue()) {
         Object natepubi = sodizaze.common$.getValue().intValue();

         for(Object epapomep = natepubi; epapomep >= -natepubi; --epapomep) {
            for(Object dagamata = -natepubi; dagamata <= natepubi; ++dagamata) {
               for(Object asinafug = -natepubi; asinafug <= natepubi; ++asinafug) {
                  Object odacayil = new BlockPos(sodizaze.mc.thePlayer.posX + (double)dagamata, sodizaze.mc.thePlayer.posY + (double)epapomep, sodizaze.mc.thePlayer.posZ + (double)asinafug);
                  Object ibufotup = sodizaze.mc.theWorld.getBlockState(odacayil).getBlock();
                  if (ibufotup == Blocks.reeds && sodizaze.webpage$.getValue().booleanValue()) {
                     sodizaze._fighter(odacayil, 0, 155, 0);
                  }

                  if (ibufotup == Blocks.nether_wart && sodizaze.stickers$.getValue().booleanValue()) {
                     sodizaze._fighter(odacayil, 255, 0, 0);
                  }
               }
            }
         }
      }

      for(Object var14 : usotereb) {
         Object var16 = var14.lastTickPosX + (var14.posX - var14.lastTickPosX) * (double)((EventRender3D)ubomadif).getPartialTicks() - ((IRenderManager)sodizaze.mc.getRenderManager()).getRenderPosX();
         Object var17 = var14.lastTickPosY + (var14.posY - var14.lastTickPosY) * (double)((EventRender3D)ubomadif).getPartialTicks() - ((IRenderManager)sodizaze.mc.getRenderManager()).getRenderPosY();
         Object yafasisa = var14.lastTickPosZ + (var14.posZ - var14.lastTickPosZ) * (double)((EventRender3D)ubomadif).getPartialTicks() - ((IRenderManager)sodizaze.mc.getRenderManager()).getRenderPosZ();
         if (sodizaze.trouble$.getValue().booleanValue() && var14 instanceof EntityEnderman) {
            WorldRenderUtils._revenues(var16, var17, yafasisa, (double)var14.width / 1.5D, var14.getEntityBoundingBox().maxY - var14.getEntityBoundingBox().minY, (new Color(143, 0, 226)).getRGB());
         }

         if (sodizaze.image$.getValue().booleanValue() && var14 instanceof EntityBlaze) {
            WorldRenderUtils._revenues(var16, var17, yafasisa, (double)var14.width / 1.5D, var14.getEntityBoundingBox().maxY - var14.getEntityBoundingBox().minY, (new Color(239, 128, 2)).getRGB());
         }

         if (sodizaze.entries$.getValue().booleanValue() && var14 instanceof EntitySlime) {
            WorldRenderUtils._revenues(var16, var17, yafasisa, (double)var14.width / 1.5D, var14.getEntityBoundingBox().maxY - var14.getEntityBoundingBox().minY, (new Color(41, 255, 0)).getRGB());
         }

         if (sodizaze.compaq$.getValue().booleanValue() && var14 instanceof EntityMagmaCube) {
            WorldRenderUtils._revenues(var16, var17, yafasisa, (double)var14.width / 1.5D, var14.getEntityBoundingBox().maxY - var14.getEntityBoundingBox().minY, (new Color(177, 22, 53)).getRGB());
         }

         if (sodizaze.temple$.getValue().booleanValue() && var14 instanceof EntityCreeper && ofovagic < 2) {
            WorldRenderUtils._revenues(var16, var17, yafasisa, (double)var14.width / 1.5D, var14.getEntityBoundingBox().maxY - var14.getEntityBoundingBox().minY, (new Color(29, 156, 7)).getRGB());
            ++ofovagic;
         }

         if (sodizaze.paint$.getValue().booleanValue() && var14 instanceof EntityZombie && !(var14 instanceof EntityPigZombie) && var14.getDisplayName() != null && Objects.nonNull(((EntityZombie)var14).getEquipmentInSlot(4)) && ((EntityZombie)var14).getEquipmentInSlot(4).getItem() == Items.skull) {
            WorldRenderUtils._revenues(var16, var17, yafasisa, 0.4D, var14.getEntityBoundingBox().maxY - var14.getEntityBoundingBox().minY, (new Color(255, 255, 255)).getRGB());
         }
      }

      if (sodizaze.driving$.getValue().booleanValue()) {
         for(Object var15 : sodizaze.mc.theWorld.loadedTileEntityList) {
            if (var15 instanceof TileEntityMobSpawner) {
               GL11.glPushMatrix();
               RenderUtils._marvel(2.0F);
               TileEntityRendererDispatcher.instance.renderTileEntity(var15, ((EventRender3D)ubomadif).getPartialTicks(), -1);
               RenderUtils._rather();
               TileEntityRendererDispatcher.instance.renderTileEntity(var15, ((EventRender3D)ubomadif).getPartialTicks(), -1);
               RenderUtils._plants();
               TileEntityRendererDispatcher.instance.renderTileEntity(var15, ((EventRender3D)ubomadif).getPartialTicks(), -1);
               RenderUtils._phones((new Color(0, 86, 255)).getRGB());
               TileEntityRendererDispatcher.instance.renderTileEntity(var15, ((EventRender3D)ubomadif).getPartialTicks(), -1);
               RenderUtils._councils();
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               GL11.glPopMatrix();
            }
         }
      }

   }

   @EventHandler
   public void _reasons(EventPacketReceive vipibiyu) {
      if (EventPacketReceive.getPacket() instanceof S0FPacketSpawnMob) {
         Object ciranasi = (S0FPacketSpawnMob)EventPacketReceive.getPacket();
         Object uberadib = (EntityLivingBase)EntityList.createEntityByID(ciranasi.getEntityType(), iyezobag.mc.theWorld);
         Object tocasefo = (double)ciranasi.getX() / 32.0D;
         Object yuridori = (double)ciranasi.getY() / 32.0D;
         Object revucifu = (double)ciranasi.getZ() / 32.0D;
         Object dadecusi = (float)(ciranasi.getYaw() * 360) / 256.0F;
         Object igeremat = (float)(ciranasi.getPitch() * 360) / 256.0F;
         uberadib.serverPosX = ciranasi.getX();
         uberadib.serverPosY = ciranasi.getY();
         uberadib.serverPosZ = ciranasi.getZ();
         uberadib.renderYawOffset = uberadib.rotationYawHead = (float)(ciranasi.getHeadPitch() * 360) / 256.0F;
         Object fopuyevo = 0;
         Object vizefeca = uberadib.getParts();
         Object afitevuy = ciranasi.getEntityID() - uberadib.getEntityId();
         if (vizefeca != null) {
            for(Object var22 = 0; var22 < vizefeca.length; ++var22) {
               vizefeca[var22].setEntityId(vizefeca[var22].getEntityId() + afitevuy);
            }
         }

         uberadib.setEntityId(ciranasi.getEntityID());
         uberadib.setPositionAndRotation(tocasefo, yuridori, revucifu, dadecusi, igeremat);
         uberadib.motionX = (double)((float)ciranasi.getVelocityX() / 8000.0F);
         uberadib.motionY = (double)((float)ciranasi.getVelocityY() / 8000.0F);
         uberadib.motionZ = (double)((float)ciranasi.getVelocityZ() / 8000.0F);
         Object umirotif = ciranasi.func_149027_c();
         uberadib.getDataWatcher().updateWatchedObjectsFromList(umirotif);
         fopuyevo = ciranasi.getX() / 32;
         Object sinuyise = ciranasi.getY() / 32;
         Object utizocof = ciranasi.getZ() / 32;
         float var18 = (float)(iyezobag.mc.thePlayer.posX - (double)fopuyevo);
         float var19 = (float)(iyezobag.mc.thePlayer.posY - (double)sinuyise);
         float var20 = (float)(iyezobag.mc.thePlayer.posZ - (double)utizocof);
         float var21 = MathHelper.sqrt_float(var18 * var18 + var19 * var19 + var20 * var20);
         if (iyezobag.trouble$.getValue().booleanValue() && uberadib instanceof EntityEnderman) {
            iyezobag.mc.thePlayer.addChatMessage(new ChatComponentText("§3[Find] §r" + uberadib.getName() + "§e " + (int)var21 + "§7m"));
            iyezobag.mc.thePlayer.addChatMessage(new ChatComponentText("§3[Find] §r§5X: §r" + fopuyevo + " §5Y: §r" + sinuyise + " §5Z: §r" + utizocof));
         }

         if (iyezobag.compaq$.getValue().booleanValue() && uberadib instanceof EntityMagmaCube) {
            iyezobag.mc.thePlayer.addChatMessage(new ChatComponentText("§3[Find] §r" + uberadib.getName() + "§e " + (int)var21 + "§7m"));
            iyezobag.mc.thePlayer.addChatMessage(new ChatComponentText("§3[Find] §r§5X: §r" + fopuyevo + " §5Y: §r" + sinuyise + " §5Z: §r" + utizocof));
         }

         if (iyezobag.image$.getValue().booleanValue() && uberadib instanceof EntityBlaze) {
            iyezobag.mc.thePlayer.addChatMessage(new ChatComponentText("§3[Find] §r" + uberadib.getName() + "§e " + (int)var21 + "§7m"));
            iyezobag.mc.thePlayer.addChatMessage(new ChatComponentText("§3[Find] §r§5X: §r" + fopuyevo + " §5Y: §r" + sinuyise + " §5Z: §r" + utizocof));
         }

         if (iyezobag.paint$.getValue().booleanValue() && uberadib instanceof EntityZombie && !(uberadib instanceof EntityPigZombie) && uberadib.getDisplayName() != null && !uberadib.getDisplayName().getUnformattedText().equalsIgnoreCase("Zombie") && !uberadib.getDisplayName().getUnformattedText().equalsIgnoreCase("僵尸") && !uberadib.getDisplayName().getFormattedText().startsWith("§")) {
            iyezobag.mc.thePlayer.addChatMessage(new ChatComponentText("§3[Find] §r" + uberadib.getName() + "§e " + (int)var21 + "§7m"));
            iyezobag.mc.thePlayer.addChatMessage(new ChatComponentText("§3[Find] §r§5X: §r" + fopuyevo + " §5Y: §r" + sinuyise + " §5Z: §r" + utizocof));
         }
      }

   }

   public void _trash(Entity uvinonul, Color imidilas) {
      Object onuduyis = ((Entity)uvinonul).lastTickPosX + (((Entity)uvinonul).posX - ((Entity)uvinonul).lastTickPosX) * (double)caziviza.mc.timer.renderPartialTicks - caziviza.mc.getRenderManager().renderPosX;
      Object uvebosab = ((Entity)uvinonul).lastTickPosY + (((Entity)uvinonul).posY - ((Entity)uvinonul).lastTickPosY) * (double)caziviza.mc.timer.renderPartialTicks - caziviza.mc.getRenderManager().renderPosY;
      Object udeleles = ((Entity)uvinonul).lastTickPosZ + (((Entity)uvinonul).posZ - ((Entity)uvinonul).lastTickPosZ) * (double)caziviza.mc.timer.renderPartialTicks - caziviza.mc.getRenderManager().renderPosZ;
      double var9 = (double)((Entity)uvinonul).width / 1.5D;
      double var11 = ((Entity)uvinonul).getEntityBoundingBox().maxY - ((Entity)uvinonul).getEntityBoundingBox().minY;
      GL11.glPushMatrix();
      RenderUtils._marvel(2.0F);
      GL11.glDisable(2848);
      RenderUtils._cities(new AxisAlignedBB(onuduyis - var9, uvebosab, udeleles - var9, onuduyis + var9, uvebosab + var11, udeleles + var9));
      RenderUtils._rather();
      RenderUtils._cities(new AxisAlignedBB(onuduyis - var9, uvebosab, udeleles - var9, onuduyis + var9, uvebosab + var11, udeleles + var9));
      RenderUtils._plants();
      RenderUtils._cities(new AxisAlignedBB(onuduyis - var9, uvebosab, udeleles - var9, onuduyis + var9, uvebosab + var11, udeleles + var9));
      RenderUtils._phones(((Color)imidilas).getRGB());
      RenderUtils._cities(new AxisAlignedBB(onuduyis - var9, uvebosab, udeleles - var9, onuduyis + var9, uvebosab + var11, udeleles + var9));
      RenderUtils._councils();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPopMatrix();
   }

   public static double _monday(Entity cucifupi) {
      return (double)Minecraft.getMinecraft().thePlayer.getDistanceToEntity((Entity)cucifupi);
   }
}
