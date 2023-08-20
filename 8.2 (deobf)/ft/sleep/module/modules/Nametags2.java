//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.Client;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import java.nio.FloatBuffer;
import java.util.Objects;
import java.util.regex.Pattern;

import ft.sleep.util.color.ColorUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.command.ICommandSender;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class Nametags2 {
   public EntityLivingBase detect$;
   public double[] source$;
   public static String initial$ = "pro";
   public static String stranger$ = "sha";
   public Nametags example$;

   public Nametags2(Nametags teyigizu, EntityLivingBase tipomece) {
      ocofusor.example$ = (Nametags)teyigizu;
      super();
      ocofusor.source$ = new double[]{Double.longBitsToDouble(0L), Double.longBitsToDouble(0L), Double.longBitsToDouble(0L)};
      ocofusor.detect$ = (EntityLivingBase)tipomece;
   }

   public void _coding() {
      GL11.glPushMatrix();
      Object folders = new ScaledResolution(Minecraft.getMinecraft());
      Object scenes = (float)(count.source$[0] / (double)folders.getScaleFactor());
      Object niagara = (float)(count.source$[1] / (double)folders.getScaleFactor());
      Object creates = (float)(count.source$[2] / (double)folders.getScaleFactor());
      Object salary = Nametags.scoring$.getValue().booleanValue() ? (Objects.equals(Nametags._bishop(count.example$).getValue(), "Value") ? EnumChatFormatting.WHITE + " [" + EnumChatFormatting.RESET + (int)(count.detect$.getHealth() + count.detect$.getAbsorptionAmount()) + EnumChatFormatting.RED + "�?" + EnumChatFormatting.WHITE + "]" : "") : "";
      Object layout = Nametags.thunder$.getValue().booleanValue() ? EnumChatFormatting.WHITE + "[" + EnumChatFormatting.GREEN + (int)Minecraft.getMinecraft().thePlayer.getDistanceToEntity(count.detect$) + EnumChatFormatting.WHITE + "] " : "";
      Object aurora = count.detect$.getDisplayName().getFormattedText();
      if (Nametags.alerts$.getValue().booleanValue() && count.detect$.getHealth() < 10.0F && Teams._issued(count.detect$)) {
         aurora = aurora + " §c[TBlood§c]§r";
      }

      if (Client.�?().�?().friendsConfig.isFriend(count.detect$.getName())) {
         aurora = aurora + " §b[ft.sleep.command.commands.Friend§b]§r";
      }

      if (Nametags.scout$.getValue().booleanValue() && count.detect$.getHealth() < 10.0F && !Teams._issued(count.detect$)) {
         aurora = aurora + " §c[Blood§c]§r";
      }

      GL11.glTranslatef(scenes, niagara, creates);
      Object broker = 1.0F;
      switch(Minecraft.getMinecraft().gameSettings.guiScale) {
      case 0:
         broker = 0.5F;
         break;
      case 1:
         broker = 2.0F;
      case 2:
      default:
         break;
      case 3:
         broker = 0.6666667F;
      }

      if (count.source$[2] >= Double.longBitsToDouble(0L) && count.source$[2] < 1.0D) {
         Object detected = new ScaledResolution(count.example$.mc);
         Object floor = (double)detected.getScaleFactor() / Math.pow((double)detected.getScaleFactor(), Nametags.widely$.getValue().doubleValue());
         GL11.glScaled(floor, floor, floor);
         GlStateManager.disableDepth();
         Object impacts = Client.�?().�?().friendsConfig.isFriend(count.detect$.getName()) ? EnumChatFormatting.AQUA + aurora : EnumChatFormatting.RESET + aurora;
         Object casio = layout + impacts;
         Object mercedes = Math.abs(-(count._reaction(casio) / 2.0F) - 3.0F - (count._reaction(casio) / 2.0F + 4.0F));
         Object fifth = (float)((int)(count.detect$.getMaxHealth() + count.detect$.getAbsorptionAmount()));
         Object scholars = 100.0F / fifth;
         Object gonna = (float)((int)((count.detect$.getHealth() + count.detect$.getAbsorptionAmount()) * scholars));
         Object recovery = mercedes / 100.0F;
         Object lobby = Nametags.scoring$.getValue().booleanValue() && Objects.equals(Nametags._bishop(count.example$).getValue(), "Value") ? 15 : 0;
         Object divine = count._reaction(casio) / 2.0F;
         Object grove = new ScaledResolution(Minecraft.getMinecraft());
         float var22 = (float)grove.getScaledWidth() / 2.0F;
         float var23 = (float)grove.getScaledHeight() / 2.0F;
         int var24 = Nametags.scoring$.getValue().booleanValue() && Objects.equals(Nametags._bishop(count.example$).getValue(), "Value") ? (Objects.equals(Nametags._applies(count.example$).getValue(), "ft.sleep.util.other.Client") ? -4 : -12) : (Objects.equals(Nametags._applies(count.example$).getValue(), "ft.sleep.util.other.Client") ? 2 : 1);
         int var25 = (new Color(0, 0, 0, Nametags.hobbies$.getValue().intValue())).getRGB();
         if (Client.surround$.�?().friendsConfig.isFriend(count.detect$.getName())) {
            var25 = (new Color(0, 255, 255, Nametags.hobbies$.getValue().intValue())).getRGB();
         }

         if (count.detect$.getHealth() < 10.0F) {
            var25 = (new Color(255, 0, 0, Nametags.hobbies$.getValue().intValue())).getRGB();
         }

         if (Nametags.pants$.getValue().booleanValue()) {
            count._commerce(-divine - 2.0F - (float)lobby, -8.0F - count._apache(), count._reaction(casio + salary) / 2.0F + (Objects.equals(Nametags._bishop(count.example$).getValue(), "Bar") ? 2.0F : count._reaction(salary) + (float)var24 - (float)lobby), (float)(Nametags.scoring$.getValue().booleanValue() ? (Objects.equals(Nametags._bishop(count.example$).getValue(), "Bar") ? 6 : 5) : 5) - count._apache(), var25);
         }

         if (count.detect$ != Minecraft.getMinecraft().thePlayer) {
            if (Nametags.unlock$.getValue().booleanValue()) {
               count._perfect(((AbstractClientPlayer)count.detect$).getLocationSkin(), (int)(-divine - 15.4F - (float)lobby), (int)(-8.5F - count._apache()), 13, 13);
            }

            if (Nametags.afraid$.getValue().booleanValue()) {
               count._vision((EntityPlayer)count.detect$);
            }
         }

         count._chassis(casio, -divine - (float)lobby, -count._apache() - 5.0F, ColorUtils.liquid$.hygiene$);
         count._chassis(salary, divine - (float)lobby, -count._apache() - 5.0F, count._milan());
         if (Nametags.scoring$.getValue().booleanValue() && Objects.equals(Nametags._bishop(count.example$).getValue(), "Bar")) {
            count._commerce(-divine - 2.0F, 5.0F - count._apache(), -divine - 5.0F + gonna * recovery, 6.0F - count._apache(), count._milan());
         }

         GlStateManager.enableDepth();
         GL11.glPopMatrix();
      } else {
         GlStateManager.popMatrix();
      }
   }

   public void _chassis(String evecirin, float ramatofi, float asutogad, int iyipurev) {
      if (Objects.equals(Nametags._applies(lumufete.example$).getValue(), "ft.sleep.util.other.Client")) {
         FontLoaders.Roboto18.drawStringWithShadow((String)evecirin, (double)ramatofi, (double)asutogad + 0.8D, (int)iyipurev);
      } else if (Nametags.examined$.getValue().booleanValue()) {
         lumufete.example$._lebanon((String)evecirin, (float)ramatofi, (float)asutogad, (int)iyipurev);
      } else {
         lumufete.example$.mc.fontRendererObj.drawString((String)evecirin, (float)ramatofi, (float)asutogad, (int)iyipurev, false);
      }

   }

   public boolean _knows(ICommandSender rotation, ICommandSender specs) {
      Object worked = "§" + adobe._potter((ICommandSender)rotation);
      return ((ICommandSender)rotation).getDisplayName().getFormattedText().contains(worked) && ((ICommandSender)specs).getDisplayName().getFormattedText().contains(worked);
   }

   public boolean _beauty(ICommandSender except) {
      return consent._knows(Minecraft.getMinecraft().thePlayer, (ICommandSender)except);
   }

   public String _potter(ICommandSender udiveniy) {
      Object apepodeg = Pattern.compile("§(.).*§r").matcher(((ICommandSender)udiveniy).getDisplayName().getFormattedText());
      return apepodeg.find() ? apepodeg.group(1) : "f";
   }

   public float _reaction(String spaces) {
      return Objects.equals(Nametags._applies(chest.example$).getValue(), "ft.sleep.util.other.Client") ? (float)FontLoaders.Roboto18.getStringWidth((String)spaces) : (float)chest.example$.mc.fontRendererObj.getStringWidth((String)spaces);
   }

   public float _apache() {
      Object hughes = Minecraft.getMinecraft().thePlayer.getDistanceToEntity(salon.detect$);
      return Objects.equals(Nametags._bishop(salon.example$).getValue(), "Bar") ? (float)Math.max((double)salon._younger() * (hughes >= 110.0F ? 0.058D : 0.032D + (double)(4.0F / hughes)), 1.0D) : (float)Math.max((double)salon._younger() * (hughes >= 110.0F ? 0.046D : 0.02D + (double)(4.0F / hughes)), 1.0D);
   }

   public int _milan() {
      Object zitegegi = tucidice.detect$.getHealth();
      Object sadedede = tucidice.detect$.getMaxHealth();
      Object emudutuf = Math.max(Float.intBitsToFloat(0), Math.min(zitegegi, sadedede) / sadedede);
      return Color.HSBtoRGB(emudutuf / 3.0F, 1.0F, 1.0F) | -16777216;
   }

   public int _younger() {
      Object fecoyupi = (int)Math.abs(Minecraft.getMinecraft().thePlayer.posX - uvuyiriz.detect$.posX);
      Object yodecica = (int)Math.abs(Minecraft.getMinecraft().thePlayer.posY - uvuyiriz.detect$.posY);
      Object rutigope = (int)Math.abs(Minecraft.getMinecraft().thePlayer.posZ - uvuyiriz.detect$.posZ);
      return (int)Math.sqrt((double)(fecoyupi * fecoyupi + yodecica * yodecica + rutigope * rutigope));
   }

   public double[] _small(double otulomav, double erotudim, double asazilud) {
      Object iguramam = BufferUtils.createFloatBuffer(3);
      Object umilitas = BufferUtils.createIntBuffer(16);
      FloatBuffer var9 = BufferUtils.createFloatBuffer(16);
      FloatBuffer var10 = BufferUtils.createFloatBuffer(16);
      GL11.glGetFloat(2982, var9);
      GL11.glGetFloat(2983, var10);
      GL11.glGetInteger(2978, umilitas);
      boolean var11 = GLU.gluProject((float)otulomav, (float)erotudim, (float)asazilud, var9, var10, umilitas, iguramam);
      return var11 ? new double[]{(double)iguramam.get(0), (double)((float)Display.getHeight() - iguramam.get(1)), (double)iguramam.get(2)} : null;
   }

   public void _commerce(float iyorerag, float itaritem, float otubupet, float enurerev, int rucaraca) {
      Object urefanib = (float)(rucaraca >> 24 & 255) / 255.0F;
      Object ofuvefuf = (float)(rucaraca >> 16 & 255) / 255.0F;
      Object negofago = (float)(rucaraca >> 8 & 255) / 255.0F;
      Object pepinami = (float)(rucaraca & 255) / 255.0F;
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glEnable(2848);
      GL11.glPushMatrix();
      GL11.glColor4f(ofuvefuf, negofago, pepinami, urefanib);
      GL11.glBegin(7);
      GL11.glVertex2d((double)otubupet, (double)itaritem);
      GL11.glVertex2d((double)iyorerag, (double)itaritem);
      GL11.glVertex2d((double)iyorerag, (double)enurerev);
      GL11.glVertex2d((double)otubupet, (double)enurerev);
      GL11.glEnd();
      GL11.glPopMatrix();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glDisable(2848);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public void _vision(EntityPlayer igotanon) {
      Object fivobizo = 0;

      for(Object cizadire = 3; cizadire >= 0; --cizadire) {
         Object atigitof = ((EntityPlayer)igotanon).inventory.armorInventory[cizadire];
         if (atigitof != null) {
            fivobizo -= 8;
         }
      }

      if (((EntityPlayer)igotanon).getCurrentEquippedItem() != null) {
         fivobizo = fivobizo - 8;
         Object pobedovo = ((EntityPlayer)igotanon).getCurrentEquippedItem().copy();
         if (pobedovo.hasEffect() && (pobedovo.getItem() instanceof ItemTool || pobedovo.getItem() instanceof ItemArmor)) {
            pobedovo.stackSize = 1;
         }

         nodunubu._target(pobedovo, fivobizo, -33);
         fivobizo = fivobizo + 16;
      }

      for(Object var7 = 3; var7 >= 0; --var7) {
         Object var8 = ((EntityPlayer)igotanon).inventory.armorInventory[var7];
         if (var8 != null) {
            Object var9 = var8.copy();
            if (var9.hasEffect() && (var9.getItem() instanceof ItemTool || var9.getItem() instanceof ItemArmor)) {
               var9.stackSize = 1;
            }

            nodunubu._target(var9, fivobizo, -34);
            fivobizo += 16;
         }
      }

      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public void _shipping(int ivogetuc, int duvofuci, float avivazid, float obodilol, int nilebuyu, int imasadon, int etobabup, int aveyigem, float cayepige, float guzodegu) {
      Object losarora = 1.0F / cayepige;
      Object mepeyeyi = 1.0F / guzodegu;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Object pafunaci = Tessellator.getInstance();
      Object micarazo = pafunaci.getWorldRenderer();
      micarazo.begin(7, DefaultVertexFormats.POSITION_TEX);
      micarazo.pos((double)ivogetuc, (double)(duvofuci + aveyigem), Double.longBitsToDouble(0L)).tex((double)(avivazid * losarora), (double)((obodilol + (float)imasadon) * mepeyeyi)).endVertex();
      micarazo.pos((double)(ivogetuc + etobabup), (double)(duvofuci + aveyigem), Double.longBitsToDouble(0L)).tex((double)((avivazid + (float)nilebuyu) * losarora), (double)((obodilol + (float)imasadon) * mepeyeyi)).endVertex();
      micarazo.pos((double)(ivogetuc + etobabup), (double)duvofuci, Double.longBitsToDouble(0L)).tex((double)((avivazid + (float)nilebuyu) * losarora), (double)(obodilol * mepeyeyi)).endVertex();
      micarazo.pos((double)ivogetuc, (double)duvofuci, Double.longBitsToDouble(0L)).tex((double)(avivazid * losarora), (double)(obodilol * mepeyeyi)).endVertex();
      pafunaci.draw();
   }

   public void _perfect(ResourceLocation proteins, int centres, int college, int release, int qualify) {
      fifteen.example$.mc.getTextureManager().bindTexture((ResourceLocation)proteins);
      fifteen._shipping((int)centres, (int)college, 8.0F, 8.0F, 8, 8, (int)release, (int)qualify, 64.0F, 64.0F);
      fifteen._shipping((int)centres, (int)college, 40.0F, 8.0F, 8, 8, (int)release, (int)qualify, 64.0F, 64.0F);
   }

   public void _target(ItemStack lamanona, int uyomilon, int givozulo) {
      GlStateManager.pushMatrix();
      GlStateManager.depthMask(true);
      GlStateManager.clear(256);
      RenderHelper.enableStandardItemLighting();
      duyabuna.example$.mc.getRenderItem().zLevel = -150.0F;
      GlStateManager.disableDepth();
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
      GlStateManager.enableLighting();
      GlStateManager.enableDepth();
      duyabuna.example$.mc.getRenderItem().renderItemAndEffectIntoGUI((ItemStack)lamanona, (int)uyomilon, (int)givozulo);
      duyabuna.example$.mc.getRenderItem().renderItemOverlays(duyabuna.example$.mc.fontRendererObj, (ItemStack)lamanona, (int)uyomilon, (int)givozulo);
      duyabuna.example$.mc.getRenderItem().zLevel = Float.intBitsToFloat(0);
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableCull();
      GlStateManager.enableAlpha();
      GlStateManager.disableBlend();
      GlStateManager.disableLighting();
      Object mudutano = 0.5D;
      GlStateManager.scale(mudutano, mudutano, mudutano);
      GlStateManager.disableDepth();
      duyabuna._lexus((ItemStack)lamanona, (int)uyomilon, (int)givozulo);
      GlStateManager.enableDepth();
      GlStateManager.scale(2.0F, 2.0F, 2.0F);
      GlStateManager.popMatrix();
   }

   public void _lexus(ItemStack etudinig, int dosedevo, int gefipolu) {
      Object vidiyepi = gefipolu - 24;
      if (((ItemStack)etudinig).getEnchantmentTagList() != null && ((ItemStack)etudinig).getEnchantmentTagList().tagCount() >= 6) {
         gitubono.example$.mc.fontRendererObj.drawStringWithShadow("god", (float)(dosedevo * 2), (float)vidiyepi, 16711680);
      } else {
         if (((ItemStack)etudinig).getItem() instanceof ItemArmor) {
            Object tecobove = EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, (ItemStack)etudinig);
            Object berupali = EnchantmentHelper.getEnchantmentLevel(Enchantment.projectileProtection.effectId, (ItemStack)etudinig);
            Object titevusu = EnchantmentHelper.getEnchantmentLevel(Enchantment.blastProtection.effectId, (ItemStack)etudinig);
            Object camatabe = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireProtection.effectId, (ItemStack)etudinig);
            Object zisusadi = EnchantmentHelper.getEnchantmentLevel(Enchantment.thorns.effectId, (ItemStack)etudinig);
            Object vomopuve = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, (ItemStack)etudinig);
            Object uyunogis = ((ItemStack)etudinig).getMaxDamage() - ((ItemStack)etudinig).getItemDamage();
            gitubono.example$.mc.fontRendererObj.drawStringWithShadow("" + uyunogis, (float)(dosedevo * 2), (float)gefipolu, 16777215);
            if (tecobove > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("prot" + tecobove, (float)(dosedevo * 2), (float)vidiyepi, -1);
               vidiyepi += 8;
            }

            if (berupali > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("proj" + berupali, (float)(dosedevo * 2), (float)vidiyepi, -1);
               vidiyepi += 8;
            }

            if (titevusu > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("bp" + titevusu, (float)(dosedevo * 2), (float)vidiyepi, -1);
               vidiyepi += 8;
            }

            if (camatabe > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("frp" + camatabe, (float)(dosedevo * 2), (float)vidiyepi, -1);
               vidiyepi += 8;
            }

            if (zisusadi > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("th" + zisusadi, (float)(dosedevo * 2), (float)vidiyepi, -1);
               vidiyepi += 8;
            }

            if (vomopuve > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("unb" + vomopuve, (float)(dosedevo * 2), (float)vidiyepi, -1);
               vidiyepi += 8;
            }
         }

         if (((ItemStack)etudinig).getItem() instanceof ItemBow) {
            Object var14 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, (ItemStack)etudinig);
            Object var17 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, (ItemStack)etudinig);
            Object var20 = EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, (ItemStack)etudinig);
            Object riyezulo = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, (ItemStack)etudinig);
            if (var14 > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("pow" + var14, (float)(dosedevo * 2), (float)vidiyepi, -1);
               vidiyepi += 8;
            }

            if (var17 > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("pun" + var17, (float)(dosedevo * 2), (float)vidiyepi, -1);
               vidiyepi += 8;
            }

            if (var20 > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("flame" + var20, (float)(dosedevo * 2), (float)vidiyepi, -1);
               vidiyepi += 8;
            }

            if (riyezulo > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("unb" + riyezulo, (float)(dosedevo * 2), (float)vidiyepi, -1);
               vidiyepi += 8;
            }
         }

         if (((ItemStack)etudinig).getItem() instanceof ItemSword) {
            Object var15 = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, (ItemStack)etudinig);
            Object var18 = EnchantmentHelper.getEnchantmentLevel(Enchantment.knockback.effectId, (ItemStack)etudinig);
            Object var21 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, (ItemStack)etudinig);
            Object var13 = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, (ItemStack)etudinig);
            if (var15 > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("sh" + var15, (float)(dosedevo * 2), (float)vidiyepi, -1);
               vidiyepi += 8;
            }

            if (var18 > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("kb" + var18, (float)(dosedevo * 2), (float)vidiyepi, -1);
               vidiyepi += 8;
            }

            if (var21 > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("fire" + var21, (float)(dosedevo * 2), (float)vidiyepi, -1);
               vidiyepi += 8;
            }

            if (var13 > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("unb" + var13, (float)(dosedevo * 2), (float)vidiyepi, -1);
            }
         }

         if (((ItemStack)etudinig).getItem() instanceof ItemTool) {
            Object var16 = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, (ItemStack)etudinig);
            Object var19 = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, (ItemStack)etudinig);
            Object var22 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, (ItemStack)etudinig);
            Object var23 = EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId, (ItemStack)etudinig);
            if (var19 > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("eff" + var19, (float)(dosedevo * 2), (float)vidiyepi, -1);
               vidiyepi += 8;
            }

            if (var22 > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("fo" + var22, (float)(dosedevo * 2), (float)vidiyepi, -1);
               vidiyepi += 8;
            }

            if (var23 > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("silk" + var23, (float)(dosedevo * 2), (float)vidiyepi, -1);
               vidiyepi += 8;
            }

            if (var16 > 0) {
               gitubono.example$.mc.fontRendererObj.drawStringWithShadow("ub" + var16, (float)(dosedevo * 2), (float)vidiyepi, -1);
            }
         }

         if (((ItemStack)etudinig).getItem() == Items.golden_apple && ((ItemStack)etudinig).hasEffect()) {
            gitubono.example$.mc.fontRendererObj.drawStringWithShadow("god", (float)(dosedevo * 2), (float)vidiyepi, -1);
         }

      }
   }

   public static EntityLivingBase _nvidia(Nametags2 ediyidid) {
      return ((Nametags2)ediyidid).detect$;
   }

   public static double[] _weeks(Nametags2 ragivuro, double[] iveriyig) {
      return ((Nametags2)ragivuro).source$ = (double[])iveriyig;
   }

   public static double[] _events(Nametags2 tactics, double machines, double mobiles, double var5) {
      return ((Nametags2)tactics)._small((double)machines, (double)mobiles, var5);
   }
}
