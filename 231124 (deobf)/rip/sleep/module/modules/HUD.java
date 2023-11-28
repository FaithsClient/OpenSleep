package rip.sleep.module.modules;

import com.mojang.authlib.GameProfile;
import java.awt.Color;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;

import rip.sleep.injection.MixinLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.json.JSONException;
import org.lwjgl.opengl.GL11;
import rip.sleep.Sleep;
import rip.sleep.event.EventTarget;
import rip.sleep.event.events.Render2DEventA;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.struct.DirectionStruct;
import rip.sleep.ui.font.FontManager;
import rip.sleep.ui.font.FontRendererB;
import rip.sleep.util.TimerUtilI;
import rip.sleep.util.*;
import rip.sleep.value.Value;
import rip.sleep.value.values.BooleanValue;
import rip.sleep.value.values.IntValue;
import rip.sleep.value.values.ModeValue;
import rip.sleep.value.values.NumberValue;

public class HUD extends Module {
   public static ModeValue c88810 = new ModeValue("Hud Mode", new String[]{"Astolfo", "Normal"}, "Normal");
   public static BooleanValue c50349 = new BooleanValue("Rect Render", true);
   public static ModeValue c48062 = new ModeValue("Rect Mode", () -> {
      return c50349.c1473();
   }, new String[]{"Astolfo", "Right"}, "Astolfo");
   public static ModeValue c73213 = new ModeValue("Tags Mode", new String[]{"Empty", "None", "Null", "Hyphen", "Box"}, "None");
   public static ModeValue c19923 = new ModeValue("Font Mode", new String[]{"Roboto", "SF", "Tahoma", "TahomaBOLD", "Lato", "Grey", "Edit", "Digi", "Pixel"}, "SF");
   public static ModeValue c49595 = new ModeValue("Color Mode", new String[]{"Rainbow", "Fade", "Color", "Category", "Astolfo"}, "Color");
   public static BooleanValue c72467 = new BooleanValue("Reset XY", false);
   public static BooleanValue c4046 = new BooleanValue("Vape Logo ", true);
   public static BooleanValue c55580 = new BooleanValue("Sleep Logo", true);
   public static BooleanValue c54940 = new BooleanValue("New Rect ", true);
   public static BooleanValue c75103 = new BooleanValue("Module Wav", true);
   public static BooleanValue c23496 = new BooleanValue("Module Sort", true);
   public static BooleanValue c78668 = new BooleanValue("Module Lower", false);
   public static BooleanValue c56724 = new BooleanValue("Module Hide", false);
   public static BooleanValue c27738 = new BooleanValue("Module Player", false);
   public static BooleanValue c43030 = new BooleanValue("Module Health", false);
   public static BooleanValue c16470 = new BooleanValue("Module Shadow", true);
   public static BooleanValue c74288 = new BooleanValue("Module Visuals", false);
   public static BooleanValue c27960 = new BooleanValue("Smooth Font", false);
   public static BooleanValue c38479 = new BooleanValue("Render Name", true);
   public static BooleanValue c76546 = new BooleanValue("Health Render", true);
   public static BooleanValue c7166 = new BooleanValue("Compass Render", true);
   public static BooleanValue c36596 = new BooleanValue("Background Render", true);
   public static NumberValue<Number> c50184 = new NumberValue<Number>("Bgd Alpha", () -> {
      return c36596.c1473();
   }, 100.0D, 0.0D, 255.0D, 5.0D);
   public static BooleanValue c11055 = new BooleanValue("Color Interpolate", () -> {
      return c49595.c54460().equalsIgnoreCase("Rainbow");
   }, false);
   public static BooleanValue c2442 = new BooleanValue("Module Notifications", false);
   public static NumberValue<Number> c78194 = new NumberValue<Number>("Difference", () -> {
      return c49595.c54460().equalsIgnoreCase("Fade");
   }, 10.0D, 1.0D, 20.0D, 1.0D);
   public static NumberValue<Number> c26885 = new NumberValue<Number>("Array Size", () -> {
      return c27960.c1473();
   }, 18.0D, Integer.valueOf(16), 24.0D, 1.0D);
   public static NumberValue<Number> c73918 = new NumberValue<Number>("Font Width", () -> {
      return c27960.c1473();
   }, 8.0D, 8.0D, 9.0D, 0.1D);
   public static NumberValue<Number> c38600 = new NumberValue<Number>("Suffix Tick", 8.0D, 0.0D, 10.0D, 1.0D);
   public static final IntValue c64734 = new IntValue("Color", Color.WHITE.getRGB());
   public static final IntValue c46242 = new IntValue("Color2", Color.PINK.getRGB());
   public static String c28241 = "Sleep";
   public static String c27743 = "";
   private static int c48792 = 0;
   private static int c71793 = 2;
   private final DirectionStruct c81924;
   private float c8258;
   private long c9895;
   double c49125;
   private boolean c19347;
   private long c56040;
   public static FontRendererB c34359;
   public static boolean c72071;
   public static boolean c7096;

   public HUD() {
      super("HUD", new String[]{"gui"}, ModuleType.c12482, ModuleType.c21190.c94221);
      this.c81924 = new DirectionStruct(mc);
      this.c19347 = false;
      this.c23631(true);
      this.c68609(true);
   }

   @EventTarget
   private void c14172(Render2DEventA var1) {
      Value.c27574();
      ScaledResolution var3 = new ScaledResolution(mc);
      if (c7166.c1473().booleanValue()) {
         this.c81924.c4106(var3.getScaledWidth());
      }

      if (c72467.c1473().booleanValue()) {
         c48792 = 2;
         c71793 = 2;
         c72467.c28440(Boolean.valueOf(false));
      }

      label1266: {
         if (c26885.c53968().intValue() == 16) {
            if (Objects.equals(c19923.c54460(), "SF")) {
               c34359 = FontManager.c27296;
            }

            if (Objects.equals(c19923.c54460(), "Lato")) {
               c34359 = FontManager.c94176;
            }

            if (Objects.equals(c19923.c54460(), "Tahoma")) {
               c34359 = FontManager.c14643;
            }

            if (Objects.equals(c19923.c54460(), "TahomaBOLD")) {
               c34359 = FontManager.c26685;
            }

            if (Objects.equals(c19923.c54460(), "Grey")) {
               c34359 = FontManager.c28966;
            }

            if (Objects.equals(c19923.c54460(), "Roboto")) {
               c34359 = FontManager.c30189;
            }

            if (Objects.equals(c19923.c54460(), "Edit")) {
               c34359 = FontManager.c46837;
            }

            if (Objects.equals(c19923.c54460(), "Digi")) {
               c34359 = FontManager.c63562;
            }

            if (!Objects.equals(c19923.c54460(), "Pixel")) {
               break label1266;
            }

            c34359 = FontManager.c44442;
         }

         if (c26885.c53968().intValue() == 17) {
            if (Objects.equals(c19923.c54460(), "SF")) {
               c34359 = FontManager.c55508;
            }

            if (Objects.equals(c19923.c54460(), "Lato")) {
               c34359 = FontManager.c2405;
            }

            if (Objects.equals(c19923.c54460(), "Tahoma")) {
               c34359 = FontManager.c92692;
            }

            if (Objects.equals(c19923.c54460(), "TahomaBOLD")) {
               c34359 = FontManager.c2407;
            }

            if (Objects.equals(c19923.c54460(), "Grey")) {
               c34359 = FontManager.c54334;
            }

            if (Objects.equals(c19923.c54460(), "Roboto")) {
               c34359 = FontManager.c68373;
            }

            if (Objects.equals(c19923.c54460(), "Edit")) {
               c34359 = FontManager.c65763;
            }

            if (Objects.equals(c19923.c54460(), "Digi")) {
               c34359 = FontManager.c73795;
            }

            if (!Objects.equals(c19923.c54460(), "Pixel")) {
               break label1266;
            }

            c34359 = FontManager.c60325;
         }

         if (c26885.c53968().intValue() == 18) {
            if (Objects.equals(c19923.c54460(), "SF")) {
               c34359 = FontManager.c17232;
            }

            if (Objects.equals(c19923.c54460(), "Lato")) {
               c34359 = FontManager.c5274;
            }

            if (Objects.equals(c19923.c54460(), "Tahoma")) {
               c34359 = FontManager.c3535;
            }

            if (Objects.equals(c19923.c54460(), "TahomaBOLD")) {
               c34359 = FontManager.c11121;
            }

            if (Objects.equals(c19923.c54460(), "Grey")) {
               c34359 = FontManager.c2780;
            }

            if (Objects.equals(c19923.c54460(), "Roboto")) {
               c34359 = FontManager.c3113;
            }

            if (Objects.equals(c19923.c54460(), "Edit")) {
               c34359 = FontManager.c28664;
            }

            if (Objects.equals(c19923.c54460(), "Digi")) {
               c34359 = FontManager.c89396;
            }

            if (!Objects.equals(c19923.c54460(), "Pixel")) {
               break label1266;
            }

            c34359 = FontManager.c59902;
         }

         if (c26885.c53968().intValue() == 19) {
            if (Objects.equals(c19923.c54460(), "SF")) {
               c34359 = FontManager.c57450;
            }

            if (Objects.equals(c19923.c54460(), "Lato")) {
               c34359 = FontManager.c46848;
            }

            if (Objects.equals(c19923.c54460(), "Tahoma")) {
               c34359 = FontManager.c57999;
            }

            if (Objects.equals(c19923.c54460(), "TahomaBOLD")) {
               c34359 = FontManager.c23571;
            }

            if (Objects.equals(c19923.c54460(), "Grey")) {
               c34359 = FontManager.c70503;
            }

            if (Objects.equals(c19923.c54460(), "Roboto")) {
               c34359 = FontManager.c95413;
            }

            if (Objects.equals(c19923.c54460(), "Edit")) {
               c34359 = FontManager.c15065;
            }

            if (Objects.equals(c19923.c54460(), "Digi")) {
               c34359 = FontManager.c17724;
            }

            if (!Objects.equals(c19923.c54460(), "Pixel")) {
               break label1266;
            }

            c34359 = FontManager.c73931;
         }

         if (c26885.c53968().intValue() == 20) {
            if (Objects.equals(c19923.c54460(), "SF")) {
               c34359 = FontManager.c95778;
            }

            if (Objects.equals(c19923.c54460(), "Lato")) {
               c34359 = FontManager.c26446;
            }

            if (Objects.equals(c19923.c54460(), "Tahoma")) {
               c34359 = FontManager.c75252;
            }

            if (Objects.equals(c19923.c54460(), "TahomaBOLD")) {
               c34359 = FontManager.c35003;
            }

            if (Objects.equals(c19923.c54460(), "Grey")) {
               c34359 = FontManager.c61869;
            }

            if (Objects.equals(c19923.c54460(), "Roboto")) {
               c34359 = FontManager.c47687;
            }

            if (Objects.equals(c19923.c54460(), "Edit")) {
               c34359 = FontManager.c37948;
            }

            if (Objects.equals(c19923.c54460(), "Digi")) {
               c34359 = FontManager.c93224;
            }

            if (!Objects.equals(c19923.c54460(), "Pixel")) {
               break label1266;
            }

            c34359 = FontManager.c47231;
         }

         if (c26885.c53968().intValue() == 21) {
            if (Objects.equals(c19923.c54460(), "SF")) {
               c34359 = FontManager.c44915;
            }

            if (Objects.equals(c19923.c54460(), "Lato")) {
               c34359 = FontManager.c10904;
            }

            if (Objects.equals(c19923.c54460(), "Tahoma")) {
               c34359 = FontManager.c92118;
            }

            if (Objects.equals(c19923.c54460(), "TahomaBOLD")) {
               c34359 = FontManager.c79020;
            }

            if (Objects.equals(c19923.c54460(), "Grey")) {
               c34359 = FontManager.c40838;
            }

            if (Objects.equals(c19923.c54460(), "Roboto")) {
               c34359 = FontManager.c85360;
            }

            if (Objects.equals(c19923.c54460(), "Edit")) {
               c34359 = FontManager.c317;
            }

            if (Objects.equals(c19923.c54460(), "Digi")) {
               c34359 = FontManager.c9311;
            }

            if (!Objects.equals(c19923.c54460(), "Pixel")) {
               break label1266;
            }

            c34359 = FontManager.c56243;
         }

         if (c26885.c53968().intValue() == 22) {
            if (Objects.equals(c19923.c54460(), "SF")) {
               c34359 = FontManager.c28504;
            }

            if (Objects.equals(c19923.c54460(), "Lato")) {
               c34359 = FontManager.c8623;
            }

            if (Objects.equals(c19923.c54460(), "Tahoma")) {
               c34359 = FontManager.c196;
            }

            if (Objects.equals(c19923.c54460(), "TahomaBOLD")) {
               c34359 = FontManager.c37419;
            }

            if (Objects.equals(c19923.c54460(), "Grey")) {
               c34359 = FontManager.c62616;
            }

            if (Objects.equals(c19923.c54460(), "Roboto")) {
               c34359 = FontManager.c65553;
            }

            if (Objects.equals(c19923.c54460(), "Edit")) {
               c34359 = FontManager.c4911;
            }

            if (Objects.equals(c19923.c54460(), "Digi")) {
               c34359 = FontManager.c21665;
            }

            if (!Objects.equals(c19923.c54460(), "Pixel")) {
               break label1266;
            }

            c34359 = FontManager.c87696;
         }

         if (c26885.c53968().intValue() == 23) {
            if (Objects.equals(c19923.c54460(), "SF")) {
               c34359 = FontManager.c83050;
            }

            if (Objects.equals(c19923.c54460(), "Lato")) {
               c34359 = FontManager.c61479;
            }

            if (Objects.equals(c19923.c54460(), "Tahoma")) {
               c34359 = FontManager.c71933;
            }

            if (Objects.equals(c19923.c54460(), "TahomaBOLD")) {
               c34359 = FontManager.c39433;
            }

            if (Objects.equals(c19923.c54460(), "Grey")) {
               c34359 = FontManager.c28796;
            }

            if (Objects.equals(c19923.c54460(), "Roboto")) {
               c34359 = FontManager.c64753;
            }

            if (Objects.equals(c19923.c54460(), "Edit")) {
               c34359 = FontManager.c67803;
            }

            if (Objects.equals(c19923.c54460(), "Digi")) {
               c34359 = FontManager.c21309;
            }

            if (!Objects.equals(c19923.c54460(), "Pixel")) {
               break label1266;
            }

            c34359 = FontManager.c18779;
         }

         if (Objects.equals(c19923.c54460(), "SF")) {
            c34359 = FontManager.c23063;
         }

         if (Objects.equals(c19923.c54460(), "Lato")) {
            c34359 = FontManager.c50065;
         }

         if (Objects.equals(c19923.c54460(), "Tahoma")) {
            c34359 = FontManager.c88095;
         }

         if (Objects.equals(c19923.c54460(), "TahomaBOLD")) {
            c34359 = FontManager.c13658;
         }

         if (Objects.equals(c19923.c54460(), "Grey")) {
            c34359 = FontManager.c53460;
         }

         if (Objects.equals(c19923.c54460(), "Roboto")) {
            c34359 = FontManager.c9729;
         }

         if (Objects.equals(c19923.c54460(), "Edit")) {
            c34359 = FontManager.c15267;
         }

         if (Objects.equals(c19923.c54460(), "Digi")) {
            c34359 = FontManager.c10012;
         }

         if (Objects.equals(c19923.c54460(), "Pixel")) {
            c34359 = FontManager.c86753;
         }
      }

      ArrayList var4 = new ArrayList();
      int var5 = 0;
      if (Objects.equals(c88810.c54460(), "Astolfo")) {
         Color var7 = new Color(0, 5, 0, c50184.c53968().intValue());
         float var8 = 0.0F;
         double var9 = 0.0D;
         double var11 = 15.5D;
         double var13 = 16.5D;
         double var15 = 15.5D;
         double var17 = 6.0D;
         if (c26885.c53968().intValue() > 21) {
            var15 = 16.0D;
            var11 = 15.5D;
            var13 = 17.0D;
            var17 = 6.0D;
         }

         if (c26885.c53968().intValue() == 21) {
            var17 = 6.0D;
            if (c27960.c1473().booleanValue()) {
               var13 = 16.0D;
            }
         }

         if (c26885.c53968().intValue() == 20) {
            var17 = 6.0D;
         }

         if (c26885.c53968().intValue() < 20) {
            var17 = 7.0D;
         }

         if (c26885.c53968().intValue() == 16) {
            var17 = 7.5D;
         }

         for(Module var20 : ModuleManager.c84590()) {
            if ((var20.c24622() || !var20.c99480() || var20.c41461() != 0.0F) && (c56724.c1473().booleanValue() || !var20.c41971())) {
               if (!c74288.c1473().booleanValue() && var20.c78173() == ModuleType.c12482 && !var20.c63183()) {
                  ;
               }

               var4.add(var20);
               break;
            }
         }

         if (c23496.c1473().booleanValue()) {
            if (c27960.c1473().booleanValue()) {
               var4.sort((var0, var1x) -> {
                  Module[] var2 = Value.c27574();
                  return c34359.c65036(var1x.c80366().isEmpty() ? Sleep.c92237(var1x) : String.format("%s %s", Sleep.c92237(var1x), var1x.c80366())) - c34359.c65036(var0.c80366().isEmpty() ? Sleep.c92237(var0) : String.format("%s %s", Sleep.c92237(var0), var0.c80366()));
               });
            }

            var4.sort((var0, var1x) -> {
               Module[] var2 = Value.c27574();
               return mc.fontRendererObj.getStringWidth(var1x.c80366().isEmpty() ? Sleep.c92237(var1x) : String.format("%s %s", Sleep.c92237(var1x), var1x.c80366())) - mc.fontRendererObj.getStringWidth(var0.c80366().isEmpty() ? Sleep.c92237(var0) : String.format("%s %s", Sleep.c92237(var0), var0.c80366()));
            });
         }

         Iterator var109 = var4.iterator();
         if (var109.hasNext()) {
            Module var112 = (Module)var109.next();
            var112.c78177();
            String var6 = var112.c80366().isEmpty() ? Sleep.c92237(var112) : String.format("%s %s", Sleep.c92237(var112), var112.c80366());
            if (var112.c24622() && var112.c32668 == 0.0F) {
               var112.c32668 = var8;
            }

            if (var112.c24622() && var112.c32668 < var8) {
               var112.c32668 += 0.5F;
            }

            if (var112.c24622() && var112.c32668 > var8) {
               var112.c32668 -= 0.5F;
            }

            if (c27960.c1473().booleanValue()) {
               if (var112.c24622()) {
                  var112.c74296(false);
                  if (mc.thePlayer.ticksExisted >= 30) {
                     var112.c47662(Math.min(var112.c41461() + (float)(c34359.c65036(var6) / 15), (float)c34359.c65036(var6)));
                  }

                  var112.c47662((float)c34359.c65036(var6));
               }

               if (var112.c41461() <= 0.0F) {
                  var112.c74296(true);
               }

               if (mc.thePlayer.ticksExisted >= 30) {
                  var112.c47662(Math.max(var112.c41461() - (float)(c34359.c65036(var6) / 15), 0.0F));
               }

               var112.c47662(0.0F);
            }

            if (var112.c24622()) {
               var112.c74296(false);
               if (mc.thePlayer.ticksExisted >= 30) {
                  var112.c47662(Math.min(var112.c41461() + (float)(mc.fontRendererObj.getStringWidth(var6) / 20), (float) mc.fontRendererObj.getStringWidth(var6)));
               }

               var112.c47662((float) mc.fontRendererObj.getStringWidth(var6));
            }

            if (var112.c41461() <= 0.0F) {
               var112.c74296(true);
            }

            if (mc.thePlayer.ticksExisted >= 30) {
               var112.c47662(Math.max(var112.c41461() - (float)(mc.fontRendererObj.getStringWidth(var6) / 20), 0.0F));
            }

            var112.c47662(0.0F);
            double var21 = (double)((float)(c27960.c1473().booleanValue() ? c34359.c65036(var6) : mc.fontRendererObj.getStringWidth(var6)) * 2.0F);
            double var23 = (double)(var3.getScaledWidth() - (c27960.c1473().booleanValue() ? c34359.c65036(var6) : mc.fontRendererObj.getStringWidth(var6))) - var9 - 4.0D;
            var23 = var23 + TimerUtilI.c31412(100.0D - var112.c43483.c84837(), var21);
            double var25 = c27960.c1473().booleanValue() ? (double)var8 + 4.5D : (double)var8 + 3.5D;
            double var27 = (double)var3.getScaledWidth() - var9;
            var27 = var27 + TimerUtilI.c31412(100.0D - var112.c43483.c84837(), var21);
            double var29 = c27960.c1473().booleanValue() ? (double)var8 + var15 : (double)var8 + 15.5D;
            if (c36596.c1473().booleanValue()) {
               if (Objects.equals(c48062.c54460(), "Right") && c54940.c1473().booleanValue()) {
                  RenderUtilD.c24215(var23 - 7.0D, var25, var27 - 4.0D, var29, var7.getRGB());
               }

               RenderUtilD.c24215(var23 - 5.0D, var25, var27 - 3.0D, var29, var7.getRGB());
            }

            if (Objects.equals(c49595.c54460(), "Rainbow")) {
               RenderUtilG.c61874(9, var5 * 20, Sleep.INSTANCE.c27940(), Sleep.INSTANCE.c19118(), c11055.c1473().booleanValue()).getRGB();
            }

            if (Objects.equals(c49595.c54460(), "Fade")) {
               int var31 = ColorUtil.c3182(new Color(c64734.c41161().intValue()), (int)(var8 / 11.0F), c78194.c53968().intValue()).getRGB();
            }

            if (Objects.equals(c49595.c54460(), "Category")) {
               int var132 = RenderUtilG.c54521(var112.c78173());
            }

            if (Objects.equals(c49595.c54460(), "Astolfo")) {
               int var133 = RenderUtilG.c72816((int)(var8 * 50.0F));
            }

            int var134 = c64734.c41161().intValue();
            double var32 = 6.0D;
            double var34 = 0.0D;
            if (Objects.equals(c19923.c54460(), "Edit")) {
               if (c26885.c53968().intValue() == 20 || c26885.c53968().intValue() <= 18) {
                  var34 = -0.5D;
               }

               if (c26885.c53968().intValue() == 19) {
                  var34 = -1.0D;
               }
            }

            if ((Objects.equals(c19923.c54460(), "Pixel") || Objects.equals(c19923.c54460(), "Grey")) && (c26885.c53968().intValue() == 18 || c26885.c53968().intValue() == 17)) {
               var34 = 1.0D;
            }

            if (c26885.c53968().intValue() <= 18) {
               var32 = 7.5D;
            }

            if (c26885.c53968().intValue() == 19) {
               var32 = 6.5D;
            }

            if (c26885.c53968().intValue() == 20) {
               var32 = 6.5D;
            }

            if (c26885.c53968().intValue() == 21) {
               var32 = 6.5D;
            }

            if (c27960.c1473().booleanValue()) {
               if (c16470.c1473().booleanValue()) {
                  if (Objects.equals(c48062.c54460(), "Right") && c54940.c1473().booleanValue()) {
                     c34359.c17470(var6, (double)((float)var3.getScaledWidth() - var112.c41461()) - var9 - 8.0D + TimerUtilI.c31412(100.0D - var112.c43483.c84837(), var21), (double)var112.c37406() + (Objects.equals(c48062.c54460(), "Astolfo") ? var17 : var32 - var34), var134);
                  }

                  c34359.c17470(var6, (double)((float)var3.getScaledWidth() - var112.c41461()) - var9 - (c50349.c1473().booleanValue() ? 6.5D : 4.0D) + TimerUtilI.c31412(100.0D - var112.c43483.c84837(), var21), (double)var112.c37406() + (Objects.equals(c48062.c54460(), "Astolfo") ? var17 : var32 - var34), var134);
               }

               if (Objects.equals(c48062.c54460(), "Right") && c54940.c1473().booleanValue()) {
                  c34359.c59386(var6, (float)((double)((float)var3.getScaledWidth() - var112.c41461()) - var9 - 8.0D + TimerUtilI.c31412(100.0D - var112.c43483.c84837(), var21)), (float)((double)var112.c37406() + (Objects.equals(c48062.c54460(), "Astolfo") ? var17 : var32)), var134);
               }

               c34359.c59386(var6, (float)((double)((float)var3.getScaledWidth() - var112.c41461()) - var9 - (c50349.c1473().booleanValue() ? 6.5D : 4.0D) + TimerUtilI.c31412(100.0D - var112.c43483.c84837(), var21)), (float)((double)var112.c37406() + (Objects.equals(c48062.c54460(), "Astolfo") ? var17 : var32)), var134);
            }

            if (c16470.c1473().booleanValue()) {
               if (Objects.equals(c48062.c54460(), "Right") && c54940.c1473().booleanValue()) {
                  mc.fontRendererObj.drawStringWithShadow(var6, (float)((double)((float)((double)((float)var3.getScaledWidth() - var112.c41461()) - var9)) - 8.0D + TimerUtilI.c31412(100.0D - var112.c43483.c84837(), var21)), var112.c37406() + 6.0F, var134);
               }

               mc.fontRendererObj.drawStringWithShadow(var6, (float)((double)((float)((double)((float)var3.getScaledWidth() - var112.c41461()) - var9)) - (c50349.c1473().booleanValue() ? 6.0D : 4.5D) + TimerUtilI.c31412(100.0D - var112.c43483.c84837(), var21)), var112.c37406() + 6.0F, var134);
            }

            if (Objects.equals(c48062.c54460(), "Right") && c54940.c1473().booleanValue()) {
               mc.fontRendererObj.drawString(var6, (float)((double)((float)((double)((float)var3.getScaledWidth() - var112.c41461()) - var9) - 8.0F) + TimerUtilI.c31412(100.0D - var112.c43483.c84837(), var21)), var112.c37406() + 6.0F, var134, false);
            }

            label1052: {
               mc.fontRendererObj.drawString(var6, (float)((double)((float)((double)((float)var3.getScaledWidth() - var112.c41461()) - var9)) - (c50349.c1473().booleanValue() ? 6.0D : 4.5D) + TimerUtilI.c31412(100.0D - var112.c43483.c84837(), var21)), var112.c37406() + 6.0F, var134, false);
               if (Objects.equals(c48062.c54460(), "Astolfo")) {
                  if (!c50349.c1473().booleanValue()) {
                     break label1052;
                  }

                  if (var5 == 0) {
                     RenderUtilF.c38259((double)((float)(var3.getScaledWidth() - (c27960.c1473().booleanValue() ? c34359.c65036(var6) : mc.fontRendererObj.getStringWidth(var6))) - 7.5F - 0.0F), (double)(var8 + 3.5F), (double)(var3.getScaledWidth() - (c27960.c1473().booleanValue() ? c34359.c65036(var6) : mc.fontRendererObj.getStringWidth(var6)) - 7 - 2 + (c27960.c1473().booleanValue() ? c34359.c65036(var6) : mc.fontRendererObj.getStringWidth(var6)) + 6), (double)(var8 + 4.0F), var134);
                  }

                  if (var112 == var4.get(var4.size() - 1)) {
                     RenderUtilF.c38259((double)((float)(var3.getScaledWidth() - (c27960.c1473().booleanValue() ? c34359.c65036(var6) : mc.fontRendererObj.getStringWidth(var6))) - 6.5F - 1.0F), (double)var8 + var11, (double)(var3.getScaledWidth() - (c27960.c1473().booleanValue() ? c34359.c65036(var6) : mc.fontRendererObj.getStringWidth(var6)) - 7 - 2 + (c27960.c1473().booleanValue() ? c34359.c65036(var6) : mc.fontRendererObj.getStringWidth(var6)) + 6), (double)var8 + var13, var134);
                  }

                  int var36 = var4.indexOf(var112);
                  int var37 = var36 + 1;
                  int var38 = c27960.c1473().booleanValue() ? c34359.c65036(((Module)var4.get(var36)).c80366().equals("") ? Sleep.c92237((Module)var4.get(var36)) : String.format("%s %s", Sleep.c92237((Module)var4.get(var36)), ((Module)var4.get(var36)).c80366())) : mc.fontRendererObj.getStringWidth(((Module)var4.get(var36)).c80366().equals("") ? Sleep.c92237((Module)var4.get(var36)) : String.format("%s %s", Sleep.c92237((Module)var4.get(var36)), ((Module)var4.get(var36)).c80366()));
                  int var39 = c27960.c1473().booleanValue() ? c34359.c65036(((Module)var4.get(var37)).c80366().equals("") ? Sleep.c92237((Module)var4.get(var37)) : String.format("%s %s", Sleep.c92237((Module)var4.get(var37)), ((Module)var4.get(var37)).c80366())) : mc.fontRendererObj.getStringWidth(((Module)var4.get(var37)).c80366().equals("") ? Sleep.c92237((Module)var4.get(var37)) : String.format("%s %s", Sleep.c92237((Module)var4.get(var37)), ((Module)var4.get(var37)).c80366()));
                  RenderUtilF.c38259((double)((float)var3.getScaledWidth() - (c27960.c1473().booleanValue() ? (float)c34359.c65036(var6) + 8.0F : (float) mc.fontRendererObj.getStringWidth(var6) + 8.0F)), !c23496.c1473().booleanValue() ? (double)(var8 + 16.0F) : (double)(var8 + (float)(c26885.c53968().intValue() > 21 ? 16 : (c27960.c1473().booleanValue() ? 15 : 15))), (double)((float)var3.getScaledWidth() - (c27960.c1473().booleanValue() ? (float)c34359.c65036(var6) + 8.0F : (float) mc.fontRendererObj.getStringWidth(var6) + 8.0F) + (float)(var38 - var39)), !c23496.c1473().booleanValue() ? (double)(var8 + 15.0F) : (double)(var8 + (float)(c26885.c53968().intValue() > 21 ? 15 : (c27960.c1473().booleanValue() ? 16 : 16))), var134);
                  RenderUtilF.c38259((double)(var3.getScaledWidth() - 4), (double)(var8 + (float)(c27960.c1473().booleanValue() ? 4 : 4)), (double)(var3.getScaledWidth() - 3), (double)var8 + var13, var134);
                  RenderUtilF.c38259((double)((float)(var3.getScaledWidth() - (c27960.c1473().booleanValue() ? c34359.c65036(var6) : mc.fontRendererObj.getStringWidth(var6)) - 7) - 1.0F), c23496.c1473().booleanValue() ? (double)(var8 + 4.0F) : (double)(var8 + 3.5F), (double)(var3.getScaledWidth() - (c27960.c1473().booleanValue() ? c34359.c65036(var6) : mc.fontRendererObj.getStringWidth(var6)) - 7), c23496.c1473().booleanValue() ? (double)var8 + var11 : (double)var8 + var11 + 0.5D, var134);
               }

               if (c50349.c1473().booleanValue()) {
                  RenderUtilF.c38259((double)(var3.getScaledWidth() - 4), (double)(var8 + 4.0F), (double)(var3.getScaledWidth() - 3), !c27960.c1473().booleanValue() ? (double)var8 + var13 : (double)var8 + var13 - 0.699999988079071D, var134);
               }
            }

            ++var5;
            var8 = var8 + (c27960.c1473().booleanValue() ? (c26885.c53968().intValue() > 21 ? 11.5F : 11.0F) : 12.0F);
         }
      }

      if (Objects.equals(c88810.c54460(), "Normal") && !mc.gameSettings.showDebugInfo) {
         for(Module var61 : ModuleManager.c84590()) {
            if ((var61.c24622() || !var61.c99480() || var61.c41461() != 0.0F) && (c56724.c1473().booleanValue() || !var61.c41971())) {
               if (!c74288.c1473().booleanValue() && var61.c78173() == ModuleType.c12482 && !var61.c63183()) {
                  ;
               }

               var4.add(var61);
               break;
            }
         }

         if (c23496.c1473().booleanValue()) {
            if (c27960.c1473().booleanValue()) {
               var4.sort((var0, var1x) -> {
                  Module[] var2 = Value.c27574();
                  return c34359.c65036(var1x.c80366().isEmpty() ? Sleep.c92237(var1x) : String.format("%s %s", Sleep.c92237(var1x), var1x.c80366())) - c34359.c65036(var0.c80366().isEmpty() ? Sleep.c92237(var0) : String.format("%s %s", Sleep.c92237(var0), var0.c80366()));
               });
            }

            var4.sort((var0, var1x) -> {
               Module[] var2 = Value.c27574();
               return mc.fontRendererObj.getStringWidth(var1x.c80366().isEmpty() ? Sleep.c92237(var1x) : String.format("%s %s", Sleep.c92237(var1x), var1x.c80366())) - mc.fontRendererObj.getStringWidth(var0.c80366().isEmpty() ? Sleep.c92237(var0) : String.format("%s %s", Sleep.c92237(var0), var0.c80366()));
            });
         }

         int var57 = c48792;
         int var62 = c71793;
         float var65 = c48792 < -300 ? (float)(var57 - 60 + 3 + RenderUtilF.c56546()) : (float)(var57 + var3.getScaledWidth() - 55 - 22);
         float var10 = c48792 < -300 ? (float)(var57 - 60 + RenderUtilF.c56546()) : (float)(var57 + var3.getScaledWidth() - 55);
         if (c55580.c1473().booleanValue()) {
            ResourceLocation var69 = new ResourceLocation("sleep/sleeplogo.png");
            RenderUtilF.c39900(var69, (float)((int)(var65 - 7.0F)), (float)(c71793 - 17), 82.0F, 14.0F);
         }

         if (c4046.c1473().booleanValue()) {
            ResourceLocation var70 = new ResourceLocation("sleep/vapelogo.png");
            RenderUtilF.c39900(var70, (float)((int)(var10 - 7.0F)), (float)(c71793 - 17), 60.0F, 14.0F);
         }

         if (c27960.c1473().booleanValue()) {
            Iterator var71 = var4.iterator();
            if (var71.hasNext()) {
               Module var12 = (Module)var71.next();
               var12.c78177();
               String var52 = var12.c80366().isEmpty() ? Sleep.c92237(var12) : String.format("%s %s", Sleep.c92237(var12), var12.c80366());
               if (c7096) {
                  var12.c32668 = (float)var62;
               }

               if (var12.c24622() && var12.c32668 == 0.0F) {
                  var12.c32668 = (float)var62;
               }

               if (var12.c24622() && var12.c32668 < (float)var62) {
                  var12.c32668 += 0.5F;
               }

               if (var12.c24622() && var12.c32668 > (float)var62) {
                  var12.c32668 -= 0.5F;
               }

               if (var12.c24622()) {
                  var12.c74296(false);
                  if (mc.thePlayer.ticksExisted >= 30) {
                     var12.c47662(Math.min(var12.c41461() + (float)(c34359.c65036(var52) / 15), (float)c34359.c65036(var52)));
                  }

                  var12.c47662((float)c34359.c65036(var52));
               }

               if (var12.c41461() <= 0.0F) {
                  var12.c74296(true);
               }

               if (mc.thePlayer.ticksExisted >= 30) {
                  var12.c47662(Math.max(var12.c41461() - (float)(c34359.c65036(var52) / 15), 0.0F));
               }

               var12.c47662(0.0F);
               float var82 = c48792 < -421 ? (float)(var57 - 60 + RenderUtilF.c56546()) : (float)(var57 + var3.getScaledWidth()) - (c72071 ? 0.0F : var12.c41461());
               if (Objects.equals(c49595.c54460(), "Rainbow")) {
                  RenderUtilG.c61874(5, var5 * 20, Sleep.INSTANCE.c27940(), Sleep.INSTANCE.c19118(), c11055.c1473().booleanValue()).getRGB();
               }

               if (Objects.equals(c49595.c54460(), "Astolfo")) {
                  int var14 = RenderUtilG.c72816(var62 * 50);
               }

               if (Objects.equals(c49595.c54460(), "Fade")) {
                  int var86 = ColorUtil.c3182(new Color(c64734.c41161().intValue()), var62 / 11, c78194.c53968().intValue()).getRGB();
               }

               if (Objects.equals(c49595.c54460(), "Category")) {
                  int var87 = RenderUtilG.c54521(var12.c78173());
               }

               int var88 = c64734.c41161().intValue();
               if (c16470.c1473().booleanValue()) {
                  GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                  GlStateManager.enableAlpha();
                  GlStateManager.alphaFunc(516, 0.0F);
                  GL11.glEnable(3042);
                  GL11.glBlendFunc(770, 771);
                  c34359.c17470(var52, (double)(var82 - 3.0F), (double)((c7096 ? (float)var62 : var12.c37406()) + 3.5F), var88);
                  GL11.glDisable(3089);
               }

               GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
               GlStateManager.enableAlpha();
               GlStateManager.alphaFunc(516, 0.0F);
               GL11.glEnable(3042);
               GL11.glBlendFunc(770, 771);
               c34359.c59386(var52, var82 - 3.0F, (c7096 ? (float)var62 : var12.c37406()) + 3.5F, var88);
               GL11.glDisable(3089);
               ++var5;
               var62 += 12;
            }
         }

         Iterator var72 = var4.iterator();
         if (var72.hasNext()) {
            Module var77 = (Module)var72.next();
            String var53 = var77.c80366().isEmpty() ? Sleep.c92237(var77) : String.format("%s %s", Sleep.c92237(var77), var77.c80366());
            if (c7096) {
               var77.c32668 = (float)var62;
            }

            if (var77.c24622() && var77.c32668 == 0.0F) {
               var77.c32668 = (float)var62;
            }

            if (var77.c24622() && var77.c32668 < (float)var62) {
               var77.c32668 += 0.5F;
            }

            if (var77.c24622() && var77.c32668 > (float)var62) {
               var77.c32668 -= 0.5F;
            }

            if (var77.c24622()) {
               var77.c74296(false);
               if (mc.thePlayer.ticksExisted >= 30) {
                  var77.c47662(Math.min(var77.c41461() + (float)(mc.fontRendererObj.getStringWidth(var53) / 12), (float) mc.fontRendererObj.getStringWidth(var53)));
               }

               var77.c47662((float) mc.fontRendererObj.getStringWidth(var53));
            }

            if (var77.c41461() <= 0.0F) {
               var77.c74296(true);
            }

            if (mc.thePlayer.ticksExisted >= 30) {
               var77.c47662(Math.max(var77.c41461() - (float)(mc.fontRendererObj.getStringWidth(var53) / 12), 0.0F));
            }

            var77.c47662(0.0F);
            float var83 = c48792 < -300 ? (float)(var57 - 60 + RenderUtilF.c56546()) : (float)(var57 + RenderUtilF.c56546()) - var77.c41461();
            if (Objects.equals(c49595.c54460(), "Rainbow")) {
               RenderUtilG.c61874(5, var5 * 20, Sleep.INSTANCE.c27940(), Sleep.INSTANCE.c19118(), c11055.c1473().booleanValue()).getRGB();
            }

            if (Objects.equals(c49595.c54460(), "Fade")) {
               int var89 = ColorUtil.c3182(new Color(c64734.c41161().intValue()), var62 / 11, c78194.c53968().intValue()).getRGB();
            }

            if (Objects.equals(c49595.c54460(), "Category")) {
               int var90 = RenderUtilG.c54521(var77.c78173());
            }

            if (Objects.equals(c49595.c54460(), "Astolfo")) {
               int var91 = RenderUtilG.c72816(var62 * 50);
            }

            int var92 = c64734.c41161().intValue();
            if (c16470.c1473().booleanValue()) {
               GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
               GlStateManager.enableAlpha();
               GlStateManager.alphaFunc(516, 0.0F);
               GL11.glEnable(3042);
               GL11.glBlendFunc(770, 771);
               mc.fontRendererObj.drawStringWithShadow(var53, var83 - 3.5F, (c7096 ? (float)var62 : var77.c37406()) + 2.5F, var92);
               GL11.glDisable(3089);
            }

            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableAlpha();
            GlStateManager.alphaFunc(516, 0.0F);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            mc.fontRendererObj.drawString(var53, var83 - 3.5F, (c7096 ? (float)var62 : var77.c37406()) + 2.5F, var92, false);
            GL11.glDisable(3089);
            ++var5;
            var62 = var62 + 12;
         }
      }

      if (c76546.c1473().booleanValue()) {
         String var54 = String.valueOf(MathUtilB.c98725((double) mc.thePlayer.getHealth(), 1));
         String var58 = String.valueOf(MathUtilB.c98725((double) mc.thePlayer.getAbsorptionAmount(), 1));
         float var64 = 0.0F;
         if (mc.thePlayer.getHealth() < 10.0F) {
            var64 = 4.0F;
         }

         float var66 = 0.0F;
         if (MathUtilB.c98725((double) mc.thePlayer.getAbsorptionAmount(), 1) >= 1.0D && MathUtilB.c98725((double) mc.thePlayer.getAbsorptionAmount(), 1) < 2.0D) {
            var66 = 1.5F;
         }

         float var68 = (float)var3.getScaledWidth() / 2.0F - 24.0F;
         if (mc.thePlayer.getHealth() < 10.0F) {
            var68 = (float)var3.getScaledWidth() / 2.0F - 21.0F;
         }

         float var73 = MathUtilB.c98725((double) mc.thePlayer.getAbsorptionAmount(), 1) > 0.0D ? var68 : (mc.thePlayer.getHealth() < 10.0F ? (float)var3.getScaledWidth() / 2.0F - 11.0F + 2.0F : (float)var3.getScaledWidth() / 2.0F - 11.0F);
         float var78 = (float)var3.getScaledHeight() / 2.0F + 18.0F;
         mc.fontRendererObj.drawStringWithShadow(var54, var73, var78, MathUtilA.c66748(0, 255, 0, 200));
         mc.fontRendererObj.drawStringWithShadow("§7" + EnumChatFormatting.RED + "❤", var73 + (float) mc.fontRendererObj.getStringWidth(var54), var78 - 1.0F, -1);
         if (MathUtilB.c98725((double) mc.thePlayer.getAbsorptionAmount(), 1) > 0.0D) {
            mc.fontRendererObj.drawStringWithShadow("§7" + EnumChatFormatting.GOLD + var58, var73 + 31.0F - var64 + (float) FontManager.c74342.c65036("§7" + EnumChatFormatting.RED + "❤"), var78 - 0.5F, -1);
            mc.fontRendererObj.drawStringWithShadow("§7" + EnumChatFormatting.GOLD + "❤", var73 + 39.0F - var64 + (float) FontManager.c74342.c65036("§7" + EnumChatFormatting.RED + "❤") + (float) FontManager.c74342.c65036("§7" + EnumChatFormatting.GOLD + var58) + var66, var78 - 1.5F, -1);
         }
      }

      EntityPlayerSP var55 = mc.thePlayer;
      double var59 = var55.posX;
      double var67 = var55.posZ;
      if (c27738.c1473().booleanValue()) {
         float var74 = var55.getHealth();
         long var79 = System.currentTimeMillis();
         float var93 = var74 - this.c8258;
         if (var93 >= 2.0F || var93 < -2.0F) {
            this.c49125 = (double)var93;
            this.c19347 = true;
            this.c56040 = System.currentTimeMillis() + 2000L;
         }

         if (this.c19347 && System.currentTimeMillis() < this.c56040) {
            mc.fontRendererObj.drawStringWithShadow((this.c49125 >= 2.0D ? "+" : "") + String.format("%.1f", this.c49125) + EnumChatFormatting.RED + " ❤", (float)var3.getScaledWidth() / 2.0F - 14.0F, (float)var3.getScaledHeight() - ((float)var3.getScaledHeight() / 2.0F + 30.0F) - 13.0F, c64734.c41161().intValue());
         }

         this.c19347 = false;
         this.c8258 = var74;
         if (mc.thePlayer.isPotionActive(Potion.regeneration)) {
            PotionEffect var97 = mc.thePlayer.getActivePotionEffect(Potion.regeneration);
            if (var97 != null && var97.getAmplifier() == 2) {
               float var16 = (float)var97.getDuration() / 20.0F;
               String var106 = String.format("%.1f", var16);
               mc.fontRendererObj.drawStringWithShadow(var106, (float)var3.getScaledWidth() / 2.0F - 9.0F, (float)var3.getScaledHeight() - ((float)var3.getScaledHeight() / 2.0F + 30.0F), c64734.c41161().intValue());
            }
         }

         String[] var98 = new String[]{EnumChatFormatting.RED.toString(), EnumChatFormatting.YELLOW.toString(), EnumChatFormatting.GREEN.toString(), EnumChatFormatting.BLUE.toString()};
         int var102 = (int)((float)var3.getScaledHeight() / 2.0F + 100.0F);
         int var18 = var98.length;
         int var110 = 0;
         if (var110 < var18) {
            String var113 = var98[var110];
            double var115 = Double.MAX_VALUE;
            Object var117 = null;
            EntityPlayer var24 = null;
            Iterator var119 = mc.theWorld.loadedEntityList.iterator();
            if (var119.hasNext()) {
               Entity var26 = (Entity)var119.next();
               if (var26 instanceof EntityPlayer) {
                  EntityPlayer var124 = (EntityPlayer)var26;
                  String var28 = var124.getDisplayName().getFormattedText();
                  if (var28.contains(var113) && var124 != mc.thePlayer) {
                     double var129 = (double)var55.getDistanceToEntity(var124);
                     if (var129 < var115) {
                        var115 = var129;
                        var24 = var124;
                     }
                  }
               }
            }

            byte var120 = 10;
            int var121 = (int)((float)var3.getScaledWidth() / 2.0F - 30.0F + 2.0F);
            int var125 = var121 + var120 + 4;
            EnumChatFormatting var127 = null;
            if (var113.equals(EnumChatFormatting.RED.toString())) {
               var127 = EnumChatFormatting.RED;
            } else if (var113.equals(EnumChatFormatting.YELLOW.toString())) {
               var127 = EnumChatFormatting.YELLOW;
            } else if (var113.equals(EnumChatFormatting.GREEN.toString())) {
               var127 = EnumChatFormatting.GREEN;
            } else if (var113.equals(EnumChatFormatting.BLUE.toString())) {
               var127 = EnumChatFormatting.BLUE;
            }

            String var130 = (var127 != null ? var127 : "") + String.format("%.0f", var115) + EnumChatFormatting.RESET;
            if (c27960.c1473().booleanValue()) {
               c34359.c17470(var130, (double)var125, (double)var102 + 2.5D, -1);
            }

            mc.fontRendererObj.drawStringWithShadow(var130, (float)var125, (float)var102 + 1.5F, -1);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GameProfile var30 = ((EntityPlayer)var24).getGameProfile();
            AbstractClientPlayer var135 = new AbstractClientPlayer(mc.theWorld, var30) {
            };
            ResourceLocation var139 = var135.getLocationSkin();
            mc.getTextureManager().bindTexture(var139);
            Gui.drawScaledCustomSizeModalRect(var121, var102, 8.0F, 8.0F, 8, 8, var120, var120, 64.0F, 64.0F);
            double var33 = var24.posX - var59;
            double var35 = var24.posZ - var67;
            double var144 = Math.atan2(var35, var33);
            double var145 = Math.toDegrees(var144);
            var145 = (var145 + 360.0D) % 360.0D;
            var145 = var145 - (double) mc.thePlayer.rotationYaw;
            if (var145 < 0.0D) {
               var145 += 360.0D;
            }

            byte var41 = 10;
            int var42 = var125 + (c27960.c1473().booleanValue() ? c34359.c65036(var130) + 4 : mc.fontRendererObj.getStringWidth(var130) + 4);
            float var43 = (float)var102 + (c27960.c1473().booleanValue() ? (float)(c34359.c5657() / 2 - var41 / 2) + 2.5F : (float)(mc.fontRendererObj.FONT_HEIGHT / 2 - var41 / 2 + 1));
            GL11.glPushMatrix();
            GL11.glBlendFunc(770, 771);
            if (var113.equals(EnumChatFormatting.RED.toString())) {
               GlStateManager.color(1.0F, 0.0F, 0.0F, 1.0F);
            }

            if (var113.equals(EnumChatFormatting.BLUE.toString())) {
               GlStateManager.color(0.0F, 0.0F, 1.0F, 1.0F);
            }

            if (var113.equals(EnumChatFormatting.YELLOW.toString())) {
               GlStateManager.color(1.0F, 1.0F, 0.0F, 1.0F);
            }

            if (var113.equals(EnumChatFormatting.GREEN.toString())) {
               GlStateManager.color(0.0F, 1.0F, 0.0F, 1.0F);
            }

            GL11.glTranslatef((float)(var42 + var41 / 2), var43 + (float)(var41 / 2), 0.0F);
            GL11.glRotatef((float)var145 - 90.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef((float)(-var41 / 2), (float)(-var41 / 2), 0.0F);
            ResourceLocation var44 = new ResourceLocation("sleep/playerarrow.png");
            Minecraft.getMinecraft().getTextureManager().bindTexture(var44);
            Gui.drawModalRectWithCustomSizedTexture(0, 0, 0.0F, 0.0F, var41, var41, (float)var41, (float)var41);
            GlStateManager.resetColor();
            GL11.glPopMatrix();
            double var45 = mc.thePlayer.posY;
            double var47 = var24.posY;
            int var49 = (int)Math.round(var47 - var45);
            if (var49 > 0) {
               (new StringBuilder()).append("+").append(var49).toString();
            }

            if (var49 < 0) {
               (new StringBuilder()).append("-").append(Math.abs(var49)).toString();
            }

            String var50 = "0";
            if (c27960.c1473().booleanValue()) {
               c34359.c17470(var50, (double)(var42 + 14), (double)var102 + 2.5D, (new Color(180, 180, 180)).getRGB());
            }

            mc.fontRendererObj.drawStringWithShadow(var50, (float)(var42 + 14), (float)var102 + 1.5F, (new Color(180, 180, 180)).getRGB());
            var102 = var102 + 15;
            ++var110;
         }
      }

      if (c43030.c1473().booleanValue()) {
         float var75 = (float)var3.getScaledHeight() - ((float)var3.getScaledHeight() / 2.0F + 190.0F);
         int var80 = c27960.c1473().booleanValue() ? c34359.c5657() + 3 : mc.fontRendererObj.FONT_HEIGHT + 3;
         ArrayList var84 = new ArrayList();
         Iterator var94 = mc.theWorld.loadedEntityList.iterator();
         if (var94.hasNext()) {
            Entity var99 = (Entity)var94.next();
            if (var99 instanceof EntityPlayer && mc.thePlayer.getDistanceToEntity(var99) <= 20.0F && var99 instanceof EntityLivingBase) {
               EntityLivingBase var104 = (EntityLivingBase)var99;
               if (var104 != mc.thePlayer && !var104.isDead && var104.getHealth() <= 10.0F && !Teams.c55703(var104)) {
                  var84.add(var104);
               }
            }
         }

         var84.sort(Comparator.comparingDouble((var1x) -> {
            double var2 = var1x.posX - var55.posX;
            double var4 = var1x.posZ - var55.posZ;
            return var2 * var2 + var4 * var4;
         }));
         var94 = var84.iterator();
         if (var94.hasNext()) {
            EntityLivingBase var100 = (EntityLivingBase)var94.next();
            double var105 = var100.posX;
            double var107 = var100.posZ;
            double var114 = var105 - var59;
            double var22 = var107 - var67;
            double var118 = Math.sqrt(var114 * var114 + var22 * var22);
            String var122 = String.format(" %.1f m", var118);
            String var126 = var100.getDisplayName().getFormattedText();
            String var128 = " " + EnumChatFormatting.RED + MathUtilB.c98725((double)var100.getHealth(), 1) + EnumChatFormatting.LIGHT_PURPLE + var122 + EnumChatFormatting.RESET;
            if (c27960.c1473().booleanValue()) {
               c34359.c17470(var126 + var128, (double)((float)var3.getScaledWidth() / 2.0F - 60.5F), (double)var75, -1);
            }

            mc.fontRendererObj.drawStringWithShadow(var126 + var128, (float)var3.getScaledWidth() / 2.0F - 60.5F, var75, -1);
            double var131 = Math.atan2(var22, var114);
            double var136 = Math.toDegrees(var131);
            var136 = (var136 + 360.0D) % 360.0D;
            var136 = var136 - (double) mc.thePlayer.rotationYaw;
            if (var136 < 0.0D) {
               var136 += 360.0D;
            }

            byte var140 = 10;
            int var141 = (int)((float)var3.getScaledWidth() / 2.0F - 60.5F + (float)(c27960.c1473().booleanValue() ? c34359.c65036(var126 + var128) + 4 : mc.fontRendererObj.getStringWidth(var126 + var128) + 4));
            float var142 = var75 + (float)(c27960.c1473().booleanValue() ? c34359.c5657() / 2 - var140 / 2 : mc.fontRendererObj.FONT_HEIGHT / 2 - var140 / 2);
            GL11.glPushMatrix();
            GL11.glBlendFunc(770, 771);
            GL11.glTranslatef((float)(var141 + var140 / 2), var142 + (float)(var140 / 2), 0.0F);
            GL11.glRotatef((float)var136 - 90.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef((float)(-var140 / 2), (float)(-var140 / 2), 0.0F);
            ResourceLocation var143 = new ResourceLocation("sleep/arroww.png");
            Minecraft.getMinecraft().getTextureManager().bindTexture(var143);
            Gui.drawModalRectWithCustomSizedTexture(0, 0, 0.0F, 0.0F, var140, var140, (float)var140, (float)var140);
            GL11.glPopMatrix();
            float var10000 = var75 + (float)var80;
         }
      }

      String var76 = "Sleep".equals("") ? c28241.charAt(0) + "§7" + EnumChatFormatting.WHITE + c28241.substring(1) : "Sleep".charAt(0) + "§7" + EnumChatFormatting.WHITE + "Sleep".substring(1);
      SimpleDateFormat var81 = new SimpleDateFormat("HH:mm");
      String var85 = "Sleep".charAt(0) + "§7" + EnumChatFormatting.WHITE + c28241.substring(1) + EnumChatFormatting.WHITE + " | " + var81.format(new Date()) + " | " + MixinLoader.Client_User + " | " + (mc.isSingleplayer() ? "SinglePlayer" : mc.getCurrentServerData().serverIP);
      if (c38479.c1473().booleanValue()) {
         if (c27960.c1473().booleanValue()) {
            RenderUtilD.c15402(3.5F, 4.5F, 3.5F + (float)c34359.c65036(var85) + 2.0F, (float)(5 + c34359.c5657()), 10, new Color(14, 14, 14, 180));
            RenderUtilD.c24215(3.5D, 4.5D, (double)(3.5F + (float)c34359.c65036(var85) + 4.0F), 9.5D + (double)c34359.c5657(), (new Color(14, 14, 14, 70)).getRGB());
            c34359.c17470(var85, 5.5D, 7.5D, c64734.c41161().intValue());
         }

         mc.fontRendererObj.drawStringWithShadow(var76 + EnumChatFormatting.GRAY + " [" + EnumChatFormatting.WHITE + var81.format(new Date()) + EnumChatFormatting.GRAY + "]", 3.5F, 5.5F, c64734.c41161().intValue());
      }

      BigDecimal var96 = new BigDecimal(this.c19151() * 10.0D);
      double var101 = var96.setScale(2, 4).doubleValue();
      int var108 = mc.ingameGUI.getChatGUI().getChatOpen() ? 24 : 10;
      if (c27960.c1473().booleanValue()) {
         c34359.c17470(EnumChatFormatting.WHITE + "Release" + EnumChatFormatting.GRAY + " - " + EnumChatFormatting.WHITE + "112323" + EnumChatFormatting.GRAY + " - " + EnumChatFormatting.GREEN + MixinLoader.Client_User, (double)(var3.getScaledWidth() - c34359.c65036(EnumChatFormatting.WHITE + "Release" + EnumChatFormatting.GRAY + " - " + EnumChatFormatting.WHITE + "112323" + EnumChatFormatting.GRAY + " - " + EnumChatFormatting.GREEN + MixinLoader.Client_User) - 2), (double)(var3.getScaledHeight() - var108), c64734.c41161().intValue());
      }

      mc.fontRendererObj.drawStringWithShadow(EnumChatFormatting.WHITE + "Release" + EnumChatFormatting.GRAY + " - " + EnumChatFormatting.WHITE + "112323" + EnumChatFormatting.GRAY + " - " + EnumChatFormatting.GREEN + MixinLoader.Client_User, (float)(var3.getScaledWidth() - mc.fontRendererObj.getStringWidth(EnumChatFormatting.WHITE + "Release" + EnumChatFormatting.GRAY + " - " + EnumChatFormatting.WHITE + "112323" + EnumChatFormatting.GRAY + " - " + EnumChatFormatting.GREEN + MixinLoader.Client_User) - 2), (float)(var3.getScaledHeight() - var108), c64734.c41161().intValue());
   }

   private EnumChatFormatting c35910(String var1) {
      EnumChatFormatting[] var3 = EnumChatFormatting.values();
      int var4 = var3.length;
      Value.c27574();
      int var5 = 0;
      if (var5 < var4) {
         EnumChatFormatting var6 = var3[var5];
         if (var1.startsWith(var6.toString())) {
            return var6;
         }

         ++var5;
      }

      return null;
   }

   private static float c31791() {
      return (float)(System.currentTimeMillis() % 2000L) / 1000.0F;
   }

   public static Color c74344(int var0, float var1) {
      float var3 = 4000.0F;
      Value.c27574();
      float var4 = (float)(System.currentTimeMillis() % (long)var0) + var1;
      if (var4 > var3) {
         var4 -= var3;
      }

      var4 = var4 / var3;
      if ((double)var4 > 0.5D) {
         var4 = 0.5F - (var4 - 0.5F);
      }

      var4 = var4 + 0.5F;
      return Color.getHSBColor(var4, 0.75F, 1.0F);
   }

   public static int c46389() {
      return c48792;
   }

   public static void c95424(int var0) {
      c48792 = var0;
   }

   public static int c28175() {
      return c71793;
   }

   public static void c88120(int var0) {
      c71793 = var0;
      c7096 = true;
   }

   public static boolean c91289(int var0, int var1) {
      c7096 = false;
      Value.c27574();
      ScaledResolution var3 = new ScaledResolution(ChatUtilA.mc);
      return MathUtilB.c23165((double)var0, (double)var1, (double)(c46389() + var3.getScaledWidth() + 3), (double)(c28175() + var3.getScaledHeight() - 238), (double)(c46389() + var3.getScaledWidth() - 70), (double)(c28175() - 15)) && ModuleManager.c25475(HUD.class).c24622();
   }

   public static Color c24332() {
      return new Color(c64734.c41161().intValue());
   }

   public double c19151() {
      double var1 = (mc.thePlayer.posX - mc.thePlayer.lastTickPosX) * 2.0D;
      double var3 = (mc.thePlayer.posZ - mc.thePlayer.lastTickPosZ) * 2.0D;
      return (double)MathHelper.sqrt_double(var1 * var1 + var3 * var3);
   }

   public static void c95730(String var0) {
      c27743 = var0;
   }

   public static int c79151(int var0) {
      Module[] var1 = Value.c27574();
      if (Objects.equals(c49595.c54460(), "Rainbow")) {
         RenderUtilG.c61874(5, var0 * 20, Sleep.INSTANCE.c27940(), Sleep.INSTANCE.c19118(), c11055.c1473().booleanValue()).getRGB();
      }

      if (Objects.equals(c49595.c54460(), "Category")) {
         boolean var2 = true;
      }

      if (Objects.equals(c49595.c54460(), "Astolfo")) {
         int var3 = RenderUtilG.c72816(var0 * 50);
      }

      if (Objects.equals(c49595.c54460(), "Fade")) {
         int var4 = ColorUtil.c3182(new Color(c64734.c41161().intValue()), var0 / 11, c78194.c53968().intValue()).getRGB();
      }

      int var5 = c64734.c41161().intValue();
      return var5;
   }

   private static JSONException c25321(JSONException var0) {
      return var0;
   }

   class c6540 {
      float c46752;
      long c41185;

      c6540(float var2, long var3) {
         this.c46752 = var2;
         this.c41185 = var3;
      }
   }
}
