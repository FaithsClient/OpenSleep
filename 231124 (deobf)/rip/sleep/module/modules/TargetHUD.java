package rip.sleep.module.modules;

import java.awt.Color;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.AttackEntityEvent;
import rip.sleep.event.events.Render2DEventA;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.*;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.NumberValue;

public final class TargetHUD extends Module {
   private final ModeValue c33216 = new ModeValue("Mode", new String[]{"Skid", "Astolfo", "Bingus", "Zenith", "Vape", "Novoline", "Raven", "PowerX", "Stella", "StellaNew", "NeverLose"}, "Astolfo");
   private final ModeValue c81215 = new ModeValue("XYMOD", new String[]{"Chat", "XY"}, "Chat");
   public static BooleanValue c9253 = new BooleanValue("Reset XY", false);
   public static NumberValue<Number> c22574 = new NumberValue<Number>("X", "X", 20.0D, -1000.0D, 1920.0D, 10.0D);
   public static NumberValue<Number> c8241 = new NumberValue<Number>("Y", "Y", 10.0D, -1000.0D, 1080.0D, 10.0D);
   public double c92687;
   private int c92729;
   private int c92911;
   private float c54996 = 0.0F;
   private double c208 = 1.0D;
   private Entity c89432;
   private static int c9668 = 250;
   private static int c34314 = 250;
   DecimalFormat c49989 = new DecimalFormat("##0.0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
   private double c45733;
   private EntityLivingBase c95402;
   private final TimerUtilE c4794 = new TimerUtilE();
   private final TimerUtilE c3799 = new TimerUtilE();
   private boolean c27961;
   public final List<TargetHUD.c18129> c52145 = new ArrayList();
   private final TimerUtilF c1965 = new TimerUtilF();
   private MathUtilE c58706 = new MathUtilE(0.0F, 0.0F);
   private MathUtilE c70238 = new MathUtilE(0.0F, 0.0F);
   public float c80605;
   public float c84231;
   private float c57482 = 0.0F;
   private float c82354 = 0.0F;
   private EntityLivingBase c81310 = null;
   private float c73952 = 0.0F;
   private float c15800 = -1.0F;
   private long c3343;
   double c31223;
   private boolean c9894 = false;
   private long c39283;
   private static final String[] c80829 = new String[]{"N", "NE", "E", "SE", "S", "SW", "W", "NW"};
   private final Pattern c61306 = Pattern.compile("(?i)§[0-9A-FK-ORX]");

   public TargetHUD() {
      super("Target HUD", new String[]{"TargetHUD"}, ModuleType.c12482, ModuleType.c21190.c94221);
   }

   @EventTarget
   public void c47492(AttackEntityEvent var1) {
      this.c89432 = var1.c44489();
   }

   @EventTarget
   public void c82872(Render2DEventA param1) {
      // $FF: Couldn't be decompiled
   }

   public void c16502(float var1) {
      this.c57482 = (float)((double)this.c57482 + (double)(var1 - this.c57482) / Math.pow(2.0D, 0.0D) * (double) RenderUtilF.c75973);
   }

   public static void c1103(double var0, double var2, double var4, double var6, int var8, int var9) {
      float var10 = (float)(var8 >> 24 & 255) / 255.0F;
      float var11 = (float)(var8 >> 16 & 255) / 255.0F;
      float var12 = (float)(var8 >> 8 & 255) / 255.0F;
      float var13 = (float)(var8 & 255) / 255.0F;
      float var14 = (float)(var9 >> 24 & 255) / 255.0F;
      float var15 = (float)(var9 >> 16 & 255) / 255.0F;
      float var16 = (float)(var9 >> 8 & 255) / 255.0F;
      float var17 = (float)(var9 & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glShadeModel(7425);
      GL11.glPushMatrix();
      GL11.glBegin(7);
      GL11.glColor4f(var11, var12, var13, var10);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var0, var6);
      GL11.glColor4f(var15, var16, var17, var14);
      GL11.glVertex2d(var4, var6);
      GL11.glVertex2d(var4, var2);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glShadeModel(7424);
   }

   public void c70337(double var1, double var3, double var5, double var7, double var9, int var11, int var12) {
      this.c93367(var1 + var9, var3 + var9, var5 - var9, var7 - var9, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      this.c93367(var1 + var9, var3, var5 - var9, var3 + var9, var12);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      this.c93367(var1, var3, var1 + var9, var7, var12);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      this.c93367(var5 - var9, var3, var5, var7, var12);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      this.c93367(var1 + var9, var7 - var9, var5 - var9, var7, var12);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public static void c63843(float var0, float var1, float var2, float var3, Color var4) {
      c1832(var0, var1, var2, var3, var4.getRGB());
   }

   public static void c1832(float var0, float var1, float var2, float var3, int var4) {
      RenderUtilD.c50993();
      RenderUtilD.c33760(var4);
      GL11.glBegin(7);
      GL11.glVertex2d((double)var0, (double)var1);
      GL11.glVertex2d((double)(var0 + var2), (double)var1);
      GL11.glVertex2d((double)(var0 + var2), (double)(var1 + var3));
      GL11.glVertex2d((double)var0, (double)(var1 + var3));
      GL11.glEnd();
      RenderUtilD.c87379();
   }

   public void c93367(double var1, double var3, double var5, double var7, int var9) {
      Module[] var10 = Value.c27574();
      if (var1 < var5) {
         double var11 = var1;
         var1 = var5;
         var5 = var11;
      }

      if (var3 < var7) {
         double var18 = var3;
         var3 = var7;
         var7 = var18;
      }

      float var13 = (float)(var9 >> 24 & 255) / 255.0F;
      float var14 = (float)(var9 >> 16 & 255) / 255.0F;
      float var15 = (float)(var9 >> 8 & 255) / 255.0F;
      float var16 = (float)(var9 & 255) / 255.0F;
      WorldRenderer var17 = Tessellator.getInstance().getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(var14, var15, var16, var13);
      var17.begin(7, DefaultVertexFormats.POSITION);
      var17.pos(var1, var7, 0.0D).endVertex();
      var17.pos(var5, var7, 0.0D).endVertex();
      var17.pos(var5, var3, 0.0D).endVertex();
      var17.pos(var1, var3, 0.0D).endVertex();
      Tessellator.getInstance().draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public void c63220(ResourceLocation var1, int var2, int var3, int var4, int var5) {
      mc.getTextureManager().bindTexture(var1);
      c88776((double)var2, (double)var3, 8.0F, 8.0F, 8, 8, (float)var4, (float)var5, 64.0F, 64.0F);
      c88776((double)var2, (double)var3, 40.0F, 8.0F, 8, 8, (float)var4, (float)var5, 64.0F, 64.0F);
   }

   public void c83205() {
      super.c83205();
      this.c95402 = null;
   }

   public void c71897() {
      super.c71897();
   }

   public static void c23677(int var0, int var1, int var2, float var3, float var4, EntityLivingBase var5) {
      GlStateManager.enableColorMaterial();
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)var0, (float)var1, 50.0F);
      GlStateManager.scale((float)(-var2), (float)var2, (float)var2);
      GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
      float var6 = var5.renderYawOffset;
      float var7 = var5.rotationYaw;
      float var8 = var5.rotationPitch;
      float var9 = var5.prevRotationYawHead;
      float var10 = var5.rotationYawHead;
      GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
      RenderHelper.enableStandardItemLighting();
      GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.rotate(-(var4 / 40.0F) * 20.0F, 1.0F, 0.0F, 0.0F);
      var5.renderYawOffset = var3 / 40.0F * 40.0F;
      var5.rotationYaw = var3 / 40.0F * 40.0F;
      var5.rotationPitch = -((float)Math.atan((double)(var4 / 40.0F))) * 20.0F;
      var5.rotationYawHead = var5.rotationYaw;
      var5.prevRotationYawHead = var5.rotationYaw;
      GlStateManager.translate(0.0F, 0.0F, 0.0F);
      RenderManager var11 = Minecraft.getMinecraft().getRenderManager();
      var11.setPlayerViewY(180.0F);
      var11.setRenderShadow(false);
      var11.renderEntityWithPosYaw(var5, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
      var11.setRenderShadow(true);
      var5.renderYawOffset = var6;
      var5.rotationYaw = var7;
      var5.rotationPitch = var8;
      var5.prevRotationYawHead = var9;
      var5.rotationYawHead = var10;
      GlStateManager.popMatrix();
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableRescaleNormal();
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.disableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
   }

   public static void c88776(double var0, double var2, float var4, float var5, int var6, int var7, float var8, float var9, float var10, float var11) {
      float var12 = 1.0F / var10;
      float var13 = 1.0F / var11;
      Tessellator var14 = Tessellator.getInstance();
      WorldRenderer var15 = var14.getWorldRenderer();
      var15.begin(7, DefaultVertexFormats.POSITION_TEX);
      var15.pos(var0, var2 + (double)var9, 0.0D).tex((double)(var4 * var12), (double)((var5 + (float)var7) * var13)).endVertex();
      var15.pos(var0 + (double)var8, var2 + (double)var9, 0.0D).tex((double)((var4 + (float)var6) * var12), (double)((var5 + (float)var7) * var13)).endVertex();
      var15.pos(var0 + (double)var8, var2, 0.0D).tex((double)((var4 + (float)var6) * var12), (double)(var5 * var13)).endVertex();
      var15.pos(var0, var2, 0.0D).tex((double)(var4 * var12), (double)(var5 * var13)).endVertex();
      var14.draw();
   }

   public int c4613(EntityPlayer var1) {
      Value.c27574();
      Iterator var3 = Minecraft.getMinecraft().getNetHandler().getPlayerInfoMap().iterator();
      if (var3.hasNext()) {
         NetworkPlayerInfo var4 = (NetworkPlayerInfo)var3.next();
         if (var4.getGameProfile().getId().equals(var1.getUniqueID())) {
            return var4.getResponseTime();
         }
      }

      return 0;
   }

   public static String c55284(EntityPlayer var0, Entity var1) {
      BlockPos var2 = new BlockPos(var0.posX, var0.posY, var0.posZ);
      BlockPos var3 = new BlockPos(var1.posX, var1.posY, var1.posZ);
      double var4 = Math.atan2((double)(var3.getZ() - var2.getZ()), (double)(var3.getX() - var2.getX())) * 57.29577951308232D + 90.0D;
      int var6 = MathHelper.floor_double(var4 / 45.0D) & 7;
      return c80829[var6];
   }

   private void c27469(String var1, float var2, float var3, int var4) {
      this.c68564(var1, var2, var3, var4);
   }

   public String c75596(String var1) {
      return this.c61306.matcher(var1).replaceAll("");
   }

   public void c68564(String var1, float var2, float var3, int var4) {
      mc.fontRendererObj.drawString(this.c75596(var1), var2 - 0.5F, var3, 0, false);
      mc.fontRendererObj.drawString(this.c75596(var1), var2 + 0.5F, var3, 0, false);
      mc.fontRendererObj.drawString(this.c75596(var1), var2, var3 - 0.5F, 0, false);
      mc.fontRendererObj.drawString(this.c75596(var1), var2, var3 + 0.5F, 0, false);
      mc.fontRendererObj.drawString(var1, var2, var3, var4, false);
   }

   public static int c46389() {
      return c9668;
   }

   public static int c28175() {
      return c34314;
   }

   public static void c95424(int var0) {
      c9668 = var0;
   }

   public static void c88120(int var0) {
      c34314 = var0;
   }

   public static boolean c91289(int var0, int var1) {
      Module[] var2 = Value.c27574();
      return MathUtilB.c23165((double)var0, (double)var1, (double)(c9668 + 110), (double)(c34314 + 70), (double)c9668, (double)(c34314 - 50)) && ModuleManager.c25475(TargetHUD.class).c24622();
   }

   private static Exception c16603(Exception var0) {
      return var0;
   }

   public static class c18129 {
      public float c87671;
      public float c33818;
      public float c40638;
      public float c61769;
      public float c74210;
      public float c40082;
      public float c12158;
      public float c9275;
      public Color c10955;

      public void c13092() {
         ShaderUtilB.c25830(this.c87671 + this.c40638, this.c33818 + this.c61769, this.c12158, this.c12158, this.c12158 / 2.0F - 0.5F, RenderUtilG.c23588(this.c10955, this.c9275 / 255.0F));
      }

      public void c92086() {
         Value.c27574();
         int var2 = 1;
         if (var2 <= 2) {
            this.c40638 += this.c74210;
            this.c61769 += this.c40082;
            this.c40082 = (float)((double)this.c40082 * 0.97D);
            this.c74210 = (float)((double)this.c74210 * 0.97D);
            --this.c9275;
            if (this.c9275 < 1.0F) {
               this.c9275 = 1.0F;
            }

            ++var2;
         }

      }

      public void c93890(float var1, float var2, float var3, float var4, float var5, Color var6) {
         this.c87671 = var1;
         this.c33818 = var2;
         this.c74210 = var3;
         this.c40082 = var4;
         this.c12158 = var5;
         this.c9275 = 254.0F;
         this.c10955 = var6;
      }

      private static JSONException c26029(JSONException var0) {
         return var0;
      }
   }
}
