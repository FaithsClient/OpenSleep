package rip.sleep.util;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.AxisAlignedBB;
import org.json.JSONException;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;
import rip.sleep.module.Module;
import rip.sleep.value.Value;

public class RenderUtilK {
   public static Minecraft c15530 = Minecraft.getMinecraft();

   public static int c92985() {
      ScaledResolution var0 = new ScaledResolution(c15530);
      return var0.getScaledHeight();
   }

   public static int c87157() {
      ScaledResolution var0 = new ScaledResolution(c15530);
      return var0.getScaledWidth();
   }

   public static void c70471() {
      c89949();
      GL11.glPushAttrib(1048575);
      GL11.glDisable(3008);
      GL11.glDisable(3553);
      GL11.glDisable(2896);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(3.0F);
      GL11.glEnable(2848);
      GL11.glEnable(2960);
      GL11.glClear(1024);
      GL11.glClearStencil(15);
      GL11.glStencilFunc(512, 1, 15);
      GL11.glStencilOp(7681, 7681, 7681);
      GL11.glPolygonMode(1032, 6913);
   }

   public static void c89949() {
      Value.c27574();
      Framebuffer var1 = c15530.getFramebuffer();
      if (var1 != null && var1.depthBuffer > -1) {
         c59138(var1);
         var1.depthBuffer = -1;
      }

   }

   public static void c59138(Framebuffer var0) {
      EXTFramebufferObject.glDeleteRenderbuffersEXT(var0.depthBuffer);
      int var1 = EXTFramebufferObject.glGenRenderbuffersEXT();
      EXTFramebufferObject.glBindRenderbufferEXT(36161, var1);
      EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, c15530.displayWidth, c15530.displayHeight);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, var1);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, var1);
   }

   public static void c3045() {
      GL11.glStencilFunc(512, 0, 15);
      GL11.glStencilOp(7681, 7681, 7681);
      GL11.glPolygonMode(1032, 6914);
   }

   public static void c11286() {
      GL11.glStencilFunc(514, 1, 15);
      GL11.glStencilOp(7680, 7680, 7680);
      GL11.glPolygonMode(1032, 6913);
   }

   public static ScaledResolution c6496() {
      return new ScaledResolution(c15530);
   }

   public static void c37773(int var0) {
      c7127(var0);
      GL11.glDepthMask(false);
      GL11.glDisable(2929);
      GL11.glEnable(10754);
      GL11.glPolygonOffset(1.0F, -2000000.0F);
      OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
   }

   public static int c12664(Entity var0) {
      Value.c27574();
      int var2 = 16777215;
      if (var0 instanceof EntityPlayer) {
         ScorePlayerTeam var3 = (ScorePlayerTeam)((EntityPlayer)var0).getTeam();
         if (var3 != null) {
            String var4 = FontRenderer.getFormatFromString(var3.getColorPrefix());
            if (var4.length() >= 2) {
               if (!"0123456789abcdef".contains(String.valueOf(var4.charAt(1)))) {
                  return var2;
               }

               var2 = c15530.fontRendererObj.getColorCode(var4.charAt(1));
            }
         }
      }

      return var2;
   }

   public static void c66212() {
      GL11.glPolygonOffset(1.0F, 2000000.0F);
      GL11.glDisable(10754);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(2960);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glEnable(3042);
      GL11.glEnable(2896);
      GL11.glEnable(3553);
      GL11.glEnable(3008);
      GL11.glPopAttrib();
   }

   public static void c11383(float var0) {
      GL11.glDisable(3008);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glEnable(2884);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
      GL11.glLineWidth(var0);
   }

   public static void c98337() {
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDisable(3042);
      GL11.glEnable(3008);
      GL11.glDepthMask(true);
      GL11.glCullFace(1029);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
   }

   /** @deprecated */
   @Deprecated
   public static void c60436(float var0, float var1, float var2, float var3, int var4) {
      c93197();
      c99935(var4);
      c55909(var0, var1, var2, var3);
      c11096();
   }

   /** @deprecated */
   @Deprecated
   public static void c51415(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      c93197();
      GL11.glColor4f(var4, var5, var6, var7);
      c55909(var0, var1, var2, var3);
      c11096();
   }

   /** @deprecated */
   @Deprecated
   public static void c55909(float var0, float var1, float var2, float var3) {
      GL11.glBegin(7);
      GL11.glVertex2f(var0, var3);
      GL11.glVertex2f(var2, var3);
      GL11.glVertex2f(var2, var1);
      GL11.glVertex2f(var0, var1);
      GL11.glEnd();
   }

   public static void c31293(float var0, float var1, float var2, float var3, float var4, int var5, int var6) {
      c93197();
      c60436(var0, var1, var2, var3, var5);
      c99935(var6);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(var4);
      GL11.glBegin(3);
      GL11.glVertex2f(var0, var1);
      GL11.glVertex2f(var0, var3);
      GL11.glVertex2f(var2, var3);
      GL11.glVertex2f(var2, var1);
      GL11.glVertex2f(var0, var1);
      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      c11096();
   }

   /** @deprecated */
   @Deprecated
   public static float c91817() {
      ScaledResolution var0 = new ScaledResolution(c15530);
      return (float)var0.getScaleFactor();
   }

   /** @deprecated */
   @Deprecated
   public static int c61396() {
      ScaledResolution var0 = new ScaledResolution(c15530);
      return var0.getScaledWidth();
   }

   /** @deprecated */
   @Deprecated
   public static int c43502() {
      ScaledResolution var0 = new ScaledResolution(c15530);
      return var0.getScaledHeight();
   }

   private static void c87220(ItemStack var0, int var1, int var2) {
      Value.c27574();
      int var4 = var2 - 24;
      if (var0.getEnchantmentTagList() != null && var0.getEnchantmentTagList().tagCount() >= 6) {
         c15530.fontRendererObj.drawStringWithShadow("god", (float)(var1 * 2), (float)var4, 16711680);
      } else {
         if (var0.getItem() instanceof ItemArmor) {
            int var5 = EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, var0);
            int var6 = EnchantmentHelper.getEnchantmentLevel(Enchantment.projectileProtection.effectId, var0);
            int var7 = EnchantmentHelper.getEnchantmentLevel(Enchantment.blastProtection.effectId, var0);
            int var8 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireProtection.effectId, var0);
            int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.thorns.effectId, var0);
            int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, var0);
            if (var5 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("pr" + var5, (float)(var1 * 2), (float)var4, -1052689);
               var4 += 8;
            }

            if (var6 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("pp" + var6, (float)(var1 * 2), (float)var4, -1052689);
               var4 += 8;
            }

            if (var7 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("bp" + var7, (float)(var1 * 2), (float)var4, -1052689);
               var4 += 8;
            }

            if (var8 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("fp" + var8, (float)(var1 * 2), (float)var4, -1052689);
               var4 += 8;
            }

            if (var9 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("t" + var9, (float)(var1 * 2), (float)var4, -1052689);
               var4 += 8;
            }

            if (var10 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("u" + var10, (float)(var1 * 2), (float)var4, -1052689);
               var4 += 8;
            }
         }

         if (var0.getItem() instanceof ItemBow) {
            int var11 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, var0);
            int var14 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, var0);
            int var17 = EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, var0);
            int var20 = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, var0);
            if (var11 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("po" + var11, (float)(var1 * 2), (float)var4, -1052689);
               var4 += 8;
            }

            if (var14 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("pu" + var14, (float)(var1 * 2), (float)var4, -1052689);
               var4 += 8;
            }

            if (var17 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("f" + var17, (float)(var1 * 2), (float)var4, -1052689);
               var4 += 8;
            }

            if (var20 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("u" + var20, (float)(var1 * 2), (float)var4, -1052689);
               var4 += 8;
            }
         }

         if (var0.getItem() instanceof ItemSword) {
            int var12 = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, var0);
            int var15 = EnchantmentHelper.getEnchantmentLevel(Enchantment.knockback.effectId, var0);
            int var18 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, var0);
            int var21 = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, var0);
            if (var12 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("sh" + var12, (float)(var1 * 2), (float)var4, -1052689);
               var4 += 8;
            }

            if (var15 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("kn" + var15, (float)(var1 * 2), (float)var4, -1052689);
               var4 += 8;
            }

            if (var18 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("f" + var18, (float)(var1 * 2), (float)var4, -1052689);
               var4 += 8;
            }

            if (var21 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("ub" + var21, (float)(var1 * 2), (float)var4, -1052689);
            }
         }

         if (var0.getItem() instanceof ItemTool) {
            int var13 = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, var0);
            int var16 = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, var0);
            int var19 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, var0);
            int var22 = EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId, var0);
            if (var16 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("eff" + var16, (float)(var1 * 2), (float)var4, -1052689);
               var4 += 8;
            }

            if (var19 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("fo" + var19, (float)(var1 * 2), (float)var4, -1052689);
               var4 += 8;
            }

            if (var22 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("st" + var22, (float)(var1 * 2), (float)var4, -1052689);
               var4 += 8;
            }

            if (var13 > 0) {
               c15530.fontRendererObj.drawStringWithShadow("ub" + var13, (float)(var1 * 2), (float)var4, -1052689);
            }
         }

         if (var0.getItem() == Items.golden_apple && var0.hasEffect()) {
            c15530.fontRendererObj.drawStringWithShadow("god", (float)(var1 * 2), (float)var4, -1052689);
         }

      }
   }

   public static void c93197() {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glDepthMask(true);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
   }

   public static void c11096() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
   }

   public static void c17659(Color var0) {
      GL11.glColor4f((float)var0.getRed() / 255.0F, (float)var0.getGreen() / 255.0F, (float)var0.getBlue() / 255.0F, (float)var0.getAlpha() / 255.0F);
   }

   public static void c99935(int var0) {
      float var1 = (float)(var0 >> 24 & 255) / 255.0F;
      float var2 = (float)(var0 >> 16 & 255) / 255.0F;
      float var3 = (float)(var0 >> 8 & 255) / 255.0F;
      float var4 = (float)(var0 & 255) / 255.0F;
      GL11.glColor4f(var2, var3, var4, var1);
   }

   public static void c17452(float var0, int var1, int var2, int var3) {
      float var4 = 0.003921569F * (float)var1;
      float var5 = 0.003921569F * (float)var2;
      float var6 = 0.003921569F * (float)var3;
      GL11.glColor4f(var4, var5, var6, var0);
   }

   /** @deprecated */
   @Deprecated
   public static void c29904(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      Gui.drawRect(var0 + var6, var1 + var6, var2 - var6, var3 - var6, var5);
      Gui.drawRect(var0, var1 + 1, var0 + var6, var3 - 1, var4);
      Gui.drawRect(var0 + var6, var1, var2, var1 + var6, var4);
      Gui.drawRect(var0 + var6, var3 - var6, var2, var3, var4);
      Gui.drawRect(var2 - var6, var1 + var6, var2, var3 - var6, var4);
   }

   public static void c20572(double var0, double var2, double var4, double var6) {
      GL11.glBegin(7);
      GL11.glVertex2f((float)var0, (float)var6);
      GL11.glVertex2f((float)var4, (float)var6);
      GL11.glVertex2f((float)var4, (float)var2);
      GL11.glVertex2f((float)var0, (float)var2);
      GL11.glEnd();
   }

   public static int c65368(int var0, float var1) {
      Color var2 = new Color(var0);
      float var3 = 0.003921569F * (float)var2.getRed();
      float var4 = 0.003921569F * (float)var2.getGreen();
      float var5 = 0.003921569F * (float)var2.getBlue();
      return (new Color(var3, var4, var5, var1)).getRGB();
   }

   public static void c122(AxisAlignedBB var0) {
      Tessellator var1 = Tessellator.getInstance();
      WorldRenderer var2 = var1.getWorldRenderer();
      var2.begin(3, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var1.draw();
      var2.begin(3, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var1.draw();
      var2.begin(1, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var1.draw();
   }

   public static void c79788(AxisAlignedBB var0) {
      Tessellator var1 = Tessellator.getInstance();
      WorldRenderer var2 = var1.getWorldRenderer();
      var2.begin(7, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var1.draw();
      var2.begin(7, DefaultVertexFormats.POSITION);
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var1.draw();
      var2.begin(7, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var1.draw();
      var2.begin(7, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var1.draw();
      var2.begin(7, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var1.draw();
      var2.begin(7, DefaultVertexFormats.POSITION);
      var2.pos(var0.minX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.maxZ).endVertex();
      var2.pos(var0.minX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.minX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.minZ).endVertex();
      var2.pos(var0.maxX, var0.maxY, var0.maxZ).endVertex();
      var2.pos(var0.maxX, var0.minY, var0.maxZ).endVertex();
      var1.draw();
   }

   public static void c18753(double var0, double var2, double var4, int var6, int var7, float var8) {
      float var9 = (float)(var6 >> 24 & 255) / 255.0F;
      float var10 = (float)(var6 >> 16 & 255) / 255.0F;
      float var11 = (float)(var6 >> 8 & 255) / 255.0F;
      float var12 = (float)(var6 & 255) / 255.0F;
      float var13 = (float)(var7 >> 24 & 255) / 255.0F;
      float var14 = (float)(var7 >> 16 & 255) / 255.0F;
      float var15 = (float)(var7 >> 8 & 255) / 255.0F;
      float var16 = (float)(var7 & 255) / 255.0F;
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var10, var11, var12, var9);
      c79788(new AxisAlignedBB(var0, var2, var4, var0 + 1.0D, var2 + 1.0D, var4 + 1.0D));
      GL11.glLineWidth(var8);
      GL11.glColor4f(var14, var15, var16, var13);
      c122(new AxisAlignedBB(var0, var2, var4, var0 + 1.0D, var2 + 1.0D, var4 + 1.0D));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c70244(double var0, double var2, double var4, int var6) {
      float var7 = (float)(var6 >> 24 & 255) / 255.0F;
      float var8 = (float)(var6 >> 16 & 255) / 255.0F;
      float var9 = (float)(var6 >> 8 & 255) / 255.0F;
      float var10 = (float)(var6 & 255) / 255.0F;
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var8, var9, var10, var7);
      c79788(new AxisAlignedBB(var0, var2, var4, var0 + 0.1D, var2 + 0.1D, var4 + 0.1D));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c87241(AxisAlignedBB var0, int var1) {
      GL11.glPushMatrix();
      float var2 = (float)(var1 >> 24 & 255) / 255.0F;
      float var3 = (float)(var1 >> 16 & 255) / 255.0F;
      float var4 = (float)(var1 >> 8 & 255) / 255.0F;
      float var5 = (float)(var1 & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(2896);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var2, var3, var4, var5);
      c10747(var0);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2896);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c10747(AxisAlignedBB var0) {
      Module[] var1 = Value.c27574();
      if (var0 != null) {
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glEnd();
      }
   }

   public static void c73094(AxisAlignedBB var0, float var1, int var2) {
      GL11.glPushMatrix();
      float var3 = (float)(var2 >> 24 & 255) / 255.0F;
      float var4 = (float)(var2 >> 16 & 255) / 255.0F;
      float var5 = (float)(var2 >> 8 & 255) / 255.0F;
      float var6 = (float)(var2 & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(2896);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glLineWidth(var1);
      GL11.glColor4f(var3, var4, var5, var6);
      c89927(var0);
      GL11.glLineWidth(1.0F);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2896);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c87681(double var0, double var2, double var4, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var6, var7, var8, var9);
      c79788(new AxisAlignedBB(var0, var2, var4, var0 + 1.0D, var2 + 1.0D, var4 + 1.0D));
      GL11.glLineWidth(var14);
      GL11.glColor4f(var10, var11, var12, var13);
      c122(new AxisAlignedBB(var0, var2, var4, var0 + 1.0D, var2 + 1.0D, var4 + 1.0D));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c27182(double var0, double var2, double var4, float var6, float var7, float var8, float var9, float var10, float var11, float var12, float var13, float var14) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var6, var7, var8, var9);
      c79788(new AxisAlignedBB(var0, var2 + 1.1D, var4, var0 + 1.0D, var2 + 1.0D, var4 + 1.0D));
      GL11.glLineWidth(var14);
      GL11.glColor4f(var10, var11, var12, var13);
      c122(new AxisAlignedBB(var0, var2 + 1.1D, var4, var0 + 1.0D, var2 + 1.0D, var4 + 1.0D));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c87178(double var0, double var2, double var4, float var6, float var7, float var8, float var9) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var6, var7, var8, var9);
      c79788(new AxisAlignedBB(var0, var2, var4, var0 + 1.0D, var2 + 1.0D, var4 + 1.0D));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c82676(double var0, double var2, double var4, Color var6, float var7) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f((float)var6.getRed() / 255.0F, (float)var6.getGreen() / 255.0F, (float)var6.getBlue() / 255.0F, (float)var6.getAlpha() / 255.0F);
      c79788(new AxisAlignedBB(var0, var2, var4, var0 + (double)var7, var2 + (double)var7, var4 + (double)var7));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c32520(double var0, double var2, double var4, double var6, double var8, int var10) {
      GL11.glPushMatrix();
      Value.c27574();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glLineWidth(1.0F);
      float var12 = (float)(var10 >> 24 & 255) / 255.0F;
      float var13 = (float)(var10 >> 16 & 255) / 255.0F;
      float var14 = (float)(var10 >> 8 & 255) / 255.0F;
      float var15 = (float)(var10 & 255) / 255.0F;
      GL11.glColor4f(var13, var14, var15, var12 == 0.0F ? 1.0F : var12);
      c122(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c7127(int var0) {
      Value.c27574();
      float var2 = (float)(var0 >> 24 & 255) / 255.0F;
      float var3 = (float)(var0 >> 16 & 255) / 255.0F;
      float var4 = (float)(var0 >> 8 & 255) / 255.0F;
      float var5 = (float)(var0 & 255) / 255.0F;
      GL11.glColor4f(var3, var4, var5, var2 == 0.0F ? 1.0F : var2);
   }

   public static void c35063(double var0, double var2, double var4, double var6, double var8, float var10, float var11, float var12, float var13) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var10, var11, var12, var13);
      c79788(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c44526(double var0, double var2, double var4, double var6, double var8, float var10, float var11, float var12, float var13, float var14, float var15, float var16, float var17, float var18) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var10, var11, var12, var13);
      c79788(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GL11.glLineWidth(var18);
      GL11.glColor4f(var14, var15, var16, var17);
      c122(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c14501(double var0, double var2, double var4, double var6, double var8, float var10, float var11, float var12, float var13, float var14, float var15, float var16, float var17, float var18) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDepthMask(false);
      GL11.glColor4f(var10, var11, var12, var13);
      c79788(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GL11.glLineWidth(var18);
      GL11.glColor4f(var14, var15, var16, var17);
      c122(new AxisAlignedBB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + var8, var4 + var6));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void c54951(float var0, float var1, float var2, float var3, int var4) {
      c93197();
      c7127(var4);
      Value.c27574();
      GL11.glLineWidth(var3);
      int var6 = (int)Math.min(Math.max(var2, 45.0F), 360.0F);
      GL11.glBegin(2);
      int var7 = 0;
      if (var7 < var6) {
         double var8 = 6.283185307179586D * (double)var7 / (double)var6;
         GL11.glVertex2d((double)var0 + Math.sin(var8) * (double)var2, (double)var1 + Math.cos(var8) * (double)var2);
         ++var7;
      }

      GL11.glEnd();
      c11096();
   }

   public static void c74218(int var0, int var1, double var2, int var4) {
      float var6 = (float)(var4 >> 24 & 255) / 255.0F;
      float var7 = (float)(var4 >> 16 & 255) / 255.0F;
      float var8 = (float)(var4 >> 8 & 255) / 255.0F;
      float var9 = (float)(var4 & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(var7, var8, var9, var6);
      GL11.glBegin(2);
      Value.c27574();
      int var10 = 0;
      if (var10 <= 360) {
         double var11 = Math.sin((double)var10 * 3.141592653589793D / 180.0D) * var2;
         double var13 = Math.cos((double)var10 * 3.141592653589793D / 180.0D) * var2;
         GL11.glVertex2d((double)var0 + var11, (double)var1 + var13);
         ++var10;
      }

      GL11.glEnd();
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
   }

   public static void c26677(float var0, float var1, float var2, int var3) {
      c93197();
      Value.c27574();
      c7127(var3);
      int var5 = (int)Math.min(Math.max(var2, 45.0F), 360.0F);
      GL11.glBegin(9);
      int var6 = 0;
      if (var6 < var5) {
         double var7 = 6.283185307179586D * (double)var6 / (double)var5;
         GL11.glVertex2d((double)var0 + Math.sin(var7) * (double)var2, (double)var1 + Math.cos(var7) * (double)var2);
         ++var6;
      }

      GL11.glEnd();
      c11096();
      c54951(var0, var1, var2, 1.5F, 16777215);
   }

   public static void c86397(int var0, int var1, double var2, int var4) {
      float var6 = (float)(var4 >> 24 & 255) / 255.0F;
      Value.c27574();
      float var7 = (float)(var4 >> 16 & 255) / 255.0F;
      float var8 = (float)(var4 >> 8 & 255) / 255.0F;
      float var9 = (float)(var4 & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(var7, var8, var9, var6);
      GL11.glBegin(6);
      int var10 = 0;
      if (var10 <= 360) {
         double var11 = Math.sin((double)var10 * 3.141592653589793D / 180.0D) * var2;
         double var13 = Math.cos((double)var10 * 3.141592653589793D / 180.0D) * var2;
         GL11.glVertex2d((double)var0 + var11, (double)var1 + var13);
         ++var10;
      }

      GL11.glEnd();
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
   }

   public static void c9118(double var0, double var2, double var4, double var6, int var8) {
      Module[] var9 = Value.c27574();
      if (var0 < var4) {
         double var10 = var0;
         var0 = var4;
         var4 = var10;
      }

      if (var2 < var6) {
         double var16 = var2;
         var2 = var6;
         var6 = var16;
      }

      float var17 = (float)(var8 >> 24 & 255) / 255.0F;
      float var11 = (float)(var8 >> 16 & 255) / 255.0F;
      float var12 = (float)(var8 >> 8 & 255) / 255.0F;
      float var13 = (float)(var8 & 255) / 255.0F;
      Tessellator var14 = Tessellator.getInstance();
      WorldRenderer var15 = var14.getWorldRenderer();
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(var11, var12, var13, var17);
      var15.begin(7, DefaultVertexFormats.POSITION);
      var15.pos(var0, var6, 0.0D);
      var15.pos(var4, var6, 0.0D);
      var15.pos(var4, var2, 0.0D);
      var15.pos(var0, var2, 0.0D);
      var14.draw();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
   }

   public static void c90594(double var0, double var2, double var4, double var6, int var8, int var9) {
      float var10 = (float)(var8 >> 24 & 255) / 255.0F;
      float var11 = (float)(var8 >> 16 & 255) / 255.0F;
      float var12 = (float)(var8 >> 8 & 255) / 255.0F;
      float var13 = (float)(var8 & 255) / 255.0F;
      float var14 = (float)(var9 >> 24 & 255) / 255.0F;
      float var15 = (float)(var9 >> 16 & 255) / 255.0F;
      float var16 = (float)(var9 >> 8 & 255) / 255.0F;
      float var17 = (float)(var9 & 255) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.shadeModel(7425);
      Tessellator var18 = Tessellator.getInstance();
      WorldRenderer var19 = var18.getWorldRenderer();
      var19.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var19.pos(var4, var2, 0.0D).color(var11, var12, var13, var10).endVertex();
      var19.pos(var0, var2, 0.0D).color(var11, var12, var13, var10).endVertex();
      var19.pos(var0, var6, 0.0D).color(var15, var16, var17, var14).endVertex();
      var19.pos(var4, var6, 0.0D).color(var15, var16, var17, var14).endVertex();
      var18.draw();
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
   }

   public static void c30613(float var0, float var1, float var2, float var3, float var4, int var5, int var6) {
      Value.c27574();
      float var8 = (float)(var5 >> 24 & 255) / 255.0F;
      float var9 = (float)(var5 >> 16 & 255) / 255.0F;
      float var10 = (float)(var5 >> 8 & 255) / 255.0F;
      float var11 = (float)(var5 & 255) / 255.0F;
      GlStateManager.pushMatrix();
      c8443((double)var0, (double)var1, (double)var2, (double)var3, new Color(var9, var10, var11, var8));
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(var9, var10, var11, var8);
      if (var4 == 1.0F) {
         GL11.glEnable(2848);
      }

      GL11.glLineWidth(var4);
      Tessellator var12 = Tessellator.getInstance();
      WorldRenderer var13 = var12.getWorldRenderer();
      var13.begin(1, DefaultVertexFormats.POSITION);
      var13.pos((double)var0, (double)var1, 0.0D);
      var13.pos((double)var0, (double)var3, 0.0D);
      var13.pos((double)var2, (double)var3, 0.0D);
      var13.pos((double)var2, (double)var1, 0.0D);
      var13.pos((double)var0, (double)var1, 0.0D);
      var13.pos((double)var2, (double)var1, 0.0D);
      var13.pos((double)var0, (double)var3, 0.0D);
      var13.pos((double)var2, (double)var3, 0.0D);
      var12.draw();
      GL11.glLineWidth(2.0F);
      if (var4 == 1.0F) {
         GL11.glDisable(2848);
      }

      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.popMatrix();
   }

   public static void c8443(double var0, double var2, double var4, double var6, Color var8) {
      c93197();
      c17659(var8);
      c20572(var0, var2, var4, var6);
      c11096();
   }

   public static void c32171(double var0, double var2, double var4, double var6, int var8) {
      c93197();
      c99935(var8);
      c20572(var0, var2, var4, var6);
      c11096();
   }

   public static void c18242(double var0, double var2, double var4, double var6, float var8, int var9, int var10, int var11) {
      float var13 = (float)(var9 >> 24 & 255) / 255.0F;
      float var14 = (float)(var9 >> 16 & 255) / 255.0F;
      Value.c27574();
      float var15 = (float)(var9 >> 8 & 255) / 255.0F;
      float var16 = (float)(var9 & 255) / 255.0F;
      GlStateManager.pushMatrix();
      c90594(var0, var2, var4, var6, var10, var11);
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(var14, var15, var16, var13);
      if (var8 == 1.0F) {
         GL11.glEnable(2848);
      }

      GL11.glLineWidth(var8);
      Tessellator var17 = Tessellator.getInstance();
      WorldRenderer var18 = var17.getWorldRenderer();
      var18.begin(1, DefaultVertexFormats.POSITION);
      var18.pos(var0, var2, 0.0D);
      var18.pos(var0, var6, 0.0D);
      var18.pos(var4, var6, 0.0D);
      var18.pos(var4, var2, 0.0D);
      var18.pos(var0, var2, 0.0D);
      var18.pos(var4, var2, 0.0D);
      var18.pos(var0, var6, 0.0D);
      var18.pos(var4, var6, 0.0D);
      var17.draw();
      GL11.glLineWidth(2.0F);
      if (var8 == 1.0F) {
         GL11.glDisable(2848);
      }

      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.popMatrix();
   }

   public static double c53027(double var0, double var2, float var4, double var5) {
      return var0 + (var2 - var0) * (double)var4 - var5;
   }

   public static void c84886(Entity var0, double var1, double var3, double var5, int var7, int var8) {
      GlStateManager.pushMatrix();
      Value.c27574();
      GL11.glLineWidth(1.0F);
      AxisAlignedBB var10 = var0.getEntityBoundingBox();
      AxisAlignedBB var11 = new AxisAlignedBB(var10.minX - var0.posX + var1, var10.minY - var0.posY + var3, var10.minZ - var0.posZ + var5, var10.maxX - var0.posX + var1, var10.maxY - var0.posY + var3, var10.maxZ - var0.posZ + var5);
      GlStateManager.disableDepth();
      c76029(var11, var8, true);
      GlStateManager.disableLighting();
      int[] var12 = RenderUtilK.c53516.c48898(var7);
      GlStateManager.popMatrix();
   }

   public static void c76029(AxisAlignedBB var0, int var1, boolean var2) {
      GlStateManager.pushMatrix();
      Value.c27574();
      float var4 = (float)(var1 >> 24 & 255) / 255.0F;
      float var5 = (float)(var1 >> 16 & 255) / 255.0F;
      float var6 = (float)(var1 >> 8 & 255) / 255.0F;
      float var7 = (float)(var1 & 255) / 255.0F;
      WorldRenderer var8 = Tessellator.getInstance().getWorldRenderer();
      if (var2) {
         GlStateManager.color(var5, var6, var7, var4);
      }

      boolean var9 = true;
      var8.begin(7, DefaultVertexFormats.POSITION);
      var8.pos(var0.minX, var0.minY, var0.minZ);
      var8.pos(var0.minX, var0.maxY, var0.minZ);
      var8.pos(var0.maxX, var0.minY, var0.minZ);
      var8.pos(var0.maxX, var0.maxY, var0.minZ);
      var8.pos(var0.maxX, var0.minY, var0.maxZ);
      var8.pos(var0.maxX, var0.maxY, var0.maxZ);
      var8.pos(var0.minX, var0.minY, var0.maxZ);
      var8.pos(var0.minX, var0.maxY, var0.maxZ);
      Tessellator.getInstance().draw();
      var8.begin(7, DefaultVertexFormats.POSITION);
      var8.pos(var0.maxX, var0.maxY, var0.minZ);
      var8.pos(var0.maxX, var0.minY, var0.minZ);
      var8.pos(var0.minX, var0.maxY, var0.minZ);
      var8.pos(var0.minX, var0.minY, var0.minZ);
      var8.pos(var0.minX, var0.maxY, var0.maxZ);
      var8.pos(var0.minX, var0.minY, var0.maxZ);
      var8.pos(var0.maxX, var0.maxY, var0.maxZ);
      var8.pos(var0.maxX, var0.minY, var0.maxZ);
      Tessellator.getInstance().draw();
      var8.begin(7, DefaultVertexFormats.POSITION);
      var8.pos(var0.minX, var0.maxY, var0.minZ);
      var8.pos(var0.maxX, var0.maxY, var0.minZ);
      var8.pos(var0.maxX, var0.maxY, var0.maxZ);
      var8.pos(var0.minX, var0.maxY, var0.maxZ);
      var8.pos(var0.minX, var0.maxY, var0.minZ);
      var8.pos(var0.minX, var0.maxY, var0.maxZ);
      var8.pos(var0.maxX, var0.maxY, var0.maxZ);
      var8.pos(var0.maxX, var0.maxY, var0.minZ);
      Tessellator.getInstance().draw();
      var8.begin(7, DefaultVertexFormats.POSITION);
      var8.pos(var0.minX, var0.minY, var0.minZ);
      var8.pos(var0.maxX, var0.minY, var0.minZ);
      var8.pos(var0.maxX, var0.minY, var0.maxZ);
      var8.pos(var0.minX, var0.minY, var0.maxZ);
      var8.pos(var0.minX, var0.minY, var0.minZ);
      var8.pos(var0.minX, var0.minY, var0.maxZ);
      var8.pos(var0.maxX, var0.minY, var0.maxZ);
      var8.pos(var0.maxX, var0.minY, var0.minZ);
      Tessellator.getInstance().draw();
      var8.begin(7, DefaultVertexFormats.POSITION);
      var8.pos(var0.minX, var0.minY, var0.minZ);
      var8.pos(var0.minX, var0.maxY, var0.minZ);
      var8.pos(var0.minX, var0.minY, var0.maxZ);
      var8.pos(var0.minX, var0.maxY, var0.maxZ);
      var8.pos(var0.maxX, var0.minY, var0.maxZ);
      var8.pos(var0.maxX, var0.maxY, var0.maxZ);
      var8.pos(var0.maxX, var0.minY, var0.minZ);
      var8.pos(var0.maxX, var0.maxY, var0.minZ);
      Tessellator.getInstance().draw();
      var8.begin(7, DefaultVertexFormats.POSITION);
      var8.pos(var0.minX, var0.maxY, var0.maxZ);
      var8.pos(var0.minX, var0.minY, var0.maxZ);
      var8.pos(var0.minX, var0.maxY, var0.minZ);
      var8.pos(var0.minX, var0.minY, var0.minZ);
      var8.pos(var0.maxX, var0.maxY, var0.minZ);
      var8.pos(var0.maxX, var0.minY, var0.minZ);
      var8.pos(var0.maxX, var0.maxY, var0.maxZ);
      var8.pos(var0.maxX, var0.minY, var0.maxZ);
      Tessellator.getInstance().draw();
      GlStateManager.depthMask(true);
      GlStateManager.popMatrix();
      if (Module.c12876() == null) {
         Value.c96815(new Module[3]);
      }

   }

   public static void c26443(float var0, float var1, float var2, float var3, int var4, int var5) {
      c30613(var0, var1, var2, var3, 1.0F, var4, var5);
   }

   public static void c15168(double var0, double var2, double var4, double var6, int var8, int var9, int var10) {
      c18242(var0, var2, var4, var6, 1.0F, var8, var9, var10);
   }

   public static void c48035(EntityLivingBase var0, int var1, double var2, double var4, double var6) {
      GL11.glPushMatrix();
      GL11.glTranslated(var2, var4, var6);
      GL11.glRotatef(-var0.rotationYaw, 0.0F, 1.0F, 0.0F);
      c7127(var1);
      c11383(1.0F);
      Cylinder var8 = new Cylinder();
      GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
      var8.setDrawStyle(100011);
      var8.draw(0.5F, 0.5F, var0.height + 0.1F, 18, 1);
      c98337();
      GL11.glPopMatrix();
   }

   public static void c34605(int var0, double var1, double var3, double var5) {
      AxisAlignedBB var7 = new AxisAlignedBB(var1 - 0.4D, var3, var5 - 0.4D, var1 + 0.4D, var3 + 2.0D, var5 + 0.4D);
      GlStateManager.pushMatrix();
      GlStateManager.translate(var1, var3, var5);
      GlStateManager.translate(-var1, -var3, -var5);
      c11383(1.0F);
      c7127(var0);
      c122(var7);
      c98337();
      GlStateManager.popMatrix();
   }

   public static void c89927(AxisAlignedBB var0) {
      Module[] var1 = Value.c27574();
      if (var0 != null) {
         GL11.glBegin(3);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(3);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glEnd();
         GL11.glBegin(1);
         GL11.glVertex3d(var0.minX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.minZ);
         GL11.glVertex3d(var0.maxX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.maxX, var0.maxY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.minY, var0.maxZ);
         GL11.glVertex3d(var0.minX, var0.maxY, var0.maxZ);
         GL11.glEnd();
      }

   }

   public static void c1031(int var0, double var1, double var3, double var5) {
      GL11.glPushMatrix();
      c11383(2.0F);
      c7127((new Color(255, 0, 0)).getRGB());
      GL11.glBegin(2);
      GL11.glVertex3d(0.0D, (double)c15530.thePlayer.getEyeHeight(), 0.0D);
      GL11.glVertex3d(var1, var3, var5);
      GL11.glEnd();
      c98337();
      GL11.glPopMatrix();
   }

   public static void c38518(double var0, double var2, double var4, double var6, float var8, int var9) {
      GL11.glEnable(3042);
      GL11.glDisable(2884);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(1.0F);
      c7127(var9);
      GL11.glLineWidth(var8);
      GL11.glBegin(1);
      GL11.glVertex2d(var0, var2);
      GL11.glVertex2d(var4, var6);
      GL11.glEnd();
      GL11.glDisable(3042);
      GL11.glEnable(2884);
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableTexture2D();
   }

   private static JSONException c24634(JSONException var0) {
      return var0;
   }

   public static class c53516 {
      public int c33607(int var1, int var2, int var3, int var4) {
         return (var4 << 24) + (var1 << 16) + (var2 << 8) + var3;
      }

      public Color c29028(long var1, float var3) {
         float var4 = (float)(System.nanoTime() + var1) / 5.0E9F % 1.0F;
         long var5 = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(var4, 1.0F, 1.0F).intValue()), 16);
         Color var7 = new Color((int)var5);
         return new Color((float)var7.getRed() / 255.0F * var3, (float)var7.getGreen() / 255.0F * var3, (float)var7.getBlue() / 255.0F * var3, (float)var7.getAlpha() / 255.0F);
      }

      public static Color c60724(int var0, float var1) {
         float var2 = (float)(var0 >> 16 & 255) / 255.0F;
         float var3 = (float)(var0 >> 8 & 255) / 255.0F;
         float var4 = (float)(var0 & 255) / 255.0F;
         GL11.glColor4f(var2, var3, var4, var1);
         return new Color(var2, var3, var4, var1);
      }

      public void c98249(Color var1) {
         GL11.glColor4f((float)var1.getRed() / 255.0F, (float)var1.getGreen() / 255.0F, (float)var1.getBlue() / 255.0F, (float)var1.getAlpha() / 255.0F);
      }

      public Color c98875(int var1) {
         float var2 = (float)(var1 >> 24 & 255) / 256.0F;
         float var3 = (float)(var1 >> 16 & 255) / 255.0F;
         float var4 = (float)(var1 >> 8 & 255) / 255.0F;
         float var5 = (float)(var1 & 255) / 255.0F;
         GL11.glColor4f(var3, var4, var5, var2);
         return new Color(var3, var4, var5, var2);
      }

      public Color c75572(float var1, int var2, int var3, int var4) {
         float var5 = 0.003921569F * (float)var2;
         float var6 = 0.003921569F * (float)var3;
         float var7 = 0.003921569F * (float)var4;
         GL11.glColor4f(var5, var6, var7, var1);
         return new Color(var5, var6, var7, var1);
      }

      public static int c81662(int var0, double var1) {
         Color var3 = new Color(var0);
         float var4 = 0.003921569F * (float)var3.getRed();
         float var5 = 0.003921569F * (float)var3.getGreen();
         float var6 = 0.003921569F * (float)var3.getBlue();
         return (new Color(var4, var5, var6, (float)var1)).getRGB();
      }

      public static float[] c827(int var0) {
         float var1 = (float)(var0 >> 24 & 255) / 255.0F;
         float var2 = (float)(var0 >> 16 & 255) / 255.0F;
         float var3 = (float)(var0 >> 8 & 255) / 255.0F;
         float var4 = (float)(var0 & 255) / 255.0F;
         return new float[]{var2, var3, var4, var1};
      }

      public static int[] c48898(int var0) {
         int var1 = var0 >> 24 & 255;
         int var2 = var0 >> 16 & 255;
         int var3 = var0 >> 8 & 255;
         int var4 = var0 & 255;
         return new int[]{var2, var3, var4, var1};
      }

      public static int c29954(String var0) {
         String var10000 = var0;
         byte var10001 = 15;

         try {
            return Integer.parseInt(var10000, var10001);
         } catch (NumberFormatException var2) {
            return -1;
         }
      }

      public static String c34161(int var0) {
         return c61288(new Color(var0));
      }

      public static String c61288(Color var0) {
         return Integer.toHexString(var0.getRGB()).substring(2);
      }
   }
}
