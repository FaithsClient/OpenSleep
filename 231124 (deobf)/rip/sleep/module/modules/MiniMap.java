package rip.sleep.module.modules;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.ScorePlayerTeam;
import org.lwjgl.input.Mouse;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.Render2DEventA;
import rip.sleep.module.Module;
import rip.sleep.util.ColorUtil;
import rip.sleep.util.RenderUtilD;
import rip.sleep.util.RenderUtilF;
import rip.sleep.util.TargetUtil;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.NumberValue;
import rip.sleep.module.ModuleType;

public class MiniMap extends Module {
   private boolean c27337;
   float c57637;
   public final BooleanValue c38307 = new BooleanValue("Exh Radar", false);
   private NumberValue<Number> c31217 = new NumberValue<Number>("Scale", "Scale", 2.0D, 1.0D, 5.0D, 0.1D);
   private NumberValue<Number> c29785 = new NumberValue<Number>("X", "X", 500.0D, 1.0D, 1920.0D, 5.0D);
   private NumberValue<Number> c25966 = new NumberValue<Number>("Y", "Y", 2.0D, 1.0D, 1080.0D, 5.0D);
   private NumberValue<Number> c1696 = new NumberValue<Number>("Size", "Size", 125.0D, 50.0D, 500.0D, 5.0D);

   public MiniMap() {
      super("Mini Map", new String[]{"MiniMap"}, ModuleType.c12482, ModuleType.c21190.c94221);
   }

   @EventTarget
   public void c21923(Render2DEventA var1) {
      ScaledResolution var3 = new ScaledResolution(mc);
      int var4 = this.c1696.c53968().intValue();
      float var5 = this.c29785.c53968().floatValue();
      float var6 = this.c25966.c53968().floatValue();
      float var7 = (float) mc.thePlayer.posX;
      float var8 = (float) mc.thePlayer.posZ;
      Value.c27574();
      int var9 = var3.getScaledWidth();
      int var10 = var3.getScaledHeight();
      int var11 = Mouse.getX() * var9 / mc.displayWidth;
      int var12 = var10 - Mouse.getY() * var10 / mc.displayHeight - 1;
      if ((float)var11 >= var5 && (float)var11 <= var5 + (float)var4 && (float)var12 >= var6 - 3.0F && (float)var12 <= var6 + 10.0F && Mouse.getEventButton() == 0) {
         this.c27337 = !this.c27337;
         boolean var13 = this.c27337;
      }

      if (this.c27337 && mc.currentScreen instanceof GuiChat) {
         Object var34 = c80212(Double.toString((double)(var11 - var4 / 2)), Integer.valueOf(5));
         this.c29785.c70375((Double)var34);
         Object var14 = c80212(Double.toString((double)(var12 - 2)), Integer.valueOf(5));
         this.c25966.c70375((Double)var14);
      }

      this.c27337 = false;
      if (this.c57637 > 255.0F) {
         this.c57637 = 0.0F;
      }

      float var35 = this.c57637;
      float var36 = this.c57637 + 85.0F;
      float var15 = this.c57637 + 170.0F;
      if (var35 > 255.0F) {
         var35 = 0.0F;
      }

      if (var36 > 255.0F) {
         var36 -= 255.0F;
      }

      if (var15 > 255.0F) {
         var15 -= 255.0F;
      }

      Color var16 = Color.getHSBColor(var35 / 255.0F, 0.9F, 1.0F);
      Color var17 = Color.getHSBColor(var36 / 255.0F, 0.9F, 1.0F);
      Color var18 = Color.getHSBColor(var15 / 255.0F, 0.9F, 1.0F);
      int var19 = var16.getRGB();
      int var20 = var17.getRGB();
      int var21 = var18.getRGB();
      this.c57637 = (float)((double)this.c57637 + 0.1D);
      if (this.c38307.c1473().booleanValue()) {
         RenderUtilF.c78669((double)var5, (double)var6, (double)(var5 + (float)var4), (double)(var6 + (float)var4), 0.5D, ColorUtil.c41390(90), ColorUtil.c41390(0));
         RenderUtilF.c78669((double)(var5 + 1.0F), (double)(var6 + 1.0F), (double)(var5 + (float)var4 - 1.0F), (double)(var6 + (float)var4 - 1.0F), 1.0D, ColorUtil.c41390(90), ColorUtil.c41390(61));
         RenderUtilF.c78669((double)var5 + 2.5D, (double)var6 + 2.5D, (double)(var5 + (float)var4) - 2.5D, (double)(var6 + (float)var4) - 2.5D, 0.5D, ColorUtil.c41390(61), ColorUtil.c41390(0));
         RenderUtilD.c4482(var5 + 3.0F, var6 + 3.0F, var5 + (float)var4 - 3.0F, var6 + (float)var4 - 3.0F, (new Color(0, 0, 0, 150)).getRGB());
         RenderUtilF.c34359((double)(var5 + 3.0F), (double)(var6 + 3.0F), (double)(var5 + (float)(var4 - 3)), (double)var6 + 3.6D, ColorUtil.c3182(new Color(HUD.c64734.c41161().intValue()), (int)(var5 * 1.0F), 5).getRGB(), ColorUtil.c3182(new Color(HUD.c46242.c41161().intValue()), (int)(var5 * 1.0F), 5).getRGB());
         RenderUtilF.c48010((double)var5 + ((double)(var4 / 2) - 0.5D), (double)var6 + 3.5D, (double)var5 + (double)(var4 / 2) + 0.5D, (double)(var6 + (float)var4) - 3.5D, ColorUtil.c21891(255, 80));
         RenderUtilF.c48010((double)var5 + 3.5D, (double)var6 + ((double)(var4 / 2) - 0.5D), (double)(var5 + (float)var4) - 3.5D, (double)var6 + (double)(var4 / 2) + 0.5D, ColorUtil.c21891(255, 80));
      }

      RenderUtilD.c15402(var5 + 2.0F, var6 + 4.0F, 105.0F, 76.0F, 10, new Color(14, 14, 14, 240));
      RenderUtilD.c31951((double)(var5 + 2.0F), (double)(var6 + 3.0F), (double)(var5 + (float)var4 + 20.0F), (double)(var6 + (float)var4 - 3.0F), 8.0D, (new Color(14, 14, 14, 70)).getRGB());
      RenderUtilF.c48010((double)var5 + (double)(var4 / 2) + 11.5D, (double)var6 + 5.5D, (double)var5 + (double)(var4 / 2) + 12.5D, (double)(var6 + (float)var4) - 4.5D, ColorUtil.c21891(255, 255));
      RenderUtilF.c48010((double)(var5 + 4.0F), (double)var6 + ((double)(var4 / 2) - 0.5D), (double)(var5 + (float)var4 + 18.0F), (double)var6 + (double)(var4 / 2) + 0.5D, ColorUtil.c21891(255, 255));

      for(Object var23 : mc.theWorld.getLoadedEntityList()) {
         EntityPlayer var24;
         if (var23 instanceof EntityPlayer && (var24 = (EntityPlayer)var23).isEntityAlive() && var24 != mc.thePlayer && !var24.isInvisible()) {
            if (var24.isInvisibleToPlayer(mc.thePlayer)) {
               ;
            }

            float var25 = mc.timer.renderPartialTicks;
            float var26 = (float)((var24.posX + (var24.posX - var24.lastTickPosX) * (double)var25 - (double)var7) * this.c31217.c53968().doubleValue());
            float var27 = (float)((var24.posZ + (var24.posZ - var24.lastTickPosZ) * (double)var25 - (double)var8) * this.c31217.c53968().doubleValue());
            String var28 = ((EntityPlayer)var23).getName();
            int var29 = -1;
            if (TargetUtil.c17356(var24)) {
               var29 = Color.CYAN.getRGB();
            }

            if (((EntityPlayer)var23).getDisplayName().getUnformattedText().startsWith("§")) {
               String var30 = ((EntityPlayer)var23).getDisplayName().getUnformattedText();
               if (var30.startsWith("§0")) {
                  var29 = (new Color(0)).getRGB();
               }

               if (var30.startsWith("§1")) {
                  var29 = (new Color(170)).getRGB();
               }

               if (var30.startsWith("§2")) {
                  var29 = (new Color(43520)).getRGB();
               }

               if (var30.startsWith("§3")) {
                  var29 = (new Color(43690)).getRGB();
               }

               if (var30.startsWith("§4")) {
                  var29 = (new Color(11141120)).getRGB();
               }

               if (var30.startsWith("§5")) {
                  var29 = (new Color(11141290)).getRGB();
               }

               if (var30.startsWith("§6")) {
                  var29 = (new Color(16755200)).getRGB();
               }

               if (var30.startsWith("§7")) {
                  var29 = (new Color(11184810)).getRGB();
               }

               if (var30.startsWith("§8")) {
                  var29 = (new Color(5592405)).getRGB();
               }

               if (var30.startsWith("§9")) {
                  var29 = (new Color(5592575)).getRGB();
               }

               if (var30.startsWith("§a")) {
                  var29 = (new Color(5635925)).getRGB();
               }

               if (var30.startsWith("§b")) {
                  var29 = (new Color(5636095)).getRGB();
               }

               if (var30.startsWith("§c")) {
                  var29 = (new Color(16733525)).getRGB();
               }

               if (var30.startsWith("§d")) {
                  var29 = (new Color(16733695)).getRGB();
               }

               if (var30.startsWith("§e")) {
                  var29 = (new Color(16777045)).getRGB();
               }

               if (var30.startsWith("§f")) {
                  var29 = (new Color(16777215)).getRGB();
               }
            }

            float var32;
            float var33;
            label190: {
               float var37 = (float)Math.cos((double) mc.thePlayer.rotationYaw * 0.017453292519943295D);
               float var31 = (float)Math.sin((double) mc.thePlayer.rotationYaw * 0.017453292519943295D);
               var32 = -(var27 * var37 - var26 * var31);
               var33 = -(var26 * var37 + var27 * var31) + (float)(this.c38307.c1473().booleanValue() ? 0 : 13);
               if (this.c38307.c1473().booleanValue()) {
                  if (var32 > (float)(var4 / 2) - 5.0F) {
                     var32 = (float)(var4 / 2) - 5.0F;
                  }

                  if (var32 < (float)(-(var4 / 2)) + 5.0F) {
                     var32 = (float)(-(var4 / 2)) + 5.0F;
                  }

                  if (var33 > (float)(var4 / 2) - 5.0F) {
                     var33 = (float)(var4 / 2 - 5);
                  }

                  if (var33 >= (float)(-(var4 / 2 - 5))) {
                     break label190;
                  }

                  var33 = -((float)(var4 / 2) - 5.0F);
               }

               if (var32 > (float)(var4 / 2) - 5.0F) {
                  var32 = (float)(var4 / 2 - 8);
               }

               if (var32 < (float)(-(var4 / 2)) + 5.0F) {
                  var32 = (float)(-(var4 / 2) + 8);
               }

               if (var33 > (float)(var4 / 2) + 17.0F) {
                  var33 = (float)(var4 / 2 + 17);
               }

               if (var33 < (float)(-(var4 / 2 - 5))) {
                  var33 = -((float)(var4 / 2) - 5.0F);
               }
            }

            if (this.c38307.c1473().booleanValue()) {
               RenderUtilF.c78669((double)(var5 + (float)(var4 / 2) + var33) - 1.5D, (double)(var6 + (float)(var4 / 2) + var32) - 1.5D, (double)(var5 + (float)(var4 / 2) + var33) + 1.5D, (double)(var6 + (float)(var4 / 2) + var32) + 1.5D, 0.5D, var29, ColorUtil.c41390(46));
            }

            RenderUtilD.c31951((double)(var5 + (float)(var4 / 2) + var33) - 1.5D, (double)(var6 + (float)(var4 / 2) + var32) - 1.5D, (double)(var5 + (float)(var4 / 2) + var33) + 1.5D, (double)(var6 + (float)(var4 / 2) + var32) + 1.5D, 3.0D, var29);
            break;
         }
      }

   }

   public static int c32622(Entity var0) {
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

               var2 = Minecraft.getMinecraft().fontRendererObj.getColorCode(var4.charAt(1));
            }
         }
      }

      return var2;
   }

   public void c71897() {
      super.c71897();
   }

   public void c83205() {
      super.c24622();
   }

   public static boolean c4880(String var0) {
      String var10000 = var0;

      try {
         Integer.parseInt(var10000);
         return true;
      } catch (NumberFormatException var2) {
         return false;
      }
   }

   public static Object c80212(String var0, Object var1) {
      Module[] var2 = Value.c27574();
      if (var0.contains(".")) {
         return var0.toLowerCase().contains("f") ? Float.parseFloat(var0) : Double.parseDouble(var0);
      } else {
         return c4880(var0) ? Integer.parseInt(var0) : var0;
      }
   }

   private float c77596(float var1, float var2, float var3, float var4) {
      return (float)(Math.atan2((double)(var4 - var3), (double)(var2 - var1)) * 180.0D / 3.141592653589793D);
   }

   private static NumberFormatException c94496(NumberFormatException var0) {
      return var0;
   }
}
