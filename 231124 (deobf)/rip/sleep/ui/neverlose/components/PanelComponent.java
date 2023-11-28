package rip.sleep.ui.neverlose.components;

import Sleep.native0;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import rip.sleep.Sleep;
import rip.sleep.interfaces.IFontRenderer;
import rip.sleep.interfaces.IFontManager;
import rip.sleep.management.ModuleManager;
import rip.sleep.module.Module;
import rip.sleep.module.ModuleType;
import rip.sleep.module.modules.HUD;
import rip.sleep.ui.renderer.ComponentRenderer;
import rip.sleep.struct.AnimationState;
import rip.sleep.util.AnimationUtilA;
import rip.sleep.util.AnimationUtilB;
import rip.sleep.util.AnimationUtilC;
import rip.sleep.util.MathUtilB;
import rip.sleep.util.RenderUtilE;
import rip.sleep.util.ShaderUtilA;
import rip.sleep.value.Value;

@native0
public class PanelComponent {
   public int c48565;
   public int c57187;
   public int c46448;
   public int c72358;
   public int c8045;
   public ModuleType.c21190 c94267;
   public List<ComponentRenderer> c35514;
   public AnimationUtilA c57896;
   private float c57527;
   private float c26357;
   private float c16016;
   private float c40131;
   private AnimationUtilA c23329;

   public PanelComponent(ModuleType.c21190 var1, int var2) {
      Value.c27574();
      this.c35514 = new ArrayList();
      this.c57896 = new AnimationUtilB(150, 1.0D, AnimationState.Backward);
      this.c57527 = Float.MAX_VALUE;
      this.c26357 = 0.0F;
      this.c23329 = new AnimationUtilC(0, 0.0D, AnimationState.Backward);
      this.c94267 = var1;
      this.c8045 = var2;
      int var4 = 0;
      Iterator var5 = ModuleManager.c84590().iterator();
      if (var5.hasNext()) {
         Module var6 = (Module)var5.next();
         if (var6.c42672().equals(var1)) {
            this.c35514.add(new ComponentRenderer(this, var6, var4 % 2 == 0));
            ++var4;
         }
      }

   }

   public void c295(int var1, int var2) {
      Module[] var3 = Value.c27574();
      this.c57896.c96546(this.c85844() ? AnimationState.Forward : AnimationState.Backward);
      if (this.c85844()) {
         float var10000 = (float)(this.c48565 + 7);
         float var10001 = (float)(this.c57187 + this.c8045 + 8);
         Sleep var10005 = Sleep.INSTANCE;
         ShaderUtilA.c76901(var10000, var10001, 76.0F, 15.0F, 2.0F, Sleep.c43802.c45529() ? new Color(200, 200, 200, (int)(100.0D + 70.0D * this.c57896.c53286())) : new Color(8, 48, 70, (int)(100.0D + 70.0D * this.c57896.c53286())));
      }

      if (this.c94267.c25928().equalsIgnoreCase("g") || this.c94267.c25928().equalsIgnoreCase("f")) {
         IFontManager.NL_ICON.c42073.c88416.c48462(this.c94267.c25928(), this.c48565 + 10, this.c57187 + this.c8045 + 14, (new Color(HUD.c64734.c41161().intValue())).getRGB());
         IFontRenderer var10 = IFontManager.NL_FONT.c3571.c47895;
         String var12 = this.c94267.toString();
         float var10002 = (float)(this.c48565 + 10 + IFontManager.NL_ICON.c42073.c88416.c80174(this.c94267.c25928()) + 8);
         float var10003 = (float)(this.c57187 + this.c8045) + 14.5F;
         Sleep var10004 = Sleep.INSTANCE;
         var10.c18223(var12, var10002, var10003, Sleep.c43802.c45529() ? (new Color(18, 18, 19)).getRGB() : -1);
      }

      IFontManager.NL_ICON.c33205.c53784.c48462(this.c94267.c25928(), this.c48565 + 10, this.c57187 + this.c8045 + 14, (new Color(HUD.c64734.c41161().intValue())).getRGB());
      IFontRenderer var11 = IFontManager.NL_FONT.c3571.c47895;
      String var13 = this.c94267.toString();
      float var14 = (float)(this.c48565 + 10 + IFontManager.NL_ICON.c33205.c53784.c80174(this.c94267.c25928()) + 8);
      float var15 = (float)(this.c57187 + this.c8045) + 13.5F;
      Sleep var16 = Sleep.INSTANCE;
      var11.c18223(var13, var14, var15, Sleep.c43802.c45529() ? (new Color(18, 18, 19)).getRGB() : -1);
      if (this.c85844()) {
         double var4 = (double)this.c48720();
         Iterator var6 = this.c35514.iterator();
         if (var6.hasNext()) {
            ComponentRenderer var7 = (ComponentRenderer)var6.next();
            var7.c9138 = (int) MathUtilB.c11525(var4);
         }

         this.c46581(40);
         this.c57527 = (float)Math.max(0, ((ComponentRenderer)this.c35514.get(this.c35514.size() - 1)).c82746 + 110 + ((ComponentRenderer)this.c35514.get(this.c35514.size() - 1)).c37437 + ((ComponentRenderer)this.c35514.get(this.c35514.size() - 1)).c18047());
         var6 = this.c35514.iterator();
         if (var6.hasNext()) {
            ComponentRenderer var9 = (ComponentRenderer)var6.next();
            var9.c78871 = this.c48565;
            var9.c82746 = this.c57187;
            var9.c18377 = this.c46448;
            var9.c19740 = this.c72358;
            GL11.glEnable(3089);
            RenderUtilE.c31072((double)(this.c48565 + 90), (double)(this.c57187 + 40), (double)(this.c46448 - 90), (double)(this.c72358 - 40));
            var9.c80771(var1, var2);
            GL11.glDisable(3089);
         }
      }

   }

   public void c46581(int var1) {
      this.c40131 = (float)((double)this.c16016 - this.c23329.c53286());
      this.c16016 += (float)Mouse.getDWheel() / 4.0F;
      this.c16016 = Math.max(Math.min(this.c26357, this.c16016), -this.c57527);
      this.c23329 = new AnimationUtilC(var1, (double)(this.c16016 - this.c40131), AnimationState.Backward);
   }

   public float c48720() {
      this.c40131 = (float)((double)this.c16016 - this.c23329.c53286());
      return this.c40131;
   }

   public void c45513(char var1, int var2) {
      this.c35514.forEach((var2x) -> {
         var2x.c11226(var1, var2);
      });
   }

   public void c39160(int var1, int var2, int var3) {
      this.c35514.forEach((var3x) -> {
         var3x.c3958(var1, var2, var3);
      });
   }

   public void c5933(int var1, int var2, int var3) {
      Module[] var4 = Value.c27574();
      if (this.c85844()) {
         this.c35514.forEach((var3x) -> {
            var3x.c24639(var1, var2, var3);
         });
      }

   }

   public boolean c85844() {
      Sleep var10000 = Sleep.INSTANCE;
      return Sleep.c43802.c48514 == this.c94267;
   }

   private static JSONException c11741(JSONException var0) {
      return var0;
   }
}
