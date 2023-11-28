package rip.sleep.ui.neverlose.components;

import Sleep.native0;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import rip.sleep.interfaces.IFontRenderer;
import rip.sleep.interfaces.IFontManager;
import rip.sleep.module.modules.HUD;
import rip.sleep.util.RenderUtilD;
import rip.sleep.util.RenderUtilE;
import rip.sleep.util.ShaderUtilA;
import rip.sleep.value.Value;
import rip.sleep.module.Module;

@native0
public class UserInfoComponent {
   public int c93412 = 50;
   public int c66084 = 100;
   private boolean c6544;
   private int c49030;
   private int c77771;
   public boolean c69684;

   public void c81897(int var1, int var2) {
      Module[] var3 = Value.c27574();
      if (this.c6544) {
         this.c93412 = this.c49030 + var1;
         this.c66084 = this.c77771 + var2;
      }

      ShaderUtilA.c76901((float)this.c93412, (float)this.c66084, 160.0F, 160.0F, 3.0F, this.c69684 ? new Color(255, 255, 255, 230) : new Color(15, 15, 15, 40));
      if (!this.c69684) {
         RenderUtilD.c15402((float)this.c93412, (float)this.c66084, 160.0F, 160.0F, 20, new Color(15, 15, 15, 80));
      }

      IFontManager.NL_FONT.c39582.c9044.c48462("About Sleep", this.c93412 + 13, this.c66084 + 3, this.c69684 ? (new Color(95, 95, 95)).getRGB() : -1);
      IFontManager.NL_ICON.c52401.c15228.c48462("x", this.c93412 + 2, this.c66084 + 4, (new Color(HUD.c64734.c41161().intValue())).getRGB());
      if (!this.c69684) {
         c55474("sleep.ft".toUpperCase(), IFontManager.MUSEO_SANS.c50067.c51061, (float)this.c93412, (float)(this.c66084 + 30), -1, (new Color(HUD.c64734.c41161().intValue())).getRGB(), 160, 0.7F);
      }

      IFontManager.MUSEO_SANS.c50067.c51061.c5112("sleep.ft".toUpperCase(), (float)(this.c93412 + 80), (float)(this.c66084 + 30), (new Color(51, 51, 51)).getRGB());
      IFontManager.NL_FONT.c41337.c17902.c48462((!this.c69684 ? ChatFormatting.WHITE : ChatFormatting.BLACK) + "Version: " + ChatFormatting.RESET + "Dev", this.c93412 + 10, this.c66084 + 65, (new Color(HUD.c64734.c41161().intValue())).getRGB());
      IFontManager.NL_FONT.c41337.c17902.c48462((!this.c69684 ? ChatFormatting.WHITE : ChatFormatting.BLACK) + "Build Type: " + ChatFormatting.RESET + "Dev", this.c93412 + 10, this.c66084 + 65 + IFontManager.NL_FONT.c41337.c17902.c5397() + 5, (new Color(HUD.c64734.c41161().intValue())).getRGB());
      IFontManager.NL_FONT.c41337.c17902.c48462((!this.c69684 ? ChatFormatting.WHITE : ChatFormatting.BLACK) + "Build Date: " + ChatFormatting.RESET + (new SimpleDateFormat("dd:MM")).format(new Date()) + " " + (new SimpleDateFormat("HH:mm")).format(new Date()), this.c93412 + 10, this.c66084 + 65 + (IFontManager.NL_FONT.c41337.c17902.c5397() + 5) * 2, (new Color(HUD.c64734.c41161().intValue())).getRGB());
      IFontManager.NL_FONT.c41337.c17902.c48462((!this.c69684 ? ChatFormatting.WHITE : ChatFormatting.BLACK) + "Registered to: " + ChatFormatting.RESET + "sleep", this.c93412 + 10, this.c66084 + 65 + (IFontManager.NL_FONT.c41337.c17902.c5397() + 5) * 3, (new Color(HUD.c64734.c41161().intValue())).getRGB());
      IFontManager.NL_FONT.c41337.c17902.c5112("sleep.ft @ 2020-2023", (float)(this.c93412 + 80), (float)(this.c66084 + 65 + (IFontManager.NL_FONT.c41337.c17902.c5397() + 5) * 4 + 7), this.c69684 ? (new Color(95, 95, 95)).getRGB() : -1);
      IFontManager.NL_FONT.c41337.c17902.c48462("Style", this.c93412 + 10, this.c66084 + 145, this.c69684 ? (new Color(95, 95, 95)).getRGB() : -1);
      if (this.c69684) {
         ShaderUtilA.c76901((float)(this.c93412 + 39), (float)(this.c66084 + 143), 11.5F, 11.5F, 5.5F, new Color(HUD.c64734.c41161().intValue()));
      }

      ShaderUtilA.c76901((float)(this.c93412 + 40), (float)(this.c66084 + 144), 9.5F, 9.5F, 4.5F, new Color(210, 210, 210));
      if (!this.c69684) {
         ShaderUtilA.c76901((float)(this.c93412 + 39 + 20), (float)(this.c66084 + 143), 11.5F, 11.5F, 5.5F, new Color(HUD.c64734.c41161().intValue()));
      }

      ShaderUtilA.c76901((float)(this.c93412 + 40 + 20), (float)(this.c66084 + 144), 9.5F, 9.5F, 4.5F, new Color(7, 13, 23, 230));
   }

   public static void c55474(String var0, IFontRenderer var1, float var2, float var3, int var4, int var5, int var6, float var7) {
      var1.c19763(var0, var2 + (float)(var6 / 2) + var7, var3, var5, false);
      var1.c19763(var0, var2 + (float)(var6 / 2), var3 - var7, var5, false);
      var1.c19763(var0, var2 + (float)(var6 / 2), var3, var4, false);
   }

   public void c69158(int var1, int var2, int var3) {
      this.c6544 = false;
   }

   public void c67641(int var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      if (var3 == 0) {
         if (RenderUtilE.c3863((float)this.c93412, (float)this.c66084, 160.0F, 160.0F, var1, var2)) {
            this.c49030 = this.c93412 - var1;
            this.c77771 = this.c66084 - var2;
            this.c6544 = true;
         }

         if (RenderUtilE.c3863((float)(this.c93412 + 40 + 20), (float)(this.c66084 + 144), 9.5F, 9.5F, var1, var2)) {
            this.c69684 = false;
            this.c6544 = false;
         }

         if (RenderUtilE.c3863((float)(this.c93412 + 40), (float)(this.c66084 + 144), 9.5F, 9.5F, var1, var2)) {
            this.c69684 = true;
            this.c6544 = false;
         }
      }

   }

   private static JSONException c71417(JSONException var0) {
      return var0;
   }
}
