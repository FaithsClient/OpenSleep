//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.alt;

import com.mojang.authlib.GameProfile;
import ft.sleep.api.Account;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.util.MovementInputFromOptions;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.WorldSettings.GameType;

public class Alts {
   public String bedding$ = "None";
   public double affects$ = 1.0D;
   public Minecraft operator$ = Minecraft.getMinecraft();
   public WorldClient ruling$;
   public boolean oxide$ = true;
   public boolean sacred$;
   public EntityPlayerSP genesis$;
   public FakeEntityPlayer handy$;
   public Account waiting$;
   public int destroy$;
   public int garbage$;
   public int trail$;
   public static List someone$ = Arrays.asList(new ItemStack(Items.bow), new ItemStack(Items.iron_sword), new ItemStack(Items.wooden_sword), new ItemStack(Items.stone_pickaxe), new ItemStack(Items.diamond_pickaxe), new ItemStack(Items.iron_ingot), new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.red_flower));

   public Alts(Account yanafulo) {
      podupilu.waiting$ = (Account)yanafulo;
   }

   public void _normally(int ufigivef, int opatovaz) {
      zuzitapo.destroy$ = 220 * zuzitapo.trail$ + 5 + zuzitapo.garbage$;
      Object acetabay = new ScaledResolution(zuzitapo.operator$);
      if (zuzitapo._auctions()) {
         FontLoaders.TahomaBold35.drawCenteredString("Login as " + zuzitapo.waiting$._modules(), (float)(acetabay.getScaledWidth() / 2), 10.0F, (new Color(HUD.during$.getValue().intValue())).getRGB());
      }

      RoundedUtil._resorts((float)(Client2.surround$.oriented$.mpegs$ + zuzitapo.destroy$), (float) Client2.surround$.oriented$.contest$, 210.0F, 320.0F, 2.0F, 0.8F, new Color(0, 0, 0, 100), zuzitapo.sacred$ ? new Color(HUD.during$.getValue().intValue()) : new Color(0, 0, 0, 100));
      RenderUtil._marked(new ResourceLocation("sleep/alts/" + (zuzitapo.waiting$ instanceof MicrosoftAccount ? "microsoft" : "cracked") + ".png"), (float)(Client2.surround$.oriented$.mpegs$ + zuzitapo.destroy$ + 180), (float)(Client2.surround$.oriented$.contest$ + 10), 16, 16);
      GlStateManager.pushMatrix();
      if (zuzitapo.genesis$ == null || zuzitapo.genesis$.worldObj == null) {
         zuzitapo._areas();
      }

      if (zuzitapo.operator$.getRenderManager().worldObj == null || zuzitapo.operator$.getRenderManager().livingPlayer == null) {
         zuzitapo.operator$.getRenderManager().cacheActiveRenderInfo(zuzitapo.ruling$, zuzitapo.operator$.fontRendererObj, zuzitapo.genesis$, zuzitapo.genesis$, zuzitapo.operator$.gameSettings, Float.intBitsToFloat(0));
      }

      if (zuzitapo.ruling$ != null && zuzitapo.genesis$ != null) {
         zuzitapo.operator$.thePlayer = zuzitapo.genesis$;
         zuzitapo.operator$.theWorld = zuzitapo.ruling$;
         if (zuzitapo.handy$ == null) {
            zuzitapo.handy$ = new FakeEntityPlayer(new GameProfile(zuzitapo.waiting$._sport(), zuzitapo.waiting$._modules()), (ResourceLocation)null);
         }

         zuzitapo._pricing(Client2.surround$.oriented$.mpegs$ + zuzitapo.destroy$ + 102, Client2.surround$.oriented$.contest$ + (zuzitapo._auctions() ? 300 : 295), 100.0F, acetabay.getScaledWidth() / 16 - ufigivef / 8, acetabay.getScaledHeight() / 16 - opatovaz / 8, zuzitapo.handy$);
         if (zuzitapo.oxide$) {
            zuzitapo.handy$.setCurrentItemOrArmor(0, (ItemStack)someone$.get(ThreadLocalRandom.current().nextInt(someone$.size())));
            zuzitapo.oxide$ = false;
         }
      }

      GlStateManager.popMatrix();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      zuzitapo.operator$.thePlayer = null;
      zuzitapo.operator$.theWorld = null;
      FontLoaders.TahomaBold24.drawString("Name : " + zuzitapo.waiting$._modules(), (float)(Client2.surround$.oriented$.mpegs$ + zuzitapo.destroy$ + 8), (float)(Client2.surround$.oriented$.contest$ + 12), -1);
      if (zuzitapo.waiting$ instanceof MicrosoftAccount) {
         FontLoaders.TahomaBold24.drawString("Level : " + zuzitapo.affects$, (float)(Client2.surround$.oriented$.mpegs$ + zuzitapo.destroy$ + 8), (float)(Client2.surround$.oriented$.contest$ + 12 + FontLoaders.TahomaBold24.getHeight() + 4), -1);
         FontLoaders.TahomaBold24.drawString("Rank : " + zuzitapo.bedding$, (float)(Client2.surround$.oriented$.mpegs$ + zuzitapo.destroy$ + 8), (float)(Client2.surround$.oriented$.contest$ + 12 + (FontLoaders.TahomaBold24.getHeight() + 4) * 2), -1);
      }

      if (zuzitapo._auctions()) {
         FontLoaders.TahomaBold24.drawString("Logged in ", (float)(Client2.surround$.oriented$.mpegs$ + zuzitapo.destroy$ + 70), (float)(Client2.surround$.oriented$.contest$ + 12 + FontLoaders.TahomaBold24.getHeight() + 60), HUD.during$.getValue().intValue());
      }

   }

   public void _describe(GameProfile across, ResourceLocation exactly) {
      Object score = Minecraft.getMinecraft();
      mariah.handy$ = new FakeEntityPlayer((GameProfile)across, (ResourceLocation)exactly);
      score.getRenderManager().cacheActiveRenderInfo(mariah.genesis$.worldObj, score.fontRendererObj, mariah.genesis$, mariah.genesis$, score.gameSettings, Float.intBitsToFloat(0));
   }

   public boolean _auctions() {
      return rosodafu.waiting$._modules().equals(rosodafu.operator$.session.getUsername());
   }

   public void _pricing(int tamil, int contents, float papua, int trinity, int chapters, EntityLivingBase months) {
      GlStateManager.disableBlend();
      GlStateManager.depthMask(true);
      GlStateManager.enableDepth();
      GlStateManager.enableAlpha();
      GlStateManager.enableColorMaterial();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.translate((float)tamil, (float)contents, 50.0F);
      GlStateManager.scale((float)(-papua), (float)papua, (float)papua);
      GlStateManager.rotate(180.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0), 1.0F);
      Object optional = ((EntityLivingBase)months).renderYawOffset;
      Object staff = ((EntityLivingBase)months).rotationYaw;
      Object nelson = ((EntityLivingBase)months).rotationPitch;
      Object european = ((EntityLivingBase)months).prevRotationYawHead;
      Object bangkok = ((EntityLivingBase)months).rotationYawHead;
      GlStateManager.rotate(135.0F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      RenderHelper.enableGUIStandardItemLighting();
      GlStateManager.rotate(-135.0F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      GlStateManager.rotate(-((float)Math.atan((double)((float)chapters / 100.0F))) * 20.0F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      ((EntityLivingBase)months).renderYawOffset = (float)Math.atan((double)((float)trinity / 40.0F)) * 20.0F;
      ((EntityLivingBase)months).rotationYaw = (float)Math.atan((double)((float)trinity / 40.0F)) * 40.0F;
      ((EntityLivingBase)months).rotationPitch = -((float)Math.atan((double)((float)chapters / 100.0F))) * 20.0F;
      ((EntityLivingBase)months).rotationYawHead = ((EntityLivingBase)months).rotationYaw;
      ((EntityLivingBase)months).prevRotationYawHead = ((EntityLivingBase)months).rotationYaw;
      GlStateManager.translate(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      Object samsung = Minecraft.getMinecraft().getRenderManager();
      samsung.setPlayerViewY(180.0F);
      samsung.setRenderShadow(false);
      samsung.renderEntityWithPosYaw((Entity)months, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Float.intBitsToFloat(0), 1.0F);
      samsung.setRenderShadow(true);
      ((EntityLivingBase)months).renderYawOffset = optional;
      ((EntityLivingBase)months).rotationYaw = staff;
      ((EntityLivingBase)months).rotationPitch = nelson;
      ((EntityLivingBase)months).prevRotationYawHead = european;
      ((EntityLivingBase)months).rotationYawHead = bangkok;
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableRescaleNormal();
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.disableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
      GlStateManager.translate(Float.intBitsToFloat(0), Float.intBitsToFloat(0), 20.0F);
   }

   public void _areas() {
      Object loyibira = ofurusaz.ruling$ == null;
      Object lomefapi = new WorldSettings((long)2073316379 ^ 2073316379L, GameType.NOT_SET, true, false, WorldType.DEFAULT);
      Object ibafipec = new FakeNetHandlerPlayClient(ofurusaz.operator$);
      if (loyibira) {
         ofurusaz.ruling$ = new FakeWorld(lomefapi, ibafipec);
      }

      if (loyibira || ofurusaz.genesis$ == null) {
         ofurusaz.genesis$ = new EntityPlayerSP(ofurusaz.operator$, ofurusaz.ruling$, ibafipec, (StatFileWriter)null);

         for(EnumPlayerModelParts var5 : ofurusaz.operator$.gameSettings.getModelParts()) {
            ;
         }

         ofurusaz.genesis$.dimension = 0;
         ofurusaz.genesis$.movementInput = new MovementInputFromOptions(ofurusaz.operator$.gameSettings);
      }

      ofurusaz.operator$.getRenderManager().cacheActiveRenderInfo(ofurusaz.ruling$, ofurusaz.operator$.fontRendererObj, ofurusaz.genesis$, ofurusaz.genesis$, ofurusaz.operator$.gameSettings, Float.intBitsToFloat(0));
   }

   public int _delivery() {
      return Client2.surround$.oriented$.mpegs$ + 220 * (gulemava.trail$ - 4) + 5 + 210;
   }

   public Account _eagle() {
      return stories.waiting$;
   }

   public void _battle(boolean ilunapur) {
      fidupali.sacred$ = (boolean)ilunapur;
   }

   public boolean _quarter() {
      return disorder.sacred$;
   }

   public boolean _origin(int yocemufi, int ubibutag) {
      return RenderUtil._become((float)(Client2.surround$.oriented$.mpegs$ + utisopig.destroy$), (float) Client2.surround$.oriented$.contest$, 210.0F, 320.0F, (int)yocemufi, (int)ubibutag);
   }
}
