//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.Client;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender2D;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector4d;

import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import ft.sleep.module.modules.AntiBot;
import ft.sleep.module.modules.ESP2D;
import ft.sleep.util.color.ColorUtils;
import ft.sleep.util.render.RenderUtils;
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

public class Tags extends Module {
   public static Mode operated$ = new Mode("Mode", new String[]{"Vape", "Astolfo", "Name"}, "Astolfo");
   public Numbers transmit$ = new Numbers("Scale", Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3), 0.05D);
   public List thumb$ = new ArrayList();
   public Option modern$ = new Option("Players", true);
   public Option borough$ = new Option("Mobs", false);
   public Option british$ = new Option("Invisible", false);
   public Option experts$ = new Option("Animals", false);
   public Option theorem$ = new Option("Dead", false);
   public Option network$ = new Option("Outline", true);
   public static Option proceed$ = new Option("mcTheplayer", false);
   public Pattern titans$ = Pattern.compile("(?i)Â§[0-9A-FK-ORX]");

   public Tags() {
      super("CustomTags", new String[]{"CustomTags"}, ModuleType.ignored$);
      referral._piece((new Color(29, 187, 102)).getRGB());
   }

   @EventHandler
   public void _hospital(EventRender2D nunadoro) {
      Client.î ?();
      Object afapelal = (ESP2D) ModuleManager._herbs(ESP2D.class);
      Object osiropal = afapelal._central();
      Object vitusale = 3.0D - muyuteni.transmit$.getValue().doubleValue();
      Object ucafodes = muyuteni.mc.fontRendererObj;
      Object gozoguru = muyuteni._proof();
      if (muyuteni.mc.gameSettings.thirdPersonView != 0 && proceed$.getValue().booleanValue()) {
         gozoguru.add(muyuteni.mc.thePlayer);
      }

      for(Object avufopup : gozoguru) {
         Object nalunimo = RenderUtils._kijiji(avufopup.posX, avufopup.lastTickPosX, ((EventRender2D)nunadoro).getPartialTicks());
         Object ogefeted = RenderUtils._kijiji(avufopup.posY, avufopup.lastTickPosY, ((EventRender2D)nunadoro).getPartialTicks()) - vitusale / 30.0D + avufopup.getDistance(muyuteni.mc.getRenderManager().viewerPosX, muyuteni.mc.getRenderManager().viewerPosY, muyuteni.mc.getRenderManager().viewerPosZ) / (40.0D * vitusale);
         Object comamogo = RenderUtils._kijiji(avufopup.posZ, avufopup.lastTickPosZ, ((EventRender2D)nunadoro).getPartialTicks());
         Object olarazes = (double)avufopup.width / 1.5D;
         Object aruvomov = (double)avufopup.getEyeHeight() * 1.3185D;
         Object usupafar = null;
         AxisAlignedBB var21 = new AxisAlignedBB(nalunimo - olarazes, ogefeted, comamogo - olarazes, nalunimo + olarazes, ogefeted + aruvomov, comamogo + olarazes);
         List var22 = Arrays.asList(new Vector3d(var21.minX, var21.minY, var21.minZ), new Vector3d(var21.minX, var21.maxY, var21.minZ), new Vector3d(var21.maxX, var21.minY, var21.minZ), new Vector3d(var21.maxX, var21.maxY, var21.minZ), new Vector3d(var21.minX, var21.minY, var21.maxZ), new Vector3d(var21.minX, var21.maxY, var21.maxZ), new Vector3d(var21.maxX, var21.minY, var21.maxZ), new Vector3d(var21.maxX, var21.maxY, var21.maxZ));
         muyuteni.mc.entityRenderer.setupCameraTransform(((EventRender2D)nunadoro).getPartialTicks(), 0);
         float var23 = 0.2F;
         if (Minecraft.getMinecraft().thePlayer.getDistanceToEntity(avufopup) > 50.0F) {
            var23 = 0.7F;
         }

         for(Vector3d var25 : var22) {
            if (osiropal) {
               var25 = RenderUtils._istanbul(var25.x - muyuteni.mc.getRenderManager().viewerPosX, var25.y - muyuteni.mc.getRenderManager().viewerPosY + (double)var23, var25.z - muyuteni.mc.getRenderManager().viewerPosZ);
            } else {
               var25 = RenderUtils._istanbul(avufopup.posX - muyuteni.mc.getRenderManager().viewerPosX, ogefeted + aruvomov - muyuteni.mc.getRenderManager().viewerPosY, avufopup.posZ - muyuteni.mc.getRenderManager().viewerPosZ);
            }

            if (var25 != null && var25.z >= Double.longBitsToDouble(0L) && var25.z < 1.0D) {
               if (usupafar == null) {
                  usupafar = new Vector4d(var25.x, var25.y, var25.z, Double.longBitsToDouble(0L));
               }

               usupafar.x = Math.min(var25.x, usupafar.x);
               usupafar.y = Math.min(var25.y, usupafar.y);
               usupafar.z = Math.max(var25.x, usupafar.z);
               usupafar.w = Math.max(var25.y, usupafar.w);
            }
         }

         muyuteni.mc.entityRenderer.setupOverlayRendering();
         if (usupafar != null) {
            float var27 = (float)usupafar.x;
            float var29 = (float)usupafar.z;
            float var26 = (float)usupafar.y - 1.0F;
            GlStateManager.translate(var27 + (var29 - var27) / 2.0F, var26, 1.0F);
            GlStateManager.scale(1.0D / vitusale, 1.0D / vitusale, 1.0D);
            if (Objects.equals(operated$.getValue(), "Vape")) {
               muyuteni._motorola(avufopup, ucafodes, aruvomov);
            } else if (Objects.equals(operated$.getValue(), "Astolfo")) {
               muyuteni._download(avufopup, ucafodes, aruvomov);
            } else if (Objects.equals(operated$.getValue(), "Name")) {
               ucafodes.drawStringWithShadow(avufopup.getDisplayName().getFormattedText(), (float)(-ucafodes.getStringWidth(avufopup.getDisplayName().getFormattedText()) / 2), (float)ucafodes.FONT_HEIGHT, ColorUtils.liquid$.hygiene$);
            }

            GlStateManager.scale(1.0D * vitusale, 1.0D * vitusale, 1.0D);
            GlStateManager.translate(-(var27 + (var29 - var27) / 2.0F), -var26, 1.0F);
         }
      }

   }

   public List _proof() {
      if (!eating._central()) {
         return new ArrayList();
      } else {
         Object attacked = Minecraft.getMinecraft();
         eating.thumb$ = new ArrayList();
         Stream var10000 = attacked.theWorld.loadedEntityList.stream();
         EntityLivingBase.class.getClass();

         for(Object counted : (List)var10000.filter(EntityLivingBase.class::isInstance).collect(Collectors.toList())) {
            Object eagles = (EntityLivingBase)counted;
            if (eagles != attacked.thePlayer && !AntiBot._remind(eagles) && !(eagles instanceof EntityArmorStand) && !(eagles instanceof EntityVillager) && (eating.british$.getValue().booleanValue() || eagles.isInvisible()) && (eating.borough$.getValue().booleanValue() || !(eagles instanceof EntityMob)) && (eating.experts$.getValue().booleanValue() || !(eagles instanceof EntityAnimal) && !(eagles instanceof EntityBat)) && (eating.modern$.getValue().booleanValue() || !(eagles instanceof EntityPlayer)) && (eating.theorem$.getValue().booleanValue() || !eagles.isDead && eagles.getHealth() > Float.intBitsToFloat(0))) {
               eating.thumb$.add(eagles);
            }
         }

         return eating.thumb$;
      }
   }

   public void _download(EntityLivingBase indirect, FontRenderer promptly, double located) {
      Object compile = (float)Math.round(((EntityLivingBase)indirect).getHealth() * 10.0F) / 10.0F + "";
      Object caught = (float)Math.round(fresh.mc.thePlayer.getDistanceToEntity((Entity)indirect) * 10.0F) / 10.0F + "";
      Object rural = ((EntityLivingBase)indirect).getDisplayName().getFormattedText() + " Â§7[Â§f" + compile + "Â§câ¤Â?7] " + EnumChatFormatting.RESET + "- " + caught + "m";
      String var8 = Client.î ?().î ?().friendsConfig.isFriend(((EntityLivingBase)indirect).getDisplayName().getFormattedText()) ? EnumChatFormatting.AQUA + rural : EnumChatFormatting.RESET + rural;
      RenderUtils._illness((double)(-((FontRenderer)promptly).getStringWidth(rural) / 2 - 3), located - 2.0D, (double)(((FontRenderer)promptly).getStringWidth(rural) / 2 + 3), (double)(((FontRenderer)promptly).FONT_HEIGHT + 2) + located, -1728053248);
      if (fresh.network$.getValue().booleanValue()) {
         fresh._cayman(var8, Float.intBitsToFloat(0), (float)(located + 0.5D), ColorUtils.liquid$.hygiene$);
      } else {
         fresh._domains(rural, Float.intBitsToFloat(0), (float)(located + 0.5D), ColorUtils.liquid$.hygiene$);
      }

   }

   public String _walls(String pigavizi) {
      return zitovica.titans$.matcher((CharSequence)pigavizi).replaceAll("");
   }

   public void _cayman(String ucolapir, float givamiya, float nanopula, int anenoliv) {
      odubugif.mc.fontRendererObj.drawString(odubugif._walls((String)ucolapir), givamiya - (float)(odubugif.mc.fontRendererObj.getStringWidth((String)ucolapir) / 2) - 0.5F, (float)nanopula, 0, false);
      odubugif.mc.fontRendererObj.drawString(odubugif._walls((String)ucolapir), givamiya - (float)(odubugif.mc.fontRendererObj.getStringWidth((String)ucolapir) / 2) + 0.5F, (float)nanopula, 0, false);
      odubugif.mc.fontRendererObj.drawString(odubugif._walls((String)ucolapir), givamiya - (float)(odubugif.mc.fontRendererObj.getStringWidth((String)ucolapir) / 2), nanopula - 0.5F, 0, false);
      odubugif.mc.fontRendererObj.drawString(odubugif._walls((String)ucolapir), givamiya - (float)(odubugif.mc.fontRendererObj.getStringWidth((String)ucolapir) / 2), nanopula + 0.5F, 0, false);
      odubugif.mc.fontRendererObj.drawString((String)ucolapir, givamiya - (float)(odubugif.mc.fontRendererObj.getStringWidth((String)ucolapir) / 2), (float)nanopula, (int)anenoliv, false);
   }

   public void _domains(String upper, float normally, float deposit, int posted) {
      middle.mc.fontRendererObj.drawStringWithShadow((String)upper, normally - (float)(middle.mc.fontRendererObj.getStringWidth((String)upper) / 2), (float)deposit, (int)posted);
   }

   public void _motorola(EntityLivingBase spyware, FontRenderer watson, double bachelor) {
      Object tragedy = EnumChatFormatting.GREEN;
      Object tribe = EnumChatFormatting.RED;
      Object bones = EnumChatFormatting.BLUE;
      Object ferry = EnumChatFormatting.RESET;
      Object operates = Math.round(eugene.mc.thePlayer.getDistanceToEntity((Entity)spyware));
      Object castle = ((EntityLivingBase)spyware).getDisplayName().getFormattedText();
      Object bureau = (float)Math.round(((EntityLivingBase)spyware).getHealth() * 5.0F) / 10.0F;
      Object racks = ((EntityLivingBase)spyware).getHealth() == (float)eugene.mc.thePlayer.getTotalArmorValue() ? EnumChatFormatting.YELLOW + "=" : (((EntityLivingBase)spyware).getTotalArmorValue() > eugene.mc.thePlayer.getTotalArmorValue() ? EnumChatFormatting.RED + "-" : EnumChatFormatting.GREEN + "+");
      Object dispatch = ((EntityLivingBase)spyware).getHealth() / ((EntityLivingBase)spyware).getMaxHealth() * 100.0F;
      Object norway = -16408318;
      Object covered = "";

      for(int var16 = 0; var16 <= Float.toString(bureau).length() + 1; ++var16) {
         covered = covered + " ";
      }

      if (dispatch < 70.0F) {
         norway = -786584;
      }

      if (dispatch <= 50.0F) {
         norway = -1986271;
      }

      if (dispatch <= 20.0F) {
         norway = -6813677;
      }

      String var20 = tragedy + "[" + ferry + operates + tragedy + "] " + castle + ferry + " ";
      String var17 = tragedy + "[" + ferry + operates + tragedy + "] " + castle + ferry + " " + covered + " " + racks;
      double var18 = (double)((FontRenderer)watson).getStringWidth(var17);
      RenderUtils._illness(-var18 / 2.0D - 2.0D, -2.0D + bachelor - 2.0D, var18 / 2.0D + 2.0D, (double)((FontRenderer)watson).FONT_HEIGHT + 0.5D + bachelor - 2.0D, -2013265920);
      eugene._domains(var17, Float.intBitsToFloat(0), (float)(bachelor - 2.0D), -1);
      ((FontRenderer)watson).drawString(Float.toString(bureau), (int)(-var18 / 2.0D + (double)((FontRenderer)watson).getStringWidth(var20) + 2.0D), (int)(bachelor - 2.0D), norway);
   }
}
