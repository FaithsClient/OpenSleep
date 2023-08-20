//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Minecraft\vape\maps\15"!

package ft.sleep.value;

import ft.sleep.Client;
import ft.sleep.api.value.Numbers;
import ft.sleep.api.value.Value;
import ft.sleep.module.ModuleManager;
import ft.sleep.module.modules.HUD;
import ft.sleep.ui.font.FontLoaders;
import java.awt.Color;

import ft.sleep.ui.screen.ClickGui;
import ft.sleep.util.math.MathUtil;
import ft.sleep.util.render.RenderUtil4;
import ft.sleep.util.render.RoundedUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;

public class NumberSetting extends Downward {
   public float churches$;
   public float mixer$;
   public float poker$;
   public float starts$ = Float.intBitsToFloat(0);
   public boolean fault$;

   public NumberSetting(Numbers yurovayi, float gobocipo, float dogosidi, int usiluroz, int tolibebi, ModuleRender2 coparalu) {
      super((Value)yurovayi, (float)gobocipo, (float)dogosidi, (int)usiluroz, (int)tolibebi, (ModuleRender2)coparalu);
   }

   public void __/* $FF was: î ‘î ”*/(int advise, int bowling) {
      walnut.churches$ = Client.surround$.conflict$.î ‘î ”î ?();
      walnut.mixer$ = Client.surround$.conflict$.î ‘î ”î ?();
      walnut.poker$ = walnut.î ?.strength$ + (float)walnut.î “î “î ?();
      Minecraft.getMinecraft();
      Object unwrap = MathHelper.clamp_double((double)(Minecraft.getDebugFPS() / 30), 1.0D, 9999.0D);
      Object building = (((Numbers)walnut.î ?).getValue().doubleValue() - ((Numbers)walnut.î ?).getMinimum().doubleValue()) / (((Numbers)walnut.î ?).getMaximum().doubleValue() - ((Numbers)walnut.î ?).getMinimum().doubleValue());
      walnut.starts$ = Math.max(Float.intBitsToFloat(0), Math.min(1.0F, (float)((double)walnut.starts$ + (Math.max(Double.longBitsToDouble(0L), Math.min(building, 1.0D)) - (double)walnut.starts$) * (0.2D / unwrap))));
      RoundedUtil._ticket(walnut.churches$ + 5.0F + walnut.î ?.linking$ + 55.0F, walnut.mixer$ + 17.0F + walnut.poker$ + 8.0F, 75.0F, 2.5F, 1.0F, new Color(34, 38, 48));
      RoundedUtil._ticket(walnut.churches$ + 5.0F + walnut.î ?.linking$ + 55.0F, walnut.mixer$ + 17.0F + walnut.poker$ + 8.0F, 75.0F * walnut.starts$, 2.5F, 1.0F, new Color(HUD.during$.getValue().intValue()));
      FontLoaders.TahomaBold11.drawString(((Numbers)walnut.î ?).getName(), walnut.churches$ + 5.0F + walnut.î ?.linking$ + 4.0F, walnut.mixer$ + 17.0F + walnut.poker$ + 8.0F, (new Color(200, 200, 200)).getRGB());
      if (walnut.fault$) {
         Object urgent = Math.min(1.0F, Math.max(Float.intBitsToFloat(0), ((float)advise - (walnut.churches$ + 5.0F + walnut.î ?.linking$ + 55.0F)) / 99.0F * 1.3F));
         double var8 = (double)urgent * (((Numbers)walnut.î ?).getMaximum().doubleValue() - ((Numbers)walnut.î ?).getMinimum().doubleValue()) + ((Numbers)walnut.î ?).getMinimum().doubleValue();
         double var10 = MathUtil._currency(var8, ((Numbers)walnut.î ?).getIncrement().doubleValue());
         ((Numbers)walnut.î ?).setValue(Double.valueOf(var10));
      }

      Client.î ?();
      Object var12 = (ClickGui) ModuleManager._herbs(ClickGui.class);
      if (walnut.fault$ || walnut._cyber((int)advise, (int)bowling) || var12.medical$.getValue().booleanValue()) {
         RoundedUtil._ticket(walnut.churches$ + 5.0F + walnut.î ?.linking$ + 55.0F + 61.0F * walnut.starts$, walnut.mixer$ + 17.0F + walnut.poker$ + 8.0F + 6.0F, (float)(FontLoaders.TahomaBold11.getStringWidth(((Numbers)walnut.î ?).getValue() + "") + 1), 6.0F, 1.0F, new Color(32, 34, 39, 180));
         FontLoaders.TahomaBold11.drawString(((Numbers)walnut.î ?).getValue() + "", walnut.churches$ + 5.5F + walnut.î ?.linking$ + 55.0F + 62.0F * walnut.starts$, walnut.mixer$ + 17.0F + walnut.poker$ + 8.0F + 8.0F, (new Color(250, 250, 250)).getRGB());
      }

      if (walnut._cyber((int)advise, (int)bowling)) {
         RenderUtil4._knowing(walnut.churches$ + 5.0F + walnut.î ?.linking$ + 55.0F, walnut.mixer$ + 17.0F + walnut.poker$ + 8.0F, 75.0F, 2.5F, 1.0F, (new Color(0, 0, 0, 0)).getRGB(), 1.0F, (new Color(HUD.during$.getValue().intValue())).getRGB());
      }

   }

   public void __/* $FF was: î ”î ”*/(int software, int advert, int close) {
      if (gentle._cyber((int)software, (int)advert) && close == 0) {
         gentle.fault$ = true;
      }

   }

   public void __/* $FF was: î ”î ‘*/(int offices, int var2, int var3) {
      if (var3 == 0) {
         movies.fault$ = false;
      }

   }

   public boolean _cyber(int orenoyov, int sucopapi) {
      return (float)orenoyov >= cemanozo.churches$ + 5.0F + cemanozo.î ?.linking$ + 55.0F && (float)orenoyov <= cemanozo.churches$ + 5.0F + cemanozo.î ?.linking$ + 55.0F + 75.0F && (float)sucopapi >= cemanozo.mixer$ + 17.0F + cemanozo.poker$ + 8.0F && (float)sucopapi <= cemanozo.mixer$ + 17.0F + cemanozo.poker$ + 8.0F + 2.5F;
   }
}
