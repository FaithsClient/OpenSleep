package rip.sleep.module.modules;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import rip.sleep.injection.in.IRenderManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.command.ICommandSender;
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
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.json.JSONException;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.Render2DEventA;
import rip.sleep.event.events.Render3DEvent;
import rip.sleep.module.Module;
import rip.sleep.ui.font.FontManager;
import rip.sleep.util.ColorUtil;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.NumberValue;
import rip.sleep.module.ModuleType;

public class NameTags extends Module {
   private final ModeValue c47040 = new ModeValue("Font Mode", new String[]{"Client", "Vanilla"}, "Vanilla");
   private final ModeValue c63821 = new ModeValue("Health Mode", new String[]{"Bar", "Value"}, "Value");
   public static NumberValue<Number> c55012 = new NumberValue<Number>("Scale", 2.0D, 0.0D, 5.0D, 0.1D);
   public static NumberValue<Number> c44563 = new NumberValue<Number>("Alpha", 70.0D, 0.0D, 255.0D, 1.0D);
   public static NumberValue<Number> c3767 = new NumberValue<Number>("Distance", 256.0D, 4.0D, 256.0D, 1.0D);
   public static BooleanValue c96205 = new BooleanValue("Range", true);
   public static BooleanValue c18145 = new BooleanValue("Armor", true);
   public static BooleanValue c12312 = new BooleanValue("Background", true);
   public static BooleanValue c80193 = new BooleanValue("Head", true);
   public static BooleanValue c39341 = new BooleanValue("Outline", false);
   public static BooleanValue c37983 = new BooleanValue("Health", true);
   public static BooleanValue c52073 = new BooleanValue("Low Teams", true);
   public static BooleanValue c21669 = new BooleanValue("Low Target", true);
   private final List<NameTags.c65534> c15032 = new CopyOnWriteArrayList();
   private final Pattern c24302 = Pattern.compile("(?i)§[0-9A-FK-ORX]");

   public NameTags() {
      super("Name Tags", new String[]{"tags"}, ModuleType.c12482, ModuleType.c21190.c1301);
   }

   public void c71897() {
      this.c15032.clear();
   }

   private NameTags.c65534 c89059(EntityLivingBase var1) {
      return (NameTags.c65534)this.c15032.stream().filter((var1x) -> {
         return var1x.c83752.equals(var1);
      }).findFirst().orElse((Object)null);
   }

   @EventTarget
   public void c82872(Render2DEventA var1) {
      this.c15032.forEach(NameTags.c65534::c41126);
   }

   @EventTarget
   private void c78334(Render3DEvent var1) {
      Stream var10000 = Minecraft.getMinecraft().theWorld.getLoadedEntityList().stream();
      EntityPlayer.class.getClass();
      var10000 = var10000.filter(EntityPlayer.class::isInstance).filter((var0) -> {
         Module[] var1 = Value.c27574();
         return !var0.isInvisible();
      }).filter(Entity::isEntityAlive);
      EntityLivingBase.class.getClass();
      var10000.map(EntityLivingBase.class::cast).filter((var1x) -> {
         Module[] var2 = Value.c27574();
         return !this.c15032.contains(this.c89059(var1x));
      }).forEach((var1x) -> {
         this.c15032.add(new NameTags.c65534(var1x));
      });
      this.c15032.forEach((var2x) -> {
         Module[] var3 = Value.c27574();
         if (!var2x.c83752.isEntityAlive() || Minecraft.getMinecraft().thePlayer.getDistanceToEntity(var2x.c83752) > (float)c3767.c53968().intValue()) {
            this.c15032.remove(var2x);
         }

         if (!Minecraft.getMinecraft().theWorld.getLoadedEntityList().contains(var2x.c83752) || var2x.c83752.getDisplayName().getFormattedText().contains("NPC") || var2x.c83752.getDisplayName().getUnformattedText().equalsIgnoreCase(var2x.c83752.getName())) {
            this.c15032.remove(var2x);
         }

         float var4 = (float)(var2x.c83752.lastTickPosX + (var2x.c83752.posX - var2x.c83752.lastTickPosX) * (double)var1.c36064() - ((IRenderManager) mc.getRenderManager()).getRenderPosX());
         float var5 = (float)(var2x.c83752.lastTickPosY + 2.3D + (var2x.c83752.posY + 2.3D - (var2x.c83752.lastTickPosY + 2.3D)) * (double)var1.c36064() - ((IRenderManager) mc.getRenderManager()).getRenderPosY());
         float var6 = (float)(var2x.c83752.lastTickPosZ + (var2x.c83752.posZ - var2x.c83752.lastTickPosZ) * (double)var1.c36064() - ((IRenderManager) mc.getRenderManager()).getRenderPosZ());
         var2x.c99402 = var2x.c31667((double)var4, (double)var5, (double)var6);
      });
   }

   public List<NameTags.c65534> c71549() {
      return this.c15032;
   }

   public String c75596(String var1) {
      return this.c24302.matcher(var1).replaceAll("");
   }

   public void c68564(String var1, float var2, float var3, int var4) {
      mc.fontRendererObj.drawString(this.c75596(var1), var2 - 0.5F, var3, 0, false);
      mc.fontRendererObj.drawString(this.c75596(var1), var2 + 0.5F, var3, 0, false);
      mc.fontRendererObj.drawString(this.c75596(var1), var2, var3 - 0.5F, 0, false);
      mc.fontRendererObj.drawString(this.c75596(var1), var2, var3 + 0.5F, 0, false);
      mc.fontRendererObj.drawString(var1, var2, var3, var4, false);
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }

   private class c65534 {
      private final EntityLivingBase c83752;
      private double[] c99402 = new double[]{0.0D, 0.0D, 0.0D};
      private static final String c39301 = "pro";
      private static final String c99665 = "sha";

      public c65534(EntityLivingBase var2) {
         this.c83752 = var2;
      }

      void c41126() {
         GL11.glPushMatrix();
         ScaledResolution var2 = new ScaledResolution(Minecraft.getMinecraft());
         Value.c27574();
         float var3 = (float)(this.c99402[0] / (double)var2.getScaleFactor());
         float var4 = (float)(this.c99402[1] / (double)var2.getScaleFactor());
         float var5 = (float)(this.c99402[2] / (double)var2.getScaleFactor());
         String var6 = NameTags.c37983.c1473().booleanValue() ? (Objects.equals(NameTags.this.c63821.c54460(), "Value") ? (NameTags.c39341.c1473().booleanValue() ? EnumChatFormatting.BOLD : EnumChatFormatting.BOLD) + " [" + EnumChatFormatting.RESET + (int)(this.c83752.getHealth() + this.c83752.getAbsorptionAmount()) + (NameTags.c39341.c1473().booleanValue() ? EnumChatFormatting.BOLD : EnumChatFormatting.BOLD) + "" + (NameTags.c39341.c1473().booleanValue() ? EnumChatFormatting.BOLD : EnumChatFormatting.BOLD) + "]" : "") : "";
         String var7 = NameTags.c96205.c1473().booleanValue() ? (NameTags.c39341.c1473().booleanValue() ? EnumChatFormatting.BOLD : EnumChatFormatting.BOLD) + "[" + EnumChatFormatting.WHITE + (int)Minecraft.getMinecraft().thePlayer.getDistanceToEntity(this.c83752) + (NameTags.c39341.c1473().booleanValue() ? EnumChatFormatting.BOLD : EnumChatFormatting.BOLD) + "] " : "";
         String var8 = this.c83752.getDisplayName().getFormattedText();
         if (NameTags.c52073.c1473().booleanValue() && this.c83752.getHealth() < 10.0F && Teams.c55703(this.c83752)) {
            var8 = var8 + " §c[TBlood§c]§r";
         }

         if (Sleep.getInstance().c43557().c25756.c43312(this.c83752.getName())) {
            var8 = var8 + " §b[Friend§b]§r";
         }

         if (NameTags.c21669.c1473().booleanValue() && this.c83752.getHealth() < 10.0F && !Teams.c55703(this.c83752)) {
            var8 = var8 + " §c[Blood§c]§r";
         }

         GL11.glTranslatef(var3, var4, var5);
         float var9 = 1.0F;
         switch(Minecraft.getMinecraft().gameSettings.guiScale) {
         case 0:
            var9 = 0.5F;
         case 1:
            var9 = 2.0F;
         case 3:
            var9 = 0.6666667F;
         case 2:
         }

         if (this.c99402[2] >= 0.0D && this.c99402[2] < 1.0D) {
            ScaledResolution var10 = new ScaledResolution(Module.mc);
            double var11 = (double)var10.getScaleFactor() / Math.pow((double)var10.getScaleFactor(), NameTags.c55012.c53968().doubleValue());
            GL11.glScaled(var11, var11, var11);
            GlStateManager.disableDepth();
            String var13 = Sleep.getInstance().c43557().c25756.c43312(this.c83752.getName()) ? EnumChatFormatting.AQUA + var8 : EnumChatFormatting.RESET + var8;
            String var14 = var7 + var13;
            float var15 = Math.abs(-(this.c56317(var14) / 2.0F) - 3.0F - (this.c56317(var14) / 2.0F + 4.0F));
            float var16 = (float)((int)(this.c83752.getMaxHealth() + this.c83752.getAbsorptionAmount()));
            float var17 = 100.0F / var16;
            float var18 = (float)((int)((this.c83752.getHealth() + this.c83752.getAbsorptionAmount()) * var17));
            float var19 = var15 / 100.0F;
            int var20 = NameTags.c37983.c1473().booleanValue() && Objects.equals(NameTags.this.c63821.c54460(), "Value") ? 15 : 0;
            float var21 = this.c56317(var14) / 2.0F;
            ScaledResolution var22 = new ScaledResolution(Minecraft.getMinecraft());
            float var23 = (float)var22.getScaledWidth() / 2.0F;
            float var24 = (float)var22.getScaledHeight() / 2.0F;
            int var25 = (int)(this.c83752.getHealth() + this.c83752.getAbsorptionAmount()) >= 10 && (int)(this.c83752.getHealth() + this.c83752.getAbsorptionAmount()) <= 99 ? -6 : -3;
            int var26 = NameTags.c37983.c1473().booleanValue() && Objects.equals(NameTags.this.c63821.c54460(), "Value") ? (Objects.equals(NameTags.this.c47040.c54460(), "Client") ? var25 : ((int)(this.c83752.getHealth() + this.c83752.getAbsorptionAmount()) >= 10 && (int)(this.c83752.getHealth() + this.c83752.getAbsorptionAmount()) <= 99 ? -13 : -13)) : (Objects.equals(NameTags.this.c47040.c54460(), "Client") ? 2 : 1);
            int var27 = (new Color(0, 0, 0, NameTags.c44563.c53968().intValue())).getRGB();
            if (Sleep.INSTANCE.c43557().c25756.c43312(this.c83752.getName())) {
               var27 = (new Color(0, 255, 255, NameTags.c44563.c53968().intValue())).getRGB();
            }

            String var28 = this.c83752.getDisplayName().getUnformattedText();
            int var29 = NameTags.c44563.c53968().intValue();
            String var30 = var28.substring(1, 2);
            int var32 = -1;
            int var34 = -1;
            switch(var30.hashCode()) {
            case 48:
               if (!var30.equals("0")) {
                  break;
               }

               var34 = 0;
            case 49:
               if (!var30.equals("1")) {
                  break;
               }

               var34 = 1;
            case 50:
               if (!var30.equals("2")) {
                  break;
               }

               var34 = 2;
            case 51:
               if (!var30.equals("3")) {
                  break;
               }

               var34 = 3;
            case 52:
               if (!var30.equals("4")) {
                  break;
               }

               var34 = 4;
            case 53:
               if (!var30.equals("5")) {
                  break;
               }

               var34 = 5;
            case 54:
               if (!var30.equals("6")) {
                  break;
               }

               var34 = 6;
            case 55:
               if (!var30.equals("7")) {
                  break;
               }

               var34 = 7;
            case 56:
               if (!var30.equals("8")) {
                  break;
               }

               var34 = 8;
            case 57:
               if (!var30.equals("9")) {
                  break;
               }

               var34 = 9;
            case 97:
               if (!var30.equals("a")) {
                  break;
               }

               var34 = 10;
            case 98:
               if (!var30.equals("b")) {
                  break;
               }

               var34 = 11;
            case 99:
               if (!var30.equals("c")) {
                  break;
               }

               var34 = 12;
            case 100:
               if (!var30.equals("d")) {
                  break;
               }

               var34 = 13;
            case 101:
               if (!var30.equals("e")) {
                  break;
               }

               var34 = 14;
            case 102:
               if (var30.equals("f")) {
                  var34 = 15;
               }
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            }

            switch(var34) {
            case 0:
               new Color(0, 0, 0);
            case 1:
               new Color(0, 0, 170);
            case 2:
               new Color(0, 170, 0);
            case 3:
               new Color(0, 170, 170);
            case 4:
               new Color(170, 0, 0);
            case 5:
               new Color(170, 0, 170);
            case 6:
               new Color(255, 170, 0);
            case 7:
               new Color(170, 170, 170);
            case 8:
               new Color(85, 85, 85);
            case 9:
               new Color(85, 85, 255);
            case 10:
               new Color(85, 255, 85);
            case 11:
               new Color(85, 255, 255);
            case 12:
               new Color(255, 85, 85);
            case 13:
               new Color(255, 85, 255);
            case 14:
               new Color(255, 255, 85);
            case 15:
               new Color(255, 255, 255);
            default:
               Color var31 = new Color(255, 255, 255);
               int var33 = var31.getRed();
               var34 = var31.getGreen();
               int var35 = var31.getBlue();
               var32 = (new Color(var33, var34, var35, var29)).getRGB();
               if (this.c83752.getHealth() < 10.0F) {
                  var27 = var32;
               }

               if (NameTags.c12312.c1473().booleanValue()) {
                  this.c2814(-var21 - 2.0F - (float)var20, -8.0F - this.c85060(), this.c56317(var14 + var6) / 2.0F + (Objects.equals(NameTags.this.c63821.c54460(), "Bar") ? 2.0F : this.c56317(var6) + (float)var26 - (float)var20), (float)(NameTags.c37983.c1473().booleanValue() ? (Objects.equals(NameTags.this.c63821.c54460(), "Bar") ? 6 : 5) : 5) - this.c85060(), var27);
               }

               if (this.c83752 != Minecraft.getMinecraft().thePlayer) {
                  if (NameTags.c80193.c1473().booleanValue()) {
                     this.c5951(((AbstractClientPlayer)this.c83752).getLocationSkin(), (int)(-var21 - 15.4F - (float)var20), (int)(-8.5F - this.c85060()), 13, 13);
                  }

                  if (NameTags.c18145.c1473().booleanValue()) {
                     this.c47461((EntityPlayer)this.c83752);
                  }
               }

               this.c19335(var14, -var21 - (float)var20, -this.c85060() - 5.0F, ColorUtil.c27970.c79340);
               this.c19335(var6, var21 - (float)var20, -this.c85060() - 5.0F, this.c38481());
               if (NameTags.c37983.c1473().booleanValue() && Objects.equals(NameTags.this.c63821.c54460(), "Bar")) {
                  this.c2814(-var21 - 2.0F, 5.0F - this.c85060(), -var21 - 5.0F + var18 * var19, 6.0F - this.c85060(), this.c38481());
               }

               GlStateManager.enableDepth();
               GL11.glPopMatrix();
            }
         } else {
            GlStateManager.popMatrix();
         }
      }

      private void c19335(String var1, float var2, float var3, int var4) {
         Module[] var5 = Value.c27574();
         if (Objects.equals(NameTags.this.c47040.c54460(), "Client")) {
            FontManager.c3113.c17470(var1, (double)var2, (double)var3 + 0.8D, var4);
         }

         if (NameTags.c39341.c1473().booleanValue()) {
            Module.mc.fontRendererObj.drawStringWithShadow(var1, var2, var3, var4);
         }

         if (this.c83752.getHealth() < 10.0F) {
            Module.mc.fontRendererObj.drawStringWithShadow(var1, var2, var3, var4);
         }

         Module.mc.fontRendererObj.drawString(var1, var2, var3, var4, false);
      }

      public boolean c47891(ICommandSender var1, ICommandSender var2) {
         Value.c27574();
         String var4 = "§" + this.c9693(var1);
         return var1.getDisplayName().getFormattedText().contains(var4) && var2.getDisplayName().getFormattedText().contains(var4);
      }

      public boolean c91429(ICommandSender var1) {
         return this.c47891(Minecraft.getMinecraft().thePlayer, var1);
      }

      public String c9693(ICommandSender var1) {
         Value.c27574();
         Matcher var3 = Pattern.compile("§(.).*§r").matcher(var1.getDisplayName().getFormattedText());
         return var3.find() ? var3.group(1) : "f";
      }

      private float c56317(String var1) {
         Module[] var2 = Value.c27574();
         return Objects.equals(NameTags.this.c47040.c54460(), "Client") ? (float) FontManager.c3113.c65036(var1) : (float) Module.mc.fontRendererObj.getStringWidth(var1);
      }

      private float c85060() {
         Value.c27574();
         float var2 = Minecraft.getMinecraft().thePlayer.getDistanceToEntity(this.c83752);
         return Objects.equals(NameTags.this.c63821.c54460(), "Bar") ? (float)Math.max((double)this.c56625() * (var2 >= 110.0F ? 0.058D : 0.032D + (double)(4.0F / var2)), 1.0D) : (float)Math.max((double)this.c56625() * (var2 >= 110.0F ? 0.046D : 0.02D + (double)(4.0F / var2)), 1.0D);
      }

      private int c38481() {
         float var1 = this.c83752.getHealth();
         float var2 = this.c83752.getMaxHealth();
         float var3 = Math.max(0.0F, Math.min(var1, var2) / var2);
         return Color.HSBtoRGB(var3 / 3.0F, 1.0F, 1.0F) | -16777216;
      }

      private int c56625() {
         int var1 = (int)Math.abs(Minecraft.getMinecraft().thePlayer.posX - this.c83752.posX);
         int var2 = (int)Math.abs(Minecraft.getMinecraft().thePlayer.posY - this.c83752.posY);
         int var3 = (int)Math.abs(Minecraft.getMinecraft().thePlayer.posZ - this.c83752.posZ);
         return (int)Math.sqrt((double)(var1 * var1 + var2 * var2 + var3 * var3));
      }

      private double[] c31667(double var1, double var3, double var5) {
         FloatBuffer var8 = BufferUtils.createFloatBuffer(3);
         Value.c27574();
         IntBuffer var9 = BufferUtils.createIntBuffer(16);
         FloatBuffer var10 = BufferUtils.createFloatBuffer(16);
         FloatBuffer var11 = BufferUtils.createFloatBuffer(16);
         GL11.glGetFloat(2982, var10);
         GL11.glGetFloat(2983, var11);
         GL11.glGetInteger(2978, var9);
         boolean var12 = GLU.gluProject((float)var1, (float)var3, (float)var5, var10, var11, var9, var8);
         return var12 ? new double[]{(double)var8.get(0), (double)((float)Display.getHeight() - var8.get(1)), (double)var8.get(2)} : null;
      }

      public void c2814(float var1, float var2, float var3, float var4, int var5) {
         float var6 = (float)(var5 >> 24 & 255) / 255.0F;
         float var7 = (float)(var5 >> 16 & 255) / 255.0F;
         float var8 = (float)(var5 >> 8 & 255) / 255.0F;
         float var9 = (float)(var5 & 255) / 255.0F;
         GL11.glEnable(3042);
         GL11.glDisable(3553);
         GL11.glBlendFunc(770, 771);
         GL11.glEnable(2848);
         GL11.glPushMatrix();
         GL11.glColor4f(var7, var8, var9, var6);
         GL11.glBegin(7);
         GL11.glVertex2d((double)var3, (double)var2);
         GL11.glVertex2d((double)var1, (double)var2);
         GL11.glVertex2d((double)var1, (double)var4);
         GL11.glVertex2d((double)var3, (double)var4);
         GL11.glEnd();
         GL11.glPopMatrix();
         GL11.glEnable(3553);
         GL11.glDisable(3042);
         GL11.glDisable(2848);
         GlStateManager.enableTexture2D();
         GlStateManager.disableBlend();
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      }

      private void c47461(EntityPlayer var1) {
         Value.c27574();
         int var3 = 0;
         int var4 = 3;
         ItemStack var5 = var1.inventory.armorInventory[var4];
         if (var5 != null) {
            var3 -= 8;
         }

         --var4;
         if (var1.getCurrentEquippedItem() != null) {
            var3 = var3 - 8;
            ItemStack var6 = var1.getCurrentEquippedItem().copy();
            if (var6.hasEffect() && (var6.getItem() instanceof ItemTool || var6.getItem() instanceof ItemArmor)) {
               var6.stackSize = 1;
            }

            this.c35254(var6, var3, -33);
            var3 = var3 + 16;
         }

         var4 = 3;
         var5 = var1.inventory.armorInventory[var4];
         ItemStack var13 = var5.copy();
         if (var13.hasEffect() && (var13.getItem() instanceof ItemTool || var13.getItem() instanceof ItemArmor)) {
            var13.stackSize = 1;
         }

         this.c35254(var13, var3, -34);
         var3 = var3 + 16;
         --var4;
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      }

      public void c47925(int var1, int var2, float var3, float var4, int var5, int var6, int var7, int var8, float var9, float var10) {
         float var11 = 1.0F / var9;
         float var12 = 1.0F / var10;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         Tessellator var13 = Tessellator.getInstance();
         WorldRenderer var14 = var13.getWorldRenderer();
         var14.begin(7, DefaultVertexFormats.POSITION_TEX);
         var14.pos((double)var1, (double)(var2 + var8), 0.0D).tex((double)(var3 * var11), (double)((var4 + (float)var6) * var12)).endVertex();
         var14.pos((double)(var1 + var7), (double)(var2 + var8), 0.0D).tex((double)((var3 + (float)var5) * var11), (double)((var4 + (float)var6) * var12)).endVertex();
         var14.pos((double)(var1 + var7), (double)var2, 0.0D).tex((double)((var3 + (float)var5) * var11), (double)(var4 * var12)).endVertex();
         var14.pos((double)var1, (double)var2, 0.0D).tex((double)(var3 * var11), (double)(var4 * var12)).endVertex();
         var13.draw();
      }

      public void c5951(ResourceLocation var1, int var2, int var3, int var4, int var5) {
         Module.mc.getTextureManager().bindTexture(var1);
         this.c47925(var2, var3, 8.0F, 8.0F, 8, 8, var4, var5, 64.0F, 64.0F);
         this.c47925(var2, var3, 40.0F, 8.0F, 8, 8, var4, var5, 64.0F, 64.0F);
      }

      private void c35254(ItemStack var1, int var2, int var3) {
         GlStateManager.pushMatrix();
         GlStateManager.depthMask(true);
         GlStateManager.clear(256);
         RenderHelper.enableStandardItemLighting();
         Module.mc.getRenderItem().zLevel = -150.0F;
         GlStateManager.disableDepth();
         GlStateManager.disableTexture2D();
         GlStateManager.enableBlend();
         GlStateManager.enableAlpha();
         GlStateManager.enableTexture2D();
         GlStateManager.enableLighting();
         GlStateManager.enableDepth();
         Module.mc.getRenderItem().renderItemAndEffectIntoGUI(var1, var2, var3);
         Module.mc.getRenderItem().renderItemOverlays(Module.mc.fontRendererObj, var1, var2, var3);
         Module.mc.getRenderItem().zLevel = 0.0F;
         RenderHelper.disableStandardItemLighting();
         GlStateManager.disableCull();
         GlStateManager.enableAlpha();
         GlStateManager.disableBlend();
         GlStateManager.disableLighting();
         double var4 = 0.5D;
         GlStateManager.scale(var4, var4, var4);
         GlStateManager.disableDepth();
         this.c81580(var1, var2, var3);
         GlStateManager.enableDepth();
         GlStateManager.scale(2.0F, 2.0F, 2.0F);
         GlStateManager.popMatrix();
      }

      private void c81580(ItemStack var1, int var2, int var3) {
         Value.c27574();
         int var6 = var3 - 24;
         if (var1.getEnchantmentTagList() != null && var1.getEnchantmentTagList().tagCount() >= 6) {
            Module.mc.fontRendererObj.drawStringWithShadow("god", (float)(var2 * 2), (float)var6, 16711680);
         } else {
            if (var1.getItem() instanceof ItemArmor) {
               int var7 = EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, var1);
               int var8 = EnchantmentHelper.getEnchantmentLevel(Enchantment.projectileProtection.effectId, var1);
               int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.blastProtection.effectId, var1);
               int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireProtection.effectId, var1);
               int var11 = EnchantmentHelper.getEnchantmentLevel(Enchantment.thorns.effectId, var1);
               int var12 = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, var1);
               int var13 = var1.getMaxDamage() - var1.getItemDamage();
               Module.mc.fontRendererObj.drawStringWithShadow("" + var13, (float)(var2 * 2), (float)var3, 16777215);
               if (var7 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("prot" + var7, (float)(var2 * 2), (float)var6, -1);
                  var6 += 8;
               }

               if (var8 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("proj" + var8, (float)(var2 * 2), (float)var6, -1);
                  var6 += 8;
               }

               if (var9 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("bp" + var9, (float)(var2 * 2), (float)var6, -1);
                  var6 += 8;
               }

               if (var10 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("frp" + var10, (float)(var2 * 2), (float)var6, -1);
                  var6 += 8;
               }

               if (var11 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("th" + var11, (float)(var2 * 2), (float)var6, -1);
                  var6 += 8;
               }

               if (var12 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("unb" + var12, (float)(var2 * 2), (float)var6, -1);
                  var6 += 8;
               }
            }

            if (var1.getItem() instanceof ItemBow) {
               int var15 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, var1);
               int var18 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, var1);
               int var21 = EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, var1);
               int var5 = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, var1);
               if (var15 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("pow" + var15, (float)(var2 * 2), (float)var6, -1);
                  var6 += 8;
               }

               if (var18 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("pun" + var18, (float)(var2 * 2), (float)var6, -1);
                  var6 += 8;
               }

               if (var21 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("flame" + var21, (float)(var2 * 2), (float)var6, -1);
                  var6 += 8;
               }

               if (var5 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("unb" + var5, (float)(var2 * 2), (float)var6, -1);
                  var6 += 8;
               }
            }

            if (var1.getItem() instanceof ItemSword) {
               int var16 = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, var1);
               int var19 = EnchantmentHelper.getEnchantmentLevel(Enchantment.knockback.effectId, var1);
               int var22 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, var1);
               int var14 = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, var1);
               if (var16 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("sh" + var16, (float)(var2 * 2), (float)var6, -1);
                  var6 += 8;
               }

               if (var19 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("kb" + var19, (float)(var2 * 2), (float)var6, -1);
                  var6 += 8;
               }

               if (var22 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("fire" + var22, (float)(var2 * 2), (float)var6, -1);
                  var6 += 8;
               }

               if (var14 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("unb" + var14, (float)(var2 * 2), (float)var6, -1);
               }
            }

            if (var1.getItem() instanceof ItemTool) {
               int var17 = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, var1);
               int var20 = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, var1);
               int var23 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, var1);
               int var24 = EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId, var1);
               if (var20 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("eff" + var20, (float)(var2 * 2), (float)var6, -1);
                  var6 += 8;
               }

               if (var23 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("fo" + var23, (float)(var2 * 2), (float)var6, -1);
                  var6 += 8;
               }

               if (var24 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("silk" + var24, (float)(var2 * 2), (float)var6, -1);
                  var6 += 8;
               }

               if (var17 > 0) {
                  Module.mc.fontRendererObj.drawStringWithShadow("ub" + var17, (float)(var2 * 2), (float)var6, -1);
               }
            }

            if (var1.getItem() == Items.golden_apple && var1.hasEffect()) {
               Module.mc.fontRendererObj.drawStringWithShadow("god", (float)(var2 * 2), (float)var6, -1);
            }

         }
      }

      private static JSONException c18934(JSONException var0) {
         return var0;
      }
   }
}
