//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.util.render;

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
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;

public class WorldRenderUtils {
   public static Minecraft marco$ = Minecraft.getMinecraft();

   public static int _acute() {
      Object nufiliga = new ScaledResolution(marco$);
      return nufiliga.getScaledHeight();
   }

   public static int _london() {
      Object mirrors = new ScaledResolution(marco$);
      return mirrors.getScaledWidth();
   }

   public static void _metres() {
      _strips();
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

   public static void _strips() {
      Object ragotopo = marco$.getFramebuffer();
      if (ragotopo != null && ragotopo.depthBuffer > -1) {
         _sandy(ragotopo);
         ragotopo.depthBuffer = -1;
      }

   }

   public static void _sandy(Framebuffer utirifib) {
      EXTFramebufferObject.glDeleteRenderbuffersEXT(((Framebuffer)utirifib).depthBuffer);
      Object oyoradum = EXTFramebufferObject.glGenRenderbuffersEXT();
      EXTFramebufferObject.glBindRenderbufferEXT(36161, oyoradum);
      EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, marco$.displayWidth, marco$.displayHeight);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, oyoradum);
      EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, oyoradum);
   }

   public static void _arena() {
      GL11.glStencilFunc(512, 0, 15);
      GL11.glStencilOp(7681, 7681, 7681);
      GL11.glPolygonMode(1032, 6914);
   }

   public static void _great() {
      GL11.glStencilFunc(514, 1, 15);
      GL11.glStencilOp(7680, 7680, 7680);
      GL11.glPolygonMode(1032, 6913);
   }

   public static ScaledResolution _protest() {
      return new ScaledResolution(marco$);
   }

   public static void _climate(int iyofibud) {
      _bearing((int)iyofibud);
      GL11.glDepthMask(false);
      GL11.glDisable(2929);
      GL11.glEnable(10754);
      GL11.glPolygonOffset(1.0F, -2000000.0F);
      OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
   }

   public static int _reaches(Entity irasucas) {
      Object azalimug = 16777215;
      if (irasucas instanceof EntityPlayer) {
         Object cadopuda = (ScorePlayerTeam)((EntityPlayer)irasucas).getTeam();
         if (cadopuda != null) {
            Object mitubivu = FontRenderer.getFormatFromString(cadopuda.getColorPrefix());
            if (mitubivu.length() >= 2) {
               if (!"0123456789abcdef".contains(String.valueOf(mitubivu.charAt(1)))) {
                  return azalimug;
               }

               azalimug = marco$.fontRendererObj.getColorCode(mitubivu.charAt(1));
            }
         }
      }

      return azalimug;
   }

   public static void _collar() {
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

   public static void _compiler(float evunopil) {
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
      GL11.glLineWidth((float)evunopil);
   }

   public static void _resumes() {
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
   public static void _foods(float realm, float seeds, float imaging, float burke, int spend) {
      _winston();
      _prefer((int)spend);
      _ashley((float)realm, (float)seeds, (float)imaging, (float)burke);
      _outlet();
   }

   /** @deprecated */
   @Deprecated
   public static void _working(float recover, float fashion, float camping, float livecam, float ultram, float decor, float check, float luggage) {
      _winston();
      GL11.glColor4f((float)ultram, (float)decor, (float)check, (float)luggage);
      _ashley((float)recover, (float)fashion, (float)camping, (float)livecam);
      _outlet();
   }

   /** @deprecated */
   @Deprecated
   public static void _ashley(float ucileyan, float terotinu, float venegobi, float urosoped) {
      GL11.glBegin(7);
      GL11.glVertex2f((float)ucileyan, (float)urosoped);
      GL11.glVertex2f((float)venegobi, (float)urosoped);
      GL11.glVertex2f((float)venegobi, (float)terotinu);
      GL11.glVertex2f((float)ucileyan, (float)terotinu);
      GL11.glEnd();
   }

   public static void _camps(float onedenid, float oluposim, float mabeyova, float fudocopa, float ayemanof, int ugolafov, int moyudure) {
      _winston();
      _foods((float)onedenid, (float)oluposim, (float)mabeyova, (float)fudocopa, (int)ugolafov);
      _prefer((int)moyudure);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth((float)ayemanof);
      GL11.glBegin(3);
      GL11.glVertex2f((float)onedenid, (float)oluposim);
      GL11.glVertex2f((float)onedenid, (float)fudocopa);
      GL11.glVertex2f((float)mabeyova, (float)fudocopa);
      GL11.glVertex2f((float)mabeyova, (float)oluposim);
      GL11.glVertex2f((float)onedenid, (float)oluposim);
      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      _outlet();
   }

   /** @deprecated */
   @Deprecated
   public static float _bathroom() {
      Object lepucubu = new ScaledResolution(marco$);
      return (float)lepucubu.getScaleFactor();
   }

   /** @deprecated */
   @Deprecated
   public static int _fares() {
      Object enetabor = new ScaledResolution(marco$);
      return enetabor.getScaledWidth();
   }

   /** @deprecated */
   @Deprecated
   public static int _board() {
      Object beceguro = new ScaledResolution(marco$);
      return beceguro.getScaledHeight();
   }

   public static void _labeled(ItemStack claims, int portable, int hebrew) {
      Object entities = hebrew - 24;
      if (((ItemStack)claims).getEnchantmentTagList() != null && ((ItemStack)claims).getEnchantmentTagList().tagCount() >= 6) {
         marco$.fontRendererObj.drawStringWithShadow("god", (float)(portable * 2), (float)entities, 16711680);
      } else {
         if (((ItemStack)claims).getItem() instanceof ItemArmor) {
            Object refers = EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, (ItemStack)claims);
            Object lexmark = EnchantmentHelper.getEnchantmentLevel(Enchantment.projectileProtection.effectId, (ItemStack)claims);
            Object stones = EnchantmentHelper.getEnchantmentLevel(Enchantment.blastProtection.effectId, (ItemStack)claims);
            Object seeing = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireProtection.effectId, (ItemStack)claims);
            Object salmon = EnchantmentHelper.getEnchantmentLevel(Enchantment.thorns.effectId, (ItemStack)claims);
            Object peoples = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, (ItemStack)claims);
            if (refers > 0) {
               marco$.fontRendererObj.drawStringWithShadow("pr" + refers, (float)(portable * 2), (float)entities, -1052689);
               entities += 8;
            }

            if (lexmark > 0) {
               marco$.fontRendererObj.drawStringWithShadow("pp" + lexmark, (float)(portable * 2), (float)entities, -1052689);
               entities += 8;
            }

            if (stones > 0) {
               marco$.fontRendererObj.drawStringWithShadow("bp" + stones, (float)(portable * 2), (float)entities, -1052689);
               entities += 8;
            }

            if (seeing > 0) {
               marco$.fontRendererObj.drawStringWithShadow("fp" + seeing, (float)(portable * 2), (float)entities, -1052689);
               entities += 8;
            }

            if (salmon > 0) {
               marco$.fontRendererObj.drawStringWithShadow("t" + salmon, (float)(portable * 2), (float)entities, -1052689);
               entities += 8;
            }

            if (peoples > 0) {
               marco$.fontRendererObj.drawStringWithShadow("u" + peoples, (float)(portable * 2), (float)entities, -1052689);
               entities += 8;
            }
         }

         if (((ItemStack)claims).getItem() instanceof ItemBow) {
            Object var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, (ItemStack)claims);
            Object var13 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, (ItemStack)claims);
            Object var16 = EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, (ItemStack)claims);
            Object var19 = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, (ItemStack)claims);
            if (var10 > 0) {
               marco$.fontRendererObj.drawStringWithShadow("po" + var10, (float)(portable * 2), (float)entities, -1052689);
               entities += 8;
            }

            if (var13 > 0) {
               marco$.fontRendererObj.drawStringWithShadow("pu" + var13, (float)(portable * 2), (float)entities, -1052689);
               entities += 8;
            }

            if (var16 > 0) {
               marco$.fontRendererObj.drawStringWithShadow("f" + var16, (float)(portable * 2), (float)entities, -1052689);
               entities += 8;
            }

            if (var19 > 0) {
               marco$.fontRendererObj.drawStringWithShadow("u" + var19, (float)(portable * 2), (float)entities, -1052689);
               entities += 8;
            }
         }

         if (((ItemStack)claims).getItem() instanceof ItemSword) {
            Object var11 = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, (ItemStack)claims);
            Object var14 = EnchantmentHelper.getEnchantmentLevel(Enchantment.knockback.effectId, (ItemStack)claims);
            Object var17 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, (ItemStack)claims);
            Object var20 = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, (ItemStack)claims);
            if (var11 > 0) {
               marco$.fontRendererObj.drawStringWithShadow("sh" + var11, (float)(portable * 2), (float)entities, -1052689);
               entities += 8;
            }

            if (var14 > 0) {
               marco$.fontRendererObj.drawStringWithShadow("kn" + var14, (float)(portable * 2), (float)entities, -1052689);
               entities += 8;
            }

            if (var17 > 0) {
               marco$.fontRendererObj.drawStringWithShadow("f" + var17, (float)(portable * 2), (float)entities, -1052689);
               entities += 8;
            }

            if (var20 > 0) {
               marco$.fontRendererObj.drawStringWithShadow("ub" + var20, (float)(portable * 2), (float)entities, -1052689);
            }
         }

         if (((ItemStack)claims).getItem() instanceof ItemTool) {
            Object var12 = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, (ItemStack)claims);
            Object var15 = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, (ItemStack)claims);
            Object var18 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, (ItemStack)claims);
            Object var21 = EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId, (ItemStack)claims);
            if (var15 > 0) {
               marco$.fontRendererObj.drawStringWithShadow("eff" + var15, (float)(portable * 2), (float)entities, -1052689);
               entities += 8;
            }

            if (var18 > 0) {
               marco$.fontRendererObj.drawStringWithShadow("fo" + var18, (float)(portable * 2), (float)entities, -1052689);
               entities += 8;
            }

            if (var21 > 0) {
               marco$.fontRendererObj.drawStringWithShadow("st" + var21, (float)(portable * 2), (float)entities, -1052689);
               entities += 8;
            }

            if (var12 > 0) {
               marco$.fontRendererObj.drawStringWithShadow("ub" + var12, (float)(portable * 2), (float)entities, -1052689);
            }
         }

         if (((ItemStack)claims).getItem() == Items.golden_apple && ((ItemStack)claims).hasEffect()) {
            marco$.fontRendererObj.drawStringWithShadow("god", (float)(portable * 2), (float)entities, -1052689);
         }

      }
   }

   public static void _winston() {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glDepthMask(true);
      GL11.glEnable(2848);
      GL11.glHint(3154, 4354);
      GL11.glHint(3155, 4354);
   }

   public static void _outlet() {
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      GL11.glDisable(2848);
      GL11.glHint(3154, 4352);
      GL11.glHint(3155, 4352);
   }

   public static void _layers(Color draws) {
      GL11.glColor4f((float)((Color)draws).getRed() / 255.0F, (float)((Color)draws).getGreen() / 255.0F, (float)((Color)draws).getBlue() / 255.0F, (float)((Color)draws).getAlpha() / 255.0F);
   }

   public static void _prefer(int about) {
      Object pupils = (float)(about >> 24 & 255) / 255.0F;
      Object stand = (float)(about >> 16 & 255) / 255.0F;
      Object washer = (float)(about >> 8 & 255) / 255.0F;
      Object angeles = (float)(about & 255) / 255.0F;
      GL11.glColor4f(stand, washer, angeles, pupils);
   }

   public static void _arrived(float cazonere, int gabopage, int atuyiziz, int residogo) {
      Object abeyafuc = 0.003921569F * (float)gabopage;
      Object omeyugod = 0.003921569F * (float)atuyiziz;
      Object ecusecob = 0.003921569F * (float)residogo;
      GL11.glColor4f(abeyafuc, omeyugod, ecusecob, (float)cazonere);
   }

   /** @deprecated */
   @Deprecated
   public static void _kruger(int dozuvelo, int reviyobu, int urigogeg, int vigaciyu, int egacefol, int nizumace, int eyacosit) {
      Gui.drawRect(dozuvelo + eyacosit, reviyobu + eyacosit, urigogeg - eyacosit, vigaciyu - eyacosit, (int)nizumace);
      Gui.drawRect((int)dozuvelo, reviyobu + 1, dozuvelo + eyacosit, vigaciyu - 1, (int)egacefol);
      Gui.drawRect(dozuvelo + eyacosit, (int)reviyobu, (int)urigogeg, reviyobu + eyacosit, (int)egacefol);
      Gui.drawRect(dozuvelo + eyacosit, vigaciyu - eyacosit, (int)urigogeg, (int)vigaciyu, (int)egacefol);
      Gui.drawRect(urigogeg - eyacosit, reviyobu + eyacosit, (int)urigogeg, vigaciyu - eyacosit, (int)egacefol);
   }

   public static void _pound(double panel, double business, double var4, double var6) {
      GL11.glBegin(7);
      GL11.glVertex2f((float)panel, (float)var6);
      GL11.glVertex2f((float)var4, (float)var6);
      GL11.glVertex2f((float)var4, (float)business);
      GL11.glVertex2f((float)panel, (float)business);
      GL11.glEnd();
   }

   public static int _fully(int colleges, float hitachi) {
      Object flash = new Color((int)colleges);
      Object inquiry = 0.003921569F * (float)flash.getRed();
      Object brisbane = 0.003921569F * (float)flash.getGreen();
      Object remember = 0.003921569F * (float)flash.getBlue();
      return (new Color(inquiry, brisbane, remember, (float)hitachi)).getRGB();
   }

   public static void _angels(AxisAlignedBB thick) {
      Object mixer = Tessellator.getInstance();
      Object sellers = mixer.getWorldRenderer();
      sellers.begin(3, DefaultVertexFormats.POSITION);
      sellers.pos(((AxisAlignedBB)thick).minX, ((AxisAlignedBB)thick).minY, ((AxisAlignedBB)thick).minZ).endVertex();
      sellers.pos(((AxisAlignedBB)thick).maxX, ((AxisAlignedBB)thick).minY, ((AxisAlignedBB)thick).minZ).endVertex();
      sellers.pos(((AxisAlignedBB)thick).maxX, ((AxisAlignedBB)thick).minY, ((AxisAlignedBB)thick).maxZ).endVertex();
      sellers.pos(((AxisAlignedBB)thick).minX, ((AxisAlignedBB)thick).minY, ((AxisAlignedBB)thick).maxZ).endVertex();
      sellers.pos(((AxisAlignedBB)thick).minX, ((AxisAlignedBB)thick).minY, ((AxisAlignedBB)thick).minZ).endVertex();
      mixer.draw();
      sellers.begin(3, DefaultVertexFormats.POSITION);
      sellers.pos(((AxisAlignedBB)thick).minX, ((AxisAlignedBB)thick).maxY, ((AxisAlignedBB)thick).minZ).endVertex();
      sellers.pos(((AxisAlignedBB)thick).maxX, ((AxisAlignedBB)thick).maxY, ((AxisAlignedBB)thick).minZ).endVertex();
      sellers.pos(((AxisAlignedBB)thick).maxX, ((AxisAlignedBB)thick).maxY, ((AxisAlignedBB)thick).maxZ).endVertex();
      sellers.pos(((AxisAlignedBB)thick).minX, ((AxisAlignedBB)thick).maxY, ((AxisAlignedBB)thick).maxZ).endVertex();
      sellers.pos(((AxisAlignedBB)thick).minX, ((AxisAlignedBB)thick).maxY, ((AxisAlignedBB)thick).minZ).endVertex();
      mixer.draw();
      sellers.begin(1, DefaultVertexFormats.POSITION);
      sellers.pos(((AxisAlignedBB)thick).minX, ((AxisAlignedBB)thick).minY, ((AxisAlignedBB)thick).minZ).endVertex();
      sellers.pos(((AxisAlignedBB)thick).minX, ((AxisAlignedBB)thick).maxY, ((AxisAlignedBB)thick).minZ).endVertex();
      sellers.pos(((AxisAlignedBB)thick).maxX, ((AxisAlignedBB)thick).minY, ((AxisAlignedBB)thick).minZ).endVertex();
      sellers.pos(((AxisAlignedBB)thick).maxX, ((AxisAlignedBB)thick).maxY, ((AxisAlignedBB)thick).minZ).endVertex();
      sellers.pos(((AxisAlignedBB)thick).maxX, ((AxisAlignedBB)thick).minY, ((AxisAlignedBB)thick).maxZ).endVertex();
      sellers.pos(((AxisAlignedBB)thick).maxX, ((AxisAlignedBB)thick).maxY, ((AxisAlignedBB)thick).maxZ).endVertex();
      sellers.pos(((AxisAlignedBB)thick).minX, ((AxisAlignedBB)thick).minY, ((AxisAlignedBB)thick).maxZ).endVertex();
      sellers.pos(((AxisAlignedBB)thick).minX, ((AxisAlignedBB)thick).maxY, ((AxisAlignedBB)thick).maxZ).endVertex();
      mixer.draw();
   }

   public static void _between(AxisAlignedBB afemogud) {
      Object fatusoyi = Tessellator.getInstance();
      Object yemeguna = fatusoyi.getWorldRenderer();
      yemeguna.begin(7, DefaultVertexFormats.POSITION);
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      fatusoyi.draw();
      yemeguna.begin(7, DefaultVertexFormats.POSITION);
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      fatusoyi.draw();
      yemeguna.begin(7, DefaultVertexFormats.POSITION);
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      fatusoyi.draw();
      yemeguna.begin(7, DefaultVertexFormats.POSITION);
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      fatusoyi.draw();
      yemeguna.begin(7, DefaultVertexFormats.POSITION);
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      fatusoyi.draw();
      yemeguna.begin(7, DefaultVertexFormats.POSITION);
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).minX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).minZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).maxY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      yemeguna.pos(((AxisAlignedBB)afemogud).maxX, ((AxisAlignedBB)afemogud).minY, ((AxisAlignedBB)afemogud).maxZ).endVertex();
      fatusoyi.draw();
   }

   public static void _teaching(double febatube, double fimufozu, double batafacu, int icovudot, int libizupi, float ufatuvor) {
      Object aligobef = (float)(icovudot >> 24 & 255) / 255.0F;
      Object losibuza = (float)(icovudot >> 16 & 255) / 255.0F;
      Object esofepap = (float)(icovudot >> 8 & 255) / 255.0F;
      Object tafugive = (float)(icovudot & 255) / 255.0F;
      Object enorinef = (float)(libizupi >> 24 & 255) / 255.0F;
      float var14 = (float)(libizupi >> 16 & 255) / 255.0F;
      float var15 = (float)(libizupi >> 8 & 255) / 255.0F;
      float var16 = (float)(libizupi & 255) / 255.0F;
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(losibuza, esofepap, tafugive, aligobef);
      _between(new AxisAlignedBB((double)febatube, (double)fimufozu, (double)batafacu, febatube + 1.0D, fimufozu + 1.0D, batafacu + 1.0D));
      GL11.glLineWidth((float)ufatuvor);
      GL11.glColor4f(var14, var15, var16, enorinef);
      _angels(new AxisAlignedBB((double)febatube, (double)fimufozu, (double)batafacu, febatube + 1.0D, fimufozu + 1.0D, batafacu + 1.0D));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _derek(double evucifin, double iratogeb, double atetipad, int litugulu) {
      Object yomeruba = (float)(litugulu >> 24 & 255) / 255.0F;
      float var8 = (float)(litugulu >> 16 & 255) / 255.0F;
      float var9 = (float)(litugulu >> 8 & 255) / 255.0F;
      float var10 = (float)(litugulu & 255) / 255.0F;
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var8, var9, var10, yomeruba);
      _between(new AxisAlignedBB((double)evucifin, (double)iratogeb, (double)atetipad, evucifin + 0.1D, iratogeb + 0.1D, atetipad + 0.1D));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _wrote(AxisAlignedBB frost, int euros) {
      GL11.glPushMatrix();
      Object bookmark = (float)(euros >> 24 & 255) / 255.0F;
      Object sword = (float)(euros >> 16 & 255) / 255.0F;
      Object treat = (float)(euros >> 8 & 255) / 255.0F;
      Object quote = (float)(euros & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(2896);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(bookmark, sword, treat, quote);
      _summer((AxisAlignedBB)frost);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2896);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _summer(AxisAlignedBB archives) {
      if (archives != null) {
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).maxZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).minZ);
         GL11.glEnd();
         GL11.glBegin(7);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).minX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).minZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).maxY, ((AxisAlignedBB)archives).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)archives).maxX, ((AxisAlignedBB)archives).minY, ((AxisAlignedBB)archives).maxZ);
         GL11.glEnd();
      }
   }

   public static void _hungary(AxisAlignedBB evumitay, float sotofebi, int sipipema) {
      GL11.glPushMatrix();
      Object alizivuy = (float)(sipipema >> 24 & 255) / 255.0F;
      Object dinenato = (float)(sipipema >> 16 & 255) / 255.0F;
      Object azamurab = (float)(sipipema >> 8 & 255) / 255.0F;
      Object oyavufig = (float)(sipipema & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(2896);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glLineWidth((float)sotofebi);
      GL11.glColor4f(alizivuy, dinenato, azamurab, oyavufig);
      _ranking((AxisAlignedBB)evumitay);
      GL11.glLineWidth(1.0F);
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2896);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _heaven(double newer, double posts, double worlds, float wishes, float seating, float admin, float zealand, float modified, float people, float var12, float var13, float var14) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f((float)wishes, (float)seating, (float)admin, (float)zealand);
      _between(new AxisAlignedBB((double)newer, (double)posts, (double)worlds, newer + 1.0D, posts + 1.0D, worlds + 1.0D));
      GL11.glLineWidth(var14);
      GL11.glColor4f((float)modified, (float)people, var12, var13);
      _angels(new AxisAlignedBB((double)newer, (double)posts, (double)worlds, newer + 1.0D, posts + 1.0D, worlds + 1.0D));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _surgeon(double bamoceyo, double atafayas, double isisezot, float netayuda, float biceyuni, float ayebasot, float luyecite, float betogimo, float ovipayen, float var12, float var13, float var14) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f((float)netayuda, (float)biceyuni, (float)ayebasot, (float)luyecite);
      _between(new AxisAlignedBB((double)bamoceyo, atafayas + 1.1D, (double)isisezot, bamoceyo + 1.0D, atafayas + 1.0D, isisezot + 1.0D));
      GL11.glLineWidth(var14);
      GL11.glColor4f((float)betogimo, (float)ovipayen, var12, var13);
      _angels(new AxisAlignedBB((double)bamoceyo, atafayas + 1.1D, (double)isisezot, bamoceyo + 1.0D, atafayas + 1.0D, isisezot + 1.0D));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _viewers(double sauce, double thank, double lawrence, float websites, float var7, float var8, float var9) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f((float)websites, var7, var8, var9);
      _between(new AxisAlignedBB((double)sauce, (double)thank, (double)lawrence, sauce + 1.0D, thank + 1.0D, lawrence + 1.0D));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _eligible(double vedavigo, double vasodivo, double luzutuzi, Color var6, float var7) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f((float)var6.getRed() / 255.0F, (float)var6.getGreen() / 255.0F, (float)var6.getBlue() / 255.0F, (float)var6.getAlpha() / 255.0F);
      _between(new AxisAlignedBB((double)vedavigo, (double)vasodivo, (double)luzutuzi, vedavigo + (double)var7, vasodivo + (double)var7, luzutuzi + (double)var7));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _revenues(double beyuvasi, double rorusimu, double ezolaben, double repudule, double totacopa, int var10) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glLineWidth(1.0F);
      float var11 = (float)(var10 >> 24 & 255) / 255.0F;
      float var12 = (float)(var10 >> 16 & 255) / 255.0F;
      float var13 = (float)(var10 >> 8 & 255) / 255.0F;
      float var14 = (float)(var10 & 255) / 255.0F;
      GL11.glColor4f(var12, var13, var14, var11 == Float.intBitsToFloat(0) ? 1.0F : var11);
      _angels(new AxisAlignedBB((double)(beyuvasi - repudule), (double)rorusimu, (double)(ezolaben - repudule), (double)(beyuvasi + repudule), (double)(rorusimu + totacopa), (double)(ezolaben + repudule)));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _bearing(int night) {
      Object carter = (float)(night >> 24 & 255) / 255.0F;
      Object placed = (float)(night >> 16 & 255) / 255.0F;
      Object tries = (float)(night >> 8 & 255) / 255.0F;
      Object venues = (float)(night & 255) / 255.0F;
      GL11.glColor4f(placed, tries, venues, carter == Float.intBitsToFloat(0) ? 1.0F : carter);
   }

   public static void _jenny(double rachel, double spots, double bidder, double quick, double brunei, float var10, float var11, float var12, float var13) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f(var10, var11, var12, var13);
      _between(new AxisAlignedBB((double)(rachel - quick), (double)spots, (double)(bidder - quick), (double)(rachel + quick), (double)(spots + brunei), (double)(bidder + quick)));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _enough(double vociyoyu, double zarifidi, double bayadosi, double fasoteyi, double ebapogob, float nupeyida, float decezavo, float putupofi, float ipofotil, float var14, float var15, float var16, float var17, float var18) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glColor4f((float)nupeyida, (float)decezavo, (float)putupofi, (float)ipofotil);
      _between(new AxisAlignedBB((double)(vociyoyu - fasoteyi), (double)zarifidi, (double)(bayadosi - fasoteyi), (double)(vociyoyu + fasoteyi), (double)(zarifidi + ebapogob), (double)(bayadosi + fasoteyi)));
      GL11.glLineWidth(var18);
      GL11.glColor4f(var14, var15, var16, var17);
      _angels(new AxisAlignedBB((double)(vociyoyu - fasoteyi), (double)zarifidi, (double)(bayadosi - fasoteyi), (double)(vociyoyu + fasoteyi), (double)(zarifidi + ebapogob), (double)(bayadosi + fasoteyi)));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _problems(double finds, double enter, double argument, double roughly, double explicit, float lodge, float hereby, float martha, float vital, float var14, float var15, float var16, float var17, float var18) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glDepthMask(false);
      GL11.glColor4f((float)lodge, (float)hereby, (float)martha, (float)vital);
      _between(new AxisAlignedBB((double)(finds - roughly), (double)enter, (double)(argument - roughly), (double)(finds + roughly), (double)(enter + explicit), (double)(argument + roughly)));
      GL11.glLineWidth(var18);
      GL11.glColor4f(var14, var15, var16, var17);
      _angels(new AxisAlignedBB((double)(finds - roughly), (double)enter, (double)(argument - roughly), (double)(finds + roughly), (double)(enter + explicit), (double)(argument + roughly)));
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glEnable(2929);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public static void _syracuse(float ipiceyec, float emunucif, float zuyayoge, float avorutiz, int omipozor) {
      _winston();
      _bearing((int)omipozor);
      GL11.glLineWidth((float)avorutiz);
      Object radufopa = (int)Math.min(Math.max((float)zuyayoge, 45.0F), 360.0F);
      GL11.glBegin(2);

      for(Object ronemune = 0; ronemune < radufopa; ++ronemune) {
         Object ridusibi = 6.283185307179586D * (double)ronemune / (double)radufopa;
         GL11.glVertex2d((double)ipiceyec + Math.sin(ridusibi) * (double)zuyayoge, (double)emunucif + Math.cos(ridusibi) * (double)zuyayoge);
      }

      GL11.glEnd();
      _outlet();
   }

   public static void _reflects(int reload, int mysimon, double bunny, int whenever) {
      Object emphasis = (float)(whenever >> 24 & 255) / 255.0F;
      Object proven = (float)(whenever >> 16 & 255) / 255.0F;
      Object mobile = (float)(whenever >> 8 & 255) / 255.0F;
      Object hiring = (float)(whenever & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(proven, mobile, hiring, emphasis);
      GL11.glBegin(2);

      for(Object amazing = 0; amazing <= 360; ++amazing) {
         Object adjacent = Math.sin((double)amazing * 3.141592653589793D / 180.0D) * bunny;
         double var12 = Math.cos((double)amazing * 3.141592653589793D / 180.0D) * bunny;
         GL11.glVertex2d((double)reload + adjacent, (double)mysimon + var12);
      }

      GL11.glEnd();
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
   }

   public static void _scoop(float jesus, float chambers, float death, int stronger) {
      _winston();
      _bearing((int)stronger);
      Object relating = (int)Math.min(Math.max((float)death, 45.0F), 360.0F);
      GL11.glBegin(9);

      for(Object textiles = 0; textiles < relating; ++textiles) {
         Object sweden = 6.283185307179586D * (double)textiles / (double)relating;
         GL11.glVertex2d((double)jesus + Math.sin(sweden) * (double)death, (double)chambers + Math.cos(sweden) * (double)death);
      }

      GL11.glEnd();
      _outlet();
      _syracuse((float)jesus, (float)chambers, (float)death, 1.5F, 16777215);
   }

   public static void _heather(int tutazisi, int sebazamu, double azoyetos, int zayodolu) {
      Object dividubo = (float)(zayodolu >> 24 & 255) / 255.0F;
      Object ipayesir = (float)(zayodolu >> 16 & 255) / 255.0F;
      Object avavidiv = (float)(zayodolu >> 8 & 255) / 255.0F;
      Object zisasime = (float)(zayodolu & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(ipayesir, avavidiv, zisasime, dividubo);
      GL11.glBegin(6);

      for(Object ecuvoyoz = 0; ecuvoyoz <= 360; ++ecuvoyoz) {
         Object ezurepat = Math.sin((double)ecuvoyoz * 3.141592653589793D / 180.0D) * azoyetos;
         double var12 = Math.cos((double)ecuvoyoz * 3.141592653589793D / 180.0D) * azoyetos;
         GL11.glVertex2d((double)tutazisi + ezurepat, (double)sebazamu + var12);
      }

      GL11.glEnd();
      GL11.glDisable(2848);
      GL11.glEnable(3553);
      GL11.glDisable(3042);
   }

   public static void _given(double betasalo, double imarutad, double ivifigis, double yanivova, int izigemuc) {
      if (betasalo < ivifigis) {
         Object cideluge = (double)betasalo;
         betasalo = ivifigis;
         ivifigis = cideluge;
      }

      if (imarutad < yanivova) {
         Object var15 = (double)imarutad;
         imarutad = yanivova;
         yanivova = var15;
      }

      Object var16 = (float)(izigemuc >> 24 & 255) / 255.0F;
      Object umonulic = (float)(izigemuc >> 16 & 255) / 255.0F;
      float var11 = (float)(izigemuc >> 8 & 255) / 255.0F;
      float var12 = (float)(izigemuc & 255) / 255.0F;
      Tessellator var13 = Tessellator.getInstance();
      WorldRenderer var14 = var13.getWorldRenderer();
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(umonulic, var11, var12, var16);
      var14.begin(7, DefaultVertexFormats.POSITION);
      var14.pos((double)betasalo, (double)yanivova, Double.longBitsToDouble(0L));
      var14.pos((double)ivifigis, (double)yanivova, Double.longBitsToDouble(0L));
      var14.pos((double)ivifigis, (double)imarutad, Double.longBitsToDouble(0L));
      var14.pos((double)betasalo, (double)imarutad, Double.longBitsToDouble(0L));
      var13.draw();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
   }

   public static void _syndrome(double vecenimi, double sonivane, double erimadom, double pumalile, int zegugevi, int mufovogu) {
      Object iyamagud = (float)(zegugevi >> 24 & 255) / 255.0F;
      Object rofavopa = (float)(zegugevi >> 16 & 255) / 255.0F;
      Object fezisegi = (float)(zegugevi >> 8 & 255) / 255.0F;
      Object emevigoz = (float)(zegugevi & 255) / 255.0F;
      Object bedupigo = (float)(mufovogu >> 24 & 255) / 255.0F;
      Object loripubu = (float)(mufovogu >> 16 & 255) / 255.0F;
      float var16 = (float)(mufovogu >> 8 & 255) / 255.0F;
      float var17 = (float)(mufovogu & 255) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.shadeModel(7425);
      Tessellator var18 = Tessellator.getInstance();
      WorldRenderer var19 = var18.getWorldRenderer();
      var19.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var19.pos((double)erimadom, (double)sonivane, Double.longBitsToDouble(0L)).color(rofavopa, fezisegi, emevigoz, iyamagud).endVertex();
      var19.pos((double)vecenimi, (double)sonivane, Double.longBitsToDouble(0L)).color(rofavopa, fezisegi, emevigoz, iyamagud).endVertex();
      var19.pos((double)vecenimi, (double)pumalile, Double.longBitsToDouble(0L)).color(loripubu, var16, var17, bedupigo).endVertex();
      var19.pos((double)erimadom, (double)pumalile, Double.longBitsToDouble(0L)).color(loripubu, var16, var17, bedupigo).endVertex();
      var18.draw();
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
   }

   public static void _hardwood(float slightly, float gardens, float health, float ought, float mirror, int sucking, int blocks) {
      Object villa = (float)(sucking >> 24 & 255) / 255.0F;
      Object congress = (float)(sucking >> 16 & 255) / 255.0F;
      Object planner = (float)(sucking >> 8 & 255) / 255.0F;
      Object reduces = (float)(sucking & 255) / 255.0F;
      GlStateManager.pushMatrix();
      _humidity((double)slightly, (double)gardens, (double)health, (double)ought, new Color(congress, planner, reduces, villa));
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(congress, planner, reduces, villa);
      if (mirror == 1.0F) {
         GL11.glEnable(2848);
      }

      GL11.glLineWidth((float)mirror);
      Object voices = Tessellator.getInstance();
      WorldRenderer var12 = voices.getWorldRenderer();
      var12.begin(1, DefaultVertexFormats.POSITION);
      var12.pos((double)slightly, (double)gardens, Double.longBitsToDouble(0L));
      var12.pos((double)slightly, (double)ought, Double.longBitsToDouble(0L));
      var12.pos((double)health, (double)ought, Double.longBitsToDouble(0L));
      var12.pos((double)health, (double)gardens, Double.longBitsToDouble(0L));
      var12.pos((double)slightly, (double)gardens, Double.longBitsToDouble(0L));
      var12.pos((double)health, (double)gardens, Double.longBitsToDouble(0L));
      var12.pos((double)slightly, (double)ought, Double.longBitsToDouble(0L));
      var12.pos((double)health, (double)ought, Double.longBitsToDouble(0L));
      voices.draw();
      GL11.glLineWidth(2.0F);
      if (mirror == 1.0F) {
         GL11.glDisable(2848);
      }

      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.popMatrix();
   }

   public static void _humidity(double sotagalo, double izadagem, double enotagis, double var6, Color var8) {
      _winston();
      _layers(var8);
      _pound((double)sotagalo, (double)izadagem, (double)enotagis, var6);
      _outlet();
   }

   public static void _equal(double yeteduyi, double erupusab, double dogedafu, double var6, int var8) {
      _winston();
      _prefer(var8);
      _pound((double)yeteduyi, (double)erupusab, (double)dogedafu, var6);
      _outlet();
   }

   public static void _corner(double yadavonu, double ozegamim, double ebezaven, double gosocori, float devecari, int ebenelol, int tumezavo, int otivuvib) {
      Object uyocagag = (float)(ebenelol >> 24 & 255) / 255.0F;
      Object iyocuzin = (float)(ebenelol >> 16 & 255) / 255.0F;
      float var14 = (float)(ebenelol >> 8 & 255) / 255.0F;
      float var15 = (float)(ebenelol & 255) / 255.0F;
      GlStateManager.pushMatrix();
      _syndrome((double)yadavonu, (double)ozegamim, (double)ebezaven, (double)gosocori, (int)tumezavo, (int)otivuvib);
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(iyocuzin, var14, var15, uyocagag);
      if (devecari == 1.0F) {
         GL11.glEnable(2848);
      }

      GL11.glLineWidth((float)devecari);
      Tessellator var16 = Tessellator.getInstance();
      WorldRenderer var17 = var16.getWorldRenderer();
      var17.begin(1, DefaultVertexFormats.POSITION);
      var17.pos((double)yadavonu, (double)ozegamim, Double.longBitsToDouble(0L));
      var17.pos((double)yadavonu, (double)gosocori, Double.longBitsToDouble(0L));
      var17.pos((double)ebezaven, (double)gosocori, Double.longBitsToDouble(0L));
      var17.pos((double)ebezaven, (double)ozegamim, Double.longBitsToDouble(0L));
      var17.pos((double)yadavonu, (double)ozegamim, Double.longBitsToDouble(0L));
      var17.pos((double)ebezaven, (double)ozegamim, Double.longBitsToDouble(0L));
      var17.pos((double)yadavonu, (double)gosocori, Double.longBitsToDouble(0L));
      var17.pos((double)ebezaven, (double)gosocori, Double.longBitsToDouble(0L));
      var16.draw();
      GL11.glLineWidth(2.0F);
      if (devecari == 1.0F) {
         GL11.glDisable(2848);
      }

      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.popMatrix();
   }

   public static double _actress(double arenefap, double varagipa, float var4, double var5) {
      return arenefap + (varagipa - arenefap) * (double)var4 - var5;
   }

   public static void _violin(Entity hunger, double accuracy, double drunk, double light, int filling, int var8) {
      GlStateManager.pushMatrix();
      GL11.glLineWidth(1.0F);
      AxisAlignedBB var9 = ((Entity)hunger).getEntityBoundingBox();
      AxisAlignedBB var10 = new AxisAlignedBB(var9.minX - ((Entity)hunger).posX + accuracy, var9.minY - ((Entity)hunger).posY + drunk, var9.minZ - ((Entity)hunger).posZ + light, var9.maxX - ((Entity)hunger).posX + accuracy, var9.maxY - ((Entity)hunger).posY + drunk, var9.maxZ - ((Entity)hunger).posZ + light);
      if (filling != 0) {
         GlStateManager.disableDepth();
         _ensures(var10, var8, true);
         GlStateManager.disableLighting();
         int[] var11 = WorldRenderUtils2._coupled((int)filling);
      }

      GlStateManager.popMatrix();
   }

   public static void _ensures(AxisAlignedBB reribopi, int ogemadel, boolean uropadam) {
      GlStateManager.pushMatrix();
      Object givolure = (float)(ogemadel >> 24 & 255) / 255.0F;
      Object pavigisa = (float)(ogemadel >> 16 & 255) / 255.0F;
      Object ifegacos = (float)(ogemadel >> 8 & 255) / 255.0F;
      Object sezupube = (float)(ogemadel & 255) / 255.0F;
      Object datiyole = Tessellator.getInstance().getWorldRenderer();
      if (uropadam) {
         GlStateManager.color(pavigisa, ifegacos, sezupube, givolure);
      }

      boolean var8 = true;
      datiyole.begin(7, DefaultVertexFormats.POSITION);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).maxZ);
      Tessellator.getInstance().draw();
      datiyole.begin(7, DefaultVertexFormats.POSITION);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).maxZ);
      Tessellator.getInstance().draw();
      datiyole.begin(7, DefaultVertexFormats.POSITION);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).minZ);
      Tessellator.getInstance().draw();
      datiyole.begin(7, DefaultVertexFormats.POSITION);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).minZ);
      Tessellator.getInstance().draw();
      datiyole.begin(7, DefaultVertexFormats.POSITION);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).minZ);
      Tessellator.getInstance().draw();
      datiyole.begin(7, DefaultVertexFormats.POSITION);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).minX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).minZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).maxY, ((AxisAlignedBB)reribopi).maxZ);
      datiyole.pos(((AxisAlignedBB)reribopi).maxX, ((AxisAlignedBB)reribopi).minY, ((AxisAlignedBB)reribopi).maxZ);
      Tessellator.getInstance().draw();
      GlStateManager.depthMask(true);
      GlStateManager.popMatrix();
   }

   public static void _brochure(float bible, float nuclear, float trains, float install, int kodak, int italia) {
      _hardwood((float)bible, (float)nuclear, (float)trains, (float)install, 1.0F, (int)kodak, (int)italia);
   }

   public static void _texture(double zasiyome, double sesutete, double pezobasi, double pagagena, int var8, int var9, int var10) {
      _corner((double)zasiyome, (double)sesutete, (double)pezobasi, (double)pagagena, 1.0F, var8, var9, var10);
   }

   public static void _seasonal(EntityLivingBase utocagom, int timotuni, double cutocesu, double uporinen, double var6) {
      GL11.glPushMatrix();
      GL11.glTranslated((double)cutocesu, (double)uporinen, var6);
      GL11.glRotatef(-((EntityLivingBase)utocagom).rotationYaw, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      _bearing((int)timotuni);
      _compiler(1.0F);
      Cylinder var8 = new Cylinder();
      GL11.glRotatef(-90.0F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      var8.setDrawStyle(100011);
      var8.draw(0.5F, 0.5F, ((EntityLivingBase)utocagom).height + 0.1F, 18, 1);
      _resumes();
      GL11.glPopMatrix();
   }

   public static void _sweden(int eyozilom, double emurepap, double figofale, double var5) {
      AxisAlignedBB var7 = new AxisAlignedBB(emurepap - 0.4D, (double)figofale, var5 - 0.4D, emurepap + 0.4D, figofale + 2.0D, var5 + 0.4D);
      GlStateManager.pushMatrix();
      GlStateManager.translate((double)emurepap, (double)figofale, var5);
      GlStateManager.translate((double)(-emurepap), (double)(-figofale), -var5);
      _compiler(1.0F);
      _bearing((int)eyozilom);
      _angels(var7);
      _resumes();
      GlStateManager.popMatrix();
   }

   public static void _ranking(AxisAlignedBB areas) {
      if (areas != null) {
         GL11.glBegin(3);
         GL11.glVertex3d(((AxisAlignedBB)areas).minX, ((AxisAlignedBB)areas).minY, ((AxisAlignedBB)areas).minZ);
         GL11.glVertex3d(((AxisAlignedBB)areas).maxX, ((AxisAlignedBB)areas).minY, ((AxisAlignedBB)areas).minZ);
         GL11.glVertex3d(((AxisAlignedBB)areas).maxX, ((AxisAlignedBB)areas).minY, ((AxisAlignedBB)areas).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)areas).minX, ((AxisAlignedBB)areas).minY, ((AxisAlignedBB)areas).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)areas).minX, ((AxisAlignedBB)areas).minY, ((AxisAlignedBB)areas).minZ);
         GL11.glEnd();
         GL11.glBegin(3);
         GL11.glVertex3d(((AxisAlignedBB)areas).minX, ((AxisAlignedBB)areas).maxY, ((AxisAlignedBB)areas).minZ);
         GL11.glVertex3d(((AxisAlignedBB)areas).maxX, ((AxisAlignedBB)areas).maxY, ((AxisAlignedBB)areas).minZ);
         GL11.glVertex3d(((AxisAlignedBB)areas).maxX, ((AxisAlignedBB)areas).maxY, ((AxisAlignedBB)areas).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)areas).minX, ((AxisAlignedBB)areas).maxY, ((AxisAlignedBB)areas).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)areas).minX, ((AxisAlignedBB)areas).maxY, ((AxisAlignedBB)areas).minZ);
         GL11.glEnd();
         GL11.glBegin(1);
         GL11.glVertex3d(((AxisAlignedBB)areas).minX, ((AxisAlignedBB)areas).minY, ((AxisAlignedBB)areas).minZ);
         GL11.glVertex3d(((AxisAlignedBB)areas).minX, ((AxisAlignedBB)areas).maxY, ((AxisAlignedBB)areas).minZ);
         GL11.glVertex3d(((AxisAlignedBB)areas).maxX, ((AxisAlignedBB)areas).minY, ((AxisAlignedBB)areas).minZ);
         GL11.glVertex3d(((AxisAlignedBB)areas).maxX, ((AxisAlignedBB)areas).maxY, ((AxisAlignedBB)areas).minZ);
         GL11.glVertex3d(((AxisAlignedBB)areas).maxX, ((AxisAlignedBB)areas).minY, ((AxisAlignedBB)areas).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)areas).maxX, ((AxisAlignedBB)areas).maxY, ((AxisAlignedBB)areas).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)areas).minX, ((AxisAlignedBB)areas).minY, ((AxisAlignedBB)areas).maxZ);
         GL11.glVertex3d(((AxisAlignedBB)areas).minX, ((AxisAlignedBB)areas).maxY, ((AxisAlignedBB)areas).maxZ);
         GL11.glEnd();
      }

   }

   public static void _trains(int angry, double control, double var3, double var5) {
      GL11.glPushMatrix();
      _compiler(2.0F);
      _bearing((new Color(255, 0, 0)).getRGB());
      GL11.glBegin(2);
      GL11.glVertex3d(Double.longBitsToDouble(0L), (double)marco$.thePlayer.getEyeHeight(), Double.longBitsToDouble(0L));
      GL11.glVertex3d((double)control, var3, var5);
      GL11.glEnd();
      _resumes();
      GL11.glPopMatrix();
   }

   public static void _toolkit(double zisubime, double usetatod, double afirebat, double var6, float var8, int var9) {
      GL11.glEnable(3042);
      GL11.glDisable(2884);
      GL11.glDisable(3553);
      GL11.glEnable(2848);
      GL11.glBlendFunc(770, 771);
      GL11.glLineWidth(1.0F);
      _bearing(var9);
      GL11.glLineWidth(var8);
      GL11.glBegin(1);
      GL11.glVertex2d((double)zisubime, (double)usetatod);
      GL11.glVertex2d((double)afirebat, var6);
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
}
