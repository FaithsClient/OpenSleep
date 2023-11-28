package rip.sleep.ui.neverlose.components;

import java.awt.Color;
import org.json.JSONException;
import org.lwjgl.input.Keyboard;
import rip.sleep.interfaces.IFontRenderer;
import rip.sleep.interfaces.IFontManager;
import rip.sleep.util.RenderUtilD;
import rip.sleep.util.RenderUtilE;
import rip.sleep.value.Value;
import rip.sleep.value.values.StringValue;
import rip.sleep.ui.renderer.ComponentRenderer;
import rip.sleep.module.Module;
import rip.sleep.Sleep;

public class TextFieldComponent extends NeverLoseComponent<StringValue> {
   public TextFieldComponent(StringValue var1, ComponentRenderer var2) {
      super(var1, var2);
   }

   public void c60551(int var1, int var2) {
      Value.c27574();
      Sleep var10001 = Sleep.INSTANCE;
      int var4 = Sleep.c43802.c16525;
      var10001 = Sleep.INSTANCE;
      int var5 = Sleep.c43802.c9435;
      int var6 = (int)(this.c49717() + (float)this.c51261());
      IFontRenderer var10000 = IFontManager.NL_FONT.c39582.c9044;
      String var13 = ((StringValue)this.c93183).getName();
      float var10002 = (float)(var4 + 100) + this.c9605();
      float var10003 = (float)(var5 + var6 + 60);
      Sleep var10004 = Sleep.INSTANCE;
      var10000.c18223(var13, var10002, var10003, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1);
      float var7 = (float)(var4 + 170) + this.c9605();
      float var14 = (float)(var5 + var6 + 54);
      Sleep var10005 = Sleep.INSTANCE;
      RenderUtilE.c5737(var7, var14, 80.0F, 14.0F, 2.0F, Sleep.c43802.c45529() ? (new Color(255, 255, 255)).getRGB() : (new Color(15, 15, 15, 30)).getRGB(), 1.0F, (new Color(13, 24, 35, 0)).getRGB());
      Sleep var8 = Sleep.INSTANCE;
      if (!Sleep.c43802.c45529()) {
         RenderUtilD.c15402((float)(var4 + 170) + this.c9605(), (float)(var5 + var6 + 54), 80.0F, 14.0F, 20, new Color(15, 15, 15, 80));
      }

      if (IFontManager.NL_FONT.c39582.c9044.c80174((CharSequence)(((StringValue)this.c93183).c71447() ? (String)((StringValue)this.c93183).c36545() + "_" : (CharSequence)((StringValue)this.c93183).c36545())) > 65) {
         IFontRenderer var9 = IFontManager.NL_FONT.c39582.c9044;
         String var15 = IFontManager.NL_FONT.c39582.c9044.c52754((CharSequence)(((StringValue)this.c93183).c71447() ? (String)((StringValue)this.c93183).c36545() + "_" : (CharSequence)((StringValue)this.c93183).c36545()), 59, true);
         var10002 = (float)(var4 + 173) + this.c9605();
         var10003 = (float)(var5 + var6 + 59);
         var10004 = Sleep.INSTANCE;
         var9.c18223(var15, var10002, var10003, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1);
      }

      if (((String)((StringValue)this.c93183).c36545()).isEmpty() && !((StringValue)this.c93183).c71447()) {
         IFontRenderer var10 = IFontManager.NL_FONT.c39582.c9044;
         var10002 = (float)(var4 + 173) + this.c9605();
         var10003 = (float)(var5 + var6 + 59);
         var10004 = Sleep.INSTANCE;
         var10.c18223("Type Here...", var10002, var10003, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1);
      }

      IFontRenderer var11 = IFontManager.NL_FONT.c39582.c9044;
      Object var16 = ((StringValue)this.c93183).c71447() ? (String)((StringValue)this.c93183).c36545() + "_" : (CharSequence)((StringValue)this.c93183).c36545();
      var10002 = (float)(var4 + 173) + this.c9605();
      var10003 = (float)(var5 + var6 + 59);
      var10004 = Sleep.INSTANCE;
      var11.c18223((CharSequence)var16, var10002, var10003, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1);
   }

   public void c80028(int var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      if (var3 == 0) {
         Sleep var10000 = Sleep.INSTANCE;
         float var5 = (float)(Sleep.c43802.c16525 + 170) + this.c9605();
         Sleep var10001 = Sleep.INSTANCE;
         if (RenderUtilE.c3863(var5, (float)(Sleep.c43802.c9435 + (int)(this.c49717() + (float)this.c51261()) + 54), 80.0F, 14.0F, var1, var2)) {
            ((StringValue)this.c93183).c13510 = !((StringValue)this.c93183).c13510;
         }
      }

      ((StringValue)this.c93183).c13510 = false;
   }

   public void c66160(int var1, int var2, int var3) {
   }

   public void c91879(char var1, int var2) {
      Module[] var3 = Value.c27574();
      if (((StringValue)this.c93183).c71447()) {
         if (var2 == 1) {
            ((StringValue)this.c93183).c14402(false);
         }

         if (var2 != 14 && var2 != 157 && var2 != 29 && var2 != 54 && var2 != 42 && var2 != 15 && var2 != 58 && var2 != 211 && var2 != 199 && var2 != 210 && var2 != 200 && var2 != 208 && var2 != 205 && var2 != 203 && var2 != 56 && var2 != 184 && var2 != 197 && var2 != 70 && var2 != 207 && var2 != 201 && var2 != 209 && var2 != 221 && var2 != 59 && var2 != 60 && var2 != 61 && var2 != 62 && var2 != 63 && var2 != 64 && var2 != 65 && var2 != 66 && var2 != 67 && var2 != 68 && var2 != 87 && var2 != 88) {
            ((StringValue)this.c93183).c82079(var1);
         }

         if (((StringValue)this.c93183).c71447() && Keyboard.isKeyDown(14) && ((String)((StringValue)this.c93183).c36545()).length() >= 1) {
            ((StringValue)this.c93183).c28440(((String)((StringValue)this.c93183).c36545()).substring(0, ((String)((StringValue)this.c93183).c36545()).length() - 1));
         }
      }

      super.c91879(var1, var2);
   }

   private static JSONException c99200(JSONException var0) {
      return var0;
   }
}
