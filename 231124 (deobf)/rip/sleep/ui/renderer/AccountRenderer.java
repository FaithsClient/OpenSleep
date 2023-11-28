package rip.sleep.ui.renderer;

import com.mojang.authlib.GameProfile;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import rip.sleep.Sleep;
import rip.sleep.interfaces.IAccount;
import rip.sleep.util.RenderUtilA;
import rip.sleep.util.FakeEntityPlayer;

public class AccountRenderer {
   public String c16493 = "None";
   public double c56334 = 1.0D;
   private Minecraft c80357 = Minecraft.getMinecraft();
   private WorldClient c6281;
   private boolean c50940 = true;
   private boolean c73534;
   private EntityPlayerSP c88514;
   private FakeEntityPlayer c67281;
   public IAccount c13273;
   public int c3991;
   public int c96090;
   public int c93133;
   private static final List<ItemStack> c27600 = Arrays.asList(new ItemStack(Items.bow), new ItemStack(Items.iron_sword), new ItemStack(Items.wooden_sword), new ItemStack(Items.stone_pickaxe), new ItemStack(Items.diamond_pickaxe), new ItemStack(Items.iron_ingot), new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.red_flower));

   public AccountRenderer(IAccount var1) {
      this.c13273 = var1;
   }

   public void c47548(int param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   void c97683(GameProfile var1, ResourceLocation var2) {
      Minecraft var3 = Minecraft.getMinecraft();
      this.c67281 = new FakeEntityPlayer(var1, var2);
      var3.getRenderManager().cacheActiveRenderInfo(this.c88514.worldObj, var3.fontRendererObj, this.c88514, this.c88514, var3.gameSettings, 0.0F);
   }

   public boolean c49840() {
      return this.c13273.name().equals(this.c80357.session.getUsername());
   }

   public void c7580(int var1, int var2, float var3, int var4, int var5, EntityLivingBase var6) {
      GlStateManager.disableBlend();
      GlStateManager.depthMask(true);
      GlStateManager.enableDepth();
      GlStateManager.enableAlpha();
      GlStateManager.enableColorMaterial();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.translate((float)var1, (float)var2, 50.0F);
      GlStateManager.scale(-var3, var3, var3);
      GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
      float var7 = var6.renderYawOffset;
      float var8 = var6.rotationYaw;
      float var9 = var6.rotationPitch;
      float var10 = var6.prevRotationYawHead;
      float var11 = var6.rotationYawHead;
      GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
      RenderHelper.enableGUIStandardItemLighting();
      GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.rotate(-((float)Math.atan((double)((float)var5 / 100.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
      var6.renderYawOffset = (float)Math.atan((double)((float)var4 / 40.0F)) * 20.0F;
      var6.rotationYaw = (float)Math.atan((double)((float)var4 / 40.0F)) * 40.0F;
      var6.rotationPitch = -((float)Math.atan((double)((float)var5 / 100.0F))) * 20.0F;
      var6.rotationYawHead = var6.rotationYaw;
      var6.prevRotationYawHead = var6.rotationYaw;
      GlStateManager.translate(0.0F, 0.0F, 0.0F);
      RenderManager var12 = Minecraft.getMinecraft().getRenderManager();
      var12.setPlayerViewY(180.0F);
      var12.setRenderShadow(false);
      var12.renderEntityWithPosYaw(var6, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
      var12.setRenderShadow(true);
      var6.renderYawOffset = var7;
      var6.rotationYaw = var8;
      var6.rotationPitch = var9;
      var6.prevRotationYawHead = var10;
      var6.rotationYawHead = var11;
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableRescaleNormal();
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.disableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
      GlStateManager.translate(0.0F, 0.0F, 20.0F);
   }

   public void c69() {
      // $FF: Couldn't be decompiled
   }

   public int c54801() {
      Sleep var10000 = Sleep.INSTANCE;
      return Sleep.c64898.c27410 + 220 * (this.c93133 - 4) + 5 + 210;
   }

   public IAccount c84348() {
      return this.c13273;
   }

   public void c55914(boolean var1) {
      this.c73534 = var1;
   }

   public boolean c34914() {
      return this.c73534;
   }

   public boolean c50241(int var1, int var2) {
      Sleep var10000 = Sleep.INSTANCE;
      float var3 = (float)(Sleep.c64898.c27410 + this.c3991);
      Sleep var10001 = Sleep.INSTANCE;
      return RenderUtilA.c58363(var3, (float) Sleep.c64898.c50329, 210.0F, 320.0F, var1, var2);
   }

   private static Throwable c52063(Throwable var0) {
      return var0;
   }
}
