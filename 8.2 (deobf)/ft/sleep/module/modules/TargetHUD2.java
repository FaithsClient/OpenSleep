//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender2D;
import ft.sleep.api.events.world.EventAttack;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

import ft.sleep.util.animation.AnimationUtil;
import ft.sleep.util.animation.AnimationUtils2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TargetHUD2 extends Module {
   public Mode prophet$ = new Mode("Mode", new String[]{"Skid", "Astolfo", "Zenith", "Bingus", "Zeriy", "Stella", "ExhOld", "Exhibition", "Zeriy2", "NeverLose"}, "Astolfo");
   public Mode started$ = new Mode("XYMOD", new String[]{"Chat", "XY"}, "Chat");
   public static Option hewlett$ = new Option("Reset XY", false);
   public static Numbers lucky$ = new Numbers("X", "X", 20.0D, -1000.0D, 1920.0D, 10.0D);
   public static Numbers unwrap$ = new Numbers("Y", "Y", 10.0D, -1000.0D, 1080.0D, 10.0D);
   public double diabetes$;
   public long houston$;
   public int mexican$;
   public boolean suggests$;
   public double fighting$ = 1.0D;
   public Entity planets$;
   public float heard$ = Float.intBitsToFloat(0);
   public float flash$;
   public float italian$;
   public static int affairs$ = 250;
   public static int rover$ = 250;
   public float stripes$;
   public float playing$;
   public NetworkPlayerInfo findings$;
   public float arrive$ = Float.intBitsToFloat(0);
   public float adware$ = Float.intBitsToFloat(0);
   public float hotels$ = Float.intBitsToFloat(0);
   public float intro$ = Float.intBitsToFloat(0);
   public double getting$;
   public EntityLivingBase articles$;
   public TimeUtil reunion$ = new TimeUtil();
   public TimeUtil bookmark$ = new TimeUtil();
   public boolean tackle$;
   public List packages$ = new ArrayList();
   public TimerUtil vehicles$ = new TimerUtil();
   public List cross$ = new ArrayList();
   public double domestic$;
   public double thriller$;
   public double cottages$;
   public TranslateUtil pearl$ = new TranslateUtil(Float.intBitsToFloat(0), Float.intBitsToFloat(0));
   public TranslateUtil chargers$ = new TranslateUtil(Float.intBitsToFloat(0), Float.intBitsToFloat(0));
   public float expenses$;
   public float older$;
   public Pattern banned$ = Pattern.compile("(?i)§[0-9A-FK-ORX]");

   public TargetHUD2() {
      super("ft.sleep.module.modules.TargetHUD", new String[]{"ft.sleep.module.modules.TargetHUD"}, ModuleType.ignored$);
   }

   @EventHandler
   public void _releases(EventAttack peter) {
      clubs.planets$ = (EntityLivingBase)((EventAttack)peter).getEntity();
   }

   @EventHandler
   public void _counties(EventRender2D otunizol) {
      if (hewlett$.getValue().booleanValue()) {
         affairs$ = 200;
         rover$ = 200;
         hewlett$.setValue(Boolean.valueOf(false));
      }

      Object dotesuda = (KillAura) ModuleManager._herbs(KillAura.class);
      Object gutovotu = dotesuda._central() && KillAura._versus() != null;
      Object olepayas = (Reach)ModuleManager._herbs(Reach.class);
      if (!gutovotu && sapepori.planets$ != null && (double)sapepori.planets$.getDistanceToEntity(sapepori.mc.thePlayer) >= (olepayas._central() ? (double) Reach.penguin$.getValue().floatValue() : 3.0D)) {
         sapepori.planets$ = null;
         sapepori.reunion$._skype();
      }

      if (sapepori.planets$ != null && sapepori.planets$.isDead) {
         sapepori.planets$ = null;
         sapepori.reunion$._skype();
      }

      Object osecosub = sapepori.mc.currentScreen instanceof GuiChat ? sapepori.mc.thePlayer : (gutovotu ? KillAura._versus() : (EntityLivingBase)sapepori.planets$);
      new ScaledResolution(sapepori.mc);
      Object mepicego = Objects.equals(sapepori.started$.getValue(), "Chat") ? affairs$ : lucky$.getValue().intValue();
      Object butosore = Objects.equals(sapepori.started$.getValue(), "Chat") ? rover$ : unwrap$.getValue().intValue();
      Object eruseron = Objects.equals(sapepori.started$.getValue(), "Chat") ? affairs$ : lucky$.getValue().intValue();
      Object oguyivul = Objects.equals(sapepori.started$.getValue(), "Chat") ? rover$ : unwrap$.getValue().intValue();
      if (sapepori.reunion$._amazon((long)-1892900414 ^ -1892900401L)) {
         if (osecosub != null) {
            sapepori.fighting$ = Math.min(1.0D, sapepori.fighting$ + (double)sapepori.bookmark$._dominant() / 4.0E14D + (1.0D - sapepori.fighting$) / 10.0D);
            sapepori.reunion$._skype();
         } else {
            sapepori.fighting$ = Math.max(Double.longBitsToDouble(0L), sapepori.fighting$ - (double)sapepori.bookmark$._dominant() / 8.0E13D - (1.0D - sapepori.fighting$) / 10.0D);
            sapepori.reunion$._skype();
         }
      }

      Object eroriviv = (EntityLivingBase)sapepori.planets$;
      if (Objects.equals(sapepori.prophet$.getValue(), "New2")) {
         if (KillAura._versus() == null) {
            if (sapepori.mc.thePlayer != null && sapepori.mc.currentScreen instanceof GuiChat) {
               eroriviv = sapepori.mc.thePlayer;
               sapepori.fighting$ = (double) AnimationUtil._meeting((float)sapepori.fighting$, 1.0F, (float)(6.0D * RenderUtil5._weapon()));
            }
         } else {
            eroriviv = KillAura._versus();
            sapepori.fighting$ = (double)AnimationUtil._meeting((float)sapepori.fighting$, 1.0F, (float)(6.0D * RenderUtil5._weapon()));
         }

         if (eroriviv != null) {
            GlStateManager.pushMatrix();
            GlStateManager.resetColor();
            GL11.glTranslated((double)(mepicego + 55), (double)(butosore + 11), Double.longBitsToDouble(0L));
            GL11.glScaled(sapepori.fighting$, sapepori.fighting$, Double.longBitsToDouble(0L));
            GL11.glTranslated((double)(-(mepicego + 55)), (double)(-(butosore + 11)), Double.longBitsToDouble(0L));
            Object apofozay = (double)(((EntityLivingBase)eroriviv).getHealth() / ((EntityLivingBase)eroriviv).getMaxHealth() * 360.0F);
            apofozay = MathHelper.clamp_double(apofozay, Double.longBitsToDouble(0L), 360.0D);
            sapepori.getting$ = AnimationUtil._chrysler(sapepori.getting$, (double)((float)apofozay), (double)((float)(160.0D * RenderUtil5._weapon())));
            Object opasulet = "" + MathUtil._teach((double)((EntityLivingBase)eroriviv).getHealth(), 1);
            Object agovuyay = "" + MathUtil._teach(sapepori.mc.thePlayer.getDistance(((EntityLivingBase)eroriviv).posX, ((EntityLivingBase)eroriviv).posY, ((EntityLivingBase)eroriviv).posZ), 1);
            GlStateManager.resetColor();
            RoundedUtil._ticket((float)mepicego, (float)(butosore + 1), 120.0F, 40.0F, 3.0F, new Color(0, 0, 0, 70));
            FontLoaders.TahomaBold14.drawStringWithShadow(((EntityLivingBase)eroriviv).getDisplayName().getFormattedText(), (double)(mepicego + 27), (double)((float)butosore + 7.0F), -1);
            FontLoaders.TahomaBold13.drawStringWithShadow(" " + ((EntityPlayer)eroriviv).isBlocking(), (double)(mepicego + 57), (double)((float)butosore + 17.5F), -1);
            FontLoaders.TahomaBold13.drawStringWithShadow("Blocking:", (double)(mepicego + 27), (double)(butosore + 18), (new Color(HUD.during$.getValue().intValue())).getRGB());
            GlStateManager.resetColor();
            RenderUtils._closest((float)mepicego + 105.0F, (float)(butosore + 14), Float.intBitsToFloat(0), 360.0F, 10.0F, (new Color(17, 17, 17, 255)).getRGB(), 3);
            RenderUtils._closest((float)mepicego + 105.0F, (float)(butosore + 14), Float.intBitsToFloat(0), (float)sapepori.getting$, 10.0F, (new Color(HUD.during$.getValue().intValue())).getRGB(), 3);
            FontLoaders.TahomaBold12.drawCenteredString(opasulet, (float)(mepicego + 106), (float)(butosore + 13), (new Color(HUD.cosmetic$.getValue().intValue())).getRGB());
            sapepori.getting$ = (double) AnimationUtils2._presents((float)sapepori.getting$, (float)apofozay, (float)(10.0D * RenderUtil5._weapon()));

            for(Object ecesisor : sapepori.mc.getNetHandler().getPlayerInfoMap()) {
               if (sapepori.mc.theWorld.getPlayerEntityByUUID(ecesisor.getGameProfile().getId()) == eroriviv && eroriviv != null) {
                  sapepori.mc.getTextureManager().bindTexture(ecesisor.getLocationSkin());
                  Object ereyesar = _beans((EntityLivingBase)eroriviv);
                  GL11.glPushMatrix();
                  GL11.glColor4f(1.0F, 1.0F - ereyesar, 1.0F - ereyesar, 1.0F);
                  Gui.drawScaledCustomSizeModalRect(mepicego + 5, butosore + 5, 8.0F, 8.0F, 8, 8, 18, 18, 64.0F, 64.0F);
                  GL11.glPopMatrix();
                  GlStateManager.bindTexture(0);
               }
            }

            GlStateManager.popMatrix();

            for(Object moligaye : sapepori.packages$) {
               moligaye.profiles$ = (float)(mepicego + 10);
               moligaye.shops$ = (float)(butosore + 12);
               GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
               if (moligaye.winter$ > 4.0F) {
                  moligaye._gilbert();
               }
            }

            if (sapepori.vehicles$._herself((long)913348063 ^ 913348047L, true)) {
               for(Object var51 : sapepori.packages$) {
                  var51._bradley();
                  if (var51.winter$ < 1.0F) {
                     sapepori.packages$.remove(var51);
                  }
               }
            }

            if (((EntityLivingBase)osecosub).hurtTime == 9 && !sapepori.tackle$) {
               for(Object var35 = 0; var35 <= 25; ++var35) {
                  Object var52 = new TargetHUD();
                  var52._boulder((float)(mepicego + 20), (float)(butosore + 20), (float)((Math.random() - 0.5D) * 2.0D * 1.4D), (float)((Math.random() - 0.5D) * 2.0D * 1.4D), (float)(Math.random() * 4.0D), var35 % 2 == 0 ? new Color(HUD.during$.getValue().intValue()) : new Color(HUD.cosmetic$.getValue().intValue()));
                  sapepori.packages$.add(var52);
               }

               sapepori.tackle$ = true;
            }

            if (((EntityLivingBase)osecosub).hurtTime == 8) {
               sapepori.tackle$ = false;
            }
         }
      }

      if (Objects.equals(sapepori.prophet$.getValue(), "Skid") && osecosub != null) {
         Object var36 = ESP2D._practice(1200.0F, 0.4F, 1.0F, (long)816502413 ^ 816502412L);
         Object var53 = 0;
         RenderUtils._laptops((float)(mepicego - 2), (float)butosore, 155.5F, 44.0F, 20, new Color(14, 14, 14, 100));
         RenderUtils._secured((double)mepicego, (double)butosore, (double)(mepicego + 150), (double)(butosore + 42), 5.0D, (new Color(14, 14, 14, 70)).getRGB());
         if (Double.isNaN((double)sapepori.expenses$)) {
            sapepori.expenses$ = Float.intBitsToFloat(0);
         }

         if (sapepori.expenses$ > ((EntityLivingBase)osecosub).getMaxHealth()) {
            sapepori.expenses$ = ((EntityLivingBase)osecosub).getMaxHealth();
         }

         if (sapepori.expenses$ < Float.intBitsToFloat(0)) {
            sapepori.expenses$ = Float.intBitsToFloat(0);
         }

         sapepori.expenses$ += (((EntityLivingBase)osecosub).getHealth() - sapepori.expenses$) / 45.0F;
         Object var71 = 14.5D;
         Object var99 = 5.0D;
         RenderUtils._secured((double)(mepicego + 42), (double)butosore + var71, (double)(mepicego + 112), (double)butosore + var71 + var99, 10.0D, (new Color(14, 14, 14, 70)).getRGB());
         RenderUtils._secured((double)(mepicego + 43), (double)butosore + var71 + 1.0D, (double)((float)(mepicego + 43) + 68.0F / ((EntityLivingBase)osecosub).getMaxHealth() * sapepori.expenses$), (double)butosore + var71 + var99 - 1.0D, 10.0D, (new Color(HUD.during$.getValue().intValue())).getRGB());
         FontLoaders.kiona16.drawString(((EntityLivingBase)osecosub).getDisplayName().getFormattedText(), (float)mepicego + 42.5F, (float)(butosore + 5), -1);
         RenderUtils._secured((double)mepicego + 2.5D, (double)butosore + 2.5D, (double)mepicego + 39.5D, (double)butosore + 39.5D, 5.0D, (new Color(14, 14, 14, 70)).getRGB());
         GL11.glColor3d(1.0D, 1.0D, 1.0D);
         _parent(mepicego + 21, butosore + 36, 16, (float)(System.currentTimeMillis() % ((long)1918593043 ^ 1918594843L) / ((long)1484123556 ^ 1484123553L)), Float.intBitsToFloat(0), (EntityLivingBase)osecosub);
         if (osecosub instanceof EntityPlayer) {
            Object var126 = sapepori._kentucky((EntityPlayer)osecosub) + "ms";
            FontLoaders.kiona14.drawString(var126, (float)(mepicego + 148 - FontLoaders.kiona14.getStringWidth(var126)), (float)butosore + 13.5F, -1);
            var126 = (float)Math.round(sapepori.expenses$ / ((EntityLivingBase)osecosub).getMaxHealth() * 1000.0F) / 10.0F + "%";
            FontLoaders.kiona14.drawString(var126, (float)(mepicego + 148 - FontLoaders.kiona14.getStringWidth(var126)), (float)(butosore + 5), (new Color(HUD.during$.getValue().intValue())).getRGB());
         }

         Object var128 = 45.0F;
         Object dotadipa = 26.0F;

         for(Object fuyesuyi = 0; fuyesuyi <= 4; ++fuyesuyi) {
            if (fuyesuyi < 4) {
               RenderUtils._meter((double)((float)mepicego + var128 + (float)(18 * fuyesuyi) - 3.0F), (double)(butosore + 23), (double)((float)mepicego + var128) + 16.5D + (double)(18 * fuyesuyi) - 3.0D, (double)butosore + 39.5D, 5, (new Color(14, 14, 14, 70)).getRGB());
               if (((EntityLivingBase)osecosub).getCurrentArmor(3 - fuyesuyi) != null) {
                  GlStateManager.enableRescaleNormal();
                  GlStateManager.enableBlend();
                  GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                  RenderHelper.enableGUIStandardItemLighting();
                  sapepori.mc.getRenderItem().renderItemAndEffectIntoGUI(((EntityLivingBase)osecosub).getCurrentArmor(3 - fuyesuyi), (int)((double)((float)mepicego + var128 + (float)(18 * fuyesuyi)) - 2.5D), (int)((float)butosore + dotadipa - 3.0F));
                  sapepori.mc.getRenderItem().renderItemOverlays(sapepori.mc.fontRendererObj, ((EntityLivingBase)osecosub).getCurrentArmor(3 - fuyesuyi), (int)((float)mepicego + var128 - 3.0F + (float)(18 * fuyesuyi)), (int)((float)butosore + dotadipa - 1.0F));
                  RenderHelper.disableStandardItemLighting();
                  GlStateManager.disableRescaleNormal();
                  GlStateManager.disableBlend();
               }
            } else if (fuyesuyi == 4) {
               var53 = 3;
               var128 += 17.0F;
               RenderUtils._meter((double)((float)mepicego + var128 + (float)(18 * fuyesuyi)) - 3.5D, (double)(butosore + 23), (double)((float)mepicego + var128 + 16.0F + (float)(18 * fuyesuyi)) - 2.5D, (double)butosore + 39.5D, 5, (new Color(14, 14, 14, 70)).getRGB());
               if (((EntityLivingBase)osecosub).getHeldItem() != null) {
                  GlStateManager.enableRescaleNormal();
                  GlStateManager.enableBlend();
                  GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                  RenderHelper.enableGUIStandardItemLighting();
                  sapepori.mc.getRenderItem().renderItemAndEffectIntoGUI(((EntityLivingBase)osecosub).getHeldItem(), (int)((float)mepicego + var128 + (float)(18 * var53) + 15.0F), (int)((float)butosore + dotadipa - 2.0F));
                  sapepori.mc.getRenderItem().renderItemOverlays(sapepori.mc.fontRendererObj, ((EntityLivingBase)osecosub).getHeldItem(), (int)((float)mepicego + var128 - 3.0F + (float)(18 * var53) + 18.0F), (int)((float)butosore + dotadipa - 2.0F));
                  RenderHelper.disableStandardItemLighting();
                  GlStateManager.disableRescaleNormal();
                  GlStateManager.disableBlend();
               }
            }
         }
      }

      if (Objects.equals(sapepori.prophet$.getValue(), "NeverLose")) {
         if (KillAura._versus() == null) {
            if (sapepori.mc.thePlayer != null && sapepori.mc.currentScreen instanceof GuiChat) {
               eroriviv = sapepori.mc.thePlayer;
               sapepori.fighting$ = (double)AnimationUtil._meeting((float)sapepori.fighting$, 1.0F, (float)(6.0D * RenderUtil5._weapon()));
            }
         } else {
            eroriviv = KillAura._versus();
            sapepori.fighting$ = (double)AnimationUtil._meeting((float)sapepori.fighting$, 1.0F, (float)(6.0D * RenderUtil5._weapon()));
         }

         if (eroriviv != null) {
            GlStateManager.pushMatrix();
            GlStateManager.resetColor();
            GL11.glTranslated((double)(mepicego + 55), (double)(butosore + 11), Double.longBitsToDouble(0L));
            GL11.glScaled(sapepori.fighting$, sapepori.fighting$, Double.longBitsToDouble(0L));
            GL11.glTranslated((double)(-(mepicego + 55)), (double)(-(butosore + 11)), Double.longBitsToDouble(0L));
            Object var37 = (double)(((EntityLivingBase)eroriviv).getHealth() / ((EntityLivingBase)eroriviv).getMaxHealth() * 360.0F);
            var37 = MathHelper.clamp_double(var37, Double.longBitsToDouble(0L), 360.0D);
            sapepori.getting$ = AnimationUtil._chrysler(sapepori.getting$, (double)((float)var37), (double)((float)(160.0D * RenderUtil5._weapon())));
            Object var72 = "" + MathUtil._teach((double)((EntityLivingBase)eroriviv).getHealth(), 1);
            Object var85 = "" + MathUtil._teach(sapepori.mc.thePlayer.getDistance(((EntityLivingBase)eroriviv).posX, ((EntityLivingBase)eroriviv).posY, ((EntityLivingBase)eroriviv).posZ), 1);
            GlStateManager.resetColor();
            RoundedUtil._ticket((float)mepicego, (float)(butosore + 1), 120.0F, 25.0F, 3.0F, new Color(15, 15, 15, 180));
            FontLoaders.TahomaBold14.drawStringWithShadow(((EntityLivingBase)eroriviv).getDisplayName().getFormattedText(), (double)(mepicego + 27), (double)((float)butosore + 7.0F), -1);
            FontLoaders.TahomaBold13.drawStringWithShadow(" " + ((EntityPlayer)eroriviv).isBlocking(), (double)(mepicego + 57), (double)((float)butosore + 17.5F), -1);
            FontLoaders.TahomaBold13.drawStringWithShadow("Blocking:", (double)(mepicego + 27), (double)(butosore + 18), (new Color(HUD.during$.getValue().intValue())).getRGB());
            GlStateManager.resetColor();
            RenderUtils._laptops((float)(mepicego + 87), (float)(butosore + 1), 35.0F, 25.0F, 5, new Color(14, 14, 14, 150));
            RenderUtils._closest((float)mepicego + 105.0F, (float)(butosore + 14), Float.intBitsToFloat(0), 360.0F, 10.0F, (new Color(17, 17, 17, 255)).getRGB(), 3);
            RenderUtils._closest((float)mepicego + 105.0F, (float)(butosore + 14), Float.intBitsToFloat(0), (float)sapepori.getting$, 10.0F, (new Color(HUD.during$.getValue().intValue())).getRGB(), 3);
            FontLoaders.TahomaBold12.drawCenteredString(var72, (float)(mepicego + 106), (float)(butosore + 13), (new Color(HUD.cosmetic$.getValue().intValue())).getRGB());
            sapepori.getting$ = (double)AnimationUtils2._presents((float)sapepori.getting$, (float)var37, (float)(10.0D * RenderUtil5._weapon()));

            for(Object var111 : sapepori.mc.getNetHandler().getPlayerInfoMap()) {
               if (sapepori.mc.theWorld.getPlayerEntityByUUID(var111.getGameProfile().getId()) == eroriviv && eroriviv != null) {
                  if (osecosub instanceof EntityPlayer) {
                     StencilUtil._murphy();
                     StencilUtil._country();
                     RenderUtils._hazard((float)(eruseron + 4), (float)(oguyivul + 5), (float)(eruseron + 4 + 18), (float)(oguyivul + 5 + 18), 4.0F);
                     StencilUtil._mirrors(1);
                     GlStateManager.enableBlend();
                     GlStateManager.blendFunc(770, 771);
                     GlStateManager.alphaFunc(516, Float.intBitsToFloat(0));
                     GlStateManager.enableTexture2D();
                     sapepori.mc.getTextureManager().bindTexture(((AbstractClientPlayer)osecosub).getLocationSkin());
                     GlStateManager.resetColor();
                     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                     Gui.drawScaledCustomSizeModalRect(mepicego + 4, butosore + 5, 8.0F, 8.0F, 8, 8, 18, 18, 64.0F, 64.0F);
                     RenderUtil5._usually((float)(eruseron + 4), (float)(oguyivul + 5), (float)(eruseron + 22), (float)(oguyivul + 23), (new Color(255, 0, 0, ((EntityLivingBase)osecosub).hurtTime * 20)).getRGB());
                     GlStateManager.disableBlend();
                     StencilUtil._involve();
                  }

                  RenderUtils._laptops((float)mepicego, (float)(butosore + 1), 88.0F, 26.0F, 5, new Color(14, 14, 14, 50));
               }
            }

            GlStateManager.popMatrix();

            for(Object var55 : sapepori.packages$) {
               var55.profiles$ = (float)(mepicego + 11);
               var55.shops$ = (float)(butosore + 12);
               GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
               if (var55.winter$ > 4.0F) {
                  var55._gilbert();
               }
            }

            if (sapepori.vehicles$._herself((long)-1513550418 ^ -1513550402L, true)) {
               for(Object var56 : sapepori.packages$) {
                  var56._bradley();
                  if (var56.winter$ < 1.0F) {
                     sapepori.packages$.remove(var56);
                  }
               }
            }

            if (((EntityLivingBase)osecosub).hurtTime == 9 && !sapepori.tackle$) {
               for(Object var41 = 0; var41 <= 25; ++var41) {
                  Object var57 = new TargetHUD();
                  var57._boulder((float)(mepicego + 20), (float)(butosore + 20), (float)((Math.random() - 0.5D) * 2.0D * 1.4D), (float)((Math.random() - 0.5D) * 2.0D * 1.4D), (float)(Math.random() * 4.0D), var41 % 2 == 0 ? new Color(HUD.during$.getValue().intValue()) : new Color(HUD.cosmetic$.getValue().intValue()));
                  sapepori.packages$.add(var57);
               }

               sapepori.tackle$ = true;
            }

            if (((EntityLivingBase)osecosub).hurtTime == 8) {
               sapepori.tackle$ = false;
            }
         }
      }

      if (Objects.equals(sapepori.prophet$.getValue(), "Exhibition") && osecosub != null) {
         if (sapepori.fighting$ == Double.longBitsToDouble(0L)) {
            return;
         }

         GlStateManager.pushMatrix();
         GlStateManager.translate((double)((float)(mepicego + 38 + 2) + 64.5F) * (1.0D - sapepori.fighting$), (double)((float)(butosore - 34) + 24.0F) * (1.0D - sapepori.fighting$), Double.longBitsToDouble(0L));
         GlStateManager.scale(sapepori.fighting$, sapepori.fighting$, Double.longBitsToDouble(0L));
         _opened((double)mepicego, (double)(butosore + 20), (double)(mepicego + 110), (double)(butosore + 60), Color.BLACK.getRGB());
         _opened((double)(mepicego + 1), (double)(butosore + 20 + 1), (double)(mepicego + 110 - 1), (double)(butosore + 60 - 1), (new Color(55, 55, 55)).getRGB());
         _opened((double)(mepicego + 1), (double)butosore + 21.5D, (double)(mepicego + 108), (double)butosore + 58.5D, (new Color(30, 30, 30)).getRGB());
         _opened((double)(mepicego + 3), (double)(butosore + 20 + 3), (double)(mepicego + 110 - 3), (double)(butosore + 60 - 3), (new Color(14, 14, 14)).getRGB());
         Object var31 = mepicego + 3;
         butosore = butosore + 20 + 3;
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GuiInventory.drawEntityOnScreen(var31 + 15, butosore + 33, 15, ((EntityLivingBase)osecosub).rotationYaw, ((EntityLivingBase)osecosub).rotationPitch, (EntityLivingBase)osecosub);
         GlStateManager.resetColor();
         mepicego = var31 + 30;
         FontLoaders.TahomaBold14.drawStringWithShadow("§l" + ((EntityLivingBase)osecosub).getName(), (double)(mepicego + 0), (double)(butosore + 4), -1);
         RenderUtil5._poland((double)mepicego, (double)(butosore + 12), (double)(mepicego + 55), (double)(butosore + 16), 0.5D, (new Color(40, 40, 40)).getRGB(), Color.BLACK.getRGB());
         Object var42 = 55.0D * MathHelper.clamp_double((double)(((EntityLivingBase)osecosub).getHealth() / ((EntityLivingBase)osecosub).getMaxHealth()), Double.longBitsToDouble(0L), 1.0D);
         _opened((double)((float)mepicego + 0.5F), (double)((float)(butosore + 12) + 0.5F), (double)mepicego + var42 - 0.5D, (double)(butosore + 15), ColorUtil._enjoying((double)((EntityLivingBase)osecosub).getHealth(), (double)((EntityLivingBase)osecosub).getMaxHealth()).getRGB());
         Object var73 = 6;

         for(Object var86 = 0; var86 < 8; ++var86) {
            _opened((double)(mepicego + var73), (double)(butosore + 11), (double)((float)(mepicego + var73) + 0.5F), (double)(butosore + 15), Color.BLACK.getRGB());
            var73 += 6;
         }

         GlStateManager.pushMatrix();
         GlStateManager.scale(0.5D, 0.5D, 0.5D);
         sapepori.mc.fontRendererObj.drawStringWithShadow("HP:" + (int)((EntityLivingBase)osecosub).getHealth() + " | Dist:" + (int)sapepori.mc.thePlayer.getDistanceToEntity((Entity)osecosub), (float)((mepicego + 1) * 2), (float)((butosore + 17) * 2), -1);
         GlStateManager.popMatrix();
         if (osecosub instanceof EntityPlayer) {
            Object var87 = (EntityPlayer)osecosub;
            Object var101 = 3;

            for(Object var112 = 3; var112 >= 0; --var112) {
               Object var129 = var87.inventory.armorItemInSlot(var112);
               if (var129 != null) {
                  sapepori.mc.getRenderItem().renderItemIntoGUI(var129, mepicego - var101, butosore + 20);
                  var101 -= 15;
               }
            }

            Object var113 = var87.inventory.getCurrentItem();
            if (var113 != null) {
               RenderHelper.enableGUIStandardItemLighting();
               sapepori.mc.getRenderItem().renderItemIntoGUI(var113, mepicego - var101, butosore + 18);
               RenderHelper.disableStandardItemLighting();
            }

            GlStateManager.popMatrix();
            sapepori.bookmark$._skype();
         }
      }

      if (Objects.equals(sapepori.prophet$.getValue(), "Astolfo") && osecosub != null) {
         Gui.drawRect(mepicego, butosore, mepicego + 125, butosore + 45, -1442840576);
         GlStateManager.color(1.0F, 1.0F, 1.0F);
         _parent(mepicego + 12, butosore + 42, 20, -50.0F, Float.intBitsToFloat(0), (EntityLivingBase)osecosub);
         sapepori.mc.fontRendererObj.drawStringWithShadow(((EntityLivingBase)osecosub).getName(), (float)(mepicego + 25), (float)(butosore + 4), -1);
         GlStateManager.scale(2.0F, 2.0F, 1.0F);
         Object var43 = ESP2D._practice(12.0F, 0.7F, 1.0F, (long)1855041716 ^ 1855041716L);
         sapepori.mc.fontRendererObj.drawStringWithShadow(("" + (float)Math.round(((EntityLivingBase)osecosub).getHealth() * 10.0F) / 10.0F).replaceAll("\\.", ",") + " �?", (float)(mepicego + 25) / 2.0F, (float)(butosore + 16) / 2.0F, var43);
         GlStateManager.scale(0.5D, 0.5D, 1.0D);
         Gui.drawRect(mepicego + 25, butosore + 36, mepicego + 122, butosore + 42, var43);
         Gui.drawRect(mepicego + 25, butosore + 36, mepicego + 122, butosore + 42, -872415232);
         Object var58 = 97.0F / ((EntityLivingBase)osecosub).getMaxHealth();
         var58 = var58 * ((EntityLivingBase)osecosub).getHealth();
         sapepori.expenses$ += (var58 - sapepori.expenses$) / 5.0F;
         RenderUtils._storage((float)(mepicego + 25), (float)(butosore + 36), (float)(mepicego + 25) + sapepori.expenses$, (float)(butosore + 42), var43);
         RenderUtils._storage((float)(mepicego + 25) + sapepori.expenses$ - 4.0F, (float)(butosore + 36), (float)(mepicego + 25) + sapepori.expenses$, (float)(butosore + 42), 1610612736);
      }

      if (Objects.equals(sapepori.prophet$.getValue(), "Astolfo1") && osecosub != null) {
         if (osecosub == null || !(osecosub instanceof EntityPlayer)) {
            sapepori.mexican$ = 0;
            sapepori.diabetes$ = Double.longBitsToDouble(0L);
            return;
         }

         if (sapepori.fighting$ == Double.longBitsToDouble(0L)) {
            return;
         }

         GlStateManager.pushMatrix();
         GlStateManager.translate((float)mepicego, (float)butosore, Float.intBitsToFloat(0));
         GlStateManager.scale(sapepori.fighting$, sapepori.fighting$, Double.longBitsToDouble(0L));
         Object var44 = 22;
         Object var60 = 34;
         Object var74 = 2 + Math.max(sapepori.mc.fontRendererObj.getStringWidth(((EntityLivingBase)osecosub).getDisplayName().getFormattedText()) + 4, 85);
         Object var88 = String.valueOf((float)((int)((EntityLivingBase)osecosub).getHealth()) + ((EntityLivingBase)osecosub).getAbsorptionAmount() / 2.0F);
         RenderUtil5._usually(Float.intBitsToFloat(0), Float.intBitsToFloat(0), (float)(var44 + var74), (float)var60, (new Color(0, 5, 0, 180)).getRGB());
         GlStateManager.color(1.0F, 1.0F, 1.0F);
         Object var102 = ((EntityLivingBase)osecosub).getDisplayName().getFormattedText() + "";
         sapepori.mc.fontRendererObj.drawStringWithShadow(var102, (float)(var44 + 14), 1.0F, -1);
         sapepori.mc.fontRendererObj.drawStringWithShadow(var88, (float)(var44 + 14), 15.0F, (new Color(Colors._venture(((EntityLivingBase)osecosub).getHealth(), ((EntityLivingBase)osecosub).getMaxHealth()))).getRGB());
         sapepori.mc.fontRendererObj.drawStringWithShadow(EnumChatFormatting.RED + "�?", (float)(sapepori.mc.fontRendererObj.getStringWidth(var88) + var44 + 15), 14.5F, (new Color(Colors._venture(((EntityLivingBase)osecosub).getHealth(), ((EntityLivingBase)osecosub).getMaxHealth()))).getRGB());
         Object var114 = (double)((float)(var44 + var74 - 2) * ((EntityLivingBase)osecosub).getHealth() / ((EntityLivingBase)osecosub).getMaxHealth());
         RenderUtil5._integer((double)(var44 + 14), 28.0D, (double)(var44 + 14) + (double)(var44 + var74 - 2) / 1.5D, 32.0D, (new Color(0, 0, 0, 70)).getRGB());
         RenderUtil5._integer((double)(var44 + 14), 28.0D, (double)(var44 + 14) + var114 / 1.5D, 32.0D, (new Color(Colors._venture(((EntityLivingBase)osecosub).getHealth(), ((EntityLivingBase)osecosub).getMaxHealth()))).getRGB());
         Object var141 = (float)((EntityLivingBase)osecosub).hurtTime;
         float var153;
         if (var141 == Float.intBitsToFloat(0)) {
            var153 = 1.0F;
         } else if (var141 < 0.5F) {
            var153 = 1.0F - 0.2F * var141 * 1.0F;
         } else {
            var153 = 0.8F + 0.2F * (var141 - 0.5F) * 0.1F;
         }

         Object egedobur = 34;
         GL11.glPushMatrix();
         GL11.glScalef(var153, var153, var153);
         GL11.glTranslatef((float)egedobur * 0.5F * (1.0F - var153) / var153, (float)egedobur * 0.5F * (1.0F - var153) / var153, Float.intBitsToFloat(0));
         GL11.glColor4f(1.0F, 1.0F - var141, 1.0F - var141, 1.0F);
         sapepori._catalog(((AbstractClientPlayer)osecosub).getLocationSkin(), 0, 0, egedobur, egedobur);

         for(Object orilepud : sapepori.packages$) {
            orilepud.profiles$ = 15.0F;
            orilepud.shops$ = 15.0F;
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            if (orilepud.winter$ > 4.0F) {
               orilepud._gilbert();
            }
         }

         if (sapepori.vehicles$._herself((long)-1819503109 ^ -1819503125L, true)) {
            for(Object var173 : sapepori.packages$) {
               var173._bradley();
               if (var173.winter$ < 1.0F) {
                  sapepori.packages$.remove(var173);
               }
            }
         }

         if (((EntityLivingBase)osecosub).hurtTime == 9 && !sapepori.tackle$) {
            for(Object var168 = 0; var168 <= 25; ++var168) {
               Object var174 = new TargetHUD();
               var174._boulder((float)(mepicego + 20), (float)(butosore + 20), (float)((Math.random() - 0.5D) * 2.0D * 1.4D), (float)((Math.random() - 0.5D) * 2.0D * 1.4D), (float)(Math.random() * 4.0D), var168 % 2 == 0 ? new Color(HUD.during$.getValue().intValue()) : new Color(HUD.cosmetic$.getValue().intValue()));
               sapepori.packages$.add(var174);
            }

            sapepori.tackle$ = true;
         }

         if (((EntityLivingBase)osecosub).hurtTime == 8) {
            sapepori.tackle$ = false;
         }

         RenderUtil5._usually(Float.intBitsToFloat(0), Float.intBitsToFloat(0), (float)egedobur, (float)egedobur, (new Color(255, 0, 0, ((EntityLivingBase)osecosub).hurtTime * 20)).getRGB());
         GL11.glPopMatrix();
         GlStateManager.popMatrix();
      }

      if (Objects.equals(sapepori.prophet$.getValue(), "123") && osecosub != null) {
         if (sapepori.fighting$ == Double.longBitsToDouble(0L)) {
            return;
         }

         GL11.glPushMatrix();
         Object var61 = ((EntityLivingBase)osecosub).getDisplayName().getFormattedText();
         Object var75 = "";
         Object var89 = (float)Math.max(80, sapepori.mc.fontRendererObj.getStringWidth(var75 + var61) + 15);
         Object var103 = (double)Math.round(((EntityLivingBase)osecosub).getHealth() * 10.0F) / 10.0D + " �?";
         GL11.glTranslatef((float)mepicego, (float)butosore, Float.intBitsToFloat(0));
         GlStateManager.scale(sapepori.fighting$, sapepori.fighting$, Double.longBitsToDouble(0L));
         RenderUtil5._archived(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), (double)(55.0F + var89), 50.0D, 2.0D, (new Color(0, 0, 0, 120)).getRGB(), 0, Float.intBitsToFloat(0));
         GuiInventory.drawEntityOnScreen(16, 43, 20, 18.0F, ((EntityLivingBase)osecosub).rotationYaw, (EntityLivingBase)osecosub);
         sapepori.mc.fontRendererObj.drawStringWithShadow(var75 + ((EntityLivingBase)osecosub).getName().toLowerCase(Locale.ROOT), 36.0F, 2.5F, ColorUtils.liquid$.hygiene$);
         Object var115 = Float.isNaN(((EntityLivingBase)osecosub).getHealth());
         Object var130 = var115 ? 20.0F : ((EntityLivingBase)osecosub).getHealth();
         Object var142 = var115 ? 20.0F : ((EntityLivingBase)osecosub).getMaxHealth();
         Object var154 = MathUtils._fatty(var130 / var142, Float.intBitsToFloat(0), 1.0F);
         Object var160 = (int)(var154 * 120.0F);
         Object var45 = ColorUtils2._reward(new Color(HUD.during$.getValue().intValue()), mepicego / 6, 10).getRGB();
         GlStateManager.pushMatrix();
         GL11.glScalef(1.3F, 1.3F, 1.3F);
         sapepori.mc.fontRendererObj.drawStringWithShadow(var103, 28.0F, 11.5F, var45);
         GlStateManager.popMatrix();
         Object var169 = 43.0F + var89 - 2.0F - 32.0F;
         Object var175 = 8.0F + var169 / 100.0F * var154 * 100.0F;
         if (sapepori.heard$ <= Float.intBitsToFloat(0)) {
            sapepori.heard$ = var175;
         }

         if (((EntityLivingBase)osecosub).hurtTime <= 6) {
            sapepori.heard$ = AnimationUtils2._presents(sapepori.heard$, var175, (float)Math.max(10.0D, (double)(Math.abs(sapepori.heard$ - var175) * 30.0F) * 0.4D));
         }

         GuiRenderUtils._pamela(36.0F, 40.5F, 45.0F + var89 - 28.5F, 4.5F, RenderUtil5._virgin(var45, 0.35F));
         GuiRenderUtils._pamela(36.0F, 40.5F, var175, 4.5F, var45);
         GL11.glPopMatrix();
         sapepori.bookmark$._skype();
      }

      if (Objects.equals(sapepori.prophet$.getValue(), "Zeriy2")) {
         if (osecosub != null) {
            if (sapepori.fighting$ == Double.longBitsToDouble(0L)) {
               return;
            }

            GlStateManager.pushMatrix();
            GlStateManager.translate((double)mepicego * (1.0D - sapepori.fighting$), (double)butosore * (1.0D - sapepori.fighting$), Double.longBitsToDouble(0L));
            GlStateManager.scale(sapepori.fighting$, sapepori.fighting$, Double.longBitsToDouble(0L));
            Object var46 = (float)Math.max(110, FontLoaders.SF18.getStringWidth(((EntityLivingBase)osecosub).getDisplayName().getFormattedText()) + 70);
            RoundedUtil._ticket((float)eruseron + 16.0F, (float)(oguyivul + 27), 127.5F, 35.0F, 3.0F, new Color(0, 0, 0, 40));
            RenderUtils._laptops((float)eruseron + 16.0F, (float)(oguyivul + 27), 127.5F, 35.0F, 20, new Color(0, 0, 0, 180));
            GlStateManager.pushMatrix();
            FontLoaders.kiona16.drawStringWithShadow(((EntityLivingBase)osecosub).getDisplayName().getFormattedText(), (double)((float)eruseron + 51.5F), (double)(oguyivul + 31), (new Color(HUD.during$.getValue().intValue())).getRGB());
            GlStateManager.popMatrix();
            Object var62 = (double)(88.0F * (((EntityLivingBase)osecosub).getHealth() / ((EntityLivingBase)osecosub).getMaxHealth()));
            sapepori.pearl$._watts((float)var62, Float.intBitsToFloat(0), 0.15F);
            Object var90 = 38.5D;
            if (((EntityLivingBase)osecosub).getHealth() == 19.0F) {
               var90 = 46.0D;
            } else if (((EntityLivingBase)osecosub).getHealth() == 18.0F) {
               var90 = 51.0D;
            } else if (((EntityLivingBase)osecosub).getHealth() < 20.0F) {
               var90 = 56.0D;
            }

            FontLoaders.kiona14.drawStringWithShadow((int)((EntityLivingBase)osecosub).getHealth() + "%", (double)eruseron + var90 + var62, (double)(oguyivul + 47), -1);
            RenderUtil5._integer((double)(eruseron + 52), (double)((float)oguyivul + 54.0F), (double)(eruseron + 52) + var62, (double)(oguyivul + 58), (new Color(HUD.during$.getValue().intValue())).getRGB());
            if (osecosub instanceof EntityPlayer) {
               StencilUtil._murphy();
               StencilUtil._country();
               RenderUtils._hazard((float)(eruseron + 19), (float)(oguyivul + 29), (float)(eruseron + 19 + 30), (float)(oguyivul + 29 + 30), 4.0F);
               StencilUtil._mirrors(1);
               GlStateManager.enableBlend();
               GlStateManager.blendFunc(770, 771);
               GlStateManager.alphaFunc(516, Float.intBitsToFloat(0));
               GlStateManager.enableTexture2D();
               sapepori.mc.getTextureManager().bindTexture(((AbstractClientPlayer)osecosub).getLocationSkin());
               GlStateManager.resetColor();
               GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
               Gui.drawScaledCustomSizeModalRect(eruseron + 19, oguyivul + 29, 4.0F, 4.0F, 4, 4, 30, 30, 32.0F, 32.0F);
               RenderUtil5._usually((float)(eruseron + 19), (float)(oguyivul + 29), (float)(eruseron + 49), (float)(oguyivul + 59), (new Color(255, 0, 0, ((EntityLivingBase)osecosub).hurtTime * 20)).getRGB());
               GlStateManager.disableBlend();
               StencilUtil._involve();
            }

            for(Object var131 : sapepori.packages$) {
               var131.profiles$ = (float)(mepicego + 32);
               var131.shops$ = (float)(butosore + 42);
               GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
               if (var131.winter$ > 4.0F) {
                  var131._gilbert();
               }
            }

            if (sapepori.vehicles$._herself((long)-2134095797 ^ -2134095781L, true)) {
               for(Object var132 : sapepori.packages$) {
                  var132._bradley();
                  if (var132.winter$ < 1.0F) {
                     sapepori.packages$.remove(var132);
                  }
               }
            }

            if (((EntityLivingBase)osecosub).hurtTime == 9 && !sapepori.tackle$) {
               for(Object var118 = 0; var118 <= 25; ++var118) {
                  Object var133 = new TargetHUD();
                  var133._boulder((float)(mepicego + 20), (float)(butosore + 20), (float)((Math.random() - 0.5D) * 2.0D * 1.4D), (float)((Math.random() - 0.5D) * 2.0D * 1.4D), (float)(Math.random() * 4.0D), var118 % 2 == 0 ? new Color(HUD.during$.getValue().intValue()) : new Color(HUD.cosmetic$.getValue().intValue()));
                  sapepori.packages$.add(var133);
               }

               sapepori.tackle$ = true;
            }

            if (((EntityLivingBase)osecosub).hurtTime == 8) {
               sapepori.tackle$ = false;
            }

            GlStateManager.popMatrix();
            sapepori.bookmark$._skype();
         }
      } else {
         sapepori.pearl$._plastic(Float.intBitsToFloat(0));
      }

      if (Objects.equals(sapepori.prophet$.getValue(), "New")) {
         if (osecosub != null) {
            if (sapepori.fighting$ == Double.longBitsToDouble(0L)) {
               return;
            }

            GlStateManager.pushMatrix();
            GlStateManager.translate((double)mepicego * (1.0D - sapepori.fighting$), (double)butosore * (1.0D - sapepori.fighting$), Double.longBitsToDouble(0L));
            GlStateManager.scale(sapepori.fighting$, sapepori.fighting$, Double.longBitsToDouble(0L));
            RenderUtil5._poland((double)((float)eruseron + 15.5F), (double)(oguyivul + 25), (double)(eruseron + 135), (double)(oguyivul + 71), 1.0D, (new Color(0, 0, 0, 200)).getRGB(), HUD._bargains().getRGB());
            FontLoaders.kiona18.drawString(((EntityLivingBase)osecosub).getName(), (float)(eruseron + 58), (float)(oguyivul + 30), -1);
            FontLoaders.kiona14.drawString("H", (float)(eruseron + 58), (float)(oguyivul + 40), HUD._bargains().getRGB());
            RenderUtil5._usually((float)(eruseron + 64), (float)(oguyivul + 41), (float)(eruseron + 130), (float)(oguyivul + 44), (new Color(70, 70, 70)).getRGB());
            Object var47 = (double)(66.0F * (((EntityLivingBase)osecosub).getHealth() / ((EntityLivingBase)osecosub).getMaxHealth()));
            sapepori.pearl$._watts((float)var47, Float.intBitsToFloat(0), 0.15F);
            RenderUtil5._usually((float)(eruseron + 64), (float)(oguyivul + 41), (float)(eruseron + 64) + sapepori.pearl$._heath(), (float)(oguyivul + 44), ColorUtil._assure(HUD._bargains(), 100, 255).getRGB());
            RenderUtil5._integer((double)(eruseron + 64), (double)(oguyivul + 41), (double)(eruseron + 64) + var47, (double)(oguyivul + 44), HUD._bargains().getRGB());
            FontLoaders.kiona14.drawString("T", (float)eruseron + 58.5F, (float)(oguyivul + 48), -1);
            RenderUtil5._usually((float)(eruseron + 64), (float)(oguyivul + 49), (float)(eruseron + 130), (float)(oguyivul + 52), (new Color(70, 70, 70)).getRGB());
            Object var76 = (double)((EntityLivingBase)osecosub).hurtResistantTime * 3.3D;
            sapepori.chargers$._watts((float)var76, Float.intBitsToFloat(0), 0.5F);
            RenderUtil5._usually((float)(eruseron + 64), (float)(oguyivul + 49), (float)(eruseron + 64) + sapepori.chargers$._heath(), (float)(oguyivul + 52), HUD._bargains().getRGB());
            Object var104 = Math.round(((EntityLivingBase)osecosub).getHealth());
            Object var119 = Math.round(sapepori.mc.thePlayer.getHealth());
            Object var134 = var104 > var119 ? "Lose" : (var104 == var119 ? "Draw" : "Win");
            FontLoaders.kiona18.drawString(var134, (float)eruseron + 58.5F, (float)oguyivul + 57.5F, -1);

            for(Object var155 : GuiPlayerTabOverlay.field_175252_a.sortedCopy(sapepori.mc.thePlayer.sendQueue.getPlayerInfoMap())) {
               Object var161 = (NetworkPlayerInfo)var155;
               if (sapepori.mc.theWorld.getPlayerEntityByUUID(var161.getGameProfile().getId()) == osecosub) {
                  sapepori.mc.getTextureManager().bindTexture(var161.getLocationSkin());
                  Gui.drawScaledCustomSizeModalRect(eruseron + 20, oguyivul + 30, 8.0F, 8.0F, 8, 8, 36, 36, 64.0F, 64.0F);
                  GlStateManager.bindTexture(0);
                  break;
               }
            }

            for(Object var156 : sapepori.packages$) {
               var156.profiles$ = (float)(mepicego + 35);
               var156.shops$ = (float)(butosore + 43);
               GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
               if (var156.winter$ > 4.0F) {
                  var156._gilbert();
               }
            }

            if (sapepori.vehicles$._herself((long)991527395 ^ 991527411L, true)) {
               for(Object var157 : sapepori.packages$) {
                  var157._bradley();
                  if (var157.winter$ < 1.0F) {
                     sapepori.packages$.remove(var157);
                  }
               }
            }

            if (((EntityLivingBase)osecosub).hurtTime == 9 && !sapepori.tackle$) {
               for(Object var146 = 0; var146 <= 25; ++var146) {
                  Object var158 = new TargetHUD();
                  var158._boulder((float)(mepicego + 20), (float)(butosore + 20), (float)((Math.random() - 0.5D) * 2.0D * 1.4D), (float)((Math.random() - 0.5D) * 2.0D * 1.4D), (float)(Math.random() * 4.0D), var146 % 2 == 0 ? new Color(HUD.during$.getValue().intValue()) : new Color(HUD.cosmetic$.getValue().intValue()));
                  sapepori.packages$.add(var158);
               }

               sapepori.tackle$ = true;
            }

            if (((EntityLivingBase)osecosub).hurtTime == 8) {
               sapepori.tackle$ = false;
            }

            RenderUtil5._usually((float)(eruseron + 20), (float)(oguyivul + 30), (float)(eruseron + 56), (float)(oguyivul + 66), (new Color(255, 0, 0, ((EntityLivingBase)osecosub).hurtTime * 20)).getRGB());
            GlStateManager.popMatrix();
            sapepori.bookmark$._skype();
         }
      } else {
         sapepori.pearl$._plastic(Float.intBitsToFloat(0));
         sapepori.chargers$._plastic(Float.intBitsToFloat(0));
      }

      if (Objects.equals(sapepori.prophet$.getValue(), "Old")) {
         if (osecosub != null) {
            if (sapepori.fighting$ == Double.longBitsToDouble(0L)) {
               return;
            }

            GlStateManager.pushMatrix();
            GlStateManager.translate((double)mepicego * (1.0D - sapepori.fighting$), (double)butosore * (1.0D - sapepori.fighting$), Double.longBitsToDouble(0L));
            GlStateManager.scale(sapepori.fighting$, sapepori.fighting$, Double.longBitsToDouble(0L));
            Object var63 = ((EntityLivingBase)osecosub).getDisplayName().getFormattedText();
            Object var77 = "H:" + MathUtil._teach((double)((EntityLivingBase)osecosub).getHealth(), 2);
            Object var91 = Math.round(((EntityLivingBase)osecosub).getHealth());
            int var48;
            Object var105 = var91 > (var48 = Math.round(sapepori.mc.thePlayer.getHealth())) ? "Lose." : (var91 == var48 ? "Draw." : "Win.");
            Object var120 = sapepori.mc.fontRendererObj.getStringWidth(var63) + sapepori.mc.fontRendererObj.getStringWidth(var77) / 2 + 7;
            RenderUtil5._usually((float)(eruseron + 30), (float)(oguyivul + 15), (float)(eruseron + 30 + var120 + 1), (float)(oguyivul + 30), (new Color(15, 15, 15, 180)).getRGB());
            Object var135 = ColorUtils2._reward(new Color(HUD.during$.getValue().intValue()), 1, 14).getRGB();
            GlStateManager.pushMatrix();
            sapepori.mc.fontRendererObj.drawStringWithShadow(((EntityLivingBase)osecosub).getName(), (float)(eruseron + 33), (float)(oguyivul + 18), var135);
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
            sapepori.mc.fontRendererObj.drawString(var105, (eruseron + 33 + sapepori.mc.fontRendererObj.getStringWidth(var63) + 2) * 2, oguyivul * 2 + 35, var135);
            sapepori.mc.fontRendererObj.drawString(var77, (eruseron + 33 + sapepori.mc.fontRendererObj.getStringWidth(var63) + 2) * 2, oguyivul * 2 + 45, var135);
            GlStateManager.popMatrix();
            Object var147 = (float)((double)(var120 + 1) * MathHelper.clamp_double((double)(((EntityLivingBase)osecosub).getHealth() / ((EntityLivingBase)osecosub).getMaxHealth()), Double.longBitsToDouble(0L), 1.0D));
            sapepori.pearl$._watts(var147, Float.intBitsToFloat(0), 0.1F);
            Object var159 = ((EntityLivingBase)osecosub).getHealth();
            if (var159 > 20.0F) {
               var159 = 20.0F;
            }

            Object var162 = new float[]{Float.intBitsToFloat(0), 0.5F, 1.0F};
            Object var170 = new Color[]{Color.RED, Color.YELLOW, Color.GREEN};
            Object var176 = var159 * 5.0F * 0.01F;
            Object enovibat = ColorUtil._crafts(var162, var170, var176).brighter();
            Object alonorit = enovibat.getRGB();
            RenderUtil5._usually((float)(eruseron + 30), (float)(oguyivul + 29), (float)(eruseron + 30) + sapepori.pearl$._heath(), (float)(oguyivul + 30), ColorUtil._assure(new Color(var135), 50, 255).getRGB());
            RenderUtil5._usually((float)(eruseron + 30), (float)(oguyivul + 29), (float)(eruseron + 30) + var147, (float)(oguyivul + 30), var135);
            GlStateManager.popMatrix();
            sapepori.bookmark$._skype();
         }
      } else {
         sapepori.pearl$._plastic(Float.intBitsToFloat(0));
      }

      if (Objects.equals(sapepori.prophet$.getValue(), "Skid1")) {
         new ScaledResolution(sapepori.mc);
         if (osecosub == null || !(osecosub instanceof EntityPlayer)) {
            sapepori.mexican$ = 0;
            sapepori.diabetes$ = Double.longBitsToDouble(0L);
            return;
         }

         Object var64 = 22;
         Object var78 = 34;
         Object var92 = 2 + Math.max(sapepori.mc.fontRendererObj.getStringWidth(((EntityLivingBase)osecosub).getDisplayName().getFormattedText()) + 12, 85);
         Object var106 = String.valueOf((float)((int)((EntityLivingBase)osecosub).getHealth()) / 2.0F);
         GlStateManager.pushMatrix();
         GlStateManager.translate((float)mepicego, (float)butosore, Float.intBitsToFloat(0));
         RenderUtils._storage(Float.intBitsToFloat(0), Float.intBitsToFloat(0), (float)(var64 + var92), (float)var78, (new Color(0, 0, 0, 180)).getRGB());
         GlStateManager.color(1.0F, 1.0F, 1.0F);
         if (((EntityLivingBase)osecosub).getHealth() > 10.0F) {
            RenderUtil5._depend(new Color(-16711936), new Color(-256), (double)(1.0F / ((EntityLivingBase)osecosub).getHealth() / 2.0F * (((EntityLivingBase)osecosub).getHealth() - 10.0F))).getRGB();
         } else {
            RenderUtil5._depend(new Color(-256), new Color(-65536), (double)(0.1F * ((EntityLivingBase)osecosub).getHealth())).getRGB();
         }

         Object var136 = EnumChatFormatting.BOLD + "" + ((EntityLivingBase)osecosub).getDisplayName().getFormattedText() + "";
         sapepori.mc.fontRendererObj.drawStringWithShadow(var136, (float)(var64 + 13), 3.0F, -1);
         GlStateManager.pushMatrix();
         GlStateManager.scale(0.5D, 0.5D, 0.5D);
         sapepori.mc.fontRendererObj.drawStringWithShadow("Dist>> " + var106, (float)(var64 + 49), 39.0F, -1);
         sapepori.mc.fontRendererObj.drawStringWithShadow("Armor>> " + ((EntityLivingBase)osecosub).getTotalArmorValue() + ".0", (float)(var64 + 110), 39.0F, -1);
         sapepori.mc.fontRendererObj.drawStringWithShadow("Heal>> " + (int)((EntityLivingBase)osecosub).getHealth() + ".0", (float)(var64 + 49), 53.0F, -1);
         sapepori.mc.fontRendererObj.drawStringWithShadow("Blocking>> " + ((EntityPlayer)osecosub).isBlocking(), (float)(var64 + 110), 53.0F, -1);
         GlStateManager.popMatrix();
         Object var148 = (double)((float)(var64 + var92 - 2) * ((EntityLivingBase)osecosub).getHealth() / ((EntityLivingBase)osecosub).getMaxHealth());
         if ((double)sapepori.mexican$ > var148) {
            sapepori.mexican$ = MathUtil._military(sapepori.mexican$, (int)var148, 20.0D);
         }

         if ((double)sapepori.mexican$ < var148) {
            sapepori.mexican$ = MathUtil._military(sapepori.mexican$, (int)var148, 20.0D);
         }

         Object var163 = true;
         RenderUtil5._tramadol((double)(var64 + 13), 13.0D, (double)(var64 + 13) + (double)sapepori.mexican$ / 1.5D, 16.0D, (new Color(HUD.during$.getValue().intValue())).getRGB(), _yearly(((EntityLivingBase)osecosub).getHealth(), ((EntityLivingBase)osecosub).getMaxHealth()).getRGB());
         Object var171 = false;
         Object var177 = false;
         Object var181 = (float)((EntityLivingBase)osecosub).hurtTime;
         float var185;
         if (var181 == Float.intBitsToFloat(0)) {
            var185 = 1.0F;
         } else if (var181 < 0.5F) {
            var185 = 1.0F - 0.2F * var181 * 1.0F;
         } else {
            var185 = 0.8F + 0.2F * (var181 - 0.5F) * 0.1F;
         }

         Object erobegap = 32;
         GL11.glPushMatrix();
         GL11.glScalef(var185, var185, var185);
         GL11.glTranslatef((float)erobegap * 0.5F * (1.0F - var185) / var185, (float)erobegap * 0.5F * (1.0F - var185) / var185, Float.intBitsToFloat(0));
         GL11.glColor4f(1.0F, 1.0F - var181, 1.0F - var181, 1.0F);
         sapepori._catalog(((AbstractClientPlayer)osecosub).getLocationSkin(), 1, 1, erobegap, erobegap);
         GL11.glPopMatrix();
         GlStateManager.popMatrix();
      }

      if (Objects.equals(sapepori.prophet$.getValue(), "Raven")) {
         new ScaledResolution(sapepori.mc);
         if (osecosub == null || !(osecosub instanceof EntityPlayer)) {
            sapepori.mexican$ = 0;
            return;
         }

         if (sapepori.fighting$ == Double.longBitsToDouble(0L)) {
            return;
         }

         Object var65 = 22;
         Object var79 = 28;
         Object var93 = 2 + Math.max(sapepori.mc.fontRendererObj.getStringWidth(((EntityLivingBase)osecosub).getDisplayName().getFormattedText()) + 25, 90);
         GlStateManager.pushMatrix();
         GlStateManager.translate((double)(mepicego * 1) + sapepori.fighting$, (double)(butosore * 1) + sapepori.fighting$, Double.longBitsToDouble(0L));
         GlStateManager.scale(sapepori.fighting$, sapepori.fighting$, Double.longBitsToDouble(0L));
         RenderUtils._storage(Float.intBitsToFloat(0), Float.intBitsToFloat(0), (float)(var65 + var93), (float)var79, (new Color(0, 0, 0, 120)).getRGB());
         GlStateManager.color(1.0F, 1.0F, 1.0F);
         Object var107 = ColorUtils2._reward(new Color(HUD.during$.getValue().intValue()), 1, 14).getRGB();
         Object var121 = EnumChatFormatting.BOLD + "ft.sleep.module.modules.Target�?";
         sapepori.mc.fontRendererObj.drawStringWithShadow(var121 + ((EntityLivingBase)osecosub).getDisplayName().getFormattedText(), (float)(var65 - 18), 4.0F, -1);
         Object var137 = "" + EnumChatFormatting.WHITE + EnumChatFormatting.BOLD + "Health�?";
         sapepori.mc.fontRendererObj.drawStringWithShadow(var137 + EnumChatFormatting.RESET + "" + (float)((int)((EntityLivingBase)osecosub).getHealth()) / 2.0F, (float)(var65 - 17), 17.0F, (new Color(Colors._venture(((EntityLivingBase)osecosub).getHealth(), ((EntityLivingBase)osecosub).getMaxHealth()))).getRGB());
         Object var149 = (double)((float)(var93 - 2) * ((EntityLivingBase)osecosub).getHealth() / ((EntityLivingBase)osecosub).getMaxHealth());
         if ((double)sapepori.mexican$ > var149) {
            sapepori.mexican$ = MathUtil._military(sapepori.mexican$, (int)var149, 2.0D);
         }

         if ((double)sapepori.mexican$ < var149) {
            sapepori.mexican$ = MathUtil._military(sapepori.mexican$, (int)var149, 2.0D);
         }

         RenderUtil5._integer((double)(var65 - 23), (double)(28 - sapepori.mexican$ / 3) + 2.5D, (double)(var65 - 22), 28.0D, (new Color(Colors._venture(((EntityLivingBase)osecosub).getHealth(), ((EntityLivingBase)osecosub).getMaxHealth()))).getRGB());
         GlStateManager.popMatrix();
         sapepori.bookmark$._skype();
      }

      if (Objects.equals(sapepori.prophet$.getValue(), "Normal")) {
         new ScaledResolution(sapepori.mc);
         if (osecosub == null || !(osecosub instanceof EntityPlayer)) {
            sapepori.mexican$ = 0;
            sapepori.diabetes$ = Double.longBitsToDouble(0L);
            return;
         }

         Object var66 = 22;
         Object var80 = 34;
         Object var94 = 2 + Math.max(sapepori.mc.fontRendererObj.getStringWidth(((EntityLivingBase)osecosub).getDisplayName().getFormattedText()) + 2, 85);
         Object var108 = String.valueOf((float)((int)((EntityLivingBase)osecosub).getHealth()) / 2.0F);
         GlStateManager.pushMatrix();
         GlStateManager.translate((double)(mepicego * 1) + sapepori.fighting$, (double)(butosore * 1) + sapepori.fighting$, Double.longBitsToDouble(0L));
         GlStateManager.scale(sapepori.fighting$, sapepori.fighting$, Double.longBitsToDouble(0L));
         RenderUtil4._expanded(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), (double)(var66 + 3 + var94), (double)(var80 + 2));
         GlStateManager.color(1.0F, 1.0F, 1.0F);
         if (((EntityLivingBase)osecosub).getHealth() > 10.0F) {
            RenderUtil5._depend(new Color(-16711936), new Color(-256), (double)(1.0F / ((EntityLivingBase)osecosub).getHealth() / 2.0F * (((EntityLivingBase)osecosub).getHealth() - 10.0F))).getRGB();
         } else {
            RenderUtil5._depend(new Color(-256), new Color(-65536), (double)(0.1F * ((EntityLivingBase)osecosub).getHealth())).getRGB();
         }

         Object var138 = EnumChatFormatting.BOLD + "" + ((EntityLivingBase)osecosub).getDisplayName().getFormattedText() + "";
         FontLoaders.TahomaBold13.drawStringWithShadow(var138, (double)(var66 + 13), 7.0D, -1);
         FontLoaders.TahomaBold10.drawStringWithShadow("Dist: " + var108, (double)(var66 + 13), 21.0D, -1);
         FontLoaders.TahomaBold10.drawStringWithShadow("Armor: " + ((EntityLivingBase)osecosub).getTotalArmorValue() + ".0", (double)(var66 + 43), 21.0D, -1);
         FontLoaders.TahomaBold10.drawStringWithShadow("Heal: " + (int)((EntityLivingBase)osecosub).getHealth() + ".0", (double)(var66 + 13), 28.0D, -1);
         FontLoaders.TahomaBold10.drawStringWithShadow("Blocking: " + ((EntityPlayer)osecosub).isBlocking(), (double)(var66 + 43), 28.0D, -1);
         Object var150 = (double)((float)(var66 + var94 - 2) * ((EntityLivingBase)osecosub).getHealth() / ((EntityLivingBase)osecosub).getMaxHealth());
         if ((double)sapepori.mexican$ > var150) {
            sapepori.mexican$ = MathUtil._military(sapepori.mexican$, (int)var150, 20.0D);
         }

         if ((double)sapepori.mexican$ < var150) {
            sapepori.mexican$ = MathUtil._military(sapepori.mexican$, (int)var150, 20.0D);
         }

         Object var164 = true;
         RenderUtil5._tramadol((double)(var66 + 13), 13.0D, (double)(var66 + 13) + (double)sapepori.mexican$ / 1.5D, 16.0D, (new Color(HUD.during$.getValue().intValue())).getRGB(), _yearly(((EntityLivingBase)osecosub).getHealth(), ((EntityLivingBase)osecosub).getMaxHealth()).getRGB());
         Object var172 = false;
         Object var178 = false;
         Object var182 = (float)((EntityLivingBase)osecosub).hurtTime;
         float var186;
         if (var182 == Float.intBitsToFloat(0)) {
            var186 = 1.0F;
         } else if (var182 < 0.5F) {
            var186 = 1.0F - 0.2F * var182 * 1.0F;
         } else {
            var186 = 0.8F + 0.2F * (var182 - 0.5F) * 0.1F;
         }

         Object var189 = 28;
         GL11.glPushMatrix();
         GL11.glScalef(var186, var186, var186);
         GL11.glTranslatef((float)var189 * 0.5F * (1.0F - var186) / var186, (float)var189 * 0.5F * (1.0F - var186) / var186, Float.intBitsToFloat(0));
         GL11.glColor4f(1.0F, 1.0F - var182, 1.0F - var182, 1.0F);
         sapepori._catalog(((AbstractClientPlayer)osecosub).getLocationSkin(), 4, 4, var189, var189);
         GL11.glPopMatrix();
         GlStateManager.popMatrix();
         sapepori.bookmark$._skype();
      }

      if (Objects.equals(sapepori.prophet$.getValue(), "Stella")) {
         new ScaledResolution(sapepori.mc);
         if (osecosub == null || !(osecosub instanceof EntityPlayer)) {
            sapepori.mexican$ = 0;
            sapepori.diabetes$ = Double.longBitsToDouble(0L);
            return;
         }

         if (sapepori.fighting$ == Double.longBitsToDouble(0L)) {
            return;
         }

         Object var67 = 21;
         Object var81 = 40;
         Object var95 = 2 + Math.max(sapepori.mc.fontRendererObj.getStringWidth(((EntityLivingBase)osecosub).getDisplayName().getFormattedText()) + 5, 85);
         Object var109 = String.valueOf((float)((int)((EntityLivingBase)osecosub).getHealth()) / 2.0F);
         GlStateManager.pushMatrix();
         GlStateManager.translate((double)(mepicego * 1) + sapepori.fighting$, (double)(butosore * 1) + sapepori.fighting$, Double.longBitsToDouble(0L));
         GlStateManager.scale(sapepori.fighting$, sapepori.fighting$, Double.longBitsToDouble(0L));
         GlStateManager.color(1.0F, 1.0F, 1.0F);
         RenderUtil5._norman(3.0D, -2.0D, (double)var67 + (double)var95, (double)var81, 4.0D, (new Color(41, 39, 44, 235)).getRGB());
         if (((EntityLivingBase)osecosub).getHealth() > 10.0F) {
            RenderUtil5._depend(new Color(255, 2, 12), new Color(-180), (double)(1.0F / ((EntityLivingBase)osecosub).getHealth() / 2.0F * (((EntityLivingBase)osecosub).getHealth() - 10.0F))).getRGB();
         } else {
            RenderUtil5._depend(new Color(-256), new Color(-65536), (double)(0.1F * ((EntityLivingBase)osecosub).getHealth())).getRGB();
         }

         Object var139 = "" + ((EntityLivingBase)osecosub).getDisplayName().getFormattedText() + "";
         FontLoaders.TahomaBold16.drawStringWithShadow(var139, (double)(var67 + 9), 4.0D, -1);
         FontLoaders.TahomaBold12.drawStringWithShadow("Health: " + var109, (double)(var67 + 9), 14.8D, -1);
         FontLoaders.logo10.drawStringWithShadow("s", (double)(var67 - 15), 28.5D, (new Color(255, 85, 85)).getRGB());
         FontLoaders.logo10.drawStringWithShadow("r", (double)(var67 - 15), 35.5D, (new Color(87, 160, 250)).getRGB());
         Object var151 = (double)((float)(var67 + var95 - 2) * ((EntityLivingBase)osecosub).getHealth() / ((EntityLivingBase)osecosub).getMaxHealth());
         if ((double)sapepori.mexican$ > var151) {
            sapepori.mexican$ = MathUtil._military(sapepori.mexican$, (int)var151, 20.0D);
         }

         if ((double)sapepori.mexican$ < var151) {
            sapepori.mexican$ = MathUtil._military(sapepori.mexican$, (int)var151, 20.0D);
         }

         Object var165 = (double)((var67 + var95 - 2) * ((EntityLivingBase)osecosub).getTotalArmorValue());
         if (sapepori.diabetes$ > var165) {
            sapepori.diabetes$ = (double) MathUtil._military((int)sapepori.diabetes$, (int)var165, 20.0D);
         }

         if (sapepori.diabetes$ < var165) {
            sapepori.diabetes$ = (double) MathUtil._military((int)sapepori.diabetes$, (int)var165, 20.0D);
         }

         Object var179 = true;
         RenderUtils._illness((double)(var67 - 9), 27.5D, (double)(var67 - 9) + (double)sapepori.mexican$ / 1.15D, 29.5D, Colors._venture(((EntityLivingBase)osecosub).getHealth(), ((EntityLivingBase)osecosub).getMaxHealth()));
         RenderUtils._illness((double)(var67 - 9), 34.0D, (double)(var67 - 9) + sapepori.diabetes$ / 23.0D, 36.0D, (new Color(87, 160, 250)).getRGB());
         Object var183 = false;
         Object var187 = false;
         Object var190 = (float)((EntityLivingBase)osecosub).hurtTime;
         float cayicofi;
         if (var190 == Float.intBitsToFloat(0)) {
            cayicofi = 1.0F;
         } else if (var190 < 0.5F) {
            cayicofi = 1.0F - 0.2F * var190 * 1.0F;
         } else {
            cayicofi = 0.8F + 0.2F * (var190 - 0.5F) * 0.1F;
         }

         Object olezecep = 22;
         GL11.glPushMatrix();
         GL11.glScalef(cayicofi, cayicofi, cayicofi);
         GL11.glTranslatef((float)olezecep * 0.5F * (1.0F - cayicofi) / cayicofi, (float)olezecep * 0.5F * (1.0F - cayicofi) / cayicofi, Float.intBitsToFloat(0));
         GL11.glColor4f(1.0F, 1.0F - var190, 1.0F - var190, 1.0F);
         sapepori._sciences(4.5D, 0.5D, 27.5D, 23.5D, 0.5D, 0, (new Color(87, 160, 250)).getRGB());
         sapepori._catalog(((AbstractClientPlayer)osecosub).getLocationSkin(), 5, 1, olezecep, olezecep);
         RenderUtil5._usually(5.0F, 1.0F, 27.0F, 23.0F, (new Color(255, 0, 0, ((EntityLivingBase)osecosub).hurtTime * 20)).getRGB());
         GL11.glPopMatrix();
         GlStateManager.popMatrix();
         sapepori.bookmark$._skype();
      }

      if (Objects.equals(sapepori.prophet$.getValue(), "Zeriy")) {
         new ScaledResolution(sapepori.mc);
         if (osecosub == null || !(osecosub instanceof EntityPlayer)) {
            sapepori.mexican$ = 0;
            sapepori.diabetes$ = Double.longBitsToDouble(0L);
            return;
         }

         if (sapepori.fighting$ == Double.longBitsToDouble(0L)) {
            return;
         }

         Object var68 = 22;
         Object var82 = 34;
         Object var96 = 2 + Math.max(sapepori.mc.fontRendererObj.getStringWidth(((EntityLivingBase)osecosub).getDisplayName().getFormattedText()) + 2, 85);
         GlStateManager.pushMatrix();
         GlStateManager.translate((double)(mepicego * 1) + sapepori.fighting$, (double)(butosore * 1) + sapepori.fighting$, Double.longBitsToDouble(0L));
         GlStateManager.scale(sapepori.fighting$, sapepori.fighting$, Double.longBitsToDouble(0L));
         RenderUtil5._tramadol(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), (double)(var68 + var96), 1.0D, HUD.during$.getValue().intValue(), HUD.cosmetic$.getValue().intValue());
         RenderUtil5._usually(Float.intBitsToFloat(0), 1.0F, (float)(var68 + var96), (float)var82, (new Color(0, 5, 0, 130)).getRGB());
         GlStateManager.color(1.0F, 1.0F, 1.0F);
         if (((EntityLivingBase)osecosub).getHealth() > 10.0F) {
            RenderUtil5._depend(new Color(-16711936), new Color(-256), (double)(1.0F / ((EntityLivingBase)osecosub).getHealth() / 2.0F * (((EntityLivingBase)osecosub).getHealth() - 10.0F))).getRGB();
         } else {
            RenderUtil5._depend(new Color(-256), new Color(-65536), (double)(0.1F * ((EntityLivingBase)osecosub).getHealth())).getRGB();
         }

         Object var122 = "" + ((EntityLivingBase)osecosub).getDisplayName().getFormattedText() + "";
         FontLoaders.kiona14.drawStringWithShadow(var122, (double)(var68 + 12), 6.0D, -1);
         Object var140 = ((EntityLivingBase)osecosub).getHealth() / 2.0F == 10.0F ? 35.0F : 33.0F;
         FontLoaders.logo10.drawStringWithShadow("§7" + EnumChatFormatting.RED + "s", (double)(var68 + 12), 16.0D, -1);
         FontLoaders.kiona11.drawStringWithShadow("§7" + EnumChatFormatting.RED + " " + MathUtil._teach((double)((EntityLivingBase)osecosub).getHealth(), 1) + "HP " + "§7" + EnumChatFormatting.GRAY + "I", (double)(var68 + 12 + FontLoaders.logo10.getStringWidth("§7" + EnumChatFormatting.RED + "s")), 15.0D, -1);
         FontLoaders.kiona11.drawStringWithShadow("§7" + EnumChatFormatting.GOLD + " " + MathUtil._teach((double)((EntityLivingBase)osecosub).getAbsorptionAmount(), 1) + "GP", (double)(var68 + 17 + FontLoaders.kiona11.getStringWidth(" " + MathUtil._teach((double)((EntityLivingBase)osecosub).getHealth(), 1) + "HP " + "§7" + EnumChatFormatting.GRAY + "I")), 15.0D, -1);
         FontLoaders.logo10.drawStringWithShadow("§7" + EnumChatFormatting.GOLD + "s", (double)(var68 + 21 + FontLoaders.kiona11.getStringWidth(" " + MathUtil._teach((double)((EntityLivingBase)osecosub).getHealth(), 1) + "HP " + "§7" + EnumChatFormatting.GRAY + "I") + FontLoaders.kiona11.getStringWidth(MathUtil._teach((double)((EntityLivingBase)osecosub).getAbsorptionAmount(), 1) + "GP")), 16.0D, -1);
         Object var152 = (double)((float)(var68 + var96 - 2) * ((EntityLivingBase)osecosub).getHealth() / ((EntityLivingBase)osecosub).getMaxHealth());
         if ((double)sapepori.mexican$ > var152) {
            sapepori.mexican$ = MathUtil._military(sapepori.mexican$, (int)var152, 20.0D);
         }

         if ((double)sapepori.mexican$ < var152) {
            sapepori.mexican$ = MathUtil._military(sapepori.mexican$, (int)var152, 20.0D);
         }

         Object var166 = (double)((var68 + var96 - 2) * ((EntityLivingBase)osecosub).getTotalArmorValue());
         if (sapepori.diabetes$ > var166) {
            sapepori.diabetes$ = (double) MathUtil._military((int)sapepori.diabetes$, (int)var166, 20.0D);
         }

         if (sapepori.diabetes$ < var166) {
            sapepori.diabetes$ = (double) MathUtil._military((int)sapepori.diabetes$, (int)var166, 20.0D);
         }

         Object var180 = true;
         RenderUtil5._norman((double)(var68 + 12), 22.0D, (double)(var68 + 12) + (double)(var68 + var96 - 2) / 1.5D, 25.0D, 2.0D, (new Color(0, 0, 0, 80)).getRGB());
         RenderUtil5._norman((double)(var68 + 12), 22.0D, (double)(var68 + 12) + (double)sapepori.mexican$ / 1.5D, 25.0D, 2.0D, Colors._venture(((EntityLivingBase)osecosub).getHealth(), ((EntityLivingBase)osecosub).getMaxHealth()));
         RenderUtil5._norman((double)(var68 + 12), 27.0D, (double)(var68 + 12) + (double)(var68 + var96 - 2) / 1.5D, 30.0D, 2.0D, (new Color(0, 0, 0, 80)).getRGB());
         RenderUtil5._norman((double)(var68 + 12), 27.0D, (double)(var68 + 12) + sapepori.diabetes$ / 30.0D, 30.0D, 2.0D, (new Color(87, 130, 255)).getRGB());
         Object var184 = false;
         Object var188 = false;
         Object var191 = (float)((EntityLivingBase)osecosub).hurtTime;
         float var192;
         if (var191 == Float.intBitsToFloat(0)) {
            var192 = 1.0F;
         } else if (var191 < 0.5F) {
            var192 = 1.0F - 0.2F * var191 * 1.0F;
         } else {
            var192 = 0.8F + 0.2F * (var191 - 0.5F) * 0.1F;
         }

         Object var193 = 27;
         GL11.glPushMatrix();
         GL11.glScalef(var192, var192, var192);
         GL11.glTranslatef((float)var193 * 0.5F * (1.0F - var192) / var192, (float)var193 * 0.5F * (1.0F - var192) / var192, Float.intBitsToFloat(0));
         GL11.glColor4f(1.0F, 1.0F - var191, 1.0F - var191, 1.0F);
         sapepori._catalog(((AbstractClientPlayer)osecosub).getLocationSkin(), 3, 4, var193, var193);
         RenderUtil5._usually(3.0F, 4.0F, 30.0F, 31.0F, (new Color(255, 0, 0, ((EntityLivingBase)osecosub).hurtTime * 20)).getRGB());
         GL11.glPopMatrix();

         for(TargetHUD var30 : sapepori.packages$) {
            var30.profiles$ = 13.0F;
            var30.shops$ = 17.0F;
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            if (var30.winter$ > 4.0F) {
               var30._gilbert();
            }
         }

         if (sapepori.vehicles$._herself((long)306253863 ^ 306253879L, true)) {
            for(TargetHUD var196 : sapepori.packages$) {
               var196._bradley();
               if (var196.winter$ < 1.0F) {
                  sapepori.packages$.remove(var196);
               }
            }
         }

         if (((EntityLivingBase)osecosub).hurtTime == 9 && !sapepori.tackle$) {
            for(int var195 = 0; var195 <= 25; ++var195) {
               TargetHUD var197 = new TargetHUD();
               var197._boulder((float)(mepicego + 20), (float)(butosore + 20), (float)((Math.random() - 0.5D) * 2.0D * 1.4D), (float)((Math.random() - 0.5D) * 2.0D * 1.4D), (float)(Math.random() * 4.0D), var195 % 2 == 0 ? new Color(HUD.during$.getValue().intValue()) : new Color(HUD.cosmetic$.getValue().intValue()));
               sapepori.packages$.add(var197);
            }

            sapepori.tackle$ = true;
         }

         if (((EntityLivingBase)osecosub).hurtTime == 8) {
            sapepori.tackle$ = false;
         }

         GlStateManager.popMatrix();
         sapepori.bookmark$._skype();
      }

      if (Objects.equals(sapepori.prophet$.getValue(), "Zenith") && osecosub instanceof EntityLivingBase && osecosub != null && !((EntityLivingBase)osecosub).isDead && sapepori.mc.thePlayer.getDistanceToEntity((Entity)osecosub) < 8.0F) {
         if (sapepori.fighting$ == Double.longBitsToDouble(0L)) {
            return;
         }

         GlStateManager.pushMatrix();
         GlStateManager.translate((double)mepicego * (1.0D - sapepori.fighting$), (double)butosore * (1.0D - sapepori.fighting$), Double.longBitsToDouble(0L));
         GlStateManager.scale(sapepori.fighting$, sapepori.fighting$, Double.longBitsToDouble(0L));
         Object var49 = 2 + Math.max(sapepori.mc.fontRendererObj.getStringWidth(((EntityLivingBase)osecosub).getDisplayName().getFormattedText()) + 17, 85);
         Object var69 = 50.0F;
         RenderUtil5._usually((float)mepicego, (float)butosore, (float)(mepicego + var49), (float)butosore + var69, Colors._coleman(34));
         RenderUtil5._integer((double)mepicego + 0.5D, (double)butosore + 0.5D, (double)(mepicego + var49) - 0.5D, (double)((float)butosore + var69) - 0.5D, Colors._coleman(130));
         RenderUtil5._usually((float)mepicego + 1.5F, (float)butosore + 1.5F, (float)(mepicego + var49) - 1.5F, (float)butosore + var69 - 1.5F, Colors._coleman(34));
         Object var83 = "" + ((EntityLivingBase)osecosub).getDisplayName().getFormattedText() + "";
         FontLoaders.TahomaBold17.drawStringWithShadow(var83, (double)mepicego + 8.5D, (double)(butosore + 10), 16777215);
         Object var97 = 70.0D * MathHelper.clamp_double((double)(((EntityLivingBase)osecosub).getHealth() / ((EntityLivingBase)osecosub).getMaxHealth()), Double.longBitsToDouble(0L), 1.0D);
         RenderUtils._illness((double)(mepicego + 79), (double)butosore + 31.5D, (double)(mepicego + 8), (double)(butosore + 20), Colors._coleman(9));
         RenderUtils._illness((double)((float)mepicego + 8.5F), (double)((float)butosore + 31.0F), (double)mepicego + var97 + 8.5D, (double)((float)(butosore + 21) - 0.5F), ColorUtil._enjoying((double)((EntityLivingBase)osecosub).getHealth(), (double)((EntityLivingBase)osecosub).getMaxHealth()).getRGB());
         FontLoaders.Tahoma18.drawStringWithShadow((int)((EntityLivingBase)osecosub).getHealth() + " HP", (double)((float)mepicego + 30.5F), (double)((float)butosore + 53.0F - (float)FontLoaders.clickgui20.getHeight() - 22.0F), -1);
         if (osecosub instanceof EntityPlayer) {
            Object var123 = "";
            if (((EntityPlayer)osecosub).isBlocking()) {
               var123 = "§cBlocking: ";
            } else {
               var123 = "§6Blocking: ";
            }

            FontLoaders.TahomaBold14.drawStringWithShadow(String.valueOf(var123 + ((EntityPlayer)osecosub).isBlocking()), (double)((float)mepicego + 8.5F), (double)((float)butosore + 66.0F - (float)FontLoaders.clickgui18.getHeight() - 22.2F), -1);
         }

         GlStateManager.popMatrix();
         sapepori.bookmark$._skype();
      }

      if (Objects.equals(sapepori.prophet$.getValue(), "Bingus")) {
         if (osecosub == null || !(osecosub instanceof EntityPlayer)) {
            sapepori.mexican$ = 0;
            return;
         }

         if (osecosub != null) {
            if (sapepori.fighting$ == Double.longBitsToDouble(0L)) {
               return;
            }

            GlStateManager.pushMatrix();
            GlStateManager.translate((double)mepicego * (1.0D - sapepori.fighting$), (double)butosore * (1.0D - sapepori.fighting$), Double.longBitsToDouble(0L));
            GlStateManager.scale(sapepori.fighting$, sapepori.fighting$, Double.longBitsToDouble(0L));
            RenderUtils._wanna((double)((float)mepicego - 1.0F), (double)((float)butosore + 4.0F), 112.0D, 45.0D, new Color(5, 5, 5, 180));
            Object var50 = ColorUtils2._reward(new Color(HUD.during$.getValue().intValue()), butosore / 11, 14).getRGB();
            sapepori.mc.fontRendererObj.drawStringWithShadow(((EntityLivingBase)osecosub).getName(), (float)mepicego + 22.0F, (float)butosore + 6.0F, var50);
            GuiInventory.drawEntityOnScreen(mepicego + 10, butosore + 44, 20, ((EntityLivingBase)osecosub).rotationYaw, -((EntityLivingBase)osecosub).rotationPitch, (EntityLivingBase)osecosub);
            Object var70 = true;
            Object var84 = true;
            Object var98 = 112.0F;
            Object var110 = 112.0F * ((EntityLivingBase)osecosub).getHealth() / ((EntityLivingBase)osecosub).getMaxHealth();
            if ((float)sapepori.mexican$ > var110) {
               sapepori.mexican$ = MathUtil._military(sapepori.mexican$, (int)var110, 100.0D);
            }

            if ((float)sapepori.mexican$ < var110) {
               sapepori.mexican$ = MathUtil._military(sapepori.mexican$, (int)var110, 100.0D);
            }

            GuiRenderUtils._pamela((float)(mepicego + -1), (float)(butosore + 46), (float)sapepori.mexican$, 3.0F, var50);
            GlStateManager.translate((float)mepicego, (float)butosore, 1.0F);
            GL11.glScalef(2.0F, 2.0F, 2.0F);
            GlStateManager.translate((float)(-mepicego), (float)(-butosore), 1.0F);
            Object var125 = (double)Math.round(((EntityLivingBase)osecosub).getHealth() * 10.0F) / 10.0D + " �?";
            sapepori.mc.fontRendererObj.drawStringWithShadow(var125, (float)mepicego + 11.0F, (float)butosore + 9.0F, var50);
            GlStateManager.popMatrix();
            sapepori.bookmark$._skype();
         }
      }

   }

   public void _sciences(double certain, double auburn, double airplane, double reserved, double var9, int var11, int var12) {
      meter._floating(certain + var9, auburn + var9, airplane - var9, reserved - var9, var11);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      meter._floating(certain + var9, (double)auburn, airplane - var9, auburn + var9, var12);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      meter._floating((double)certain, (double)auburn, certain + var9, (double)reserved, var12);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      meter._floating(airplane - var9, (double)auburn, (double)airplane, (double)reserved, var12);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      meter._floating(certain + var9, reserved - var9, airplane - var9, (double)reserved, var12);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public void _floating(double formats, double lender, double whale, double vintage, int decimal) {
      if (formats < whale) {
         Object strength = (double)formats;
         formats = whale;
         whale = strength;
      }

      if (lender < vintage) {
         Object var17 = (double)lender;
         lender = vintage;
         vintage = var17;
      }

      float var12 = (float)(decimal >> 24 & 255) / 255.0F;
      float var13 = (float)(decimal >> 16 & 255) / 255.0F;
      float var14 = (float)(decimal >> 8 & 255) / 255.0F;
      float var15 = (float)(decimal & 255) / 255.0F;
      WorldRenderer var16 = Tessellator.getInstance().getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(var13, var14, var15, var12);
      var16.begin(7, DefaultVertexFormats.POSITION);
      var16.pos((double)formats, (double)vintage, Double.longBitsToDouble(0L)).endVertex();
      var16.pos((double)whale, (double)vintage, Double.longBitsToDouble(0L)).endVertex();
      var16.pos((double)whale, (double)lender, Double.longBitsToDouble(0L)).endVertex();
      var16.pos((double)formats, (double)lender, Double.longBitsToDouble(0L)).endVertex();
      Tessellator.getInstance().draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public void _roulette(int adopeged, int labaregu, float uzozigis, float uroralim, int fetoroso, int dezolere, int pobuyepa, int ucupotad, float idomibey, float obepupob) {
      Object naposeca = 1.0F / idomibey;
      Object uvusobec = 1.0F / obepupob;
      if (Objects.equals(oyugotoy.prophet$.getValue(), "Normal")) {
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.enableAlpha();
         GlStateManager.enableBlend();
      } else {
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      }

      Object ogogomoz = Tessellator.getInstance();
      Object poteteti = ogogomoz.getWorldRenderer();
      poteteti.begin(7, DefaultVertexFormats.POSITION_TEX);
      poteteti.pos((double)adopeged, (double)(labaregu + ucupotad), Double.longBitsToDouble(0L)).tex((double)(uzozigis * naposeca), (double)((uroralim + (float)dezolere) * uvusobec)).endVertex();
      poteteti.pos((double)(adopeged + pobuyepa), (double)(labaregu + ucupotad), Double.longBitsToDouble(0L)).tex((double)((uzozigis + (float)fetoroso) * naposeca), (double)((uroralim + (float)dezolere) * uvusobec)).endVertex();
      poteteti.pos((double)(adopeged + pobuyepa), (double)labaregu, Double.longBitsToDouble(0L)).tex((double)((uzozigis + (float)fetoroso) * naposeca), (double)(uroralim * uvusobec)).endVertex();
      poteteti.pos((double)adopeged, (double)labaregu, Double.longBitsToDouble(0L)).tex((double)(uzozigis * naposeca), (double)(uroralim * uvusobec)).endVertex();
      ogogomoz.draw();
   }

   public void _catalog(ResourceLocation silicon, int receives, int skiing, int waste, int taylor) {
      numerous.mc.getTextureManager().bindTexture((ResourceLocation)silicon);
      numerous._roulette((int)receives, (int)skiing, 8.0F, 8.0F, 8, 8, (int)waste, (int)taylor, 64.0F, 64.0F);
      numerous._roulette((int)receives, (int)skiing, 40.0F, 8.0F, 8, 8, (int)waste, (int)taylor, 64.0F, 64.0F);
   }

   public void _medline(double magenise, double segazeda, float yeyomovi, float duzelayu, int upubobed, int uyesopob, int oracazem, int inalirup, float nedoboyo, float gabosupi, AbstractClientPlayer var13) {
      ResourceLocation var14 = var13.getLocationSkin();
      Minecraft.getMinecraft().getTextureManager().bindTexture(var14);
      GL11.glEnable(3042);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Gui.drawScaledCustomSizeModalRect((int)magenise, (int)segazeda, (float)yeyomovi, (float)duzelayu, (int)upubobed, (int)uyesopob, (int)oracazem, (int)inalirup, (float)nedoboyo, (float)gabosupi);
      GL11.glDisable(3042);
   }

   public void _regime() {
      super._regime();
      abibiguz.cottages$ = Double.longBitsToDouble(0L);
      abibiguz.thriller$ = Double.longBitsToDouble(0L);
      abibiguz.articles$ = null;
      abibiguz.domestic$ = Double.longBitsToDouble(0L);
   }

   public void _discs() {
      super._discs();
   }

   public void _maple(double var1, double var3, EntityLivingBase var5) {
   }

   public static int _bobby(float fitting, int rocky) {
      return Math.min(255, (int)Math.ceil((double)(fitting * 255.0F)) + rocky);
   }

   public int _register(int isipuvat, float evesovaz) {
      Object idedunif = new Color((int)isipuvat);
      Object igufobes = 0.003921569F * (float)idedunif.getRed();
      Object nigefopi = 0.003921569F * (float)idedunif.getGreen();
      Object ilayidab = 0.003921569F * (float)idedunif.getBlue();
      return (new Color(igufobes, nigefopi, ilayidab, (float)evesovaz)).getRGB();
   }

   public void _model(float gaperono, float ivigebun, float bovuzido, float idimupuc, Color uyirezes) {
      RenderUtil5._usually((float)gaperono, (float)ivigebun, (float)(gaperono + bovuzido), (float)(ivigebun + idimupuc), ((Color)uyirezes).getRGB());
   }

   public void _arthur(int odutulen, int gumibegi, int alameyap, float udanapiz, float nulezefa, EntityLivingBase lomayuvi) {
      oyivobon._nested((int)odutulen, (int)gumibegi, (int)alameyap, (float)udanapiz, (float)nulezefa, (EntityLivingBase)lomayuvi, 135.0F);
   }

   public static int _unknown(EntityLivingBase alepibaf) {
      Object fadulibo = ((EntityLivingBase)alepibaf).getHealth();
      Object oyamileb = ((EntityLivingBase)alepibaf).getMaxHealth();
      Object yedaribi = Math.max(Float.intBitsToFloat(0), Math.min(fadulibo, oyamileb) / oyamileb);
      return Color.HSBtoRGB(yedaribi / 3.0F, 1.0F, 0.75F) | -16777216;
   }

   public void _nested(int nights, int pierre, int occur, float discount, float pendant, EntityLivingBase signals, float reporter) {
      GlStateManager.enableColorMaterial();
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)nights, (float)pierre, 50.0F);
      GlStateManager.scale((float)(-occur), (float)occur, (float)occur);
      GlStateManager.rotate(180.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0), 1.0F);
      Object informal = ((EntityLivingBase)signals).renderYawOffset;
      Object hampton = ((EntityLivingBase)signals).rotationYaw;
      Object peterson = ((EntityLivingBase)signals).rotationPitch;
      Object audio = ((EntityLivingBase)signals).prevRotationYawHead;
      Object anything = ((EntityLivingBase)signals).rotationYawHead;
      GlStateManager.rotate((float)reporter, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      RenderHelper.enableStandardItemLighting();
      GlStateManager.rotate(-135.0F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      GlStateManager.rotate(-((float)Math.atan((double)(pendant / 40.0F))) * 20.0F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      ((EntityLivingBase)signals).renderYawOffset = (float)Math.atan((double)(discount / 40.0F)) * 20.0F;
      ((EntityLivingBase)signals).rotationYaw = (float)Math.atan((double)(discount / 40.0F)) * 40.0F;
      ((EntityLivingBase)signals).rotationPitch = -((float)Math.atan((double)(pendant / 40.0F))) * 20.0F;
      ((EntityLivingBase)signals).rotationYawHead = ((EntityLivingBase)signals).rotationYaw;
      ((EntityLivingBase)signals).prevRotationYawHead = ((EntityLivingBase)signals).rotationYaw;
      GlStateManager.translate(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      Object brother = Minecraft.getMinecraft().getRenderManager();
      brother.setPlayerViewY(180.0F);
      brother.setRenderShadow(false);
      brother.renderEntityWithPosYaw((Entity)signals, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Float.intBitsToFloat(0), 1.0F);
      brother.setRenderShadow(true);
      ((EntityLivingBase)signals).renderYawOffset = informal;
      ((EntityLivingBase)signals).rotationYaw = hampton;
      ((EntityLivingBase)signals).rotationPitch = peterson;
      ((EntityLivingBase)signals).prevRotationYawHead = audio;
      ((EntityLivingBase)signals).rotationYawHead = anything;
      GlStateManager.popMatrix();
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableRescaleNormal();
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.disableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
   }

   public static Color _yearly(float omuruzib, float suduyalu) {
      Object gosenami = new float[]{Float.intBitsToFloat(0), 0.5F, 1.0F};
      Object isemetet = new Color[]{new Color(0, 81, 179), new Color(41, 255, 255), new Color(HUD.cosmetic$.getValue().intValue())};
      Object gogigila = (float)(omuruzib / suduyalu);
      return _lincoln(gosenami, isemetet, gogigila).brighter();
   }

   public static int[] _passion(float[] visits, float confirm) {
      Object theme = new int[2];

      int citation;
      for(citation = 0; citation < ((Object[])visits).length && ((Object[])visits)[citation] <= confirm; ++citation) {
         ;
      }

      if (citation >= ((Object[])visits).length) {
         citation = ((Object[])visits).length - 1;
      }

      theme[0] = citation - 1;
      theme[1] = citation;
      return theme;
   }

   public static Color _lincoln(float[] movifure, Color[] firuzimu, float nimurone) {
      if (((Object[])movifure).length == ((Object[])firuzimu).length) {
         Object inotibid = _passion((float[])movifure, (float)nimurone);
         Object revebere = new float[]{(float)((Object[])movifure)[inotibid[0]], (float)((Object[])movifure)[inotibid[1]]};
         Object tecepini = new Color[]{(Color)((Object[])firuzimu)[inotibid[0]], (Color)((Object[])firuzimu)[inotibid[1]]};
         Object zometune = revebere[1] - revebere[0];
         Object upuvanuv = nimurone - revebere[0];
         Object gugeyaca = upuvanuv / zometune;
         return _integral(tecepini[0], tecepini[1], (double)(1.0F - gugeyaca));
      } else {
         throw new IllegalArgumentException("Fractions and colours must have equal number of elements");
      }
   }

   public static Color _integral(Color fanayine, Color nobizaro, double ufetavun) {
      Object utezimul = (float)ufetavun;
      Object pesobapu = 1.0F - utezimul;
      Object malidino = new float[3];
      float[] var7 = new float[3];
      ((Color)fanayine).getColorComponents(malidino);
      ((Color)nobizaro).getColorComponents(var7);
      return new Color(malidino[0] * utezimul + var7[0] * pesobapu, malidino[1] * utezimul + var7[1] * pesobapu, malidino[2] * utezimul + var7[2] * pesobapu);
   }

   public static float _synopsis(EntityLivingBase header) {
      return (float)((EntityLivingBase)header).hurtTime - (((EntityLivingBase)header).hurtTime != 0 ? Minecraft.getMinecraft().timer.renderPartialTicks : Float.intBitsToFloat(0));
   }

   public static float _beans(EntityLivingBase femecima) {
      return _synopsis((EntityLivingBase)femecima) / 10.0F;
   }

   public static void _failures(float contain, float comics, float passes, float couples, float sector, int sensor) {
      Object expected = true;
      Object cloudy = 5.0F;
      Object deliver = (float)(sensor >> 24 & 255) / 255.0F;
      Object murphy = (float)(sensor >> 16 & 255) / 255.0F;
      Object analysts = (float)(sensor >> 8 & 255) / 255.0F;
      Object norfolk = (float)(sensor & 255) / 255.0F;
      GL11.glDisable(2884);
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(murphy, analysts, norfolk, deliver);
      GL11.glBegin(5);
      GL11.glVertex2f((float)(contain + sector), (float)comics);
      GL11.glVertex2f((float)(contain + sector), (float)couples);
      GL11.glVertex2f((float)(passes - sector), (float)comics);
      GL11.glVertex2f((float)(passes - sector), (float)couples);
      GL11.glEnd();
      GL11.glBegin(5);
      GL11.glVertex2f((float)contain, (float)(comics + sector));
      GL11.glVertex2f((float)(contain + sector), (float)(comics + sector));
      GL11.glVertex2f((float)contain, (float)(couples - sector));
      GL11.glVertex2f((float)(contain + sector), (float)(couples - sector));
      GL11.glEnd();
      GL11.glBegin(5);
      GL11.glVertex2f((float)passes, (float)(comics + sector));
      GL11.glVertex2f((float)(passes - sector), (float)(comics + sector));
      GL11.glVertex2f((float)passes, (float)(couples - sector));
      GL11.glVertex2f((float)(passes - sector), (float)(couples - sector));
      GL11.glEnd();
      GL11.glBegin(6);
      Object vietnam = (float)(passes - sector);
      Object brandon = (float)(comics + sector);
      GL11.glVertex2f(vietnam, brandon);
      boolean var14 = false;

      for(int var22 = 0; var22 <= 18; ++var22) {
         float var15 = (float)var22 * 5.0F;
         GL11.glVertex2f((float)((double)vietnam + (double)sector * Math.cos(Math.toRadians((double)var15))), (float)((double)brandon - (double)sector * Math.sin(Math.toRadians((double)var15))));
      }

      GL11.glEnd();
      GL11.glBegin(6);
      vietnam = (float)(contain + sector);
      brandon = (float)(comics + sector);
      GL11.glVertex2f(vietnam, brandon);

      for(int var23 = 0; var23 <= 18; ++var23) {
         float var26 = (float)var23 * 5.0F;
         GL11.glVertex2f((float)((double)vietnam - (double)sector * Math.cos(Math.toRadians((double)var26))), (float)((double)brandon - (double)sector * Math.sin(Math.toRadians((double)var26))));
      }

      GL11.glEnd();
      GL11.glBegin(6);
      vietnam = (float)(contain + sector);
      brandon = (float)(couples - sector);
      GL11.glVertex2f(vietnam, brandon);

      for(int var24 = 0; var24 <= 18; ++var24) {
         float var27 = (float)var24 * 5.0F;
         GL11.glVertex2f((float)((double)vietnam - (double)sector * Math.cos(Math.toRadians((double)var27))), (float)((double)brandon + (double)sector * Math.sin(Math.toRadians((double)var27))));
      }

      GL11.glEnd();
      GL11.glBegin(6);
      vietnam = (float)(passes - sector);
      brandon = (float)(couples - sector);
      GL11.glVertex2f(vietnam, brandon);

      for(int var25 = 0; var25 <= 18; ++var25) {
         float var28 = (float)var25 * 5.0F;
         GL11.glVertex2f((float)((double)vietnam + (double)sector * Math.cos(Math.toRadians((double)var28))), (float)((double)brandon + (double)sector * Math.sin(Math.toRadians((double)var28))));
      }

      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glEnable(2884);
      GL11.glDisable(3042);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public void _friends(ResourceLocation libosozu, int udabifob, int umetoceb, int naveridu, int umolubiv, float corubiri) {
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, (float)corubiri);
      dagecocu.mc.getTextureManager().bindTexture((ResourceLocation)libosozu);
      Gui.drawScaledCustomSizeModalRect((int)udabifob, (int)umetoceb, 8.0F, 8.0F, 8, 8, (int)naveridu, (int)umolubiv, 64.0F, 64.0F);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
   }

   public static void _parent(int scores, int depot, int everyday, float gratuit, float agent, EntityLivingBase shares) {
      GlStateManager.enableColorMaterial();
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)scores, (float)depot, 50.0F);
      GlStateManager.scale((float)(-everyday), (float)everyday, (float)everyday);
      GlStateManager.rotate(180.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0), 1.0F);
      Object interval = ((EntityLivingBase)shares).renderYawOffset;
      Object siemens = ((EntityLivingBase)shares).rotationYaw;
      Object crimes = ((EntityLivingBase)shares).rotationPitch;
      Object circular = ((EntityLivingBase)shares).prevRotationYawHead;
      Object patent = ((EntityLivingBase)shares).rotationYawHead;
      GlStateManager.rotate(135.0F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      RenderHelper.enableStandardItemLighting();
      GlStateManager.rotate(-135.0F, Float.intBitsToFloat(0), 1.0F, Float.intBitsToFloat(0));
      GlStateManager.rotate(-(agent / 40.0F) * 20.0F, 1.0F, Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      ((EntityLivingBase)shares).renderYawOffset = (float)((double)(gratuit / 40.0F)) * 40.0F;
      ((EntityLivingBase)shares).rotationYaw = (float)((double)(gratuit / 40.0F)) * 40.0F;
      ((EntityLivingBase)shares).rotationPitch = -((float)Math.atan((double)(agent / 40.0F))) * 20.0F;
      ((EntityLivingBase)shares).rotationYawHead = ((EntityLivingBase)shares).rotationYaw;
      ((EntityLivingBase)shares).prevRotationYawHead = ((EntityLivingBase)shares).rotationYaw;
      GlStateManager.translate(Float.intBitsToFloat(0), Float.intBitsToFloat(0), Float.intBitsToFloat(0));
      Object condos = Minecraft.getMinecraft().getRenderManager();
      condos.setPlayerViewY(180.0F);
      condos.setRenderShadow(false);
      condos.renderEntityWithPosYaw((Entity)shares, Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Float.intBitsToFloat(0), 1.0F);
      condos.setRenderShadow(true);
      ((EntityLivingBase)shares).renderYawOffset = interval;
      ((EntityLivingBase)shares).rotationYaw = siemens;
      ((EntityLivingBase)shares).rotationPitch = crimes;
      ((EntityLivingBase)shares).prevRotationYawHead = circular;
      ((EntityLivingBase)shares).rotationYawHead = patent;
      GlStateManager.popMatrix();
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableRescaleNormal();
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.disableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
   }

   public void _sally(ResourceLocation venazeva, int lesuyage, int ovumunab, float ovetiyid, float upudabez, float lipetuti) {
      GL11.glPushMatrix();
      GL11.glTranslated((double)lesuyage, (double)ovumunab, Double.longBitsToDouble(0L));
      Stencil._velvet(false);
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      _failures(Float.intBitsToFloat(0), Float.intBitsToFloat(0), (float)ovetiyid, (float)upudabez, 4.0F, (new Color(0, 0, 0, 0)).getRGB());
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      Stencil._harold(true);
      GL11.glDisable(2929);
      GL11.glEnable(3042);
      GL11.glDepthMask(false);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, (float)lipetuti);
      omabiyog.mc.getTextureManager().bindTexture((ResourceLocation)venazeva);
      _bother(Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), 8.0F, 8.0F, 8, 8, (float)ovetiyid, (float)upudabez, 64.0F, 64.0F);
      GL11.glDepthMask(true);
      GL11.glDisable(3042);
      GL11.glEnable(2929);
      Stencil._registry();
      GL11.glPopMatrix();
   }

   public static void _digital(double idezacit, double figevudi, double paficaca, double ribiniri, double picabipa, int zetifimu) {
      GL11.glPushAttrib(0);
      GL11.glScaled(0.5D, 0.5D, 0.5D);
      idezacit = idezacit * 2.0D;
      figevudi = figevudi * 2.0D;
      paficaca = paficaca * 2.0D;
      ribiniri = ribiniri * 2.0D;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      float var11 = (float)(zetifimu >> 24 & 255) / 255.0F;
      float var12 = (float)(zetifimu >> 16 & 255) / 255.0F;
      float var13 = (float)(zetifimu >> 8 & 255) / 255.0F;
      float var14 = (float)(zetifimu & 255) / 255.0F;
      GL11.glColor4f(var12, var13, var14, var11);
      GL11.glEnable(2848);
      GL11.glBegin(9);

      for(int var15 = 0; var15 <= 90; var15 += 3) {
         GL11.glVertex2d(idezacit + picabipa + Math.sin((double)var15 * 3.141592653589793D / 180.0D) * picabipa * -1.0D, figevudi + picabipa + Math.cos((double)var15 * 3.141592653589793D / 180.0D) * picabipa * -1.0D);
      }

      for(int var20 = 90; var20 <= 180; var20 += 3) {
         GL11.glVertex2d(idezacit + picabipa + Math.sin((double)var20 * 3.141592653589793D / 180.0D) * picabipa * -1.0D, ribiniri - picabipa + Math.cos((double)var20 * 3.141592653589793D / 180.0D) * picabipa * -1.0D);
      }

      for(int var21 = 0; var21 <= 90; var21 += 3) {
         GL11.glVertex2d(paficaca - picabipa + Math.sin((double)var21 * 3.141592653589793D / 180.0D) * picabipa, ribiniri - picabipa + Math.cos((double)var21 * 3.141592653589793D / 180.0D) * picabipa);
      }

      for(int var22 = 90; var22 <= 180; var22 += 3) {
         GL11.glVertex2d(paficaca - picabipa + Math.sin((double)var22 * 3.141592653589793D / 180.0D) * picabipa, figevudi + picabipa + Math.cos((double)var22 * 3.141592653589793D / 180.0D) * picabipa);
      }

      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glEnable(3553);
      GL11.glScaled(2.0D, 2.0D, 2.0D);
      GL11.glPopAttrib();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void _bother(double cooked, double sitemap, float schema, float press, int delhi, int supposed, float officers, float burst, float lights, float bristol) {
      Object france = 1.0F / lights;
      Object result = 1.0F / bristol;
      Tessellator var14 = Tessellator.getInstance();
      WorldRenderer var15 = var14.getWorldRenderer();
      var15.begin(7, DefaultVertexFormats.POSITION_TEX);
      var15.pos((double)cooked, sitemap + (double)burst, Double.longBitsToDouble(0L)).tex((double)(schema * france), (double)((press + (float)supposed) * result)).endVertex();
      var15.pos(cooked + (double)officers, sitemap + (double)burst, Double.longBitsToDouble(0L)).tex((double)((schema + (float)delhi) * france), (double)((press + (float)supposed) * result)).endVertex();
      var15.pos(cooked + (double)officers, (double)sitemap, Double.longBitsToDouble(0L)).tex((double)((schema + (float)delhi) * france), (double)(press * result)).endVertex();
      var15.pos((double)cooked, (double)sitemap, Double.longBitsToDouble(0L)).tex((double)(schema * france), (double)(press * result)).endVertex();
      var14.draw();
   }

   public static void _fuzzy(double brian, double cookie, float upcoming, float playlist, int seats, int posing, int mental, int threads, float safely, float compiler, AbstractClientPlayer var12) {
      ResourceLocation var13 = var12.getLocationSkin();
      Minecraft.getMinecraft().getTextureManager().bindTexture(var13);
      GL11.glEnable(3042);
      _bother((double)brian, (double)cookie, (float)upcoming, (float)playlist, (int)seats, (int)posing, (float)mental, (float)threads, (float)safely, (float)compiler);
      GL11.glDisable(3042);
   }

   public static void _opened(double yaluvedu, double eruneliv, double peligabi, double mumesape, int zebasuza) {
      if (yaluvedu < peligabi) {
         Object omanulit = (int)yaluvedu;
         yaluvedu = peligabi;
         peligabi = (double)omanulit;
      }

      if (eruneliv < mumesape) {
         Object var15 = (int)eruneliv;
         eruneliv = mumesape;
         mumesape = (double)var15;
      }

      Object var16 = (float)(zebasuza >> 24 & 255) / 255.0F;
      Object pamipemo = (float)(zebasuza >> 16 & 255) / 255.0F;
      float var11 = (float)(zebasuza >> 8 & 255) / 255.0F;
      float var12 = (float)(zebasuza & 255) / 255.0F;
      Tessellator var13 = Tessellator.getInstance();
      WorldRenderer var14 = var13.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(pamipemo, var11, var12, var16);
      var14.begin(7, DefaultVertexFormats.POSITION);
      var14.pos((double)yaluvedu, (double)mumesape, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)peligabi, (double)mumesape, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)peligabi, (double)eruneliv, Double.longBitsToDouble(0L)).endVertex();
      var14.pos((double)yaluvedu, (double)eruneliv, Double.longBitsToDouble(0L)).endVertex();
      var13.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public void _pools(EntityLivingBase offline, float rouge, float schemes, float income) {
      if (offline instanceof EntityPlayer) {
         GlStateManager.color(1.0F, 1.0F, 1.0F, 0.5F);
         GlStateManager.enableAlpha();
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);

         for(Object ghana : GuiPlayerTabOverlay.field_175252_a.sortedCopy(makers.mc.thePlayer.sendQueue.getPlayerInfoMap())) {
            Object williams = (NetworkPlayerInfo)ghana;
            if (makers.mc.theWorld.getPlayerEntityByUUID(williams.getGameProfile().getId()) == offline) {
               makers.mc.getTextureManager().bindTexture(williams.getLocationSkin());
               _bother((double)rouge, (double)schemes, 8.0F, 8.0F, 8, 8, (float)((int)income), (float)((int)income), 64.0F, 64.0F);
               if (((EntityPlayer)offline).isWearing(EnumPlayerModelParts.HAT)) {
                  _bother((double)rouge, (double)schemes, 40.0F, 8.0F, 8, 8, (float)((int)income), (float)((int)income), 64.0F, 64.0F);
               }

               GlStateManager.bindTexture(0);
               break;
            }
         }
      }

   }

   public int _kentucky(EntityPlayer dayton) {
      for(Object jessica : Minecraft.getMinecraft().getNetHandler().getPlayerInfoMap()) {
         if (jessica.getGameProfile().getId().equals(((EntityPlayer)dayton).getUniqueID())) {
            return jessica.getResponseTime();
         }
      }

      return 0;
   }

   public void _numerous(String ecigabub, float genayadu, float isufovif, int eyeyigor) {
      uvicuzeb._yields((String)ecigabub, (float)genayadu, (float)isufovif, (int)eyeyigor);
   }

   public String _bradford(String written) {
      return protein.banned$.matcher((CharSequence)written).replaceAll("");
   }

   public void _yields(String licence, float opening, float mixed, int segments) {
      veteran.mc.fontRendererObj.drawString(veteran._bradford((String)licence), opening - 0.5F, (float)mixed, 0, false);
      veteran.mc.fontRendererObj.drawString(veteran._bradford((String)licence), opening + 0.5F, (float)mixed, 0, false);
      veteran.mc.fontRendererObj.drawString(veteran._bradford((String)licence), (float)opening, mixed - 0.5F, 0, false);
      veteran.mc.fontRendererObj.drawString(veteran._bradford((String)licence), (float)opening, mixed + 0.5F, 0, false);
      veteran.mc.fontRendererObj.drawString((String)licence, (float)opening, (float)mixed, (int)segments, false);
   }

   public void _honduras(int opuyelas, int zubavuzu) {
      Object bumecoyi = afocozar.mc.currentScreen instanceof GuiChat ? afocozar.mc.thePlayer : KillAura._versus();
      if (bumecoyi != null && bumecoyi instanceof EntityPlayer) {
         GL11.glPushMatrix();
         Object atanayen = new ArrayList();
         Object ayiditum = -2;
         Object balipipe = ((EntityPlayer)bumecoyi).getCurrentArmor(2);
         if (balipipe != null) {
            atanayen.add(balipipe);
         }

         for(Object tazusetu : atanayen) {
            if (Minecraft.getMinecraft().theWorld != null) {
               RenderHelper.enableGUIStandardItemLighting();
               ayiditum += 20;
            }

            GlStateManager.pushMatrix();
            GlStateManager.disableAlpha();
            GlStateManager.clear(256);
            GlStateManager.enableBlend();
            Minecraft.getMinecraft().getRenderItem().renderItemIntoGUI(tazusetu, ayiditum + opuyelas, (int)zubavuzu);
            GlStateManager.disableBlend();
            GlStateManager.scale(0.5D, 0.5D, 0.5D);
            GlStateManager.disableDepth();
            GlStateManager.disableLighting();
            GlStateManager.enableDepth();
            GlStateManager.scale(2.0F, 2.0F, 2.0F);
            GlStateManager.enableAlpha();
            GlStateManager.popMatrix();
         }

         GL11.glPopMatrix();
      }
   }

   public void _brandon(int reginome, int utigemon) {
      Object vosefove = resarimu.mc.currentScreen instanceof GuiChat ? resarimu.mc.thePlayer : KillAura._versus();
      if (vosefove != null && vosefove instanceof EntityPlayer) {
         GL11.glPushMatrix();
         Object osovupoc = new ArrayList();
         Object viribigu = -2;
         Object sitocenu = ((EntityPlayer)vosefove).getCurrentArmor(1);
         if (sitocenu != null) {
            osovupoc.add(sitocenu);
         }

         for(Object vogigebo : osovupoc) {
            if (Minecraft.getMinecraft().theWorld != null) {
               RenderHelper.enableGUIStandardItemLighting();
               viribigu += 20;
            }

            GlStateManager.pushMatrix();
            GlStateManager.disableAlpha();
            GlStateManager.clear(256);
            GlStateManager.enableBlend();
            Minecraft.getMinecraft().getRenderItem().renderItemIntoGUI(vogigebo, viribigu + reginome, (int)utigemon);
            GlStateManager.disableBlend();
            GlStateManager.scale(0.5D, 0.5D, 0.5D);
            GlStateManager.disableDepth();
            GlStateManager.disableLighting();
            GlStateManager.enableDepth();
            GlStateManager.scale(2.0F, 2.0F, 2.0F);
            GlStateManager.enableAlpha();
            GlStateManager.popMatrix();
         }

         GL11.glPopMatrix();
      }
   }

   public void _salvador(int ofeminel, int upepoziv) {
      Object cedumeli = usenerid.mc.currentScreen instanceof GuiChat ? usenerid.mc.thePlayer : KillAura._versus();
      if (cedumeli != null && cedumeli instanceof EntityPlayer) {
         GL11.glPushMatrix();
         Object imocatod = new ArrayList();
         Object fibevemo = -2;
         Object ubisavut = ((EntityPlayer)cedumeli).getCurrentArmor(0);
         if (ubisavut != null) {
            imocatod.add(ubisavut);
         }

         for(Object mocedanu : imocatod) {
            if (Minecraft.getMinecraft().theWorld != null) {
               RenderHelper.enableGUIStandardItemLighting();
               fibevemo += 20;
            }

            GlStateManager.pushMatrix();
            GlStateManager.disableAlpha();
            GlStateManager.clear(256);
            GlStateManager.enableBlend();
            Minecraft.getMinecraft().getRenderItem().renderItemIntoGUI(mocedanu, fibevemo + ofeminel, (int)upepoziv);
            GlStateManager.disableBlend();
            GlStateManager.scale(0.5D, 0.5D, 0.5D);
            GlStateManager.disableDepth();
            GlStateManager.disableLighting();
            GlStateManager.enableDepth();
            GlStateManager.scale(2.0F, 2.0F, 2.0F);
            GlStateManager.enableAlpha();
            GlStateManager.popMatrix();
         }

         GL11.glPopMatrix();
      }
   }

   public static int _desktops() {
      return affairs$;
   }

   public static int _utility() {
      return rover$;
   }

   public static void _entire(int usozemid) {
      affairs$ = (int)usozemid;
   }

   public static void _quickly(int intake) {
      rover$ = (int)intake;
   }

   public static boolean _indian(int elevofed, int tudofegu) {
      return MathUtil._alice((double)elevofed, (double)tudofegu, (double)(affairs$ + 110), (double)(rover$ + 70), (double)affairs$, (double)(rover$ - 50)) && ModuleManager._herbs(TargetHUD2.class)._central();
   }
}
