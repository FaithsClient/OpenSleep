//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.module.modules;

import ft.sleep.Client;
import ft.sleep.api.EventHandler;
import ft.sleep.api.events.rendering.EventRender2D;
import ft.sleep.api.value.ColorValue;
import ft.sleep.api.value.Mode;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Option;
import ft.sleep.api.value.TextValue;
import ft.sleep.module.Module;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.ModuleType;
import ft.sleep.ui.font.CFontRenderer;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

import ft.sleep.util.animation.Animation2;
import ft.sleep.util.color.ColorUtil;
import ft.sleep.util.color.ColorUtils2;
import ft.sleep.util.render.RenderUtil5;
import ft.sleep.util.render.RenderUtils;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class HUD extends Module {
   public static Mode lovely$ = new Mode("Hud Mode", new String[]{"Astolfo", "Normal"}, "Normal");
   public static Mode chief$ = new Mode("Rect Mode", new String[]{"Astolfo", "Right"}, "Astolfo");
   public static Mode grams$ = new Mode("ft.sleep.module.modules.Tags Mode", new String[]{"Empty", "None", "Null", "Hyphen", "Box"}, "None");
   public static Mode everyone$ = new Mode("Font Mode", new String[]{"Roboto", "SF", "Tahoma", "TahomaBOLD", "Lato", "Grey", "Edit", "Digi", "Pixel"}, "SF");
   public static Mode hotmail$ = new Mode("Color Mode", new String[]{"Rainbow", "Fade", "Color"}, "Color");
   public TextValue fifth$ = new TextValue("ft.sleep.command.commands.ClientName", "SleepClient");
   public static Option memory$ = new Option("ft.sleep.command.commands.Module Wav", true);
   public static Option ronald$ = new Option("ft.sleep.command.commands.Module Sort", true);
   public static Option bronze$ = new Option("ft.sleep.command.commands.Module Lower", false);
   public static Option pairs$ = new Option("ft.sleep.command.commands.Module Hide", false);
   public static Option aware$ = new Option("ft.sleep.command.commands.Module Shadow", true);
   public static Option cheapest$ = new Option("ft.sleep.command.commands.Module Visuals", false);
   public static Option weekends$ = new Option("Smooth Font", false);
   public static Option drawings$ = new Option("Render Name", true);
   public static Option shares$ = new Option("ft.sleep.util.other.Client Icon", true);
   public static Option symphony$ = new Option("Rect Render", true);
   public static Option insert$ = new Option("Health Render", true);
   public static Option seems$ = new Option("Compass Render", true);
   public static Option maintain$ = new Option("Background Render", true);
   public static Option surfing$ = new Option("Color Interpolate", false);
   public static Option cakes$ = new Option("ft.sleep.command.commands.Module Notifications", false);
   public static Numbers stores$ = new Numbers("Difference", 10.0D, 1.0D, 20.0D, 1.0D);
   public static Numbers straight$ = new Numbers("Array Size", 18.0D, Integer.valueOf(16), 24.0D, 1.0D);
   public static Numbers select$ = new Numbers("Suffix Tick", 8.0D, Double.longBitsToDouble(0L), 10.0D, 1.0D);
   public static Numbers ventures$ = new Numbers("Bgd Alpha", 100.0D, Double.longBitsToDouble(0L), 255.0D, 5.0D);
   public static ColorValue during$ = new ColorValue("Color", Color.WHITE.getRGB());
   public static ColorValue cosmetic$ = new ColorValue("Color2", Color.PINK.getRGB());
   public static String draft$ = "Sleep";
   public static String columns$ = Client.jelsoft$;
   public static int muscle$ = 0;
   public static int creek$ = 2;
   public CompassUtils baskets$;
   public static CFontRenderer email$;

   public HUD() {
      super("ft.sleep.module.modules.HUD", new String[]{"gui"}, ModuleType.ignored$);
      workflow.baskets$ = new CompassUtils(workflow.mc);
      workflow._piece((new Color(î ?.nextInt(255), î ?.nextInt(255), î ?.nextInt(255))).getRGB());
      workflow._serial(true);
      workflow._bosnia(true);
   }

   @EventHandler
   public void _metals(EventRender2D osodayat) {
      Object ofunopuy = new ScaledResolution(dugabopu.mc);
      if (seems$.getValue().booleanValue()) {
         dugabopu.baskets$._beaches(ofunopuy.getScaledWidth());
      }

      if (straight$.getValue().intValue() == 16) {
         if (Objects.equals(everyone$.getValue(), "SF")) {
            email$ = FontLoaders.SF16;
         } else if (Objects.equals(everyone$.getValue(), "Lato")) {
            email$ = FontLoaders.clickgui16;
         } else if (Objects.equals(everyone$.getValue(), "Tahoma")) {
            email$ = FontLoaders.Tahoma16;
         } else if (Objects.equals(everyone$.getValue(), "TahomaBOLD")) {
            email$ = FontLoaders.TahomaBold16;
         } else if (Objects.equals(everyone$.getValue(), "Grey")) {
            email$ = FontLoaders.kiona16;
         } else if (Objects.equals(everyone$.getValue(), "Roboto")) {
            email$ = FontLoaders.Roboto16;
         } else if (Objects.equals(everyone$.getValue(), "Edit")) {
            email$ = FontLoaders.edit16;
         } else if (Objects.equals(everyone$.getValue(), "Digi")) {
            email$ = FontLoaders.digi16;
         } else if (Objects.equals(everyone$.getValue(), "Pixel")) {
            email$ = FontLoaders.pixel16;
         }
      } else if (straight$.getValue().intValue() == 17) {
         if (Objects.equals(everyone$.getValue(), "SF")) {
            email$ = FontLoaders.SF17;
         } else if (Objects.equals(everyone$.getValue(), "Lato")) {
            email$ = FontLoaders.clickgui17;
         } else if (Objects.equals(everyone$.getValue(), "Tahoma")) {
            email$ = FontLoaders.Tahoma17;
         } else if (Objects.equals(everyone$.getValue(), "TahomaBOLD")) {
            email$ = FontLoaders.TahomaBold17;
         } else if (Objects.equals(everyone$.getValue(), "Grey")) {
            email$ = FontLoaders.kiona17;
         } else if (Objects.equals(everyone$.getValue(), "Roboto")) {
            email$ = FontLoaders.Roboto17;
         } else if (Objects.equals(everyone$.getValue(), "Edit")) {
            email$ = FontLoaders.edit17;
         } else if (Objects.equals(everyone$.getValue(), "Digi")) {
            email$ = FontLoaders.digi17;
         } else if (Objects.equals(everyone$.getValue(), "Pixel")) {
            email$ = FontLoaders.pixel17;
         }
      } else if (straight$.getValue().intValue() == 18) {
         if (Objects.equals(everyone$.getValue(), "SF")) {
            email$ = FontLoaders.SF18;
         } else if (Objects.equals(everyone$.getValue(), "Lato")) {
            email$ = FontLoaders.clickgui18;
         } else if (Objects.equals(everyone$.getValue(), "Tahoma")) {
            email$ = FontLoaders.Tahoma18;
         } else if (Objects.equals(everyone$.getValue(), "TahomaBOLD")) {
            email$ = FontLoaders.TahomaBold18;
         } else if (Objects.equals(everyone$.getValue(), "Grey")) {
            email$ = FontLoaders.kiona18;
         } else if (Objects.equals(everyone$.getValue(), "Roboto")) {
            email$ = FontLoaders.Roboto18;
         } else if (Objects.equals(everyone$.getValue(), "Edit")) {
            email$ = FontLoaders.edit18;
         } else if (Objects.equals(everyone$.getValue(), "Digi")) {
            email$ = FontLoaders.digi18;
         } else if (Objects.equals(everyone$.getValue(), "Pixel")) {
            email$ = FontLoaders.pixel18;
         }
      } else if (straight$.getValue().intValue() == 19) {
         if (Objects.equals(everyone$.getValue(), "SF")) {
            email$ = FontLoaders.SF19;
         } else if (Objects.equals(everyone$.getValue(), "Lato")) {
            email$ = FontLoaders.clickgui19;
         } else if (Objects.equals(everyone$.getValue(), "Tahoma")) {
            email$ = FontLoaders.Tahoma19;
         } else if (Objects.equals(everyone$.getValue(), "TahomaBOLD")) {
            email$ = FontLoaders.TahomaBold19;
         } else if (Objects.equals(everyone$.getValue(), "Grey")) {
            email$ = FontLoaders.kiona19;
         } else if (Objects.equals(everyone$.getValue(), "Roboto")) {
            email$ = FontLoaders.Roboto19;
         } else if (Objects.equals(everyone$.getValue(), "Edit")) {
            email$ = FontLoaders.edit19;
         } else if (Objects.equals(everyone$.getValue(), "Digi")) {
            email$ = FontLoaders.digi19;
         } else if (Objects.equals(everyone$.getValue(), "Pixel")) {
            email$ = FontLoaders.pixel19;
         }
      } else if (straight$.getValue().intValue() == 20) {
         if (Objects.equals(everyone$.getValue(), "SF")) {
            email$ = FontLoaders.SF20;
         } else if (Objects.equals(everyone$.getValue(), "Lato")) {
            email$ = FontLoaders.clickgui20;
         } else if (Objects.equals(everyone$.getValue(), "Tahoma")) {
            email$ = FontLoaders.Tahoma20;
         } else if (Objects.equals(everyone$.getValue(), "TahomaBOLD")) {
            email$ = FontLoaders.TahomaBold20;
         } else if (Objects.equals(everyone$.getValue(), "Grey")) {
            email$ = FontLoaders.kiona20;
         } else if (Objects.equals(everyone$.getValue(), "Roboto")) {
            email$ = FontLoaders.Roboto20;
         } else if (Objects.equals(everyone$.getValue(), "Edit")) {
            email$ = FontLoaders.edit20;
         } else if (Objects.equals(everyone$.getValue(), "Digi")) {
            email$ = FontLoaders.digi20;
         } else if (Objects.equals(everyone$.getValue(), "Pixel")) {
            email$ = FontLoaders.pixel20;
         }
      } else if (straight$.getValue().intValue() == 21) {
         if (Objects.equals(everyone$.getValue(), "SF")) {
            email$ = FontLoaders.SF21;
         } else if (Objects.equals(everyone$.getValue(), "Lato")) {
            email$ = FontLoaders.clickgui21;
         } else if (Objects.equals(everyone$.getValue(), "Tahoma")) {
            email$ = FontLoaders.Tahoma21;
         } else if (Objects.equals(everyone$.getValue(), "TahomaBOLD")) {
            email$ = FontLoaders.TahomaBold21;
         } else if (Objects.equals(everyone$.getValue(), "Grey")) {
            email$ = FontLoaders.kiona21;
         } else if (Objects.equals(everyone$.getValue(), "Roboto")) {
            email$ = FontLoaders.Roboto21;
         } else if (Objects.equals(everyone$.getValue(), "Edit")) {
            email$ = FontLoaders.edit21;
         } else if (Objects.equals(everyone$.getValue(), "Digi")) {
            email$ = FontLoaders.digi21;
         } else if (Objects.equals(everyone$.getValue(), "Pixel")) {
            email$ = FontLoaders.pixel21;
         }
      } else if (straight$.getValue().intValue() == 22) {
         if (Objects.equals(everyone$.getValue(), "SF")) {
            email$ = FontLoaders.SF22;
         } else if (Objects.equals(everyone$.getValue(), "Lato")) {
            email$ = FontLoaders.clickgui22;
         } else if (Objects.equals(everyone$.getValue(), "Tahoma")) {
            email$ = FontLoaders.Tahoma22;
         } else if (Objects.equals(everyone$.getValue(), "TahomaBOLD")) {
            email$ = FontLoaders.TahomaBold22;
         } else if (Objects.equals(everyone$.getValue(), "Grey")) {
            email$ = FontLoaders.kiona22;
         } else if (Objects.equals(everyone$.getValue(), "Roboto")) {
            email$ = FontLoaders.Roboto22;
         } else if (Objects.equals(everyone$.getValue(), "Edit")) {
            email$ = FontLoaders.edit22;
         } else if (Objects.equals(everyone$.getValue(), "Digi")) {
            email$ = FontLoaders.digi22;
         } else if (Objects.equals(everyone$.getValue(), "Pixel")) {
            email$ = FontLoaders.pixel22;
         }
      } else if (straight$.getValue().intValue() == 23) {
         if (Objects.equals(everyone$.getValue(), "SF")) {
            email$ = FontLoaders.SF23;
         } else if (Objects.equals(everyone$.getValue(), "Lato")) {
            email$ = FontLoaders.clickgui23;
         } else if (Objects.equals(everyone$.getValue(), "Tahoma")) {
            email$ = FontLoaders.Tahoma23;
         } else if (Objects.equals(everyone$.getValue(), "TahomaBOLD")) {
            email$ = FontLoaders.TahomaBold23;
         } else if (Objects.equals(everyone$.getValue(), "Grey")) {
            email$ = FontLoaders.kiona23;
         } else if (Objects.equals(everyone$.getValue(), "Roboto")) {
            email$ = FontLoaders.Roboto23;
         } else if (Objects.equals(everyone$.getValue(), "Edit")) {
            email$ = FontLoaders.edit23;
         } else if (Objects.equals(everyone$.getValue(), "Digi")) {
            email$ = FontLoaders.digi23;
         } else if (Objects.equals(everyone$.getValue(), "Pixel")) {
            email$ = FontLoaders.pixel23;
         }
      } else if (Objects.equals(everyone$.getValue(), "SF")) {
         email$ = FontLoaders.SF24;
      } else if (Objects.equals(everyone$.getValue(), "Lato")) {
         email$ = FontLoaders.clickgui24;
      } else if (Objects.equals(everyone$.getValue(), "Tahoma")) {
         email$ = FontLoaders.Tahoma24;
      } else if (Objects.equals(everyone$.getValue(), "TahomaBOLD")) {
         email$ = FontLoaders.TahomaBold24;
      } else if (Objects.equals(everyone$.getValue(), "Grey")) {
         email$ = FontLoaders.kiona24;
      } else if (Objects.equals(everyone$.getValue(), "Roboto")) {
         email$ = FontLoaders.Roboto24;
      } else if (Objects.equals(everyone$.getValue(), "Edit")) {
         email$ = FontLoaders.edit24;
      } else if (Objects.equals(everyone$.getValue(), "Digi")) {
         email$ = FontLoaders.digi24;
      } else if (Objects.equals(everyone$.getValue(), "Pixel")) {
         email$ = FontLoaders.pixel24;
      }

      Object otacanon = new ArrayList();
      Object zapogugo = 0;
      if (Objects.equals(lovely$.getValue(), "Astolfo")) {
         Object atuyalac = new Color(0, 5, 0, ventures$.getValue().intValue());
         Object galucoca = Float.intBitsToFloat(0);
         Object daganevi = Double.longBitsToDouble(0L);
         Object novezoge = 10.0D;
         Object osebebat = 11.0D;
         Object bacesase = 10.7D;
         Object idigibit = 1.5D;
         if (straight$.getValue().intValue() > 21) {
            bacesase = 11.5D;
            novezoge = 11.5D;
            osebebat = 12.5D;
            idigibit = 0.5D;
         }

         if (straight$.getValue().intValue() == 21) {
            idigibit = 1.0D;
         }

         if (straight$.getValue().intValue() == 20) {
            idigibit = 1.0D;
         }

         if (straight$.getValue().intValue() <= 17) {
            idigibit = 2.5D;
         }

         for(Object abubonan : ModuleManager._trick()) {
            if ((abubonan._central() || !abubonan._discover() || abubonan._early() != Float.intBitsToFloat(0)) && (pairs$.getValue().booleanValue() || !abubonan._wishlist()) && (cheapest$.getValue().booleanValue() || abubonan._bennett() != ModuleType.ignored$ || abubonan._keeps())) {
               otacanon.add(abubonan);
            }
         }

         if (ronald$.getValue().booleanValue()) {
            if (weekends$.getValue().booleanValue()) {
               otacanon.sort(HUD::_brick);
            } else {
               otacanon.sort(dugabopu::_dollar);
            }
         }

         for(Object var61 : otacanon) {
            var61._britain();
            Object modocoyu = var61._lesbian().isEmpty() ? Client.î ?(var61) : String.format("%s %s", Client.î ?(var61), var61._lesbian());
            if (var61._central() && var61.python$ == Float.intBitsToFloat(0)) {
               var61.python$ = galucoca;
            } else if (var61._central() && var61.python$ < galucoca) {
               var61.python$ += 0.5F;
            } else if (var61._central() && var61.python$ > galucoca) {
               var61.python$ -= 0.5F;
            }

            if (weekends$.getValue().booleanValue()) {
               if (var61._central()) {
                  var61._algeria(false);
                  if (dugabopu.mc.thePlayer.ticksExisted >= 30) {
                     var61._disputes(Math.min(var61._early() + (float)(email$.getStringWidth(modocoyu) / 15), (float)email$.getStringWidth(modocoyu)));
                  } else {
                     var61._disputes((float)email$.getStringWidth(modocoyu));
                  }
               } else if (var61._early() <= Float.intBitsToFloat(0)) {
                  var61._algeria(true);
               } else if (dugabopu.mc.thePlayer.ticksExisted >= 30) {
                  var61._disputes(Math.max(var61._early() - (float)(email$.getStringWidth(modocoyu) / 15), Float.intBitsToFloat(0)));
               } else {
                  var61._disputes(Float.intBitsToFloat(0));
               }
            } else if (var61._central()) {
               var61._algeria(false);
               if (dugabopu.mc.thePlayer.ticksExisted >= 30) {
                  var61._disputes(Math.min(var61._early() + (float)(dugabopu.mc.fontRendererObj.getStringWidth(modocoyu) / 20), (float)dugabopu.mc.fontRendererObj.getStringWidth(modocoyu)));
               } else {
                  var61._disputes((float)dugabopu.mc.fontRendererObj.getStringWidth(modocoyu));
               }
            } else if (var61._early() <= Float.intBitsToFloat(0)) {
               var61._algeria(true);
            } else if (dugabopu.mc.thePlayer.ticksExisted >= 30) {
               var61._disputes(Math.max(var61._early() - (float)(dugabopu.mc.fontRendererObj.getStringWidth(modocoyu) / 20), Float.intBitsToFloat(0)));
            } else {
               var61._disputes(Float.intBitsToFloat(0));
            }

            Object vizitami = (double)((float)(weekends$.getValue().booleanValue() ? email$.getStringWidth(modocoyu) : dugabopu.mc.fontRendererObj.getStringWidth(modocoyu)) * 2.0F);
            Object picobeyi = (double)(ofunopuy.getScaledWidth() - (weekends$.getValue().booleanValue() ? email$.getStringWidth(modocoyu) : dugabopu.mc.fontRendererObj.getStringWidth(modocoyu))) - daganevi - 4.0D;
            picobeyi = picobeyi + Animation2._harper(100.0D - var61.schools$._hungry(), vizitami);
            Object fayegefa = weekends$.getValue().booleanValue() ? (double)galucoca : (double)galucoca;
            Object osasiyec = (double)ofunopuy.getScaledWidth() - daganevi;
            osasiyec = osasiyec + Animation2._harper(100.0D - var61.schools$._hungry(), vizitami);
            double var28 = weekends$.getValue().booleanValue() ? (double)galucoca + bacesase : (straight$.getValue().intValue() > 21 ? (double)galucoca + 11.5D : (double)galucoca + 10.5D);
            if (maintain$.getValue().booleanValue()) {
               RenderUtils._illness(picobeyi, fayegefa, osasiyec, var28, atuyalac.getRGB());
            }

            int var30;
            if (Objects.equals(hotmail$.getValue(), "Rainbow")) {
               var30 = ColorUtil._islamic(5, zapogugo * 20, Client.surround$.î ?(), Client.surround$.î ?(), surfing$.getValue().booleanValue()).getRGB();
            } else if (Objects.equals(hotmail$.getValue(), "Fade")) {
               var30 = ColorUtils2._reward(new Color(during$.getValue().intValue()), (int)(galucoca / 11.0F), stores$.getValue().intValue()).getRGB();
            } else {
               var30 = during$.getValue().intValue();
            }

            double var31 = 2.0D;
            if (straight$.getValue().intValue() < 17) {
               var31 = 3.5D;
            }

            if (straight$.getValue().intValue() == 17) {
               var31 = 2.5D;
            }

            if (weekends$.getValue().booleanValue()) {
               if (aware$.getValue().booleanValue()) {
                  email$.drawStringWithShadow(modocoyu, (double)((float)ofunopuy.getScaledWidth() - var61._early()) - daganevi - (symphony$.getValue().booleanValue() ? 2.5D : 1.5D) + Animation2._harper(100.0D - var61.schools$._hungry(), vizitami), (double)var61._section() + (Objects.equals(chief$.getValue(), "Astolfo") ? idigibit : var31), var30);
               } else {
                  email$.drawString(modocoyu, (float)((double)((float)ofunopuy.getScaledWidth() - var61._early()) - daganevi - (symphony$.getValue().booleanValue() ? 2.5D : 1.5D) + Animation2._harper(100.0D - var61.schools$._hungry(), vizitami)), (float)((double)var61._section() + (Objects.equals(chief$.getValue(), "Astolfo") ? idigibit : var31)), var30);
               }
            } else if (aware$.getValue().booleanValue()) {
               dugabopu.mc.fontRendererObj.drawStringWithShadow(modocoyu, (float)((double)((float)((double)((float)ofunopuy.getScaledWidth() - var61._early()) - daganevi)) - (symphony$.getValue().booleanValue() ? 2.0D : 1.0D) + Animation2._harper(100.0D - var61.schools$._hungry(), vizitami)), var61._section() + 1.5F, var30);
            } else {
               dugabopu.mc.fontRendererObj.drawString(modocoyu, (float)((double)((float)((double)((float)ofunopuy.getScaledWidth() - var61._early()) - daganevi)) - (symphony$.getValue().booleanValue() ? 2.0D : 1.0D) + Animation2._harper(100.0D - var61.schools$._hungry(), vizitami)), var61._section() + 1.5F, var30, false);
            }

            if (Objects.equals(chief$.getValue(), "Astolfo")) {
               if (symphony$.getValue().booleanValue()) {
                  if (var61 == otacanon.get(otacanon.size() - 1)) {
                     RenderUtil5._integer((double)(ofunopuy.getScaledWidth() - (weekends$.getValue().booleanValue() ? email$.getStringWidth(modocoyu) : dugabopu.mc.fontRendererObj.getStringWidth(modocoyu)) - 4 - 1), (double)galucoca + novezoge, (double)(ofunopuy.getScaledWidth() - (weekends$.getValue().booleanValue() ? email$.getStringWidth(modocoyu) : dugabopu.mc.fontRendererObj.getStringWidth(modocoyu)) - 4 - 2 + (weekends$.getValue().booleanValue() ? email$.getStringWidth(modocoyu) : dugabopu.mc.fontRendererObj.getStringWidth(modocoyu)) + 6), (double)galucoca + osebebat, var30);
                  } else {
                     int var33 = otacanon.indexOf(var61);
                     int var34 = var33 + 1;
                     int var35 = weekends$.getValue().booleanValue() ? email$.getStringWidth(((Module)otacanon.get(var33))._lesbian().equals("") ? Client.î ?((Module)otacanon.get(var33)) : String.format("%s %s", Client.î ?((Module)otacanon.get(var33)), ((Module)otacanon.get(var33))._lesbian())) : dugabopu.mc.fontRendererObj.getStringWidth(((Module)otacanon.get(var33))._lesbian().equals("") ? Client.î ?((Module)otacanon.get(var33)) : String.format("%s %s", Client.î ?((Module)otacanon.get(var33)), ((Module)otacanon.get(var33))._lesbian()));
                     int var36 = weekends$.getValue().booleanValue() ? email$.getStringWidth(((Module)otacanon.get(var34))._lesbian().equals("") ? Client.î ?((Module)otacanon.get(var34)) : String.format("%s %s", Client.î ?((Module)otacanon.get(var34)), ((Module)otacanon.get(var34))._lesbian())) : dugabopu.mc.fontRendererObj.getStringWidth(((Module)otacanon.get(var34))._lesbian().equals("") ? Client.î ?((Module)otacanon.get(var34)) : String.format("%s %s", Client.î ?((Module)otacanon.get(var34)), ((Module)otacanon.get(var34))._lesbian()));
                     RenderUtil5._usually((float)ofunopuy.getScaledWidth() - (weekends$.getValue().booleanValue() ? (float)email$.getStringWidth(modocoyu) + 5.0F : (float)dugabopu.mc.fontRendererObj.getStringWidth(modocoyu) + 5.0F), galucoca + (float)(straight$.getValue().intValue() > 21 ? 11 : 10), (float)ofunopuy.getScaledWidth() - (weekends$.getValue().booleanValue() ? (float)email$.getStringWidth(modocoyu) + 4.0F : (float)dugabopu.mc.fontRendererObj.getStringWidth(modocoyu) + 4.0F) + (float)(var35 - var36), galucoca + (float)(straight$.getValue().intValue() > 21 ? 12 : 11), var30);
                  }

                  RenderUtil5._integer((double)(ofunopuy.getScaledWidth() - 1), (double)(galucoca + (float)(weekends$.getValue().booleanValue() ? 0 : 1)), (double)ofunopuy.getScaledWidth(), (double)galucoca + osebebat, var30);
                  RenderUtil5._integer((double)((float)(ofunopuy.getScaledWidth() - (weekends$.getValue().booleanValue() ? email$.getStringWidth(modocoyu) : dugabopu.mc.fontRendererObj.getStringWidth(modocoyu)) - 4) - 1.0F), ronald$.getValue().booleanValue() ? (double)galucoca : (double)(straight$.getValue().intValue() > 21 ? galucoca + 0.5F : galucoca + 0.5F), (double)(ofunopuy.getScaledWidth() - (weekends$.getValue().booleanValue() ? email$.getStringWidth(modocoyu) : dugabopu.mc.fontRendererObj.getStringWidth(modocoyu)) - 4), straight$.getValue().intValue() > 21 ? (double)galucoca + novezoge : (double)galucoca + novezoge, var30);
               }
            } else if (symphony$.getValue().booleanValue()) {
               RenderUtil5._integer((double)(ofunopuy.getScaledWidth() - 1), (double)galucoca, (double)ofunopuy.getScaledWidth(), (double)galucoca + osebebat - 0.699999988079071D, var30);
            }

            ++zapogugo;
            galucoca += straight$.getValue().intValue() > 21 ? 11.5F : 10.5F;
         }
      }

      if (Objects.equals(lovely$.getValue(), "Normal") && !dugabopu.mc.gameSettings.showDebugInfo) {
         for(Object var46 : ModuleManager._trick()) {
            if ((var46._central() || !var46._discover() || var46._early() != Float.intBitsToFloat(0)) && (pairs$.getValue().booleanValue() || !var46._wishlist()) && (cheapest$.getValue().booleanValue() || var46._bennett() != ModuleType.ignored$ || var46._keeps())) {
               otacanon.add(var46);
            }
         }

         if (ronald$.getValue().booleanValue()) {
            if (weekends$.getValue().booleanValue()) {
               otacanon.sort(HUD::_finished);
            } else {
               otacanon.sort(dugabopu::_imposed);
            }
         }

         Object var42 = muscle$;
         Object var47 = creek$;
         if (weekends$.getValue().booleanValue()) {
            for(Object ucizizib : otacanon) {
               ucizizib._britain();
               Object var37 = ucizizib._lesbian().isEmpty() ? Client.î ?(ucizizib) : String.format("%s %s", Client.î ?(ucizizib), ucizizib._lesbian());
               if (ucizizib._central() && ucizizib.python$ == Float.intBitsToFloat(0)) {
                  ucizizib.python$ = (float)var47;
               } else if (ucizizib._central() && ucizizib.python$ < (float)var47) {
                  ucizizib.python$ += 0.5F;
               } else if (ucizizib._central() && ucizizib.python$ > (float)var47) {
                  ucizizib.python$ -= 0.5F;
               }

               if (ucizizib._central()) {
                  ucizizib._algeria(false);
                  if (dugabopu.mc.thePlayer.ticksExisted >= 30) {
                     ucizizib._disputes(Math.min(ucizizib._early() + (float)(email$.getStringWidth(var37) / 15), (float)email$.getStringWidth(var37)));
                  } else {
                     ucizizib._disputes((float)email$.getStringWidth(var37));
                  }
               } else if (ucizizib._early() <= Float.intBitsToFloat(0)) {
                  ucizizib._algeria(true);
               } else if (dugabopu.mc.thePlayer.ticksExisted >= 30) {
                  ucizizib._disputes(Math.max(ucizizib._early() - (float)(email$.getStringWidth(var37) / 15), Float.intBitsToFloat(0)));
               } else {
                  ucizizib._disputes(Float.intBitsToFloat(0));
               }

               Object var55 = muscle$ < -421 ? (float)(var42 - 60 + RenderUtil5._junior()) : (float)(var42 + ofunopuy.getScaledWidth()) - ucizizib._early();
               int ninamevo;
               if (Objects.equals(hotmail$.getValue(), "Rainbow")) {
                  ninamevo = ColorUtil._islamic(5, zapogugo * 20, Client.surround$.î ?(), Client.surround$.î ?(), surfing$.getValue().booleanValue()).getRGB();
               } else if (Objects.equals(hotmail$.getValue(), "Fade")) {
                  ninamevo = ColorUtils2._reward(new Color(during$.getValue().intValue()), var47 / 11, stores$.getValue().intValue()).getRGB();
               } else {
                  ninamevo = during$.getValue().intValue();
               }

               if (aware$.getValue().booleanValue()) {
                  email$.drawStringWithShadow(var37, (double)(var55 - 3.0F), (double)(ucizizib._section() + 3.5F), ninamevo);
               } else {
                  email$.drawString(var37, var55 - 3.0F, ucizizib._section() + 3.5F, ninamevo);
               }

               ++zapogugo;
               var47 += 12;
            }
         } else {
            for(Object var53 : otacanon) {
               Object var38 = var53._lesbian().isEmpty() ? Client.î ?(var53) : String.format("%s %s", Client.î ?(var53), var53._lesbian());
               if (var53._central() && var53.python$ == Float.intBitsToFloat(0)) {
                  var53.python$ = (float)var47;
               } else if (var53._central() && var53.python$ < (float)var47) {
                  var53.python$ += 0.5F;
               } else if (var53._central() && var53.python$ > (float)var47) {
                  var53.python$ -= 0.5F;
               }

               if (var53._central()) {
                  var53._algeria(false);
                  if (dugabopu.mc.thePlayer.ticksExisted >= 30) {
                     var53._disputes(Math.min(var53._early() + (float)(dugabopu.mc.fontRendererObj.getStringWidth(var38) / 12), (float)dugabopu.mc.fontRendererObj.getStringWidth(var38)));
                  } else {
                     var53._disputes((float)dugabopu.mc.fontRendererObj.getStringWidth(var38));
                  }
               } else if (var53._early() <= Float.intBitsToFloat(0)) {
                  var53._algeria(true);
               } else if (dugabopu.mc.thePlayer.ticksExisted >= 30) {
                  var53._disputes(Math.max(var53._early() - (float)(dugabopu.mc.fontRendererObj.getStringWidth(var38) / 12), Float.intBitsToFloat(0)));
               } else {
                  var53._disputes(Float.intBitsToFloat(0));
               }

               Object var56 = muscle$ < -300 ? (float)(var42 - 60 + RenderUtil5._junior()) : (float)(var42 + RenderUtil5._junior()) - var53._early();
               int var58;
               if (Objects.equals(hotmail$.getValue(), "Rainbow")) {
                  var58 = ColorUtil._islamic(5, zapogugo * 20, Client.surround$.î ?(), Client.surround$.î ?(), surfing$.getValue().booleanValue()).getRGB();
               } else if (Objects.equals(hotmail$.getValue(), "Fade")) {
                  var58 = ColorUtils2._reward(new Color(during$.getValue().intValue()), var47 / 11, stores$.getValue().intValue()).getRGB();
               } else {
                  var58 = during$.getValue().intValue();
               }

               if (aware$.getValue().booleanValue()) {
                  dugabopu.mc.fontRendererObj.drawStringWithShadow(var38, var56 - 3.5F, var53._section() + 2.5F, var58);
               } else {
                  dugabopu.mc.fontRendererObj.drawString(var38, var56 - 3.5F, var53._section() + 2.5F, var58, false);
               }

               ++zapogugo;
               var47 += 12;
            }
         }
      }

      if (insert$.getValue().booleanValue()) {
         Object var39 = String.valueOf(MathUtil._teach((double)dugabopu.mc.thePlayer.getHealth(), 1));
         Object var43 = String.valueOf(MathUtil._teach((double)dugabopu.mc.thePlayer.getAbsorptionAmount(), 1));
         Object var48 = Float.intBitsToFloat(0);
         if (dugabopu.mc.thePlayer.getHealth() < 10.0F) {
            var48 = 4.0F;
         }

         Object var52 = Float.intBitsToFloat(0);
         if (MathUtil._teach((double)dugabopu.mc.thePlayer.getAbsorptionAmount(), 1) >= 1.0D && MathUtil._teach((double)dugabopu.mc.thePlayer.getAbsorptionAmount(), 1) < 2.0D) {
            var52 = 1.5F;
         }

         Object var54 = (float)ofunopuy.getScaledWidth() / 2.0F - 24.0F;
         if (dugabopu.mc.thePlayer.getHealth() < 10.0F) {
            var54 = (float)ofunopuy.getScaledWidth() / 2.0F - 21.0F;
         }

         Object var57 = MathUtil._teach((double)dugabopu.mc.thePlayer.getAbsorptionAmount(), 1) > Double.longBitsToDouble(0L) ? var54 : (dugabopu.mc.thePlayer.getHealth() < 10.0F ? (float)ofunopuy.getScaledWidth() / 2.0F - 11.0F + 2.0F : (float)ofunopuy.getScaledWidth() / 2.0F - 11.0F);
         Object var59 = (float)ofunopuy.getScaledHeight() / 2.0F + 18.0F;
         dugabopu.mc.fontRendererObj.drawStringWithShadow(var39, var57, var59, Colors._nickname(0, 255, 0, 200));
         dugabopu.mc.fontRendererObj.drawStringWithShadow("Â§7" + EnumChatFormatting.RED + "â?", var57 + (float)dugabopu.mc.fontRendererObj.getStringWidth(var39), var59 - 1.0F, -1);
         if (MathUtil._teach((double)dugabopu.mc.thePlayer.getAbsorptionAmount(), 1) > Double.longBitsToDouble(0L)) {
            dugabopu.mc.fontRendererObj.drawStringWithShadow("Â§7" + EnumChatFormatting.GOLD + var43, var57 + 31.0F - var48 + (float)FontLoaders.kiona11.getStringWidth("Â§7" + EnumChatFormatting.RED + "â?"), var59 - 0.5F, -1);
            dugabopu.mc.fontRendererObj.drawStringWithShadow("Â§7" + EnumChatFormatting.GOLD + "â?", var57 + 38.0F - var48 + (float)FontLoaders.kiona11.getStringWidth("Â§7" + EnumChatFormatting.RED + "â?") + (float)FontLoaders.kiona11.getStringWidth("Â§7" + EnumChatFormatting.GOLD + var43) + var52, var59 - 1.0F, -1);
         }
      }

      Object var40 = ((String)dugabopu.fifth$.getValue()).equals("") ? draft$.charAt(0) + "Â§7" + EnumChatFormatting.WHITE + draft$.substring(1) : ((String)dugabopu.fifth$.getValue()).charAt(0) + "Â§7" + EnumChatFormatting.WHITE + ((String)dugabopu.fifth$.getValue()).substring(1);
      if (shares$.getValue().booleanValue()) {
         Object var44 = new ResourceLocation("sleep/customlog.png");
         RenderUtil5._river(var44, 3.0F, 5.0F, 40.0F, 40.0F);
      }

      if (drawings$.getValue().booleanValue()) {
         if (weekends$.getValue().booleanValue()) {
            email$.drawStringWithShadow(var40.replace('&', 'Â§'), 3.5D, 5.5D, during$.getValue().intValue());
         } else {
            dugabopu.mc.fontRendererObj.drawStringWithShadow(var40.replace('&', 'Â§'), 3.5F, 5.5F, during$.getValue().intValue());
         }
      }

      Object var45 = new BigDecimal(dugabopu._girls() * 10.0D);
      Object var49 = var45.setScale(2, 4).doubleValue();
      if (weekends$.getValue().booleanValue()) {
         email$.drawStringWithShadow(EnumChatFormatting.WHITE + "Block/s: " + EnumChatFormatting.RESET + var49, 2.0D, (double)(ofunopuy.getScaledHeight() - 10), during$.getValue().intValue());
      } else {
         dugabopu.mc.fontRendererObj.drawStringWithShadow(EnumChatFormatting.WHITE + "Block/s: " + EnumChatFormatting.RESET + var49, 2.0F, (float)(ofunopuy.getScaledHeight() - 10), during$.getValue().intValue());
      }

      if (weekends$.getValue().booleanValue()) {
         boolean var10000 = dugabopu.mc.ingameGUI.getChatGUI().getChatOpen() ? true : true;
         email$.drawStringWithShadow(EnumChatFormatting.WHITE + "Release 8.2 -" + EnumChatFormatting.GRAY + " " + columns$.replace('&', 'Â§'), (double)((float)(ofunopuy.getScaledWidth() - email$.getStringWidth(EnumChatFormatting.WHITE + "Release 8.2 -" + EnumChatFormatting.GRAY + " " + columns$.replace('&', 'Â§'))) - 2.0F), (double)(ofunopuy.getScaledHeight() - 10), during$.getValue().intValue());
      } else {
         boolean var64 = dugabopu.mc.ingameGUI.getChatGUI().getChatOpen() ? true : true;
         dugabopu.mc.fontRendererObj.drawStringWithShadow(EnumChatFormatting.WHITE + "Release 8.2 -" + EnumChatFormatting.GRAY + " " + columns$.replace('&', 'Â§'), (float)(ofunopuy.getScaledWidth() - dugabopu.mc.fontRendererObj.getStringWidth(EnumChatFormatting.WHITE + "Release 8.2 -" + EnumChatFormatting.GRAY + " " + columns$.replace('&', 'Â§')) - 2), (float)(ofunopuy.getScaledHeight() - 10), during$.getValue().intValue());
      }

   }

   public static float _motion() {
      return (float)(System.currentTimeMillis() % ((long)553482121 ^ 553480281L)) / 1000.0F;
   }

   public static Color _bases(int resident, float murder) {
      Object brussels = 4000.0F;

      float danny;
      for(danny = (float)(System.currentTimeMillis() % (long)resident) + murder; danny > brussels; danny -= brussels) {
         ;
      }

      danny = danny / brussels;
      if ((double)danny > 0.5D) {
         danny = 0.5F - (danny - 0.5F);
      }

      danny = danny + 0.5F;
      return Color.getHSBColor(danny, 0.75F, 1.0F);
   }

   public static int _speakers() {
      return muscle$;
   }

   public static void _grass(int alfred) {
      muscle$ = (int)alfred;
   }

   public static int _linear() {
      return creek$;
   }

   public static void _rapids(int uyalocov) {
      creek$ = (int)uyalocov;
   }

   public static boolean _higher(int tumobuni, int ziviyofi) {
      Object upudadis = new ScaledResolution(Helper.sprint$);
      return MathUtil._alice((double)tumobuni, (double)ziviyofi, (double)(_speakers() + upudadis.getScaledWidth() + 3), (double)(_linear() + upudadis.getScaledHeight() - 238), (double)(_speakers() + upudadis.getScaledWidth() - 70), (double)(_linear() - 15)) && ModuleManager._herbs(HUD.class)._central();
   }

   public static Color _bargains() {
      return new Color(during$.getValue().intValue());
   }

   public double _girls() {
      Object floppy = (judges.mc.thePlayer.posX - judges.mc.thePlayer.lastTickPosX) * 2.0D;
      double var3 = (judges.mc.thePlayer.posZ - judges.mc.thePlayer.lastTickPosZ) * 2.0D;
      return (double)MathHelper.sqrt_double(floppy * floppy + var3 * var3);
   }

   public static void _expects(String izovoteg) {
      columns$ = (String)izovoteg;
   }

   public static int _cedar(int amanda) {
      int pixel;
      if (Objects.equals(hotmail$.getValue(), "Rainbow")) {
         pixel = ColorUtil._islamic(5, amanda * 20, Client.surround$.î ?(), Client.surround$.î ?(), surfing$.getValue().booleanValue()).getRGB();
      } else if (Objects.equals(hotmail$.getValue(), "Fade")) {
         pixel = ColorUtils2._reward(new Color(during$.getValue().intValue()), amanda / 11, stores$.getValue().intValue()).getRGB();
      } else {
         pixel = during$.getValue().intValue();
      }

      return pixel;
   }

   public int _imposed(Module iceland, Module prove) {
      return scroll.mc.fontRendererObj.getStringWidth(((Module)prove)._lesbian().isEmpty() ? Client.î ?((Module)prove) : String.format("%s %s", Client.î ?((Module)prove), ((Module)prove)._lesbian())) - scroll.mc.fontRendererObj.getStringWidth(((Module)iceland)._lesbian().isEmpty() ? Client.î ?((Module)iceland) : String.format("%s %s", Client.î ?((Module)iceland), ((Module)iceland)._lesbian()));
   }

   public static int _finished(Module eniliyef, Module sobadofu) {
      return email$.getStringWidth(((Module)sobadofu)._lesbian().isEmpty() ? Client.î ?((Module)sobadofu) : String.format("%s %s", Client.î ?((Module)sobadofu), ((Module)sobadofu)._lesbian())) - email$.getStringWidth(((Module)eniliyef)._lesbian().isEmpty() ? Client.î ?((Module)eniliyef) : String.format("%s %s", Client.î ?((Module)eniliyef), ((Module)eniliyef)._lesbian()));
   }

   public int _dollar(Module gitevega, Module ipamudus) {
      return izegimip.mc.fontRendererObj.getStringWidth(((Module)ipamudus)._lesbian().isEmpty() ? Client.î ?((Module)ipamudus) : String.format("%s %s", Client.î ?((Module)ipamudus), ((Module)ipamudus)._lesbian())) - izegimip.mc.fontRendererObj.getStringWidth(((Module)gitevega)._lesbian().isEmpty() ? Client.î ?((Module)gitevega) : String.format("%s %s", Client.î ?((Module)gitevega), ((Module)gitevega)._lesbian()));
   }

   public static int _brick(Module asking, Module destroy) {
      return email$.getStringWidth(((Module)destroy)._lesbian().isEmpty() ? Client.î ?((Module)destroy) : String.format("%s %s", Client.î ?((Module)destroy), ((Module)destroy)._lesbian())) - email$.getStringWidth(((Module)asking)._lesbian().isEmpty() ? Client.î ?((Module)asking) : String.format("%s %s", Client.î ?((Module)asking), ((Module)asking)._lesbian()));
   }
}
