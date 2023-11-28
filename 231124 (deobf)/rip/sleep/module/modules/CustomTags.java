package rip.sleep.module.modules;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector4d;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumChatFormatting;
import org.json.JSONException;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.Render2DEventA;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.util.ColorUtil;
import rip.sleep.util.RenderUtilD;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.NumberValue;

public class CustomTags extends Module {
   public static ModeValue c29191 = new ModeValue("Mode", new String[]{"Vape", "Astolfo", "Name"}, "Astolfo");
   private NumberValue<Number> c85495 = new NumberValue<Number>("Scale", Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3), 0.05D);
   public List<EntityLivingBase> c76068 = new ArrayList();
   public BooleanValue c89688 = new BooleanValue("Players", true);
   public BooleanValue c61515 = new BooleanValue("Mobs", false);
   public BooleanValue c22272 = new BooleanValue("Invisible", false);
   public BooleanValue c94152 = new BooleanValue("Animals", false);
   public BooleanValue c59114 = new BooleanValue("Dead", false);
   public BooleanValue c40830 = new BooleanValue("Outline", true);
   public static BooleanValue c92322 = new BooleanValue("mcTheplayer", false);
   private final Pattern c58641 = Pattern.compile("(?i)§[0-9A-FK-ORX]");

   public CustomTags() {
      super("Custom Tags", new String[]{"CustomTags"}, ModuleType.c12482, ModuleType.c21190.c1301);
      this.c36162((new Color(29, 187, 102)).getRGB());
   }

   @EventTarget
   public void c74427(Render2DEventA var1) {
      Sleep.c33759();
      ESP2D var3 = (ESP2D) ModuleManager.c25475(ESP2D.class);
      Value.c27574();
      boolean var4 = var3.c24622();
      double var5 = 3.0D - this.c85495.c53968().doubleValue();
      FontRenderer var7 = mc.fontRendererObj;
      List var8 = this.c72256();
      if (mc.gameSettings.thirdPersonView != 0 && c92322.c1473().booleanValue()) {
         var8.add(mc.thePlayer);
      }

      Iterator var9 = var8.iterator();
      if (var9.hasNext()) {
         EntityLivingBase var10 = (EntityLivingBase)var9.next();
         double var11 = RenderUtilD.c86345(var10.posX, var10.lastTickPosX, var1.c36064());
         double var13 = RenderUtilD.c86345(var10.posY, var10.lastTickPosY, var1.c36064()) - var5 / 30.0D + var10.getDistance(mc.getRenderManager().viewerPosX, mc.getRenderManager().viewerPosY, mc.getRenderManager().viewerPosZ) / (40.0D * var5);
         double var15 = RenderUtilD.c86345(var10.posZ, var10.lastTickPosZ, var1.c36064());
         double var17 = (double)var10.width / 1.5D;
         double var19 = (double)var10.getEyeHeight() * 1.3185D;
         Vector4d var21 = null;
         AxisAlignedBB var22 = new AxisAlignedBB(var11 - var17, var13, var15 - var17, var11 + var17, var13 + var19, var15 + var17);
         List var23 = Arrays.asList(new Vector3d(var22.minX, var22.minY, var22.minZ), new Vector3d(var22.minX, var22.maxY, var22.minZ), new Vector3d(var22.maxX, var22.minY, var22.minZ), new Vector3d(var22.maxX, var22.maxY, var22.minZ), new Vector3d(var22.minX, var22.minY, var22.maxZ), new Vector3d(var22.minX, var22.maxY, var22.maxZ), new Vector3d(var22.maxX, var22.minY, var22.maxZ), new Vector3d(var22.maxX, var22.maxY, var22.maxZ));
         mc.entityRenderer.setupCameraTransform(var1.c36064(), 0);
         float var24 = 0.2F;
         if (Minecraft.getMinecraft().thePlayer.getDistanceToEntity(var10) > 50.0F) {
            var24 = 0.7F;
         }

         Iterator var25 = var23.iterator();
         if (var25.hasNext()) {
            Vector3d var26 = (Vector3d)var25.next();
            if (var4) {
               var26 = RenderUtilD.c46412(var1.c26056(), var26.x - mc.getRenderManager().viewerPosX, var26.y - mc.getRenderManager().viewerPosY + (double)var24, var26.z - mc.getRenderManager().viewerPosZ);
            }

            var26 = RenderUtilD.c46412(var1.c26056(), var26.x - mc.getRenderManager().viewerPosX, var26.y - mc.getRenderManager().viewerPosY, var26.z - mc.getRenderManager().viewerPosZ);
            if (var26 != null && var26.z >= 0.0D && var26.z < 1.0D) {
               if (var21 == null) {
                  var21 = new Vector4d(var26.x, var26.y, var26.z, 0.0D);
               }

               var21.x = Math.min(var26.x, var21.x);
               var21.y = Math.min(var26.y, var21.y);
               var21.z = Math.max(var26.x, var21.z);
               var21.w = Math.max(var26.y, var21.w);
            }
         }

         mc.entityRenderer.setupOverlayRendering();
         if (var21 != null) {
            double var31 = var21.x;
            double var27 = var21.z;
            double var29 = var21.y - 1.0D;
            GlStateManager.translate(var31 + (var27 - var31) / 2.0D, var29, 1.0D);
            GlStateManager.scale(1.0D / var5, 1.0D / var5, 1.0D);
            if (Objects.equals(c29191.c54460(), "Vape")) {
               this.c24961(var10, var7, var19);
            }

            if (Objects.equals(c29191.c54460(), "Astolfo")) {
               this.c14683(var10, var7, var19);
            }

            if (Objects.equals(c29191.c54460(), "Name")) {
               var7.drawStringWithShadow(var10.getDisplayName().getFormattedText(), (float)(-var7.getStringWidth(var10.getDisplayName().getFormattedText()) / 2), (float)var7.FONT_HEIGHT, ColorUtil.c27970.c79340);
            }

            GlStateManager.scale(1.0D * var5, 1.0D * var5, 1.0D);
            GlStateManager.translate(-(var31 + (var27 - var31) / 2.0D), -var29, 1.0D);
         }
      }

   }

   public List<EntityLivingBase> c72256() {
      Module[] var1 = Value.c27574();
      if (!this.c24622()) {
         return new ArrayList();
      } else {
         Minecraft var2 = Minecraft.getMinecraft();
         this.c76068 = new ArrayList();
         Stream var10000 = var2.theWorld.loadedEntityList.stream();
         EntityLivingBase.class.getClass();
         Iterator var3 = ((List)var10000.filter(EntityLivingBase.class::isInstance).collect(Collectors.toList())).iterator();
         if (var3.hasNext()) {
            Entity var4 = (Entity)var3.next();
            EntityLivingBase var5 = (EntityLivingBase)var4;
            if (var5 != var2.thePlayer && !AntiBot.c13506(var5) && !(var5 instanceof EntityArmorStand) && !(var5 instanceof EntityVillager) && (this.c22272.c1473().booleanValue() || var5.isInvisible()) && (this.c61515.c1473().booleanValue() || !(var5 instanceof EntityMob)) && (this.c94152.c1473().booleanValue() || !(var5 instanceof EntityAnimal) && !(var5 instanceof EntityBat)) && (this.c89688.c1473().booleanValue() || !(var5 instanceof EntityPlayer)) && (this.c59114.c1473().booleanValue() || !var5.isDead && var5.getHealth() > 0.0F)) {
               this.c76068.add(var5);
            }
         }

         return this.c76068;
      }
   }

   public void c14683(EntityLivingBase var1, FontRenderer var2, double var3) {
      String var6 = (float)Math.round(var1.getHealth() * 10.0F) / 10.0F + "";
      Value.c27574();
      String var7 = (float)Math.round(mc.thePlayer.getDistanceToEntity(var1) * 10.0F) / 10.0F + "";
      String var8 = var1.getDisplayName().getFormattedText() + " §7[§f" + var6 + "§c❤§7] " + EnumChatFormatting.RESET + "- " + var7 + "m";
      String var9 = Sleep.getInstance().c43557().c25756.c43312(var1.getDisplayName().getFormattedText()) ? EnumChatFormatting.AQUA + var8 : EnumChatFormatting.RESET + var8;
      RenderUtilD.c24215((double)(-var2.getStringWidth(var8) / 2 - 3), var3 - 2.0D, (double)(var2.getStringWidth(var8) / 2 + 3), (double)(var2.FONT_HEIGHT + 2) + var3, -1728053248);
      if (this.c40830.c1473().booleanValue()) {
         this.c68564(var9, 0.0F, (float)(var3 + 0.5D), ColorUtil.c27970.c79340);
      }

      this.c68441(var8, 0.0F, (float)(var3 + 0.5D), ColorUtil.c27970.c79340);
   }

   public String c75596(String var1) {
      return this.c58641.matcher(var1).replaceAll("");
   }

   public void c68564(String var1, float var2, float var3, int var4) {
      mc.fontRendererObj.drawString(this.c75596(var1), var2 - (float)(mc.fontRendererObj.getStringWidth(var1) / 2) - 0.5F, var3, 0, false);
      mc.fontRendererObj.drawString(this.c75596(var1), var2 - (float)(mc.fontRendererObj.getStringWidth(var1) / 2) + 0.5F, var3, 0, false);
      mc.fontRendererObj.drawString(this.c75596(var1), var2 - (float)(mc.fontRendererObj.getStringWidth(var1) / 2), var3 - 0.5F, 0, false);
      mc.fontRendererObj.drawString(this.c75596(var1), var2 - (float)(mc.fontRendererObj.getStringWidth(var1) / 2), var3 + 0.5F, 0, false);
      mc.fontRendererObj.drawString(var1, var2 - (float)(mc.fontRendererObj.getStringWidth(var1) / 2), var3, var4, false);
   }

   public void c68441(String var1, float var2, float var3, int var4) {
      mc.fontRendererObj.drawStringWithShadow(var1, var2 - (float)(mc.fontRendererObj.getStringWidth(var1) / 2), var3, var4);
   }

   public void c24961(EntityLivingBase var1, FontRenderer var2, double var3) {
      EnumChatFormatting var6 = EnumChatFormatting.GREEN;
      Value.c27574();
      EnumChatFormatting var7 = EnumChatFormatting.RED;
      EnumChatFormatting var8 = EnumChatFormatting.BLUE;
      EnumChatFormatting var9 = EnumChatFormatting.RESET;
      int var10 = Math.round(mc.thePlayer.getDistanceToEntity(var1));
      String var11 = var1.getDisplayName().getFormattedText();
      float var12 = (float)Math.round(var1.getHealth() * 5.0F) / 10.0F;
      String var13 = var1.getHealth() == (float) mc.thePlayer.getTotalArmorValue() ? EnumChatFormatting.YELLOW + "=" : (var1.getTotalArmorValue() > mc.thePlayer.getTotalArmorValue() ? EnumChatFormatting.RED + "-" : EnumChatFormatting.GREEN + "+");
      float var14 = var1.getHealth() / var1.getMaxHealth() * 100.0F;
      int var15 = -16408318;
      String var16 = "";
      int var17 = 0;
      if (var17 <= Float.toString(var12).length() + 1) {
         var16 = var16 + " ";
         ++var17;
      }

      if (var14 < 70.0F) {
         var15 = -786584;
      }

      if (var14 <= 50.0F) {
         var15 = -1986271;
      }

      if (var14 <= 20.0F) {
         var15 = -6813677;
      }

      String var22 = var6 + "[" + var9 + var10 + var6 + "] " + var11 + var9 + " ";
      String var18 = var6 + "[" + var9 + var10 + var6 + "] " + var11 + var9 + " " + var16 + " " + var13;
      double var19 = (double)var2.getStringWidth(var18);
      RenderUtilD.c24215(-var19 / 2.0D - 2.0D, -2.0D + var3 - 2.0D, var19 / 2.0D + 2.0D, (double)var2.FONT_HEIGHT + 0.5D + var3 - 2.0D, -2013265920);
      this.c68441(var18, 0.0F, (float)(var3 - 2.0D), -1);
      var2.drawString(Float.toString(var12), (int)(-var19 / 2.0D + (double)var2.getStringWidth(var22) + 2.0D), (int)(var3 - 2.0D), var15);
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }
}
