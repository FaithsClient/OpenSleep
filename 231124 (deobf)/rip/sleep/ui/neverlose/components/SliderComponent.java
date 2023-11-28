package rip.sleep.ui.neverlose.components;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;
import org.json.JSONException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import rip.sleep.interfaces.IFontRenderer;
import rip.sleep.interfaces.IFontManager;
import rip.sleep.module.modules.HUD;
import rip.sleep.struct.AnimationState;
import rip.sleep.util.AnimationUtilA;
import rip.sleep.util.AnimationUtilD;
import rip.sleep.util.MathUtilB;
import rip.sleep.util.RenderUtilD;
import rip.sleep.util.RenderUtilE;
import rip.sleep.util.ShaderUtilA;
import rip.sleep.value.Value;
import rip.sleep.value.values.NumberValue;
import rip.sleep.ui.renderer.ComponentRenderer;
import rip.sleep.module.Module;
import rip.sleep.Sleep;

public class SliderComponent extends NeverLoseComponent<NumberValue> {
   public float c73564 = 0.0F;
   private boolean c50193;
   private boolean c82836;
   private String c48371;
   public AnimationUtilA c24261 = new AnimationUtilD(225, 1.0D, AnimationState.Backward);

   public SliderComponent(NumberValue var1, ComponentRenderer var2) {
      super(var1, var2);
   }

   public void c60551(int var1, int var2) {
      int var4;
      int var5;
      int var6;
      AnimationState var24;
      AnimationUtilA var10000;
      label63: {
         Value.c27574();
         Sleep var10001 = Sleep.INSTANCE;
         var4 = Sleep.c43802.c16525;
         var10001 = Sleep.INSTANCE;
         var5 = Sleep.c43802.c9435;
         var6 = (int)(this.c49717() + (float)this.c51261());
         var10000 = this.c24261;
         if (!this.c50193) {
            var10001 = Sleep.INSTANCE;
            float var23 = (float)(Sleep.c43802.c16525 + 170) + this.c9605();
            Sleep var10002 = Sleep.INSTANCE;
            if (!RenderUtilE.c3863(var23, (float)(Sleep.c43802.c9435 + (int)(this.c49717() + (float)this.c51261()) + 58), 60.0F, 2.0F, var1, var2)) {
               var24 = AnimationState.Backward;
               break label63;
            }
         }

         var24 = AnimationState.Forward;
      }

      var10000.c96546(var24);
      double var7 = MathHelper.clamp_double((double)(Minecraft.getDebugFPS() / 30), 1.0D, 9999.0D);
      double var9 = (((NumberValue)this.c93183).c53968().doubleValue() - ((NumberValue)this.c93183).c61905().doubleValue()) / (((NumberValue)this.c93183).c36673().doubleValue() - ((NumberValue)this.c93183).c61905().doubleValue());
      this.c73564 = Math.max(0.0F, Math.min(1.0F, (float)((double)this.c73564 + (Math.max(0.0D, Math.min(var9, 1.0D)) - (double)this.c73564) * (0.2D / var7))));
      IFontRenderer var16 = IFontManager.NL_FONT.c16126.c55770;
      String var25 = ((NumberValue)this.c93183).getName();
      float var29 = (float)(var4 + 100) + this.c9605();
      float var10003 = (float)(var5 + var6 + 57);
      Sleep var10004 = Sleep.INSTANCE;
      var16.c18223(var25, var29, var10003, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1);
      float var17 = (float)(var4 + 168) + this.c9605();
      float var26 = (float)(var5 + var6 + 58);
      Sleep var10005 = Sleep.INSTANCE;
      ShaderUtilA.c76901(var17, var26, 62.0F, 2.0F, 2.0F, Sleep.c43802.c45529() ? new Color(230, 230, 230) : new Color(5, 22, 41));
      ShaderUtilA.c76901((float)(var4 + 168) + this.c9605(), (float)(var5 + var6 + 58), 62.0F * this.c73564, 2.0F, 2.0F, new Color(HUD.c64734.c41161().intValue()));
      ShaderUtilA.c88870((float)(var4 + 167) + this.c9605() + 60.0F * this.c73564, (float)(var5 + var6 + 56), (float)(5.5D + 0.5D * this.c24261.c53286()), new Color(HUD.c64734.c41161().intValue()));
      if (this.c50193) {
         float var11 = Math.min(1.0F, Math.max(0.0F, ((float)var1 - ((float)(var4 + 170) + this.c9605())) / 99.0F * 1.55F));
         double var12 = (double)var11 * (((NumberValue)this.c93183).c36673().doubleValue() - ((NumberValue)this.c93183).c61905().doubleValue()) + ((NumberValue)this.c93183).c61905().doubleValue();
         double var14 = MathUtilB.c39098(var12, ((NumberValue)this.c93183).c18780().doubleValue());
         ((NumberValue)this.c93183).c70375(Double.valueOf(var14));
      }

      if (this.c82836) {
         GL11.glTranslatef(0.0F, 0.0F, 2.0F);
      }

      var17 = (float)(var4 + 235) + this.c9605();
      var26 = (float)(var5 + var6 + 55);
      var29 = (float)(IFontManager.NL_FONT.c83066.c73459.c80174(this.c82836 ? this.c48371 + "_" : ((NumberValue)this.c93183).c53968().floatValue() + "") + 4);
      var10005 = Sleep.INSTANCE;
      RenderUtilE.c5737(var17, var26, var29, 9.0F, 3.0F, Sleep.c43802.c45529() ? (new Color(255, 255, 255, 70)).getRGB() : (new Color(15, 15, 15, 30)).getRGB(), 1.0F, (new Color(13, 24, 35, 0)).getRGB());
      Sleep var19 = Sleep.INSTANCE;
      if (!Sleep.c43802.c45529()) {
         RenderUtilD.c15402((float)(var4 + 235) + this.c9605(), (float)(var5 + var6 + 55), (float)(IFontManager.NL_FONT.c83066.c73459.c80174(this.c82836 ? this.c48371 + "_" : ((NumberValue)this.c93183).c53968().floatValue() + "") + 4), 9.0F, 10, new Color(15, 15, 15, 120));
      }

      IFontRenderer var20 = IFontManager.NL_FONT.c83066.c73459;
      String var28 = this.c82836 ? this.c48371 + "_" : ((NumberValue)this.c93183).c53968().floatValue() + "";
      var29 = (float)(var4 + 237) + this.c9605();
      var10003 = (float)(var5 + var6 + 58);
      var10004 = Sleep.INSTANCE;
      var20.c18223(var28, var29, var10003, Sleep.c43802.c45529() ? (new Color(95, 95, 95)).getRGB() : -1);
      if (this.c82836) {
         GL11.glTranslatef(0.0F, 0.0F, -2.0F);
      }

   }

   public void c80028(int var1, int var2, int var3) {
      Value.c27574();
      Sleep var10001 = Sleep.INSTANCE;
      float var10000 = (float)(Sleep.c43802.c16525 + 170) + this.c9605();
      var10001 = Sleep.INSTANCE;
      if (RenderUtilE.c3863(var10000, (float)(Sleep.c43802.c9435 + (int)(this.c49717() + (float)this.c51261()) + 58), 60.0F, 2.0F, var1, var2) && !this.c82836 && var3 == 0) {
         this.c50193 = true;
      }

      Sleep var5 = Sleep.INSTANCE;
      float var6 = (float)(Sleep.c43802.c16525 + 235) + this.c9605();
      var10001 = Sleep.INSTANCE;
      if (RenderUtilE.c3863(var6, (float) Sleep.c43802.c9435 + this.c49717() + (float)this.c51261() + 55.0F, (float)(IFontManager.NL_FONT.c83066.c73459.c80174(this.c82836 ? this.c48371 + "_" : ((NumberValue)this.c93183).c53968().floatValue() + "") + 4), 9.0F, var1, var2)) {
         this.c48371 = String.valueOf(((NumberValue)this.c93183).c53968().floatValue());
         this.c82836 = true;
      }

      if (var3 == 0) {
         this.c82836 = false;
      }

   }

   public void c66160(int var1, int var2, int var3) {
      this.c50193 = false;
   }

   public void c91879(char var1, int var2) {
      Module[] var3 = Value.c27574();
      if (this.c82836) {
         if (var2 == 1) {
            this.c82836 = false;
         }

         if (this.c17880(var2) && (var2 != 52 || !this.c48371.contains("."))) {
            this.c48371 = this.c48371 + var1;
         }

         if (Keyboard.isKeyDown(14) && this.c48371.length() >= 1) {
            this.c48371 = this.c48371.substring(0, this.c48371.length() - 1);
         }

         if (var2 == 28) {
            ((NumberValue)this.c93183).c70375(Float.valueOf(Float.parseFloat(this.c48371) > ((NumberValue)this.c93183).c36673().floatValue() ? ((NumberValue)this.c93183).c36673().floatValue() : Math.max(Float.parseFloat(this.c48371), ((NumberValue)this.c93183).c61905().floatValue())));
            this.c82836 = false;
         }
      }

      super.c91879(var1, var2);
   }

   public boolean c17880(int var1) {
      Module[] var2 = Value.c27574();
      return var1 == 11 || var1 == 2 || var1 == 3 || var1 == 4 || var1 == 5 || var1 == 7 || var1 == 6 || var1 == 8 || var1 == 9 || var1 == 10 || var1 == 52 || var1 == 12;
   }

   private static JSONException c99200(JSONException var0) {
      return var0;
   }
}
